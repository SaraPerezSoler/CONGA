package org.xtext.botGenerator.validation;

import java.util.ArrayList;
import java.util.List;

public class ProblemSet {
	private String tool;
	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	private List<Problem> problems;
	
	public ProblemSet() {
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	@Override
	public String toString() {
		return "ProblemSet [problems=" + problems + "]";
	}
	
	public List<Problem> getProblems(String className){
		List<Problem> ret = new ArrayList<Problem>();
		for (Problem problem: problems) {
			if (problem.getClassName().equalsIgnoreCase(className)) {
				ret.add(problem);
			}
		}
		return ret;
	}

}
