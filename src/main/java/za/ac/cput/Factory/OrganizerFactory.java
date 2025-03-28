/*OrganizerFactory.java
Organizer Factory class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */

package za.ac.cput.Factory;

import za.ac.cput.Domain.Organizer;

public class OrganizerFactory {
    public static Organizer createOrganizer(String organizerId, String organizerName, String organizerSurname, String organizerEmail, String organizerPhone) {
        if (organizerId == null || organizerId.isEmpty() || organizerName == null || organizerName.isEmpty() || organizerSurname == null || organizerSurname.isEmpty()
                || organizerEmail == null || organizerEmail.isEmpty() || organizerPhone == null|| organizerPhone.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: All fields are required");
        }

        return new Organizer.OrganizerBuilder()
                .organizerId(organizerId)
                .organizerName(organizerName)
                .organizerSurname(organizerSurname)
                .organizerEmail(organizerEmail)
                .organizerPhone(organizerPhone)
                .build();
    }
}
