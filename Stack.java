
class Stack {
    int maxSize; // максимальный размер стека
    int[] stackArray; // массив стека
    int top; // верхний элемент стека

    Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    void addElement(int element) {
        stackArray[++top] = element;
    }

    int deleteElement() {
        return stackArray[top--];
    }

    int getTop() {
        return stackArray[top];
    }

    boolean stackEmpty() {
        return (top == -1);
    }
}
