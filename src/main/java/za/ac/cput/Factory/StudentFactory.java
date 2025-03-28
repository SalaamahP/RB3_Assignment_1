/*StudentFactory.java
Student Factory class
Author: Salaamah Peck (230207170)
Date:15 March 2025
 */
package za.ac.cput.Factory;

import za.ac.cput.Domain.Student;
import za.ac.cput.Util.Helper;

/**
 * Creates a new Student object using the Builder pattern.
 */
public class StudentFactory {
    public static Student createStudent(String studentID, String studentName, String studentSurname, String studentEmail, String studentPhone) {
        if (studentID == null || studentName == null || studentSurname == null || studentEmail == null || studentPhone == null){
            System.out.println("Error: One or more fields are null");
            return null;
        }
        if (!Helper.isValidEmail(studentEmail)){
            System.out.println("Error: Invalid email");
            return null;
        }
        if (!Helper.isValidPhone(studentPhone)){
            System.out.println("Error: Invalid phone number");
            return null;
        }
        return new Student.StudentBuilder()
                .setStudentID(studentID)
                .setStudentName(studentName)
                .setStudentSurname(studentSurname)
                .setStudentEmail(studentEmail)
                .setStudentPhone(studentPhone)
                .build();

    }

}
