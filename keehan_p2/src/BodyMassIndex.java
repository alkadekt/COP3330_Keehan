import java.util.ArrayList;

public class BodyMassIndex {

    //Instance variables
    double bmi;
    String cat;

    //Create an instance method of the class
    public BodyMassIndex(double height, double weight) {
        bmi = 703 * weight / (height * height);
        cat = CategoryPicker(bmi);
    }

    //Chooses which bmi category a user falls within
    public String CategoryPicker(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal weight";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obesity";
    }

}
