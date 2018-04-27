package kisaki.web.mapper;

import kisaki.web.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CommentMapper {
    List<Comment> getCommentList(Long imgId);
}
