
import java.util.Date;
import java.text.SimpleDateFormat;
public class Task {
    String description;
    String consist;
    Date date;

    Task (String description, String consist, Date date) {
        this.consist = consist;
        this.description = description;
        this.date = date;
    }
}

