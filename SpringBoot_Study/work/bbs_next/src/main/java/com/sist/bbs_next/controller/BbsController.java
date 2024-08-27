package com.sist.bbs_next.controller;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.bbs_next.service.BbsService;
import com.sist.bbs_next.util.FileRenameUtil;
import com.sist.bbs_next.util.Paging2;
import com.sist.bbs_next.vo.BbsVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/bbs")
public class BbsController {
    
    @Autowired
    private BbsService bbsService;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ServletContext application;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam String bname,String cPage){
        Map<String, Object> map = new HashMap<>();
        
        int nowPage = 1;
        if(bname==null){
            bname = "bbs";
        }

        if(cPage != null){
            nowPage = Integer.parseInt(cPage);
        }
        //총 게시물이 수를 얻어내자!
        int totalRecord = bbsService.getTotalCount(bname, null, null);
        
        Paging2 page = new Paging2(nowPage, totalRecord, 10, 5);

        //정확한 현재페이지 값 얻기
        nowPage = page.getNowPage();

        int begin = page.getBegin();
        int end = page.getEnd();

        BbsVO[] ar = bbsService.getList(bname, null, null, begin, end);

        //JSON표기가 될 수 있도록 map에 원하는 정보들을 저장한다.
        map.put("ar", ar);
        map.put("nowpage", nowPage);
        map.put("totalRecord", totalRecord);
        map.put("bname", bname);
        map.put("totalPage", page.getTotalPage());

        return map;
    }

    @GetMapping("/view")
    @ResponseBody
    public Map<String, Object> view(@RequestParam String b_idx){
        Map<String, Object> map = new HashMap<>();
        BbsVO vo = bbsService.getView(b_idx);
        map.put("vo", vo);
        return map;
    }

    @PostMapping("/write")
    @ResponseBody
    public Map<String, Object> write(BbsVO vo) throws IOException{
        Map<String, Object> map = new HashMap<>();
        vo.setIp(request.getRemoteAddr());
        if(vo.getFile().getSize()>0 && request.getContentType().startsWith("multipart/")){
            String realPath = application.getRealPath("/upload");
            File file = new File(realPath);
            if(!file.exists()){
                file.mkdirs();
            }
            String o_name=vo.getFile().getOriginalFilename();
            String f_name=FileRenameUtil.checkSameFileName(o_name, realPath);
            vo.getFile().transferTo(new File(realPath, f_name));
            System.out.println(realPath);
            vo.setOri_name(o_name);
            vo.setFile_name(f_name);
            System.out.println(realPath);
        }
        System.out.println(vo.getOri_name());
        System.out.println(vo.getFile_name());
        bbsService.addBbs(vo);
        return map;
    }
    
    @PostMapping("/add")
    @ResponseBody
    public Map<String, Object> add(BbsVO vo){
        Map<String, Object> map = new HashMap<>();
        vo.setIp(request.getRemoteAddr());
        int result = bbsService.addBbs(vo);

        map.put("result", result);
        map.put("vo", vo);
        return map;
    }
    @PostMapping("/addFile")
    @ResponseBody
    public Map<String, Object> addFile(BbsVO vo) throws IOException{
        Map<String, Object> map = new HashMap<>();
        if(vo.getFile().getSize()>0 && request.getContentType().startsWith("multipart/")){
            String realPath = application.getRealPath("/upload");
            File file = new File(realPath);
            if(!file.exists()){
                file.mkdirs();
            }
            String o_name=vo.getFile().getOriginalFilename();
            String f_name=FileRenameUtil.checkSameFileName(o_name, realPath);
            vo.getFile().transferTo(new File(realPath, f_name));
            System.out.println(realPath);
            vo.setOri_name(o_name);
            vo.setFile_name(f_name);
            System.out.println(vo.getB_idx());
            System.out.println(vo.getOri_name());
            System.out.println(vo.getFile_name());
        }
        int result = bbsService.addFile(vo);
        map.put("result", result);
        return map;
    }
}