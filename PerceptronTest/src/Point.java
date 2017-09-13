import java.util.*;
import java.awt.*;

import javax.swing.*;

public class Point{
	
	private double x;
	private double y;
	private int type;
	
	public Point(int width, int height) {
		Random rng = new Random();
		x = rng.nextDouble() * width;
		y = rng.nextDouble() * height;
		
		if (x > y) 
			type = 1;
		else
			type = -1;
	}
	
	public boolean TypeVisible(){
		return (type == 1);
	}
	public int getx() {
		return (int)Math.round(x);
	}
	public int gety() {
		return (int)Math.round(y);
	}
	public int getType() {
		return type;
	}
	
}
