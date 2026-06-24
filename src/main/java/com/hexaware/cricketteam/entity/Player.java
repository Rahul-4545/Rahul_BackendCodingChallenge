package com.hexaware.cricketteam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "players")
@Data
public class Player {

    @Id
    private Long playerId;

    private String playerName;

    private Integer jerseyNumber;

    private String role;

    private Integer totalMatches;

    private String teamName;

    private String countryStateName;

    private String description;
}