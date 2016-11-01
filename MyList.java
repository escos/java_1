import java.util.Scanner;

public class MyList {

    private String[] data = new String[16];
    int size = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyList list = new MyList();
        list.add("Запись №1");
        System.out.println("Первая строка списка list.data[0] = " + list.data[0]);
        list.add("Запись №2");
        System.out.println("Вторая строка списка list.data[1] = " + list.data[1]);
        System.out.println("Текущий размер списка = " + list.size());
        list.add("Запись №3");
        list.add("Запись №4");
        list.add("Запись №5");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "-й элемент списка = " + list.get(i));
        }
        System.out.println("Текущий размер списка = " + list.size());
        System.out.println("Выберите номер строки списка для удаления(целое число от 1 до " + list.size + " )");
        int j = sc.nextInt();
        if ((j < list.size + 1) && (j > 0)) {
            list.delete(j);
            System.out.println("Получившийся список после удаления " + j + "-го элемента:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + "-й элемент списка = " + list.get(i));
            }
        } else {
            System.out.println("Не правильно введен номер элемента списка");
        }
        System.out.println("Очищаем список");
        list.clear();
        list.add("Новая запись №1!");
        list.get(0);
        System.out.println("Первый элемент списка = " + list.get(0));
    }

    private int size() {
        return size;
    }

    private String get(int i) {
        return data[i];
    }

    private void add(String s) {
        size++;
        if (data.length < size) {
            String[] newdata = new String[(int) (data.length * 1.5)];
            for (int i = 0; i < newdata.length; i++) {
                newdata[i] = data[i];
            }
            data = newdata;
        }
        data[size - 1] = s;
    }

    private void delete(int j) {
        for (int i = j - 1; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void clear() {
        size = 0;
    }
}
