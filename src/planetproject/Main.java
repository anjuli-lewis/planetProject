/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

import javax.swing.JFrame;

/**
 *
 * @author anjul_000
 */
public class Main {
    public static void main(String[] args) {
        //creates a new frame
        JFrame frame=new JFrame();
        //makes it so the program stops when the window closes (this is the default)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this sets all the componets to at or above their preffered size, depending on the size of the window. You could use a setSize() method, but then it wouldn't be dynamic
        frame.pack();
        //makes the frame appear
        frame.setVisible(true);
        
    }
}
