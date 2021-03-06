import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class CoordinatesPanel extends JPanel
{
	private final int SIZE = 6;		//diameter of the dot
	private int x = 50, y = 50;		//coordinates of mouse press
	
	//constructor, sets up this panel to listen for mouse events.
	public CoordinatesPanel()
	{
		addMouseListener (new CoordinatesListener());
		
		setBackground (Color.black);
		setPreferredSize (new Dimension(300, 200));
	}
	
	//draws all of the dots stored in the list.
	public void paintComponent (Graphics page)
	{
		super.paintComponent(page);
		
		page.setColor(Color.green);
		
		page.fillOval(x, y, SIZE, SIZE);
		
		page.drawString("Coordinates: (" + x + ". " + y + ")", 5, 15);
	}
	
	//represents the listener for mouse events.
	private class CoordinatesListener implements MouseListener
	{
		//adds the current point to the list of points and redraws the panel whenever the mouse button is presed.
		public void mousePressed (MouseEvent event)
		{
			x = event.getX();
			y = event.getY();
			repaint();
		}
		
		public void mouseDragged (MouseEvent event)
		{
			x = event.getX();
			y = event.getY();
			repaint();
		}
		
		//provide empty definitions for unused event methods
		public void mouseClicked (MouseEvent e) {}
		public void mouseReleased (MouseEvent e) {}
		public void mouseEntered (MouseEvent e) {}
		public void mouseExited (MouseEvent e) {}
	}
}
