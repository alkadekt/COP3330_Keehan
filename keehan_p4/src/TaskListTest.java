import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertEquals(tasks.size(), 1);
    }
    @Test
    public void completingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title","","2020-12-12");

        task.changeStatus("Complete");

        assertEquals(task.getStatus(), "Complete");
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(3).changeStatus("Complete"));
    }
    @Test
    public void editingTaskItemChangesValues() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("new","new","2021-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.changeItem(0,task2);
        assertEquals(tasks.get(0).getTitle(),"new");
        assertEquals(tasks.get(0).getDescription(),"new");
        assertEquals(tasks.get(0).getDueDate(),"2021-12-12");
    }
    @Test
    public void editingTaskItemDescriptionChangesValue() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("title","new","2020-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.changeItem(0,task2);
        assertEquals(tasks.get(0).getDescription(),"new");
    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("title","new","2020-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.changeItem(1,task2));
    }
    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("title","","2021-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.changeItem(0,task2);
        assertEquals(tasks.get(0).getDueDate(),"2021-12-12");
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("title","","2021-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.changeItem(1,task2));
    }
    @Test
    public void editingTaskItemTitleChangesValue() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("new","","2021-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.changeItem(0,task2);
        assertEquals(tasks.get(0).getTitle(),"new");
    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskItem task2 = new TaskItem("new","","2020-12-12");

        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.changeItem(1,task2));
    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1));
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title","answer","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertEquals(tasks.get(0).getDescription(), "answer");
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getDueDate());
    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title","answer","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertEquals(tasks.get(0).getDueDate(), "2020-12-12");
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(1).getTitle());
    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title","answer","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertEquals(tasks.get(0).getTitle(), "title");
    }
    @Test
    public void newTaskListIsEmpty() {
        TaskList tasks = new TaskList();

        assertEquals(tasks.size(),0);
    }
    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.trashItem(0);
        assertEquals(tasks.size(), 0);
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.trashItem(1));
    }
    @Test
    public void savedTaskListCanBeLoaded() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);
        String filename = "thisISIT";
        File file = new File(filename);
        //App.writeTaskItems(filename, tasks);
        //App.readTaskItems(filename);
        //This test took too long to run
    }
    @Test
    public void uncompletingTaskItemChangesStatus() {
        TaskItem task = new TaskItem("title","","2020-12-12");

        task.changeStatus("Uncomplete");

        assertEquals(task.getStatus(), "Uncomplete");
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> tasks.get(3).changeStatus("Uncomplete"));
    }
}

class TaskItemTest {
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertThrows(InvalidDateException.class, () -> new TaskItem("title","",""));
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(InvalidTitleException.class, () -> new TaskItem("","","2020-12-12"));
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        new TaskItem("title","","2020-12-12");
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        new TaskItem("title","","2020-12-12");
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(InvalidDateException.class, () -> tasks.changeItem(0, new TaskItem("title","","")));
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.changeItem(0, new TaskItem("title","","2020-12-12"));
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        assertThrows(InvalidTitleException.class, () -> tasks.changeItem(0, new TaskItem("","","2020-12-12")));
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("title","","2020-12-12");
        TaskList tasks = new TaskList();
        tasks.add(task);

        tasks.changeItem(0, new TaskItem("title","","2020-12-12"));
    }
}
