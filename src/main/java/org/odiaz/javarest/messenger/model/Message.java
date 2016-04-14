package org.odiaz.javarest.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
	
	private long id;
	private String body;
	private Date createdOn;
	private String author;
	
	public Message() {
		
	}
	
	public Message(long id, String body, String author, Date createdOn) {
		this.id = id;
		this.body = body;
		this.author = author;
		this.createdOn = new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
