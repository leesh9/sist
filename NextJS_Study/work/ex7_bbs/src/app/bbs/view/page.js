'use client'
import { Card, CardContent, TextField, Button } from "@mui/material";
import { useState, useEffect } from "react";
import axios from "axios";
import { useSearchParams } from "next/navigation";

export default function View(){
    const API_URL = "/api/bbs/view";
    const [vo, setVo] = useState({});
    const [c_list, setC_list] = useState([]);
    const b_idx = useSearchParams().get("b_idx");
    function getData(){
        axios.get(API_URL,{params:{b_idx:b_idx}})
        .then(res => {
            console.log(res.data.vo);
            setVo(res.data.vo);
            setC_list(res.data.vo.c_list);
        })
    }

    useEffect(() => {
        getData();
    }, []);

    return (
        <div style={{width:"70%", margin:"10px auto"}}>
            <Card>
                <CardContent>
                    <h2>{vo.subject}</h2>
                    <div  dangerouslySetInnerHTML={{__html:vo.content}} style={{margin:"10px 0"}}></div>
                    <hr/>
                    {/* 댓글목록 */}
                    {c_list&&c_list.map((c)=>(
                        <div key={c.c_idx}>
                            <h3>{c.writer}</h3>
                            <div dangerouslySetInnerHTML={{__html:c.content}}></div>
                        </div>
                    ))}
                </CardContent>
            </Card>
        </div>
    )
}