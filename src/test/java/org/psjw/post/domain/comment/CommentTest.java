package org.psjw.post.domain.comment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.psjw.post.domain.Post;
import org.psjw.post.domain.content.CommentContent;
import org.psjw.post.domain.content.PostContent;
import org.psjw.user.domain.User;
import org.psjw.user.domain.UserInfo;

class CommentTest {
    private final UserInfo info = new UserInfo("name","url");
    private User user = new User(1L , info);
    private User otherUser = new User(2L , info);

    private final Post post = new Post(1L, user, new PostContent("content"));
    private final Comment comment = new Comment(1L, user, new CommentContent("content"));


    @Test
    void givenComment_whenLike_thenLikeCountShouldBe1() {
        //when
        comment.like(otherUser);

        //then
        assertEquals(1, comment.getLikeCount());
    }

    @Test
    void givenComment_whenLikeByOtherUser_thenThrowException() {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> comment.like(user));
    }

    @Test
    void givenComment_whenUnlike_thenLikeCountShouldBe0() {
        //when
        comment.like(otherUser);

        //then
        comment.unlike();

        //then
        assertEquals(0, comment.getLikeCount());
    }

    @Test
    void givenCommentCreated_whenUnlike_thenLikeCountShouldBe0() {
        //then
        comment.unlike();

        //then
        assertEquals(0, comment.getLikeCount());
    }

    @Test
    void givenComment_whenUpdateContent_thenShouldBeUpdated() {
        //given
        String updatedContent = "updated content";
        //when
        comment.updateComment(user, updatedContent);
        //then
        assertEquals(updatedContent, comment.getContent());
    }


    @Test
    void givenComment_whenUpdateContentOver100_thenThrowException() {
        //given
        String updatedContent = "a".repeat(101);
        //when, then
        assertThrows(IllegalArgumentException.class, () -> comment.updateComment(user, updatedContent));
    }

}