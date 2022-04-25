package hello.MemberReview.repository;

import hello.MemberReview.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // sequence를 증가시킨다.
        store.put(member.getId(), member); // member의 id : member객체
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        /** null이 반환될 가능성이 있기에 -> optional로 감싼다. **/
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 테스트 의존성을 없애기 위한 메소드
    public void clearStore(){
        store.clear();
    }
}
