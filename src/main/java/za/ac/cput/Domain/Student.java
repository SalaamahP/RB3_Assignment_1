/*Student.java
Student model class
Author: Salaamah Peck (230207170)
Date:15 March 2025
 */
package za.ac.cput.Domain;

/**
 * Represents a Student that is interested in an event.
 */
public class Student {
    private final String studentID; // Uniquely identifies a student
    private final String studentName; //Name of student
    private final String studentSurname; //Surname of student
    private final String studentEmail; // Email of student
    private final String studentPhone; // Cellphone number of student

    private Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        this.studentName = builder.studentName;
        this.studentSurname = builder.studentSurname;
        this.studentEmail = builder.studentEmail;
        this.studentPhone = builder.studentPhone;

    }
    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentPhone() {
        return studentPhone;
    }
    

    @Override
    public String toString() {
        return "Student{" +
                "studentID:'" + studentID + '\'' +
                ", studentName:'" + studentName + '\'' +
                ", studentSurname:'" + studentSurname + '\'' +
                ", studentEmail:'" + studentEmail + '\'' +
                ", studentPhone:'" + studentPhone + '\'' +
                '}';
    }

    //Builder class
    public static class StudentBuilder {
        private String studentID;
        private String studentName;
        private String studentSurname;
        private String studentEmail;
        private String studentPhone;

        //Setters
        public StudentBuilder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public StudentBuilder setStudentSurname(String studentSurname) {
            this.studentSurname = studentSurname;
            return this;
        }

        public StudentBuilder setStudentEmail(String studentEmail) {
            this.studentEmail = studentEmail;
            return this;
        }

        public StudentBuilder setStudentPhone(String studentPhone) {
            this.studentPhone = studentPhone;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }

}
