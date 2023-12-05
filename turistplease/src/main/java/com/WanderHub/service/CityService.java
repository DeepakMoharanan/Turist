package com.WanderHub.service;

import com.WanderHub.entity.City;

import java.util.List;


public interface CityService {

    City saveCity(City city);

    List<City> getAllCities();

    City getCityById(long id);

    void deleteCity(long id);

    City updateCity(long id, City updatedCity);
}
