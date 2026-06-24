package com.hexaware.cricketteam.dto;

import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class PlayerDTO {

    @NotNull
    private Long playerId;

    @NotBlank
    @Size(min = 3,max = 50)
    private String playerName;

    @NotNull
    @Min(value = 1)
    @Max(value = 999)
    private Integer jerseyNumber;

    @NotBlank
    @Pattern(
    		 regexp = "(?i)Batsman|Bowler|Keeper|All Rounder",
    		 message = "Role must be Batsman, Bowler, Keeper or All Rounder"
    		)
    		private String role;

    @NotNull
    @Min(value = 0)
    private Integer totalMatches;

    @NotBlank
    private String teamName;

    @NotBlank
    private String countryStateName;

    @NotBlank
    @Size(max = 500)
    private String description;
}