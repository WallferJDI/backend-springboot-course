package com.wallferjdi.wallfer.controller;

import com.wallferjdi.wallfer.entity.PriorityEntity;
import com.wallferjdi.wallfer.search.PrioritySearchValues;
import com.wallferjdi.wallfer.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    @Autowired
    private PriorityService service;

    @GetMapping("/all")
    public List<PriorityEntity> findAll(){
        return   service.findAll();
    }
    @PutMapping("/update")
    public ResponseEntity<PriorityEntity> save(@RequestBody PriorityEntity priorityEntity){
        if(priorityEntity.getId()==null||priorityEntity.getId()==0){
            return  new ResponseEntity("missed id",HttpStatus.NOT_ACCEPTABLE);
        }
        if(priorityEntity.getTitle()==null|| priorityEntity.getTitle().trim().length()==0){
            return new ResponseEntity("missed param title ", HttpStatus.NOT_ACCEPTABLE);
        }
        if(priorityEntity.getColor()==null|| priorityEntity.getColor().trim().length()==0){
            return new ResponseEntity("missed param color ", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(service.save(priorityEntity));
    }
    @PostMapping("/add")
    public ResponseEntity<PriorityEntity> add(@RequestBody PriorityEntity priorityEntity){
        if(priorityEntity.getId()!=null&&priorityEntity.getId()!=0){
            return new ResponseEntity("param must be null ", HttpStatus.NOT_ACCEPTABLE);
        }
        if(priorityEntity.getTitle()==null|| priorityEntity.getTitle().trim().length()==0){
            return new ResponseEntity("missed param title ", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(service.save(priorityEntity));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<PriorityEntity> findById(@PathVariable long id){
        PriorityEntity priorityEntity = null;
        try {
            priorityEntity = service.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PriorityEntity> deleteById(@PathVariable long id){
        PriorityEntity priorityEntity = null;
        try {
            service.delete(id);
        }catch (Exception e){
            return new ResponseEntity("id "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }
        return new  ResponseEntity(id+" Delte succes ",HttpStatus.ACCEPTED);
    }
    @PostMapping("/search")
    public ResponseEntity<List<PriorityEntity>> search(@RequestBody PrioritySearchValues prioritySearchValues){
      return   ResponseEntity.ok(service.searchByTitle(prioritySearchValues.getTitle()));
    }

}
