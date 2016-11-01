import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class MyTasks {
    final static int N = 10;
    int size = 0;
    static Scanner sc = new Scanner(System.in);
    private Task[] tasks = new Task[N];
    static SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    public static void main(String[] args) {
        MyTasks taskList = new MyTasks();
        boolean id = true;
        while (id) {
            System.out.println("Введите команду:");
            String command = sc.next();
            switch (command) {
                case "ADD":
                    Task task1 = MyTasks.createtask();
                    taskList.add(task1);
                    id = true;
                    break;
                default:
                    System.out.println("Команда введена не верно");
                    id = false;
                    break;
            }
        }
        System.out.println("Размер списка = " + taskList.size());

        for (int i = 0; i < taskList.size; i++) {
            System.out.println("Данные "+(i+1)+"-й задачи:");
            taskList.print(taskList.tasks[i]);
        }
    }

    public enum commands {
        ADD {
            public String toString() {
                return "ADD";
            }
        },
        DELETE {
            public String toString() {
                return "DEL";
            }
        }
    }

    private void print(Task task) {
        System.out.println("    Дата введения задачи " + format1.format(task.date));
        System.out.println("    Название задачи: " + task.description);
        System.out.println("    Содержание задачи: " + task.consist);
    }

    private static Task createtask() {
        System.out.println("Введите название задачи: ");
        String description = sc.next();
        System.out.println("Введите содержание задачи: ");
        String consist = sc.next();
        Date date = new Date();
        Task task = new Task(description, consist, date);
        return task;
    }

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

    private int size() {
        return size;
    }
}
