'use client'
import { useState, useEffect } from "react";
import Link from "next/link";
import Cookies from 'js-cookie';
import { usePathname } from "next/navigation";
import { useSession } from "next-auth/react";

export default function Header() {
    const Page = usePathname();
    const [accessToken, setAccessToken] = useState(null);
    const { data: session } = useSession();
    console.log("session",session);
    useEffect(() => {
        const accessToken = Cookies.get('accessToken');
        setAccessToken(accessToken);
    }, [Page]);

    return(
        <header className="header">
            <nav className="navbar">
                <Link href="/">홈</Link>
                <Link href="/members">회원목록</Link>
                <Link href="/bbs">게시판</Link>{session?session.user.name:''}
            </nav>
            <div className="fr">
                {accessToken ==null && session ==null ? (
                    <Link href="/members/login">로그인</Link>
                ) : (
                    <Link href="/members/logout">로그아웃</Link>
                )}
                <Link href="/members/signup">회원가입</Link>
            </div>
        </header>
    )
}