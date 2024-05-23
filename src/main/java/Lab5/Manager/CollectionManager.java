package Lab5.Manager;


import com.google.common.collect.Iterables;
import Lab5.CollectionModel.Route;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private long currentId = 1;
    private final ArrayDeque<String> logStack = new ArrayDeque<String>();
    private final DumpManager dumpManager;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final Map<Long, Route> routes = new HashMap<>();
    private final LinkedList<Route> collection = new LinkedList<Route>();

    public CollectionManager(DumpManager dumpManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.dumpManager = dumpManager;
    }

    public LinkedList<Route> getCollection() {
        return collection;
    }

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    public long getFreeId() {
        while (byId(currentId) != null)
            if (++currentId < 0)
                currentId = 1;
        return currentId;
    }
    public Route byId(Long id) { return routes.get(id); }

    public void add(Route r) {
        if (isСontain(r)) return;
        routes.put(r.getId(), r);
        collection.add(r);
    }

    public boolean loadCollection() {
        routes.clear();
        dumpManager.readCollection(collection);
        lastInitTime = LocalDateTime.now();
        for (var e : collection)
            if (byId(e.getId()) != null) {
                collection.clear();
                return false;
            } else {
                if (e.getId()>currentId) currentId = e.getId();
                routes.put(e.getId(), e);
            }

        return true;
    }

    public boolean isСontain(Route r) { return r == null || byId(r.getId()) != null; }

    public void addLog(String cmd, boolean isFirst) {
        if (isFirst)
            logStack.push("+");
        if (!cmd.isEmpty())
            logStack.push(cmd);
    }

    public void saveCollection() {
        dumpManager.writeCollection(collection);
        lastSaveTime = LocalDateTime.now();
    }

    public String sortByDistanceDown(){
        collection.sort(Comparator.comparingDouble(Route::getDistance).reversed());
        for (Route r: collection){
            System.out.println(" id : " + r.getId() + " | дистанция: " +r.getDistance() );
        }
        return "";
    }

    public String unique(){
        Set<Route> uniqueValues = new HashSet<>(collection);

        for (Route r: uniqueValues) {
            System.out.println(r.getDistance());
        }
        return "";
    }

    public void remove(long id) {
        var a = byId(id);
        if (a == null) return;
        routes.remove(a.getId());
        collection.remove(a);
    }

    public Route getLast() {
        if (collection.isEmpty()) return null;
        return Iterables.getLast(collection);
    }

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";
        var last = getLast();

        StringBuilder info = new StringBuilder();
        for (Route r: collection) {
            info.append(r);
            if (r != last) info.append("\n\n");
        }
        return info.toString();
    }
}
