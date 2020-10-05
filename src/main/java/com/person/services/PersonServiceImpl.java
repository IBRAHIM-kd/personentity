package com.person.services;

import com.person.model.Person;
import com.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl extends PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

