package za.ac.cput.Factory;

import za.ac.cput.Domain.Rsvp;

import java.util.UUID;

/**
 * Factory class for creating RSVP objects.
 */
public class RsvpFactory {

    /**
     * Creates a valid RSVP entry.
     *
     * @param studentID The ID of the student making the RSVP.
     * @param eventID The ID of the event.
     * @param status The RSVP status (e.g., "Confirmed", "Pending").
     * @return A valid Rsvp object or null if input is invalid.
     */
    public static Rsvp createRsvp(String studentID, String eventID, String status) {
        // Validate inputs
        if (studentID == null || eventID == null || status == null ||
                studentID.trim().isEmpty() || eventID.trim().isEmpty() || status.trim().isEmpty()) {
            return null; // Ensure valid input
        }

        return new Rsvp.Builder()
                .setRsvpID(UUID.randomUUID().toString()) // Generates a unique RSVP ID
                .setStudentID(studentID)
                .setEventID(eventID)
                .setStatus(status.trim()) // Trim status to remove leading/trailing spaces
                .build();
    }
}
