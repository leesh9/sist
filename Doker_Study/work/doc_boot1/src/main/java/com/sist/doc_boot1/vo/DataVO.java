package com.sist.doc_boot1.vo;

public class DataVO {
    private int num;
    private String msg;

    public DataVO() {}

    public DataVO(int num, String msg) {
        this.num = num;
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
