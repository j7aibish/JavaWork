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
   private Color currentColor;
   private Canvas canvas;
   private JPanel topPanel;
   private JButton undo;

   public WholePanel()
    {
      // here we use black to draw a circle
      currentColor = Color.black;

      circleList = new ArrayList();
      topPanel = new JPanel();

      undo = new JButton("Undo");
      topPanel.add(undo);

      canvas = new Canvas();

      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);

      //to be completed

     }


    private class Canvas extends JPanel
     {
      //This method needs to be defined to draw in this panel
      public void paintComponent(Graphics page)
       {
         super.paintComponent(page);

         setBackground(Color.white);

        //to be filled
       }
     } //end of Canvas class

    private class PointListener implements MouseListener, MouseMotionListener
     {
                 public void mousePressed(MouseEvent event)
                  {
                         //needs to be filled
                  }
                 public void mouseReleased(MouseEvent event)
                  {
                         //needs to be filled
                  }
                 public void mouseClicked(MouseEvent event) {}
                 public void mouseEntered(MouseEvent event) {}
                 public void mouseExited(MouseEvent event) {}
                 public void mouseDragged(MouseEvent event)
                   {
                        //needs to be filled
                   }
                 public void mouseMoved(MouseEvent event) {}

     } //end of PointListener

} // end of Whole Panel Class