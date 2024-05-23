package Lab5;


import Lab5.Command.Commands.*;
import Lab5.Manager.CollectionManager;
import Lab5.Manager.CommandManager;
import Lab5.Manager.DumpManager;
import Lab5.Utility.Runner;
import Lab5.Utility.StandardConsole;

public class Main {
    public static void main(String[] args) {

        var console = new StandardConsole();


        if (args.length == 0) {
            console.println("Введите имя загружаемого файла как аргумент командной строки");
            System.exit(1);
        }

        String path = null;
        if (System.getenv("HOMEPATH") != null) {
            path = "C:\\Users\\kuzmi\\IdeaProjects\\Lab5Prog 2\\Lab5Prog\\files\\Arguments.json";
        }


        var dumpManager = new DumpManager(path, console);
        var collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.loadCollection()) {
            System.exit(1);
        }


        var commandManager = new CommandManager() {{
            register("help", new CommandHelp(console, this));
            register("info", new CommandInfo(console, collectionManager));
            register("show", new CommandShow(console, collectionManager));
            register("add", new CommandAdd(console, collectionManager));
            register("exit", new CommandExit(console));
            register("save", new CommandSave(console, collectionManager));
            register("history", new CommandHistory(console, this));
            register("update", new CommandUpdate(console, collectionManager));
            register("remove_by_id", new CommandRemoveId(console,collectionManager));
            register("clear", new CommandClear(console, collectionManager));
            register("execute_script", new CommandExecuteScript(console));
            register("print_field_descending_distance", new CommandDistanseDown(console, collectionManager));
            register("print_unique_distance", new CommandUnique(console, collectionManager));
            register("add_if_min", new CommandAddIfMin(console, collectionManager));
            register("add_if_max", new CommandAddIfMax(console, collectionManager));
        }};

        new Runner(console, commandManager).interactiveMode();

    }
}