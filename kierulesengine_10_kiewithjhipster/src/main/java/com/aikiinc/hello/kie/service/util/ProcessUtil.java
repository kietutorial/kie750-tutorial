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
		String path = "Task Begin (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")";

		showPath(path);
	}

	public static void showTaskEnd(ProcessContext kcontext) {
		String path = "Task End(" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")";

		showPath(path);
	}

	public static void showTask(ProcessContext kcontext) {
		String path = "Task (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")";

		showPath(path);
	}

	public static void showGateWay(ProcessContext kcontext) {
		String path = "Gateway (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")";

		showPath(path);
	}

	public static boolean showGateWay(Object booleanExp, ProcessContext kcontext) {
		if (booleanExp == null)
			booleanExp = new Boolean(false);

		boolean bool = (Boolean) booleanExp;
		String path = "Gateway (" + kcontext.getProcessInstance().getProcessName() + " (%s) : "
				+ kcontext.getNodeInstance().getNodeName() + ")";

		if (bool)
			path = String.format(path, "True Path");
		else
			path = String.format(path, "False Path");

		setRuleExecutionPath(path);

		showPath(path);

		return bool;
	}

	public static boolean showGateWay(boolean boolexp, ProcessContext kcontext) {
		return showGateWay(new Boolean(boolexp), kcontext);
	}

	private static void showPath(String path) {
		LOG.debug("");
		LOG.debug("--------------------------------------");
		LOG.debug(path);
		LOG.debug("--------------------------------------");
	}

	private static void setRuleExecutionPath(String path) {
		if (path != null)
			ruleExecutionPath.add(path);
	}

	public static <T> void showFact(T t) {
		LOG.debug("Fact (" + t + ")");
	}

	public static void showTaskName(ProcessContext kcontext) {
		LOG.debug("");
		LOG.debug("Task (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
	}

	public static void showMessage(String msg) {
		LOG.debug(msg);
	}

	public static String getExecutionPaths() {
		StringBuilder bld = new StringBuilder();

		int j = 0;
		for (String path : ruleExecutionPath) {

		}

		return bld.toString();
	}

	public static Boolean getBoolean(Boolean bool) {
		if (bool != null)
			bool = new Boolean(false);

		return bool;
	}

	public static Boolean getBoolean(boolean bool) {
		return new Boolean(bool);
	}

}
