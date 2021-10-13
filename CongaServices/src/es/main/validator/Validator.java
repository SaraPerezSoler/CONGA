package es.main.validator;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import validation.problems.Problem;

public abstract class Validator {
	public abstract List<Problem> validate (Resource resource);
}
