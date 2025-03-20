package za.ac.cput.Repository;

import za.ac.cput.Domain.Event;
import java.util.List;

public interface IEventRepository {
    Event create(Event event);
    Event read(String id);
    Event update(Event event);
    boolean delete(String id);
    List<Event> getAll();
}
