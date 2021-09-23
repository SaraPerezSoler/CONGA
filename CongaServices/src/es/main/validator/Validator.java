package es.main.validator;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

public abstract class Validator {
	public abstract List<Problem> validate (Resource resource);
}
