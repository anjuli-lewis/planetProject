/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author anjul_000
 */
public class UniverseFrame extends JFrame {
    private Timer timer;
    
    public UniverseFrame () {
       timer = new Timer(1000, new Universe());
       timer.start();
    }
    
}
