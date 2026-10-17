package org.example.Repository;

import lombok.Getter;
import lombok.Setter;
import org.example.Models.Comments;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
@Primary
public class MongoDBRepository implements CommentRepository{
    @Override
    public void storeComments(Comments comments) {
        System.out.println("Stored in MongoDB:"+comments.getText());
    }
}
