package com.sist.ex0726_secure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.ex0726_secure.mapper.MemberMapper;
import com.sist.ex0726_secure.vo.MemVO;

@Service
public class MemberService {
    
    @Autowired
    private MemberMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //회원등록
    public int regMember(MemVO vo){
        //reg.jsp에서 전달되는 m_id, m_pw, m_name이 컨트롤러에서 vo로 받은 것을
        // 그대로 인자로 받았다. 이제 이쯤에서 비밀번호만
        // 암호화 시키자!
        //String pw = passwordEncoder.encode(vo.getM_pw());
        //vo.setM_pw(pw);
        vo.setM_pw(passwordEncoder.encode(vo.getM_pw()));

        return mapper.reg(vo);
    }

    public MemVO login(MemVO vo){
        // DB로부터 vo에 있는 m_id를 보내어
        // 해당 memVO를 받아서 반환한다.
        // 이때 비밀번호가 일치 하는지는
        // passwordEncoder 에게 물어봐야 한다.
        MemVO mvo = mapper.login(vo.getM_id());
        //사용자가 입력한 아이디가 잘 못 되었다면
        //mvo에는 null이 저장된다
        if(mvo != null){
            //여기서는  아이디는 잘 입력되었으니 이제는
            // 비밀번호가 일치한지?를 물어봐야 한다.
            if(passwordEncoder.matches(vo.getM_pw(), mvo.getM_pw())){
                return mvo;
            }
        }
        return null;
    }
}
