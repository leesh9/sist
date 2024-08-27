import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import Link from 'next/link';

export default function MyTable({ar}) {
    return (
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>번호</TableCell>
                        <TableCell align="right">내용</TableCell>
                        <TableCell align="right">작성일</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {ar.map((row,index) => (
                        <TableRow
                            key={index}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                        >   
                            <TableCell component="th" scope="row">
                                {index+1}
                            </TableCell>
                            <TableCell align="right"><Link href={`/detail/${row.m_idx}`}>{row.content}</Link></TableCell>
                            <TableCell align="right">{row.write_date}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}