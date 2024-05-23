package Lab5.Command.Commands;



import Lab5.Command.CommandPattern;
import Lab5.Manager.CommandManager;
import Lab5.Utility.Console;
import Lab5.Utility.ExecutionResponse;

import java.util.stream.Collectors;

public class CommandHelp extends CommandPattern {

    private final Console console;
    private final CommandManager commandManager;

    public CommandHelp(Console console, CommandManager commandManager) {
        super("help", "вывести список всех команд");
        this.console = console;
        this.commandManager = commandManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (!arguments[1].isEmpty())
            return new ExecutionResponse(false, "Неправильное количество аргументов!\nИспользование: '" + getName() + "'");

        return new ExecutionResponse(commandManager.getCommands()
                .values().stream().map(command -> String
                        .format(" %-35s%-1s%n", command.getName(), command.getDescription()))
                .collect(Collectors.joining("\n")));
    }
}
