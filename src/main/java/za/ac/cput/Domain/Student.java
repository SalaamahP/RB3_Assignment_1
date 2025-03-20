/*Student.java
Student model class
Author: Salaamah Peck (230207170)
Date:15 March 2025
 */
package za.ac.cput.Domain;

public class Student {
    private final String studentID;
    private final String studentName;
    private final String studentSurname;
    private final String studentEmail;
    private final String studentPhone;

    private Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        this.studentName = builder.studentName;
        this.studentSurname = builder.studentSurname;
        this.studentEmail = builder.studentEmail;
        this.studentPhone = builder.studentPhone;

    }

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

    public static class StudentBuilder {
        private String studentID;
        private String studentName;
        private String studentSurname;
        private String studentEmail;
        private String studentPhone;

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
