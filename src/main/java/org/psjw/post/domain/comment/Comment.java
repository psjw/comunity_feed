package org.psjw.post.domain.comment;

import java.util.Locale;
import org.psjw.common.domain.PositiveIntegerCounter;
import org.psjw.post.domain.Post;
import org.psjw.post.domain.content.PostContent;
import org.psjw.user.domain.User;

public class Comment {

    private final Long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;

    public Comment(Long id, User author, PostContent content) {
        if(author == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
    }
    public void like(User user) {
        if(this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        likeCount.increase();
    }

    public void unlike(User user) {
        this.likeCount.decrease();
    }

    public void updateComment(User user, String updatedContent) {
        if(!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        this.content.updateContent(updatedContent);
    }
}
