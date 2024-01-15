package es.main.parser.rasa.actions.python;

import java.util.List;

public class PythonImportFrom {
	private String module;
	private List<PythonImport> imports;
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public List<PythonImport> getImports() {
		return imports;
	}
	public void setImports(List<PythonImport> imports) {
		this.imports = imports;
	}
	
	
}
