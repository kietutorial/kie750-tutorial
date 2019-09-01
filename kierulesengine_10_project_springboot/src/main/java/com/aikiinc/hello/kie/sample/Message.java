package com.aikiinc.hello.kie.sample;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1656125146510691501L;
	public static final int HELLO = 0;
	public static final int GOODBYE = 1;
	private String message;
	private int status;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [message=");
		builder.append(message);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}