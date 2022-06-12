package g.date;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateSample {
    public static void main(String[] args) {
        DateSample sample = new DateSample();
        sample.printDayOfWeek();
        System.out.println("-------");
        sample.printDayOfWeekLocales();
    }

    private void printDayOfWeek() {
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();
        Locale locale = Locale.getDefault();
        for(DayOfWeek day : dayOfWeeks) {
            System.out.print(day.getDisplayName(TextStyle.FULL, locale)+" ");
            System.out.print(day.getDisplayName(TextStyle.SHORT, locale)+" ");
            System.out.println(day.getDisplayName(TextStyle.NARROW, locale)+" ");
        }
    }
    private void printDayOfWeekLocales() {
        DayOfWeek day = DayOfWeek.SUNDAY;
        Locale[] locales = Locale.getAvailableLocales();
        for(Locale locale : locales) {
            System.out.print(locale.getCountry() + " ");
            System.out.print(day.getDisplayName(TextStyle.FULL, locale)+" ");
            System.out.print(day.getDisplayName(TextStyle.SHORT, locale)+" ");
            System.out.println(day.getDisplayName(TextStyle.NARROW, locale));
        }
    }
}
