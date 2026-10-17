package org.example.Proxies;

import org.example.Models.Comments;

public interface CommentNotificationProxy {
    void sendNotification(Comments comments);
}
