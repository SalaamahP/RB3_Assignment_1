/*OrganizerFactory.java
Organizer Factory class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */

package za.ac.cput.Factory;

import za.ac.cput.Domain.Organizer;
import za.ac.cput.Util.Helper;

//Creates a new Organizer object using the Builder pattern.
public class OrganizerFactory {
    public static Organizer createOrganizer(String organizerId, String organizerName, String organizerSurname, String organizerEmail, String organizerPhone) {
        if (organizerId == null || organizerId.isEmpty() || organizerName == null || organizerName.isEmpty() || organizerSurname == null || organizerSurname.isEmpty()
                || organizerEmail == null || organizerEmail.isEmpty() || organizerPhone == null|| organizerPhone.isEmpty()) {
            System.out.println("Invalid input: All fields are required");
            return null;
        }
        if (!Helper.isValidEmail(organizerEmail)) {
            System.out.println("Invalid email address: " + organizerEmail);
            return null;
        }
        if (!Helper.isValidPhone(organizerPhone)) {
            System.out.println("Invalid phone number: " + organizerPhone);
            return null;
        }

        return new Organizer.OrganizerBuilder()
                .setOrganizerId(organizerId)
                .setOrganizerName(organizerName)
                .setOrganizerSurname(organizerSurname)
                .setOrganizerEmail(organizerEmail)
                .setOrganizerPhone(organizerPhone)
                .build();
    }
}
