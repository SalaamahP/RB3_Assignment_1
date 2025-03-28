package za.ac.cput.Domain;

import java.util.Objects;

/**
 * Represents an RSVP entry linked to a student and an event.
 */
public class Rsvp {
    private final String rsvpID;
    private final String studentID;
    private final String eventID;
    private final Status status;

    /**
     * Enum representing RSVP statuses.
     */
    public enum Status {
        CONFIRMED, PENDING, DECLINED
    }

    /**
     * Private constructor using Builder pattern.
     */
    private Rsvp(Builder builder) {
        this.rsvpID = builder.rsvpID;
        this.studentID = builder.studentID;
        this.eventID = builder.eventID;
        this.status = builder.status;
    }

    public String getRsvpID() {
        return rsvpID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getEventID() {
        return eventID;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Builder class for creating RSVP objects.
     */
    public static class Builder {
        private String rsvpID;
        private String studentID;
        private String eventID;
        private Status status;

        public Builder setRsvpID(String rsvpID) {
            this.rsvpID = rsvpID;
            return this;
        }

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setEventID(String eventID) {
            this.eventID = eventID;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Rsvp build() {
            return new Rsvp(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return rsvpID.equals(rsvp.rsvpID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rsvpID);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "rsvpID='" + rsvpID + '\'' +
                ", studentID='" + studentID + '\'' +
                ", eventID='" + eventID + '\'' +
                ", status=" + status +
                '}';
    }
}
