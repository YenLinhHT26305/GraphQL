package vn.iotstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstart.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
	

