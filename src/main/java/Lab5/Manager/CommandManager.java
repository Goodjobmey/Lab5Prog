package Lab5.Manager;


import Lab5.Command.CommandPattern;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    private final Map<String, CommandPattern> commands = new LinkedHashMap<>();
    private final List<String> commandHistory = new ArrayList<>();


    public void register(String commandName, CommandPattern command) {
        commands.put(commandName, command);
    }

    public Map<String, CommandPattern> getCommands() {
        return commands;
    }

    public List<String> getCommandHistory() {
        return commandHistory;
    }

    public void addToHistory(String command) {
        commandHistory.add(command);
    }

}
