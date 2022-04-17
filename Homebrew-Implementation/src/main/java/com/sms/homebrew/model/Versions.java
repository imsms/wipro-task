package com.sms.homebrew.model;

public class Versions {
	private String stable;
	private String head;
	private boolean bottle;

	public String getStable() {
		return stable;
	}

	public void setStable(String stable) {
		this.stable = stable;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public boolean isBottle() {
		return bottle;
	}

	public void setBottle(boolean bottle) {
		this.bottle = bottle;
	}
}
