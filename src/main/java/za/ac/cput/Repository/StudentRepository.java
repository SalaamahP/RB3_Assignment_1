/*StudentRepository.java
Student Repository class
Author: Salaamah Peck (230207170)
Date:15 March 2025
 */
package za.ac.cput.Repository;

import za.ac.cput.Domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static IStudentRepository repository = null;
        private final List<Student> studentList;

    private StudentRepository(){
        studentList = new ArrayList<Student>();
    }
    public static IStudentRepository getRepository(){
        if(repository == null){
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentList);
    }

    @Override
    public Student create(Student student) {
     if (student != null) {
         studentList.add(student);
         return student;
        }
        return null;
    }

    @Override
    public Student read(String studentId) {
        for(Student student : studentList){
            if(student.getStudentID().equals(studentId)){
                return student;
            }

        }
        return null;
    }

    @Override
    public Student update(Student updatedStudent) {
        for(int i=0; i<studentList.size(); i++){
            System.out.println("Checking student ID: " + studentList.get(i).getStudentID());
            if(studentList.get(i).getStudentID().equals(updatedStudent.getStudentID())){
                studentList.set(i, updatedStudent);
                System.out.println("Student Updated: " + updatedStudent.getStudentID());
                return updatedStudent;
             }

        }
        System.out.println("Student not found: " + updatedStudent.getStudentID());
        return null;
    }

    @Override
    public boolean delete(String studentId) {
        for(int i = 0 ; i < studentList.size() ; i++){
            if(studentList.get(i).getStudentID().equals(studentId)){
                studentList.remove(i);
                return true;
            }
        }

        return false;
    }
}
