/*IStudentRepository.java
IStudent Repository class
Author: Salaamah Peck (230207170)
Date:15 March 2025
 */
package za.ac.cput.Repository;

import za.ac.cput.Domain.Student;

import java.util.List;

public interface IStudentRepository extends IRepository <Student, String> {
    List<Student> getAll();
}
