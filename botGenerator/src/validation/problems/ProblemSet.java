package validation.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import generator.Bot;
import generator.GeneratorPackage;
/**
 * @author Sara Pérez Soler
 * 
 * Validation Problem Set, using in validation service
 * 
 * **/
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

	public void resolve(Bot bot) {
		
		for (Problem problem: problems) {
			EClass eClass = (EClass) GeneratorPackage.eINSTANCE.getEClassifier(problem.getClassName());
			if (eClass != null) {
				Iterator<?> objs = IteratorExtensions.filter(bot.eAllContents(), eClass.getInstanceClass());
				while (objs.hasNext()) {
					EObject obj = (EObject) objs.next();
					if (problem.saveEObject(obj)) {
						break;
					}
				}
			
			}
		}
	}

}
