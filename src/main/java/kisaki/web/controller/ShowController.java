package kisaki.web.controller;

import kisaki.web.entity.Img;
import kisaki.web.entity.shiro.User;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;
import java.util.Map;

import kisaki.web.service.commentService.CommentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/show")
public class ShowController  {
    @Autowired
    BackgroundImgService backgroundImgService;
    @Autowired
    CommentService commentService;


//    插图展示页面
    @RequestMapping("/showImg")
    ModelAndView show (long imgId){
        Map map =new HashMap();
        map.put("imgId",imgId);
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        map.put("userId",user.getId());
        try {
            backgroundImgService.haveSeen(map);
        }catch (Exception e){

        }
        ModelAndView modelAndView = new ModelAndView();
        Img img = backgroundImgService.showByImgId(imgId);
        List<Img> imgList = backgroundImgService.findImgByUserId(Long.parseLong(img.getUserId()));
        List<Img> careList = backgroundImgService.getCareImgListByUserId(Long.parseLong(img.getUserId()));
        modelAndView.addObject("Img",img);
        modelAndView.addObject("imgList",imgList);
        modelAndView.addObject("careList",careList);
        modelAndView.setViewName("/web/show");
        modelAndView.addObject("commentList",commentService.getCommentList(imgId));
        return  modelAndView;
    }
}
