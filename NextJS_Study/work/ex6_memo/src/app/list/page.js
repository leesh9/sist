"use client"
import axios from "axios";
import { Button, Card, CardContent } from "@mui/material"
import { useEffect, useState } from "react";
import MyTable from "../../../component/MyTable";
import Link from "next/link";



export default function List() {
    const [list, setList] = useState([]);
    const API_URL = "/memo/list";
    function getData(){
        axios.get(API_URL)
        .then(res=>{
            setList(res.data.ar);
            console.log(res.data.ar);
        })
        .catch(err=>{
            console.log(err);
        })
    }

    useEffect(()=>{
        //익명함수의 내용
        getData();
    },[])

    return (
        <div className="list_bg">
            
            <Card sx={{maxWidth:800, margin: "20px auto"}}>
                <CardContent>
                    <MyTable ar={list}/>
                    <Link href="/write"><Button variant="contained" color="primary" sx={{marginTop: "10px"}}>전송</Button></Link>
                </CardContent>
            </Card>
        </div>
    )
}