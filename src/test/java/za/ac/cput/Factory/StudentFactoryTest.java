/*StudentFactoryTest.java
Student Factory Test class
Author: Salaamah Peck (230207170)
Date: 23 March 2025
 */

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Student;
import za.ac.cput.Util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    @Test
    //Test to verify the creation using builder pattern
    void testCreateStudent_Pass() {
        Student student = StudentFactory.createStudent("12345", "John", "Cena", "jcena@mycput.ac.za", "0811234567");
        assertNotNull(student);
        assertEquals("John", student.getStudentName());
        assertEquals("Cena", student.getStudentSurname());
        assertEquals("jcena@mycput.ac.za", student.getStudentEmail());
        assertEquals("0811234567", student.getStudentPhone());
        assertEquals("12345", student.getStudentID());

    }

    @Test
    //Verify null details are not accepted
    void testCreateStudent_Fail() {
            Student student = StudentFactory.createStudent(null, "John", "Cena", "jcenta@mycput.ac.za", "0811234567");
            assertNull(student);
        }

        @Test
    void isValidEmail() {
        assertTrue(Helper.isValidEmail("jcena@mycput.ac.za"));
        }

        @Test
    void isValidPhone() {
        assertTrue(Helper.isValidPhone("0811234567"));
        }
        @Test
    void isNotValidEmail() {
        assertFalse(Helper.isValidEmail("jcena@gmail"));
        }
        @Test
    void isNotValidPhone() {
        assertFalse(Helper.isValidPhone("08112"));
        }
    }

