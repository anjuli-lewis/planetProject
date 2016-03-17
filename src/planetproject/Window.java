/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author anjul_000
 */
public class Window extends JFrame {
    
    public Window () {
        this.frameInit();
        this.createRootPane();
        Dimension d=new Dimension(10,10);
        Container c=new Container();
        c.setPreferredSize(d);
        this.setContentPane(c);
        
    }
    /*public Window (int len, int wid) {
          this.frameInit();
    }*/
    public static void main(String[] args) {
        Window w=new Window();
    }
}
