package com.sist.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.app.mapper.CommMapper;
import com.sist.app.vo.CommVO;

@Service
public class CommService {
    
    @Autowired
    CommMapper mapper;

    public CommVO[] getList(String b_idx) {
        CommVO[] ar = null;
        List<CommVO> list = mapper.commList(b_idx);
        
        if(list != null && !list.isEmpty()) {
            ar = new CommVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }
}
