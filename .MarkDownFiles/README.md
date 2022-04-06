# SpringBasic
## 각 패키지에 대한 간략 설명
- 컨트롤러(controller) : 웹 MVC의 컨트롤러 역할, API 역할
- 서비스(service) :  핵심 비즈니스 로직 구현
    - ex) 회원은 중복 가입이 안된다.
- 리포지토리(repository) : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
- 도메인 : 비즈니스 도메인 객체 - 회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리되는 객체 관리
    - 데이터베이스에 저장되는 객체

## 프로젝트 구조
- controller : 
    - 웹 url 처리 및 입력 데이터, 출력 데이터 전달, API
- domain : DTO(Data Transfer Object), VO
    - 각 계층간 데이터 교환을 위한 객체
    - DB에서 데이터를 얻어 Service, Controller 등으로 보낼 때 사용한다.
    - 로직을 갖지 않고, getter, setter 메소드를 가진다.
- repository : DAO(Data Access Object)
    - DB에 접근하는 객체, DB를 사용해 데이터를 조작하는 기능을 하는 객체
    - 어떤 쿼리문을 수행하여 반환하는 메소드를 정의한다.
- service
    - 핵심 비즈니스 로직을 구현하는 부분
    - ex) 회원가입, 회원 조회, 로그인, 로그아웃 등



### 참고
- https://devlog-wjdrbs96.tistory.com/209
