package com.sample;

import org.junit.Test;
import org.kie.api.runtime.KieSession;
import com.kie.service.util.KieUtils;

public class DecisionTableTest {

	@Test
	public void sampleDecisionTest() {
		try {
			KieSession kSession = KieUtils.getKieSession("ksession-dtables");

			Message message = new Message();
			message.setMessage("Hello World");
			message.setStatus(Message.HELLO);

			KieUtils.fireRule(kSession, message);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
