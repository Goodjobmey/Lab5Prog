package Lab5.Command;


import Lab5.Utility.Executable;
import Lab5.Utility.ExecutionResponse;
import Lab5.Utility.Input;

public class CommandPattern implements Executable {
    private final String name;
    private final String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CommandPattern(String name, String description) {
        this.name = name;
        this.description= description;
    }


    @Override
    public ExecutionResponse apply(String[] arguments) throws Input.InputStop {
        return null;
    }
}
