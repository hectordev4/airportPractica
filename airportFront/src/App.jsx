// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { CssBaseline, Box } from '@mui/material';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import { ApiProvider } from './context/ApiContext';
import Header from './components/layout/Header';
import Sidebar from './components/layout/Sidebar';
import Footer from './components/layout/Footer';
import Home from './pages/Home';
import Airports from './pages/Airports';
import AirportDetails from './components/airports/AirportDetails';
import Flights from './pages/Flights';
import FlightDetails from './components/flights/FlightDetails';
import Planes from './pages/Planes';
import PlaneDetails from './components/planes/PlaneDetails';

const theme = createTheme({
  palette: {
    primary: {
      main: '#1976d2',
    },
    secondary: {
      main: '#dc004e',
    },
  },
});

function App() {
  return (
    <ApiProvider>
      <ThemeProvider theme={theme}>
        <Router>
          <CssBaseline />
          <Box sx={{ display: 'flex' }}>
            <Header />
            <Sidebar />
            <Box
              component="main"
              sx={{
                flexGrow: 1,
                p: 3,
                width: { sm: `calc(100% - 240px)` },
                ml: { sm: '240px' },
                mt: '64px',
              }}
            >
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/airports" element={<Airports />} />
                <Route path="/airports/:id" element={<AirportDetails />} />
                <Route path="/flights" element={<Flights />} />
                <Route path="/flights/:id" element={<FlightDetails />} />
                <Route path="/planes" element={<Planes />} />
                <Route path="/planes/:id" element={<PlaneDetails />} />
              </Routes>
              <Footer />
            </Box>
          </Box>
        </Router>
      </ThemeProvider>
    </ApiProvider>
  );
}

export default App;