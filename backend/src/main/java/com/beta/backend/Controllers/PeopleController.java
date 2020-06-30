package com.beta.backend.Controllers;


import com.beta.backend.Exceptions.PersonNotFoundException;
import com.beta.backend.Models.Person;
import com.beta.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PeopleController {
/**
 * Controller for Postgres connection testing
  */

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") long id) throws PersonNotFoundException {
        Person person =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new PersonNotFoundException() );
        return ResponseEntity.ok().body(person);

    }

    @GetMapping("/people")
    public List<Person> getAllPersons(){
        return userRepository.findAll();
    }

}
