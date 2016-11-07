
import java.io.*;
import java.util.*;
import java.text.*;

public class MyTasks {
    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    //перечисления команд управления списком
    private enum Commands {
        ADD {
            public String toString() {
                return "add";
            }
        },
        DEL {
            public String toString() {
                return "del";
            }
        },
        LIST {
            public String toString() {
                return "list";
            }
        },
        CHANGE {
            public String toString() {
                return "change";
            }
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Task> taskList = new ArrayList<>();
        ArrayList<String> s = readListFile();
        System.out.println(s.size());
        for (int i = 0; i < s.size() ; i++) {
            System.out.println(s.get(i));
            taskList.add(parseDateAndDescription(s.get(i)));
            System.out.println("Задача: " + taskList.get(i).description + " дата выполнения: " + format1.format(taskList.get(i).date.getTime()));
        }

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
                        taskList.remove(j);
                        break;
                    case LIST:
                        System.out.println("Содержание списка задач:");
                         s = readListFile();
                        for (int i = 0; i < s.size(); i++) {
                            Task task1 = MyTasks.parseDateAndDescription(s.get(i));
                            taskList.add(task1);
                            System.out.println("Задача: " + taskList.get(i).description + " дата выполнения: " + format1.format(task1.date.getTime()));
                        }
                        break;
                    case CHANGE:
                        System.out.println("Укажите номер задачи из списка, которую нужно корректировать:");
                        int n = sc.nextByte();
                        if ((n > taskList.size()) || (n < 1)) {
                            System.out.println("Задачи с таким номером не существует!");
                        } else {
                            changeTask(MyTasks.parseDateAndDescription(s.get(n-1)));
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Команда \"" + command + "\" введена неверно!");
                id = false;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
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

    // читаем файла задачи в список строк
    private static ArrayList readListFile() throws ParseException {
        ArrayList<String> s = new ArrayList<>();
        try {
            File file = new File("C:\\test.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            int i = 0;
            while (reader.readLine() != null) {
                s.add(i, reader.readLine());
                i++;
            }
            return s;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    //
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
}



