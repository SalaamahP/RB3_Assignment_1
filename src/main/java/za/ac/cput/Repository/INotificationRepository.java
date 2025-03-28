package za.ac.cput.Repository;

import za.ac.cput.Domain.Notification;
import java.util.Set;

//[author] Jaedon Prince, 230473474
//[date] 17/03/2025

/**
 * Repository interface for managing Notification entities.
 */
public interface INotificationRepository extends IRepository<Notification, String> {
    Set<Notification> getAll(); // Changed from List<Notification> to Set<Notification>
}
