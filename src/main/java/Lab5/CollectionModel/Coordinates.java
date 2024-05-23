package Lab5.CollectionModel;


import Lab5.Utility.Validatable;

public class Coordinates implements Validatable {
    private long x;
    private Double y; //Значение поля должно быть больше -102, Поле не может быть null

    public Coordinates(long x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public boolean validate() {
        return y != null && y >= -102;
    }
}
