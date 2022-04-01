package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // localhost:8080/hello에 접속시 String hello() 메소드 호출,
    @GetMapping("hello")
    /** model을 전달받아, 모델안에 데이터를 삽입한 후,
     * return 문을 통해 해당 html로 보낸다. **/
    public String hello(Model model){
        model.addAttribute("data", "hello!"); // key : data, value:"hello!"
        return "hello"; // templates 폴더의 hello.html로 보낸다는 뜻이다.

    }
    /** 코드 해석
     * model 안에 {data : "hello!"}를 넣고
     * resources/templates/hello.html에 model을 전달한다.
     * **/


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    /** API **/
    @GetMapping("hello-string")
    @ResponseBody // http의 body부분에 데이터를 넣겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
