package com.sist.ex0731_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.ex0731_jpa.repository.EmpRepository;
import com.sist.ex0731_jpa.store.Emp;

@Service
public class EmpService {
    @Autowired
    private EmpRepository empRepository;

    public Emp[] getAll() {
        Emp[] ar = null;

        List<Emp> list = empRepository.findAll();
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }

        return ar;
    }
    
    public Emp[] searchName(String ename) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findByEname(ename);
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public Emp[] searchNameContaining(String ename) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findByEnameContaining(ename);
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public Emp[] searchNameLike(String ename) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findByEnameLike("%" + ename + "%");
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public Emp[] searchJob(String job) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findByJob(job);
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public Emp[] searchJobContaining(String job) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findByJobContaining(job);
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public Emp[] searchJobAndDeptno(String job, String deptno) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findByJobAndDeptno(job, deptno);
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public Emp[] searchSalLessThan(int salary) {
        Emp[] ar = null;

        List<Emp> list = empRepository.findBySalLessThan(salary);
        if (list != null && list.size() > 0) {
            ar = new Emp[list.size()];
            list.toArray(ar);
        }
        return ar;
    }
}
