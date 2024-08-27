'use client'
import { Card, CardContent, TextField, Button } from "@mui/material";
import axios from "axios";
import { useRouter } from "next/navigation";


export default function Write(){
    const API_URL = "/api/bbs/write";
    const router = useRouter();
    
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


    return (
        <div style={{width:"70%", margin:"10px auto"}}>
            <Card>
                <CardContent style={{display:"flex", flexDirection:"column", alignItems:"center"}}>
                    <header>
                        <h2>게시판 글쓰기</h2>
                    </header>
                    <div>
                        <form onSubmit={write}>
                        <TextField name="subject" label="제목" variant="outlined" fullWidth sx={{margin:"10px 0"}}/>
                        <TextField name="writer" label="작성자" variant="outlined" fullWidth sx={{margin:"10px 0"}}/>
                        <TextField name="content" label="내용" variant="outlined" fullWidth sx={{margin:"10px 0"}}/>
                        <input type="hidden" name="bname" value="bbs"></input>
                        <input type="file" name="file" /><br/>
                            <Button type="submit" variant="contained" color="primary">글쓰기</Button>
                        </form>
                    </div>
                </CardContent>
            </Card>
        </div>
    )
}