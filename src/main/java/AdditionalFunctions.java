import java.text.SimpleDateFormat;
import java.util.Date;

public interface AdditionalFunctions {

    default String dataTime() {
        SimpleDateFormat formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        return formatterDate.format(date) + " в " + formatterTime.format(date);
    }
}
