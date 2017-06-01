/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.service;

import com.xieziming.tap.execution.model.Execution;

import java.util.List;

/**
 * Created by Suny on 5/31/17.
 */
public interface ExecutionService {
    Execution save(Execution execution);
    void delete(Integer id);
    Execution findOne(Integer id);
    Iterable<Execution> findAll();
    List<Execution> withTestCase(String testCase);
    List<Execution> withPath(String path);
    List<Execution> withStatus(String status);
    List<Execution> withResult(String result);
}
