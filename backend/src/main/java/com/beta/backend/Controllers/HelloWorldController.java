package com.beta.backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.beta.backend.Models.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public Hello getHello(@RequestParam(name = "locale", defaultValue = "en") String locale,
                          @RequestParam(name = "username", defaultValue = "World") String username){
        return new Hello(locale, username);
    }
}
