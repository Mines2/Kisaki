package kisaki.web.mapper;

import kisaki.web.entity.BackgroundImg;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BackgroundImgMapper {


    List<BackgroundImg> getList();
}
