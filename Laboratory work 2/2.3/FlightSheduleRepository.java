import java.util.ArrayList;
import java.util.List;

public class FlightSheduleRepository {
    private List<FlightSchedule> flightShedules = new ArrayList<>();

    public void addShedule(FlightSchedule schedule){
        flightShedules.add(schedule);
    }

    public List<FlightSchedule> getAll(){
        return flightShedules;
    }

    private static FlightSheduleRepository instance = null;

    public static FlightSheduleRepository getInstance(){
        if(instance == null)
            instance = new FlightSheduleRepository();
        return instance;
    }
}
