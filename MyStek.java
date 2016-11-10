import java.util.Random;
import java.util.Scanner;

public class MyStek {
    static Random gen = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите максимальное количество элементов(необходимо ввести целое число > 2)");
        int N = sc.nextInt();
        Stack myStack = new Stack(N);
        Stack replyStack = new Stack(N);
        // Заполнение элементами стек
        for (int i = 0; i < gen.nextInt(N-2); i++) {
            myStack.addElement(gen.nextInt(100));
        }
        // Вывод исходного стека на экран, заполнение элементами обратного стека
        System.out.println("Исходный стек: ");
        while (!myStack.stackEmpty()) {
            replyStack.addElement(myStack.getTop());
            System.out.println(myStack.deleteElement());
        }
        System.out.println();
        // Вывод стека наоборот
        System.out.println("Перевернутый стек: ");
        while (!replyStack.stackEmpty()) {
            System.out.println(replyStack.deleteElement());
        }
    }
}
