package kisaki.web.service.BackgroundImgServiceImpl;


import kisaki.web.entity.Img;
import kisaki.web.mapper.ImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;

import java.util.List;
import java.util.Map;

@Service
public class BackgroundImgServiceImpl implements BackgroundImgService {
    @Autowired
    ImgMapper backgroundImgMapper;
    @Override
    public List<Img> getBGList() {
        return backgroundImgMapper.getList();
    }

    @Override
    public List<Img> getImgListByType(Map map) {
        return backgroundImgMapper.getImgListByType(map);
    }

    @Override
    public Boolean addCollect(Map map) {
        return backgroundImgMapper.addCollect(map);
    }

    @Override
    public Img showByImgId(Long id) {
        return backgroundImgMapper.showByImgId(id);
    }

    @Override
    public List<Img> findImgByUserId(Long id) {
        return backgroundImgMapper.findImgByUserId(id);
    }

    @Override
    public List<Img> getCareImgListByUserId(Long userId) {
        return backgroundImgMapper.findImgByUserId(userId);
    }

    @Override
    public Boolean haveSeen(Map map) {
        return backgroundImgMapper.haveSeen(map);
    }

    @Override
    public Boolean upLoad(Map map) {
        return backgroundImgMapper.upLoad(map);
    }

    @Override
    public int deleteImgs(Map map) {
        return backgroundImgMapper.deleteImgs(map);
    }

    @Override
    public int deleteCollectImgs(Map map) {
        return backgroundImgMapper.deleteCollectImgs(map);
    }

    @Override
    public List<Img> getCollectionList(Long userId) {
        return backgroundImgMapper.getCollectionList(userId);
    }

    @Override
    public List<Img> getImgListByUserId(Long userId) {
        return backgroundImgMapper.getImgListByUserId(userId);
    }


}
