package com.zyh.domain;

import lombok.Data;

import java.util.Date;
@Data
public class emp {
    private Integer id;
    private String name;
    private Integer age;
    private String job;
    private Integer salary;
    private Date entrydate;
    private Integer managerid;
    private Integer deptId;
}
