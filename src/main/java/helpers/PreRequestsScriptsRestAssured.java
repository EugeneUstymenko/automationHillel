package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PreRequestsScriptsRestAssured {

    public enum StatusOrderPet {
        placed,
        approved,
        delivered
    }

    public static String setData(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+0000'"/*, Locale.getDefault()*/);
        return dateFormat.format(date);
    }
}
