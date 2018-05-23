package kisaki.web.service.commentService;

import kisaki.web.entity.Comment;
import kisaki.web.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentList(Long imgId) {
        return commentMapper.getCommentList(imgId);
    }

    @Override
    public Boolean insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }
}
