import { TableContainer, Table, Paper, TableHead, TableBody, TableRow, TableCell, TablePagination } from "@mui/material";
import TablePaginationActions from "@mui/material/TablePagination/TablePaginationActions";
import { useSearchParams } from "next/navigation";
export default function BbsList({items, p}) {
    return (
        <div>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell>No</TableCell>
                            <TableCell>Title</TableCell>
                            <TableCell>Writer</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {items.map((item) => (
                            <TableRow
                                key={item.bidx}
                                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell component="th" scope="row">
                                    {item.bidx}
                                </TableCell>
                                <TableCell>{item.subject}</TableCell>
                                <TableCell>{item.writer}</TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
            <TablePaginationActions
                component="div"
                count={100} // Total number of items, you might want to get this from your API
                page={parseInt(p || '0') - 1} // Current page, subtract 1 as MUI uses 0-based index
                onPageChange={(event, newPage) => {
                    window.location.href = `/board?p=${newPage + 1}`; // Add 1 to match your API's 1-based index
                }}
                rowsPerPage={10} // Number of items per page, adjust as needed
                rowsPerPageOptions={[10]} // Only allow 10 items per page
            />
                
        </div>
    )
}