package kisaki.web.service.BackgroundImgService;



import kisaki.web.entity.Img;

import java.util.List;
import java.util.Map;

public interface BackgroundImgService {
    List<Img> getBGList();


    List<Img> getImgListByType(Map map);

    Boolean addCollect(Map map);

    Img showByImgId(Long id );

    List<Img>  findImgByUserId (Long id);

    List<Img> getCareImgListByUserId (Long userId);

    Boolean haveSeen(Map map);

    Boolean upLoad(Map map);

    int deleteImgs(Map map);

    int deleteCollectImgs(Map map);

    List<Img> getCollectionList(Long userId);

    List<Img> getImgListByUserId(Long userId);
}
