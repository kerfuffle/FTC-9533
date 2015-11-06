package net.kerfuffle.OpModeBuilder;

import net.kerfuffle.Utilities.Quad;
import net.kerfuffle.Utilities.RGB;

import org.newdawn.slick.opengl.Texture;

public class Motor {

	public static int FORWARD = 1, REVERSE = -1;
	
	private String name;
	private int direction = FORWARD;
	private float power;
	
	private boolean leftJoy, rightJoy;
	
	private int id;
	Quad box = new Quad(0, 0, 0, 0, new RGB(0, 0, 0));
	
	public Motor(String name)
	{
		this.name = name;
	}
	
	
	public void draw()
	{
		
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public float getPower()
	{
		return power;
	}
	public void setPower(float power)
	{
		this.power = power;
	}
	
	public int getDirection()
	{
		return direction;
	}
	public void setDirection(int direction)
	{
		this.direction = direction;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
}
