package Lab5.Manager;

import Lab5.CollectionModel.Route;
import Lab5.Utility.Console;
import Lab5.Utility.LocalDateAdapter;
import Lab5.Utility.LocalDateTimeAdapter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.*;

public class DumpManager {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    private final String fileName;
    private final Console console;


    public DumpManager(String fileName, Console console) {
        if (!(new File(fileName).exists())) {
            fileName = "../" + fileName;
        }
        this.fileName = fileName;
        this.console = console;
    }

    /**
     * Записывает коллекцию в файл.
     */
    public void writeCollection(Collection<Route> collection) {
        try (PrintWriter collectionPrintWriter = new PrintWriter(new File(fileName))) {
            System.out.println(collection);
            collectionPrintWriter.println(gson.toJson(collection));
            console.println("Коллекция успешна сохранена в файл!");
        } catch (IOException exception) {
            console.printError("Загрузочный файл не может быть открыт!");
        }

        }


    /**
     * Считывает коллекцию из файл.
     */
    public void readCollection(Collection<Route> collection) {
        if (fileName != null && !fileName.isEmpty()) {
            try (var fileReader = new FileReader(fileName)) {
                var reader = new  BufferedReader(fileReader);
                var jsonString = new StringBuilder();

                String line;
                while((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        jsonString.append(line);
                    }
                }

                if (jsonString.isEmpty()) {
                    jsonString = new StringBuilder("[]");
                }

                var collectionType = new TypeToken<LinkedList<Route>>() {}.getType();
                var collectionFromFile = (LinkedList<Route>) gson.fromJson(jsonString.toString(), collectionType);

                collection.addAll(collectionFromFile);
                console.println("Коллекция успешна загружена!");



            } catch (FileNotFoundException exception) {
                console.printError("Загрузочный файл не найден!");
            } catch (NoSuchElementException exception) {
                console.printError("Загрузочный файл пуст!");
            } catch (JsonParseException exception) {
                console.printError("В загрузочном файле не обнаружена необходимая коллекция!");
            } catch (IllegalStateException | IOException exception) {
                console.printError("Непредвиденная ошибка!");
                System.exit(0);
            }
        } else {
            console.printError("Аргумент командной строки с загрузочным файлом не найден!");
        }
    }
}