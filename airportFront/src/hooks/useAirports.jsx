// src/hooks/useAirports.js
import { useState, useEffect, useCallback } from 'react';
import { useApi } from './useApi';

export const useAirports = () => {
  const { get, post, put, remove, loading } = useApi();
  const [airports, setAirports] = useState([]);
  const [pagination, setPagination] = useState({
    page: 0,
    size: 10,
    totalElements: 0,
    totalPages: 0
  });

  const fetchAirports = useCallback(async (page = 0, size = 10) => {
    try {
      const response = await get('/airports', { page, size });
      setAirports(response.content);
      setPagination({
        page: response.number,
        size: response.size,
        totalElements: response.totalElements,
        totalPages: response.totalPages
      });
      return response;
    } catch (error) {
      console.error('Error fetching airports:', error);
      return null;
    }
  }, [get]);

  const getAirportById = useCallback(async (id) => {
    try {
      return await get(`/airports/${id}`);
    } catch (error) {
      console.error(`Error fetching airport with id ${id}:`, error);
      return null;
    }
  }, [get]);

  const createAirport = useCallback(async (airportData) => {
    try {
      const newAirport = await post('/airports', airportData);
      setAirports(prevAirports => [...prevAirports, newAirport]);
      return newAirport;
    } catch (error) {
      console.error('Error creating airport:', error);
      return null;
    }
  }, [post]);

  const updateAirport = useCallback(async (id, airportData) => {
    try {
      const updatedAirport = await put(`/airports/${id}`, airportData);
      setAirports(prevAirports => 
        prevAirports.map(airport => 
          airport.id === id ? updatedAirport : airport
        )
      );
      return updatedAirport;
    } catch (error) {
      console.error(`Error updating airport with id ${id}:`, error);
      return null;
    }
  }, [put]);

  const deleteAirport = useCallback(async (id) => {
    try {
      await remove(`/airports/${id}`);
      setAirports(prevAirports => 
        prevAirports.filter(airport => airport.id !== id)
      );
      return true;
    } catch (error) {
      console.error(`Error deleting airport with id ${id}:`, error);
      return false;
    }
  }, [remove]);

  const searchAirports = useCallback(async (keyword) => {
    try {
      return await get('/airports/search', { keyword });
    } catch (error) {
      console.error('Error searching airports:', error);
      return [];
    }
  }, [get]);

  useEffect(() => {
    fetchAirports();
  }, [fetchAirports]);

  return {
    airports,
    pagination,
    loading,
    fetchAirports,
    getAirportById,
    createAirport,
    updateAirport,
    deleteAirport,
    searchAirports
  };
};