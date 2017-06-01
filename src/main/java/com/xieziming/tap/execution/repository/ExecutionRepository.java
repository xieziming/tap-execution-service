/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.repository;

import com.xieziming.tap.execution.model.Execution;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExecutionRepository extends CrudRepository<Execution, Integer> {
    List<Execution> findByTestCase(String testCase);
    List<Execution> findByPath(String path);
    List<Execution> findByStatus(String status);
    List<Execution> findByResult(String result);
}
