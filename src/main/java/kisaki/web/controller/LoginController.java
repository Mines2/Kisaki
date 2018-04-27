package kisaki.web.controller;

import kisaki.web.entity.Img;
import kisaki.web.entity.shiro.User;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;
import kisaki.web.service.userService.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import util.ImgUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    BackgroundImgService backgroundImgService;

    @ResponseBody
    @RequestMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        if(subject.getSession().getAttribute("user") != null){
            user = (User) subject.getSession().getAttribute("user");
        }else {

            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),
                    user.getPassword());
            subject.login(token);
            subject.getSession().setAttribute("user",
                    userService.findByUserName( subject.getPrincipal().toString()));
        }


        User currentUser = userService.findByUserName( subject.getPrincipal().toString());
        modelAndView.setViewName("/index");
        modelAndView.addObject("user", currentUser);
        modelAndView.addObject("fansList",
                userService.findFansByUserId(currentUser.getId()));
        modelAndView.addObject("careList",
                userService.findCareByUserId(currentUser.getId()));
               Map map = new HashMap();
        map.put("type","img_have_collected");
        List<Img> collectList = backgroundImgService.getImgListByType(map);
        modelAndView.addObject("collectList",collectList);
        map.put("table","t_user_care");
        map.put("column","care_id");
        modelAndView.addObject("userList",userService.findUserByTable(map));







//        map.put("type","img_have_seen");
//        modelAndView.addObject("seenList",backgroundImgService.getImgListByType(map));

        return modelAndView;
    }
    @RequestMapping("/")
    public String test(Model model){
        return "/web/login";
    }

//    @RequestMapping("/getUserList")
//    public
}
