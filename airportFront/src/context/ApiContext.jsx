// src/context/ApiContext.js
import React, { createContext, useState } from 'react';
import axios from 'axios';

export const ApiContext = createContext();

const API_BASE_URL = 'http://localhost:8080/api';

export const ApiProvider = ({ children }) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const apiClient = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      'Content-Type': 'application/json',
    },
  });

  const get = async (endpoint, params = {}) => {
    setLoading(true);
    try {
      const response = await apiClient.get(endpoint, { params });
      setLoading(false);
      return response.data;
    } catch (err) {
      setError(err.response?.data || 'An error occurred');
      setLoading(false);
      throw err;
    }
  };

  const post = async (endpoint, data = {}) => {
    setLoading(true);
    try {
      const response = await apiClient.post(endpoint, data);
      setLoading(false);
      return response.data;
    } catch (err) {
      setError(err.response?.data || 'An error occurred');
      setLoading(false);
      throw err;
    }
  };

  const put = async (endpoint, data = {}) => {
    setLoading(true);
    try {
      const response = await apiClient.put(endpoint, data);
      setLoading(false);
      return response.data;
    } catch (err) {
      setError(err.response?.data || 'An error occurred');
      setLoading(false);
      throw err;
    }
  };

  const remove = async (endpoint) => {
    setLoading(true);
    try {
      const response = await apiClient.delete(endpoint);
      setLoading(false);
      return response.data;
    } catch (err) {
      setError(err.response?.data || 'An error occurred');
      setLoading(false);
      throw err;
    }
  };
return (
    <ApiContext.Provider
      value={{
        loading,
        error,
        get,
        post,
        put,
        remove,
        setError
      }}
    >
      {children}
    </ApiContext.Provider>
  );
};