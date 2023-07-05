package com.wu.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LineVO {
    private List<String> month;
    private Map<String,List> status;
}
