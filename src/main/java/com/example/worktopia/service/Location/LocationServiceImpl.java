package com.example.worktopia.service.Location;


import com.example.worktopia.dto.Location.LocationReqDTO;
import com.example.worktopia.dto.Location.LocationRespDTO;
import com.example.worktopia.entity.Location;
import com.example.worktopia.exeption.ResourceNotFoundException;
import com.example.worktopia.mapper.MentoreMapper;
import com.example.worktopia.repository.LocationRepo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class  LocationServiceImpl implements LocationService {

    private final LocationRepo locationRepo;
    private final MentoreMapper mentoreMapper;

    public LocationServiceImpl(LocationRepo locationRepo, MentoreMapper mentoreMapper){
        this.locationRepo = locationRepo;
        this.mentoreMapper = mentoreMapper;
    }

    @Override
    public Location addLocation(Location location) {
        location.setCreatedAt(new Date());
        location.setStatus(true);
        System.out.println("location1");
        return this.locationRepo.save(location);
    }

    @Override
    public LocationRespDTO addLocation(@Valid LocationReqDTO locationReqDTO) {
        Location location = this.mentoreMapper.fromLocationReqDTO(locationReqDTO);
        location.setCreatedAt(new Date());
        location.setStatus(true);
        Location location1=this.locationRepo.save(location);
        System.out.println("location1");
        return this.mentoreMapper.fromLocation(this.locationRepo.save(location)) ;
    }


    @Override
    public List<Location> getLocations() {
        return this.locationRepo.findAll();
    }

    @Override
    public Page<LocationRespDTO> getLocations(int offset, int pageSize) {
        return this.locationRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(Sort.Direction.DESC, "createdAt")))
                .map(this.mentoreMapper::fromLocation);
    }

    @Override
    public Location getLocationById(Integer locationId) {

        return this.locationRepo.findById(locationId).orElseThrow(
                ()-> new ResourceNotFoundException("Location not found !")
        );
    }

    @Override
    public Location updateLocation(Location location, Integer locationId) {
        //Recherche
        Optional<Location> locationToEdit = this.locationRepo.findById(locationId);
        if (locationToEdit.isEmpty())
            throw new ResourceNotFoundException("Location not found !");
        //Modidier les informations
        if (location.getTown() != null)
            locationToEdit.get().setTown(location.getTown());
        if (location.getStreet() != null)
            locationToEdit.get().setStreet(location.getStreet());
        if (location.getPostalCode() != null)
            locationToEdit.get().setPostalCode(location.getPostalCode());
        locationToEdit.get().setUpdatedAt(new Date());
        //Sauvegarder les modifications
        return this.locationRepo.saveAndFlush(locationToEdit.get());
    }

    @Override
    public void deleteLocation(Integer locationId) {
        Location location = this.locationRepo.findById(locationId)
                .orElseThrow(()->new ResourceNotFoundException("Location not found"));
        this.locationRepo.delete(location);
    }
}
