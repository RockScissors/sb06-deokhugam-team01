package com.sprint.sb06deokhugamteam01.repository;

import com.sprint.sb06deokhugamteam01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
