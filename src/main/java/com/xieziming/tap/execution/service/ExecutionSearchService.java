/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.service;

import com.xieziming.tap.execution.model.Execution;
import com.xieziming.tap.execution.search.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Suny on 6/8/17.
 */
@Service
public class ExecutionSearchService {
    @Autowired
    ExecutionService executionService;

    public List<Execution> findByConditions(SearchCondition searchCondition) throws Exception {
        List<Execution> executions = findByCondition(searchCondition);

        if(searchCondition.getOtherCondition() != null){
            List<Execution> otherExecutions = findByConditions(searchCondition.getOtherCondition());
            if("And".equalsIgnoreCase(searchCondition.getAndOr())){
                return executionsAnd(executions, otherExecutions);
            }else if("Or".equalsIgnoreCase(searchCondition.getAndOr())){
                return executionsOr(executions, otherExecutions);
            }else {
                throw new Exception("bad condition relation, only 'And' or 'Or' allowed!");
            }
        }

        return executions;
    }

    private List<Execution> findByCondition(SearchCondition searchCondition){
        Assert.notNull(searchCondition, "search condition should not null");

        String condition = searchCondition.getCondition();
        String value = searchCondition.getValue();

        if(condition == null || condition.isEmpty()) return null;
        if("Status".equalsIgnoreCase(condition)){
            return executionService.withStatus(value);
        }else if("Result".equalsIgnoreCase(condition)){
            return executionService.withResult(value);
        }else if("Path".equalsIgnoreCase(condition)){
            return executionService.withPath(value);
        }else if("TestCase".equalsIgnoreCase(condition)){
            return executionService.withTestCase(value);
        }
        return null;
    }

    private List<Execution> executionsAnd(List<Execution> executions1, List<Execution> executions2){
        Assert.notNull(executions1, "search condition should not null");
        Assert.notNull(executions2, "search condition should not null");

        List<Execution> executions = new LinkedList<>();

        Set<Integer> executionIds = new HashSet<>();
        for(Execution execution : executions1){
            executionIds.add(execution.getId());
        }

        for(Execution execution : executions2){
            if(executionIds.contains(execution.getId())) {
                executions.add(execution);
            }
        }
        return executions;
    }

    private List<Execution> executionsOr(List<Execution> executions1, List<Execution> executions2){
        Assert.notNull(executions1, "search condition should not null");
        Assert.notNull(executions2, "search condition should not null");

        List<Execution> executions = new LinkedList<>();

        Set<Integer> executionIds = new HashSet<>();
        for(Execution execution : executions1){
            executionIds.add(execution.getId());
            executions.add(execution);
        }

        for(Execution execution : executions2){
            if(!executionIds.contains(execution.getId())) {
                executions.add(execution);
            }
        }
        return executions;
    }
}
