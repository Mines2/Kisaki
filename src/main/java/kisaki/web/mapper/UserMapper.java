package kisaki.web.mapper;

import java.util.Map;
import kisaki.web.entity.shiro.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

User findByUserName(String username);

List<User> findFansByUserId(Long id );

List<User> findCareByUserId(Long id );

List<User> findUserByTable(Map map);

}
