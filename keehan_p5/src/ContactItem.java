public class ContactItem {
    //Instance Variables
    private String firstname;
    private String lastname;
    private String phoneNum;
    private String email;

    //Constructor
    public ContactItem(String firstname, String lastname, String phoneNum, String email) {

        //Validation
        if(isFirstNameValid(firstname)) {
            this.firstname = firstname;
        } else{
            throw new InvalidFirstNameException("invalid first name");
        }
        if(isLastNameValid(lastname)) {
            this.lastname = lastname;
        } else{
            throw new InvalidLastNameException("invalid last name");
        }
        if(isPhoneNumValid(phoneNum)) {
            this.phoneNum = phoneNum;
        } else {
            throw new InvalidPhoneNumException("invalid phone number");
        }
        if(isEmailValid(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException("invalid email");
        }
        if(emptyContact()) {
            throw new EmptyContactException("empty contact");
        }
    }

    //Regular Expression Validation
    private boolean isFirstNameValid(String name) {
        return name.length() >= 0;
    }
    private boolean isLastNameValid(String name) {
        return name.length() >= 0;
    }
    private boolean isPhoneNumValid(String number) {
        return number.equals("") || number.matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}");
    }
    private boolean isEmailValid(String email) {
        return email.equals("") || email.matches("^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$");
    }
    private boolean emptyContact() {
        return firstname.equals("") && lastname.equals("") && phoneNum.equals("") && email.equals("");
    }

    //Set Methods
    private void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    private void setLastName(String lastname) {
        this.lastname = lastname;
    }
    private void setPhoneNum(String number) {
        this.phoneNum = number;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    public void set(ContactItem contact) {
        setFirstName(contact.firstname);
        setLastName(contact.lastname);
        setPhoneNum(contact.phoneNum);
        setEmail(contact.email);
    }

    //Get Methods
    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getEmail() {
        return email;
    }

    //toString
    public String toString() {
        return firstname + " " + lastname + " " + phoneNum + " " + email;
    }
}

//Exception Classes
class InvalidFirstNameException extends IllegalArgumentException {
    public InvalidFirstNameException(String s) {
        super(s);
    }
}
class InvalidLastNameException extends IllegalArgumentException {
    public InvalidLastNameException(String s) {
        super(s);
    }
}
class InvalidPhoneNumException extends IllegalArgumentException {
    public InvalidPhoneNumException(String s) {
        super(s);
    }
}
class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(String s) {
        super(s);
    }
}
class EmptyContactException extends IllegalArgumentException {
    public EmptyContactException(String s) {
        super(s);
    }
}