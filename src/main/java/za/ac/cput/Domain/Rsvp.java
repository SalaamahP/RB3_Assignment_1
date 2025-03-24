package za.ac.cput.Domain;

import za.ac.cput.Domain.Student;
import java.util.Objects;


/**
 * Represents an RSVP entry linked to a student and an event.
 */
public class Rsvp {
    private final String id;
    private final Student student;
    private final String event;
    private final int numberOfGuests;

    /**
     * Private constructor using Builder pattern.
     */
    private Rsvp(Builder builder) {
        this.id = builder.id;
        this.student = builder.student;
        this.event = builder.event;
        this.numberOfGuests = builder.numberOfGuests;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public String getEvent() {
        return event;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Builder class for creating RSVP objects.
     */
    public static class Builder {
        private String id;
        private Student student;
        private String event;
        private int numberOfGuests;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setEvent(String event) {
            this.event = event;
            return this;
        }

        public Builder setNumberOfGuests(int numberOfGuests) {
            this.numberOfGuests = numberOfGuests;
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
        return id.equals(rsvp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", event='" + event + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}
