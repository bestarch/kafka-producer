package com.bestarch.framework.kafkapoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestarch.framework.kafkapoc.bean.Request;
import com.bestarch.framework.kafkapoc.service.DummyService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class KafkaPocApplication { //implements CommandLineRunner {
	
	@Autowired
	DummyService service;

	public static void main(String[] args) {
		SpringApplication.run(KafkaPocApplication.class, args);
	}
	
	
	@PostMapping("/request")
	public String sendMessage(@RequestBody Request request) {
		long t1 = System.currentTimeMillis();
		System.out.println("Inside sendMessage() controller method");
		service.processRequest(request);
		System.out.println("********* Time taken to send request from client to Kafka ********* "+request.getRequestId()+": "+(System.currentTimeMillis()-t1));
		return "Message published successfully";
	}


	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside run method...");
		Request request = null;
		for (int i=0;i<10;i++) {
			request = new Request(i, "requestName"+i, "details"+i, i*10.0+1, "ser"+i+"00", "miscDetails"+i, i+1);
			service.processRequest(request);
		}
		
	}*/

}
