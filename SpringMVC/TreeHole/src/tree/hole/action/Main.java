package tree.hole.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mvc")
public class Main  {
    @RequestMapping(value = "/hello")
    public String test(){
        System.out.println("Holle world!");
        return "Hello";
    }
}
