package com.hexaware.cricketteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.cricketteam.entity.Player;

public interface PlayerRepository
        extends JpaRepository<Player, Long> {

}