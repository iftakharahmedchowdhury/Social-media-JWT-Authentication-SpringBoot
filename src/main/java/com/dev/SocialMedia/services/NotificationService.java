package com.dev.SocialMedia.services;

import com.dev.SocialMedia.models.Notification;
import com.dev.SocialMedia.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification notification) {
        Notification existingNotification = notificationRepository.findById(id).orElse(null);
        if (existingNotification != null) {
            existingNotification.setMessage(notification.getMessage());
            existingNotification.setUser(notification.getUser());
            existingNotification.setReadStatus(notification.isReadStatus());
            return notificationRepository.save(existingNotification);
        }
        return null;
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}