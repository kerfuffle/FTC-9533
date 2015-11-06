package net.kerfuffle.Utilities;

import java.util.ArrayList;
import static net.kerfuffle.Utilities.Util.*;
import static org.lwjgl.opengl.GL11.*;

public class DropMenu {

	class Block
	{
		float x, y, w, h;
		String str;
	}
	
	ArrayList <Block> blocks = new ArrayList<Block>();
	
	RGB color = new RGB(1, 1, 1);
	
	public DropMenu(String newBlocks[], float x, float y, float w, float h, String name)
	{
		for (int i = 0; i < newBlocks.length; i++)
		{
			Block block = new Block();
			block.str = newBlocks[i];
			block.w = w;
			block.h = h;
			block.x = x;
			block.y = y-(h*i);
			blocks.add(block);
		}
	}
	
	public void draw()
	{
		for (int i = 0; i < blocks.size(); i++)
		{
			color(color);
			quad(blocks.get(i).x, blocks.get(i).y, blocks.get(i).w, blocks.get(i).h);
			glColor3f(0, 0, 0);
			lineH(blocks.get(i).x, blocks.get(i).y, blocks.get(i).w);
		}
	}
	
}
