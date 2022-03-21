import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class PersonalDate {

    private Date date;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public PersonalDate(Date date) {
        this.date = date;
    }

    public static PersonalDate of(String value){
        try{
            return new PersonalDate(dateFormat.parse(value));
        }catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Error formateando fecha = "));
        }
    }

    @Override
    public String toString() {
        return dateFormat.format(date);
    }
}
