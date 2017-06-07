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
@Table(name="execution_output_text", uniqueConstraints = {@UniqueConstraint(columnNames={"execution_id", "path", "field"})})
public class ExecutionOutputText {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=50)
    private String path;

    @Column(length=50)
    private String field;

    @Column(length=500)
    private String value;

    @Column(length=100)
    private String remark;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;

    @Override
    public String toString() {
        return "ExecutionOutputText{" +
                "id=" + id +
                ", path=" + path +
                ", field=" + field +
                ", value=" + value +
                ", remark=" + remark +
                ", lastModified=" + lastModified +
                '}';
    }

    @Override
    public boolean equals(Object o){
        boolean equals = false;
        if(o != null && ExecutionOutputText.class.isAssignableFrom(o.getClass())){
            ExecutionOutputText executionOutputText = (ExecutionOutputText) o;
            equals = (new EqualsBuilder()
                    .append(path, executionOutputText.getPath())
                    .append(field, executionOutputText.getField())
                    .append(value, executionOutputText.getValue())
                    .append(remark, executionOutputText.getRemark())
                    .append(lastModified, executionOutputText.getLastModified())
                    .isEquals());
        }
        return equals;
    }
}
