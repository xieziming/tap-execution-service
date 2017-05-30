/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.repository;

import com.xieziming.tap.execution.model.Execution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A repository to manage {@link Execution} instances.
 *
 * @author Suny Xie
 */
@RepositoryRestResource(collectionResourceRel = "execution", path = "execution")
public interface ExecutionRepository extends CrudRepository<Execution, Integer> {
    Execution findByTestCase(@Param("testCase") String testCase);
    List<Execution> findByPath(@Param("path") String path);
    List<Execution> findByStatus(@Param("status") String status);
    List<Execution> findByResult(@Param("result") String result);
}
