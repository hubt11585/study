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
        //��װҪ��ʾ����ͼ������

        mv.addObject("msg","hello myfirst mvc");
        //��ͼ��
        mv.setViewName("Hello");

        return mv;
    }


}
