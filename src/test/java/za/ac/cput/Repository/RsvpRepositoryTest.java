package za.ac.cput.Repository;

import za.ac.cput.Domain.Rsvp;
import za.ac.cput.Factory.RsvpFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class RsvpRepositoryTest {
    private RsvpRepository repository;
    private Rsvp testRsvp;

    @BeforeEach
    void setUp() {
        repository = RsvpRepository.getInstance(); // Ensure singleton instance
        testRsvp = RsvpFactory.createRsvp("S12345", "E67890", "Confirmed");
        assertNotNull(testRsvp);
        repository.create(testRsvp);
    }

    @Test
    void testCreate() {
        Rsvp rsvp = RsvpFactory.createRsvp("S67890", "E12345", "Pending");
        Rsvp created = repository.create(rsvp);

        assertNotNull(created);
        assertEquals(rsvp.getRsvpID(), created.getRsvpID());
        assertEquals("S67890", created.getStudentID());
        assertEquals("E12345", created.getEventID());
        assertEquals("Pending", created.getStatus());
    }

    @Test
    void testRead_Success() {
        Rsvp found = repository.read(testRsvp.getRsvpID());
        assertNotNull(found);
        assertEquals(testRsvp.getRsvpID(), found.getRsvpID());
    }

    @Test
    void testRead_Fail() {
        Rsvp found = repository.read("NonExistentID");
        assertNull(found, "Reading a non-existent RSVP should return null.");
    }

    @Test
    void testUpdate_Success() {
        Rsvp updatedRsvp = new Rsvp.Builder()
                .setRsvpID(testRsvp.getRsvpID())
                .setStudentID(testRsvp.getStudentID())
                .setEventID(testRsvp.getEventID())
                .setStatus("Cancelled") // Change status
                .build();

        Rsvp result = repository.update(updatedRsvp);

        assertNotNull(result);
        assertEquals("Cancelled", result.getStatus());
    }

    @Test
    void testUpdate_Fail() {
        Rsvp nonExistingRsvp = new Rsvp.Builder()
                .setRsvpID("FakeID")
                .setStudentID("S99999")
                .setEventID("E99999")
                .setStatus("Pending")
                .build();

        Rsvp result = repository.update(nonExistingRsvp);
        assertNull(result, "Updating a non-existent RSVP should return null.");
    }

    @Test
    void testDelete_Success() {
        boolean deleted = repository.delete(testRsvp.getRsvpID());
        assertTrue(deleted, "RSVP should be deleted successfully.");
        assertNull(repository.read(testRsvp.getRsvpID()), "Deleted RSVP should no longer exist.");
    }

    @Test
    void testDelete_Fail() {
        boolean deleted = repository.delete("NonExistentID");
        assertFalse(deleted, "Deleting a non-existent RSVP should return false.");
    }

    @Test
    void testGetAll() {
        List<Rsvp> allRsvps = repository.getAll();
        assertFalse(allRsvps.isEmpty(), "Repository should not be empty after inserting an RSVP.");
    }
}
