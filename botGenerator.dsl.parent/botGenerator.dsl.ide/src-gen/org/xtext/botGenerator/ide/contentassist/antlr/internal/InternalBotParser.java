package org.xtext.botGenerator.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.botGenerator.services.BotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBotParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'text'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language:'", "'intents'", "':'", "'flows'", "','", "'entities'", "'actions'", "'-'", "';'", "'parameters:'", "'inputs'", "'{'", "'}'", "'in'", "'user'", "'=>'", "'chatbot'", "'entity'", "'prompts'", "'['", "']'", "'Token'", "'@'", "'('", "')'", "'request.'", "'.'", "'Entity'", "'r'", "'c'", "'s'", "'synonyms'", "'response'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'Fallback'", "'required'", "'isList'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalBotParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBotParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBotParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBot.g"; }


    	private BotGrammarAccess grammarAccess;

    	public void setGrammarAccess(BotGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleBot"
    // InternalBot.g:53:1: entryRuleBot : ruleBot EOF ;
    public final void entryRuleBot() throws RecognitionException {
        try {
            // InternalBot.g:54:1: ( ruleBot EOF )
            // InternalBot.g:55:1: ruleBot EOF
            {
             before(grammarAccess.getBotRule()); 
            pushFollow(FOLLOW_1);
            ruleBot();

            state._fsp--;

             after(grammarAccess.getBotRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBot"


    // $ANTLR start "ruleBot"
    // InternalBot.g:62:1: ruleBot : ( ( rule__Bot__Group__0 ) ) ;
    public final void ruleBot() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:66:2: ( ( ( rule__Bot__Group__0 ) ) )
            // InternalBot.g:67:2: ( ( rule__Bot__Group__0 ) )
            {
            // InternalBot.g:67:2: ( ( rule__Bot__Group__0 ) )
            // InternalBot.g:68:3: ( rule__Bot__Group__0 )
            {
             before(grammarAccess.getBotAccess().getGroup()); 
            // InternalBot.g:69:3: ( rule__Bot__Group__0 )
            // InternalBot.g:69:4: rule__Bot__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBot"


    // $ANTLR start "entryRuleAction"
    // InternalBot.g:78:1: entryRuleAction : ruleAction EOF ;
    public final void entryRuleAction() throws RecognitionException {
        try {
            // InternalBot.g:79:1: ( ruleAction EOF )
            // InternalBot.g:80:1: ruleAction EOF
            {
             before(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getActionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalBot.g:87:1: ruleAction : ( ( rule__Action__Alternatives ) ) ;
    public final void ruleAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:91:2: ( ( ( rule__Action__Alternatives ) ) )
            // InternalBot.g:92:2: ( ( rule__Action__Alternatives ) )
            {
            // InternalBot.g:92:2: ( ( rule__Action__Alternatives ) )
            // InternalBot.g:93:3: ( rule__Action__Alternatives )
            {
             before(grammarAccess.getActionAccess().getAlternatives()); 
            // InternalBot.g:94:3: ( rule__Action__Alternatives )
            // InternalBot.g:94:4: rule__Action__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Action__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getActionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEString"
    // InternalBot.g:103:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalBot.g:104:1: ( ruleEString EOF )
            // InternalBot.g:105:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalBot.g:112:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:116:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalBot.g:117:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalBot.g:117:2: ( ( rule__EString__Alternatives ) )
            // InternalBot.g:118:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalBot.g:119:3: ( rule__EString__Alternatives )
            // InternalBot.g:119:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleIntent"
    // InternalBot.g:128:1: entryRuleIntent : ruleIntent EOF ;
    public final void entryRuleIntent() throws RecognitionException {
        try {
            // InternalBot.g:129:1: ( ruleIntent EOF )
            // InternalBot.g:130:1: ruleIntent EOF
            {
             before(grammarAccess.getIntentRule()); 
            pushFollow(FOLLOW_1);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getIntentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntent"


    // $ANTLR start "ruleIntent"
    // InternalBot.g:137:1: ruleIntent : ( ( rule__Intent__Group__0 ) ) ;
    public final void ruleIntent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:141:2: ( ( ( rule__Intent__Group__0 ) ) )
            // InternalBot.g:142:2: ( ( rule__Intent__Group__0 ) )
            {
            // InternalBot.g:142:2: ( ( rule__Intent__Group__0 ) )
            // InternalBot.g:143:3: ( rule__Intent__Group__0 )
            {
             before(grammarAccess.getIntentAccess().getGroup()); 
            // InternalBot.g:144:3: ( rule__Intent__Group__0 )
            // InternalBot.g:144:4: rule__Intent__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntent"


    // $ANTLR start "entryRuleIntentLanguageInputs"
    // InternalBot.g:153:1: entryRuleIntentLanguageInputs : ruleIntentLanguageInputs EOF ;
    public final void entryRuleIntentLanguageInputs() throws RecognitionException {
        try {
            // InternalBot.g:154:1: ( ruleIntentLanguageInputs EOF )
            // InternalBot.g:155:1: ruleIntentLanguageInputs EOF
            {
             before(grammarAccess.getIntentLanguageInputsRule()); 
            pushFollow(FOLLOW_1);
            ruleIntentLanguageInputs();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntentLanguageInputs"


    // $ANTLR start "ruleIntentLanguageInputs"
    // InternalBot.g:162:1: ruleIntentLanguageInputs : ( ( rule__IntentLanguageInputs__Group__0 ) ) ;
    public final void ruleIntentLanguageInputs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:166:2: ( ( ( rule__IntentLanguageInputs__Group__0 ) ) )
            // InternalBot.g:167:2: ( ( rule__IntentLanguageInputs__Group__0 ) )
            {
            // InternalBot.g:167:2: ( ( rule__IntentLanguageInputs__Group__0 ) )
            // InternalBot.g:168:3: ( rule__IntentLanguageInputs__Group__0 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup()); 
            // InternalBot.g:169:3: ( rule__IntentLanguageInputs__Group__0 )
            // InternalBot.g:169:4: rule__IntentLanguageInputs__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntentLanguageInputs"


    // $ANTLR start "entryRuleTransition"
    // InternalBot.g:178:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalBot.g:179:1: ( ruleTransition EOF )
            // InternalBot.g:180:1: ruleTransition EOF
            {
             before(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getTransitionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalBot.g:187:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:191:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalBot.g:192:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalBot.g:192:2: ( ( rule__Transition__Group__0 ) )
            // InternalBot.g:193:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalBot.g:194:3: ( rule__Transition__Group__0 )
            // InternalBot.g:194:4: rule__Transition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleState"
    // InternalBot.g:203:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalBot.g:204:1: ( ruleState EOF )
            // InternalBot.g:205:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalBot.g:212:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:216:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalBot.g:217:2: ( ( rule__State__Group__0 ) )
            {
            // InternalBot.g:217:2: ( ( rule__State__Group__0 ) )
            // InternalBot.g:218:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalBot.g:219:3: ( rule__State__Group__0 )
            // InternalBot.g:219:4: rule__State__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleState2"
    // InternalBot.g:228:1: entryRuleState2 : ruleState2 EOF ;
    public final void entryRuleState2() throws RecognitionException {
        try {
            // InternalBot.g:229:1: ( ruleState2 EOF )
            // InternalBot.g:230:1: ruleState2 EOF
            {
             before(grammarAccess.getState2Rule()); 
            pushFollow(FOLLOW_1);
            ruleState2();

            state._fsp--;

             after(grammarAccess.getState2Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState2"


    // $ANTLR start "ruleState2"
    // InternalBot.g:237:1: ruleState2 : ( ( rule__State2__Group__0 ) ) ;
    public final void ruleState2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:241:2: ( ( ( rule__State2__Group__0 ) ) )
            // InternalBot.g:242:2: ( ( rule__State2__Group__0 ) )
            {
            // InternalBot.g:242:2: ( ( rule__State2__Group__0 ) )
            // InternalBot.g:243:3: ( rule__State2__Group__0 )
            {
             before(grammarAccess.getState2Access().getGroup()); 
            // InternalBot.g:244:3: ( rule__State2__Group__0 )
            // InternalBot.g:244:4: rule__State2__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState2"


    // $ANTLR start "entryRuleIntentInput"
    // InternalBot.g:253:1: entryRuleIntentInput : ruleIntentInput EOF ;
    public final void entryRuleIntentInput() throws RecognitionException {
        try {
            // InternalBot.g:254:1: ( ruleIntentInput EOF )
            // InternalBot.g:255:1: ruleIntentInput EOF
            {
             before(grammarAccess.getIntentInputRule()); 
            pushFollow(FOLLOW_1);
            ruleIntentInput();

            state._fsp--;

             after(grammarAccess.getIntentInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntentInput"


    // $ANTLR start "ruleIntentInput"
    // InternalBot.g:262:1: ruleIntentInput : ( ( rule__IntentInput__Alternatives ) ) ;
    public final void ruleIntentInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:266:2: ( ( ( rule__IntentInput__Alternatives ) ) )
            // InternalBot.g:267:2: ( ( rule__IntentInput__Alternatives ) )
            {
            // InternalBot.g:267:2: ( ( rule__IntentInput__Alternatives ) )
            // InternalBot.g:268:3: ( rule__IntentInput__Alternatives )
            {
             before(grammarAccess.getIntentInputAccess().getAlternatives()); 
            // InternalBot.g:269:3: ( rule__IntentInput__Alternatives )
            // InternalBot.g:269:4: rule__IntentInput__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IntentInput__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntentInputAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntentInput"


    // $ANTLR start "entryRuleTrainingPhrase"
    // InternalBot.g:278:1: entryRuleTrainingPhrase : ruleTrainingPhrase EOF ;
    public final void entryRuleTrainingPhrase() throws RecognitionException {
        try {
            // InternalBot.g:279:1: ( ruleTrainingPhrase EOF )
            // InternalBot.g:280:1: ruleTrainingPhrase EOF
            {
             before(grammarAccess.getTrainingPhraseRule()); 
            pushFollow(FOLLOW_1);
            ruleTrainingPhrase();

            state._fsp--;

             after(grammarAccess.getTrainingPhraseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrainingPhrase"


    // $ANTLR start "ruleTrainingPhrase"
    // InternalBot.g:287:1: ruleTrainingPhrase : ( ( rule__TrainingPhrase__Group__0 ) ) ;
    public final void ruleTrainingPhrase() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:291:2: ( ( ( rule__TrainingPhrase__Group__0 ) ) )
            // InternalBot.g:292:2: ( ( rule__TrainingPhrase__Group__0 ) )
            {
            // InternalBot.g:292:2: ( ( rule__TrainingPhrase__Group__0 ) )
            // InternalBot.g:293:3: ( rule__TrainingPhrase__Group__0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getGroup()); 
            // InternalBot.g:294:3: ( rule__TrainingPhrase__Group__0 )
            // InternalBot.g:294:4: rule__TrainingPhrase__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrainingPhrase"


    // $ANTLR start "entryRuleParameter"
    // InternalBot.g:303:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalBot.g:304:1: ( ruleParameter EOF )
            // InternalBot.g:305:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBot.g:312:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:316:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalBot.g:317:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalBot.g:317:2: ( ( rule__Parameter__Group__0 ) )
            // InternalBot.g:318:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalBot.g:319:3: ( rule__Parameter__Group__0 )
            // InternalBot.g:319:4: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameter2"
    // InternalBot.g:328:1: entryRuleParameter2 : ruleParameter2 EOF ;
    public final void entryRuleParameter2() throws RecognitionException {
        try {
            // InternalBot.g:329:1: ( ruleParameter2 EOF )
            // InternalBot.g:330:1: ruleParameter2 EOF
            {
             before(grammarAccess.getParameter2Rule()); 
            pushFollow(FOLLOW_1);
            ruleParameter2();

            state._fsp--;

             after(grammarAccess.getParameter2Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter2"


    // $ANTLR start "ruleParameter2"
    // InternalBot.g:337:1: ruleParameter2 : ( ( rule__Parameter2__Group__0 ) ) ;
    public final void ruleParameter2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:341:2: ( ( ( rule__Parameter2__Group__0 ) ) )
            // InternalBot.g:342:2: ( ( rule__Parameter2__Group__0 ) )
            {
            // InternalBot.g:342:2: ( ( rule__Parameter2__Group__0 ) )
            // InternalBot.g:343:3: ( rule__Parameter2__Group__0 )
            {
             before(grammarAccess.getParameter2Access().getGroup()); 
            // InternalBot.g:344:3: ( rule__Parameter2__Group__0 )
            // InternalBot.g:344:4: rule__Parameter2__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameter2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter2"


    // $ANTLR start "entryRulePromptLanguage"
    // InternalBot.g:353:1: entryRulePromptLanguage : rulePromptLanguage EOF ;
    public final void entryRulePromptLanguage() throws RecognitionException {
        try {
            // InternalBot.g:354:1: ( rulePromptLanguage EOF )
            // InternalBot.g:355:1: rulePromptLanguage EOF
            {
             before(grammarAccess.getPromptLanguageRule()); 
            pushFollow(FOLLOW_1);
            rulePromptLanguage();

            state._fsp--;

             after(grammarAccess.getPromptLanguageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePromptLanguage"


    // $ANTLR start "rulePromptLanguage"
    // InternalBot.g:362:1: rulePromptLanguage : ( ( rule__PromptLanguage__Group__0 ) ) ;
    public final void rulePromptLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:366:2: ( ( ( rule__PromptLanguage__Group__0 ) ) )
            // InternalBot.g:367:2: ( ( rule__PromptLanguage__Group__0 ) )
            {
            // InternalBot.g:367:2: ( ( rule__PromptLanguage__Group__0 ) )
            // InternalBot.g:368:3: ( rule__PromptLanguage__Group__0 )
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup()); 
            // InternalBot.g:369:3: ( rule__PromptLanguage__Group__0 )
            // InternalBot.g:369:4: rule__PromptLanguage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePromptLanguage"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:378:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBot.g:379:1: ( ruleLiteral EOF )
            // InternalBot.g:380:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBot.g:387:1: ruleLiteral : ( ( rule__Literal__TextAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:391:2: ( ( ( rule__Literal__TextAssignment ) ) )
            // InternalBot.g:392:2: ( ( rule__Literal__TextAssignment ) )
            {
            // InternalBot.g:392:2: ( ( rule__Literal__TextAssignment ) )
            // InternalBot.g:393:3: ( rule__Literal__TextAssignment )
            {
             before(grammarAccess.getLiteralAccess().getTextAssignment()); 
            // InternalBot.g:394:3: ( rule__Literal__TextAssignment )
            // InternalBot.g:394:4: rule__Literal__TextAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Literal__TextAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getTextAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEntityToken"
    // InternalBot.g:403:1: entryRuleEntityToken : ruleEntityToken EOF ;
    public final void entryRuleEntityToken() throws RecognitionException {
        try {
            // InternalBot.g:404:1: ( ruleEntityToken EOF )
            // InternalBot.g:405:1: ruleEntityToken EOF
            {
             before(grammarAccess.getEntityTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleEntityToken();

            state._fsp--;

             after(grammarAccess.getEntityTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntityToken"


    // $ANTLR start "ruleEntityToken"
    // InternalBot.g:412:1: ruleEntityToken : ( ( rule__EntityToken__Group__0 ) ) ;
    public final void ruleEntityToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:416:2: ( ( ( rule__EntityToken__Group__0 ) ) )
            // InternalBot.g:417:2: ( ( rule__EntityToken__Group__0 ) )
            {
            // InternalBot.g:417:2: ( ( rule__EntityToken__Group__0 ) )
            // InternalBot.g:418:3: ( rule__EntityToken__Group__0 )
            {
             before(grammarAccess.getEntityTokenAccess().getGroup()); 
            // InternalBot.g:419:3: ( rule__EntityToken__Group__0 )
            // InternalBot.g:419:4: rule__EntityToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntityToken"


    // $ANTLR start "entryRuleParameterToken"
    // InternalBot.g:428:1: entryRuleParameterToken : ruleParameterToken EOF ;
    public final void entryRuleParameterToken() throws RecognitionException {
        try {
            // InternalBot.g:429:1: ( ruleParameterToken EOF )
            // InternalBot.g:430:1: ruleParameterToken EOF
            {
             before(grammarAccess.getParameterTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterToken();

            state._fsp--;

             after(grammarAccess.getParameterTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterToken"


    // $ANTLR start "ruleParameterToken"
    // InternalBot.g:437:1: ruleParameterToken : ( ( rule__ParameterToken__Group__0 ) ) ;
    public final void ruleParameterToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:441:2: ( ( ( rule__ParameterToken__Group__0 ) ) )
            // InternalBot.g:442:2: ( ( rule__ParameterToken__Group__0 ) )
            {
            // InternalBot.g:442:2: ( ( rule__ParameterToken__Group__0 ) )
            // InternalBot.g:443:3: ( rule__ParameterToken__Group__0 )
            {
             before(grammarAccess.getParameterTokenAccess().getGroup()); 
            // InternalBot.g:444:3: ( rule__ParameterToken__Group__0 )
            // InternalBot.g:444:4: rule__ParameterToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterToken"


    // $ANTLR start "entryRuleParameterRefenceToken"
    // InternalBot.g:453:1: entryRuleParameterRefenceToken : ruleParameterRefenceToken EOF ;
    public final void entryRuleParameterRefenceToken() throws RecognitionException {
        try {
            // InternalBot.g:454:1: ( ruleParameterRefenceToken EOF )
            // InternalBot.g:455:1: ruleParameterRefenceToken EOF
            {
             before(grammarAccess.getParameterRefenceTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleParameterRefenceToken();

            state._fsp--;

             after(grammarAccess.getParameterRefenceTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterRefenceToken"


    // $ANTLR start "ruleParameterRefenceToken"
    // InternalBot.g:462:1: ruleParameterRefenceToken : ( ( rule__ParameterRefenceToken__Group__0 ) ) ;
    public final void ruleParameterRefenceToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:466:2: ( ( ( rule__ParameterRefenceToken__Group__0 ) ) )
            // InternalBot.g:467:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            {
            // InternalBot.g:467:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            // InternalBot.g:468:3: ( rule__ParameterRefenceToken__Group__0 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getGroup()); 
            // InternalBot.g:469:3: ( rule__ParameterRefenceToken__Group__0 )
            // InternalBot.g:469:4: rule__ParameterRefenceToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterRefenceTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterRefenceToken"


    // $ANTLR start "entryRuleHTTPRequestToken"
    // InternalBot.g:478:1: entryRuleHTTPRequestToken : ruleHTTPRequestToken EOF ;
    public final void entryRuleHTTPRequestToken() throws RecognitionException {
        try {
            // InternalBot.g:479:1: ( ruleHTTPRequestToken EOF )
            // InternalBot.g:480:1: ruleHTTPRequestToken EOF
            {
             before(grammarAccess.getHTTPRequestTokenRule()); 
            pushFollow(FOLLOW_1);
            ruleHTTPRequestToken();

            state._fsp--;

             after(grammarAccess.getHTTPRequestTokenRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHTTPRequestToken"


    // $ANTLR start "ruleHTTPRequestToken"
    // InternalBot.g:487:1: ruleHTTPRequestToken : ( ( rule__HTTPRequestToken__Group__0 ) ) ;
    public final void ruleHTTPRequestToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:491:2: ( ( ( rule__HTTPRequestToken__Group__0 ) ) )
            // InternalBot.g:492:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            {
            // InternalBot.g:492:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            // InternalBot.g:493:3: ( rule__HTTPRequestToken__Group__0 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup()); 
            // InternalBot.g:494:3: ( rule__HTTPRequestToken__Group__0 )
            // InternalBot.g:494:4: rule__HTTPRequestToken__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestTokenAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPRequestToken"


    // $ANTLR start "entryRuleEntity"
    // InternalBot.g:503:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalBot.g:504:1: ( ruleEntity EOF )
            // InternalBot.g:505:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalBot.g:512:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:516:2: ( ( ( rule__Entity__Group__0 ) ) )
            // InternalBot.g:517:2: ( ( rule__Entity__Group__0 ) )
            {
            // InternalBot.g:517:2: ( ( rule__Entity__Group__0 ) )
            // InternalBot.g:518:3: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // InternalBot.g:519:3: ( rule__Entity__Group__0 )
            // InternalBot.g:519:4: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleLanguageInput"
    // InternalBot.g:528:1: entryRuleLanguageInput : ruleLanguageInput EOF ;
    public final void entryRuleLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:529:1: ( ruleLanguageInput EOF )
            // InternalBot.g:530:1: ruleLanguageInput EOF
            {
             before(grammarAccess.getLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleLanguageInput();

            state._fsp--;

             after(grammarAccess.getLanguageInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLanguageInput"


    // $ANTLR start "ruleLanguageInput"
    // InternalBot.g:537:1: ruleLanguageInput : ( ( rule__LanguageInput__Group__0 ) ) ;
    public final void ruleLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:541:2: ( ( ( rule__LanguageInput__Group__0 ) ) )
            // InternalBot.g:542:2: ( ( rule__LanguageInput__Group__0 ) )
            {
            // InternalBot.g:542:2: ( ( rule__LanguageInput__Group__0 ) )
            // InternalBot.g:543:3: ( rule__LanguageInput__Group__0 )
            {
             before(grammarAccess.getLanguageInputAccess().getGroup()); 
            // InternalBot.g:544:3: ( rule__LanguageInput__Group__0 )
            // InternalBot.g:544:4: rule__LanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguageInput"


    // $ANTLR start "entryRuleEntityInput"
    // InternalBot.g:553:1: entryRuleEntityInput : ruleEntityInput EOF ;
    public final void entryRuleEntityInput() throws RecognitionException {
        try {
            // InternalBot.g:554:1: ( ruleEntityInput EOF )
            // InternalBot.g:555:1: ruleEntityInput EOF
            {
             before(grammarAccess.getEntityInputRule()); 
            pushFollow(FOLLOW_1);
            ruleEntityInput();

            state._fsp--;

             after(grammarAccess.getEntityInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntityInput"


    // $ANTLR start "ruleEntityInput"
    // InternalBot.g:562:1: ruleEntityInput : ( ( rule__EntityInput__Alternatives ) ) ;
    public final void ruleEntityInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:566:2: ( ( ( rule__EntityInput__Alternatives ) ) )
            // InternalBot.g:567:2: ( ( rule__EntityInput__Alternatives ) )
            {
            // InternalBot.g:567:2: ( ( rule__EntityInput__Alternatives ) )
            // InternalBot.g:568:3: ( rule__EntityInput__Alternatives )
            {
             before(grammarAccess.getEntityInputAccess().getAlternatives()); 
            // InternalBot.g:569:3: ( rule__EntityInput__Alternatives )
            // InternalBot.g:569:4: rule__EntityInput__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EntityInput__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEntityInputAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntityInput"


    // $ANTLR start "entryRuleRegexInput"
    // InternalBot.g:578:1: entryRuleRegexInput : ruleRegexInput EOF ;
    public final void entryRuleRegexInput() throws RecognitionException {
        try {
            // InternalBot.g:579:1: ( ruleRegexInput EOF )
            // InternalBot.g:580:1: ruleRegexInput EOF
            {
             before(grammarAccess.getRegexInputRule()); 
            pushFollow(FOLLOW_1);
            ruleRegexInput();

            state._fsp--;

             after(grammarAccess.getRegexInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRegexInput"


    // $ANTLR start "ruleRegexInput"
    // InternalBot.g:587:1: ruleRegexInput : ( ( rule__RegexInput__Group__0 ) ) ;
    public final void ruleRegexInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:591:2: ( ( ( rule__RegexInput__Group__0 ) ) )
            // InternalBot.g:592:2: ( ( rule__RegexInput__Group__0 ) )
            {
            // InternalBot.g:592:2: ( ( rule__RegexInput__Group__0 ) )
            // InternalBot.g:593:3: ( rule__RegexInput__Group__0 )
            {
             before(grammarAccess.getRegexInputAccess().getGroup()); 
            // InternalBot.g:594:3: ( rule__RegexInput__Group__0 )
            // InternalBot.g:594:4: rule__RegexInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RegexInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRegexInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegexInput"


    // $ANTLR start "entryRuleCompositeInput"
    // InternalBot.g:603:1: entryRuleCompositeInput : ruleCompositeInput EOF ;
    public final void entryRuleCompositeInput() throws RecognitionException {
        try {
            // InternalBot.g:604:1: ( ruleCompositeInput EOF )
            // InternalBot.g:605:1: ruleCompositeInput EOF
            {
             before(grammarAccess.getCompositeInputRule()); 
            pushFollow(FOLLOW_1);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCompositeInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCompositeInput"


    // $ANTLR start "ruleCompositeInput"
    // InternalBot.g:612:1: ruleCompositeInput : ( ( rule__CompositeInput__Group__0 ) ) ;
    public final void ruleCompositeInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:616:2: ( ( ( rule__CompositeInput__Group__0 ) ) )
            // InternalBot.g:617:2: ( ( rule__CompositeInput__Group__0 ) )
            {
            // InternalBot.g:617:2: ( ( rule__CompositeInput__Group__0 ) )
            // InternalBot.g:618:3: ( rule__CompositeInput__Group__0 )
            {
             before(grammarAccess.getCompositeInputAccess().getGroup()); 
            // InternalBot.g:619:3: ( rule__CompositeInput__Group__0 )
            // InternalBot.g:619:4: rule__CompositeInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCompositeInput"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:628:1: entryRuleSimpleInput : ruleSimpleInput EOF ;
    public final void entryRuleSimpleInput() throws RecognitionException {
        try {
            // InternalBot.g:629:1: ( ruleSimpleInput EOF )
            // InternalBot.g:630:1: ruleSimpleInput EOF
            {
             before(grammarAccess.getSimpleInputRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSimpleInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleInput"


    // $ANTLR start "ruleSimpleInput"
    // InternalBot.g:637:1: ruleSimpleInput : ( ( rule__SimpleInput__Group__0 ) ) ;
    public final void ruleSimpleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:641:2: ( ( ( rule__SimpleInput__Group__0 ) ) )
            // InternalBot.g:642:2: ( ( rule__SimpleInput__Group__0 ) )
            {
            // InternalBot.g:642:2: ( ( rule__SimpleInput__Group__0 ) )
            // InternalBot.g:643:3: ( rule__SimpleInput__Group__0 )
            {
             before(grammarAccess.getSimpleInputAccess().getGroup()); 
            // InternalBot.g:644:3: ( rule__SimpleInput__Group__0 )
            // InternalBot.g:644:4: rule__SimpleInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleInput"


    // $ANTLR start "entryRuleText"
    // InternalBot.g:653:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // InternalBot.g:654:1: ( ruleText EOF )
            // InternalBot.g:655:1: ruleText EOF
            {
             before(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            ruleText();

            state._fsp--;

             after(grammarAccess.getTextRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalBot.g:662:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:666:2: ( ( ( rule__Text__Group__0 ) ) )
            // InternalBot.g:667:2: ( ( rule__Text__Group__0 ) )
            {
            // InternalBot.g:667:2: ( ( rule__Text__Group__0 ) )
            // InternalBot.g:668:3: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // InternalBot.g:669:3: ( rule__Text__Group__0 )
            // InternalBot.g:669:4: rule__Text__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleTextLanguageInput"
    // InternalBot.g:678:1: entryRuleTextLanguageInput : ruleTextLanguageInput EOF ;
    public final void entryRuleTextLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:679:1: ( ruleTextLanguageInput EOF )
            // InternalBot.g:680:1: ruleTextLanguageInput EOF
            {
             before(grammarAccess.getTextLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleTextLanguageInput();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextLanguageInput"


    // $ANTLR start "ruleTextLanguageInput"
    // InternalBot.g:687:1: ruleTextLanguageInput : ( ( rule__TextLanguageInput__Group__0 ) ) ;
    public final void ruleTextLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:691:2: ( ( ( rule__TextLanguageInput__Group__0 ) ) )
            // InternalBot.g:692:2: ( ( rule__TextLanguageInput__Group__0 ) )
            {
            // InternalBot.g:692:2: ( ( rule__TextLanguageInput__Group__0 ) )
            // InternalBot.g:693:3: ( rule__TextLanguageInput__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup()); 
            // InternalBot.g:694:3: ( rule__TextLanguageInput__Group__0 )
            // InternalBot.g:694:4: rule__TextLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextLanguageInput"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:703:1: entryRuleHTTPResponse : ruleHTTPResponse EOF ;
    public final void entryRuleHTTPResponse() throws RecognitionException {
        try {
            // InternalBot.g:704:1: ( ruleHTTPResponse EOF )
            // InternalBot.g:705:1: ruleHTTPResponse EOF
            {
             before(grammarAccess.getHTTPResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleHTTPResponse();

            state._fsp--;

             after(grammarAccess.getHTTPResponseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHTTPResponse"


    // $ANTLR start "ruleHTTPResponse"
    // InternalBot.g:712:1: ruleHTTPResponse : ( ( rule__HTTPResponse__Group__0 ) ) ;
    public final void ruleHTTPResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:716:2: ( ( ( rule__HTTPResponse__Group__0 ) ) )
            // InternalBot.g:717:2: ( ( rule__HTTPResponse__Group__0 ) )
            {
            // InternalBot.g:717:2: ( ( rule__HTTPResponse__Group__0 ) )
            // InternalBot.g:718:3: ( rule__HTTPResponse__Group__0 )
            {
             before(grammarAccess.getHTTPResponseAccess().getGroup()); 
            // InternalBot.g:719:3: ( rule__HTTPResponse__Group__0 )
            // InternalBot.g:719:4: rule__HTTPResponse__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPResponse"


    // $ANTLR start "entryRuleHTTPRequest"
    // InternalBot.g:728:1: entryRuleHTTPRequest : ruleHTTPRequest EOF ;
    public final void entryRuleHTTPRequest() throws RecognitionException {
        try {
            // InternalBot.g:729:1: ( ruleHTTPRequest EOF )
            // InternalBot.g:730:1: ruleHTTPRequest EOF
            {
             before(grammarAccess.getHTTPRequestRule()); 
            pushFollow(FOLLOW_1);
            ruleHTTPRequest();

            state._fsp--;

             after(grammarAccess.getHTTPRequestRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHTTPRequest"


    // $ANTLR start "ruleHTTPRequest"
    // InternalBot.g:737:1: ruleHTTPRequest : ( ( rule__HTTPRequest__Group__0 ) ) ;
    public final void ruleHTTPRequest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:741:2: ( ( ( rule__HTTPRequest__Group__0 ) ) )
            // InternalBot.g:742:2: ( ( rule__HTTPRequest__Group__0 ) )
            {
            // InternalBot.g:742:2: ( ( rule__HTTPRequest__Group__0 ) )
            // InternalBot.g:743:3: ( rule__HTTPRequest__Group__0 )
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup()); 
            // InternalBot.g:744:3: ( rule__HTTPRequest__Group__0 )
            // InternalBot.g:744:4: rule__HTTPRequest__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPRequest"


    // $ANTLR start "entryRuleImage"
    // InternalBot.g:753:1: entryRuleImage : ruleImage EOF ;
    public final void entryRuleImage() throws RecognitionException {
        try {
            // InternalBot.g:754:1: ( ruleImage EOF )
            // InternalBot.g:755:1: ruleImage EOF
            {
             before(grammarAccess.getImageRule()); 
            pushFollow(FOLLOW_1);
            ruleImage();

            state._fsp--;

             after(grammarAccess.getImageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImage"


    // $ANTLR start "ruleImage"
    // InternalBot.g:762:1: ruleImage : ( ( rule__Image__Group__0 ) ) ;
    public final void ruleImage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:766:2: ( ( ( rule__Image__Group__0 ) ) )
            // InternalBot.g:767:2: ( ( rule__Image__Group__0 ) )
            {
            // InternalBot.g:767:2: ( ( rule__Image__Group__0 ) )
            // InternalBot.g:768:3: ( rule__Image__Group__0 )
            {
             before(grammarAccess.getImageAccess().getGroup()); 
            // InternalBot.g:769:3: ( rule__Image__Group__0 )
            // InternalBot.g:769:4: rule__Image__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Image__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImage"


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:778:1: entryRuleTextLanguageInputHttpResponse : ruleTextLanguageInputHttpResponse EOF ;
    public final void entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:779:1: ( ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:780:1: ruleTextLanguageInputHttpResponse EOF
            {
             before(grammarAccess.getTextLanguageInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleTextLanguageInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextLanguageInputHttpResponse"


    // $ANTLR start "ruleTextLanguageInputHttpResponse"
    // InternalBot.g:787:1: ruleTextLanguageInputHttpResponse : ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) ;
    public final void ruleTextLanguageInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:791:2: ( ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) )
            // InternalBot.g:792:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            {
            // InternalBot.g:792:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            // InternalBot.g:793:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 
            // InternalBot.g:794:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            // InternalBot.g:794:4: rule__TextLanguageInputHttpResponse__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextLanguageInputHttpResponse"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:803:1: entryRuleTextInputHttpResponse : ruleTextInputHttpResponse EOF ;
    public final void entryRuleTextInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:804:1: ( ruleTextInputHttpResponse EOF )
            // InternalBot.g:805:1: ruleTextInputHttpResponse EOF
            {
             before(grammarAccess.getTextInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextInputHttpResponseRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextInputHttpResponse"


    // $ANTLR start "ruleTextInputHttpResponse"
    // InternalBot.g:812:1: ruleTextInputHttpResponse : ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) ;
    public final void ruleTextInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:816:2: ( ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) )
            // InternalBot.g:817:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            {
            // InternalBot.g:817:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            // InternalBot.g:818:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            {
            // InternalBot.g:818:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) )
            // InternalBot.g:819:4: ( rule__TextInputHttpResponse__TokensAssignment )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:820:4: ( rule__TextInputHttpResponse__TokensAssignment )
            // InternalBot.g:820:5: rule__TextInputHttpResponse__TokensAssignment
            {
            pushFollow(FOLLOW_3);
            rule__TextInputHttpResponse__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }

            // InternalBot.g:823:3: ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            // InternalBot.g:824:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:825:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==69||LA1_0==75) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:825:5: rule__TextInputHttpResponse__TokensAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__TextInputHttpResponse__TokensAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextInputHttpResponse"


    // $ANTLR start "entryRuleTextInputText"
    // InternalBot.g:835:1: entryRuleTextInputText : ruleTextInputText EOF ;
    public final void entryRuleTextInputText() throws RecognitionException {
        try {
            // InternalBot.g:836:1: ( ruleTextInputText EOF )
            // InternalBot.g:837:1: ruleTextInputText EOF
            {
             before(grammarAccess.getTextInputTextRule()); 
            pushFollow(FOLLOW_1);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextInputTextRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTextInputText"


    // $ANTLR start "ruleTextInputText"
    // InternalBot.g:844:1: ruleTextInputText : ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) ;
    public final void ruleTextInputText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:848:2: ( ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) )
            // InternalBot.g:849:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            {
            // InternalBot.g:849:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            // InternalBot.g:850:3: ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* )
            {
            // InternalBot.g:850:3: ( ( rule__TextInputText__TokensAssignment ) )
            // InternalBot.g:851:4: ( rule__TextInputText__TokensAssignment )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:852:4: ( rule__TextInputText__TokensAssignment )
            // InternalBot.g:852:5: rule__TextInputText__TokensAssignment
            {
            pushFollow(FOLLOW_4);
            rule__TextInputText__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }

            // InternalBot.g:855:3: ( ( rule__TextInputText__TokensAssignment )* )
            // InternalBot.g:856:4: ( rule__TextInputText__TokensAssignment )*
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:857:4: ( rule__TextInputText__TokensAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==69) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:857:5: rule__TextInputText__TokensAssignment
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__TextInputText__TokensAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextInputText"


    // $ANTLR start "entryRuleKeyValue"
    // InternalBot.g:867:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBot.g:868:1: ( ruleKeyValue EOF )
            // InternalBot.g:869:1: ruleKeyValue EOF
            {
             before(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_1);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getKeyValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // InternalBot.g:876:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:880:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBot.g:881:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBot.g:881:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBot.g:882:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBot.g:883:3: ( rule__KeyValue__Group__0 )
            // InternalBot.g:883:4: rule__KeyValue__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleData"
    // InternalBot.g:892:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalBot.g:893:1: ( ruleData EOF )
            // InternalBot.g:894:1: ruleData EOF
            {
             before(grammarAccess.getDataRule()); 
            pushFollow(FOLLOW_1);
            ruleData();

            state._fsp--;

             after(grammarAccess.getDataRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalBot.g:901:1: ruleData : ( ( rule__Data__Group__0 ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:905:2: ( ( ( rule__Data__Group__0 ) ) )
            // InternalBot.g:906:2: ( ( rule__Data__Group__0 ) )
            {
            // InternalBot.g:906:2: ( ( rule__Data__Group__0 ) )
            // InternalBot.g:907:3: ( rule__Data__Group__0 )
            {
             before(grammarAccess.getDataAccess().getGroup()); 
            // InternalBot.g:908:3: ( rule__Data__Group__0 )
            // InternalBot.g:908:4: rule__Data__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Data__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleData"


    // $ANTLR start "ruleDefaultEntity"
    // InternalBot.g:917:1: ruleDefaultEntity : ( ( rule__DefaultEntity__Alternatives ) ) ;
    public final void ruleDefaultEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:921:1: ( ( ( rule__DefaultEntity__Alternatives ) ) )
            // InternalBot.g:922:2: ( ( rule__DefaultEntity__Alternatives ) )
            {
            // InternalBot.g:922:2: ( ( rule__DefaultEntity__Alternatives ) )
            // InternalBot.g:923:3: ( rule__DefaultEntity__Alternatives )
            {
             before(grammarAccess.getDefaultEntityAccess().getAlternatives()); 
            // InternalBot.g:924:3: ( rule__DefaultEntity__Alternatives )
            // InternalBot.g:924:4: rule__DefaultEntity__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DefaultEntity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDefaultEntityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefaultEntity"


    // $ANTLR start "ruleHTTPReturnType"
    // InternalBot.g:933:1: ruleHTTPReturnType : ( ( rule__HTTPReturnType__Alternatives ) ) ;
    public final void ruleHTTPReturnType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:937:1: ( ( ( rule__HTTPReturnType__Alternatives ) ) )
            // InternalBot.g:938:2: ( ( rule__HTTPReturnType__Alternatives ) )
            {
            // InternalBot.g:938:2: ( ( rule__HTTPReturnType__Alternatives ) )
            // InternalBot.g:939:3: ( rule__HTTPReturnType__Alternatives )
            {
             before(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 
            // InternalBot.g:940:3: ( rule__HTTPReturnType__Alternatives )
            // InternalBot.g:940:4: rule__HTTPReturnType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__HTTPReturnType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHTTPReturnType"


    // $ANTLR start "ruleLanguage"
    // InternalBot.g:949:1: ruleLanguage : ( ( rule__Language__Alternatives ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:953:1: ( ( ( rule__Language__Alternatives ) ) )
            // InternalBot.g:954:2: ( ( rule__Language__Alternatives ) )
            {
            // InternalBot.g:954:2: ( ( rule__Language__Alternatives ) )
            // InternalBot.g:955:3: ( rule__Language__Alternatives )
            {
             before(grammarAccess.getLanguageAccess().getAlternatives()); 
            // InternalBot.g:956:3: ( rule__Language__Alternatives )
            // InternalBot.g:956:4: rule__Language__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Language__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLanguageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLanguage"


    // $ANTLR start "ruleDataType"
    // InternalBot.g:965:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:969:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalBot.g:970:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalBot.g:970:2: ( ( rule__DataType__Alternatives ) )
            // InternalBot.g:971:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalBot.g:972:3: ( rule__DataType__Alternatives )
            // InternalBot.g:972:4: rule__DataType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleMethod"
    // InternalBot.g:981:1: ruleMethod : ( ( rule__Method__Alternatives ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:985:1: ( ( ( rule__Method__Alternatives ) ) )
            // InternalBot.g:986:2: ( ( rule__Method__Alternatives ) )
            {
            // InternalBot.g:986:2: ( ( rule__Method__Alternatives ) )
            // InternalBot.g:987:3: ( rule__Method__Alternatives )
            {
             before(grammarAccess.getMethodAccess().getAlternatives()); 
            // InternalBot.g:988:3: ( rule__Method__Alternatives )
            // InternalBot.g:988:4: rule__Method__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Method__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMethodAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "rule__Action__Alternatives"
    // InternalBot.g:996:1: rule__Action__Alternatives : ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1000:1: ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 85:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 83:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalBot.g:1001:2: ( ruleText )
                    {
                    // InternalBot.g:1001:2: ( ruleText )
                    // InternalBot.g:1002:3: ruleText
                    {
                     before(grammarAccess.getActionAccess().getTextParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleText();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getTextParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1007:2: ( ruleHTTPRequest )
                    {
                    // InternalBot.g:1007:2: ( ruleHTTPRequest )
                    // InternalBot.g:1008:3: ruleHTTPRequest
                    {
                     before(grammarAccess.getActionAccess().getHTTPRequestParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPRequest();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getHTTPRequestParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1013:2: ( ruleImage )
                    {
                    // InternalBot.g:1013:2: ( ruleImage )
                    // InternalBot.g:1014:3: ruleImage
                    {
                     before(grammarAccess.getActionAccess().getImageParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleImage();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getImageParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1019:2: ( ruleHTTPResponse )
                    {
                    // InternalBot.g:1019:2: ( ruleHTTPResponse )
                    // InternalBot.g:1020:3: ruleHTTPResponse
                    {
                     before(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPResponse();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Action__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalBot.g:1029:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1033:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalBot.g:1034:2: ( RULE_STRING )
                    {
                    // InternalBot.g:1034:2: ( RULE_STRING )
                    // InternalBot.g:1035:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1040:2: ( RULE_ID )
                    {
                    // InternalBot.g:1040:2: ( RULE_ID )
                    // InternalBot.g:1041:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Transition__TargetAlternatives_2_1_0"
    // InternalBot.g:1050:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );
    public final void rule__Transition__TargetAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1054:1: ( ( ruleState ) | ( ruleState2 ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalBot.g:1055:2: ( ruleState )
                    {
                    // InternalBot.g:1055:2: ( ruleState )
                    // InternalBot.g:1056:3: ruleState
                    {
                     before(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_2_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleState();

                    state._fsp--;

                     after(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_2_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1061:2: ( ruleState2 )
                    {
                    // InternalBot.g:1061:2: ( ruleState2 )
                    // InternalBot.g:1062:3: ruleState2
                    {
                     before(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_2_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleState2();

                    state._fsp--;

                     after(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_2_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__TargetAlternatives_2_1_0"


    // $ANTLR start "rule__IntentInput__Alternatives"
    // InternalBot.g:1071:1: rule__IntentInput__Alternatives : ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) );
    public final void rule__IntentInput__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1075:1: ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)||LA6_0==73) ) {
                alt6=1;
            }
            else if ( (LA6_0==78) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBot.g:1076:2: ( ruleTrainingPhrase )
                    {
                    // InternalBot.g:1076:2: ( ruleTrainingPhrase )
                    // InternalBot.g:1077:3: ruleTrainingPhrase
                    {
                     before(grammarAccess.getIntentInputAccess().getTrainingPhraseParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTrainingPhrase();

                    state._fsp--;

                     after(grammarAccess.getIntentInputAccess().getTrainingPhraseParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1082:2: ( ruleRegexInput )
                    {
                    // InternalBot.g:1082:2: ( ruleRegexInput )
                    // InternalBot.g:1083:3: ruleRegexInput
                    {
                     before(grammarAccess.getIntentInputAccess().getRegexInputParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRegexInput();

                    state._fsp--;

                     after(grammarAccess.getIntentInputAccess().getRegexInputParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentInput__Alternatives"


    // $ANTLR start "rule__TrainingPhrase__TokensAlternatives_1_0"
    // InternalBot.g:1092:1: rule__TrainingPhrase__TokensAlternatives_1_0 : ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) );
    public final void rule__TrainingPhrase__TokensAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1096:1: ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            else if ( (LA7_0==73) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBot.g:1097:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1097:2: ( ruleLiteral )
                    // InternalBot.g:1098:3: ruleLiteral
                    {
                     before(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1103:2: ( ruleParameterRefenceToken )
                    {
                    // InternalBot.g:1103:2: ( ruleParameterRefenceToken )
                    // InternalBot.g:1104:3: ruleParameterRefenceToken
                    {
                     before(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterRefenceToken();

                    state._fsp--;

                     after(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__TokensAlternatives_1_0"


    // $ANTLR start "rule__Parameter__Alternatives_3"
    // InternalBot.g:1113:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1117:1: ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=11 && LA8_0<=15)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBot.g:1118:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    {
                    // InternalBot.g:1118:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    // InternalBot.g:1119:3: ( rule__Parameter__EntityAssignment_3_0 )
                    {
                     before(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 
                    // InternalBot.g:1120:3: ( rule__Parameter__EntityAssignment_3_0 )
                    // InternalBot.g:1120:4: rule__Parameter__EntityAssignment_3_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__EntityAssignment_3_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1124:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    {
                    // InternalBot.g:1124:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    // InternalBot.g:1125:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    {
                     before(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 
                    // InternalBot.g:1126:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    // InternalBot.g:1126:4: rule__Parameter__DefaultEntityAssignment_3_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__DefaultEntityAssignment_3_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Alternatives_3"


    // $ANTLR start "rule__EntityInput__Alternatives"
    // InternalBot.g:1134:1: rule__EntityInput__Alternatives : ( ( ruleRegexInput ) | ( ruleCompositeInput ) | ( ruleSimpleInput ) );
    public final void rule__EntityInput__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1138:1: ( ( ruleRegexInput ) | ( ruleCompositeInput ) | ( ruleSimpleInput ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 78:
                {
                alt9=1;
                }
                break;
            case 79:
                {
                alt9=2;
                }
                break;
            case 80:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalBot.g:1139:2: ( ruleRegexInput )
                    {
                    // InternalBot.g:1139:2: ( ruleRegexInput )
                    // InternalBot.g:1140:3: ruleRegexInput
                    {
                     before(grammarAccess.getEntityInputAccess().getRegexInputParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleRegexInput();

                    state._fsp--;

                     after(grammarAccess.getEntityInputAccess().getRegexInputParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1145:2: ( ruleCompositeInput )
                    {
                    // InternalBot.g:1145:2: ( ruleCompositeInput )
                    // InternalBot.g:1146:3: ruleCompositeInput
                    {
                     before(grammarAccess.getEntityInputAccess().getCompositeInputParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleCompositeInput();

                    state._fsp--;

                     after(grammarAccess.getEntityInputAccess().getCompositeInputParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1151:2: ( ruleSimpleInput )
                    {
                    // InternalBot.g:1151:2: ( ruleSimpleInput )
                    // InternalBot.g:1152:3: ruleSimpleInput
                    {
                     before(grammarAccess.getEntityInputAccess().getSimpleInputParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleSimpleInput();

                    state._fsp--;

                     after(grammarAccess.getEntityInputAccess().getSimpleInputParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityInput__Alternatives"


    // $ANTLR start "rule__CompositeInput__ExpresionAlternatives_3_0"
    // InternalBot.g:1161:1: rule__CompositeInput__ExpresionAlternatives_3_0 : ( ( ruleLiteral ) | ( ruleEntityToken ) );
    public final void rule__CompositeInput__ExpresionAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1165:1: ( ( ruleLiteral ) | ( ruleEntityToken ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)) ) {
                alt10=1;
            }
            else if ( (LA10_0==71) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalBot.g:1166:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1166:2: ( ruleLiteral )
                    // InternalBot.g:1167:3: ruleLiteral
                    {
                     before(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_3_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1172:2: ( ruleEntityToken )
                    {
                    // InternalBot.g:1172:2: ( ruleEntityToken )
                    // InternalBot.g:1173:3: ruleEntityToken
                    {
                     before(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_3_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEntityToken();

                    state._fsp--;

                     after(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_3_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__ExpresionAlternatives_3_0"


    // $ANTLR start "rule__TextInputHttpResponse__TokensAlternatives_0"
    // InternalBot.g:1182:1: rule__TextInputHttpResponse__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) );
    public final void rule__TextInputHttpResponse__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1186:1: ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt11=1;
                }
                break;
            case 69:
                {
                alt11=2;
                }
                break;
            case 75:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalBot.g:1187:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1187:2: ( ruleLiteral )
                    // InternalBot.g:1188:3: ruleLiteral
                    {
                     before(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1193:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1193:2: ( ruleParameterToken )
                    // InternalBot.g:1194:3: ruleParameterToken
                    {
                     before(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterToken();

                    state._fsp--;

                     after(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1199:2: ( ruleHTTPRequestToken )
                    {
                    // InternalBot.g:1199:2: ( ruleHTTPRequestToken )
                    // InternalBot.g:1200:3: ruleHTTPRequestToken
                    {
                     before(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPRequestToken();

                    state._fsp--;

                     after(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputHttpResponse__TokensAlternatives_0"


    // $ANTLR start "rule__TextInputText__TokensAlternatives_0"
    // InternalBot.g:1209:1: rule__TextInputText__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__TextInputText__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1213:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                alt12=1;
            }
            else if ( (LA12_0==69) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBot.g:1214:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1214:2: ( ruleLiteral )
                    // InternalBot.g:1215:3: ruleLiteral
                    {
                     before(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1220:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1220:2: ( ruleParameterToken )
                    // InternalBot.g:1221:3: ruleParameterToken
                    {
                     before(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterToken();

                    state._fsp--;

                     after(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputText__TokensAlternatives_0"


    // $ANTLR start "rule__Data__ValueAlternatives_2_0"
    // InternalBot.g:1230:1: rule__Data__ValueAlternatives_2_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__Data__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1234:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_ID)) ) {
                alt13=1;
            }
            else if ( (LA13_0==69) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalBot.g:1235:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1235:2: ( ruleLiteral )
                    // InternalBot.g:1236:3: ruleLiteral
                    {
                     before(grammarAccess.getDataAccess().getValueLiteralParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getDataAccess().getValueLiteralParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1241:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1241:2: ( ruleParameterToken )
                    // InternalBot.g:1242:3: ruleParameterToken
                    {
                     before(grammarAccess.getDataAccess().getValueParameterTokenParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleParameterToken();

                    state._fsp--;

                     after(grammarAccess.getDataAccess().getValueParameterTokenParserRuleCall_2_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__ValueAlternatives_2_0"


    // $ANTLR start "rule__DefaultEntity__Alternatives"
    // InternalBot.g:1251:1: rule__DefaultEntity__Alternatives : ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) );
    public final void rule__DefaultEntity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1255:1: ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) )
            int alt14=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt14=1;
                }
                break;
            case 12:
                {
                alt14=2;
                }
                break;
            case 13:
                {
                alt14=3;
                }
                break;
            case 14:
                {
                alt14=4;
                }
                break;
            case 15:
                {
                alt14=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalBot.g:1256:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1256:2: ( ( 'text' ) )
                    // InternalBot.g:1257:3: ( 'text' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1258:3: ( 'text' )
                    // InternalBot.g:1258:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1262:2: ( ( 'number' ) )
                    {
                    // InternalBot.g:1262:2: ( ( 'number' ) )
                    // InternalBot.g:1263:3: ( 'number' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalBot.g:1264:3: ( 'number' )
                    // InternalBot.g:1264:4: 'number'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1268:2: ( ( 'date' ) )
                    {
                    // InternalBot.g:1268:2: ( ( 'date' ) )
                    // InternalBot.g:1269:3: ( 'date' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1270:3: ( 'date' )
                    // InternalBot.g:1270:4: 'date'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1274:2: ( ( 'float' ) )
                    {
                    // InternalBot.g:1274:2: ( ( 'float' ) )
                    // InternalBot.g:1275:3: ( 'float' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1276:3: ( 'float' )
                    // InternalBot.g:1276:4: 'float'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1280:2: ( ( 'time' ) )
                    {
                    // InternalBot.g:1280:2: ( ( 'time' ) )
                    // InternalBot.g:1281:3: ( 'time' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1282:3: ( 'time' )
                    // InternalBot.g:1282:4: 'time'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DefaultEntity__Alternatives"


    // $ANTLR start "rule__HTTPReturnType__Alternatives"
    // InternalBot.g:1290:1: rule__HTTPReturnType__Alternatives : ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) );
    public final void rule__HTTPReturnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1294:1: ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt15=1;
                }
                break;
            case 16:
                {
                alt15=2;
                }
                break;
            case 17:
                {
                alt15=3;
                }
                break;
            case 18:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalBot.g:1295:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1295:2: ( ( 'text' ) )
                    // InternalBot.g:1296:3: ( 'text' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1297:3: ( 'text' )
                    // InternalBot.g:1297:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1301:2: ( ( 'status_code' ) )
                    {
                    // InternalBot.g:1301:2: ( ( 'status_code' ) )
                    // InternalBot.g:1302:3: ( 'status_code' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1303:3: ( 'status_code' )
                    // InternalBot.g:1303:4: 'status_code'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1307:2: ( ( 'image' ) )
                    {
                    // InternalBot.g:1307:2: ( ( 'image' ) )
                    // InternalBot.g:1308:3: ( 'image' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1309:3: ( 'image' )
                    // InternalBot.g:1309:4: 'image'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1313:2: ( ( 'data' ) )
                    {
                    // InternalBot.g:1313:2: ( ( 'data' ) )
                    // InternalBot.g:1314:3: ( 'data' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1315:3: ( 'data' )
                    // InternalBot.g:1315:4: 'data'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPReturnType__Alternatives"


    // $ANTLR start "rule__Language__Alternatives"
    // InternalBot.g:1323:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1327:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) )
            int alt16=26;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt16=1;
                }
                break;
            case 20:
                {
                alt16=2;
                }
                break;
            case 21:
                {
                alt16=3;
                }
                break;
            case 22:
                {
                alt16=4;
                }
                break;
            case 23:
                {
                alt16=5;
                }
                break;
            case 24:
                {
                alt16=6;
                }
                break;
            case 25:
                {
                alt16=7;
                }
                break;
            case 26:
                {
                alt16=8;
                }
                break;
            case 27:
                {
                alt16=9;
                }
                break;
            case 28:
                {
                alt16=10;
                }
                break;
            case 29:
                {
                alt16=11;
                }
                break;
            case 30:
                {
                alt16=12;
                }
                break;
            case 31:
                {
                alt16=13;
                }
                break;
            case 32:
                {
                alt16=14;
                }
                break;
            case 33:
                {
                alt16=15;
                }
                break;
            case 34:
                {
                alt16=16;
                }
                break;
            case 35:
                {
                alt16=17;
                }
                break;
            case 36:
                {
                alt16=18;
                }
                break;
            case 37:
                {
                alt16=19;
                }
                break;
            case 38:
                {
                alt16=20;
                }
                break;
            case 39:
                {
                alt16=21;
                }
                break;
            case 40:
                {
                alt16=22;
                }
                break;
            case 41:
                {
                alt16=23;
                }
                break;
            case 42:
                {
                alt16=24;
                }
                break;
            case 43:
                {
                alt16=25;
                }
                break;
            case 44:
                {
                alt16=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalBot.g:1328:2: ( ( 'en' ) )
                    {
                    // InternalBot.g:1328:2: ( ( 'en' ) )
                    // InternalBot.g:1329:3: ( 'en' )
                    {
                     before(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1330:3: ( 'en' )
                    // InternalBot.g:1330:4: 'en'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1334:2: ( ( 'es' ) )
                    {
                    // InternalBot.g:1334:2: ( ( 'es' ) )
                    // InternalBot.g:1335:3: ( 'es' )
                    {
                     before(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1336:3: ( 'es' )
                    // InternalBot.g:1336:4: 'es'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1340:2: ( ( 'da' ) )
                    {
                    // InternalBot.g:1340:2: ( ( 'da' ) )
                    // InternalBot.g:1341:3: ( 'da' )
                    {
                     before(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1342:3: ( 'da' )
                    // InternalBot.g:1342:4: 'da'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1346:2: ( ( 'de' ) )
                    {
                    // InternalBot.g:1346:2: ( ( 'de' ) )
                    // InternalBot.g:1347:3: ( 'de' )
                    {
                     before(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1348:3: ( 'de' )
                    // InternalBot.g:1348:4: 'de'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1352:2: ( ( 'fr' ) )
                    {
                    // InternalBot.g:1352:2: ( ( 'fr' ) )
                    // InternalBot.g:1353:3: ( 'fr' )
                    {
                     before(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1354:3: ( 'fr' )
                    // InternalBot.g:1354:4: 'fr'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1358:2: ( ( 'hi' ) )
                    {
                    // InternalBot.g:1358:2: ( ( 'hi' ) )
                    // InternalBot.g:1359:3: ( 'hi' )
                    {
                     before(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 
                    // InternalBot.g:1360:3: ( 'hi' )
                    // InternalBot.g:1360:4: 'hi'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:1364:2: ( ( 'id' ) )
                    {
                    // InternalBot.g:1364:2: ( ( 'id' ) )
                    // InternalBot.g:1365:3: ( 'id' )
                    {
                     before(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 
                    // InternalBot.g:1366:3: ( 'id' )
                    // InternalBot.g:1366:4: 'id'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:1370:2: ( ( 'it' ) )
                    {
                    // InternalBot.g:1370:2: ( ( 'it' ) )
                    // InternalBot.g:1371:3: ( 'it' )
                    {
                     before(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 
                    // InternalBot.g:1372:3: ( 'it' )
                    // InternalBot.g:1372:4: 'it'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:1376:2: ( ( 'ja' ) )
                    {
                    // InternalBot.g:1376:2: ( ( 'ja' ) )
                    // InternalBot.g:1377:3: ( 'ja' )
                    {
                     before(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 
                    // InternalBot.g:1378:3: ( 'ja' )
                    // InternalBot.g:1378:4: 'ja'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:1382:2: ( ( 'ko' ) )
                    {
                    // InternalBot.g:1382:2: ( ( 'ko' ) )
                    // InternalBot.g:1383:3: ( 'ko' )
                    {
                     before(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 
                    // InternalBot.g:1384:3: ( 'ko' )
                    // InternalBot.g:1384:4: 'ko'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:1388:2: ( ( 'nl' ) )
                    {
                    // InternalBot.g:1388:2: ( ( 'nl' ) )
                    // InternalBot.g:1389:3: ( 'nl' )
                    {
                     before(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 
                    // InternalBot.g:1390:3: ( 'nl' )
                    // InternalBot.g:1390:4: 'nl'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:1394:2: ( ( 'no' ) )
                    {
                    // InternalBot.g:1394:2: ( ( 'no' ) )
                    // InternalBot.g:1395:3: ( 'no' )
                    {
                     before(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 
                    // InternalBot.g:1396:3: ( 'no' )
                    // InternalBot.g:1396:4: 'no'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:1400:2: ( ( 'pl' ) )
                    {
                    // InternalBot.g:1400:2: ( ( 'pl' ) )
                    // InternalBot.g:1401:3: ( 'pl' )
                    {
                     before(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 
                    // InternalBot.g:1402:3: ( 'pl' )
                    // InternalBot.g:1402:4: 'pl'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:1406:2: ( ( 'pt' ) )
                    {
                    // InternalBot.g:1406:2: ( ( 'pt' ) )
                    // InternalBot.g:1407:3: ( 'pt' )
                    {
                     before(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 
                    // InternalBot.g:1408:3: ( 'pt' )
                    // InternalBot.g:1408:4: 'pt'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:1412:2: ( ( 'ru' ) )
                    {
                    // InternalBot.g:1412:2: ( ( 'ru' ) )
                    // InternalBot.g:1413:3: ( 'ru' )
                    {
                     before(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 
                    // InternalBot.g:1414:3: ( 'ru' )
                    // InternalBot.g:1414:4: 'ru'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:1418:2: ( ( 'sv' ) )
                    {
                    // InternalBot.g:1418:2: ( ( 'sv' ) )
                    // InternalBot.g:1419:3: ( 'sv' )
                    {
                     before(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 
                    // InternalBot.g:1420:3: ( 'sv' )
                    // InternalBot.g:1420:4: 'sv'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:1424:2: ( ( 'th' ) )
                    {
                    // InternalBot.g:1424:2: ( ( 'th' ) )
                    // InternalBot.g:1425:3: ( 'th' )
                    {
                     before(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 
                    // InternalBot.g:1426:3: ( 'th' )
                    // InternalBot.g:1426:4: 'th'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:1430:2: ( ( 'tr' ) )
                    {
                    // InternalBot.g:1430:2: ( ( 'tr' ) )
                    // InternalBot.g:1431:3: ( 'tr' )
                    {
                     before(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 
                    // InternalBot.g:1432:3: ( 'tr' )
                    // InternalBot.g:1432:4: 'tr'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:1436:2: ( ( 'uk' ) )
                    {
                    // InternalBot.g:1436:2: ( ( 'uk' ) )
                    // InternalBot.g:1437:3: ( 'uk' )
                    {
                     before(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 
                    // InternalBot.g:1438:3: ( 'uk' )
                    // InternalBot.g:1438:4: 'uk'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:1442:2: ( ( 'zh' ) )
                    {
                    // InternalBot.g:1442:2: ( ( 'zh' ) )
                    // InternalBot.g:1443:3: ( 'zh' )
                    {
                     before(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 
                    // InternalBot.g:1444:3: ( 'zh' )
                    // InternalBot.g:1444:4: 'zh'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:1448:2: ( ( 'ar' ) )
                    {
                    // InternalBot.g:1448:2: ( ( 'ar' ) )
                    // InternalBot.g:1449:3: ( 'ar' )
                    {
                     before(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 
                    // InternalBot.g:1450:3: ( 'ar' )
                    // InternalBot.g:1450:4: 'ar'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:1454:2: ( ( 'cz' ) )
                    {
                    // InternalBot.g:1454:2: ( ( 'cz' ) )
                    // InternalBot.g:1455:3: ( 'cz' )
                    {
                     before(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 
                    // InternalBot.g:1456:3: ( 'cz' )
                    // InternalBot.g:1456:4: 'cz'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:1460:2: ( ( 'bu' ) )
                    {
                    // InternalBot.g:1460:2: ( ( 'bu' ) )
                    // InternalBot.g:1461:3: ( 'bu' )
                    {
                     before(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 
                    // InternalBot.g:1462:3: ( 'bu' )
                    // InternalBot.g:1462:4: 'bu'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:1466:2: ( ( 'fi' ) )
                    {
                    // InternalBot.g:1466:2: ( ( 'fi' ) )
                    // InternalBot.g:1467:3: ( 'fi' )
                    {
                     before(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 
                    // InternalBot.g:1468:3: ( 'fi' )
                    // InternalBot.g:1468:4: 'fi'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:1472:2: ( ( 'gr' ) )
                    {
                    // InternalBot.g:1472:2: ( ( 'gr' ) )
                    // InternalBot.g:1473:3: ( 'gr' )
                    {
                     before(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 
                    // InternalBot.g:1474:3: ( 'gr' )
                    // InternalBot.g:1474:4: 'gr'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:1478:2: ( ( 'ba' ) )
                    {
                    // InternalBot.g:1478:2: ( ( 'ba' ) )
                    // InternalBot.g:1479:3: ( 'ba' )
                    {
                     before(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 
                    // InternalBot.g:1480:3: ( 'ba' )
                    // InternalBot.g:1480:4: 'ba'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Language__Alternatives"


    // $ANTLR start "rule__DataType__Alternatives"
    // InternalBot.g:1488:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1492:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==45) ) {
                alt17=1;
            }
            else if ( (LA17_0==46) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalBot.g:1493:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1493:2: ( ( 'JSON' ) )
                    // InternalBot.g:1494:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1495:3: ( 'JSON' )
                    // InternalBot.g:1495:4: 'JSON'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1499:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1499:2: ( ( 'FORM' ) )
                    // InternalBot.g:1500:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1501:3: ( 'FORM' )
                    // InternalBot.g:1501:4: 'FORM'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Alternatives"


    // $ANTLR start "rule__Method__Alternatives"
    // InternalBot.g:1509:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1513:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==47) ) {
                alt18=1;
            }
            else if ( (LA18_0==48) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalBot.g:1514:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1514:2: ( ( 'post' ) )
                    // InternalBot.g:1515:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1516:3: ( 'post' )
                    // InternalBot.g:1516:4: 'post'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1520:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1520:2: ( ( 'get' ) )
                    // InternalBot.g:1521:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1522:3: ( 'get' )
                    // InternalBot.g:1522:4: 'get'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Method__Alternatives"


    // $ANTLR start "rule__Bot__Group__0"
    // InternalBot.g:1530:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1534:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1535:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Bot__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__0"


    // $ANTLR start "rule__Bot__Group__0__Impl"
    // InternalBot.g:1542:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1546:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1547:1: ( 'Chatbot' )
            {
            // InternalBot.g:1547:1: ( 'Chatbot' )
            // InternalBot.g:1548:2: 'Chatbot'
            {
             before(grammarAccess.getBotAccess().getChatbotKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getChatbotKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__0__Impl"


    // $ANTLR start "rule__Bot__Group__1"
    // InternalBot.g:1557:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1561:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1562:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Bot__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__1"


    // $ANTLR start "rule__Bot__Group__1__Impl"
    // InternalBot.g:1569:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1573:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1574:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1574:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1575:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1576:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1576:3: rule__Bot__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__1__Impl"


    // $ANTLR start "rule__Bot__Group__2"
    // InternalBot.g:1584:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1588:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1589:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Bot__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__2"


    // $ANTLR start "rule__Bot__Group__2__Impl"
    // InternalBot.g:1596:1: rule__Bot__Group__2__Impl : ( 'language:' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1600:1: ( ( 'language:' ) )
            // InternalBot.g:1601:1: ( 'language:' )
            {
            // InternalBot.g:1601:1: ( 'language:' )
            // InternalBot.g:1602:2: 'language:'
            {
             before(grammarAccess.getBotAccess().getLanguageKeyword_2()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getLanguageKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__2__Impl"


    // $ANTLR start "rule__Bot__Group__3"
    // InternalBot.g:1611:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1615:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1616:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Bot__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__3"


    // $ANTLR start "rule__Bot__Group__3__Impl"
    // InternalBot.g:1623:1: rule__Bot__Group__3__Impl : ( ( rule__Bot__LanguagesAssignment_3 ) ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1627:1: ( ( ( rule__Bot__LanguagesAssignment_3 ) ) )
            // InternalBot.g:1628:1: ( ( rule__Bot__LanguagesAssignment_3 ) )
            {
            // InternalBot.g:1628:1: ( ( rule__Bot__LanguagesAssignment_3 ) )
            // InternalBot.g:1629:2: ( rule__Bot__LanguagesAssignment_3 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_3()); 
            // InternalBot.g:1630:2: ( rule__Bot__LanguagesAssignment_3 )
            // InternalBot.g:1630:3: rule__Bot__LanguagesAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguagesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguagesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__3__Impl"


    // $ANTLR start "rule__Bot__Group__4"
    // InternalBot.g:1638:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1642:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1643:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Bot__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__4"


    // $ANTLR start "rule__Bot__Group__4__Impl"
    // InternalBot.g:1650:1: rule__Bot__Group__4__Impl : ( ( rule__Bot__Group_4__0 )* ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1654:1: ( ( ( rule__Bot__Group_4__0 )* ) )
            // InternalBot.g:1655:1: ( ( rule__Bot__Group_4__0 )* )
            {
            // InternalBot.g:1655:1: ( ( rule__Bot__Group_4__0 )* )
            // InternalBot.g:1656:2: ( rule__Bot__Group_4__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_4()); 
            // InternalBot.g:1657:2: ( rule__Bot__Group_4__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==54) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:1657:3: rule__Bot__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__Bot__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__4__Impl"


    // $ANTLR start "rule__Bot__Group__5"
    // InternalBot.g:1665:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1669:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1670:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__5"


    // $ANTLR start "rule__Bot__Group__5__Impl"
    // InternalBot.g:1677:1: rule__Bot__Group__5__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1681:1: ( ( 'intents' ) )
            // InternalBot.g:1682:1: ( 'intents' )
            {
            // InternalBot.g:1682:1: ( 'intents' )
            // InternalBot.g:1683:2: 'intents'
            {
             before(grammarAccess.getBotAccess().getIntentsKeyword_5()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getIntentsKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__5__Impl"


    // $ANTLR start "rule__Bot__Group__6"
    // InternalBot.g:1692:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1696:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:1697:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
            {
            pushFollow(FOLLOW_5);
            rule__Bot__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__6"


    // $ANTLR start "rule__Bot__Group__6__Impl"
    // InternalBot.g:1704:1: rule__Bot__Group__6__Impl : ( ':' ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1708:1: ( ( ':' ) )
            // InternalBot.g:1709:1: ( ':' )
            {
            // InternalBot.g:1709:1: ( ':' )
            // InternalBot.g:1710:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_6()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__6__Impl"


    // $ANTLR start "rule__Bot__Group__7"
    // InternalBot.g:1719:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1723:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:1724:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
            {
            pushFollow(FOLLOW_11);
            rule__Bot__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__7"


    // $ANTLR start "rule__Bot__Group__7__Impl"
    // InternalBot.g:1731:1: rule__Bot__Group__7__Impl : ( ( rule__Bot__IntentsAssignment_7 ) ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1735:1: ( ( ( rule__Bot__IntentsAssignment_7 ) ) )
            // InternalBot.g:1736:1: ( ( rule__Bot__IntentsAssignment_7 ) )
            {
            // InternalBot.g:1736:1: ( ( rule__Bot__IntentsAssignment_7 ) )
            // InternalBot.g:1737:2: ( rule__Bot__IntentsAssignment_7 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_7()); 
            // InternalBot.g:1738:2: ( rule__Bot__IntentsAssignment_7 )
            // InternalBot.g:1738:3: rule__Bot__IntentsAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Bot__IntentsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getIntentsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__7__Impl"


    // $ANTLR start "rule__Bot__Group__8"
    // InternalBot.g:1746:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1750:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:1751:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
            {
            pushFollow(FOLLOW_11);
            rule__Bot__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__8"


    // $ANTLR start "rule__Bot__Group__8__Impl"
    // InternalBot.g:1758:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__IntentsAssignment_8 )* ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1762:1: ( ( ( rule__Bot__IntentsAssignment_8 )* ) )
            // InternalBot.g:1763:1: ( ( rule__Bot__IntentsAssignment_8 )* )
            {
            // InternalBot.g:1763:1: ( ( rule__Bot__IntentsAssignment_8 )* )
            // InternalBot.g:1764:2: ( rule__Bot__IntentsAssignment_8 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_8()); 
            // InternalBot.g:1765:2: ( rule__Bot__IntentsAssignment_8 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_ID)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBot.g:1765:3: rule__Bot__IntentsAssignment_8
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Bot__IntentsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getIntentsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__8__Impl"


    // $ANTLR start "rule__Bot__Group__9"
    // InternalBot.g:1773:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1777:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:1778:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__Bot__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__9"


    // $ANTLR start "rule__Bot__Group__9__Impl"
    // InternalBot.g:1785:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__Group_9__0 )? ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1789:1: ( ( ( rule__Bot__Group_9__0 )? ) )
            // InternalBot.g:1790:1: ( ( rule__Bot__Group_9__0 )? )
            {
            // InternalBot.g:1790:1: ( ( rule__Bot__Group_9__0 )? )
            // InternalBot.g:1791:2: ( rule__Bot__Group_9__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_9()); 
            // InternalBot.g:1792:2: ( rule__Bot__Group_9__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==55) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalBot.g:1792:3: rule__Bot__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Bot__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBotAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__9__Impl"


    // $ANTLR start "rule__Bot__Group__10"
    // InternalBot.g:1800:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1804:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:1805:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
            {
            pushFollow(FOLLOW_11);
            rule__Bot__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__10"


    // $ANTLR start "rule__Bot__Group__10__Impl"
    // InternalBot.g:1812:1: rule__Bot__Group__10__Impl : ( ( rule__Bot__Group_10__0 )? ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1816:1: ( ( ( rule__Bot__Group_10__0 )? ) )
            // InternalBot.g:1817:1: ( ( rule__Bot__Group_10__0 )? )
            {
            // InternalBot.g:1817:1: ( ( rule__Bot__Group_10__0 )? )
            // InternalBot.g:1818:2: ( rule__Bot__Group_10__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_10()); 
            // InternalBot.g:1819:2: ( rule__Bot__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==56) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBot.g:1819:3: rule__Bot__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Bot__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBotAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__10__Impl"


    // $ANTLR start "rule__Bot__Group__11"
    // InternalBot.g:1827:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1831:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:1832:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__11"


    // $ANTLR start "rule__Bot__Group__11__Impl"
    // InternalBot.g:1839:1: rule__Bot__Group__11__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1843:1: ( ( 'flows' ) )
            // InternalBot.g:1844:1: ( 'flows' )
            {
            // InternalBot.g:1844:1: ( 'flows' )
            // InternalBot.g:1845:2: 'flows'
            {
             before(grammarAccess.getBotAccess().getFlowsKeyword_11()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getFlowsKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__11__Impl"


    // $ANTLR start "rule__Bot__Group__12"
    // InternalBot.g:1854:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl rule__Bot__Group__13 ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1858:1: ( rule__Bot__Group__12__Impl rule__Bot__Group__13 )
            // InternalBot.g:1859:2: rule__Bot__Group__12__Impl rule__Bot__Group__13
            {
            pushFollow(FOLLOW_13);
            rule__Bot__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__12"


    // $ANTLR start "rule__Bot__Group__12__Impl"
    // InternalBot.g:1866:1: rule__Bot__Group__12__Impl : ( ':' ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1870:1: ( ( ':' ) )
            // InternalBot.g:1871:1: ( ':' )
            {
            // InternalBot.g:1871:1: ( ':' )
            // InternalBot.g:1872:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_12()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__12__Impl"


    // $ANTLR start "rule__Bot__Group__13"
    // InternalBot.g:1881:1: rule__Bot__Group__13 : rule__Bot__Group__13__Impl ;
    public final void rule__Bot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1885:1: ( rule__Bot__Group__13__Impl )
            // InternalBot.g:1886:2: rule__Bot__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__13"


    // $ANTLR start "rule__Bot__Group__13__Impl"
    // InternalBot.g:1892:1: rule__Bot__Group__13__Impl : ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) ) ;
    public final void rule__Bot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1896:1: ( ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) ) )
            // InternalBot.g:1897:1: ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) )
            {
            // InternalBot.g:1897:1: ( ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* ) )
            // InternalBot.g:1898:2: ( ( rule__Bot__Group_13__0 ) ) ( ( rule__Bot__Group_13__0 )* )
            {
            // InternalBot.g:1898:2: ( ( rule__Bot__Group_13__0 ) )
            // InternalBot.g:1899:3: ( rule__Bot__Group_13__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_13()); 
            // InternalBot.g:1900:3: ( rule__Bot__Group_13__0 )
            // InternalBot.g:1900:4: rule__Bot__Group_13__0
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_13__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_13()); 

            }

            // InternalBot.g:1903:2: ( ( rule__Bot__Group_13__0 )* )
            // InternalBot.g:1904:3: ( rule__Bot__Group_13__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_13()); 
            // InternalBot.g:1905:3: ( rule__Bot__Group_13__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==57) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:1905:4: rule__Bot__Group_13__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Bot__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_13()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group__13__Impl"


    // $ANTLR start "rule__Bot__Group_4__0"
    // InternalBot.g:1915:1: rule__Bot__Group_4__0 : rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1 ;
    public final void rule__Bot__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1919:1: ( rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1 )
            // InternalBot.g:1920:2: rule__Bot__Group_4__0__Impl rule__Bot__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Bot__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_4__0"


    // $ANTLR start "rule__Bot__Group_4__0__Impl"
    // InternalBot.g:1927:1: rule__Bot__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Bot__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1931:1: ( ( ',' ) )
            // InternalBot.g:1932:1: ( ',' )
            {
            // InternalBot.g:1932:1: ( ',' )
            // InternalBot.g:1933:2: ','
            {
             before(grammarAccess.getBotAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_4__0__Impl"


    // $ANTLR start "rule__Bot__Group_4__1"
    // InternalBot.g:1942:1: rule__Bot__Group_4__1 : rule__Bot__Group_4__1__Impl ;
    public final void rule__Bot__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1946:1: ( rule__Bot__Group_4__1__Impl )
            // InternalBot.g:1947:2: rule__Bot__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_4__1"


    // $ANTLR start "rule__Bot__Group_4__1__Impl"
    // InternalBot.g:1953:1: rule__Bot__Group_4__1__Impl : ( ( rule__Bot__LanguagesAssignment_4_1 ) ) ;
    public final void rule__Bot__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1957:1: ( ( ( rule__Bot__LanguagesAssignment_4_1 ) ) )
            // InternalBot.g:1958:1: ( ( rule__Bot__LanguagesAssignment_4_1 ) )
            {
            // InternalBot.g:1958:1: ( ( rule__Bot__LanguagesAssignment_4_1 ) )
            // InternalBot.g:1959:2: ( rule__Bot__LanguagesAssignment_4_1 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_4_1()); 
            // InternalBot.g:1960:2: ( rule__Bot__LanguagesAssignment_4_1 )
            // InternalBot.g:1960:3: rule__Bot__LanguagesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguagesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguagesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_4__1__Impl"


    // $ANTLR start "rule__Bot__Group_9__0"
    // InternalBot.g:1969:1: rule__Bot__Group_9__0 : rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 ;
    public final void rule__Bot__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1973:1: ( rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1 )
            // InternalBot.g:1974:2: rule__Bot__Group_9__0__Impl rule__Bot__Group_9__1
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__0"


    // $ANTLR start "rule__Bot__Group_9__0__Impl"
    // InternalBot.g:1981:1: rule__Bot__Group_9__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1985:1: ( ( 'entities' ) )
            // InternalBot.g:1986:1: ( 'entities' )
            {
            // InternalBot.g:1986:1: ( 'entities' )
            // InternalBot.g:1987:2: 'entities'
            {
             before(grammarAccess.getBotAccess().getEntitiesKeyword_9_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getEntitiesKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__0__Impl"


    // $ANTLR start "rule__Bot__Group_9__1"
    // InternalBot.g:1996:1: rule__Bot__Group_9__1 : rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 ;
    public final void rule__Bot__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2000:1: ( rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2 )
            // InternalBot.g:2001:2: rule__Bot__Group_9__1__Impl rule__Bot__Group_9__2
            {
            pushFollow(FOLLOW_15);
            rule__Bot__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__1"


    // $ANTLR start "rule__Bot__Group_9__1__Impl"
    // InternalBot.g:2008:1: rule__Bot__Group_9__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2012:1: ( ( ':' ) )
            // InternalBot.g:2013:1: ( ':' )
            {
            // InternalBot.g:2013:1: ( ':' )
            // InternalBot.g:2014:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_9_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__1__Impl"


    // $ANTLR start "rule__Bot__Group_9__2"
    // InternalBot.g:2023:1: rule__Bot__Group_9__2 : rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 ;
    public final void rule__Bot__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2027:1: ( rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3 )
            // InternalBot.g:2028:2: rule__Bot__Group_9__2__Impl rule__Bot__Group_9__3
            {
            pushFollow(FOLLOW_15);
            rule__Bot__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__2"


    // $ANTLR start "rule__Bot__Group_9__2__Impl"
    // InternalBot.g:2035:1: rule__Bot__Group_9__2__Impl : ( ( rule__Bot__EntitiesAssignment_9_2 ) ) ;
    public final void rule__Bot__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2039:1: ( ( ( rule__Bot__EntitiesAssignment_9_2 ) ) )
            // InternalBot.g:2040:1: ( ( rule__Bot__EntitiesAssignment_9_2 ) )
            {
            // InternalBot.g:2040:1: ( ( rule__Bot__EntitiesAssignment_9_2 ) )
            // InternalBot.g:2041:2: ( rule__Bot__EntitiesAssignment_9_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_9_2()); 
            // InternalBot.g:2042:2: ( rule__Bot__EntitiesAssignment_9_2 )
            // InternalBot.g:2042:3: rule__Bot__EntitiesAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__EntitiesAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getEntitiesAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__2__Impl"


    // $ANTLR start "rule__Bot__Group_9__3"
    // InternalBot.g:2050:1: rule__Bot__Group_9__3 : rule__Bot__Group_9__3__Impl ;
    public final void rule__Bot__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2054:1: ( rule__Bot__Group_9__3__Impl )
            // InternalBot.g:2055:2: rule__Bot__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_9__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__3"


    // $ANTLR start "rule__Bot__Group_9__3__Impl"
    // InternalBot.g:2061:1: rule__Bot__Group_9__3__Impl : ( ( rule__Bot__EntitiesAssignment_9_3 )* ) ;
    public final void rule__Bot__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2065:1: ( ( ( rule__Bot__EntitiesAssignment_9_3 )* ) )
            // InternalBot.g:2066:1: ( ( rule__Bot__EntitiesAssignment_9_3 )* )
            {
            // InternalBot.g:2066:1: ( ( rule__Bot__EntitiesAssignment_9_3 )* )
            // InternalBot.g:2067:2: ( rule__Bot__EntitiesAssignment_9_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_9_3()); 
            // InternalBot.g:2068:2: ( rule__Bot__EntitiesAssignment_9_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==77) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:2068:3: rule__Bot__EntitiesAssignment_9_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Bot__EntitiesAssignment_9_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getEntitiesAssignment_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_9__3__Impl"


    // $ANTLR start "rule__Bot__Group_10__0"
    // InternalBot.g:2077:1: rule__Bot__Group_10__0 : rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 ;
    public final void rule__Bot__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2081:1: ( rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 )
            // InternalBot.g:2082:2: rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1
            {
            pushFollow(FOLLOW_10);
            rule__Bot__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__0"


    // $ANTLR start "rule__Bot__Group_10__0__Impl"
    // InternalBot.g:2089:1: rule__Bot__Group_10__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2093:1: ( ( 'actions' ) )
            // InternalBot.g:2094:1: ( 'actions' )
            {
            // InternalBot.g:2094:1: ( 'actions' )
            // InternalBot.g:2095:2: 'actions'
            {
             before(grammarAccess.getBotAccess().getActionsKeyword_10_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getActionsKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__0__Impl"


    // $ANTLR start "rule__Bot__Group_10__1"
    // InternalBot.g:2104:1: rule__Bot__Group_10__1 : rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 ;
    public final void rule__Bot__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2108:1: ( rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 )
            // InternalBot.g:2109:2: rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2
            {
            pushFollow(FOLLOW_17);
            rule__Bot__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__1"


    // $ANTLR start "rule__Bot__Group_10__1__Impl"
    // InternalBot.g:2116:1: rule__Bot__Group_10__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2120:1: ( ( ':' ) )
            // InternalBot.g:2121:1: ( ':' )
            {
            // InternalBot.g:2121:1: ( ':' )
            // InternalBot.g:2122:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_10_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__1__Impl"


    // $ANTLR start "rule__Bot__Group_10__2"
    // InternalBot.g:2131:1: rule__Bot__Group_10__2 : rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 ;
    public final void rule__Bot__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2135:1: ( rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 )
            // InternalBot.g:2136:2: rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3
            {
            pushFollow(FOLLOW_17);
            rule__Bot__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__2"


    // $ANTLR start "rule__Bot__Group_10__2__Impl"
    // InternalBot.g:2143:1: rule__Bot__Group_10__2__Impl : ( ( rule__Bot__ActionsAssignment_10_2 ) ) ;
    public final void rule__Bot__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2147:1: ( ( ( rule__Bot__ActionsAssignment_10_2 ) ) )
            // InternalBot.g:2148:1: ( ( rule__Bot__ActionsAssignment_10_2 ) )
            {
            // InternalBot.g:2148:1: ( ( rule__Bot__ActionsAssignment_10_2 ) )
            // InternalBot.g:2149:2: ( rule__Bot__ActionsAssignment_10_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_10_2()); 
            // InternalBot.g:2150:2: ( rule__Bot__ActionsAssignment_10_2 )
            // InternalBot.g:2150:3: rule__Bot__ActionsAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__ActionsAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getActionsAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__2__Impl"


    // $ANTLR start "rule__Bot__Group_10__3"
    // InternalBot.g:2158:1: rule__Bot__Group_10__3 : rule__Bot__Group_10__3__Impl ;
    public final void rule__Bot__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2162:1: ( rule__Bot__Group_10__3__Impl )
            // InternalBot.g:2163:2: rule__Bot__Group_10__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_10__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__3"


    // $ANTLR start "rule__Bot__Group_10__3__Impl"
    // InternalBot.g:2169:1: rule__Bot__Group_10__3__Impl : ( ( rule__Bot__ActionsAssignment_10_3 )* ) ;
    public final void rule__Bot__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2173:1: ( ( ( rule__Bot__ActionsAssignment_10_3 )* ) )
            // InternalBot.g:2174:1: ( ( rule__Bot__ActionsAssignment_10_3 )* )
            {
            // InternalBot.g:2174:1: ( ( rule__Bot__ActionsAssignment_10_3 )* )
            // InternalBot.g:2175:2: ( rule__Bot__ActionsAssignment_10_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_10_3()); 
            // InternalBot.g:2176:2: ( rule__Bot__ActionsAssignment_10_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==11||LA25_0==17||LA25_0==83||LA25_0==85) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBot.g:2176:3: rule__Bot__ActionsAssignment_10_3
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Bot__ActionsAssignment_10_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getActionsAssignment_10_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_10__3__Impl"


    // $ANTLR start "rule__Bot__Group_13__0"
    // InternalBot.g:2185:1: rule__Bot__Group_13__0 : rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1 ;
    public final void rule__Bot__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2189:1: ( rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1 )
            // InternalBot.g:2190:2: rule__Bot__Group_13__0__Impl rule__Bot__Group_13__1
            {
            pushFollow(FOLLOW_19);
            rule__Bot__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__0"


    // $ANTLR start "rule__Bot__Group_13__0__Impl"
    // InternalBot.g:2197:1: rule__Bot__Group_13__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2201:1: ( ( '-' ) )
            // InternalBot.g:2202:1: ( '-' )
            {
            // InternalBot.g:2202:1: ( '-' )
            // InternalBot.g:2203:2: '-'
            {
             before(grammarAccess.getBotAccess().getHyphenMinusKeyword_13_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getHyphenMinusKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__0__Impl"


    // $ANTLR start "rule__Bot__Group_13__1"
    // InternalBot.g:2212:1: rule__Bot__Group_13__1 : rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2 ;
    public final void rule__Bot__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2216:1: ( rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2 )
            // InternalBot.g:2217:2: rule__Bot__Group_13__1__Impl rule__Bot__Group_13__2
            {
            pushFollow(FOLLOW_20);
            rule__Bot__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_13__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__1"


    // $ANTLR start "rule__Bot__Group_13__1__Impl"
    // InternalBot.g:2224:1: rule__Bot__Group_13__1__Impl : ( ( rule__Bot__FlowsAssignment_13_1 ) ) ;
    public final void rule__Bot__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2228:1: ( ( ( rule__Bot__FlowsAssignment_13_1 ) ) )
            // InternalBot.g:2229:1: ( ( rule__Bot__FlowsAssignment_13_1 ) )
            {
            // InternalBot.g:2229:1: ( ( rule__Bot__FlowsAssignment_13_1 ) )
            // InternalBot.g:2230:2: ( rule__Bot__FlowsAssignment_13_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_13_1()); 
            // InternalBot.g:2231:2: ( rule__Bot__FlowsAssignment_13_1 )
            // InternalBot.g:2231:3: rule__Bot__FlowsAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__FlowsAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getFlowsAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__1__Impl"


    // $ANTLR start "rule__Bot__Group_13__2"
    // InternalBot.g:2239:1: rule__Bot__Group_13__2 : rule__Bot__Group_13__2__Impl ;
    public final void rule__Bot__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2243:1: ( rule__Bot__Group_13__2__Impl )
            // InternalBot.g:2244:2: rule__Bot__Group_13__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_13__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__2"


    // $ANTLR start "rule__Bot__Group_13__2__Impl"
    // InternalBot.g:2250:1: rule__Bot__Group_13__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2254:1: ( ( ';' ) )
            // InternalBot.g:2255:1: ( ';' )
            {
            // InternalBot.g:2255:1: ( ';' )
            // InternalBot.g:2256:2: ';'
            {
             before(grammarAccess.getBotAccess().getSemicolonKeyword_13_2()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getSemicolonKeyword_13_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_13__2__Impl"


    // $ANTLR start "rule__Intent__Group__0"
    // InternalBot.g:2266:1: rule__Intent__Group__0 : rule__Intent__Group__0__Impl rule__Intent__Group__1 ;
    public final void rule__Intent__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2270:1: ( rule__Intent__Group__0__Impl rule__Intent__Group__1 )
            // InternalBot.g:2271:2: rule__Intent__Group__0__Impl rule__Intent__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__Intent__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__0"


    // $ANTLR start "rule__Intent__Group__0__Impl"
    // InternalBot.g:2278:1: rule__Intent__Group__0__Impl : ( ( rule__Intent__NameAssignment_0 ) ) ;
    public final void rule__Intent__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2282:1: ( ( ( rule__Intent__NameAssignment_0 ) ) )
            // InternalBot.g:2283:1: ( ( rule__Intent__NameAssignment_0 ) )
            {
            // InternalBot.g:2283:1: ( ( rule__Intent__NameAssignment_0 ) )
            // InternalBot.g:2284:2: ( rule__Intent__NameAssignment_0 )
            {
             before(grammarAccess.getIntentAccess().getNameAssignment_0()); 
            // InternalBot.g:2285:2: ( rule__Intent__NameAssignment_0 )
            // InternalBot.g:2285:3: rule__Intent__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Intent__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__0__Impl"


    // $ANTLR start "rule__Intent__Group__1"
    // InternalBot.g:2293:1: rule__Intent__Group__1 : rule__Intent__Group__1__Impl rule__Intent__Group__2 ;
    public final void rule__Intent__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2297:1: ( rule__Intent__Group__1__Impl rule__Intent__Group__2 )
            // InternalBot.g:2298:2: rule__Intent__Group__1__Impl rule__Intent__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__Intent__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__1"


    // $ANTLR start "rule__Intent__Group__1__Impl"
    // InternalBot.g:2305:1: rule__Intent__Group__1__Impl : ( ( rule__Intent__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2309:1: ( ( ( rule__Intent__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2310:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2310:1: ( ( rule__Intent__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2311:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2312:2: ( rule__Intent__FallbackIntentAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==91) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBot.g:2312:3: rule__Intent__FallbackIntentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__FallbackIntentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getFallbackIntentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__1__Impl"


    // $ANTLR start "rule__Intent__Group__2"
    // InternalBot.g:2320:1: rule__Intent__Group__2 : rule__Intent__Group__2__Impl rule__Intent__Group__3 ;
    public final void rule__Intent__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2324:1: ( rule__Intent__Group__2__Impl rule__Intent__Group__3 )
            // InternalBot.g:2325:2: rule__Intent__Group__2__Impl rule__Intent__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__Intent__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__2"


    // $ANTLR start "rule__Intent__Group__2__Impl"
    // InternalBot.g:2332:1: rule__Intent__Group__2__Impl : ( ':' ) ;
    public final void rule__Intent__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2336:1: ( ( ':' ) )
            // InternalBot.g:2337:1: ( ':' )
            {
            // InternalBot.g:2337:1: ( ':' )
            // InternalBot.g:2338:2: ':'
            {
             before(grammarAccess.getIntentAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__2__Impl"


    // $ANTLR start "rule__Intent__Group__3"
    // InternalBot.g:2347:1: rule__Intent__Group__3 : rule__Intent__Group__3__Impl rule__Intent__Group__4 ;
    public final void rule__Intent__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2351:1: ( rule__Intent__Group__3__Impl rule__Intent__Group__4 )
            // InternalBot.g:2352:2: rule__Intent__Group__3__Impl rule__Intent__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Intent__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__3"


    // $ANTLR start "rule__Intent__Group__3__Impl"
    // InternalBot.g:2359:1: rule__Intent__Group__3__Impl : ( ( rule__Intent__InputsAssignment_3 )* ) ;
    public final void rule__Intent__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2363:1: ( ( ( rule__Intent__InputsAssignment_3 )* ) )
            // InternalBot.g:2364:1: ( ( rule__Intent__InputsAssignment_3 )* )
            {
            // InternalBot.g:2364:1: ( ( rule__Intent__InputsAssignment_3 )* )
            // InternalBot.g:2365:2: ( rule__Intent__InputsAssignment_3 )*
            {
             before(grammarAccess.getIntentAccess().getInputsAssignment_3()); 
            // InternalBot.g:2366:2: ( rule__Intent__InputsAssignment_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==60) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBot.g:2366:3: rule__Intent__InputsAssignment_3
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__Intent__InputsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getInputsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__3__Impl"


    // $ANTLR start "rule__Intent__Group__4"
    // InternalBot.g:2374:1: rule__Intent__Group__4 : rule__Intent__Group__4__Impl ;
    public final void rule__Intent__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2378:1: ( rule__Intent__Group__4__Impl )
            // InternalBot.g:2379:2: rule__Intent__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__4"


    // $ANTLR start "rule__Intent__Group__4__Impl"
    // InternalBot.g:2385:1: rule__Intent__Group__4__Impl : ( ( rule__Intent__Group_4__0 )? ) ;
    public final void rule__Intent__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2389:1: ( ( ( rule__Intent__Group_4__0 )? ) )
            // InternalBot.g:2390:1: ( ( rule__Intent__Group_4__0 )? )
            {
            // InternalBot.g:2390:1: ( ( rule__Intent__Group_4__0 )? )
            // InternalBot.g:2391:2: ( rule__Intent__Group_4__0 )?
            {
             before(grammarAccess.getIntentAccess().getGroup_4()); 
            // InternalBot.g:2392:2: ( rule__Intent__Group_4__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==59) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalBot.g:2392:3: rule__Intent__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group__4__Impl"


    // $ANTLR start "rule__Intent__Group_4__0"
    // InternalBot.g:2401:1: rule__Intent__Group_4__0 : rule__Intent__Group_4__0__Impl rule__Intent__Group_4__1 ;
    public final void rule__Intent__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2405:1: ( rule__Intent__Group_4__0__Impl rule__Intent__Group_4__1 )
            // InternalBot.g:2406:2: rule__Intent__Group_4__0__Impl rule__Intent__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__0"


    // $ANTLR start "rule__Intent__Group_4__0__Impl"
    // InternalBot.g:2413:1: rule__Intent__Group_4__0__Impl : ( 'parameters:' ) ;
    public final void rule__Intent__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2417:1: ( ( 'parameters:' ) )
            // InternalBot.g:2418:1: ( 'parameters:' )
            {
            // InternalBot.g:2418:1: ( 'parameters:' )
            // InternalBot.g:2419:2: 'parameters:'
            {
             before(grammarAccess.getIntentAccess().getParametersKeyword_4_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getParametersKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__0__Impl"


    // $ANTLR start "rule__Intent__Group_4__1"
    // InternalBot.g:2428:1: rule__Intent__Group_4__1 : rule__Intent__Group_4__1__Impl ;
    public final void rule__Intent__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2432:1: ( rule__Intent__Group_4__1__Impl )
            // InternalBot.g:2433:2: rule__Intent__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__1"


    // $ANTLR start "rule__Intent__Group_4__1__Impl"
    // InternalBot.g:2439:1: rule__Intent__Group_4__1__Impl : ( ( ( rule__Intent__Group_4_1__0 ) ) ( ( rule__Intent__Group_4_1__0 )* ) ) ;
    public final void rule__Intent__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2443:1: ( ( ( ( rule__Intent__Group_4_1__0 ) ) ( ( rule__Intent__Group_4_1__0 )* ) ) )
            // InternalBot.g:2444:1: ( ( ( rule__Intent__Group_4_1__0 ) ) ( ( rule__Intent__Group_4_1__0 )* ) )
            {
            // InternalBot.g:2444:1: ( ( ( rule__Intent__Group_4_1__0 ) ) ( ( rule__Intent__Group_4_1__0 )* ) )
            // InternalBot.g:2445:2: ( ( rule__Intent__Group_4_1__0 ) ) ( ( rule__Intent__Group_4_1__0 )* )
            {
            // InternalBot.g:2445:2: ( ( rule__Intent__Group_4_1__0 ) )
            // InternalBot.g:2446:3: ( rule__Intent__Group_4_1__0 )
            {
             before(grammarAccess.getIntentAccess().getGroup_4_1()); 
            // InternalBot.g:2447:3: ( rule__Intent__Group_4_1__0 )
            // InternalBot.g:2447:4: rule__Intent__Group_4_1__0
            {
            pushFollow(FOLLOW_12);
            rule__Intent__Group_4_1__0();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getGroup_4_1()); 

            }

            // InternalBot.g:2450:2: ( ( rule__Intent__Group_4_1__0 )* )
            // InternalBot.g:2451:3: ( rule__Intent__Group_4_1__0 )*
            {
             before(grammarAccess.getIntentAccess().getGroup_4_1()); 
            // InternalBot.g:2452:3: ( rule__Intent__Group_4_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_STRING) ) {
                    int LA29_2 = input.LA(2);

                    if ( (LA29_2==54) ) {
                        alt29=1;
                    }
                    else if ( (LA29_2==52) ) {
                        int LA29_5 = input.LA(3);

                        if ( (LA29_5==67) ) {
                            alt29=1;
                        }


                    }


                }
                else if ( (LA29_0==RULE_ID) ) {
                    int LA29_3 = input.LA(2);

                    if ( (LA29_3==54) ) {
                        alt29=1;
                    }
                    else if ( (LA29_3==52) ) {
                        int LA29_5 = input.LA(3);

                        if ( (LA29_5==67) ) {
                            alt29=1;
                        }


                    }


                }


                switch (alt29) {
            	case 1 :
            	    // InternalBot.g:2452:4: rule__Intent__Group_4_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent__Group_4_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getGroup_4_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4__1__Impl"


    // $ANTLR start "rule__Intent__Group_4_1__0"
    // InternalBot.g:2462:1: rule__Intent__Group_4_1__0 : rule__Intent__Group_4_1__0__Impl rule__Intent__Group_4_1__1 ;
    public final void rule__Intent__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2466:1: ( rule__Intent__Group_4_1__0__Impl rule__Intent__Group_4_1__1 )
            // InternalBot.g:2467:2: rule__Intent__Group_4_1__0__Impl rule__Intent__Group_4_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Intent__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4_1__0"


    // $ANTLR start "rule__Intent__Group_4_1__0__Impl"
    // InternalBot.g:2474:1: rule__Intent__Group_4_1__0__Impl : ( ( rule__Intent__ParametersAssignment_4_1_0 )* ) ;
    public final void rule__Intent__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2478:1: ( ( ( rule__Intent__ParametersAssignment_4_1_0 )* ) )
            // InternalBot.g:2479:1: ( ( rule__Intent__ParametersAssignment_4_1_0 )* )
            {
            // InternalBot.g:2479:1: ( ( rule__Intent__ParametersAssignment_4_1_0 )* )
            // InternalBot.g:2480:2: ( rule__Intent__ParametersAssignment_4_1_0 )*
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_4_1_0()); 
            // InternalBot.g:2481:2: ( rule__Intent__ParametersAssignment_4_1_0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_STRING) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==54) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==RULE_ID) ) {
                    int LA30_2 = input.LA(2);

                    if ( (LA30_2==54) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // InternalBot.g:2481:3: rule__Intent__ParametersAssignment_4_1_0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent__ParametersAssignment_4_1_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getIntentAccess().getParametersAssignment_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4_1__0__Impl"


    // $ANTLR start "rule__Intent__Group_4_1__1"
    // InternalBot.g:2489:1: rule__Intent__Group_4_1__1 : rule__Intent__Group_4_1__1__Impl ;
    public final void rule__Intent__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2493:1: ( rule__Intent__Group_4_1__1__Impl )
            // InternalBot.g:2494:2: rule__Intent__Group_4_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Group_4_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4_1__1"


    // $ANTLR start "rule__Intent__Group_4_1__1__Impl"
    // InternalBot.g:2500:1: rule__Intent__Group_4_1__1__Impl : ( ( rule__Intent__ParametersAssignment_4_1_1 ) ) ;
    public final void rule__Intent__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2504:1: ( ( ( rule__Intent__ParametersAssignment_4_1_1 ) ) )
            // InternalBot.g:2505:1: ( ( rule__Intent__ParametersAssignment_4_1_1 ) )
            {
            // InternalBot.g:2505:1: ( ( rule__Intent__ParametersAssignment_4_1_1 ) )
            // InternalBot.g:2506:2: ( rule__Intent__ParametersAssignment_4_1_1 )
            {
             before(grammarAccess.getIntentAccess().getParametersAssignment_4_1_1()); 
            // InternalBot.g:2507:2: ( rule__Intent__ParametersAssignment_4_1_1 )
            // InternalBot.g:2507:3: rule__Intent__ParametersAssignment_4_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent__ParametersAssignment_4_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getParametersAssignment_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__Group_4_1__1__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__0"
    // InternalBot.g:2516:1: rule__IntentLanguageInputs__Group__0 : rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 ;
    public final void rule__IntentLanguageInputs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2520:1: ( rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 )
            // InternalBot.g:2521:2: rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__IntentLanguageInputs__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__0"


    // $ANTLR start "rule__IntentLanguageInputs__Group__0__Impl"
    // InternalBot.g:2528:1: rule__IntentLanguageInputs__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__IntentLanguageInputs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2532:1: ( ( 'inputs' ) )
            // InternalBot.g:2533:1: ( 'inputs' )
            {
            // InternalBot.g:2533:1: ( 'inputs' )
            // InternalBot.g:2534:2: 'inputs'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__0__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__1"
    // InternalBot.g:2543:1: rule__IntentLanguageInputs__Group__1 : rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 ;
    public final void rule__IntentLanguageInputs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2547:1: ( rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 )
            // InternalBot.g:2548:2: rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__IntentLanguageInputs__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__1"


    // $ANTLR start "rule__IntentLanguageInputs__Group__1__Impl"
    // InternalBot.g:2555:1: rule__IntentLanguageInputs__Group__1__Impl : ( ( rule__IntentLanguageInputs__Group_1__0 )? ) ;
    public final void rule__IntentLanguageInputs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2559:1: ( ( ( rule__IntentLanguageInputs__Group_1__0 )? ) )
            // InternalBot.g:2560:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            {
            // InternalBot.g:2560:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            // InternalBot.g:2561:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 
            // InternalBot.g:2562:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==63) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:2562:3: rule__IntentLanguageInputs__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IntentLanguageInputs__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__1__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__2"
    // InternalBot.g:2570:1: rule__IntentLanguageInputs__Group__2 : rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 ;
    public final void rule__IntentLanguageInputs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2574:1: ( rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 )
            // InternalBot.g:2575:2: rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__IntentLanguageInputs__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__2"


    // $ANTLR start "rule__IntentLanguageInputs__Group__2__Impl"
    // InternalBot.g:2582:1: rule__IntentLanguageInputs__Group__2__Impl : ( '{' ) ;
    public final void rule__IntentLanguageInputs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2586:1: ( ( '{' ) )
            // InternalBot.g:2587:1: ( '{' )
            {
            // InternalBot.g:2587:1: ( '{' )
            // InternalBot.g:2588:2: '{'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__2__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__3"
    // InternalBot.g:2597:1: rule__IntentLanguageInputs__Group__3 : rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 ;
    public final void rule__IntentLanguageInputs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2601:1: ( rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 )
            // InternalBot.g:2602:2: rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__IntentLanguageInputs__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__3"


    // $ANTLR start "rule__IntentLanguageInputs__Group__3__Impl"
    // InternalBot.g:2609:1: rule__IntentLanguageInputs__Group__3__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) ;
    public final void rule__IntentLanguageInputs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2613:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) )
            // InternalBot.g:2614:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            {
            // InternalBot.g:2614:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            // InternalBot.g:2615:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 
            // InternalBot.g:2616:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            // InternalBot.g:2616:3: rule__IntentLanguageInputs__InputsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__InputsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__3__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__4"
    // InternalBot.g:2624:1: rule__IntentLanguageInputs__Group__4 : rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 ;
    public final void rule__IntentLanguageInputs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2628:1: ( rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 )
            // InternalBot.g:2629:2: rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__IntentLanguageInputs__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__4"


    // $ANTLR start "rule__IntentLanguageInputs__Group__4__Impl"
    // InternalBot.g:2636:1: rule__IntentLanguageInputs__Group__4__Impl : ( ( rule__IntentLanguageInputs__Group_4__0 )* ) ;
    public final void rule__IntentLanguageInputs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2640:1: ( ( ( rule__IntentLanguageInputs__Group_4__0 )* ) )
            // InternalBot.g:2641:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            {
            // InternalBot.g:2641:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            // InternalBot.g:2642:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 
            // InternalBot.g:2643:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==54) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBot.g:2643:3: rule__IntentLanguageInputs__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__IntentLanguageInputs__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__4__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__5"
    // InternalBot.g:2651:1: rule__IntentLanguageInputs__Group__5 : rule__IntentLanguageInputs__Group__5__Impl ;
    public final void rule__IntentLanguageInputs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2655:1: ( rule__IntentLanguageInputs__Group__5__Impl )
            // InternalBot.g:2656:2: rule__IntentLanguageInputs__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__5"


    // $ANTLR start "rule__IntentLanguageInputs__Group__5__Impl"
    // InternalBot.g:2662:1: rule__IntentLanguageInputs__Group__5__Impl : ( '}' ) ;
    public final void rule__IntentLanguageInputs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2666:1: ( ( '}' ) )
            // InternalBot.g:2667:1: ( '}' )
            {
            // InternalBot.g:2667:1: ( '}' )
            // InternalBot.g:2668:2: '}'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group__5__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__0"
    // InternalBot.g:2678:1: rule__IntentLanguageInputs__Group_1__0 : rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 ;
    public final void rule__IntentLanguageInputs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2682:1: ( rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 )
            // InternalBot.g:2683:2: rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__IntentLanguageInputs__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__0"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__0__Impl"
    // InternalBot.g:2690:1: rule__IntentLanguageInputs__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__IntentLanguageInputs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2694:1: ( ( 'in' ) )
            // InternalBot.g:2695:1: ( 'in' )
            {
            // InternalBot.g:2695:1: ( 'in' )
            // InternalBot.g:2696:2: 'in'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__0__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__1"
    // InternalBot.g:2705:1: rule__IntentLanguageInputs__Group_1__1 : rule__IntentLanguageInputs__Group_1__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2709:1: ( rule__IntentLanguageInputs__Group_1__1__Impl )
            // InternalBot.g:2710:2: rule__IntentLanguageInputs__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__1"


    // $ANTLR start "rule__IntentLanguageInputs__Group_1__1__Impl"
    // InternalBot.g:2716:1: rule__IntentLanguageInputs__Group_1__1__Impl : ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2720:1: ( ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:2721:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:2721:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            // InternalBot.g:2722:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:2723:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            // InternalBot.g:2723:3: rule__IntentLanguageInputs__LanguageAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__LanguageAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_1__1__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__0"
    // InternalBot.g:2732:1: rule__IntentLanguageInputs__Group_4__0 : rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 ;
    public final void rule__IntentLanguageInputs__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2736:1: ( rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 )
            // InternalBot.g:2737:2: rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1
            {
            pushFollow(FOLLOW_25);
            rule__IntentLanguageInputs__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__0"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__0__Impl"
    // InternalBot.g:2744:1: rule__IntentLanguageInputs__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IntentLanguageInputs__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2748:1: ( ( ',' ) )
            // InternalBot.g:2749:1: ( ',' )
            {
            // InternalBot.g:2749:1: ( ',' )
            // InternalBot.g:2750:2: ','
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__0__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__1"
    // InternalBot.g:2759:1: rule__IntentLanguageInputs__Group_4__1 : rule__IntentLanguageInputs__Group_4__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2763:1: ( rule__IntentLanguageInputs__Group_4__1__Impl )
            // InternalBot.g:2764:2: rule__IntentLanguageInputs__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__1"


    // $ANTLR start "rule__IntentLanguageInputs__Group_4__1__Impl"
    // InternalBot.g:2770:1: rule__IntentLanguageInputs__Group_4__1__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2774:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) )
            // InternalBot.g:2775:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:2775:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            // InternalBot.g:2776:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:2777:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            // InternalBot.g:2777:3: rule__IntentLanguageInputs__InputsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__IntentLanguageInputs__InputsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__Group_4__1__Impl"


    // $ANTLR start "rule__Transition__Group__0"
    // InternalBot.g:2786:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2790:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:2791:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Transition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0"


    // $ANTLR start "rule__Transition__Group__0__Impl"
    // InternalBot.g:2798:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2802:1: ( ( 'user' ) )
            // InternalBot.g:2803:1: ( 'user' )
            {
            // InternalBot.g:2803:1: ( 'user' )
            // InternalBot.g:2804:2: 'user'
            {
             before(grammarAccess.getTransitionAccess().getUserKeyword_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getUserKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__0__Impl"


    // $ANTLR start "rule__Transition__Group__1"
    // InternalBot.g:2813:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2817:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:2818:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__Transition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1"


    // $ANTLR start "rule__Transition__Group__1__Impl"
    // InternalBot.g:2825:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2829:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:2830:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:2830:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:2831:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:2832:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:2832:3: rule__Transition__IntentAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__IntentAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__1__Impl"


    // $ANTLR start "rule__Transition__Group__2"
    // InternalBot.g:2840:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2844:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:2845:2: rule__Transition__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2"


    // $ANTLR start "rule__Transition__Group__2__Impl"
    // InternalBot.g:2851:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2855:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:2856:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:2856:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:2857:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:2858:2: ( rule__Transition__Group_2__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==65) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:2858:3: rule__Transition__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Transition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group__2__Impl"


    // $ANTLR start "rule__Transition__Group_2__0"
    // InternalBot.g:2867:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2871:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:2872:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
            {
            pushFollow(FOLLOW_28);
            rule__Transition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0"


    // $ANTLR start "rule__Transition__Group_2__0__Impl"
    // InternalBot.g:2879:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2883:1: ( ( '=>' ) )
            // InternalBot.g:2884:1: ( '=>' )
            {
            // InternalBot.g:2884:1: ( '=>' )
            // InternalBot.g:2885:2: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__0__Impl"


    // $ANTLR start "rule__Transition__Group_2__1"
    // InternalBot.g:2894:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2898:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:2899:2: rule__Transition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transition__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1"


    // $ANTLR start "rule__Transition__Group_2__1__Impl"
    // InternalBot.g:2905:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2909:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:2910:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:2910:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:2911:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:2912:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:2912:3: rule__Transition__TargetAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Transition__TargetAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__Group_2__1__Impl"


    // $ANTLR start "rule__State__Group__0"
    // InternalBot.g:2921:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2925:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:2926:2: rule__State__Group__0__Impl rule__State__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__State__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0"


    // $ANTLR start "rule__State__Group__0__Impl"
    // InternalBot.g:2933:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2937:1: ( ( 'chatbot' ) )
            // InternalBot.g:2938:1: ( 'chatbot' )
            {
            // InternalBot.g:2938:1: ( 'chatbot' )
            // InternalBot.g:2939:2: 'chatbot'
            {
             before(grammarAccess.getStateAccess().getChatbotKeyword_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getChatbotKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__0__Impl"


    // $ANTLR start "rule__State__Group__1"
    // InternalBot.g:2948:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2952:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:2953:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_29);
            rule__State__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1"


    // $ANTLR start "rule__State__Group__1__Impl"
    // InternalBot.g:2960:1: rule__State__Group__1__Impl : ( ( rule__State__ActionsAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2964:1: ( ( ( rule__State__ActionsAssignment_1 ) ) )
            // InternalBot.g:2965:1: ( ( rule__State__ActionsAssignment_1 ) )
            {
            // InternalBot.g:2965:1: ( ( rule__State__ActionsAssignment_1 ) )
            // InternalBot.g:2966:2: ( rule__State__ActionsAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_1()); 
            // InternalBot.g:2967:2: ( rule__State__ActionsAssignment_1 )
            // InternalBot.g:2967:3: rule__State__ActionsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__State__ActionsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__1__Impl"


    // $ANTLR start "rule__State__Group__2"
    // InternalBot.g:2975:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2979:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:2980:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_29);
            rule__State__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2"


    // $ANTLR start "rule__State__Group__2__Impl"
    // InternalBot.g:2987:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )* ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2991:1: ( ( ( rule__State__Group_2__0 )* ) )
            // InternalBot.g:2992:1: ( ( rule__State__Group_2__0 )* )
            {
            // InternalBot.g:2992:1: ( ( rule__State__Group_2__0 )* )
            // InternalBot.g:2993:2: ( rule__State__Group_2__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // InternalBot.g:2994:2: ( rule__State__Group_2__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==54) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:2994:3: rule__State__Group_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__State__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getStateAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__2__Impl"


    // $ANTLR start "rule__State__Group__3"
    // InternalBot.g:3002:1: rule__State__Group__3 : rule__State__Group__3__Impl ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3006:1: ( rule__State__Group__3__Impl )
            // InternalBot.g:3007:2: rule__State__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3"


    // $ANTLR start "rule__State__Group__3__Impl"
    // InternalBot.g:3013:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3017:1: ( ( ( rule__State__Group_3__0 )? ) )
            // InternalBot.g:3018:1: ( ( rule__State__Group_3__0 )? )
            {
            // InternalBot.g:3018:1: ( ( rule__State__Group_3__0 )? )
            // InternalBot.g:3019:2: ( rule__State__Group_3__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:3020:2: ( rule__State__Group_3__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==65) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:3020:3: rule__State__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__State__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStateAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group__3__Impl"


    // $ANTLR start "rule__State__Group_2__0"
    // InternalBot.g:3029:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3033:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // InternalBot.g:3034:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__State__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__0"


    // $ANTLR start "rule__State__Group_2__0__Impl"
    // InternalBot.g:3041:1: rule__State__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3045:1: ( ( ',' ) )
            // InternalBot.g:3046:1: ( ',' )
            {
            // InternalBot.g:3046:1: ( ',' )
            // InternalBot.g:3047:2: ','
            {
             before(grammarAccess.getStateAccess().getCommaKeyword_2_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__0__Impl"


    // $ANTLR start "rule__State__Group_2__1"
    // InternalBot.g:3056:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3060:1: ( rule__State__Group_2__1__Impl )
            // InternalBot.g:3061:2: rule__State__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__1"


    // $ANTLR start "rule__State__Group_2__1__Impl"
    // InternalBot.g:3067:1: rule__State__Group_2__1__Impl : ( ( rule__State__ActionsAssignment_2_1 ) ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3071:1: ( ( ( rule__State__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3072:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3072:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            // InternalBot.g:3073:2: ( rule__State__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_1()); 
            // InternalBot.g:3074:2: ( rule__State__ActionsAssignment_2_1 )
            // InternalBot.g:3074:3: rule__State__ActionsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__State__ActionsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getActionsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_2__1__Impl"


    // $ANTLR start "rule__State__Group_3__0"
    // InternalBot.g:3083:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3087:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:3088:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
            {
            pushFollow(FOLLOW_19);
            rule__State__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__0"


    // $ANTLR start "rule__State__Group_3__0__Impl"
    // InternalBot.g:3095:1: rule__State__Group_3__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3099:1: ( ( '=>' ) )
            // InternalBot.g:3100:1: ( '=>' )
            {
            // InternalBot.g:3100:1: ( '=>' )
            // InternalBot.g:3101:2: '=>'
            {
             before(grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__0__Impl"


    // $ANTLR start "rule__State__Group_3__1"
    // InternalBot.g:3110:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3114:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:3115:2: rule__State__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__1"


    // $ANTLR start "rule__State__Group_3__1__Impl"
    // InternalBot.g:3121:1: rule__State__Group_3__1__Impl : ( ( rule__State__OutcomingAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3125:1: ( ( ( rule__State__OutcomingAssignment_3_1 ) ) )
            // InternalBot.g:3126:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            {
            // InternalBot.g:3126:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            // InternalBot.g:3127:2: ( rule__State__OutcomingAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_3_1()); 
            // InternalBot.g:3128:2: ( rule__State__OutcomingAssignment_3_1 )
            // InternalBot.g:3128:3: rule__State__OutcomingAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__State__OutcomingAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getOutcomingAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__Group_3__1__Impl"


    // $ANTLR start "rule__State2__Group__0"
    // InternalBot.g:3137:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3141:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:3142:2: rule__State2__Group__0__Impl rule__State2__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__State2__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__0"


    // $ANTLR start "rule__State2__Group__0__Impl"
    // InternalBot.g:3149:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3153:1: ( ( 'chatbot' ) )
            // InternalBot.g:3154:1: ( 'chatbot' )
            {
            // InternalBot.g:3154:1: ( 'chatbot' )
            // InternalBot.g:3155:2: 'chatbot'
            {
             before(grammarAccess.getState2Access().getChatbotKeyword_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getState2Access().getChatbotKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__0__Impl"


    // $ANTLR start "rule__State2__Group__1"
    // InternalBot.g:3164:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3168:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:3169:2: rule__State2__Group__1__Impl rule__State2__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__State2__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__1"


    // $ANTLR start "rule__State2__Group__1__Impl"
    // InternalBot.g:3176:1: rule__State2__Group__1__Impl : ( ( rule__State2__ActionsAssignment_1 ) ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3180:1: ( ( ( rule__State2__ActionsAssignment_1 ) ) )
            // InternalBot.g:3181:1: ( ( rule__State2__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3181:1: ( ( rule__State2__ActionsAssignment_1 ) )
            // InternalBot.g:3182:2: ( rule__State2__ActionsAssignment_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_1()); 
            // InternalBot.g:3183:2: ( rule__State2__ActionsAssignment_1 )
            // InternalBot.g:3183:3: rule__State2__ActionsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__State2__ActionsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getActionsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__1__Impl"


    // $ANTLR start "rule__State2__Group__2"
    // InternalBot.g:3191:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3195:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:3196:2: rule__State2__Group__2__Impl rule__State2__Group__3
            {
            pushFollow(FOLLOW_30);
            rule__State2__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__2"


    // $ANTLR start "rule__State2__Group__2__Impl"
    // InternalBot.g:3203:1: rule__State2__Group__2__Impl : ( ( rule__State2__Group_2__0 )* ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3207:1: ( ( ( rule__State2__Group_2__0 )* ) )
            // InternalBot.g:3208:1: ( ( rule__State2__Group_2__0 )* )
            {
            // InternalBot.g:3208:1: ( ( rule__State2__Group_2__0 )* )
            // InternalBot.g:3209:2: ( rule__State2__Group_2__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_2()); 
            // InternalBot.g:3210:2: ( rule__State2__Group_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==54) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:3210:3: rule__State2__Group_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__State2__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getState2Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__2__Impl"


    // $ANTLR start "rule__State2__Group__3"
    // InternalBot.g:3218:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3222:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:3223:2: rule__State2__Group__3__Impl rule__State2__Group__4
            {
            pushFollow(FOLLOW_27);
            rule__State2__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__3"


    // $ANTLR start "rule__State2__Group__3__Impl"
    // InternalBot.g:3230:1: rule__State2__Group__3__Impl : ( '{' ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3234:1: ( ( '{' ) )
            // InternalBot.g:3235:1: ( '{' )
            {
            // InternalBot.g:3235:1: ( '{' )
            // InternalBot.g:3236:2: '{'
            {
             before(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_3()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__3__Impl"


    // $ANTLR start "rule__State2__Group__4"
    // InternalBot.g:3245:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3249:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:3250:2: rule__State2__Group__4__Impl rule__State2__Group__5
            {
            pushFollow(FOLLOW_31);
            rule__State2__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__4"


    // $ANTLR start "rule__State2__Group__4__Impl"
    // InternalBot.g:3257:1: rule__State2__Group__4__Impl : ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3261:1: ( ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) )
            // InternalBot.g:3262:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            {
            // InternalBot.g:3262:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            // InternalBot.g:3263:2: ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* )
            {
            // InternalBot.g:3263:2: ( ( rule__State2__Group_4__0 ) )
            // InternalBot.g:3264:3: ( rule__State2__Group_4__0 )
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3265:3: ( rule__State2__Group_4__0 )
            // InternalBot.g:3265:4: rule__State2__Group_4__0
            {
            pushFollow(FOLLOW_32);
            rule__State2__Group_4__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_4()); 

            }

            // InternalBot.g:3268:2: ( ( rule__State2__Group_4__0 )* )
            // InternalBot.g:3269:3: ( rule__State2__Group_4__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3270:3: ( rule__State2__Group_4__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==65) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBot.g:3270:4: rule__State2__Group_4__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__State2__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getState2Access().getGroup_4()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__4__Impl"


    // $ANTLR start "rule__State2__Group__5"
    // InternalBot.g:3279:1: rule__State2__Group__5 : rule__State2__Group__5__Impl ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3283:1: ( rule__State2__Group__5__Impl )
            // InternalBot.g:3284:2: rule__State2__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__5"


    // $ANTLR start "rule__State2__Group__5__Impl"
    // InternalBot.g:3290:1: rule__State2__Group__5__Impl : ( '}' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3294:1: ( ( '}' ) )
            // InternalBot.g:3295:1: ( '}' )
            {
            // InternalBot.g:3295:1: ( '}' )
            // InternalBot.g:3296:2: '}'
            {
             before(grammarAccess.getState2Access().getRightCurlyBracketKeyword_5()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getState2Access().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group__5__Impl"


    // $ANTLR start "rule__State2__Group_2__0"
    // InternalBot.g:3306:1: rule__State2__Group_2__0 : rule__State2__Group_2__0__Impl rule__State2__Group_2__1 ;
    public final void rule__State2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3310:1: ( rule__State2__Group_2__0__Impl rule__State2__Group_2__1 )
            // InternalBot.g:3311:2: rule__State2__Group_2__0__Impl rule__State2__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__State2__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_2__0"


    // $ANTLR start "rule__State2__Group_2__0__Impl"
    // InternalBot.g:3318:1: rule__State2__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3322:1: ( ( ',' ) )
            // InternalBot.g:3323:1: ( ',' )
            {
            // InternalBot.g:3323:1: ( ',' )
            // InternalBot.g:3324:2: ','
            {
             before(grammarAccess.getState2Access().getCommaKeyword_2_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getState2Access().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_2__0__Impl"


    // $ANTLR start "rule__State2__Group_2__1"
    // InternalBot.g:3333:1: rule__State2__Group_2__1 : rule__State2__Group_2__1__Impl ;
    public final void rule__State2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3337:1: ( rule__State2__Group_2__1__Impl )
            // InternalBot.g:3338:2: rule__State2__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_2__1"


    // $ANTLR start "rule__State2__Group_2__1__Impl"
    // InternalBot.g:3344:1: rule__State2__Group_2__1__Impl : ( ( rule__State2__ActionsAssignment_2_1 ) ) ;
    public final void rule__State2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3348:1: ( ( ( rule__State2__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3349:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3349:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            // InternalBot.g:3350:2: ( rule__State2__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2_1()); 
            // InternalBot.g:3351:2: ( rule__State2__ActionsAssignment_2_1 )
            // InternalBot.g:3351:3: rule__State2__ActionsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__State2__ActionsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getActionsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_2__1__Impl"


    // $ANTLR start "rule__State2__Group_4__0"
    // InternalBot.g:3360:1: rule__State2__Group_4__0 : rule__State2__Group_4__0__Impl rule__State2__Group_4__1 ;
    public final void rule__State2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3364:1: ( rule__State2__Group_4__0__Impl rule__State2__Group_4__1 )
            // InternalBot.g:3365:2: rule__State2__Group_4__0__Impl rule__State2__Group_4__1
            {
            pushFollow(FOLLOW_19);
            rule__State2__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_4__0"


    // $ANTLR start "rule__State2__Group_4__0__Impl"
    // InternalBot.g:3372:1: rule__State2__Group_4__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3376:1: ( ( '=>' ) )
            // InternalBot.g:3377:1: ( '=>' )
            {
            // InternalBot.g:3377:1: ( '=>' )
            // InternalBot.g:3378:2: '=>'
            {
             before(grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_4_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_4__0__Impl"


    // $ANTLR start "rule__State2__Group_4__1"
    // InternalBot.g:3387:1: rule__State2__Group_4__1 : rule__State2__Group_4__1__Impl rule__State2__Group_4__2 ;
    public final void rule__State2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3391:1: ( rule__State2__Group_4__1__Impl rule__State2__Group_4__2 )
            // InternalBot.g:3392:2: rule__State2__Group_4__1__Impl rule__State2__Group_4__2
            {
            pushFollow(FOLLOW_20);
            rule__State2__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__State2__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_4__1"


    // $ANTLR start "rule__State2__Group_4__1__Impl"
    // InternalBot.g:3399:1: rule__State2__Group_4__1__Impl : ( ( rule__State2__OutcomingAssignment_4_1 ) ) ;
    public final void rule__State2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3403:1: ( ( ( rule__State2__OutcomingAssignment_4_1 ) ) )
            // InternalBot.g:3404:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            {
            // InternalBot.g:3404:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            // InternalBot.g:3405:2: ( rule__State2__OutcomingAssignment_4_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_4_1()); 
            // InternalBot.g:3406:2: ( rule__State2__OutcomingAssignment_4_1 )
            // InternalBot.g:3406:3: rule__State2__OutcomingAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__State2__OutcomingAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getOutcomingAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_4__1__Impl"


    // $ANTLR start "rule__State2__Group_4__2"
    // InternalBot.g:3414:1: rule__State2__Group_4__2 : rule__State2__Group_4__2__Impl ;
    public final void rule__State2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3418:1: ( rule__State2__Group_4__2__Impl )
            // InternalBot.g:3419:2: rule__State2__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__State2__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_4__2"


    // $ANTLR start "rule__State2__Group_4__2__Impl"
    // InternalBot.g:3425:1: rule__State2__Group_4__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3429:1: ( ( ';' ) )
            // InternalBot.g:3430:1: ( ';' )
            {
            // InternalBot.g:3430:1: ( ';' )
            // InternalBot.g:3431:2: ';'
            {
             before(grammarAccess.getState2Access().getSemicolonKeyword_4_2()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getState2Access().getSemicolonKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__Group_4__2__Impl"


    // $ANTLR start "rule__TrainingPhrase__Group__0"
    // InternalBot.g:3441:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3445:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3446:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__TrainingPhrase__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__0"


    // $ANTLR start "rule__TrainingPhrase__Group__0__Impl"
    // InternalBot.g:3453:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3457:1: ( ( () ) )
            // InternalBot.g:3458:1: ( () )
            {
            // InternalBot.g:3458:1: ( () )
            // InternalBot.g:3459:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3460:2: ()
            // InternalBot.g:3460:3: 
            {
            }

             after(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__0__Impl"


    // $ANTLR start "rule__TrainingPhrase__Group__1"
    // InternalBot.g:3468:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3472:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3473:2: rule__TrainingPhrase__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__1"


    // $ANTLR start "rule__TrainingPhrase__Group__1__Impl"
    // InternalBot.g:3479:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3483:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3484:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3484:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3485:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3485:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3486:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3487:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3487:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_34);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3490:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3491:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3492:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)||LA38_0==73) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBot.g:3492:4: rule__TrainingPhrase__TokensAssignment_1
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__TrainingPhrase__TokensAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // InternalBot.g:3502:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3506:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3507:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // InternalBot.g:3514:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3518:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3519:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3519:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3520:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3521:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3521:3: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // InternalBot.g:3529:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3533:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3534:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_35);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // InternalBot.g:3541:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3545:1: ( ( ':' ) )
            // InternalBot.g:3546:1: ( ':' )
            {
            // InternalBot.g:3546:1: ( ':' )
            // InternalBot.g:3547:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__2"
    // InternalBot.g:3556:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3560:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3561:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FOLLOW_36);
            rule__Parameter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2"


    // $ANTLR start "rule__Parameter__Group__2__Impl"
    // InternalBot.g:3568:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3572:1: ( ( 'entity' ) )
            // InternalBot.g:3573:1: ( 'entity' )
            {
            // InternalBot.g:3573:1: ( 'entity' )
            // InternalBot.g:3574:2: 'entity'
            {
             before(grammarAccess.getParameterAccess().getEntityKeyword_2()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getEntityKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2__Impl"


    // $ANTLR start "rule__Parameter__Group__3"
    // InternalBot.g:3583:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3587:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:3588:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__Parameter__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__3"


    // $ANTLR start "rule__Parameter__Group__3__Impl"
    // InternalBot.g:3595:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3599:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:3600:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:3600:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:3601:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:3602:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:3602:3: rule__Parameter__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__3__Impl"


    // $ANTLR start "rule__Parameter__Group__4"
    // InternalBot.g:3610:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3614:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:3615:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FOLLOW_37);
            rule__Parameter__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__4"


    // $ANTLR start "rule__Parameter__Group__4__Impl"
    // InternalBot.g:3622:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3626:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:3627:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:3627:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:3628:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:3629:2: ( rule__Parameter__Group_4__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==54) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==92) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:3629:3: rule__Parameter__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__4__Impl"


    // $ANTLR start "rule__Parameter__Group__5"
    // InternalBot.g:3637:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3641:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:3642:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FOLLOW_37);
            rule__Parameter__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__5"


    // $ANTLR start "rule__Parameter__Group__5__Impl"
    // InternalBot.g:3649:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3653:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:3654:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:3654:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:3655:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:3656:2: ( rule__Parameter__Group_5__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==54) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==68) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalBot.g:3656:3: rule__Parameter__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__5__Impl"


    // $ANTLR start "rule__Parameter__Group__6"
    // InternalBot.g:3664:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl rule__Parameter__Group__7 ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3668:1: ( rule__Parameter__Group__6__Impl rule__Parameter__Group__7 )
            // InternalBot.g:3669:2: rule__Parameter__Group__6__Impl rule__Parameter__Group__7
            {
            pushFollow(FOLLOW_37);
            rule__Parameter__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__6"


    // $ANTLR start "rule__Parameter__Group__6__Impl"
    // InternalBot.g:3676:1: rule__Parameter__Group__6__Impl : ( ( rule__Parameter__Group_6__0 )? ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3680:1: ( ( ( rule__Parameter__Group_6__0 )? ) )
            // InternalBot.g:3681:1: ( ( rule__Parameter__Group_6__0 )? )
            {
            // InternalBot.g:3681:1: ( ( rule__Parameter__Group_6__0 )? )
            // InternalBot.g:3682:2: ( rule__Parameter__Group_6__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_6()); 
            // InternalBot.g:3683:2: ( rule__Parameter__Group_6__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==54) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:3683:3: rule__Parameter__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Parameter__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getParameterAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__6__Impl"


    // $ANTLR start "rule__Parameter__Group__7"
    // InternalBot.g:3691:1: rule__Parameter__Group__7 : rule__Parameter__Group__7__Impl ;
    public final void rule__Parameter__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3695:1: ( rule__Parameter__Group__7__Impl )
            // InternalBot.g:3696:2: rule__Parameter__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__7"


    // $ANTLR start "rule__Parameter__Group__7__Impl"
    // InternalBot.g:3702:1: rule__Parameter__Group__7__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3706:1: ( ( ';' ) )
            // InternalBot.g:3707:1: ( ';' )
            {
            // InternalBot.g:3707:1: ( ';' )
            // InternalBot.g:3708:2: ';'
            {
             before(grammarAccess.getParameterAccess().getSemicolonKeyword_7()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getSemicolonKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__7__Impl"


    // $ANTLR start "rule__Parameter__Group_4__0"
    // InternalBot.g:3718:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3722:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:3723:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FOLLOW_38);
            rule__Parameter__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__0"


    // $ANTLR start "rule__Parameter__Group_4__0__Impl"
    // InternalBot.g:3730:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3734:1: ( ( ',' ) )
            // InternalBot.g:3735:1: ( ',' )
            {
            // InternalBot.g:3735:1: ( ',' )
            // InternalBot.g:3736:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__0__Impl"


    // $ANTLR start "rule__Parameter__Group_4__1"
    // InternalBot.g:3745:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3749:1: ( rule__Parameter__Group_4__1__Impl )
            // InternalBot.g:3750:2: rule__Parameter__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__1"


    // $ANTLR start "rule__Parameter__Group_4__1__Impl"
    // InternalBot.g:3756:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__RequiredAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3760:1: ( ( ( rule__Parameter__RequiredAssignment_4_1 ) ) )
            // InternalBot.g:3761:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            {
            // InternalBot.g:3761:1: ( ( rule__Parameter__RequiredAssignment_4_1 ) )
            // InternalBot.g:3762:2: ( rule__Parameter__RequiredAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_4_1()); 
            // InternalBot.g:3763:2: ( rule__Parameter__RequiredAssignment_4_1 )
            // InternalBot.g:3763:3: rule__Parameter__RequiredAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__RequiredAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getRequiredAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_4__1__Impl"


    // $ANTLR start "rule__Parameter__Group_5__0"
    // InternalBot.g:3772:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3776:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:3777:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FOLLOW_39);
            rule__Parameter__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__0"


    // $ANTLR start "rule__Parameter__Group_5__0__Impl"
    // InternalBot.g:3784:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3788:1: ( ( ',' ) )
            // InternalBot.g:3789:1: ( ',' )
            {
            // InternalBot.g:3789:1: ( ',' )
            // InternalBot.g:3790:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_5_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__0__Impl"


    // $ANTLR start "rule__Parameter__Group_5__1"
    // InternalBot.g:3799:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3803:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:3804:2: rule__Parameter__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__1"


    // $ANTLR start "rule__Parameter__Group_5__1__Impl"
    // InternalBot.g:3810:1: rule__Parameter__Group_5__1__Impl : ( ( ( rule__Parameter__PromptsAssignment_5_1 ) ) ( ( rule__Parameter__PromptsAssignment_5_1 )* ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3814:1: ( ( ( ( rule__Parameter__PromptsAssignment_5_1 ) ) ( ( rule__Parameter__PromptsAssignment_5_1 )* ) ) )
            // InternalBot.g:3815:1: ( ( ( rule__Parameter__PromptsAssignment_5_1 ) ) ( ( rule__Parameter__PromptsAssignment_5_1 )* ) )
            {
            // InternalBot.g:3815:1: ( ( ( rule__Parameter__PromptsAssignment_5_1 ) ) ( ( rule__Parameter__PromptsAssignment_5_1 )* ) )
            // InternalBot.g:3816:2: ( ( rule__Parameter__PromptsAssignment_5_1 ) ) ( ( rule__Parameter__PromptsAssignment_5_1 )* )
            {
            // InternalBot.g:3816:2: ( ( rule__Parameter__PromptsAssignment_5_1 ) )
            // InternalBot.g:3817:3: ( rule__Parameter__PromptsAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_5_1()); 
            // InternalBot.g:3818:3: ( rule__Parameter__PromptsAssignment_5_1 )
            // InternalBot.g:3818:4: rule__Parameter__PromptsAssignment_5_1
            {
            pushFollow(FOLLOW_40);
            rule__Parameter__PromptsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_5_1()); 

            }

            // InternalBot.g:3821:2: ( ( rule__Parameter__PromptsAssignment_5_1 )* )
            // InternalBot.g:3822:3: ( rule__Parameter__PromptsAssignment_5_1 )*
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_5_1()); 
            // InternalBot.g:3823:3: ( rule__Parameter__PromptsAssignment_5_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==68) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBot.g:3823:4: rule__Parameter__PromptsAssignment_5_1
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__Parameter__PromptsAssignment_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getParameterAccess().getPromptsAssignment_5_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_5__1__Impl"


    // $ANTLR start "rule__Parameter__Group_6__0"
    // InternalBot.g:3833:1: rule__Parameter__Group_6__0 : rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 ;
    public final void rule__Parameter__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3837:1: ( rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 )
            // InternalBot.g:3838:2: rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1
            {
            pushFollow(FOLLOW_41);
            rule__Parameter__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_6__0"


    // $ANTLR start "rule__Parameter__Group_6__0__Impl"
    // InternalBot.g:3845:1: rule__Parameter__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3849:1: ( ( ',' ) )
            // InternalBot.g:3850:1: ( ',' )
            {
            // InternalBot.g:3850:1: ( ',' )
            // InternalBot.g:3851:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_6_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_6__0__Impl"


    // $ANTLR start "rule__Parameter__Group_6__1"
    // InternalBot.g:3860:1: rule__Parameter__Group_6__1 : rule__Parameter__Group_6__1__Impl ;
    public final void rule__Parameter__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3864:1: ( rule__Parameter__Group_6__1__Impl )
            // InternalBot.g:3865:2: rule__Parameter__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_6__1"


    // $ANTLR start "rule__Parameter__Group_6__1__Impl"
    // InternalBot.g:3871:1: rule__Parameter__Group_6__1__Impl : ( ( rule__Parameter__IsListAssignment_6_1 ) ) ;
    public final void rule__Parameter__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3875:1: ( ( ( rule__Parameter__IsListAssignment_6_1 ) ) )
            // InternalBot.g:3876:1: ( ( rule__Parameter__IsListAssignment_6_1 ) )
            {
            // InternalBot.g:3876:1: ( ( rule__Parameter__IsListAssignment_6_1 ) )
            // InternalBot.g:3877:2: ( rule__Parameter__IsListAssignment_6_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_6_1()); 
            // InternalBot.g:3878:2: ( rule__Parameter__IsListAssignment_6_1 )
            // InternalBot.g:3878:3: rule__Parameter__IsListAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__IsListAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getIsListAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group_6__1__Impl"


    // $ANTLR start "rule__Parameter2__Group__0"
    // InternalBot.g:3887:1: rule__Parameter2__Group__0 : rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 ;
    public final void rule__Parameter2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3891:1: ( rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 )
            // InternalBot.g:3892:2: rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__Parameter2__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Parameter2__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter2__Group__0"


    // $ANTLR start "rule__Parameter2__Group__0__Impl"
    // InternalBot.g:3899:1: rule__Parameter2__Group__0__Impl : ( ( rule__Parameter2__NameAssignment_0 ) ) ;
    public final void rule__Parameter2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3903:1: ( ( ( rule__Parameter2__NameAssignment_0 ) ) )
            // InternalBot.g:3904:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            {
            // InternalBot.g:3904:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            // InternalBot.g:3905:2: ( rule__Parameter2__NameAssignment_0 )
            {
             before(grammarAccess.getParameter2Access().getNameAssignment_0()); 
            // InternalBot.g:3906:2: ( rule__Parameter2__NameAssignment_0 )
            // InternalBot.g:3906:3: rule__Parameter2__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Parameter2__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameter2Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter2__Group__0__Impl"


    // $ANTLR start "rule__Parameter2__Group__1"
    // InternalBot.g:3914:1: rule__Parameter2__Group__1 : rule__Parameter2__Group__1__Impl ;
    public final void rule__Parameter2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3918:1: ( rule__Parameter2__Group__1__Impl )
            // InternalBot.g:3919:2: rule__Parameter2__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Parameter2__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter2__Group__1"


    // $ANTLR start "rule__Parameter2__Group__1__Impl"
    // InternalBot.g:3925:1: rule__Parameter2__Group__1__Impl : ( ',' ) ;
    public final void rule__Parameter2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3929:1: ( ( ',' ) )
            // InternalBot.g:3930:1: ( ',' )
            {
            // InternalBot.g:3930:1: ( ',' )
            // InternalBot.g:3931:2: ','
            {
             before(grammarAccess.getParameter2Access().getCommaKeyword_1()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getParameter2Access().getCommaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter2__Group__1__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__0"
    // InternalBot.g:3941:1: rule__PromptLanguage__Group__0 : rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 ;
    public final void rule__PromptLanguage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3945:1: ( rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 )
            // InternalBot.g:3946:2: rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1
            {
            pushFollow(FOLLOW_43);
            rule__PromptLanguage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__0"


    // $ANTLR start "rule__PromptLanguage__Group__0__Impl"
    // InternalBot.g:3953:1: rule__PromptLanguage__Group__0__Impl : ( 'prompts' ) ;
    public final void rule__PromptLanguage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3957:1: ( ( 'prompts' ) )
            // InternalBot.g:3958:1: ( 'prompts' )
            {
            // InternalBot.g:3958:1: ( 'prompts' )
            // InternalBot.g:3959:2: 'prompts'
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__0__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__1"
    // InternalBot.g:3968:1: rule__PromptLanguage__Group__1 : rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 ;
    public final void rule__PromptLanguage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3972:1: ( rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 )
            // InternalBot.g:3973:2: rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2
            {
            pushFollow(FOLLOW_43);
            rule__PromptLanguage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__1"


    // $ANTLR start "rule__PromptLanguage__Group__1__Impl"
    // InternalBot.g:3980:1: rule__PromptLanguage__Group__1__Impl : ( ( rule__PromptLanguage__Group_1__0 )? ) ;
    public final void rule__PromptLanguage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3984:1: ( ( ( rule__PromptLanguage__Group_1__0 )? ) )
            // InternalBot.g:3985:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            {
            // InternalBot.g:3985:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            // InternalBot.g:3986:2: ( rule__PromptLanguage__Group_1__0 )?
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_1()); 
            // InternalBot.g:3987:2: ( rule__PromptLanguage__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==63) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:3987:3: rule__PromptLanguage__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PromptLanguage__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getPromptLanguageAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__1__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__2"
    // InternalBot.g:3995:1: rule__PromptLanguage__Group__2 : rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 ;
    public final void rule__PromptLanguage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3999:1: ( rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 )
            // InternalBot.g:4000:2: rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__PromptLanguage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__2"


    // $ANTLR start "rule__PromptLanguage__Group__2__Impl"
    // InternalBot.g:4007:1: rule__PromptLanguage__Group__2__Impl : ( '[' ) ;
    public final void rule__PromptLanguage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4011:1: ( ( '[' ) )
            // InternalBot.g:4012:1: ( '[' )
            {
            // InternalBot.g:4012:1: ( '[' )
            // InternalBot.g:4013:2: '['
            {
             before(grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__2__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__3"
    // InternalBot.g:4022:1: rule__PromptLanguage__Group__3 : rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 ;
    public final void rule__PromptLanguage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4026:1: ( rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 )
            // InternalBot.g:4027:2: rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4
            {
            pushFollow(FOLLOW_44);
            rule__PromptLanguage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__3"


    // $ANTLR start "rule__PromptLanguage__Group__3__Impl"
    // InternalBot.g:4034:1: rule__PromptLanguage__Group__3__Impl : ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) ;
    public final void rule__PromptLanguage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4038:1: ( ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) )
            // InternalBot.g:4039:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            {
            // InternalBot.g:4039:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            // InternalBot.g:4040:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 
            // InternalBot.g:4041:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            // InternalBot.g:4041:3: rule__PromptLanguage__PromptsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__PromptsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__3__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__4"
    // InternalBot.g:4049:1: rule__PromptLanguage__Group__4 : rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 ;
    public final void rule__PromptLanguage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4053:1: ( rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 )
            // InternalBot.g:4054:2: rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5
            {
            pushFollow(FOLLOW_44);
            rule__PromptLanguage__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__4"


    // $ANTLR start "rule__PromptLanguage__Group__4__Impl"
    // InternalBot.g:4061:1: rule__PromptLanguage__Group__4__Impl : ( ( rule__PromptLanguage__Group_4__0 )* ) ;
    public final void rule__PromptLanguage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4065:1: ( ( ( rule__PromptLanguage__Group_4__0 )* ) )
            // InternalBot.g:4066:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            {
            // InternalBot.g:4066:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            // InternalBot.g:4067:2: ( rule__PromptLanguage__Group_4__0 )*
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_4()); 
            // InternalBot.g:4068:2: ( rule__PromptLanguage__Group_4__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==54) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:4068:3: rule__PromptLanguage__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__PromptLanguage__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getPromptLanguageAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__4__Impl"


    // $ANTLR start "rule__PromptLanguage__Group__5"
    // InternalBot.g:4076:1: rule__PromptLanguage__Group__5 : rule__PromptLanguage__Group__5__Impl ;
    public final void rule__PromptLanguage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4080:1: ( rule__PromptLanguage__Group__5__Impl )
            // InternalBot.g:4081:2: rule__PromptLanguage__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__5"


    // $ANTLR start "rule__PromptLanguage__Group__5__Impl"
    // InternalBot.g:4087:1: rule__PromptLanguage__Group__5__Impl : ( ']' ) ;
    public final void rule__PromptLanguage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4091:1: ( ( ']' ) )
            // InternalBot.g:4092:1: ( ']' )
            {
            // InternalBot.g:4092:1: ( ']' )
            // InternalBot.g:4093:2: ']'
            {
             before(grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group__5__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_1__0"
    // InternalBot.g:4103:1: rule__PromptLanguage__Group_1__0 : rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 ;
    public final void rule__PromptLanguage__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4107:1: ( rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 )
            // InternalBot.g:4108:2: rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__PromptLanguage__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_1__0"


    // $ANTLR start "rule__PromptLanguage__Group_1__0__Impl"
    // InternalBot.g:4115:1: rule__PromptLanguage__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__PromptLanguage__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4119:1: ( ( 'in' ) )
            // InternalBot.g:4120:1: ( 'in' )
            {
            // InternalBot.g:4120:1: ( 'in' )
            // InternalBot.g:4121:2: 'in'
            {
             before(grammarAccess.getPromptLanguageAccess().getInKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getInKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_1__0__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_1__1"
    // InternalBot.g:4130:1: rule__PromptLanguage__Group_1__1 : rule__PromptLanguage__Group_1__1__Impl ;
    public final void rule__PromptLanguage__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4134:1: ( rule__PromptLanguage__Group_1__1__Impl )
            // InternalBot.g:4135:2: rule__PromptLanguage__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_1__1"


    // $ANTLR start "rule__PromptLanguage__Group_1__1__Impl"
    // InternalBot.g:4141:1: rule__PromptLanguage__Group_1__1__Impl : ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) ;
    public final void rule__PromptLanguage__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4145:1: ( ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:4146:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:4146:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            // InternalBot.g:4147:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:4148:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            // InternalBot.g:4148:3: rule__PromptLanguage__LanguageAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__LanguageAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_1__1__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_4__0"
    // InternalBot.g:4157:1: rule__PromptLanguage__Group_4__0 : rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 ;
    public final void rule__PromptLanguage__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4161:1: ( rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 )
            // InternalBot.g:4162:2: rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__PromptLanguage__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_4__0"


    // $ANTLR start "rule__PromptLanguage__Group_4__0__Impl"
    // InternalBot.g:4169:1: rule__PromptLanguage__Group_4__0__Impl : ( ',' ) ;
    public final void rule__PromptLanguage__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4173:1: ( ( ',' ) )
            // InternalBot.g:4174:1: ( ',' )
            {
            // InternalBot.g:4174:1: ( ',' )
            // InternalBot.g:4175:2: ','
            {
             before(grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_4__0__Impl"


    // $ANTLR start "rule__PromptLanguage__Group_4__1"
    // InternalBot.g:4184:1: rule__PromptLanguage__Group_4__1 : rule__PromptLanguage__Group_4__1__Impl ;
    public final void rule__PromptLanguage__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4188:1: ( rule__PromptLanguage__Group_4__1__Impl )
            // InternalBot.g:4189:2: rule__PromptLanguage__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_4__1"


    // $ANTLR start "rule__PromptLanguage__Group_4__1__Impl"
    // InternalBot.g:4195:1: rule__PromptLanguage__Group_4__1__Impl : ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) ;
    public final void rule__PromptLanguage__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4199:1: ( ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) )
            // InternalBot.g:4200:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            {
            // InternalBot.g:4200:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            // InternalBot.g:4201:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 
            // InternalBot.g:4202:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            // InternalBot.g:4202:3: rule__PromptLanguage__PromptsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__PromptLanguage__PromptsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__Group_4__1__Impl"


    // $ANTLR start "rule__EntityToken__Group__0"
    // InternalBot.g:4211:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4215:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:4216:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__EntityToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__0"


    // $ANTLR start "rule__EntityToken__Group__0__Impl"
    // InternalBot.g:4223:1: rule__EntityToken__Group__0__Impl : ( 'Token' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4227:1: ( ( 'Token' ) )
            // InternalBot.g:4228:1: ( 'Token' )
            {
            // InternalBot.g:4228:1: ( 'Token' )
            // InternalBot.g:4229:2: 'Token'
            {
             before(grammarAccess.getEntityTokenAccess().getTokenKeyword_0()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getEntityTokenAccess().getTokenKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__0__Impl"


    // $ANTLR start "rule__EntityToken__Group__1"
    // InternalBot.g:4238:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl rule__EntityToken__Group__2 ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4242:1: ( rule__EntityToken__Group__1__Impl rule__EntityToken__Group__2 )
            // InternalBot.g:4243:2: rule__EntityToken__Group__1__Impl rule__EntityToken__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__EntityToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__1"


    // $ANTLR start "rule__EntityToken__Group__1__Impl"
    // InternalBot.g:4250:1: rule__EntityToken__Group__1__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4254:1: ( ( '@' ) )
            // InternalBot.g:4255:1: ( '@' )
            {
            // InternalBot.g:4255:1: ( '@' )
            // InternalBot.g:4256:2: '@'
            {
             before(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__1__Impl"


    // $ANTLR start "rule__EntityToken__Group__2"
    // InternalBot.g:4265:1: rule__EntityToken__Group__2 : rule__EntityToken__Group__2__Impl ;
    public final void rule__EntityToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4269:1: ( rule__EntityToken__Group__2__Impl )
            // InternalBot.g:4270:2: rule__EntityToken__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__2"


    // $ANTLR start "rule__EntityToken__Group__2__Impl"
    // InternalBot.g:4276:1: rule__EntityToken__Group__2__Impl : ( ( rule__EntityToken__EntityAssignment_2 ) ) ;
    public final void rule__EntityToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4280:1: ( ( ( rule__EntityToken__EntityAssignment_2 ) ) )
            // InternalBot.g:4281:1: ( ( rule__EntityToken__EntityAssignment_2 ) )
            {
            // InternalBot.g:4281:1: ( ( rule__EntityToken__EntityAssignment_2 ) )
            // InternalBot.g:4282:2: ( rule__EntityToken__EntityAssignment_2 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_2()); 
            // InternalBot.g:4283:2: ( rule__EntityToken__EntityAssignment_2 )
            // InternalBot.g:4283:3: rule__EntityToken__EntityAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__EntityAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEntityTokenAccess().getEntityAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__Group__2__Impl"


    // $ANTLR start "rule__ParameterToken__Group__0"
    // InternalBot.g:4292:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4296:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:4297:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ParameterToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__0"


    // $ANTLR start "rule__ParameterToken__Group__0__Impl"
    // InternalBot.g:4304:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4308:1: ( ( '[' ) )
            // InternalBot.g:4309:1: ( '[' )
            {
            // InternalBot.g:4309:1: ( '[' )
            // InternalBot.g:4310:2: '['
            {
             before(grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__0__Impl"


    // $ANTLR start "rule__ParameterToken__Group__1"
    // InternalBot.g:4319:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4323:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:4324:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
            {
            pushFollow(FOLLOW_46);
            rule__ParameterToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__1"


    // $ANTLR start "rule__ParameterToken__Group__1__Impl"
    // InternalBot.g:4331:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4335:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:4336:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:4336:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:4337:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:4338:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:4338:3: rule__ParameterToken__ParameterAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterToken__ParameterAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__1__Impl"


    // $ANTLR start "rule__ParameterToken__Group__2"
    // InternalBot.g:4346:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4350:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:4351:2: rule__ParameterToken__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterToken__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__2"


    // $ANTLR start "rule__ParameterToken__Group__2__Impl"
    // InternalBot.g:4357:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4361:1: ( ( ']' ) )
            // InternalBot.g:4362:1: ( ']' )
            {
            // InternalBot.g:4362:1: ( ']' )
            // InternalBot.g:4363:2: ']'
            {
             before(grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__Group__2__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__0"
    // InternalBot.g:4373:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4377:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:4378:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ParameterRefenceToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__0"


    // $ANTLR start "rule__ParameterRefenceToken__Group__0__Impl"
    // InternalBot.g:4385:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4389:1: ( ( '(' ) )
            // InternalBot.g:4390:1: ( '(' )
            {
            // InternalBot.g:4390:1: ( '(' )
            // InternalBot.g:4391:2: '('
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__0__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__1"
    // InternalBot.g:4400:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4404:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:4405:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__ParameterRefenceToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__1"


    // $ANTLR start "rule__ParameterRefenceToken__Group__1__Impl"
    // InternalBot.g:4412:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4416:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:4417:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:4417:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:4418:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:4419:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:4419:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__TextReferenceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__1__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__2"
    // InternalBot.g:4427:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4431:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:4432:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
            {
            pushFollow(FOLLOW_48);
            rule__ParameterRefenceToken__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__2"


    // $ANTLR start "rule__ParameterRefenceToken__Group__2__Impl"
    // InternalBot.g:4439:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4443:1: ( ( ')' ) )
            // InternalBot.g:4444:1: ( ')' )
            {
            // InternalBot.g:4444:1: ( ')' )
            // InternalBot.g:4445:2: ')'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__2__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__3"
    // InternalBot.g:4454:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4458:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:4459:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__ParameterRefenceToken__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__3"


    // $ANTLR start "rule__ParameterRefenceToken__Group__3__Impl"
    // InternalBot.g:4466:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4470:1: ( ( '[' ) )
            // InternalBot.g:4471:1: ( '[' )
            {
            // InternalBot.g:4471:1: ( '[' )
            // InternalBot.g:4472:2: '['
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__3__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__4"
    // InternalBot.g:4481:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4485:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:4486:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
            {
            pushFollow(FOLLOW_46);
            rule__ParameterRefenceToken__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__4"


    // $ANTLR start "rule__ParameterRefenceToken__Group__4__Impl"
    // InternalBot.g:4493:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4497:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:4498:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:4498:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:4499:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:4500:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:4500:3: rule__ParameterRefenceToken__ParameterAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__ParameterAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__4__Impl"


    // $ANTLR start "rule__ParameterRefenceToken__Group__5"
    // InternalBot.g:4508:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4512:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:4513:2: rule__ParameterRefenceToken__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ParameterRefenceToken__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__5"


    // $ANTLR start "rule__ParameterRefenceToken__Group__5__Impl"
    // InternalBot.g:4519:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4523:1: ( ( ']' ) )
            // InternalBot.g:4524:1: ( ']' )
            {
            // InternalBot.g:4524:1: ( ']' )
            // InternalBot.g:4525:2: ']'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__Group__5__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group__0"
    // InternalBot.g:4535:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4539:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:4540:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__HTTPRequestToken__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__0"


    // $ANTLR start "rule__HTTPRequestToken__Group__0__Impl"
    // InternalBot.g:4547:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4551:1: ( ( 'request.' ) )
            // InternalBot.g:4552:1: ( 'request.' )
            {
            // InternalBot.g:4552:1: ( 'request.' )
            // InternalBot.g:4553:2: 'request.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__0__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group__1"
    // InternalBot.g:4562:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4566:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:4567:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
            {
            pushFollow(FOLLOW_50);
            rule__HTTPRequestToken__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__1"


    // $ANTLR start "rule__HTTPRequestToken__Group__1__Impl"
    // InternalBot.g:4574:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4578:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4579:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4579:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4580:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4581:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4581:3: rule__HTTPRequestToken__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__1__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group__2"
    // InternalBot.g:4589:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4593:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:4594:2: rule__HTTPRequestToken__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__2"


    // $ANTLR start "rule__HTTPRequestToken__Group__2__Impl"
    // InternalBot.g:4600:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4604:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:4605:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:4605:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:4606:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:4607:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==76) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBot.g:4607:3: rule__HTTPRequestToken__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequestToken__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group__2__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__0"
    // InternalBot.g:4616:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4620:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:4621:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequestToken__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__0"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__0__Impl"
    // InternalBot.g:4628:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4632:1: ( ( '.' ) )
            // InternalBot.g:4633:1: ( '.' )
            {
            // InternalBot.g:4633:1: ( '.' )
            // InternalBot.g:4634:2: '.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__0__Impl"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__1"
    // InternalBot.g:4643:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4647:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:4648:2: rule__HTTPRequestToken__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__1"


    // $ANTLR start "rule__HTTPRequestToken__Group_2__1__Impl"
    // InternalBot.g:4654:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4658:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:4659:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:4659:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:4660:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:4661:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:4661:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequestToken__DataKeyAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__Group_2__1__Impl"


    // $ANTLR start "rule__Entity__Group__0"
    // InternalBot.g:4670:1: rule__Entity__Group__0 : rule__Entity__Group__0__Impl rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4674:1: ( rule__Entity__Group__0__Impl rule__Entity__Group__1 )
            // InternalBot.g:4675:2: rule__Entity__Group__0__Impl rule__Entity__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Entity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0"


    // $ANTLR start "rule__Entity__Group__0__Impl"
    // InternalBot.g:4682:1: rule__Entity__Group__0__Impl : ( 'Entity' ) ;
    public final void rule__Entity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4686:1: ( ( 'Entity' ) )
            // InternalBot.g:4687:1: ( 'Entity' )
            {
            // InternalBot.g:4687:1: ( 'Entity' )
            // InternalBot.g:4688:2: 'Entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__0__Impl"


    // $ANTLR start "rule__Entity__Group__1"
    // InternalBot.g:4697:1: rule__Entity__Group__1 : rule__Entity__Group__1__Impl rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4701:1: ( rule__Entity__Group__1__Impl rule__Entity__Group__2 )
            // InternalBot.g:4702:2: rule__Entity__Group__1__Impl rule__Entity__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Entity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1"


    // $ANTLR start "rule__Entity__Group__1__Impl"
    // InternalBot.g:4709:1: rule__Entity__Group__1__Impl : ( ( rule__Entity__NameAssignment_1 ) ) ;
    public final void rule__Entity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4713:1: ( ( ( rule__Entity__NameAssignment_1 ) ) )
            // InternalBot.g:4714:1: ( ( rule__Entity__NameAssignment_1 ) )
            {
            // InternalBot.g:4714:1: ( ( rule__Entity__NameAssignment_1 ) )
            // InternalBot.g:4715:2: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // InternalBot.g:4716:2: ( rule__Entity__NameAssignment_1 )
            // InternalBot.g:4716:3: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Entity__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__1__Impl"


    // $ANTLR start "rule__Entity__Group__2"
    // InternalBot.g:4724:1: rule__Entity__Group__2 : rule__Entity__Group__2__Impl rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4728:1: ( rule__Entity__Group__2__Impl rule__Entity__Group__3 )
            // InternalBot.g:4729:2: rule__Entity__Group__2__Impl rule__Entity__Group__3
            {
            pushFollow(FOLLOW_51);
            rule__Entity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Entity__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2"


    // $ANTLR start "rule__Entity__Group__2__Impl"
    // InternalBot.g:4736:1: rule__Entity__Group__2__Impl : ( ':' ) ;
    public final void rule__Entity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4740:1: ( ( ':' ) )
            // InternalBot.g:4741:1: ( ':' )
            {
            // InternalBot.g:4741:1: ( ':' )
            // InternalBot.g:4742:2: ':'
            {
             before(grammarAccess.getEntityAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getEntityAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__2__Impl"


    // $ANTLR start "rule__Entity__Group__3"
    // InternalBot.g:4751:1: rule__Entity__Group__3 : rule__Entity__Group__3__Impl ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4755:1: ( rule__Entity__Group__3__Impl )
            // InternalBot.g:4756:2: rule__Entity__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3"


    // $ANTLR start "rule__Entity__Group__3__Impl"
    // InternalBot.g:4762:1: rule__Entity__Group__3__Impl : ( ( ( rule__Entity__InputsAssignment_3 ) ) ( ( rule__Entity__InputsAssignment_3 )* ) ) ;
    public final void rule__Entity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4766:1: ( ( ( ( rule__Entity__InputsAssignment_3 ) ) ( ( rule__Entity__InputsAssignment_3 )* ) ) )
            // InternalBot.g:4767:1: ( ( ( rule__Entity__InputsAssignment_3 ) ) ( ( rule__Entity__InputsAssignment_3 )* ) )
            {
            // InternalBot.g:4767:1: ( ( ( rule__Entity__InputsAssignment_3 ) ) ( ( rule__Entity__InputsAssignment_3 )* ) )
            // InternalBot.g:4768:2: ( ( rule__Entity__InputsAssignment_3 ) ) ( ( rule__Entity__InputsAssignment_3 )* )
            {
            // InternalBot.g:4768:2: ( ( rule__Entity__InputsAssignment_3 ) )
            // InternalBot.g:4769:3: ( rule__Entity__InputsAssignment_3 )
            {
             before(grammarAccess.getEntityAccess().getInputsAssignment_3()); 
            // InternalBot.g:4770:3: ( rule__Entity__InputsAssignment_3 )
            // InternalBot.g:4770:4: rule__Entity__InputsAssignment_3
            {
            pushFollow(FOLLOW_52);
            rule__Entity__InputsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getInputsAssignment_3()); 

            }

            // InternalBot.g:4773:2: ( ( rule__Entity__InputsAssignment_3 )* )
            // InternalBot.g:4774:3: ( rule__Entity__InputsAssignment_3 )*
            {
             before(grammarAccess.getEntityAccess().getInputsAssignment_3()); 
            // InternalBot.g:4775:3: ( rule__Entity__InputsAssignment_3 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=60 && LA46_0<=61)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:4775:4: rule__Entity__InputsAssignment_3
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__Entity__InputsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getInputsAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Group__3__Impl"


    // $ANTLR start "rule__LanguageInput__Group__0"
    // InternalBot.g:4785:1: rule__LanguageInput__Group__0 : rule__LanguageInput__Group__0__Impl rule__LanguageInput__Group__1 ;
    public final void rule__LanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4789:1: ( rule__LanguageInput__Group__0__Impl rule__LanguageInput__Group__1 )
            // InternalBot.g:4790:2: rule__LanguageInput__Group__0__Impl rule__LanguageInput__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__LanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__0"


    // $ANTLR start "rule__LanguageInput__Group__0__Impl"
    // InternalBot.g:4797:1: rule__LanguageInput__Group__0__Impl : ( ( rule__LanguageInput__Group_0__0 )? ) ;
    public final void rule__LanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4801:1: ( ( ( rule__LanguageInput__Group_0__0 )? ) )
            // InternalBot.g:4802:1: ( ( rule__LanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:4802:1: ( ( rule__LanguageInput__Group_0__0 )? )
            // InternalBot.g:4803:2: ( rule__LanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:4804:2: ( rule__LanguageInput__Group_0__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==60) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:4804:3: rule__LanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__0__Impl"


    // $ANTLR start "rule__LanguageInput__Group__1"
    // InternalBot.g:4812:1: rule__LanguageInput__Group__1 : rule__LanguageInput__Group__1__Impl rule__LanguageInput__Group__2 ;
    public final void rule__LanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4816:1: ( rule__LanguageInput__Group__1__Impl rule__LanguageInput__Group__2 )
            // InternalBot.g:4817:2: rule__LanguageInput__Group__1__Impl rule__LanguageInput__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__LanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__1"


    // $ANTLR start "rule__LanguageInput__Group__1__Impl"
    // InternalBot.g:4824:1: rule__LanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__LanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4828:1: ( ( '{' ) )
            // InternalBot.g:4829:1: ( '{' )
            {
            // InternalBot.g:4829:1: ( '{' )
            // InternalBot.g:4830:2: '{'
            {
             before(grammarAccess.getLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__1__Impl"


    // $ANTLR start "rule__LanguageInput__Group__2"
    // InternalBot.g:4839:1: rule__LanguageInput__Group__2 : rule__LanguageInput__Group__2__Impl rule__LanguageInput__Group__3 ;
    public final void rule__LanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4843:1: ( rule__LanguageInput__Group__2__Impl rule__LanguageInput__Group__3 )
            // InternalBot.g:4844:2: rule__LanguageInput__Group__2__Impl rule__LanguageInput__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__LanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__2"


    // $ANTLR start "rule__LanguageInput__Group__2__Impl"
    // InternalBot.g:4851:1: rule__LanguageInput__Group__2__Impl : ( ( rule__LanguageInput__Group_2__0 ) ) ;
    public final void rule__LanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4855:1: ( ( ( rule__LanguageInput__Group_2__0 ) ) )
            // InternalBot.g:4856:1: ( ( rule__LanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:4856:1: ( ( rule__LanguageInput__Group_2__0 ) )
            // InternalBot.g:4857:2: ( rule__LanguageInput__Group_2__0 )
            {
             before(grammarAccess.getLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:4858:2: ( rule__LanguageInput__Group_2__0 )
            // InternalBot.g:4858:3: rule__LanguageInput__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getLanguageInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__2__Impl"


    // $ANTLR start "rule__LanguageInput__Group__3"
    // InternalBot.g:4866:1: rule__LanguageInput__Group__3 : rule__LanguageInput__Group__3__Impl ;
    public final void rule__LanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4870:1: ( rule__LanguageInput__Group__3__Impl )
            // InternalBot.g:4871:2: rule__LanguageInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__3"


    // $ANTLR start "rule__LanguageInput__Group__3__Impl"
    // InternalBot.g:4877:1: rule__LanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__LanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4881:1: ( ( '}' ) )
            // InternalBot.g:4882:1: ( '}' )
            {
            // InternalBot.g:4882:1: ( '}' )
            // InternalBot.g:4883:2: '}'
            {
             before(grammarAccess.getLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getLanguageInputAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group__3__Impl"


    // $ANTLR start "rule__LanguageInput__Group_0__0"
    // InternalBot.g:4893:1: rule__LanguageInput__Group_0__0 : rule__LanguageInput__Group_0__0__Impl rule__LanguageInput__Group_0__1 ;
    public final void rule__LanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4897:1: ( rule__LanguageInput__Group_0__0__Impl rule__LanguageInput__Group_0__1 )
            // InternalBot.g:4898:2: rule__LanguageInput__Group_0__0__Impl rule__LanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_54);
            rule__LanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_0__0"


    // $ANTLR start "rule__LanguageInput__Group_0__0__Impl"
    // InternalBot.g:4905:1: rule__LanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__LanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4909:1: ( ( 'inputs' ) )
            // InternalBot.g:4910:1: ( 'inputs' )
            {
            // InternalBot.g:4910:1: ( 'inputs' )
            // InternalBot.g:4911:2: 'inputs'
            {
             before(grammarAccess.getLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__LanguageInput__Group_0__1"
    // InternalBot.g:4920:1: rule__LanguageInput__Group_0__1 : rule__LanguageInput__Group_0__1__Impl rule__LanguageInput__Group_0__2 ;
    public final void rule__LanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4924:1: ( rule__LanguageInput__Group_0__1__Impl rule__LanguageInput__Group_0__2 )
            // InternalBot.g:4925:2: rule__LanguageInput__Group_0__1__Impl rule__LanguageInput__Group_0__2
            {
            pushFollow(FOLLOW_7);
            rule__LanguageInput__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_0__1"


    // $ANTLR start "rule__LanguageInput__Group_0__1__Impl"
    // InternalBot.g:4932:1: rule__LanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__LanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4936:1: ( ( 'in' ) )
            // InternalBot.g:4937:1: ( 'in' )
            {
            // InternalBot.g:4937:1: ( 'in' )
            // InternalBot.g:4938:2: 'in'
            {
             before(grammarAccess.getLanguageInputAccess().getInKeyword_0_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getLanguageInputAccess().getInKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__LanguageInput__Group_0__2"
    // InternalBot.g:4947:1: rule__LanguageInput__Group_0__2 : rule__LanguageInput__Group_0__2__Impl ;
    public final void rule__LanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4951:1: ( rule__LanguageInput__Group_0__2__Impl )
            // InternalBot.g:4952:2: rule__LanguageInput__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_0__2"


    // $ANTLR start "rule__LanguageInput__Group_0__2__Impl"
    // InternalBot.g:4958:1: rule__LanguageInput__Group_0__2__Impl : ( ( rule__LanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__LanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4962:1: ( ( ( rule__LanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:4963:1: ( ( rule__LanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:4963:1: ( ( rule__LanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:4964:2: ( rule__LanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:4965:2: ( rule__LanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:4965:3: rule__LanguageInput__LanguageAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__LanguageAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getLanguageInputAccess().getLanguageAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_0__2__Impl"


    // $ANTLR start "rule__LanguageInput__Group_2__0"
    // InternalBot.g:4974:1: rule__LanguageInput__Group_2__0 : rule__LanguageInput__Group_2__0__Impl rule__LanguageInput__Group_2__1 ;
    public final void rule__LanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4978:1: ( rule__LanguageInput__Group_2__0__Impl rule__LanguageInput__Group_2__1 )
            // InternalBot.g:4979:2: rule__LanguageInput__Group_2__0__Impl rule__LanguageInput__Group_2__1
            {
            pushFollow(FOLLOW_53);
            rule__LanguageInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_2__0"


    // $ANTLR start "rule__LanguageInput__Group_2__0__Impl"
    // InternalBot.g:4986:1: rule__LanguageInput__Group_2__0__Impl : ( ( rule__LanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__LanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4990:1: ( ( ( rule__LanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:4991:1: ( ( rule__LanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:4991:1: ( ( rule__LanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:4992:2: ( rule__LanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:4993:2: ( rule__LanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:4993:3: rule__LanguageInput__InputsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__InputsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getLanguageInputAccess().getInputsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_2__0__Impl"


    // $ANTLR start "rule__LanguageInput__Group_2__1"
    // InternalBot.g:5001:1: rule__LanguageInput__Group_2__1 : rule__LanguageInput__Group_2__1__Impl ;
    public final void rule__LanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5005:1: ( rule__LanguageInput__Group_2__1__Impl )
            // InternalBot.g:5006:2: rule__LanguageInput__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LanguageInput__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_2__1"


    // $ANTLR start "rule__LanguageInput__Group_2__1__Impl"
    // InternalBot.g:5012:1: rule__LanguageInput__Group_2__1__Impl : ( ( rule__LanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__LanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5016:1: ( ( ( rule__LanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5017:1: ( ( rule__LanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5017:1: ( ( rule__LanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5018:2: ( rule__LanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5019:2: ( rule__LanguageInput__InputsAssignment_2_1 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=78 && LA48_0<=80)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBot.g:5019:3: rule__LanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__LanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getLanguageInputAccess().getInputsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__Group_2__1__Impl"


    // $ANTLR start "rule__RegexInput__Group__0"
    // InternalBot.g:5028:1: rule__RegexInput__Group__0 : rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 ;
    public final void rule__RegexInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5032:1: ( rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 )
            // InternalBot.g:5033:2: rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__RegexInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__0"


    // $ANTLR start "rule__RegexInput__Group__0__Impl"
    // InternalBot.g:5040:1: rule__RegexInput__Group__0__Impl : ( () ) ;
    public final void rule__RegexInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5044:1: ( ( () ) )
            // InternalBot.g:5045:1: ( () )
            {
            // InternalBot.g:5045:1: ( () )
            // InternalBot.g:5046:2: ()
            {
             before(grammarAccess.getRegexInputAccess().getRegexInputAction_0()); 
            // InternalBot.g:5047:2: ()
            // InternalBot.g:5047:3: 
            {
            }

             after(grammarAccess.getRegexInputAccess().getRegexInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__0__Impl"


    // $ANTLR start "rule__RegexInput__Group__1"
    // InternalBot.g:5055:1: rule__RegexInput__Group__1 : rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 ;
    public final void rule__RegexInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5059:1: ( rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 )
            // InternalBot.g:5060:2: rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__RegexInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__1"


    // $ANTLR start "rule__RegexInput__Group__1__Impl"
    // InternalBot.g:5067:1: rule__RegexInput__Group__1__Impl : ( 'r' ) ;
    public final void rule__RegexInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5071:1: ( ( 'r' ) )
            // InternalBot.g:5072:1: ( 'r' )
            {
            // InternalBot.g:5072:1: ( 'r' )
            // InternalBot.g:5073:2: 'r'
            {
             before(grammarAccess.getRegexInputAccess().getRKeyword_1()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getRegexInputAccess().getRKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__1__Impl"


    // $ANTLR start "rule__RegexInput__Group__2"
    // InternalBot.g:5082:1: rule__RegexInput__Group__2 : rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 ;
    public final void rule__RegexInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5086:1: ( rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 )
            // InternalBot.g:5087:2: rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__RegexInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__2"


    // $ANTLR start "rule__RegexInput__Group__2__Impl"
    // InternalBot.g:5094:1: rule__RegexInput__Group__2__Impl : ( ':' ) ;
    public final void rule__RegexInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5098:1: ( ( ':' ) )
            // InternalBot.g:5099:1: ( ':' )
            {
            // InternalBot.g:5099:1: ( ':' )
            // InternalBot.g:5100:2: ':'
            {
             before(grammarAccess.getRegexInputAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getRegexInputAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__2__Impl"


    // $ANTLR start "rule__RegexInput__Group__3"
    // InternalBot.g:5109:1: rule__RegexInput__Group__3 : rule__RegexInput__Group__3__Impl ;
    public final void rule__RegexInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5113:1: ( rule__RegexInput__Group__3__Impl )
            // InternalBot.g:5114:2: rule__RegexInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RegexInput__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__3"


    // $ANTLR start "rule__RegexInput__Group__3__Impl"
    // InternalBot.g:5120:1: rule__RegexInput__Group__3__Impl : ( ( rule__RegexInput__ExpresionAssignment_3 ) ) ;
    public final void rule__RegexInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5124:1: ( ( ( rule__RegexInput__ExpresionAssignment_3 ) ) )
            // InternalBot.g:5125:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            {
            // InternalBot.g:5125:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            // InternalBot.g:5126:2: ( rule__RegexInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getRegexInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:5127:2: ( rule__RegexInput__ExpresionAssignment_3 )
            // InternalBot.g:5127:3: rule__RegexInput__ExpresionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__RegexInput__ExpresionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRegexInputAccess().getExpresionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__Group__3__Impl"


    // $ANTLR start "rule__CompositeInput__Group__0"
    // InternalBot.g:5136:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5140:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:5141:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__CompositeInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__0"


    // $ANTLR start "rule__CompositeInput__Group__0__Impl"
    // InternalBot.g:5148:1: rule__CompositeInput__Group__0__Impl : ( () ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5152:1: ( ( () ) )
            // InternalBot.g:5153:1: ( () )
            {
            // InternalBot.g:5153:1: ( () )
            // InternalBot.g:5154:2: ()
            {
             before(grammarAccess.getCompositeInputAccess().getCompositeInputAction_0()); 
            // InternalBot.g:5155:2: ()
            // InternalBot.g:5155:3: 
            {
            }

             after(grammarAccess.getCompositeInputAccess().getCompositeInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__0__Impl"


    // $ANTLR start "rule__CompositeInput__Group__1"
    // InternalBot.g:5163:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5167:1: ( rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 )
            // InternalBot.g:5168:2: rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__CompositeInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__1"


    // $ANTLR start "rule__CompositeInput__Group__1__Impl"
    // InternalBot.g:5175:1: rule__CompositeInput__Group__1__Impl : ( 'c' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5179:1: ( ( 'c' ) )
            // InternalBot.g:5180:1: ( 'c' )
            {
            // InternalBot.g:5180:1: ( 'c' )
            // InternalBot.g:5181:2: 'c'
            {
             before(grammarAccess.getCompositeInputAccess().getCKeyword_1()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getCompositeInputAccess().getCKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__1__Impl"


    // $ANTLR start "rule__CompositeInput__Group__2"
    // InternalBot.g:5190:1: rule__CompositeInput__Group__2 : rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 ;
    public final void rule__CompositeInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5194:1: ( rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 )
            // InternalBot.g:5195:2: rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3
            {
            pushFollow(FOLLOW_57);
            rule__CompositeInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__2"


    // $ANTLR start "rule__CompositeInput__Group__2__Impl"
    // InternalBot.g:5202:1: rule__CompositeInput__Group__2__Impl : ( ':' ) ;
    public final void rule__CompositeInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5206:1: ( ( ':' ) )
            // InternalBot.g:5207:1: ( ':' )
            {
            // InternalBot.g:5207:1: ( ':' )
            // InternalBot.g:5208:2: ':'
            {
             before(grammarAccess.getCompositeInputAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getCompositeInputAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__2__Impl"


    // $ANTLR start "rule__CompositeInput__Group__3"
    // InternalBot.g:5217:1: rule__CompositeInput__Group__3 : rule__CompositeInput__Group__3__Impl ;
    public final void rule__CompositeInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5221:1: ( rule__CompositeInput__Group__3__Impl )
            // InternalBot.g:5222:2: rule__CompositeInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CompositeInput__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__3"


    // $ANTLR start "rule__CompositeInput__Group__3__Impl"
    // InternalBot.g:5228:1: rule__CompositeInput__Group__3__Impl : ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) ;
    public final void rule__CompositeInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5232:1: ( ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) )
            // InternalBot.g:5233:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            {
            // InternalBot.g:5233:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            // InternalBot.g:5234:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            {
            // InternalBot.g:5234:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) )
            // InternalBot.g:5235:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:5236:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            // InternalBot.g:5236:4: rule__CompositeInput__ExpresionAssignment_3
            {
            pushFollow(FOLLOW_58);
            rule__CompositeInput__ExpresionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 

            }

            // InternalBot.g:5239:2: ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            // InternalBot.g:5240:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:5241:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=RULE_STRING && LA49_0<=RULE_ID)||LA49_0==71) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBot.g:5241:4: rule__CompositeInput__ExpresionAssignment_3
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__CompositeInput__ExpresionAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__Group__3__Impl"


    // $ANTLR start "rule__SimpleInput__Group__0"
    // InternalBot.g:5251:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5255:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:5256:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
            {
            pushFollow(FOLLOW_53);
            rule__SimpleInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__0"


    // $ANTLR start "rule__SimpleInput__Group__0__Impl"
    // InternalBot.g:5263:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5267:1: ( ( () ) )
            // InternalBot.g:5268:1: ( () )
            {
            // InternalBot.g:5268:1: ( () )
            // InternalBot.g:5269:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:5270:2: ()
            // InternalBot.g:5270:3: 
            {
            }

             after(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group__1"
    // InternalBot.g:5278:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5282:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:5283:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__SimpleInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__1"


    // $ANTLR start "rule__SimpleInput__Group__1__Impl"
    // InternalBot.g:5290:1: rule__SimpleInput__Group__1__Impl : ( 's' ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5294:1: ( ( 's' ) )
            // InternalBot.g:5295:1: ( 's' )
            {
            // InternalBot.g:5295:1: ( 's' )
            // InternalBot.g:5296:2: 's'
            {
             before(grammarAccess.getSimpleInputAccess().getSKeyword_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getSKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group__2"
    // InternalBot.g:5305:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5309:1: ( rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3 )
            // InternalBot.g:5310:2: rule__SimpleInput__Group__2__Impl rule__SimpleInput__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__2"


    // $ANTLR start "rule__SimpleInput__Group__2__Impl"
    // InternalBot.g:5317:1: rule__SimpleInput__Group__2__Impl : ( ':' ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5321:1: ( ( ':' ) )
            // InternalBot.g:5322:1: ( ':' )
            {
            // InternalBot.g:5322:1: ( ':' )
            // InternalBot.g:5323:2: ':'
            {
             before(grammarAccess.getSimpleInputAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__2__Impl"


    // $ANTLR start "rule__SimpleInput__Group__3"
    // InternalBot.g:5332:1: rule__SimpleInput__Group__3 : rule__SimpleInput__Group__3__Impl rule__SimpleInput__Group__4 ;
    public final void rule__SimpleInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5336:1: ( rule__SimpleInput__Group__3__Impl rule__SimpleInput__Group__4 )
            // InternalBot.g:5337:2: rule__SimpleInput__Group__3__Impl rule__SimpleInput__Group__4
            {
            pushFollow(FOLLOW_59);
            rule__SimpleInput__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__3"


    // $ANTLR start "rule__SimpleInput__Group__3__Impl"
    // InternalBot.g:5344:1: rule__SimpleInput__Group__3__Impl : ( ( rule__SimpleInput__NameAssignment_3 ) ) ;
    public final void rule__SimpleInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5348:1: ( ( ( rule__SimpleInput__NameAssignment_3 ) ) )
            // InternalBot.g:5349:1: ( ( rule__SimpleInput__NameAssignment_3 ) )
            {
            // InternalBot.g:5349:1: ( ( rule__SimpleInput__NameAssignment_3 ) )
            // InternalBot.g:5350:2: ( rule__SimpleInput__NameAssignment_3 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_3()); 
            // InternalBot.g:5351:2: ( rule__SimpleInput__NameAssignment_3 )
            // InternalBot.g:5351:3: rule__SimpleInput__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__3__Impl"


    // $ANTLR start "rule__SimpleInput__Group__4"
    // InternalBot.g:5359:1: rule__SimpleInput__Group__4 : rule__SimpleInput__Group__4__Impl ;
    public final void rule__SimpleInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5363:1: ( rule__SimpleInput__Group__4__Impl )
            // InternalBot.g:5364:2: rule__SimpleInput__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__4"


    // $ANTLR start "rule__SimpleInput__Group__4__Impl"
    // InternalBot.g:5370:1: rule__SimpleInput__Group__4__Impl : ( ( rule__SimpleInput__Group_4__0 )? ) ;
    public final void rule__SimpleInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5374:1: ( ( ( rule__SimpleInput__Group_4__0 )? ) )
            // InternalBot.g:5375:1: ( ( rule__SimpleInput__Group_4__0 )? )
            {
            // InternalBot.g:5375:1: ( ( rule__SimpleInput__Group_4__0 )? )
            // InternalBot.g:5376:2: ( rule__SimpleInput__Group_4__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_4()); 
            // InternalBot.g:5377:2: ( rule__SimpleInput__Group_4__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==81) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBot.g:5377:3: rule__SimpleInput__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleInput__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleInputAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group__4__Impl"


    // $ANTLR start "rule__SimpleInput__Group_4__0"
    // InternalBot.g:5386:1: rule__SimpleInput__Group_4__0 : rule__SimpleInput__Group_4__0__Impl rule__SimpleInput__Group_4__1 ;
    public final void rule__SimpleInput__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5390:1: ( rule__SimpleInput__Group_4__0__Impl rule__SimpleInput__Group_4__1 )
            // InternalBot.g:5391:2: rule__SimpleInput__Group_4__0__Impl rule__SimpleInput__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4__0"


    // $ANTLR start "rule__SimpleInput__Group_4__0__Impl"
    // InternalBot.g:5398:1: rule__SimpleInput__Group_4__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5402:1: ( ( 'synonyms' ) )
            // InternalBot.g:5403:1: ( 'synonyms' )
            {
            // InternalBot.g:5403:1: ( 'synonyms' )
            // InternalBot.g:5404:2: 'synonyms'
            {
             before(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_4_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group_4__1"
    // InternalBot.g:5413:1: rule__SimpleInput__Group_4__1 : rule__SimpleInput__Group_4__1__Impl rule__SimpleInput__Group_4__2 ;
    public final void rule__SimpleInput__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5417:1: ( rule__SimpleInput__Group_4__1__Impl rule__SimpleInput__Group_4__2 )
            // InternalBot.g:5418:2: rule__SimpleInput__Group_4__1__Impl rule__SimpleInput__Group_4__2
            {
            pushFollow(FOLLOW_42);
            rule__SimpleInput__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4__1"


    // $ANTLR start "rule__SimpleInput__Group_4__1__Impl"
    // InternalBot.g:5425:1: rule__SimpleInput__Group_4__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_4_1 ) ) ;
    public final void rule__SimpleInput__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5429:1: ( ( ( rule__SimpleInput__ValuesAssignment_4_1 ) ) )
            // InternalBot.g:5430:1: ( ( rule__SimpleInput__ValuesAssignment_4_1 ) )
            {
            // InternalBot.g:5430:1: ( ( rule__SimpleInput__ValuesAssignment_4_1 ) )
            // InternalBot.g:5431:2: ( rule__SimpleInput__ValuesAssignment_4_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_4_1()); 
            // InternalBot.g:5432:2: ( rule__SimpleInput__ValuesAssignment_4_1 )
            // InternalBot.g:5432:3: rule__SimpleInput__ValuesAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__ValuesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getValuesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group_4__2"
    // InternalBot.g:5440:1: rule__SimpleInput__Group_4__2 : rule__SimpleInput__Group_4__2__Impl ;
    public final void rule__SimpleInput__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5444:1: ( rule__SimpleInput__Group_4__2__Impl )
            // InternalBot.g:5445:2: rule__SimpleInput__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4__2"


    // $ANTLR start "rule__SimpleInput__Group_4__2__Impl"
    // InternalBot.g:5451:1: rule__SimpleInput__Group_4__2__Impl : ( ( rule__SimpleInput__Group_4_2__0 )* ) ;
    public final void rule__SimpleInput__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5455:1: ( ( ( rule__SimpleInput__Group_4_2__0 )* ) )
            // InternalBot.g:5456:1: ( ( rule__SimpleInput__Group_4_2__0 )* )
            {
            // InternalBot.g:5456:1: ( ( rule__SimpleInput__Group_4_2__0 )* )
            // InternalBot.g:5457:2: ( rule__SimpleInput__Group_4_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_4_2()); 
            // InternalBot.g:5458:2: ( rule__SimpleInput__Group_4_2__0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==54) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBot.g:5458:3: rule__SimpleInput__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__SimpleInput__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getSimpleInputAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4__2__Impl"


    // $ANTLR start "rule__SimpleInput__Group_4_2__0"
    // InternalBot.g:5467:1: rule__SimpleInput__Group_4_2__0 : rule__SimpleInput__Group_4_2__0__Impl rule__SimpleInput__Group_4_2__1 ;
    public final void rule__SimpleInput__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5471:1: ( rule__SimpleInput__Group_4_2__0__Impl rule__SimpleInput__Group_4_2__1 )
            // InternalBot.g:5472:2: rule__SimpleInput__Group_4_2__0__Impl rule__SimpleInput__Group_4_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4_2__0"


    // $ANTLR start "rule__SimpleInput__Group_4_2__0__Impl"
    // InternalBot.g:5479:1: rule__SimpleInput__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5483:1: ( ( ',' ) )
            // InternalBot.g:5484:1: ( ',' )
            {
            // InternalBot.g:5484:1: ( ',' )
            // InternalBot.g:5485:2: ','
            {
             before(grammarAccess.getSimpleInputAccess().getCommaKeyword_4_2_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4_2__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group_4_2__1"
    // InternalBot.g:5494:1: rule__SimpleInput__Group_4_2__1 : rule__SimpleInput__Group_4_2__1__Impl ;
    public final void rule__SimpleInput__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5498:1: ( rule__SimpleInput__Group_4_2__1__Impl )
            // InternalBot.g:5499:2: rule__SimpleInput__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4_2__1"


    // $ANTLR start "rule__SimpleInput__Group_4_2__1__Impl"
    // InternalBot.g:5505:1: rule__SimpleInput__Group_4_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_4_2_1 ) ) ;
    public final void rule__SimpleInput__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5509:1: ( ( ( rule__SimpleInput__ValuesAssignment_4_2_1 ) ) )
            // InternalBot.g:5510:1: ( ( rule__SimpleInput__ValuesAssignment_4_2_1 ) )
            {
            // InternalBot.g:5510:1: ( ( rule__SimpleInput__ValuesAssignment_4_2_1 ) )
            // InternalBot.g:5511:2: ( rule__SimpleInput__ValuesAssignment_4_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_4_2_1()); 
            // InternalBot.g:5512:2: ( rule__SimpleInput__ValuesAssignment_4_2_1 )
            // InternalBot.g:5512:3: rule__SimpleInput__ValuesAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__ValuesAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getValuesAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_4_2__1__Impl"


    // $ANTLR start "rule__Text__Group__0"
    // InternalBot.g:5521:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5525:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:5526:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__Text__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__0"


    // $ANTLR start "rule__Text__Group__0__Impl"
    // InternalBot.g:5533:1: rule__Text__Group__0__Impl : ( 'text' ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5537:1: ( ( 'text' ) )
            // InternalBot.g:5538:1: ( 'text' )
            {
            // InternalBot.g:5538:1: ( 'text' )
            // InternalBot.g:5539:2: 'text'
            {
             before(grammarAccess.getTextAccess().getTextKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getTextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__0__Impl"


    // $ANTLR start "rule__Text__Group__1"
    // InternalBot.g:5548:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5552:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:5553:2: rule__Text__Group__1__Impl rule__Text__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Text__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__1"


    // $ANTLR start "rule__Text__Group__1__Impl"
    // InternalBot.g:5560:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5564:1: ( ( 'response' ) )
            // InternalBot.g:5565:1: ( 'response' )
            {
            // InternalBot.g:5565:1: ( 'response' )
            // InternalBot.g:5566:2: 'response'
            {
             before(grammarAccess.getTextAccess().getResponseKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getResponseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__1__Impl"


    // $ANTLR start "rule__Text__Group__2"
    // InternalBot.g:5575:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5579:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:5580:2: rule__Text__Group__2__Impl rule__Text__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Text__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__2"


    // $ANTLR start "rule__Text__Group__2__Impl"
    // InternalBot.g:5587:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5591:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:5592:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:5592:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:5593:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:5594:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:5594:3: rule__Text__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Text__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__2__Impl"


    // $ANTLR start "rule__Text__Group__3"
    // InternalBot.g:5602:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5606:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:5607:2: rule__Text__Group__3__Impl rule__Text__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__Text__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__3"


    // $ANTLR start "rule__Text__Group__3__Impl"
    // InternalBot.g:5614:1: rule__Text__Group__3__Impl : ( ':' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5618:1: ( ( ':' ) )
            // InternalBot.g:5619:1: ( ':' )
            {
            // InternalBot.g:5619:1: ( ':' )
            // InternalBot.g:5620:2: ':'
            {
             before(grammarAccess.getTextAccess().getColonKeyword_3()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTextAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__3__Impl"


    // $ANTLR start "rule__Text__Group__4"
    // InternalBot.g:5629:1: rule__Text__Group__4 : rule__Text__Group__4__Impl ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5633:1: ( rule__Text__Group__4__Impl )
            // InternalBot.g:5634:2: rule__Text__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__4"


    // $ANTLR start "rule__Text__Group__4__Impl"
    // InternalBot.g:5640:1: rule__Text__Group__4__Impl : ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5644:1: ( ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5645:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5645:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            // InternalBot.g:5646:2: ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* )
            {
            // InternalBot.g:5646:2: ( ( rule__Text__InputsAssignment_4 ) )
            // InternalBot.g:5647:3: ( rule__Text__InputsAssignment_4 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:5648:3: ( rule__Text__InputsAssignment_4 )
            // InternalBot.g:5648:4: rule__Text__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__Text__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5651:2: ( ( rule__Text__InputsAssignment_4 )* )
            // InternalBot.g:5652:3: ( rule__Text__InputsAssignment_4 )*
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:5653:3: ( rule__Text__InputsAssignment_4 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=60 && LA52_0<=61)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:5653:4: rule__Text__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__Text__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__4__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__0"
    // InternalBot.g:5663:1: rule__TextLanguageInput__Group__0 : rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 ;
    public final void rule__TextLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5667:1: ( rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 )
            // InternalBot.g:5668:2: rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__TextLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__0"


    // $ANTLR start "rule__TextLanguageInput__Group__0__Impl"
    // InternalBot.g:5675:1: rule__TextLanguageInput__Group__0__Impl : ( ( rule__TextLanguageInput__Group_0__0 )? ) ;
    public final void rule__TextLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5679:1: ( ( ( rule__TextLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5680:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5680:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            // InternalBot.g:5681:2: ( rule__TextLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5682:2: ( rule__TextLanguageInput__Group_0__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==60) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:5682:3: rule__TextLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__1"
    // InternalBot.g:5690:1: rule__TextLanguageInput__Group__1 : rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 ;
    public final void rule__TextLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5694:1: ( rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 )
            // InternalBot.g:5695:2: rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2
            {
            pushFollow(FOLLOW_61);
            rule__TextLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__1"


    // $ANTLR start "rule__TextLanguageInput__Group__1__Impl"
    // InternalBot.g:5702:1: rule__TextLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__TextLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5706:1: ( ( '{' ) )
            // InternalBot.g:5707:1: ( '{' )
            {
            // InternalBot.g:5707:1: ( '{' )
            // InternalBot.g:5708:2: '{'
            {
             before(grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__2"
    // InternalBot.g:5717:1: rule__TextLanguageInput__Group__2 : rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 ;
    public final void rule__TextLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5721:1: ( rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 )
            // InternalBot.g:5722:2: rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3
            {
            pushFollow(FOLLOW_26);
            rule__TextLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__2"


    // $ANTLR start "rule__TextLanguageInput__Group__2__Impl"
    // InternalBot.g:5729:1: rule__TextLanguageInput__Group__2__Impl : ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) ;
    public final void rule__TextLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5733:1: ( ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) )
            // InternalBot.g:5734:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            {
            // InternalBot.g:5734:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            // InternalBot.g:5735:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 
            // InternalBot.g:5736:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            // InternalBot.g:5736:3: rule__TextLanguageInput__InputsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__InputsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__3"
    // InternalBot.g:5744:1: rule__TextLanguageInput__Group__3 : rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 ;
    public final void rule__TextLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5748:1: ( rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 )
            // InternalBot.g:5749:2: rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__TextLanguageInput__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__3"


    // $ANTLR start "rule__TextLanguageInput__Group__3__Impl"
    // InternalBot.g:5756:1: rule__TextLanguageInput__Group__3__Impl : ( ( rule__TextLanguageInput__Group_3__0 )* ) ;
    public final void rule__TextLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5760:1: ( ( ( rule__TextLanguageInput__Group_3__0 )* ) )
            // InternalBot.g:5761:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            {
            // InternalBot.g:5761:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            // InternalBot.g:5762:2: ( rule__TextLanguageInput__Group_3__0 )*
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 
            // InternalBot.g:5763:2: ( rule__TextLanguageInput__Group_3__0 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==54) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:5763:3: rule__TextLanguageInput__Group_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TextLanguageInput__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

             after(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group__4"
    // InternalBot.g:5771:1: rule__TextLanguageInput__Group__4 : rule__TextLanguageInput__Group__4__Impl ;
    public final void rule__TextLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5775:1: ( rule__TextLanguageInput__Group__4__Impl )
            // InternalBot.g:5776:2: rule__TextLanguageInput__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__4"


    // $ANTLR start "rule__TextLanguageInput__Group__4__Impl"
    // InternalBot.g:5782:1: rule__TextLanguageInput__Group__4__Impl : ( '}' ) ;
    public final void rule__TextLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5786:1: ( ( '}' ) )
            // InternalBot.g:5787:1: ( '}' )
            {
            // InternalBot.g:5787:1: ( '}' )
            // InternalBot.g:5788:2: '}'
            {
             before(grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group__4__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0__0"
    // InternalBot.g:5798:1: rule__TextLanguageInput__Group_0__0 : rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 ;
    public final void rule__TextLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5802:1: ( rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 )
            // InternalBot.g:5803:2: rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_54);
            rule__TextLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0__0"


    // $ANTLR start "rule__TextLanguageInput__Group_0__0__Impl"
    // InternalBot.g:5810:1: rule__TextLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5814:1: ( ( 'inputs' ) )
            // InternalBot.g:5815:1: ( 'inputs' )
            {
            // InternalBot.g:5815:1: ( 'inputs' )
            // InternalBot.g:5816:2: 'inputs'
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0__1"
    // InternalBot.g:5825:1: rule__TextLanguageInput__Group_0__1 : rule__TextLanguageInput__Group_0__1__Impl ;
    public final void rule__TextLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5829:1: ( rule__TextLanguageInput__Group_0__1__Impl )
            // InternalBot.g:5830:2: rule__TextLanguageInput__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0__1"


    // $ANTLR start "rule__TextLanguageInput__Group_0__1__Impl"
    // InternalBot.g:5836:1: rule__TextLanguageInput__Group_0__1__Impl : ( ( rule__TextLanguageInput__Group_0_1__0 )? ) ;
    public final void rule__TextLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5840:1: ( ( ( rule__TextLanguageInput__Group_0_1__0 )? ) )
            // InternalBot.g:5841:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            {
            // InternalBot.g:5841:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            // InternalBot.g:5842:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 
            // InternalBot.g:5843:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==63) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:5843:3: rule__TextLanguageInput__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextLanguageInput__Group_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__0"
    // InternalBot.g:5852:1: rule__TextLanguageInput__Group_0_1__0 : rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 ;
    public final void rule__TextLanguageInput__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5856:1: ( rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 )
            // InternalBot.g:5857:2: rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TextLanguageInput__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__0"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__0__Impl"
    // InternalBot.g:5864:1: rule__TextLanguageInput__Group_0_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInput__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5868:1: ( ( 'in' ) )
            // InternalBot.g:5869:1: ( 'in' )
            {
            // InternalBot.g:5869:1: ( 'in' )
            // InternalBot.g:5870:2: 'in'
            {
             before(grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__1"
    // InternalBot.g:5879:1: rule__TextLanguageInput__Group_0_1__1 : rule__TextLanguageInput__Group_0_1__1__Impl ;
    public final void rule__TextLanguageInput__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5883:1: ( rule__TextLanguageInput__Group_0_1__1__Impl )
            // InternalBot.g:5884:2: rule__TextLanguageInput__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__1"


    // $ANTLR start "rule__TextLanguageInput__Group_0_1__1__Impl"
    // InternalBot.g:5890:1: rule__TextLanguageInput__Group_0_1__1__Impl : ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) ;
    public final void rule__TextLanguageInput__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5894:1: ( ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) )
            // InternalBot.g:5895:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            {
            // InternalBot.g:5895:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            // InternalBot.g:5896:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 
            // InternalBot.g:5897:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            // InternalBot.g:5897:3: rule__TextLanguageInput__LanguageAssignment_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__LanguageAssignment_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_0_1__1__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_3__0"
    // InternalBot.g:5906:1: rule__TextLanguageInput__Group_3__0 : rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 ;
    public final void rule__TextLanguageInput__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5910:1: ( rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 )
            // InternalBot.g:5911:2: rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1
            {
            pushFollow(FOLLOW_61);
            rule__TextLanguageInput__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_3__0"


    // $ANTLR start "rule__TextLanguageInput__Group_3__0__Impl"
    // InternalBot.g:5918:1: rule__TextLanguageInput__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInput__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5922:1: ( ( ',' ) )
            // InternalBot.g:5923:1: ( ',' )
            {
            // InternalBot.g:5923:1: ( ',' )
            // InternalBot.g:5924:2: ','
            {
             before(grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_3__0__Impl"


    // $ANTLR start "rule__TextLanguageInput__Group_3__1"
    // InternalBot.g:5933:1: rule__TextLanguageInput__Group_3__1 : rule__TextLanguageInput__Group_3__1__Impl ;
    public final void rule__TextLanguageInput__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5937:1: ( rule__TextLanguageInput__Group_3__1__Impl )
            // InternalBot.g:5938:2: rule__TextLanguageInput__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_3__1"


    // $ANTLR start "rule__TextLanguageInput__Group_3__1__Impl"
    // InternalBot.g:5944:1: rule__TextLanguageInput__Group_3__1__Impl : ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) ;
    public final void rule__TextLanguageInput__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5948:1: ( ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) )
            // InternalBot.g:5949:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            {
            // InternalBot.g:5949:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            // InternalBot.g:5950:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 
            // InternalBot.g:5951:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            // InternalBot.g:5951:3: rule__TextLanguageInput__InputsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInput__InputsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__Group_3__1__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__0"
    // InternalBot.g:5960:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5964:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:5965:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__0"


    // $ANTLR start "rule__HTTPResponse__Group__0__Impl"
    // InternalBot.g:5972:1: rule__HTTPResponse__Group__0__Impl : ( 'HttpResponse' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5976:1: ( ( 'HttpResponse' ) )
            // InternalBot.g:5977:1: ( 'HttpResponse' )
            {
            // InternalBot.g:5977:1: ( 'HttpResponse' )
            // InternalBot.g:5978:2: 'HttpResponse'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__0__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__1"
    // InternalBot.g:5987:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5991:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:5992:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__HTTPResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__1"


    // $ANTLR start "rule__HTTPResponse__Group__1__Impl"
    // InternalBot.g:5999:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6003:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:6004:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:6004:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:6005:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:6006:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:6006:3: rule__HTTPResponse__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__1__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__2"
    // InternalBot.g:6014:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6018:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:6019:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
            {
            pushFollow(FOLLOW_62);
            rule__HTTPResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__2"


    // $ANTLR start "rule__HTTPResponse__Group__2__Impl"
    // InternalBot.g:6026:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6030:1: ( ( ':' ) )
            // InternalBot.g:6031:1: ( ':' )
            {
            // InternalBot.g:6031:1: ( ':' )
            // InternalBot.g:6032:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__2__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__3"
    // InternalBot.g:6041:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6045:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:6046:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__HTTPResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__3"


    // $ANTLR start "rule__HTTPResponse__Group__3__Impl"
    // InternalBot.g:6053:1: rule__HTTPResponse__Group__3__Impl : ( 'HttpRequest:' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6057:1: ( ( 'HttpRequest:' ) )
            // InternalBot.g:6058:1: ( 'HttpRequest:' )
            {
            // InternalBot.g:6058:1: ( 'HttpRequest:' )
            // InternalBot.g:6059:2: 'HttpRequest:'
            {
             before(grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__3__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__4"
    // InternalBot.g:6068:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6072:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:6073:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__HTTPResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__4"


    // $ANTLR start "rule__HTTPResponse__Group__4__Impl"
    // InternalBot.g:6080:1: rule__HTTPResponse__Group__4__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6084:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) ) )
            // InternalBot.g:6085:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            {
            // InternalBot.g:6085:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_4 ) )
            // InternalBot.g:6086:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_4()); 
            // InternalBot.g:6087:2: ( rule__HTTPResponse__HTTPRequestAssignment_4 )
            // InternalBot.g:6087:3: rule__HTTPResponse__HTTPRequestAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__HTTPRequestAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__4__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__5"
    // InternalBot.g:6095:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6099:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:6100:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
            {
            pushFollow(FOLLOW_63);
            rule__HTTPResponse__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__5"


    // $ANTLR start "rule__HTTPResponse__Group__5__Impl"
    // InternalBot.g:6107:1: rule__HTTPResponse__Group__5__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6111:1: ( ( ';' ) )
            // InternalBot.g:6112:1: ( ';' )
            {
            // InternalBot.g:6112:1: ( ';' )
            // InternalBot.g:6113:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__5__Impl"


    // $ANTLR start "rule__HTTPResponse__Group__6"
    // InternalBot.g:6122:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6126:1: ( rule__HTTPResponse__Group__6__Impl )
            // InternalBot.g:6127:2: rule__HTTPResponse__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__6"


    // $ANTLR start "rule__HTTPResponse__Group__6__Impl"
    // InternalBot.g:6133:1: rule__HTTPResponse__Group__6__Impl : ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6137:1: ( ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) ) )
            // InternalBot.g:6138:1: ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) )
            {
            // InternalBot.g:6138:1: ( ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* ) )
            // InternalBot.g:6139:2: ( ( rule__HTTPResponse__InputsAssignment_6 ) ) ( ( rule__HTTPResponse__InputsAssignment_6 )* )
            {
            // InternalBot.g:6139:2: ( ( rule__HTTPResponse__InputsAssignment_6 ) )
            // InternalBot.g:6140:3: ( rule__HTTPResponse__InputsAssignment_6 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 
            // InternalBot.g:6141:3: ( rule__HTTPResponse__InputsAssignment_6 )
            // InternalBot.g:6141:4: rule__HTTPResponse__InputsAssignment_6
            {
            pushFollow(FOLLOW_23);
            rule__HTTPResponse__InputsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 

            }

            // InternalBot.g:6144:2: ( ( rule__HTTPResponse__InputsAssignment_6 )* )
            // InternalBot.g:6145:3: ( rule__HTTPResponse__InputsAssignment_6 )*
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 
            // InternalBot.g:6146:3: ( rule__HTTPResponse__InputsAssignment_6 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==60) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBot.g:6146:4: rule__HTTPResponse__InputsAssignment_6
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__HTTPResponse__InputsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_6()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__Group__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__0"
    // InternalBot.g:6156:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6160:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:6161:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
            {
            pushFollow(FOLLOW_64);
            rule__HTTPRequest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__0"


    // $ANTLR start "rule__HTTPRequest__Group__0__Impl"
    // InternalBot.g:6168:1: rule__HTTPRequest__Group__0__Impl : ( 'HTTP' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6172:1: ( ( 'HTTP' ) )
            // InternalBot.g:6173:1: ( 'HTTP' )
            {
            // InternalBot.g:6173:1: ( 'HTTP' )
            // InternalBot.g:6174:2: 'HTTP'
            {
             before(grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__1"
    // InternalBot.g:6183:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6187:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:6188:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
            {
            pushFollow(FOLLOW_65);
            rule__HTTPRequest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__1"


    // $ANTLR start "rule__HTTPRequest__Group__1__Impl"
    // InternalBot.g:6195:1: rule__HTTPRequest__Group__1__Impl : ( 'request' ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6199:1: ( ( 'request' ) )
            // InternalBot.g:6200:1: ( 'request' )
            {
            // InternalBot.g:6200:1: ( 'request' )
            // InternalBot.g:6201:2: 'request'
            {
             before(grammarAccess.getHTTPRequestAccess().getRequestKeyword_1()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getRequestKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__2"
    // InternalBot.g:6210:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6214:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:6215:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__2"


    // $ANTLR start "rule__HTTPRequest__Group__2__Impl"
    // InternalBot.g:6222:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__MethodAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6226:1: ( ( ( rule__HTTPRequest__MethodAssignment_2 ) ) )
            // InternalBot.g:6227:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            {
            // InternalBot.g:6227:1: ( ( rule__HTTPRequest__MethodAssignment_2 ) )
            // InternalBot.g:6228:2: ( rule__HTTPRequest__MethodAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_2()); 
            // InternalBot.g:6229:2: ( rule__HTTPRequest__MethodAssignment_2 )
            // InternalBot.g:6229:3: rule__HTTPRequest__MethodAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__MethodAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getMethodAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__3"
    // InternalBot.g:6237:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6241:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:6242:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
            {
            pushFollow(FOLLOW_10);
            rule__HTTPRequest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__3"


    // $ANTLR start "rule__HTTPRequest__Group__3__Impl"
    // InternalBot.g:6249:1: rule__HTTPRequest__Group__3__Impl : ( ( rule__HTTPRequest__NameAssignment_3 ) ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6253:1: ( ( ( rule__HTTPRequest__NameAssignment_3 ) ) )
            // InternalBot.g:6254:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            {
            // InternalBot.g:6254:1: ( ( rule__HTTPRequest__NameAssignment_3 ) )
            // InternalBot.g:6255:2: ( rule__HTTPRequest__NameAssignment_3 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_3()); 
            // InternalBot.g:6256:2: ( rule__HTTPRequest__NameAssignment_3 )
            // InternalBot.g:6256:3: rule__HTTPRequest__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__4"
    // InternalBot.g:6264:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6268:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:6269:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
            {
            pushFollow(FOLLOW_66);
            rule__HTTPRequest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__4"


    // $ANTLR start "rule__HTTPRequest__Group__4__Impl"
    // InternalBot.g:6276:1: rule__HTTPRequest__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6280:1: ( ( ':' ) )
            // InternalBot.g:6281:1: ( ':' )
            {
            // InternalBot.g:6281:1: ( ':' )
            // InternalBot.g:6282:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__5"
    // InternalBot.g:6291:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6295:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:6296:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__HTTPRequest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__5"


    // $ANTLR start "rule__HTTPRequest__Group__5__Impl"
    // InternalBot.g:6303:1: rule__HTTPRequest__Group__5__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6307:1: ( ( 'URL' ) )
            // InternalBot.g:6308:1: ( 'URL' )
            {
            // InternalBot.g:6308:1: ( 'URL' )
            // InternalBot.g:6309:2: 'URL'
            {
             before(grammarAccess.getHTTPRequestAccess().getURLKeyword_5()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getURLKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__5__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__6"
    // InternalBot.g:6318:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6322:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:6323:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__6"


    // $ANTLR start "rule__HTTPRequest__Group__6__Impl"
    // InternalBot.g:6330:1: rule__HTTPRequest__Group__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6334:1: ( ( ':' ) )
            // InternalBot.g:6335:1: ( ':' )
            {
            // InternalBot.g:6335:1: ( ':' )
            // InternalBot.g:6336:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_6()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__7"
    // InternalBot.g:6345:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6349:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:6350:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
            {
            pushFollow(FOLLOW_20);
            rule__HTTPRequest__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__7"


    // $ANTLR start "rule__HTTPRequest__Group__7__Impl"
    // InternalBot.g:6357:1: rule__HTTPRequest__Group__7__Impl : ( ( rule__HTTPRequest__URLAssignment_7 ) ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6361:1: ( ( ( rule__HTTPRequest__URLAssignment_7 ) ) )
            // InternalBot.g:6362:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            {
            // InternalBot.g:6362:1: ( ( rule__HTTPRequest__URLAssignment_7 ) )
            // InternalBot.g:6363:2: ( rule__HTTPRequest__URLAssignment_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_7()); 
            // InternalBot.g:6364:2: ( rule__HTTPRequest__URLAssignment_7 )
            // InternalBot.g:6364:3: rule__HTTPRequest__URLAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__URLAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getURLAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__7__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__8"
    // InternalBot.g:6372:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6376:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:6377:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
            {
            pushFollow(FOLLOW_67);
            rule__HTTPRequest__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__8"


    // $ANTLR start "rule__HTTPRequest__Group__8__Impl"
    // InternalBot.g:6384:1: rule__HTTPRequest__Group__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6388:1: ( ( ';' ) )
            // InternalBot.g:6389:1: ( ';' )
            {
            // InternalBot.g:6389:1: ( ';' )
            // InternalBot.g:6390:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__8__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__9"
    // InternalBot.g:6399:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6403:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:6404:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
            {
            pushFollow(FOLLOW_67);
            rule__HTTPRequest__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__9"


    // $ANTLR start "rule__HTTPRequest__Group__9__Impl"
    // InternalBot.g:6411:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6415:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:6416:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:6416:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:6417:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:6418:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==88) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalBot.g:6418:3: rule__HTTPRequest__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__9__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__10"
    // InternalBot.g:6426:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6430:1: ( rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11 )
            // InternalBot.g:6431:2: rule__HTTPRequest__Group__10__Impl rule__HTTPRequest__Group__11
            {
            pushFollow(FOLLOW_67);
            rule__HTTPRequest__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__10"


    // $ANTLR start "rule__HTTPRequest__Group__10__Impl"
    // InternalBot.g:6438:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6442:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:6443:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:6443:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:6444:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:6445:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==89) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:6445:3: rule__HTTPRequest__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__10__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__11"
    // InternalBot.g:6453:1: rule__HTTPRequest__Group__11 : rule__HTTPRequest__Group__11__Impl ;
    public final void rule__HTTPRequest__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6457:1: ( rule__HTTPRequest__Group__11__Impl )
            // InternalBot.g:6458:2: rule__HTTPRequest__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__11"


    // $ANTLR start "rule__HTTPRequest__Group__11__Impl"
    // InternalBot.g:6464:1: rule__HTTPRequest__Group__11__Impl : ( ( rule__HTTPRequest__Group_11__0 )? ) ;
    public final void rule__HTTPRequest__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6468:1: ( ( ( rule__HTTPRequest__Group_11__0 )? ) )
            // InternalBot.g:6469:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            {
            // InternalBot.g:6469:1: ( ( rule__HTTPRequest__Group_11__0 )? )
            // InternalBot.g:6470:2: ( rule__HTTPRequest__Group_11__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11()); 
            // InternalBot.g:6471:2: ( rule__HTTPRequest__Group_11__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==18) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalBot.g:6471:3: rule__HTTPRequest__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group__11__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__0"
    // InternalBot.g:6480:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6484:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:6485:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
            {
            pushFollow(FOLLOW_10);
            rule__HTTPRequest__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__0"


    // $ANTLR start "rule__HTTPRequest__Group_9__0__Impl"
    // InternalBot.g:6492:1: rule__HTTPRequest__Group_9__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6496:1: ( ( 'basicAuth' ) )
            // InternalBot.g:6497:1: ( 'basicAuth' )
            {
            // InternalBot.g:6497:1: ( 'basicAuth' )
            // InternalBot.g:6498:2: 'basicAuth'
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__1"
    // InternalBot.g:6507:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6511:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:6512:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__1"


    // $ANTLR start "rule__HTTPRequest__Group_9__1__Impl"
    // InternalBot.g:6519:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6523:1: ( ( ':' ) )
            // InternalBot.g:6524:1: ( ':' )
            {
            // InternalBot.g:6524:1: ( ':' )
            // InternalBot.g:6525:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__2"
    // InternalBot.g:6534:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6538:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:6539:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
            {
            pushFollow(FOLLOW_20);
            rule__HTTPRequest__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__2"


    // $ANTLR start "rule__HTTPRequest__Group_9__2__Impl"
    // InternalBot.g:6546:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6550:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) ) )
            // InternalBot.g:6551:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            {
            // InternalBot.g:6551:1: ( ( rule__HTTPRequest__BasicAuthAssignment_9_2 ) )
            // InternalBot.g:6552:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_9_2()); 
            // InternalBot.g:6553:2: ( rule__HTTPRequest__BasicAuthAssignment_9_2 )
            // InternalBot.g:6553:3: rule__HTTPRequest__BasicAuthAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__BasicAuthAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__3"
    // InternalBot.g:6561:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6565:1: ( rule__HTTPRequest__Group_9__3__Impl )
            // InternalBot.g:6566:2: rule__HTTPRequest__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__3"


    // $ANTLR start "rule__HTTPRequest__Group_9__3__Impl"
    // InternalBot.g:6572:1: rule__HTTPRequest__Group_9__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6576:1: ( ( ';' ) )
            // InternalBot.g:6577:1: ( ';' )
            {
            // InternalBot.g:6577:1: ( ';' )
            // InternalBot.g:6578:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__0"
    // InternalBot.g:6588:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6592:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:6593:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
            {
            pushFollow(FOLLOW_10);
            rule__HTTPRequest__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__0"


    // $ANTLR start "rule__HTTPRequest__Group_10__0__Impl"
    // InternalBot.g:6600:1: rule__HTTPRequest__Group_10__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6604:1: ( ( 'headers' ) )
            // InternalBot.g:6605:1: ( 'headers' )
            {
            // InternalBot.g:6605:1: ( 'headers' )
            // InternalBot.g:6606:2: 'headers'
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__1"
    // InternalBot.g:6615:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6619:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:6620:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__1"


    // $ANTLR start "rule__HTTPRequest__Group_10__1__Impl"
    // InternalBot.g:6627:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6631:1: ( ( ':' ) )
            // InternalBot.g:6632:1: ( ':' )
            {
            // InternalBot.g:6632:1: ( ':' )
            // InternalBot.g:6633:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__2"
    // InternalBot.g:6642:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6646:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:6647:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
            {
            pushFollow(FOLLOW_37);
            rule__HTTPRequest__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__2"


    // $ANTLR start "rule__HTTPRequest__Group_10__2__Impl"
    // InternalBot.g:6654:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6658:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) ) )
            // InternalBot.g:6659:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            {
            // InternalBot.g:6659:1: ( ( rule__HTTPRequest__HeadersAssignment_10_2 ) )
            // InternalBot.g:6660:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_2()); 
            // InternalBot.g:6661:2: ( rule__HTTPRequest__HeadersAssignment_10_2 )
            // InternalBot.g:6661:3: rule__HTTPRequest__HeadersAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__HeadersAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__3"
    // InternalBot.g:6669:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6673:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:6674:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
            {
            pushFollow(FOLLOW_37);
            rule__HTTPRequest__Group_10__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__3"


    // $ANTLR start "rule__HTTPRequest__Group_10__3__Impl"
    // InternalBot.g:6681:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6685:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:6686:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:6686:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:6687:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:6688:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==54) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBot.g:6688:3: rule__HTTPRequest__Group_10_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HTTPRequest__Group_10_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

             after(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__4"
    // InternalBot.g:6696:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6700:1: ( rule__HTTPRequest__Group_10__4__Impl )
            // InternalBot.g:6701:2: rule__HTTPRequest__Group_10__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__4"


    // $ANTLR start "rule__HTTPRequest__Group_10__4__Impl"
    // InternalBot.g:6707:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6711:1: ( ( ';' ) )
            // InternalBot.g:6712:1: ( ';' )
            {
            // InternalBot.g:6712:1: ( ';' )
            // InternalBot.g:6713:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__0"
    // InternalBot.g:6723:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6727:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:6728:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_10_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__0"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__0__Impl"
    // InternalBot.g:6735:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6739:1: ( ( ',' ) )
            // InternalBot.g:6740:1: ( ',' )
            {
            // InternalBot.g:6740:1: ( ',' )
            // InternalBot.g:6741:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__1"
    // InternalBot.g:6750:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6754:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:6755:2: rule__HTTPRequest__Group_10_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__1"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__1__Impl"
    // InternalBot.g:6761:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6765:1: ( ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) ) )
            // InternalBot.g:6766:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            {
            // InternalBot.g:6766:1: ( ( rule__HTTPRequest__HeadersAssignment_10_3_1 ) )
            // InternalBot.g:6767:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_3_1()); 
            // InternalBot.g:6768:2: ( rule__HTTPRequest__HeadersAssignment_10_3_1 )
            // InternalBot.g:6768:3: rule__HTTPRequest__HeadersAssignment_10_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__HeadersAssignment_10_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_10_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10_3__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__0"
    // InternalBot.g:6777:1: rule__HTTPRequest__Group_11__0 : rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 ;
    public final void rule__HTTPRequest__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6781:1: ( rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1 )
            // InternalBot.g:6782:2: rule__HTTPRequest__Group_11__0__Impl rule__HTTPRequest__Group_11__1
            {
            pushFollow(FOLLOW_10);
            rule__HTTPRequest__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__0"


    // $ANTLR start "rule__HTTPRequest__Group_11__0__Impl"
    // InternalBot.g:6789:1: rule__HTTPRequest__Group_11__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6793:1: ( ( 'data' ) )
            // InternalBot.g:6794:1: ( 'data' )
            {
            // InternalBot.g:6794:1: ( 'data' )
            // InternalBot.g:6795:2: 'data'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__1"
    // InternalBot.g:6804:1: rule__HTTPRequest__Group_11__1 : rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 ;
    public final void rule__HTTPRequest__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6808:1: ( rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2 )
            // InternalBot.g:6809:2: rule__HTTPRequest__Group_11__1__Impl rule__HTTPRequest__Group_11__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__1"


    // $ANTLR start "rule__HTTPRequest__Group_11__1__Impl"
    // InternalBot.g:6816:1: rule__HTTPRequest__Group_11__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6820:1: ( ( ':' ) )
            // InternalBot.g:6821:1: ( ':' )
            {
            // InternalBot.g:6821:1: ( ':' )
            // InternalBot.g:6822:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__2"
    // InternalBot.g:6831:1: rule__HTTPRequest__Group_11__2 : rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 ;
    public final void rule__HTTPRequest__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6835:1: ( rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3 )
            // InternalBot.g:6836:2: rule__HTTPRequest__Group_11__2__Impl rule__HTTPRequest__Group_11__3
            {
            pushFollow(FOLLOW_37);
            rule__HTTPRequest__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__2"


    // $ANTLR start "rule__HTTPRequest__Group_11__2__Impl"
    // InternalBot.g:6843:1: rule__HTTPRequest__Group_11__2__Impl : ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) ;
    public final void rule__HTTPRequest__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6847:1: ( ( ( rule__HTTPRequest__DataAssignment_11_2 ) ) )
            // InternalBot.g:6848:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            {
            // InternalBot.g:6848:1: ( ( rule__HTTPRequest__DataAssignment_11_2 ) )
            // InternalBot.g:6849:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_2()); 
            // InternalBot.g:6850:2: ( rule__HTTPRequest__DataAssignment_11_2 )
            // InternalBot.g:6850:3: rule__HTTPRequest__DataAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__3"
    // InternalBot.g:6858:1: rule__HTTPRequest__Group_11__3 : rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 ;
    public final void rule__HTTPRequest__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6862:1: ( rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4 )
            // InternalBot.g:6863:2: rule__HTTPRequest__Group_11__3__Impl rule__HTTPRequest__Group_11__4
            {
            pushFollow(FOLLOW_37);
            rule__HTTPRequest__Group_11__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__3"


    // $ANTLR start "rule__HTTPRequest__Group_11__3__Impl"
    // InternalBot.g:6870:1: rule__HTTPRequest__Group_11__3__Impl : ( ( rule__HTTPRequest__Group_11_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6874:1: ( ( ( rule__HTTPRequest__Group_11_3__0 )* ) )
            // InternalBot.g:6875:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            {
            // InternalBot.g:6875:1: ( ( rule__HTTPRequest__Group_11_3__0 )* )
            // InternalBot.g:6876:2: ( rule__HTTPRequest__Group_11_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_11_3()); 
            // InternalBot.g:6877:2: ( rule__HTTPRequest__Group_11_3__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==54) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBot.g:6877:3: rule__HTTPRequest__Group_11_3__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__HTTPRequest__Group_11_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getHTTPRequestAccess().getGroup_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__4"
    // InternalBot.g:6885:1: rule__HTTPRequest__Group_11__4 : rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 ;
    public final void rule__HTTPRequest__Group_11__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6889:1: ( rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5 )
            // InternalBot.g:6890:2: rule__HTTPRequest__Group_11__4__Impl rule__HTTPRequest__Group_11__5
            {
            pushFollow(FOLLOW_68);
            rule__HTTPRequest__Group_11__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__4"


    // $ANTLR start "rule__HTTPRequest__Group_11__4__Impl"
    // InternalBot.g:6897:1: rule__HTTPRequest__Group_11__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6901:1: ( ( ';' ) )
            // InternalBot.g:6902:1: ( ';' )
            {
            // InternalBot.g:6902:1: ( ';' )
            // InternalBot.g:6903:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__5"
    // InternalBot.g:6912:1: rule__HTTPRequest__Group_11__5 : rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 ;
    public final void rule__HTTPRequest__Group_11__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6916:1: ( rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6 )
            // InternalBot.g:6917:2: rule__HTTPRequest__Group_11__5__Impl rule__HTTPRequest__Group_11__6
            {
            pushFollow(FOLLOW_10);
            rule__HTTPRequest__Group_11__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__5"


    // $ANTLR start "rule__HTTPRequest__Group_11__5__Impl"
    // InternalBot.g:6924:1: rule__HTTPRequest__Group_11__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_11__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6928:1: ( ( 'dataType' ) )
            // InternalBot.g:6929:1: ( 'dataType' )
            {
            // InternalBot.g:6929:1: ( 'dataType' )
            // InternalBot.g:6930:2: 'dataType'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__5__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__6"
    // InternalBot.g:6939:1: rule__HTTPRequest__Group_11__6 : rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 ;
    public final void rule__HTTPRequest__Group_11__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6943:1: ( rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7 )
            // InternalBot.g:6944:2: rule__HTTPRequest__Group_11__6__Impl rule__HTTPRequest__Group_11__7
            {
            pushFollow(FOLLOW_69);
            rule__HTTPRequest__Group_11__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__6"


    // $ANTLR start "rule__HTTPRequest__Group_11__6__Impl"
    // InternalBot.g:6951:1: rule__HTTPRequest__Group_11__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_11__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6955:1: ( ( ':' ) )
            // InternalBot.g:6956:1: ( ':' )
            {
            // InternalBot.g:6956:1: ( ':' )
            // InternalBot.g:6957:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__7"
    // InternalBot.g:6966:1: rule__HTTPRequest__Group_11__7 : rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 ;
    public final void rule__HTTPRequest__Group_11__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6970:1: ( rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8 )
            // InternalBot.g:6971:2: rule__HTTPRequest__Group_11__7__Impl rule__HTTPRequest__Group_11__8
            {
            pushFollow(FOLLOW_20);
            rule__HTTPRequest__Group_11__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__7"


    // $ANTLR start "rule__HTTPRequest__Group_11__7__Impl"
    // InternalBot.g:6978:1: rule__HTTPRequest__Group_11__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) ;
    public final void rule__HTTPRequest__Group_11__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6982:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) ) )
            // InternalBot.g:6983:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            {
            // InternalBot.g:6983:1: ( ( rule__HTTPRequest__DataTypeAssignment_11_7 ) )
            // InternalBot.g:6984:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_11_7()); 
            // InternalBot.g:6985:2: ( rule__HTTPRequest__DataTypeAssignment_11_7 )
            // InternalBot.g:6985:3: rule__HTTPRequest__DataTypeAssignment_11_7
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataTypeAssignment_11_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_11_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__7__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11__8"
    // InternalBot.g:6993:1: rule__HTTPRequest__Group_11__8 : rule__HTTPRequest__Group_11__8__Impl ;
    public final void rule__HTTPRequest__Group_11__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6997:1: ( rule__HTTPRequest__Group_11__8__Impl )
            // InternalBot.g:6998:2: rule__HTTPRequest__Group_11__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__8"


    // $ANTLR start "rule__HTTPRequest__Group_11__8__Impl"
    // InternalBot.g:7004:1: rule__HTTPRequest__Group_11__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_11__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7008:1: ( ( ';' ) )
            // InternalBot.g:7009:1: ( ';' )
            {
            // InternalBot.g:7009:1: ( ';' )
            // InternalBot.g:7010:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11__8__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__0"
    // InternalBot.g:7020:1: rule__HTTPRequest__Group_11_3__0 : rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 ;
    public final void rule__HTTPRequest__Group_11_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7024:1: ( rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1 )
            // InternalBot.g:7025:2: rule__HTTPRequest__Group_11_3__0__Impl rule__HTTPRequest__Group_11_3__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_11_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__0"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__0__Impl"
    // InternalBot.g:7032:1: rule__HTTPRequest__Group_11_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_11_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7036:1: ( ( ',' ) )
            // InternalBot.g:7037:1: ( ',' )
            {
            // InternalBot.g:7037:1: ( ',' )
            // InternalBot.g:7038:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__1"
    // InternalBot.g:7047:1: rule__HTTPRequest__Group_11_3__1 : rule__HTTPRequest__Group_11_3__1__Impl ;
    public final void rule__HTTPRequest__Group_11_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7051:1: ( rule__HTTPRequest__Group_11_3__1__Impl )
            // InternalBot.g:7052:2: rule__HTTPRequest__Group_11_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_11_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__1"


    // $ANTLR start "rule__HTTPRequest__Group_11_3__1__Impl"
    // InternalBot.g:7058:1: rule__HTTPRequest__Group_11_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_11_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7062:1: ( ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) ) )
            // InternalBot.g:7063:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            {
            // InternalBot.g:7063:1: ( ( rule__HTTPRequest__DataAssignment_11_3_1 ) )
            // InternalBot.g:7064:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_3_1()); 
            // InternalBot.g:7065:2: ( rule__HTTPRequest__DataAssignment_11_3_1 )
            // InternalBot.g:7065:3: rule__HTTPRequest__DataAssignment_11_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataAssignment_11_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataAssignment_11_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_11_3__1__Impl"


    // $ANTLR start "rule__Image__Group__0"
    // InternalBot.g:7074:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7078:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:7079:2: rule__Image__Group__0__Impl rule__Image__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__Image__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__0"


    // $ANTLR start "rule__Image__Group__0__Impl"
    // InternalBot.g:7086:1: rule__Image__Group__0__Impl : ( 'image' ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7090:1: ( ( 'image' ) )
            // InternalBot.g:7091:1: ( 'image' )
            {
            // InternalBot.g:7091:1: ( 'image' )
            // InternalBot.g:7092:2: 'image'
            {
             before(grammarAccess.getImageAccess().getImageKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getImageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__0__Impl"


    // $ANTLR start "rule__Image__Group__1"
    // InternalBot.g:7101:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7105:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:7106:2: rule__Image__Group__1__Impl rule__Image__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Image__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__1"


    // $ANTLR start "rule__Image__Group__1__Impl"
    // InternalBot.g:7113:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7117:1: ( ( 'response' ) )
            // InternalBot.g:7118:1: ( 'response' )
            {
            // InternalBot.g:7118:1: ( 'response' )
            // InternalBot.g:7119:2: 'response'
            {
             before(grammarAccess.getImageAccess().getResponseKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getResponseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__1__Impl"


    // $ANTLR start "rule__Image__Group__2"
    // InternalBot.g:7128:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7132:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:7133:2: rule__Image__Group__2__Impl rule__Image__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Image__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__2"


    // $ANTLR start "rule__Image__Group__2__Impl"
    // InternalBot.g:7140:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7144:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:7145:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:7145:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:7146:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:7147:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:7147:3: rule__Image__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Image__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__2__Impl"


    // $ANTLR start "rule__Image__Group__3"
    // InternalBot.g:7155:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7159:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:7160:2: rule__Image__Group__3__Impl rule__Image__Group__4
            {
            pushFollow(FOLLOW_66);
            rule__Image__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__3"


    // $ANTLR start "rule__Image__Group__3__Impl"
    // InternalBot.g:7167:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7171:1: ( ( ':' ) )
            // InternalBot.g:7172:1: ( ':' )
            {
            // InternalBot.g:7172:1: ( ':' )
            // InternalBot.g:7173:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_3()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__3__Impl"


    // $ANTLR start "rule__Image__Group__4"
    // InternalBot.g:7182:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7186:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:7187:2: rule__Image__Group__4__Impl rule__Image__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__Image__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__4"


    // $ANTLR start "rule__Image__Group__4__Impl"
    // InternalBot.g:7194:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7198:1: ( ( 'URL' ) )
            // InternalBot.g:7199:1: ( 'URL' )
            {
            // InternalBot.g:7199:1: ( 'URL' )
            // InternalBot.g:7200:2: 'URL'
            {
             before(grammarAccess.getImageAccess().getURLKeyword_4()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getURLKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__4__Impl"


    // $ANTLR start "rule__Image__Group__5"
    // InternalBot.g:7209:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7213:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:7214:2: rule__Image__Group__5__Impl rule__Image__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Image__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__5"


    // $ANTLR start "rule__Image__Group__5__Impl"
    // InternalBot.g:7221:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7225:1: ( ( ':' ) )
            // InternalBot.g:7226:1: ( ':' )
            {
            // InternalBot.g:7226:1: ( ':' )
            // InternalBot.g:7227:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_5()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__5__Impl"


    // $ANTLR start "rule__Image__Group__6"
    // InternalBot.g:7236:1: rule__Image__Group__6 : rule__Image__Group__6__Impl ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7240:1: ( rule__Image__Group__6__Impl )
            // InternalBot.g:7241:2: rule__Image__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Image__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__6"


    // $ANTLR start "rule__Image__Group__6__Impl"
    // InternalBot.g:7247:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7251:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:7252:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:7252:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:7253:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:7254:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:7254:3: rule__Image__URLAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Image__URLAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getURLAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__6__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0"
    // InternalBot.g:7263:1: rule__TextLanguageInputHttpResponse__Group__0 : rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7267:1: ( rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 )
            // InternalBot.g:7268:2: rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__TextLanguageInputHttpResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__0"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0__Impl"
    // InternalBot.g:7275:1: rule__TextLanguageInputHttpResponse__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7279:1: ( ( 'inputs' ) )
            // InternalBot.g:7280:1: ( 'inputs' )
            {
            // InternalBot.g:7280:1: ( 'inputs' )
            // InternalBot.g:7281:2: 'inputs'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__0__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__1"
    // InternalBot.g:7290:1: rule__TextLanguageInputHttpResponse__Group__1 : rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 ;
    public final void rule__TextLanguageInputHttpResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7294:1: ( rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 )
            // InternalBot.g:7295:2: rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__TextLanguageInputHttpResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__1__Impl"
    // InternalBot.g:7302:1: rule__TextLanguageInputHttpResponse__Group__1__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7306:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) )
            // InternalBot.g:7307:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            {
            // InternalBot.g:7307:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            // InternalBot.g:7308:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 
            // InternalBot.g:7309:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==63) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalBot.g:7309:3: rule__TextLanguageInputHttpResponse__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextLanguageInputHttpResponse__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__1__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__2"
    // InternalBot.g:7317:1: rule__TextLanguageInputHttpResponse__Group__2 : rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 ;
    public final void rule__TextLanguageInputHttpResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7321:1: ( rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 )
            // InternalBot.g:7322:2: rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3
            {
            pushFollow(FOLLOW_70);
            rule__TextLanguageInputHttpResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__2"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__2__Impl"
    // InternalBot.g:7329:1: rule__TextLanguageInputHttpResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7333:1: ( ( '{' ) )
            // InternalBot.g:7334:1: ( '{' )
            {
            // InternalBot.g:7334:1: ( '{' )
            // InternalBot.g:7335:2: '{'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__2__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__3"
    // InternalBot.g:7344:1: rule__TextLanguageInputHttpResponse__Group__3 : rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 ;
    public final void rule__TextLanguageInputHttpResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7348:1: ( rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 )
            // InternalBot.g:7349:2: rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4
            {
            pushFollow(FOLLOW_26);
            rule__TextLanguageInputHttpResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__3"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__3__Impl"
    // InternalBot.g:7356:1: rule__TextLanguageInputHttpResponse__Group__3__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7360:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) )
            // InternalBot.g:7361:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            {
            // InternalBot.g:7361:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            // InternalBot.g:7362:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 
            // InternalBot.g:7363:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            // InternalBot.g:7363:3: rule__TextLanguageInputHttpResponse__InputsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__InputsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__3__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__4"
    // InternalBot.g:7371:1: rule__TextLanguageInputHttpResponse__Group__4 : rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 ;
    public final void rule__TextLanguageInputHttpResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7375:1: ( rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 )
            // InternalBot.g:7376:2: rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__TextLanguageInputHttpResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__4"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__4__Impl"
    // InternalBot.g:7383:1: rule__TextLanguageInputHttpResponse__Group__4__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7387:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) )
            // InternalBot.g:7388:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            {
            // InternalBot.g:7388:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            // InternalBot.g:7389:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 
            // InternalBot.g:7390:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==54) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBot.g:7390:3: rule__TextLanguageInputHttpResponse__Group_4__0
            	    {
            	    pushFollow(FOLLOW_9);
            	    rule__TextLanguageInputHttpResponse__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__4__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__5"
    // InternalBot.g:7398:1: rule__TextLanguageInputHttpResponse__Group__5 : rule__TextLanguageInputHttpResponse__Group__5__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7402:1: ( rule__TextLanguageInputHttpResponse__Group__5__Impl )
            // InternalBot.g:7403:2: rule__TextLanguageInputHttpResponse__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__5"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__5__Impl"
    // InternalBot.g:7409:1: rule__TextLanguageInputHttpResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7413:1: ( ( '}' ) )
            // InternalBot.g:7414:1: ( '}' )
            {
            // InternalBot.g:7414:1: ( '}' )
            // InternalBot.g:7415:2: '}'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group__5__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__0"
    // InternalBot.g:7425:1: rule__TextLanguageInputHttpResponse__Group_1__0 : rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7429:1: ( rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 )
            // InternalBot.g:7430:2: rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__TextLanguageInputHttpResponse__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__0"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__0__Impl"
    // InternalBot.g:7437:1: rule__TextLanguageInputHttpResponse__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7441:1: ( ( 'in' ) )
            // InternalBot.g:7442:1: ( 'in' )
            {
            // InternalBot.g:7442:1: ( 'in' )
            // InternalBot.g:7443:2: 'in'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__0__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__1"
    // InternalBot.g:7452:1: rule__TextLanguageInputHttpResponse__Group_1__1 : rule__TextLanguageInputHttpResponse__Group_1__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7456:1: ( rule__TextLanguageInputHttpResponse__Group_1__1__Impl )
            // InternalBot.g:7457:2: rule__TextLanguageInputHttpResponse__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_1__1__Impl"
    // InternalBot.g:7463:1: rule__TextLanguageInputHttpResponse__Group_1__1__Impl : ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7467:1: ( ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:7468:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:7468:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            // InternalBot.g:7469:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:7470:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            // InternalBot.g:7470:3: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_1__1__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__0"
    // InternalBot.g:7479:1: rule__TextLanguageInputHttpResponse__Group_4__0 : rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7483:1: ( rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 )
            // InternalBot.g:7484:2: rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1
            {
            pushFollow(FOLLOW_70);
            rule__TextLanguageInputHttpResponse__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__0"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__0__Impl"
    // InternalBot.g:7491:1: rule__TextLanguageInputHttpResponse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7495:1: ( ( ',' ) )
            // InternalBot.g:7496:1: ( ',' )
            {
            // InternalBot.g:7496:1: ( ',' )
            // InternalBot.g:7497:2: ','
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__0__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__1"
    // InternalBot.g:7506:1: rule__TextLanguageInputHttpResponse__Group_4__1 : rule__TextLanguageInputHttpResponse__Group_4__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7510:1: ( rule__TextLanguageInputHttpResponse__Group_4__1__Impl )
            // InternalBot.g:7511:2: rule__TextLanguageInputHttpResponse__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group_4__1__Impl"
    // InternalBot.g:7517:1: rule__TextLanguageInputHttpResponse__Group_4__1__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7521:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) )
            // InternalBot.g:7522:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:7522:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            // InternalBot.g:7523:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:7524:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            // InternalBot.g:7524:3: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TextLanguageInputHttpResponse__InputsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__Group_4__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__0"
    // InternalBot.g:7533:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7537:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:7538:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__KeyValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0"


    // $ANTLR start "rule__KeyValue__Group__0__Impl"
    // InternalBot.g:7545:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7549:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:7550:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:7550:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:7551:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:7552:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:7552:3: rule__KeyValue__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__0__Impl"


    // $ANTLR start "rule__KeyValue__Group__1"
    // InternalBot.g:7560:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7564:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:7565:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__KeyValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1"


    // $ANTLR start "rule__KeyValue__Group__1__Impl"
    // InternalBot.g:7572:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7576:1: ( ( ':' ) )
            // InternalBot.g:7577:1: ( ':' )
            {
            // InternalBot.g:7577:1: ( ':' )
            // InternalBot.g:7578:2: ':'
            {
             before(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__1__Impl"


    // $ANTLR start "rule__KeyValue__Group__2"
    // InternalBot.g:7587:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7591:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:7592:2: rule__KeyValue__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2"


    // $ANTLR start "rule__KeyValue__Group__2__Impl"
    // InternalBot.g:7598:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7602:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:7603:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:7603:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:7604:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:7605:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:7605:3: rule__KeyValue__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__KeyValue__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__Group__2__Impl"


    // $ANTLR start "rule__Data__Group__0"
    // InternalBot.g:7614:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7618:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:7619:2: rule__Data__Group__0__Impl rule__Data__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Data__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Data__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__0"


    // $ANTLR start "rule__Data__Group__0__Impl"
    // InternalBot.g:7626:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7630:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:7631:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:7631:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:7632:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:7633:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:7633:3: rule__Data__KeyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Data__KeyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getKeyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__0__Impl"


    // $ANTLR start "rule__Data__Group__1"
    // InternalBot.g:7641:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7645:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:7646:2: rule__Data__Group__1__Impl rule__Data__Group__2
            {
            pushFollow(FOLLOW_61);
            rule__Data__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Data__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__1"


    // $ANTLR start "rule__Data__Group__1__Impl"
    // InternalBot.g:7653:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7657:1: ( ( ':' ) )
            // InternalBot.g:7658:1: ( ':' )
            {
            // InternalBot.g:7658:1: ( ':' )
            // InternalBot.g:7659:2: ':'
            {
             before(grammarAccess.getDataAccess().getColonKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getDataAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__1__Impl"


    // $ANTLR start "rule__Data__Group__2"
    // InternalBot.g:7668:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7672:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:7673:2: rule__Data__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Data__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__2"


    // $ANTLR start "rule__Data__Group__2__Impl"
    // InternalBot.g:7679:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7683:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:7684:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:7684:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:7685:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:7686:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:7686:3: rule__Data__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Data__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__Group__2__Impl"


    // $ANTLR start "rule__Bot__NameAssignment_1"
    // InternalBot.g:7695:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7699:1: ( ( ruleEString ) )
            // InternalBot.g:7700:2: ( ruleEString )
            {
            // InternalBot.g:7700:2: ( ruleEString )
            // InternalBot.g:7701:3: ruleEString
            {
             before(grammarAccess.getBotAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getBotAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__NameAssignment_1"


    // $ANTLR start "rule__Bot__LanguagesAssignment_3"
    // InternalBot.g:7710:1: rule__Bot__LanguagesAssignment_3 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7714:1: ( ( ruleLanguage ) )
            // InternalBot.g:7715:2: ( ruleLanguage )
            {
            // InternalBot.g:7715:2: ( ruleLanguage )
            // InternalBot.g:7716:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguagesAssignment_3"


    // $ANTLR start "rule__Bot__LanguagesAssignment_4_1"
    // InternalBot.g:7725:1: rule__Bot__LanguagesAssignment_4_1 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7729:1: ( ( ruleLanguage ) )
            // InternalBot.g:7730:2: ( ruleLanguage )
            {
            // InternalBot.g:7730:2: ( ruleLanguage )
            // InternalBot.g:7731:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguagesAssignment_4_1"


    // $ANTLR start "rule__Bot__IntentsAssignment_7"
    // InternalBot.g:7740:1: rule__Bot__IntentsAssignment_7 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7744:1: ( ( ruleIntent ) )
            // InternalBot.g:7745:2: ( ruleIntent )
            {
            // InternalBot.g:7745:2: ( ruleIntent )
            // InternalBot.g:7746:3: ruleIntent
            {
             before(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__IntentsAssignment_7"


    // $ANTLR start "rule__Bot__IntentsAssignment_8"
    // InternalBot.g:7755:1: rule__Bot__IntentsAssignment_8 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7759:1: ( ( ruleIntent ) )
            // InternalBot.g:7760:2: ( ruleIntent )
            {
            // InternalBot.g:7760:2: ( ruleIntent )
            // InternalBot.g:7761:3: ruleIntent
            {
             before(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__IntentsAssignment_8"


    // $ANTLR start "rule__Bot__EntitiesAssignment_9_2"
    // InternalBot.g:7770:1: rule__Bot__EntitiesAssignment_9_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7774:1: ( ( ruleEntity ) )
            // InternalBot.g:7775:2: ( ruleEntity )
            {
            // InternalBot.g:7775:2: ( ruleEntity )
            // InternalBot.g:7776:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_9_2"


    // $ANTLR start "rule__Bot__EntitiesAssignment_9_3"
    // InternalBot.g:7785:1: rule__Bot__EntitiesAssignment_9_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_9_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7789:1: ( ( ruleEntity ) )
            // InternalBot.g:7790:2: ( ruleEntity )
            {
            // InternalBot.g:7790:2: ( ruleEntity )
            // InternalBot.g:7791:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_9_3"


    // $ANTLR start "rule__Bot__ActionsAssignment_10_2"
    // InternalBot.g:7800:1: rule__Bot__ActionsAssignment_10_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7804:1: ( ( ruleAction ) )
            // InternalBot.g:7805:2: ( ruleAction )
            {
            // InternalBot.g:7805:2: ( ruleAction )
            // InternalBot.g:7806:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_10_2"


    // $ANTLR start "rule__Bot__ActionsAssignment_10_3"
    // InternalBot.g:7815:1: rule__Bot__ActionsAssignment_10_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7819:1: ( ( ruleAction ) )
            // InternalBot.g:7820:2: ( ruleAction )
            {
            // InternalBot.g:7820:2: ( ruleAction )
            // InternalBot.g:7821:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_10_3"


    // $ANTLR start "rule__Bot__FlowsAssignment_13_1"
    // InternalBot.g:7830:1: rule__Bot__FlowsAssignment_13_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7834:1: ( ( ruleTransition ) )
            // InternalBot.g:7835:2: ( ruleTransition )
            {
            // InternalBot.g:7835:2: ( ruleTransition )
            // InternalBot.g:7836:3: ruleTransition
            {
             before(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__FlowsAssignment_13_1"


    // $ANTLR start "rule__Intent__NameAssignment_0"
    // InternalBot.g:7845:1: rule__Intent__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7849:1: ( ( ruleEString ) )
            // InternalBot.g:7850:2: ( ruleEString )
            {
            // InternalBot.g:7850:2: ( ruleEString )
            // InternalBot.g:7851:3: ruleEString
            {
             before(grammarAccess.getIntentAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__NameAssignment_0"


    // $ANTLR start "rule__Intent__FallbackIntentAssignment_1"
    // InternalBot.g:7860:1: rule__Intent__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7864:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:7865:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:7865:2: ( ( 'Fallback' ) )
            // InternalBot.g:7866:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:7867:3: ( 'Fallback' )
            // InternalBot.g:7868:4: 'Fallback'
            {
             before(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 

            }

             after(grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__FallbackIntentAssignment_1"


    // $ANTLR start "rule__Intent__InputsAssignment_3"
    // InternalBot.g:7879:1: rule__Intent__InputsAssignment_3 : ( ruleIntentLanguageInputs ) ;
    public final void rule__Intent__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7883:1: ( ( ruleIntentLanguageInputs ) )
            // InternalBot.g:7884:2: ( ruleIntentLanguageInputs )
            {
            // InternalBot.g:7884:2: ( ruleIntentLanguageInputs )
            // InternalBot.g:7885:3: ruleIntentLanguageInputs
            {
             before(grammarAccess.getIntentAccess().getInputsIntentLanguageInputsParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIntentLanguageInputs();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getInputsIntentLanguageInputsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__InputsAssignment_3"


    // $ANTLR start "rule__Intent__ParametersAssignment_4_1_0"
    // InternalBot.g:7894:1: rule__Intent__ParametersAssignment_4_1_0 : ( ruleParameter2 ) ;
    public final void rule__Intent__ParametersAssignment_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7898:1: ( ( ruleParameter2 ) )
            // InternalBot.g:7899:2: ( ruleParameter2 )
            {
            // InternalBot.g:7899:2: ( ruleParameter2 )
            // InternalBot.g:7900:3: ruleParameter2
            {
             before(grammarAccess.getIntentAccess().getParametersParameter2ParserRuleCall_4_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter2();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameter2ParserRuleCall_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_4_1_0"


    // $ANTLR start "rule__Intent__ParametersAssignment_4_1_1"
    // InternalBot.g:7909:1: rule__Intent__ParametersAssignment_4_1_1 : ( ruleParameter ) ;
    public final void rule__Intent__ParametersAssignment_4_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7913:1: ( ( ruleParameter ) )
            // InternalBot.g:7914:2: ( ruleParameter )
            {
            // InternalBot.g:7914:2: ( ruleParameter )
            // InternalBot.g:7915:3: ruleParameter
            {
             before(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent__ParametersAssignment_4_1_1"


    // $ANTLR start "rule__IntentLanguageInputs__LanguageAssignment_1_1"
    // InternalBot.g:7924:1: rule__IntentLanguageInputs__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__IntentLanguageInputs__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7928:1: ( ( ruleLanguage ) )
            // InternalBot.g:7929:2: ( ruleLanguage )
            {
            // InternalBot.g:7929:2: ( ruleLanguage )
            // InternalBot.g:7930:3: ruleLanguage
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__LanguageAssignment_1_1"


    // $ANTLR start "rule__IntentLanguageInputs__InputsAssignment_3"
    // InternalBot.g:7939:1: rule__IntentLanguageInputs__InputsAssignment_3 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7943:1: ( ( ruleIntentInput ) )
            // InternalBot.g:7944:2: ( ruleIntentInput )
            {
            // InternalBot.g:7944:2: ( ruleIntentInput )
            // InternalBot.g:7945:3: ruleIntentInput
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIntentInput();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__InputsAssignment_3"


    // $ANTLR start "rule__IntentLanguageInputs__InputsAssignment_4_1"
    // InternalBot.g:7954:1: rule__IntentLanguageInputs__InputsAssignment_4_1 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7958:1: ( ( ruleIntentInput ) )
            // InternalBot.g:7959:2: ( ruleIntentInput )
            {
            // InternalBot.g:7959:2: ( ruleIntentInput )
            // InternalBot.g:7960:3: ruleIntentInput
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleIntentInput();

            state._fsp--;

             after(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntentLanguageInputs__InputsAssignment_4_1"


    // $ANTLR start "rule__Transition__IntentAssignment_1"
    // InternalBot.g:7969:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7973:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:7974:2: ( ( ruleEString ) )
            {
            // InternalBot.g:7974:2: ( ( ruleEString ) )
            // InternalBot.g:7975:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:7976:3: ( ruleEString )
            // InternalBot.g:7977:4: ruleEString
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransitionAccess().getIntentIntentEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__IntentAssignment_1"


    // $ANTLR start "rule__Transition__TargetAssignment_2_1"
    // InternalBot.g:7988:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7992:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:7993:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:7993:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:7994:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:7995:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:7995:4: rule__Transition__TargetAlternatives_2_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Transition__TargetAlternatives_2_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transition__TargetAssignment_2_1"


    // $ANTLR start "rule__State__ActionsAssignment_1"
    // InternalBot.g:8003:1: rule__State__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8007:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8008:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8008:2: ( ( ruleEString ) )
            // InternalBot.g:8009:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:8010:3: ( ruleEString )
            // InternalBot.g:8011:4: ruleEString
            {
             before(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_1"


    // $ANTLR start "rule__State__ActionsAssignment_2_1"
    // InternalBot.g:8022:1: rule__State__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8026:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8027:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8027:2: ( ( ruleEString ) )
            // InternalBot.g:8028:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:8029:3: ( ruleEString )
            // InternalBot.g:8030:4: ruleEString
            {
             before(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getStateAccess().getActionsActionEStringParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__ActionsAssignment_2_1"


    // $ANTLR start "rule__State__OutcomingAssignment_3_1"
    // InternalBot.g:8041:1: rule__State__OutcomingAssignment_3_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8045:1: ( ( ruleTransition ) )
            // InternalBot.g:8046:2: ( ruleTransition )
            {
            // InternalBot.g:8046:2: ( ruleTransition )
            // InternalBot.g:8047:3: ruleTransition
            {
             before(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__OutcomingAssignment_3_1"


    // $ANTLR start "rule__State2__ActionsAssignment_1"
    // InternalBot.g:8056:1: rule__State2__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8060:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8061:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8061:2: ( ( ruleEString ) )
            // InternalBot.g:8062:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:8063:3: ( ruleEString )
            // InternalBot.g:8064:4: ruleEString
            {
             before(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getState2Access().getActionsActionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__ActionsAssignment_1"


    // $ANTLR start "rule__State2__ActionsAssignment_2_1"
    // InternalBot.g:8075:1: rule__State2__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8079:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8080:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8080:2: ( ( ruleEString ) )
            // InternalBot.g:8081:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:8082:3: ( ruleEString )
            // InternalBot.g:8083:4: ruleEString
            {
             before(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getState2Access().getActionsActionEStringParserRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__ActionsAssignment_2_1"


    // $ANTLR start "rule__State2__OutcomingAssignment_4_1"
    // InternalBot.g:8094:1: rule__State2__OutcomingAssignment_4_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8098:1: ( ( ruleTransition ) )
            // InternalBot.g:8099:2: ( ruleTransition )
            {
            // InternalBot.g:8099:2: ( ruleTransition )
            // InternalBot.g:8100:3: ruleTransition
            {
             before(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State2__OutcomingAssignment_4_1"


    // $ANTLR start "rule__TrainingPhrase__TokensAssignment_1"
    // InternalBot.g:8109:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8113:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:8114:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:8114:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:8115:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:8116:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:8116:4: rule__TrainingPhrase__TokensAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TrainingPhrase__TokensAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrainingPhrase__TokensAssignment_1"


    // $ANTLR start "rule__Parameter__NameAssignment_0"
    // InternalBot.g:8124:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8128:1: ( ( ruleEString ) )
            // InternalBot.g:8129:2: ( ruleEString )
            {
            // InternalBot.g:8129:2: ( ruleEString )
            // InternalBot.g:8130:3: ruleEString
            {
             before(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment_0"


    // $ANTLR start "rule__Parameter__EntityAssignment_3_0"
    // InternalBot.g:8139:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8143:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8144:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8144:2: ( ( ruleEString ) )
            // InternalBot.g:8145:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:8146:3: ( ruleEString )
            // InternalBot.g:8147:4: ruleEString
            {
             before(grammarAccess.getParameterAccess().getEntityEntityEStringParserRuleCall_3_0_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getEntityEntityEStringParserRuleCall_3_0_0_1()); 

            }

             after(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__EntityAssignment_3_0"


    // $ANTLR start "rule__Parameter__DefaultEntityAssignment_3_1"
    // InternalBot.g:8158:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8162:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:8163:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:8163:2: ( ruleDefaultEntity )
            // InternalBot.g:8164:3: ruleDefaultEntity
            {
             before(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDefaultEntity();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__DefaultEntityAssignment_3_1"


    // $ANTLR start "rule__Parameter__RequiredAssignment_4_1"
    // InternalBot.g:8173:1: rule__Parameter__RequiredAssignment_4_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8177:1: ( ( ( 'required' ) ) )
            // InternalBot.g:8178:2: ( ( 'required' ) )
            {
            // InternalBot.g:8178:2: ( ( 'required' ) )
            // InternalBot.g:8179:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            // InternalBot.g:8180:3: ( 'required' )
            // InternalBot.g:8181:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 

            }

             after(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__RequiredAssignment_4_1"


    // $ANTLR start "rule__Parameter__PromptsAssignment_5_1"
    // InternalBot.g:8192:1: rule__Parameter__PromptsAssignment_5_1 : ( rulePromptLanguage ) ;
    public final void rule__Parameter__PromptsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8196:1: ( ( rulePromptLanguage ) )
            // InternalBot.g:8197:2: ( rulePromptLanguage )
            {
            // InternalBot.g:8197:2: ( rulePromptLanguage )
            // InternalBot.g:8198:3: rulePromptLanguage
            {
             before(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            rulePromptLanguage();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_5_1"


    // $ANTLR start "rule__Parameter__IsListAssignment_6_1"
    // InternalBot.g:8207:1: rule__Parameter__IsListAssignment_6_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8211:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:8212:2: ( ( 'isList' ) )
            {
            // InternalBot.g:8212:2: ( ( 'isList' ) )
            // InternalBot.g:8213:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_6_1_0()); 
            // InternalBot.g:8214:3: ( 'isList' )
            // InternalBot.g:8215:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_6_1_0()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getIsListIsListKeyword_6_1_0()); 

            }

             after(grammarAccess.getParameterAccess().getIsListIsListKeyword_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__IsListAssignment_6_1"


    // $ANTLR start "rule__Parameter2__NameAssignment_0"
    // InternalBot.g:8226:1: rule__Parameter2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8230:1: ( ( ruleEString ) )
            // InternalBot.g:8231:2: ( ruleEString )
            {
            // InternalBot.g:8231:2: ( ruleEString )
            // InternalBot.g:8232:3: ruleEString
            {
             before(grammarAccess.getParameter2Access().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameter2Access().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter2__NameAssignment_0"


    // $ANTLR start "rule__PromptLanguage__LanguageAssignment_1_1"
    // InternalBot.g:8241:1: rule__PromptLanguage__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__PromptLanguage__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8245:1: ( ( ruleLanguage ) )
            // InternalBot.g:8246:2: ( ruleLanguage )
            {
            // InternalBot.g:8246:2: ( ruleLanguage )
            // InternalBot.g:8247:3: ruleLanguage
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__LanguageAssignment_1_1"


    // $ANTLR start "rule__PromptLanguage__PromptsAssignment_3"
    // InternalBot.g:8256:1: rule__PromptLanguage__PromptsAssignment_3 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8260:1: ( ( ruleEString ) )
            // InternalBot.g:8261:2: ( ruleEString )
            {
            // InternalBot.g:8261:2: ( ruleEString )
            // InternalBot.g:8262:3: ruleEString
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__PromptsAssignment_3"


    // $ANTLR start "rule__PromptLanguage__PromptsAssignment_4_1"
    // InternalBot.g:8271:1: rule__PromptLanguage__PromptsAssignment_4_1 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8275:1: ( ( ruleEString ) )
            // InternalBot.g:8276:2: ( ruleEString )
            {
            // InternalBot.g:8276:2: ( ruleEString )
            // InternalBot.g:8277:3: ruleEString
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PromptLanguage__PromptsAssignment_4_1"


    // $ANTLR start "rule__Literal__TextAssignment"
    // InternalBot.g:8286:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8290:1: ( ( ruleEString ) )
            // InternalBot.g:8291:2: ( ruleEString )
            {
            // InternalBot.g:8291:2: ( ruleEString )
            // InternalBot.g:8292:3: ruleEString
            {
             before(grammarAccess.getLiteralAccess().getTextEStringParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLiteralAccess().getTextEStringParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__TextAssignment"


    // $ANTLR start "rule__EntityToken__EntityAssignment_2"
    // InternalBot.g:8301:1: rule__EntityToken__EntityAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8305:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8306:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8306:2: ( ( ruleEString ) )
            // InternalBot.g:8307:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_2_0()); 
            // InternalBot.g:8308:3: ( ruleEString )
            // InternalBot.g:8309:4: ruleEString
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEntityTokenAccess().getEntityEntityEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__EntityAssignment_2"


    // $ANTLR start "rule__ParameterToken__ParameterAssignment_1"
    // InternalBot.g:8320:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8324:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8325:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8325:2: ( ( ruleEString ) )
            // InternalBot.g:8326:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:8327:3: ( ruleEString )
            // InternalBot.g:8328:4: ruleEString
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterTokenAccess().getParameterParameterEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterToken__ParameterAssignment_1"


    // $ANTLR start "rule__ParameterRefenceToken__TextReferenceAssignment_1"
    // InternalBot.g:8339:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8343:1: ( ( ruleEString ) )
            // InternalBot.g:8344:2: ( ruleEString )
            {
            // InternalBot.g:8344:2: ( ruleEString )
            // InternalBot.g:8345:3: ruleEString
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__TextReferenceAssignment_1"


    // $ANTLR start "rule__ParameterRefenceToken__ParameterAssignment_4"
    // InternalBot.g:8354:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8358:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8359:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8359:2: ( ( ruleEString ) )
            // InternalBot.g:8360:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:8361:3: ( ruleEString )
            // InternalBot.g:8362:4: ruleEString
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterRefenceToken__ParameterAssignment_4"


    // $ANTLR start "rule__HTTPRequestToken__TypeAssignment_1"
    // InternalBot.g:8373:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8377:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:8378:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:8378:2: ( ruleHTTPReturnType )
            // InternalBot.g:8379:3: ruleHTTPReturnType
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleHTTPReturnType();

            state._fsp--;

             after(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__TypeAssignment_1"


    // $ANTLR start "rule__HTTPRequestToken__DataKeyAssignment_2_1"
    // InternalBot.g:8388:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8392:1: ( ( ruleEString ) )
            // InternalBot.g:8393:2: ( ruleEString )
            {
            // InternalBot.g:8393:2: ( ruleEString )
            // InternalBot.g:8394:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestTokenAccess().getDataKeyEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequestToken__DataKeyAssignment_2_1"


    // $ANTLR start "rule__Entity__NameAssignment_1"
    // InternalBot.g:8403:1: rule__Entity__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8407:1: ( ( ruleEString ) )
            // InternalBot.g:8408:2: ( ruleEString )
            {
            // InternalBot.g:8408:2: ( ruleEString )
            // InternalBot.g:8409:3: ruleEString
            {
             before(grammarAccess.getEntityAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__NameAssignment_1"


    // $ANTLR start "rule__Entity__InputsAssignment_3"
    // InternalBot.g:8418:1: rule__Entity__InputsAssignment_3 : ( ruleLanguageInput ) ;
    public final void rule__Entity__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8422:1: ( ( ruleLanguageInput ) )
            // InternalBot.g:8423:2: ( ruleLanguageInput )
            {
            // InternalBot.g:8423:2: ( ruleLanguageInput )
            // InternalBot.g:8424:3: ruleLanguageInput
            {
             before(grammarAccess.getEntityAccess().getInputsLanguageInputParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguageInput();

            state._fsp--;

             after(grammarAccess.getEntityAccess().getInputsLanguageInputParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__InputsAssignment_3"


    // $ANTLR start "rule__LanguageInput__LanguageAssignment_0_2"
    // InternalBot.g:8433:1: rule__LanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__LanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8437:1: ( ( ruleLanguage ) )
            // InternalBot.g:8438:2: ( ruleLanguage )
            {
            // InternalBot.g:8438:2: ( ruleLanguage )
            // InternalBot.g:8439:3: ruleLanguage
            {
             before(grammarAccess.getLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__LanguageAssignment_0_2"


    // $ANTLR start "rule__LanguageInput__InputsAssignment_2_0"
    // InternalBot.g:8448:1: rule__LanguageInput__InputsAssignment_2_0 : ( ruleEntityInput ) ;
    public final void rule__LanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8452:1: ( ( ruleEntityInput ) )
            // InternalBot.g:8453:2: ( ruleEntityInput )
            {
            // InternalBot.g:8453:2: ( ruleEntityInput )
            // InternalBot.g:8454:3: ruleEntityInput
            {
             before(grammarAccess.getLanguageInputAccess().getInputsEntityInputParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEntityInput();

            state._fsp--;

             after(grammarAccess.getLanguageInputAccess().getInputsEntityInputParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__InputsAssignment_2_0"


    // $ANTLR start "rule__LanguageInput__InputsAssignment_2_1"
    // InternalBot.g:8463:1: rule__LanguageInput__InputsAssignment_2_1 : ( ruleEntityInput ) ;
    public final void rule__LanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8467:1: ( ( ruleEntityInput ) )
            // InternalBot.g:8468:2: ( ruleEntityInput )
            {
            // InternalBot.g:8468:2: ( ruleEntityInput )
            // InternalBot.g:8469:3: ruleEntityInput
            {
             before(grammarAccess.getLanguageInputAccess().getInputsEntityInputParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEntityInput();

            state._fsp--;

             after(grammarAccess.getLanguageInputAccess().getInputsEntityInputParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LanguageInput__InputsAssignment_2_1"


    // $ANTLR start "rule__RegexInput__ExpresionAssignment_3"
    // InternalBot.g:8478:1: rule__RegexInput__ExpresionAssignment_3 : ( ruleEString ) ;
    public final void rule__RegexInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8482:1: ( ( ruleEString ) )
            // InternalBot.g:8483:2: ( ruleEString )
            {
            // InternalBot.g:8483:2: ( ruleEString )
            // InternalBot.g:8484:3: ruleEString
            {
             before(grammarAccess.getRegexInputAccess().getExpresionEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRegexInputAccess().getExpresionEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexInput__ExpresionAssignment_3"


    // $ANTLR start "rule__CompositeInput__ExpresionAssignment_3"
    // InternalBot.g:8493:1: rule__CompositeInput__ExpresionAssignment_3 : ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) ;
    public final void rule__CompositeInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8497:1: ( ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) )
            // InternalBot.g:8498:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            {
            // InternalBot.g:8498:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            // InternalBot.g:8499:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAlternatives_3_0()); 
            // InternalBot.g:8500:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            // InternalBot.g:8500:4: rule__CompositeInput__ExpresionAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__CompositeInput__ExpresionAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getExpresionAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CompositeInput__ExpresionAssignment_3"


    // $ANTLR start "rule__SimpleInput__NameAssignment_3"
    // InternalBot.g:8508:1: rule__SimpleInput__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8512:1: ( ( ruleEString ) )
            // InternalBot.g:8513:2: ( ruleEString )
            {
            // InternalBot.g:8513:2: ( ruleEString )
            // InternalBot.g:8514:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__NameAssignment_3"


    // $ANTLR start "rule__SimpleInput__ValuesAssignment_4_1"
    // InternalBot.g:8523:1: rule__SimpleInput__ValuesAssignment_4_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8527:1: ( ( ruleEString ) )
            // InternalBot.g:8528:2: ( ruleEString )
            {
            // InternalBot.g:8528:2: ( ruleEString )
            // InternalBot.g:8529:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__ValuesAssignment_4_1"


    // $ANTLR start "rule__SimpleInput__ValuesAssignment_4_2_1"
    // InternalBot.g:8538:1: rule__SimpleInput__ValuesAssignment_4_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8542:1: ( ( ruleEString ) )
            // InternalBot.g:8543:2: ( ruleEString )
            {
            // InternalBot.g:8543:2: ( ruleEString )
            // InternalBot.g:8544:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__ValuesAssignment_4_2_1"


    // $ANTLR start "rule__Text__NameAssignment_2"
    // InternalBot.g:8553:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8557:1: ( ( ruleEString ) )
            // InternalBot.g:8558:2: ( ruleEString )
            {
            // InternalBot.g:8558:2: ( ruleEString )
            // InternalBot.g:8559:3: ruleEString
            {
             before(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__NameAssignment_2"


    // $ANTLR start "rule__Text__InputsAssignment_4"
    // InternalBot.g:8568:1: rule__Text__InputsAssignment_4 : ( ruleTextLanguageInput ) ;
    public final void rule__Text__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8572:1: ( ( ruleTextLanguageInput ) )
            // InternalBot.g:8573:2: ( ruleTextLanguageInput )
            {
            // InternalBot.g:8573:2: ( ruleTextLanguageInput )
            // InternalBot.g:8574:3: ruleTextLanguageInput
            {
             before(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTextLanguageInput();

            state._fsp--;

             after(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__InputsAssignment_4"


    // $ANTLR start "rule__TextLanguageInput__LanguageAssignment_0_1_1"
    // InternalBot.g:8583:1: rule__TextLanguageInput__LanguageAssignment_0_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInput__LanguageAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8587:1: ( ( ruleLanguage ) )
            // InternalBot.g:8588:2: ( ruleLanguage )
            {
            // InternalBot.g:8588:2: ( ruleLanguage )
            // InternalBot.g:8589:3: ruleLanguage
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__LanguageAssignment_0_1_1"


    // $ANTLR start "rule__TextLanguageInput__InputsAssignment_2"
    // InternalBot.g:8598:1: rule__TextLanguageInput__InputsAssignment_2 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8602:1: ( ( ruleTextInputText ) )
            // InternalBot.g:8603:2: ( ruleTextInputText )
            {
            // InternalBot.g:8603:2: ( ruleTextInputText )
            // InternalBot.g:8604:3: ruleTextInputText
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__InputsAssignment_2"


    // $ANTLR start "rule__TextLanguageInput__InputsAssignment_3_1"
    // InternalBot.g:8613:1: rule__TextLanguageInput__InputsAssignment_3_1 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8617:1: ( ( ruleTextInputText ) )
            // InternalBot.g:8618:2: ( ruleTextInputText )
            {
            // InternalBot.g:8618:2: ( ruleTextInputText )
            // InternalBot.g:8619:3: ruleTextInputText
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInput__InputsAssignment_3_1"


    // $ANTLR start "rule__HTTPResponse__NameAssignment_1"
    // InternalBot.g:8628:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8632:1: ( ( ruleEString ) )
            // InternalBot.g:8633:2: ( ruleEString )
            {
            // InternalBot.g:8633:2: ( ruleEString )
            // InternalBot.g:8634:3: ruleEString
            {
             before(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__NameAssignment_1"


    // $ANTLR start "rule__HTTPResponse__HTTPRequestAssignment_4"
    // InternalBot.g:8643:1: rule__HTTPResponse__HTTPRequestAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8647:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:8648:2: ( ( ruleEString ) )
            {
            // InternalBot.g:8648:2: ( ( ruleEString ) )
            // InternalBot.g:8649:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0()); 
            // InternalBot.g:8650:3: ( ruleEString )
            // InternalBot.g:8651:4: ruleEString
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__HTTPRequestAssignment_4"


    // $ANTLR start "rule__HTTPResponse__InputsAssignment_6"
    // InternalBot.g:8662:1: rule__HTTPResponse__InputsAssignment_6 : ( ruleTextLanguageInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8666:1: ( ( ruleTextLanguageInputHttpResponse ) )
            // InternalBot.g:8667:2: ( ruleTextLanguageInputHttpResponse )
            {
            // InternalBot.g:8667:2: ( ruleTextLanguageInputHttpResponse )
            // InternalBot.g:8668:3: ruleTextLanguageInputHttpResponse
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTextLanguageInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__InputsAssignment_6"


    // $ANTLR start "rule__HTTPRequest__MethodAssignment_2"
    // InternalBot.g:8677:1: rule__HTTPRequest__MethodAssignment_2 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8681:1: ( ( ruleMethod ) )
            // InternalBot.g:8682:2: ( ruleMethod )
            {
            // InternalBot.g:8682:2: ( ruleMethod )
            // InternalBot.g:8683:3: ruleMethod
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMethod();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__MethodAssignment_2"


    // $ANTLR start "rule__HTTPRequest__NameAssignment_3"
    // InternalBot.g:8692:1: rule__HTTPRequest__NameAssignment_3 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8696:1: ( ( ruleEString ) )
            // InternalBot.g:8697:2: ( ruleEString )
            {
            // InternalBot.g:8697:2: ( ruleEString )
            // InternalBot.g:8698:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__NameAssignment_3"


    // $ANTLR start "rule__HTTPRequest__URLAssignment_7"
    // InternalBot.g:8707:1: rule__HTTPRequest__URLAssignment_7 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8711:1: ( ( ruleEString ) )
            // InternalBot.g:8712:2: ( ruleEString )
            {
            // InternalBot.g:8712:2: ( ruleEString )
            // InternalBot.g:8713:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__URLAssignment_7"


    // $ANTLR start "rule__HTTPRequest__BasicAuthAssignment_9_2"
    // InternalBot.g:8722:1: rule__HTTPRequest__BasicAuthAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8726:1: ( ( ruleKeyValue ) )
            // InternalBot.g:8727:2: ( ruleKeyValue )
            {
            // InternalBot.g:8727:2: ( ruleKeyValue )
            // InternalBot.g:8728:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__BasicAuthAssignment_9_2"


    // $ANTLR start "rule__HTTPRequest__HeadersAssignment_10_2"
    // InternalBot.g:8737:1: rule__HTTPRequest__HeadersAssignment_10_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8741:1: ( ( ruleKeyValue ) )
            // InternalBot.g:8742:2: ( ruleKeyValue )
            {
            // InternalBot.g:8742:2: ( ruleKeyValue )
            // InternalBot.g:8743:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__HeadersAssignment_10_2"


    // $ANTLR start "rule__HTTPRequest__HeadersAssignment_10_3_1"
    // InternalBot.g:8752:1: rule__HTTPRequest__HeadersAssignment_10_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8756:1: ( ( ruleKeyValue ) )
            // InternalBot.g:8757:2: ( ruleKeyValue )
            {
            // InternalBot.g:8757:2: ( ruleKeyValue )
            // InternalBot.g:8758:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__HeadersAssignment_10_3_1"


    // $ANTLR start "rule__HTTPRequest__DataAssignment_11_2"
    // InternalBot.g:8767:1: rule__HTTPRequest__DataAssignment_11_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8771:1: ( ( ruleData ) )
            // InternalBot.g:8772:2: ( ruleData )
            {
            // InternalBot.g:8772:2: ( ruleData )
            // InternalBot.g:8773:3: ruleData
            {
             before(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataAssignment_11_2"


    // $ANTLR start "rule__HTTPRequest__DataAssignment_11_3_1"
    // InternalBot.g:8782:1: rule__HTTPRequest__DataAssignment_11_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_11_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8786:1: ( ( ruleData ) )
            // InternalBot.g:8787:2: ( ruleData )
            {
            // InternalBot.g:8787:2: ( ruleData )
            // InternalBot.g:8788:3: ruleData
            {
             before(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataAssignment_11_3_1"


    // $ANTLR start "rule__HTTPRequest__DataTypeAssignment_11_7"
    // InternalBot.g:8797:1: rule__HTTPRequest__DataTypeAssignment_11_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_11_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8801:1: ( ( ruleDataType ) )
            // InternalBot.g:8802:2: ( ruleDataType )
            {
            // InternalBot.g:8802:2: ( ruleDataType )
            // InternalBot.g:8803:3: ruleDataType
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_11_7_0()); 
            pushFollow(FOLLOW_2);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_11_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataTypeAssignment_11_7"


    // $ANTLR start "rule__Image__NameAssignment_2"
    // InternalBot.g:8812:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8816:1: ( ( ruleEString ) )
            // InternalBot.g:8817:2: ( ruleEString )
            {
            // InternalBot.g:8817:2: ( ruleEString )
            // InternalBot.g:8818:3: ruleEString
            {
             before(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__NameAssignment_2"


    // $ANTLR start "rule__Image__URLAssignment_6"
    // InternalBot.g:8827:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8831:1: ( ( ruleEString ) )
            // InternalBot.g:8832:2: ( ruleEString )
            {
            // InternalBot.g:8832:2: ( ruleEString )
            // InternalBot.g:8833:3: ruleEString
            {
             before(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__URLAssignment_6"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"
    // InternalBot.g:8842:1: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8846:1: ( ( ruleLanguage ) )
            // InternalBot.g:8847:2: ( ruleLanguage )
            {
            // InternalBot.g:8847:2: ( ruleLanguage )
            // InternalBot.g:8848:3: ruleLanguage
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__InputsAssignment_3"
    // InternalBot.g:8857:1: rule__TextLanguageInputHttpResponse__InputsAssignment_3 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8861:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:8862:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:8862:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:8863:3: ruleTextInputHttpResponse
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__InputsAssignment_3"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__InputsAssignment_4_1"
    // InternalBot.g:8872:1: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8876:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:8877:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:8877:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:8878:3: ruleTextInputHttpResponse
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextLanguageInputHttpResponse__InputsAssignment_4_1"


    // $ANTLR start "rule__TextInputHttpResponse__TokensAssignment"
    // InternalBot.g:8887:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8891:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:8892:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:8892:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:8893:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:8894:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:8894:4: rule__TextInputHttpResponse__TokensAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TextInputHttpResponse__TokensAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputHttpResponse__TokensAssignment"


    // $ANTLR start "rule__TextInputText__TokensAssignment"
    // InternalBot.g:8902:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8906:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:8907:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:8907:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:8908:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:8909:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:8909:4: rule__TextInputText__TokensAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__TextInputText__TokensAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextInputText__TokensAssignment"


    // $ANTLR start "rule__KeyValue__KeyAssignment_0"
    // InternalBot.g:8917:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8921:1: ( ( ruleEString ) )
            // InternalBot.g:8922:2: ( ruleEString )
            {
            // InternalBot.g:8922:2: ( ruleEString )
            // InternalBot.g:8923:3: ruleEString
            {
             before(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__KeyAssignment_0"


    // $ANTLR start "rule__KeyValue__ValueAssignment_2"
    // InternalBot.g:8932:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8936:1: ( ( ruleLiteral ) )
            // InternalBot.g:8937:2: ( ruleLiteral )
            {
            // InternalBot.g:8937:2: ( ruleLiteral )
            // InternalBot.g:8938:3: ruleLiteral
            {
             before(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__KeyValue__ValueAssignment_2"


    // $ANTLR start "rule__Data__KeyAssignment_0"
    // InternalBot.g:8947:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8951:1: ( ( ruleEString ) )
            // InternalBot.g:8952:2: ( ruleEString )
            {
            // InternalBot.g:8952:2: ( ruleEString )
            // InternalBot.g:8953:3: ruleEString
            {
             before(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__KeyAssignment_0"


    // $ANTLR start "rule__Data__ValueAssignment_2"
    // InternalBot.g:8962:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8966:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:8967:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:8967:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:8968:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:8969:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:8969:4: rule__Data__ValueAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Data__ValueAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Data__ValueAssignment_2"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String dfa_1s = "\11\uffff";
    static final String dfa_2s = "\2\uffff\2\5\3\uffff\2\5";
    static final String dfa_3s = "\1\102\1\4\2\66\1\4\2\uffff\2\66";
    static final String dfa_4s = "\1\102\1\5\2\101\1\5\2\uffff\2\101";
    static final String dfa_5s = "\5\uffff\1\1\1\2\2\uffff";
    static final String dfa_6s = "\11\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\1\3",
            "\1\4\3\uffff\1\5\2\uffff\1\6\3\uffff\1\5",
            "\1\4\3\uffff\1\5\2\uffff\1\6\3\uffff\1\5",
            "\1\7\1\10",
            "",
            "",
            "\1\4\3\uffff\1\5\2\uffff\1\6\3\uffff\1\5",
            "\1\4\3\uffff\1\5\2\uffff\1\6\3\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1050:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000820L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00001FFFFFF80000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0048000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x01A0000000000030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020800L,0x0000000000280000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020802L,0x0000000000280000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0010000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xA000000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000030L,0x0000000000004200L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x2040000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000200L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000200L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000000000000F830L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000070800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000030L,0x000000000001C200L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000032L,0x000000000001C200L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000080L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000080L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000020L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000040000L,0x0000000003000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000820L});

}