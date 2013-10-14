// Assignment #: 7
//         Name: Chris LaVoy
//    StudentID: 1201806935
//      Lecture: MWF 10:30 - 11:20
//  Description: it needs to be filled.

import java.awt.*;

import javax.swing.*;

import java.awt.event.*; // to use listener interfaces
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private ArrayList circleList;
   private Color currentColor = Color.black;
   private Canvas canvas;
   private JPanel topPanel;
   private JButton undo;
   private JButton erase;
   private JComboBox colorBox;
   
   private int x1 = 0, y1 = 0;
   private int x2 = 0, y2 = 0;
   private int x3 = 0, y3 = 0;
   private int diameter = 0;
   private Color color;

   public WholePanel()
    {
      // here we use black to draw a circle
      currentColor = Color.black;

      circleList = new ArrayList();
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

      //to be completed
      erase.addActionListener(new ButtonListener());
      undo.addActionListener(new ButtonListener());
      colorBox.addActionListener(new ColorListener());

     }

    private class Canvas extends JPanel
     {
      //This method needs to be defined to draw in this panel
      public void paintComponent(Graphics page)
       {
         super.paintComponent(page);

         setBackground(Color.white);

        //to be filled
         addMouseListener (new PointListener());
         addMouseMotionListener (new PointListener());
         
//    	 Circle circle = new Circle(globalX, globalY, diameter, currentColor);
//    	 circle.draw(page);
//    	 circleList.add(circle);
//		 repaint();
         
         page.drawOval(x1, y1, 4, 4);
    	 page.drawOval(x1 - (diameter/2), y1 - (diameter/2), diameter, diameter);
         
         for(int i = 0; i < circleList.size(); i++)
         {
        	 page.setColor(currentColor);
        	 page.fillOval(x1 - (diameter/2), y1 - (diameter/2), diameter, diameter);
         }
         
         
       }
     } //end of Canvas class

    private class PointListener implements MouseListener, MouseMotionListener
     {
                 public void mousePressed(MouseEvent event)
                  {
                         //needs to be filled)
                	 x1 = event.getX();
                	 y1 = event.getY();
                	 repaint();
                  }
                 public void mouseReleased(MouseEvent event)
                  {
                         //needs to be filled
                	 x3 = event.getX();
                	 y3 = event.getY();
                	 
                	 int radius = (int)Math.sqrt(Math.pow((double)(x3-x1), 2) + Math.pow((double)(y3-y1), 2));
                	 diameter = 2 * radius;
                	 
                	 Circle circle = new Circle(x1, y1, diameter, currentColor);
                	 circleList.add(circle);
                	 
                	 repaint();
                  }
                 public void mouseClicked(MouseEvent event) {}
                 public void mouseEntered(MouseEvent event) {}
                 public void mouseExited(MouseEvent event) {}
                 public void mouseDragged(MouseEvent event)
                   {
                        //needs to be filled
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
				circleList.clear();
				repaint();
			}
			
			if (event.getSource() == undo)
			{
				circleList.remove(circleList.size()-1);
				repaint();
			}
		}
    }//end of ButtonListener
    
    private class ColorListener implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
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
    	
    }
    
    private class Circle
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
    		page.setColor(currentColor);
    		page.fillOval(x, y, diameter, diameter);
    	}
    }//end of Circle

} // end of Whole Panel Class