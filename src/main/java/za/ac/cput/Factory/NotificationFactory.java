package za.ac.cput.Factory;

import za.ac.cput.Domain.Notification;

import java.time.LocalDateTime;

/**
 * Factory class for creating Notification objects using the Builder Pattern.
 */
public class NotificationFactory {
    public static Notification createNotification(String notificationID, String message, String studentID, String eventID) {
        if (notificationID == null || message == null || studentID == null || eventID == null) {
            return null; // Ensures no null values
        }

        return new Notification.Builder()
                .setNotificationID(notificationID)
                .setMessage(message)
                .setStudentID(studentID)
                .setEventID(eventID)
                .setTimestamp(LocalDateTime.now()) // Auto-set timestamp
                .build();
    }
}