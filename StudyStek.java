

public class StudyStek<String> {
    Element top = null;

    public void push(String value) {
        Element e = new Element();
        e.value = value;
        e.next = top;
        top = e;
    }

    public String pop() {
        String value = top.value;
        top = top.next;
        return value;
    }

    private class Element {
        String value;
        Element next;
    }

}
