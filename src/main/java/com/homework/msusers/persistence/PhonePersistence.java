package com.homework.msusers.persistence;

import com.homework.msusers.domain.PhoneUserRequest;
import com.homework.msusers.persistence.entity.Phone;
import com.homework.msusers.persistence.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonePersistence {
    @Autowired
    private PhoneRepository repository;

    public void saveAll(List<Phone> phones) {
        repository.saveAll(phones);
    }
}
