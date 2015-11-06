package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 12664 on 10/18/2015.
 */
public class DriveOp extends OpMode {

    DcMotor motorLeft, motorRight, motorLift;
    Servo leftDoor, rightDoor;


    public void init()
    {
        motorLeft = hardwareMap.dcMotor.get("leftMotor");
        motorRight = hardwareMap.dcMotor.get("rightMotor");
        motorLift = hardwareMap.dcMotor.get("liftMotor");

        leftDoor = hardwareMap.servo.get("leftDoorServo");
        rightDoor = hardwareMap.servo.get("rightdoorServo");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        rightDoor.setDirection(Servo.Direction.REVERSE);
    }

    double liftPower = 0.2;
    boolean doorOpen = false;

    public void loop()
    {
       /* float throttle = -gamepad1.left_stick_y;
        float direction = gamepad1.left_stick_x;

        float right = throttle - direction;
        float left = throttle + direction;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        right = (float) scaleInput(right);
        left = (float) scaleInput(left);

        motorLeft.setPower(left);
        motorRight.setPower(right);
*/

        controlWheels(gamepad1.left_stick_y, gamepad1.right_stick_y, motorLeft, motorRight);
        checkLift(gamepad1.right_bumper, gamepad1.left_bumper, motorLift, 0.85f);
        checkDoors(gamepad2.a, leftDoor, rightDoor, 135/360, 135/360);
    }


    public void stop()
    {

    }


    private void checkLift(boolean upBut, boolean downBut, DcMotor liftMotor, float power)
    {
        if (upBut)
        {
            liftMotor.setPower(power);
        }
        else if (downBut)
        {
            liftMotor.setPower(-power);
        }
        else
        {
            liftMotor.setPower(0);
        }
    }

    private void checkDoors(boolean button, Servo leftDoor, Servo rightDoor, float leftAngle, float rightAngle)
    {
        if (button)
        {
            doorOpen = !doorOpen;
        }

        if (doorOpen)
        {
            leftDoor.setPosition(leftAngle);
            rightDoor.setPosition(rightAngle);
        }
        else
        {
            leftDoor.setPosition(1);
            rightDoor.setPosition(1);
        }

        telemetry.addData("LeftDoorPos", "LeftDoorPos: " + leftDoor.getPosition());
        telemetry.addData("RightDoorPos", "RightDoorPos: " + rightDoor.getPosition());
    }

    private void controlWheels(float leftStickY, float rightStickY, DcMotor leftMotor, DcMotor rightMotor)
    {
        leftMotor.setPower((float) scaleInput(-leftStickY));
        rightMotor.setPower((float) scaleInput(-rightStickY));
    }

    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }
}
