package za.ac.cput;

import za.ac.cput.Domain.Student;
import za.ac.cput.Domain.Organizer;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Factory.OrganizerFactory;

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

       Organizer organizer = OrganizerFactory.createOrganizer("67339", "Willy",
               "Simon", "simon@cput.ac.za", "0839111450");
        if (organizer != null) {
            System.out.println(organizer.toString());
        } else {
            System.out.println("Organizer could not be created due to invalid input");
        }

    }
}