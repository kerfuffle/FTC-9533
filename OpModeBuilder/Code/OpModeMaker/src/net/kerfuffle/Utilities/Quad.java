package net.kerfuffle.Utilities;

import org.newdawn.slick.opengl.Texture;

public class Quad {

	private float x, y, w, h;
	private RGB color;
	
	private Texture tex;
	
	public Quad(float x, float y, float w, float h, RGB color)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.color = color;
	}
	
	public void setPos(float x, float y, float w, float h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public void setColor(RGB color)
	{
		this.color = color;
	}
	public void setTexture(Texture tex)
	{
		this.tex = tex;
	}
	
	public float X()
	{
		return x;
	}
	public float Y()
	{
		return y;
	}
	public float W()
	{
		return w;
	}
	public float H()
	{
		return h;
	}
}
