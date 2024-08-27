package com.sist.doc_boot2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.doc_boot2.vo.EmpVO;

@Mapper
public interface EmpMapper {
    List<EmpVO> total();
}
