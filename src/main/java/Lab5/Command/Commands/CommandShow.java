package Lab5.Command.Commands;


import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandShow extends CommandPattern {
    private final Console console;
    private final CollectionManager collectionManager;

    public CommandShow(Console console, CollectionManager collectionManager) {
        super("show", "ввысести все элементы коллекции");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        }
        return new ExecutionResponse(collectionManager.toString());
    }
}
