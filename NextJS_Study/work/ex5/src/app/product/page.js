import Image from "next/image";

export default function Page() {

    let ar1 =[
        {name:"딸기", price:12000, img:"/images/fruit0.png" },
        {name:"라임", price:9000, img:"/images/fruit1.png"},
        {name:"바나나", price:15000, img:"/images/fruit2.png"},
    ]

    return (
        <div>
            <h1 className="title">제품들</h1>
            <hr/>
            {ar1.map((item) => (
                <div className="box">
                    <h4>{item.name}</h4>
                    <Image src={item.img} alt={item.name} width={200} height={200} />   
                    <p>{item.price}원</p>
                </div>
            ))}
        </div>
        
    );
}