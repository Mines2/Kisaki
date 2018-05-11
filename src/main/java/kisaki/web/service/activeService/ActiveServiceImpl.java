package kisaki.web.service.activeService;

import kisaki.web.entity.Active;
import kisaki.web.mapper.ActiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    ActiveMapper activeMapper ;
    @Override
    public List<Active> findContextWithCareIds(Long userId) {
        return activeMapper.findContextWithCareIds(userId);
    }

    @Override
    public List<Active> findContextWithUserId(Long userId) {
        return activeMapper.findContextWithUserId(userId);
    }

    @Override
    public Boolean insertContext(Active active) {
        return activeMapper.insertContext(active);
    }

    @Override
    public List<Active> findContextByUserId(Long userId) {
        return activeMapper.findContextByUserId(userId);
    }
}
