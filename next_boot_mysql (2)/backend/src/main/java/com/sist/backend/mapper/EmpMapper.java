package com.sist.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sist.backend.vo.EmpVO;

@Mapper
public interface EmpMapper {
    
    // 반드시 연결된 emp.xml 문서에 id들을
    // 추상 메서드로 정의해야한다.
    List<EmpVO> all();
}
