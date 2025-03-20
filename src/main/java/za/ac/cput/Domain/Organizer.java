/*Organizer.java
Organizer model class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */
package za.ac.cput.Domain;

public class Organizer {
    private final String organizerId;
    private final String organizerName;
    private final String organizerSurname;
    private final String organizerEmail;
    private final String organizerPhone;

    private Organizer(OrganizerBuilder builder) {
        this.organizerId = builder.organizerId;
        this.organizerName = builder.organizerName;
        this.organizerSurname = builder.organizerSurname;
        this.organizerEmail = builder.organizerEmail;
        this.organizerPhone = builder.organizerPhone;

    }

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

    public static class OrganizerBuilder {
        private String organizerId;
        private String organizerName;
        private String organizerSurname;
        private String organizerEmail;
        private String organizerPhone;

        public OrganizerBuilder organizerId(String organizerId) {
            this.organizerId = organizerId;
            return this;
        }
        public OrganizerBuilder organizerName(String organizerName) {
            this.organizerName = organizerName;
            return this;
        }
        public OrganizerBuilder organizerSurname(String organizerSurname) {
            this.organizerSurname = organizerSurname;
            return this;
        }
        public OrganizerBuilder organizerEmail(String organizerEmail) {
            this.organizerEmail = organizerEmail;
            return this;
        }
        public OrganizerBuilder organizerPhone(String organizerPhone) {
            this.organizerPhone = organizerPhone;
            return this;
        }
        public Organizer build() {
            return new Organizer(this);
        }
    }
}
