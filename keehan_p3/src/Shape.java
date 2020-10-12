import java.lang.Math;

//Abstract Shape class
public abstract class Shape {
    //Abstract methods getName and getArea
    public abstract String getName();
    public abstract double getArea();
}

//Abstract Shape2D class
abstract class Shape2D extends Shape {}

//Abstract Shape 3D class
abstract class Shape3D extends Shape {
    //Abstract getVolume method
    public abstract double getVolume();
}

//Classes for specific shapes
//SQUARE
class Square extends Shape2D {

    double input1;
    public Square(double entry1) { input1 = entry1; }
    //Method overrides
    @Override
    public String getName() { return "square"; }
    @Override
    public double getArea() { return input1 * input1; }
}
//TRIANGLE
class Triangle extends Shape2D {

    double input1;
    double input2;
    public Triangle(double entry1, double entry2) {
        input1 = entry1;
        input2 = entry2;
    }
    //Method overrides
    @Override
    public String getName() { return "triangle"; }
    @Override
    public double getArea() { return input1 * input2 / 2; }
}
//CIRCLE
class Circle extends Shape2D {

    double input1;
    public Circle(double entry1) {
        input1 = entry1;
    }
    //Method overrides
    @Override
    public String getName() { return "circle"; }
    @Override
    public double getArea() { return input1 * input1 * 3.1415926; }
}
//CUBE
class Cube extends Shape3D {

    double input1;
    public Cube(double entry1) {
        input1 = entry1;
    }
    //Method overrides
    @Override
    public String getName() { return "cube"; }
    @Override
    public double getArea() { return input1 * input1 * 6; }
    @Override
    public double getVolume() { return input1 * input1 * input1; }
}
//PYRAMID
class Pyramid extends Shape3D {

    double input1;
    double input2;
    double input3;
    public Pyramid(double entry1, double entry2, double entry3) {
        input1 = entry1;
        input2 = entry2;
        input3 = entry3;
    }
    //Method overrides
    @Override
    public String getName() { return "pyramid"; }
    @Override
    public double getArea() { return (input1 * input2) + input1*Math.sqrt( (input2/2)*(input2/2) + input3*input3 ) + input2*Math.sqrt( (input1/2)*(input1/2) + input3*input3 ); }
    @Override
    public double getVolume() { return input1 * input1 * input1 / 3; }
}
//SPHERE
class Sphere extends Shape3D {

    double input1;
    public Sphere(double entry1) {
        input1 = entry1;
    }
    //Method overrides
    @Override
    public String getName() { return "sphere"; }
    @Override
    public double getArea() { return input1 * input1 * 4 * 3.1415926; }
    @Override
    public double getVolume() { return input1 * input1 * input1 * 4/3 * 3.1415926; }
}