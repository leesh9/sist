package com.sist.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.app.vo.BbsVO;

@Mapper
public interface BbsMapper {
    
    int count(String searchType, String searchValue, String bname);
    List<BbsVO> list(String searchType, String searchValue, String bname, int begin, int end);
    void write(BbsVO vo);
}
