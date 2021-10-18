package validation.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
/**
 * @author Sara Pérez Soler
 * 
 * Validation Problem, object exchanged in validation service
 * 
 * **/
public class Problem {

	public enum Severity {
		INFO, WARNING, ERROR
	}

	private Severity severity;
	private Map<String, Object> object;
	private String className;
	private String message;
	private EObject eObject;
	private String efeature;

	public Problem() {
	}

	public Problem(Severity severity, EObject object, String className, String message, String efeature) {
		super();
		this.severity = severity;
		saveObject(object);
		this.className = className;
		this.message = message;
		this.efeature = efeature;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public void saveObject(EObject object) {
		
		this.object = eObjectToMap(object);
	}

	private Map<String, Object> eObjectToMap(EObject object) {
		if (object == null) {
			return new HashMap<>();
		}
		Map<String, Object> map = new HashMap<>();
		EClass eclass = object.eClass();
		for (EAttribute attribute : eclass.getEAllAttributes()) {
			if (attribute.getUpperBound() != 1) {
				EList<?> elist = (EList<?>) object.eGet(attribute);
				List<Object> newList = new ArrayList<>();
				newList.addAll(elist);
				map.put(attribute.getName(), newList);
			} else {
				map.put(attribute.getName(), object.eGet(attribute));
			}
		}
		for (EReference references : eclass.getEAllReferences()) {
			if (references.isContainment()) {
				if (references.getUpperBound() != 1 ) {
					EList<EObject> elist = (EList<EObject>) object.eGet(references);
					List<Object> newList = new ArrayList<>();
					for (EObject refObj : elist) {
						newList.add(eObjectToMap(refObj));
					}
					map.put(references.getName(), newList);
				} else {
					map.put(references.getName(), eObjectToMap((EObject) object.eGet(references)));
				}
			}

		}
		return map;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EObject obtainEObject() {
		return this.eObject;
	}

	public EStructuralFeature obtainFeature() {
		if (obtainEObject() == null) {
			return null;
		}
		return obtainEObject().eClass().getEStructuralFeature(efeature);
	}

	public boolean saveEObject(EObject obj) {
		 if (isEObject(obj)) {
			 this.eObject = obj;
			 return true;
		 }else {
			 return false;
		 }
	}

	private boolean isEObject(EObject obj) {
		Map<String, Object> secondObj = eObjectToMap(obj);
		return secondObj.toString().equals(object.toString());
	}

	public String getEfeature() {
		return efeature;
	}

	public void setEfeature(String efeature) {
		this.efeature = efeature;
	}

	public Map<String, Object> getObject() {
		return object;
	}

	public void setObject(Map<String, Object> object) {
		this.object = object;
	}

}
