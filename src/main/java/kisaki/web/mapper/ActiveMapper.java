package kisaki.web.mapper;

import kisaki.web.entity.Active;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActiveMapper {

    List<Active> findContextWithCareIds(Long userId);

    List<Active> findContextWithUserId(Long userId);

    Boolean insertContext(Active active);

    List<Active> findContextByUserId(Long userId);




}
