package com.sist.doc_boot2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.doc_boot2.mapper.EmpMapper;
import com.sist.doc_boot2.vo.EmpVO;

@Service
public class EmpService {
    @Autowired
    private EmpMapper empMapper;

    public EmpVO[] getTotal() {
        EmpVO[] ar = null;
        List<EmpVO> list = empMapper.total();
        if (list != null) {
            ar = new EmpVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }
}
