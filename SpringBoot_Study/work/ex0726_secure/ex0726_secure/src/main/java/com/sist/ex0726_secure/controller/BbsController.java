package com.sist.ex0726_secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sist.ex0726_secure.service.BbsService;
import com.sist.ex0726_secure.vo.BbsVO;

@Controller
public class BbsController {
    
    //DB 활용을 위한 service
    @Autowired
    private BbsService b_service;

    @RequestMapping("/bbs")
    public ModelAndView bbsList(@RequestParam("bname") String bname,String cPage,String searchType,String searchValue){
        ModelAndView mv = new ModelAndView();
        int nowPage = 1;
        //현재 페이지값인 cPage가 null이 아니면 사용자가
        // 가고자 하는 페이지가 있으므로 nowPage값을 cPage로 변경하자!
        if(cPage != null){
            nowPage = Integer.parseInt(cPage);
        }
        if(bname != null){
            bname = "bbs";
        }

        //총 게시물의 수를 구해야 한다.
        int totalRecord = b_service.getCount(bname, searchType, searchValue);
        // Paging2객체 생성 후 페이징 HTML코드 생성까지 수항하는 객체 준비

        //뷰페이지에서 보여질 게시물을 얻어내어 mv에 저장
        BbsVO[] bbsList = b_service.getList(bname, "1", "10", searchType, searchValue);
        mv.addObject("list", bbsList);
        mv.setViewName(bname+"/list");
        mv.addObject("bname", bname);
        return mv;
    }
}
