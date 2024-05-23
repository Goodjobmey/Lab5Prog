package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CollectionManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;
import Lab5.Utility.Input;

public class CommandUpdate extends CommandPattern {
	private final Console console;
	private final CollectionManager collectionManager;

	public CommandUpdate(Console console, CollectionManager collectionManager) {
		super("update <ID>", "обновить значение элемента коллекции по ID");
		this.console = console;
		this.collectionManager = collectionManager;
	}

	/**
	 * Выполняет команду
	 * @return Успешность выполнения команды.
	 */
	@Override
	public ExecutionResponse apply(String[] arguments) {
		try {
			if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
			long id = -1;
			try { id = Long.parseLong(arguments[1].trim()); } catch (NumberFormatException e) { return new ExecutionResponse(false, "ID не распознан"); }
			
			var old = collectionManager.byId(id);
			if (old == null || !collectionManager.getCollection().contains(old)) {
				return new ExecutionResponse(false, "Не существующий ID");
			}
			
			console.println("* Создание нового Пути:");
			var d = Input.askRoute(console, old.getId());
			if (d != null && d.validate()) {
				collectionManager.remove(old.getId());
				collectionManager.add(d);
				return new ExecutionResponse("Обновлено!");
			} else {
				return new ExecutionResponse(false, "Поля Пути не валидны! Путь не создан!");
			}
		} catch (Input.InputStop e) {
			return new ExecutionResponse(false, "Поля Пути не валидны! Путь не создан!");
		}
	}
}