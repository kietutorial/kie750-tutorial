package com.sample;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.aikiinc.Message;
import com.kie.service.util.KieUtils;

public class DroolsRuleTest {

	@Test
	public void sampleRuleTest() {
		try {
			KieSession kSession = KieUtils.getKieSession("ksession-rules");

			Message message = new Message();
			message.setMessage("Hello World");
			message.setStatus(Message.HELLO);

			KieUtils.fireRule(kSession, message);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
