package congabase.plantUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;


import botGenerator.web.xtextServlets.BotServlet;
import generator.Action;
import generator.BotInteraction;
import generator.UserInteraction;
/**
 * @author Sara Pérez Soler
 * 
 * Generates PlantUML script to create a flow diagram using a state diagram format
 * UserInteractions are transitions, BotInteractions states
 * 
 * **/
public class CreateFlowsDiagram {

	private static final String ENTR = "\n";
	public static final String START = "@startuml" + ENTR + ENTR;

	public static final String START_CLASS_DIAGRAM = START + "skinparam class {" + ENTR + "}" + ENTR
			+ "skinparam nodeSep 30 " + ENTR /////// configura espacio horizontal
			+ "skinparam rankSep 30 " + ENTR /////// configura espacio vertical
			+ "hide empty members   " + ENTR; /////// oculta la cajita de atributos si está vacía
	public static final String END = ENTR + "@enduml";
	public static final String CHOICE = "state c <<choice>>"+ENTR;
	public static final String INITIAL_FINAL_STATE = "[*]";
	public static final String CHOICE_STATE = "c";
	public static final String START_NOTE  = "note on link"+ENTR;
	public static final String END_NOTE  = "end note"+ENTR;
	
	
	private String initialState = INITIAL_FINAL_STATE;
	private Map<BotInteraction, String> stateName = new HashMap<>();
	private List<BotInteraction> printed = new ArrayList<BotInteraction>();
	//private List<String> names = new ArrayList<>();
	
	public String createUML(Resource resource, List<UserInteraction> flows) {
		IResourceValidator validator = BotServlet.getInjector().getInstance(IResourceValidator.class);
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				if (issue.getSeverity() == Severity.ERROR) {
					return START_CLASS_DIAGRAM + "[*]-->[*]"+END;
				}
			}
		}
		String cad = START_CLASS_DIAGRAM;
		if (flows.size()>1) {
			cad += CHOICE;
			cad += INITIAL_FINAL_STATE +"-->"+CHOICE_STATE+ENTR;
			initialState= CHOICE_STATE;
		}
		
		for (UserInteraction flow : flows) {
			cad += printFlow(flow);
		}
		cad += END;
		return cad;
	}

	private String printFlow(UserInteraction user) {
		String flowString = printState(user);
		if (user.getTarget() != null) {
			if (!printed.contains(user.getTarget())) {
				flowString += printStateActions(user.getTarget());
				if (user.getTarget().getOutcoming().isEmpty()) {
					flowString += printEndState(user.getTarget());
				}
				printed.add(user.getTarget());
				for (UserInteraction interaction : user.getTarget().getOutcoming()) {
					flowString += printFlow(interaction);
				}
				for (UserInteraction interaction : user.getTarget().getBackTo()) {
					flowString += printBackTo(interaction, user.getTarget());
				}
				
			}
		}
		return flowString;

	}

	private String printEndState(BotInteraction target) {
		return stateName(target) + "-->"+INITIAL_FINAL_STATE + ENTR;
	}

	private String printState(UserInteraction userInteraction) {
		String previousState;
		String nextState;
		String linkNote= "";
		if (userInteraction.getSrc() == null) {
			previousState = initialState;
		} else {
			previousState = stateName(userInteraction.getSrc());
		}

		if (userInteraction.getTarget() == null) {
			if (userInteraction.getBackTo() == null) {
				nextState = INITIAL_FINAL_STATE;
			}else {
				nextState = stateName(userInteraction.getBackTo().getBackTo());
				if (!userInteraction.getBackTo().getPrevious().isEmpty()) {
					linkNote = START_NOTE;
					for (Action ac: userInteraction.getBackTo().getPrevious()) {
						linkNote+= ac.getName().replace(" ", "").replace("-", "")+ENTR;
					}
					linkNote+= END_NOTE;
				}
			}
		} else {
			nextState = stateName(userInteraction.getTarget());
		}
		String name="";
		if (userInteraction.getName()!=null) {
			name=userInteraction.getName()+"-";
		}
		return previousState + "-->" + nextState + " : "+name + userInteraction.getIntent().getName() + ENTR+linkNote;

	}
	private String printBackTo(UserInteraction userInteraction, BotInteraction from) {
		String previousState;
		String nextState;
		previousState = stateName(from);
		if (userInteraction.getTarget() == null) {
			nextState = INITIAL_FINAL_STATE;
		} else {
			nextState = stateName(userInteraction.getTarget());
		}
		String name="";
		if (userInteraction.getName()!=null) {
			name=userInteraction.getName()+"-";
		}
		return previousState + "-->" + nextState + " : " + name+userInteraction.getIntent().getName() + ENTR;

	}

	private String printStateActions(BotInteraction interaction) {
		String actions = "";
		for (Action a : interaction.getActions()) {
			actions += stateName(interaction) + " : " + a.getName() + ENTR;
		}
		return actions;

	}

	private String stateName(BotInteraction interaction) {
		
		if (stateName.containsKey(interaction)) {
			return stateName.get(interaction);
		}
		
		int i = 0;
		String name = interaction.getActions().get(0).getName().replace(" ", "").replace("-", "");
		if (interaction.getName()!= null) {
			name = interaction.getName().replace(" ", "").replace("-", "");
		}
		
		
		boolean flagContinue = false;
		String aux = name;
		do {
			if (!stateName.containsValue(aux)) {
				stateName.put(interaction, aux);
				flagContinue = true;
			}else {
				i++;
				aux = name+i;
			}
		}while (flagContinue != true);
		return aux;
		
		
	}
	
//
//	private int getBotInteractionNumber(BotInteraction interaction) {
//		Integer i = stateNumber.get(interaction);
//		if (i == null) {
//			i = getLastNumber() + 1;
//			stateNumber.put(interaction, i);
//		}
//		return i;
//	}
//
//	private int getLastNumber() {
//		return stateNumber.size();
//	}

}
