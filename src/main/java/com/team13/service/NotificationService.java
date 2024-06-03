package com.team13.service;

import com.team13.model.NotificationModel;
import com.team13.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<NotificationModel> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public NotificationModel getNotificationById(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public NotificationModel createNotification(NotificationModel notification) {
        return notificationRepository.save(notification);
    }

    public NotificationModel updateNotification(Long id, NotificationModel notification) {
        if (notificationRepository.existsById(id)) {
            notification.setId(id);
            return notificationRepository.save(notification);
        } else {
            return null;
        }
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
