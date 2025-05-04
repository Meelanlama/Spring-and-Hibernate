package com.tutorial.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String fun() {
        return "Fun!";
    }

    @GetMapping("/workout")
    public String workout() {
        return "I will workout 1 hour!";
    }

    @GetMapping("/fortune")
    public String fortune() {
        return "Today is a good and lucky day!";
    }
}
