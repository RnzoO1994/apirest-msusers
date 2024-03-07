package com.homework.msusers.persistence;

import com.homework.msusers.persistence.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhonePersistence {
    @Autowired
    private PhoneRepository repository;
}
