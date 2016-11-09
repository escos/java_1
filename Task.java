
import java.util.*;
import java.util.Random;

public class Task {
    String description;
    Calendar date;
    static Random gen = new Random();
    static Scanner sc = new Scanner(System.in);

    Task(String description, Calendar date) {
        this.description = description;
        this.date = date;
    }

    public static Task createTask() {
        System.out.println("Введите название задачи: ");
        String description = sc.nextLine();
        Calendar date = new GregorianCalendar();
        while (true) {
            //System.out.println("Введите дату выполнения задачи в формате(dd.mm.yyyy hh:mm:ss): ");
            Calendar current = Calendar.getInstance();
            date.set(Calendar.YEAR, 2016);
            date.set(Calendar.MONTH, 11);
            date.set(Calendar.DAY_OF_MONTH, gen.nextInt(23)+9);
            date.set(Calendar.HOUR, gen.nextInt(24));
            date.set(Calendar.MINUTE, gen.nextInt(59));
            if (date.after(current))
                break;
            else System.out.println("Ошибка, необходимо ввести дату выполнения задачи позже текущей");
        }
        return new Task(description, date);
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                '}';
    }
}

