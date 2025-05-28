package com.example.worktopia.dto.Location;

import jakarta.validation.constraints.NotEmpty;

public record LocationReqDTO (
    @NotEmpty
    String town,
    Integer postalCode,
    String street)
{
}
