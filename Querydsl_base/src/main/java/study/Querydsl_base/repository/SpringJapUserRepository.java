package study.Querydsl_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.Querydsl_base.domain.User;

import java.util.Optional;

public interface SpringJapUserRepository extends JpaRepository<User, String>, UserRepository{
    @Override
    Optional<User> findById(String id);
}
