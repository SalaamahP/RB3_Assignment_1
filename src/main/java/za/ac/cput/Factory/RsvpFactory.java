package za.ac.cput.Factory; // Correct package naming convention

import Rsvp.Domain.Rsvp;
import za.ac.cput.Domain.Student; // Correct import for Student class
import java.util.UUID;

/**
 * Factory class for creating RSVP objects.
 */
public class RsvpFactory {

    /**
     * Creates a valid RSVP entry.
     *
     * @param student The student making the RSVP.
     * @param event The event name.
     * @param numberOfGuests The number of guests accompanying the student.
     * @return A valid Rsvp object or null if input is invalid.
     */
    public static Rsvp createRsvp(Student student, String event, int numberOfGuests) {
        // Validate inputs
        if (student == null || event == null || event.trim().isEmpty() || numberOfGuests < 0) {
            return null; // Ensure valid input
        }

        return new Rsvp.Builder()
                .setId(UUID.randomUUID().toString()) // Generates a unique RSVP ID
                .setStudent(student)
                .setEvent(event.trim()) // Trim event name to remove leading/trailing spaces
                .setNumberOfGuests(numberOfGuests)
                .build();
    }
}
