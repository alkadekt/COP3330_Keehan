import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        assertEquals(1,contacts.size());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        assertThrows(EmptyContactException.class, () -> contacts.changeItem(0, new ContactItem("","","","")));
    }
    @Test
    public void editingItemsFailsWithInvalidIndex() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        assertThrows(IndexOutOfBoundsException.class, () -> contacts.changeItem(1, new ContactItem("john","","","")));
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        contacts.changeItem(0, new ContactItem("","bay","123-123-1234","jb@gmail.com"));
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        contacts.changeItem(0, new ContactItem("john","","123-123-1234","jb@gmail.com"));
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        contacts.changeItem(0, new ContactItem("john","bay","","jb@gmail.com"));
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        contacts.changeItem(0, new ContactItem("john","smith","123-123-1234","jb@gmail.com"));
    }
    @Test
    public void newListIsEmpty() {
        ContactList contacts = new ContactList();
        assertEquals(0,contacts.size());
    }
    @Test
    public void removingItemsDecreasesSize() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        contacts.trashItem(0);
        assertEquals(0,contacts.size());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        assertThrows(IndexOutOfBoundsException.class, () -> contacts.trashItem(1));
    }
    @Test
    public void savedContactListCanBeLoaded() {
        ContactList contacts = new ContactList();
        contacts.add(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
        String filename = "ContactTest.txt";
        File file = new File(filename);
        ContactApp.writeContacts(filename, contacts);
        ContactList contacts2 = ContactApp.readContacts(filename);
        assertEquals("john",contacts2.get(0).getFirstName());
    }
}
