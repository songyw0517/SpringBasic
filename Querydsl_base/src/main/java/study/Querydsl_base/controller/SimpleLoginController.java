package study.Querydsl_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.Querydsl_base.domain.User;
import study.Querydsl_base.service.UserService;

@Controller
public class SimpleLoginController {
    private final UserService userService;

    public SimpleLoginController(UserService userservice){this.userService = userservice;}

    @GetMapping("/simpleLogin")
    public String showsimpleLogin(){return "SimpleLoginExample";}

    @PostMapping("/simpleLogin/login")
    @ResponseBody
    public void simpleLogin(@RequestParam("id") String id, @RequestParam("pw") String pw){
        System.out.println("id = "+id+" pw = " + pw);
    }
    @GetMapping("/simpleLogin/register")
    public String simpleRegister(){return "SimpleRegisterExample";}

    @PostMapping("/simpleLogin/register/submit")
    public String simpleRegisterSubmit(UserForm form, @RequestParam("pwr") String pwr){
        User user = new User();
        user.setId(form.getId());
        user.setPw(form.getPw());
        user.setName(form.getName());

        userService.join(user, pwr);

        return "redirect:/simpleLogin";

    }
}
