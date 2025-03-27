package za.ac.cput.Repository;

import za.ac.cput.Domain.Rsvp;
import za.ac.cput.Domain.Student;
import java.util.List;

public interface IRsvpRepository extends IRepository <Rsvp, String> {
    List<Rsvp> getAll();
}
