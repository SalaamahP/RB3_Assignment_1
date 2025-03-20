package za.ac.cput.Repository;

import za.ac.cput.Domain.Event;
import java.util.*;

public class EventRepository implements IEventRepository {

    private static EventRepository repository = null;
    private final Map<String, Event> eventDB;

    private EventRepository() {
        eventDB = new HashMap<>();
    }

    public static EventRepository getRepository() {
        if (repository == null)
            repository = new EventRepository();
        return repository;
    }

    @Override
    public Event create(Event event) {
        eventDB.put(event.getEventID(), event);
        return event;
    }

    @Override
    public Event read(String id) {
        return eventDB.get(id);
    }

    @Override
    public Event update(Event event) {
        if (eventDB.containsKey(event.getEventID())) {
            eventDB.put(event.getEventID(), event);
            return event;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return eventDB.remove(id) != null;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<>(eventDB.values());
    }
}
