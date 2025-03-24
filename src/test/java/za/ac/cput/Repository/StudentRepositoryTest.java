package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentRepositoryTest {

    private IStudentRepository repository;
    private Student student;


    @BeforeEach
    void setUp() {
        repository = StudentRepository.getRepository();

        student = new Student.StudentBuilder()
                .setStudentID("12345")
                .setStudentName("John")
                .setStudentSurname("Cena")
                .setStudentEmail("jcenta@mycput.ac.za")
                .setStudentPhone("0811234567")
                .build();
        repository.create(student);
    }

   @Test
    void createdStudent() {
        assertEquals(1, repository.getAll().size());

   }

   @Test
    void readStudent() {
        Student retrieved = repository.read("12345");
        assertEquals("John", retrieved.getStudentName());
        assertEquals("Cena", retrieved.getStudentSurname());
        assertEquals("0811234567", retrieved.getStudentPhone());

   }

   @Test
    void updateStudent() {

     Student updatedStudent = new Student.StudentBuilder()
             .setStudentID("12345")
             .setStudentName("Jane")
             .setStudentSurname("Cena")
             .setStudentEmail("jcena@gmail.com")
             .setStudentPhone("0814793232")
             .build();
     repository.update(updatedStudent);
     Student retrieved = repository.read("12345");
     assertEquals("Jane", retrieved.getStudentName());
     assertEquals("Cena", retrieved.getStudentSurname());
     assertEquals("0814793232", retrieved.getStudentPhone());

   }

   @Test
    void deleteStudent() {
        boolean deleted = repository.delete("12345");
        assertTrue(deleted);
        assertEquals(0, repository.getAll().size());
   }
}