package org.odiaz.javarest.messenger.utils;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.owlike.genson.Genson;

public class ServerResponse <T> {
	
	public String data;
	
	public ServerResponse(List<T> resultSet, Response.Status httpCode) {
		
		Genson genson = new Genson();
		ResponseObject<T> responseObject = new ResponseObject<T>(resultSet, httpCode);
		ResponseObjectContainer responseObjectContainer = new ResponseObjectContainer(responseObject);
		this.data = genson.serialize(responseObjectContainer);
		
	}

}

class ResponseObject <T> {
	
	private List<T> resultSet;
	private Response.Status httpCode;
	private int resultCount;
	
	public ResponseObject(List<T> resultSet, Status httpCode) {
		this.resultSet = resultSet;
		this.httpCode = httpCode;
		this.resultCount = resultSet.size();
		
	}
	public List<T> getResultSet() {
		return resultSet;
	}
	public void setResultSet(List<T> resultSet) {
		this.resultSet = resultSet;
	}
	public Response.Status getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(Response.Status httpCode) {
		this.httpCode = httpCode;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	
}

class ResponseObjectContainer {
	
	private ResponseObject<?> data;
	
	public ResponseObjectContainer (ResponseObject<?> responseObject) {
		this.setData(responseObject);
	}

	public ResponseObject<?> getData() {
		return data;
	}

	public void setData(ResponseObject<?> data) {
		this.data = data;
	}
	
}
