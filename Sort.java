import java.util.Random;
import java.util.Scanner;

public class Sort {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Выберите функцию (необходимо ввести число от 0 до 5)");
        byte var = sc.nextByte();
        switch (var) {
            case 0:
                fillArray();
                break;
            case 1:
                findMinimum();
                break;
            case 2:
                findMaximum();
                break;
            case 3:
                findAverageValue();
                break;
            case 4:
                findNumber();
                break;
            case 5:
                sortBubbleArray();
                break;
            default:
                System.out.println("Число введено не верно!");
                break;
        }
    }

    public static void fillArray() {
        Random gen = new Random();
        float a[] = new float[10];
        System.out.println("Массив вещественных значений:\n");
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextFloat();
            System.out.printf("%.3f\b",a[i]);
        }
    }

    public static void sortBubbleArray() {
        Random gen = new Random();
        int a[] = new int[10];
        System.out.println("Неотсортированный массив:");
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
            System.out.printf("\b%d\b",a[i]);
        }
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
            System.out.printf("\b%d\b",a[i]);
        }
    }

    public static void findMinimum() {
        Random gen = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
            System.out.printf("%d\b",a[i]);
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("");
        System.out.println("Минимальное значение массива = " + min);
    }

    public static void findMaximum() {
        Random gen = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
            System.out.printf("%d\b",a[i]);
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("");
        System.out.println("Максимальное значение массива = " + max);
    }

    public static void findAverageValue() {
        Random gen = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(10);
            System.out.printf("%d\b",a[i]);
        }
        float summa = 0;
        for (int i = 0; i < a.length; i++) {
            summa += a[i];
        }
        float average = summa / a.length;
        System.out.println("");
        System.out.printf("Среднее арифметическое массива = %.1f",average);
    }

    public static void findNumber() {
        Random gen = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
            System.out.printf("%d\b",a[i]);
        }
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
}
