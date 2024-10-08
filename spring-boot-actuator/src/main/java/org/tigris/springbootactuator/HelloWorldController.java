package org.tigris.springbootactuator;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    private static final String template="Hello, %s!";
    private final AtomicLong counter=new AtomicLong();

    @GetMapping("/hello-world")
    public Greeting getMessage(@RequestParam(name = "name",required = false,defaultValue = "Stranger") String name){

        return  new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

}
