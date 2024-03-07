package com.homework.msusers.persistence;

import com.homework.msusers.persistence.entity.User;
import com.homework.msusers.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPersistence {
    @Autowired
    private UserRepository repository;

    public Boolean exists(String email) {
        return repository.existsByEmail(email);
    }

    public User save(User user) {
        return repository.save(user);
    }
}