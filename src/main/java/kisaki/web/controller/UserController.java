package kisaki.web.controller;

import kisaki.web.entity.shiro.User;
import kisaki.web.service.userService.UserService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

//   前往个人管理页面
    @RequestMapping("/personal")
    public ModelAndView toUpdate(Long userId) {
        ModelAndView modelAndView = new ModelAndView();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        String s = user.getAddress().substring(0,user.getAddress().indexOf(",") );
        String s2 = user.getBirthdayString().substring(user.getBirthdayString().indexOf("-") + 1, user.getBirthdayString().lastIndexOf("-"));
        String s3 = user.getBirthdayString().substring(user.getBirthdayString().lastIndexOf("-") + 1, user.getBirthdayString().length());
        int i = Integer.parseInt(user.getBirthdayString().substring(0, user.getBirthdayString().indexOf('-')));
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/web/personal");
        return modelAndView;
    }

//    修改密码
    @RequestMapping("/updatePassWord")
    @ResponseBody
    public Object updatePassWord(String newPassWord, String pastPassWord) {
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        User checkUser = userService.findByUserName(user.getUserName());
        String checkPassWord = checkUser.getPassword().toString();
        pastPassWord = new SimpleHash("md5", pastPassWord, user.getUserName(), 2).toString();
        if(checkPassWord.equals(pastPassWord)){
            user.setPassword(new SimpleHash("md5", newPassWord, user.getUserName(), 2).toString());
            userService.updatePassWord(user);
            jsonObject.accumulate("result", 1);
        } else {
            jsonObject.accumulate("reuslt", 2);
        }


        return jsonObject;
    }

//    修改个人信息
    @RequestMapping("/updateMess")
    @ResponseBody
    public Object updateMess(User user) {
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user_now = (User) subject.getSession().getAttribute("user");
        user_now.setAddress(user.getAddress());
        user_now.setBirthday(user.getBirthday());
        user_now.setSex(user.getSex());
        jsonObject.accumulate("result", userService.updateMess(user_now));
        return jsonObject;
    }
}
