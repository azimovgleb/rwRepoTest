package rw.vtb.dolomit.dolomit.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

    public static Date addOneDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
