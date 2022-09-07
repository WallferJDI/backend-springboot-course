package com.wallferjdi.wallfer.controller;

import com.wallferjdi.wallfer.entity.TaskEntity;
import com.wallferjdi.wallfer.search.TaskSearchValues;
import com.wallferjdi.wallfer.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {



    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<TaskEntity> findAll(){
        return   taskService.findAll();
    }
    @PutMapping("/update")
    public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity taskEntity){
        if(taskEntity.getId()==null||taskEntity.getId()==0){
            return  new ResponseEntity("missed id", HttpStatus.NOT_ACCEPTABLE);
        }
        if(taskEntity.getTitle()==null|| taskEntity.getTitle().trim().length()==0){
            return new ResponseEntity("missed param title ", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(taskService.save(taskEntity));
    }
    @PostMapping("/add")
    public ResponseEntity<TaskEntity> add(@RequestBody TaskEntity taskEntity){
        if(taskEntity.getId()!=null&&taskEntity.getId()!=0){
            return new ResponseEntity("param must be null ", HttpStatus.NOT_ACCEPTABLE);
        }
        if(taskEntity.getTitle()==null|| taskEntity.getTitle().trim().length()==0){
            return new ResponseEntity("missed param title ", HttpStatus.NOT_ACCEPTABLE);
        }

        taskService.save(taskEntity);
        return new  ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<TaskEntity> findById(@PathVariable long id){
        TaskEntity taskEntity = null;
        try {
            taskEntity = taskService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(taskEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaskEntity> deleteById(@PathVariable long id){
        TaskEntity TaskEntity = null;
        try {
            taskService.delete(id);
        }catch (Exception e){
            return new ResponseEntity("id "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }
        return new  ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/search")
    public ResponseEntity<Page<TaskEntity>> search(@RequestBody TaskSearchValues taskSearchValues){

        Sort sort = Sort.by(taskSearchValues.getSortDirection().trim().equals("asc")?Sort.Direction.ASC:Sort.Direction.DESC
                ,taskSearchValues.getSortColumn());
        PageRequest pageRequest = PageRequest.of(taskSearchValues.getPageNumber(),taskSearchValues.getPageSize(),sort) ;
        Page result = taskService.findByParams(taskSearchValues,pageRequest);
       return ResponseEntity.ok(result);

    }
}
