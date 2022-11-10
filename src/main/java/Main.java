
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    Queue<Integer> q
            = new LinkedList<>();
    static int i;
    public void action(int i){
        for (int j = 0; j < 5; j++)
            q.add(j);

        // Display contents of the queue.
        System.out.println("Elements of queue "
                + q);

        // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("removed element-"
                + removedele);

        System.out.println(q);
    }
    public static void main(String[] args) {


        Main m = new Main();

        Timer timer = new Timer();
        // creating timer task, timer
        TimerTask tasknew = new TimerTask() {
            @Override
            public void run() {

                m.action(i);
                i = i+1;
                //stop the timer after 5 executions
                if(i == 5){
                    timer.cancel();
                }
            }
        };
        // scheduling the task at interval
        timer.schedule(tasknew,100, 3000);










/**
 * SNIPPET NO 1:
 * convert a date-time string to date-time using date-format
 * then convert the datetime from one zone to another.
 * convert date-time from london (UTC) to Kabul(UTC+4:30)
 */
        String dateInString =  "2022-11-10 05:15:39";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId londonZoneId = ZoneId.of("Europe/London");
        System.out.println("TimeZone : " + londonZoneId);

        ZonedDateTime londonDateTime = ldt.atZone(londonZoneId);
        System.out.println("Date (London) : " + londonDateTime);

        ZoneId kabulZoneId = ZoneId.of("Asia/Kabul");
        System.out.println("TimeZone : " + kabulZoneId);

        ZonedDateTime asiaZonedDateTime = londonDateTime.withZoneSameInstant(kabulZoneId);
        System.out.println("Date (Kabul) : " + asiaZonedDateTime);

        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
        System.out.println("\n---Converted date-times---");
        System.out.println("Date (Kabul) : " + format.format(asiaZonedDateTime));
        System.out.println("Date (London) : " + format.format(londonDateTime));
    }
}
