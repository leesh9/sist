package com.sist.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.memo.mapper.MemoMapper;
import com.sist.memo.vo.MemoVO;

@Service
public class MemoService {
    
    @Autowired
    private MemoMapper mapper;

    public int getCount(String searchType, String searchValue){
        return mapper.count(searchType, searchValue);   
    }

    public MemoVO[] getList(String searchType, String searchValue, int begin, int end){
        MemoVO[] ar=null;
        List<MemoVO> list=mapper.list(searchType, searchValue, begin, end);
        if(list!=null){
            ar=new MemoVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    public MemoVO getMemo(String m_idx){
        return mapper.get_memo(m_idx);
    }

    public int write(MemoVO vo){
        return mapper.write(vo);
    }

    public int edit(MemoVO vo){
        return mapper.edit(vo);
    }
}
