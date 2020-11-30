import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
