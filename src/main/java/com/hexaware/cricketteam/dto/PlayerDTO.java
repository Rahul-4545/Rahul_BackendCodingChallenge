package com.hexaware.cricketteam.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class PlayerDTO {

    @NotNull(message = "Player Id cannot be null")
    private Long playerId;

    @NotBlank(message = "Player Name is required")
    @Size(min = 3,max = 50)
    private String playerName;

    @NotNull(message = "Jersey Number is required")
    @Min(value = 1)
    @Max(value = 999)
    private Integer jerseyNumber;

    @NotBlank(message = "Role is required")
    private String role;

    @NotNull(message = "Total Matches is required")
    @Min(value = 0)
    private Integer totalMatches;

    @NotBlank(message = "Team Name is required")
    private String teamName;

    @NotBlank(message = "Country/State Name is required")
    private String countryStateName;

    @NotBlank(message = "Description is required")
    @Size(max = 500)
    private String description;
}