import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    //Main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                printMainMenu();
                System.out.print("> ");
                int selection = input.nextInt();

                if(selection == 1) {
                    //task list
                    TaskApp.MainMenu();
                }
                if(selection == 2) {
                    //contact list
                    ContactApp.MainMenu();
                }
                if(selection == 3) {
                    //quit
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("invalid option");
                input.nextLine();
            }
        }
    }

    //Print Menu
    private static void printMainMenu() {
        System.out.println("\nSelect Your Application");
        System.out.println("-----------------------");
        System.out.print("1) task list\n2) contact list\n3) quit\n\n");
    }
}
