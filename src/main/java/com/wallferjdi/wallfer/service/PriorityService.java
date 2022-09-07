package com.wallferjdi.wallfer.service;

import com.wallferjdi.wallfer.entity.CategoryEntity;
import com.wallferjdi.wallfer.entity.PriorityEntity;
import com.wallferjdi.wallfer.repository.CategoryRepository;
import com.wallferjdi.wallfer.repository.PriorityRepository;
import com.wallferjdi.wallfer.search.CategorySearchValues;
import com.wallferjdi.wallfer.search.PrioritySearchValues;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<PriorityEntity> findAll(){
        return priorityRepository.findAll();
    }
    public PriorityEntity add(PriorityEntity entity){
        return priorityRepository.save(entity);
    }
    public PriorityEntity save(PriorityEntity entity){
        return priorityRepository.save(entity);
    }
    public PriorityEntity findById(long id){
        return priorityRepository.findById(id).get();
    }
    public void delete(long id){
        priorityRepository.deleteById(id);
    }
    public List<PriorityEntity> searchByTitle(String title){
        return   priorityRepository.findByTitle(title);
    }
}
