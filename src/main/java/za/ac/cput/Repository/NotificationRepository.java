package za.ac.cput.Repository;

import za.ac.cput.Domain.Notification;
import java.util.HashSet;
import java.util.Set;

//[author] Jaedon Prince, 230473474
//[date] 17/03/2025

public class NotificationRepository implements INotificationRepository {
    private static NotificationRepository repository = null;
    private final Set<Notification> notificationSet;

    private NotificationRepository() {
        this.notificationSet = new HashSet<>();
    }

    public static NotificationRepository getRepository() {
        if (repository == null) {
            repository = new NotificationRepository();
        }
        return repository;
    }

    @Override
    public Notification create(Notification notification) {
        boolean added = this.notificationSet.add(notification);
        return added ? notification : null;
    }

    @Override
    public Notification read(String notificationID) {
        return notificationSet.stream()
                .filter(n -> n.getNotificationID().equals(notificationID))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Notification update(Notification updatedNotification) {
        Notification existingNotification = read(updatedNotification.getNotificationID());
        if (existingNotification != null) {
            notificationSet.remove(existingNotification);
            notificationSet.add(updatedNotification);
            return updatedNotification;
        }
        return null;
    }

    @Override
    public boolean delete(String notificationID) {
        Notification notificationToDelete = read(notificationID);
        if (notificationToDelete != null) {
            return notificationSet.remove(notificationToDelete);
        }
        return false;
    }

    @Override
    public Set<Notification> getAll() {
        return new HashSet<>(notificationSet);
    }

    /**
     * Clears the repository to reset data between test runs.
     */
    public void clear() {
        notificationSet.clear();
    }
}
