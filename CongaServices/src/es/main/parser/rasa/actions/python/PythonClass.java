package es.main.parser.rasa.actions.python;

import java.util.List;

public class PythonClass {
	private String name;
	private List<String> extends_;
	private List<PythonFunction> functions;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getExtends() {
		return extends_;
	}
	public void setExtends(List<String> extends_) {
		this.extends_ = extends_;
	}
	public List<PythonFunction> getFunctions() {
		return functions;
	}
	public void setFunctions(List<PythonFunction> functions) {
		this.functions = functions;
	}

	
	
}
