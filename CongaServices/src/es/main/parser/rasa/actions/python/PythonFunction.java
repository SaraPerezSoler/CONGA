package es.main.parser.rasa.actions.python;

import java.util.List;

public class PythonFunction {
	private String name;
	private List<String> args;
	private PythonReturn ret;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getArgs() {
		return args;
	}
	public void setArgs(List<String> args) {
		this.args = args;
	}
	public PythonReturn getRet() {
		return ret;
	}
	public void setRet(PythonReturn ret) {
		this.ret = ret;
	}

	
}
