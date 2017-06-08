/*
 * Author: Suny Xie
 * Email: inbox@xieziming.com
 * Copyright (c) 2017 xieziming.com All rights reserved.
 */

package com.xieziming.tap.execution.search;

import lombok.Data;

/**
 * Created by Suny on 6/8/17.
 */
@Data
public class SearchCondition {
    private String condition;
    private String value;

    private String andOr;
    private SearchCondition otherCondition;
}
