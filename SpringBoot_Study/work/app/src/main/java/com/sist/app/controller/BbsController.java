package com.sist.app.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.app.service.BbsService;
import com.sist.app.util.FileRenameUtil;
import com.sist.app.util.Paging2;
import com.sist.app.vo.BbsVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class BbsController {
    
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BbsService bService;

    @Autowired
    private ServletContext application;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${server.upload.path}")
    private String upload;

    @RequestMapping("list")
    public ModelAndView list(@RequestParam String bname, String searchType, String searchValue, String cPage) {
        ModelAndView mv = new ModelAndView();

        int nowPage = 1;

        if(cPage != null) {
            nowPage = Integer.parseInt(cPage);
        }
        if(bname == null || bname.trim().length() == 0) {
            bname = "bbs";
        }

        int totalRecord = bService.getCount(searchType, searchValue, bname);

        Paging2 page = new Paging2(nowPage, totalRecord, 7, 5);

        nowPage = page.getNowPage();

        // 페이징 HTML
        String pageCode = page.getSb().toString();

        int begin = page.getBegin();
        int end = page.getEnd();

        BbsVO[] ar = bService.getList(searchType, searchValue, bname, begin, end);

        mv.addObject("ar", ar);
        mv.addObject("page", page);
        mv.addObject("pageCode", pageCode);
        mv.addObject("totalRecord", totalRecord);
        mv.addObject("numPerPage", page.getNumPerPage());
        mv.addObject("bname", bname);
        mv.addObject("nowPage", nowPage);

        mv.setViewName(bname + "/list");

        return mv;
    }

    @RequestMapping(value = "write", method = RequestMethod.GET)
    public String write(String bname,String cPage) {
        return "bbs/write";
    }

    @RequestMapping(value = "write", method=RequestMethod.POST)
    public ModelAndView write(BbsVO vo) throws Exception {
        String c_type = request.getContentType();
        ModelAndView mv = new ModelAndView();
        String o_name = vo.getOri_name();
        String f_name = vo.getFile_name();
        String bname = vo.getBname();
        if(vo.getFile().getSize()>0 && c_type.startsWith("multipart")&&vo.getFile()!=null){
            String realPath = application.getRealPath(upload);
            o_name=vo.getFile().getOriginalFilename();
            f_name=FileRenameUtil.checkSameFileName(o_name, realPath);
            vo.getFile().transferTo(new File(realPath, f_name));
            System.out.println(realPath);
        }
        vo.setOri_name(o_name);
        vo.setFile_name(f_name);
        bService.write(vo);
        mv.setViewName("redirect:/list?bname=" + vo.getBname());
        return mv;
    }
    
    @RequestMapping(value="saveImg", method=RequestMethod.POST)
    public Map<String, String> saveImg(MultipartFile file) throws Exception{
        Map<String, String> map = new HashMap<>();
        if(file.getSize()>0 && file!=null) {
            String realPath = application.getRealPath("/resources/editor_img");
            String o_name = file.getOriginalFilename();
            String f_name = FileRenameUtil.checkSameFileName(o_name, realPath);
            file.transferTo(new File(realPath, f_name));
            map.put("fileName", f_name);
        }
        String c_path = request.getContextPath();
        map.put("url", c_path + "/resources/editor_img/");
        return map;
    }
    
    
    
}
