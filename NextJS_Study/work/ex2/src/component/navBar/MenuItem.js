import Link from "next/link"

export default function MenuItem(){
    const link_item=[
        {name:"Home", href:"/"},
        {name:"About", href:"/about"},
        {name:"Content", href:"/content"},
        {name:"Blog", href:"/blog"},
    ];
    
    return(
        <div>
            {link_item.map((item)=>(
                <Link href={item.href}>{item.name}</Link>
            ))}
        </div>
    );
}