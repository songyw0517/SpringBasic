package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional // 테스트마다 db에 commit을 하지않고, rollback을 수행하여 db를 이전 db로 유지한다.
class MemberServiceIntegrationTest {

    // 사실상 테스트는 다른 곳에 사용할 것이 아니기 때문에
    // 어노테이션을 통해 편하게 테스트할 수 있다.
    @Autowired  MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // 테스트에서는 한글로 써도 된다.

        // given : 뭔가가 주어졌을 때,
        Member member = new Member();
        member.setName("hello");

        // when : 이것을 실행했을 때
        Long saveId = memberService.join(member);

        // then : 결과가 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring23");

        Member member2 = new Member();
        member2.setName("spring23");

        // when
        memberService.join(member1);

        /**
         * 방법 1. try catch 사용
         try{
         memberService.join(member2);
         fail();
         } catch (IllegalStateException e){
         assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
         }
         */

        // 방법 2. try catch문 대신 assertThrows 사용
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // 방법 3. 위의 assertThrows 메시지를 받아 사용
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}