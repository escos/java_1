import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sort {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Выберите  функцию обработки массива(необходимо ввести число от 0 до 5):");
        System.out.println("           0 - заполнение массива вещественными числами");
        System.out.println("           1 - нахождение минимального значения сгенерированного массива целых чисел");
        System.out.println("           2 - нахождение максимального значения сгенерированного массива целых чисел");
        System.out.println("           3 - нахождение среднего арифметического значения сгенерированного массива целых чисел");
        System.out.println("           4 - нахождение заданного числа в массиве сгенерированного массива целых чисел и определение количества таких чисел в массиве");
        System.out.println("           5 - сортировка пузырьком сгенерированного массива целых чисел");
        byte var = sc.nextByte();
        switch (var) {
            case 0:
                fillArrayRealNumbers(); // заполнение массива вещественными значениями
                break;
            case 1:
                findMinimum(generateRandomArray()); // поиск минимума в массиве
                break;
            case 2:
                findMaximum(generateRandomArray()); // поиск максисума в массиве
                break;
            case 3:
                findAverageValue(generateRandomArray()); // нахождения среднего арифметического элементов массива
                break;
            case 4:
                findNumber(generateRandomArray()); // нахождение заданного числа в массиве и количетво таких чисел
                break;
            case 5:
                sortByBubbleMethod(generateRandomArray()); // сортировка массива методом "пузырька"
                break;
            default:
                System.out.println("Число введено не верно!");
                break;
        }
    }

    public static void fillArrayRealNumbers() {
        Random gen = new Random();
        float a[] = new float[10];
        System.out.println("Массив вещественных значений:");
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextFloat();
        }
        System.out.println(Arrays.toString(a));
    }

    public static void sortByBubbleMethod(int a[]) {
        System.out.println("Сгенерированный массив:");
        System.out.println(Arrays.toString(a));
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("");
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("\b%d\b", a[i]);
        }
    }

    public static void findMinimum(int a[]) {
        System.out.println("Сгенерированный массив:");
        System.out.println(Arrays.toString(a));
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("");
        System.out.println("Минимальное значение массива = " + min);
    }

    public static void findMaximum(int a[]) {
        System.out.println("Сгенерированный массив:");
        System.out.println(Arrays.toString(a));
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("");
        System.out.println("Максимальное значение массива = " + max);
    }

    public static void findAverageValue(int a[]) {
        System.out.println("Сгенерированный массив:");
        System.out.println(Arrays.toString(a));
        float summa = 0;
        for (int i = 0; i < a.length; i++) {
            summa += a[i];
        }
        float average = summa / a.length;
        System.out.println("");
        System.out.printf("Среднее арифметическое массива = %.1f", average);
    }

    public static void findNumber(int a[]) {
        System.out.println("Сгенерированный массив:");
        System.out.println(Arrays.toString(a));
        System.out.printf("");
        System.out.println("Введите искомое число");
        int number = sc.nextInt();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == number) {
                count++;
            }
        }
        if (count == 0)
            System.out.println("Числа " + number + " в данном массиве нет!");
        else
            System.out.println("В массиве встречается " + count + " раз число " + number);
    }

    public static int[] generateRandomArray() {
        Random gen = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
        }
        return a;
    }
}
