package za.ac.cput.Repository;

import za.ac.cput.Entity.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Notification repository.
 * Uses an in-memory list to simulate database operations.
 */
public class NotificationRepository implements INotificationRepository {
    private static INotificationRepository repository = null;
    private final List<Notification> notificationList;

    private NotificationRepository() {
        notificationList = new ArrayList<>();
    }

    public static INotificationRepository getRepository() {
        if (repository == null) {
            repository = new NotificationRepository();
        }
        return repository;
    }

    @Override
    public List<Notification> getAll() {
        return new ArrayList<>(notificationList);
    }

    @Override
    public Notification create(Notification notification) {
        if (notification != null) {
            notificationList.add(notification);
            return notification;
        }
        return null;
    }

    @Override
    public Notification read(String notificationID) {
        for (Notification notification : notificationList) {
            if (notification.getNotificationID().equals(notificationID)) {
                return notification;
            }
        }
        return null;
    }

    @Override
    public Notification update(Notification updatedNotification) {
        for (int i = 0; i < notificationList.size(); i++) {
            if (notificationList.get(i).getNotificationID().equals(updatedNotification.getNotificationID())) {
                notificationList.set(i, updatedNotification);
                return updatedNotification;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String notificationID) {
        return notificationList.removeIf(notification -> notification.getNotificationID().equals(notificationID));
    }
}