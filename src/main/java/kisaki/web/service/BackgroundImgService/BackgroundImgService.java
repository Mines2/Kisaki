package kisaki.web.service.BackgroundImgService;

import kisaki.web.entiy.BackgroundImg;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BackgroundImgService {
    List<BackgroundImg> getBGList();
}
