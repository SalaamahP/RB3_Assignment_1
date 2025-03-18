package za.ac.cput.Repository;

import za.ac.cput.Entity.Notification;

import java.util.List;

/**
 * Repository interface for managing Notification entities.
 */
public interface INotificationRepository extends IRepository<Notification, String> {
    List<Notification> getAll();
}