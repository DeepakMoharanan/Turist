package com.WanderHub.controller;

import com.WanderHub.entity.Plase;
import com.WanderHub.exception.PlaseNotFoundException;
import com.WanderHub.service.PlaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/api/places")
public class PlaseController {

    private PlaseService plaseService;

    public PlaseController(PlaseService plaseService) {
        this.plaseService = plaseService;
    }
    //http://localhost:8080/api/places
    @GetMapping
    public ResponseEntity<List<Plase>> getAllPlaces() {
        List<Plase> places = plaseService.getAllPlaces();
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plase> getPlaceById(@PathVariable long id) {
        Plase plase = plaseService.getPlaceById(id);
        if (plase != null) {
            return new ResponseEntity<>(plase, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Plase> savePlace(@RequestBody Plase plase) {
        Plase savedPlase = plaseService.savePlace(plase);
        return new ResponseEntity<>(savedPlase, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plase> updatePlace(@PathVariable long id, @RequestBody Plase updatedPlase) {
        try {
            Plase plase = plaseService.updatePlace(id, updatedPlase);
            return new ResponseEntity<>(plase, HttpStatus.OK);
        } catch (PlaseNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable long id) {
        plaseService.deletePlace(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

