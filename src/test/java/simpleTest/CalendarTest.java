package simpleTest;

import java.util.Calendar;

/**
 * Created by caoyang on 2017/6/13.
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        calendar.add(Calendar.SECOND,1080*60+66);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) +":"+calendar.get(Calendar.MINUTE)+":" +calendar.get(Calendar.SECOND));

    }
}
