package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Event;

import static org.junit.jupiter.api.Assertions.*;

public class EventFactoryTest {

    @Test
    public void testCreateEvent() {
        Event event = EventFactory.createEvent(
                "EV001", "Career Fair", "Job opportunities",
                "2025-08-30 10:00", "Main Hall", "ORG001");

        assertNotNull(event);
        assertEquals("Career Fair", event.getTitle());
        System.out.println(event);
    }
}
