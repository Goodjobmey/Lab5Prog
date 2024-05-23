package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandUnique extends CommandPattern {

    private final Console console;
    private final CollectionManager collectionManager;

    public CommandUnique(Console console, CollectionManager collectionManager) {
        super("print_unique_distance", "вывести уникальные значения поля distance всех элементов в коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }


    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        }
        return new ExecutionResponse(collectionManager.unique());
    }

}
