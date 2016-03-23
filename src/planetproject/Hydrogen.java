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
public class Hydrogen extends Bondable {
    private int electrons=1;
    
    public Hydrogen(Vector p) {
        position=p;
        radius=1;
        double a1 = (-1 + (2 * Math.random()) ) / 10;
        double a2=(-1 + (2 * Math.random()) ) / 10;
        double [] arr={a1,a2};
        velocity=new Vector(arr);
        electrons=1;
    }
    
    @Override
    public Compound bond(Bondable e) {
        if(e instanceof Hydrogen) {
            Bondable [] elements={e, this};
            double energy=432;
            return new Compound(elements, energy);
        }
       /* else if (e instanceof Oxygen) {
            Bondable [] elements={e, this};
            double energy=467;
            return new Compound(elements, energy);
        }*/
        else {
            return null;
        }
    }

    /**
     * @return the electrons
     */
    public int getElectrons() {
        return electrons;
    }
    
    @Override
    public int compareTo(Bondable other) {
        return (int)(radius-other.getRadius());
    }
    
   
    @Override
    public String toString() {
        return "H: "+position+":"+((radius*2)%10)+1;
    }
}
