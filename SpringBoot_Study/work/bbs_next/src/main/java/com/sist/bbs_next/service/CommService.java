package com.sist.bbs_next.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.bbs_next.mapper.CommMapper;
import com.sist.bbs_next.vo.CommVO;

@Service
public class CommService {
    @Autowired
    private CommMapper commMapper;

    public CommVO[] commList(String b_idx){
        CommVO[] ar = null;
        List<CommVO> list = commMapper.commList(b_idx);
        if(list!=null&&list.size()>0){
            ar = new CommVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }
}
