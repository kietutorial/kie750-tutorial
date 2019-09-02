package com.aikiinc.hello.web.rest;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aikiinc.hello.domain.Message;
import com.aikiinc.hello.kie.service.util.KieUtils;

/**
 * REST controller for managing Hello.
 */
@RestController
@RequestMapping("/api")
public class JbpmProcess {
	private final Logger log = LoggerFactory.getLogger(JbpmProcess.class);
	private static final String ENTITY_NAME = "jbpm";

	public JbpmProcess() {
	}

	@PostMapping("/jbpm/process")
	public ResponseEntity<Message> process(@RequestBody Message message) throws URISyntaxException {
		System.out.println("Processing xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("Processing Message: " + message);
		System.out.println("Processing xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		try {
			// The Message fact
//			message = new Message();
//			message.setMessage("Hello World");
//			message.setMessage(hello.getName());
//			message.setStatus(Message.HELLO);
			// message.setStatus(Message.GOODBYE);

			KieUtils.<Message>executeJbpmProcess(message, "ksession-process", "com.aikiinc.bpmn.hello");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

}
