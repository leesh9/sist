package com.sist.ex0731_jpa.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="emp")
@Getter
@Setter
public class Emp {
    @Id
    @Column(name = "empno")
    private String empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private String mgr;
    @Column(name = "hiredate")
    private String hiredate;
    @Column(name = "sal")
    private String sal;
    @Column(name = "comm")
    private String comm;
    @Column(name = "deptno")
    private String deptno;
}
