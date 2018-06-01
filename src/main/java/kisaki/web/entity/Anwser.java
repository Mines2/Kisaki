package kisaki.web.entity;

import java.io.Serializable;

public class Anwser extends Comment {
    private Long anwserId;
    private String anwserName;
    private Long id;
    private Long commentId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnwserId() {
        return anwserId;
    }

    public void setAnwserId(Long anwserId) {
        this.anwserId = anwserId;
    }

    public String getAnwserName() {
        return anwserName;
    }

    public void setAnwserName(String anwserName) {
        this.anwserName = anwserName;
    }
}
