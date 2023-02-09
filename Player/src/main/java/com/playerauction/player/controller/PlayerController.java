package com.playerauction.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playerauction.player.entity.Player;
import com.playerauction.player.service.PlayerServiceImpl;

@RestController
@RequestMapping("player")
public class PlayerController {
	@Autowired
	private PlayerServiceImpl playerService;
@PostMapping("/add")
public Player createPlayer(@RequestBody Player player)
{
	return playerService.addPlayer(player);
}

@GetMapping("/getAll/{teamName}")
public List<Player> getAllPlayersByTeamName(@PathVariable("teamName") String teamName)
{
	return playerService.getPlayersByTeamName(teamName);
}

@GetMapping("/get/{playerName}")
public Player getByPlayerName(@PathVariable("playerName") String playerName)
{
	return playerService.getPlayerByName(playerName);
}
}
