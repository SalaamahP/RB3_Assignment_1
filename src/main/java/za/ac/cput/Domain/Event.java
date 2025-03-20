package za.ac.cput.Domain;

/*
 * Event.java
 * Entity for Event using Builder Pattern
 * Author: Nobahle Vuyiswa Nzimande (222641533)
 * Date: 17 March 2025
 */

public class Event {
    private String eventID;
    private String title;
    private String description;
    private String dateTime;
    private String location;
    private String organizerID;

    private Event(Builder builder) {
        this.eventID = builder.eventID;
        this.title = builder.title;
        this.description = builder.description;
        this.dateTime = builder.dateTime;
        this.location = builder.location;
        this.organizerID = builder.organizerID;
    }

    public String getEventID() { return eventID; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDateTime() { return dateTime; }
    public String getLocation() { return location; }
    public String getOrganizerID() { return organizerID; }

    @Override
    public String toString() {
        return "Event{" +
                "eventID='" + eventID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", location='" + location + '\'' +
                ", organizerID='" + organizerID + '\'' +
                '}';
    }

    public static class Builder {
        private String eventID;
        private String title;
        private String description;
        private String dateTime;
        private String location;
        private String organizerID;

        public Builder setEventID(String eventID) {
            this.eventID = eventID;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDateTime(String dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setOrganizerID(String organizerID) {
            this.organizerID = organizerID;
            return this;
        }

        public Event build() {
            return new Event(this);
        }

        public Builder copy(Event event) {
            this.eventID = event.eventID;
            this.title = event.title;
            this.description = event.description;
            this.dateTime = event.dateTime;
            this.location = event.location;
            this.organizerID = event.organizerID;
            return this;
        }
    }
}