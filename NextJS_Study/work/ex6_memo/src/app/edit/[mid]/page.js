'use client'
import axios from "axios";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function Edit(props) {
    const router = useRouter();
    const mid = props.params.mid;
    const API_URL = "/memo/getMemo?m_idx="+mid;
    const [vo,setVo] = useState({});
    function send(){
        router.push(`/edit/${mid}`);
    }

    function getdata(){
        axios.get(API_URL)
        .then(res=>{
            setVo(res.data.vo);
        });
    };

    function send(event){
        event.preventDefault();
        const form = event.target;
        const writer = form.writer.value;
        const content = form.content.value;
        if(writer.length == 0){
            alert("글쓴이를 입력하세요");
            return;
        }
        if(content.length == 0){
            alert("내용을 입력하세요");
            return;
        }
        axios.post("/memo/edit",form)
        .then(res=>{
            router.push(`/detail/${mid}`);
        });
    }
        
    useEffect(()=>{
        getdata();
    },[]);

    return(
        <div className="write-container">
            <h1 className="write-title">글수정</h1>
                <form className="write-form" onSubmit={send}>
                    <input 
                        type="text" 
                        name="writer" 
                        placeholder="글쓴이" 
                        className="write-input"
                        defaultValue={vo.writer}
                    />
                    <textarea 
                        name="content" 
                        placeholder="내용" 
                        className="write-textarea"
                        defaultValue={vo.content}
                    />
                    <input type="hidden" name="m_idx" value={vo.m_idx} />
                    <button type="submit" className="write-button">전송</button>
                </form>
            </div>
    )

}