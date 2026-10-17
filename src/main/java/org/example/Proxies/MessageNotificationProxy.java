package org.example.Proxies;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.Comments;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Qualifier("NotificationProxy")
public class MessageNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendNotification(Comments comments) {
        System.out.println("SMS send to:"+comments.getAuthor());
    }
}
