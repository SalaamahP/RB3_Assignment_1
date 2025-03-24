package za.ac.cput.Domain;

/**
 * Represents an RSVP entity with details such as customer name, event, and number of guests.
 */
public class Rsvp {
    private String id;
    private String customerName;
    private String event;
    private int numberOfGuests;

    /**
     * Private constructor to enforce the use of the Builder pattern.
     */
    private Rsvp(Builder builder) {
        this.id = builder.id;
        this.customerName = builder.customerName;
        this.event = builder.event;
        this.numberOfGuests = builder.numberOfGuests;
    }

    // Getters for retrieving RSVP details
    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEvent() {
        return event;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Builder class to create immutable Rsvp objects.
     */
    public static class Builder {
        private String id;
        private String customerName;
        private String event;
        private int numberOfGuests;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
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

        /**
         * Builds and returns an instance of Rsvp.
         */
        public Rsvp build() {
            return new Rsvp(this);
        }
    }

    /**
     * Checks if two RSVP objects are equal based on their unique ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return id.equals(rsvp.id);
    }

    /**
     * Generates a unique hash code for an RSVP object based on its ID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a string representation of the RSVP object.
     */
    @Override
    public String toString() {
        return "Rsvp{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", event='" + event + '\'' +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}