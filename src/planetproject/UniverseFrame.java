/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author anjul_000
 */
public class UniverseFrame extends JFrame {

    private Timer timer;
    public static final int FRAME_WIDTH = 768;
    public static final int FRAME_HEIGHT = 768;
    private int time;

    public UniverseFrame(int time) {
        this.time = time;
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();
        Universe panel = new Universe(time);
        pane.add(panel);
        this.timer = new Timer(time, panel);
        timer.start();
        this.setVisible(true);
    }

}
