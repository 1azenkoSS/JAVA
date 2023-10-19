import java.util.ArrayList;
import java.util.List;

public class AirportRepository {
    private List<Airport> airportStorage = new ArrayList<>();

    public void addAirport(Airport airport){
        airportStorage.add(airport);
    }
    public void deleteAirport(Airport airport){
        airportStorage.remove(airport);
    }

    public Airport redactAirport(String name, String location){
        Airport airport = airportStorage.stream().filter(port -> port.getName().equals(name)).toList().get(0);

        airport.setName(name);
        airport.setLocation(location);

        return airport;
    }

    private static AirportRepository instance = null;

    public static AirportRepository getInstance(){
        if(instance == null)
            instance = new AirportRepository();
        return instance;
    }
}
