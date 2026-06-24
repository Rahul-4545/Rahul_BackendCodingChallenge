package com.hexaware.cricketteam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketteam.dto.PlayerDTO;
import com.hexaware.cricketteam.entity.Player;
import com.hexaware.cricketteam.exception.PlayerNotFoundException;
import com.hexaware.cricketteam.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayer {

    @Autowired
    private PlayerRepository repository;

    @Override
    public PlayerDTO addPlayer(PlayerDTO dto) {

        Player player = dtoToEntity(dto);

        Player savedPlayer = repository.save(player);

        return entityToDto(savedPlayer);
    }

    @Override
    public PlayerDTO getPlayerById(Long playerId) {

        Player player = repository.findById(playerId)
                .orElseThrow(() ->
                        new PlayerNotFoundException(
                                "Player not found with Id : " + playerId));

        return entityToDto(player);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {

        List<Player> players = repository.findAll();

        return players.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO updatePlayer(Long playerId, PlayerDTO dto) {

        Player player = repository.findById(playerId)
                .orElseThrow(() ->
                        new PlayerNotFoundException(
                                "Player not found with Id : " + playerId));

        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryStateName(dto.getCountryStateName());
        player.setDescription(dto.getDescription());

        Player updatedPlayer = repository.save(player);

        return entityToDto(updatedPlayer);
    }

    @Override
    public String deletePlayer(Long playerId) {

        if (!repository.existsById(playerId)) {
            throw new PlayerNotFoundException(
                    "Player not found with Id : " + playerId);
        }

        repository.deleteById(playerId);

        return "Player deleted successfully";
    }

    // DTO -> Entity
    private Player dtoToEntity(PlayerDTO dto) {

        Player player = new Player();

        player.setPlayerId(dto.getPlayerId());
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryStateName(dto.getCountryStateName());
        player.setDescription(dto.getDescription());

        return player;
    }

    // Entity -> DTO
    private PlayerDTO entityToDto(Player player) {

        PlayerDTO dto = new PlayerDTO();

        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setRole(player.getRole());
        dto.setTotalMatches(player.getTotalMatches());
        dto.setTeamName(player.getTeamName());
        dto.setCountryStateName(player.getCountryStateName());
        dto.setDescription(player.getDescription());

        return dto;
    }
}