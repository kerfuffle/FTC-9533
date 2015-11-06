package net.kerfuffle.OpModeBuilder;

import static net.kerfuffle.Utilities.Util.*;
import static org.lwjgl.opengl.GL11.*;

import net.kerfuffle.Utilities.DropMenu;

import org.lwjgl.opengl.Display;

public class Main {

	static final int WIDTH = 1000, HEIGHT = 700;
	
	public static void main(String args[])
	{
		setDisplay(WIDTH, HEIGHT, "OpMode Builder");
		
		initGL();
		
		if (!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			
			DropMenu menu = new DropMenu(new String[]{"bob", "billy", "billybob"}, 100, 100, 100, 50, "MyMenu");
			
			menu.draw();
			
			updateAndSync(60);
		}
	}
	
}
