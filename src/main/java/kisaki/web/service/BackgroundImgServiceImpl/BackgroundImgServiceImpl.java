package kisaki.web.service.BackgroundImgServiceImpl;

import kisaki.web.entity.BackgroundImg;
import kisaki.web.mapper.BackgroundImgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;

import java.util.List;
@Service
public class BackgroundImgServiceImpl implements BackgroundImgService {
    @Autowired
    BackgroundImgMapper backgroundImgMapper;
    @Override
    public List<BackgroundImg> getBGList() {
        return backgroundImgMapper.getList();
    }
}
