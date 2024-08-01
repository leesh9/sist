package com.sist.app.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.app.service.BbsService;
import com.sist.app.util.FileRenameUtil;
import com.sist.app.util.Paging2;
import com.sist.app.vo.BbsVO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class BbsController {
    
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BbsService bService;

    @Autowired
    private HttpSession session;

    @Autowired
    private ServletContext application;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private HttpServletResponse response;

    @Value("${server.upload.path}")
    private String upload;

    @Value("${server.editor_img.path}")
    private String editor_img;

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
        String o_name = null;
        String f_name = null;
        if(vo.getFile().getSize()>0 && c_type.startsWith("multipart")){
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
    
    @ResponseBody
    @RequestMapping(value="saveImg", method=RequestMethod.POST)
    public Map<String, String> saveImg(MultipartFile file) throws Exception{
        Map<String, String> map = new HashMap<>();
        if(file.getSize()>0 && file!=null) {
            String realPath = application.getRealPath("/resources/editor_img");
            String o_name = file.getOriginalFilename();
            String f_name = FileRenameUtil.checkSameFileName(o_name, realPath);
            file.transferTo(new File(realPath, f_name));
            map.put("fname", f_name);
        }
        String c_path = request.getContextPath();
        map.put("url", c_path + editor_img);
        return map;
    }
    
    @RequestMapping(value = "/view", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam String b_idx,String cPage,String bname) {
        ModelAndView mv = new ModelAndView();
        BbsVO vo = bService.view(b_idx);
        //세션에 read_list라는 이름으로 저장된 객체 얻기
        Object obj = session.getAttribute("read_list");
        ArrayList<BbsVO> list = null;
        if(obj==null) {
            list = new ArrayList<BbsVO>();
        }else {
            list = (ArrayList<BbsVO>)obj;
        }

        boolean chk =false;
        for(BbsVO bvo : list) {
            if(bvo.getB_idx().equals(b_idx)) {
                chk = true;
                break;// 탈출!
            }
        }
        if(!chk) {
            int hit = Integer.parseInt(vo.getHit());
            hit++;
            vo.setHit(String.valueOf(hit));
            bService.hit(b_idx);
            list.add(vo);
            session.setAttribute("read_list", list);
        }
        mv.addObject("vo", vo);
        mv.setViewName("bbs/view");
        return mv;
    }
    
    @RequestMapping(value="download", method=RequestMethod.POST)
    public ResponseEntity<Resource> download(@RequestParam String fname) throws Exception {
        //파일들이 위치하는 곳(upload)를 절대경로화 시킨다.
        String realPath = application.getRealPath(upload+"/"+fname);
        File f = new File(realPath);
        if(f.exists()) {
            //파일이 실재 존재할 경우
            byte[] buf = new byte[4096];
            int size = -1;
            //다운로드애 필요한 스트림을 준비
            BufferedInputStream bis = null;
            FileInputStream fis = null;
            //보내기할 때 필요한 스트림 준비
            BufferedOutputStream bos = null;
            ServletOutputStream sos = null;// 응답을 하는 것이 접속자의
            // 컴퓨터로 다운로드 시켜야 하기 때문에 response 를 통해
            //outputstream 을 얻는다.

            try{
                //접속자 화면에 다운로드 창 보여준다.
                response.setHeader("Content-Disposition", "attachment;filename=" + new String(fname.getBytes("utf-8"), "ISO-8859-1"));
                response.setContentType("application/x-msdownload");
                
                //다운로드할 파일과 연결되는 스트림
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                
                //response를 통해 이미 out이라는 스트림이 존재하므로
                // 다운로드를 시키기위해 스트림 준비하자
                sos = response.getOutputStream();
                bos = new BufferedOutputStream(sos);

                while((size=bis.read(buf))!=-1) {
                    bos.write(buf, 0, size);
                    bos.flush();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }finally{
                if(bos!=null) bos.close();
                if(bis!=null) bis.close();
                if(fis!=null) fis.close();
                if(sos!=null) sos.close();
            }

        }
        return null;
    }
    
    
}
