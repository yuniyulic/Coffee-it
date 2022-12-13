package src.com.coffee.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import src.com.coffee.domain.user.domain.TestMember;

@Repository
public interface TestMemberRepository extends JpaRepository<TestMember, String>{

}
