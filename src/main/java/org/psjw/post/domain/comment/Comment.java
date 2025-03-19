package org.psjw.post.domain.comment;

import org.psjw.post.domain.Post;
import org.psjw.user.domain.User;

public class Comment {

    private final Long id;
    private final Post post;
    private final User author;
    private final String content;

    public Comment(Long id, Post post, User author, String content) {
        if(author == null) {
            throw new IllegalArgumentException();
        }

        if(post == null) {
            throw new IllegalArgumentException();
        }

        if(content == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
    }
}
