package planetproject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * ****************************************************************************
 * Compilation: javac Universe.java Execution: java Universe dt input.txt
 * Dependencies: Body.java Vector.java StdIn.java StdDraw.java Datafiles:
 * http://www.cs.princeton.edu/introcs/34nbody/2body.txt
 * http://www.cs.princeton.edu/introcs/34nbody/3body.txt
 * http://www.cs.princeton.edu/introcs/34nbody/4body.txt
 * http://www.cs.princeton.edu/introcs/34nbody/2bodyTiny.txt
 *
 * This data-driven program simulates motion in the universe defined by the
 * standard input stream, increasing time at the rate on the command line.
 *
 * % java Universe 25000 4body.txt
 *
 *
 *****************************************************************************
 */
public class Universe extends JPanel implements ActionListener {

    //private final int diameter;     // diameter of universe
    private int N;             // number of bodies
    private Bondable[] orbs;       // array of N bodies
    private double time;

    public Universe(double time) {
        orbs = new Bondable[10];
        N = orbs.length;
        //radius=orbs.length*2;
        this.time = time;
        double a1 = 0;
        double a2 = 0;
        for (int i = 0; i < orbs.length; i++) {
            a1 = (-1 + (2 * Math.random()));
            a2 =(-1 + (2 * Math.random()));
            double[] arrA = {a1, a2};
            orbs[i] = new Hydrogen(new Vector(arrA));
        }
    }

    /**
     * Increases the time of the simulation, moving the bodies in the universe
     * accordingly
     *
     * @param dt how fast time is moving
     */
    public void increaseTime(double dt) {

    } // increaseTime( double )*/

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int w = this.getWidth();
        int h = this.getHeight();
        AffineTransform scale = new AffineTransform();
        AffineTransform translate = new AffineTransform();
        AffineTransform transform = new AffineTransform();
        translate.setToTranslation(1, 1);
        scale.setToScale(w / 2, h / 2);
        transform.concatenate(scale);
        transform.concatenate(translate);
        for (int i = 0; i < N; i++) {
            orbs[i].draw(g2d, transform);
        } // for
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Bondable> orbs2= new ArrayList<>(N);
        for(Bondable b:orbs) {
            orbs2.add(b);
        }
        //orbs2.sort();
        for(int i=0;i<orbs2.size();i++) {
            Bondable b=orbs2.get(i);
            if(!(b instanceof Compound)) {
               for(int z=(i+1);z<orbs2.size();z++) {
                   Bondable b2=orbs2.get(z);
                   if(b.intersects(b2)) {
                       Compound c=b.bond(b2);
                       orbs2.remove(i);
                       orbs2.remove(b2);
                       orbs2.add(0,c);
                   }
               }
            }
        }
        Bondable [] arr=new Bondable[orbs2.size()];
        for(int i=0;i<orbs2.size();i++) {
            arr[i]=orbs2.get(i);
        }
        orbs=arr;
        N=orbs.length;
        // move the bodies
        for (int f = 0; f < N; f++) {
            orbs[f].move(time);
            double diameter=(orbs[f].getRadius()*2)/50;
            Vector v = orbs[f].getPosition();
            Vector v2 = orbs[f].getVelocity();
            double x = v.cartesian(0);
            double y = v.cartesian(1);
            double x2 = v2.cartesian(0);
            double y2 = v2.cartesian(1);
            if (x < -1 || x > 1-diameter) {
                if (x < -1) {
                    x = -1;
                } 
                else if (x>1-diameter){
                    x = 1-diameter;
                }
                x2 = x2 * -1;
            }
            if (y < -1 || y > 1-diameter) {
                if (y < -1) {
                    y = -1;
                } 
                else if (y>1-diameter){
                    y = 1-diameter;
                }
                y2 = y2 * -1;
            }


            double[] r = {x, y};
            double[] r2 = {x2, y2};
            Vector n = new Vector(r);
            Vector n2 = new Vector(r2);
            orbs[f].setPosition(n);
            orbs[f].setVelocity(n2);
            this.repaint();
        }
    } // Universe
}
