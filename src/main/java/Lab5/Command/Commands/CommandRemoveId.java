package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandRemoveId extends CommandPattern {
	private final Console console;
	private final CollectionManager collectionManager;

	public CommandRemoveId(Console console, CollectionManager collectionManager) {
		super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
		this.console = console;
		this.collectionManager = collectionManager;
	}


	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		long id = -1;
		try { id = Long.parseLong(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }

		if (collectionManager.byId(id) == null || !collectionManager.getCollection().contains(collectionManager.byId(id)))
			return new ExecutionResponse(false, "Не существующий ID");
		collectionManager.remove(id);
		return new ExecutionResponse("Путь успешно удалён!");
	}
}