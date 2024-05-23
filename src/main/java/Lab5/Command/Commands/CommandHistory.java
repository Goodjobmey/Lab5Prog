package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CommandManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

import java.util.stream.Collectors;

public class CommandHistory extends CommandPattern {
	private final Console console;
	private final CommandManager commandManager;

	public CommandHistory(Console console, CommandManager commandManager) {
		super("history", "Вывыодит историю команд");
		this.console = console;
		this.commandManager = commandManager;
	}

	/**
	 * Выполняет команду
	 * @return Успешность выполнения команды.
	 */
	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (!arguments[1].isEmpty()) return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		
		return new ExecutionResponse(commandManager.getCommandHistory().stream().map(command -> " " + command).collect(Collectors.joining("\n")));
	}
}