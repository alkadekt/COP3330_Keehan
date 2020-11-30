import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaskItem {
    private final String title;
    private final String description;
    private final String dueDate;
    String status = "Uncompleted";

    //Constructor
    public TaskItem(String title, String description, String dueDate) {

        if(isTitleValid(title)) {
            this.title = title;
        } else{
            throw new InvalidTitleException("WARNING: title must be at least 1 character long; task not created");
        }
        if(isDescriptionValid(description)) {
            this.description = description;
        } else{
            throw new InvalidDescriptionException("invalid description");
        }
        if(isDateValid(dueDate)) {
            this.dueDate = dueDate;
        } else {
            throw new InvalidDateException("WARNING: invalid due date; task not created");
        }
    }

    private boolean isTitleValid(String title) {
        return title.length() > 0;
    }

    private boolean isDescriptionValid(String description) {
        return description.length() >= 0;
    }

    private boolean isDateValid(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }
}

//EXCEPTION CLASSES
class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String title) {
        super(title);
    }
}

class InvalidDescriptionException extends IllegalArgumentException {
    public InvalidDescriptionException(String description) {
        super(description);
    }
}

class InvalidDateException extends IllegalArgumentException {
    public InvalidDateException(String date) {
        super(date);
    }
}