package reverse.rasa.bot;

import org.jsoup.nodes.Document;

import generator.Bot;
import generator.GeneratorFactory;
import generator.Language;

public class RasaBot {

	private String name;
	private Nlu nlu;
	private Stories stories;
	private Domain domain;
	private Config config;

	public RasaBot(String name) {
		super();
		this.name = name;
	}

	public Nlu getNlu() {
		return nlu;
	}

	public Stories getStories() {
		return stories;
	}

	public void setStories(String stories) {
		if (this.stories == null) {
		this.stories = new Stories(stories);
		}else {
			this.stories.add(stories);
		}
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public Bot getRasaBot() {
		Bot bot = GeneratorFactory.eINSTANCE.createBot();
		bot.setName(name);
		if (config != null) {
			bot.getLanguages().add(config.getBotLanguage());
		} else {
			bot.getLanguages().add(Language.ENGLISH);
		}
		if (nlu != null) {
			nlu.saveBotEntities(bot);
			nlu.saveBotIntents(bot);
		}
		domain.saveBotActions(bot);
		stories.saveBotFlows(bot);
		stories.setParameters(bot);
		return bot;
	}

	public void setNlu(Document html) {
		if (this.nlu != null) {
			this.nlu.add(html);
		} else {
			this.nlu = new Nlu(html);
		}
	}

}
