package botGenerator.web.xtextServlets;

import java.util.List;

import javax.servlet.ServletContext;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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

import congabase.Project;
import congabase.main.CongaData;
import generator.Bot;
import generator.GeneratorPackage;
import validation.problems.Problem;
import validation.problems.Problem.Severity;
import validation.problems.ProblemSet;

/**
 * @author Sara Pérez Soler
 * 
 *         Allows services calls to validate the resource and transform the
 *         Problem object into a Issue object
 * 
 **/

public class MyResourceValidator extends ResourceValidatorImpl {

	@Override
	public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator mon) throws OperationCanceledError {
		List<Issue> issues = super.validate(resource, mode, mon);
		IAcceptor<Issue> acceptor = createAcceptor(issues);
		try {
			CongaData conga = CongaData.getCongaData((ServletContext) null);
			Project p = conga.getProject(resource);
			if (p != null) {
				ProblemSet set;
				set = p.getProblemSet();
				if (set != null) {
					set.resolve((Bot) resource.getContents().get(0));
					for (Problem problem : set.getProblems()) {
						EObject object = problem.obtainEObject();
						EStructuralFeature feature = problem.obtainFeature();
						if (object == null) {
							object = resource.getContents().get(0);
							feature = GeneratorPackage.Literals.ELEMENT__NAME;
						}
						Diagnostic diagnostic = new FeatureBasedDiagnostic(toDiagnosticSeverity(problem.getSeverity()),
								'[' + set.getTool() + ']' + problem.getMessage(), object, feature,
								ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CheckType.NORMAL, null);
						getDiagnosticConverter().convertValidatorDiagnostic(diagnostic, acceptor);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
