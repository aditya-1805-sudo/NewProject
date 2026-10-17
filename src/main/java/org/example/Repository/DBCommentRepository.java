package org.example.Repository;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.Comments;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
public class DBCommentRepository implements CommentRepository{


    public void storeComments(Comments comments) {
        System.out.println("Storing:"+comments.getText());
    }
}
