package com.aikiinc.hello.kie.service.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.hello.kie.sample.Message;

/**
 * Utility to handle KIE Session and firing of Drools, Business Process and
 * Decision Tables
 * 
 * @author Philip Jahmani Chauvet
 */
public class KieUtils {
	private static Logger LOG = LoggerFactory.getLogger(KieUtils.class);
	private static KieSession kSession;
	private static Map<String, KieSession> kSessionMap = new HashMap<String, KieSession>();

	public static KieSession getKieSession(String kmodulename) {

		kSession = kSessionMap.get(kmodulename);
		if (kSession == null) {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();

			kSession = kContainer.newKieSession(kmodulename);
			kSessionMap.put(kmodulename, kSession);
		}

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

	public static void executeJbpmProcess(Message message, String kiesession, String processname) {
		KieSession kSession = KieUtils.getKieSession(kiesession);

		if (message != null) {
			// Fact data to pass to process
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("message", message);

			ProcessUtil.showMessage("Init fact (" + message.getClass().getSimpleName() + "): " + message);

			// Start processing with fact data
			ProcessInstance pinstance = kSession.startProcess(processname, parameters);

			ProcessUtil.showMessage(
					"After processing (" + message.getClass().getSimpleName().toLowerCase() + "): " + message);

			KieUtils.showProcessInstance(pinstance);

			// Default is stateful, so clear session
			kSession.dispose();
		} else {
			LOG.warn("The fact object was null");
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
		LOG.debug("");
		LOG.debug("Executing process: " + procname);

		return kSession.startProcess(procname);
	}

	public static void showProcessInstance(ProcessInstance pinstance) {
		LOG.debug("");
		LOG.debug("=======================================================================");
		if (pinstance != null)
			LOG.debug(pinstance.toString());
		LOG.debug("=======================================================================");
		LOG.debug("id: " + pinstance.getId());
		LOG.debug("processId: " + pinstance.getProcessId());
		LOG.debug("processName: " + pinstance.getProcessName());
		LOG.debug("state: " + pinstance.getState() + " - " + getState(pinstance.getState()));
		LOG.debug("eventTypes: " + Arrays.toString(pinstance.getEventTypes()));
	}

	public static void showHeader(String msg) {
		LOG.debug("");
		LOG.debug("=======================================================");
		LOG.debug(msg);
		LOG.debug("=======================================================");
	}

	public static void showSubHeader(String msg) {
		LOG.debug("-------------------------------------------------------");
		LOG.debug(msg);
		LOG.debug("-------------------------------------------------------");
	}

	public static void showMessage(String msg) {
		LOG.debug(msg);
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
