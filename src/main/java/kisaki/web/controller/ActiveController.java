package kisaki.web.controller;

import kisaki.web.entity.Active;
import kisaki.web.entity.shiro.User;
import kisaki.web.service.activeService.ActiveService;
import kisaki.web.service.userService.UserService;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.Subject;
import java.util.Date;
import java.util.List;

@RequestMapping("/active")
@Controller
public class ActiveController {
    @Autowired
    ActiveService activeService;
    @Autowired
    UserService userService;

    @RequestMapping("/getlist1")
    @ResponseBody
    public JSONObject findfindContextWithCareIds(){
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        List<Active> list = activeService.findContextWithCareIds(user.getId());
        jsonObject.accumulate("list",list);
        return jsonObject;
    }

    @RequestMapping("/getlist2")
    @ResponseBody
    public  JSONObject findContextWithUserId(Long userId){
        JSONObject jsonObject = new JSONObject();
        List<Active> list = activeService.findContextWithUserId(userId);
        jsonObject.accumulate("list",list);
        return jsonObject;
    }

    @RequestMapping("/getlist3")
    public  ModelAndView findContextWithUserIds(){
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        List<Active> list = activeService.findContextWithUserId(user.getId());
        List<Active> carelist = activeService.findContextWithCareIds(user.getId());
        List<User> userList = userService.findCareByUserId(user.getId());
        List<Active> meActiveList = activeService.findContextByUserId(user.getId());
        List<Active> newList = march(list , carelist);
        newList = march(newList , meActiveList);
        modelAndView.addObject("list",newList);
        modelAndView.setViewName("/web/comment");
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("/pushContext")
    @ResponseBody
    public JSONObject push(Active active){
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        active.setUserId(user.getId());
        jsonObject.accumulate("result",activeService.insertContext(active));
        return jsonObject;

    }


    @RequestMapping("/getListByUserId")
    @ResponseBody
    public JSONObject getListByUserId(int type){
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        if(type == 1){
            List<Active> list_context = activeService.findContextByUserId(user.getId());
            List<Active> list_comment = activeService.findCommentByUserId(user.getId());
            List<Active> newList = march(list_comment,list_context);
            jsonObject.accumulate("list",newList);
        }else if(type == 2){
            List<Active> list_comment = activeService.findCommentByUserId(user.getId());
            List<Active> newList = march(list_comment, null);
            jsonObject.accumulate("list", newList);
        }else {
            List<Active> list_context = activeService.findContextByUserId(user.getId());
            List<Active> newList = march(list_context, null);
            jsonObject.accumulate("list", newList);
        }
        return jsonObject;
    }


    @RequestMapping("/getAllList")
    @ResponseBody
    public JSONObject getAllList(int type){
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        if(type == 1){
            List<Active> list = activeService.findContextWithUserId(user.getId());
            List<Active> carelist = activeService.findContextWithCareIds(user.getId());
            List<Active> meActiveList = activeService.findContextByUserId(user.getId());
            List<Active> newList = march(list, carelist);
            newList = march(newList, meActiveList);
            jsonObject.accumulate("list", newList);
        }else if(type == 2){
            List<Active> list = activeService.findContextWithUserId(user.getId());
            List<Active> newList = march(list, null);
            jsonObject.accumulate("list", newList);
        }else {
            List<Active> meActiveList = activeService.findContextByUserId(user.getId());
            List<Active> carelist = activeService.findContextWithCareIds(user.getId());
            List<Active> newList = march(meActiveList, carelist);
            jsonObject.accumulate("list", newList);
        }
        return jsonObject;
    }


    @RequestMapping("/getCardsList")
    @ResponseBody
    public  JSONObject getCardsList(int type){
        JSONObject jsonObject = new JSONObject();
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        if(type == 1){
            List<Active> list_context = activeService.findContextWithCareIds(user.getId());
            List<Active> list_comment = activeService.findCommentByCareIds(user.getId());
            List<Active> newList = march(list_comment,list_context);
            jsonObject.accumulate("list",newList);
        }else if(type == 2){
            List<Active> list_comment = activeService.findCommentByCareIds(user.getId());
            List<Active> newList = march(list_comment, null);
            jsonObject.accumulate("list", newList);
        }else {
            List<Active> list_context = activeService.findContextWithCareIds(user.getId());
            List<Active> newList = march(list_context, null);
            jsonObject.accumulate("list", newList);
        }
        return jsonObject;

    }


    /*
    合并list，并且按照日期排序
     */
    public List<Active> march(List<Active> list1,List<Active> list2){
        if(list2 != null){
            list1.addAll(list2);
        }
        for ( Active active  :list1) {
            for (int i = 0; i<list1.size()-1 ; i++){
                Active active_i = list1.get(i);
                Active active_j = list1.get(i+1);
                if( active_i.returnDate().getTime() < active_j.returnDate().getTime()){
                    list1.set(i,active_j);
                    list1.set(i+1,active_i);


                }
            }
            
        }



        return list1;
    }


}
