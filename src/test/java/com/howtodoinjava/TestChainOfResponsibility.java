package com.howtodoinjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.ServiceLevel;
import com.sample.data.ServiceRequest;
import com.sample.handler.SupportService;

public class TestChainOfResponsibility {
	public static void main(String[] args) 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
		SupportService supportService = (SupportService) context.getBean("supportService");
		
		ServiceRequest request = new ServiceRequest();
		request.setType(ServiceLevel.LEVEL_ONE);
		supportService.handleRequest(request);
		System.out.println(request.getConclusion());
		
		request = new ServiceRequest();
		request.setType(ServiceLevel.LEVEL_THREE);
		supportService.handleRequest(request);
		System.out.println(request.getConclusion());
		
		request = new ServiceRequest();
		request.setType(ServiceLevel.INVALID_REQUEST);
		supportService.handleRequest(request);
		System.out.println(request.getConclusion());
	}
}
