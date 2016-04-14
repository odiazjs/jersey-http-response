package org.odiaz.javarest.messenger.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.odiaz.javarest.messenger.contracts.IPlayersContract;
import org.odiaz.javarest.messenger.dto.PlayerDto;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

public class PlayerService implements IPlayersContract {

	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public List<PlayerDto> getAllPlayers() throws Exception {
		
		Client client = ClientBuilder.newClient();
		this.setUrl("https://www.easports.com/fifa/ultimate-team/api/fut/");
		JsonParamObject jsonParamObject = new JsonParamObject(1);
		
		WebTarget baseTarget = client.target(this.url);
		WebTarget itemTarget = baseTarget.path("item");
		
		List<PlayerDto> playersList = new ArrayList<PlayerDto>();
		
		try {			
			
			String data = itemTarget
					.resolveTemplate("jsonParamObject", jsonParamObject)
					.request(MediaType.APPLICATION_JSON)
					.get(String.class);
			
			int index = data.indexOf("[{");
			data = data.substring(index);
			data = data.substring(0, data.length() - 1);
			
			Genson genson = new GensonBuilder()
							.include("firstName", PlayerDto.class)
							.include("lastName", PlayerDto.class)
							.include("league", PlayerDto.class)
							.create();
			
			ArrayList<PlayerDto> players = genson.deserialize(data, new GenericType<ArrayList<PlayerDto>>(){});
			
			players.forEach((player) ->  playersList.add(
					new PlayerDto(1, player.getFirstName(), player.getLastName(), player.getLeague())));
			
			System.out.println(players);
			return new ArrayList<PlayerDto>();
			
		} catch (Exception e) {			
			
			throw new Exception("Error getting the players" + e.getStackTrace());
			
		}finally{
			
			
		}
		
	}
	
	public class JsonParamObject {
		
		public JsonParamObject (int Page) {
			this.Page = Page;
		}
		
		private int Page;

		public int getPage() {
			return Page;
		}

		public void setPage(int page) {
			Page = page;
		}
		
	}
	
}
