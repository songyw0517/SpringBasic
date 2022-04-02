package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    // Autowired : 생성자를 호출시,
    // 스프링에서 memberService를 가져다가 매개변수로 넣어준다.
    // 이때, 스프링에는 memberService, memberService 안의 memoryMemberRepository가 있어야한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
