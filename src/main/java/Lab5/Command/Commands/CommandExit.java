package Lab5.Command.Commands;

import Lab5.Command.CommandPattern;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

public class CommandExit extends CommandPattern {
  private final Console console;

  public CommandExit(Console console) {
    super("exit", "завершить программу (без сохранения в файл)");
    this.console = console;
  }

  @Override
  public ExecutionResponse apply(String[] arguments) {
    if (!arguments[1].isEmpty()) {
      return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");
    }

    console.println("Завершение выполнения...");
    return new ExecutionResponse("exit");
  }
}