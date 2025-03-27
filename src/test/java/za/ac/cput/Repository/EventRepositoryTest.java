package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Event;
import za.ac.cput.Factory.EventFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * EventRepositoryTest - Unit tests for EventRepository
 * Author: Nobahle Vuyiswa Nzimande (222641533)
 * Date: 26 March 2025
 *
 * This class tests the CRUD functionality of the EventRepository class.
 */
class EventRepositoryTest {
    private EventRepository repository; // Repository instance
    private Event event; // Sample event object

    @BeforeEach
    void setUp() {
        repository = EventRepository.getRepository(); // Get singleton instance
        event = EventFactory.createEvent(
                "EV001", "Career Fair", "Job opportunities",
                "2025-08-30 10:00", "Main Hall", "ORG001"
        );
    }

    @Test
    void testCreate() {
        Event created = repository.create(event);
        assertNotNull(created, "Created event should not be null.");
        assertEquals("EV001", created.getEventID(), "Event ID should match.");
        System.out.println("Create Test Passed: " + created);
    }

    @Test
    void testRead() {
        repository.create(event); //Add event before reading
        Event found = repository.read("EV001");
        assertNotNull(found, "Event should be found in the repository.");
        assertEquals("Career Fair", found.getTitle(), "Event title should match.");
        System.out.println("Read Test Passed: " + found);
    }

    @Test
    void testUpdate() {
        repository.create(event); // Add event first

        // Create an updated version of the event
        Event updatedEvent = new Event.Builder()
                .setEventID("EV001")
                .setTitle("Updated Career Fair")
                .setDescription("Updated Job Opportunities")
                .setDateTime("2025-09-01 12:00")
                .setLocation("Updated Hall")
                .setOrganizerID("ORG001")
                .build();

        Event result = repository.update(updatedEvent); // Update event in repository
        assertNotNull(result, "Updated event should not be null.");
        assertEquals("Updated Career Fair", result.getTitle(), "Title should be updated.");
        System.out.println("Update Test Passed: " + result);
    }

    @Test
    void testDelete() {
        repository.create(event); // Add event first
        boolean deleted = repository.delete("EV001"); // Delete event by ID
        assertTrue(deleted, "Event should be deleted successfully.");
        System.out.println("Delete Test Passed: Event Deleted");
    }


    @Test
    void testGetAll() {
        repository.create(event); // Add event before fetching all
        List<Event> eventList = repository.getAll(); // Retrieve all events
        assertFalse(eventList.isEmpty(), "Event list should not be empty.");
        System.out.println("GetAll Test Passed: " + eventList);
    }
}
