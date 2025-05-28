package com.example.worktopia.controller;

import com.example.worktopia.dto.Location.LocationReqDTO;
import com.example.worktopia.dto.Location.LocationRespDTO;
import com.example.worktopia.entity.Location;
import com.example.worktopia.service.Location.LocationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class
LocationController {

    public final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "location/add")
    public ResponseEntity<LocationRespDTO> addLocation(@Valid @RequestBody LocationReqDTO locationReqDTO){

        return ResponseEntity
                .status(201)
                .body(this.locationService.addLocation(locationReqDTO));
    }

    @GetMapping(path = "locations/get_all")
    public ResponseEntity<List<Location>> getLocations(){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocations());
    }

    @GetMapping(path = "locations/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<LocationRespDTO>> getLocations(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocations(offset, pageSize));
    }

    @GetMapping(path = "locations/get_by_id/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Integer locationId){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocationById(locationId));
    }

    @PutMapping(path = "location/update_by_id/{locationId}")
    public ResponseEntity<Location> updateLocationById(@PathVariable Integer locationId, @RequestBody  Location location){

        return ResponseEntity
                .status(202)
                .body(this.locationService.updateLocation(location,locationId));
    }

    @DeleteMapping(path = "location/delete_by_id/{locationId}")
    public ResponseEntity<String> deleteLocationById(@PathVariable Integer locationId){
        this.locationService.deleteLocation(locationId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }

}
