package helpers;

import javax.swing.text.html.parser.Parser;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

public class PreRequestsScripts {

    //For example
    public static String getToken() {
        return "token";
    }

    /*public static void setData(){
        *//*@Column(name = "created_at")
        @CreationTimestamp*//*
        LocalDateTime createDate;
        String s;
        Date date = createDate.parse(s);
        //String createDates = Parser.;
        formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);
    }*/

    public enum StatusOrderPet {
        placed,
        approved,
        delivered
    }
}
