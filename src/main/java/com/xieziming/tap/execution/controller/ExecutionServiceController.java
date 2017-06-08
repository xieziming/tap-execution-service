/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.controller;

import com.xieziming.tap.execution.model.Execution;
import com.xieziming.tap.execution.search.SearchCondition;
import com.xieziming.tap.execution.service.ExecutionSearchService;
import com.xieziming.tap.execution.service.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Suny on 5/31/17.
 */
@RestController
@RequestMapping("/executions")
public class ExecutionServiceController {
    @Autowired
    ExecutionService executionService;

    @Autowired
    ExecutionSearchService executionSearchService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Execution> findAll(){
        return executionService.findAll();
    }

    @RequestMapping(value = "", method = {RequestMethod.PUT, RequestMethod.POST})
    public Execution save(@RequestBody Execution execution){
        return executionService.save(execution);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Execution find(@PathVariable Integer id){
        return executionService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        executionService.delete(id);
    }

    @RequestMapping(value = "search/path", method = RequestMethod.POST)
    public List<Execution> withPath(String path){
        return executionService.withPath(path);
    }

    @RequestMapping(value = "search/status/{status}", method = RequestMethod.GET)
    public List<Execution> withStatus(@PathVariable String status){
        return executionService.withStatus(status);
    }

    @RequestMapping(value = "search/result/{result}", method = RequestMethod.GET)
    public List<Execution> withResult(@PathVariable String result){
        return executionService.withResult(result);
    }

    @RequestMapping(value = "search/testCase/{testCase}", method = RequestMethod.GET)
    public List<Execution> withTestCase(@PathVariable String testCase){
        return executionService.withTestCase(testCase);
    }

    @RequestMapping(value = "search", method = {RequestMethod.PUT, RequestMethod.POST})
    public List<Execution> search(@RequestBody SearchCondition searchCondition) throws Exception {
        return executionSearchService.findByConditions(searchCondition);
    }
}
