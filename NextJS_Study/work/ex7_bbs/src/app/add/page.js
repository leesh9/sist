'use client'
import { Card, CardContent, TextField, Button } from "@mui/material";
import axios from "axios";
import { useRouter } from "next/navigation";
import { useState } from "react";


export default function Write(){
    const API_URL = "/api/bbs/add";

    const router = useRouter();

    const [subject, setSubject] = useState("");
    const [writer, setWriter] = useState("");
    const [content, setContent] = useState("");
    const [file, setFile] = useState({});
    
    function write(e){
        e.preventDefault();
        const form = e.target;
        const formData = new FormData(form);

        if(form.subject.value === "" ){
            alert("제목을 입력해주세요.");
            return;
        }
        if(form.writer.value === "" ){
            alert("작성자를 입력해주세요.");
            return;
        }
        if(form.content.value === "" ){
            alert("내용을 입력해주세요.");
            return;
        }
        
        axios.post(API_URL, formData)
        .then(res => {
            console.log(res.data);
            router.push("/bbs");
        })
    }

    function send(){
        axios({
            method:"post",
            url:API_URL,
            params:{
                subject:subject, 
                writer:writer, 
                content:content
            }
        })
        .then(res => {
            if(res.data.result === 1){
                alert("글쓰기 성공"+res.data.vo.b_idx);
                const b_idx = res.data.vo.b_idx;
                sendFile(b_idx);
            }
        })
    }

    function sendFile(b_idx){
        console.log(b_idx, file);
        const formData = new FormData();
        formData.append("b_idx", b_idx);
        formData.append("file", file);
        axios({
            method:"post",
            url:"/api/bbs/addFile",
            data:formData,
            headers:{
                "Content-Type":"multipart/form-data"
            }
        })
        .then(res => {
            console.log(res.data);
            if(res.data.result === 1){
                alert("파일 업로드 성공");
                router.push("/bbs");
            }
        })
    }

    return (
        <div style={{width:"70%", margin:"10px auto"}}>
            <Card>
                <CardContent style={{display:"flex", flexDirection:"column", alignItems:"center"}}>
                    <header>
                        <h2>게시판 글쓰기</h2>
                    </header>
                    <div>
                        <form onSubmit={write}>
                        <TextField name="subject" label="제목" variant="outlined" fullWidth sx={{margin:"10px 0"}} onChange={e=>setSubject(e.target.value)}/>
                        <TextField name="writer" label="작성자" variant="outlined" fullWidth sx={{margin:"10px 0"}} onChange={e=>setWriter(e.target.value)}/>
                        <TextField name="content" label="내용" variant="outlined" fullWidth sx={{margin:"10px 0"}} onChange={e=>setContent(e.target.value)}/>
                        <input type="hidden" name="bname" value="bbs"></input>
                        <input type="file" name="file" onChange={e=>setFile(e.target.files[0])}/><br/>
                            <Button type="button" variant="contained" color="primary" onClick={send}>글쓰기</Button>
                        </form>
                    </div>
                </CardContent>
            </Card>
        </div>
    )
}