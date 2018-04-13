package kisaki.web.controller;

import kisaki.web.entity.shiro.User;
import kisaki.web.service.UserService.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();

        subject.login(token);
        subject.getSession().setAttribute("user",
                userService.findByUserName( subject.getPrincipal().toString()));

        modelAndView.setViewName("/index");
        modelAndView.addObject("user", userService.findByUserName( subject.getPrincipal().toString()));
        return modelAndView;
    }
    @RequestMapping("/")
    public String test(Model model){
        return "/web/login";
    }
}
