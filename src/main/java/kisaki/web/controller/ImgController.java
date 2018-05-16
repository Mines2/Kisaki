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
import java.util.Date;
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
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        for (Img img:  list) {
            try {
                String newUrl = ImgUtil.GenerateImage(img.getImgUrl());
                img.setImgUrl(newUrl);
                img = ImgUtil.getImgSize(img);
                img.setImgUrl("../"+newUrl.substring(newUrl.indexOf("/",newUrl.indexOf("templates")),newUrl.length()));
                img.setUserId(user.getId().toString());
                img.setImgPushDate(new Date());
                newList.add(img);
            }catch (Exception e){

            }

        }
        Map map = new HashMap();
        map.put("list",newList);
        backgroundImgService.upLoad(map);

        jsonObject.put("list",newList);
        return jsonObject;
    }


    @RequestMapping("/delete")
    @ResponseBody
    public  Object delete(String ids , int type){
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        Map map = new HashMap();
        String[] idslist = ids.split(",");
        List<Integer>  idsList = new ArrayList<Integer>();
        for(int i = 0; i<idslist.length ; i++){
            idsList.add(Integer.parseInt(idslist[i]));
        }
        map.put("userId",user.getId());
        map.put("ids",idsList);
        if(type == 1){
            jsonObject.accumulate("result", backgroundImgService.deleteImgs(map));
        }else if(type == 2){
            jsonObject.accumulate("result",backgroundImgService.deleteCollectImgs(map));
        }else{
            jsonObject.accumulate("result",false);
        }

        return jsonObject;


    }


    @RequestMapping("/toManage")
    public  ModelAndView modelAndView (int type ){
        ModelAndView modelAndView = new ModelAndView();
        if(type ==1 ){
            modelAndView.addObject("tittle", "管理作品");
        }else{
            modelAndView.addObject("tittle", "收藏管理");
        }
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/web/manage");
        return modelAndView;
    }


    @RequestMapping("/getImgList")
    @ResponseBody
    public  Object getImgList( int type){
        JSONObject jsonObject = new JSONObject();
         List<Img> imgList = null;
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        if( type == 1){
            imgList = backgroundImgService.getImgListByUserId(user.getId());

        }else  if (type == 2){
            imgList = backgroundImgService.getCollectionList(user.getId());
        }
        jsonObject.accumulate("imgList",imgList);

        return jsonObject;


    }


    @RequestMapping("/toUpload")
    public ModelAndView toUpload(){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getSession().getAttribute("user");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/web/upload");
        return  modelAndView;
    }
}
