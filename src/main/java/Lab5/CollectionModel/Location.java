package Lab5.CollectionModel;


import Lab5.Utility.Validatable;

public class Location implements Validatable {
    private Double x; //Поле не может быть null
    private int y;
    private int z;

    public Location(Double x, int y, int z){
        this.z = z;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ";" + y + ";" + z;
    }

    @Override
    public boolean validate() {
        if (x == null) return false;

        return true;
    }
}
