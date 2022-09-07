package com.wallferjdi.wallfer.controller;


import com.wallferjdi.wallfer.entity.CategoryEntity;
import com.wallferjdi.wallfer.search.CategorySearchValues;
import com.wallferjdi.wallfer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/testCategory")
    public List<CategoryEntity> testCategory(){
        List<CategoryEntity> categoryEntityList = categoryService.findAll();
        return  categoryEntityList;
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryEntity> add(@RequestBody CategoryEntity categoryEntity){
        if(categoryEntity.getTitle()==null|| categoryEntity.getTitle().trim().length()==0){
            return new ResponseEntity("missed param title ", HttpStatus.NOT_ACCEPTABLE);
        }
       return ResponseEntity.ok(categoryService.add(categoryEntity));
    }
    @PutMapping("/update")
    public ResponseEntity<CategoryEntity> save(@RequestBody CategoryEntity categoryEntity){
        if(categoryEntity.getId()==null||categoryEntity.getId()==(0)){
            return  new ResponseEntity("missed id", HttpStatus.NOT_ACCEPTABLE);
        }

        if(categoryEntity.getTitle()==null|| categoryEntity.getTitle().trim().length()==0){
            return new ResponseEntity("missed param title ", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(categoryService.save(categoryEntity));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable long id){
        CategoryEntity categoryEntity = null;
        try {
            categoryEntity = categoryService.findById(id);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity("id "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryEntity> deleteById(@PathVariable long id){
        CategoryEntity categoryEntity = null;
        try {
           categoryService.delete(id);
        }catch (Exception e){
            return new ResponseEntity("id "+id+" not found",HttpStatus.NOT_ACCEPTABLE);
        }
        return new  ResponseEntity(id+" Delte succes ",HttpStatus.ACCEPTED);
    }
    @PostMapping("/search")
    public ResponseEntity<List<CategoryEntity>> search(@RequestBody CategorySearchValues categorySearchValues){
        return ResponseEntity.ok(categoryService.search(categorySearchValues));
    }
}
