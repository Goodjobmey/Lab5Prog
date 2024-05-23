package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandDistanseDown extends CommandPattern {

    private final Console console;
    private final CollectionManager collectionManager;

    public CommandDistanseDown(Console console, CollectionManager collectionManager) {
        super("print_field_descending_distance", "вывести значения поля distance всех элементов в порядке убывания");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        }
        return new ExecutionResponse(collectionManager.sortByDistanceDown());
    }

}
