package kisaki.web.service.UserService;

import kisaki.web.entity.shiro.User;
import kisaki.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }
}
