package com.wallferjdi.wallfer.service;

import com.wallferjdi.wallfer.entity.TaskEntity;
import com.wallferjdi.wallfer.repository.TaskRepository;
import com.wallferjdi.wallfer.search.TaskSearchValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> findAll(){
        return taskRepository.findAll();
    }
    public TaskEntity add(TaskEntity entity){
        return taskRepository.save(entity);
    }
    public TaskEntity save(TaskEntity entity){
        return taskRepository.save(entity);
    }
    public TaskEntity findById(long id){
        return taskRepository.findById(id).get();
    }
    public void delete(long id){
        taskRepository.deleteById(id);
    }
    public Page<TaskEntity> findByParams(TaskSearchValues taskSearchValues, PageRequest pageRequest){
        return   taskRepository.findByParams(taskSearchValues.getTitle(),
                taskSearchValues.getCompleted(),
                taskSearchValues.getPriorityId(),
                taskSearchValues.getCategoryId(),pageRequest);
    }
}
