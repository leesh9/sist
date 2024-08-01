import styles from "../../css/menu.css";

let title = "쌍용교육센터";
let redFont = {
    color: "red",
    fontSize: "20px",
    fontWeight: "bold",
};

export default function Apple() {
  return (
    <div>
    <article id="wrap">
        <header id="header">
            <ul id="nav">
                <li><a href="" id="apple">&nbsp;</a></li>
                <li><a href="">Store</a></li>
                <li><a href="">Mac</a></li>
                <li><a href="">iPad</a></li>
                <li><a href="">iPhone</a></li>
                <li><a href="">Watch</a></li>
                <li><a href="">Vision</a></li>
                <li><a href="">AirPods</a></li>
                <li><a href="">TV & Home</a></li>
                <li><a href="">Entertaiment</a></li>
                <li><a href="">Support</a></li>
            </ul>
        </header>
    </article>
    </div>
  );
}