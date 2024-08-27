package com.sist.ex0731_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.ex0731_jpa.repository.BbsRepository;
import com.sist.ex0731_jpa.store.Bbs;

@Service
public class BbsService {
    @Autowired
    private BbsRepository bbsRepository;

    public Bbs[] all(){
        Bbs[] ar = null;
        List<Bbs> list = bbsRepository.findAll();
        if(list.size() > 0){
            ar = new Bbs[list.size()];
            return list.toArray(ar);
        }
        return ar;
    }
}
