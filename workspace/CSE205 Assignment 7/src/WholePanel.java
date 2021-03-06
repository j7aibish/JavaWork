// Assignment #: 7
//         Name: Chris LaVoy
//    StudentID: 1201806935
//      Lecture: MWF 10:30 - 11:20
//  Description: Handles creating the panels that will be used in the drawing program. 
//				 Also handles the drawing and erasing logic.

import java.awt.*;

import javax.swing.*;

import java.awt.event.*; // to use listener interfaces
import java.util.ArrayList;

public class WholePanel extends JPanel
{
	//declare private variables
   private ArrayList circleList;
   private ArrayList copyList;
   private Color currentColor;
   private Canvas canvas;
   private JPanel topPanel;
   private JButton undo;
   private JButton erase;
   private JComboBox colorBox;
   private boolean erased;
   private boolean pressed;
   
   private int x1 = 0, y1 = 0;
   private int x2 = 0, y2 = 0;
   private int x3 = 0, y3 = 0;
   private int diameter = 0;

   public WholePanel()
    {
      // here we use black to draw a circle
      currentColor = Color.black;

      circleList = new ArrayList();
      copyList = new ArrayList();
      
      erased = false;
      
      
      topPanel = new JPanel();
      topPanel.setLayout(new GridLayout(1, 3));

      undo = new JButton("Undo");
      topPanel.add(undo);
      
      erase = new JButton("Erase");
      topPanel.add(erase);
      
      colorBox = new JComboBox();
      colorBox.addItem("black");
      colorBox.addItem("red");
      colorBox.addItem("blue");
      colorBox.addItem("green");
      colorBox.addItem("orange");
      topPanel.add(colorBox);

      canvas = new Canvas();

      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);

      erase.addActionListener(new ButtonListener());
      undo.addActionListener(new ButtonListener());
      colorBox.addActionListener(new ColorListener());
      
      canvas.addMouseListener (new PointListener());
      canvas.addMouseMotionListener (new PointListener());
     }

	private class Canvas extends JPanel
     {
      //This method needs to be defined to draw in this panel
      public void paintComponent(Graphics page)
       {
         super.paintComponent(page);

         setBackground(Color.white);
         
         page.setColor(currentColor);
         
         if(pressed == true)
         {
         	page.drawOval(x1, y1, 2, 2);
         	page.drawOval(x1 - (diameter/2), y1 - (diameter/2), diameter, diameter);
         }
         
         for(int i = 0; i < circleList.size(); i++)
         {
        	 Circle c = (Circle)circleList.get(i);
        	 c.draw(page);
         }
       }
     } //end of Canvas class

    private class PointListener implements MouseListener, MouseMotionListener
     {
                 public void mousePressed(MouseEvent event)
                  {
                	 	// Handles a mousePressed event to create the center point of the cirlce
                	 pressed = true;
                	 diameter = 0;
                	 x1 = event.getX();
                	 y1 = event.getY();
                	 repaint();
                  }
                 public void mouseReleased(MouseEvent event)
                  {
                         // Handles a mouseReleased event to create a new circle and add it to an arrayList
                	 x3 = event.getX();
                	 y3 = event.getY();
                	 
                	 int radius = (int)Math.sqrt(Math.pow((double)(x3-x1), 2) + Math.pow((double)(y3-y1), 2));
                	 diameter = 2 * radius;

                	 Circle circle = new Circle(x1, y1, diameter, currentColor);
                	 circleList.add(circle);
                	 repaint();
                	 pressed = false;
                  }
                 public void mouseClicked(MouseEvent event) {}
                 public void mouseEntered(MouseEvent event) {}
                 public void mouseExited(MouseEvent event) {}
                 public void mouseDragged(MouseEvent event)
                   {
                        // Handles a mouseDragged event to create a circle outline to show where the circle will be drawn
                	 x2 = event.getX();
                	 y2 = event.getY();
                	 
                	 int radius = (int)Math.sqrt(Math.pow((double)(x2-x1), 2) + Math.pow((double)(y2-y1), 2));
                	 diameter = 2 * radius;
                	 
                	 repaint();
                   }
                 public void mouseMoved(MouseEvent event) {}

     } //end of PointListener
    
    private class ButtonListener implements ActionListener
    {
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == erase)
			{
				for(int i = 0; i < circleList.size(); i++)
				{
					// Create a copy of the circleList to recall if needed in an undo action
					copyList.add(i, circleList.get(i));
				}
				circleList.clear();
				repaint();
				erased = true;
			}
			
			if (event.getSource() == undo)
			{
				if(erased == true)
				{
					for(int i = 0; i < copyList.size(); i++)
					{
						// Recreate the circleList from the copyList to redraw it
						circleList.add(i, copyList.get(i));
						repaint();
					}
					erased = false;
				}
				else if(erased == false)
				{
					// If an erase call hasn't been made undo the last drawn circle
					circleList.remove(circleList.size()-1);
					repaint();
				}
			}
		}
    }//end of ButtonListener
    
    private class ColorListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) 
		{
			// Allow the user to change the color
			int choice = colorBox.getSelectedIndex();
			switch(choice)
			{
			case 1: currentColor = Color.red;
					break;
			case 2: currentColor = Color.blue;
					break;
			case 3: currentColor = Color.green;
					break;
			case 4: currentColor = Color.orange;
					break;
			default: currentColor = Color.black;
					break;
			}	
		}
    } //end of ColorListener
} // end of Whole Panel Class