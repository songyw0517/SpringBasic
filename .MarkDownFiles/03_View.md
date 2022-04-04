# View
## Welcome Page
- 스트링 부트가 제공하는 기능으로
- static/index.html을 올려두고, 서버를 실행하면
- localhost:8080에 접속시 첫 페이지로 index.html을 보여준다.
```html
<!-- resources/static/index.html --> 
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Hello</title>
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```

## thymeleaf 템플릿 엔진
- 파이썬 flask의 Jinja 같은 느낌?이다.
- controller은 url에 따라 알맞는 메소드를 실행시킨다.
```java
/** hello/hellospring/controller/HelloController.java **/

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
```
```html

<!-- resources/templates/hello.html -->

<!doctype html>

<!-- xmlns:th="http://www.thymeleaf.org" 를 사용함으로써, 
타임리프 템플릿을 사용함을 보여준다. -->
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<p th:text="'안녕하세요.' + ${data}"> 안녕하세요. 손님</p>
</body>
</html>
```
### 동작과정
1. 서버 실행
2. localhost:8080/hello url 접속
3. controller의 HelloController에서 "hello"에 매핑이 되어있는 메소드를 찾음
4. 위 예제에서는 @GetMapping("hello")에 해당하는 public String hello(Model model) 메소드 호출
5. 모델에 data:"hello"를 저장한 후, "hello" 리턴
6. resources/templates에서 "hello".html 파일을 찾아 들어간다. (viewResolver)
7. hello.html에서 ${data}부분에 값("hello!")가 대입되어 화면에 보인다.

### 편의를 위한 spring-boot-devtools
- spring-boot-devtools를 추가하면 html 파일을 저장할 시, 서버의 재시작 없이 변경가능하다.


### Spring VS Flask
- 플라스크에서는 spring의 controller부분을 블루프린트로 처리했었다. (부족한 역량 탓..)
- 플라스크의 Jinja가 spring에서는 thymeleaf이다.

