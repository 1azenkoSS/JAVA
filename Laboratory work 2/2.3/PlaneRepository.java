import java.util.ArrayList;
import java.util.List;

public class PlaneRepository {
    private List<Plane> planeStorage = new ArrayList<>();

    public void addPlane(Plane plane){
        planeStorage.add(plane);
    }
    public void deletePlane(Plane plane){
        planeStorage.remove(plane);
    }

    public Plane redactPlane(String name){
        Plane plane = planeStorage.stream().filter(plane1 -> plane1.getName().equals(name)).toList().get(0);

        plane.setName(name);

        return plane;
    }

    private static PlaneRepository instance = null;

    public static PlaneRepository getInstance(){
        if(instance == null)
            instance = new PlaneRepository();
        return instance;
    }
}
