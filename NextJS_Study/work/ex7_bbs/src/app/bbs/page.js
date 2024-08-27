'use client'
import BbsList from "@/component/BbsList";
import { Card, CardContent } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";

export default function Bbs(){

    const API_URL = "/api/bbs/list";    
    //스프링 서버로 부터 받은 자원들을 저장할 곳
    const[ar,setAr] = useState([]);
    const[totalPage,setTotalPage] = useState(0);
    const[nowPage,setNowPage] = useState(1);

    useEffect(() => {
        getData();
    }, [nowPage]);

    function getData(){ 
        axios.get(API_URL,{params:{cPage:nowPage,bname:"bbs"}})
        .then(res => {
            console.log(res.data);
            setAr(res.data.ar);
            setTotalPage(res.data.totalPage);
        })
        .catch(err => {
            console.log(err);
        })
    }

    function changePage(e){
        setNowPage(e.target.innerText);
        //getData();
    }

    return (
        <div style={{width:"70%", margin:"10px auto"}}>
            <Card>
                <CardContent style={{display:"flex", flexDirection:"column", alignItems:"center"}}>
                    <header>
                        <h2>게시판</h2>
                    </header>
                    <div>
                        <BbsList ar={ar} changePage={changePage} totalPage={totalPage} nowPage={nowPage} />
                    </div>
                </CardContent>
            </Card>
        </div>
    )
}