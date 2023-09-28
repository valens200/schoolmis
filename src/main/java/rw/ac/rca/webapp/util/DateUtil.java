package rw.ac.rca.webapp.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatDate(Date inputDate) throws ParseException {
        // Define the desired output date format
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Format the Date object to the desired output format
        String outputDateStr = outputDateFormat.format(inputDate);

        // Print the formatted date
        return outputDateStr;
    }
}

