package za.ac.cput.Factory;

import rsvp.domain.Rsvp;
import java.util.UUID;

public class RsvpFactory {

    public static Rsvp createRsvp(String customerName, String event, int numberOfGuests) {
        return new Rsvp.Builder()
                .setId(UUID.randomUUID().toString()) // Generates a unique ID
                .setCustomerName(customerName)
                .setEvent(event)
                .setNumberOfGuests(numberOfGuests)
                .build();
    }
}
