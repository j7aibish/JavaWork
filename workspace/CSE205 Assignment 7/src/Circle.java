// Assignment #: 7
//         Name: Chris LaVoy
//    StudentID: 1201806935
//      Lecture: MWF 10:30 - 11:20
//  Description: Creates the circle class to be used in the WholePanel class

import java.awt.Color;
import java.awt.Graphics;

 public class Circle
    {
    	private int x;
    	private int y;
    	private int diameter;
    	private Color color;
    	
    	public Circle(int x, int y, int diameter, Color color)
    	{
    		this.x = x;
    		this.y = y;
    		this.diameter = diameter;
    		this.color = color;
    	}
    	
    	public void draw(Graphics page)
    	{
    		page.setColor(color);
    		page.fillOval(x - (diameter/2), y - (diameter/2), diameter, diameter);
    	}
    }//end of Circle