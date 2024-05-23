package Lab5.Command.Commands;


import Lab5.CollectionModel.Route;
import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;
import Lab5.Utility.Input;

public class CommandAdd extends CommandPattern {
    private final Console console;
    private final CollectionManager collectionManager;
    public CommandAdd(Console console, CollectionManager collectionManager) {
        super("add", "добавить новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) {return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
            }

            console.println("Создание Пути:");
            Route r = Input.askRoute(console, collectionManager.getFreeId());

            if (r != null && r.validate()) {
                collectionManager.add(r);
                collectionManager.addLog("add " + r.getId(), true);
                return new ExecutionResponse("Путь успешно добавлен!");
            } else {
                return new ExecutionResponse("Поля вашего пути не валидны! Путь не создан!");
            }
        } catch (Input.InputStop e) {
            console.println("Отмена...");
            return new ExecutionResponse(false,"Отмена...");
        }
    }
}
