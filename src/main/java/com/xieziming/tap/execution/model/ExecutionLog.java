/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.model;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Suny on 5/8/16.
 */
@Data
@Entity
@Table(name="execution_log")
public class ExecutionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=50)
    private String level;

    @Column(length=1000)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date time;

    @Override
    public String toString() {
        return "ExecutionLog{" +
                "id=" + id +
                ", level=" + level +
                ", content=" + content +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && ExecutionLog.class.isAssignableFrom(o.getClass())){
            ExecutionLog executionLog = (ExecutionLog) o;
            equals = (new EqualsBuilder()
                    .append(level, executionLog.getLevel())
                    .append(content, executionLog.getContent())
                    .append(time, executionLog.getTime())
                    .isEquals());
        }
        return equals;
    }
}
