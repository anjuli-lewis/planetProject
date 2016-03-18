package planetproject;

/******************************************************************************
 *  Compilation:  javac Vector.java
 *  Execution:    java Vector
 *
 *  Implementation of a vector of real numbers.
 *
 *  This class is implemented to be immutable: once the client program
 *  initialize a Vector, it cannot change any of its fields
 *  (N or data[i]) either directly or indirectly. Immutability is a
 *  very desirable feature of a data type.
 *
 *
 *  Note that java.util.Vector is an unrelated Java library class.
 *
 ******************************************************************************/

public class Vector { 

    private final int N;         // length of the vector
    private final double[] data;       // array of vector's components

    /**
     * Creates a Vector at the origin in the specified dimension
     * @param N dimension
     */
    public Vector(int N) {
        this.N = N;
        this.data = new double[N];
    } // Vector( int )

    /**
     * Creates a Vector from an array
     * @param data an array of doubles
     */
    public Vector(double[] data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++) {
            this.data[i] = data[i];
        } // for
    } // Vector( double [] )

    // create a vector from either an array or a vararg list
    // this constructor uses Java's vararg syntax to support
    // a constructor that takes a variable number of arguments, such as
    // Vector x = new Vector(1.0, 2.0, 3.0, 4.0);
    // Vector y = new Vector(5.0, 2.0, 4.0, 1.0);
/*
    public Vector(double... data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++)
            this.data[i] = data[i];
    }
*/
    /**
     * Gets the dimension of the Vector
     * @return the dimension of the Vector
     */
    public int length() {
        return N;
    } // length()

    /**
     * Gets the dot product of two Vectors
     * @param that the other Vector
     * @return the dot product of the two Vectors
     */
    public double dot(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    } // dot( Vector )

    // return the Euclidean norm of this Vector
    /**
     * Returns the Euclidean norm (magnitude) of the vector
     * @return the Eucludean norm of the vector
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    /**
     * Finds the distance between two vectors
     * @param that the other vector
     * @return the distance
     */
    public double distanceTo(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        return this.minus(that).magnitude();
    } // distanceTo( Vector )

    /**
     * Adds two vectors
     * @param that the other vector
     * @return the sum of the two vectors
     */
    public Vector plus(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    } // plus( Vector )

    /**
     * Finds the difference between the two vectors
     * @param that the other vector
     * @return the difference between the vectors
     */
    public Vector minus(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    } // minus( Vector )

    // 
    /**
     * return the corresponding coordinate at i
     * @param i the index
     * @return the coordinate at i
     */
    public double cartesian(int i) {
        return data[i];
    } // cartesian( int )

    // create and return a new object whose value is (this * factor)
    /**
     * create and return a new object whose value is (this * factor)
     * @param factor the factor to increase the Vector by
     * @return a new Vector that is equal to (this*factor)
     */
    public Vector times(double factor) {
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = factor * data[i];
        return c;
    } // times( double )


    /**
     * return the corresponding unit vector
     * @return the corresponding unit vector
     */
    public Vector direction() {
        if (this.magnitude() == 0.0) {
            throw new RuntimeException("Zero-vector has no direction");
        } // if
        
        return this.times(1.0 / this.magnitude());
    } // direction()

    /**
     * return a string representation of the vector
     * @return the String representation of the Vector
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i < N; i++) {
            s.append(data[i]);
            if (i < N-1) s.append(", ");
        } // for
        s.append(")");
        return s.toString();
    } // toString()


    // test client
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.times(10.0));
        System.out.println("|x|      =  " + x.magnitude());
        System.out.println("<x, y>   =  " + x.dot(y));
        System.out.println("|x - y|  =  " + x.minus(y).magnitude());
    } // main( String [] )
} // Vector
