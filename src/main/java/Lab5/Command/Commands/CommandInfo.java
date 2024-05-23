package Lab5.Command.Commands;


import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

import java.time.LocalDateTime;

public class CommandInfo extends CommandPattern {


    private final Console console;
    private final CollectionManager collectionManager;
    public CommandInfo(Console console, CollectionManager collectionManager) {
        super("info", "вывести информацию о коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty()) { return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
        }

        LocalDateTime lastInitTime = collectionManager.getLastInitTime();
        String lastInitTimeString = (lastInitTime == null) ? "в данной сессии инициализации еще не происходило" :
                lastInitTime.toLocalDate().toString() + " " + lastInitTime.toLocalTime().toString();

        LocalDateTime lastSaveTime = collectionManager.getLastSaveTime();
        String lastSaveTimeString = (lastSaveTime == null) ? "в данной сессии сохранения еще не происходило" :
                lastSaveTime.toLocalDate().toString() + " " + lastSaveTime.toLocalTime().toString();

        var s="Сведения о коллекции:\n";
        s+=" Тип: " + collectionManager.getCollection().getClass().toString()+"\n";
        s+=" Количество элементов: " + collectionManager.getCollection().size()+"\n";
        console.println(" Дата последнего сохранения: " + lastSaveTimeString);
        console.println(" Дата последней инициализации: " + lastInitTimeString);
        return new ExecutionResponse(s);
    }
}
