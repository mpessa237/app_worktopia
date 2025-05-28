package com.example.worktopia.dto.Mentore;

import com.example.worktopia.dto.Location.LocationReqDTO;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record MentoreReqDTO (
        @Column(nullable = false)
        @Length(min = 3, max = 50, message = "firstname must have min 3 caracters and max 50 caracters")
        @NotEmpty(message = "This field must be fill")
        String firstname,
        String lastname,
        @NotEmpty(message = "the email does not be Empty")
        @Email(message = "Your email address isn't correct")
        String email,
        @Column(name = "phone_number")
        String phone,
        Integer locationId,
        LocationReqDTO locationReqDTO)


{
    @Override
    public @NotEmpty(message = "the email does not be Empty") @Email(message = "Your email address isn't correct") String email() {
    return email;
}

    public LocationReqDTO getLocationReqDTO() {
    return locationReqDTO;
}

    @Override
    public @Length(min = 3, max = 50, message = "firstname must have min 3 caracters and max 50 caracters") @NotEmpty(message = "This field must be fill") String firstname() {
    return firstname;
}

    @Override
    public String lastname() {
    return lastname;
}

    @Override
    public Integer locationId() {
    return locationId;
}

    @Override
    public LocationReqDTO locationReqDTO() {
    return locationReqDTO;
}


}