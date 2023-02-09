package com.playerauction.player.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.playerauction.player.entity.Player;
import com.playerauction.player.entity.Response;
import com.playerauction.player.exception.BudgetExceedsException;
import com.playerauction.player.exception.PlayerNotFoundException;
import com.playerauction.player.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService{
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public Player addPlayer(Player player) {
		Response response = restTemplate.getForObject("http://localhost:8082/team/getBudget/" + player.getTeamName(),
				Response.class);
		if(!(response.getTeamBudget()>=player.getBiddingPrice()))
		{
			throw new BudgetExceedsException("Player Can't be tagged to this team as it exceeds team's total budget");
		}
		
		restTemplate.getForObject("http://localhost:8082/team/updateBudget/" + player.getBiddingPrice()+"/"+player.getTeamName(),void.class);
		return playerRepository.save(player);
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamName) {
		return playerRepository.getPlayersByTeamName(teamName);
	}

	@Override
	public Player getPlayerByName(String playerName) {
		
		return playerRepository.findById(playerName).orElseThrow(()-> new PlayerNotFoundException("Player With Player Name :"+ playerName + "Not Found"));
	}

}
