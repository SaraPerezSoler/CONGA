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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'text'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language'", "':'", "'intents'", "'flows'", "','", "'entities'", "'actions'", "'-'", "';'", "'parameters'", "'inputs'", "'{'", "'}'", "'in'", "'user'", "'=>'", "'chatbot'", "'entity'", "'prompts'", "'['", "']'", "'@'", "'('", "')'", "'request.'", "'.'", "'Simple'", "'Composite'", "'Regex'", "'pattern'", "'composite'", "'synonyms'", "'response'", "'Response'", "'Request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'caption'", "'empty'", "'Fallback'", "'isList'", "'required'"
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
    // InternalBot.g:137:1: ruleIntent : ( ( rule__Intent__Alternatives ) ) ;
    public final void ruleIntent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:141:2: ( ( ( rule__Intent__Alternatives ) ) )
            // InternalBot.g:142:2: ( ( rule__Intent__Alternatives ) )
            {
            // InternalBot.g:142:2: ( ( rule__Intent__Alternatives ) )
            // InternalBot.g:143:3: ( rule__Intent__Alternatives )
            {
             before(grammarAccess.getIntentAccess().getAlternatives()); 
            // InternalBot.g:144:3: ( rule__Intent__Alternatives )
            // InternalBot.g:144:4: rule__Intent__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Intent__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIntentAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleIntent2"
    // InternalBot.g:153:1: entryRuleIntent2 : ruleIntent2 EOF ;
    public final void entryRuleIntent2() throws RecognitionException {
        try {
            // InternalBot.g:154:1: ( ruleIntent2 EOF )
            // InternalBot.g:155:1: ruleIntent2 EOF
            {
             before(grammarAccess.getIntent2Rule()); 
            pushFollow(FOLLOW_1);
            ruleIntent2();

            state._fsp--;

             after(grammarAccess.getIntent2Rule()); 
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
    // $ANTLR end "entryRuleIntent2"


    // $ANTLR start "ruleIntent2"
    // InternalBot.g:162:1: ruleIntent2 : ( ( rule__Intent2__Group__0 ) ) ;
    public final void ruleIntent2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:166:2: ( ( ( rule__Intent2__Group__0 ) ) )
            // InternalBot.g:167:2: ( ( rule__Intent2__Group__0 ) )
            {
            // InternalBot.g:167:2: ( ( rule__Intent2__Group__0 ) )
            // InternalBot.g:168:3: ( rule__Intent2__Group__0 )
            {
             before(grammarAccess.getIntent2Access().getGroup()); 
            // InternalBot.g:169:3: ( rule__Intent2__Group__0 )
            // InternalBot.g:169:4: rule__Intent2__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Intent2__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntent2Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntent2"


    // $ANTLR start "entryRuleIntent1"
    // InternalBot.g:178:1: entryRuleIntent1 : ruleIntent1 EOF ;
    public final void entryRuleIntent1() throws RecognitionException {
        try {
            // InternalBot.g:179:1: ( ruleIntent1 EOF )
            // InternalBot.g:180:1: ruleIntent1 EOF
            {
             before(grammarAccess.getIntent1Rule()); 
            pushFollow(FOLLOW_1);
            ruleIntent1();

            state._fsp--;

             after(grammarAccess.getIntent1Rule()); 
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
    // $ANTLR end "entryRuleIntent1"


    // $ANTLR start "ruleIntent1"
    // InternalBot.g:187:1: ruleIntent1 : ( ( rule__Intent1__Group__0 ) ) ;
    public final void ruleIntent1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:191:2: ( ( ( rule__Intent1__Group__0 ) ) )
            // InternalBot.g:192:2: ( ( rule__Intent1__Group__0 ) )
            {
            // InternalBot.g:192:2: ( ( rule__Intent1__Group__0 ) )
            // InternalBot.g:193:3: ( rule__Intent1__Group__0 )
            {
             before(grammarAccess.getIntent1Access().getGroup()); 
            // InternalBot.g:194:3: ( rule__Intent1__Group__0 )
            // InternalBot.g:194:4: rule__Intent1__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Intent1__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntent1Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntent1"


    // $ANTLR start "entryRuleIntentLanguageInputs"
    // InternalBot.g:203:1: entryRuleIntentLanguageInputs : ruleIntentLanguageInputs EOF ;
    public final void entryRuleIntentLanguageInputs() throws RecognitionException {
        try {
            // InternalBot.g:204:1: ( ruleIntentLanguageInputs EOF )
            // InternalBot.g:205:1: ruleIntentLanguageInputs EOF
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
    // InternalBot.g:212:1: ruleIntentLanguageInputs : ( ( rule__IntentLanguageInputs__Group__0 ) ) ;
    public final void ruleIntentLanguageInputs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:216:2: ( ( ( rule__IntentLanguageInputs__Group__0 ) ) )
            // InternalBot.g:217:2: ( ( rule__IntentLanguageInputs__Group__0 ) )
            {
            // InternalBot.g:217:2: ( ( rule__IntentLanguageInputs__Group__0 ) )
            // InternalBot.g:218:3: ( rule__IntentLanguageInputs__Group__0 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup()); 
            // InternalBot.g:219:3: ( rule__IntentLanguageInputs__Group__0 )
            // InternalBot.g:219:4: rule__IntentLanguageInputs__Group__0
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
    // InternalBot.g:228:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // InternalBot.g:229:1: ( ruleTransition EOF )
            // InternalBot.g:230:1: ruleTransition EOF
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
    // InternalBot.g:237:1: ruleTransition : ( ( rule__Transition__Group__0 ) ) ;
    public final void ruleTransition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:241:2: ( ( ( rule__Transition__Group__0 ) ) )
            // InternalBot.g:242:2: ( ( rule__Transition__Group__0 ) )
            {
            // InternalBot.g:242:2: ( ( rule__Transition__Group__0 ) )
            // InternalBot.g:243:3: ( rule__Transition__Group__0 )
            {
             before(grammarAccess.getTransitionAccess().getGroup()); 
            // InternalBot.g:244:3: ( rule__Transition__Group__0 )
            // InternalBot.g:244:4: rule__Transition__Group__0
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
    // InternalBot.g:253:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalBot.g:254:1: ( ruleState EOF )
            // InternalBot.g:255:1: ruleState EOF
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
    // InternalBot.g:262:1: ruleState : ( ( rule__State__Group__0 ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:266:2: ( ( ( rule__State__Group__0 ) ) )
            // InternalBot.g:267:2: ( ( rule__State__Group__0 ) )
            {
            // InternalBot.g:267:2: ( ( rule__State__Group__0 ) )
            // InternalBot.g:268:3: ( rule__State__Group__0 )
            {
             before(grammarAccess.getStateAccess().getGroup()); 
            // InternalBot.g:269:3: ( rule__State__Group__0 )
            // InternalBot.g:269:4: rule__State__Group__0
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
    // InternalBot.g:278:1: entryRuleState2 : ruleState2 EOF ;
    public final void entryRuleState2() throws RecognitionException {
        try {
            // InternalBot.g:279:1: ( ruleState2 EOF )
            // InternalBot.g:280:1: ruleState2 EOF
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
    // InternalBot.g:287:1: ruleState2 : ( ( rule__State2__Group__0 ) ) ;
    public final void ruleState2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:291:2: ( ( ( rule__State2__Group__0 ) ) )
            // InternalBot.g:292:2: ( ( rule__State2__Group__0 ) )
            {
            // InternalBot.g:292:2: ( ( rule__State2__Group__0 ) )
            // InternalBot.g:293:3: ( rule__State2__Group__0 )
            {
             before(grammarAccess.getState2Access().getGroup()); 
            // InternalBot.g:294:3: ( rule__State2__Group__0 )
            // InternalBot.g:294:4: rule__State2__Group__0
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
    // InternalBot.g:303:1: entryRuleIntentInput : ruleIntentInput EOF ;
    public final void entryRuleIntentInput() throws RecognitionException {
        try {
            // InternalBot.g:304:1: ( ruleIntentInput EOF )
            // InternalBot.g:305:1: ruleIntentInput EOF
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
    // InternalBot.g:312:1: ruleIntentInput : ( ( rule__IntentInput__Alternatives ) ) ;
    public final void ruleIntentInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:316:2: ( ( ( rule__IntentInput__Alternatives ) ) )
            // InternalBot.g:317:2: ( ( rule__IntentInput__Alternatives ) )
            {
            // InternalBot.g:317:2: ( ( rule__IntentInput__Alternatives ) )
            // InternalBot.g:318:3: ( rule__IntentInput__Alternatives )
            {
             before(grammarAccess.getIntentInputAccess().getAlternatives()); 
            // InternalBot.g:319:3: ( rule__IntentInput__Alternatives )
            // InternalBot.g:319:4: rule__IntentInput__Alternatives
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
    // InternalBot.g:328:1: entryRuleTrainingPhrase : ruleTrainingPhrase EOF ;
    public final void entryRuleTrainingPhrase() throws RecognitionException {
        try {
            // InternalBot.g:329:1: ( ruleTrainingPhrase EOF )
            // InternalBot.g:330:1: ruleTrainingPhrase EOF
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
    // InternalBot.g:337:1: ruleTrainingPhrase : ( ( rule__TrainingPhrase__Group__0 ) ) ;
    public final void ruleTrainingPhrase() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:341:2: ( ( ( rule__TrainingPhrase__Group__0 ) ) )
            // InternalBot.g:342:2: ( ( rule__TrainingPhrase__Group__0 ) )
            {
            // InternalBot.g:342:2: ( ( rule__TrainingPhrase__Group__0 ) )
            // InternalBot.g:343:3: ( rule__TrainingPhrase__Group__0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getGroup()); 
            // InternalBot.g:344:3: ( rule__TrainingPhrase__Group__0 )
            // InternalBot.g:344:4: rule__TrainingPhrase__Group__0
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
    // InternalBot.g:353:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // InternalBot.g:354:1: ( ruleParameter EOF )
            // InternalBot.g:355:1: ruleParameter EOF
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
    // InternalBot.g:362:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:366:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // InternalBot.g:367:2: ( ( rule__Parameter__Group__0 ) )
            {
            // InternalBot.g:367:2: ( ( rule__Parameter__Group__0 ) )
            // InternalBot.g:368:3: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // InternalBot.g:369:3: ( rule__Parameter__Group__0 )
            // InternalBot.g:369:4: rule__Parameter__Group__0
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
    // InternalBot.g:378:1: entryRuleParameter2 : ruleParameter2 EOF ;
    public final void entryRuleParameter2() throws RecognitionException {
        try {
            // InternalBot.g:379:1: ( ruleParameter2 EOF )
            // InternalBot.g:380:1: ruleParameter2 EOF
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
    // InternalBot.g:387:1: ruleParameter2 : ( ( rule__Parameter2__Group__0 ) ) ;
    public final void ruleParameter2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:391:2: ( ( ( rule__Parameter2__Group__0 ) ) )
            // InternalBot.g:392:2: ( ( rule__Parameter2__Group__0 ) )
            {
            // InternalBot.g:392:2: ( ( rule__Parameter2__Group__0 ) )
            // InternalBot.g:393:3: ( rule__Parameter2__Group__0 )
            {
             before(grammarAccess.getParameter2Access().getGroup()); 
            // InternalBot.g:394:3: ( rule__Parameter2__Group__0 )
            // InternalBot.g:394:4: rule__Parameter2__Group__0
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
    // InternalBot.g:403:1: entryRulePromptLanguage : rulePromptLanguage EOF ;
    public final void entryRulePromptLanguage() throws RecognitionException {
        try {
            // InternalBot.g:404:1: ( rulePromptLanguage EOF )
            // InternalBot.g:405:1: rulePromptLanguage EOF
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
    // InternalBot.g:412:1: rulePromptLanguage : ( ( rule__PromptLanguage__Group__0 ) ) ;
    public final void rulePromptLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:416:2: ( ( ( rule__PromptLanguage__Group__0 ) ) )
            // InternalBot.g:417:2: ( ( rule__PromptLanguage__Group__0 ) )
            {
            // InternalBot.g:417:2: ( ( rule__PromptLanguage__Group__0 ) )
            // InternalBot.g:418:3: ( rule__PromptLanguage__Group__0 )
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup()); 
            // InternalBot.g:419:3: ( rule__PromptLanguage__Group__0 )
            // InternalBot.g:419:4: rule__PromptLanguage__Group__0
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
    // InternalBot.g:428:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalBot.g:429:1: ( ruleLiteral EOF )
            // InternalBot.g:430:1: ruleLiteral EOF
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
    // InternalBot.g:437:1: ruleLiteral : ( ( rule__Literal__TextAssignment ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:441:2: ( ( ( rule__Literal__TextAssignment ) ) )
            // InternalBot.g:442:2: ( ( rule__Literal__TextAssignment ) )
            {
            // InternalBot.g:442:2: ( ( rule__Literal__TextAssignment ) )
            // InternalBot.g:443:3: ( rule__Literal__TextAssignment )
            {
             before(grammarAccess.getLiteralAccess().getTextAssignment()); 
            // InternalBot.g:444:3: ( rule__Literal__TextAssignment )
            // InternalBot.g:444:4: rule__Literal__TextAssignment
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
    // InternalBot.g:453:1: entryRuleEntityToken : ruleEntityToken EOF ;
    public final void entryRuleEntityToken() throws RecognitionException {
        try {
            // InternalBot.g:454:1: ( ruleEntityToken EOF )
            // InternalBot.g:455:1: ruleEntityToken EOF
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
    // InternalBot.g:462:1: ruleEntityToken : ( ( rule__EntityToken__Group__0 ) ) ;
    public final void ruleEntityToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:466:2: ( ( ( rule__EntityToken__Group__0 ) ) )
            // InternalBot.g:467:2: ( ( rule__EntityToken__Group__0 ) )
            {
            // InternalBot.g:467:2: ( ( rule__EntityToken__Group__0 ) )
            // InternalBot.g:468:3: ( rule__EntityToken__Group__0 )
            {
             before(grammarAccess.getEntityTokenAccess().getGroup()); 
            // InternalBot.g:469:3: ( rule__EntityToken__Group__0 )
            // InternalBot.g:469:4: rule__EntityToken__Group__0
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
    // InternalBot.g:478:1: entryRuleParameterToken : ruleParameterToken EOF ;
    public final void entryRuleParameterToken() throws RecognitionException {
        try {
            // InternalBot.g:479:1: ( ruleParameterToken EOF )
            // InternalBot.g:480:1: ruleParameterToken EOF
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
    // InternalBot.g:487:1: ruleParameterToken : ( ( rule__ParameterToken__Group__0 ) ) ;
    public final void ruleParameterToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:491:2: ( ( ( rule__ParameterToken__Group__0 ) ) )
            // InternalBot.g:492:2: ( ( rule__ParameterToken__Group__0 ) )
            {
            // InternalBot.g:492:2: ( ( rule__ParameterToken__Group__0 ) )
            // InternalBot.g:493:3: ( rule__ParameterToken__Group__0 )
            {
             before(grammarAccess.getParameterTokenAccess().getGroup()); 
            // InternalBot.g:494:3: ( rule__ParameterToken__Group__0 )
            // InternalBot.g:494:4: rule__ParameterToken__Group__0
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
    // InternalBot.g:503:1: entryRuleParameterRefenceToken : ruleParameterRefenceToken EOF ;
    public final void entryRuleParameterRefenceToken() throws RecognitionException {
        try {
            // InternalBot.g:504:1: ( ruleParameterRefenceToken EOF )
            // InternalBot.g:505:1: ruleParameterRefenceToken EOF
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
    // InternalBot.g:512:1: ruleParameterRefenceToken : ( ( rule__ParameterRefenceToken__Group__0 ) ) ;
    public final void ruleParameterRefenceToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:516:2: ( ( ( rule__ParameterRefenceToken__Group__0 ) ) )
            // InternalBot.g:517:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            {
            // InternalBot.g:517:2: ( ( rule__ParameterRefenceToken__Group__0 ) )
            // InternalBot.g:518:3: ( rule__ParameterRefenceToken__Group__0 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getGroup()); 
            // InternalBot.g:519:3: ( rule__ParameterRefenceToken__Group__0 )
            // InternalBot.g:519:4: rule__ParameterRefenceToken__Group__0
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
    // InternalBot.g:528:1: entryRuleHTTPRequestToken : ruleHTTPRequestToken EOF ;
    public final void entryRuleHTTPRequestToken() throws RecognitionException {
        try {
            // InternalBot.g:529:1: ( ruleHTTPRequestToken EOF )
            // InternalBot.g:530:1: ruleHTTPRequestToken EOF
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
    // InternalBot.g:537:1: ruleHTTPRequestToken : ( ( rule__HTTPRequestToken__Group__0 ) ) ;
    public final void ruleHTTPRequestToken() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:541:2: ( ( ( rule__HTTPRequestToken__Group__0 ) ) )
            // InternalBot.g:542:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            {
            // InternalBot.g:542:2: ( ( rule__HTTPRequestToken__Group__0 ) )
            // InternalBot.g:543:3: ( rule__HTTPRequestToken__Group__0 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup()); 
            // InternalBot.g:544:3: ( rule__HTTPRequestToken__Group__0 )
            // InternalBot.g:544:4: rule__HTTPRequestToken__Group__0
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
    // InternalBot.g:553:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // InternalBot.g:554:1: ( ruleEntity EOF )
            // InternalBot.g:555:1: ruleEntity EOF
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
    // InternalBot.g:562:1: ruleEntity : ( ( rule__Entity__Alternatives ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:566:2: ( ( ( rule__Entity__Alternatives ) ) )
            // InternalBot.g:567:2: ( ( rule__Entity__Alternatives ) )
            {
            // InternalBot.g:567:2: ( ( rule__Entity__Alternatives ) )
            // InternalBot.g:568:3: ( rule__Entity__Alternatives )
            {
             before(grammarAccess.getEntityAccess().getAlternatives()); 
            // InternalBot.g:569:3: ( rule__Entity__Alternatives )
            // InternalBot.g:569:4: rule__Entity__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Entity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleSimpleEntity"
    // InternalBot.g:578:1: entryRuleSimpleEntity : ruleSimpleEntity EOF ;
    public final void entryRuleSimpleEntity() throws RecognitionException {
        try {
            // InternalBot.g:579:1: ( ruleSimpleEntity EOF )
            // InternalBot.g:580:1: ruleSimpleEntity EOF
            {
             before(grammarAccess.getSimpleEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleEntity();

            state._fsp--;

             after(grammarAccess.getSimpleEntityRule()); 
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
    // $ANTLR end "entryRuleSimpleEntity"


    // $ANTLR start "ruleSimpleEntity"
    // InternalBot.g:587:1: ruleSimpleEntity : ( ( rule__SimpleEntity__Group__0 ) ) ;
    public final void ruleSimpleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:591:2: ( ( ( rule__SimpleEntity__Group__0 ) ) )
            // InternalBot.g:592:2: ( ( rule__SimpleEntity__Group__0 ) )
            {
            // InternalBot.g:592:2: ( ( rule__SimpleEntity__Group__0 ) )
            // InternalBot.g:593:3: ( rule__SimpleEntity__Group__0 )
            {
             before(grammarAccess.getSimpleEntityAccess().getGroup()); 
            // InternalBot.g:594:3: ( rule__SimpleEntity__Group__0 )
            // InternalBot.g:594:4: rule__SimpleEntity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SimpleEntity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleEntity"


    // $ANTLR start "entryRuleComplexEntity"
    // InternalBot.g:603:1: entryRuleComplexEntity : ruleComplexEntity EOF ;
    public final void entryRuleComplexEntity() throws RecognitionException {
        try {
            // InternalBot.g:604:1: ( ruleComplexEntity EOF )
            // InternalBot.g:605:1: ruleComplexEntity EOF
            {
             before(grammarAccess.getComplexEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleComplexEntity();

            state._fsp--;

             after(grammarAccess.getComplexEntityRule()); 
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
    // $ANTLR end "entryRuleComplexEntity"


    // $ANTLR start "ruleComplexEntity"
    // InternalBot.g:612:1: ruleComplexEntity : ( ( rule__ComplexEntity__Group__0 ) ) ;
    public final void ruleComplexEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:616:2: ( ( ( rule__ComplexEntity__Group__0 ) ) )
            // InternalBot.g:617:2: ( ( rule__ComplexEntity__Group__0 ) )
            {
            // InternalBot.g:617:2: ( ( rule__ComplexEntity__Group__0 ) )
            // InternalBot.g:618:3: ( rule__ComplexEntity__Group__0 )
            {
             before(grammarAccess.getComplexEntityAccess().getGroup()); 
            // InternalBot.g:619:3: ( rule__ComplexEntity__Group__0 )
            // InternalBot.g:619:4: rule__ComplexEntity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComplexEntity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComplexEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComplexEntity"


    // $ANTLR start "entryRuleRegexEntity"
    // InternalBot.g:628:1: entryRuleRegexEntity : ruleRegexEntity EOF ;
    public final void entryRuleRegexEntity() throws RecognitionException {
        try {
            // InternalBot.g:629:1: ( ruleRegexEntity EOF )
            // InternalBot.g:630:1: ruleRegexEntity EOF
            {
             before(grammarAccess.getRegexEntityRule()); 
            pushFollow(FOLLOW_1);
            ruleRegexEntity();

            state._fsp--;

             after(grammarAccess.getRegexEntityRule()); 
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
    // $ANTLR end "entryRuleRegexEntity"


    // $ANTLR start "ruleRegexEntity"
    // InternalBot.g:637:1: ruleRegexEntity : ( ( rule__RegexEntity__Group__0 ) ) ;
    public final void ruleRegexEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:641:2: ( ( ( rule__RegexEntity__Group__0 ) ) )
            // InternalBot.g:642:2: ( ( rule__RegexEntity__Group__0 ) )
            {
            // InternalBot.g:642:2: ( ( rule__RegexEntity__Group__0 ) )
            // InternalBot.g:643:3: ( rule__RegexEntity__Group__0 )
            {
             before(grammarAccess.getRegexEntityAccess().getGroup()); 
            // InternalBot.g:644:3: ( rule__RegexEntity__Group__0 )
            // InternalBot.g:644:4: rule__RegexEntity__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RegexEntity__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRegexEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRegexEntity"


    // $ANTLR start "entryRuleSLanguageInput"
    // InternalBot.g:653:1: entryRuleSLanguageInput : ruleSLanguageInput EOF ;
    public final void entryRuleSLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:654:1: ( ruleSLanguageInput EOF )
            // InternalBot.g:655:1: ruleSLanguageInput EOF
            {
             before(grammarAccess.getSLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleSLanguageInput();

            state._fsp--;

             after(grammarAccess.getSLanguageInputRule()); 
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
    // $ANTLR end "entryRuleSLanguageInput"


    // $ANTLR start "ruleSLanguageInput"
    // InternalBot.g:662:1: ruleSLanguageInput : ( ( rule__SLanguageInput__Group__0 ) ) ;
    public final void ruleSLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:666:2: ( ( ( rule__SLanguageInput__Group__0 ) ) )
            // InternalBot.g:667:2: ( ( rule__SLanguageInput__Group__0 ) )
            {
            // InternalBot.g:667:2: ( ( rule__SLanguageInput__Group__0 ) )
            // InternalBot.g:668:3: ( rule__SLanguageInput__Group__0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup()); 
            // InternalBot.g:669:3: ( rule__SLanguageInput__Group__0 )
            // InternalBot.g:669:4: rule__SLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSLanguageInput"


    // $ANTLR start "entryRuleCLanguageInput"
    // InternalBot.g:678:1: entryRuleCLanguageInput : ruleCLanguageInput EOF ;
    public final void entryRuleCLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:679:1: ( ruleCLanguageInput EOF )
            // InternalBot.g:680:1: ruleCLanguageInput EOF
            {
             before(grammarAccess.getCLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleCLanguageInput();

            state._fsp--;

             after(grammarAccess.getCLanguageInputRule()); 
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
    // $ANTLR end "entryRuleCLanguageInput"


    // $ANTLR start "ruleCLanguageInput"
    // InternalBot.g:687:1: ruleCLanguageInput : ( ( rule__CLanguageInput__Group__0 ) ) ;
    public final void ruleCLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:691:2: ( ( ( rule__CLanguageInput__Group__0 ) ) )
            // InternalBot.g:692:2: ( ( rule__CLanguageInput__Group__0 ) )
            {
            // InternalBot.g:692:2: ( ( rule__CLanguageInput__Group__0 ) )
            // InternalBot.g:693:3: ( rule__CLanguageInput__Group__0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup()); 
            // InternalBot.g:694:3: ( rule__CLanguageInput__Group__0 )
            // InternalBot.g:694:4: rule__CLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCLanguageInput"


    // $ANTLR start "entryRuleRLanguageInput"
    // InternalBot.g:703:1: entryRuleRLanguageInput : ruleRLanguageInput EOF ;
    public final void entryRuleRLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:704:1: ( ruleRLanguageInput EOF )
            // InternalBot.g:705:1: ruleRLanguageInput EOF
            {
             before(grammarAccess.getRLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleRLanguageInput();

            state._fsp--;

             after(grammarAccess.getRLanguageInputRule()); 
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
    // $ANTLR end "entryRuleRLanguageInput"


    // $ANTLR start "ruleRLanguageInput"
    // InternalBot.g:712:1: ruleRLanguageInput : ( ( rule__RLanguageInput__Group__0 ) ) ;
    public final void ruleRLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:716:2: ( ( ( rule__RLanguageInput__Group__0 ) ) )
            // InternalBot.g:717:2: ( ( rule__RLanguageInput__Group__0 ) )
            {
            // InternalBot.g:717:2: ( ( rule__RLanguageInput__Group__0 ) )
            // InternalBot.g:718:3: ( rule__RLanguageInput__Group__0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup()); 
            // InternalBot.g:719:3: ( rule__RLanguageInput__Group__0 )
            // InternalBot.g:719:4: rule__RLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRLanguageInput"


    // $ANTLR start "entryRuleRegexInput"
    // InternalBot.g:728:1: entryRuleRegexInput : ruleRegexInput EOF ;
    public final void entryRuleRegexInput() throws RecognitionException {
        try {
            // InternalBot.g:729:1: ( ruleRegexInput EOF )
            // InternalBot.g:730:1: ruleRegexInput EOF
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
    // InternalBot.g:737:1: ruleRegexInput : ( ( rule__RegexInput__Group__0 ) ) ;
    public final void ruleRegexInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:741:2: ( ( ( rule__RegexInput__Group__0 ) ) )
            // InternalBot.g:742:2: ( ( rule__RegexInput__Group__0 ) )
            {
            // InternalBot.g:742:2: ( ( rule__RegexInput__Group__0 ) )
            // InternalBot.g:743:3: ( rule__RegexInput__Group__0 )
            {
             before(grammarAccess.getRegexInputAccess().getGroup()); 
            // InternalBot.g:744:3: ( rule__RegexInput__Group__0 )
            // InternalBot.g:744:4: rule__RegexInput__Group__0
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
    // InternalBot.g:753:1: entryRuleCompositeInput : ruleCompositeInput EOF ;
    public final void entryRuleCompositeInput() throws RecognitionException {
        try {
            // InternalBot.g:754:1: ( ruleCompositeInput EOF )
            // InternalBot.g:755:1: ruleCompositeInput EOF
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
    // InternalBot.g:762:1: ruleCompositeInput : ( ( rule__CompositeInput__Group__0 ) ) ;
    public final void ruleCompositeInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:766:2: ( ( ( rule__CompositeInput__Group__0 ) ) )
            // InternalBot.g:767:2: ( ( rule__CompositeInput__Group__0 ) )
            {
            // InternalBot.g:767:2: ( ( rule__CompositeInput__Group__0 ) )
            // InternalBot.g:768:3: ( rule__CompositeInput__Group__0 )
            {
             before(grammarAccess.getCompositeInputAccess().getGroup()); 
            // InternalBot.g:769:3: ( rule__CompositeInput__Group__0 )
            // InternalBot.g:769:4: rule__CompositeInput__Group__0
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
    // InternalBot.g:778:1: entryRuleSimpleInput : ruleSimpleInput EOF ;
    public final void entryRuleSimpleInput() throws RecognitionException {
        try {
            // InternalBot.g:779:1: ( ruleSimpleInput EOF )
            // InternalBot.g:780:1: ruleSimpleInput EOF
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
    // InternalBot.g:787:1: ruleSimpleInput : ( ( rule__SimpleInput__Group__0 ) ) ;
    public final void ruleSimpleInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:791:2: ( ( ( rule__SimpleInput__Group__0 ) ) )
            // InternalBot.g:792:2: ( ( rule__SimpleInput__Group__0 ) )
            {
            // InternalBot.g:792:2: ( ( rule__SimpleInput__Group__0 ) )
            // InternalBot.g:793:3: ( rule__SimpleInput__Group__0 )
            {
             before(grammarAccess.getSimpleInputAccess().getGroup()); 
            // InternalBot.g:794:3: ( rule__SimpleInput__Group__0 )
            // InternalBot.g:794:4: rule__SimpleInput__Group__0
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
    // InternalBot.g:803:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // InternalBot.g:804:1: ( ruleText EOF )
            // InternalBot.g:805:1: ruleText EOF
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
    // InternalBot.g:812:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:816:2: ( ( ( rule__Text__Group__0 ) ) )
            // InternalBot.g:817:2: ( ( rule__Text__Group__0 ) )
            {
            // InternalBot.g:817:2: ( ( rule__Text__Group__0 ) )
            // InternalBot.g:818:3: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // InternalBot.g:819:3: ( rule__Text__Group__0 )
            // InternalBot.g:819:4: rule__Text__Group__0
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
    // InternalBot.g:828:1: entryRuleTextLanguageInput : ruleTextLanguageInput EOF ;
    public final void entryRuleTextLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:829:1: ( ruleTextLanguageInput EOF )
            // InternalBot.g:830:1: ruleTextLanguageInput EOF
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
    // InternalBot.g:837:1: ruleTextLanguageInput : ( ( rule__TextLanguageInput__Group__0 ) ) ;
    public final void ruleTextLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:841:2: ( ( ( rule__TextLanguageInput__Group__0 ) ) )
            // InternalBot.g:842:2: ( ( rule__TextLanguageInput__Group__0 ) )
            {
            // InternalBot.g:842:2: ( ( rule__TextLanguageInput__Group__0 ) )
            // InternalBot.g:843:3: ( rule__TextLanguageInput__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup()); 
            // InternalBot.g:844:3: ( rule__TextLanguageInput__Group__0 )
            // InternalBot.g:844:4: rule__TextLanguageInput__Group__0
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
    // InternalBot.g:853:1: entryRuleHTTPResponse : ruleHTTPResponse EOF ;
    public final void entryRuleHTTPResponse() throws RecognitionException {
        try {
            // InternalBot.g:854:1: ( ruleHTTPResponse EOF )
            // InternalBot.g:855:1: ruleHTTPResponse EOF
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
    // InternalBot.g:862:1: ruleHTTPResponse : ( ( rule__HTTPResponse__Group__0 ) ) ;
    public final void ruleHTTPResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:866:2: ( ( ( rule__HTTPResponse__Group__0 ) ) )
            // InternalBot.g:867:2: ( ( rule__HTTPResponse__Group__0 ) )
            {
            // InternalBot.g:867:2: ( ( rule__HTTPResponse__Group__0 ) )
            // InternalBot.g:868:3: ( rule__HTTPResponse__Group__0 )
            {
             before(grammarAccess.getHTTPResponseAccess().getGroup()); 
            // InternalBot.g:869:3: ( rule__HTTPResponse__Group__0 )
            // InternalBot.g:869:4: rule__HTTPResponse__Group__0
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
    // InternalBot.g:878:1: entryRuleHTTPRequest : ruleHTTPRequest EOF ;
    public final void entryRuleHTTPRequest() throws RecognitionException {
        try {
            // InternalBot.g:879:1: ( ruleHTTPRequest EOF )
            // InternalBot.g:880:1: ruleHTTPRequest EOF
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
    // InternalBot.g:887:1: ruleHTTPRequest : ( ( rule__HTTPRequest__Group__0 ) ) ;
    public final void ruleHTTPRequest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:891:2: ( ( ( rule__HTTPRequest__Group__0 ) ) )
            // InternalBot.g:892:2: ( ( rule__HTTPRequest__Group__0 ) )
            {
            // InternalBot.g:892:2: ( ( rule__HTTPRequest__Group__0 ) )
            // InternalBot.g:893:3: ( rule__HTTPRequest__Group__0 )
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup()); 
            // InternalBot.g:894:3: ( rule__HTTPRequest__Group__0 )
            // InternalBot.g:894:4: rule__HTTPRequest__Group__0
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
    // InternalBot.g:903:1: entryRuleImage : ruleImage EOF ;
    public final void entryRuleImage() throws RecognitionException {
        try {
            // InternalBot.g:904:1: ( ruleImage EOF )
            // InternalBot.g:905:1: ruleImage EOF
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
    // InternalBot.g:912:1: ruleImage : ( ( rule__Image__Group__0 ) ) ;
    public final void ruleImage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:916:2: ( ( ( rule__Image__Group__0 ) ) )
            // InternalBot.g:917:2: ( ( rule__Image__Group__0 ) )
            {
            // InternalBot.g:917:2: ( ( rule__Image__Group__0 ) )
            // InternalBot.g:918:3: ( rule__Image__Group__0 )
            {
             before(grammarAccess.getImageAccess().getGroup()); 
            // InternalBot.g:919:3: ( rule__Image__Group__0 )
            // InternalBot.g:919:4: rule__Image__Group__0
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


    // $ANTLR start "entryRuleEmpty"
    // InternalBot.g:928:1: entryRuleEmpty : ruleEmpty EOF ;
    public final void entryRuleEmpty() throws RecognitionException {
        try {
            // InternalBot.g:929:1: ( ruleEmpty EOF )
            // InternalBot.g:930:1: ruleEmpty EOF
            {
             before(grammarAccess.getEmptyRule()); 
            pushFollow(FOLLOW_1);
            ruleEmpty();

            state._fsp--;

             after(grammarAccess.getEmptyRule()); 
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
    // $ANTLR end "entryRuleEmpty"


    // $ANTLR start "ruleEmpty"
    // InternalBot.g:937:1: ruleEmpty : ( ( rule__Empty__Group__0 ) ) ;
    public final void ruleEmpty() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:941:2: ( ( ( rule__Empty__Group__0 ) ) )
            // InternalBot.g:942:2: ( ( rule__Empty__Group__0 ) )
            {
            // InternalBot.g:942:2: ( ( rule__Empty__Group__0 ) )
            // InternalBot.g:943:3: ( rule__Empty__Group__0 )
            {
             before(grammarAccess.getEmptyAccess().getGroup()); 
            // InternalBot.g:944:3: ( rule__Empty__Group__0 )
            // InternalBot.g:944:4: rule__Empty__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Empty__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEmptyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEmpty"


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:953:1: entryRuleTextLanguageInputHttpResponse : ruleTextLanguageInputHttpResponse EOF ;
    public final void entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:954:1: ( ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:955:1: ruleTextLanguageInputHttpResponse EOF
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
    // InternalBot.g:962:1: ruleTextLanguageInputHttpResponse : ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) ;
    public final void ruleTextLanguageInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:966:2: ( ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) )
            // InternalBot.g:967:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            {
            // InternalBot.g:967:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            // InternalBot.g:968:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 
            // InternalBot.g:969:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            // InternalBot.g:969:4: rule__TextLanguageInputHttpResponse__Group__0
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
    // InternalBot.g:978:1: entryRuleTextInputHttpResponse : ruleTextInputHttpResponse EOF ;
    public final void entryRuleTextInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:979:1: ( ruleTextInputHttpResponse EOF )
            // InternalBot.g:980:1: ruleTextInputHttpResponse EOF
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
    // InternalBot.g:987:1: ruleTextInputHttpResponse : ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) ;
    public final void ruleTextInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:991:2: ( ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) )
            // InternalBot.g:992:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            {
            // InternalBot.g:992:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            // InternalBot.g:993:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            {
            // InternalBot.g:993:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) )
            // InternalBot.g:994:4: ( rule__TextInputHttpResponse__TokensAssignment )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:995:4: ( rule__TextInputHttpResponse__TokensAssignment )
            // InternalBot.g:995:5: rule__TextInputHttpResponse__TokensAssignment
            {
            pushFollow(FOLLOW_3);
            rule__TextInputHttpResponse__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }

            // InternalBot.g:998:3: ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            // InternalBot.g:999:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:1000:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==69||LA1_0==74) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:1000:5: rule__TextInputHttpResponse__TokensAssignment
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
    // InternalBot.g:1010:1: entryRuleTextInputText : ruleTextInputText EOF ;
    public final void entryRuleTextInputText() throws RecognitionException {
        try {
            // InternalBot.g:1011:1: ( ruleTextInputText EOF )
            // InternalBot.g:1012:1: ruleTextInputText EOF
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
    // InternalBot.g:1019:1: ruleTextInputText : ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) ;
    public final void ruleTextInputText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1023:2: ( ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) )
            // InternalBot.g:1024:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            {
            // InternalBot.g:1024:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            // InternalBot.g:1025:3: ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* )
            {
            // InternalBot.g:1025:3: ( ( rule__TextInputText__TokensAssignment ) )
            // InternalBot.g:1026:4: ( rule__TextInputText__TokensAssignment )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:1027:4: ( rule__TextInputText__TokensAssignment )
            // InternalBot.g:1027:5: rule__TextInputText__TokensAssignment
            {
            pushFollow(FOLLOW_4);
            rule__TextInputText__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }

            // InternalBot.g:1030:3: ( ( rule__TextInputText__TokensAssignment )* )
            // InternalBot.g:1031:4: ( rule__TextInputText__TokensAssignment )*
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:1032:4: ( rule__TextInputText__TokensAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==69) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:1032:5: rule__TextInputText__TokensAssignment
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
    // InternalBot.g:1042:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBot.g:1043:1: ( ruleKeyValue EOF )
            // InternalBot.g:1044:1: ruleKeyValue EOF
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
    // InternalBot.g:1051:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1055:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBot.g:1056:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBot.g:1056:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBot.g:1057:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBot.g:1058:3: ( rule__KeyValue__Group__0 )
            // InternalBot.g:1058:4: rule__KeyValue__Group__0
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
    // InternalBot.g:1067:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalBot.g:1068:1: ( ruleData EOF )
            // InternalBot.g:1069:1: ruleData EOF
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
    // InternalBot.g:1076:1: ruleData : ( ( rule__Data__Group__0 ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1080:2: ( ( ( rule__Data__Group__0 ) ) )
            // InternalBot.g:1081:2: ( ( rule__Data__Group__0 ) )
            {
            // InternalBot.g:1081:2: ( ( rule__Data__Group__0 ) )
            // InternalBot.g:1082:3: ( rule__Data__Group__0 )
            {
             before(grammarAccess.getDataAccess().getGroup()); 
            // InternalBot.g:1083:3: ( rule__Data__Group__0 )
            // InternalBot.g:1083:4: rule__Data__Group__0
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
    // InternalBot.g:1092:1: ruleDefaultEntity : ( ( rule__DefaultEntity__Alternatives ) ) ;
    public final void ruleDefaultEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1096:1: ( ( ( rule__DefaultEntity__Alternatives ) ) )
            // InternalBot.g:1097:2: ( ( rule__DefaultEntity__Alternatives ) )
            {
            // InternalBot.g:1097:2: ( ( rule__DefaultEntity__Alternatives ) )
            // InternalBot.g:1098:3: ( rule__DefaultEntity__Alternatives )
            {
             before(grammarAccess.getDefaultEntityAccess().getAlternatives()); 
            // InternalBot.g:1099:3: ( rule__DefaultEntity__Alternatives )
            // InternalBot.g:1099:4: rule__DefaultEntity__Alternatives
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
    // InternalBot.g:1108:1: ruleHTTPReturnType : ( ( rule__HTTPReturnType__Alternatives ) ) ;
    public final void ruleHTTPReturnType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1112:1: ( ( ( rule__HTTPReturnType__Alternatives ) ) )
            // InternalBot.g:1113:2: ( ( rule__HTTPReturnType__Alternatives ) )
            {
            // InternalBot.g:1113:2: ( ( rule__HTTPReturnType__Alternatives ) )
            // InternalBot.g:1114:3: ( rule__HTTPReturnType__Alternatives )
            {
             before(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 
            // InternalBot.g:1115:3: ( rule__HTTPReturnType__Alternatives )
            // InternalBot.g:1115:4: rule__HTTPReturnType__Alternatives
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
    // InternalBot.g:1124:1: ruleLanguage : ( ( rule__Language__Alternatives ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1128:1: ( ( ( rule__Language__Alternatives ) ) )
            // InternalBot.g:1129:2: ( ( rule__Language__Alternatives ) )
            {
            // InternalBot.g:1129:2: ( ( rule__Language__Alternatives ) )
            // InternalBot.g:1130:3: ( rule__Language__Alternatives )
            {
             before(grammarAccess.getLanguageAccess().getAlternatives()); 
            // InternalBot.g:1131:3: ( rule__Language__Alternatives )
            // InternalBot.g:1131:4: rule__Language__Alternatives
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
    // InternalBot.g:1140:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1144:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalBot.g:1145:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalBot.g:1145:2: ( ( rule__DataType__Alternatives ) )
            // InternalBot.g:1146:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalBot.g:1147:3: ( rule__DataType__Alternatives )
            // InternalBot.g:1147:4: rule__DataType__Alternatives
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
    // InternalBot.g:1156:1: ruleMethod : ( ( rule__Method__Alternatives ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1160:1: ( ( ( rule__Method__Alternatives ) ) )
            // InternalBot.g:1161:2: ( ( rule__Method__Alternatives ) )
            {
            // InternalBot.g:1161:2: ( ( rule__Method__Alternatives ) )
            // InternalBot.g:1162:3: ( rule__Method__Alternatives )
            {
             before(grammarAccess.getMethodAccess().getAlternatives()); 
            // InternalBot.g:1163:3: ( rule__Method__Alternatives )
            // InternalBot.g:1163:4: rule__Method__Alternatives
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
    // InternalBot.g:1171:1: rule__Action__Alternatives : ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) | ( ruleEmpty ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1175:1: ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) | ( ruleEmpty ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 84:
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
            case 90:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalBot.g:1176:2: ( ruleText )
                    {
                    // InternalBot.g:1176:2: ( ruleText )
                    // InternalBot.g:1177:3: ruleText
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
                    // InternalBot.g:1182:2: ( ruleHTTPRequest )
                    {
                    // InternalBot.g:1182:2: ( ruleHTTPRequest )
                    // InternalBot.g:1183:3: ruleHTTPRequest
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
                    // InternalBot.g:1188:2: ( ruleImage )
                    {
                    // InternalBot.g:1188:2: ( ruleImage )
                    // InternalBot.g:1189:3: ruleImage
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
                    // InternalBot.g:1194:2: ( ruleHTTPResponse )
                    {
                    // InternalBot.g:1194:2: ( ruleHTTPResponse )
                    // InternalBot.g:1195:3: ruleHTTPResponse
                    {
                     before(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleHTTPResponse();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1200:2: ( ruleEmpty )
                    {
                    // InternalBot.g:1200:2: ( ruleEmpty )
                    // InternalBot.g:1201:3: ruleEmpty
                    {
                     before(grammarAccess.getActionAccess().getEmptyParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleEmpty();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getEmptyParserRuleCall_4()); 

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
    // InternalBot.g:1210:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1214:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalBot.g:1215:2: ( RULE_STRING )
                    {
                    // InternalBot.g:1215:2: ( RULE_STRING )
                    // InternalBot.g:1216:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1221:2: ( RULE_ID )
                    {
                    // InternalBot.g:1221:2: ( RULE_ID )
                    // InternalBot.g:1222:3: RULE_ID
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


    // $ANTLR start "rule__Intent__Alternatives"
    // InternalBot.g:1231:1: rule__Intent__Alternatives : ( ( ruleIntent1 ) | ( ruleIntent2 ) );
    public final void rule__Intent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1235:1: ( ( ruleIntent1 ) | ( ruleIntent2 ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 91:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==51) ) {
                        alt5=2;
                    }
                    else if ( (LA5_3==EOF||(LA5_3>=RULE_STRING && LA5_3<=RULE_ID)||LA5_3==53||(LA5_3>=55 && LA5_3<=56)) ) {
                        alt5=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case RULE_STRING:
                case RULE_ID:
                case 53:
                case 55:
                case 56:
                    {
                    alt5=1;
                    }
                    break;
                case 51:
                    {
                    alt5=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA5_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 91:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==51) ) {
                        alt5=2;
                    }
                    else if ( (LA5_3==EOF||(LA5_3>=RULE_STRING && LA5_3<=RULE_ID)||LA5_3==53||(LA5_3>=55 && LA5_3<=56)) ) {
                        alt5=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case RULE_STRING:
                case RULE_ID:
                case 53:
                case 55:
                case 56:
                    {
                    alt5=1;
                    }
                    break;
                case 51:
                    {
                    alt5=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalBot.g:1236:2: ( ruleIntent1 )
                    {
                    // InternalBot.g:1236:2: ( ruleIntent1 )
                    // InternalBot.g:1237:3: ruleIntent1
                    {
                     before(grammarAccess.getIntentAccess().getIntent1ParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntent1();

                    state._fsp--;

                     after(grammarAccess.getIntentAccess().getIntent1ParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1242:2: ( ruleIntent2 )
                    {
                    // InternalBot.g:1242:2: ( ruleIntent2 )
                    // InternalBot.g:1243:3: ruleIntent2
                    {
                     before(grammarAccess.getIntentAccess().getIntent2ParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleIntent2();

                    state._fsp--;

                     after(grammarAccess.getIntentAccess().getIntent2ParserRuleCall_1()); 

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
    // $ANTLR end "rule__Intent__Alternatives"


    // $ANTLR start "rule__Transition__TargetAlternatives_2_1_0"
    // InternalBot.g:1252:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );
    public final void rule__Transition__TargetAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1256:1: ( ( ruleState ) | ( ruleState2 ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBot.g:1257:2: ( ruleState )
                    {
                    // InternalBot.g:1257:2: ( ruleState )
                    // InternalBot.g:1258:3: ruleState
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
                    // InternalBot.g:1263:2: ( ruleState2 )
                    {
                    // InternalBot.g:1263:2: ( ruleState2 )
                    // InternalBot.g:1264:3: ruleState2
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
    // InternalBot.g:1273:1: rule__IntentInput__Alternatives : ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) );
    public final void rule__IntentInput__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1277:1: ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||LA7_0==72) ) {
                alt7=1;
            }
            else if ( (LA7_0==79) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBot.g:1278:2: ( ruleTrainingPhrase )
                    {
                    // InternalBot.g:1278:2: ( ruleTrainingPhrase )
                    // InternalBot.g:1279:3: ruleTrainingPhrase
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
                    // InternalBot.g:1284:2: ( ruleRegexInput )
                    {
                    // InternalBot.g:1284:2: ( ruleRegexInput )
                    // InternalBot.g:1285:3: ruleRegexInput
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
    // InternalBot.g:1294:1: rule__TrainingPhrase__TokensAlternatives_1_0 : ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) );
    public final void rule__TrainingPhrase__TokensAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1298:1: ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            else if ( (LA8_0==72) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBot.g:1299:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1299:2: ( ruleLiteral )
                    // InternalBot.g:1300:3: ruleLiteral
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
                    // InternalBot.g:1305:2: ( ruleParameterRefenceToken )
                    {
                    // InternalBot.g:1305:2: ( ruleParameterRefenceToken )
                    // InternalBot.g:1306:3: ruleParameterRefenceToken
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
    // InternalBot.g:1315:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1319:1: ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=11 && LA9_0<=15)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBot.g:1320:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    {
                    // InternalBot.g:1320:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    // InternalBot.g:1321:3: ( rule__Parameter__EntityAssignment_3_0 )
                    {
                     before(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 
                    // InternalBot.g:1322:3: ( rule__Parameter__EntityAssignment_3_0 )
                    // InternalBot.g:1322:4: rule__Parameter__EntityAssignment_3_0
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
                    // InternalBot.g:1326:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    {
                    // InternalBot.g:1326:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    // InternalBot.g:1327:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    {
                     before(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 
                    // InternalBot.g:1328:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    // InternalBot.g:1328:4: rule__Parameter__DefaultEntityAssignment_3_1
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


    // $ANTLR start "rule__Entity__Alternatives"
    // InternalBot.g:1336:1: rule__Entity__Alternatives : ( ( ruleSimpleEntity ) | ( ruleComplexEntity ) | ( ruleRegexEntity ) );
    public final void rule__Entity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1340:1: ( ( ruleSimpleEntity ) | ( ruleComplexEntity ) | ( ruleRegexEntity ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt10=1;
                }
                break;
            case 77:
                {
                alt10=2;
                }
                break;
            case 78:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalBot.g:1341:2: ( ruleSimpleEntity )
                    {
                    // InternalBot.g:1341:2: ( ruleSimpleEntity )
                    // InternalBot.g:1342:3: ruleSimpleEntity
                    {
                     before(grammarAccess.getEntityAccess().getSimpleEntityParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSimpleEntity();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getSimpleEntityParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1347:2: ( ruleComplexEntity )
                    {
                    // InternalBot.g:1347:2: ( ruleComplexEntity )
                    // InternalBot.g:1348:3: ruleComplexEntity
                    {
                     before(grammarAccess.getEntityAccess().getComplexEntityParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleComplexEntity();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getComplexEntityParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1353:2: ( ruleRegexEntity )
                    {
                    // InternalBot.g:1353:2: ( ruleRegexEntity )
                    // InternalBot.g:1354:3: ruleRegexEntity
                    {
                     before(grammarAccess.getEntityAccess().getRegexEntityParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleRegexEntity();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getRegexEntityParserRuleCall_2()); 

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
    // $ANTLR end "rule__Entity__Alternatives"


    // $ANTLR start "rule__CompositeInput__ExpresionAlternatives_3_0"
    // InternalBot.g:1363:1: rule__CompositeInput__ExpresionAlternatives_3_0 : ( ( ruleLiteral ) | ( ruleEntityToken ) );
    public final void rule__CompositeInput__ExpresionAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1367:1: ( ( ruleLiteral ) | ( ruleEntityToken ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                alt11=1;
            }
            else if ( (LA11_0==71) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:1368:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1368:2: ( ruleLiteral )
                    // InternalBot.g:1369:3: ruleLiteral
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
                    // InternalBot.g:1374:2: ( ruleEntityToken )
                    {
                    // InternalBot.g:1374:2: ( ruleEntityToken )
                    // InternalBot.g:1375:3: ruleEntityToken
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
    // InternalBot.g:1384:1: rule__TextInputHttpResponse__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) );
    public final void rule__TextInputHttpResponse__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1388:1: ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) )
            int alt12=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt12=1;
                }
                break;
            case 69:
                {
                alt12=2;
                }
                break;
            case 74:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalBot.g:1389:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1389:2: ( ruleLiteral )
                    // InternalBot.g:1390:3: ruleLiteral
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
                    // InternalBot.g:1395:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1395:2: ( ruleParameterToken )
                    // InternalBot.g:1396:3: ruleParameterToken
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
                    // InternalBot.g:1401:2: ( ruleHTTPRequestToken )
                    {
                    // InternalBot.g:1401:2: ( ruleHTTPRequestToken )
                    // InternalBot.g:1402:3: ruleHTTPRequestToken
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
    // InternalBot.g:1411:1: rule__TextInputText__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__TextInputText__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1415:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
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
                    // InternalBot.g:1416:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1416:2: ( ruleLiteral )
                    // InternalBot.g:1417:3: ruleLiteral
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
                    // InternalBot.g:1422:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1422:2: ( ruleParameterToken )
                    // InternalBot.g:1423:3: ruleParameterToken
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
    // InternalBot.g:1432:1: rule__Data__ValueAlternatives_2_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__Data__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1436:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_ID)) ) {
                alt14=1;
            }
            else if ( (LA14_0==69) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalBot.g:1437:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1437:2: ( ruleLiteral )
                    // InternalBot.g:1438:3: ruleLiteral
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
                    // InternalBot.g:1443:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1443:2: ( ruleParameterToken )
                    // InternalBot.g:1444:3: ruleParameterToken
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
    // InternalBot.g:1453:1: rule__DefaultEntity__Alternatives : ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) );
    public final void rule__DefaultEntity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1457:1: ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) )
            int alt15=5;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt15=1;
                }
                break;
            case 12:
                {
                alt15=2;
                }
                break;
            case 13:
                {
                alt15=3;
                }
                break;
            case 14:
                {
                alt15=4;
                }
                break;
            case 15:
                {
                alt15=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalBot.g:1458:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1458:2: ( ( 'text' ) )
                    // InternalBot.g:1459:3: ( 'text' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1460:3: ( 'text' )
                    // InternalBot.g:1460:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1464:2: ( ( 'number' ) )
                    {
                    // InternalBot.g:1464:2: ( ( 'number' ) )
                    // InternalBot.g:1465:3: ( 'number' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalBot.g:1466:3: ( 'number' )
                    // InternalBot.g:1466:4: 'number'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1470:2: ( ( 'date' ) )
                    {
                    // InternalBot.g:1470:2: ( ( 'date' ) )
                    // InternalBot.g:1471:3: ( 'date' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1472:3: ( 'date' )
                    // InternalBot.g:1472:4: 'date'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1476:2: ( ( 'float' ) )
                    {
                    // InternalBot.g:1476:2: ( ( 'float' ) )
                    // InternalBot.g:1477:3: ( 'float' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1478:3: ( 'float' )
                    // InternalBot.g:1478:4: 'float'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1482:2: ( ( 'time' ) )
                    {
                    // InternalBot.g:1482:2: ( ( 'time' ) )
                    // InternalBot.g:1483:3: ( 'time' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1484:3: ( 'time' )
                    // InternalBot.g:1484:4: 'time'
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
    // InternalBot.g:1492:1: rule__HTTPReturnType__Alternatives : ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) );
    public final void rule__HTTPReturnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1496:1: ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt16=1;
                }
                break;
            case 16:
                {
                alt16=2;
                }
                break;
            case 17:
                {
                alt16=3;
                }
                break;
            case 18:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalBot.g:1497:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1497:2: ( ( 'text' ) )
                    // InternalBot.g:1498:3: ( 'text' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1499:3: ( 'text' )
                    // InternalBot.g:1499:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1503:2: ( ( 'status_code' ) )
                    {
                    // InternalBot.g:1503:2: ( ( 'status_code' ) )
                    // InternalBot.g:1504:3: ( 'status_code' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1505:3: ( 'status_code' )
                    // InternalBot.g:1505:4: 'status_code'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1509:2: ( ( 'image' ) )
                    {
                    // InternalBot.g:1509:2: ( ( 'image' ) )
                    // InternalBot.g:1510:3: ( 'image' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1511:3: ( 'image' )
                    // InternalBot.g:1511:4: 'image'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1515:2: ( ( 'data' ) )
                    {
                    // InternalBot.g:1515:2: ( ( 'data' ) )
                    // InternalBot.g:1516:3: ( 'data' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1517:3: ( 'data' )
                    // InternalBot.g:1517:4: 'data'
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
    // InternalBot.g:1525:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1529:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) )
            int alt17=26;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt17=1;
                }
                break;
            case 20:
                {
                alt17=2;
                }
                break;
            case 21:
                {
                alt17=3;
                }
                break;
            case 22:
                {
                alt17=4;
                }
                break;
            case 23:
                {
                alt17=5;
                }
                break;
            case 24:
                {
                alt17=6;
                }
                break;
            case 25:
                {
                alt17=7;
                }
                break;
            case 26:
                {
                alt17=8;
                }
                break;
            case 27:
                {
                alt17=9;
                }
                break;
            case 28:
                {
                alt17=10;
                }
                break;
            case 29:
                {
                alt17=11;
                }
                break;
            case 30:
                {
                alt17=12;
                }
                break;
            case 31:
                {
                alt17=13;
                }
                break;
            case 32:
                {
                alt17=14;
                }
                break;
            case 33:
                {
                alt17=15;
                }
                break;
            case 34:
                {
                alt17=16;
                }
                break;
            case 35:
                {
                alt17=17;
                }
                break;
            case 36:
                {
                alt17=18;
                }
                break;
            case 37:
                {
                alt17=19;
                }
                break;
            case 38:
                {
                alt17=20;
                }
                break;
            case 39:
                {
                alt17=21;
                }
                break;
            case 40:
                {
                alt17=22;
                }
                break;
            case 41:
                {
                alt17=23;
                }
                break;
            case 42:
                {
                alt17=24;
                }
                break;
            case 43:
                {
                alt17=25;
                }
                break;
            case 44:
                {
                alt17=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalBot.g:1530:2: ( ( 'en' ) )
                    {
                    // InternalBot.g:1530:2: ( ( 'en' ) )
                    // InternalBot.g:1531:3: ( 'en' )
                    {
                     before(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1532:3: ( 'en' )
                    // InternalBot.g:1532:4: 'en'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1536:2: ( ( 'es' ) )
                    {
                    // InternalBot.g:1536:2: ( ( 'es' ) )
                    // InternalBot.g:1537:3: ( 'es' )
                    {
                     before(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1538:3: ( 'es' )
                    // InternalBot.g:1538:4: 'es'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1542:2: ( ( 'da' ) )
                    {
                    // InternalBot.g:1542:2: ( ( 'da' ) )
                    // InternalBot.g:1543:3: ( 'da' )
                    {
                     before(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1544:3: ( 'da' )
                    // InternalBot.g:1544:4: 'da'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1548:2: ( ( 'de' ) )
                    {
                    // InternalBot.g:1548:2: ( ( 'de' ) )
                    // InternalBot.g:1549:3: ( 'de' )
                    {
                     before(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1550:3: ( 'de' )
                    // InternalBot.g:1550:4: 'de'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1554:2: ( ( 'fr' ) )
                    {
                    // InternalBot.g:1554:2: ( ( 'fr' ) )
                    // InternalBot.g:1555:3: ( 'fr' )
                    {
                     before(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1556:3: ( 'fr' )
                    // InternalBot.g:1556:4: 'fr'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1560:2: ( ( 'hi' ) )
                    {
                    // InternalBot.g:1560:2: ( ( 'hi' ) )
                    // InternalBot.g:1561:3: ( 'hi' )
                    {
                     before(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 
                    // InternalBot.g:1562:3: ( 'hi' )
                    // InternalBot.g:1562:4: 'hi'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:1566:2: ( ( 'id' ) )
                    {
                    // InternalBot.g:1566:2: ( ( 'id' ) )
                    // InternalBot.g:1567:3: ( 'id' )
                    {
                     before(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 
                    // InternalBot.g:1568:3: ( 'id' )
                    // InternalBot.g:1568:4: 'id'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:1572:2: ( ( 'it' ) )
                    {
                    // InternalBot.g:1572:2: ( ( 'it' ) )
                    // InternalBot.g:1573:3: ( 'it' )
                    {
                     before(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 
                    // InternalBot.g:1574:3: ( 'it' )
                    // InternalBot.g:1574:4: 'it'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:1578:2: ( ( 'ja' ) )
                    {
                    // InternalBot.g:1578:2: ( ( 'ja' ) )
                    // InternalBot.g:1579:3: ( 'ja' )
                    {
                     before(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 
                    // InternalBot.g:1580:3: ( 'ja' )
                    // InternalBot.g:1580:4: 'ja'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:1584:2: ( ( 'ko' ) )
                    {
                    // InternalBot.g:1584:2: ( ( 'ko' ) )
                    // InternalBot.g:1585:3: ( 'ko' )
                    {
                     before(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 
                    // InternalBot.g:1586:3: ( 'ko' )
                    // InternalBot.g:1586:4: 'ko'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:1590:2: ( ( 'nl' ) )
                    {
                    // InternalBot.g:1590:2: ( ( 'nl' ) )
                    // InternalBot.g:1591:3: ( 'nl' )
                    {
                     before(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 
                    // InternalBot.g:1592:3: ( 'nl' )
                    // InternalBot.g:1592:4: 'nl'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:1596:2: ( ( 'no' ) )
                    {
                    // InternalBot.g:1596:2: ( ( 'no' ) )
                    // InternalBot.g:1597:3: ( 'no' )
                    {
                     before(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 
                    // InternalBot.g:1598:3: ( 'no' )
                    // InternalBot.g:1598:4: 'no'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:1602:2: ( ( 'pl' ) )
                    {
                    // InternalBot.g:1602:2: ( ( 'pl' ) )
                    // InternalBot.g:1603:3: ( 'pl' )
                    {
                     before(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 
                    // InternalBot.g:1604:3: ( 'pl' )
                    // InternalBot.g:1604:4: 'pl'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:1608:2: ( ( 'pt' ) )
                    {
                    // InternalBot.g:1608:2: ( ( 'pt' ) )
                    // InternalBot.g:1609:3: ( 'pt' )
                    {
                     before(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 
                    // InternalBot.g:1610:3: ( 'pt' )
                    // InternalBot.g:1610:4: 'pt'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:1614:2: ( ( 'ru' ) )
                    {
                    // InternalBot.g:1614:2: ( ( 'ru' ) )
                    // InternalBot.g:1615:3: ( 'ru' )
                    {
                     before(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 
                    // InternalBot.g:1616:3: ( 'ru' )
                    // InternalBot.g:1616:4: 'ru'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:1620:2: ( ( 'sv' ) )
                    {
                    // InternalBot.g:1620:2: ( ( 'sv' ) )
                    // InternalBot.g:1621:3: ( 'sv' )
                    {
                     before(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 
                    // InternalBot.g:1622:3: ( 'sv' )
                    // InternalBot.g:1622:4: 'sv'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:1626:2: ( ( 'th' ) )
                    {
                    // InternalBot.g:1626:2: ( ( 'th' ) )
                    // InternalBot.g:1627:3: ( 'th' )
                    {
                     before(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 
                    // InternalBot.g:1628:3: ( 'th' )
                    // InternalBot.g:1628:4: 'th'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:1632:2: ( ( 'tr' ) )
                    {
                    // InternalBot.g:1632:2: ( ( 'tr' ) )
                    // InternalBot.g:1633:3: ( 'tr' )
                    {
                     before(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 
                    // InternalBot.g:1634:3: ( 'tr' )
                    // InternalBot.g:1634:4: 'tr'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:1638:2: ( ( 'uk' ) )
                    {
                    // InternalBot.g:1638:2: ( ( 'uk' ) )
                    // InternalBot.g:1639:3: ( 'uk' )
                    {
                     before(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 
                    // InternalBot.g:1640:3: ( 'uk' )
                    // InternalBot.g:1640:4: 'uk'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:1644:2: ( ( 'zh' ) )
                    {
                    // InternalBot.g:1644:2: ( ( 'zh' ) )
                    // InternalBot.g:1645:3: ( 'zh' )
                    {
                     before(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 
                    // InternalBot.g:1646:3: ( 'zh' )
                    // InternalBot.g:1646:4: 'zh'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:1650:2: ( ( 'ar' ) )
                    {
                    // InternalBot.g:1650:2: ( ( 'ar' ) )
                    // InternalBot.g:1651:3: ( 'ar' )
                    {
                     before(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 
                    // InternalBot.g:1652:3: ( 'ar' )
                    // InternalBot.g:1652:4: 'ar'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:1656:2: ( ( 'cz' ) )
                    {
                    // InternalBot.g:1656:2: ( ( 'cz' ) )
                    // InternalBot.g:1657:3: ( 'cz' )
                    {
                     before(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 
                    // InternalBot.g:1658:3: ( 'cz' )
                    // InternalBot.g:1658:4: 'cz'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:1662:2: ( ( 'bu' ) )
                    {
                    // InternalBot.g:1662:2: ( ( 'bu' ) )
                    // InternalBot.g:1663:3: ( 'bu' )
                    {
                     before(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 
                    // InternalBot.g:1664:3: ( 'bu' )
                    // InternalBot.g:1664:4: 'bu'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:1668:2: ( ( 'fi' ) )
                    {
                    // InternalBot.g:1668:2: ( ( 'fi' ) )
                    // InternalBot.g:1669:3: ( 'fi' )
                    {
                     before(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 
                    // InternalBot.g:1670:3: ( 'fi' )
                    // InternalBot.g:1670:4: 'fi'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:1674:2: ( ( 'gr' ) )
                    {
                    // InternalBot.g:1674:2: ( ( 'gr' ) )
                    // InternalBot.g:1675:3: ( 'gr' )
                    {
                     before(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 
                    // InternalBot.g:1676:3: ( 'gr' )
                    // InternalBot.g:1676:4: 'gr'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:1680:2: ( ( 'ba' ) )
                    {
                    // InternalBot.g:1680:2: ( ( 'ba' ) )
                    // InternalBot.g:1681:3: ( 'ba' )
                    {
                     before(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 
                    // InternalBot.g:1682:3: ( 'ba' )
                    // InternalBot.g:1682:4: 'ba'
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
    // InternalBot.g:1690:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1694:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==45) ) {
                alt18=1;
            }
            else if ( (LA18_0==46) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalBot.g:1695:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1695:2: ( ( 'JSON' ) )
                    // InternalBot.g:1696:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1697:3: ( 'JSON' )
                    // InternalBot.g:1697:4: 'JSON'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1701:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1701:2: ( ( 'FORM' ) )
                    // InternalBot.g:1702:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1703:3: ( 'FORM' )
                    // InternalBot.g:1703:4: 'FORM'
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
    // InternalBot.g:1711:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1715:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==47) ) {
                alt19=1;
            }
            else if ( (LA19_0==48) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalBot.g:1716:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1716:2: ( ( 'post' ) )
                    // InternalBot.g:1717:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1718:3: ( 'post' )
                    // InternalBot.g:1718:4: 'post'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1722:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1722:2: ( ( 'get' ) )
                    // InternalBot.g:1723:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1724:3: ( 'get' )
                    // InternalBot.g:1724:4: 'get'
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
    // InternalBot.g:1732:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1736:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1737:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
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
    // InternalBot.g:1744:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1748:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1749:1: ( 'Chatbot' )
            {
            // InternalBot.g:1749:1: ( 'Chatbot' )
            // InternalBot.g:1750:2: 'Chatbot'
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
    // InternalBot.g:1759:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1763:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1764:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
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
    // InternalBot.g:1771:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1775:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1776:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1776:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1777:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1778:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1778:3: rule__Bot__NameAssignment_1
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
    // InternalBot.g:1786:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1790:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1791:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
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
    // InternalBot.g:1798:1: rule__Bot__Group__2__Impl : ( 'language' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1802:1: ( ( 'language' ) )
            // InternalBot.g:1803:1: ( 'language' )
            {
            // InternalBot.g:1803:1: ( 'language' )
            // InternalBot.g:1804:2: 'language'
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
    // InternalBot.g:1813:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1817:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1818:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
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
    // InternalBot.g:1825:1: rule__Bot__Group__3__Impl : ( ':' ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1829:1: ( ( ':' ) )
            // InternalBot.g:1830:1: ( ':' )
            {
            // InternalBot.g:1830:1: ( ':' )
            // InternalBot.g:1831:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_3()); 

            }


            }

        }
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
    // InternalBot.g:1840:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1844:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1845:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalBot.g:1852:1: rule__Bot__Group__4__Impl : ( ( rule__Bot__LanguagesAssignment_4 ) ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1856:1: ( ( ( rule__Bot__LanguagesAssignment_4 ) ) )
            // InternalBot.g:1857:1: ( ( rule__Bot__LanguagesAssignment_4 ) )
            {
            // InternalBot.g:1857:1: ( ( rule__Bot__LanguagesAssignment_4 ) )
            // InternalBot.g:1858:2: ( rule__Bot__LanguagesAssignment_4 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_4()); 
            // InternalBot.g:1859:2: ( rule__Bot__LanguagesAssignment_4 )
            // InternalBot.g:1859:3: rule__Bot__LanguagesAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguagesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguagesAssignment_4()); 

            }


            }

        }
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
    // InternalBot.g:1867:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1871:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1872:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
            {
            pushFollow(FOLLOW_9);
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
    // InternalBot.g:1879:1: rule__Bot__Group__5__Impl : ( ( rule__Bot__Group_5__0 )* ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1883:1: ( ( ( rule__Bot__Group_5__0 )* ) )
            // InternalBot.g:1884:1: ( ( rule__Bot__Group_5__0 )* )
            {
            // InternalBot.g:1884:1: ( ( rule__Bot__Group_5__0 )* )
            // InternalBot.g:1885:2: ( rule__Bot__Group_5__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_5()); 
            // InternalBot.g:1886:2: ( rule__Bot__Group_5__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==54) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBot.g:1886:3: rule__Bot__Group_5__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Bot__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_5()); 

            }


            }

        }
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
    // InternalBot.g:1894:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1898:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:1899:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:1906:1: rule__Bot__Group__6__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1910:1: ( ( 'intents' ) )
            // InternalBot.g:1911:1: ( 'intents' )
            {
            // InternalBot.g:1911:1: ( 'intents' )
            // InternalBot.g:1912:2: 'intents'
            {
             before(grammarAccess.getBotAccess().getIntentsKeyword_6()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getIntentsKeyword_6()); 

            }


            }

        }
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
    // InternalBot.g:1921:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1925:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:1926:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:1933:1: rule__Bot__Group__7__Impl : ( ':' ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1937:1: ( ( ':' ) )
            // InternalBot.g:1938:1: ( ':' )
            {
            // InternalBot.g:1938:1: ( ':' )
            // InternalBot.g:1939:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_7()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_7()); 

            }


            }

        }
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
    // InternalBot.g:1948:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1952:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:1953:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
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
    // InternalBot.g:1960:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__IntentsAssignment_8 ) ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1964:1: ( ( ( rule__Bot__IntentsAssignment_8 ) ) )
            // InternalBot.g:1965:1: ( ( rule__Bot__IntentsAssignment_8 ) )
            {
            // InternalBot.g:1965:1: ( ( rule__Bot__IntentsAssignment_8 ) )
            // InternalBot.g:1966:2: ( rule__Bot__IntentsAssignment_8 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_8()); 
            // InternalBot.g:1967:2: ( rule__Bot__IntentsAssignment_8 )
            // InternalBot.g:1967:3: rule__Bot__IntentsAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Bot__IntentsAssignment_8();

            state._fsp--;


            }

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
    // InternalBot.g:1975:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1979:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:1980:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
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
    // InternalBot.g:1987:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__IntentsAssignment_9 )* ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1991:1: ( ( ( rule__Bot__IntentsAssignment_9 )* ) )
            // InternalBot.g:1992:1: ( ( rule__Bot__IntentsAssignment_9 )* )
            {
            // InternalBot.g:1992:1: ( ( rule__Bot__IntentsAssignment_9 )* )
            // InternalBot.g:1993:2: ( rule__Bot__IntentsAssignment_9 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_9()); 
            // InternalBot.g:1994:2: ( rule__Bot__IntentsAssignment_9 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_ID)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:1994:3: rule__Bot__IntentsAssignment_9
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Bot__IntentsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getIntentsAssignment_9()); 

            }


            }

        }
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
    // InternalBot.g:2002:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2006:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:2007:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
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
    // InternalBot.g:2014:1: rule__Bot__Group__10__Impl : ( ( rule__Bot__Group_10__0 )? ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2018:1: ( ( ( rule__Bot__Group_10__0 )? ) )
            // InternalBot.g:2019:1: ( ( rule__Bot__Group_10__0 )? )
            {
            // InternalBot.g:2019:1: ( ( rule__Bot__Group_10__0 )? )
            // InternalBot.g:2020:2: ( rule__Bot__Group_10__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_10()); 
            // InternalBot.g:2021:2: ( rule__Bot__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==55) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBot.g:2021:3: rule__Bot__Group_10__0
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
    // InternalBot.g:2029:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2033:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:2034:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
            {
            pushFollow(FOLLOW_11);
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
    // InternalBot.g:2041:1: rule__Bot__Group__11__Impl : ( ( rule__Bot__Group_11__0 )? ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2045:1: ( ( ( rule__Bot__Group_11__0 )? ) )
            // InternalBot.g:2046:1: ( ( rule__Bot__Group_11__0 )? )
            {
            // InternalBot.g:2046:1: ( ( rule__Bot__Group_11__0 )? )
            // InternalBot.g:2047:2: ( rule__Bot__Group_11__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_11()); 
            // InternalBot.g:2048:2: ( rule__Bot__Group_11__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==56) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBot.g:2048:3: rule__Bot__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Bot__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBotAccess().getGroup_11()); 

            }


            }

        }
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
    // InternalBot.g:2056:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl rule__Bot__Group__13 ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2060:1: ( rule__Bot__Group__12__Impl rule__Bot__Group__13 )
            // InternalBot.g:2061:2: rule__Bot__Group__12__Impl rule__Bot__Group__13
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:2068:1: rule__Bot__Group__12__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2072:1: ( ( 'flows' ) )
            // InternalBot.g:2073:1: ( 'flows' )
            {
            // InternalBot.g:2073:1: ( 'flows' )
            // InternalBot.g:2074:2: 'flows'
            {
             before(grammarAccess.getBotAccess().getFlowsKeyword_12()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getFlowsKeyword_12()); 

            }


            }

        }
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
    // InternalBot.g:2083:1: rule__Bot__Group__13 : rule__Bot__Group__13__Impl rule__Bot__Group__14 ;
    public final void rule__Bot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2087:1: ( rule__Bot__Group__13__Impl rule__Bot__Group__14 )
            // InternalBot.g:2088:2: rule__Bot__Group__13__Impl rule__Bot__Group__14
            {
            pushFollow(FOLLOW_13);
            rule__Bot__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group__14();

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
    // InternalBot.g:2095:1: rule__Bot__Group__13__Impl : ( ':' ) ;
    public final void rule__Bot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2099:1: ( ( ':' ) )
            // InternalBot.g:2100:1: ( ':' )
            {
            // InternalBot.g:2100:1: ( ':' )
            // InternalBot.g:2101:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_13()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_13()); 

            }


            }

        }
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


    // $ANTLR start "rule__Bot__Group__14"
    // InternalBot.g:2110:1: rule__Bot__Group__14 : rule__Bot__Group__14__Impl ;
    public final void rule__Bot__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2114:1: ( rule__Bot__Group__14__Impl )
            // InternalBot.g:2115:2: rule__Bot__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group__14__Impl();

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
    // $ANTLR end "rule__Bot__Group__14"


    // $ANTLR start "rule__Bot__Group__14__Impl"
    // InternalBot.g:2121:1: rule__Bot__Group__14__Impl : ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) ) ;
    public final void rule__Bot__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2125:1: ( ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) ) )
            // InternalBot.g:2126:1: ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) )
            {
            // InternalBot.g:2126:1: ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) )
            // InternalBot.g:2127:2: ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* )
            {
            // InternalBot.g:2127:2: ( ( rule__Bot__Group_14__0 ) )
            // InternalBot.g:2128:3: ( rule__Bot__Group_14__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_14()); 
            // InternalBot.g:2129:3: ( rule__Bot__Group_14__0 )
            // InternalBot.g:2129:4: rule__Bot__Group_14__0
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_14__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_14()); 

            }

            // InternalBot.g:2132:2: ( ( rule__Bot__Group_14__0 )* )
            // InternalBot.g:2133:3: ( rule__Bot__Group_14__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_14()); 
            // InternalBot.g:2134:3: ( rule__Bot__Group_14__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==57) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:2134:4: rule__Bot__Group_14__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Bot__Group_14__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getGroup_14()); 

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
    // $ANTLR end "rule__Bot__Group__14__Impl"


    // $ANTLR start "rule__Bot__Group_5__0"
    // InternalBot.g:2144:1: rule__Bot__Group_5__0 : rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1 ;
    public final void rule__Bot__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2148:1: ( rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1 )
            // InternalBot.g:2149:2: rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1
            {
            pushFollow(FOLLOW_8);
            rule__Bot__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_5__1();

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
    // $ANTLR end "rule__Bot__Group_5__0"


    // $ANTLR start "rule__Bot__Group_5__0__Impl"
    // InternalBot.g:2156:1: rule__Bot__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Bot__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2160:1: ( ( ',' ) )
            // InternalBot.g:2161:1: ( ',' )
            {
            // InternalBot.g:2161:1: ( ',' )
            // InternalBot.g:2162:2: ','
            {
             before(grammarAccess.getBotAccess().getCommaKeyword_5_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_5__0__Impl"


    // $ANTLR start "rule__Bot__Group_5__1"
    // InternalBot.g:2171:1: rule__Bot__Group_5__1 : rule__Bot__Group_5__1__Impl ;
    public final void rule__Bot__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2175:1: ( rule__Bot__Group_5__1__Impl )
            // InternalBot.g:2176:2: rule__Bot__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_5__1__Impl();

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
    // $ANTLR end "rule__Bot__Group_5__1"


    // $ANTLR start "rule__Bot__Group_5__1__Impl"
    // InternalBot.g:2182:1: rule__Bot__Group_5__1__Impl : ( ( rule__Bot__LanguagesAssignment_5_1 ) ) ;
    public final void rule__Bot__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2186:1: ( ( ( rule__Bot__LanguagesAssignment_5_1 ) ) )
            // InternalBot.g:2187:1: ( ( rule__Bot__LanguagesAssignment_5_1 ) )
            {
            // InternalBot.g:2187:1: ( ( rule__Bot__LanguagesAssignment_5_1 ) )
            // InternalBot.g:2188:2: ( rule__Bot__LanguagesAssignment_5_1 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_5_1()); 
            // InternalBot.g:2189:2: ( rule__Bot__LanguagesAssignment_5_1 )
            // InternalBot.g:2189:3: rule__Bot__LanguagesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__LanguagesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getLanguagesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_5__1__Impl"


    // $ANTLR start "rule__Bot__Group_10__0"
    // InternalBot.g:2198:1: rule__Bot__Group_10__0 : rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 ;
    public final void rule__Bot__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2202:1: ( rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 )
            // InternalBot.g:2203:2: rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:2210:1: rule__Bot__Group_10__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2214:1: ( ( 'entities' ) )
            // InternalBot.g:2215:1: ( 'entities' )
            {
            // InternalBot.g:2215:1: ( 'entities' )
            // InternalBot.g:2216:2: 'entities'
            {
             before(grammarAccess.getBotAccess().getEntitiesKeyword_10_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getEntitiesKeyword_10_0()); 

            }


            }

        }
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
    // InternalBot.g:2225:1: rule__Bot__Group_10__1 : rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 ;
    public final void rule__Bot__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2229:1: ( rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 )
            // InternalBot.g:2230:2: rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2
            {
            pushFollow(FOLLOW_15);
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
    // InternalBot.g:2237:1: rule__Bot__Group_10__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2241:1: ( ( ':' ) )
            // InternalBot.g:2242:1: ( ':' )
            {
            // InternalBot.g:2242:1: ( ':' )
            // InternalBot.g:2243:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_10_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:2252:1: rule__Bot__Group_10__2 : rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 ;
    public final void rule__Bot__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2256:1: ( rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 )
            // InternalBot.g:2257:2: rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3
            {
            pushFollow(FOLLOW_15);
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
    // InternalBot.g:2264:1: rule__Bot__Group_10__2__Impl : ( ( rule__Bot__EntitiesAssignment_10_2 ) ) ;
    public final void rule__Bot__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2268:1: ( ( ( rule__Bot__EntitiesAssignment_10_2 ) ) )
            // InternalBot.g:2269:1: ( ( rule__Bot__EntitiesAssignment_10_2 ) )
            {
            // InternalBot.g:2269:1: ( ( rule__Bot__EntitiesAssignment_10_2 ) )
            // InternalBot.g:2270:2: ( rule__Bot__EntitiesAssignment_10_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_10_2()); 
            // InternalBot.g:2271:2: ( rule__Bot__EntitiesAssignment_10_2 )
            // InternalBot.g:2271:3: rule__Bot__EntitiesAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__EntitiesAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getEntitiesAssignment_10_2()); 

            }


            }

        }
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
    // InternalBot.g:2279:1: rule__Bot__Group_10__3 : rule__Bot__Group_10__3__Impl ;
    public final void rule__Bot__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2283:1: ( rule__Bot__Group_10__3__Impl )
            // InternalBot.g:2284:2: rule__Bot__Group_10__3__Impl
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
    // InternalBot.g:2290:1: rule__Bot__Group_10__3__Impl : ( ( rule__Bot__EntitiesAssignment_10_3 )* ) ;
    public final void rule__Bot__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2294:1: ( ( ( rule__Bot__EntitiesAssignment_10_3 )* ) )
            // InternalBot.g:2295:1: ( ( rule__Bot__EntitiesAssignment_10_3 )* )
            {
            // InternalBot.g:2295:1: ( ( rule__Bot__EntitiesAssignment_10_3 )* )
            // InternalBot.g:2296:2: ( rule__Bot__EntitiesAssignment_10_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_10_3()); 
            // InternalBot.g:2297:2: ( rule__Bot__EntitiesAssignment_10_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=76 && LA25_0<=78)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBot.g:2297:3: rule__Bot__EntitiesAssignment_10_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Bot__EntitiesAssignment_10_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getEntitiesAssignment_10_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Bot__Group_11__0"
    // InternalBot.g:2306:1: rule__Bot__Group_11__0 : rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1 ;
    public final void rule__Bot__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2310:1: ( rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1 )
            // InternalBot.g:2311:2: rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1
            {
            pushFollow(FOLLOW_7);
            rule__Bot__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_11__1();

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
    // $ANTLR end "rule__Bot__Group_11__0"


    // $ANTLR start "rule__Bot__Group_11__0__Impl"
    // InternalBot.g:2318:1: rule__Bot__Group_11__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2322:1: ( ( 'actions' ) )
            // InternalBot.g:2323:1: ( 'actions' )
            {
            // InternalBot.g:2323:1: ( 'actions' )
            // InternalBot.g:2324:2: 'actions'
            {
             before(grammarAccess.getBotAccess().getActionsKeyword_11_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getActionsKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_11__0__Impl"


    // $ANTLR start "rule__Bot__Group_11__1"
    // InternalBot.g:2333:1: rule__Bot__Group_11__1 : rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2 ;
    public final void rule__Bot__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2337:1: ( rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2 )
            // InternalBot.g:2338:2: rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2
            {
            pushFollow(FOLLOW_17);
            rule__Bot__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_11__2();

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
    // $ANTLR end "rule__Bot__Group_11__1"


    // $ANTLR start "rule__Bot__Group_11__1__Impl"
    // InternalBot.g:2345:1: rule__Bot__Group_11__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2349:1: ( ( ':' ) )
            // InternalBot.g:2350:1: ( ':' )
            {
            // InternalBot.g:2350:1: ( ':' )
            // InternalBot.g:2351:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_11_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getColonKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_11__1__Impl"


    // $ANTLR start "rule__Bot__Group_11__2"
    // InternalBot.g:2360:1: rule__Bot__Group_11__2 : rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3 ;
    public final void rule__Bot__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2364:1: ( rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3 )
            // InternalBot.g:2365:2: rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3
            {
            pushFollow(FOLLOW_17);
            rule__Bot__Group_11__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_11__3();

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
    // $ANTLR end "rule__Bot__Group_11__2"


    // $ANTLR start "rule__Bot__Group_11__2__Impl"
    // InternalBot.g:2372:1: rule__Bot__Group_11__2__Impl : ( ( rule__Bot__ActionsAssignment_11_2 ) ) ;
    public final void rule__Bot__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2376:1: ( ( ( rule__Bot__ActionsAssignment_11_2 ) ) )
            // InternalBot.g:2377:1: ( ( rule__Bot__ActionsAssignment_11_2 ) )
            {
            // InternalBot.g:2377:1: ( ( rule__Bot__ActionsAssignment_11_2 ) )
            // InternalBot.g:2378:2: ( rule__Bot__ActionsAssignment_11_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_11_2()); 
            // InternalBot.g:2379:2: ( rule__Bot__ActionsAssignment_11_2 )
            // InternalBot.g:2379:3: rule__Bot__ActionsAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__Bot__ActionsAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getActionsAssignment_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_11__2__Impl"


    // $ANTLR start "rule__Bot__Group_11__3"
    // InternalBot.g:2387:1: rule__Bot__Group_11__3 : rule__Bot__Group_11__3__Impl ;
    public final void rule__Bot__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2391:1: ( rule__Bot__Group_11__3__Impl )
            // InternalBot.g:2392:2: rule__Bot__Group_11__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_11__3__Impl();

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
    // $ANTLR end "rule__Bot__Group_11__3"


    // $ANTLR start "rule__Bot__Group_11__3__Impl"
    // InternalBot.g:2398:1: rule__Bot__Group_11__3__Impl : ( ( rule__Bot__ActionsAssignment_11_3 )* ) ;
    public final void rule__Bot__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2402:1: ( ( ( rule__Bot__ActionsAssignment_11_3 )* ) )
            // InternalBot.g:2403:1: ( ( rule__Bot__ActionsAssignment_11_3 )* )
            {
            // InternalBot.g:2403:1: ( ( rule__Bot__ActionsAssignment_11_3 )* )
            // InternalBot.g:2404:2: ( rule__Bot__ActionsAssignment_11_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_11_3()); 
            // InternalBot.g:2405:2: ( rule__Bot__ActionsAssignment_11_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==11||LA26_0==17||(LA26_0>=83 && LA26_0<=84)||LA26_0==90) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBot.g:2405:3: rule__Bot__ActionsAssignment_11_3
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Bot__ActionsAssignment_11_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getBotAccess().getActionsAssignment_11_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_11__3__Impl"


    // $ANTLR start "rule__Bot__Group_14__0"
    // InternalBot.g:2414:1: rule__Bot__Group_14__0 : rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1 ;
    public final void rule__Bot__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2418:1: ( rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1 )
            // InternalBot.g:2419:2: rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1
            {
            pushFollow(FOLLOW_19);
            rule__Bot__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_14__1();

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
    // $ANTLR end "rule__Bot__Group_14__0"


    // $ANTLR start "rule__Bot__Group_14__0__Impl"
    // InternalBot.g:2426:1: rule__Bot__Group_14__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2430:1: ( ( '-' ) )
            // InternalBot.g:2431:1: ( '-' )
            {
            // InternalBot.g:2431:1: ( '-' )
            // InternalBot.g:2432:2: '-'
            {
             before(grammarAccess.getBotAccess().getHyphenMinusKeyword_14_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getHyphenMinusKeyword_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_14__0__Impl"


    // $ANTLR start "rule__Bot__Group_14__1"
    // InternalBot.g:2441:1: rule__Bot__Group_14__1 : rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2 ;
    public final void rule__Bot__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2445:1: ( rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2 )
            // InternalBot.g:2446:2: rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2
            {
            pushFollow(FOLLOW_20);
            rule__Bot__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Bot__Group_14__2();

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
    // $ANTLR end "rule__Bot__Group_14__1"


    // $ANTLR start "rule__Bot__Group_14__1__Impl"
    // InternalBot.g:2453:1: rule__Bot__Group_14__1__Impl : ( ( rule__Bot__FlowsAssignment_14_1 ) ) ;
    public final void rule__Bot__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2457:1: ( ( ( rule__Bot__FlowsAssignment_14_1 ) ) )
            // InternalBot.g:2458:1: ( ( rule__Bot__FlowsAssignment_14_1 ) )
            {
            // InternalBot.g:2458:1: ( ( rule__Bot__FlowsAssignment_14_1 ) )
            // InternalBot.g:2459:2: ( rule__Bot__FlowsAssignment_14_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_14_1()); 
            // InternalBot.g:2460:2: ( rule__Bot__FlowsAssignment_14_1 )
            // InternalBot.g:2460:3: rule__Bot__FlowsAssignment_14_1
            {
            pushFollow(FOLLOW_2);
            rule__Bot__FlowsAssignment_14_1();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getFlowsAssignment_14_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_14__1__Impl"


    // $ANTLR start "rule__Bot__Group_14__2"
    // InternalBot.g:2468:1: rule__Bot__Group_14__2 : rule__Bot__Group_14__2__Impl ;
    public final void rule__Bot__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2472:1: ( rule__Bot__Group_14__2__Impl )
            // InternalBot.g:2473:2: rule__Bot__Group_14__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Bot__Group_14__2__Impl();

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
    // $ANTLR end "rule__Bot__Group_14__2"


    // $ANTLR start "rule__Bot__Group_14__2__Impl"
    // InternalBot.g:2479:1: rule__Bot__Group_14__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2483:1: ( ( ';' ) )
            // InternalBot.g:2484:1: ( ';' )
            {
            // InternalBot.g:2484:1: ( ';' )
            // InternalBot.g:2485:2: ';'
            {
             before(grammarAccess.getBotAccess().getSemicolonKeyword_14_2()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getBotAccess().getSemicolonKeyword_14_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__Group_14__2__Impl"


    // $ANTLR start "rule__Intent2__Group__0"
    // InternalBot.g:2495:1: rule__Intent2__Group__0 : rule__Intent2__Group__0__Impl rule__Intent2__Group__1 ;
    public final void rule__Intent2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2499:1: ( rule__Intent2__Group__0__Impl rule__Intent2__Group__1 )
            // InternalBot.g:2500:2: rule__Intent2__Group__0__Impl rule__Intent2__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__Intent2__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group__1();

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
    // $ANTLR end "rule__Intent2__Group__0"


    // $ANTLR start "rule__Intent2__Group__0__Impl"
    // InternalBot.g:2507:1: rule__Intent2__Group__0__Impl : ( ( rule__Intent2__NameAssignment_0 ) ) ;
    public final void rule__Intent2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2511:1: ( ( ( rule__Intent2__NameAssignment_0 ) ) )
            // InternalBot.g:2512:1: ( ( rule__Intent2__NameAssignment_0 ) )
            {
            // InternalBot.g:2512:1: ( ( rule__Intent2__NameAssignment_0 ) )
            // InternalBot.g:2513:2: ( rule__Intent2__NameAssignment_0 )
            {
             before(grammarAccess.getIntent2Access().getNameAssignment_0()); 
            // InternalBot.g:2514:2: ( rule__Intent2__NameAssignment_0 )
            // InternalBot.g:2514:3: rule__Intent2__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Intent2__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIntent2Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group__0__Impl"


    // $ANTLR start "rule__Intent2__Group__1"
    // InternalBot.g:2522:1: rule__Intent2__Group__1 : rule__Intent2__Group__1__Impl rule__Intent2__Group__2 ;
    public final void rule__Intent2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2526:1: ( rule__Intent2__Group__1__Impl rule__Intent2__Group__2 )
            // InternalBot.g:2527:2: rule__Intent2__Group__1__Impl rule__Intent2__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__Intent2__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group__2();

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
    // $ANTLR end "rule__Intent2__Group__1"


    // $ANTLR start "rule__Intent2__Group__1__Impl"
    // InternalBot.g:2534:1: rule__Intent2__Group__1__Impl : ( ( rule__Intent2__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2538:1: ( ( ( rule__Intent2__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2539:1: ( ( rule__Intent2__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2539:1: ( ( rule__Intent2__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2540:2: ( rule__Intent2__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2541:2: ( rule__Intent2__FallbackIntentAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==91) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBot.g:2541:3: rule__Intent2__FallbackIntentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent2__FallbackIntentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntent2Access().getFallbackIntentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group__1__Impl"


    // $ANTLR start "rule__Intent2__Group__2"
    // InternalBot.g:2549:1: rule__Intent2__Group__2 : rule__Intent2__Group__2__Impl rule__Intent2__Group__3 ;
    public final void rule__Intent2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2553:1: ( rule__Intent2__Group__2__Impl rule__Intent2__Group__3 )
            // InternalBot.g:2554:2: rule__Intent2__Group__2__Impl rule__Intent2__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__Intent2__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group__3();

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
    // $ANTLR end "rule__Intent2__Group__2"


    // $ANTLR start "rule__Intent2__Group__2__Impl"
    // InternalBot.g:2561:1: rule__Intent2__Group__2__Impl : ( ':' ) ;
    public final void rule__Intent2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2565:1: ( ( ':' ) )
            // InternalBot.g:2566:1: ( ':' )
            {
            // InternalBot.g:2566:1: ( ':' )
            // InternalBot.g:2567:2: ':'
            {
             before(grammarAccess.getIntent2Access().getColonKeyword_2()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getIntent2Access().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group__2__Impl"


    // $ANTLR start "rule__Intent2__Group__3"
    // InternalBot.g:2576:1: rule__Intent2__Group__3 : rule__Intent2__Group__3__Impl rule__Intent2__Group__4 ;
    public final void rule__Intent2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2580:1: ( rule__Intent2__Group__3__Impl rule__Intent2__Group__4 )
            // InternalBot.g:2581:2: rule__Intent2__Group__3__Impl rule__Intent2__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Intent2__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group__4();

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
    // $ANTLR end "rule__Intent2__Group__3"


    // $ANTLR start "rule__Intent2__Group__3__Impl"
    // InternalBot.g:2588:1: rule__Intent2__Group__3__Impl : ( ( rule__Intent2__InputsAssignment_3 )* ) ;
    public final void rule__Intent2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2592:1: ( ( ( rule__Intent2__InputsAssignment_3 )* ) )
            // InternalBot.g:2593:1: ( ( rule__Intent2__InputsAssignment_3 )* )
            {
            // InternalBot.g:2593:1: ( ( rule__Intent2__InputsAssignment_3 )* )
            // InternalBot.g:2594:2: ( rule__Intent2__InputsAssignment_3 )*
            {
             before(grammarAccess.getIntent2Access().getInputsAssignment_3()); 
            // InternalBot.g:2595:2: ( rule__Intent2__InputsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==60) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBot.g:2595:3: rule__Intent2__InputsAssignment_3
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__Intent2__InputsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getIntent2Access().getInputsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group__3__Impl"


    // $ANTLR start "rule__Intent2__Group__4"
    // InternalBot.g:2603:1: rule__Intent2__Group__4 : rule__Intent2__Group__4__Impl ;
    public final void rule__Intent2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2607:1: ( rule__Intent2__Group__4__Impl )
            // InternalBot.g:2608:2: rule__Intent2__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent2__Group__4__Impl();

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
    // $ANTLR end "rule__Intent2__Group__4"


    // $ANTLR start "rule__Intent2__Group__4__Impl"
    // InternalBot.g:2614:1: rule__Intent2__Group__4__Impl : ( ( rule__Intent2__Group_4__0 )? ) ;
    public final void rule__Intent2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2618:1: ( ( ( rule__Intent2__Group_4__0 )? ) )
            // InternalBot.g:2619:1: ( ( rule__Intent2__Group_4__0 )? )
            {
            // InternalBot.g:2619:1: ( ( rule__Intent2__Group_4__0 )? )
            // InternalBot.g:2620:2: ( rule__Intent2__Group_4__0 )?
            {
             before(grammarAccess.getIntent2Access().getGroup_4()); 
            // InternalBot.g:2621:2: ( rule__Intent2__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==59) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:2621:3: rule__Intent2__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent2__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntent2Access().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group__4__Impl"


    // $ANTLR start "rule__Intent2__Group_4__0"
    // InternalBot.g:2630:1: rule__Intent2__Group_4__0 : rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1 ;
    public final void rule__Intent2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2634:1: ( rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1 )
            // InternalBot.g:2635:2: rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1
            {
            pushFollow(FOLLOW_7);
            rule__Intent2__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group_4__1();

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
    // $ANTLR end "rule__Intent2__Group_4__0"


    // $ANTLR start "rule__Intent2__Group_4__0__Impl"
    // InternalBot.g:2642:1: rule__Intent2__Group_4__0__Impl : ( 'parameters' ) ;
    public final void rule__Intent2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2646:1: ( ( 'parameters' ) )
            // InternalBot.g:2647:1: ( 'parameters' )
            {
            // InternalBot.g:2647:1: ( 'parameters' )
            // InternalBot.g:2648:2: 'parameters'
            {
             before(grammarAccess.getIntent2Access().getParametersKeyword_4_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getIntent2Access().getParametersKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group_4__0__Impl"


    // $ANTLR start "rule__Intent2__Group_4__1"
    // InternalBot.g:2657:1: rule__Intent2__Group_4__1 : rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2 ;
    public final void rule__Intent2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2661:1: ( rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2 )
            // InternalBot.g:2662:2: rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2
            {
            pushFollow(FOLLOW_5);
            rule__Intent2__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group_4__2();

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
    // $ANTLR end "rule__Intent2__Group_4__1"


    // $ANTLR start "rule__Intent2__Group_4__1__Impl"
    // InternalBot.g:2669:1: rule__Intent2__Group_4__1__Impl : ( ':' ) ;
    public final void rule__Intent2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2673:1: ( ( ':' ) )
            // InternalBot.g:2674:1: ( ':' )
            {
            // InternalBot.g:2674:1: ( ':' )
            // InternalBot.g:2675:2: ':'
            {
             before(grammarAccess.getIntent2Access().getColonKeyword_4_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getIntent2Access().getColonKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group_4__1__Impl"


    // $ANTLR start "rule__Intent2__Group_4__2"
    // InternalBot.g:2684:1: rule__Intent2__Group_4__2 : rule__Intent2__Group_4__2__Impl ;
    public final void rule__Intent2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2688:1: ( rule__Intent2__Group_4__2__Impl )
            // InternalBot.g:2689:2: rule__Intent2__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent2__Group_4__2__Impl();

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
    // $ANTLR end "rule__Intent2__Group_4__2"


    // $ANTLR start "rule__Intent2__Group_4__2__Impl"
    // InternalBot.g:2695:1: rule__Intent2__Group_4__2__Impl : ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) ) ;
    public final void rule__Intent2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2699:1: ( ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) ) )
            // InternalBot.g:2700:1: ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) )
            {
            // InternalBot.g:2700:1: ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) )
            // InternalBot.g:2701:2: ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* )
            {
            // InternalBot.g:2701:2: ( ( rule__Intent2__Group_4_2__0 ) )
            // InternalBot.g:2702:3: ( rule__Intent2__Group_4_2__0 )
            {
             before(grammarAccess.getIntent2Access().getGroup_4_2()); 
            // InternalBot.g:2703:3: ( rule__Intent2__Group_4_2__0 )
            // InternalBot.g:2703:4: rule__Intent2__Group_4_2__0
            {
            pushFollow(FOLLOW_12);
            rule__Intent2__Group_4_2__0();

            state._fsp--;


            }

             after(grammarAccess.getIntent2Access().getGroup_4_2()); 

            }

            // InternalBot.g:2706:2: ( ( rule__Intent2__Group_4_2__0 )* )
            // InternalBot.g:2707:3: ( rule__Intent2__Group_4_2__0 )*
            {
             before(grammarAccess.getIntent2Access().getGroup_4_2()); 
            // InternalBot.g:2708:3: ( rule__Intent2__Group_4_2__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_STRING) ) {
                    int LA30_2 = input.LA(2);

                    if ( (LA30_2==51) ) {
                        int LA30_4 = input.LA(3);

                        if ( (LA30_4==67) ) {
                            alt30=1;
                        }


                    }
                    else if ( (LA30_2==54) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==RULE_ID) ) {
                    int LA30_3 = input.LA(2);

                    if ( (LA30_3==51) ) {
                        int LA30_4 = input.LA(3);

                        if ( (LA30_4==67) ) {
                            alt30=1;
                        }


                    }
                    else if ( (LA30_3==54) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // InternalBot.g:2708:4: rule__Intent2__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent2__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getIntent2Access().getGroup_4_2()); 

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
    // $ANTLR end "rule__Intent2__Group_4__2__Impl"


    // $ANTLR start "rule__Intent2__Group_4_2__0"
    // InternalBot.g:2718:1: rule__Intent2__Group_4_2__0 : rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1 ;
    public final void rule__Intent2__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2722:1: ( rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1 )
            // InternalBot.g:2723:2: rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Intent2__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent2__Group_4_2__1();

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
    // $ANTLR end "rule__Intent2__Group_4_2__0"


    // $ANTLR start "rule__Intent2__Group_4_2__0__Impl"
    // InternalBot.g:2730:1: rule__Intent2__Group_4_2__0__Impl : ( ( rule__Intent2__ParametersAssignment_4_2_0 )* ) ;
    public final void rule__Intent2__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2734:1: ( ( ( rule__Intent2__ParametersAssignment_4_2_0 )* ) )
            // InternalBot.g:2735:1: ( ( rule__Intent2__ParametersAssignment_4_2_0 )* )
            {
            // InternalBot.g:2735:1: ( ( rule__Intent2__ParametersAssignment_4_2_0 )* )
            // InternalBot.g:2736:2: ( rule__Intent2__ParametersAssignment_4_2_0 )*
            {
             before(grammarAccess.getIntent2Access().getParametersAssignment_4_2_0()); 
            // InternalBot.g:2737:2: ( rule__Intent2__ParametersAssignment_4_2_0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_STRING) ) {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1==54) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==RULE_ID) ) {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==54) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // InternalBot.g:2737:3: rule__Intent2__ParametersAssignment_4_2_0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent2__ParametersAssignment_4_2_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getIntent2Access().getParametersAssignment_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group_4_2__0__Impl"


    // $ANTLR start "rule__Intent2__Group_4_2__1"
    // InternalBot.g:2745:1: rule__Intent2__Group_4_2__1 : rule__Intent2__Group_4_2__1__Impl ;
    public final void rule__Intent2__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2749:1: ( rule__Intent2__Group_4_2__1__Impl )
            // InternalBot.g:2750:2: rule__Intent2__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent2__Group_4_2__1__Impl();

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
    // $ANTLR end "rule__Intent2__Group_4_2__1"


    // $ANTLR start "rule__Intent2__Group_4_2__1__Impl"
    // InternalBot.g:2756:1: rule__Intent2__Group_4_2__1__Impl : ( ( rule__Intent2__ParametersAssignment_4_2_1 ) ) ;
    public final void rule__Intent2__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2760:1: ( ( ( rule__Intent2__ParametersAssignment_4_2_1 ) ) )
            // InternalBot.g:2761:1: ( ( rule__Intent2__ParametersAssignment_4_2_1 ) )
            {
            // InternalBot.g:2761:1: ( ( rule__Intent2__ParametersAssignment_4_2_1 ) )
            // InternalBot.g:2762:2: ( rule__Intent2__ParametersAssignment_4_2_1 )
            {
             before(grammarAccess.getIntent2Access().getParametersAssignment_4_2_1()); 
            // InternalBot.g:2763:2: ( rule__Intent2__ParametersAssignment_4_2_1 )
            // InternalBot.g:2763:3: rule__Intent2__ParametersAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Intent2__ParametersAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getIntent2Access().getParametersAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__Group_4_2__1__Impl"


    // $ANTLR start "rule__Intent1__Group__0"
    // InternalBot.g:2772:1: rule__Intent1__Group__0 : rule__Intent1__Group__0__Impl rule__Intent1__Group__1 ;
    public final void rule__Intent1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2776:1: ( rule__Intent1__Group__0__Impl rule__Intent1__Group__1 )
            // InternalBot.g:2777:2: rule__Intent1__Group__0__Impl rule__Intent1__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Intent1__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Intent1__Group__1();

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
    // $ANTLR end "rule__Intent1__Group__0"


    // $ANTLR start "rule__Intent1__Group__0__Impl"
    // InternalBot.g:2784:1: rule__Intent1__Group__0__Impl : ( ( rule__Intent1__NameAssignment_0 ) ) ;
    public final void rule__Intent1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2788:1: ( ( ( rule__Intent1__NameAssignment_0 ) ) )
            // InternalBot.g:2789:1: ( ( rule__Intent1__NameAssignment_0 ) )
            {
            // InternalBot.g:2789:1: ( ( rule__Intent1__NameAssignment_0 ) )
            // InternalBot.g:2790:2: ( rule__Intent1__NameAssignment_0 )
            {
             before(grammarAccess.getIntent1Access().getNameAssignment_0()); 
            // InternalBot.g:2791:2: ( rule__Intent1__NameAssignment_0 )
            // InternalBot.g:2791:3: rule__Intent1__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Intent1__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIntent1Access().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent1__Group__0__Impl"


    // $ANTLR start "rule__Intent1__Group__1"
    // InternalBot.g:2799:1: rule__Intent1__Group__1 : rule__Intent1__Group__1__Impl ;
    public final void rule__Intent1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2803:1: ( rule__Intent1__Group__1__Impl )
            // InternalBot.g:2804:2: rule__Intent1__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Intent1__Group__1__Impl();

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
    // $ANTLR end "rule__Intent1__Group__1"


    // $ANTLR start "rule__Intent1__Group__1__Impl"
    // InternalBot.g:2810:1: rule__Intent1__Group__1__Impl : ( ( rule__Intent1__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2814:1: ( ( ( rule__Intent1__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2815:1: ( ( rule__Intent1__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2815:1: ( ( rule__Intent1__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2816:2: ( rule__Intent1__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2817:2: ( rule__Intent1__FallbackIntentAssignment_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==91) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBot.g:2817:3: rule__Intent1__FallbackIntentAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Intent1__FallbackIntentAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntent1Access().getFallbackIntentAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent1__Group__1__Impl"


    // $ANTLR start "rule__IntentLanguageInputs__Group__0"
    // InternalBot.g:2826:1: rule__IntentLanguageInputs__Group__0 : rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 ;
    public final void rule__IntentLanguageInputs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2830:1: ( rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 )
            // InternalBot.g:2831:2: rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalBot.g:2838:1: rule__IntentLanguageInputs__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__IntentLanguageInputs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2842:1: ( ( 'inputs' ) )
            // InternalBot.g:2843:1: ( 'inputs' )
            {
            // InternalBot.g:2843:1: ( 'inputs' )
            // InternalBot.g:2844:2: 'inputs'
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
    // InternalBot.g:2853:1: rule__IntentLanguageInputs__Group__1 : rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 ;
    public final void rule__IntentLanguageInputs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2857:1: ( rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 )
            // InternalBot.g:2858:2: rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalBot.g:2865:1: rule__IntentLanguageInputs__Group__1__Impl : ( ( rule__IntentLanguageInputs__Group_1__0 )? ) ;
    public final void rule__IntentLanguageInputs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2869:1: ( ( ( rule__IntentLanguageInputs__Group_1__0 )? ) )
            // InternalBot.g:2870:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            {
            // InternalBot.g:2870:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            // InternalBot.g:2871:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 
            // InternalBot.g:2872:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==63) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:2872:3: rule__IntentLanguageInputs__Group_1__0
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
    // InternalBot.g:2880:1: rule__IntentLanguageInputs__Group__2 : rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 ;
    public final void rule__IntentLanguageInputs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2884:1: ( rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 )
            // InternalBot.g:2885:2: rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalBot.g:2892:1: rule__IntentLanguageInputs__Group__2__Impl : ( '{' ) ;
    public final void rule__IntentLanguageInputs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2896:1: ( ( '{' ) )
            // InternalBot.g:2897:1: ( '{' )
            {
            // InternalBot.g:2897:1: ( '{' )
            // InternalBot.g:2898:2: '{'
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
    // InternalBot.g:2907:1: rule__IntentLanguageInputs__Group__3 : rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 ;
    public final void rule__IntentLanguageInputs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2911:1: ( rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 )
            // InternalBot.g:2912:2: rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalBot.g:2919:1: rule__IntentLanguageInputs__Group__3__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) ;
    public final void rule__IntentLanguageInputs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2923:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) )
            // InternalBot.g:2924:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            {
            // InternalBot.g:2924:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            // InternalBot.g:2925:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 
            // InternalBot.g:2926:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            // InternalBot.g:2926:3: rule__IntentLanguageInputs__InputsAssignment_3
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
    // InternalBot.g:2934:1: rule__IntentLanguageInputs__Group__4 : rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 ;
    public final void rule__IntentLanguageInputs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2938:1: ( rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 )
            // InternalBot.g:2939:2: rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5
            {
            pushFollow(FOLLOW_27);
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
    // InternalBot.g:2946:1: rule__IntentLanguageInputs__Group__4__Impl : ( ( rule__IntentLanguageInputs__Group_4__0 )* ) ;
    public final void rule__IntentLanguageInputs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2950:1: ( ( ( rule__IntentLanguageInputs__Group_4__0 )* ) )
            // InternalBot.g:2951:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            {
            // InternalBot.g:2951:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            // InternalBot.g:2952:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 
            // InternalBot.g:2953:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==54) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:2953:3: rule__IntentLanguageInputs__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__IntentLanguageInputs__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // InternalBot.g:2961:1: rule__IntentLanguageInputs__Group__5 : rule__IntentLanguageInputs__Group__5__Impl ;
    public final void rule__IntentLanguageInputs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2965:1: ( rule__IntentLanguageInputs__Group__5__Impl )
            // InternalBot.g:2966:2: rule__IntentLanguageInputs__Group__5__Impl
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
    // InternalBot.g:2972:1: rule__IntentLanguageInputs__Group__5__Impl : ( '}' ) ;
    public final void rule__IntentLanguageInputs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2976:1: ( ( '}' ) )
            // InternalBot.g:2977:1: ( '}' )
            {
            // InternalBot.g:2977:1: ( '}' )
            // InternalBot.g:2978:2: '}'
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
    // InternalBot.g:2988:1: rule__IntentLanguageInputs__Group_1__0 : rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 ;
    public final void rule__IntentLanguageInputs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2992:1: ( rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 )
            // InternalBot.g:2993:2: rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalBot.g:3000:1: rule__IntentLanguageInputs__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__IntentLanguageInputs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3004:1: ( ( 'in' ) )
            // InternalBot.g:3005:1: ( 'in' )
            {
            // InternalBot.g:3005:1: ( 'in' )
            // InternalBot.g:3006:2: 'in'
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
    // InternalBot.g:3015:1: rule__IntentLanguageInputs__Group_1__1 : rule__IntentLanguageInputs__Group_1__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3019:1: ( rule__IntentLanguageInputs__Group_1__1__Impl )
            // InternalBot.g:3020:2: rule__IntentLanguageInputs__Group_1__1__Impl
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
    // InternalBot.g:3026:1: rule__IntentLanguageInputs__Group_1__1__Impl : ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3030:1: ( ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:3031:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:3031:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            // InternalBot.g:3032:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:3033:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            // InternalBot.g:3033:3: rule__IntentLanguageInputs__LanguageAssignment_1_1
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
    // InternalBot.g:3042:1: rule__IntentLanguageInputs__Group_4__0 : rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 ;
    public final void rule__IntentLanguageInputs__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3046:1: ( rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 )
            // InternalBot.g:3047:2: rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalBot.g:3054:1: rule__IntentLanguageInputs__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IntentLanguageInputs__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3058:1: ( ( ',' ) )
            // InternalBot.g:3059:1: ( ',' )
            {
            // InternalBot.g:3059:1: ( ',' )
            // InternalBot.g:3060:2: ','
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
    // InternalBot.g:3069:1: rule__IntentLanguageInputs__Group_4__1 : rule__IntentLanguageInputs__Group_4__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3073:1: ( rule__IntentLanguageInputs__Group_4__1__Impl )
            // InternalBot.g:3074:2: rule__IntentLanguageInputs__Group_4__1__Impl
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
    // InternalBot.g:3080:1: rule__IntentLanguageInputs__Group_4__1__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3084:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) )
            // InternalBot.g:3085:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:3085:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            // InternalBot.g:3086:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:3087:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            // InternalBot.g:3087:3: rule__IntentLanguageInputs__InputsAssignment_4_1
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
    // InternalBot.g:3096:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3100:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:3101:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
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
    // InternalBot.g:3108:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3112:1: ( ( 'user' ) )
            // InternalBot.g:3113:1: ( 'user' )
            {
            // InternalBot.g:3113:1: ( 'user' )
            // InternalBot.g:3114:2: 'user'
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
    // InternalBot.g:3123:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3127:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:3128:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalBot.g:3135:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3139:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:3140:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:3140:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:3141:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:3142:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:3142:3: rule__Transition__IntentAssignment_1
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
    // InternalBot.g:3150:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3154:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:3155:2: rule__Transition__Group__2__Impl
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
    // InternalBot.g:3161:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3165:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:3166:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:3166:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:3167:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:3168:2: ( rule__Transition__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==65) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:3168:3: rule__Transition__Group_2__0
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
    // InternalBot.g:3177:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3181:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:3182:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalBot.g:3189:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3193:1: ( ( '=>' ) )
            // InternalBot.g:3194:1: ( '=>' )
            {
            // InternalBot.g:3194:1: ( '=>' )
            // InternalBot.g:3195:2: '=>'
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
    // InternalBot.g:3204:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3208:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:3209:2: rule__Transition__Group_2__1__Impl
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
    // InternalBot.g:3215:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3219:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:3220:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:3220:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:3221:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:3222:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:3222:3: rule__Transition__TargetAssignment_2_1
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
    // InternalBot.g:3231:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3235:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:3236:2: rule__State__Group__0__Impl rule__State__Group__1
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
    // InternalBot.g:3243:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3247:1: ( ( 'chatbot' ) )
            // InternalBot.g:3248:1: ( 'chatbot' )
            {
            // InternalBot.g:3248:1: ( 'chatbot' )
            // InternalBot.g:3249:2: 'chatbot'
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
    // InternalBot.g:3258:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3262:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:3263:2: rule__State__Group__1__Impl rule__State__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalBot.g:3270:1: rule__State__Group__1__Impl : ( ( rule__State__ActionsAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3274:1: ( ( ( rule__State__ActionsAssignment_1 ) ) )
            // InternalBot.g:3275:1: ( ( rule__State__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3275:1: ( ( rule__State__ActionsAssignment_1 ) )
            // InternalBot.g:3276:2: ( rule__State__ActionsAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_1()); 
            // InternalBot.g:3277:2: ( rule__State__ActionsAssignment_1 )
            // InternalBot.g:3277:3: rule__State__ActionsAssignment_1
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
    // InternalBot.g:3285:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3289:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:3290:2: rule__State__Group__2__Impl rule__State__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalBot.g:3297:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )* ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3301:1: ( ( ( rule__State__Group_2__0 )* ) )
            // InternalBot.g:3302:1: ( ( rule__State__Group_2__0 )* )
            {
            // InternalBot.g:3302:1: ( ( rule__State__Group_2__0 )* )
            // InternalBot.g:3303:2: ( rule__State__Group_2__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // InternalBot.g:3304:2: ( rule__State__Group_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==54) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:3304:3: rule__State__Group_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__State__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalBot.g:3312:1: rule__State__Group__3 : rule__State__Group__3__Impl ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3316:1: ( rule__State__Group__3__Impl )
            // InternalBot.g:3317:2: rule__State__Group__3__Impl
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
    // InternalBot.g:3323:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3327:1: ( ( ( rule__State__Group_3__0 )? ) )
            // InternalBot.g:3328:1: ( ( rule__State__Group_3__0 )? )
            {
            // InternalBot.g:3328:1: ( ( rule__State__Group_3__0 )? )
            // InternalBot.g:3329:2: ( rule__State__Group_3__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:3330:2: ( rule__State__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==65) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:3330:3: rule__State__Group_3__0
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
    // InternalBot.g:3339:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3343:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // InternalBot.g:3344:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
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
    // InternalBot.g:3351:1: rule__State__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3355:1: ( ( ',' ) )
            // InternalBot.g:3356:1: ( ',' )
            {
            // InternalBot.g:3356:1: ( ',' )
            // InternalBot.g:3357:2: ','
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
    // InternalBot.g:3366:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3370:1: ( rule__State__Group_2__1__Impl )
            // InternalBot.g:3371:2: rule__State__Group_2__1__Impl
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
    // InternalBot.g:3377:1: rule__State__Group_2__1__Impl : ( ( rule__State__ActionsAssignment_2_1 ) ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3381:1: ( ( ( rule__State__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3382:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3382:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            // InternalBot.g:3383:2: ( rule__State__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_1()); 
            // InternalBot.g:3384:2: ( rule__State__ActionsAssignment_2_1 )
            // InternalBot.g:3384:3: rule__State__ActionsAssignment_2_1
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
    // InternalBot.g:3393:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3397:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:3398:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
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
    // InternalBot.g:3405:1: rule__State__Group_3__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3409:1: ( ( '=>' ) )
            // InternalBot.g:3410:1: ( '=>' )
            {
            // InternalBot.g:3410:1: ( '=>' )
            // InternalBot.g:3411:2: '=>'
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
    // InternalBot.g:3420:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3424:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:3425:2: rule__State__Group_3__1__Impl
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
    // InternalBot.g:3431:1: rule__State__Group_3__1__Impl : ( ( rule__State__OutcomingAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3435:1: ( ( ( rule__State__OutcomingAssignment_3_1 ) ) )
            // InternalBot.g:3436:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            {
            // InternalBot.g:3436:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            // InternalBot.g:3437:2: ( rule__State__OutcomingAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_3_1()); 
            // InternalBot.g:3438:2: ( rule__State__OutcomingAssignment_3_1 )
            // InternalBot.g:3438:3: rule__State__OutcomingAssignment_3_1
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
    // InternalBot.g:3447:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3451:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:3452:2: rule__State2__Group__0__Impl rule__State2__Group__1
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
    // InternalBot.g:3459:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3463:1: ( ( 'chatbot' ) )
            // InternalBot.g:3464:1: ( 'chatbot' )
            {
            // InternalBot.g:3464:1: ( 'chatbot' )
            // InternalBot.g:3465:2: 'chatbot'
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
    // InternalBot.g:3474:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3478:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:3479:2: rule__State2__Group__1__Impl rule__State2__Group__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalBot.g:3486:1: rule__State2__Group__1__Impl : ( ( rule__State2__ActionsAssignment_1 ) ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3490:1: ( ( ( rule__State2__ActionsAssignment_1 ) ) )
            // InternalBot.g:3491:1: ( ( rule__State2__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3491:1: ( ( rule__State2__ActionsAssignment_1 ) )
            // InternalBot.g:3492:2: ( rule__State2__ActionsAssignment_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_1()); 
            // InternalBot.g:3493:2: ( rule__State2__ActionsAssignment_1 )
            // InternalBot.g:3493:3: rule__State2__ActionsAssignment_1
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
    // InternalBot.g:3501:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3505:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:3506:2: rule__State2__Group__2__Impl rule__State2__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalBot.g:3513:1: rule__State2__Group__2__Impl : ( ( rule__State2__Group_2__0 )* ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3517:1: ( ( ( rule__State2__Group_2__0 )* ) )
            // InternalBot.g:3518:1: ( ( rule__State2__Group_2__0 )* )
            {
            // InternalBot.g:3518:1: ( ( rule__State2__Group_2__0 )* )
            // InternalBot.g:3519:2: ( rule__State2__Group_2__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_2()); 
            // InternalBot.g:3520:2: ( rule__State2__Group_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==54) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBot.g:3520:3: rule__State2__Group_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__State2__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalBot.g:3528:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3532:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:3533:2: rule__State2__Group__3__Impl rule__State2__Group__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalBot.g:3540:1: rule__State2__Group__3__Impl : ( '{' ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3544:1: ( ( '{' ) )
            // InternalBot.g:3545:1: ( '{' )
            {
            // InternalBot.g:3545:1: ( '{' )
            // InternalBot.g:3546:2: '{'
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
    // InternalBot.g:3555:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3559:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:3560:2: rule__State2__Group__4__Impl rule__State2__Group__5
            {
            pushFollow(FOLLOW_32);
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
    // InternalBot.g:3567:1: rule__State2__Group__4__Impl : ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3571:1: ( ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) )
            // InternalBot.g:3572:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            {
            // InternalBot.g:3572:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            // InternalBot.g:3573:2: ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* )
            {
            // InternalBot.g:3573:2: ( ( rule__State2__Group_4__0 ) )
            // InternalBot.g:3574:3: ( rule__State2__Group_4__0 )
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3575:3: ( rule__State2__Group_4__0 )
            // InternalBot.g:3575:4: rule__State2__Group_4__0
            {
            pushFollow(FOLLOW_33);
            rule__State2__Group_4__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_4()); 

            }

            // InternalBot.g:3578:2: ( ( rule__State2__Group_4__0 )* )
            // InternalBot.g:3579:3: ( rule__State2__Group_4__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3580:3: ( rule__State2__Group_4__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==65) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBot.g:3580:4: rule__State2__Group_4__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__State2__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalBot.g:3589:1: rule__State2__Group__5 : rule__State2__Group__5__Impl ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3593:1: ( rule__State2__Group__5__Impl )
            // InternalBot.g:3594:2: rule__State2__Group__5__Impl
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
    // InternalBot.g:3600:1: rule__State2__Group__5__Impl : ( '}' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3604:1: ( ( '}' ) )
            // InternalBot.g:3605:1: ( '}' )
            {
            // InternalBot.g:3605:1: ( '}' )
            // InternalBot.g:3606:2: '}'
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
    // InternalBot.g:3616:1: rule__State2__Group_2__0 : rule__State2__Group_2__0__Impl rule__State2__Group_2__1 ;
    public final void rule__State2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3620:1: ( rule__State2__Group_2__0__Impl rule__State2__Group_2__1 )
            // InternalBot.g:3621:2: rule__State2__Group_2__0__Impl rule__State2__Group_2__1
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
    // InternalBot.g:3628:1: rule__State2__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3632:1: ( ( ',' ) )
            // InternalBot.g:3633:1: ( ',' )
            {
            // InternalBot.g:3633:1: ( ',' )
            // InternalBot.g:3634:2: ','
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
    // InternalBot.g:3643:1: rule__State2__Group_2__1 : rule__State2__Group_2__1__Impl ;
    public final void rule__State2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3647:1: ( rule__State2__Group_2__1__Impl )
            // InternalBot.g:3648:2: rule__State2__Group_2__1__Impl
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
    // InternalBot.g:3654:1: rule__State2__Group_2__1__Impl : ( ( rule__State2__ActionsAssignment_2_1 ) ) ;
    public final void rule__State2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3658:1: ( ( ( rule__State2__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3659:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3659:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            // InternalBot.g:3660:2: ( rule__State2__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2_1()); 
            // InternalBot.g:3661:2: ( rule__State2__ActionsAssignment_2_1 )
            // InternalBot.g:3661:3: rule__State2__ActionsAssignment_2_1
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
    // InternalBot.g:3670:1: rule__State2__Group_4__0 : rule__State2__Group_4__0__Impl rule__State2__Group_4__1 ;
    public final void rule__State2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3674:1: ( rule__State2__Group_4__0__Impl rule__State2__Group_4__1 )
            // InternalBot.g:3675:2: rule__State2__Group_4__0__Impl rule__State2__Group_4__1
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
    // InternalBot.g:3682:1: rule__State2__Group_4__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3686:1: ( ( '=>' ) )
            // InternalBot.g:3687:1: ( '=>' )
            {
            // InternalBot.g:3687:1: ( '=>' )
            // InternalBot.g:3688:2: '=>'
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
    // InternalBot.g:3697:1: rule__State2__Group_4__1 : rule__State2__Group_4__1__Impl rule__State2__Group_4__2 ;
    public final void rule__State2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3701:1: ( rule__State2__Group_4__1__Impl rule__State2__Group_4__2 )
            // InternalBot.g:3702:2: rule__State2__Group_4__1__Impl rule__State2__Group_4__2
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
    // InternalBot.g:3709:1: rule__State2__Group_4__1__Impl : ( ( rule__State2__OutcomingAssignment_4_1 ) ) ;
    public final void rule__State2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3713:1: ( ( ( rule__State2__OutcomingAssignment_4_1 ) ) )
            // InternalBot.g:3714:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            {
            // InternalBot.g:3714:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            // InternalBot.g:3715:2: ( rule__State2__OutcomingAssignment_4_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_4_1()); 
            // InternalBot.g:3716:2: ( rule__State2__OutcomingAssignment_4_1 )
            // InternalBot.g:3716:3: rule__State2__OutcomingAssignment_4_1
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
    // InternalBot.g:3724:1: rule__State2__Group_4__2 : rule__State2__Group_4__2__Impl ;
    public final void rule__State2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3728:1: ( rule__State2__Group_4__2__Impl )
            // InternalBot.g:3729:2: rule__State2__Group_4__2__Impl
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
    // InternalBot.g:3735:1: rule__State2__Group_4__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3739:1: ( ( ';' ) )
            // InternalBot.g:3740:1: ( ';' )
            {
            // InternalBot.g:3740:1: ( ';' )
            // InternalBot.g:3741:2: ';'
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
    // InternalBot.g:3751:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3755:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3756:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalBot.g:3763:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3767:1: ( ( () ) )
            // InternalBot.g:3768:1: ( () )
            {
            // InternalBot.g:3768:1: ( () )
            // InternalBot.g:3769:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3770:2: ()
            // InternalBot.g:3770:3: 
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
    // InternalBot.g:3778:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3782:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3783:2: rule__TrainingPhrase__Group__1__Impl
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
    // InternalBot.g:3789:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3793:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3794:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3794:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3795:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3795:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3796:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3797:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3797:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_35);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3800:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3801:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3802:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==72) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:3802:4: rule__TrainingPhrase__TokensAssignment_1
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__TrainingPhrase__TokensAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalBot.g:3812:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3816:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3817:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:3824:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3828:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3829:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3829:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3830:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3831:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3831:3: rule__Parameter__NameAssignment_0
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
    // InternalBot.g:3839:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3843:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3844:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_36);
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
    // InternalBot.g:3851:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3855:1: ( ( ':' ) )
            // InternalBot.g:3856:1: ( ':' )
            {
            // InternalBot.g:3856:1: ( ':' )
            // InternalBot.g:3857:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:3866:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3870:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3871:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
            {
            pushFollow(FOLLOW_37);
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
    // InternalBot.g:3878:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3882:1: ( ( 'entity' ) )
            // InternalBot.g:3883:1: ( 'entity' )
            {
            // InternalBot.g:3883:1: ( 'entity' )
            // InternalBot.g:3884:2: 'entity'
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
    // InternalBot.g:3893:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3897:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:3898:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3905:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3909:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:3910:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:3910:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:3911:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:3912:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:3912:3: rule__Parameter__Alternatives_3
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
    // InternalBot.g:3920:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3924:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:3925:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3932:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3936:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:3937:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:3937:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:3938:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:3939:2: ( rule__Parameter__Group_4__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==54) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==92) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:3939:3: rule__Parameter__Group_4__0
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
    // InternalBot.g:3947:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3951:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:3952:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3959:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3963:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:3964:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:3964:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:3965:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:3966:2: ( rule__Parameter__Group_5__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==93) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:3966:3: rule__Parameter__Group_5__0
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
    // InternalBot.g:3974:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl rule__Parameter__Group__7 ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3978:1: ( rule__Parameter__Group__6__Impl rule__Parameter__Group__7 )
            // InternalBot.g:3979:2: rule__Parameter__Group__6__Impl rule__Parameter__Group__7
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:3986:1: rule__Parameter__Group__6__Impl : ( ( rule__Parameter__Group_6__0 )? ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3990:1: ( ( ( rule__Parameter__Group_6__0 )? ) )
            // InternalBot.g:3991:1: ( ( rule__Parameter__Group_6__0 )? )
            {
            // InternalBot.g:3991:1: ( ( rule__Parameter__Group_6__0 )? )
            // InternalBot.g:3992:2: ( rule__Parameter__Group_6__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_6()); 
            // InternalBot.g:3993:2: ( rule__Parameter__Group_6__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==54) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:3993:3: rule__Parameter__Group_6__0
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
    // InternalBot.g:4001:1: rule__Parameter__Group__7 : rule__Parameter__Group__7__Impl ;
    public final void rule__Parameter__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4005:1: ( rule__Parameter__Group__7__Impl )
            // InternalBot.g:4006:2: rule__Parameter__Group__7__Impl
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
    // InternalBot.g:4012:1: rule__Parameter__Group__7__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4016:1: ( ( ';' ) )
            // InternalBot.g:4017:1: ( ';' )
            {
            // InternalBot.g:4017:1: ( ';' )
            // InternalBot.g:4018:2: ';'
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
    // InternalBot.g:4028:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4032:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:4033:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
            {
            pushFollow(FOLLOW_39);
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
    // InternalBot.g:4040:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4044:1: ( ( ',' ) )
            // InternalBot.g:4045:1: ( ',' )
            {
            // InternalBot.g:4045:1: ( ',' )
            // InternalBot.g:4046:2: ','
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
    // InternalBot.g:4055:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4059:1: ( rule__Parameter__Group_4__1__Impl )
            // InternalBot.g:4060:2: rule__Parameter__Group_4__1__Impl
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
    // InternalBot.g:4066:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__IsListAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4070:1: ( ( ( rule__Parameter__IsListAssignment_4_1 ) ) )
            // InternalBot.g:4071:1: ( ( rule__Parameter__IsListAssignment_4_1 ) )
            {
            // InternalBot.g:4071:1: ( ( rule__Parameter__IsListAssignment_4_1 ) )
            // InternalBot.g:4072:2: ( rule__Parameter__IsListAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_4_1()); 
            // InternalBot.g:4073:2: ( rule__Parameter__IsListAssignment_4_1 )
            // InternalBot.g:4073:3: rule__Parameter__IsListAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__IsListAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getIsListAssignment_4_1()); 

            }


            }

        }
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
    // InternalBot.g:4082:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4086:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:4087:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
            {
            pushFollow(FOLLOW_40);
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
    // InternalBot.g:4094:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4098:1: ( ( ',' ) )
            // InternalBot.g:4099:1: ( ',' )
            {
            // InternalBot.g:4099:1: ( ',' )
            // InternalBot.g:4100:2: ','
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
    // InternalBot.g:4109:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4113:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:4114:2: rule__Parameter__Group_5__1__Impl
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
    // InternalBot.g:4120:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__RequiredAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4124:1: ( ( ( rule__Parameter__RequiredAssignment_5_1 ) ) )
            // InternalBot.g:4125:1: ( ( rule__Parameter__RequiredAssignment_5_1 ) )
            {
            // InternalBot.g:4125:1: ( ( rule__Parameter__RequiredAssignment_5_1 ) )
            // InternalBot.g:4126:2: ( rule__Parameter__RequiredAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_5_1()); 
            // InternalBot.g:4127:2: ( rule__Parameter__RequiredAssignment_5_1 )
            // InternalBot.g:4127:3: rule__Parameter__RequiredAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Parameter__RequiredAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getRequiredAssignment_5_1()); 

            }


            }

        }
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
    // InternalBot.g:4136:1: rule__Parameter__Group_6__0 : rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 ;
    public final void rule__Parameter__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4140:1: ( rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 )
            // InternalBot.g:4141:2: rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1
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
    // InternalBot.g:4148:1: rule__Parameter__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4152:1: ( ( ',' ) )
            // InternalBot.g:4153:1: ( ',' )
            {
            // InternalBot.g:4153:1: ( ',' )
            // InternalBot.g:4154:2: ','
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
    // InternalBot.g:4163:1: rule__Parameter__Group_6__1 : rule__Parameter__Group_6__1__Impl ;
    public final void rule__Parameter__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4167:1: ( rule__Parameter__Group_6__1__Impl )
            // InternalBot.g:4168:2: rule__Parameter__Group_6__1__Impl
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
    // InternalBot.g:4174:1: rule__Parameter__Group_6__1__Impl : ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) ) ;
    public final void rule__Parameter__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4178:1: ( ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) ) )
            // InternalBot.g:4179:1: ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) )
            {
            // InternalBot.g:4179:1: ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) )
            // InternalBot.g:4180:2: ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* )
            {
            // InternalBot.g:4180:2: ( ( rule__Parameter__PromptsAssignment_6_1 ) )
            // InternalBot.g:4181:3: ( rule__Parameter__PromptsAssignment_6_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 
            // InternalBot.g:4182:3: ( rule__Parameter__PromptsAssignment_6_1 )
            // InternalBot.g:4182:4: rule__Parameter__PromptsAssignment_6_1
            {
            pushFollow(FOLLOW_42);
            rule__Parameter__PromptsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 

            }

            // InternalBot.g:4185:2: ( ( rule__Parameter__PromptsAssignment_6_1 )* )
            // InternalBot.g:4186:3: ( rule__Parameter__PromptsAssignment_6_1 )*
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 
            // InternalBot.g:4187:3: ( rule__Parameter__PromptsAssignment_6_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==68) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:4187:4: rule__Parameter__PromptsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__Parameter__PromptsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 

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
    // $ANTLR end "rule__Parameter__Group_6__1__Impl"


    // $ANTLR start "rule__Parameter2__Group__0"
    // InternalBot.g:4197:1: rule__Parameter2__Group__0 : rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 ;
    public final void rule__Parameter2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4201:1: ( rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 )
            // InternalBot.g:4202:2: rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1
            {
            pushFollow(FOLLOW_43);
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
    // InternalBot.g:4209:1: rule__Parameter2__Group__0__Impl : ( ( rule__Parameter2__NameAssignment_0 ) ) ;
    public final void rule__Parameter2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4213:1: ( ( ( rule__Parameter2__NameAssignment_0 ) ) )
            // InternalBot.g:4214:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            {
            // InternalBot.g:4214:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            // InternalBot.g:4215:2: ( rule__Parameter2__NameAssignment_0 )
            {
             before(grammarAccess.getParameter2Access().getNameAssignment_0()); 
            // InternalBot.g:4216:2: ( rule__Parameter2__NameAssignment_0 )
            // InternalBot.g:4216:3: rule__Parameter2__NameAssignment_0
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
    // InternalBot.g:4224:1: rule__Parameter2__Group__1 : rule__Parameter2__Group__1__Impl ;
    public final void rule__Parameter2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4228:1: ( rule__Parameter2__Group__1__Impl )
            // InternalBot.g:4229:2: rule__Parameter2__Group__1__Impl
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
    // InternalBot.g:4235:1: rule__Parameter2__Group__1__Impl : ( ',' ) ;
    public final void rule__Parameter2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4239:1: ( ( ',' ) )
            // InternalBot.g:4240:1: ( ',' )
            {
            // InternalBot.g:4240:1: ( ',' )
            // InternalBot.g:4241:2: ','
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
    // InternalBot.g:4251:1: rule__PromptLanguage__Group__0 : rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 ;
    public final void rule__PromptLanguage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4255:1: ( rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 )
            // InternalBot.g:4256:2: rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1
            {
            pushFollow(FOLLOW_44);
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
    // InternalBot.g:4263:1: rule__PromptLanguage__Group__0__Impl : ( 'prompts' ) ;
    public final void rule__PromptLanguage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4267:1: ( ( 'prompts' ) )
            // InternalBot.g:4268:1: ( 'prompts' )
            {
            // InternalBot.g:4268:1: ( 'prompts' )
            // InternalBot.g:4269:2: 'prompts'
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
    // InternalBot.g:4278:1: rule__PromptLanguage__Group__1 : rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 ;
    public final void rule__PromptLanguage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4282:1: ( rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 )
            // InternalBot.g:4283:2: rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2
            {
            pushFollow(FOLLOW_44);
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
    // InternalBot.g:4290:1: rule__PromptLanguage__Group__1__Impl : ( ( rule__PromptLanguage__Group_1__0 )? ) ;
    public final void rule__PromptLanguage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4294:1: ( ( ( rule__PromptLanguage__Group_1__0 )? ) )
            // InternalBot.g:4295:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            {
            // InternalBot.g:4295:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            // InternalBot.g:4296:2: ( rule__PromptLanguage__Group_1__0 )?
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_1()); 
            // InternalBot.g:4297:2: ( rule__PromptLanguage__Group_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==63) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBot.g:4297:3: rule__PromptLanguage__Group_1__0
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
    // InternalBot.g:4305:1: rule__PromptLanguage__Group__2 : rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 ;
    public final void rule__PromptLanguage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4309:1: ( rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 )
            // InternalBot.g:4310:2: rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3
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
    // InternalBot.g:4317:1: rule__PromptLanguage__Group__2__Impl : ( '[' ) ;
    public final void rule__PromptLanguage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4321:1: ( ( '[' ) )
            // InternalBot.g:4322:1: ( '[' )
            {
            // InternalBot.g:4322:1: ( '[' )
            // InternalBot.g:4323:2: '['
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
    // InternalBot.g:4332:1: rule__PromptLanguage__Group__3 : rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 ;
    public final void rule__PromptLanguage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4336:1: ( rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 )
            // InternalBot.g:4337:2: rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4
            {
            pushFollow(FOLLOW_45);
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
    // InternalBot.g:4344:1: rule__PromptLanguage__Group__3__Impl : ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) ;
    public final void rule__PromptLanguage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4348:1: ( ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) )
            // InternalBot.g:4349:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            {
            // InternalBot.g:4349:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            // InternalBot.g:4350:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 
            // InternalBot.g:4351:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            // InternalBot.g:4351:3: rule__PromptLanguage__PromptsAssignment_3
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
    // InternalBot.g:4359:1: rule__PromptLanguage__Group__4 : rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 ;
    public final void rule__PromptLanguage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4363:1: ( rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 )
            // InternalBot.g:4364:2: rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5
            {
            pushFollow(FOLLOW_45);
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
    // InternalBot.g:4371:1: rule__PromptLanguage__Group__4__Impl : ( ( rule__PromptLanguage__Group_4__0 )* ) ;
    public final void rule__PromptLanguage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4375:1: ( ( ( rule__PromptLanguage__Group_4__0 )* ) )
            // InternalBot.g:4376:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            {
            // InternalBot.g:4376:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            // InternalBot.g:4377:2: ( rule__PromptLanguage__Group_4__0 )*
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_4()); 
            // InternalBot.g:4378:2: ( rule__PromptLanguage__Group_4__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==54) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:4378:3: rule__PromptLanguage__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__PromptLanguage__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalBot.g:4386:1: rule__PromptLanguage__Group__5 : rule__PromptLanguage__Group__5__Impl ;
    public final void rule__PromptLanguage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4390:1: ( rule__PromptLanguage__Group__5__Impl )
            // InternalBot.g:4391:2: rule__PromptLanguage__Group__5__Impl
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
    // InternalBot.g:4397:1: rule__PromptLanguage__Group__5__Impl : ( ']' ) ;
    public final void rule__PromptLanguage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4401:1: ( ( ']' ) )
            // InternalBot.g:4402:1: ( ']' )
            {
            // InternalBot.g:4402:1: ( ']' )
            // InternalBot.g:4403:2: ']'
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
    // InternalBot.g:4413:1: rule__PromptLanguage__Group_1__0 : rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 ;
    public final void rule__PromptLanguage__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4417:1: ( rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 )
            // InternalBot.g:4418:2: rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalBot.g:4425:1: rule__PromptLanguage__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__PromptLanguage__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4429:1: ( ( 'in' ) )
            // InternalBot.g:4430:1: ( 'in' )
            {
            // InternalBot.g:4430:1: ( 'in' )
            // InternalBot.g:4431:2: 'in'
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
    // InternalBot.g:4440:1: rule__PromptLanguage__Group_1__1 : rule__PromptLanguage__Group_1__1__Impl ;
    public final void rule__PromptLanguage__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4444:1: ( rule__PromptLanguage__Group_1__1__Impl )
            // InternalBot.g:4445:2: rule__PromptLanguage__Group_1__1__Impl
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
    // InternalBot.g:4451:1: rule__PromptLanguage__Group_1__1__Impl : ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) ;
    public final void rule__PromptLanguage__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4455:1: ( ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:4456:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:4456:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            // InternalBot.g:4457:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:4458:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            // InternalBot.g:4458:3: rule__PromptLanguage__LanguageAssignment_1_1
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
    // InternalBot.g:4467:1: rule__PromptLanguage__Group_4__0 : rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 ;
    public final void rule__PromptLanguage__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4471:1: ( rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 )
            // InternalBot.g:4472:2: rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1
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
    // InternalBot.g:4479:1: rule__PromptLanguage__Group_4__0__Impl : ( ',' ) ;
    public final void rule__PromptLanguage__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4483:1: ( ( ',' ) )
            // InternalBot.g:4484:1: ( ',' )
            {
            // InternalBot.g:4484:1: ( ',' )
            // InternalBot.g:4485:2: ','
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
    // InternalBot.g:4494:1: rule__PromptLanguage__Group_4__1 : rule__PromptLanguage__Group_4__1__Impl ;
    public final void rule__PromptLanguage__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4498:1: ( rule__PromptLanguage__Group_4__1__Impl )
            // InternalBot.g:4499:2: rule__PromptLanguage__Group_4__1__Impl
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
    // InternalBot.g:4505:1: rule__PromptLanguage__Group_4__1__Impl : ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) ;
    public final void rule__PromptLanguage__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4509:1: ( ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) )
            // InternalBot.g:4510:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            {
            // InternalBot.g:4510:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            // InternalBot.g:4511:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 
            // InternalBot.g:4512:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            // InternalBot.g:4512:3: rule__PromptLanguage__PromptsAssignment_4_1
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
    // InternalBot.g:4521:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4525:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:4526:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:4533:1: rule__EntityToken__Group__0__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4537:1: ( ( '@' ) )
            // InternalBot.g:4538:1: ( '@' )
            {
            // InternalBot.g:4538:1: ( '@' )
            // InternalBot.g:4539:2: '@'
            {
             before(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 

            }


            }

        }
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
    // InternalBot.g:4548:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4552:1: ( rule__EntityToken__Group__1__Impl )
            // InternalBot.g:4553:2: rule__EntityToken__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__Group__1__Impl();

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
    // InternalBot.g:4559:1: rule__EntityToken__Group__1__Impl : ( ( rule__EntityToken__EntityAssignment_1 ) ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4563:1: ( ( ( rule__EntityToken__EntityAssignment_1 ) ) )
            // InternalBot.g:4564:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            {
            // InternalBot.g:4564:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            // InternalBot.g:4565:2: ( rule__EntityToken__EntityAssignment_1 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 
            // InternalBot.g:4566:2: ( rule__EntityToken__EntityAssignment_1 )
            // InternalBot.g:4566:3: rule__EntityToken__EntityAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EntityToken__EntityAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ParameterToken__Group__0"
    // InternalBot.g:4575:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4579:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:4580:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
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
    // InternalBot.g:4587:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4591:1: ( ( '[' ) )
            // InternalBot.g:4592:1: ( '[' )
            {
            // InternalBot.g:4592:1: ( '[' )
            // InternalBot.g:4593:2: '['
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
    // InternalBot.g:4602:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4606:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:4607:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
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
    // InternalBot.g:4614:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4618:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:4619:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:4619:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:4620:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:4621:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:4621:3: rule__ParameterToken__ParameterAssignment_1
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
    // InternalBot.g:4629:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4633:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:4634:2: rule__ParameterToken__Group__2__Impl
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
    // InternalBot.g:4640:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4644:1: ( ( ']' ) )
            // InternalBot.g:4645:1: ( ']' )
            {
            // InternalBot.g:4645:1: ( ']' )
            // InternalBot.g:4646:2: ']'
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
    // InternalBot.g:4656:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4660:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:4661:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
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
    // InternalBot.g:4668:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4672:1: ( ( '(' ) )
            // InternalBot.g:4673:1: ( '(' )
            {
            // InternalBot.g:4673:1: ( '(' )
            // InternalBot.g:4674:2: '('
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalBot.g:4683:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4687:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:4688:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
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
    // InternalBot.g:4695:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4699:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:4700:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:4700:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:4701:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:4702:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:4702:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
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
    // InternalBot.g:4710:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4714:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:4715:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
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
    // InternalBot.g:4722:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4726:1: ( ( ')' ) )
            // InternalBot.g:4727:1: ( ')' )
            {
            // InternalBot.g:4727:1: ( ')' )
            // InternalBot.g:4728:2: ')'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 
            match(input,73,FOLLOW_2); 
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
    // InternalBot.g:4737:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4741:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:4742:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
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
    // InternalBot.g:4749:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4753:1: ( ( '[' ) )
            // InternalBot.g:4754:1: ( '[' )
            {
            // InternalBot.g:4754:1: ( '[' )
            // InternalBot.g:4755:2: '['
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
    // InternalBot.g:4764:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4768:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:4769:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
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
    // InternalBot.g:4776:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4780:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:4781:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:4781:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:4782:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:4783:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:4783:3: rule__ParameterRefenceToken__ParameterAssignment_4
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
    // InternalBot.g:4791:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4795:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:4796:2: rule__ParameterRefenceToken__Group__5__Impl
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
    // InternalBot.g:4802:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4806:1: ( ( ']' ) )
            // InternalBot.g:4807:1: ( ']' )
            {
            // InternalBot.g:4807:1: ( ']' )
            // InternalBot.g:4808:2: ']'
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
    // InternalBot.g:4818:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4822:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:4823:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
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
    // InternalBot.g:4830:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4834:1: ( ( 'request.' ) )
            // InternalBot.g:4835:1: ( 'request.' )
            {
            // InternalBot.g:4835:1: ( 'request.' )
            // InternalBot.g:4836:2: 'request.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalBot.g:4845:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4849:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:4850:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
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
    // InternalBot.g:4857:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4861:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4862:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4862:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4863:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4864:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4864:3: rule__HTTPRequestToken__TypeAssignment_1
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
    // InternalBot.g:4872:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4876:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:4877:2: rule__HTTPRequestToken__Group__2__Impl
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
    // InternalBot.g:4883:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4887:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:4888:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:4888:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:4889:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:4890:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==75) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:4890:3: rule__HTTPRequestToken__Group_2__0
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
    // InternalBot.g:4899:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4903:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:4904:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
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
    // InternalBot.g:4911:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4915:1: ( ( '.' ) )
            // InternalBot.g:4916:1: ( '.' )
            {
            // InternalBot.g:4916:1: ( '.' )
            // InternalBot.g:4917:2: '.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalBot.g:4926:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4930:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:4931:2: rule__HTTPRequestToken__Group_2__1__Impl
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
    // InternalBot.g:4937:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4941:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:4942:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:4942:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:4943:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:4944:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:4944:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
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


    // $ANTLR start "rule__SimpleEntity__Group__0"
    // InternalBot.g:4953:1: rule__SimpleEntity__Group__0 : rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1 ;
    public final void rule__SimpleEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4957:1: ( rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1 )
            // InternalBot.g:4958:2: rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__SimpleEntity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleEntity__Group__1();

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
    // $ANTLR end "rule__SimpleEntity__Group__0"


    // $ANTLR start "rule__SimpleEntity__Group__0__Impl"
    // InternalBot.g:4965:1: rule__SimpleEntity__Group__0__Impl : ( 'Simple' ) ;
    public final void rule__SimpleEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4969:1: ( ( 'Simple' ) )
            // InternalBot.g:4970:1: ( 'Simple' )
            {
            // InternalBot.g:4970:1: ( 'Simple' )
            // InternalBot.g:4971:2: 'Simple'
            {
             before(grammarAccess.getSimpleEntityAccess().getSimpleKeyword_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getSimpleEntityAccess().getSimpleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEntity__Group__0__Impl"


    // $ANTLR start "rule__SimpleEntity__Group__1"
    // InternalBot.g:4980:1: rule__SimpleEntity__Group__1 : rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2 ;
    public final void rule__SimpleEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4984:1: ( rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2 )
            // InternalBot.g:4985:2: rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__SimpleEntity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleEntity__Group__2();

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
    // $ANTLR end "rule__SimpleEntity__Group__1"


    // $ANTLR start "rule__SimpleEntity__Group__1__Impl"
    // InternalBot.g:4992:1: rule__SimpleEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__SimpleEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4996:1: ( ( 'entity' ) )
            // InternalBot.g:4997:1: ( 'entity' )
            {
            // InternalBot.g:4997:1: ( 'entity' )
            // InternalBot.g:4998:2: 'entity'
            {
             before(grammarAccess.getSimpleEntityAccess().getEntityKeyword_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getSimpleEntityAccess().getEntityKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEntity__Group__1__Impl"


    // $ANTLR start "rule__SimpleEntity__Group__2"
    // InternalBot.g:5007:1: rule__SimpleEntity__Group__2 : rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3 ;
    public final void rule__SimpleEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5011:1: ( rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3 )
            // InternalBot.g:5012:2: rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__SimpleEntity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleEntity__Group__3();

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
    // $ANTLR end "rule__SimpleEntity__Group__2"


    // $ANTLR start "rule__SimpleEntity__Group__2__Impl"
    // InternalBot.g:5019:1: rule__SimpleEntity__Group__2__Impl : ( ( rule__SimpleEntity__NameAssignment_2 ) ) ;
    public final void rule__SimpleEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5023:1: ( ( ( rule__SimpleEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5024:1: ( ( rule__SimpleEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5024:1: ( ( rule__SimpleEntity__NameAssignment_2 ) )
            // InternalBot.g:5025:2: ( rule__SimpleEntity__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5026:2: ( rule__SimpleEntity__NameAssignment_2 )
            // InternalBot.g:5026:3: rule__SimpleEntity__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SimpleEntity__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEntityAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEntity__Group__2__Impl"


    // $ANTLR start "rule__SimpleEntity__Group__3"
    // InternalBot.g:5034:1: rule__SimpleEntity__Group__3 : rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4 ;
    public final void rule__SimpleEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5038:1: ( rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4 )
            // InternalBot.g:5039:2: rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__SimpleEntity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleEntity__Group__4();

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
    // $ANTLR end "rule__SimpleEntity__Group__3"


    // $ANTLR start "rule__SimpleEntity__Group__3__Impl"
    // InternalBot.g:5046:1: rule__SimpleEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5050:1: ( ( ':' ) )
            // InternalBot.g:5051:1: ( ':' )
            {
            // InternalBot.g:5051:1: ( ':' )
            // InternalBot.g:5052:2: ':'
            {
             before(grammarAccess.getSimpleEntityAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getSimpleEntityAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEntity__Group__3__Impl"


    // $ANTLR start "rule__SimpleEntity__Group__4"
    // InternalBot.g:5061:1: rule__SimpleEntity__Group__4 : rule__SimpleEntity__Group__4__Impl ;
    public final void rule__SimpleEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5065:1: ( rule__SimpleEntity__Group__4__Impl )
            // InternalBot.g:5066:2: rule__SimpleEntity__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleEntity__Group__4__Impl();

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
    // $ANTLR end "rule__SimpleEntity__Group__4"


    // $ANTLR start "rule__SimpleEntity__Group__4__Impl"
    // InternalBot.g:5072:1: rule__SimpleEntity__Group__4__Impl : ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__SimpleEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5076:1: ( ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5077:1: ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5077:1: ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5078:2: ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5078:2: ( ( rule__SimpleEntity__InputsAssignment_4 ) )
            // InternalBot.g:5079:3: ( rule__SimpleEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5080:3: ( rule__SimpleEntity__InputsAssignment_4 )
            // InternalBot.g:5080:4: rule__SimpleEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__SimpleEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5083:2: ( ( rule__SimpleEntity__InputsAssignment_4 )* )
            // InternalBot.g:5084:3: ( rule__SimpleEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5085:3: ( rule__SimpleEntity__InputsAssignment_4 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=60 && LA48_0<=61)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBot.g:5085:4: rule__SimpleEntity__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__SimpleEntity__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 

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
    // $ANTLR end "rule__SimpleEntity__Group__4__Impl"


    // $ANTLR start "rule__ComplexEntity__Group__0"
    // InternalBot.g:5095:1: rule__ComplexEntity__Group__0 : rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1 ;
    public final void rule__ComplexEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5099:1: ( rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1 )
            // InternalBot.g:5100:2: rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__ComplexEntity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexEntity__Group__1();

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
    // $ANTLR end "rule__ComplexEntity__Group__0"


    // $ANTLR start "rule__ComplexEntity__Group__0__Impl"
    // InternalBot.g:5107:1: rule__ComplexEntity__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__ComplexEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5111:1: ( ( 'Composite' ) )
            // InternalBot.g:5112:1: ( 'Composite' )
            {
            // InternalBot.g:5112:1: ( 'Composite' )
            // InternalBot.g:5113:2: 'Composite'
            {
             before(grammarAccess.getComplexEntityAccess().getCompositeKeyword_0()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getComplexEntityAccess().getCompositeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEntity__Group__0__Impl"


    // $ANTLR start "rule__ComplexEntity__Group__1"
    // InternalBot.g:5122:1: rule__ComplexEntity__Group__1 : rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2 ;
    public final void rule__ComplexEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5126:1: ( rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2 )
            // InternalBot.g:5127:2: rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ComplexEntity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexEntity__Group__2();

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
    // $ANTLR end "rule__ComplexEntity__Group__1"


    // $ANTLR start "rule__ComplexEntity__Group__1__Impl"
    // InternalBot.g:5134:1: rule__ComplexEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__ComplexEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5138:1: ( ( 'entity' ) )
            // InternalBot.g:5139:1: ( 'entity' )
            {
            // InternalBot.g:5139:1: ( 'entity' )
            // InternalBot.g:5140:2: 'entity'
            {
             before(grammarAccess.getComplexEntityAccess().getEntityKeyword_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getComplexEntityAccess().getEntityKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEntity__Group__1__Impl"


    // $ANTLR start "rule__ComplexEntity__Group__2"
    // InternalBot.g:5149:1: rule__ComplexEntity__Group__2 : rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3 ;
    public final void rule__ComplexEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5153:1: ( rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3 )
            // InternalBot.g:5154:2: rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ComplexEntity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexEntity__Group__3();

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
    // $ANTLR end "rule__ComplexEntity__Group__2"


    // $ANTLR start "rule__ComplexEntity__Group__2__Impl"
    // InternalBot.g:5161:1: rule__ComplexEntity__Group__2__Impl : ( ( rule__ComplexEntity__NameAssignment_2 ) ) ;
    public final void rule__ComplexEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5165:1: ( ( ( rule__ComplexEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5166:1: ( ( rule__ComplexEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5166:1: ( ( rule__ComplexEntity__NameAssignment_2 ) )
            // InternalBot.g:5167:2: ( rule__ComplexEntity__NameAssignment_2 )
            {
             before(grammarAccess.getComplexEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5168:2: ( rule__ComplexEntity__NameAssignment_2 )
            // InternalBot.g:5168:3: rule__ComplexEntity__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ComplexEntity__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getComplexEntityAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEntity__Group__2__Impl"


    // $ANTLR start "rule__ComplexEntity__Group__3"
    // InternalBot.g:5176:1: rule__ComplexEntity__Group__3 : rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4 ;
    public final void rule__ComplexEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5180:1: ( rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4 )
            // InternalBot.g:5181:2: rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__ComplexEntity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComplexEntity__Group__4();

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
    // $ANTLR end "rule__ComplexEntity__Group__3"


    // $ANTLR start "rule__ComplexEntity__Group__3__Impl"
    // InternalBot.g:5188:1: rule__ComplexEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__ComplexEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5192:1: ( ( ':' ) )
            // InternalBot.g:5193:1: ( ':' )
            {
            // InternalBot.g:5193:1: ( ':' )
            // InternalBot.g:5194:2: ':'
            {
             before(grammarAccess.getComplexEntityAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getComplexEntityAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEntity__Group__3__Impl"


    // $ANTLR start "rule__ComplexEntity__Group__4"
    // InternalBot.g:5203:1: rule__ComplexEntity__Group__4 : rule__ComplexEntity__Group__4__Impl ;
    public final void rule__ComplexEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5207:1: ( rule__ComplexEntity__Group__4__Impl )
            // InternalBot.g:5208:2: rule__ComplexEntity__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComplexEntity__Group__4__Impl();

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
    // $ANTLR end "rule__ComplexEntity__Group__4"


    // $ANTLR start "rule__ComplexEntity__Group__4__Impl"
    // InternalBot.g:5214:1: rule__ComplexEntity__Group__4__Impl : ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__ComplexEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5218:1: ( ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5219:1: ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5219:1: ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5220:2: ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5220:2: ( ( rule__ComplexEntity__InputsAssignment_4 ) )
            // InternalBot.g:5221:3: ( rule__ComplexEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5222:3: ( rule__ComplexEntity__InputsAssignment_4 )
            // InternalBot.g:5222:4: rule__ComplexEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__ComplexEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5225:2: ( ( rule__ComplexEntity__InputsAssignment_4 )* )
            // InternalBot.g:5226:3: ( rule__ComplexEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5227:3: ( rule__ComplexEntity__InputsAssignment_4 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=60 && LA49_0<=61)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBot.g:5227:4: rule__ComplexEntity__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__ComplexEntity__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 

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
    // $ANTLR end "rule__ComplexEntity__Group__4__Impl"


    // $ANTLR start "rule__RegexEntity__Group__0"
    // InternalBot.g:5237:1: rule__RegexEntity__Group__0 : rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1 ;
    public final void rule__RegexEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5241:1: ( rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1 )
            // InternalBot.g:5242:2: rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__RegexEntity__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexEntity__Group__1();

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
    // $ANTLR end "rule__RegexEntity__Group__0"


    // $ANTLR start "rule__RegexEntity__Group__0__Impl"
    // InternalBot.g:5249:1: rule__RegexEntity__Group__0__Impl : ( 'Regex' ) ;
    public final void rule__RegexEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5253:1: ( ( 'Regex' ) )
            // InternalBot.g:5254:1: ( 'Regex' )
            {
            // InternalBot.g:5254:1: ( 'Regex' )
            // InternalBot.g:5255:2: 'Regex'
            {
             before(grammarAccess.getRegexEntityAccess().getRegexKeyword_0()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getRegexEntityAccess().getRegexKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexEntity__Group__0__Impl"


    // $ANTLR start "rule__RegexEntity__Group__1"
    // InternalBot.g:5264:1: rule__RegexEntity__Group__1 : rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2 ;
    public final void rule__RegexEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5268:1: ( rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2 )
            // InternalBot.g:5269:2: rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__RegexEntity__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexEntity__Group__2();

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
    // $ANTLR end "rule__RegexEntity__Group__1"


    // $ANTLR start "rule__RegexEntity__Group__1__Impl"
    // InternalBot.g:5276:1: rule__RegexEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__RegexEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5280:1: ( ( 'entity' ) )
            // InternalBot.g:5281:1: ( 'entity' )
            {
            // InternalBot.g:5281:1: ( 'entity' )
            // InternalBot.g:5282:2: 'entity'
            {
             before(grammarAccess.getRegexEntityAccess().getEntityKeyword_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getRegexEntityAccess().getEntityKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexEntity__Group__1__Impl"


    // $ANTLR start "rule__RegexEntity__Group__2"
    // InternalBot.g:5291:1: rule__RegexEntity__Group__2 : rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3 ;
    public final void rule__RegexEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5295:1: ( rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3 )
            // InternalBot.g:5296:2: rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__RegexEntity__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexEntity__Group__3();

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
    // $ANTLR end "rule__RegexEntity__Group__2"


    // $ANTLR start "rule__RegexEntity__Group__2__Impl"
    // InternalBot.g:5303:1: rule__RegexEntity__Group__2__Impl : ( ( rule__RegexEntity__NameAssignment_2 ) ) ;
    public final void rule__RegexEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5307:1: ( ( ( rule__RegexEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5308:1: ( ( rule__RegexEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5308:1: ( ( rule__RegexEntity__NameAssignment_2 ) )
            // InternalBot.g:5309:2: ( rule__RegexEntity__NameAssignment_2 )
            {
             before(grammarAccess.getRegexEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5310:2: ( rule__RegexEntity__NameAssignment_2 )
            // InternalBot.g:5310:3: rule__RegexEntity__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__RegexEntity__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRegexEntityAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexEntity__Group__2__Impl"


    // $ANTLR start "rule__RegexEntity__Group__3"
    // InternalBot.g:5318:1: rule__RegexEntity__Group__3 : rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4 ;
    public final void rule__RegexEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5322:1: ( rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4 )
            // InternalBot.g:5323:2: rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__RegexEntity__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RegexEntity__Group__4();

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
    // $ANTLR end "rule__RegexEntity__Group__3"


    // $ANTLR start "rule__RegexEntity__Group__3__Impl"
    // InternalBot.g:5330:1: rule__RegexEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__RegexEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5334:1: ( ( ':' ) )
            // InternalBot.g:5335:1: ( ':' )
            {
            // InternalBot.g:5335:1: ( ':' )
            // InternalBot.g:5336:2: ':'
            {
             before(grammarAccess.getRegexEntityAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getRegexEntityAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexEntity__Group__3__Impl"


    // $ANTLR start "rule__RegexEntity__Group__4"
    // InternalBot.g:5345:1: rule__RegexEntity__Group__4 : rule__RegexEntity__Group__4__Impl ;
    public final void rule__RegexEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5349:1: ( rule__RegexEntity__Group__4__Impl )
            // InternalBot.g:5350:2: rule__RegexEntity__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RegexEntity__Group__4__Impl();

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
    // $ANTLR end "rule__RegexEntity__Group__4"


    // $ANTLR start "rule__RegexEntity__Group__4__Impl"
    // InternalBot.g:5356:1: rule__RegexEntity__Group__4__Impl : ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__RegexEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5360:1: ( ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5361:1: ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5361:1: ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5362:2: ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5362:2: ( ( rule__RegexEntity__InputsAssignment_4 ) )
            // InternalBot.g:5363:3: ( rule__RegexEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5364:3: ( rule__RegexEntity__InputsAssignment_4 )
            // InternalBot.g:5364:4: rule__RegexEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__RegexEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5367:2: ( ( rule__RegexEntity__InputsAssignment_4 )* )
            // InternalBot.g:5368:3: ( rule__RegexEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5369:3: ( rule__RegexEntity__InputsAssignment_4 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=60 && LA50_0<=61)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:5369:4: rule__RegexEntity__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__RegexEntity__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 

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
    // $ANTLR end "rule__RegexEntity__Group__4__Impl"


    // $ANTLR start "rule__SLanguageInput__Group__0"
    // InternalBot.g:5379:1: rule__SLanguageInput__Group__0 : rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1 ;
    public final void rule__SLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5383:1: ( rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1 )
            // InternalBot.g:5384:2: rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__SLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group__1();

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
    // $ANTLR end "rule__SLanguageInput__Group__0"


    // $ANTLR start "rule__SLanguageInput__Group__0__Impl"
    // InternalBot.g:5391:1: rule__SLanguageInput__Group__0__Impl : ( ( rule__SLanguageInput__Group_0__0 )? ) ;
    public final void rule__SLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5395:1: ( ( ( rule__SLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5396:1: ( ( rule__SLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5396:1: ( ( rule__SLanguageInput__Group_0__0 )? )
            // InternalBot.g:5397:2: ( rule__SLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5398:2: ( rule__SLanguageInput__Group_0__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==60) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:5398:3: rule__SLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__SLanguageInput__Group__1"
    // InternalBot.g:5406:1: rule__SLanguageInput__Group__1 : rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2 ;
    public final void rule__SLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5410:1: ( rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2 )
            // InternalBot.g:5411:2: rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__SLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group__2();

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
    // $ANTLR end "rule__SLanguageInput__Group__1"


    // $ANTLR start "rule__SLanguageInput__Group__1__Impl"
    // InternalBot.g:5418:1: rule__SLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__SLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5422:1: ( ( '{' ) )
            // InternalBot.g:5423:1: ( '{' )
            {
            // InternalBot.g:5423:1: ( '{' )
            // InternalBot.g:5424:2: '{'
            {
             before(grammarAccess.getSLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getSLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__SLanguageInput__Group__2"
    // InternalBot.g:5433:1: rule__SLanguageInput__Group__2 : rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3 ;
    public final void rule__SLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5437:1: ( rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3 )
            // InternalBot.g:5438:2: rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__SLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group__3();

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
    // $ANTLR end "rule__SLanguageInput__Group__2"


    // $ANTLR start "rule__SLanguageInput__Group__2__Impl"
    // InternalBot.g:5445:1: rule__SLanguageInput__Group__2__Impl : ( ( rule__SLanguageInput__Group_2__0 ) ) ;
    public final void rule__SLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5449:1: ( ( ( rule__SLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5450:1: ( ( rule__SLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5450:1: ( ( rule__SLanguageInput__Group_2__0 ) )
            // InternalBot.g:5451:2: ( rule__SLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5452:2: ( rule__SLanguageInput__Group_2__0 )
            // InternalBot.g:5452:3: rule__SLanguageInput__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getSLanguageInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__SLanguageInput__Group__3"
    // InternalBot.g:5460:1: rule__SLanguageInput__Group__3 : rule__SLanguageInput__Group__3__Impl ;
    public final void rule__SLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5464:1: ( rule__SLanguageInput__Group__3__Impl )
            // InternalBot.g:5465:2: rule__SLanguageInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group__3__Impl();

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
    // $ANTLR end "rule__SLanguageInput__Group__3"


    // $ANTLR start "rule__SLanguageInput__Group__3__Impl"
    // InternalBot.g:5471:1: rule__SLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__SLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5475:1: ( ( '}' ) )
            // InternalBot.g:5476:1: ( '}' )
            {
            // InternalBot.g:5476:1: ( '}' )
            // InternalBot.g:5477:2: '}'
            {
             before(grammarAccess.getSLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getSLanguageInputAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__SLanguageInput__Group_0__0"
    // InternalBot.g:5487:1: rule__SLanguageInput__Group_0__0 : rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1 ;
    public final void rule__SLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5491:1: ( rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1 )
            // InternalBot.g:5492:2: rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_53);
            rule__SLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group_0__1();

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
    // $ANTLR end "rule__SLanguageInput__Group_0__0"


    // $ANTLR start "rule__SLanguageInput__Group_0__0__Impl"
    // InternalBot.g:5499:1: rule__SLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__SLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5503:1: ( ( 'inputs' ) )
            // InternalBot.g:5504:1: ( 'inputs' )
            {
            // InternalBot.g:5504:1: ( 'inputs' )
            // InternalBot.g:5505:2: 'inputs'
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getSLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__SLanguageInput__Group_0__1"
    // InternalBot.g:5514:1: rule__SLanguageInput__Group_0__1 : rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2 ;
    public final void rule__SLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5518:1: ( rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2 )
            // InternalBot.g:5519:2: rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2
            {
            pushFollow(FOLLOW_8);
            rule__SLanguageInput__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group_0__2();

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
    // $ANTLR end "rule__SLanguageInput__Group_0__1"


    // $ANTLR start "rule__SLanguageInput__Group_0__1__Impl"
    // InternalBot.g:5526:1: rule__SLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__SLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5530:1: ( ( 'in' ) )
            // InternalBot.g:5531:1: ( 'in' )
            {
            // InternalBot.g:5531:1: ( 'in' )
            // InternalBot.g:5532:2: 'in'
            {
             before(grammarAccess.getSLanguageInputAccess().getInKeyword_0_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getSLanguageInputAccess().getInKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__SLanguageInput__Group_0__2"
    // InternalBot.g:5541:1: rule__SLanguageInput__Group_0__2 : rule__SLanguageInput__Group_0__2__Impl ;
    public final void rule__SLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5545:1: ( rule__SLanguageInput__Group_0__2__Impl )
            // InternalBot.g:5546:2: rule__SLanguageInput__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group_0__2__Impl();

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
    // $ANTLR end "rule__SLanguageInput__Group_0__2"


    // $ANTLR start "rule__SLanguageInput__Group_0__2__Impl"
    // InternalBot.g:5552:1: rule__SLanguageInput__Group_0__2__Impl : ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__SLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5556:1: ( ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:5557:1: ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:5557:1: ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:5558:2: ( rule__SLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getSLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:5559:2: ( rule__SLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:5559:3: rule__SLanguageInput__LanguageAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__LanguageAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getSLanguageInputAccess().getLanguageAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group_0__2__Impl"


    // $ANTLR start "rule__SLanguageInput__Group_2__0"
    // InternalBot.g:5568:1: rule__SLanguageInput__Group_2__0 : rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1 ;
    public final void rule__SLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5572:1: ( rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1 )
            // InternalBot.g:5573:2: rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SLanguageInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group_2__1();

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
    // $ANTLR end "rule__SLanguageInput__Group_2__0"


    // $ANTLR start "rule__SLanguageInput__Group_2__0__Impl"
    // InternalBot.g:5580:1: rule__SLanguageInput__Group_2__0__Impl : ( ( rule__SLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__SLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5584:1: ( ( ( rule__SLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:5585:1: ( ( rule__SLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:5585:1: ( ( rule__SLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:5586:2: ( rule__SLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:5587:2: ( rule__SLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:5587:3: rule__SLanguageInput__InputsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__InputsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group_2__0__Impl"


    // $ANTLR start "rule__SLanguageInput__Group_2__1"
    // InternalBot.g:5595:1: rule__SLanguageInput__Group_2__1 : rule__SLanguageInput__Group_2__1__Impl ;
    public final void rule__SLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5599:1: ( rule__SLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5600:2: rule__SLanguageInput__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SLanguageInput__Group_2__1__Impl();

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
    // $ANTLR end "rule__SLanguageInput__Group_2__1"


    // $ANTLR start "rule__SLanguageInput__Group_2__1__Impl"
    // InternalBot.g:5606:1: rule__SLanguageInput__Group_2__1__Impl : ( ( rule__SLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__SLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5610:1: ( ( ( rule__SLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5611:1: ( ( rule__SLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5611:1: ( ( rule__SLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5612:2: ( rule__SLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5613:2: ( rule__SLanguageInput__InputsAssignment_2_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=RULE_STRING && LA52_0<=RULE_ID)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:5613:3: rule__SLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__SLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__Group_2__1__Impl"


    // $ANTLR start "rule__CLanguageInput__Group__0"
    // InternalBot.g:5622:1: rule__CLanguageInput__Group__0 : rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1 ;
    public final void rule__CLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5626:1: ( rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1 )
            // InternalBot.g:5627:2: rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__CLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group__1();

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
    // $ANTLR end "rule__CLanguageInput__Group__0"


    // $ANTLR start "rule__CLanguageInput__Group__0__Impl"
    // InternalBot.g:5634:1: rule__CLanguageInput__Group__0__Impl : ( ( rule__CLanguageInput__Group_0__0 )? ) ;
    public final void rule__CLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5638:1: ( ( ( rule__CLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5639:1: ( ( rule__CLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5639:1: ( ( rule__CLanguageInput__Group_0__0 )? )
            // InternalBot.g:5640:2: ( rule__CLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5641:2: ( rule__CLanguageInput__Group_0__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==60) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:5641:3: rule__CLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__CLanguageInput__Group__1"
    // InternalBot.g:5649:1: rule__CLanguageInput__Group__1 : rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2 ;
    public final void rule__CLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5653:1: ( rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2 )
            // InternalBot.g:5654:2: rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2
            {
            pushFollow(FOLLOW_54);
            rule__CLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group__2();

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
    // $ANTLR end "rule__CLanguageInput__Group__1"


    // $ANTLR start "rule__CLanguageInput__Group__1__Impl"
    // InternalBot.g:5661:1: rule__CLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__CLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5665:1: ( ( '{' ) )
            // InternalBot.g:5666:1: ( '{' )
            {
            // InternalBot.g:5666:1: ( '{' )
            // InternalBot.g:5667:2: '{'
            {
             before(grammarAccess.getCLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getCLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__CLanguageInput__Group__2"
    // InternalBot.g:5676:1: rule__CLanguageInput__Group__2 : rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3 ;
    public final void rule__CLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5680:1: ( rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3 )
            // InternalBot.g:5681:2: rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__CLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group__3();

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
    // $ANTLR end "rule__CLanguageInput__Group__2"


    // $ANTLR start "rule__CLanguageInput__Group__2__Impl"
    // InternalBot.g:5688:1: rule__CLanguageInput__Group__2__Impl : ( ( rule__CLanguageInput__Group_2__0 ) ) ;
    public final void rule__CLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5692:1: ( ( ( rule__CLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5693:1: ( ( rule__CLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5693:1: ( ( rule__CLanguageInput__Group_2__0 ) )
            // InternalBot.g:5694:2: ( rule__CLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5695:2: ( rule__CLanguageInput__Group_2__0 )
            // InternalBot.g:5695:3: rule__CLanguageInput__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getCLanguageInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__CLanguageInput__Group__3"
    // InternalBot.g:5703:1: rule__CLanguageInput__Group__3 : rule__CLanguageInput__Group__3__Impl ;
    public final void rule__CLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5707:1: ( rule__CLanguageInput__Group__3__Impl )
            // InternalBot.g:5708:2: rule__CLanguageInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group__3__Impl();

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
    // $ANTLR end "rule__CLanguageInput__Group__3"


    // $ANTLR start "rule__CLanguageInput__Group__3__Impl"
    // InternalBot.g:5714:1: rule__CLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__CLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5718:1: ( ( '}' ) )
            // InternalBot.g:5719:1: ( '}' )
            {
            // InternalBot.g:5719:1: ( '}' )
            // InternalBot.g:5720:2: '}'
            {
             before(grammarAccess.getCLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getCLanguageInputAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__CLanguageInput__Group_0__0"
    // InternalBot.g:5730:1: rule__CLanguageInput__Group_0__0 : rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1 ;
    public final void rule__CLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5734:1: ( rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1 )
            // InternalBot.g:5735:2: rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_53);
            rule__CLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group_0__1();

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
    // $ANTLR end "rule__CLanguageInput__Group_0__0"


    // $ANTLR start "rule__CLanguageInput__Group_0__0__Impl"
    // InternalBot.g:5742:1: rule__CLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__CLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5746:1: ( ( 'inputs' ) )
            // InternalBot.g:5747:1: ( 'inputs' )
            {
            // InternalBot.g:5747:1: ( 'inputs' )
            // InternalBot.g:5748:2: 'inputs'
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getCLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__CLanguageInput__Group_0__1"
    // InternalBot.g:5757:1: rule__CLanguageInput__Group_0__1 : rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2 ;
    public final void rule__CLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5761:1: ( rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2 )
            // InternalBot.g:5762:2: rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2
            {
            pushFollow(FOLLOW_8);
            rule__CLanguageInput__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group_0__2();

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
    // $ANTLR end "rule__CLanguageInput__Group_0__1"


    // $ANTLR start "rule__CLanguageInput__Group_0__1__Impl"
    // InternalBot.g:5769:1: rule__CLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__CLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5773:1: ( ( 'in' ) )
            // InternalBot.g:5774:1: ( 'in' )
            {
            // InternalBot.g:5774:1: ( 'in' )
            // InternalBot.g:5775:2: 'in'
            {
             before(grammarAccess.getCLanguageInputAccess().getInKeyword_0_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getCLanguageInputAccess().getInKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__CLanguageInput__Group_0__2"
    // InternalBot.g:5784:1: rule__CLanguageInput__Group_0__2 : rule__CLanguageInput__Group_0__2__Impl ;
    public final void rule__CLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5788:1: ( rule__CLanguageInput__Group_0__2__Impl )
            // InternalBot.g:5789:2: rule__CLanguageInput__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group_0__2__Impl();

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
    // $ANTLR end "rule__CLanguageInput__Group_0__2"


    // $ANTLR start "rule__CLanguageInput__Group_0__2__Impl"
    // InternalBot.g:5795:1: rule__CLanguageInput__Group_0__2__Impl : ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__CLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5799:1: ( ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:5800:1: ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:5800:1: ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:5801:2: ( rule__CLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getCLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:5802:2: ( rule__CLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:5802:3: rule__CLanguageInput__LanguageAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__LanguageAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getCLanguageInputAccess().getLanguageAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group_0__2__Impl"


    // $ANTLR start "rule__CLanguageInput__Group_2__0"
    // InternalBot.g:5811:1: rule__CLanguageInput__Group_2__0 : rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1 ;
    public final void rule__CLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5815:1: ( rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1 )
            // InternalBot.g:5816:2: rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1
            {
            pushFollow(FOLLOW_54);
            rule__CLanguageInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group_2__1();

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
    // $ANTLR end "rule__CLanguageInput__Group_2__0"


    // $ANTLR start "rule__CLanguageInput__Group_2__0__Impl"
    // InternalBot.g:5823:1: rule__CLanguageInput__Group_2__0__Impl : ( ( rule__CLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__CLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5827:1: ( ( ( rule__CLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:5828:1: ( ( rule__CLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:5828:1: ( ( rule__CLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:5829:2: ( rule__CLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:5830:2: ( rule__CLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:5830:3: rule__CLanguageInput__InputsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__InputsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group_2__0__Impl"


    // $ANTLR start "rule__CLanguageInput__Group_2__1"
    // InternalBot.g:5838:1: rule__CLanguageInput__Group_2__1 : rule__CLanguageInput__Group_2__1__Impl ;
    public final void rule__CLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5842:1: ( rule__CLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5843:2: rule__CLanguageInput__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CLanguageInput__Group_2__1__Impl();

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
    // $ANTLR end "rule__CLanguageInput__Group_2__1"


    // $ANTLR start "rule__CLanguageInput__Group_2__1__Impl"
    // InternalBot.g:5849:1: rule__CLanguageInput__Group_2__1__Impl : ( ( rule__CLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__CLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5853:1: ( ( ( rule__CLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5854:1: ( ( rule__CLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5854:1: ( ( rule__CLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5855:2: ( rule__CLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5856:2: ( rule__CLanguageInput__InputsAssignment_2_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==80) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:5856:3: rule__CLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__CLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

             after(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__Group_2__1__Impl"


    // $ANTLR start "rule__RLanguageInput__Group__0"
    // InternalBot.g:5865:1: rule__RLanguageInput__Group__0 : rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1 ;
    public final void rule__RLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5869:1: ( rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1 )
            // InternalBot.g:5870:2: rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__RLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group__1();

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
    // $ANTLR end "rule__RLanguageInput__Group__0"


    // $ANTLR start "rule__RLanguageInput__Group__0__Impl"
    // InternalBot.g:5877:1: rule__RLanguageInput__Group__0__Impl : ( ( rule__RLanguageInput__Group_0__0 )? ) ;
    public final void rule__RLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5881:1: ( ( ( rule__RLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5882:1: ( ( rule__RLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5882:1: ( ( rule__RLanguageInput__Group_0__0 )? )
            // InternalBot.g:5883:2: ( rule__RLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5884:2: ( rule__RLanguageInput__Group_0__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==60) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:5884:3: rule__RLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__RLanguageInput__Group__1"
    // InternalBot.g:5892:1: rule__RLanguageInput__Group__1 : rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2 ;
    public final void rule__RLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5896:1: ( rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2 )
            // InternalBot.g:5897:2: rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__RLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group__2();

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
    // $ANTLR end "rule__RLanguageInput__Group__1"


    // $ANTLR start "rule__RLanguageInput__Group__1__Impl"
    // InternalBot.g:5904:1: rule__RLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__RLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5908:1: ( ( '{' ) )
            // InternalBot.g:5909:1: ( '{' )
            {
            // InternalBot.g:5909:1: ( '{' )
            // InternalBot.g:5910:2: '{'
            {
             before(grammarAccess.getRLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getRLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__RLanguageInput__Group__2"
    // InternalBot.g:5919:1: rule__RLanguageInput__Group__2 : rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3 ;
    public final void rule__RLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5923:1: ( rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3 )
            // InternalBot.g:5924:2: rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__RLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group__3();

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
    // $ANTLR end "rule__RLanguageInput__Group__2"


    // $ANTLR start "rule__RLanguageInput__Group__2__Impl"
    // InternalBot.g:5931:1: rule__RLanguageInput__Group__2__Impl : ( ( rule__RLanguageInput__Group_2__0 ) ) ;
    public final void rule__RLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5935:1: ( ( ( rule__RLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5936:1: ( ( rule__RLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5936:1: ( ( rule__RLanguageInput__Group_2__0 ) )
            // InternalBot.g:5937:2: ( rule__RLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5938:2: ( rule__RLanguageInput__Group_2__0 )
            // InternalBot.g:5938:3: rule__RLanguageInput__Group_2__0
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getRLanguageInputAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__RLanguageInput__Group__3"
    // InternalBot.g:5946:1: rule__RLanguageInput__Group__3 : rule__RLanguageInput__Group__3__Impl ;
    public final void rule__RLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5950:1: ( rule__RLanguageInput__Group__3__Impl )
            // InternalBot.g:5951:2: rule__RLanguageInput__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group__3__Impl();

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
    // $ANTLR end "rule__RLanguageInput__Group__3"


    // $ANTLR start "rule__RLanguageInput__Group__3__Impl"
    // InternalBot.g:5957:1: rule__RLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__RLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5961:1: ( ( '}' ) )
            // InternalBot.g:5962:1: ( '}' )
            {
            // InternalBot.g:5962:1: ( '}' )
            // InternalBot.g:5963:2: '}'
            {
             before(grammarAccess.getRLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getRLanguageInputAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__RLanguageInput__Group_0__0"
    // InternalBot.g:5973:1: rule__RLanguageInput__Group_0__0 : rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1 ;
    public final void rule__RLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5977:1: ( rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1 )
            // InternalBot.g:5978:2: rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_53);
            rule__RLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group_0__1();

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
    // $ANTLR end "rule__RLanguageInput__Group_0__0"


    // $ANTLR start "rule__RLanguageInput__Group_0__0__Impl"
    // InternalBot.g:5985:1: rule__RLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__RLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5989:1: ( ( 'inputs' ) )
            // InternalBot.g:5990:1: ( 'inputs' )
            {
            // InternalBot.g:5990:1: ( 'inputs' )
            // InternalBot.g:5991:2: 'inputs'
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getRLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__RLanguageInput__Group_0__1"
    // InternalBot.g:6000:1: rule__RLanguageInput__Group_0__1 : rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2 ;
    public final void rule__RLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6004:1: ( rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2 )
            // InternalBot.g:6005:2: rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2
            {
            pushFollow(FOLLOW_8);
            rule__RLanguageInput__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group_0__2();

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
    // $ANTLR end "rule__RLanguageInput__Group_0__1"


    // $ANTLR start "rule__RLanguageInput__Group_0__1__Impl"
    // InternalBot.g:6012:1: rule__RLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__RLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6016:1: ( ( 'in' ) )
            // InternalBot.g:6017:1: ( 'in' )
            {
            // InternalBot.g:6017:1: ( 'in' )
            // InternalBot.g:6018:2: 'in'
            {
             before(grammarAccess.getRLanguageInputAccess().getInKeyword_0_1()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getRLanguageInputAccess().getInKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__RLanguageInput__Group_0__2"
    // InternalBot.g:6027:1: rule__RLanguageInput__Group_0__2 : rule__RLanguageInput__Group_0__2__Impl ;
    public final void rule__RLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6031:1: ( rule__RLanguageInput__Group_0__2__Impl )
            // InternalBot.g:6032:2: rule__RLanguageInput__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group_0__2__Impl();

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
    // $ANTLR end "rule__RLanguageInput__Group_0__2"


    // $ANTLR start "rule__RLanguageInput__Group_0__2__Impl"
    // InternalBot.g:6038:1: rule__RLanguageInput__Group_0__2__Impl : ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__RLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6042:1: ( ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:6043:1: ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:6043:1: ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:6044:2: ( rule__RLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getRLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:6045:2: ( rule__RLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:6045:3: rule__RLanguageInput__LanguageAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__LanguageAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getRLanguageInputAccess().getLanguageAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group_0__2__Impl"


    // $ANTLR start "rule__RLanguageInput__Group_2__0"
    // InternalBot.g:6054:1: rule__RLanguageInput__Group_2__0 : rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1 ;
    public final void rule__RLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6058:1: ( rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1 )
            // InternalBot.g:6059:2: rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1
            {
            pushFollow(FOLLOW_26);
            rule__RLanguageInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group_2__1();

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
    // $ANTLR end "rule__RLanguageInput__Group_2__0"


    // $ANTLR start "rule__RLanguageInput__Group_2__0__Impl"
    // InternalBot.g:6066:1: rule__RLanguageInput__Group_2__0__Impl : ( ( rule__RLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__RLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6070:1: ( ( ( rule__RLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:6071:1: ( ( rule__RLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:6071:1: ( ( rule__RLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:6072:2: ( rule__RLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:6073:2: ( rule__RLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:6073:3: rule__RLanguageInput__InputsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__InputsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group_2__0__Impl"


    // $ANTLR start "rule__RLanguageInput__Group_2__1"
    // InternalBot.g:6081:1: rule__RLanguageInput__Group_2__1 : rule__RLanguageInput__Group_2__1__Impl ;
    public final void rule__RLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6085:1: ( rule__RLanguageInput__Group_2__1__Impl )
            // InternalBot.g:6086:2: rule__RLanguageInput__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RLanguageInput__Group_2__1__Impl();

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
    // $ANTLR end "rule__RLanguageInput__Group_2__1"


    // $ANTLR start "rule__RLanguageInput__Group_2__1__Impl"
    // InternalBot.g:6092:1: rule__RLanguageInput__Group_2__1__Impl : ( ( rule__RLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__RLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6096:1: ( ( ( rule__RLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:6097:1: ( ( rule__RLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:6097:1: ( ( rule__RLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:6098:2: ( rule__RLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:6099:2: ( rule__RLanguageInput__InputsAssignment_2_1 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==79) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBot.g:6099:3: rule__RLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__RLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

             after(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__Group_2__1__Impl"


    // $ANTLR start "rule__RegexInput__Group__0"
    // InternalBot.g:6108:1: rule__RegexInput__Group__0 : rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 ;
    public final void rule__RegexInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6112:1: ( rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 )
            // InternalBot.g:6113:2: rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1
            {
            pushFollow(FOLLOW_26);
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
    // InternalBot.g:6120:1: rule__RegexInput__Group__0__Impl : ( () ) ;
    public final void rule__RegexInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6124:1: ( ( () ) )
            // InternalBot.g:6125:1: ( () )
            {
            // InternalBot.g:6125:1: ( () )
            // InternalBot.g:6126:2: ()
            {
             before(grammarAccess.getRegexInputAccess().getRegexInputAction_0()); 
            // InternalBot.g:6127:2: ()
            // InternalBot.g:6127:3: 
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
    // InternalBot.g:6135:1: rule__RegexInput__Group__1 : rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 ;
    public final void rule__RegexInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6139:1: ( rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 )
            // InternalBot.g:6140:2: rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:6147:1: rule__RegexInput__Group__1__Impl : ( 'pattern' ) ;
    public final void rule__RegexInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6151:1: ( ( 'pattern' ) )
            // InternalBot.g:6152:1: ( 'pattern' )
            {
            // InternalBot.g:6152:1: ( 'pattern' )
            // InternalBot.g:6153:2: 'pattern'
            {
             before(grammarAccess.getRegexInputAccess().getPatternKeyword_1()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getRegexInputAccess().getPatternKeyword_1()); 

            }


            }

        }
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
    // InternalBot.g:6162:1: rule__RegexInput__Group__2 : rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 ;
    public final void rule__RegexInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6166:1: ( rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 )
            // InternalBot.g:6167:2: rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3
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
    // InternalBot.g:6174:1: rule__RegexInput__Group__2__Impl : ( ':' ) ;
    public final void rule__RegexInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6178:1: ( ( ':' ) )
            // InternalBot.g:6179:1: ( ':' )
            {
            // InternalBot.g:6179:1: ( ':' )
            // InternalBot.g:6180:2: ':'
            {
             before(grammarAccess.getRegexInputAccess().getColonKeyword_2()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:6189:1: rule__RegexInput__Group__3 : rule__RegexInput__Group__3__Impl ;
    public final void rule__RegexInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6193:1: ( rule__RegexInput__Group__3__Impl )
            // InternalBot.g:6194:2: rule__RegexInput__Group__3__Impl
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
    // InternalBot.g:6200:1: rule__RegexInput__Group__3__Impl : ( ( rule__RegexInput__ExpresionAssignment_3 ) ) ;
    public final void rule__RegexInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6204:1: ( ( ( rule__RegexInput__ExpresionAssignment_3 ) ) )
            // InternalBot.g:6205:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            {
            // InternalBot.g:6205:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            // InternalBot.g:6206:2: ( rule__RegexInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getRegexInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6207:2: ( rule__RegexInput__ExpresionAssignment_3 )
            // InternalBot.g:6207:3: rule__RegexInput__ExpresionAssignment_3
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
    // InternalBot.g:6216:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6220:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:6221:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
            {
            pushFollow(FOLLOW_54);
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
    // InternalBot.g:6228:1: rule__CompositeInput__Group__0__Impl : ( () ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6232:1: ( ( () ) )
            // InternalBot.g:6233:1: ( () )
            {
            // InternalBot.g:6233:1: ( () )
            // InternalBot.g:6234:2: ()
            {
             before(grammarAccess.getCompositeInputAccess().getCompositeInputAction_0()); 
            // InternalBot.g:6235:2: ()
            // InternalBot.g:6235:3: 
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
    // InternalBot.g:6243:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6247:1: ( rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 )
            // InternalBot.g:6248:2: rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:6255:1: rule__CompositeInput__Group__1__Impl : ( 'composite' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6259:1: ( ( 'composite' ) )
            // InternalBot.g:6260:1: ( 'composite' )
            {
            // InternalBot.g:6260:1: ( 'composite' )
            // InternalBot.g:6261:2: 'composite'
            {
             before(grammarAccess.getCompositeInputAccess().getCompositeKeyword_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getCompositeInputAccess().getCompositeKeyword_1()); 

            }


            }

        }
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
    // InternalBot.g:6270:1: rule__CompositeInput__Group__2 : rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 ;
    public final void rule__CompositeInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6274:1: ( rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 )
            // InternalBot.g:6275:2: rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3
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
    // InternalBot.g:6282:1: rule__CompositeInput__Group__2__Impl : ( ':' ) ;
    public final void rule__CompositeInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6286:1: ( ( ':' ) )
            // InternalBot.g:6287:1: ( ':' )
            {
            // InternalBot.g:6287:1: ( ':' )
            // InternalBot.g:6288:2: ':'
            {
             before(grammarAccess.getCompositeInputAccess().getColonKeyword_2()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:6297:1: rule__CompositeInput__Group__3 : rule__CompositeInput__Group__3__Impl ;
    public final void rule__CompositeInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6301:1: ( rule__CompositeInput__Group__3__Impl )
            // InternalBot.g:6302:2: rule__CompositeInput__Group__3__Impl
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
    // InternalBot.g:6308:1: rule__CompositeInput__Group__3__Impl : ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) ;
    public final void rule__CompositeInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6312:1: ( ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) )
            // InternalBot.g:6313:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            {
            // InternalBot.g:6313:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            // InternalBot.g:6314:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            {
            // InternalBot.g:6314:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) )
            // InternalBot.g:6315:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6316:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            // InternalBot.g:6316:4: rule__CompositeInput__ExpresionAssignment_3
            {
            pushFollow(FOLLOW_58);
            rule__CompositeInput__ExpresionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 

            }

            // InternalBot.g:6319:2: ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            // InternalBot.g:6320:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6321:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_STRING && LA57_0<=RULE_ID)||LA57_0==71) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBot.g:6321:4: rule__CompositeInput__ExpresionAssignment_3
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__CompositeInput__ExpresionAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
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
    // InternalBot.g:6331:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6335:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:6336:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:6343:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6347:1: ( ( () ) )
            // InternalBot.g:6348:1: ( () )
            {
            // InternalBot.g:6348:1: ( () )
            // InternalBot.g:6349:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:6350:2: ()
            // InternalBot.g:6350:3: 
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
    // InternalBot.g:6358:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6362:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:6363:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
            {
            pushFollow(FOLLOW_59);
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
    // InternalBot.g:6370:1: rule__SimpleInput__Group__1__Impl : ( ( rule__SimpleInput__NameAssignment_1 ) ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6374:1: ( ( ( rule__SimpleInput__NameAssignment_1 ) ) )
            // InternalBot.g:6375:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            {
            // InternalBot.g:6375:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            // InternalBot.g:6376:2: ( rule__SimpleInput__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 
            // InternalBot.g:6377:2: ( rule__SimpleInput__NameAssignment_1 )
            // InternalBot.g:6377:3: rule__SimpleInput__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 

            }


            }

        }
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
    // InternalBot.g:6385:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6389:1: ( rule__SimpleInput__Group__2__Impl )
            // InternalBot.g:6390:2: rule__SimpleInput__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group__2__Impl();

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
    // InternalBot.g:6396:1: rule__SimpleInput__Group__2__Impl : ( ( rule__SimpleInput__Group_2__0 )? ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6400:1: ( ( ( rule__SimpleInput__Group_2__0 )? ) )
            // InternalBot.g:6401:1: ( ( rule__SimpleInput__Group_2__0 )? )
            {
            // InternalBot.g:6401:1: ( ( rule__SimpleInput__Group_2__0 )? )
            // InternalBot.g:6402:2: ( rule__SimpleInput__Group_2__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2()); 
            // InternalBot.g:6403:2: ( rule__SimpleInput__Group_2__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==81) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:6403:3: rule__SimpleInput__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SimpleInput__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimpleInputAccess().getGroup_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__SimpleInput__Group_2__0"
    // InternalBot.g:6412:1: rule__SimpleInput__Group_2__0 : rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 ;
    public final void rule__SimpleInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6416:1: ( rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 )
            // InternalBot.g:6417:2: rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2__1();

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
    // $ANTLR end "rule__SimpleInput__Group_2__0"


    // $ANTLR start "rule__SimpleInput__Group_2__0__Impl"
    // InternalBot.g:6424:1: rule__SimpleInput__Group_2__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6428:1: ( ( 'synonyms' ) )
            // InternalBot.g:6429:1: ( 'synonyms' )
            {
            // InternalBot.g:6429:1: ( 'synonyms' )
            // InternalBot.g:6430:2: 'synonyms'
            {
             before(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2__1"
    // InternalBot.g:6439:1: rule__SimpleInput__Group_2__1 : rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 ;
    public final void rule__SimpleInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6443:1: ( rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 )
            // InternalBot.g:6444:2: rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2
            {
            pushFollow(FOLLOW_43);
            rule__SimpleInput__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2__2();

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
    // $ANTLR end "rule__SimpleInput__Group_2__1"


    // $ANTLR start "rule__SimpleInput__Group_2__1__Impl"
    // InternalBot.g:6451:1: rule__SimpleInput__Group_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6455:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) )
            // InternalBot.g:6456:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            {
            // InternalBot.g:6456:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            // InternalBot.g:6457:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 
            // InternalBot.g:6458:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            // InternalBot.g:6458:3: rule__SimpleInput__ValuesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__ValuesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__1__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2__2"
    // InternalBot.g:6466:1: rule__SimpleInput__Group_2__2 : rule__SimpleInput__Group_2__2__Impl ;
    public final void rule__SimpleInput__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6470:1: ( rule__SimpleInput__Group_2__2__Impl )
            // InternalBot.g:6471:2: rule__SimpleInput__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2__2__Impl();

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
    // $ANTLR end "rule__SimpleInput__Group_2__2"


    // $ANTLR start "rule__SimpleInput__Group_2__2__Impl"
    // InternalBot.g:6477:1: rule__SimpleInput__Group_2__2__Impl : ( ( rule__SimpleInput__Group_2_2__0 )* ) ;
    public final void rule__SimpleInput__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6481:1: ( ( ( rule__SimpleInput__Group_2_2__0 )* ) )
            // InternalBot.g:6482:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            {
            // InternalBot.g:6482:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            // InternalBot.g:6483:2: ( rule__SimpleInput__Group_2_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 
            // InternalBot.g:6484:2: ( rule__SimpleInput__Group_2_2__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==54) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBot.g:6484:3: rule__SimpleInput__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__SimpleInput__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2__2__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2_2__0"
    // InternalBot.g:6493:1: rule__SimpleInput__Group_2_2__0 : rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 ;
    public final void rule__SimpleInput__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6497:1: ( rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 )
            // InternalBot.g:6498:2: rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1
            {
            pushFollow(FOLLOW_5);
            rule__SimpleInput__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2_2__1();

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
    // $ANTLR end "rule__SimpleInput__Group_2_2__0"


    // $ANTLR start "rule__SimpleInput__Group_2_2__0__Impl"
    // InternalBot.g:6505:1: rule__SimpleInput__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6509:1: ( ( ',' ) )
            // InternalBot.g:6510:1: ( ',' )
            {
            // InternalBot.g:6510:1: ( ',' )
            // InternalBot.g:6511:2: ','
            {
             before(grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2_2__0__Impl"


    // $ANTLR start "rule__SimpleInput__Group_2_2__1"
    // InternalBot.g:6520:1: rule__SimpleInput__Group_2_2__1 : rule__SimpleInput__Group_2_2__1__Impl ;
    public final void rule__SimpleInput__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6524:1: ( rule__SimpleInput__Group_2_2__1__Impl )
            // InternalBot.g:6525:2: rule__SimpleInput__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__Group_2_2__1__Impl();

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
    // $ANTLR end "rule__SimpleInput__Group_2_2__1"


    // $ANTLR start "rule__SimpleInput__Group_2_2__1__Impl"
    // InternalBot.g:6531:1: rule__SimpleInput__Group_2_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6535:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) )
            // InternalBot.g:6536:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            {
            // InternalBot.g:6536:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            // InternalBot.g:6537:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 
            // InternalBot.g:6538:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            // InternalBot.g:6538:3: rule__SimpleInput__ValuesAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__SimpleInput__ValuesAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__Group_2_2__1__Impl"


    // $ANTLR start "rule__Text__Group__0"
    // InternalBot.g:6547:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6551:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:6552:2: rule__Text__Group__0__Impl rule__Text__Group__1
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
    // InternalBot.g:6559:1: rule__Text__Group__0__Impl : ( 'text' ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6563:1: ( ( 'text' ) )
            // InternalBot.g:6564:1: ( 'text' )
            {
            // InternalBot.g:6564:1: ( 'text' )
            // InternalBot.g:6565:2: 'text'
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
    // InternalBot.g:6574:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6578:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:6579:2: rule__Text__Group__1__Impl rule__Text__Group__2
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
    // InternalBot.g:6586:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6590:1: ( ( 'response' ) )
            // InternalBot.g:6591:1: ( 'response' )
            {
            // InternalBot.g:6591:1: ( 'response' )
            // InternalBot.g:6592:2: 'response'
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
    // InternalBot.g:6601:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6605:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:6606:2: rule__Text__Group__2__Impl rule__Text__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:6613:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6617:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:6618:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:6618:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:6619:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:6620:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:6620:3: rule__Text__NameAssignment_2
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
    // InternalBot.g:6628:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6632:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:6633:2: rule__Text__Group__3__Impl rule__Text__Group__4
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
    // InternalBot.g:6640:1: rule__Text__Group__3__Impl : ( ':' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6644:1: ( ( ':' ) )
            // InternalBot.g:6645:1: ( ':' )
            {
            // InternalBot.g:6645:1: ( ':' )
            // InternalBot.g:6646:2: ':'
            {
             before(grammarAccess.getTextAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:6655:1: rule__Text__Group__4 : rule__Text__Group__4__Impl ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6659:1: ( rule__Text__Group__4__Impl )
            // InternalBot.g:6660:2: rule__Text__Group__4__Impl
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
    // InternalBot.g:6666:1: rule__Text__Group__4__Impl : ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6670:1: ( ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) )
            // InternalBot.g:6671:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:6671:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            // InternalBot.g:6672:2: ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* )
            {
            // InternalBot.g:6672:2: ( ( rule__Text__InputsAssignment_4 ) )
            // InternalBot.g:6673:3: ( rule__Text__InputsAssignment_4 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:6674:3: ( rule__Text__InputsAssignment_4 )
            // InternalBot.g:6674:4: rule__Text__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__Text__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:6677:2: ( ( rule__Text__InputsAssignment_4 )* )
            // InternalBot.g:6678:3: ( rule__Text__InputsAssignment_4 )*
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:6679:3: ( rule__Text__InputsAssignment_4 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=60 && LA60_0<=61)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBot.g:6679:4: rule__Text__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__Text__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop60;
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
    // InternalBot.g:6689:1: rule__TextLanguageInput__Group__0 : rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 ;
    public final void rule__TextLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6693:1: ( rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 )
            // InternalBot.g:6694:2: rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1
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
    // InternalBot.g:6701:1: rule__TextLanguageInput__Group__0__Impl : ( ( rule__TextLanguageInput__Group_0__0 )? ) ;
    public final void rule__TextLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6705:1: ( ( ( rule__TextLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:6706:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:6706:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            // InternalBot.g:6707:2: ( rule__TextLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:6708:2: ( rule__TextLanguageInput__Group_0__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==60) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalBot.g:6708:3: rule__TextLanguageInput__Group_0__0
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
    // InternalBot.g:6716:1: rule__TextLanguageInput__Group__1 : rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 ;
    public final void rule__TextLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6720:1: ( rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 )
            // InternalBot.g:6721:2: rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2
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
    // InternalBot.g:6728:1: rule__TextLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__TextLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6732:1: ( ( '{' ) )
            // InternalBot.g:6733:1: ( '{' )
            {
            // InternalBot.g:6733:1: ( '{' )
            // InternalBot.g:6734:2: '{'
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
    // InternalBot.g:6743:1: rule__TextLanguageInput__Group__2 : rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 ;
    public final void rule__TextLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6747:1: ( rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 )
            // InternalBot.g:6748:2: rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalBot.g:6755:1: rule__TextLanguageInput__Group__2__Impl : ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) ;
    public final void rule__TextLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6759:1: ( ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) )
            // InternalBot.g:6760:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            {
            // InternalBot.g:6760:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            // InternalBot.g:6761:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 
            // InternalBot.g:6762:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            // InternalBot.g:6762:3: rule__TextLanguageInput__InputsAssignment_2
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
    // InternalBot.g:6770:1: rule__TextLanguageInput__Group__3 : rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 ;
    public final void rule__TextLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6774:1: ( rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 )
            // InternalBot.g:6775:2: rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalBot.g:6782:1: rule__TextLanguageInput__Group__3__Impl : ( ( rule__TextLanguageInput__Group_3__0 )* ) ;
    public final void rule__TextLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6786:1: ( ( ( rule__TextLanguageInput__Group_3__0 )* ) )
            // InternalBot.g:6787:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            {
            // InternalBot.g:6787:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            // InternalBot.g:6788:2: ( rule__TextLanguageInput__Group_3__0 )*
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 
            // InternalBot.g:6789:2: ( rule__TextLanguageInput__Group_3__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==54) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBot.g:6789:3: rule__TextLanguageInput__Group_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__TextLanguageInput__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // InternalBot.g:6797:1: rule__TextLanguageInput__Group__4 : rule__TextLanguageInput__Group__4__Impl ;
    public final void rule__TextLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6801:1: ( rule__TextLanguageInput__Group__4__Impl )
            // InternalBot.g:6802:2: rule__TextLanguageInput__Group__4__Impl
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
    // InternalBot.g:6808:1: rule__TextLanguageInput__Group__4__Impl : ( '}' ) ;
    public final void rule__TextLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6812:1: ( ( '}' ) )
            // InternalBot.g:6813:1: ( '}' )
            {
            // InternalBot.g:6813:1: ( '}' )
            // InternalBot.g:6814:2: '}'
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
    // InternalBot.g:6824:1: rule__TextLanguageInput__Group_0__0 : rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 ;
    public final void rule__TextLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6828:1: ( rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 )
            // InternalBot.g:6829:2: rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_53);
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
    // InternalBot.g:6836:1: rule__TextLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6840:1: ( ( 'inputs' ) )
            // InternalBot.g:6841:1: ( 'inputs' )
            {
            // InternalBot.g:6841:1: ( 'inputs' )
            // InternalBot.g:6842:2: 'inputs'
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
    // InternalBot.g:6851:1: rule__TextLanguageInput__Group_0__1 : rule__TextLanguageInput__Group_0__1__Impl ;
    public final void rule__TextLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6855:1: ( rule__TextLanguageInput__Group_0__1__Impl )
            // InternalBot.g:6856:2: rule__TextLanguageInput__Group_0__1__Impl
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
    // InternalBot.g:6862:1: rule__TextLanguageInput__Group_0__1__Impl : ( ( rule__TextLanguageInput__Group_0_1__0 )? ) ;
    public final void rule__TextLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6866:1: ( ( ( rule__TextLanguageInput__Group_0_1__0 )? ) )
            // InternalBot.g:6867:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            {
            // InternalBot.g:6867:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            // InternalBot.g:6868:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 
            // InternalBot.g:6869:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==63) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalBot.g:6869:3: rule__TextLanguageInput__Group_0_1__0
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
    // InternalBot.g:6878:1: rule__TextLanguageInput__Group_0_1__0 : rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 ;
    public final void rule__TextLanguageInput__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6882:1: ( rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 )
            // InternalBot.g:6883:2: rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalBot.g:6890:1: rule__TextLanguageInput__Group_0_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInput__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6894:1: ( ( 'in' ) )
            // InternalBot.g:6895:1: ( 'in' )
            {
            // InternalBot.g:6895:1: ( 'in' )
            // InternalBot.g:6896:2: 'in'
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
    // InternalBot.g:6905:1: rule__TextLanguageInput__Group_0_1__1 : rule__TextLanguageInput__Group_0_1__1__Impl ;
    public final void rule__TextLanguageInput__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6909:1: ( rule__TextLanguageInput__Group_0_1__1__Impl )
            // InternalBot.g:6910:2: rule__TextLanguageInput__Group_0_1__1__Impl
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
    // InternalBot.g:6916:1: rule__TextLanguageInput__Group_0_1__1__Impl : ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) ;
    public final void rule__TextLanguageInput__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6920:1: ( ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) )
            // InternalBot.g:6921:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            {
            // InternalBot.g:6921:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            // InternalBot.g:6922:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 
            // InternalBot.g:6923:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            // InternalBot.g:6923:3: rule__TextLanguageInput__LanguageAssignment_0_1_1
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
    // InternalBot.g:6932:1: rule__TextLanguageInput__Group_3__0 : rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 ;
    public final void rule__TextLanguageInput__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6936:1: ( rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 )
            // InternalBot.g:6937:2: rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1
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
    // InternalBot.g:6944:1: rule__TextLanguageInput__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInput__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6948:1: ( ( ',' ) )
            // InternalBot.g:6949:1: ( ',' )
            {
            // InternalBot.g:6949:1: ( ',' )
            // InternalBot.g:6950:2: ','
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
    // InternalBot.g:6959:1: rule__TextLanguageInput__Group_3__1 : rule__TextLanguageInput__Group_3__1__Impl ;
    public final void rule__TextLanguageInput__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6963:1: ( rule__TextLanguageInput__Group_3__1__Impl )
            // InternalBot.g:6964:2: rule__TextLanguageInput__Group_3__1__Impl
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
    // InternalBot.g:6970:1: rule__TextLanguageInput__Group_3__1__Impl : ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) ;
    public final void rule__TextLanguageInput__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6974:1: ( ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) )
            // InternalBot.g:6975:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            {
            // InternalBot.g:6975:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            // InternalBot.g:6976:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 
            // InternalBot.g:6977:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            // InternalBot.g:6977:3: rule__TextLanguageInput__InputsAssignment_3_1
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
    // InternalBot.g:6986:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6990:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:6991:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
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
    // InternalBot.g:6998:1: rule__HTTPResponse__Group__0__Impl : ( 'Response' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7002:1: ( ( 'Response' ) )
            // InternalBot.g:7003:1: ( 'Response' )
            {
            // InternalBot.g:7003:1: ( 'Response' )
            // InternalBot.g:7004:2: 'Response'
            {
             before(grammarAccess.getHTTPResponseAccess().getResponseKeyword_0()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getResponseKeyword_0()); 

            }


            }

        }
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
    // InternalBot.g:7013:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7017:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:7018:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:7025:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7029:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:7030:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:7030:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:7031:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:7032:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:7032:3: rule__HTTPResponse__NameAssignment_1
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
    // InternalBot.g:7040:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7044:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:7045:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
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
    // InternalBot.g:7052:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7056:1: ( ( ':' ) )
            // InternalBot.g:7057:1: ( ':' )
            {
            // InternalBot.g:7057:1: ( ':' )
            // InternalBot.g:7058:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:7067:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7071:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:7072:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:7079:1: rule__HTTPResponse__Group__3__Impl : ( 'Request' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7083:1: ( ( 'Request' ) )
            // InternalBot.g:7084:1: ( 'Request' )
            {
            // InternalBot.g:7084:1: ( 'Request' )
            // InternalBot.g:7085:2: 'Request'
            {
             before(grammarAccess.getHTTPResponseAccess().getRequestKeyword_3()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getRequestKeyword_3()); 

            }


            }

        }
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
    // InternalBot.g:7094:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7098:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:7099:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:7106:1: rule__HTTPResponse__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7110:1: ( ( ':' ) )
            // InternalBot.g:7111:1: ( ':' )
            {
            // InternalBot.g:7111:1: ( ':' )
            // InternalBot.g:7112:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_4()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getColonKeyword_4()); 

            }


            }

        }
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
    // InternalBot.g:7121:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7125:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:7126:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:7133:1: rule__HTTPResponse__Group__5__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7137:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) ) )
            // InternalBot.g:7138:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) )
            {
            // InternalBot.g:7138:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) )
            // InternalBot.g:7139:2: ( rule__HTTPResponse__HTTPRequestAssignment_5 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_5()); 
            // InternalBot.g:7140:2: ( rule__HTTPResponse__HTTPRequestAssignment_5 )
            // InternalBot.g:7140:3: rule__HTTPResponse__HTTPRequestAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__HTTPRequestAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_5()); 

            }


            }

        }
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
    // InternalBot.g:7148:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7152:1: ( rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 )
            // InternalBot.g:7153:2: rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7
            {
            pushFollow(FOLLOW_63);
            rule__HTTPResponse__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__7();

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
    // InternalBot.g:7160:1: rule__HTTPResponse__Group__6__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7164:1: ( ( ';' ) )
            // InternalBot.g:7165:1: ( ';' )
            {
            // InternalBot.g:7165:1: ( ';' )
            // InternalBot.g:7166:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_6()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_6()); 

            }


            }

        }
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


    // $ANTLR start "rule__HTTPResponse__Group__7"
    // InternalBot.g:7175:1: rule__HTTPResponse__Group__7 : rule__HTTPResponse__Group__7__Impl ;
    public final void rule__HTTPResponse__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7179:1: ( rule__HTTPResponse__Group__7__Impl )
            // InternalBot.g:7180:2: rule__HTTPResponse__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPResponse__Group__7__Impl();

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
    // $ANTLR end "rule__HTTPResponse__Group__7"


    // $ANTLR start "rule__HTTPResponse__Group__7__Impl"
    // InternalBot.g:7186:1: rule__HTTPResponse__Group__7__Impl : ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) ) ;
    public final void rule__HTTPResponse__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7190:1: ( ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) ) )
            // InternalBot.g:7191:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) )
            {
            // InternalBot.g:7191:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) )
            // InternalBot.g:7192:2: ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* )
            {
            // InternalBot.g:7192:2: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            // InternalBot.g:7193:3: ( rule__HTTPResponse__InputsAssignment_7 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:7194:3: ( rule__HTTPResponse__InputsAssignment_7 )
            // InternalBot.g:7194:4: rule__HTTPResponse__InputsAssignment_7
            {
            pushFollow(FOLLOW_23);
            rule__HTTPResponse__InputsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 

            }

            // InternalBot.g:7197:2: ( ( rule__HTTPResponse__InputsAssignment_7 )* )
            // InternalBot.g:7198:3: ( rule__HTTPResponse__InputsAssignment_7 )*
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:7199:3: ( rule__HTTPResponse__InputsAssignment_7 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==60) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBot.g:7199:4: rule__HTTPResponse__InputsAssignment_7
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__HTTPResponse__InputsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 

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
    // $ANTLR end "rule__HTTPResponse__Group__7__Impl"


    // $ANTLR start "rule__HTTPRequest__Group__0"
    // InternalBot.g:7209:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7213:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:7214:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
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
    // InternalBot.g:7221:1: rule__HTTPRequest__Group__0__Impl : ( 'Request' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7225:1: ( ( 'Request' ) )
            // InternalBot.g:7226:1: ( 'Request' )
            {
            // InternalBot.g:7226:1: ( 'Request' )
            // InternalBot.g:7227:2: 'Request'
            {
             before(grammarAccess.getHTTPRequestAccess().getRequestKeyword_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getRequestKeyword_0()); 

            }


            }

        }
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
    // InternalBot.g:7236:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7240:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:7241:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:7248:1: rule__HTTPRequest__Group__1__Impl : ( ( rule__HTTPRequest__MethodAssignment_1 ) ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7252:1: ( ( ( rule__HTTPRequest__MethodAssignment_1 ) ) )
            // InternalBot.g:7253:1: ( ( rule__HTTPRequest__MethodAssignment_1 ) )
            {
            // InternalBot.g:7253:1: ( ( rule__HTTPRequest__MethodAssignment_1 ) )
            // InternalBot.g:7254:2: ( rule__HTTPRequest__MethodAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_1()); 
            // InternalBot.g:7255:2: ( rule__HTTPRequest__MethodAssignment_1 )
            // InternalBot.g:7255:3: rule__HTTPRequest__MethodAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__MethodAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getMethodAssignment_1()); 

            }


            }

        }
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
    // InternalBot.g:7263:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7267:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:7268:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:7275:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__NameAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7279:1: ( ( ( rule__HTTPRequest__NameAssignment_2 ) ) )
            // InternalBot.g:7280:1: ( ( rule__HTTPRequest__NameAssignment_2 ) )
            {
            // InternalBot.g:7280:1: ( ( rule__HTTPRequest__NameAssignment_2 ) )
            // InternalBot.g:7281:2: ( rule__HTTPRequest__NameAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_2()); 
            // InternalBot.g:7282:2: ( rule__HTTPRequest__NameAssignment_2 )
            // InternalBot.g:7282:3: rule__HTTPRequest__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getNameAssignment_2()); 

            }


            }

        }
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
    // InternalBot.g:7290:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7294:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:7295:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
            {
            pushFollow(FOLLOW_65);
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
    // InternalBot.g:7302:1: rule__HTTPRequest__Group__3__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7306:1: ( ( ':' ) )
            // InternalBot.g:7307:1: ( ':' )
            {
            // InternalBot.g:7307:1: ( ':' )
            // InternalBot.g:7308:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_3()); 

            }


            }

        }
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
    // InternalBot.g:7317:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7321:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:7322:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:7329:1: rule__HTTPRequest__Group__4__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7333:1: ( ( 'URL' ) )
            // InternalBot.g:7334:1: ( 'URL' )
            {
            // InternalBot.g:7334:1: ( 'URL' )
            // InternalBot.g:7335:2: 'URL'
            {
             before(grammarAccess.getHTTPRequestAccess().getURLKeyword_4()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getURLKeyword_4()); 

            }


            }

        }
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
    // InternalBot.g:7344:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7348:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:7349:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
            {
            pushFollow(FOLLOW_5);
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
    // InternalBot.g:7356:1: rule__HTTPRequest__Group__5__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7360:1: ( ( ':' ) )
            // InternalBot.g:7361:1: ( ':' )
            {
            // InternalBot.g:7361:1: ( ':' )
            // InternalBot.g:7362:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_5()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_5()); 

            }


            }

        }
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
    // InternalBot.g:7371:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7375:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:7376:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
            {
            pushFollow(FOLLOW_20);
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
    // InternalBot.g:7383:1: rule__HTTPRequest__Group__6__Impl : ( ( rule__HTTPRequest__URLAssignment_6 ) ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7387:1: ( ( ( rule__HTTPRequest__URLAssignment_6 ) ) )
            // InternalBot.g:7388:1: ( ( rule__HTTPRequest__URLAssignment_6 ) )
            {
            // InternalBot.g:7388:1: ( ( rule__HTTPRequest__URLAssignment_6 ) )
            // InternalBot.g:7389:2: ( rule__HTTPRequest__URLAssignment_6 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_6()); 
            // InternalBot.g:7390:2: ( rule__HTTPRequest__URLAssignment_6 )
            // InternalBot.g:7390:3: rule__HTTPRequest__URLAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__URLAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getURLAssignment_6()); 

            }


            }

        }
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
    // InternalBot.g:7398:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7402:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:7403:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
            {
            pushFollow(FOLLOW_66);
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
    // InternalBot.g:7410:1: rule__HTTPRequest__Group__7__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7414:1: ( ( ';' ) )
            // InternalBot.g:7415:1: ( ';' )
            {
            // InternalBot.g:7415:1: ( ';' )
            // InternalBot.g:7416:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_7()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_7()); 

            }


            }

        }
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
    // InternalBot.g:7425:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7429:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:7430:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
            {
            pushFollow(FOLLOW_66);
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
    // InternalBot.g:7437:1: rule__HTTPRequest__Group__8__Impl : ( ( rule__HTTPRequest__Group_8__0 )? ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7441:1: ( ( ( rule__HTTPRequest__Group_8__0 )? ) )
            // InternalBot.g:7442:1: ( ( rule__HTTPRequest__Group_8__0 )? )
            {
            // InternalBot.g:7442:1: ( ( rule__HTTPRequest__Group_8__0 )? )
            // InternalBot.g:7443:2: ( rule__HTTPRequest__Group_8__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_8()); 
            // InternalBot.g:7444:2: ( rule__HTTPRequest__Group_8__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==86) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBot.g:7444:3: rule__HTTPRequest__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__HTTPRequest__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getHTTPRequestAccess().getGroup_8()); 

            }


            }

        }
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
    // InternalBot.g:7452:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7456:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:7457:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
            {
            pushFollow(FOLLOW_66);
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
    // InternalBot.g:7464:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7468:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:7469:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:7469:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:7470:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:7471:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==87) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalBot.g:7471:3: rule__HTTPRequest__Group_9__0
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
    // InternalBot.g:7479:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7483:1: ( rule__HTTPRequest__Group__10__Impl )
            // InternalBot.g:7484:2: rule__HTTPRequest__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group__10__Impl();

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
    // InternalBot.g:7490:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7494:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:7495:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:7495:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:7496:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:7497:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==18) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalBot.g:7497:3: rule__HTTPRequest__Group_10__0
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


    // $ANTLR start "rule__HTTPRequest__Group_8__0"
    // InternalBot.g:7506:1: rule__HTTPRequest__Group_8__0 : rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1 ;
    public final void rule__HTTPRequest__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7510:1: ( rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1 )
            // InternalBot.g:7511:2: rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1
            {
            pushFollow(FOLLOW_7);
            rule__HTTPRequest__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_8__1();

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
    // $ANTLR end "rule__HTTPRequest__Group_8__0"


    // $ANTLR start "rule__HTTPRequest__Group_8__0__Impl"
    // InternalBot.g:7518:1: rule__HTTPRequest__Group_8__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7522:1: ( ( 'basicAuth' ) )
            // InternalBot.g:7523:1: ( 'basicAuth' )
            {
            // InternalBot.g:7523:1: ( 'basicAuth' )
            // InternalBot.g:7524:2: 'basicAuth'
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_8_0()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_8__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_8__1"
    // InternalBot.g:7533:1: rule__HTTPRequest__Group_8__1 : rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2 ;
    public final void rule__HTTPRequest__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7537:1: ( rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2 )
            // InternalBot.g:7538:2: rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_8__2();

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
    // $ANTLR end "rule__HTTPRequest__Group_8__1"


    // $ANTLR start "rule__HTTPRequest__Group_8__1__Impl"
    // InternalBot.g:7545:1: rule__HTTPRequest__Group_8__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7549:1: ( ( ':' ) )
            // InternalBot.g:7550:1: ( ':' )
            {
            // InternalBot.g:7550:1: ( ':' )
            // InternalBot.g:7551:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_8_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_8__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_8__2"
    // InternalBot.g:7560:1: rule__HTTPRequest__Group_8__2 : rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3 ;
    public final void rule__HTTPRequest__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7564:1: ( rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3 )
            // InternalBot.g:7565:2: rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3
            {
            pushFollow(FOLLOW_20);
            rule__HTTPRequest__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_8__3();

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
    // $ANTLR end "rule__HTTPRequest__Group_8__2"


    // $ANTLR start "rule__HTTPRequest__Group_8__2__Impl"
    // InternalBot.g:7572:1: rule__HTTPRequest__Group_8__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) ) ;
    public final void rule__HTTPRequest__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7576:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) ) )
            // InternalBot.g:7577:1: ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) )
            {
            // InternalBot.g:7577:1: ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) )
            // InternalBot.g:7578:2: ( rule__HTTPRequest__BasicAuthAssignment_8_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_8_2()); 
            // InternalBot.g:7579:2: ( rule__HTTPRequest__BasicAuthAssignment_8_2 )
            // InternalBot.g:7579:3: rule__HTTPRequest__BasicAuthAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__BasicAuthAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_8__2__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_8__3"
    // InternalBot.g:7587:1: rule__HTTPRequest__Group_8__3 : rule__HTTPRequest__Group_8__3__Impl ;
    public final void rule__HTTPRequest__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7591:1: ( rule__HTTPRequest__Group_8__3__Impl )
            // InternalBot.g:7592:2: rule__HTTPRequest__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_8__3__Impl();

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
    // $ANTLR end "rule__HTTPRequest__Group_8__3"


    // $ANTLR start "rule__HTTPRequest__Group_8__3__Impl"
    // InternalBot.g:7598:1: rule__HTTPRequest__Group_8__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7602:1: ( ( ';' ) )
            // InternalBot.g:7603:1: ( ';' )
            {
            // InternalBot.g:7603:1: ( ';' )
            // InternalBot.g:7604:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8_3()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_8__3__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9__0"
    // InternalBot.g:7614:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7618:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:7619:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:7626:1: rule__HTTPRequest__Group_9__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7630:1: ( ( 'headers' ) )
            // InternalBot.g:7631:1: ( 'headers' )
            {
            // InternalBot.g:7631:1: ( 'headers' )
            // InternalBot.g:7632:2: 'headers'
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_9_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_9_0()); 

            }


            }

        }
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
    // InternalBot.g:7641:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7645:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:7646:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
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
    // InternalBot.g:7653:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7657:1: ( ( ':' ) )
            // InternalBot.g:7658:1: ( ':' )
            {
            // InternalBot.g:7658:1: ( ':' )
            // InternalBot.g:7659:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:7668:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7672:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:7673:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:7680:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7684:1: ( ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) ) )
            // InternalBot.g:7685:1: ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) )
            {
            // InternalBot.g:7685:1: ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) )
            // InternalBot.g:7686:2: ( rule__HTTPRequest__HeadersAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_2()); 
            // InternalBot.g:7687:2: ( rule__HTTPRequest__HeadersAssignment_9_2 )
            // InternalBot.g:7687:3: rule__HTTPRequest__HeadersAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__HeadersAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_2()); 

            }


            }

        }
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
    // InternalBot.g:7695:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4 ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7699:1: ( rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4 )
            // InternalBot.g:7700:2: rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4
            {
            pushFollow(FOLLOW_38);
            rule__HTTPRequest__Group_9__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__4();

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
    // InternalBot.g:7707:1: rule__HTTPRequest__Group_9__3__Impl : ( ( rule__HTTPRequest__Group_9_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7711:1: ( ( ( rule__HTTPRequest__Group_9_3__0 )* ) )
            // InternalBot.g:7712:1: ( ( rule__HTTPRequest__Group_9_3__0 )* )
            {
            // InternalBot.g:7712:1: ( ( rule__HTTPRequest__Group_9_3__0 )* )
            // InternalBot.g:7713:2: ( rule__HTTPRequest__Group_9_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9_3()); 
            // InternalBot.g:7714:2: ( rule__HTTPRequest__Group_9_3__0 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==54) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalBot.g:7714:3: rule__HTTPRequest__Group_9_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HTTPRequest__Group_9_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);

             after(grammarAccess.getHTTPRequestAccess().getGroup_9_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__HTTPRequest__Group_9__4"
    // InternalBot.g:7722:1: rule__HTTPRequest__Group_9__4 : rule__HTTPRequest__Group_9__4__Impl ;
    public final void rule__HTTPRequest__Group_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7726:1: ( rule__HTTPRequest__Group_9__4__Impl )
            // InternalBot.g:7727:2: rule__HTTPRequest__Group_9__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9__4__Impl();

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
    // $ANTLR end "rule__HTTPRequest__Group_9__4"


    // $ANTLR start "rule__HTTPRequest__Group_9__4__Impl"
    // InternalBot.g:7733:1: rule__HTTPRequest__Group_9__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7737:1: ( ( ';' ) )
            // InternalBot.g:7738:1: ( ';' )
            {
            // InternalBot.g:7738:1: ( ';' )
            // InternalBot.g:7739:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_4()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9__4__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9_3__0"
    // InternalBot.g:7749:1: rule__HTTPRequest__Group_9_3__0 : rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1 ;
    public final void rule__HTTPRequest__Group_9_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7753:1: ( rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1 )
            // InternalBot.g:7754:2: rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1
            {
            pushFollow(FOLLOW_5);
            rule__HTTPRequest__Group_9_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9_3__1();

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
    // $ANTLR end "rule__HTTPRequest__Group_9_3__0"


    // $ANTLR start "rule__HTTPRequest__Group_9_3__0__Impl"
    // InternalBot.g:7761:1: rule__HTTPRequest__Group_9_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_9_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7765:1: ( ( ',' ) )
            // InternalBot.g:7766:1: ( ',' )
            {
            // InternalBot.g:7766:1: ( ',' )
            // InternalBot.g:7767:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_9_3_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getCommaKeyword_9_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9_3__0__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_9_3__1"
    // InternalBot.g:7776:1: rule__HTTPRequest__Group_9_3__1 : rule__HTTPRequest__Group_9_3__1__Impl ;
    public final void rule__HTTPRequest__Group_9_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7780:1: ( rule__HTTPRequest__Group_9_3__1__Impl )
            // InternalBot.g:7781:2: rule__HTTPRequest__Group_9_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_9_3__1__Impl();

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
    // $ANTLR end "rule__HTTPRequest__Group_9_3__1"


    // $ANTLR start "rule__HTTPRequest__Group_9_3__1__Impl"
    // InternalBot.g:7787:1: rule__HTTPRequest__Group_9_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_9_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7791:1: ( ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) ) )
            // InternalBot.g:7792:1: ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) )
            {
            // InternalBot.g:7792:1: ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) )
            // InternalBot.g:7793:2: ( rule__HTTPRequest__HeadersAssignment_9_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_3_1()); 
            // InternalBot.g:7794:2: ( rule__HTTPRequest__HeadersAssignment_9_3_1 )
            // InternalBot.g:7794:3: rule__HTTPRequest__HeadersAssignment_9_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__HeadersAssignment_9_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_9_3__1__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__0"
    // InternalBot.g:7803:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7807:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:7808:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:7815:1: rule__HTTPRequest__Group_10__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7819:1: ( ( 'data' ) )
            // InternalBot.g:7820:1: ( 'data' )
            {
            // InternalBot.g:7820:1: ( 'data' )
            // InternalBot.g:7821:2: 'data'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataKeyword_10_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getDataKeyword_10_0()); 

            }


            }

        }
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
    // InternalBot.g:7830:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7834:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:7835:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
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
    // InternalBot.g:7842:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7846:1: ( ( ':' ) )
            // InternalBot.g:7847:1: ( ':' )
            {
            // InternalBot.g:7847:1: ( ':' )
            // InternalBot.g:7848:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:7857:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7861:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:7862:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:7869:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__DataAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7873:1: ( ( ( rule__HTTPRequest__DataAssignment_10_2 ) ) )
            // InternalBot.g:7874:1: ( ( rule__HTTPRequest__DataAssignment_10_2 ) )
            {
            // InternalBot.g:7874:1: ( ( rule__HTTPRequest__DataAssignment_10_2 ) )
            // InternalBot.g:7875:2: ( rule__HTTPRequest__DataAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_2()); 
            // InternalBot.g:7876:2: ( rule__HTTPRequest__DataAssignment_10_2 )
            // InternalBot.g:7876:3: rule__HTTPRequest__DataAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_2()); 

            }


            }

        }
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
    // InternalBot.g:7884:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7888:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:7889:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
            {
            pushFollow(FOLLOW_38);
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
    // InternalBot.g:7896:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7900:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:7901:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:7901:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:7902:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:7903:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==54) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalBot.g:7903:3: rule__HTTPRequest__Group_10_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HTTPRequest__Group_10_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop69;
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
    // InternalBot.g:7911:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5 ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7915:1: ( rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5 )
            // InternalBot.g:7916:2: rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5
            {
            pushFollow(FOLLOW_67);
            rule__HTTPRequest__Group_10__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__5();

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
    // InternalBot.g:7923:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7927:1: ( ( ';' ) )
            // InternalBot.g:7928:1: ( ';' )
            {
            // InternalBot.g:7928:1: ( ';' )
            // InternalBot.g:7929:2: ';'
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


    // $ANTLR start "rule__HTTPRequest__Group_10__5"
    // InternalBot.g:7938:1: rule__HTTPRequest__Group_10__5 : rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6 ;
    public final void rule__HTTPRequest__Group_10__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7942:1: ( rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6 )
            // InternalBot.g:7943:2: rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6
            {
            pushFollow(FOLLOW_7);
            rule__HTTPRequest__Group_10__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__6();

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
    // $ANTLR end "rule__HTTPRequest__Group_10__5"


    // $ANTLR start "rule__HTTPRequest__Group_10__5__Impl"
    // InternalBot.g:7950:1: rule__HTTPRequest__Group_10__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_10__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7954:1: ( ( 'dataType' ) )
            // InternalBot.g:7955:1: ( 'dataType' )
            {
            // InternalBot.g:7955:1: ( 'dataType' )
            // InternalBot.g:7956:2: 'dataType'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_10_5()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_10_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__5__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__6"
    // InternalBot.g:7965:1: rule__HTTPRequest__Group_10__6 : rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7 ;
    public final void rule__HTTPRequest__Group_10__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7969:1: ( rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7 )
            // InternalBot.g:7970:2: rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7
            {
            pushFollow(FOLLOW_68);
            rule__HTTPRequest__Group_10__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__7();

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
    // $ANTLR end "rule__HTTPRequest__Group_10__6"


    // $ANTLR start "rule__HTTPRequest__Group_10__6__Impl"
    // InternalBot.g:7977:1: rule__HTTPRequest__Group_10__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7981:1: ( ( ':' ) )
            // InternalBot.g:7982:1: ( ':' )
            {
            // InternalBot.g:7982:1: ( ':' )
            // InternalBot.g:7983:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_6()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__6__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__7"
    // InternalBot.g:7992:1: rule__HTTPRequest__Group_10__7 : rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8 ;
    public final void rule__HTTPRequest__Group_10__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7996:1: ( rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8 )
            // InternalBot.g:7997:2: rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8
            {
            pushFollow(FOLLOW_20);
            rule__HTTPRequest__Group_10__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__8();

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
    // $ANTLR end "rule__HTTPRequest__Group_10__7"


    // $ANTLR start "rule__HTTPRequest__Group_10__7__Impl"
    // InternalBot.g:8004:1: rule__HTTPRequest__Group_10__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) ) ;
    public final void rule__HTTPRequest__Group_10__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8008:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) ) )
            // InternalBot.g:8009:1: ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) )
            {
            // InternalBot.g:8009:1: ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) )
            // InternalBot.g:8010:2: ( rule__HTTPRequest__DataTypeAssignment_10_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_10_7()); 
            // InternalBot.g:8011:2: ( rule__HTTPRequest__DataTypeAssignment_10_7 )
            // InternalBot.g:8011:3: rule__HTTPRequest__DataTypeAssignment_10_7
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataTypeAssignment_10_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_10_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__7__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10__8"
    // InternalBot.g:8019:1: rule__HTTPRequest__Group_10__8 : rule__HTTPRequest__Group_10__8__Impl ;
    public final void rule__HTTPRequest__Group_10__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8023:1: ( rule__HTTPRequest__Group_10__8__Impl )
            // InternalBot.g:8024:2: rule__HTTPRequest__Group_10__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__Group_10__8__Impl();

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
    // $ANTLR end "rule__HTTPRequest__Group_10__8"


    // $ANTLR start "rule__HTTPRequest__Group_10__8__Impl"
    // InternalBot.g:8030:1: rule__HTTPRequest__Group_10__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8034:1: ( ( ';' ) )
            // InternalBot.g:8035:1: ( ';' )
            {
            // InternalBot.g:8035:1: ( ';' )
            // InternalBot.g:8036:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_8()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__Group_10__8__Impl"


    // $ANTLR start "rule__HTTPRequest__Group_10_3__0"
    // InternalBot.g:8046:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8050:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:8051:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
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
    // InternalBot.g:8058:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8062:1: ( ( ',' ) )
            // InternalBot.g:8063:1: ( ',' )
            {
            // InternalBot.g:8063:1: ( ',' )
            // InternalBot.g:8064:2: ','
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
    // InternalBot.g:8073:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8077:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:8078:2: rule__HTTPRequest__Group_10_3__1__Impl
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
    // InternalBot.g:8084:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8088:1: ( ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) ) )
            // InternalBot.g:8089:1: ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) )
            {
            // InternalBot.g:8089:1: ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) )
            // InternalBot.g:8090:2: ( rule__HTTPRequest__DataAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_3_1()); 
            // InternalBot.g:8091:2: ( rule__HTTPRequest__DataAssignment_10_3_1 )
            // InternalBot.g:8091:3: rule__HTTPRequest__DataAssignment_10_3_1
            {
            pushFollow(FOLLOW_2);
            rule__HTTPRequest__DataAssignment_10_3_1();

            state._fsp--;


            }

             after(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_3_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Image__Group__0"
    // InternalBot.g:8100:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8104:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:8105:2: rule__Image__Group__0__Impl rule__Image__Group__1
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
    // InternalBot.g:8112:1: rule__Image__Group__0__Impl : ( 'image' ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8116:1: ( ( 'image' ) )
            // InternalBot.g:8117:1: ( 'image' )
            {
            // InternalBot.g:8117:1: ( 'image' )
            // InternalBot.g:8118:2: 'image'
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
    // InternalBot.g:8127:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8131:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:8132:2: rule__Image__Group__1__Impl rule__Image__Group__2
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
    // InternalBot.g:8139:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8143:1: ( ( 'response' ) )
            // InternalBot.g:8144:1: ( 'response' )
            {
            // InternalBot.g:8144:1: ( 'response' )
            // InternalBot.g:8145:2: 'response'
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
    // InternalBot.g:8154:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8158:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:8159:2: rule__Image__Group__2__Impl rule__Image__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:8166:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8170:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:8171:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:8171:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:8172:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:8173:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:8173:3: rule__Image__NameAssignment_2
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
    // InternalBot.g:8181:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8185:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:8186:2: rule__Image__Group__3__Impl rule__Image__Group__4
            {
            pushFollow(FOLLOW_65);
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
    // InternalBot.g:8193:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8197:1: ( ( ':' ) )
            // InternalBot.g:8198:1: ( ':' )
            {
            // InternalBot.g:8198:1: ( ':' )
            // InternalBot.g:8199:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_3()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:8208:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8212:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:8213:2: rule__Image__Group__4__Impl rule__Image__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:8220:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8224:1: ( ( 'URL' ) )
            // InternalBot.g:8225:1: ( 'URL' )
            {
            // InternalBot.g:8225:1: ( 'URL' )
            // InternalBot.g:8226:2: 'URL'
            {
             before(grammarAccess.getImageAccess().getURLKeyword_4()); 
            match(input,85,FOLLOW_2); 
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
    // InternalBot.g:8235:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8239:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:8240:2: rule__Image__Group__5__Impl rule__Image__Group__6
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
    // InternalBot.g:8247:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8251:1: ( ( ':' ) )
            // InternalBot.g:8252:1: ( ':' )
            {
            // InternalBot.g:8252:1: ( ':' )
            // InternalBot.g:8253:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_5()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:8262:1: rule__Image__Group__6 : rule__Image__Group__6__Impl rule__Image__Group__7 ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8266:1: ( rule__Image__Group__6__Impl rule__Image__Group__7 )
            // InternalBot.g:8267:2: rule__Image__Group__6__Impl rule__Image__Group__7
            {
            pushFollow(FOLLOW_69);
            rule__Image__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group__7();

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
    // InternalBot.g:8274:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8278:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:8279:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:8279:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:8280:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:8281:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:8281:3: rule__Image__URLAssignment_6
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


    // $ANTLR start "rule__Image__Group__7"
    // InternalBot.g:8289:1: rule__Image__Group__7 : rule__Image__Group__7__Impl ;
    public final void rule__Image__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8293:1: ( rule__Image__Group__7__Impl )
            // InternalBot.g:8294:2: rule__Image__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Image__Group__7__Impl();

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
    // $ANTLR end "rule__Image__Group__7"


    // $ANTLR start "rule__Image__Group__7__Impl"
    // InternalBot.g:8300:1: rule__Image__Group__7__Impl : ( ( rule__Image__Group_7__0 )? ) ;
    public final void rule__Image__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8304:1: ( ( ( rule__Image__Group_7__0 )? ) )
            // InternalBot.g:8305:1: ( ( rule__Image__Group_7__0 )? )
            {
            // InternalBot.g:8305:1: ( ( rule__Image__Group_7__0 )? )
            // InternalBot.g:8306:2: ( rule__Image__Group_7__0 )?
            {
             before(grammarAccess.getImageAccess().getGroup_7()); 
            // InternalBot.g:8307:2: ( rule__Image__Group_7__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==89) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalBot.g:8307:3: rule__Image__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Image__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImageAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group__7__Impl"


    // $ANTLR start "rule__Image__Group_7__0"
    // InternalBot.g:8316:1: rule__Image__Group_7__0 : rule__Image__Group_7__0__Impl rule__Image__Group_7__1 ;
    public final void rule__Image__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8320:1: ( rule__Image__Group_7__0__Impl rule__Image__Group_7__1 )
            // InternalBot.g:8321:2: rule__Image__Group_7__0__Impl rule__Image__Group_7__1
            {
            pushFollow(FOLLOW_7);
            rule__Image__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group_7__1();

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
    // $ANTLR end "rule__Image__Group_7__0"


    // $ANTLR start "rule__Image__Group_7__0__Impl"
    // InternalBot.g:8328:1: rule__Image__Group_7__0__Impl : ( 'caption' ) ;
    public final void rule__Image__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8332:1: ( ( 'caption' ) )
            // InternalBot.g:8333:1: ( 'caption' )
            {
            // InternalBot.g:8333:1: ( 'caption' )
            // InternalBot.g:8334:2: 'caption'
            {
             before(grammarAccess.getImageAccess().getCaptionKeyword_7_0()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getCaptionKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group_7__0__Impl"


    // $ANTLR start "rule__Image__Group_7__1"
    // InternalBot.g:8343:1: rule__Image__Group_7__1 : rule__Image__Group_7__1__Impl rule__Image__Group_7__2 ;
    public final void rule__Image__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8347:1: ( rule__Image__Group_7__1__Impl rule__Image__Group_7__2 )
            // InternalBot.g:8348:2: rule__Image__Group_7__1__Impl rule__Image__Group_7__2
            {
            pushFollow(FOLLOW_5);
            rule__Image__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Image__Group_7__2();

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
    // $ANTLR end "rule__Image__Group_7__1"


    // $ANTLR start "rule__Image__Group_7__1__Impl"
    // InternalBot.g:8355:1: rule__Image__Group_7__1__Impl : ( ':' ) ;
    public final void rule__Image__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8359:1: ( ( ':' ) )
            // InternalBot.g:8360:1: ( ':' )
            {
            // InternalBot.g:8360:1: ( ':' )
            // InternalBot.g:8361:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_7_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getImageAccess().getColonKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group_7__1__Impl"


    // $ANTLR start "rule__Image__Group_7__2"
    // InternalBot.g:8370:1: rule__Image__Group_7__2 : rule__Image__Group_7__2__Impl ;
    public final void rule__Image__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8374:1: ( rule__Image__Group_7__2__Impl )
            // InternalBot.g:8375:2: rule__Image__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Image__Group_7__2__Impl();

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
    // $ANTLR end "rule__Image__Group_7__2"


    // $ANTLR start "rule__Image__Group_7__2__Impl"
    // InternalBot.g:8381:1: rule__Image__Group_7__2__Impl : ( ( rule__Image__CaptionAssignment_7_2 ) ) ;
    public final void rule__Image__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8385:1: ( ( ( rule__Image__CaptionAssignment_7_2 ) ) )
            // InternalBot.g:8386:1: ( ( rule__Image__CaptionAssignment_7_2 ) )
            {
            // InternalBot.g:8386:1: ( ( rule__Image__CaptionAssignment_7_2 ) )
            // InternalBot.g:8387:2: ( rule__Image__CaptionAssignment_7_2 )
            {
             before(grammarAccess.getImageAccess().getCaptionAssignment_7_2()); 
            // InternalBot.g:8388:2: ( rule__Image__CaptionAssignment_7_2 )
            // InternalBot.g:8388:3: rule__Image__CaptionAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__Image__CaptionAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getCaptionAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__Group_7__2__Impl"


    // $ANTLR start "rule__Empty__Group__0"
    // InternalBot.g:8397:1: rule__Empty__Group__0 : rule__Empty__Group__0__Impl rule__Empty__Group__1 ;
    public final void rule__Empty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8401:1: ( rule__Empty__Group__0__Impl rule__Empty__Group__1 )
            // InternalBot.g:8402:2: rule__Empty__Group__0__Impl rule__Empty__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__Empty__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Empty__Group__1();

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
    // $ANTLR end "rule__Empty__Group__0"


    // $ANTLR start "rule__Empty__Group__0__Impl"
    // InternalBot.g:8409:1: rule__Empty__Group__0__Impl : ( 'empty' ) ;
    public final void rule__Empty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8413:1: ( ( 'empty' ) )
            // InternalBot.g:8414:1: ( 'empty' )
            {
            // InternalBot.g:8414:1: ( 'empty' )
            // InternalBot.g:8415:2: 'empty'
            {
             before(grammarAccess.getEmptyAccess().getEmptyKeyword_0()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getEmptyAccess().getEmptyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Empty__Group__0__Impl"


    // $ANTLR start "rule__Empty__Group__1"
    // InternalBot.g:8424:1: rule__Empty__Group__1 : rule__Empty__Group__1__Impl rule__Empty__Group__2 ;
    public final void rule__Empty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8428:1: ( rule__Empty__Group__1__Impl rule__Empty__Group__2 )
            // InternalBot.g:8429:2: rule__Empty__Group__1__Impl rule__Empty__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Empty__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Empty__Group__2();

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
    // $ANTLR end "rule__Empty__Group__1"


    // $ANTLR start "rule__Empty__Group__1__Impl"
    // InternalBot.g:8436:1: rule__Empty__Group__1__Impl : ( 'response' ) ;
    public final void rule__Empty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8440:1: ( ( 'response' ) )
            // InternalBot.g:8441:1: ( 'response' )
            {
            // InternalBot.g:8441:1: ( 'response' )
            // InternalBot.g:8442:2: 'response'
            {
             before(grammarAccess.getEmptyAccess().getResponseKeyword_1()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getEmptyAccess().getResponseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Empty__Group__1__Impl"


    // $ANTLR start "rule__Empty__Group__2"
    // InternalBot.g:8451:1: rule__Empty__Group__2 : rule__Empty__Group__2__Impl ;
    public final void rule__Empty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8455:1: ( rule__Empty__Group__2__Impl )
            // InternalBot.g:8456:2: rule__Empty__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Empty__Group__2__Impl();

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
    // $ANTLR end "rule__Empty__Group__2"


    // $ANTLR start "rule__Empty__Group__2__Impl"
    // InternalBot.g:8462:1: rule__Empty__Group__2__Impl : ( ( rule__Empty__NameAssignment_2 ) ) ;
    public final void rule__Empty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8466:1: ( ( ( rule__Empty__NameAssignment_2 ) ) )
            // InternalBot.g:8467:1: ( ( rule__Empty__NameAssignment_2 ) )
            {
            // InternalBot.g:8467:1: ( ( rule__Empty__NameAssignment_2 ) )
            // InternalBot.g:8468:2: ( rule__Empty__NameAssignment_2 )
            {
             before(grammarAccess.getEmptyAccess().getNameAssignment_2()); 
            // InternalBot.g:8469:2: ( rule__Empty__NameAssignment_2 )
            // InternalBot.g:8469:3: rule__Empty__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Empty__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEmptyAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Empty__Group__2__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0"
    // InternalBot.g:8478:1: rule__TextLanguageInputHttpResponse__Group__0 : rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8482:1: ( rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 )
            // InternalBot.g:8483:2: rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1
            {
            pushFollow(FOLLOW_25);
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
    // InternalBot.g:8490:1: rule__TextLanguageInputHttpResponse__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8494:1: ( ( 'inputs' ) )
            // InternalBot.g:8495:1: ( 'inputs' )
            {
            // InternalBot.g:8495:1: ( 'inputs' )
            // InternalBot.g:8496:2: 'inputs'
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
    // InternalBot.g:8505:1: rule__TextLanguageInputHttpResponse__Group__1 : rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 ;
    public final void rule__TextLanguageInputHttpResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8509:1: ( rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 )
            // InternalBot.g:8510:2: rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2
            {
            pushFollow(FOLLOW_25);
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
    // InternalBot.g:8517:1: rule__TextLanguageInputHttpResponse__Group__1__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8521:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) )
            // InternalBot.g:8522:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            {
            // InternalBot.g:8522:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            // InternalBot.g:8523:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 
            // InternalBot.g:8524:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==63) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalBot.g:8524:3: rule__TextLanguageInputHttpResponse__Group_1__0
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
    // InternalBot.g:8532:1: rule__TextLanguageInputHttpResponse__Group__2 : rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 ;
    public final void rule__TextLanguageInputHttpResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8536:1: ( rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 )
            // InternalBot.g:8537:2: rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3
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
    // InternalBot.g:8544:1: rule__TextLanguageInputHttpResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8548:1: ( ( '{' ) )
            // InternalBot.g:8549:1: ( '{' )
            {
            // InternalBot.g:8549:1: ( '{' )
            // InternalBot.g:8550:2: '{'
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
    // InternalBot.g:8559:1: rule__TextLanguageInputHttpResponse__Group__3 : rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 ;
    public final void rule__TextLanguageInputHttpResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8563:1: ( rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 )
            // InternalBot.g:8564:2: rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4
            {
            pushFollow(FOLLOW_27);
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
    // InternalBot.g:8571:1: rule__TextLanguageInputHttpResponse__Group__3__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8575:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) )
            // InternalBot.g:8576:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            {
            // InternalBot.g:8576:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            // InternalBot.g:8577:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 
            // InternalBot.g:8578:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            // InternalBot.g:8578:3: rule__TextLanguageInputHttpResponse__InputsAssignment_3
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
    // InternalBot.g:8586:1: rule__TextLanguageInputHttpResponse__Group__4 : rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 ;
    public final void rule__TextLanguageInputHttpResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8590:1: ( rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 )
            // InternalBot.g:8591:2: rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5
            {
            pushFollow(FOLLOW_27);
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
    // InternalBot.g:8598:1: rule__TextLanguageInputHttpResponse__Group__4__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8602:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) )
            // InternalBot.g:8603:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            {
            // InternalBot.g:8603:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            // InternalBot.g:8604:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 
            // InternalBot.g:8605:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==54) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalBot.g:8605:3: rule__TextLanguageInputHttpResponse__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__TextLanguageInputHttpResponse__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop72;
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
    // InternalBot.g:8613:1: rule__TextLanguageInputHttpResponse__Group__5 : rule__TextLanguageInputHttpResponse__Group__5__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8617:1: ( rule__TextLanguageInputHttpResponse__Group__5__Impl )
            // InternalBot.g:8618:2: rule__TextLanguageInputHttpResponse__Group__5__Impl
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
    // InternalBot.g:8624:1: rule__TextLanguageInputHttpResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8628:1: ( ( '}' ) )
            // InternalBot.g:8629:1: ( '}' )
            {
            // InternalBot.g:8629:1: ( '}' )
            // InternalBot.g:8630:2: '}'
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
    // InternalBot.g:8640:1: rule__TextLanguageInputHttpResponse__Group_1__0 : rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8644:1: ( rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 )
            // InternalBot.g:8645:2: rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalBot.g:8652:1: rule__TextLanguageInputHttpResponse__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8656:1: ( ( 'in' ) )
            // InternalBot.g:8657:1: ( 'in' )
            {
            // InternalBot.g:8657:1: ( 'in' )
            // InternalBot.g:8658:2: 'in'
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
    // InternalBot.g:8667:1: rule__TextLanguageInputHttpResponse__Group_1__1 : rule__TextLanguageInputHttpResponse__Group_1__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8671:1: ( rule__TextLanguageInputHttpResponse__Group_1__1__Impl )
            // InternalBot.g:8672:2: rule__TextLanguageInputHttpResponse__Group_1__1__Impl
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
    // InternalBot.g:8678:1: rule__TextLanguageInputHttpResponse__Group_1__1__Impl : ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8682:1: ( ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:8683:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:8683:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            // InternalBot.g:8684:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:8685:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            // InternalBot.g:8685:3: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1
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
    // InternalBot.g:8694:1: rule__TextLanguageInputHttpResponse__Group_4__0 : rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8698:1: ( rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 )
            // InternalBot.g:8699:2: rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1
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
    // InternalBot.g:8706:1: rule__TextLanguageInputHttpResponse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8710:1: ( ( ',' ) )
            // InternalBot.g:8711:1: ( ',' )
            {
            // InternalBot.g:8711:1: ( ',' )
            // InternalBot.g:8712:2: ','
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
    // InternalBot.g:8721:1: rule__TextLanguageInputHttpResponse__Group_4__1 : rule__TextLanguageInputHttpResponse__Group_4__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8725:1: ( rule__TextLanguageInputHttpResponse__Group_4__1__Impl )
            // InternalBot.g:8726:2: rule__TextLanguageInputHttpResponse__Group_4__1__Impl
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
    // InternalBot.g:8732:1: rule__TextLanguageInputHttpResponse__Group_4__1__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8736:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) )
            // InternalBot.g:8737:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:8737:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            // InternalBot.g:8738:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:8739:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            // InternalBot.g:8739:3: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1
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
    // InternalBot.g:8748:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8752:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:8753:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:8760:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8764:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:8765:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:8765:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:8766:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:8767:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:8767:3: rule__KeyValue__KeyAssignment_0
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
    // InternalBot.g:8775:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8779:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:8780:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalBot.g:8787:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8791:1: ( ( ':' ) )
            // InternalBot.g:8792:1: ( ':' )
            {
            // InternalBot.g:8792:1: ( ':' )
            // InternalBot.g:8793:2: ':'
            {
             before(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:8802:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8806:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:8807:2: rule__KeyValue__Group__2__Impl
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
    // InternalBot.g:8813:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8817:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:8818:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:8818:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:8819:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:8820:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:8820:3: rule__KeyValue__ValueAssignment_2
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
    // InternalBot.g:8829:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8833:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:8834:2: rule__Data__Group__0__Impl rule__Data__Group__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalBot.g:8841:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8845:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:8846:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:8846:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:8847:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:8848:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:8848:3: rule__Data__KeyAssignment_0
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
    // InternalBot.g:8856:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8860:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:8861:2: rule__Data__Group__1__Impl rule__Data__Group__2
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
    // InternalBot.g:8868:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8872:1: ( ( ':' ) )
            // InternalBot.g:8873:1: ( ':' )
            {
            // InternalBot.g:8873:1: ( ':' )
            // InternalBot.g:8874:2: ':'
            {
             before(grammarAccess.getDataAccess().getColonKeyword_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalBot.g:8883:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8887:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:8888:2: rule__Data__Group__2__Impl
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
    // InternalBot.g:8894:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8898:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:8899:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:8899:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:8900:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:8901:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:8901:3: rule__Data__ValueAssignment_2
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
    // InternalBot.g:8910:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8914:1: ( ( ruleEString ) )
            // InternalBot.g:8915:2: ( ruleEString )
            {
            // InternalBot.g:8915:2: ( ruleEString )
            // InternalBot.g:8916:3: ruleEString
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


    // $ANTLR start "rule__Bot__LanguagesAssignment_4"
    // InternalBot.g:8925:1: rule__Bot__LanguagesAssignment_4 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8929:1: ( ( ruleLanguage ) )
            // InternalBot.g:8930:2: ( ruleLanguage )
            {
            // InternalBot.g:8930:2: ( ruleLanguage )
            // InternalBot.g:8931:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguagesAssignment_4"


    // $ANTLR start "rule__Bot__LanguagesAssignment_5_1"
    // InternalBot.g:8940:1: rule__Bot__LanguagesAssignment_5_1 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8944:1: ( ( ruleLanguage ) )
            // InternalBot.g:8945:2: ( ruleLanguage )
            {
            // InternalBot.g:8945:2: ( ruleLanguage )
            // InternalBot.g:8946:3: ruleLanguage
            {
             before(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__LanguagesAssignment_5_1"


    // $ANTLR start "rule__Bot__IntentsAssignment_8"
    // InternalBot.g:8955:1: rule__Bot__IntentsAssignment_8 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8959:1: ( ( ruleIntent ) )
            // InternalBot.g:8960:2: ( ruleIntent )
            {
            // InternalBot.g:8960:2: ( ruleIntent )
            // InternalBot.g:8961:3: ruleIntent
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


    // $ANTLR start "rule__Bot__IntentsAssignment_9"
    // InternalBot.g:8970:1: rule__Bot__IntentsAssignment_9 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8974:1: ( ( ruleIntent ) )
            // InternalBot.g:8975:2: ( ruleIntent )
            {
            // InternalBot.g:8975:2: ( ruleIntent )
            // InternalBot.g:8976:3: ruleIntent
            {
             before(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleIntent();

            state._fsp--;

             after(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__IntentsAssignment_9"


    // $ANTLR start "rule__Bot__EntitiesAssignment_10_2"
    // InternalBot.g:8985:1: rule__Bot__EntitiesAssignment_10_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8989:1: ( ( ruleEntity ) )
            // InternalBot.g:8990:2: ( ruleEntity )
            {
            // InternalBot.g:8990:2: ( ruleEntity )
            // InternalBot.g:8991:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_10_2"


    // $ANTLR start "rule__Bot__EntitiesAssignment_10_3"
    // InternalBot.g:9000:1: rule__Bot__EntitiesAssignment_10_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9004:1: ( ( ruleEntity ) )
            // InternalBot.g:9005:2: ( ruleEntity )
            {
            // InternalBot.g:9005:2: ( ruleEntity )
            // InternalBot.g:9006:3: ruleEntity
            {
             before(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_10_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_10_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__EntitiesAssignment_10_3"


    // $ANTLR start "rule__Bot__ActionsAssignment_11_2"
    // InternalBot.g:9015:1: rule__Bot__ActionsAssignment_11_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9019:1: ( ( ruleAction ) )
            // InternalBot.g:9020:2: ( ruleAction )
            {
            // InternalBot.g:9020:2: ( ruleAction )
            // InternalBot.g:9021:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_11_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_11_2"


    // $ANTLR start "rule__Bot__ActionsAssignment_11_3"
    // InternalBot.g:9030:1: rule__Bot__ActionsAssignment_11_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_11_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9034:1: ( ( ruleAction ) )
            // InternalBot.g:9035:2: ( ruleAction )
            {
            // InternalBot.g:9035:2: ( ruleAction )
            // InternalBot.g:9036:3: ruleAction
            {
             before(grammarAccess.getBotAccess().getActionsActionParserRuleCall_11_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAction();

            state._fsp--;

             after(grammarAccess.getBotAccess().getActionsActionParserRuleCall_11_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__ActionsAssignment_11_3"


    // $ANTLR start "rule__Bot__FlowsAssignment_14_1"
    // InternalBot.g:9045:1: rule__Bot__FlowsAssignment_14_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_14_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9049:1: ( ( ruleTransition ) )
            // InternalBot.g:9050:2: ( ruleTransition )
            {
            // InternalBot.g:9050:2: ( ruleTransition )
            // InternalBot.g:9051:3: ruleTransition
            {
             before(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_14_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTransition();

            state._fsp--;

             after(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_14_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Bot__FlowsAssignment_14_1"


    // $ANTLR start "rule__Intent2__NameAssignment_0"
    // InternalBot.g:9060:1: rule__Intent2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9064:1: ( ( ruleEString ) )
            // InternalBot.g:9065:2: ( ruleEString )
            {
            // InternalBot.g:9065:2: ( ruleEString )
            // InternalBot.g:9066:3: ruleEString
            {
             before(grammarAccess.getIntent2Access().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getIntent2Access().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__NameAssignment_0"


    // $ANTLR start "rule__Intent2__FallbackIntentAssignment_1"
    // InternalBot.g:9075:1: rule__Intent2__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent2__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9079:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:9080:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:9080:2: ( ( 'Fallback' ) )
            // InternalBot.g:9081:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:9082:3: ( 'Fallback' )
            // InternalBot.g:9083:4: 'Fallback'
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 

            }

             after(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__FallbackIntentAssignment_1"


    // $ANTLR start "rule__Intent2__InputsAssignment_3"
    // InternalBot.g:9094:1: rule__Intent2__InputsAssignment_3 : ( ruleIntentLanguageInputs ) ;
    public final void rule__Intent2__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9098:1: ( ( ruleIntentLanguageInputs ) )
            // InternalBot.g:9099:2: ( ruleIntentLanguageInputs )
            {
            // InternalBot.g:9099:2: ( ruleIntentLanguageInputs )
            // InternalBot.g:9100:3: ruleIntentLanguageInputs
            {
             before(grammarAccess.getIntent2Access().getInputsIntentLanguageInputsParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIntentLanguageInputs();

            state._fsp--;

             after(grammarAccess.getIntent2Access().getInputsIntentLanguageInputsParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__InputsAssignment_3"


    // $ANTLR start "rule__Intent2__ParametersAssignment_4_2_0"
    // InternalBot.g:9109:1: rule__Intent2__ParametersAssignment_4_2_0 : ( ruleParameter2 ) ;
    public final void rule__Intent2__ParametersAssignment_4_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9113:1: ( ( ruleParameter2 ) )
            // InternalBot.g:9114:2: ( ruleParameter2 )
            {
            // InternalBot.g:9114:2: ( ruleParameter2 )
            // InternalBot.g:9115:3: ruleParameter2
            {
             before(grammarAccess.getIntent2Access().getParametersParameter2ParserRuleCall_4_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter2();

            state._fsp--;

             after(grammarAccess.getIntent2Access().getParametersParameter2ParserRuleCall_4_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__ParametersAssignment_4_2_0"


    // $ANTLR start "rule__Intent2__ParametersAssignment_4_2_1"
    // InternalBot.g:9124:1: rule__Intent2__ParametersAssignment_4_2_1 : ( ruleParameter ) ;
    public final void rule__Intent2__ParametersAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9128:1: ( ( ruleParameter ) )
            // InternalBot.g:9129:2: ( ruleParameter )
            {
            // InternalBot.g:9129:2: ( ruleParameter )
            // InternalBot.g:9130:3: ruleParameter
            {
             before(grammarAccess.getIntent2Access().getParametersParameterParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getIntent2Access().getParametersParameterParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent2__ParametersAssignment_4_2_1"


    // $ANTLR start "rule__Intent1__NameAssignment_0"
    // InternalBot.g:9139:1: rule__Intent1__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9143:1: ( ( ruleEString ) )
            // InternalBot.g:9144:2: ( ruleEString )
            {
            // InternalBot.g:9144:2: ( ruleEString )
            // InternalBot.g:9145:3: ruleEString
            {
             before(grammarAccess.getIntent1Access().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getIntent1Access().getNameEStringParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent1__NameAssignment_0"


    // $ANTLR start "rule__Intent1__FallbackIntentAssignment_1"
    // InternalBot.g:9154:1: rule__Intent1__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent1__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9158:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:9159:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:9159:2: ( ( 'Fallback' ) )
            // InternalBot.g:9160:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:9161:3: ( 'Fallback' )
            // InternalBot.g:9162:4: 'Fallback'
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 

            }

             after(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Intent1__FallbackIntentAssignment_1"


    // $ANTLR start "rule__IntentLanguageInputs__LanguageAssignment_1_1"
    // InternalBot.g:9173:1: rule__IntentLanguageInputs__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__IntentLanguageInputs__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9177:1: ( ( ruleLanguage ) )
            // InternalBot.g:9178:2: ( ruleLanguage )
            {
            // InternalBot.g:9178:2: ( ruleLanguage )
            // InternalBot.g:9179:3: ruleLanguage
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
    // InternalBot.g:9188:1: rule__IntentLanguageInputs__InputsAssignment_3 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9192:1: ( ( ruleIntentInput ) )
            // InternalBot.g:9193:2: ( ruleIntentInput )
            {
            // InternalBot.g:9193:2: ( ruleIntentInput )
            // InternalBot.g:9194:3: ruleIntentInput
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
    // InternalBot.g:9203:1: rule__IntentLanguageInputs__InputsAssignment_4_1 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9207:1: ( ( ruleIntentInput ) )
            // InternalBot.g:9208:2: ( ruleIntentInput )
            {
            // InternalBot.g:9208:2: ( ruleIntentInput )
            // InternalBot.g:9209:3: ruleIntentInput
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
    // InternalBot.g:9218:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9222:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9223:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9223:2: ( ( ruleEString ) )
            // InternalBot.g:9224:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:9225:3: ( ruleEString )
            // InternalBot.g:9226:4: ruleEString
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
    // InternalBot.g:9237:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9241:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:9242:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:9242:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:9243:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:9244:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:9244:4: rule__Transition__TargetAlternatives_2_1_0
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
    // InternalBot.g:9252:1: rule__State__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9256:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9257:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9257:2: ( ( ruleEString ) )
            // InternalBot.g:9258:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:9259:3: ( ruleEString )
            // InternalBot.g:9260:4: ruleEString
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
    // InternalBot.g:9271:1: rule__State__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9275:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9276:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9276:2: ( ( ruleEString ) )
            // InternalBot.g:9277:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:9278:3: ( ruleEString )
            // InternalBot.g:9279:4: ruleEString
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
    // InternalBot.g:9290:1: rule__State__OutcomingAssignment_3_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9294:1: ( ( ruleTransition ) )
            // InternalBot.g:9295:2: ( ruleTransition )
            {
            // InternalBot.g:9295:2: ( ruleTransition )
            // InternalBot.g:9296:3: ruleTransition
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
    // InternalBot.g:9305:1: rule__State2__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9309:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9310:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9310:2: ( ( ruleEString ) )
            // InternalBot.g:9311:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:9312:3: ( ruleEString )
            // InternalBot.g:9313:4: ruleEString
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
    // InternalBot.g:9324:1: rule__State2__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9328:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9329:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9329:2: ( ( ruleEString ) )
            // InternalBot.g:9330:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:9331:3: ( ruleEString )
            // InternalBot.g:9332:4: ruleEString
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
    // InternalBot.g:9343:1: rule__State2__OutcomingAssignment_4_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9347:1: ( ( ruleTransition ) )
            // InternalBot.g:9348:2: ( ruleTransition )
            {
            // InternalBot.g:9348:2: ( ruleTransition )
            // InternalBot.g:9349:3: ruleTransition
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
    // InternalBot.g:9358:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9362:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:9363:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:9363:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:9364:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:9365:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:9365:4: rule__TrainingPhrase__TokensAlternatives_1_0
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
    // InternalBot.g:9373:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9377:1: ( ( ruleEString ) )
            // InternalBot.g:9378:2: ( ruleEString )
            {
            // InternalBot.g:9378:2: ( ruleEString )
            // InternalBot.g:9379:3: ruleEString
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
    // InternalBot.g:9388:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9392:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9393:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9393:2: ( ( ruleEString ) )
            // InternalBot.g:9394:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:9395:3: ( ruleEString )
            // InternalBot.g:9396:4: ruleEString
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
    // InternalBot.g:9407:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9411:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:9412:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:9412:2: ( ruleDefaultEntity )
            // InternalBot.g:9413:3: ruleDefaultEntity
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


    // $ANTLR start "rule__Parameter__IsListAssignment_4_1"
    // InternalBot.g:9422:1: rule__Parameter__IsListAssignment_4_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9426:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:9427:2: ( ( 'isList' ) )
            {
            // InternalBot.g:9427:2: ( ( 'isList' ) )
            // InternalBot.g:9428:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 
            // InternalBot.g:9429:3: ( 'isList' )
            // InternalBot.g:9430:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 

            }

             after(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__IsListAssignment_4_1"


    // $ANTLR start "rule__Parameter__RequiredAssignment_5_1"
    // InternalBot.g:9441:1: rule__Parameter__RequiredAssignment_5_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9445:1: ( ( ( 'required' ) ) )
            // InternalBot.g:9446:2: ( ( 'required' ) )
            {
            // InternalBot.g:9446:2: ( ( 'required' ) )
            // InternalBot.g:9447:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 
            // InternalBot.g:9448:3: ( 'required' )
            // InternalBot.g:9449:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 

            }

             after(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__RequiredAssignment_5_1"


    // $ANTLR start "rule__Parameter__PromptsAssignment_6_1"
    // InternalBot.g:9460:1: rule__Parameter__PromptsAssignment_6_1 : ( rulePromptLanguage ) ;
    public final void rule__Parameter__PromptsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9464:1: ( ( rulePromptLanguage ) )
            // InternalBot.g:9465:2: ( rulePromptLanguage )
            {
            // InternalBot.g:9465:2: ( rulePromptLanguage )
            // InternalBot.g:9466:3: rulePromptLanguage
            {
             before(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            rulePromptLanguage();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__PromptsAssignment_6_1"


    // $ANTLR start "rule__Parameter2__NameAssignment_0"
    // InternalBot.g:9475:1: rule__Parameter2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9479:1: ( ( ruleEString ) )
            // InternalBot.g:9480:2: ( ruleEString )
            {
            // InternalBot.g:9480:2: ( ruleEString )
            // InternalBot.g:9481:3: ruleEString
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
    // InternalBot.g:9490:1: rule__PromptLanguage__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__PromptLanguage__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9494:1: ( ( ruleLanguage ) )
            // InternalBot.g:9495:2: ( ruleLanguage )
            {
            // InternalBot.g:9495:2: ( ruleLanguage )
            // InternalBot.g:9496:3: ruleLanguage
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
    // InternalBot.g:9505:1: rule__PromptLanguage__PromptsAssignment_3 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9509:1: ( ( ruleEString ) )
            // InternalBot.g:9510:2: ( ruleEString )
            {
            // InternalBot.g:9510:2: ( ruleEString )
            // InternalBot.g:9511:3: ruleEString
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
    // InternalBot.g:9520:1: rule__PromptLanguage__PromptsAssignment_4_1 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9524:1: ( ( ruleEString ) )
            // InternalBot.g:9525:2: ( ruleEString )
            {
            // InternalBot.g:9525:2: ( ruleEString )
            // InternalBot.g:9526:3: ruleEString
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
    // InternalBot.g:9535:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9539:1: ( ( ruleEString ) )
            // InternalBot.g:9540:2: ( ruleEString )
            {
            // InternalBot.g:9540:2: ( ruleEString )
            // InternalBot.g:9541:3: ruleEString
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


    // $ANTLR start "rule__EntityToken__EntityAssignment_1"
    // InternalBot.g:9550:1: rule__EntityToken__EntityAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9554:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9555:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9555:2: ( ( ruleEString ) )
            // InternalBot.g:9556:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 
            // InternalBot.g:9557:3: ( ruleEString )
            // InternalBot.g:9558:4: ruleEString
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEntityTokenAccess().getEntityEntityEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EntityToken__EntityAssignment_1"


    // $ANTLR start "rule__ParameterToken__ParameterAssignment_1"
    // InternalBot.g:9569:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9573:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9574:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9574:2: ( ( ruleEString ) )
            // InternalBot.g:9575:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:9576:3: ( ruleEString )
            // InternalBot.g:9577:4: ruleEString
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
    // InternalBot.g:9588:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9592:1: ( ( ruleEString ) )
            // InternalBot.g:9593:2: ( ruleEString )
            {
            // InternalBot.g:9593:2: ( ruleEString )
            // InternalBot.g:9594:3: ruleEString
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
    // InternalBot.g:9603:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9607:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9608:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9608:2: ( ( ruleEString ) )
            // InternalBot.g:9609:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:9610:3: ( ruleEString )
            // InternalBot.g:9611:4: ruleEString
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
    // InternalBot.g:9622:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9626:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:9627:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:9627:2: ( ruleHTTPReturnType )
            // InternalBot.g:9628:3: ruleHTTPReturnType
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
    // InternalBot.g:9637:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9641:1: ( ( ruleEString ) )
            // InternalBot.g:9642:2: ( ruleEString )
            {
            // InternalBot.g:9642:2: ( ruleEString )
            // InternalBot.g:9643:3: ruleEString
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


    // $ANTLR start "rule__SimpleEntity__NameAssignment_2"
    // InternalBot.g:9652:1: rule__SimpleEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__SimpleEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9656:1: ( ( ruleEString ) )
            // InternalBot.g:9657:2: ( ruleEString )
            {
            // InternalBot.g:9657:2: ( ruleEString )
            // InternalBot.g:9658:3: ruleEString
            {
             before(grammarAccess.getSimpleEntityAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleEntityAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEntity__NameAssignment_2"


    // $ANTLR start "rule__SimpleEntity__InputsAssignment_4"
    // InternalBot.g:9667:1: rule__SimpleEntity__InputsAssignment_4 : ( ruleSLanguageInput ) ;
    public final void rule__SimpleEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9671:1: ( ( ruleSLanguageInput ) )
            // InternalBot.g:9672:2: ( ruleSLanguageInput )
            {
            // InternalBot.g:9672:2: ( ruleSLanguageInput )
            // InternalBot.g:9673:3: ruleSLanguageInput
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsSLanguageInputParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleSLanguageInput();

            state._fsp--;

             after(grammarAccess.getSimpleEntityAccess().getInputsSLanguageInputParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleEntity__InputsAssignment_4"


    // $ANTLR start "rule__ComplexEntity__NameAssignment_2"
    // InternalBot.g:9682:1: rule__ComplexEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__ComplexEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9686:1: ( ( ruleEString ) )
            // InternalBot.g:9687:2: ( ruleEString )
            {
            // InternalBot.g:9687:2: ( ruleEString )
            // InternalBot.g:9688:3: ruleEString
            {
             before(grammarAccess.getComplexEntityAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getComplexEntityAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEntity__NameAssignment_2"


    // $ANTLR start "rule__ComplexEntity__InputsAssignment_4"
    // InternalBot.g:9697:1: rule__ComplexEntity__InputsAssignment_4 : ( ruleCLanguageInput ) ;
    public final void rule__ComplexEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9701:1: ( ( ruleCLanguageInput ) )
            // InternalBot.g:9702:2: ( ruleCLanguageInput )
            {
            // InternalBot.g:9702:2: ( ruleCLanguageInput )
            // InternalBot.g:9703:3: ruleCLanguageInput
            {
             before(grammarAccess.getComplexEntityAccess().getInputsCLanguageInputParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleCLanguageInput();

            state._fsp--;

             after(grammarAccess.getComplexEntityAccess().getInputsCLanguageInputParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComplexEntity__InputsAssignment_4"


    // $ANTLR start "rule__RegexEntity__NameAssignment_2"
    // InternalBot.g:9712:1: rule__RegexEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__RegexEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9716:1: ( ( ruleEString ) )
            // InternalBot.g:9717:2: ( ruleEString )
            {
            // InternalBot.g:9717:2: ( ruleEString )
            // InternalBot.g:9718:3: ruleEString
            {
             before(grammarAccess.getRegexEntityAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRegexEntityAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexEntity__NameAssignment_2"


    // $ANTLR start "rule__RegexEntity__InputsAssignment_4"
    // InternalBot.g:9727:1: rule__RegexEntity__InputsAssignment_4 : ( ruleRLanguageInput ) ;
    public final void rule__RegexEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9731:1: ( ( ruleRLanguageInput ) )
            // InternalBot.g:9732:2: ( ruleRLanguageInput )
            {
            // InternalBot.g:9732:2: ( ruleRLanguageInput )
            // InternalBot.g:9733:3: ruleRLanguageInput
            {
             before(grammarAccess.getRegexEntityAccess().getInputsRLanguageInputParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleRLanguageInput();

            state._fsp--;

             after(grammarAccess.getRegexEntityAccess().getInputsRLanguageInputParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RegexEntity__InputsAssignment_4"


    // $ANTLR start "rule__SLanguageInput__LanguageAssignment_0_2"
    // InternalBot.g:9742:1: rule__SLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__SLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9746:1: ( ( ruleLanguage ) )
            // InternalBot.g:9747:2: ( ruleLanguage )
            {
            // InternalBot.g:9747:2: ( ruleLanguage )
            // InternalBot.g:9748:3: ruleLanguage
            {
             before(grammarAccess.getSLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getSLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__LanguageAssignment_0_2"


    // $ANTLR start "rule__SLanguageInput__InputsAssignment_2_0"
    // InternalBot.g:9757:1: rule__SLanguageInput__InputsAssignment_2_0 : ( ruleSimpleInput ) ;
    public final void rule__SLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9761:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:9762:2: ( ruleSimpleInput )
            {
            // InternalBot.g:9762:2: ( ruleSimpleInput )
            // InternalBot.g:9763:3: ruleSimpleInput
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__InputsAssignment_2_0"


    // $ANTLR start "rule__SLanguageInput__InputsAssignment_2_1"
    // InternalBot.g:9772:1: rule__SLanguageInput__InputsAssignment_2_1 : ( ruleSimpleInput ) ;
    public final void rule__SLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9776:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:9777:2: ( ruleSimpleInput )
            {
            // InternalBot.g:9777:2: ( ruleSimpleInput )
            // InternalBot.g:9778:3: ruleSimpleInput
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleInput();

            state._fsp--;

             after(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SLanguageInput__InputsAssignment_2_1"


    // $ANTLR start "rule__CLanguageInput__LanguageAssignment_0_2"
    // InternalBot.g:9787:1: rule__CLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__CLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9791:1: ( ( ruleLanguage ) )
            // InternalBot.g:9792:2: ( ruleLanguage )
            {
            // InternalBot.g:9792:2: ( ruleLanguage )
            // InternalBot.g:9793:3: ruleLanguage
            {
             before(grammarAccess.getCLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getCLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__LanguageAssignment_0_2"


    // $ANTLR start "rule__CLanguageInput__InputsAssignment_2_0"
    // InternalBot.g:9802:1: rule__CLanguageInput__InputsAssignment_2_0 : ( ruleCompositeInput ) ;
    public final void rule__CLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9806:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:9807:2: ( ruleCompositeInput )
            {
            // InternalBot.g:9807:2: ( ruleCompositeInput )
            // InternalBot.g:9808:3: ruleCompositeInput
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__InputsAssignment_2_0"


    // $ANTLR start "rule__CLanguageInput__InputsAssignment_2_1"
    // InternalBot.g:9817:1: rule__CLanguageInput__InputsAssignment_2_1 : ( ruleCompositeInput ) ;
    public final void rule__CLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9821:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:9822:2: ( ruleCompositeInput )
            {
            // InternalBot.g:9822:2: ( ruleCompositeInput )
            // InternalBot.g:9823:3: ruleCompositeInput
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCompositeInput();

            state._fsp--;

             after(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CLanguageInput__InputsAssignment_2_1"


    // $ANTLR start "rule__RLanguageInput__LanguageAssignment_0_2"
    // InternalBot.g:9832:1: rule__RLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__RLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9836:1: ( ( ruleLanguage ) )
            // InternalBot.g:9837:2: ( ruleLanguage )
            {
            // InternalBot.g:9837:2: ( ruleLanguage )
            // InternalBot.g:9838:3: ruleLanguage
            {
             before(grammarAccess.getRLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getRLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__LanguageAssignment_0_2"


    // $ANTLR start "rule__RLanguageInput__InputsAssignment_2_0"
    // InternalBot.g:9847:1: rule__RLanguageInput__InputsAssignment_2_0 : ( ruleRegexInput ) ;
    public final void rule__RLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9851:1: ( ( ruleRegexInput ) )
            // InternalBot.g:9852:2: ( ruleRegexInput )
            {
            // InternalBot.g:9852:2: ( ruleRegexInput )
            // InternalBot.g:9853:3: ruleRegexInput
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleRegexInput();

            state._fsp--;

             after(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__InputsAssignment_2_0"


    // $ANTLR start "rule__RLanguageInput__InputsAssignment_2_1"
    // InternalBot.g:9862:1: rule__RLanguageInput__InputsAssignment_2_1 : ( ruleRegexInput ) ;
    public final void rule__RLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9866:1: ( ( ruleRegexInput ) )
            // InternalBot.g:9867:2: ( ruleRegexInput )
            {
            // InternalBot.g:9867:2: ( ruleRegexInput )
            // InternalBot.g:9868:3: ruleRegexInput
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleRegexInput();

            state._fsp--;

             after(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RLanguageInput__InputsAssignment_2_1"


    // $ANTLR start "rule__RegexInput__ExpresionAssignment_3"
    // InternalBot.g:9877:1: rule__RegexInput__ExpresionAssignment_3 : ( ruleEString ) ;
    public final void rule__RegexInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9881:1: ( ( ruleEString ) )
            // InternalBot.g:9882:2: ( ruleEString )
            {
            // InternalBot.g:9882:2: ( ruleEString )
            // InternalBot.g:9883:3: ruleEString
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
    // InternalBot.g:9892:1: rule__CompositeInput__ExpresionAssignment_3 : ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) ;
    public final void rule__CompositeInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9896:1: ( ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) )
            // InternalBot.g:9897:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            {
            // InternalBot.g:9897:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            // InternalBot.g:9898:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAlternatives_3_0()); 
            // InternalBot.g:9899:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            // InternalBot.g:9899:4: rule__CompositeInput__ExpresionAlternatives_3_0
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


    // $ANTLR start "rule__SimpleInput__NameAssignment_1"
    // InternalBot.g:9907:1: rule__SimpleInput__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9911:1: ( ( ruleEString ) )
            // InternalBot.g:9912:2: ( ruleEString )
            {
            // InternalBot.g:9912:2: ( ruleEString )
            // InternalBot.g:9913:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__NameAssignment_1"


    // $ANTLR start "rule__SimpleInput__ValuesAssignment_2_1"
    // InternalBot.g:9922:1: rule__SimpleInput__ValuesAssignment_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9926:1: ( ( ruleEString ) )
            // InternalBot.g:9927:2: ( ruleEString )
            {
            // InternalBot.g:9927:2: ( ruleEString )
            // InternalBot.g:9928:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__ValuesAssignment_2_1"


    // $ANTLR start "rule__SimpleInput__ValuesAssignment_2_2_1"
    // InternalBot.g:9937:1: rule__SimpleInput__ValuesAssignment_2_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9941:1: ( ( ruleEString ) )
            // InternalBot.g:9942:2: ( ruleEString )
            {
            // InternalBot.g:9942:2: ( ruleEString )
            // InternalBot.g:9943:3: ruleEString
            {
             before(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SimpleInput__ValuesAssignment_2_2_1"


    // $ANTLR start "rule__Text__NameAssignment_2"
    // InternalBot.g:9952:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9956:1: ( ( ruleEString ) )
            // InternalBot.g:9957:2: ( ruleEString )
            {
            // InternalBot.g:9957:2: ( ruleEString )
            // InternalBot.g:9958:3: ruleEString
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
    // InternalBot.g:9967:1: rule__Text__InputsAssignment_4 : ( ruleTextLanguageInput ) ;
    public final void rule__Text__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9971:1: ( ( ruleTextLanguageInput ) )
            // InternalBot.g:9972:2: ( ruleTextLanguageInput )
            {
            // InternalBot.g:9972:2: ( ruleTextLanguageInput )
            // InternalBot.g:9973:3: ruleTextLanguageInput
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
    // InternalBot.g:9982:1: rule__TextLanguageInput__LanguageAssignment_0_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInput__LanguageAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9986:1: ( ( ruleLanguage ) )
            // InternalBot.g:9987:2: ( ruleLanguage )
            {
            // InternalBot.g:9987:2: ( ruleLanguage )
            // InternalBot.g:9988:3: ruleLanguage
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
    // InternalBot.g:9997:1: rule__TextLanguageInput__InputsAssignment_2 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10001:1: ( ( ruleTextInputText ) )
            // InternalBot.g:10002:2: ( ruleTextInputText )
            {
            // InternalBot.g:10002:2: ( ruleTextInputText )
            // InternalBot.g:10003:3: ruleTextInputText
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
    // InternalBot.g:10012:1: rule__TextLanguageInput__InputsAssignment_3_1 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10016:1: ( ( ruleTextInputText ) )
            // InternalBot.g:10017:2: ( ruleTextInputText )
            {
            // InternalBot.g:10017:2: ( ruleTextInputText )
            // InternalBot.g:10018:3: ruleTextInputText
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
    // InternalBot.g:10027:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10031:1: ( ( ruleEString ) )
            // InternalBot.g:10032:2: ( ruleEString )
            {
            // InternalBot.g:10032:2: ( ruleEString )
            // InternalBot.g:10033:3: ruleEString
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


    // $ANTLR start "rule__HTTPResponse__HTTPRequestAssignment_5"
    // InternalBot.g:10042:1: rule__HTTPResponse__HTTPRequestAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10046:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10047:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10047:2: ( ( ruleEString ) )
            // InternalBot.g:10048:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_5_0()); 
            // InternalBot.g:10049:3: ( ruleEString )
            // InternalBot.g:10050:4: ruleEString
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__HTTPRequestAssignment_5"


    // $ANTLR start "rule__HTTPResponse__InputsAssignment_7"
    // InternalBot.g:10061:1: rule__HTTPResponse__InputsAssignment_7 : ( ruleTextLanguageInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10065:1: ( ( ruleTextLanguageInputHttpResponse ) )
            // InternalBot.g:10066:2: ( ruleTextLanguageInputHttpResponse )
            {
            // InternalBot.g:10066:2: ( ruleTextLanguageInputHttpResponse )
            // InternalBot.g:10067:3: ruleTextLanguageInputHttpResponse
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleTextLanguageInputHttpResponse();

            state._fsp--;

             after(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPResponse__InputsAssignment_7"


    // $ANTLR start "rule__HTTPRequest__MethodAssignment_1"
    // InternalBot.g:10076:1: rule__HTTPRequest__MethodAssignment_1 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10080:1: ( ( ruleMethod ) )
            // InternalBot.g:10081:2: ( ruleMethod )
            {
            // InternalBot.g:10081:2: ( ruleMethod )
            // InternalBot.g:10082:3: ruleMethod
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMethod();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__MethodAssignment_1"


    // $ANTLR start "rule__HTTPRequest__NameAssignment_2"
    // InternalBot.g:10091:1: rule__HTTPRequest__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10095:1: ( ( ruleEString ) )
            // InternalBot.g:10096:2: ( ruleEString )
            {
            // InternalBot.g:10096:2: ( ruleEString )
            // InternalBot.g:10097:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__NameAssignment_2"


    // $ANTLR start "rule__HTTPRequest__URLAssignment_6"
    // InternalBot.g:10106:1: rule__HTTPRequest__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10110:1: ( ( ruleEString ) )
            // InternalBot.g:10111:2: ( ruleEString )
            {
            // InternalBot.g:10111:2: ( ruleEString )
            // InternalBot.g:10112:3: ruleEString
            {
             before(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__URLAssignment_6"


    // $ANTLR start "rule__HTTPRequest__BasicAuthAssignment_8_2"
    // InternalBot.g:10121:1: rule__HTTPRequest__BasicAuthAssignment_8_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10125:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10126:2: ( ruleKeyValue )
            {
            // InternalBot.g:10126:2: ( ruleKeyValue )
            // InternalBot.g:10127:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__BasicAuthAssignment_8_2"


    // $ANTLR start "rule__HTTPRequest__HeadersAssignment_9_2"
    // InternalBot.g:10136:1: rule__HTTPRequest__HeadersAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10140:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10141:2: ( ruleKeyValue )
            {
            // InternalBot.g:10141:2: ( ruleKeyValue )
            // InternalBot.g:10142:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__HeadersAssignment_9_2"


    // $ANTLR start "rule__HTTPRequest__HeadersAssignment_9_3_1"
    // InternalBot.g:10151:1: rule__HTTPRequest__HeadersAssignment_9_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_9_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10155:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10156:2: ( ruleKeyValue )
            {
            // InternalBot.g:10156:2: ( ruleKeyValue )
            // InternalBot.g:10157:3: ruleKeyValue
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleKeyValue();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__HeadersAssignment_9_3_1"


    // $ANTLR start "rule__HTTPRequest__DataAssignment_10_2"
    // InternalBot.g:10166:1: rule__HTTPRequest__DataAssignment_10_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10170:1: ( ( ruleData ) )
            // InternalBot.g:10171:2: ( ruleData )
            {
            // InternalBot.g:10171:2: ( ruleData )
            // InternalBot.g:10172:3: ruleData
            {
             before(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataAssignment_10_2"


    // $ANTLR start "rule__HTTPRequest__DataAssignment_10_3_1"
    // InternalBot.g:10181:1: rule__HTTPRequest__DataAssignment_10_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10185:1: ( ( ruleData ) )
            // InternalBot.g:10186:2: ( ruleData )
            {
            // InternalBot.g:10186:2: ( ruleData )
            // InternalBot.g:10187:3: ruleData
            {
             before(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleData();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataAssignment_10_3_1"


    // $ANTLR start "rule__HTTPRequest__DataTypeAssignment_10_7"
    // InternalBot.g:10196:1: rule__HTTPRequest__DataTypeAssignment_10_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_10_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10200:1: ( ( ruleDataType ) )
            // InternalBot.g:10201:2: ( ruleDataType )
            {
            // InternalBot.g:10201:2: ( ruleDataType )
            // InternalBot.g:10202:3: ruleDataType
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_10_7_0()); 
            pushFollow(FOLLOW_2);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_10_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__HTTPRequest__DataTypeAssignment_10_7"


    // $ANTLR start "rule__Image__NameAssignment_2"
    // InternalBot.g:10211:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10215:1: ( ( ruleEString ) )
            // InternalBot.g:10216:2: ( ruleEString )
            {
            // InternalBot.g:10216:2: ( ruleEString )
            // InternalBot.g:10217:3: ruleEString
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
    // InternalBot.g:10226:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10230:1: ( ( ruleEString ) )
            // InternalBot.g:10231:2: ( ruleEString )
            {
            // InternalBot.g:10231:2: ( ruleEString )
            // InternalBot.g:10232:3: ruleEString
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


    // $ANTLR start "rule__Image__CaptionAssignment_7_2"
    // InternalBot.g:10241:1: rule__Image__CaptionAssignment_7_2 : ( ruleEString ) ;
    public final void rule__Image__CaptionAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10245:1: ( ( ruleEString ) )
            // InternalBot.g:10246:2: ( ruleEString )
            {
            // InternalBot.g:10246:2: ( ruleEString )
            // InternalBot.g:10247:3: ruleEString
            {
             before(grammarAccess.getImageAccess().getCaptionEStringParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImageAccess().getCaptionEStringParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Image__CaptionAssignment_7_2"


    // $ANTLR start "rule__Empty__NameAssignment_2"
    // InternalBot.g:10256:1: rule__Empty__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Empty__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10260:1: ( ( ruleEString ) )
            // InternalBot.g:10261:2: ( ruleEString )
            {
            // InternalBot.g:10261:2: ( ruleEString )
            // InternalBot.g:10262:3: ruleEString
            {
             before(grammarAccess.getEmptyAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEmptyAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Empty__NameAssignment_2"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"
    // InternalBot.g:10271:1: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10275:1: ( ( ruleLanguage ) )
            // InternalBot.g:10276:2: ( ruleLanguage )
            {
            // InternalBot.g:10276:2: ( ruleLanguage )
            // InternalBot.g:10277:3: ruleLanguage
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
    // InternalBot.g:10286:1: rule__TextLanguageInputHttpResponse__InputsAssignment_3 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10290:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:10291:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:10291:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:10292:3: ruleTextInputHttpResponse
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
    // InternalBot.g:10301:1: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10305:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:10306:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:10306:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:10307:3: ruleTextInputHttpResponse
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
    // InternalBot.g:10316:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10320:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:10321:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:10321:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:10322:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:10323:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:10323:4: rule__TextInputHttpResponse__TokensAlternatives_0
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
    // InternalBot.g:10331:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10335:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:10336:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:10336:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:10337:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:10338:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:10338:4: rule__TextInputText__TokensAlternatives_0
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
    // InternalBot.g:10346:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10350:1: ( ( ruleEString ) )
            // InternalBot.g:10351:2: ( ruleEString )
            {
            // InternalBot.g:10351:2: ( ruleEString )
            // InternalBot.g:10352:3: ruleEString
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
    // InternalBot.g:10361:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10365:1: ( ( ruleLiteral ) )
            // InternalBot.g:10366:2: ( ruleLiteral )
            {
            // InternalBot.g:10366:2: ( ruleLiteral )
            // InternalBot.g:10367:3: ruleLiteral
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
    // InternalBot.g:10376:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10380:1: ( ( ruleEString ) )
            // InternalBot.g:10381:2: ( ruleEString )
            {
            // InternalBot.g:10381:2: ( ruleEString )
            // InternalBot.g:10382:3: ruleEString
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
    // InternalBot.g:10391:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10395:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:10396:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:10396:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:10397:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:10398:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:10398:4: rule__Data__ValueAlternatives_2_0
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


    protected DFA6 dfa6 = new DFA6(this);
    static final String dfa_1s = "\11\uffff";
    static final String dfa_2s = "\2\uffff\2\6\3\uffff\2\6";
    static final String dfa_3s = "\1\102\1\4\2\66\1\4\2\uffff\2\66";
    static final String dfa_4s = "\1\102\1\5\2\101\1\5\2\uffff\2\101";
    static final String dfa_5s = "\5\uffff\1\2\1\1\2\uffff";
    static final String dfa_6s = "\11\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\1\3",
            "\1\4\3\uffff\1\6\2\uffff\1\5\3\uffff\1\6",
            "\1\4\3\uffff\1\6\2\uffff\1\5\3\uffff\1\6",
            "\1\7\1\10",
            "",
            "",
            "\1\4\3\uffff\1\6\2\uffff\1\5\3\uffff\1\6",
            "\1\4\3\uffff\1\6\2\uffff\1\5\3\uffff\1\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1252:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000420L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00001FFFFFF80000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x01A0000000000030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000007000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020800L,0x0000000004180000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020802L,0x0000000004180000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0008000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xA000000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000030L,0x0000000000008100L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x2040000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000100L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000000000000F830L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0440000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000070800L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000032L,0x0000000000008100L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000080L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000080L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000020L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000040000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000420L});

}