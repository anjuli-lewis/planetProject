/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetproject;

/**
 *
 * @author anjul_000
 */
public class Compound extends Bondable {
    private Bondable [] elements;
    private double energy;
    
    public Compound(Bondable [] elements, double energy) {
        this.elements=elements;
        this.energy=energy;
        Bondable max=elements[0];
        radius=0;
        for(int i=0;i<elements.length;i++) {
            if(max.compareTo(elements[i])<1) {
                max=elements[i];
            }
            radius+=elements[i].getRadius();
        }
        position=max.getPosition();
        velocity=max.getVelocity();
        
    }
    public Compound bond(Bondable e) {
        return null;
    }
    @Override
    public String toString() {
        String ret="(";
        for(Bondable e: elements) {
            ret+=e.toString()+", ";
        }
        return ret+")r:"+radius;
    }
}
