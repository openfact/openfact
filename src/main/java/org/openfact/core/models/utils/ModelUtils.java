package org.openfact.core.models.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ModelUtils {

    private ModelUtils() {
        throw new IllegalStateException("Utils Class");
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static Date getFirstDateOfPlusNMonth(int n) {
        Calendar aCalendar = Calendar.getInstance();

        // add -1 month to current month
        aCalendar.add(Calendar.MONTH, n);

        // set DATE to 1, so first date of previous month
        aCalendar.set(Calendar.DATE, 1);

        aCalendar.set(Calendar.HOUR, 0);
        aCalendar.set(Calendar.MINUTE, 0);
        aCalendar.set(Calendar.SECOND, 0);
        aCalendar.set(Calendar.MILLISECOND, 0);

        return aCalendar.getTime();
    }

    public static Date getLastDateOfPlusNMonth(int n) {
        Calendar aCalendar = Calendar.getInstance();

        // add -1 month to current month
        aCalendar.add(Calendar.MONTH, n);

        // set actual maximum date of previous month
        aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return aCalendar.getTime();
    }

}
