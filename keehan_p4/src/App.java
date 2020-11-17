import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                PrintMainMenu();
                //Get the input
                System.out.print("Make a selection: ");
                int selection = input.nextInt();

                //Give corresponding output
                if (selection == 1) {
                    //Create a new list
                    TaskList tasks = new TaskList();

                    System.out.println("new task list has been created");
                    ListOpMenu(tasks);
                    break;
                }
                if (selection == 2) {
                    //Load a list
                    System.out.print("Enter the file name to load: ");

                    input.nextLine();
                    String filename = input.nextLine();
                    readTaskItems(filename);
                }
                if(selection == 3) {
                    //Quit
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("You didn't enter a number.");
                input.nextLine();
            } catch (InvalidFileException ex) {
                //maybe something goes here
            }
        }
    }

    public static void ListOpMenu(TaskList tasks) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                PrintListOpMenu();
                //Get the input
                System.out.print("Make a selection: ");
                int selection = input.nextInt();

                //Give corresponding output
                if (selection == 1) {
                    //View the list
                    tasks.printTaskList();
                }
                if (selection == 2) {
                    //Add an item
                    input.nextLine();
                    System.out.print("Task title: ");
                    String title = input.nextLine();
                    System.out.print("Task description: ");
                    String description = input.nextLine();
                    System.out.print("Task due date (YYYY-MM-DD): ");
                    String dueDate = input.nextLine();

                    TaskItem task = new TaskItem(title, description, dueDate);
                    tasks.add(task);
                }
                if (selection == 3) {
                    //Edit an item
                    if(tasks.size() > 0) {
                        tasks.printTaskList();
                        System.out.print("Which task will you edit? ");
                        input.nextLine();
                        int toEdit = input.nextInt();

                        input.nextLine();
                        System.out.print("Enter a new title for task " + toEdit + ": ");
                        String title = input.nextLine();
                        System.out.print("Enter a new description for task " + toEdit + ": ");
                        String description = input.nextLine();
                        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + toEdit + ": ");
                        String dueDate = input.nextLine();

                        TaskItem task = new TaskItem(title, description, dueDate);
                        tasks.changeItem(toEdit, task);
                    } else {
                        System.out.println("The list is empty!");
                    }
                }
                if (selection == 4) {
                    //Remove an item
                    tasks.printTaskList();
                    System.out.print("Which task will you remove? ");
                    int index = input.nextInt();
                    tasks.trashItem(index);
                }
                if (selection == 5) {
                    //Mark an item as completed
                    tasks.printUncompleteTaskList();
                    System.out.print("Which task will you mark as completed? ");
                    int index = input.nextInt();
                    tasks.get(index).changeStatus("Complete");
                }
                if (selection == 6) {
                    //Un-mark an item as completed
                    tasks.printCompleteTaskList();
                    System.out.print("Which task will you mark as uncompleted? ");
                    int index = input.nextInt();
                    tasks.get(index).changeStatus("Uncomplete");
                }
                if (selection == 7) {
                    //Save the current list
                    input.nextLine();
                    System.out.print("Enter the filename to save as: ");

                    String filename = input.nextLine();
                    File file = new File(filename);

                    try {
                        if (file.createNewFile()) {
                            writeTaskItems(filename, tasks);
                            System.out.println("task list has been saved");
                        } else {
                            System.out.println("that file already exists");
                        }
                    } catch (IOException ex) {
                        System.out.println("we had a big error with the file");
                    }
                }
                if (selection == 8) {
                    MainMenu();
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("You didn't enter a number.");
                input.nextLine();
            } catch (InvalidTitleException ex) {
                System.out.println("WARNING: title must be at least 1 character long; task not created");
            } catch (InvalidDateException ex) {
                System.out.println("WARNING: invalid due date; task not created");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("That wasn't an item in the list");
            }
        }
    }

    public static void writeTaskItems(String filename, TaskList tasks) {
        try {
            FileWriter writer = new FileWriter(filename);
            for(int i = 0; i<tasks.size(); i++) {
                TaskItem item = tasks.get(i);
                writer.write(item.getTitle() + "\n" + item.getDescription() + "\n" +
                        item.getDueDate() + " " + item.getStatus());
                writer.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("We couldn't find this file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readTaskItems(String filename) {
        try (Scanner scan = new Scanner(Paths.get(filename))) {

            TaskList tasks = new TaskList();
            while(scan.hasNext()) {
                String title = scan.nextLine();
                String description = scan.nextLine();
                String date = scan.next();
                String status = scan.next();
                TaskItem item = new TaskItem(title, description, date);
                item.changeStatus(status);

                tasks.add(item);
            }

            System.out.println("task list has been loaded");
            ListOpMenu(tasks);

        } catch (IOException ex) {
            System.out.println("File doesn't exist");
            throw new InvalidFileException("File doesn't exist");
        }
    }

    //Print Main Menu
    static void PrintMainMenu() {
        System.out.println();
        System.out.println("Main Menu");
        System.out.print(
                "1) create a new list\n" +
                        "2) load an existing list\n" +
                        "3) quit\n");
    }

    //Print List Operations Menu
    static void PrintListOpMenu() {
        System.out.println();
        System.out.println("List Operation Menu");
        System.out.print(
                "1) view the list\n" +
                        "2) add an item\n" +
                        "3) edit an item\n" +
                        "4) remove an item\n" +
                        "5) mark an item as completed\n" +
                        "6) unmark an item as completed\n" +
                        "7) save the current list\n" +
                        "8) quit to the main menu\n");
    }
}

class InvalidFileException extends IllegalArgumentException {
    public InvalidFileException(String file) {
        super(file);
    }
}