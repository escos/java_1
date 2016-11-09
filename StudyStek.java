

public class StudyStek<T> {
    Element top = null;

    public void push(T value) {
        Element e = new Element();
        e.value = value;
        e.next = top;
        top = e;
    }

    public T pop() {
        T value = top.value;
        top = top.next;
        return value;
    }

    private class Element {
        T value;
        Element next;
    }

}
