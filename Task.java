
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
            //для проверки работоспособности дата вводится автоматически
            date.set(Calendar.YEAR, 2016);
            date.set(Calendar.MONTH, 10);
            date.set(Calendar.DAY_OF_MONTH, gen.nextInt(2)+12);
            date.set(Calendar.HOUR, gen.nextInt(24));
            date.set(Calendar.MINUTE, gen.nextInt(59));
            if (date.after(current))
                break;
            else System.out.println("Ошибка, необходимо ввести дату выполнения задачи позже текущей");
        }
        return new Task(description, date);
    }
}

enum Kind {
    HERBIVORE("травоядное"), PREDATOR("хищное");

    String russianText;

    public String getRussianText() {
        return russianText;
    }

    Kind(String russianText) {
        this.russianText = russianText;
    }
}
