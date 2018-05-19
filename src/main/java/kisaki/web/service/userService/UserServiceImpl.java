package kisaki.web.service.userService;

import kisaki.web.entity.shiro.User;
import kisaki.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<User> findFansByUserId(Long id) {
        return userMapper.findFansByUserId(id);
    }

    @Override
    public List<User> findCareByUserId(Long id) {
        return userMapper.findCareByUserId(id);
    }

    @Override
    public List<User> findUserByTable(Map map) {
        return userMapper.findUserByTable(map);
    }


    @Override
    public Boolean insertUser(User user){
        return userMapper.insertUser(user);
    }

    @Override
    public Boolean updatePassWord(User user){
        return userMapper.updatePassWord(user);
    }

    @Override
    public  Boolean updateMess(User user){
        return  userMapper.updateMess(user);
    }
}
