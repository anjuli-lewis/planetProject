/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author anjul_000
 */
public abstract class Bondable implements Comparable<Bondable> {
    protected double radius;
    protected Vector position;
    protected Vector velocity;
   
    public abstract Compound bond(Bondable e);
    public Vector getPosition() {
        return position;
    }
    public double getRadius() {
        return radius;
    }
    public Vector getVelocity() {
        return velocity;
    }
    
    @Override
    public int compareTo(Bondable other) {
        return (int)(this.radius-other.getRadius());
    }
    
    public boolean intersects(Bondable e) {
        double x2=e.getPosition().cartesian(0);
        double y2=e.getPosition().cartesian(1);
        double r2=e.getRadius();
        double distance=Math.pow((position.cartesian(0)-x2), 2)+Math.pow((position.cartesian(1)-y2),2);
        double difference=Math.pow((radius-r2), 2);
        double sum=Math.pow((radius+r2), 2);
        return (difference<=distance&&sum>=distance);
    }
    public void draw (Graphics2D g2d, AffineTransform transform) {
        Ellipse2D.Double e=new Ellipse2D.Double(position.cartesian(0),position.cartesian(1), (radius*2)/50, (radius*2)/50);
        Shape s=transform.createTransformedShape(e);
        g2d.fill(s);
    }
    public void move(double dt) {
        dt=dt/1000;
        Vector v=velocity.times(dt);
        position = position.plus(v);
    } // move( Vector, double )
    
        /**
     * @param position the position to set
     */
    public void setPosition(Vector position) {
        this.position = position;
    }



    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }
    
}
