import java.util.ArrayList;

public class MyThread implements Runnable {
    Thread thread;
    ArrayList<Task> taskList = new ArrayList<>();
    MyThread() {
        thread = new Thread(this, "Поток для примера");
        System.out.println("Создан второй поток " + thread);
        thread.start();
    }
    public void run() {
        MyTasks.checkDates(taskList);
        System.out.println("Второй поток завершён");
    }
}

