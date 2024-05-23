package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandClear extends CommandPattern {
	private final Console console;
	private final CollectionManager collectionManager;

	public CommandClear(Console console, CollectionManager collectionManager) {
		super("clear", "очистить коллекцию");
		this.console = console;
		this.collectionManager = collectionManager;
	}

	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (!arguments[1].isEmpty()) { return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");}
		
		var isFirst = true;
		while (!collectionManager.getCollection().isEmpty()) {
			var dragon = collectionManager.getCollection().removeLast();
			collectionManager.remove(dragon.getId());
			collectionManager.addLog("remove " + dragon.getId(),isFirst);
			isFirst = false;
		}

		return new ExecutionResponse("Коллекция очищена!");
	}
}