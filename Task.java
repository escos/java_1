
import java.util.*;
import java.util.Random;
public class Task {
    String description;
    Calendar date;
    static Random gen = new Random();
    static Scanner sc = new Scanner(System.in);

    Task (String description, Calendar date) {
        this.description = description;
        this.date = date;
    }

    public static Task createTask() {
        System.out.println("Введите название задачи: ");
        String description = sc.next();
        //System.out.println("Введите дату выполнения задачи(dd.mm.yyyy): ");
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, 2017);
        date.set(Calendar.MONTH, gen.nextInt(11));
        date.set(Calendar.DAY_OF_MONTH, gen.nextInt(31));
        date.set(Calendar.HOUR, gen.nextInt(24));
        date.set(Calendar.MINUTE, gen.nextInt(59));
        return new Task(description, date);
    }
}

