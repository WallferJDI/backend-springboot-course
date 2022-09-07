package com.wallferjdi.wallfer.repository;
import com.wallferjdi.wallfer.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {


    @Query("SELECT t FROM TaskEntity t where (:title is null or :title='' or lower(t.title) like lower(concat('%',:title,'%') )) and " +
            "(:completed is null or t.completed=:completed) and" +
            "(:priorityId is null or t.priorityByPriorityId.id=:priorityId) and " +
            "(:categoryId is null or t.categoryByCategoryId.id=:categoryId)")
    Page<TaskEntity> findByParams(@Param("title") String title,
                                  @Param("completed") Integer completed,
                                  @Param("priorityId" )Long priorityId,
                                  @Param("categoryId") Long categoryId,
                                  Pageable pageable);

}
