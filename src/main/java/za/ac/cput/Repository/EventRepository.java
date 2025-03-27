package za.ac.cput.Repository;

import za.ac.cput.Domain.Event;
import java.util.*;

public class EventRepository implements IEventRepository {

    private static EventRepository repository = null;
    private final Map<String, Event> eventDB;// HashMap to store events

    // Private constructor to enforce Singleton Pattern
    private EventRepository() {
        eventDB = new HashMap<>();
    }

    public static EventRepository getRepository() { //Ensures only one instance of EventRepository exists (Singleton Pattern).
        if (repository == null)
            repository = new EventRepository();
        return repository;
    }

    @Override
    public Event create(Event event) { //Adds a new event to the repository.
        eventDB.put(event.getEventID(), event);
        return event;
    }

    @Override
    public Event read(String id) {
        return eventDB.get(id);
    } //Retrieves an event by its ID.

    @Override
    public Event update(Event event) { //Updates an existing event if it exists in the repository.
        if (eventDB.containsKey(event.getEventID())) {
            eventDB.put(event.getEventID(), event);
            return event;
        }
        return null;
    }

    @Override
    public boolean delete(String id) { //Deletes an event from the repository using its ID.
        return eventDB.remove(id) != null;
    }

    @Override
    public List<Event> getAll() {
        return new ArrayList<>(eventDB.values());
    } //Retrieves all events in the repository.
}
