// src/components/airports/AirportForm.js
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import {
  Paper,
  TextField,
  Button,
  Grid,
  Typography,
  Box,
  CircularProgress,
} from '@mui/material';
import { useAirports } from '../../hooks/useAirports';

const AirportForm = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { getAirportById, createAirport, updateAirport, loading } = useAirports();

  const [formData, setFormData] = useState({
    name: '',
    code: '',
    city: '',
    country: '',
  });

  const [errors, setErrors] = useState({});
  const isEditMode = Boolean(id);

  useEffect(() => {
    const fetchAirport = async () => {
      if (isEditMode) {
        const airport = await getAirportById(id);
        if (airport) {
          setFormData({
            name: airport.name,
            code: airport.code,
            city: airport.city,
            country: airport.country,
          });
        }
      }
    };

    fetchAirport();
  }, [getAirportById, id, isEditMode]);

  const validateForm = () => {
    const newErrors = {};

    if (!formData.name.trim()) {
      newErrors.name = 'Name is required';
    }

    if (!formData.code.trim()) {
      newErrors.code = 'Code is required';
    } else if (!/^[A-Z]{3}$/.test(formData.code)) {
      newErrors.code = 'Code must be 3 uppercase letters';
    }

    if (!formData.city.trim()) {
      newErrors.city = 'City is required';
    }

    if (!formData.country.trim()) {
      newErrors.country = 'Country is required';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validateForm()) {
      return;
    }

    let result;

    if (isEditMode) {
      result = await updateAirport(id, formData);
    } else {
      result = await createAirport(formData);
    }

    if (result) {
      navigate('/airports');
    }
  };

  return (
    <Paper sx={{ p: 3 }}>
      <Typography variant="h5" gutterBottom>
        {isEditMode ? 'Edit Airport' : 'Add New Airport'}
      </Typography>

      <form onSubmit={handleSubmit}>
        <Grid container spacing={3}>
          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Name"
              name="name"
              value={formData.name}
              onChange={handleChange}
              error={Boolean(errors.name)}
              helperText={errors.name}
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Code (3 letters)"
              name="code"
              value={formData.code}
              onChange={handleChange}
              error={Boolean(errors.code)}
              helperText={errors.code}
              inputProps={{ maxLength: 3, style: { textTransform: 'uppercase' } }}
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="City"
              name="city"
              value={formData.city}
              onChange={handleChange}
              error={Boolean(errors.city)}
              helperText={errors.city}
            />
          </Grid>

          <Grid item xs={12} sm={6}>
            <TextField
              fullWidth
              label="Country"
              name="country"
              value={formData.country}
              onChange={handleChange}
              error={Boolean(errors.country)}
              helperText={errors.country}
            />
          </Grid>

          <Grid item xs={12}>
            <Box sx={{ display: 'flex', justifyContent: 'flex-end', gap: 2 }}>
              <Button 
                variant="outlined" 
                onClick={() => navigate('/airports')}
              >
                Cancel
              </Button>
              <Button 
                type="submit" 
                variant="contained" 
                color="primary"
                disabled={loading}
              >
                {loading ? <CircularProgress size={24} /> : isEditMode ? 'Update' : 'Create'}
              </Button>
            </Box>
          </Grid>
        </Grid>
      </form>
    </Paper>
  );
};

export default AirportForm;