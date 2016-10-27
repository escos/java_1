import java.util.ArrayList;

public class MyList {
    public static void main(String[] args) {
        ArrayList<String> a = createMyList();
        sizeMyList(a);
        getAnimalUseIndex(a);
        deleteAnimal(a);
        listClear(a);
    }

    public static ArrayList createMyList() {
        ArrayList<String> animals = new ArrayList();
        animals.add("Волк");
        animals.add("Заяц");
        animals.add("Медведь");
        animals.add("Лиса");
        animals.add("Собака");
        animals.add("Кот");
        animals.add("Мышь");
        System.out.println(animals);
        System.out.println("Добавляем первый элемент в список: Лось ");
        animals.add(0, "Лось");
        System.out.println(animals);
        return animals;
    }
    // Размер списка
    public static void sizeMyList(ArrayList animals) {
        animals.size();
        System.out.println("Количество животных в списке " + animals.size());
    }
    // Нахождение элемента по индексу
    public static void getAnimalUseIndex(ArrayList animals) {
        System.out.println("Второе с конца животное " + animals.get(animals.size()-3));
        int j = animals.indexOf("Лиса");
        System.out.println("Индекс животного Лиса = " + j);
    }
    // Удаление элемента из списка
    public static void deleteAnimal(ArrayList animals) {
        System.out.println("Удаляем последний элемент ");
        animals.remove(animals.size()-1);
        System.out.println(animals);
    }
    // Очистка списка
    public static boolean listClear(ArrayList animals) {
        animals.clear();
        boolean mes;
        if (animals.size() == 0)
            mes = true;
        else mes = false;
        System.out.println(mes);
        return mes;
    }
}
