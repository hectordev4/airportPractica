// src/pages/Home.js
import React from 'react';
import { Typography, Paper, Grid, Card, CardContent, CardActions, Button } from '@mui/material';
import { Link as RouterLink } from 'react-router-dom';
import { Flight, LocationOn, AirplanemodeActive } from '@mui/icons-material';

const Home = () => {
  return (
    <>
      <Paper sx={{ p: 3, mb: 3 }}>
        <Typography variant="h4" gutterBottom>
          Airport Management System
        </Typography>
        <Typography variant="body1">
          Welcome to the Airport Management System. This application allows you to manage airports, flights, and planes through an intuitive interface.
        </Typography>
      </Paper>

      <Grid container spacing={3}>
        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <LocationOn fontSize="large" color="primary" />
              <Typography variant="h5" component="div">
                Airports
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Manage airport information including codes, locations, and contact details.
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" component={RouterLink} to="/airports">
                View Airports
              </Button>
            </CardActions>
          </Card>
        </Grid>

        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <Flight fontSize="large" color="primary" />
              <Typography variant="h5" component="div">
                Flights
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Track and manage flight schedules, statuses, and associated information.
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" component={RouterLink} to="/flights">
                View Flights
              </Button>
            </CardActions>
          </Card>
        </Grid>

        <Grid item xs={12} md={4}>
          <Card>
            <CardContent>
              <AirplanemodeActive fontSize="large" color="primary" />
              <Typography variant="h5" component="div">
                Planes
              </Typography>
              <Typography variant="body2" color="text.secondary">
                Manage aircraft fleet information, maintenance records, and availability.
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small" component={RouterLink} to="/planes">
                View Planes
              </Button>
            </CardActions>
          </Card>
        </Grid>
      </Grid>
    </>
  );
};

export default Home;