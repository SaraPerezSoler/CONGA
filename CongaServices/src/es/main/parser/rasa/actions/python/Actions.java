package es.main.parser.rasa.actions.python;

import java.util.List;

public class Actions {
	private List<PythonClass> classes;
	private List<PythonImport> imports;
	private List<PythonImportFrom> ImportsFrom;
	public List<PythonClass> getClasses() {
		return classes;
	}
	public void setClasses(List<PythonClass> classes) {
		this.classes = classes;
	}
	public List<PythonImport> getImports() {
		return imports;
	}
	public void setImports(List<PythonImport> imports) {
		this.imports = imports;
	}
	public List<PythonImportFrom> getImportsFrom() {
		return ImportsFrom;
	}
	public void setImportsFrom(List<PythonImportFrom> importsFrom) {
		ImportsFrom = importsFrom;
	}
	
	
	
}
