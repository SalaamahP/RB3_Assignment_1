/*Organizer.java
Organizer model class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */
package za.ac.cput.Domain;
//Represent an Organizer responsible for the event creation.
public class Organizer {

    private final String organizerId;  //An id to uniquely identify the event Organizer
    private final String organizerName;  //The name of the event Organizer
    private final String organizerSurname;   //The surname of the organizer
    private final String organizerEmail;   // email of the organizer
    private final String organizerPhone;   // Phone number of the organizer

    // Private constructor to enforce the use of Builder Pattern
    private Organizer(OrganizerBuilder builder) {
        this.organizerId = builder.organizerId;
        this.organizerName = builder.organizerName;
        this.organizerSurname = builder.organizerSurname;
        this.organizerEmail = builder.organizerEmail;
        this.organizerPhone = builder.organizerPhone;

    }
    //Getters for the organizer's attributes
    public String getOrganizerId() {
        return organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public String getOrganizerSurname() {
        return organizerSurname;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    // Converts organizer's object details to a string format
    @Override
    public String toString() {
        return "Organizer{" +
                "organizerId='" + organizerId + '\'' +
                ", organizerName='" + organizerName + '\'' +
                ", organizerSurname='" + organizerSurname + '\'' +
                ", organizerEmail='" + organizerEmail + '\'' +
                ", organizerPhone='" + organizerPhone + '\'' +
                '}';
    }
    // Builder class for organizer
    public static class OrganizerBuilder {
        private String organizerId;
        private String organizerName;
        private String organizerSurname;
        private String organizerEmail;
        private String organizerPhone;

        // Setters for organizer

        public OrganizerBuilder setOrganizerId(String organizerId) {
            this.organizerId = organizerId;
            return this;
        }
        public OrganizerBuilder setOrganizerName(String organizerName) {
            this.organizerName = organizerName;
            return this;
        }
        public OrganizerBuilder setOrganizerSurname(String organizerSurname) {
            this.organizerSurname = organizerSurname;
            return this;
        }
        public OrganizerBuilder setOrganizerEmail(String organizerEmail) {
            this.organizerEmail = organizerEmail;
            return this;
        }
        public OrganizerBuilder setOrganizerPhone(String organizerPhone) {
            this.organizerPhone = organizerPhone;
            return this;
        }
        public Organizer build() {
            return new Organizer(this);
        }
    }
}
