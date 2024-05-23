package Lab5.Utility;

import java.util.Scanner;

public interface Console {
    void print(Object object);
    void println(Object object);
    String readln();
    boolean isCanReadln();
    void printError(Object obj);
    void prompt();
    String getPrompt();
    void selectFileScanner(Scanner obj);
    void selectConsoleScanner();
}
