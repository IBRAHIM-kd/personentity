package com.person.Config;


import com.person.model.Person;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
@CacheConfig(cacheNames = { "surnames" })
public class PersonDataService {
    /**
     * The method returns the  person's surnames,
     but refreshes all the entries in the cache to load new ones.
     *
     * @param  person the  person
     * @return the surnames
     */
    @CacheEvict(value = "surnames", allEntries = true)
    public String getSurname(Person person) {
        return person.getSurname();
    }
}

