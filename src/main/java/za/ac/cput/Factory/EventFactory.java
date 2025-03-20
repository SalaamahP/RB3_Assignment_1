package za.ac.cput.Factory;

import za.ac.cput.Domain.Event;

/*
 * EventFactory.java
 * Factory for creating Event objects
 * Author: Nobahle Vuyiswa Nzimande (222641533)
 * Date: 17 March 2025
 */

public class EventFactory {
    public static Event createEvent(String eventID, String title, String description,
                                    String dateTime, String location, String organizerID) {
        return new Event.Builder()
                .setEventID(eventID)
                .setTitle(title)
                .setDescription(description)
                .setDateTime(dateTime)
                .setLocation(location)
                .setOrganizerID(organizerID)
                .build();
    }
}