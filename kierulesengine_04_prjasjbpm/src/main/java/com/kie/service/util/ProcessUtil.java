package com.kie.service.util;

import java.io.Serializable;

import org.kie.api.runtime.process.ProcessContext;

/**
 * Utility to pass to processes and show its information.
 * 
 * @author Philip Jahmani Chauvet
 */
public class ProcessUtil implements Serializable {
	private static final long serialVersionUID = 3962128641666447098L;

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

	public static void showTaskName(ProcessContext kcontext) {
		System.out.println("");
		System.out.println("Task (" + kcontext.getProcessInstance().getProcessName() + ": "
				+ kcontext.getNodeInstance().getNodeName() + ")");
	}

}
