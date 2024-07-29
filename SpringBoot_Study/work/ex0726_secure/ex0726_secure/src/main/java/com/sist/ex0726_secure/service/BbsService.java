package com.sist.ex0726_secure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0726_secure.mapper.BbsMapper;
import com.sist.ex0726_secure.vo.BbsVO;

@Service
public class BbsService {
    @Autowired
    private BbsMapper mapper;

    public int getCount(String bname, String searchType, String searchValue) {
        return mapper.count(bname, searchType, searchValue);
    }

    public BbsVO[] getList(String bname, String begin, String end, String searchType, String searchValue) {
        BbsVO[] ar = null;

        List<BbsVO> list = mapper.list(bname, begin, end, searchType, searchValue);
        if(list != null) {
            ar = new BbsVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }
}
