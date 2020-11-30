import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    public static void MainMenu() {
        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                printMainMenu();
                System.out.print("> ");
                int selection = input.nextInt();

                if (selection == 1) {
                    //create a new list
                    ContactList contacts = new ContactList();
                    System.out.println("new contacts list has been created");
                    ListOpMenu(contacts);
                }
                if (selection == 2) {
                    //load an existing list
                    System.out.print("Enter the file name to load: ");
                    input.nextLine();
                    String filename = input.nextLine();
                    ContactList contacts = readContacts(filename);
                    ListOpMenu(contacts);
                }
                if (selection == 3) {
                    //quit
                    break;
                }
            } catch(InputMismatchException ex) {
                System.out.println("invalid option");
                input.nextLine();
            } catch(InvalidFileException ex) {
                System.out.println("invalid file");
            }
        }
    }

    private static void ListOpMenu(ContactList contacts) {
        Scanner input = new Scanner(System.in);
        while(true) {
            try {
                printListOpMenu();
                System.out.print("> ");
                int selection = input.nextInt();

                if(selection == 1) {
                    //view the list
                    contacts.printContacts();
                }
                if(selection == 2) {
                    //add an item
                    input.nextLine();
                    System.out.print("First name: ");
                    String firstname = input.nextLine();
                    System.out.print("Last name: ");
                    String lastname = input.nextLine();
                    System.out.print("Phone number (xxx-xxx-xxxx): ");
                    String phoneNum = input.nextLine();
                    System.out.print("Email address (x@y.z): ");
                    String email = input.nextLine();

                    ContactItem contact = new ContactItem(firstname, lastname, phoneNum, email);
                    contacts.add(contact);
                }
                if(selection == 3) {
                    //edit an item
                    if(contacts.size() > 0) {
                        contacts.printContacts();
                        System.out.print("Which contact will you edit? ");
                        input.nextLine();
                        int toEdit = input.nextInt();

                        input.nextLine();
                        System.out.print("Enter a new first name for contact " + toEdit + ": ");
                        String firstname = input.nextLine();
                        System.out.print("Enter a new last name for contact " + toEdit + ": ");
                        String lastname = input.nextLine();
                        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact " + toEdit + ": ");
                        String phoneNum = input.nextLine();
                        System.out.print("Enter a new email for contact " + toEdit + ": ");
                        String email = input.nextLine();

                        ContactItem contact = new ContactItem(firstname, lastname, phoneNum, email);
                        contacts.changeItem(toEdit, contact);
                    } else {
                        System.out.println("The list is empty!");
                    }
                }
                if(selection == 4) {
                    //remove an item
                    contacts.printContacts();
                    System.out.print("Which contact will you remove? ");
                    int index = input.nextInt();
                    contacts.trashItem(index);
                }
                if(selection == 5) {
                    //save the current list
                    input.nextLine();
                    System.out.print("Enter the filename to save as: ");

                    String filename = input.nextLine();
                    File file = new File(filename);
                    try {
                        if (file.createNewFile()) {
                            writeContacts(filename, contacts);
                            System.out.println("task list has been saved");
                        } else {
                            System.out.println("that file already exists");
                        }
                    } catch (IOException ex) {
                        System.out.println("IOException with the file");
                    }
                }
                if(selection == 6) {
                    //quit to the main menu
                    break;
                }
            } catch(InputMismatchException ex) {
                System.out.println("invalid option");
                input.nextLine();
            } catch (InvalidFirstNameException ex) {
                System.out.println("invalid first name; contact not created");
            } catch (InvalidLastNameException ex) {
                System.out.println("invalid last name; contact not created");
            } catch (InvalidPhoneNumException ex) {
                System.out.println("invalid phone number; contact not created");
            } catch (InvalidEmailException ex) {
                System.out.println("invalid email; contact not created");
            } catch (EmptyContactException ex) {
                System.out.println("contact cannot be empty");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("That wasn't an item in the list");
            }
        }
    }

    //Write Contacts
    public static void writeContacts(String filename, ContactList contacts) {
        try {
            FileWriter writer = new FileWriter(filename);
            for(int i = 0; i<contacts.size(); i++) {
                ContactItem item = contacts.get(i);
                writer.write(item.getFirstName() + "\n" + item.getLastName() + "\n" +
                        item.getPhoneNum() + " " + item.getEmail());
                writer.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("We couldn't find this file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Read Contacts
    public static ContactList readContacts(String filename) {
        try (Scanner scan = new Scanner(Paths.get(filename))) {

            ContactList contacts = new ContactList();
            while(scan.hasNext()) {
                String firstname = scan.nextLine();
                String lastname = scan.nextLine();
                String phoneNum = scan.next();
                String email = scan.next();
                ContactItem item = new ContactItem(firstname, lastname, phoneNum, email);

                contacts.add(item);
            }
            System.out.println("contact list has been loaded");
            return contacts;

        } catch (IOException ex) {
            System.out.println("File doesn't exist");
            throw new InvalidFileException("File doesn't exist");
        }
    }

    //Print Main Menu
    private static void printMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("---------");
        System.out.print("1) create a new list\n2) load an existing list\n3) quit\n\n");
    }

    //Print List Op Menu
    private static void printListOpMenu() {
        System.out.println("\nList Operation Menu");
        System.out.println("-------------------");
        System.out.print("1) view the list\n2) add an item\n3) edit an item\n4) remove an item\n5) save the current list\n6) quit to main menu\n\n");
    }

    
}
