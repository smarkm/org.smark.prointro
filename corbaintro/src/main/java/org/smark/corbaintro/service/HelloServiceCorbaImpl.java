package org.smark.corbaintro.service;

import org.smark.corbaintro.service.corba.HelloServicePOA;

public class HelloServiceCorbaImpl extends HelloServicePOA {

	@Override
	public String sayHello() {
		return "hello from service";
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

}
