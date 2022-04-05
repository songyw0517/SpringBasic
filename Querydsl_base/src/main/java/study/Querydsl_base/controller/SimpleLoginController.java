package study.Querydsl_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleLoginController {
    @GetMapping("/simpleLogin")
    public String showsimpleLogin(){return "SimpleLoginExample";}

    @PostMapping("/simpleLogin/login")
    @ResponseBody
    public void simpleLogin(@RequestParam("id") String id, @RequestParam("pw") String pw){
        System.out.println("id = "+id+" pw = " + pw);
    }

}
