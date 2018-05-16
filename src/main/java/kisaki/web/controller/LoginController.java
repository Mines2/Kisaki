package kisaki.web.controller;

import kisaki.web.entity.Img;
import kisaki.web.entity.shiro.User;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;
import kisaki.web.service.userService.UserService;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
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
    public Object login(User user) {
//        ModelAndView modelAndView = new ModelAndView();
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        User checkUser = userService.findByUserName(user.getUserName());
        if(subject.getSession().getAttribute("user") != null){
            user = (User) subject.getSession().getAttribute("user");
            jsonObject.accumulate("msg",1);
        }else if(!checkUser.getUserName().equals(user.getUserName())){
            jsonObject.accumulate("msg", 3);

        }
        else {
            try {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),
                        user.getPassword());
                subject.login(token);
                subject.getSession().setAttribute("user",
                        userService.findByUserName(subject.getPrincipal().toString()));
                jsonObject.accumulate("msg", 1);
            }catch (Exception e){
                jsonObject.accumulate("msg", 2);
            }
        }

        return jsonObject;
    }


    @RequestMapping("/goIndex")
    public ModelAndView goIndex(){

        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        if(user != null){
            User currentUser = userService.findByUserName(user.getUserName());
            modelAndView.setViewName("/index");
            modelAndView.addObject("user", currentUser);
            modelAndView.addObject("fansList",
                    userService.findFansByUserId(currentUser.getId()));
            modelAndView.addObject("careList",
                    userService.findCareByUserId(currentUser.getId()));
            Map map = new HashMap();
            map.put("type", "img_have_collected");
            List<Img> collectList = backgroundImgService.getImgListByType(map);
            modelAndView.addObject("collectList", collectList);
            map.put("table", "t_user_care");
            map.put("column", "care_id");
            modelAndView.addObject("userList", userService.findUserByTable(map));
        }
            return modelAndView;

    }

    @RequestMapping("/")
    public static String test(Model model){
        return "/web/login";
    }

    @RequestMapping("/out")
    public static String out(){
        SecurityUtils.getSubject().getSession().removeAttribute("user");

        return "/web/login";
    }

    @ResponseBody
    @RequestMapping("/register")
    public Object register(User user){
        JSONObject jsonObject = new JSONObject();
        if(userService.findByUserName(user.getUserName()) == null){
            user.setPassword(new SimpleHash("md5", user.getPassword(), user.getUserName(), 2).toString());
            jsonObject.accumulate("result", userService.insertUser(user));

        }
        return  jsonObject;
    }

//    @RequestMapping("/getUserList")
//    public


}
