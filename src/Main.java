import com.sun.jdi.LocalVariable;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        MessageTask mt1 = new MessageTask("subject1", "body1", "from1", "to1", LocalDateTime.now());
        mt1.execute();
        MessageTask mt2 = new MessageTask("subject2", "body2", "from2", "to2", LocalDateTime.now().minusDays(1));
        mt2.execute();
        MessageTask mt3 = new MessageTask("subject3", "body3", "from3", "to3", LocalDateTime.now().plusDays(1));
        mt3.execute();
        MessageTask mt4 = new MessageTask("subject4", "body4", "from4", "to4", LocalDateTime.now().plusMonths(1));
        mt4.execute();
        MessageTask mt5 = new MessageTask("subject3", "body3", "from3", "to3", LocalDateTime.now().minusMonths(1));
        mt5.execute();
    }
}