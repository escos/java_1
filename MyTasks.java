
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

    public static void main(String[] args) throws IOException {
        ArrayList<Task> taskList = new ArrayList<Task>();
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
                        readFile();
                        break;
                    case CHANGE:
                        System.out.println("Укажите номер задачи из списка, которую нужно корректировать:");
                        int n = sc.nextByte();
                        if ((n > taskList.size()) || (n < 1)) {
                            System.out.println("Задачи с таким номером не существует!");
                        } else {
                            changeTask(taskList.get(n - 1));
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Команда \"" + command + "\" введена неверно!");
                id = false;
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
        try (FileWriter writer = new FileWriter("C://test.txt", true)) {
            String text = task.description + " " + format1.format(task.date.getTime()) + "\n";
            writer.write(text);
            writer.append('|');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readFile() {
        try (FileReader reader = new FileReader("C://test.txt")) {
            int c;
            while ((c = reader.read()) != '|') {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



