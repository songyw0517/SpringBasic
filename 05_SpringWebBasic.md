# 스프링 웹 개발 기초
- 정적 컨텐츠
- MVC와 템플릿 엔진
- API

# Spring에서의 정적 컨텐츠, static
```html
<!-- resources/static/hello-static.html -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
정적 컨텐츠입니다.
</body>
</html>
```
- 서버 실행후
- localhost:8080/hello-static.html로 접속하면 된다!

## 동작과정
1. localhost:8080/hello-static.html 요청이 들어옴
2. 내장 톰켓 서버에서 hello-static관련 컨트롤러를 찾음 -> 없음
3. 컨트롤러가 없으므로 -> resources/static 에서 hello-static.html을 찾음
4. 찾은 것을 웹 브라우저에 보여줌

<hr>

# Spring에서의 MVC와 템플릿 엔진
- MVC : 
  - Model
  - View : 화면에 보여지는 부분
  - Controller : 서버 로직, back-end 부분
```java
/** hello/hellospring/controller/HelloController.java **/

@Controller
public class HelloController {
    
    // localhost:8080/hello-mvc 요청에 응답할 메소드
    @GetMapping("hello-mvc")
    // @RequestParam을 통해 "name"의 값을 요구한다. 
    // -> localhost:8080/hello-mvc?name=값 으로 요청해야한다.
    public String helloMvc(@RequestParam("name") String name, Model model){
      model.addAttribute("name", name);
      // hello-template.html에 모델을 전달한다.
      return "hello-template";
    }
}
```

```html
<!-- resources/templates/hello-template.html -->

<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello '+${name}">hello! empty</p>
</body>
</html>
```
## 동작과정
1. localhost:8080/hello-mvc?name=scof 로 요청이 들어온다.
2. 내장 톰켓 서버에서 hello-mvc 컨트롤러를 찾는다.
3. 찾은 hello-mvc 컨트롤러에게 전달 후, 메소드를 실행한다.
4. @RequestParam("name") String name = "scof"가 되고, 모델에 {"name":"scof"}가 저장된다.
5. viewResolver가 resources/templates의 "hello-template".html에 모델을 전달한다.
6. hello-template.html에서는 모델을 받아, 모델의 데이터를 html에 담아 출력한다.
  - <p th:text="~">hello! empty</p>를 통해 값이 전달될 경우, <p>태그의 값은 "~"으로 대체된다.

