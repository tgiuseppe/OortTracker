package it.beije.oort.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByNicknameAndPassword(String nickname, String password);
	
}