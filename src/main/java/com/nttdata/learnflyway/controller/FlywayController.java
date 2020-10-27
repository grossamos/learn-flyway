package com.nttdata.learnflyway.controller;

import com.nttdata.learnflyway.Car;
import com.nttdata.learnflyway.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/")
public class FlywayController {
    private final Repository repo;

    public FlywayController(Repository repo) {
        this.repo = repo;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addStuff(@RequestBody Car car){
        repo.save(car);
        return new ResponseEntity<>("It worked", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<String> removeStuff(@RequestParam(value = "id") int id){
        repo.deleteById(id);
        return new ResponseEntity<>("It worked", HttpStatus.NO_CONTENT);
    }

}
