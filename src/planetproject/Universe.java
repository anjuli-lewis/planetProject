package planetproject;

import edu.princeton.cs.In;
import edu.princeton.cs.StdDraw;
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
public class Universe extends JPanel {

    private final double radius;     // radius of universe
    private final int N;             // number of bodies
    private final Body[] orbs;       // array of N bodies

    
/**
 * Reads a file to get the size of the universe, how many bodies are in the universe and the details of those bodies
 * @param fileName the file with the data for the universe
 */
    public Universe(String fileName) {

        // the authors' version reads from standard input
        // our version reads from a file
        In inputStream = new In(fileName);

        // number of bodies
        N = inputStream.readInt();

        // the set scale for drawing on screen
        radius = inputStream.readDouble();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        // read in the N bodies
        orbs = new Body[N];
        for (int i = 0; i < N; i++) {
            double rx = inputStream.readDouble();
            double ry = inputStream.readDouble();
            double vx = inputStream.readDouble();
            double vy = inputStream.readDouble();
            double mass = inputStream.readDouble();
            double[] position = {rx, ry};
            double[] velocity = {vx, vy};
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            orbs[i] = new Body(r, v, mass);
        } // for
    } // Universe()

    /**
     * Increases the time of the simulation, moving the bodies in the universe accordingly
     * @param dt how fast time is moving
     */
    public void increaseTime(double dt) {

        // initialize the forces to zero
        Vector[] f = new Vector[N];
        for (int i = 0; i < N; i++) {
            f[i] = new Vector(new double[2]);
        } // for

        // compute the forces
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    f[i] = f[i].plus(orbs[i].forceFrom(orbs[j]));
                } // if
            } // for
        } // for

        // move the bodies
        for (int i = 0; i < N; i++) {
            orbs[i].move(f[i], dt);
        } // for
    } // increaseTime( double )

    /**
     * Goes through all the bodies and calls their draw function
     */
    public void draw() {
        for (int i = 0; i < N; i++) {
            orbs[i].draw();
        } // for
    } // draw()

    // client to simulate a universe
    public static void main(String[] args) {
        Universe newton = new Universe( args[1] );
        double dt = Double.parseDouble(args[0]);
        while (true) {
            StdDraw.clear();
            newton.increaseTime(dt);
            newton.draw();
            StdDraw.show(10);
        } // while
    } // main( String [] )
} // Universe
