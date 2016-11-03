
import java.util.*;

public class Task {
    String description;
    Calendar date;
    static Scanner sc = new Scanner(System.in);

    Task (String description, Calendar date) {
        this.description = description;
        this.date = date;
    }

    public static Task createTask() {
        System.out.println("Введите название задачи: ");
        String description = sc.next();
        System.out.println("Введите дату выполнения задачи(dd.mm.yyyy): ");
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, sc.nextInt());
        date.set(Calendar.MONTH, sc.nextInt());
        date.set(Calendar.DAY_OF_MONTH, sc.nextInt());
        date.set(Calendar.HOUR, sc.nextInt());
        date.set(Calendar.MINUTE, sc.nextInt());
        return new Task(description, date);
    }
}

