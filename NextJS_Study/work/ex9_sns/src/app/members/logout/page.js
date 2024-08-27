"use client";

import axios from "axios";
import { useRouter } from "next/navigation";
import Cookies from "js-cookie";
import { useEffect } from "react";

export default function Logout() {
    const router = useRouter();
    const API_URL = "/api/member/logout";

    useEffect   (()=>{
        logout();
    },[])

    function logout() {
        axios({
            headers: {
                "Content-Type": "application/json",
            },
            method: "POST",
            url: API_URL,
        }).then(res=>{
            if(res.status === 200) {
                router.push("/");
            }   
        })
    }

    return(
        <div>
            
        </div>
    )
}