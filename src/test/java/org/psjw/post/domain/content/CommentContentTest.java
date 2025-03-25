package org.psjw.post.domain.content;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CommentContentTest {


    @Test
    void givenContentLengthIsOk_whenCreateCommentContent_thenReturnTextContent() {

        //given
        String contentContext = "this is a test content";

        //when
        CommentContent commentContent = new CommentContent(contentContext);

        //then
        assertEquals(contentContext, commentContent.getContentText());
    }

    @Test
    void givenContentLengthIsOver_whenCreateCommentContent_thenThrowError() {
        //given
        String content = "a".repeat(101);
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁", "닭", "굵", "삵", "숧"})
    void givenContentLengthIsOverAndKorean_whenCreateCommentContent_thenThrowError(String koreanWord) {
        //given
        String content = koreanWord.repeat(101);
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void givenContentLengthIsEmptyAndNull_whenCreateCommentContent_thenThrowError(String content) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> new CommentContent(content));
    }
}