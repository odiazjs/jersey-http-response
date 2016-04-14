package org.odiaz.javarest.messenger.contracts;

import java.util.List;
import org.odiaz.javarest.messenger.dto.PlayerDto;

public interface IPlayersContract {
	public List<PlayerDto> getAllPlayers() throws Exception;
}
