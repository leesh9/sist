package com.sist.ex0726_secure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.ex0726_secure.vo.BbsVO;

@Mapper
public interface BbsMapper {

    int count(String bname, String searchType, String searchValue);

    public List<BbsVO> list(String bname, String begin, String end, String searchType, String searchValue);
}