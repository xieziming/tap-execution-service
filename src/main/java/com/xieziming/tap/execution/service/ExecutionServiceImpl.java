/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.service;

import com.xieziming.tap.execution.model.Execution;
import com.xieziming.tap.execution.repository.ExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Suny on 5/31/17.
 */
@Service
public class ExecutionServiceImpl implements ExecutionService{
    @Autowired
    ExecutionRepository executionRepository;

    @Override
    @CachePut(value = "execution", key = "#execution.id")
    public Execution save(Execution execution) {
        Execution executionSaved = executionRepository.save(execution);
        return executionSaved;
    }

    @Override
    @CacheEvict(value = "execution", key = "#id")
    public void delete(Integer id){
        executionRepository.delete(id);
    }

    @Override
    @Cacheable(value = "execution", key = "#id")
    public Execution findOne(Integer id) {
        return executionRepository.findOne(id);
    }

    @Override
    @Cacheable(value = "execution_search")
    public Iterable<Execution> findAll() {
        return executionRepository.findAll();
    }


    @Override
    @Cacheable(value = "execution_search", key = "'testCase_'+#testCase.id")
    public List<Execution> withTestCase(String testCase) {
        return executionRepository.findByTestCase(testCase);
    }

    @Override
    @Cacheable(value = "execution_search", key = "'path'+#path")
    public List<Execution> withPath(String path) {
        return executionRepository.findByPath(path);
    }

    @Override
    @Cacheable(value = "execution_search", key = "'status'+#status")
    public List<Execution> withStatus(String status) {
        return executionRepository.findByStatus(status);
    }

    @Override
    @Cacheable(value = "execution_search", key = "'result_'+#result")
    public List<Execution> withResult(String result) {
        return executionRepository.findByResult(result);
    }
}
