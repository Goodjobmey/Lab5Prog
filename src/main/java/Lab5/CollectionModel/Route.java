package Lab5.CollectionModel;

import Lab5.Utility.Element;
import Lab5.Utility.Validatable;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;


public class Route extends Element implements Validatable, Comparator<Element> {

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Location from; //Поле может быть null
    private final Location to; //Поле может быть null
    private final Float distance; //Поле может быть null, Значение поля должно быть больше 1


    public Route(long id, String name,Coordinates coordinates, java.time.LocalDateTime creationDate, Location from, Location to, Float distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Float getDistance() {
        return distance;
    }

    public Route(long id, String name, Coordinates coordinates, Location from, Location to, Float distance){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.creationDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }



        @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (from == null) return false;
        if (to == null) return false;
        if (distance == null || distance < 1) return false;

        return true;
    }

    @Override
    public String toString() {
        return "route{\"id\": " + id + ", " +
                "\"name\": " + name + ", "+
                "\"date\" " + creationDate + ", " +
                "\"location\": " + coordinates + ", "+
                "\"from\": " + from + ", "+
                "\"to\": " + to + ", "+
                "\"distance\": " + distance + "}";
    }

    @Override
    public int compare(Element o1, Element o2) {
        return o1.compareTo(o2);
    }

    @Override
    public int compareTo(Element element) {
        return (int)(this.id - element.getId());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Double.compare(route.distance, distance) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}

