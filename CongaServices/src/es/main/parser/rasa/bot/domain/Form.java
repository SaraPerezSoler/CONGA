package es.main.parser.rasa.bot.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Form {
	private List<String> required_slots;

	public List<String> getRequired_slots() {
		return required_slots;
	}

	public void setRequired_slots(Object required_slots) {
		this.required_slots = new ArrayList<>();
		if (required_slots instanceof List<?>) {
			this.required_slots.addAll((Collection<? extends String>) required_slots);
		}else if (required_slots instanceof Map<?, ?>) {
			this.required_slots.addAll((Collection<? extends String>) ((Map<?, ?>)required_slots).keySet());
		}
	}
	
	
}
