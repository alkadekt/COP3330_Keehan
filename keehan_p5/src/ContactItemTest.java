import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(EmptyContactException.class, () -> new ContactItem("","","",""));
    }
    @Test
    public void creationSucceedsWithBlankEmail() {
        new ContactItem("john","bay","123-123-1234","");
    }
    @Test
    public void creationSucceedsWithBlankFirstName() {
        new ContactItem("","bay","123-123-1234","jb@gmail.com");
    }
    @Test
    public void creationSucceedsWithBlankLastName() {
        new ContactItem("john","","123-123-1234","jb@gmail.com");
    }
    @Test
    public void creationSucceedsWithBlankPhone() {
        new ContactItem("john","bay","","jb@gmail.com");
    }
    @Test
    public void creationSucceedsWithNonBlankValues() {
        new ContactItem("john","bay","123-123-1234","jb@gmail.com");
    }
    @Test
    public void editingFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        assertThrows(EmptyContactException.class, () -> contact.set(new ContactItem("","","","")));
    }
    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        contact.set(new ContactItem("john","bay","123-123-1234",""));
    }
    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        contact.set(new ContactItem("","bay","123-123-1234","jb@gmail.com"));
    }
    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        contact.set(new ContactItem("john","","123-123-1234","jb@gmail.com"));
    }
    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        contact.set(new ContactItem("john","bay","","jb@gmail.com"));
    }
    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        contact.set(new ContactItem("john","bay","123-123-1234","jb@gmail.com"));
    }
    @Test
    public void testToString() {
        ContactItem contact = new ContactItem("john","bay","123-123-1234","jb@gmail.com");
        assertEquals("john bay 123-123-1234 jb@gmail.com", contact.toString());
    }
}
