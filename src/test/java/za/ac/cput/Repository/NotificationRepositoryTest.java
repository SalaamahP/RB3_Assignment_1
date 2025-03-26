package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Notification;
import za.ac.cput.Factory.NotificationFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

//[author] Jaedon Prince, 230473474
//[date] 17/03/2025

class NotificationRepositoryTest {
    private NotificationRepository repository;
    private Notification notification1, notification2;

    @BeforeEach
    void setUp() {
        repository = NotificationRepository.getRepository();

        //Reset repository before each test to prevent duplicates
        repository.clear();

        notification1 = NotificationFactory.createNotification("Message 1", "S123", "E001");
        notification2 = NotificationFactory.createNotification("Message 2", "S456", "E002");

        repository.create(notification1);
        repository.create(notification2);
    }

    @Test
    void testCreate() {
        Notification notification = NotificationFactory.createNotification("New Message", "S789", "E003");
        assertNotNull(repository.create(notification));
    }

    @Test
    void testRead() {
        Notification found = repository.read(notification1.getNotificationID());
        assertNotNull(found);
        assertEquals(notification1.getMessage(), found.getMessage());
    }

    @Test
    void testUpdate() {
        Notification updatedNotification = new Notification.Builder()
                .setNotificationID(notification1.getNotificationID())
                .setMessage("Updated Message")
                .setStudentID(notification1.getStudentID())
                .setEventID(notification1.getEventID())
                .setTimestamp(notification1.getTimestamp())
                .build();

        repository.update(updatedNotification);
        Notification readNotification = repository.read(notification1.getNotificationID());
        assertEquals("Updated Message", readNotification.getMessage());
    }

    @Test
    void testDelete() {
        boolean deleted = repository.delete(notification1.getNotificationID());
        assertTrue(deleted);
        assertNull(repository.read(notification1.getNotificationID()));
    }

    @Test
    void testGetAll() {
        Set<Notification> allNotifications = repository.getAll();
        assertEquals(2, allNotifications.size()); // Ensures only 2 notifications exist
    }
}

