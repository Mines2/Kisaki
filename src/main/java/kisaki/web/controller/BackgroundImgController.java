package kisaki.web.controller;

import kisaki.web.entity.BackgroundImg;
import kisaki.web.mapper.BackgroundImgMapper;
//import net.sf.json.JSONObject;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kisaki.web.service.BackgroundImgService.BackgroundImgService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/background")
public class BackgroundImgController {
    @Autowired
    BackgroundImgService backgroundImgService;
    @Autowired
    BackgroundImgMapper backgroundImgMapper;


    @ResponseBody
    @RequestMapping("/getBGList")
    public Object getBGList(){
        JSONObject jsonObject = new JSONObject();
        List<BackgroundImg> list = backgroundImgService.getBGList();
//        List<BackgroundImg> list = backgroundImgMapper.getList();
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
}
