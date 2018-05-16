package kisaki.web.service.userService;

import kisaki.web.entity.Img;
import kisaki.web.entity.shiro.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User  findByUserName(String username);

    List<User> findFansByUserId(Long id );

    List<User> findCareByUserId(Long id );

    List<User> findUserByTable(Map map);

    Boolean insertUser(User user);

    Boolean updatePassWord(User user);
}
