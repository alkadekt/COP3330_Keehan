
//Abstract Shape class
public abstract class Shape {

    //Abstract methods
    public abstract String getName();
    public abstract double getArea();

    //Constructor
    /*
    public Shape (int first, int second, int third) {

    }
     */

}
//Abstract Shape2D class
abstract class Shape2D extends Shape {
    //public abstract String getName();
    //public abstract double getArea();
}

//Abstract Shape 3D class
abstract class Shape3D extends Shape {
    //Abstract getVolume method
    public abstract long getVolume();

}

//Abstract classes
//SQUARE
class Square extends Shape2D {

    double input1;

    public Square(double entry1) {
        input1 = entry1;
    }

    @Override
    public String getName() {
        //Return square name
        return "square";
    }
    @Override
    public double getArea() {
        //Math for getting a triangle's area
        return input1 * input1;
    }
};

//TRIANGLE
class Triangle extends Shape2D {

    double input1;
    double input2;

    public Triangle(double entry1, double entry2) {
        input1 = entry1;
        input2 = entry2;
    }

    @Override
    public String getName() {
        //Return square name
        return "triangle";
    }
    @Override
    public double getArea() {
        //Math for getting a triangle's area
        return input1 * input2;
    }
}
//CIRCLE
class Circle extends Shape2D {

    double input1;

    public Circle(double entry1) {
        input1 = entry1;
    }

    @Override
    public String getName() {
        //Return square name
        return "circle";
    }
    @Override
    public double getArea() {
        //Math for getting a triangle's area
        return input1 * 2;
    }
}
//CUBE
//PYRAMID
//SPHERE