/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.model;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Suny on 5/8/16.
 */
@Data
@Entity
@Table(name="execution_context")
public class ExecutionContext {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=50)
    private String name;

    @Column(length=1000)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;

    @Override
    public String toString() {
        return "ExecutionContext{" +
                "id=" + id +
                ", name=" + name +
                ", content=" + content +
                ", lastModified=" + lastModified +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && ExecutionContext.class.isAssignableFrom(o.getClass())){
            ExecutionContext executionContext = (ExecutionContext) o;
            equals = (new EqualsBuilder()
                    .append(name, executionContext.getName())
                    .append(content, executionContext.getContent())
                    .append(lastModified, executionContext.getLastModified())
                    .isEquals());
        }
        return equals;
    }
}
