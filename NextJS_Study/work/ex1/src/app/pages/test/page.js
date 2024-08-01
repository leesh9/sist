import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import SendIcon from '@mui/icons-material/Send';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';

const Test = () => {
    const rows=[
        {name:"java",value:3209,rank:2,"etc":"자바는 자바다"},
        {name:"python",value:3100,rank:3,"etc":"파이썬은 파이썬이다"},
        {name:"c++",value:3000,rank:4,"etc":"C++은 C++이다"},
        {name:"javascript",value:2900,rank:5,"etc":"자바스크립트는 자바스크립트이다"},
    ]
    return (
        <div>
            <h2>테스트페이지</h2>
            <article>
                <Button variant="outlined" startIcon={<DeleteIcon />}>
                    Delete
                </Button>
                <Button variant="contained" endIcon={<SendIcon />}>
                    Send
                </Button>
                <Table sx={{ minWidth: 850 }}>
                    <TableHead>
                        <TableRow>
                            <TableCell>Language</TableCell>
                            <TableCell>Value</TableCell>
                            <TableCell>Rank</TableCell>
                            <TableCell>Etc</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map((row)=>(
                            <TableRow>
                                <TableCell>{row.name}</TableCell>
                                <TableCell>{row.value}</TableCell>
                                <TableCell>{row.rank}</TableCell>
                                <TableCell>{row.etc}</TableCell>
                            </TableRow>
                        ))}
                        {/* JSX(JavaScript Syntax Extension) 문법주석 */
                        /* {rows.map(function(row){
                            return(
                                <TableRow>
                                <TableCell>{row.name}</TableCell>
                                <TableCell>{row.value}</TableCell>
                                <TableCell>{row.rank}</TableCell>
                                    <TableCell>{row.etc}</TableCell>
                                </TableRow> 
                            )
                        })*/}
                    </TableBody>
                </Table>
            </article>
        </div>
    );
}

export default Test;