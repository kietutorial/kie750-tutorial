package com.sample;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.kie.service.util.KieUtils;

public class ProcessTest {

	@Test
	public void sampleProcessTest() {
		try {
			KieSession kSession = KieUtils.getKieSession("ksession-process");

			KieUtils.fireProcess(kSession, "com.sample.bpmn.hello");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
