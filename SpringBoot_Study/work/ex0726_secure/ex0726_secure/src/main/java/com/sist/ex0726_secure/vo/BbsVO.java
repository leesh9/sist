package com.sist.ex0726_secure.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BbsVO {
    private String b_idx, subject, writer, content, file_name, ori_name, write_date, ip, hit, bname, status;
    private List<CommVO> c_list; //댓글 객체
    private MultipartFile file;// 첨부파일
    
}
