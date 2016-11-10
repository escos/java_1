
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.text.*;

public class MyTasks {
    public static final String FILENAME = "C:\\test.txt";
    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    //перечисления команд управления списком
    private enum Commands {
        ADD,
        DEL,
        LIST,
        CHANGE
    }

    public static void main(String[] args) throws IOException, ParseException {
        List<Task> taskList = readFromFile();
        printTaskList(taskList);
        boolean id = true;
        while (id) {
            System.out.println("Введите команду:");
            String command = sc.next();
            try {
                switch (Commands.valueOf(command)) {
                    case ADD:
                        Task task = Task.createTask();
                        taskList.add(task);
                        writeFile(task);
                        break;
                    case DEL:
                        System.out.println("Укажите номер удаляемого элемента(число от 0 до size-1)");
                        int j = sc.nextInt();
                        if ((j >= 0) && (j < taskList.size())) {
                            taskList.remove(j);
                            for (int i = 0; i < taskList.size(); i++) {
                                System.out.printf("Задача: %s , дата выполнения: %s ", taskList.get(i).description, format1.format(taskList.get(i).date.getTime()));
                            }
                        } else {
                            System.out.println("Номер задачи введен не верно!");
                        }
                        break;
                    case LIST:
                        System.out.println("Содержание списка задач:");
                        taskList.clear();
                        taskList = readFromFile();
                        printTaskList(taskList);
                        break;
                    case CHANGE:
                        System.out.println("Укажите номер задачи из списка, которую нужно корректировать:");
                        int n = sc.nextByte();
                        taskList = readFromFile();
                        if ((n > taskList.size()) || (n < 1)) {
                            System.out.println("Задачи с таким номером не существует!");
                        } else {
                            changeTask(taskList.get(n - 1));
                            writeToFile(taskList);
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Команда \"" + command + "\" введена неверно!");
                id = false;
            }
        }
    }

    private static void writeToFile(List<Task> taskList) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILENAME), StandardCharsets.UTF_8)) {
            for (Task task : taskList) {
                writer.write(task.description + " " + format1.format(task.date.getTime()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // распечатка списка задач
    public static void printTaskList(List<Task> taskList) {
        System.out.println("Задач: " + taskList.size());
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("Задача " + i + ": " + taskList.get(i).description + " дата выполнения: " + format1.format(taskList.get(i).date.getTime()));
        }
    }

    public static List<Task> readFromFile() {
        List<String> s = readListFile();
        if (s != null) {
            return toTasks(s);
        }
        return Collections.emptyList();
    }

    private static List<Task> toTasks(List<String> s) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            taskList.add(parseDateAndDescription(s.get(i)));
        }
        return taskList;
    }

    //изменение параметров задач
    private static Task changeTask(Task task) {
        System.out.println("Желаете изменить название задачи?");
        if (sc.nextBoolean()) {
            System.out.println("Введите новое название задачи");
            task.description = sc.next();
        }
        System.out.println("Желаете изменить дату выполнения задачи?");
        if (sc.nextBoolean()) {
            System.out.println("Введите новую дату выполнения задачи");
            Calendar date = new GregorianCalendar();
            date.set(Calendar.YEAR, sc.nextInt());
            date.set(Calendar.MONTH, sc.nextInt());
            date.set(Calendar.DAY_OF_MONTH, sc.nextInt());
            date.set(Calendar.HOUR, sc.nextInt());
            date.set(Calendar.MINUTE, sc.nextInt());
        }
        return task;
    }

    // запись в файл задачи
    private static void writeFile(Task task) {
        try (FileWriter writer1 = new FileWriter("C://test.txt", true)) {
            writer1.write(task.description + " " + format1.format(task.date.getTime()));
            writer1.write(System.lineSeparator());
            writer1.flush();
            writer1.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // читаем из файла задачи в список строк
    private static List<String> readListFile() {
        // Files.readAllLines()
        try {
            return Files.readAllLines(Paths.get(FILENAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    //parsing данных из файла
    private static Task parseDateAndDescription(String s) {
        String s1 = s.substring(s.length() - 16);
        String description = s.substring(0, s.length() - 16);
        Calendar cal;
        try {
            cal = Calendar.getInstance();
            cal.setTime(format1.parse(s1));
        } catch (ParseException e) {
            e.printStackTrace();
            cal = null;
        }
        return new Task(description, cal);
    }

    // проверка даты и времени выполния задач
    public static void checkDates(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_MONTH, +1);
                if (tasks.get(i).date.before(calendar)) {
                    System.out.println("НАПОМИНАНИЕ: ДО ВЫПОЛНЕНИЯ " + i + "-Й ЗАДАЧИ ОСТАЛОСЬ МЕНЕЕ 1 ДНЯ.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



