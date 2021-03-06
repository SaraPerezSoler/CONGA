package org.xtext.botGenerator.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import generator.Action;
import generator.Bot;
import generator.BotInteraction;
import generator.CompositeInput;
import generator.DefaultEntity;
import generator.Entity;
import generator.EntityInput;
import generator.EntityToken;
import generator.HTTPRequest;
import generator.Image;
import generator.IntentInput;
import generator.IntentLanguageInputs;
import generator.KeyValue;
import generator.Language;
import generator.LanguageInput;
import generator.Literal;
import generator.Parameter;
import generator.ParameterReferenceToken;
import generator.ParameterToken;
import generator.PromptLanguage;
import generator.RegexInput;
import generator.SimpleInput;
import generator.Text;
import generator.TextInput;
import generator.TextLanguageInput;
import generator.Token;
import generator.TrainingPhrase;
import generator.UserInteraction;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.botGenerator.generator.BotGenerator;
import zipUtils.Zip;

@SuppressWarnings("all")
public class DialogflowGenerator {
  private String path;
  
  protected static String uri;
  
  private Zip zip;
  
  public Object doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context, final Zip zip) {
    String resourceName = resource.getURI().lastSegment().substring(0, resource.getURI().lastSegment().indexOf("."));
    Bot bot = IteratorExtensions.<Bot>toList(Iterators.<Bot>filter(resource.getAllContents(), Bot.class)).get(0);
    List<HTTPRequest> requests = IteratorExtensions.<HTTPRequest>toList(Iterators.<HTTPRequest>filter(resource.getAllContents(), HTTPRequest.class));
    this.path = (resourceName + "/Dialogflow");
    this.zip = zip;
    fsa.generateFile((this.path + "/package.json"), "{\n \"version\": \"1.0.0\"\n}");
    InputStream packageValue = fsa.readBinaryFile((this.path + "/package.json"));
    zip.addFile("package.json", packageValue);
    boolean _isEmpty = requests.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      HTTPRequest _get = requests.get(0);
      HTTPRequest request = ((HTTPRequest) _get);
      fsa.generateFile((this.path + "/agent.json"), this.agentJSON(bot, request));
    } else {
      fsa.generateFile((this.path + "/agent.json"), this.agentJSON(bot, null));
    }
    InputStream agentValue = fsa.readBinaryFile((this.path + "/agent.json"));
    zip.addFile("agent.json", agentValue);
    List<Entity> entities = IteratorExtensions.<Entity>toList(Iterators.<Entity>filter(resource.getAllContents(), Entity.class));
    for (final Entity entity : entities) {
      {
        String _name = entity.getName();
        String _plus = ((this.path + "/entities/") + _name);
        String _plus_1 = (_plus + ".json");
        fsa.generateFile(_plus_1, this.entityFile(entity));
        String _name_1 = entity.getName();
        String _plus_2 = ((this.path + "/entities/") + _name_1);
        String _plus_3 = (_plus_2 + ".json");
        InputStream entityValue = fsa.readBinaryFile(_plus_3);
        String _name_2 = entity.getName();
        String _plus_4 = (_name_2 + ".json");
        zip.addFileToFolder("entities", _plus_4, entityValue);
        Language lan = Language.ENGLISH;
        EList<LanguageInput> _inputs = entity.getInputs();
        for (final LanguageInput input : _inputs) {
          {
            lan = bot.getLanguages().get(0);
            Language _language = input.getLanguage();
            boolean _notEquals = (!Objects.equal(_language, Language.EMPTY));
            if (_notEquals) {
              lan = input.getLanguage();
            }
            String _name_3 = entity.getName();
            String _plus_5 = ((this.path + "/entities/") + _name_3);
            String _plus_6 = (_plus_5 + "_entries_");
            String _languageAbbreviation = this.languageAbbreviation(lan);
            String _plus_7 = (_plus_6 + _languageAbbreviation);
            String _plus_8 = (_plus_7 + ".json");
            fsa.generateFile(_plus_8, 
              this.entriesFile(input));
            String _name_4 = entity.getName();
            String _plus_9 = ((this.path + "/entities/") + _name_4);
            String _plus_10 = (_plus_9 + "_entries_");
            String _languageAbbreviation_1 = this.languageAbbreviation(lan);
            String _plus_11 = (_plus_10 + _languageAbbreviation_1);
            String _plus_12 = (_plus_11 + ".json");
            InputStream entityLanValue = fsa.readBinaryFile(_plus_12);
            String _name_5 = entity.getName();
            String _plus_13 = (_name_5 + "_entries_");
            String _languageAbbreviation_2 = this.languageAbbreviation(lan);
            String _plus_14 = (_plus_13 + _languageAbbreviation_2);
            String _plus_15 = (_plus_14 + ".json");
            zip.addFileToFolder("entities", _plus_15, entityLanValue);
          }
        }
      }
    }
    EList<UserInteraction> _flows = bot.getFlows();
    for (final UserInteraction transition : _flows) {
      this.createTransitionFiles(transition, "", fsa, bot);
    }
    zip.close();
    return null;
  }
  
  public void createTransitionFiles(final UserInteraction transition, final String prefix, final IFileSystemAccess2 fsa, final Bot bot) {
    String _name = transition.getIntent().getName();
    String _plus = (((this.path + "/intents/") + prefix) + _name);
    String _plus_1 = (_plus + ".json");
    fsa.generateFile(_plus_1, 
      this.intentFile(transition, prefix, bot));
    String _name_1 = transition.getIntent().getName();
    String _plus_2 = (((this.path + "/intents/") + prefix) + _name_1);
    String _plus_3 = (_plus_2 + ".json");
    InputStream intentValue = fsa.readBinaryFile(_plus_3);
    String _name_2 = transition.getIntent().getName();
    String _plus_4 = (prefix + _name_2);
    String _plus_5 = (_plus_4 + ".json");
    this.zip.addFileToFolder("intents", _plus_5, intentValue);
    EList<IntentLanguageInputs> _inputs = transition.getIntent().getInputs();
    for (final IntentLanguageInputs input : _inputs) {
      {
        Language lan = bot.getLanguages().get(0);
        Language _language = input.getLanguage();
        boolean _notEquals = (!Objects.equal(_language, Language.EMPTY));
        if (_notEquals) {
          lan = input.getLanguage();
        }
        String _name_3 = transition.getIntent().getName();
        String _plus_6 = (((this.path + "/intents/") + prefix) + _name_3);
        String _plus_7 = (_plus_6 + "_usersays_");
        String _languageAbbreviation = this.languageAbbreviation(lan);
        String _plus_8 = (_plus_7 + _languageAbbreviation);
        String _plus_9 = (_plus_8 + 
          ".json");
        fsa.generateFile(_plus_9, this.usersayFile(input));
        String _name_4 = transition.getIntent().getName();
        String _plus_10 = (((this.path + "/intents/") + prefix) + _name_4);
        String _plus_11 = (_plus_10 + "_usersays_");
        String _languageAbbreviation_1 = this.languageAbbreviation(lan);
        String _plus_12 = (_plus_11 + _languageAbbreviation_1);
        String _plus_13 = (_plus_12 + 
          ".json");
        InputStream intentLanValue = fsa.readBinaryFile(_plus_13);
        String _name_5 = transition.getIntent().getName();
        String _plus_14 = (prefix + _name_5);
        String _plus_15 = (_plus_14 + "_usersays_");
        String _languageAbbreviation_2 = this.languageAbbreviation(lan);
        String _plus_16 = (_plus_15 + _languageAbbreviation_2);
        String _plus_17 = (_plus_16 + ".json");
        this.zip.addFileToFolder("intents", _plus_17, intentLanValue);
      }
    }
    BotInteraction _target = transition.getTarget();
    boolean _tripleNotEquals = (_target != null);
    if (_tripleNotEquals) {
      String _name_3 = transition.getIntent().getName();
      String _plus_6 = (prefix + _name_3);
      String newPrefix = (_plus_6 + " - ");
      EList<UserInteraction> _outcoming = transition.getTarget().getOutcoming();
      for (final UserInteraction t : _outcoming) {
        this.createTransitionFiles(t, newPrefix, fsa, bot);
      }
    }
  }
  
  public String contextName(final UserInteraction transition, final String prefix) {
    String _name = transition.getIntent().getName();
    String _plus = (prefix + _name);
    String _plus_1 = (_plus + " - ");
    String name = (_plus_1 + "followup");
    name = name.replaceAll(" ", "");
    return name;
  }
  
  public String contextName(final String prefix) {
    String name = (prefix + "followup");
    name = name.replaceAll(" ", "");
    return name;
  }
  
  public String speechText(final TextLanguageInput textAction) {
    String ret = "";
    EList<TextInput> _inputs = textAction.getInputs();
    for (final TextInput input : _inputs) {
      {
        String _ret = ret;
        ret = (_ret + "\"");
        EList<Token> _tokens = input.getTokens();
        for (final Token token : _tokens) {
          if ((token instanceof Literal)) {
            String _ret_1 = ret;
            String _text = ((Literal)token).getText();
            String _plus = (_text + " ");
            ret = (_ret_1 + _plus);
          } else {
            if ((token instanceof ParameterToken)) {
              String _ret_2 = ret;
              String _name = ((ParameterToken)token).getParameter().getName();
              String _plus_1 = ("$" + _name);
              String _plus_2 = (_plus_1 + " ");
              ret = (_ret_2 + _plus_2);
            }
          }
        }
        String _ret_3 = ret;
        ret = (_ret_3 + "\"");
        boolean _isTheLast = DialogflowGenerator.isTheLast(textAction.getInputs(), input);
        boolean _not = (!_isTheLast);
        if (_not) {
          String _ret_4 = ret;
          ret = (_ret_4 + ",");
        }
        String _ret_5 = ret;
        ret = (_ret_5 + "\n");
      }
    }
    return ret;
  }
  
  public String paramType(final Parameter param) {
    Entity _entity = param.getEntity();
    boolean _tripleNotEquals = (_entity != null);
    if (_tripleNotEquals) {
      String _name = param.getEntity().getName();
      return ("@" + _name);
    } else {
      DefaultEntity _defaultEntity = param.getDefaultEntity();
      if (_defaultEntity != null) {
        switch (_defaultEntity) {
          case TEXT:
            return "@sys.any";
          case DATE:
            return "@sys.date";
          case TIME:
            return "@sys.time";
          case NUMBER:
            return "@sys.number-integer";
          case FLOAT:
            return "@sys.number";
          default:
            break;
        }
      }
    }
    return null;
  }
  
  public CharSequence intentFile(final UserInteraction transition, final String prefix, final Bot bot) {
    StringConcatenation _builder = new StringConcatenation();
    boolean webhook = false;
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"id\": \"");
    String _string = UUID.randomUUID().toString();
    _builder.append(_string, "\t");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"name\": \"");
    String _name = transition.getIntent().getName();
    String _plus = (prefix + _name);
    _builder.append(_plus, "\t");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"auto\": true,");
    _builder.newLine();
    {
      BotInteraction _src = transition.getSrc();
      boolean _tripleNotEquals = (_src != null);
      if (_tripleNotEquals) {
        _builder.append("\t");
        _builder.append("\"contexts\": [\"");
        String _contextName = this.contextName(prefix);
        _builder.append(_contextName, "\t");
        _builder.append("\"],");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t");
        _builder.append("\"contexts\": [],");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("\"responses\": [");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"resetContexts\": false,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"affectedContexts\": [");
    _builder.newLine();
    {
      BotInteraction _target = transition.getTarget();
      boolean _tripleNotEquals_1 = (_target != null);
      if (_tripleNotEquals_1) {
        {
          boolean _isEmpty = transition.getTarget().getOutcoming().isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _builder.append("\t\t\t\t");
            _builder.append("{");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("\"name\": \"");
            String _contextName_1 = this.contextName(transition, prefix);
            _builder.append(_contextName_1, "\t\t\t\t\t");
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("\"parameters\": {},");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("\t");
            _builder.append("\"lifespan\": 2");
            _builder.newLine();
            _builder.append("\t\t\t\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"parameters\": [");
    _builder.newLine();
    {
      EList<Parameter> _parameters = transition.getIntent().getParameters();
      for(final Parameter parameter : _parameters) {
        _builder.append("\t\t\t\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"id\": \"");
        String _string_1 = UUID.randomUUID().toString();
        _builder.append(_string_1, "\t\t\t\t\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"required\": ");
        boolean _isRequired = parameter.isRequired();
        _builder.append(_isRequired, "\t\t\t\t\t");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"dataType\": \"");
        String _paramType = this.paramType(parameter);
        _builder.append(_paramType, "\t\t\t\t\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"name\": \"");
        String _name_1 = parameter.getName();
        _builder.append(_name_1, "\t\t\t\t\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"value\": \"$");
        String _name_2 = parameter.getName();
        _builder.append(_name_2, "\t\t\t\t\t");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"prompts\": [");
        _builder.newLine();
        {
          EList<PromptLanguage> _prompts = parameter.getPrompts();
          for(final PromptLanguage prompt : _prompts) {
            {
              EList<String> _prompts_1 = prompt.getPrompts();
              for(final String text : _prompts_1) {
                _builder.append("\t\t\t\t");
                _builder.append("\t\t");
                _builder.append("{");
                _builder.newLine();
                {
                  Language _language = prompt.getLanguage();
                  boolean _notEquals = (!Objects.equal(_language, Language.EMPTY));
                  if (_notEquals) {
                    _builder.append("\t\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("\"lang\": \"");
                    String _languageAbbreviation = this.languageAbbreviation(prompt.getLanguage());
                    _builder.append(_languageAbbreviation, "\t\t\t\t\t\t\t");
                    _builder.append("\",");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("\t\t\t\t");
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("\"lang\": \"");
                    String _languageAbbreviation_1 = this.languageAbbreviation(bot.getLanguages().get(0));
                    _builder.append(_languageAbbreviation_1, "\t\t\t\t\t\t\t");
                    _builder.append("\",");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t\t\t");
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("\"value\": \"");
                _builder.append(text, "\t\t\t\t\t\t\t");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t");
                _builder.append("\t\t");
                _builder.append("}");
                {
                  if (((!DialogflowGenerator.isTheLast(parameter.getPrompts(), prompt)) || (!DialogflowGenerator.isTheLast(prompt.getPrompts(), text)))) {
                    _builder.append(",");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("],");
        _builder.newLine();
        _builder.append("\t\t\t\t");
        _builder.append("\t");
        _builder.append("\"isList\":");
        boolean _isIsList = parameter.isIsList();
        _builder.append(_isIsList, "\t\t\t\t\t");
        _builder.append(" ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t\t");
        _builder.append("}");
        {
          boolean _isTheLast = DialogflowGenerator.isTheLast(transition.getIntent().getParameters(), parameter);
          boolean _not_1 = (!_isTheLast);
          if (_not_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"messages\": [");
    _builder.newLine();
    {
      BotInteraction _target_1 = transition.getTarget();
      boolean _tripleNotEquals_2 = (_target_1 != null);
      if (_tripleNotEquals_2) {
        _builder.append("\t\t\t\t");
        String coma = "";
        _builder.newLineIfNotEmpty();
        {
          EList<Action> _actions = transition.getTarget().getActions();
          for(final Action action : _actions) {
            {
              if ((action instanceof Text)) {
                {
                  EList<TextLanguageInput> _inputs = ((Text)action).getInputs();
                  for(final TextLanguageInput texLanguage : _inputs) {
                    _builder.append("\t\t\t\t");
                    _builder.append(coma, "\t\t\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t\t");
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("\t\t\t\t");
                    _builder.append("\t");
                    _builder.append("\"type\": 0,");
                    _builder.newLine();
                    {
                      Language _language_1 = texLanguage.getLanguage();
                      boolean _notEquals_1 = (!Objects.equal(_language_1, Language.EMPTY));
                      if (_notEquals_1) {
                        _builder.append("\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("\"lang\": \"");
                        String _languageAbbreviation_2 = this.languageAbbreviation(texLanguage.getLanguage());
                        _builder.append(_languageAbbreviation_2, "\t\t\t\t\t");
                        _builder.append("\",");
                        _builder.newLineIfNotEmpty();
                      } else {
                        _builder.append("\t\t\t\t");
                        _builder.append("\t");
                        _builder.append("\"lang\": \"");
                        String _languageAbbreviation_3 = this.languageAbbreviation(bot.getLanguages().get(0));
                        _builder.append(_languageAbbreviation_3, "\t\t\t\t\t");
                        _builder.append("\",");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t\t\t");
                    _builder.append("\t");
                    _builder.append("\"condition\": \"\",");
                    _builder.newLine();
                    _builder.append("\t\t\t\t");
                    _builder.append("\t");
                    _builder.append("\"speech\": [");
                    _builder.newLine();
                    _builder.append("\t\t\t\t");
                    _builder.append("\t\t");
                    String _speechText = this.speechText(texLanguage);
                    _builder.append(_speechText, "\t\t\t\t\t\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t\t\t");
                    _builder.append("\t");
                    _builder.append("]");
                    _builder.newLine();
                    _builder.append("\t\t\t\t");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t\t\t");
                    String _xblockexpression = null;
                    {
                      coma = ",";
                      _xblockexpression = "";
                    }
                    _builder.append(_xblockexpression, "\t\t\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
              } else {
                if ((action instanceof Image)) {
                  _builder.append("\t\t\t\t");
                  _builder.append(coma, "\t\t\t\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t\t");
                  _builder.append("{");
                  _builder.newLine();
                  _builder.append("\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\"type\": 3,");
                  _builder.newLine();
                  _builder.append("\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\"condition\": \"\",");
                  _builder.newLine();
                  _builder.append("\t\t\t\t");
                  _builder.append("\t");
                  _builder.append("\"imageUrl\": \"");
                  String _uRL = ((Image) action).getURL();
                  _builder.append(_uRL, "\t\t\t\t\t");
                  _builder.append("\"");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t\t");
                  _builder.append("}");
                  _builder.newLine();
                  _builder.append("\t\t\t\t");
                  String _xblockexpression_1 = null;
                  {
                    coma = ",";
                    _xblockexpression_1 = "";
                  }
                  _builder.append(_xblockexpression_1, "\t\t\t\t");
                  _builder.newLineIfNotEmpty();
                } else {
                  if ((action instanceof HTTPRequest)) {
                    _builder.append("\t\t\t\t");
                    String _xblockexpression_2 = null;
                    {
                      webhook = true;
                      _xblockexpression_2 = "";
                    }
                    _builder.append(_xblockexpression_2, "\t\t\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"defaultResponsePlatforms\": {},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"speech\": []");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"priority\": 500000,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"webhookUsed\": ");
    _builder.append(webhook, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"webhookForSlotFilling\": false,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"fallbackIntent\": ");
    boolean _isFallbackIntent = transition.getIntent().isFallbackIntent();
    _builder.append(_isFallbackIntent, "\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"events\": [],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"conditionalResponses\": [],");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"condition\": \"\",");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"conditionalFollowupEvents\": []");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence agentJSON(final Bot bot, final HTTPRequest request) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"language\": \"");
    String _languageAbbreviation = this.languageAbbreviation(bot.getLanguages().get(0));
    _builder.append(_languageAbbreviation, "  ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"defaultTimezone\": \"Europe/Madrid\",");
    _builder.newLine();
    {
      if ((request != null)) {
        _builder.append("  ");
        _builder.append("\"webhook\": {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("\"url\": \"");
        String _returnText = this.returnText(request.getURL());
        _builder.append(_returnText, "    ");
        _builder.append("\",");
        _builder.newLineIfNotEmpty();
        {
          KeyValue _basicAuth = request.getBasicAuth();
          boolean _tripleNotEquals = (_basicAuth != null);
          if (_tripleNotEquals) {
            _builder.append("  ");
            _builder.append("  ");
            _builder.append("\"username\": \"");
            String _returnText_1 = this.returnText(request.getBasicAuth().getKey());
            _builder.append(_returnText_1, "    ");
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("  ");
            _builder.append("  ");
            _builder.append("\"username\": \"\",");
            _builder.newLine();
          }
        }
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("\"headers\": {");
        _builder.newLine();
        {
          EList<KeyValue> _headers = request.getHeaders();
          for(final KeyValue header : _headers) {
            _builder.append("  ");
            _builder.append("   ");
            _builder.append("\"");
            String _key = header.getKey();
            _builder.append(_key, "     ");
            _builder.append("\": \"");
            Token _value = header.getValue();
            String _text = ((Literal) _value).getText();
            _builder.append(_text, "     ");
            _builder.append("\"");
            {
              boolean _isTheLast = DialogflowGenerator.isTheLast(request.getHeaders(), header);
              boolean _not = (!_isTheLast);
              if (_not) {
                _builder.append(",");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("\"available\": true,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("\"useForDomains\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("\"cloudFunctionsEnabled\": false,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("\"cloudFunctionsInitialized\": false");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    _builder.append("  ");
    _builder.append("\"isPrivate\": true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"customClassifierMode\": \"use.after\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"mlMinConfidence\": 0.3,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"supportedLanguages\": [");
    _builder.newLine();
    {
      int _size = bot.getLanguages().size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        {
          int _size_1 = bot.getLanguages().size();
          int _minus = (_size_1 - 1);
          IntegerRange _upTo = new IntegerRange(1, _minus);
          for(final Integer i : _upTo) {
            _builder.append("  ");
            _builder.append("\"");
            String _languageAbbreviation_1 = this.languageAbbreviation(bot.getLanguages().get((i).intValue()));
            _builder.append(_languageAbbreviation_1, "  ");
            _builder.append("\"");
            {
              boolean _isTheLast_1 = DialogflowGenerator.isTheLast(bot.getLanguages(), bot.getLanguages().get((i).intValue()));
              boolean _not_1 = (!_isTheLast_1);
              if (_not_1) {
                _builder.append(",");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("  ");
    _builder.append("],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"onePlatformApiVersion\": \"v2\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"analyzeQueryTextSentiment\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"enabledKnowledgeBaseNames\": [],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"knowledgeServiceConfidenceAdjustment\": -0.4,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"dialogBuilderMode\": false,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"baseActionPackagesUrl\": \"\"");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence usersayFile(final IntentLanguageInputs intent) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    _builder.newLine();
    {
      EList<IntentInput> _inputs = intent.getInputs();
      for(final IntentInput phrase : _inputs) {
        {
          if ((phrase instanceof TrainingPhrase)) {
            _builder.append("{");
            _builder.newLine();
            _builder.append("  ");
            _builder.append("\"id\": \"");
            String _string = UUID.randomUUID().toString();
            _builder.append(_string, "  ");
            _builder.append("\",");
            _builder.newLineIfNotEmpty();
            _builder.append("  ");
            _builder.append("\"data\": [");
            _builder.newLine();
            {
              EList<Token> _tokens = ((TrainingPhrase)phrase).getTokens();
              for(final Token token : _tokens) {
                {
                  if ((token instanceof Literal)) {
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("  ");
                    _builder.append("\"text\": \"");
                    String _text = ((Literal)token).getText();
                    _builder.append(_text, "  ");
                    _builder.append("\",");
                    _builder.newLineIfNotEmpty();
                    _builder.append("  ");
                    _builder.append("\"userDefined\": false");
                    _builder.newLine();
                    _builder.append("},");
                    _builder.newLine();
                  } else {
                    if ((token instanceof ParameterReferenceToken)) {
                      _builder.append("{");
                      _builder.newLine();
                      _builder.append("  ");
                      _builder.append("\"text\": \"");
                      String _textReference = ((ParameterReferenceToken) token).getTextReference();
                      _builder.append(_textReference, "  ");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("\"alias\": \"");
                      String _name = ((ParameterReferenceToken) token).getParameter().getName();
                      _builder.append(_name, "  ");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("\"meta\": \"");
                      String _paramType = this.paramType(((ParameterReferenceToken) token).getParameter());
                      _builder.append(_paramType, "  ");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("\"userDefined\": true");
                      _builder.newLine();
                      _builder.append("},");
                      _builder.newLine();
                    }
                  }
                }
                _builder.append("{");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\"text\": \" \",");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\"userDefined\": false");
                _builder.newLine();
                _builder.append("}");
                {
                  boolean _isTheLast = DialogflowGenerator.isTheLast(((TrainingPhrase)phrase).getTokens(), token);
                  boolean _not = (!_isTheLast);
                  if (_not) {
                    _builder.append(",");
                  }
                }
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("],");
            _builder.newLine();
            _builder.append("\"isTemplate\": false,");
            _builder.newLine();
            _builder.append("\"count\": 0,");
            _builder.newLine();
            _builder.append("\"updated\": 0");
            _builder.newLine();
            _builder.append("}");
            {
              boolean _isTheLast_1 = DialogflowGenerator.isTheLast(intent.getInputs(), phrase);
              boolean _not_1 = (!_isTheLast_1);
              if (_not_1) {
                _builder.append(",");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append(" ");
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public String returnText(final String value) {
    boolean _isEmpty = value.isEmpty();
    if (_isEmpty) {
      return "";
    }
    return value;
  }
  
  public String languageAbbreviation(final Language lan) {
    if (lan != null) {
      switch (lan) {
        case ENGLISH:
          return "en";
        case SPANISH:
          return "es";
        case DANISH:
          return "da";
        case GERMAN:
          return "de";
        case FRENCH:
          return "fr";
        case HINDI:
          return "hi";
        case INDONESIAN:
          return "id";
        case ITALIAN:
          return "it";
        case JAPANESE:
          return "ja";
        case KOREAN:
          return "ko";
        case DUTCH:
          return "nl";
        case NORWEGIAN:
          return "no";
        case POLISH:
          return "pl";
        case PORTUGUESE:
          return "pt";
        case RUSIAN:
          return "ru";
        case SWEDISH:
          return "sv";
        case THAI:
          return "th";
        case TURKISH:
          return "tr";
        case UKRANIAN:
          return "uk";
        case CHINESE:
          return "zh";
        default:
          return "en";
      }
    } else {
      return "en";
    }
  }
  
  public CharSequence entityFile(final Entity entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"id\": \"");
    String _string = UUID.randomUUID().toString();
    _builder.append(_string, "\t");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"name\": \"");
    String _name = entity.getName();
    _builder.append(_name, "\t");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"isOverridable\": true,\t  ");
    _builder.newLine();
    {
      int _entityType = BotGenerator.entityType(entity);
      boolean _tripleEquals = (_entityType == BotGenerator.REGEX);
      if (_tripleEquals) {
        _builder.append("\t");
        _builder.append("\"isEnum\": false,");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"isRegexp\":true,");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"automatedExpansion\": true,");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"allowFuzzyExtraction\": false");
        _builder.newLine();
      } else {
        int _entityType_1 = BotGenerator.entityType(entity);
        boolean _tripleEquals_1 = (_entityType_1 == BotGenerator.SIMPLE);
        if (_tripleEquals_1) {
          _builder.append("\t");
          _builder.append("\"isEnum\": false,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"isRegexp\": false,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"automatedExpansion\": true,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"allowFuzzyExtraction\": true");
          _builder.newLine();
        } else {
          _builder.append("\t");
          _builder.append("\"isEnum\": true,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"isRegexp\": false,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"automatedExpansion\": false,");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\"allowFuzzyExtraction\": false");
          _builder.newLine();
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public Object entityIsSimple(final Entity entity) {
    return null;
  }
  
  public CharSequence entriesFile(final LanguageInput entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[");
    _builder.newLine();
    {
      EList<EntityInput> _inputs = entity.getInputs();
      for(final EntityInput entry : _inputs) {
        _builder.append("\t");
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("   ");
        CharSequence _entry = this.entry(entry);
        _builder.append(_entry, "\t   ");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("} ");
        {
          boolean _isTheLast = DialogflowGenerator.isTheLast(entity.getInputs(), entry);
          boolean _not = (!_isTheLast);
          if (_not) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence entry(final EntityInput entry) {
    if ((entry instanceof SimpleInput)) {
      return this.entry(((SimpleInput)entry));
    } else {
      if ((entry instanceof CompositeInput)) {
        return this.entry(((CompositeInput)entry));
      } else {
        if ((entry instanceof RegexInput)) {
          return this.entry(((RegexInput)entry));
        }
      }
    }
    return null;
  }
  
  public CharSequence entry(final SimpleInput entry) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"value\": \"");
    String _name = entry.getName();
    _builder.append(_name);
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\"synonyms\": [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    String _name_1 = entry.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\"");
    {
      boolean _isEmpty = entry.getValues().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append(",");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<String> _values = entry.getValues();
      for(final String synonym : _values) {
        _builder.append("\t");
        _builder.append("\"");
        _builder.append(synonym, "\t");
        _builder.append("\"");
        {
          boolean _isTheLast = DialogflowGenerator.isTheLast(entry.getValues(), synonym);
          boolean _not_1 = (!_isTheLast);
          if (_not_1) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence entry(final CompositeInput entry) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"value\": \"");
    String _compositeEntry = this.getCompositeEntry(entry);
    _builder.append(_compositeEntry);
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\"synonyms\": [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    String _compositeEntry_1 = this.getCompositeEntry(entry);
    _builder.append(_compositeEntry_1, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence entry(final RegexInput entry) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"value\": \"");
    String _expresion = entry.getExpresion();
    _builder.append(_expresion);
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\"synonyms\": [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"");
    String _expresion_1 = entry.getExpresion();
    _builder.append(_expresion_1, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public static boolean isTheLast(final List<?> list, final Object object) {
    int _indexOf = list.indexOf(object);
    int _size = list.size();
    int _minus = (_size - 1);
    boolean _equals = (_indexOf == _minus);
    if (_equals) {
      return true;
    }
    return false;
  }
  
  public String getCompositeEntry(final CompositeInput entry) {
    String ret = "";
    EList<Token> _expresion = entry.getExpresion();
    for (final Token token : _expresion) {
      if ((token instanceof Literal)) {
        String _ret = ret;
        String _text = ((Literal)token).getText();
        String _plus = (_text + " ");
        ret = (_ret + _plus);
      } else {
        if ((token instanceof EntityToken)) {
          String _ret_1 = ret;
          String _name = ((EntityToken)token).getEntity().getName();
          String _plus_1 = ("@" + _name);
          String _plus_2 = (_plus_1 + ":");
          String _name_1 = ((EntityToken)token).getEntity().getName();
          String _plus_3 = (_plus_2 + _name_1);
          String _plus_4 = (_plus_3 + " ");
          ret = (_ret_1 + _plus_4);
        }
      }
    }
    return ret;
  }
}
