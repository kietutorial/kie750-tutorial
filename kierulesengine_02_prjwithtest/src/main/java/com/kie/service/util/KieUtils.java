package com.kie.service.util;

import java.io.InputStream;
import java.util.Arrays;

import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KieUtils {
	private static Logger LOG = LoggerFactory.getLogger(KieUtils.class);

	public static KieSession getKieSession(String kmodulename) {
		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession(kmodulename);

		return kSession;
	}

	/**
	 * Fire Drool or Decision tables
	 * 
	 * @param <T>
	 * @param kSession
	 * @param t
	 */
	public static <T> void fireRule(KieSession kSession, T t) {
		try {
			kSession.insert(t);
			kSession.fireAllRules();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Fire JBPM processes
	 * 
	 * @param <T>
	 * @param kSession
	 * @param t
	 */
	public static ProcessInstance fireProcess(KieSession kSession, String procname) {
		ProcessInstance pinstance = kSession.startProcess(procname);
		System.out.println("=======================================================================");
		System.out.println(pinstance);
		System.out.println("=======================================================================");
		System.out.println("id: " + pinstance.getId());
		System.out.println("processId: " + pinstance.getProcessId());
		System.out.println("processName: " + pinstance.getProcessName());
		System.out.println("state: " + pinstance.getState() + " - " + getState(pinstance.getState()));
		System.out.println("eventTypes: " + Arrays.toString(pinstance.getEventTypes()));

		return pinstance;
	}

	private static String getState(int stateid) {
		String state = null;
		switch (stateid) {
		case 0: {
			state = "STATE_PENDING";
			break;
		}
		case 1: {
			state = "STATE_ACTIVE`";
			break;
		}
		case 2: {
			state = "STATE_COMPLETED";
			break;
		}
		case 3: {
			state = "STATE_ABORTED";
			break;
		}
		case 4: {
			state = "STATE_SUSPENDED";
			break;
		}
		}
		return state;
	}

}
