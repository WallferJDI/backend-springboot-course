package com.wallferjdi.wallfer.controller;

import com.wallferjdi.wallfer.entity.StatEntity;
import com.wallferjdi.wallfer.repository.StatRepository;
import com.wallferjdi.wallfer.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatController {


    @Autowired
    private StatService statService;
    @GetMapping("/stat")
    public ResponseEntity<StatEntity> findById(){

        return ResponseEntity.ok(statService.findById());
    }


}
