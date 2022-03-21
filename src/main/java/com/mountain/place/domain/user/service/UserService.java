package com.mountain.place.domain.user.service;

import com.mountain.place.domain.user.dao.UserRepository;
import com.mountain.place.domain.user.model.User;
import com.mountain.place.exception.CustomException;
import com.mountain.place.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username);
        return user.orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_USER));

    }

    //유저 등록
    @Transactional
    public User register(String uid, String name) {

        User registeredUser = User.builder()
                .id(uid)
                .name(name)
                .build();

        userRepository.save(registeredUser);

        return registeredUser;

    }
}


