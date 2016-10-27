import java.util.Random;

public class MyStek {
    static Random gen = new Random();
    public static void main(String[] args) {
        Stack myStack = new Stack(10);
        Stack replyStack = new Stack(10);
        // Заполнение элементами стек
        myStack.addElement(gen.nextInt(100));
        myStack.addElement(gen.nextInt(100));
        myStack.addElement(gen.nextInt(100));
        myStack.addElement(gen.nextInt(100));
        myStack.addElement(gen.nextInt(100));
        // Вывод исходного стека на экран, заполнение элементами обратного стека
        System.out.println("Исходный стек: ");
        while (!myStack.stackEmpty()) {
            replyStack.addElement(myStack.getTop());
            System.out.println(myStack.deleteElement());
        }
        System.out.println();
        // Вывод стека наоборото
        System.out.println("Перевернутый стек: ");
        while (!replyStack.stackEmpty()) {
            System.out.println(replyStack.deleteElement());
        }
    }
}
