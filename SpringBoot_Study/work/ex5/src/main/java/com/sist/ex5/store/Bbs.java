package com.sist.ex5.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="bbs_t")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bbs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="b_idx")
    private Long bidx;

    private String subject;
    private String content;
    private String writer;
    private String filename;
    private String ori_name;
    private String write_date;
    private String ip;
    private int hit;
    private String bname;
    private int status;
}