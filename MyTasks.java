import java.util.ArrayList;
public class MyTasks {
    public static ArrayList createMyList() {
        ArrayList<String> tasks = new ArrayList();
        tasks.add("Задача №1");
        tasks.add("Задача №2");
        tasks.add("Задача №3");
        tasks.add("Задача №4");
        tasks.add("Задача №5");
        tasks.add("Задача №6");
        tasks.add("Задача №7");
        System.out.println(tasks);
        System.out.println("Добавляем первый элемент в список: дополнительная задача ");
        tasks.add(0, "Дополнительная задача");
        System.out.println(tasks);
        return tasks;
    }

    // Размер списка задач
    public static void sizeMyList(ArrayList tasks) {
        tasks.size();
        System.out.println("Количество задач в списке " + tasks.size());
    }

    // Нахождение задачи по индексу
    public static void getAnimalUseIndex(ArrayList tasks) {
        System.out.println("Вторая задача с конца " + tasks.get(tasks.size()-3));
        System.out.println("Индекс задачи = " + (tasks.size()-3));
    }

    // Удаление задачи из списка
    public static void deleteAnimal(ArrayList tasks) {
        System.out.println("Удаляем последний элемент списка");
        tasks.remove(tasks.size() - 1);
        System.out.println(tasks);
    }

    // Очистка списка задач
    public static boolean listClear(ArrayList tasks) {
        tasks.clear();
        boolean mes;
        if (tasks.size() == 0)
            mes = true;
        else mes = false;
        System.out.println(mes);
        return mes;
    }

}
