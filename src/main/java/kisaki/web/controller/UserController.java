package kisaki.web.controller;

import kisaki.web.entity.shiro.User;
import kisaki.web.service.userService.UserService;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/personal")
    public ModelAndView toUpdate(Long userId){
        ModelAndView modelAndView = new ModelAndView();



        modelAndView.setViewName("/web/personal");
        return modelAndView;
    }

    @RequestMapping("/updatePassWord")
    public Object updatePassWord(User user , String pastPassWord){
        JSONObject jsonObject = new JSONObject();
        User checkUser = userService.findByUserName(user.getUserName());
        if(checkUser.getPassword() == pastPassWord){
            user.setPassword(new SimpleHash("md5", user.getPassword(), user.getUserName(), 2).toString());
            userService.updatePassWord(user);
            jsonObject.accumulate("result",1);
        }else{
            jsonObject.accumulate("reuslt",2);
        }


        return jsonObject;
    }
}
