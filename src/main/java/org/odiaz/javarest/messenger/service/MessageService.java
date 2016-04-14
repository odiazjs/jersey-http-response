package org.odiaz.javarest.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.odiaz.javarest.messenger.contracts.IMessageContract;
import org.odiaz.javarest.messenger.model.Message;

public class MessageService implements IMessageContract {

	@Override
	public List<Message> getAllMessages() {
		
		Message m1 = new Message(1L, "Hey man!", "Author1", new Date());
		Message m2 = new Message(2L,"Standup...", "Author2", new Date());
		
		List<Message> messages = new ArrayList<Message>();
		messages.add(m1);
		messages.add(m2);
		return messages;
		
	}

}
