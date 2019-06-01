package com.sample.handler;

import com.sample.ServiceLevel;
import com.sample.data.ServiceRequest;

public class ManagerSupport implements SupportServiceItf {
	
	private SupportServiceItf next = null;
	public SupportServiceItf getNext() {
		return next;
	}
	public void setNext(SupportServiceItf next) {
		this.next = next;
	}

	public void handleRequest(ServiceRequest request) {
		if(request.getType() == ServiceLevel.LEVEL_THREE)
		{
			request.setConclusion("Manager solved level three reuqest !!");
		}
		else
		{
			if(next != null){
				next.handleRequest(request);
			}
			else
			{
				throw new IllegalArgumentException("No handler found for :: " + request.getType());
			}
		}
	}

}
