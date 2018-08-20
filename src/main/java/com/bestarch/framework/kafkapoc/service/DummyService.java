package com.bestarch.framework.kafkapoc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.bestarch.framework.kafkapoc.bean.Request;

@Service
public class DummyService {
	
	@Autowired
	KafkaTemplate<Integer, Request> template;
	
	public void processRequest(Request request) {
		System.out.println("Inside processRequest() method");
		Message<Request> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .setHeader(KafkaHeaders.MESSAGE_KEY, request.getRequestId())
                .build();
		template.send(message);
	}

}
