
class Stack {
    int maxSize; // максимальный размер стека
    int[] stackArray; // массив стека
    int top; // верхний элемент стека

    Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void addElement(int element) {
        stackArray[++top] = element;
    }

    public int deleteElement() {
        return stackArray[top--];
    }

    public int getTop() {
        return stackArray[top];
    }

    public boolean stackEmpty() {
        return (top == -1);
    }
}
