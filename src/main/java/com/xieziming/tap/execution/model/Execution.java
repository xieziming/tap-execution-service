/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.model;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;

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
    private String path = "unclassified";

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

    @OneToMany(targetEntity = ExecutionLog.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "execution_id")
    private List<ExecutionLog> executionLogs;

    @OneToMany(targetEntity = ExecutionOutputText.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "execution_id")
    private List<ExecutionOutputText> executionOutputTexts;

    @OneToMany(targetEntity = ExecutionOutputFile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "execution_id")
    private List<ExecutionOutputFile> executionOutputFiles;

    @Override
    public String toString() {
        return "Execution{" +
                "id=" + id +
                ", path=" + path +
                ", testCase=" + testCase +
                ", executionContext=" + executionContext +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", result=" + result +
                ", remark=" + remark +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && Execution.class.isAssignableFrom(o.getClass())){
            Execution execution = (Execution) o;
            equals = (new EqualsBuilder()
                    .append(path, execution.getPath())
                    .append(testCase, execution.getTestCase())
                    .append(executionContext, execution.getExecutionContext())
                    .append(startTime, execution.getStartTime())
                    .append(endTime, execution.getEndTime())
                    .append(status, execution.getStatus())
                    .append(result, execution.getResult())
                    .append(remark, execution.getRemark())
                    .append(executionLogs, execution.getExecutionLogs())
                    .append(executionOutputTexts, execution.getExecutionOutputTexts())
                    .append(executionOutputFiles, execution.getExecutionOutputFiles())
                    .isEquals());
        }
        return equals;
    }
}
