package com.sithes.springbootcicd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    public String index() {
      log.info("Entering into HelloController.index method");
      return "You are currently in Index Home Page";
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(required = true) String hello) {
        log.info("Entering into HelloController.hello method with {}",hello);
        return "You are currently in Hello Page with ["+hello+"]";
    }
}

