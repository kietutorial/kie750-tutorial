package com.sample;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import com.kie.service.util.KieUtils;
import com.kie.service.util.ProcessUtil;

public class ProcessTest {

	@Test
	public void processWithFactTest() {
		try {
			KieSession kSession = KieUtils.getKieSession("ksession-process");

			// The Message fact
			Message message = new Message();
			message.setMessage("Hello World");
			message.setStatus(Message.HELLO);
			//message.setStatus(Message.GOODBYE);

			ProcessUtil.showMessage("Init fact: message: " + message);

			// Fact data to pass to process
			Map<String, Object> parameters = new HashMap();
			parameters.put("message", message);

			// Start processing with fact data
			ProcessInstance pinstance = kSession.startProcess("com.sample.bpmn.hello", parameters);

			ProcessUtil.showMessage("After processing: message: " + message);
			KieUtils.showProcessInstance(pinstance);

			// Default is stateful, so clear session
			kSession.dispose();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
