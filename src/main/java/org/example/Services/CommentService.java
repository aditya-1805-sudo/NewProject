package org.example.Services;

import lombok.Getter;
import lombok.Setter;
import org.example.Logging.ToLog;
import org.example.Models.Comments;
import org.example.Proxies.CommentNotificationProxy;
import org.example.Proxies.EmailNotificationProxy;
import org.example.Repository.CommentRepository;
import org.example.Repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Getter
@Setter
@Service
@EnableAspectJAutoProxy
public class CommentService {
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;
    private Logger logger=Logger.getLogger(CommentService.class.getName());
    @Autowired
    public CommentService(@Qualifier("messageNotificationProxy") CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository){
        System.out.println("Object Created");
        this.commentNotificationProxy=commentNotificationProxy;
        this.commentRepository=commentRepository;
    }
    public void publish(Comments comments){
        commentRepository.storeComments(comments);
        commentNotificationProxy.sendNotification(comments);
    }

    @ToLog
    public String publishComment(Comments comments){
        logger.info("Publishing Comment:"+comments.getText()+" by:"+comments.getAuthor());
        return "SUCCESS";
    }
    @ToLog
    public void deleteComment(Comments comments){
        logger.info("Deleting Comment:"+comments.getText()+" by:"+comments.getAuthor());
    }
    @ToLog
    public void editComment(Comments comments){
        logger.info("Editing Comment:"+comments.getText()+" by:"+comments.getAuthor());
    }
}
