package com.sist.ex5.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sist.ex5.repository.BbsRepository;
import com.sist.ex5.store.Bbs;

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

    public Bbs[] findAll(int page){
        System.out.println("page : " + page);
        int size = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "bidx");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Bbs> p = bbsRepository.findAll(pageable);
        Bbs[] ar = null;
        List<Bbs> list = p.getContent();
        if(list.size() > 0){
            ar = new Bbs[list.size()];
            return list.toArray(ar);
        }
        return ar;
    }
}
