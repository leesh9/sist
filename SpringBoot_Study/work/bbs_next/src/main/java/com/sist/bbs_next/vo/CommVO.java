package com.sist.bbs_next.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommVO {
    private String c_idx, b_idx, writer, content, pwd, write_date, ip;
}
