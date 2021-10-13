package botGenerator.web.xtextServlets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import generator.Bot;
import validation.problems.Problem;
import validation.problems.Problem.Severity;
import validation.problems.ProblemSet;

/**
 * @author Sara Pérez Soler
 * 
 * Allows services calls to validate the resource and transform the Problem object into a Issue object
 * 
 * **/

public class MyResourceValidator extends ResourceValidatorImpl {
	
	//Call the service instead of get the problems
	private Map<Resource, ProblemSet> problems= new HashMap<>();
	
	@Override
	public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator mon) throws OperationCanceledError {
		List<Issue> issues = super.validate(resource, mode, mon);
		IAcceptor<Issue> acceptor= createAcceptor(issues);
		ProblemSet set = problems.get(resource);
		set.resolve((Bot)resource.getContents().get(0));
		if (set != null) {
			for (Problem problem: set.getProblems()) {
				Diagnostic diagnostic = new FeatureBasedDiagnostic(toDiagnosticSeverity(problem.getSeverity()), problem.getMessage(), problem.obtainEObject(), problem.obtainFeature(),ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CheckType.NORMAL,null);
				getDiagnosticConverter().convertValidatorDiagnostic(diagnostic, acceptor);
			}
		}
		
		return issues;
	}
	

	protected int toDiagnosticSeverity(Severity severity) {
		int diagnosticSeverity = -1;
		switch (severity) {
			case ERROR:
				diagnosticSeverity = Diagnostic.ERROR;
				break;
			case WARNING:
				diagnosticSeverity = Diagnostic.WARNING;
				break;
			case INFO:
				diagnosticSeverity = Diagnostic.INFO;
				break;
			default:
				throw new IllegalArgumentException("Unknow severity " + severity);
		}
		return diagnosticSeverity;
	}

}
