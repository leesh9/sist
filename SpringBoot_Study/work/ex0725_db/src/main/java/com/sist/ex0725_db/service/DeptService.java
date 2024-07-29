package com.sist.ex0725_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0725_db.mapper.DeptMapper;
import com.sist.ex0725_db.vo.DeptVO;

@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public DeptVO[] all() {
        DeptVO[] ar = null;
        List<DeptVO> list = deptMapper.all();
        if (list != null && list.size() > 0) {
            ar = new DeptVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }
}
