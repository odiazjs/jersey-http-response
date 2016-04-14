package org.odiaz.javarest.messenger.contracts;

import java.util.List;
import org.odiaz.javarest.messenger.dto.UserDto;

public interface IUserContract {
	
	public List<UserDto> getAllUsers() throws Exception;

}
