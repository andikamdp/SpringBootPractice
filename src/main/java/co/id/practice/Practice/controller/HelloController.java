package co.id.practice.practice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
}
