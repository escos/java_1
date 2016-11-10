import java.util.ArrayList;
import java.util.List;

public class CheckDate {
    public static void main(String[] args) {
        List<Task> taskList = MyTasks.readFromFile();
        MyTasks.checkDates((ArrayList<Task>) taskList);
    }
}
