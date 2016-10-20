import java.util.Random;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        fillArray();
        findMinimum();
        findMaximum();
        sortBubbleArray();
        findAverageValue();
        findNumber();
    }

    public static void fillArray() {
        Random mymas = new Random();
        float a[] = new float[10];
        // Заполняем начальными значениями
        for (int i = 0; i < a.length; i++) {
            a[i] = mymas.nextFloat();
            System.out.println(a[i]);
        }
    }

    public static void sortBubbleArray() {
        Random mymas1 = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = mymas1.nextInt(100);
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }

    public static void findMinimum() {
        // Создаем генератор случайных чисел
        Random gen = new Random();
        int a[] = new int[10];
        // Заполняем начальными значениями
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(a[0]);
    }

    public static void findMaximum() {
        // Создаем генератор случайных чисел
        Random gen = new Random();
        int a[] = new int[10];
        // Заполняем начальными значениями
        for (int i = 0; i < a.length; i++) {
            a[i] = gen.nextInt(100);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(a[0]);
    }

    public static void findAverageValue() {
        Random mymas2 = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = mymas2.nextInt(100);
        }
        int summ = 0;
        for (int i = 0; i < a.length; i++) {
            summ = +a[i];
            System.out.println(a[i]);
        }
        int average = summ / a.length;
        System.out.println(summ + " " + average);
    }

    public static void findNumber() {
        Random mymas2 = new Random();
        int a[] = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = mymas2.nextInt(100);
        }
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        for (int i = 0; i < a.length ; i++) {
            if (a[i] == number) {
                count++;
            }
        }
        System.out.println(count);
    }

}
