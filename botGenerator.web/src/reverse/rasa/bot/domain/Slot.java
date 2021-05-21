package reverse.rasa.bot.domain;

public class Slot {
	private String type;
	private String auto_fill;
	
	public Slot() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuto_fill() {
		return auto_fill;
	}

	public void setAuto_fill(String auto_fill) {
		this.auto_fill = auto_fill;
	}
	
	
}
