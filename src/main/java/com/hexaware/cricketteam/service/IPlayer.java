package com.hexaware.cricketteam.service;

import java.util.List;

import com.hexaware.cricketteam.dto.PlayerDTO;

public interface IPlayer {

    PlayerDTO addPlayer(PlayerDTO dto);

    PlayerDTO getPlayerById(Long playerId);

    List<PlayerDTO> getAllPlayers();

    PlayerDTO updatePlayer(Long playerId,
                           PlayerDTO dto);

    String deletePlayer(Long playerId);
}