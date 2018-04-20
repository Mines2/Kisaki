package kisaki.web.controller;


//import net.sf.json.JSONObject;
import kisaki.web.entity.Img;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;
import org.springframework.web.servlet.ModelAndView;
import util.ImgUtil;

import java.io.IOException;
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
        jsonObject.accumulate("list",list);
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
}
