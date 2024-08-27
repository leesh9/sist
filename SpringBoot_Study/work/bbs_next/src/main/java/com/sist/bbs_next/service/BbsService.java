package com.sist.bbs_next.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.bbs_next.mapper.BbsMapper;
import com.sist.bbs_next.vo.BbsVO;

@Service
public class BbsService {
    @Autowired
    private BbsMapper bbsMapper;

    public int getTotalCount(String bname,String searchType,String searchValue){
        return bbsMapper.count(bname, searchType, searchValue);
    }

    public BbsVO[] getList(String bname,String searchType,String searchValue,int begin,int end){
        BbsVO[] ar = null;
        List<BbsVO> list = bbsMapper.bbsList(bname, searchType, searchValue, begin, end);
        if(list!=null&&list.size()>0){
            ar = new BbsVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }

    // 기본키를 받아서 해당 게시물만 반환
    public BbsVO getView(String b_idx){
        return bbsMapper.view(b_idx);
    }

    //원글저장
    public int addBbs(BbsVO bbs){
        return bbsMapper.write(bbs);
    }

    //조회수 증가
    public int updateHit(String b_idx){
        return bbsMapper.hit(b_idx);
    }

    //파일추가
    public int addFile(BbsVO bbs){
        return bbsMapper.addFile(bbs);
    }
}
