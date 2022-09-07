package com.wallferjdi.wallfer.service;

import com.wallferjdi.wallfer.entity.StatEntity;
import com.wallferjdi.wallfer.repository.StatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {
    private final StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    private final Long defaultId=1l;
    public StatEntity findById(){

        return statRepository.findById(defaultId).get();
    }
}
