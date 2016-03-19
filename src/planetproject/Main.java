/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author anjul_000
 */
public class Main {
    public static void main(String[] args) {
        //creates a new frame
        JFrame frame=new UniverseFrame();
        //makes it so the program stops when the window closes (this is the default)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates a new panel, that automatically uses the Flow Layout. Could create the layout as well.
        //JPanel panel =new JPanel();
        //adds the panel to the frame
        frame.setContentPane(new Universe());
        //this sets all the componets to at or above their preffered size, depending on the size of the window. More dynamis than setSize()
        frame.pack();
        frame.setLocationRelativeTo(null);
        //makes the frame appear
        frame.setVisible(true);
        
    }
}
