package com.hexaware.cricketteam.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hexaware.cricketteam.entity.Player;

public interface PlayerRepository
        extends JpaRepository<Player, Long> {

	
	Optional<Player> findByJerseyNumber(Integer jerseyNumber);

}