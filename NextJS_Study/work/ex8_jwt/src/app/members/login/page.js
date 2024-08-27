'use client'
import React, { useState } from 'react'
import styles from "../../page.module.css"
import { useRouter } from 'next/navigation';
import axios from 'axios';
import Cookies from 'js-cookie';
export default function page() {
    const router = useRouter();
    const [member, setMember] = useState({});
    const API_URL = "/api/member/login";
    const mainStyles = {
        justifyContent: 'flex-start'
    }

  function signIn(){ //비동기식 통신을 이용하여 서버에게 값 전달
    axios({
        url:API_URL,
        method: "post",
        params: member,
        withCredentials: true, // 이거 없으면 쿠키가 안들어온다.
        headers:{
            "Content-Type":"application/json"
        }
    }).then((res) => {
        console.log(res.request.status);
        if(res.request.status === 200){
            router.push("/");
        }
    });
    }

  const handleSubmit = function(e){ //사용자가 입력한 값 검증
    console.log("submit");// 의미가.....X
    }

  const handleChange = (e) => { // useState에 저장
    // 아이디 또는 비밀번호에서 입력할 때마다 호출되는 곳이다.
    const {name, value} = e.target;
    setMember({...member, [name]:value});
    //console.log({...member,[name]:value});
    }

    return (
    <div className={styles.main} style={mainStyles}>
        <h1>로그인</h1>
        <form onSubmit={handleSubmit}>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <label htmlFor='mId'>아이디</label>
                        </td>
                        <td>
                            <input type='text' id='mId' name='mId'
                                onChange={handleChange}/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label htmlFor='mPw'>비밀번호</label>
                        </td>
                        <td>
                            <input type='password' id='mPw' name='mPw'
                                onChange={handleChange}/>
                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colSpan={2}>
                            <button type='button' onClick={signIn}>
                                로그인
                            </button>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </form>
    </div>
    )
}
