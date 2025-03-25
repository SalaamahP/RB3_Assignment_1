package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Notification;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void testCreateNotification_Success() {
        Notification notification = NotificationFactory.createNotification(
                "N001", "Event Reminder", "S123", "E789");

        assertNotNull(notification, "Notification should not be null");
        assertEquals("N001", notification.getNotificationID(), "Notification ID should match");
        assertEquals("Event Reminder", notification.getMessage(), "Message should match");
        assertEquals("S123", notification.getStudentID(), "Student ID should match");
        assertEquals("E789", notification.getEventID(), "Event ID should match");
        assertNotNull(notification.getTimestamp(), "Timestamp should be set");
    }

    @Test
    void testCreateNotification_Failure_NullValues() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> NotificationFactory.createNotification(null, "Test Message", "S123", "E789")
        );

        assertEquals("All fields must be provided and cannot be null.", exception.getMessage());
    }
}
