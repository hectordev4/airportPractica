// src/components/airports/AirportList.js
import React, { useState } from 'react';
import { Link as RouterLink } from 'react-router-dom';
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  TablePagination,
  Button,
  IconButton,
  TextField,
  Box,
} from '@mui/material';
import {
  Edit as EditIcon,
  Delete as DeleteIcon,
  Search as SearchIcon,
} from '@mui/icons-material';
import { useAirports } from '../../hooks/useAirports';

const AirportList = () => {
  const {
    airports,
    pagination,
    loading,
    fetchAirports,
    deleteAirport,
    searchAirports,
  } = useAirports();

  const [searchTerm, setSearchTerm] = useState('');
  const [showDeleteConfirm, setShowDeleteConfirm] = useState(null);

  const handleChangePage = (event, newPage) => {
    fetchAirports(newPage, pagination.size);
  };

  const handleChangeRowsPerPage = (event) => {
    const newSize = parseInt(event.target.value, 10);
    fetchAirports(0, newSize);
  };

  const handleSearch = async () => {
    if (searchTerm.trim()) {
      const results = await searchAirports(searchTerm);
      // Handle search results
    } else {
      fetchAirports();
    }
  };

  const handleDelete = async (id) => {
    const success = await deleteAirport(id);
    if (success) {
      setShowDeleteConfirm(null);
    }
  };

  return (
    <Paper sx={{ width: '100%', overflow: 'hidden' }}>
      <Box sx={{ p: 2, display: 'flex', justifyContent: 'space-between' }}>
        <Box sx={{ display: 'flex', alignItems: 'center' }}>
          <TextField
            variant="outlined"
            size="small"
            placeholder="Search airports..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            sx={{ mr: 1 }}
          />
          <IconButton onClick={handleSearch}>
            <SearchIcon />
          </IconButton>
        </Box>
        <Button
          variant="contained"
          color="primary"
          component={RouterLink}
          to="/airports/new"
        >
          Add Airport
        </Button>
      </Box>

      <TableContainer sx={{ maxHeight: 440 }}>
        <Table stickyHeader>
          <TableHead>
            <TableRow>
              <TableCell>Code</TableCell>
              <TableCell>Name</TableCell>
              <TableCell>City</TableCell>
              <TableCell>Country</TableCell>
              <TableCell align="right">Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {loading ? (
              <TableRow>
                <TableCell colSpan={5} align="center">
                  Loading...
                </TableCell>
              </TableRow>
            ) : airports.length === 0 ? (
              <TableRow>
                <TableCell colSpan={5} align="center">
                  No airports found
                </TableCell>
              </TableRow>
            ) : (
              airports.map((airport) => (
                <TableRow key={airport.id}>
                  <TableCell>{airport.code}</TableCell>
                  <TableCell>{airport.name}</TableCell>
                  <TableCell>{airport.city}</TableCell>
                  <TableCell>{airport.country}</TableCell>
                  <TableCell align="right">
                    <IconButton 
                      component={RouterLink}
                      to={`/airports/${airport.id}`}
                      size="small"
                    >
                      <EditIcon />
                    </IconButton>
                    <IconButton
                      size="small"
                      onClick={() => setShowDeleteConfirm(airport.id)}
                    >
                      <DeleteIcon />
                    </IconButton>
                  </TableCell>
                </TableRow>
              ))
            )}
          </TableBody>
        </Table>
      </TableContainer>

      <TablePagination
        rowsPerPageOptions={[5, 10, 25]}
        component="div"
        count={pagination.totalElements}
        rowsPerPage={pagination.size}
        page={pagination.page}
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </Paper>
  );
};

export default AirportList;