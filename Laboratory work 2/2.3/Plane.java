import java.util.ArrayList;
import java.util.List;
public class Plane{

    public String _name;

    public List<Passenger> passangerList = new ArrayList<>();

    public void addPassenger(Passenger passenger){
        passangerList.add(passenger);
    }
    public void deletePassenger(Passenger passenger){
        passangerList.remove(passenger);
    }

    public List<Passenger> getAllPassengers(){
        return passangerList;
    }

    public Plane(String _name, String passengerCount) {
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

}
