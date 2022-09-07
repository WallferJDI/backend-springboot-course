package com.wallferjdi.wallfer.service;

import com.wallferjdi.wallfer.entity.CategoryEntity;
import com.wallferjdi.wallfer.repository.CategoryRepository;
import com.wallferjdi.wallfer.search.CategorySearchValues;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }
    public CategoryEntity add(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }
    public CategoryEntity save(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }
    public CategoryEntity findById( long id){
       return categoryRepository.findById(id).get();
    }
    public void delete(long id){
        categoryRepository.deleteById(id);
    }
    public List<CategoryEntity> search(CategorySearchValues categorySearchValues){
      return   categoryRepository.findByTitle(categorySearchValues.getTitle());
    }
}

