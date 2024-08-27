package com.sist.memo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.memo.service.MemoService;
import com.sist.memo.vo.MemoVO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/memo")
public class MemoController {
    @Autowired
    private MemoService service;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/list")
    public Map<String, Object> getlist(String cPage,String searchType,String searchValue){
        int nowPage=1;
        if(cPage!=null) nowPage=Integer.parseInt(cPage);

        // 총 메모 수 얻기
        int totalCount=service.getCount(searchType, searchValue);

        // Paging 객체 생성
        int perPage=5;
        int begin=(nowPage-1)*perPage;
        int end=perPage;

        //총 페이지 수를 page 객체로 부터 얻기
        
        MemoVO[] ar = service.getList(searchType, searchValue, begin, end);

        Map<String, Object> map=new HashMap<>();
        map.put("ar", ar);
        map.put("totalCount", totalCount);
        map.put("nowPage", nowPage);
        map.put("perPage", perPage);
        return map;
    }

    @RequestMapping("getMemo")
    public Map<String, Object> getMemo(@RequestParam String m_idx) {
        MemoVO vo=service.getMemo(m_idx);
        Map<String, Object> map=new HashMap<>();
        map.put("vo", vo);
        return map;
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    public int write(@RequestParam String content, @RequestParam String writer){
        MemoVO vo=new MemoVO();
        vo.setContent(content);
        vo.setWriter(writer);
        vo.setIp(request.getRemoteAddr());
        return service.write(vo);
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public Map<String, Object> edit(@RequestParam String m_idx, @RequestParam String content, @RequestParam String writer){
        MemoVO vo=new MemoVO();
        vo.setM_idx(m_idx);
        vo.setContent(content);
        vo.setWriter(writer);
        int result=service.edit(vo);
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("result", result);        
        map.put("m_idx", m_idx);
        return map;
    }
}
