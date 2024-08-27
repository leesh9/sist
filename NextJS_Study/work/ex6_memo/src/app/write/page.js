"use client";
import axios from "axios";
import { useRouter } from "next/navigation";


export default function Write(){
    const API_URL = "/memo/write";

    const router = useRouter();

    function send(event){
        event.preventDefault();
        console.log("send");
        const form = event.target;
        const writer = form.writer.value;
        const content = form.content.value;
        if(writer.length == 0 ){
            alert("글쓴이를  입력하세요");
            return;
        }
        if(content.length == 0){
            alert("내용을 입력하세요");
            return;
        }
        console.log(writer, content);
        axios.post(API_URL, form).then(res=>{
            console.log(res);
            if(res.data == 1){
                alert("글쓰기 성공");
                router.push("/list");
            }
        }).catch(err=>{
            console.log(err);
        })

        function handleSubmit(event){
        event.preventDefault();
        const form = event.target;
        const writer = form.writer.value;
        const content = form.content.value;
        
        if(writer.length == 0 ){
            alert("글쓴이를  입력하세요");
            return;
        }
        if(content.length == 0){
            alert("내용을 입력하세요");
            return;
        }

        // 폼 유효성 검사가 통과하면 폼을 제출합니다.
        form.submit();
    }
    }
    function handleSubmit(event){
        event.preventDefault();
        const form = event.target;
        const writer = form.writer.value;
        const content = form.content.value;
        
        if(writer.length == 0 ){
            alert("글쓴이를  입력하세요");
            return;
        }
        if(content.length == 0){
            alert("내용을 입력하세요");
            return;
        }

        // 폼 유효성 검사가 통과하면 폼을 제출합니다.
        form.submit();
    }
    return (
        <div className="write-container">
            <h1 className="write-title">글쓰기</h1>
            <form className="write-form"  action="/api/post/new" method="post" onSubmit={handleSubmit}>
                <input 
                    type="text" 
                    name="writer" 
                    placeholder="글쓴이" 
                    className="write-input"
                />
                <textarea 
                    name="content" 
                    placeholder="내용" 
                    className="write-textarea"
                />
                <button type="submit" className="write-button">전송</button>
            </form>
        </div>
    )
}