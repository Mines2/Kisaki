package kisaki.web.mapper;

import kisaki.web.entity.shiro.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

User findByUserName(String username);


}
