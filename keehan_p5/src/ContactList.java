import java.util.ArrayList;
import java.util.List;

public class ContactList {
    List<ContactItem> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ContactItem get(int i) {
        if(i<0) {
            throw new IllegalArgumentException("index must be non negative");
        }
        if(i > contacts.size()) {
            throw new IndexOutOfBoundsException("index is too big");
        }
        return contacts.get(i);
    }

    public void add(ContactItem item) {
        contacts.add(item);
    }

    public int size() {
        return contacts.size();
    }

    public void printContacts() {
        System.out.println("\nCurrent Contacts");
        System.out.println("----------------");
        for (int i = 0; i < size(); i++) {
            System.out.println(i + ") Name: " + contacts.get(i).getFirstName() + " "
                    + contacts.get(i).getLastName() + "\nPhone: " + contacts.get(i).getPhoneNum()
                    + "\nEmail: " + contacts.get(i).getEmail());
        }
    }

    public void changeItem(int index, ContactItem contact) {
        contacts.set(index, contact);
    }

    public void trashItem(int index) {
        contacts.remove(index);
    }

}
