import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;

public class FlightSchedule {

    private Plane plane;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public FlightSchedule(Plane plane, String date){
        this.plane = plane;
        try {


            this.date = dateFormat.parse(date);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Date date;

}
