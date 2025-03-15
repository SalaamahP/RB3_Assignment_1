/*StudentFactory.java
Student Factory class
Author: Salaamah Peck (230207170)
Date:15 March 2025
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Student;

public class StudentFactory {
    public static Student createStudent(String studentID, String studentName, String studentSurname, String studentEmail, String studentPhone) {
        if (studentID == null || studentName == null || studentSurname == null || studentEmail == null || studentPhone == null){
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
