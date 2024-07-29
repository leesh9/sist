package com.sist.ex0725_db.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0725_db.mapper.EmpMapper;
import com.sist.ex0725_db.vo.EmpVO;

@Service
public class EmpService {
    @Autowired
    private EmpMapper empMapper;

    public EmpVO[] getAll() {
        EmpVO[] arr = null;
        List<EmpVO> list = empMapper.all();
        if (list != null && list.size() > 0) {
            arr = new EmpVO[list.size()];
            list.toArray(arr);
        }
        return arr;
    }

    public EmpVO[] between(String begin, String end) {
        EmpVO[] arr = null;
        List<EmpVO> list = empMapper.between(begin, end);
        if (list != null && list.size() > 0) {
            arr = new EmpVO[list.size()];
            list.toArray(arr);
        }
        return arr;
    }

    public EmpVO[] search(String type, String value) {
        EmpVO[] arr = null;
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("value", value);
        System.out.println(map);
        List<EmpVO> list = empMapper.search(map);
        if (list != null && list.size() > 0) {
            arr = new EmpVO[list.size()];
            list.toArray(arr);
        }
        return arr;
    }
}
