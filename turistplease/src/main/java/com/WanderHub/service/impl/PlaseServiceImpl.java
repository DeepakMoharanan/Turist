package com.WanderHub.service.impl;

import com.WanderHub.entity.Plase;
import com.WanderHub.exception.PlaseNotFoundException;
import com.WanderHub.repository.PlaseRepository;
import com.WanderHub.service.PlaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaseServiceImpl implements PlaseService {

    @Autowired
    private PlaseRepository plaseRepository;

    @Override
    public List<Plase> getAllPlaces() {
        return plaseRepository.findAll();
    }

    @Override
    public Plase getPlaceById(long id) {
        Optional<Plase> optionalPlase = plaseRepository.findById(id);
        return optionalPlase.orElse(null);
    }

    @Override
    public Plase savePlace(Plase plase) {
        return plaseRepository.save(plase);
    }

    @Override
    public Plase updatePlace(long id, Plase updatedPlase) {
        Optional<Plase> optionalPlase = plaseRepository.findById(id);
        if (optionalPlase.isPresent()) {
            Plase existingPlase = optionalPlase.get();
            existingPlase.setPlases(updatedPlase.getPlases());
            existingPlase.setContend(updatedPlase.getContend());
            return plaseRepository.save(existingPlase);
        } else {
            throw new PlaseNotFoundException("Place not found with id: " + id);
        }
    }

    @Override
    public void deletePlace(long id) {
        plaseRepository.deleteById(id);
    }
}

