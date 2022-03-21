package com.mountain.place.domain.user.dao;

import com.mountain.place.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
