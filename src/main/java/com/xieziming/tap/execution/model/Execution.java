/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Suny on 5/8/16.
 */
@Data
@Entity
@Table(name="execution")
public class Execution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=100, nullable = false)
    private String path;

    @Column(length=100, nullable = false)
    private String testCase;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ExecutionContext executionContext;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Column(length=50)
    private String status;

    @Column(length=50)
    private String result;

    @Column(length=500)
    private String remark;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "execution")
    private List<ExecutionLog> executionLogs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "execution")
    private List<ExecutionOutputText> executionOutputTexts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "execution")
    private List<ExecutionOutputFile> executionOutputFiles;
}
