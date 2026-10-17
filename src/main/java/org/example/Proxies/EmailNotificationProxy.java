    package org.example.Proxies;

    import lombok.Getter;
    import lombok.Setter;
    import org.example.Models.Comments;
    import org.springframework.stereotype.Component;

    @Component
    @Getter
    @Setter
    public class EmailNotificationProxy implements CommentNotificationProxy{
        @Override
        public void sendNotification(Comments comments) {
            System.out.println("Sending Notification to:"+comments.getAuthor());
        }
    }
