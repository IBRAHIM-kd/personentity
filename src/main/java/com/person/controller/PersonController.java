package com.person.controller;

import  com.person.model.Person;
import  com.person.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
public class PersonController {


    @RequestMapping("/lombok")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @Autowired
    private PersonRepository repository;

    /**
     * @return
     */
    // Get all Person
    @GetMapping("/person")
    List<Person> findAll() {
        return (List<Person>) repository.findAll();
    }


    /**
     * @param listPageable
     * @return
     */
    //
    @Autowired
    private PersonRepository personData;
    @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
    Page<Person> employeesPageable(Pageable pageable) {
        return personData.findAll(pageable);

    }


    /**
     * @param newPerson
     * @return
     */
    // Save Person
    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    Person newPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }

    /**
     * @param id
     * @return
     */
    // Find by ID Person
    @GetMapping("/person/{id}")
    Optional<Person> findOne(@PathVariable Integer id) {
        return repository.findById(id);
    }

    /**
     * @param newPerson
     * @param id
     * @return
     */
    // Save or update Person
    @PutMapping("/person/{id}")
    Person saveOrUpdate(@RequestBody Person newPerson, @PathVariable Integer id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newPerson.getName());
                    x.setSurname(newPerson.getSurname());
                    x.setAge(newPerson.getAge());
                    x.setSex(newPerson.getSex());
                    x.setBirthday(newPerson.getBirthday());
                    x.setPhone(newPerson.getPhone());
                    x.setEmail(newPerson.getEmail());
                    x.setContacts(newPerson.getContacts());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return repository.save(newPerson);
                });
    }

    /**
     * @param id
     */
    // Delete Person
    @DeleteMapping("/person/{id}")
    void deletePerson(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}



