package com.Lesson1;
// Drawing shapes
import java.awt.Graphics;
import javax.swing.*;

public class SwitchTest extends JApplet {
   int choice;   

   public void init()
   {
      String input;

      input = JOptionPane.showInputDialog( 
                 "Enter 1 to draw lines\n" +
                 "Enter 2 to draw rectangles\n" +
                 "Enter 3 to draw ovals\n" );

      choice = Integer.parseInt( input );
   }

   public void paint( Graphics g )
   {
      for ( int i = 0; i < 10; i++ ) { 
         switch( choice ) {
            case 1:
               g.drawLine( 10, 10, 250, 10 + i * 10 );
               break;
            case 2:
               g.drawRect( 10 + i * 10, 10 + i * 10,
                           50 + i * 10, 50 + i * 10 );
               break;
            case 3:
               g.drawOval( 10 + i * 10, 10 + i * 10,
                           50 + i * 10, 50 + i * 10 );
               break;
            default:
               JOptionPane.showMessageDialog(
                  null, "Invalid value entered" );
         } // end switch
      } // end for
   } // end paint()
} // end class SwitchTest

/**************************************************************************
 * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
