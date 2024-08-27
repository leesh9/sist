'use client';

import { useEffect, useState } from "react";

export default function Effect() {
    
    const [count, setCount] = useState(0);
    const [content, setContent] = useState("");

    function increment() {
        setCount(count + 1);
    }

    function textChange(e) {
        setContent(e.target.value);
    }

    useEffect(() => {
        console.log("Effect");
    },[count]);

    

    return (
    <div>
        <span>Count: {count}</span><br/>
        <button onClick={increment}>Increment</button>
        내용: <input type="text" onChange={textChange} /><br/>
        <hr/>
        <span>내용: {content}</span>
    </div>
    );
}