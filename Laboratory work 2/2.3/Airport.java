public class Airport{
    private String _name;
    private String _location;

    public Airport(String _name, String _location) {
        this._name = _name;
        this._location = _location;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public void setLocation(String _location){
        this._location = _location;
    }
}