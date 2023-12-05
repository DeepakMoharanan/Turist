package com.WanderHub.service.impl;

import com.WanderHub.exception.CityNotFoundException;
import com.WanderHub.entity.City;
import com.WanderHub.repository.CityRepository;
import com.WanderHub.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }
    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(long id) {
        Optional<City> optionalCity = cityRepository.findById(id);
        return optionalCity.orElse(null);
    }

    @Override
    public void deleteCity(long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City updateCity(long id, City updatedCity) {
        Optional<City> optionalCity = cityRepository.findById(id);
        if (optionalCity.isPresent()) {
            City existingCity = optionalCity.get();
            existingCity.setCityname(updatedCity.getCityname());
            existingCity.setCountry(updatedCity.getCountry());
            return cityRepository.save(existingCity);
        } else {
            throw new CityNotFoundException("City not found with id: " + id);
        }
    }
}
