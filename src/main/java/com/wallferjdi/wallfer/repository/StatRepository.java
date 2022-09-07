package com.wallferjdi.wallfer.repository;

import com.wallferjdi.wallfer.entity.StatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<StatEntity,Long> {
}
