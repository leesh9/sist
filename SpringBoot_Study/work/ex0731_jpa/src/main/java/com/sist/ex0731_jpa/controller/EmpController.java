package com.sist.ex0731_jpa.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sist.ex0731_jpa.service.EmpService;
import com.sist.ex0731_jpa.store.Emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @GetMapping("all")
    public String all() {
        StringBuffer sb = new StringBuffer();
        
        Emp[] ar = empService.getAll();
        for (Emp emp : ar) {
            sb.append(emp.getEmpno())
                .append(":")
                .append(emp.getEname())
                .append("<br>");
        }

        return sb.toString();
    }

    @GetMapping("search_Name")
    public String searchName(@RequestParam("ename") String ename) {
        StringBuffer sb = new StringBuffer();

        Emp[] ar = empService.searchName(ename);
        for (Emp emp : ar) {
            sb.append(emp.getEmpno())
                .append(":")
                .append(emp.getEname())
                .append(":")
                .append(emp.getJob())
                .append("<br>");
        }

        return sb.toString();
    }
    
    @GetMapping("search_Name_Like")
    public String searchNameLike(@RequestParam("ename") String ename) {
        StringBuffer sb = new StringBuffer();

        Emp[] ar = empService.searchNameLike(ename);
        for (Emp emp : ar) {
            sb.append(emp.getEmpno())
                .append(":")
                .append(emp.getEname())
                .append(":")
                .append(emp.getJob())
                .append("<br>");
        }

        return sb.toString();
    }

    @GetMapping("search_Job")
    public String searchJob(@RequestParam("job") String job) {
        StringBuffer sb = new StringBuffer();

        Emp[] ar = empService.searchJob(job);
        for (Emp emp : ar) {
            sb.append(emp.getEmpno())
                .append(":")
                .append(emp.getEname())
                .append(":")
                .append(emp.getJob())
                .append("<br>");
        }

        return sb.toString();
    }

    @GetMapping("searchJD")
    public String searchJobAndDeptno( String job, String deptno) {
        StringBuffer sb = new StringBuffer();

        if(job == null) {
            job = "DEVELOP";
        }
        if(deptno == null) {
            deptno = "10";
        }

        Emp[] ar = empService.searchJobAndDeptno(job, deptno);
        for (Emp emp : ar) {
            sb.append(emp.getEmpno())
                .append(":")
                .append(emp.getEname())
                .append(":")
                .append(emp.getJob())
                .append(":")
                .append(emp.getDeptno())
                .append("<br>");
        }

        return sb.toString();
    }
}
