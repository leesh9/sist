'use client';


import axios from "axios";
import { useSearchParams } from "next/navigation";
import { useEffect, useState } from "react";
import BbsList from "../../../component/BbsList";

export default function Board(){
    const searchParams = useSearchParams();
    const p = searchParams.get('p');
    let API_URL = "/api/bbs";
    if(p!=null){
        API_URL = "/api/bbs/"+p;
    }
    const [items, setItems] = useState([]);

    function getData(){
        axios.get(API_URL)
            .then(res => {
                setItems(res.data.ar);
                console.log(res.data);
            })
    }

    useEffect(() => {
        getData();
    }, [p]);
    
    return(
        <div >
            <h1>Board</h1>
            <BbsList items={items} p={p} />
        </div>
    )
}