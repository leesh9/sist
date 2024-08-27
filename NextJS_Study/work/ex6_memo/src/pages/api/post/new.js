export default function handler(req, res) {
    const API_URL = "http://localhost:8080/memo/write";
    axios.post(API_URL, {params:req.body}).then(res=>{
        console.log("RES:"+res.data);
    });
    return res.status(200).redirect("/list");
}