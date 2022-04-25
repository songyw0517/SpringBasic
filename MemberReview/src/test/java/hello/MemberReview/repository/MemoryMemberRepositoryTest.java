package hello.MemberReview.repository;

import hello.MemberReview.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // 1. MemberRepository 생성
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    /** MemoryMemberRepository의 save 테스트 **/
    @Test
    public void save(){
        // 테스트 준비
        Member member = new Member();
        member.setName("sprint");
        
        // 테스트 진행
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        // 테스트 검증 1. junit.jupiter.api.Assertions 사용
        Assertions.assertEquals(result, member); // 성공
//        Assertions.assertEquals(result, null); // 실패

        // 테스트 검증 2. org.assertj.core.api.Assertions 사용
        assertThat(member).isEqualTo(result);
    }

    /** MemoryMemberRepository의 findByName 테스트 **/
    @Test
    public void findByName(){
        // 테스트 준비
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 테스트 실행
        Member result = repository.findByName("spring1").get(); // repository에서 spring1에 해당하는 객체(member1)를 가져온다.

        // 테스트 검증
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        // 테스트 준비
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 테스트 실행
        List<Member> result = repository.findAll();

        // 테스트 검증
        assertThat(result.size()).isEqualTo(2);
    }

}