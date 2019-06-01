package com.sample.handler;

import com.sample.data.ServiceRequest;

public class SupportService implements SupportServiceItf {

	private SupportServiceItf handler = null;
	
	public SupportServiceItf getHandler() {
		return handler;
	}

	public void setHandler(SupportServiceItf handler) {
		this.handler = handler;
	}

	public void handleRequest(ServiceRequest request) {
		handler.handleRequest(request);
	}
}
