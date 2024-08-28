'use client'

import { useEffect, useState } from "react"
import axios from "axios"
export default function Emp(){

    const [emp, setEmp] = useState([])
    const API_URL = "/api/all"

    useEffect(()=>{
        getData()
    },[])

    function getData(){
        axios.get(API_URL)
        .then(res => {
            console.log(res.data)
            setEmp(res.data.ar)
        })
    }
    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>NO</th>
                        <th>Name</th>
                        <th>Department</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        emp.map((e, index) => (
                            <tr key={e.empno}>
                                <td>{index + 1}</td>
                                <td>{e.ename}</td>
                                <td>{e.deptno}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}
