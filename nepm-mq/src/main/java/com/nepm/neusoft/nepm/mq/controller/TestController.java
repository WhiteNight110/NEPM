package com.nepm.neusoft.nepm.mq.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class TestController {

    @GetMapping("/test")
    public ResponseEntity test() {
        System.out.println("test........");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
