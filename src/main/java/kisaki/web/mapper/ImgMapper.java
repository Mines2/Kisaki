package kisaki.web.mapper;

import kisaki.web.entity.Img;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ImgMapper {


    List<Img> getList();

    List<Img> getImgListByType(Map map);

    List<Img> findUserByTable(Map map);

    Boolean addCollect(Map map);

    Img showByImgId(Long id );

    List<Img> findImgByUserId (Long id);

    List<Img> getCareImgListByUserId (Long userId);

    Boolean haveSeen(Map map);


}
