package net.kerfuffle.OpModeBuilder;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Program {

	private String code;
	private String name;
	
	Texture motorTex;
	Texture servoTex;
	Texture touchSensorTex;
	Texture opticalDistanceSensorTex;
	Texture colorSensorTex;
	Texture accelerationSensorTex;
	Texture compassSensorTex;
	Texture gyroSensorTex;
	Texture IRSeekerTex;
	Texture lightSensorTex;
	Texture ultraSonicSensorTex;
	Texture voltageSensorTex;
	
	ArrayList <Motor> motors = new ArrayList<Motor>();
	
	public Program(String name)
	{
		this.name = name;
	}
	
	
	public void initMotors()
	{
		for (int i = 0; i < motors.size(); i++)
		{
			motors.get(i).box.setTexture(motorTex);
		}
	}
	public void drawMotors()
	{
		for (int i = 0; i < motors.size(); i++)
		{
			motors.get(i).draw();
		}
	}
	public void addMotor(Motor m)
	{
		motors.add(m);
	}
	public void removeMotor(int i)
	{
		motors.remove(i);
	}
	
	public String buildMotorDeclare()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < motors.size(); i++)
		{
			builder.append("DcMotor " + motors.get(i).getName() + ";");
		}
		
		return builder.toString();
	}
	
	
	public String buildMotorInit()
	{
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < motors.size(); i++)
		{
			builder.append(motors.get(i).getName() + " = hardwareMap.dcMotor.get(\"" + motors.get(i).getName() + "\");");
			builder.append("\n");
			if (motors.get(i).getDirection() == Motor.REVERSE)
			{
				builder.append(motors.get(i).getName()+ ".setDirection(DcMotor.Direction.REVERSE);");
				builder.append("\n");
			}
		}
		
		return builder.toString();
	}
	
	
	public String buildMotorLoop()
	{
		StringBuilder builder = new StringBuilder();
		
		return builder.toString();
	}
	
	public void buildProgram()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("package com.qualcomm.ftcrobotcontroller.opmodes;");
		builder.append("\n\n");
		builder.append("import com.qualcomm.robotcore.eventloop.opmode.OpMode;");
		builder.append("\n");
		builder.append("import com.qualcomm.robotcore.hardware.*;");
		builder.append("\n");
		builder.append("public class " + name + "extends OpMode");
		builder.append("\n");
		builder.append("{");
		builder.append("\n");
		
		builder.append(buildMotorDeclare());
		
		builder.append("public void init()");
		builder.append("\n");
		builder.append("{");
		builder.append("\n");
		builder.append(buildMotorInit());
		
		builder.append("\n");
		builder.append("}");
		
		builder.append("\n\n");
		
		builder.append("public void loop()");
		builder.append("\n");
		builder.append("{");
		builder.append("\n");
		builder.append("}");
		
		builder.append("public void stop()");
		builder.append("{");
		builder.append("}");
		
		builder.append("}");
		
	}
	public String toString()
	{
		return code;
	}
}
