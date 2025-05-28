package com.example.worktopia.dto.Mentore;

import com.example.worktopia.dto.Location.LocationRespDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class MentoreRespDTO {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Boolean status;
    private LocationRespDTO locationRespDTO;



}
