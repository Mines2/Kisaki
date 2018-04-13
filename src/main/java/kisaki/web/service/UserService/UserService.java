package kisaki.web.service.UserService;

import kisaki.web.entity.shiro.User;

public interface UserService {

    User  findByUserName(String username);
}
