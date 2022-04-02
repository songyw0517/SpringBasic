package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

// 저장소(DB) 대체 클래스
public class MemoryMemberRepository implements MemberRepository{
    
    private static Map<Long, Member> store = new HashMap<>(); // 데이터 저장
    private static long sequence = 0L; // key값 생성
    
    
    @Override
    public Member save(Member member) {
        member.setId(++sequence); // id 설정
        store.put(member.getId(), member); // store에 저장 (id, member 객체)
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 스트림으로 뽑은 것에 대해, filter 적용
                .filter(member -> member.getName().equals(name)) // member에서 getName()으로 반환된 값이 name이랑 같으면, 추출
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // store를 비우는 메소드
    public void clearStore(){
        store.clear();
    }
}
