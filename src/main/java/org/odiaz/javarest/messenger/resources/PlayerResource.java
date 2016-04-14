package org.odiaz.javarest.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.odiaz.javarest.messenger.dto.PlayerDto;
import org.odiaz.javarest.messenger.service.PlayerService;
import org.odiaz.javarest.messenger.utils.ServerResponse;

@Path("/players")
public class PlayerResource {
	
	PlayerService playerService = new PlayerService();
	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getPlayers() throws Exception{
		
		List<PlayerDto> players = playerService.getAllPlayers();
		ServerResponse<PlayerDto> serverResponse = new ServerResponse<PlayerDto>(players, Response.Status.OK);	
		return serverResponse.data;
		
	}
}
