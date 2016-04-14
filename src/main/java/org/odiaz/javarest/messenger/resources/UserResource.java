package org.odiaz.javarest.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.odiaz.javarest.messenger.dto.UserDto;
import org.odiaz.javarest.messenger.service.UserService;
import org.odiaz.javarest.messenger.utils.ServerResponse;


@Path("/users")
public class UserResource {

	UserService userService = new UserService();
	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers() throws Exception{
		
		List<UserDto> users = userService.getAllUsers();
		ServerResponse<UserDto> serverResponse = new ServerResponse<UserDto>(users, Response.Status.OK);	
		return serverResponse.data;
		
	}
	
}