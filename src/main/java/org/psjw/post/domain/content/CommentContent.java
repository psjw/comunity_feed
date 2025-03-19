package org.psjw.post.domain.content;

public class CommentContent extends Content {

    private static final int MAX_COMMENT_LENGTH = 1000;

    public CommentContent(String content) {
        super(content);
    }

    @Override
    protected void checkText(String contentText) {
        if (contentText == null || contentText.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if(MAX_COMMENT_LENGTH < contentText.length()) {
            throw new IllegalArgumentException();
        }
    }
}
