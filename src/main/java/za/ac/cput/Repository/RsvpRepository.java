/*RsvpRepository.java
Rsvp class
Author: Patience Phakathi (222228431)
 */
package za.ac.cput.Repository;

import za.ac.cput.Domain.Rsvp;
import za.ac.cput.Domain.Rsvp.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of IRsvpRepository using an in-memory list.
 */
public class RsvpRepository implements IRsvpRepository {
    private final List<Rsvp> rsvpList = new ArrayList<>();
    private static RsvpRepository repository = null;

    // Private constructor for Singleton pattern
    private RsvpRepository() {}

    /**
     * Returns the singleton instance of RsvpRepository.
     *
     * @return the singleton instance.
     */
    public static RsvpRepository getInstance() {
        if (repository == null) {
            repository = new RsvpRepository();
        }
        return repository;
    }

    @Override
    public Rsvp create(Rsvp rsvp) {
        if (rsvp != null) {
            rsvpList.add(rsvp);
            return rsvp;
        }
        return null;
    }

    @Override
    public Rsvp read(String id) {
        return rsvpList.stream()
                .filter(r -> r.getRsvpID().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Rsvp update(Rsvp updatedRsvp) {
        if (updatedRsvp != null) {
            Rsvp existingRsvp = read(updatedRsvp.getRsvpID());
            if (existingRsvp != null) {
                rsvpList.remove(existingRsvp);
                rsvpList.add(updatedRsvp);
                return updatedRsvp;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Rsvp rsvp = read(id);
        if (rsvp != null) {
            rsvpList.remove(rsvp);
            return true;
        }
        return false;
    }

    @Override
    public List<Rsvp> getAll() {
        return new ArrayList<>(rsvpList); // Return a copy to protect data integrity
    }

    /**
     * Retrieves RSVPs based on their status.
     *
     * @param status The status to filter by.
     * @return A list of RSVPs with the given status.
     */
    public List<Rsvp> getByStatus(Status status) {
        return rsvpList.stream()
                .filter(r -> r.getStatus() == status)
                .collect(Collectors.toList());
    }
}
