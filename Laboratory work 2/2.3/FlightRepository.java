import java.util.ArrayList;
import java.util.List;
public class FlightRepository {

    public List<Airport> airportStorage = new ArrayList<>();
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
}
