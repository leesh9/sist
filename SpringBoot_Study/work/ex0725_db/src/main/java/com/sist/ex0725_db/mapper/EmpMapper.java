package com.sist.ex0725_db.mapper;

import java.util.List;
import java.util.Map;

import com.sist.ex0725_db.vo.EmpVO;

public interface EmpMapper {
    //추상 메서드만 정의한다. 이때 기준은
    // emp.xml의 id들과 동일한 이름의 추상메서드를 정의한다.

    public List<EmpVO> all();

    public List<EmpVO> between(String begin, String end);

    public List<EmpVO> search(Map<String, String> map);
}
