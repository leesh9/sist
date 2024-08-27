import Link from "next/link";

export default function MyHeader(){
    return(
        <nav>
            <div>Logo</div>
            <div>
                <Link href="/">Home</Link>
                <Link href="/content">Content</Link>
                <Link href="/blog">Blog</Link>
                <Link href="/about">About</Link>
            </div>
        </nav>
    )
}