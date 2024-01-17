package ru.netelogy.TaskManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        String[] expected = { "Молоко", "Яйца", "Хлеб" };
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTaskTitle() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search(simpleTask.getTitle());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { epic };
        Task[] actual = todos.search ("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting1() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { meeting };
        Task[] actual = todos.search(meeting.getProject());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingFalse() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { };
        Task[] actual = todos.search(meeting.getStart());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting3() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { meeting };
        Task[] actual = todos.search(meeting.getTopic());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTaskAndEpic() {
        SimpleTask simpleTask = new SimpleTask(7, "Позвонить родителям");

        String[] subtasks = { "Позвонить", "Написать", "Ответить" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic };
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTaskAndMeeting() {
        SimpleTask simpleTask = new SimpleTask(7, "Удалить приложения");

        String[] subtasks = { "Позвонить", "Написать", "Ответить" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, meeting };
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpicAndMeeting() {
        SimpleTask simpleTask = new SimpleTask(7, "Удалить приложения");

        String[] subtasks = { "Позвонить", "Выкатка", "Ответить" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { epic, meeting };
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAll() {
        SimpleTask simpleTask = new SimpleTask(7, "Удалить приложения");

        String[] subtasks = { "Позвонить", "Выкатка приложения", "Ответить" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);
    }
}