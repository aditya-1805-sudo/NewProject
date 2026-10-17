package org.example.Services;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.Comments;
import org.example.Proxies.CommentNotificationProxy;
import org.example.Proxies.EmailNotificationProxy;
import org.example.Repository.CommentRepository;
import org.example.Repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Service
public class CommentService {
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(@Qualifier("messageNotificationProxy") CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository){
        this.commentNotificationProxy=commentNotificationProxy;
        this.commentRepository=commentRepository;
    }
    public void publish(Comments comments){
        commentRepository.storeComments(comments);
        commentNotificationProxy.sendNotification(comments);
    }
}
