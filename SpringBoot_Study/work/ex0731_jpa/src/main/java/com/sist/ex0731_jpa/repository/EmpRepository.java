package com.sist.ex0731_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.ex0731_jpa.store.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp, String> {
    //상속받은 finAll()등이 있는 상태
    List<Emp> findByEname(String ename);
    List<Emp> findByEnameContaining(String ename);
    List<Emp> findByEnameLike(String ename);
    List<Emp> findByJob(String job);
    List<Emp> findByJobContaining(String job);
    List<Emp> findByJobAndDeptno(String job, String deptno);
    List<Emp> findBySalLessThan(int sal);
    List<Emp> findBySalLessThanEqual(int sal);
}
