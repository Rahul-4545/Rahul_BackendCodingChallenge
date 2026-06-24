package com.hexaware.cricketteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cricketteam.dto.PlayerDTO;
import com.hexaware.cricketteam.service.IPlayer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
@Validated
public class PlayerController {

    @Autowired
    private IPlayer service;

    // Add Player
    @PostMapping
    public PlayerDTO addPlayer(
            @Valid @RequestBody PlayerDTO dto) {  // converts json to dto

        return service.addPlayer(dto);
    }

    // Get All Players
    @GetMapping
    public List<PlayerDTO> getAllPlayers() {

        return service.getAllPlayers();
    }

    // Get Player By Id
    @GetMapping("/{playerId}")
    public PlayerDTO getPlayerById(
            @PathVariable Long playerId) {

        return service.getPlayerById(playerId);
    }

    
    @PutMapping("/{playerId}")
    public PlayerDTO updatePlayer(
            @PathVariable Long playerId,
            @Valid @RequestBody PlayerDTO dto) {

        return service.updatePlayer(playerId, dto);
    }

    
    @DeleteMapping("/{playerId}")
    public String deletePlayer(
            @PathVariable Long playerId) {

        return service.deletePlayer(playerId);
    }
    
    @DeleteMapping("/jersey/{jerseyNumber}")
    public String deletePlayerByJerseyNumber(
            @PathVariable Integer jerseyNumber) {

        return service.deletePlayerByJerseyNumber(
                jerseyNumber);
    }
}