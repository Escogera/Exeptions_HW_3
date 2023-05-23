import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator implements Validator {
    private String dateFormat = "dd.MM.yyyy";

    @Override
    public boolean isValid(String str)
    {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(str);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    
}
