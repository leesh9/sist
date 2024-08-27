'use client';

import Image from "next/image";
import styles from "./page.module.css";
import ItemData from "@/component/itemData";
import { useEffect, useState } from "react";
import axios from "axios";

export default function Home() {
  const API_URL="/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=강남구&dataTerm=month&pageNo=1&numOfRows=1&returnType=json&serviceKey=LGJwRYUnjFABurhH4%2BLhBkNY9B9iUaWZG3N5Y2rzlM70kV97pRIzhj%2FTtB%2B%2FZiH4ZQP1wcikIrpZEaEXxC3g2g%3D%3D"
  const [list,setList] = useState([]);
  
  function getData(){
    axios.get(API_URL)
      .then((res) => {
        console.log(res.data);
        setList(res.data.response.body.items);
        
      });
  }

  useEffect(() => {
    //최초 한번 호출
    getData();
  }, []);
  return (
    <main className={styles.main}>
      {list.map((item,index) => (
        <ItemData key={index} obj={item} />
      ))}
    </main>
  );
}
