package study.Querydsl_base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.Querydsl_base.repository.UserRepository;
import study.Querydsl_base.service.UserService;

@Configuration
public class SpringConfig {
    private final UserRepository userRepository;

    @Autowired
    public SpringConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Bean
    public UserService userservice(){return new UserService(userRepository);}

}
