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
        studentList = new ArrayList<Student>(); //List to store student objects
    }
    public static IStudentRepository getRepository(){ //Singleton implementation
        if(repository == null){
            repository = new StudentRepository();
        }
        return repository;
    }

    @Override
    public List<Student> getAll() { //retrieve all students
        return new ArrayList<>(studentList);
    }

    @Override
    public Student create(Student student) { //create anew student and add to list
     if (student != null) {
         studentList.add(student);
         return student;
        }
        return null;
    }

    @Override
    public Student read(String studentId) { //retrieve a student
        for(Student student : studentList){
            if(student.getStudentID().equals(studentId)){
                return student;
            }

        }
        return null;
    }

    @Override
    public Student update(Student updatedStudent) { //Update student details
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
    public boolean delete(String studentId) { //Delete a student
        for(int i = 0 ; i < studentList.size() ; i++){
            if(studentList.get(i).getStudentID().equals(studentId)){
                studentList.remove(i);
                return true;
            }
        }

        return false;
    }
}
