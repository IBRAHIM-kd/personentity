package com.person.services;

import com.person.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;


public abstract class PersonService {

    abstract Page<Person> findAll(Pageable pageable);

}





