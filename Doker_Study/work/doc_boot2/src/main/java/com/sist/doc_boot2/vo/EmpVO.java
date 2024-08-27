package com.sist.doc_boot2.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
    private String empno;
    private String ename;
    private String job;
    private String mgr;
    private String sal;
    private String comm;
    private String deptno;
}
