import { Avatar, Card, CardContent, CardHeader } from "@mui/material";
import { red } from "@mui/material/colors";

export default function ItemData({obj}) {
return (
    <Card sx={{ maxWidth: 445 }}>
    <CardHeader
        avatar={
            <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
            </Avatar>
        }
            title="대기 오염도"
            subheader={obj.dataTime}
        />
        
        <CardContent>
            <p>대기오염도: {obj.khaiValue}</p>
            <p>미세먼지: {obj.coValue}</p>
        </CardContent>
    </Card>
  );
}