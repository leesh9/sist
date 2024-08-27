'use client'
import axios from "axios";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function Detail(mid){

    //서버로 부터 받을 vo 정보를 저장할 곳
    const [vo,setVo] = useState({});
    const API_URL = `/memo/getMemo?m_idx=${mid.params.mid}`;
    const router = useRouter();
    function getDetail(){   
        
        axios.get(API_URL)
        .then(res=>{
            console.log(res.data.vo);
            setVo(res.data.vo);
        });
    }

    function send(){
        router.push(`/edit/${mid.params.mid}`);
    }

    useEffect(()=>{
        getDetail();
    },[]);

    return(
        <div className="card">
            <h2>상세페이지</h2>
            <h4>글쓴이: {vo.writer}, {vo.write_date}</h4>
            <p>{vo.content}</p>
            <button onClick={send}>수정</button>
        </div>
    )
}