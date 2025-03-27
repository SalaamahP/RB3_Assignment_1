package za.ac.cput;

import za.ac.cput.Domain.Student;
import za.ac.cput.Factory.StudentFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student = StudentFactory.createStudent(
                "12345",
                "John Doe",
                "Smith",
                "johndoe@gmail.com",
                "0814565858"
        );
        if (student != null) {
            System.out.println(student.toString());
        } else {
            System.out.println("Student could not be created due to invalid input");
        }

    }
}