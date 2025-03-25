// src/pages/Airports.js
import React from 'react';
import { Typography, Box } from '@mui/material';
import AirportList from '../components/airports/AirportList';

const Airports = () => {
  return (
    <Box>
      <Typography variant="h4" gutterBottom>
        Airports
      </Typography>
      <AirportList />
    </Box>
  );
};

export default Airports;