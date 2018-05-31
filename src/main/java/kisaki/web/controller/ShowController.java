package kisaki.web.controller;

import kisaki.web.entity.Anwser;
import kisaki.web.entity.Comment;
import kisaki.web.entity.Img;
import kisaki.web.entity.shiro.User;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;

import java.util.Date;
import java.util.Map;

import kisaki.web.service.commentService.CommentService;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        modelAndView.addObject("user",user);
        modelAndView.addObject("Img",img);
        modelAndView.addObject("imgList",imgList);
        modelAndView.addObject("careList",careList);
        modelAndView.setViewName("/web/show");
        modelAndView.addObject("commentList",commentService.getCommentList(imgId));
        return  modelAndView;
    }

    @RequestMapping("/insertComment")
    @ResponseBody
    public  Object insertComment(Comment comment){
        JSONObject jsonObject = new JSONObject();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        comment.setUserId(user.getId());
        comment.setDate(new Date());
        jsonObject.accumulate("result",commentService.insertComment(comment));
        return  jsonObject;
    }

    //回复
    @RequestMapping("/anwser")
    @ResponseBody
    public Object insertAnwser(Anwser anwser){
        JSONObject jsonObject = new JSONObject();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        if(anwser.getAnwserId() == user.getId()){
            jsonObject.accumulate("result", "1");
            return jsonObject;
        }
        anwser.setUserId(user.getId());
        anwser.setDate(new Date());
        jsonObject.accumulate("result",commentService.insertAnwser(anwser));
        return jsonObject;
    }

    //获取回复list
    @RequestMapping("/getAnwserList")
    @ResponseBody
    public Object getAnwserList(Long imgId){
        JSONObject jsonObject = new JSONObject();
        List<Anwser> list = commentService.getAnwserList(imgId);
        jsonObject.accumulate("AnwserList",list);
        return jsonObject;
    }

}
