package kisaki.web.service.activeService;

import kisaki.web.entity.Active;

import java.util.List;

public interface ActiveService {
    List<Active> findContextWithCareIds(Long userId);

    List<Active> findContextWithUserId(Long userId);

    Boolean insertContext(Active active);

    List<Active> findContextByUserId(Long userId);

}
