package za.ac.cput.Entity;

import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.NotificationFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the Notification class.
 */
class NotificationTest {

    @Test
    void testNotificationBuilder() {
        Notification notification = new Notification.Builder()
                .setNotificationID("N001")
                .setMessage("Event Reminder: Meeting at 5 PM")
                .setStudentID("S12345")
                .setEventID("E56789")
                .setTimestamp(LocalDateTime.now())
                .build();

        assertNotNull(notification);
        assertEquals("N001", notification.getNotificationID());
        assertEquals("Event Reminder: Meeting at 5 PM", notification.getMessage());
        assertEquals("S12345", notification.getStudentID());
        assertEquals("E56789", notification.getEventID());
        assertNotNull(notification.getTimestamp());
    }

    @Test
    void testNotificationFactory() {
        Notification notification = NotificationFactory.createNotification(
                "N002",
                "Workshop Alert: AI Seminar at 3 PM",
                "S54321",
                "E98765"
        );

        assertNotNull(notification);
        assertEquals("N002", notification.getNotificationID());
        assertEquals("Workshop Alert: AI Seminar at 3 PM", notification.getMessage());
        assertEquals("S54321", notification.getStudentID());
        assertEquals("E98765", notification.getEventID());
        assertNotNull(notification.getTimestamp());
    }

    @Test
    void testInvalidNotificationCreation() {
        Notification notification = NotificationFactory.createNotification(null, "Test Message", "S123", "E789");
        assertNull(notification); // Should return null due to invalid input
    }

    @Test
    void testSendToStudent() {
        Notification notification = new Notification.Builder()
                .setNotificationID("N003")
                .setMessage("Assignment Deadline Extended")
                .setStudentID("S11111")
                .setEventID("E22222")
                .build();

        assertDoesNotThrow(notification::sendToStudent); // Ensures no exception is thrown
    }

    @Test
    void testSendToAll() {
        Notification notification = new Notification.Builder()
                .setNotificationID("N004")
                .setMessage("Classroom Change Notification")
                .setStudentID("S99999")
                .setEventID("E33333")
                .build();

        assertDoesNotThrow(notification::sendToAll); // Ensures no exception is thrown
    }
}