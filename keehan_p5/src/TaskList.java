import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskItem get(int i) {
        if(i<0) {
            throw new IllegalArgumentException("index must be non negative");
        }
        if(i > tasks.size()) {
            throw new IndexOutOfBoundsException("index is too big");
        }
        return tasks.get(i);
    }

    public void add(TaskItem item) {
        tasks.add(item);
    }

    public int size() {
        return tasks.size();
    }

    public void printTaskList() {
        System.out.println("Current Tasks");
        System.out.println("-------------");
        for(int i=0; i < size(); i++) {
            if(tasks.get(i).getStatus() == "Complete") {
                System.out.println(i + ") *** [" + tasks.get(i).getDueDate() + "] "
                        + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
            } else {
                System.out.println(i + ") [" + tasks.get(i).getDueDate() + "] "
                        + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());

            }
        }
    }

    void printCompleteTaskList() {
        System.out.println("Completed Tasks");
        System.out.println("-------------");
        for(int i=0; i < size(); i++) {
            if(tasks.get(i).getStatus() == "Complete") {
                System.out.println(i + ") [" + tasks.get(i).getDueDate() + "] "
                        + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
            }
        }
    }

    void printUncompleteTaskList() {
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------");
        for(int i=0; i < size(); i++) {
            if(tasks.get(i).getStatus() == "Uncomplete") {
                System.out.println(i + ") [" + tasks.get(i).getDueDate() + "] "
                        + tasks.get(i).getTitle() + ": " + tasks.get(i).getDescription());
            }
        }
    }

    public void changeItem(int index, TaskItem task) {
        tasks.set(index, task);
    }

    public void trashItem(int index) {
        tasks.remove(index);
    }
}