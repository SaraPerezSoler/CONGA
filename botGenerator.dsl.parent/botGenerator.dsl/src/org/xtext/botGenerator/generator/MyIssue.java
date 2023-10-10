package org.xtext.botGenerator.generator;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

public class MyIssue {

	private Issue issue;

	public MyIssue(Issue issue) {
		this.issue = issue;
	}
	
	public Severity getSeverity() {
		return issue.getSeverity();
	}
	
	public String getMessage() {
		return issue.getMessage();
	}
	
	public Issue getIssue() {
		return issue;
	}
	
}
