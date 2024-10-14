package com.example.demo.controller;

import com.example.demo.kafka.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    ProducerService service;

    @GetMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody Message msg){
        service.send("participants", msg);
        return ResponseEntity.ok("Ваше участие подтверждено!");
    }

}
