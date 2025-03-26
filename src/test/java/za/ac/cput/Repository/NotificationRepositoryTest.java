package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Notification;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class NotificationRepositoryTest {
    private INotificationRepository repository;
    private Notification notification;

    @BeforeEach
    void setUp() {
        repository = NotificationRepository.getRepository();
        notification = new Notification.Builder()
                .setNotificationID("N001")
                .setMessage("Event Reminder")
                .setStudentID("S123")
                .setEventID("E789")
                .setTimestamp(LocalDateTime.now())
                .build();
        repository.create(notification);
    }

    @Test
    void testCreate() {
        Notification created = repository.create(new Notification.Builder()
                .setNotificationID("N002")
                .setMessage("New Event Alert")
                .setStudentID("S456")
                .setEventID("E999")
                .setTimestamp(LocalDateTime.now())
                .build());

        assertNotNull(created, "Notification should be created");
        assertEquals("N002", created.getNotificationID(), "Notification ID should match");
    }

    @Test
    void testRead() {
        Notification found = repository.read("N001");
        assertNotNull(found, "Notification should be found");
        assertEquals("N001", found.getNotificationID(), "Notification ID should match");
    }

    @Test
    void testUpdate() {
        Notification updated = new Notification.Builder()
                .setNotificationID("N001")
                .setMessage("Updated Event Reminder")
                .setStudentID("S123")
                .setEventID("E789")
                .setTimestamp(LocalDateTime.now())
                .build();

        Notification result = repository.update(updated);
        assertNotNull(result, "Updated notification should not be null");
        assertEquals("Updated Event Reminder", result.getMessage(), "Message should be updated");
    }

    @Test
    void testDelete() {
        boolean deleted = repository.delete("N001");
        assertTrue(deleted, "Notification should be deleted");
        assertNull(repository.read("N001"), "Deleted notification should not exist");
    }

    @Test
    void testGetAll() {
        assertFalse(repository.getAll().isEmpty(), "Repository should not be empty");
    }
}
