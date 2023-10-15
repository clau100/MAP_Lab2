package Domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageTask extends Task {
    private static class Message {
        static final AtomicInteger count = new AtomicInteger(0);
        public final int id;
        String subject;
        String body;
        String from;
        String to;
        LocalDateTime date;

        public Message(String subject, String body, String from, String to, LocalDateTime date) {
            this.id = count.incrementAndGet();
            this.subject = subject;
            this.body = body;
            this.from = from;
            this.to = to;
            this.date = date;
        }
    }

    Message message;

    public MessageTask(String subject, String body, String from, String to, LocalDateTime date) {
        this.message = new Message(subject, body, from, to, date);
    }

    public void execute() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("id=" + message.id + "|subject=" + message.subject + "|body=" + message.body + "|from=" + message.from + "|to" + message.to + "|date=" + message.date.format(formatter));
    }
}
