package com.wu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class VO {
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date idate;
    private String status;
}
