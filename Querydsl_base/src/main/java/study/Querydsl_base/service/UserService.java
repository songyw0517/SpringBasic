package study.Querydsl_base.service;

import org.springframework.transaction.annotation.Transactional;
import study.Querydsl_base.domain.User;
import study.Querydsl_base.repository.UserRepository;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원가입
     * **/
    public String join(User user, String pwr){
        validatePw(user, pwr); // pw 확인
        validateDuplicateUser(user); // 중복 id확인
        userRepository.save(user); // 저장

        return user.getId();
    }

    private void validatePw(User user, String pwr) {
        if(!user.getPw().equals(pwr)){
            throw new IllegalStateException("패스워드가 다릅니다.");
        }
    }

    private void validateDuplicateUser(User user) {
        userRepository.findById(user.getId())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 ID입니다.");
                });
    }
}
