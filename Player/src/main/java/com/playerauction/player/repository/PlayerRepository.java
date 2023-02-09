package com.playerauction.player.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playerauction.player.entity.Player;
@Repository
public interface PlayerRepository extends JpaRepository<Player,String>{
public List<Player> getPlayersByTeamName(String teamName);
//public Player findPlayerByName(String playerName);
}
