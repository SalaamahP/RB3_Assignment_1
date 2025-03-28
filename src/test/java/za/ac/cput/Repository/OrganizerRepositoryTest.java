/*OrganizerRepositoryTest.java
Organizer Repository Test class
Author: Oratile Precious Phologane (230690939)
Date: 24 March 2025
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Organizer;
import za.ac.cput.Domain.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerRepositoryTest {

    private IOrganizerRepository repository;
    private Organizer organizer;

    @BeforeEach
    void setUp(){
        repository = OrganizerRepository.getRepository();

        organizer = new Organizer.OrganizerBuilder()
                .setOrganizerId("29873")
                .setOrganizerName("Tom")
                .setOrganizerSurname("Hill")
                .setOrganizerEmail("hill@cput.az.za")
                .setOrganizerPhone("0789009025")
                .build();
        repository.create(organizer);

    }

    //clear repo after each test
    @AfterEach
    void tearDown() {
        if (repository instanceof OrganizerRepository){
            ((OrganizerRepository) repository).clear();
        }
    }

    //Test adding an Organizer to list
    @Test
    void createdOrganizer() {
        assertEquals(1, repository.getAllOrganizers().size());

    }

    //Test retrieving an organizer
    @Test
    void readOrganizer() {
        Organizer retrieved = repository.read("29873");
        System.out.println("Retrieved: " + retrieved);
        assertNotNull(retrieved);
        assertEquals("Tom", retrieved.getOrganizerName());
        assertEquals("Hill", retrieved.getOrganizerSurname());
        assertEquals("0789009025", retrieved.getOrganizerPhone());

    }

    //Test updating an organizer's details
    @Test
    void updateOrganizer() {
        //Confirm existing details
        Organizer existingOrganizer = repository.read("29873");
        assertNotNull(existingOrganizer, "Organizer can not be null");
        assertEquals("Tom", existingOrganizer.getOrganizerName());

        Organizer udpatedOrganizer = new Organizer.OrganizerBuilder()
                .setOrganizerId("29873")
                .setOrganizerName("Tom")
                .setOrganizerSurname("Hill")
                .setOrganizerEmail("hilltom@cput.ac.za")
                .setOrganizerPhone("0789009025")
                .build();
        repository.update(udpatedOrganizer);

        //Verify details have been changed
        Organizer retrieved = repository.read("29873");
        assertEquals("Tom", retrieved.getOrganizerName());
        assertEquals("hilltom@cput.ac.za", retrieved.getOrganizerEmail());
        assertEquals("0789009025", retrieved.getOrganizerPhone());
    }

    @Test
        //Test deleting a student
    void deleteOrganizer() {
        boolean deleted = repository.delete("29873");
        assertTrue(deleted);
        assertNull(repository.read("29873"));
    }

    //Test if there's organizer in the list
    @Test
    void getAllOrganizers() {
        List<Organizer> allOrganizers = repository.getAllOrganizers();
        System.out.println("All organizers: " + allOrganizers);
        assertFalse(allOrganizers.isEmpty());
    }
}
