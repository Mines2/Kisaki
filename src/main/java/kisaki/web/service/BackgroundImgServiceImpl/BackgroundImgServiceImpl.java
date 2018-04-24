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
}
