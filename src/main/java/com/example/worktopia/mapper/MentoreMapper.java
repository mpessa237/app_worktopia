package com.example.worktopia.mapper;

import com.example.worktopia.dto.Location.LocationReqDTO;
import com.example.worktopia.dto.Location.LocationRespDTO;
import com.example.worktopia.dto.Mentore.MentoreReqDTO;
import com.example.worktopia.dto.Mentore.MentoreRespDTO;
import com.example.worktopia.entity.Location;
import com.example.worktopia.entity.Mentore;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;


@Mapper(componentModel = "spring")
@Configuration
public interface MentoreMapper {
    Mentore fromMentoreReqDTO(MentoreReqDTO mentoreReqDTO);
    Location fromLocationReqDTO(LocationReqDTO locationReqDTO);

    MentoreRespDTO fromMentore(Mentore mentore);
    LocationRespDTO fromLocation(Location location);
}
