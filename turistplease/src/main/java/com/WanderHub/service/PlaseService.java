package com.WanderHub.service;
import com.WanderHub.entity.Plase;
import java.util.List;

public interface PlaseService {
    List<Plase> getAllPlaces();
    Plase getPlaceById(long id);
    Plase savePlace(Plase plase);
    Plase updatePlace(long id, Plase updatedPlase);
    void deletePlace(long id);
}

