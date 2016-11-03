
import java.io.IOException;
import java.util.*;
import java.text.*;

public class MyTasks {
    final static int N = 10;
    int size = 0;
    static Scanner sc = new Scanner(System.in);
    private Task[] tasks = new Task[N];
    static SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public enum Commands {
        ADD {
            public String toString() {
                return "ADD";
            }
        },
        DEL {
            public String toString() {
                return "DEL";
            }
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        MyTasks taskList = new MyTasks();
        boolean id = true;
        while (id) {
            System.out.println("Введите команду:");
            String command = sc.next();
            try {
                switch (Commands.valueOf(command)) {
                    case ADD:
                        Task task1 = MyTasks.createtask();
                        taskList.add(task1);
                        id = true;
                        break;
                    case DEL:
                        System.out.println("кажите номер удаляемого элемента(число от 0 до size-1)");
                        int j = sc.nextInt();
                        taskList.delete(j);
                        break;
                    default:
                        System.out.println("Команда введена не верно");
                        id = false;
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Команда введена неверно " + command);
                id = false;
            }
        }
        System.out.println("Размер списка = " + taskList.size());

        for (int i = 0; i < taskList.size; i++) {
            System.out.println("Данные " + (i + 1) + "-й задачи:");
            taskList.print(taskList.tasks[i]);
        }
    }

    // распечатка параметров задачи
    private void print(Task task) {
        System.out.println("    Дата выполнения задачи " + format1.format(task.date));
        System.out.println("    Название задачи: " + task.description);
    }

    // Создание объекта задачи
    private static Task createtask() throws IOException, ParseException {
        System.out.println("Введите название задачи: ");
        String description = sc.next();
        Date date = new Date();
        System.out.println("Введите дату выполнения задачи(dd.mm.yyyy): ");
        String d = sc.next();
        date = new SimpleDateFormat("yyyy-mm-dd").parse(d);
        Task task = new Task(description, date);
        return task;
    }

    // добавить новую задачу в всписок задач
    private void add(Task task) {
        size++;
        if (tasks.length < size) {
            Task[] newtasks = new Task[(int) (tasks.length * 1.5)];
            for (int i = 0; i < newtasks.length; i++) {
                newtasks[i] = tasks[i];
            }
            tasks = newtasks;
        }
        tasks[size - 1] = task;
    }

    // размер списка
    private int size() {
        return size;
    }

    //удалить задачу из списка
    private void delete(int j) {
        for (int i = j - 1; i < size - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        size--;
    }
}



