package tree.hole.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mvc")
public class Main  {
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        System.out.println("Holle world!");
        return "Hello world!";
    }

    @RequestMapping(value = "/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        //封装要显示到视图的数据

        mv.addObject("msg","hello myfirst mvc");
        //视图名
        mv.setViewName("Hello");

        return mv;
    }


}
