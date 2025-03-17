package za.ac.cput.Entity;

import java.time.LocalDateTime;

/**
 * Represents a notification that is sent to a student about an event.
 */
public class Notification {

    private String notificationID; // Unique identifier for the notification
    private String message; // Content of the notification
    private String studentID; // ID of the student receiving the notification
    private String eventID; // ID of the event linked to the notification
    private final LocalDateTime timestamp; // Time the notification was created

    /**
     * Constructor to initialize a Notification object.
     *
     * @param notificationID Unique identifier for the notification
     * @param message Content of the notification
     * @param studentID ID of the student receiving the notification
     * @param eventID ID of the related event
     */
    public Notification(String notificationID, String message, String studentID, String eventID) {
        this.notificationID = notificationID;
        this.message = message;
        this.studentID = studentID;
        this.eventID = eventID;
        this.timestamp = LocalDateTime.now(); // Sets the timestamp to the current time
    }

    // Getters and Setters
    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Methods
    /**
     * Sends a notification to a specific student.
     */
    public void sendToStudent() {
        System.out.println("Notification sent to student (ID: " + studentID + "): " + message);
    }

    /**
     * Sends a notification to all attendees of a specific event.
     *
     * @param eventID The ID of the event for which notifications are being sent
     */
    public void sendToAll(String eventID) {
        System.out.println("Notification sent to all attendees of event (ID: " + eventID + "): " + message);
    }

    @Override
    public String toString() {
        return "Notification{"
                + "notificationID='" + notificationID + '\''
                + ", message='" + message + '\''
                + ", studentID='" + studentID + '\''
                + ", eventID='" + eventID + '\''
                + ", timestamp=" + timestamp
                + '}';
    }
}
