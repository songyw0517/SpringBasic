# 라이브러리 살펴보기
- Gradle은 의존 관계가 있는 라이브러리를 함께 다운로드한다.

## 스프링 부트 라이브러리
1. spring-boot-starter-web
   - spring-boot-starter-tomcat : 톰캣 (웹 서버)
   - spring-webmvc : 스프링 웹 MVC
2. spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
3. spring-boot-starter : 스프링 부트 + 스프링 코어 + 로깅
   - spring-boot
     - spring-score
   - spring-boot-starter-logging
     - logback, slf4j

## 테스트 라이브러리
1. spring-boot-starter-test
   - junit : 테스트 프레임워크
   - mockito : 목 라이브러리
   - assertj : 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
   - spring-test : 스프링 통합 테스트 지원
