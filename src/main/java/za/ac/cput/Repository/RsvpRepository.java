package za.ac.cput.Repository;

import rsvp.domain.Rsvp;
import rsvp.repository.RsvpRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of RsvpRepository using an in-memory list.
 */

public class RsvpRepository implements IRsvpRepository{
    private final List<Rsvp> rsvpList = new ArrayList<>();
    private static RsvpRepository repository = null;

    private RsvpRepository() {}

    /**
     * Singleton instance for repository.
     */
    public static RsvpRepository getInstance() {
        if (repository == null) {
            repository = new RsvpRepository();
        }
        return repository;
    }

    @Override
    public Rsvp create(Rsvp rsvp) {
        rsvpList.add(rsvp);
        return rsvp;
    }

    @Override
    public Rsvp read(String id) {
        return rsvpList.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Rsvp update(Rsvp updatedRsvp) {
        Rsvp existingRsvp = read(updatedRsvp.getId());
        if (existingRsvp != null) {
            rsvpList.remove(existingRsvp);
            rsvpList.add(updatedRsvp);
            return updatedRsvp;
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
        return new ArrayList<>(rsvpList);
    }
}
