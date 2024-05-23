package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandSave extends CommandPattern {
	private final Console console;
	private final CollectionManager collectionManager;

	public CommandSave(Console console, CollectionManager collectionManager) {
		super("save", "сохранить коллекцию в файл");
		this.console = console;
		this.collectionManager = collectionManager;
	}

	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

		collectionManager.saveCollection();
		return new ExecutionResponse(true, "");
	}
}