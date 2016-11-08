import java.util.ArrayList;
import java.util.Calendar;

public class MyThread implements Runnable {
    Thread thread;

    MyThread() {
        thread = new Thread(this, "Поток для примера");
        System.out.println("Создан второй поток " + thread);
        thread.start();
    }
    public void run() {
        MyTasks.checkDates(ArrayList tasks);
        System.out.println("Второй поток завершён");
    }
}

