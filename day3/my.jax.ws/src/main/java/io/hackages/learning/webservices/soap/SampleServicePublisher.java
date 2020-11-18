package io.hackages.learning.webservices.soap;


import jakarta.xml.ws.Endpoint;

public class SampleServicePublisher {

	public static void main(String[] args) {
		Endpoint endpoint = Endpoint.create(new ProductServiceImpl());
		endpoint.publish("http://localhost:8888/ws/sample");

		System.out.println("Sample web service ready to consume requests!");
	}
}
