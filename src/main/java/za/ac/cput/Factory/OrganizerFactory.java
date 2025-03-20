/*OrganizerFactory.java
Organizer Factory class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Organizer;

public class OrganizerFactory {
    public static Organizer createOrganizer(String organizerId, String organizerName, String organizerSurname, String organizerEmail, String organizerPhone) {
        if (organizerId == null || organizerName == null || organizerSurname == null || organizerEmail == null || organizerPhone == null) {
            return null;
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
