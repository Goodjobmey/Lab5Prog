package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Manager.CommandManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;
import Lab5.Utility.Runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CommandExecuteScript extends CommandPattern {
	private final Console console;

	public CommandExecuteScript(Console console) {
		super("execute_script <file_name>", "исполнить скрипт из указанного файла");
		this.console = console;
	}

	@Override
	public ExecutionResponse apply(String[] arguments) {
		if (arguments[1].isEmpty()) {
			return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
		}
		return  new ExecutionResponse("Выполнение скрипта '" + arguments[1] + "'...");
	}
}


