/*IOrganizerRepository.java
IOrganizer Repository Class
Author: Oratile Precious Phologane (230690939)
Date:19 March 2025
 */

package za.ac.cput.Repository;

import za.ac.cput.Domain.Organizer;
import java.util.List;

public interface IOrganizerRepository extends IRepository <Organizer, String>{
    List<Organizer> getAllOrganizers();
}
