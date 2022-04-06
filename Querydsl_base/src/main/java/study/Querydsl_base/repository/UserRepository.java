package study.Querydsl_base.repository;

import study.Querydsl_base.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
}
