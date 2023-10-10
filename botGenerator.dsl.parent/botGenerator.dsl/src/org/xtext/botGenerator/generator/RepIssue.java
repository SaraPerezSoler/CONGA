package org.xtext.botGenerator.generator;

import org.eclipse.xtext.validation.Issue;

public class RepIssue extends MyIssue{
	private int rep;
	private String message;
	
	public RepIssue(int rep, Issue issue) {
		super(issue);
		this.rep = rep;
	}
	
	public void addOne() {
		rep++;
	}
	
	public int getRep() {
		return rep;
	}
	
	public void setMessege(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
