package com.playerauction.player.service;

import java.util.List;

import com.playerauction.player.entity.Player;

public interface IPlayerService{
public Player addPlayer(Player player);
public List<Player> getPlayersByTeamName(String teamName);
public Player getPlayerByName(String playerName);
}
