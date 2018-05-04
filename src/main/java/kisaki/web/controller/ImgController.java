package kisaki.web.controller;


//import net.sf.json.JSONObject;
import kisaki.web.entity.Img;
import kisaki.web.entity.shiro.User;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;
import org.springframework.web.servlet.ModelAndView;
import util.ImgUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/img")
public class ImgController {
    @Autowired
    BackgroundImgService backgroundImgService;



    @ResponseBody
    @RequestMapping("/getBGList")
    public Object getBGList(){
        JSONObject jsonObject = new JSONObject();
        List<Img> list = backgroundImgService.getBGList();
        if(list != null){
            jsonObject.put("list",list);
        }
        return jsonObject;
    }

    @RequestMapping("/mess")
    public String test(Model model){
        return "/web/login";
    }

    @RequestMapping("/index")
    public ModelAndView goIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @RequestMapping("/getListByType")
    public Object getList(String type) throws IOException {
        JSONObject jsonObject = new JSONObject();
        Map map = new HashMap();
        map.put("type",type);
        List<Img> list = backgroundImgService.getImgListByType(map);
        jsonObject.accumulate("list",list);
        return jsonObject;
    }

    @RequestMapping("/addCollect")
    @ResponseBody
    public Object addCollect(int imgUserId , int imgId){
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        JSONObject jsonObject = new JSONObject();
        Map map = new HashMap();
        map.put("userId",user.getId());
        map.put("imgUserId",imgUserId);
        map.put("imgId",imgId);
        jsonObject.put("result",backgroundImgService.addCollect(map));
        return jsonObject;
    }


    @RequestMapping("/findImgByUserId")
    @ResponseBody
    public Object findImgByUserId(Long id){
        JSONObject jsonObject = new JSONObject();
        List<Img> list = backgroundImgService.getCareImgListByUserId(id);
        jsonObject.put("list",list);
        return jsonObject;
    }


    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(String imgList){
        JSONObject jsonObject = new JSONObject();
        List<Img> list = (List<Img>)JSONArray.toList(JSONArray.fromObject(imgList),Img.class);
        List<Img> newList = new ArrayList<>();
        for (Img img:  list) {
            try {
                ImgUtil.GenerateImage(img.getImgUrl());
//                img = ImgUtil.getImgSize(img);
//                img = ImgUtil.readAndWriteImg(img);
                newList.add(img);
            }catch (Exception e){

            }

        }

        jsonObject.put("list",imgList);
        return jsonObject;
    }
}
