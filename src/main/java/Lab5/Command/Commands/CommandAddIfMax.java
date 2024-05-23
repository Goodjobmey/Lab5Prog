package Lab5.Command.Commands;

import Lab5.CollectionModel.Route;
import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Manager.Exeptions.WrongAmountOfElementsException;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;
import Lab5.Utility.Input;

public class CommandAddIfMax extends CommandPattern {
    private final Console console;
    private final CollectionManager collectionManager;

    public CommandAddIfMax(Console console, CollectionManager collectionManager) {
        super("add_if_max", "добавить новый элемент в коллекцию, если его дистанция больше максимальной дистанции этой коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public ExecutionResponse apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) throw new WrongAmountOfElementsException();
            console.println("* Создание нового пути:");
            Route route = Input.askRoute(console, collectionManager.getFreeId());


            var minDistance = maxDistance();
            if (route.getDistance() > maxDistance()) {
                collectionManager.add(route);
            } else {
                console.println("Путь не добавлен, дистанция не минимальная (" + route.getDistance() + " < " + maxDistance() +")");
            }
            return new ExecutionResponse("Путь успешно добавлен!");

        } catch (WrongAmountOfElementsException exception) {
            console.printError("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
        } catch (Input.InputStop e) {
            throw new RuntimeException(e);
        }
        return new  ExecutionResponse("Поля продукта не валидны! Путь не создан!");
    }

    private double maxDistance() {
        return collectionManager.getCollection().stream()
                .map(Route::getDistance)
                .mapToDouble(Float::doubleValue)
                .max()
                .orElse(Long.MAX_VALUE);
    }
}

