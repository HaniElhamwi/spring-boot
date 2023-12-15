package com.webapp.restfulwebservices;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @GetMapping(path = "/hello-world")
    public  String helloWorld() {
        return "Hello ";
    }

    @GetMapping(path = "/hello-world-bean")
    public  HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public  HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World" + name);
    }
}
