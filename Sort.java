import java.util.Random;

public class Sort {
    public static void main(String[] args) {
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
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
