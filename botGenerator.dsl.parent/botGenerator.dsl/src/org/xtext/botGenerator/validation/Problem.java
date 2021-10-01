package org.xtext.botGenerator.validation;

import org.eclipse.emf.ecore.EObject;

public class Problem {

	public enum Severity{
		INFO, WARNING, ERROR
	}
	
	private Severity severity;
	private EObject object;
	private String className;
	private String message;
	public Problem() {
	}
	
	public Problem(Severity severity, EObject object, String className, String message) {
		super();
		this.severity = severity;
		this.object = object;
		this.className = className;
		this.message = message;
	}
	
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public EObject getObject() {
		return object;
	}
	public void setObject(EObject object) {
		this.object = object;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Problem [severity=" + severity + ", object=" + object + ", className=" + className + ", message="
				+ message + "]";
	}
	
	
	
	
	
}
