package planetproject;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/******************************************************************************
 *  Compilation:  javac Body.java
 *  Execution:    java Body
 *  Dependencies: Vector.java StdDraw.java
 *
 *  Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 ******************************************************************************/

public class Body {
    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass


    public Body(Vector r, Vector v, double mass) {
        this.r = r;
        this.v = v;
        this.mass = mass;
    } // Body( Vector, Vector, double )

    public void move(Vector f, double dt) {
        Vector a = f.times(1/mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    } // move( Vector, double )

    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    public Shape draw() {
        Shape ret=new Ellipse2D.Double(r.cartesian(0), r.cartesian(1), 0.025, 0.025);
        return ret;
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public Shape draw(double radius) {
        Shape ret=new Ellipse2D.Double(r.cartesian(0), r.cartesian(1), radius, radius);
        return ret;
    } // draw( double )
    
    public double getMass() {
        return mass;
    }

} // Body
