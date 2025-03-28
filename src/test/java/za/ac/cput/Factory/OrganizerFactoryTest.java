/*OrganizerFactoryTest.java
Organizer Factory Test class
Author: Oratile Precious Phologane (230207170)
Date: 25 March 2025
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Organizer;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Util.Helper;


//Test for successfully creating an Organizer.
public class OrganizerFactoryTest {

    //Test to verify the creation using builder pattern
    @Test
    void testCreateOrganizer_Pass() {
        Organizer organizer = OrganizerFactory.createOrganizer("29873", "Tom", "Hill", "hill@cput.ac.za", "0789009025");
        assertNotNull(organizer);
        assertEquals("29873", organizer.getOrganizerId());
        assertEquals("Tom", organizer.getOrganizerName());
        assertEquals("Hill", organizer.getOrganizerSurname());
        assertEquals("hill@cput.ac.za", organizer.getOrganizerEmail());
        assertEquals("0789009025", organizer.getOrganizerPhone());

    }

    //Verify null/empty details are not accepted
    @Test
    void testCreateOrganizer_Fail() {
        Organizer organizer = OrganizerFactory.createOrganizer("", "Tom", "Hill", "hill@cput.ac.za", "0789009025");
        assertNull(organizer);
    }

    @Test
    void isValidEmail() {
        assertTrue(Helper.isValidEmail("hill@mycput.ac.za"));
    }

    @Test
    void isNotValidEmail() {
        assertFalse(Helper.isValidEmail("hillmycput.ac.za"));
    }

    @Test
    void isValidPhone() {
        assertTrue(Helper.isValidPhone("0789009025"));
    }

    @Test
    void isNotValidPhone() {
        assertFalse(Helper.isValidPhone("789009025"));
    }
}
