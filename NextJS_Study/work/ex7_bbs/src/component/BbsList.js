import { TableContainer, Table, TableHead, TableRow, TableCell, TableBody, Paper, Pagination, TableFooter, Button } from "@mui/material";
import Link from "next/link";

export default function BbsList({ ar, changePage, totalPage, nowPage }) {
    return (
        <div>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>번호</TableCell>
                            <TableCell align="left">제목</TableCell>
                            <TableCell align="center">글쓴이</TableCell>
                            <TableCell align="center">등록일</TableCell>
                            <TableCell align="center">조회수</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {ar.map((row) => (
                            <TableRow
                                key={row.b_idx}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {row.b_idx}
                                </TableCell>
                                <TableCell align="left"><Link href={`/bbs/view?b_idx=${row.b_idx}`}>{row.subject}</Link></TableCell>
                                <TableCell align="left"><Link href={`/bbs/view?b_idx=${row.b_idx}`}>{row.writer}</Link></TableCell>
                                <TableCell align="left">{row.write_date}</TableCell>
                                <TableCell align="left">{row.hit}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                    <TableFooter>
                        <TableRow>
                            <TableCell colSpan={4} align="center">
                                <Pagination count={totalPage} page={nowPage} onChange={changePage} />
                            </TableCell>
                            <TableCell align="right">
                                <Link href="/bbs/write">
                                    <Button variant="contained" color="primary">글쓰기</Button>
                                </Link>
                            </TableCell>
                        </TableRow>
                    </TableFooter>
                </Table>
            </TableContainer>
        </div>
    )
}