package org.odiaz.javarest.messenger.contracts;
import java.util.List;

import org.odiaz.javarest.messenger.model.*;

public interface IMessageContract {

	public List<Message> getAllMessages();
	
}
