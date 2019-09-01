package com.aikiinc.hello.kie.service.util;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.runtime.process.ProcessContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility to pass to processes and show its information.
 * 
 * @author Philip Jahmani Chauvet
 */
public class ProcessUtil implements Serializable {
	private static Logger LOG = LoggerFactory.getLogger(ProcessUtil.class);
	private static final long serialVersionUID = 3962128641666447098L;
	private static List<String> ruleExecutionPath = new LinkedList<String>();

	public static void showTaskBegin(ProcessContext kcontext) {
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.println("Task Begin (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
		System.out.println("-----------------------------------");
	}

	public static void showTaskEnd(ProcessContext kcontext) {
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.println("Task End(" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
		System.out.println("-----------------------------------");
	}

	public static void showTask(ProcessContext kcontext) {
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.println("Task (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
		System.out.println("-----------------------------------");
	}

	public static void showGateWay(ProcessContext kcontext) {
		System.out.println("");
		System.out.println("-----------------------------------");
		System.out.println("Gateway (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
		System.out.println("-----------------------------------");
	}

	public static boolean showGateWay(ProcessContext kcontext, Object booleanExp) {
		if (booleanExp == null)
			booleanExp = new Boolean(false);

		boolean bool = (Boolean) booleanExp;
		String path = kcontext.getProcessInstance().getProcessName() + ": " + kcontext.getNodeInstance().getNodeName();
		if (bool)
			path = String.format(path, "True Path");
		else
			path = String.format(path, "False Path");

		setRuleExecutionPath(path);

		showPath(path);

		return bool;
	}

	private static void showPath(String path) {
		LOG.info("");
		LOG.info("--------------------------------------");
		LOG.info(path);
		LOG.info("--------------------------------------");
	}

	private static void setRuleExecutionPath(String path) {
		if (path != null)
			ruleExecutionPath.add(path);
	}

	public static <T> void showFact(T t) {
		System.out.println("Fact (" + t + ")");
	}

	public static void showMessage(String msg) {
		System.out.println(msg);
	}

	public static boolean showGateWay(boolean boolexp, ProcessContext kcontext) {
		if (boolexp) {
			System.out.println("");
			System.out.println("Gateway(" + kcontext.getProcessInstance().getProcessName() + ": "
					+ kcontext.getNodeInstance().getNodeName() + ")");

			return true;
		}

		return false;
	}

	public static Boolean getBoolean(Boolean bool) {
		if (bool != null)
			bool = new Boolean(false);

		return bool;
	}

	public static Boolean getBoolean(boolean bool) {
		return new Boolean(bool);
	}

	public static void showTaskName(ProcessContext kcontext) {
		System.out.println("");
		System.out.println("Task (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
	}

	public static String getExecutionPaths() {
		StringBuilder bld = new StringBuilder();

		int j = 0;
		for (String path : ruleExecutionPath) {

		}

		return bld.toString();
	}

}
