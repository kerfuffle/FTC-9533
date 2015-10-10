package net.kerfuffle.OpModeBuilder;

import org.newdawn.slick.opengl.Texture;

public class Motor {

	public static int FORWARD = 1, REVERSE = -1;
	
	private String name;
	private int direction = FORWARD;
	private float power;
	
	private int id;
	private float x, y, w, h;
	private Texture tex;
	
	public Motor(String name)
	{
		this.name = name;
	}
	
	
	public void draw()
	{
		
	}
	public void setTexture(Texture tex)
	{
		this.tex = tex;
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
