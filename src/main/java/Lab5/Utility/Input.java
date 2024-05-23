package Lab5.Utility;





import Lab5.CollectionModel.Coordinates;
import Lab5.CollectionModel.Location;
import Lab5.CollectionModel.Route;
import Lab5.Manager.CollectionManager;
import Lab5.Manager.Exeptions.IncorrectInputInScriptException;
import Lab5.Manager.Exeptions.InvalidFormException;

import java.time.LocalDate;
import java.util.NoSuchElementException;

public class Input {
    public static class InputStop extends Exception {}

    private final Console console;
    private final CollectionManager collectionManager;

    public Input(CollectionManager collectionManager, Console console){
        this.collectionManager = collectionManager;
        this.console = console;
    }

    public static Route askRoute(Console console, long id) throws InputStop {
        try {
            String name;
            do {
                console.print("name: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new InputStop();
            } while (name.isEmpty());
            var coordinates = askCoordinates(console);
            var from = askFrom(console);
            var to = askTo(console);
            var distance =askDistance(console);
            return new Route(id, name, coordinates, from, to, distance);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }


    public static Coordinates askCoordinates(Console console) throws InputStop {
        try {
            long x;
            while (true) {
                console.print("coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { x = Long.parseLong(line); break; }catch(NumberFormatException ignored) { }
                }
            }
            double y;
            while (true) {
                console.print("coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { y = Double.parseDouble(line); break; }catch(NumberFormatException ignored) { }
                }
            }
            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }



    public static Location askFrom(Console console) throws InputStop {
        try {
            double x;
            while (true) {
                console.print("куда coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { x = Integer.parseInt(line); break; }catch(NumberFormatException ignored) { }
                }
            }
            int y;
            while (true) {
                console.print("куда coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { y = Integer.parseInt(line); break; }catch(NumberFormatException ignored) { }
                }
            }

            int z;
            while (true) {
                console.print("куда coordinates.z: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { z = Integer.parseInt(line); break; }catch(NumberFormatException ignored) { }
                }
            }

            return new Location(x, y, z);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }



    public static Location askTo(Console console) throws InputStop {
        try {
            double x;
            while (true) {
                console.print("до coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { x = Integer.parseInt(line); break; }catch(NumberFormatException ignored) { }
                }
            }
            int y;
            while (true) {
                console.print("до coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { y = Integer.parseInt(line); break; }catch(NumberFormatException ignored) { }
                }
            }

            int z;
            while (true) {
                console.print("до coordinates.z: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { z = Integer.parseInt(line); break; }catch(NumberFormatException ignored) { }
                }
            }

            return new Location(x, y, z);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Float askDistance(Console console) throws InputStop {
        try {
            float d;
            while (true) {
                console.print("distance (float): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new InputStop();
                if (!line.isEmpty()) {
                    try { d = Float.parseFloat(line); break; }catch(NumberFormatException ignored) { }
                }
            }
            return d;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }


}