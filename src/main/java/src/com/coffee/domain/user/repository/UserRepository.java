package src.com.coffee.domain.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.com.coffee.domain.user.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByUserId(String userId);
}
