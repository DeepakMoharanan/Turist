package com.WanderHub.controller;
import com.WanderHub.exception.CityNotFoundException;
import com.WanderHub.entity.City;
import com.WanderHub.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/cities")
public class CityController {
    private CityService cityService ;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    //http://localhost:8080/api/cities
    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        City savedCity = cityService.saveCity(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }
        //http://localhost:8080/api/cities
        @GetMapping
        public ResponseEntity<List<City>> getAllCities () {
            List<City> cities = cityService.getAllCities();
            return new ResponseEntity<>(cities, HttpStatus.OK);
        }
        //http://localhost:8080/api/cities/id/{1}
        @GetMapping("/{id}")
        public ResponseEntity<City> getCityById ( @PathVariable long id){
            City city = cityService.getCityById(id);
            if (city != null) {
                return new ResponseEntity<>(city, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @DeleteMapping("{id}")
        public ResponseEntity<Void> deleteCity(@PathVariable long id){
            cityService.deleteCity(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable long id, @RequestBody City updatedCity) {
        try {
            City city = cityService.updateCity(id, updatedCity);
            return new ResponseEntity<>(city, HttpStatus.OK);
        } catch (CityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
