import java.util.Scanner; //Array utility
import java.util.ArrayList; //Array utility

public class App {
    //Main Function
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
    //Determine if there is more input needed from user
    public static boolean moreInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to enter another user's info? (Y/N): ");
        String decision = input.nextLine();
        if (decision.equals("Y")) {
            return true;
        }
        else if (decision.equals("N")) {
            return false;
        }
        else {
            return false;
        }
    }
    //Scan in user height
    public static double getUserHeight() {
        System.out.print("Give your height (in inches): ");
        Scanner input = new Scanner(System.in);
        double entry = input.nextDouble();
        if (entry < 0) {
            System.out.println("You entered a negative value, please try again.");
            entry = getUserHeight();
        }
        input.nextLine(); //Assignment hint said to do this
        return entry;
    }
    //Scan in user weight
    public static double getUserWeight() {
        System.out.print("Give your weight (in pounds): ");
        Scanner input = new Scanner(System.in);
        double entry = input.nextDouble();
        if (entry < 0) {
            System.out.println("You entered a negative value, please try again.");
            entry = getUserWeight();
        }
        input.nextLine(); //Assignment hint said to do this
        return entry;
    }
    //Display the bmi/category
    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("You have a bmi of %f, which is in the %s category%n", bmi.bmi, bmi.cat);
    }
    //Display the bmi average of the input users
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> Array) {
        double total = 0;
        for(int i=0; i<Array.size(); i++) {
            total = total + Array.get(i).bmi;
        }
        double average = total/Array.size();
        System.out.printf("Average of all users' bmi values is %f%n", average);
    }

}