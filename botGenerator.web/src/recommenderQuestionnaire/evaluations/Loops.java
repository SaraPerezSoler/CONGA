package recommenderQuestionnaire.evaluations;

import java.util.List;


import generator.Bot;
import generator.BotInteraction;
import generator.UserInteraction;

public class Loops extends Evaluator implements YesNoAnswer{

	public Loops(List<String> options) {
		super(options);
		//super(object, "multilanguage");
		text= "Has the bot conversation loops?";
	}
	
	@Override
	protected boolean getMultiresponse() {
		return false;
	}

	@Override
	public List<String> evaluate(Bot bot) {
		for (UserInteraction flow: bot.getFlows()) {
			if (hasLoop(flow)) {
				return getYes();
			}
		}
		return getNo();
	}
	
	public boolean hasLoop(UserInteraction user) {
		if (user.getBackTo()!= null) {
			return true;
		}
		if (user.getTarget()!=null) {
			return hasLoop(user.getTarget());
		}
		return false;
	}
	
	public boolean hasLoop(BotInteraction bot) {
		if (!bot.getBackTo().isEmpty()) {
			return true;
		}
		for (UserInteraction user: bot.getOutcoming()) {
			boolean ret = hasLoop(user);
			if (ret) {
				return true;
			}
		}
		return false;
		
	}
	
}
