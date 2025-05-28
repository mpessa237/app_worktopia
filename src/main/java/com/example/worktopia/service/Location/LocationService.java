package com.example.worktopia.service.Location;


import com.example.worktopia.dto.Location.LocationReqDTO;
import com.example.worktopia.dto.Location.LocationRespDTO;
import com.example.worktopia.entity.Location;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LocationService {
    Location addLocation(Location location) ;
    LocationRespDTO addLocation(@Valid LocationReqDTO locationReqDTO);
    List<Location> getLocations();
    Page<LocationRespDTO> getLocations(int offset, int pageSize);
    Location getLocationById(Integer locationId);
    Location updateLocation(Location location , Integer locationId);
    void deleteLocation(Integer locationId);
}
