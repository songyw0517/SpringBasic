# Querydsl
- 스프링 부트와 JPA만으로는 '복잡한 쿼리', '동적 쿼리'를 다루는데 어려움이 존재한다.
- Querydsl은 이 한계점을 극복한 기술이다.

## Querydsl의 특징
- 쿼리를 자바 코드로 작성한다.
- 문법 오류를 컴파일 시점에 발생 시킨다.
- 동적 쿼리 문제를 해결한다.
- 쉬운 SQL 스타일 문법이다.

## 코드로 확인

```java
/** Querydsl을 사용하지 않은 경우 **/
@Test
public void jpql(){
    String username = "kim";
    // 공백 없음 으로 인한 쿼리문 오류 -> 돌려봐야 알 수 있다. 
    String query = "select m from Member m"+"where m.username = :username";
    
    List<Member> result = em.createQuery(query, Member.class)
        .getResultList();
}
```
```java
/** Querydsl을 사용한 경우 **/
@Test
public void querydsl(){
    String username = "kim";
    List<Member> result= queryFactory
        .select(member)
        .from(member)
        .where(member.username.eq(usernqme))
        .fetch();
}
```
- 코드가 간결해지며
- 컴파일 오류로 오류를 잡아줄 수 있으며
- 코드 자동완성의 도움을 받을 수 있으며
- 동적 쿼리를 편하게 작성할 수 있으며
- 메서드로 뽑아 사용할 수도 있다.
