package com.sist.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.app.mapper.BbsMapper;
import com.sist.app.vo.BbsVO;

@Service
public class BbsService {

    @Autowired
    private BbsMapper mapper;

    public int getCount(String searchType, String searchValue, String bname) {
        return mapper.count(searchType, searchValue, bname);
    }

    public BbsVO[] getList(String searchType, String searchValue, String bname, int begin, int end) {
        BbsVO[] ar = null;

        List<BbsVO> list = mapper.list(searchType, searchValue, bname, begin, end);

        if(list != null && list.size() > 0) {
            ar = new BbsVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }

    public void write(BbsVO vo) {
        mapper.write(vo);
    }
}
