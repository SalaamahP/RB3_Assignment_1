package za.ac.cput.Factory;

import za.ac.cput.Domain.Rsvp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RsvpFactoryTest {

    @Test
    void testCreateRsvp_Success() {
        Rsvp rsvp = RsvpFactory.createRsvp("S12345", "E67890", "Confirmed");
        assertNotNull(rsvp);
        assertNotNull(rsvp.getRsvpID()); // Ensure ID is generated
        assertEquals("S12345", rsvp.getStudentID());
        assertEquals("E67890", rsvp.getEventID());
        assertEquals("Confirmed", rsvp.getStatus());
    }

    @Test
    void testCreateRsvp_Fail_InvalidInputs() {
        Rsvp rsvp1 = RsvpFactory.createRsvp(null, "E67890", "Confirmed");
        Rsvp rsvp2 = RsvpFactory.createRsvp("S12345", "", "Confirmed");
        Rsvp rsvp3 = RsvpFactory.createRsvp("S12345", "E67890", null);

        assertNull(rsvp1, "Factory should return null when studentID is null.");
        assertNull(rsvp2, "Factory should return null when eventID is empty.");
        assertNull(rsvp3, "Factory should return null when status is null.");
    }
}
