package kisaki.web.service.commentService;

import kisaki.web.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentList(Long imgId);

    Boolean insertComment(Comment comment);
}
