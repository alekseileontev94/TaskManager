import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netelogy.TaskManager.Epic;
import ru.netelogy.TaskManager.Meeting;
import ru.netelogy.TaskManager.SimpleTask;
import ru.netelogy.TaskManager.Task;

public class TaskTest {

    @Test
    public void FindAnswerForQueryInEpicTrue() {
        String[] subtasks = {"Выпить кофе", "Сходить в магазин", "Встретиться с другом"};
        Task epic = new Epic(3, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Встретиться");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FindAnswerForQueryInEpicFalse() {
        String[] subtasks = {"Выпить кофе", "Сходить в магазин", "Встретиться с другом"};
        Task epic = new Epic(3, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Встретится");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FindAnswerForQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(5,  "Записаться на прием к врачу");

        boolean expected = true;
        boolean actual = simpleTask.matches("прием");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FindAnswerForQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(5,  "Записаться на прием к врачу");

        boolean expected = false;
        boolean actual = simpleTask.matches("приём");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FindAnswerForQueryInMeetingTrue() {
        Task meeting = new Meeting(12,  "Разбор домашнего задания", "Вебинар", "В среду в 14:30");

        boolean expected = true;
        boolean actual = meeting.matches("Вебинар");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FindAnswerForQueryInMeetingFalse() {
        Task meeting = new Meeting(12,  "Разбор домашнего задания", "Вебинар", "В среду в 14:30");

        boolean expected = false;
        boolean actual = meeting.matches("Вебенар");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {

        Task task = new Task(44);

        int expected = 44;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }
}
