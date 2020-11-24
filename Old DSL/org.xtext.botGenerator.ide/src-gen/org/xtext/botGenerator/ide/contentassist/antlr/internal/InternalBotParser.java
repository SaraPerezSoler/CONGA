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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'text'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language'", "':'", "'intents'", "'flows'", "','", "'entities'", "'actions'", "'-'", "';'", "'parameters'", "'inputs'", "'{'", "'}'", "'in'", "'user'", "'=>'", "'chatbot'", "'entity'", "'prompts'", "'['", "']'", "'@'", "'('", "')'", "'request.'", "'.'", "'Simple'", "'Composite'", "'Regex'", "'pattern'", "'composite'", "'synonyms'", "'response'", "'Response'", "'Request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'caption'", "'Fallback'", "'isList'", "'required'"
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


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:928:1: entryRuleTextLanguageInputHttpResponse : ruleTextLanguageInputHttpResponse EOF ;
    public final void entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:929:1: ( ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:930:1: ruleTextLanguageInputHttpResponse EOF
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
    // InternalBot.g:937:1: ruleTextLanguageInputHttpResponse : ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) ;
    public final void ruleTextLanguageInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:941:2: ( ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) )
            // InternalBot.g:942:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            {
            // InternalBot.g:942:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            // InternalBot.g:943:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 
            // InternalBot.g:944:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            // InternalBot.g:944:4: rule__TextLanguageInputHttpResponse__Group__0
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
    // InternalBot.g:953:1: entryRuleTextInputHttpResponse : ruleTextInputHttpResponse EOF ;
    public final void entryRuleTextInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:954:1: ( ruleTextInputHttpResponse EOF )
            // InternalBot.g:955:1: ruleTextInputHttpResponse EOF
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
    // InternalBot.g:962:1: ruleTextInputHttpResponse : ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) ;
    public final void ruleTextInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:966:2: ( ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) )
            // InternalBot.g:967:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            {
            // InternalBot.g:967:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            // InternalBot.g:968:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            {
            // InternalBot.g:968:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) )
            // InternalBot.g:969:4: ( rule__TextInputHttpResponse__TokensAssignment )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:970:4: ( rule__TextInputHttpResponse__TokensAssignment )
            // InternalBot.g:970:5: rule__TextInputHttpResponse__TokensAssignment
            {
            pushFollow(FOLLOW_3);
            rule__TextInputHttpResponse__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }

            // InternalBot.g:973:3: ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            // InternalBot.g:974:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:975:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==69||LA1_0==74) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:975:5: rule__TextInputHttpResponse__TokensAssignment
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
    // InternalBot.g:985:1: entryRuleTextInputText : ruleTextInputText EOF ;
    public final void entryRuleTextInputText() throws RecognitionException {
        try {
            // InternalBot.g:986:1: ( ruleTextInputText EOF )
            // InternalBot.g:987:1: ruleTextInputText EOF
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
    // InternalBot.g:994:1: ruleTextInputText : ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) ;
    public final void ruleTextInputText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:998:2: ( ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) )
            // InternalBot.g:999:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            {
            // InternalBot.g:999:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            // InternalBot.g:1000:3: ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* )
            {
            // InternalBot.g:1000:3: ( ( rule__TextInputText__TokensAssignment ) )
            // InternalBot.g:1001:4: ( rule__TextInputText__TokensAssignment )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:1002:4: ( rule__TextInputText__TokensAssignment )
            // InternalBot.g:1002:5: rule__TextInputText__TokensAssignment
            {
            pushFollow(FOLLOW_4);
            rule__TextInputText__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }

            // InternalBot.g:1005:3: ( ( rule__TextInputText__TokensAssignment )* )
            // InternalBot.g:1006:4: ( rule__TextInputText__TokensAssignment )*
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:1007:4: ( rule__TextInputText__TokensAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==69) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:1007:5: rule__TextInputText__TokensAssignment
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
    // InternalBot.g:1017:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBot.g:1018:1: ( ruleKeyValue EOF )
            // InternalBot.g:1019:1: ruleKeyValue EOF
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
    // InternalBot.g:1026:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1030:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBot.g:1031:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBot.g:1031:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBot.g:1032:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBot.g:1033:3: ( rule__KeyValue__Group__0 )
            // InternalBot.g:1033:4: rule__KeyValue__Group__0
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
    // InternalBot.g:1042:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalBot.g:1043:1: ( ruleData EOF )
            // InternalBot.g:1044:1: ruleData EOF
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
    // InternalBot.g:1051:1: ruleData : ( ( rule__Data__Group__0 ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1055:2: ( ( ( rule__Data__Group__0 ) ) )
            // InternalBot.g:1056:2: ( ( rule__Data__Group__0 ) )
            {
            // InternalBot.g:1056:2: ( ( rule__Data__Group__0 ) )
            // InternalBot.g:1057:3: ( rule__Data__Group__0 )
            {
             before(grammarAccess.getDataAccess().getGroup()); 
            // InternalBot.g:1058:3: ( rule__Data__Group__0 )
            // InternalBot.g:1058:4: rule__Data__Group__0
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
    // InternalBot.g:1067:1: ruleDefaultEntity : ( ( rule__DefaultEntity__Alternatives ) ) ;
    public final void ruleDefaultEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1071:1: ( ( ( rule__DefaultEntity__Alternatives ) ) )
            // InternalBot.g:1072:2: ( ( rule__DefaultEntity__Alternatives ) )
            {
            // InternalBot.g:1072:2: ( ( rule__DefaultEntity__Alternatives ) )
            // InternalBot.g:1073:3: ( rule__DefaultEntity__Alternatives )
            {
             before(grammarAccess.getDefaultEntityAccess().getAlternatives()); 
            // InternalBot.g:1074:3: ( rule__DefaultEntity__Alternatives )
            // InternalBot.g:1074:4: rule__DefaultEntity__Alternatives
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
    // InternalBot.g:1083:1: ruleHTTPReturnType : ( ( rule__HTTPReturnType__Alternatives ) ) ;
    public final void ruleHTTPReturnType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1087:1: ( ( ( rule__HTTPReturnType__Alternatives ) ) )
            // InternalBot.g:1088:2: ( ( rule__HTTPReturnType__Alternatives ) )
            {
            // InternalBot.g:1088:2: ( ( rule__HTTPReturnType__Alternatives ) )
            // InternalBot.g:1089:3: ( rule__HTTPReturnType__Alternatives )
            {
             before(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 
            // InternalBot.g:1090:3: ( rule__HTTPReturnType__Alternatives )
            // InternalBot.g:1090:4: rule__HTTPReturnType__Alternatives
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
    // InternalBot.g:1099:1: ruleLanguage : ( ( rule__Language__Alternatives ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1103:1: ( ( ( rule__Language__Alternatives ) ) )
            // InternalBot.g:1104:2: ( ( rule__Language__Alternatives ) )
            {
            // InternalBot.g:1104:2: ( ( rule__Language__Alternatives ) )
            // InternalBot.g:1105:3: ( rule__Language__Alternatives )
            {
             before(grammarAccess.getLanguageAccess().getAlternatives()); 
            // InternalBot.g:1106:3: ( rule__Language__Alternatives )
            // InternalBot.g:1106:4: rule__Language__Alternatives
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
    // InternalBot.g:1115:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1119:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalBot.g:1120:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalBot.g:1120:2: ( ( rule__DataType__Alternatives ) )
            // InternalBot.g:1121:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalBot.g:1122:3: ( rule__DataType__Alternatives )
            // InternalBot.g:1122:4: rule__DataType__Alternatives
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
    // InternalBot.g:1131:1: ruleMethod : ( ( rule__Method__Alternatives ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1135:1: ( ( ( rule__Method__Alternatives ) ) )
            // InternalBot.g:1136:2: ( ( rule__Method__Alternatives ) )
            {
            // InternalBot.g:1136:2: ( ( rule__Method__Alternatives ) )
            // InternalBot.g:1137:3: ( rule__Method__Alternatives )
            {
             before(grammarAccess.getMethodAccess().getAlternatives()); 
            // InternalBot.g:1138:3: ( rule__Method__Alternatives )
            // InternalBot.g:1138:4: rule__Method__Alternatives
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
    // InternalBot.g:1146:1: rule__Action__Alternatives : ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1150:1: ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) )
            int alt3=4;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalBot.g:1151:2: ( ruleText )
                    {
                    // InternalBot.g:1151:2: ( ruleText )
                    // InternalBot.g:1152:3: ruleText
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
                    // InternalBot.g:1157:2: ( ruleHTTPRequest )
                    {
                    // InternalBot.g:1157:2: ( ruleHTTPRequest )
                    // InternalBot.g:1158:3: ruleHTTPRequest
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
                    // InternalBot.g:1163:2: ( ruleImage )
                    {
                    // InternalBot.g:1163:2: ( ruleImage )
                    // InternalBot.g:1164:3: ruleImage
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
                    // InternalBot.g:1169:2: ( ruleHTTPResponse )
                    {
                    // InternalBot.g:1169:2: ( ruleHTTPResponse )
                    // InternalBot.g:1170:3: ruleHTTPResponse
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
    // InternalBot.g:1179:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1183:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalBot.g:1184:2: ( RULE_STRING )
                    {
                    // InternalBot.g:1184:2: ( RULE_STRING )
                    // InternalBot.g:1185:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1190:2: ( RULE_ID )
                    {
                    // InternalBot.g:1190:2: ( RULE_ID )
                    // InternalBot.g:1191:3: RULE_ID
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
    // InternalBot.g:1200:1: rule__Intent__Alternatives : ( ( ruleIntent1 ) | ( ruleIntent2 ) );
    public final void rule__Intent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1204:1: ( ( ruleIntent1 ) | ( ruleIntent2 ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 90:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==EOF||(LA5_3>=RULE_STRING && LA5_3<=RULE_ID)||LA5_3==53||(LA5_3>=55 && LA5_3<=56)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_3==51) ) {
                        alt5=2;
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
                case 90:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==EOF||(LA5_3>=RULE_STRING && LA5_3<=RULE_ID)||LA5_3==53||(LA5_3>=55 && LA5_3<=56)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_3==51) ) {
                        alt5=2;
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
                    // InternalBot.g:1205:2: ( ruleIntent1 )
                    {
                    // InternalBot.g:1205:2: ( ruleIntent1 )
                    // InternalBot.g:1206:3: ruleIntent1
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
                    // InternalBot.g:1211:2: ( ruleIntent2 )
                    {
                    // InternalBot.g:1211:2: ( ruleIntent2 )
                    // InternalBot.g:1212:3: ruleIntent2
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
    // InternalBot.g:1221:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );
    public final void rule__Transition__TargetAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1225:1: ( ( ruleState ) | ( ruleState2 ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBot.g:1226:2: ( ruleState )
                    {
                    // InternalBot.g:1226:2: ( ruleState )
                    // InternalBot.g:1227:3: ruleState
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
                    // InternalBot.g:1232:2: ( ruleState2 )
                    {
                    // InternalBot.g:1232:2: ( ruleState2 )
                    // InternalBot.g:1233:3: ruleState2
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
    // InternalBot.g:1242:1: rule__IntentInput__Alternatives : ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) );
    public final void rule__IntentInput__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1246:1: ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) )
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
                    // InternalBot.g:1247:2: ( ruleTrainingPhrase )
                    {
                    // InternalBot.g:1247:2: ( ruleTrainingPhrase )
                    // InternalBot.g:1248:3: ruleTrainingPhrase
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
                    // InternalBot.g:1253:2: ( ruleRegexInput )
                    {
                    // InternalBot.g:1253:2: ( ruleRegexInput )
                    // InternalBot.g:1254:3: ruleRegexInput
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
    // InternalBot.g:1263:1: rule__TrainingPhrase__TokensAlternatives_1_0 : ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) );
    public final void rule__TrainingPhrase__TokensAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1267:1: ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) )
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
                    // InternalBot.g:1268:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1268:2: ( ruleLiteral )
                    // InternalBot.g:1269:3: ruleLiteral
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
                    // InternalBot.g:1274:2: ( ruleParameterRefenceToken )
                    {
                    // InternalBot.g:1274:2: ( ruleParameterRefenceToken )
                    // InternalBot.g:1275:3: ruleParameterRefenceToken
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
    // InternalBot.g:1284:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1288:1: ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) )
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
                    // InternalBot.g:1289:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    {
                    // InternalBot.g:1289:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    // InternalBot.g:1290:3: ( rule__Parameter__EntityAssignment_3_0 )
                    {
                     before(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 
                    // InternalBot.g:1291:3: ( rule__Parameter__EntityAssignment_3_0 )
                    // InternalBot.g:1291:4: rule__Parameter__EntityAssignment_3_0
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
                    // InternalBot.g:1295:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    {
                    // InternalBot.g:1295:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    // InternalBot.g:1296:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    {
                     before(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 
                    // InternalBot.g:1297:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    // InternalBot.g:1297:4: rule__Parameter__DefaultEntityAssignment_3_1
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
    // InternalBot.g:1305:1: rule__Entity__Alternatives : ( ( ruleSimpleEntity ) | ( ruleComplexEntity ) | ( ruleRegexEntity ) );
    public final void rule__Entity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1309:1: ( ( ruleSimpleEntity ) | ( ruleComplexEntity ) | ( ruleRegexEntity ) )
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
                    // InternalBot.g:1310:2: ( ruleSimpleEntity )
                    {
                    // InternalBot.g:1310:2: ( ruleSimpleEntity )
                    // InternalBot.g:1311:3: ruleSimpleEntity
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
                    // InternalBot.g:1316:2: ( ruleComplexEntity )
                    {
                    // InternalBot.g:1316:2: ( ruleComplexEntity )
                    // InternalBot.g:1317:3: ruleComplexEntity
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
                    // InternalBot.g:1322:2: ( ruleRegexEntity )
                    {
                    // InternalBot.g:1322:2: ( ruleRegexEntity )
                    // InternalBot.g:1323:3: ruleRegexEntity
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
    // InternalBot.g:1332:1: rule__CompositeInput__ExpresionAlternatives_3_0 : ( ( ruleLiteral ) | ( ruleEntityToken ) );
    public final void rule__CompositeInput__ExpresionAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1336:1: ( ( ruleLiteral ) | ( ruleEntityToken ) )
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
                    // InternalBot.g:1337:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1337:2: ( ruleLiteral )
                    // InternalBot.g:1338:3: ruleLiteral
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
                    // InternalBot.g:1343:2: ( ruleEntityToken )
                    {
                    // InternalBot.g:1343:2: ( ruleEntityToken )
                    // InternalBot.g:1344:3: ruleEntityToken
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
    // InternalBot.g:1353:1: rule__TextInputHttpResponse__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) );
    public final void rule__TextInputHttpResponse__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1357:1: ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) )
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
                    // InternalBot.g:1358:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1358:2: ( ruleLiteral )
                    // InternalBot.g:1359:3: ruleLiteral
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
                    // InternalBot.g:1364:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1364:2: ( ruleParameterToken )
                    // InternalBot.g:1365:3: ruleParameterToken
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
                    // InternalBot.g:1370:2: ( ruleHTTPRequestToken )
                    {
                    // InternalBot.g:1370:2: ( ruleHTTPRequestToken )
                    // InternalBot.g:1371:3: ruleHTTPRequestToken
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
    // InternalBot.g:1380:1: rule__TextInputText__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__TextInputText__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1384:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
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
                    // InternalBot.g:1385:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1385:2: ( ruleLiteral )
                    // InternalBot.g:1386:3: ruleLiteral
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
                    // InternalBot.g:1391:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1391:2: ( ruleParameterToken )
                    // InternalBot.g:1392:3: ruleParameterToken
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
    // InternalBot.g:1401:1: rule__Data__ValueAlternatives_2_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__Data__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1405:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
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
                    // InternalBot.g:1406:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1406:2: ( ruleLiteral )
                    // InternalBot.g:1407:3: ruleLiteral
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
                    // InternalBot.g:1412:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1412:2: ( ruleParameterToken )
                    // InternalBot.g:1413:3: ruleParameterToken
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
    // InternalBot.g:1422:1: rule__DefaultEntity__Alternatives : ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) );
    public final void rule__DefaultEntity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1426:1: ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) )
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
                    // InternalBot.g:1427:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1427:2: ( ( 'text' ) )
                    // InternalBot.g:1428:3: ( 'text' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1429:3: ( 'text' )
                    // InternalBot.g:1429:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1433:2: ( ( 'number' ) )
                    {
                    // InternalBot.g:1433:2: ( ( 'number' ) )
                    // InternalBot.g:1434:3: ( 'number' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalBot.g:1435:3: ( 'number' )
                    // InternalBot.g:1435:4: 'number'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1439:2: ( ( 'date' ) )
                    {
                    // InternalBot.g:1439:2: ( ( 'date' ) )
                    // InternalBot.g:1440:3: ( 'date' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1441:3: ( 'date' )
                    // InternalBot.g:1441:4: 'date'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1445:2: ( ( 'float' ) )
                    {
                    // InternalBot.g:1445:2: ( ( 'float' ) )
                    // InternalBot.g:1446:3: ( 'float' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1447:3: ( 'float' )
                    // InternalBot.g:1447:4: 'float'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1451:2: ( ( 'time' ) )
                    {
                    // InternalBot.g:1451:2: ( ( 'time' ) )
                    // InternalBot.g:1452:3: ( 'time' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1453:3: ( 'time' )
                    // InternalBot.g:1453:4: 'time'
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
    // InternalBot.g:1461:1: rule__HTTPReturnType__Alternatives : ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) );
    public final void rule__HTTPReturnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1465:1: ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) )
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
                    // InternalBot.g:1466:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1466:2: ( ( 'text' ) )
                    // InternalBot.g:1467:3: ( 'text' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1468:3: ( 'text' )
                    // InternalBot.g:1468:4: 'text'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1472:2: ( ( 'status_code' ) )
                    {
                    // InternalBot.g:1472:2: ( ( 'status_code' ) )
                    // InternalBot.g:1473:3: ( 'status_code' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1474:3: ( 'status_code' )
                    // InternalBot.g:1474:4: 'status_code'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1478:2: ( ( 'image' ) )
                    {
                    // InternalBot.g:1478:2: ( ( 'image' ) )
                    // InternalBot.g:1479:3: ( 'image' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1480:3: ( 'image' )
                    // InternalBot.g:1480:4: 'image'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1484:2: ( ( 'data' ) )
                    {
                    // InternalBot.g:1484:2: ( ( 'data' ) )
                    // InternalBot.g:1485:3: ( 'data' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1486:3: ( 'data' )
                    // InternalBot.g:1486:4: 'data'
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
    // InternalBot.g:1494:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1498:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) )
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
                    // InternalBot.g:1499:2: ( ( 'en' ) )
                    {
                    // InternalBot.g:1499:2: ( ( 'en' ) )
                    // InternalBot.g:1500:3: ( 'en' )
                    {
                     before(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1501:3: ( 'en' )
                    // InternalBot.g:1501:4: 'en'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1505:2: ( ( 'es' ) )
                    {
                    // InternalBot.g:1505:2: ( ( 'es' ) )
                    // InternalBot.g:1506:3: ( 'es' )
                    {
                     before(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1507:3: ( 'es' )
                    // InternalBot.g:1507:4: 'es'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1511:2: ( ( 'da' ) )
                    {
                    // InternalBot.g:1511:2: ( ( 'da' ) )
                    // InternalBot.g:1512:3: ( 'da' )
                    {
                     before(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1513:3: ( 'da' )
                    // InternalBot.g:1513:4: 'da'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1517:2: ( ( 'de' ) )
                    {
                    // InternalBot.g:1517:2: ( ( 'de' ) )
                    // InternalBot.g:1518:3: ( 'de' )
                    {
                     before(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1519:3: ( 'de' )
                    // InternalBot.g:1519:4: 'de'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1523:2: ( ( 'fr' ) )
                    {
                    // InternalBot.g:1523:2: ( ( 'fr' ) )
                    // InternalBot.g:1524:3: ( 'fr' )
                    {
                     before(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1525:3: ( 'fr' )
                    // InternalBot.g:1525:4: 'fr'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1529:2: ( ( 'hi' ) )
                    {
                    // InternalBot.g:1529:2: ( ( 'hi' ) )
                    // InternalBot.g:1530:3: ( 'hi' )
                    {
                     before(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 
                    // InternalBot.g:1531:3: ( 'hi' )
                    // InternalBot.g:1531:4: 'hi'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:1535:2: ( ( 'id' ) )
                    {
                    // InternalBot.g:1535:2: ( ( 'id' ) )
                    // InternalBot.g:1536:3: ( 'id' )
                    {
                     before(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 
                    // InternalBot.g:1537:3: ( 'id' )
                    // InternalBot.g:1537:4: 'id'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:1541:2: ( ( 'it' ) )
                    {
                    // InternalBot.g:1541:2: ( ( 'it' ) )
                    // InternalBot.g:1542:3: ( 'it' )
                    {
                     before(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 
                    // InternalBot.g:1543:3: ( 'it' )
                    // InternalBot.g:1543:4: 'it'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:1547:2: ( ( 'ja' ) )
                    {
                    // InternalBot.g:1547:2: ( ( 'ja' ) )
                    // InternalBot.g:1548:3: ( 'ja' )
                    {
                     before(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 
                    // InternalBot.g:1549:3: ( 'ja' )
                    // InternalBot.g:1549:4: 'ja'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:1553:2: ( ( 'ko' ) )
                    {
                    // InternalBot.g:1553:2: ( ( 'ko' ) )
                    // InternalBot.g:1554:3: ( 'ko' )
                    {
                     before(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 
                    // InternalBot.g:1555:3: ( 'ko' )
                    // InternalBot.g:1555:4: 'ko'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:1559:2: ( ( 'nl' ) )
                    {
                    // InternalBot.g:1559:2: ( ( 'nl' ) )
                    // InternalBot.g:1560:3: ( 'nl' )
                    {
                     before(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 
                    // InternalBot.g:1561:3: ( 'nl' )
                    // InternalBot.g:1561:4: 'nl'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:1565:2: ( ( 'no' ) )
                    {
                    // InternalBot.g:1565:2: ( ( 'no' ) )
                    // InternalBot.g:1566:3: ( 'no' )
                    {
                     before(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 
                    // InternalBot.g:1567:3: ( 'no' )
                    // InternalBot.g:1567:4: 'no'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:1571:2: ( ( 'pl' ) )
                    {
                    // InternalBot.g:1571:2: ( ( 'pl' ) )
                    // InternalBot.g:1572:3: ( 'pl' )
                    {
                     before(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 
                    // InternalBot.g:1573:3: ( 'pl' )
                    // InternalBot.g:1573:4: 'pl'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:1577:2: ( ( 'pt' ) )
                    {
                    // InternalBot.g:1577:2: ( ( 'pt' ) )
                    // InternalBot.g:1578:3: ( 'pt' )
                    {
                     before(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 
                    // InternalBot.g:1579:3: ( 'pt' )
                    // InternalBot.g:1579:4: 'pt'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:1583:2: ( ( 'ru' ) )
                    {
                    // InternalBot.g:1583:2: ( ( 'ru' ) )
                    // InternalBot.g:1584:3: ( 'ru' )
                    {
                     before(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 
                    // InternalBot.g:1585:3: ( 'ru' )
                    // InternalBot.g:1585:4: 'ru'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:1589:2: ( ( 'sv' ) )
                    {
                    // InternalBot.g:1589:2: ( ( 'sv' ) )
                    // InternalBot.g:1590:3: ( 'sv' )
                    {
                     before(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 
                    // InternalBot.g:1591:3: ( 'sv' )
                    // InternalBot.g:1591:4: 'sv'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:1595:2: ( ( 'th' ) )
                    {
                    // InternalBot.g:1595:2: ( ( 'th' ) )
                    // InternalBot.g:1596:3: ( 'th' )
                    {
                     before(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 
                    // InternalBot.g:1597:3: ( 'th' )
                    // InternalBot.g:1597:4: 'th'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:1601:2: ( ( 'tr' ) )
                    {
                    // InternalBot.g:1601:2: ( ( 'tr' ) )
                    // InternalBot.g:1602:3: ( 'tr' )
                    {
                     before(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 
                    // InternalBot.g:1603:3: ( 'tr' )
                    // InternalBot.g:1603:4: 'tr'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:1607:2: ( ( 'uk' ) )
                    {
                    // InternalBot.g:1607:2: ( ( 'uk' ) )
                    // InternalBot.g:1608:3: ( 'uk' )
                    {
                     before(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 
                    // InternalBot.g:1609:3: ( 'uk' )
                    // InternalBot.g:1609:4: 'uk'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:1613:2: ( ( 'zh' ) )
                    {
                    // InternalBot.g:1613:2: ( ( 'zh' ) )
                    // InternalBot.g:1614:3: ( 'zh' )
                    {
                     before(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 
                    // InternalBot.g:1615:3: ( 'zh' )
                    // InternalBot.g:1615:4: 'zh'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:1619:2: ( ( 'ar' ) )
                    {
                    // InternalBot.g:1619:2: ( ( 'ar' ) )
                    // InternalBot.g:1620:3: ( 'ar' )
                    {
                     before(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 
                    // InternalBot.g:1621:3: ( 'ar' )
                    // InternalBot.g:1621:4: 'ar'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:1625:2: ( ( 'cz' ) )
                    {
                    // InternalBot.g:1625:2: ( ( 'cz' ) )
                    // InternalBot.g:1626:3: ( 'cz' )
                    {
                     before(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 
                    // InternalBot.g:1627:3: ( 'cz' )
                    // InternalBot.g:1627:4: 'cz'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:1631:2: ( ( 'bu' ) )
                    {
                    // InternalBot.g:1631:2: ( ( 'bu' ) )
                    // InternalBot.g:1632:3: ( 'bu' )
                    {
                     before(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 
                    // InternalBot.g:1633:3: ( 'bu' )
                    // InternalBot.g:1633:4: 'bu'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:1637:2: ( ( 'fi' ) )
                    {
                    // InternalBot.g:1637:2: ( ( 'fi' ) )
                    // InternalBot.g:1638:3: ( 'fi' )
                    {
                     before(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 
                    // InternalBot.g:1639:3: ( 'fi' )
                    // InternalBot.g:1639:4: 'fi'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:1643:2: ( ( 'gr' ) )
                    {
                    // InternalBot.g:1643:2: ( ( 'gr' ) )
                    // InternalBot.g:1644:3: ( 'gr' )
                    {
                     before(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 
                    // InternalBot.g:1645:3: ( 'gr' )
                    // InternalBot.g:1645:4: 'gr'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:1649:2: ( ( 'ba' ) )
                    {
                    // InternalBot.g:1649:2: ( ( 'ba' ) )
                    // InternalBot.g:1650:3: ( 'ba' )
                    {
                     before(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 
                    // InternalBot.g:1651:3: ( 'ba' )
                    // InternalBot.g:1651:4: 'ba'
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
    // InternalBot.g:1659:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1663:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
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
                    // InternalBot.g:1664:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1664:2: ( ( 'JSON' ) )
                    // InternalBot.g:1665:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1666:3: ( 'JSON' )
                    // InternalBot.g:1666:4: 'JSON'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1670:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1670:2: ( ( 'FORM' ) )
                    // InternalBot.g:1671:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1672:3: ( 'FORM' )
                    // InternalBot.g:1672:4: 'FORM'
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
    // InternalBot.g:1680:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1684:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
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
                    // InternalBot.g:1685:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1685:2: ( ( 'post' ) )
                    // InternalBot.g:1686:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1687:3: ( 'post' )
                    // InternalBot.g:1687:4: 'post'
                    {
                    match(input,47,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1691:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1691:2: ( ( 'get' ) )
                    // InternalBot.g:1692:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1693:3: ( 'get' )
                    // InternalBot.g:1693:4: 'get'
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
    // InternalBot.g:1701:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1705:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1706:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
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
    // InternalBot.g:1713:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1717:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1718:1: ( 'Chatbot' )
            {
            // InternalBot.g:1718:1: ( 'Chatbot' )
            // InternalBot.g:1719:2: 'Chatbot'
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
    // InternalBot.g:1728:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1732:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1733:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
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
    // InternalBot.g:1740:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1744:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1745:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1745:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1746:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1747:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1747:3: rule__Bot__NameAssignment_1
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
    // InternalBot.g:1755:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1759:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1760:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
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
    // InternalBot.g:1767:1: rule__Bot__Group__2__Impl : ( 'language' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1771:1: ( ( 'language' ) )
            // InternalBot.g:1772:1: ( 'language' )
            {
            // InternalBot.g:1772:1: ( 'language' )
            // InternalBot.g:1773:2: 'language'
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
    // InternalBot.g:1782:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1786:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1787:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
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
    // InternalBot.g:1794:1: rule__Bot__Group__3__Impl : ( ':' ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1798:1: ( ( ':' ) )
            // InternalBot.g:1799:1: ( ':' )
            {
            // InternalBot.g:1799:1: ( ':' )
            // InternalBot.g:1800:2: ':'
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
    // InternalBot.g:1809:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1813:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1814:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
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
    // InternalBot.g:1821:1: rule__Bot__Group__4__Impl : ( ( rule__Bot__LanguagesAssignment_4 ) ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1825:1: ( ( ( rule__Bot__LanguagesAssignment_4 ) ) )
            // InternalBot.g:1826:1: ( ( rule__Bot__LanguagesAssignment_4 ) )
            {
            // InternalBot.g:1826:1: ( ( rule__Bot__LanguagesAssignment_4 ) )
            // InternalBot.g:1827:2: ( rule__Bot__LanguagesAssignment_4 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_4()); 
            // InternalBot.g:1828:2: ( rule__Bot__LanguagesAssignment_4 )
            // InternalBot.g:1828:3: rule__Bot__LanguagesAssignment_4
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
    // InternalBot.g:1836:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1840:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1841:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
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
    // InternalBot.g:1848:1: rule__Bot__Group__5__Impl : ( ( rule__Bot__Group_5__0 )* ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1852:1: ( ( ( rule__Bot__Group_5__0 )* ) )
            // InternalBot.g:1853:1: ( ( rule__Bot__Group_5__0 )* )
            {
            // InternalBot.g:1853:1: ( ( rule__Bot__Group_5__0 )* )
            // InternalBot.g:1854:2: ( rule__Bot__Group_5__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_5()); 
            // InternalBot.g:1855:2: ( rule__Bot__Group_5__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==54) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalBot.g:1855:3: rule__Bot__Group_5__0
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
    // InternalBot.g:1863:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1867:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:1868:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
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
    // InternalBot.g:1875:1: rule__Bot__Group__6__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1879:1: ( ( 'intents' ) )
            // InternalBot.g:1880:1: ( 'intents' )
            {
            // InternalBot.g:1880:1: ( 'intents' )
            // InternalBot.g:1881:2: 'intents'
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
    // InternalBot.g:1890:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1894:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:1895:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
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
    // InternalBot.g:1902:1: rule__Bot__Group__7__Impl : ( ':' ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1906:1: ( ( ':' ) )
            // InternalBot.g:1907:1: ( ':' )
            {
            // InternalBot.g:1907:1: ( ':' )
            // InternalBot.g:1908:2: ':'
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
    // InternalBot.g:1917:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1921:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:1922:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
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
    // InternalBot.g:1929:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__IntentsAssignment_8 ) ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1933:1: ( ( ( rule__Bot__IntentsAssignment_8 ) ) )
            // InternalBot.g:1934:1: ( ( rule__Bot__IntentsAssignment_8 ) )
            {
            // InternalBot.g:1934:1: ( ( rule__Bot__IntentsAssignment_8 ) )
            // InternalBot.g:1935:2: ( rule__Bot__IntentsAssignment_8 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_8()); 
            // InternalBot.g:1936:2: ( rule__Bot__IntentsAssignment_8 )
            // InternalBot.g:1936:3: rule__Bot__IntentsAssignment_8
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
    // InternalBot.g:1944:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1948:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:1949:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
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
    // InternalBot.g:1956:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__IntentsAssignment_9 )* ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1960:1: ( ( ( rule__Bot__IntentsAssignment_9 )* ) )
            // InternalBot.g:1961:1: ( ( rule__Bot__IntentsAssignment_9 )* )
            {
            // InternalBot.g:1961:1: ( ( rule__Bot__IntentsAssignment_9 )* )
            // InternalBot.g:1962:2: ( rule__Bot__IntentsAssignment_9 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_9()); 
            // InternalBot.g:1963:2: ( rule__Bot__IntentsAssignment_9 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_STRING && LA21_0<=RULE_ID)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:1963:3: rule__Bot__IntentsAssignment_9
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
    // InternalBot.g:1971:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1975:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:1976:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
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
    // InternalBot.g:1983:1: rule__Bot__Group__10__Impl : ( ( rule__Bot__Group_10__0 )? ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1987:1: ( ( ( rule__Bot__Group_10__0 )? ) )
            // InternalBot.g:1988:1: ( ( rule__Bot__Group_10__0 )? )
            {
            // InternalBot.g:1988:1: ( ( rule__Bot__Group_10__0 )? )
            // InternalBot.g:1989:2: ( rule__Bot__Group_10__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_10()); 
            // InternalBot.g:1990:2: ( rule__Bot__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==55) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBot.g:1990:3: rule__Bot__Group_10__0
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
    // InternalBot.g:1998:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2002:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:2003:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
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
    // InternalBot.g:2010:1: rule__Bot__Group__11__Impl : ( ( rule__Bot__Group_11__0 )? ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2014:1: ( ( ( rule__Bot__Group_11__0 )? ) )
            // InternalBot.g:2015:1: ( ( rule__Bot__Group_11__0 )? )
            {
            // InternalBot.g:2015:1: ( ( rule__Bot__Group_11__0 )? )
            // InternalBot.g:2016:2: ( rule__Bot__Group_11__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_11()); 
            // InternalBot.g:2017:2: ( rule__Bot__Group_11__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==56) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBot.g:2017:3: rule__Bot__Group_11__0
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
    // InternalBot.g:2025:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl rule__Bot__Group__13 ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2029:1: ( rule__Bot__Group__12__Impl rule__Bot__Group__13 )
            // InternalBot.g:2030:2: rule__Bot__Group__12__Impl rule__Bot__Group__13
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
    // InternalBot.g:2037:1: rule__Bot__Group__12__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2041:1: ( ( 'flows' ) )
            // InternalBot.g:2042:1: ( 'flows' )
            {
            // InternalBot.g:2042:1: ( 'flows' )
            // InternalBot.g:2043:2: 'flows'
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
    // InternalBot.g:2052:1: rule__Bot__Group__13 : rule__Bot__Group__13__Impl rule__Bot__Group__14 ;
    public final void rule__Bot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2056:1: ( rule__Bot__Group__13__Impl rule__Bot__Group__14 )
            // InternalBot.g:2057:2: rule__Bot__Group__13__Impl rule__Bot__Group__14
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
    // InternalBot.g:2064:1: rule__Bot__Group__13__Impl : ( ':' ) ;
    public final void rule__Bot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2068:1: ( ( ':' ) )
            // InternalBot.g:2069:1: ( ':' )
            {
            // InternalBot.g:2069:1: ( ':' )
            // InternalBot.g:2070:2: ':'
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
    // InternalBot.g:2079:1: rule__Bot__Group__14 : rule__Bot__Group__14__Impl ;
    public final void rule__Bot__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2083:1: ( rule__Bot__Group__14__Impl )
            // InternalBot.g:2084:2: rule__Bot__Group__14__Impl
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
    // InternalBot.g:2090:1: rule__Bot__Group__14__Impl : ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) ) ;
    public final void rule__Bot__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2094:1: ( ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) ) )
            // InternalBot.g:2095:1: ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) )
            {
            // InternalBot.g:2095:1: ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) )
            // InternalBot.g:2096:2: ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* )
            {
            // InternalBot.g:2096:2: ( ( rule__Bot__Group_14__0 ) )
            // InternalBot.g:2097:3: ( rule__Bot__Group_14__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_14()); 
            // InternalBot.g:2098:3: ( rule__Bot__Group_14__0 )
            // InternalBot.g:2098:4: rule__Bot__Group_14__0
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_14__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_14()); 

            }

            // InternalBot.g:2101:2: ( ( rule__Bot__Group_14__0 )* )
            // InternalBot.g:2102:3: ( rule__Bot__Group_14__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_14()); 
            // InternalBot.g:2103:3: ( rule__Bot__Group_14__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==57) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:2103:4: rule__Bot__Group_14__0
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
    // InternalBot.g:2113:1: rule__Bot__Group_5__0 : rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1 ;
    public final void rule__Bot__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2117:1: ( rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1 )
            // InternalBot.g:2118:2: rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1
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
    // InternalBot.g:2125:1: rule__Bot__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Bot__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2129:1: ( ( ',' ) )
            // InternalBot.g:2130:1: ( ',' )
            {
            // InternalBot.g:2130:1: ( ',' )
            // InternalBot.g:2131:2: ','
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
    // InternalBot.g:2140:1: rule__Bot__Group_5__1 : rule__Bot__Group_5__1__Impl ;
    public final void rule__Bot__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2144:1: ( rule__Bot__Group_5__1__Impl )
            // InternalBot.g:2145:2: rule__Bot__Group_5__1__Impl
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
    // InternalBot.g:2151:1: rule__Bot__Group_5__1__Impl : ( ( rule__Bot__LanguagesAssignment_5_1 ) ) ;
    public final void rule__Bot__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2155:1: ( ( ( rule__Bot__LanguagesAssignment_5_1 ) ) )
            // InternalBot.g:2156:1: ( ( rule__Bot__LanguagesAssignment_5_1 ) )
            {
            // InternalBot.g:2156:1: ( ( rule__Bot__LanguagesAssignment_5_1 ) )
            // InternalBot.g:2157:2: ( rule__Bot__LanguagesAssignment_5_1 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_5_1()); 
            // InternalBot.g:2158:2: ( rule__Bot__LanguagesAssignment_5_1 )
            // InternalBot.g:2158:3: rule__Bot__LanguagesAssignment_5_1
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
    // InternalBot.g:2167:1: rule__Bot__Group_10__0 : rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 ;
    public final void rule__Bot__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2171:1: ( rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 )
            // InternalBot.g:2172:2: rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1
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
    // InternalBot.g:2179:1: rule__Bot__Group_10__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2183:1: ( ( 'entities' ) )
            // InternalBot.g:2184:1: ( 'entities' )
            {
            // InternalBot.g:2184:1: ( 'entities' )
            // InternalBot.g:2185:2: 'entities'
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
    // InternalBot.g:2194:1: rule__Bot__Group_10__1 : rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 ;
    public final void rule__Bot__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2198:1: ( rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 )
            // InternalBot.g:2199:2: rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2
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
    // InternalBot.g:2206:1: rule__Bot__Group_10__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2210:1: ( ( ':' ) )
            // InternalBot.g:2211:1: ( ':' )
            {
            // InternalBot.g:2211:1: ( ':' )
            // InternalBot.g:2212:2: ':'
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
    // InternalBot.g:2221:1: rule__Bot__Group_10__2 : rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 ;
    public final void rule__Bot__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2225:1: ( rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 )
            // InternalBot.g:2226:2: rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3
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
    // InternalBot.g:2233:1: rule__Bot__Group_10__2__Impl : ( ( rule__Bot__EntitiesAssignment_10_2 ) ) ;
    public final void rule__Bot__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2237:1: ( ( ( rule__Bot__EntitiesAssignment_10_2 ) ) )
            // InternalBot.g:2238:1: ( ( rule__Bot__EntitiesAssignment_10_2 ) )
            {
            // InternalBot.g:2238:1: ( ( rule__Bot__EntitiesAssignment_10_2 ) )
            // InternalBot.g:2239:2: ( rule__Bot__EntitiesAssignment_10_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_10_2()); 
            // InternalBot.g:2240:2: ( rule__Bot__EntitiesAssignment_10_2 )
            // InternalBot.g:2240:3: rule__Bot__EntitiesAssignment_10_2
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
    // InternalBot.g:2248:1: rule__Bot__Group_10__3 : rule__Bot__Group_10__3__Impl ;
    public final void rule__Bot__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2252:1: ( rule__Bot__Group_10__3__Impl )
            // InternalBot.g:2253:2: rule__Bot__Group_10__3__Impl
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
    // InternalBot.g:2259:1: rule__Bot__Group_10__3__Impl : ( ( rule__Bot__EntitiesAssignment_10_3 )* ) ;
    public final void rule__Bot__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2263:1: ( ( ( rule__Bot__EntitiesAssignment_10_3 )* ) )
            // InternalBot.g:2264:1: ( ( rule__Bot__EntitiesAssignment_10_3 )* )
            {
            // InternalBot.g:2264:1: ( ( rule__Bot__EntitiesAssignment_10_3 )* )
            // InternalBot.g:2265:2: ( rule__Bot__EntitiesAssignment_10_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_10_3()); 
            // InternalBot.g:2266:2: ( rule__Bot__EntitiesAssignment_10_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=76 && LA25_0<=78)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBot.g:2266:3: rule__Bot__EntitiesAssignment_10_3
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
    // InternalBot.g:2275:1: rule__Bot__Group_11__0 : rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1 ;
    public final void rule__Bot__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2279:1: ( rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1 )
            // InternalBot.g:2280:2: rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1
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
    // InternalBot.g:2287:1: rule__Bot__Group_11__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2291:1: ( ( 'actions' ) )
            // InternalBot.g:2292:1: ( 'actions' )
            {
            // InternalBot.g:2292:1: ( 'actions' )
            // InternalBot.g:2293:2: 'actions'
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
    // InternalBot.g:2302:1: rule__Bot__Group_11__1 : rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2 ;
    public final void rule__Bot__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2306:1: ( rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2 )
            // InternalBot.g:2307:2: rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2
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
    // InternalBot.g:2314:1: rule__Bot__Group_11__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2318:1: ( ( ':' ) )
            // InternalBot.g:2319:1: ( ':' )
            {
            // InternalBot.g:2319:1: ( ':' )
            // InternalBot.g:2320:2: ':'
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
    // InternalBot.g:2329:1: rule__Bot__Group_11__2 : rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3 ;
    public final void rule__Bot__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2333:1: ( rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3 )
            // InternalBot.g:2334:2: rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3
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
    // InternalBot.g:2341:1: rule__Bot__Group_11__2__Impl : ( ( rule__Bot__ActionsAssignment_11_2 ) ) ;
    public final void rule__Bot__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2345:1: ( ( ( rule__Bot__ActionsAssignment_11_2 ) ) )
            // InternalBot.g:2346:1: ( ( rule__Bot__ActionsAssignment_11_2 ) )
            {
            // InternalBot.g:2346:1: ( ( rule__Bot__ActionsAssignment_11_2 ) )
            // InternalBot.g:2347:2: ( rule__Bot__ActionsAssignment_11_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_11_2()); 
            // InternalBot.g:2348:2: ( rule__Bot__ActionsAssignment_11_2 )
            // InternalBot.g:2348:3: rule__Bot__ActionsAssignment_11_2
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
    // InternalBot.g:2356:1: rule__Bot__Group_11__3 : rule__Bot__Group_11__3__Impl ;
    public final void rule__Bot__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2360:1: ( rule__Bot__Group_11__3__Impl )
            // InternalBot.g:2361:2: rule__Bot__Group_11__3__Impl
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
    // InternalBot.g:2367:1: rule__Bot__Group_11__3__Impl : ( ( rule__Bot__ActionsAssignment_11_3 )* ) ;
    public final void rule__Bot__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2371:1: ( ( ( rule__Bot__ActionsAssignment_11_3 )* ) )
            // InternalBot.g:2372:1: ( ( rule__Bot__ActionsAssignment_11_3 )* )
            {
            // InternalBot.g:2372:1: ( ( rule__Bot__ActionsAssignment_11_3 )* )
            // InternalBot.g:2373:2: ( rule__Bot__ActionsAssignment_11_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_11_3()); 
            // InternalBot.g:2374:2: ( rule__Bot__ActionsAssignment_11_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==11||LA26_0==17||(LA26_0>=83 && LA26_0<=84)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBot.g:2374:3: rule__Bot__ActionsAssignment_11_3
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
    // InternalBot.g:2383:1: rule__Bot__Group_14__0 : rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1 ;
    public final void rule__Bot__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2387:1: ( rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1 )
            // InternalBot.g:2388:2: rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1
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
    // InternalBot.g:2395:1: rule__Bot__Group_14__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2399:1: ( ( '-' ) )
            // InternalBot.g:2400:1: ( '-' )
            {
            // InternalBot.g:2400:1: ( '-' )
            // InternalBot.g:2401:2: '-'
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
    // InternalBot.g:2410:1: rule__Bot__Group_14__1 : rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2 ;
    public final void rule__Bot__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2414:1: ( rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2 )
            // InternalBot.g:2415:2: rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2
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
    // InternalBot.g:2422:1: rule__Bot__Group_14__1__Impl : ( ( rule__Bot__FlowsAssignment_14_1 ) ) ;
    public final void rule__Bot__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2426:1: ( ( ( rule__Bot__FlowsAssignment_14_1 ) ) )
            // InternalBot.g:2427:1: ( ( rule__Bot__FlowsAssignment_14_1 ) )
            {
            // InternalBot.g:2427:1: ( ( rule__Bot__FlowsAssignment_14_1 ) )
            // InternalBot.g:2428:2: ( rule__Bot__FlowsAssignment_14_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_14_1()); 
            // InternalBot.g:2429:2: ( rule__Bot__FlowsAssignment_14_1 )
            // InternalBot.g:2429:3: rule__Bot__FlowsAssignment_14_1
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
    // InternalBot.g:2437:1: rule__Bot__Group_14__2 : rule__Bot__Group_14__2__Impl ;
    public final void rule__Bot__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2441:1: ( rule__Bot__Group_14__2__Impl )
            // InternalBot.g:2442:2: rule__Bot__Group_14__2__Impl
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
    // InternalBot.g:2448:1: rule__Bot__Group_14__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2452:1: ( ( ';' ) )
            // InternalBot.g:2453:1: ( ';' )
            {
            // InternalBot.g:2453:1: ( ';' )
            // InternalBot.g:2454:2: ';'
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
    // InternalBot.g:2464:1: rule__Intent2__Group__0 : rule__Intent2__Group__0__Impl rule__Intent2__Group__1 ;
    public final void rule__Intent2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2468:1: ( rule__Intent2__Group__0__Impl rule__Intent2__Group__1 )
            // InternalBot.g:2469:2: rule__Intent2__Group__0__Impl rule__Intent2__Group__1
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
    // InternalBot.g:2476:1: rule__Intent2__Group__0__Impl : ( ( rule__Intent2__NameAssignment_0 ) ) ;
    public final void rule__Intent2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2480:1: ( ( ( rule__Intent2__NameAssignment_0 ) ) )
            // InternalBot.g:2481:1: ( ( rule__Intent2__NameAssignment_0 ) )
            {
            // InternalBot.g:2481:1: ( ( rule__Intent2__NameAssignment_0 ) )
            // InternalBot.g:2482:2: ( rule__Intent2__NameAssignment_0 )
            {
             before(grammarAccess.getIntent2Access().getNameAssignment_0()); 
            // InternalBot.g:2483:2: ( rule__Intent2__NameAssignment_0 )
            // InternalBot.g:2483:3: rule__Intent2__NameAssignment_0
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
    // InternalBot.g:2491:1: rule__Intent2__Group__1 : rule__Intent2__Group__1__Impl rule__Intent2__Group__2 ;
    public final void rule__Intent2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2495:1: ( rule__Intent2__Group__1__Impl rule__Intent2__Group__2 )
            // InternalBot.g:2496:2: rule__Intent2__Group__1__Impl rule__Intent2__Group__2
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
    // InternalBot.g:2503:1: rule__Intent2__Group__1__Impl : ( ( rule__Intent2__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2507:1: ( ( ( rule__Intent2__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2508:1: ( ( rule__Intent2__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2508:1: ( ( rule__Intent2__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2509:2: ( rule__Intent2__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2510:2: ( rule__Intent2__FallbackIntentAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==90) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalBot.g:2510:3: rule__Intent2__FallbackIntentAssignment_1
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
    // InternalBot.g:2518:1: rule__Intent2__Group__2 : rule__Intent2__Group__2__Impl rule__Intent2__Group__3 ;
    public final void rule__Intent2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2522:1: ( rule__Intent2__Group__2__Impl rule__Intent2__Group__3 )
            // InternalBot.g:2523:2: rule__Intent2__Group__2__Impl rule__Intent2__Group__3
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
    // InternalBot.g:2530:1: rule__Intent2__Group__2__Impl : ( ':' ) ;
    public final void rule__Intent2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2534:1: ( ( ':' ) )
            // InternalBot.g:2535:1: ( ':' )
            {
            // InternalBot.g:2535:1: ( ':' )
            // InternalBot.g:2536:2: ':'
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
    // InternalBot.g:2545:1: rule__Intent2__Group__3 : rule__Intent2__Group__3__Impl rule__Intent2__Group__4 ;
    public final void rule__Intent2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2549:1: ( rule__Intent2__Group__3__Impl rule__Intent2__Group__4 )
            // InternalBot.g:2550:2: rule__Intent2__Group__3__Impl rule__Intent2__Group__4
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
    // InternalBot.g:2557:1: rule__Intent2__Group__3__Impl : ( ( rule__Intent2__InputsAssignment_3 )* ) ;
    public final void rule__Intent2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2561:1: ( ( ( rule__Intent2__InputsAssignment_3 )* ) )
            // InternalBot.g:2562:1: ( ( rule__Intent2__InputsAssignment_3 )* )
            {
            // InternalBot.g:2562:1: ( ( rule__Intent2__InputsAssignment_3 )* )
            // InternalBot.g:2563:2: ( rule__Intent2__InputsAssignment_3 )*
            {
             before(grammarAccess.getIntent2Access().getInputsAssignment_3()); 
            // InternalBot.g:2564:2: ( rule__Intent2__InputsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==60) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBot.g:2564:3: rule__Intent2__InputsAssignment_3
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
    // InternalBot.g:2572:1: rule__Intent2__Group__4 : rule__Intent2__Group__4__Impl ;
    public final void rule__Intent2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2576:1: ( rule__Intent2__Group__4__Impl )
            // InternalBot.g:2577:2: rule__Intent2__Group__4__Impl
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
    // InternalBot.g:2583:1: rule__Intent2__Group__4__Impl : ( ( rule__Intent2__Group_4__0 )? ) ;
    public final void rule__Intent2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2587:1: ( ( ( rule__Intent2__Group_4__0 )? ) )
            // InternalBot.g:2588:1: ( ( rule__Intent2__Group_4__0 )? )
            {
            // InternalBot.g:2588:1: ( ( rule__Intent2__Group_4__0 )? )
            // InternalBot.g:2589:2: ( rule__Intent2__Group_4__0 )?
            {
             before(grammarAccess.getIntent2Access().getGroup_4()); 
            // InternalBot.g:2590:2: ( rule__Intent2__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==59) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:2590:3: rule__Intent2__Group_4__0
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
    // InternalBot.g:2599:1: rule__Intent2__Group_4__0 : rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1 ;
    public final void rule__Intent2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2603:1: ( rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1 )
            // InternalBot.g:2604:2: rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1
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
    // InternalBot.g:2611:1: rule__Intent2__Group_4__0__Impl : ( 'parameters' ) ;
    public final void rule__Intent2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2615:1: ( ( 'parameters' ) )
            // InternalBot.g:2616:1: ( 'parameters' )
            {
            // InternalBot.g:2616:1: ( 'parameters' )
            // InternalBot.g:2617:2: 'parameters'
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
    // InternalBot.g:2626:1: rule__Intent2__Group_4__1 : rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2 ;
    public final void rule__Intent2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2630:1: ( rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2 )
            // InternalBot.g:2631:2: rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2
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
    // InternalBot.g:2638:1: rule__Intent2__Group_4__1__Impl : ( ':' ) ;
    public final void rule__Intent2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2642:1: ( ( ':' ) )
            // InternalBot.g:2643:1: ( ':' )
            {
            // InternalBot.g:2643:1: ( ':' )
            // InternalBot.g:2644:2: ':'
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
    // InternalBot.g:2653:1: rule__Intent2__Group_4__2 : rule__Intent2__Group_4__2__Impl ;
    public final void rule__Intent2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2657:1: ( rule__Intent2__Group_4__2__Impl )
            // InternalBot.g:2658:2: rule__Intent2__Group_4__2__Impl
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
    // InternalBot.g:2664:1: rule__Intent2__Group_4__2__Impl : ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) ) ;
    public final void rule__Intent2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2668:1: ( ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) ) )
            // InternalBot.g:2669:1: ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) )
            {
            // InternalBot.g:2669:1: ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) )
            // InternalBot.g:2670:2: ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* )
            {
            // InternalBot.g:2670:2: ( ( rule__Intent2__Group_4_2__0 ) )
            // InternalBot.g:2671:3: ( rule__Intent2__Group_4_2__0 )
            {
             before(grammarAccess.getIntent2Access().getGroup_4_2()); 
            // InternalBot.g:2672:3: ( rule__Intent2__Group_4_2__0 )
            // InternalBot.g:2672:4: rule__Intent2__Group_4_2__0
            {
            pushFollow(FOLLOW_12);
            rule__Intent2__Group_4_2__0();

            state._fsp--;


            }

             after(grammarAccess.getIntent2Access().getGroup_4_2()); 

            }

            // InternalBot.g:2675:2: ( ( rule__Intent2__Group_4_2__0 )* )
            // InternalBot.g:2676:3: ( rule__Intent2__Group_4_2__0 )*
            {
             before(grammarAccess.getIntent2Access().getGroup_4_2()); 
            // InternalBot.g:2677:3: ( rule__Intent2__Group_4_2__0 )*
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

                    if ( (LA30_3==54) ) {
                        alt30=1;
                    }
                    else if ( (LA30_3==51) ) {
                        int LA30_4 = input.LA(3);

                        if ( (LA30_4==67) ) {
                            alt30=1;
                        }


                    }


                }


                switch (alt30) {
            	case 1 :
            	    // InternalBot.g:2677:4: rule__Intent2__Group_4_2__0
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
    // InternalBot.g:2687:1: rule__Intent2__Group_4_2__0 : rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1 ;
    public final void rule__Intent2__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2691:1: ( rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1 )
            // InternalBot.g:2692:2: rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1
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
    // InternalBot.g:2699:1: rule__Intent2__Group_4_2__0__Impl : ( ( rule__Intent2__ParametersAssignment_4_2_0 )* ) ;
    public final void rule__Intent2__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2703:1: ( ( ( rule__Intent2__ParametersAssignment_4_2_0 )* ) )
            // InternalBot.g:2704:1: ( ( rule__Intent2__ParametersAssignment_4_2_0 )* )
            {
            // InternalBot.g:2704:1: ( ( rule__Intent2__ParametersAssignment_4_2_0 )* )
            // InternalBot.g:2705:2: ( rule__Intent2__ParametersAssignment_4_2_0 )*
            {
             before(grammarAccess.getIntent2Access().getParametersAssignment_4_2_0()); 
            // InternalBot.g:2706:2: ( rule__Intent2__ParametersAssignment_4_2_0 )*
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
            	    // InternalBot.g:2706:3: rule__Intent2__ParametersAssignment_4_2_0
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
    // InternalBot.g:2714:1: rule__Intent2__Group_4_2__1 : rule__Intent2__Group_4_2__1__Impl ;
    public final void rule__Intent2__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2718:1: ( rule__Intent2__Group_4_2__1__Impl )
            // InternalBot.g:2719:2: rule__Intent2__Group_4_2__1__Impl
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
    // InternalBot.g:2725:1: rule__Intent2__Group_4_2__1__Impl : ( ( rule__Intent2__ParametersAssignment_4_2_1 ) ) ;
    public final void rule__Intent2__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2729:1: ( ( ( rule__Intent2__ParametersAssignment_4_2_1 ) ) )
            // InternalBot.g:2730:1: ( ( rule__Intent2__ParametersAssignment_4_2_1 ) )
            {
            // InternalBot.g:2730:1: ( ( rule__Intent2__ParametersAssignment_4_2_1 ) )
            // InternalBot.g:2731:2: ( rule__Intent2__ParametersAssignment_4_2_1 )
            {
             before(grammarAccess.getIntent2Access().getParametersAssignment_4_2_1()); 
            // InternalBot.g:2732:2: ( rule__Intent2__ParametersAssignment_4_2_1 )
            // InternalBot.g:2732:3: rule__Intent2__ParametersAssignment_4_2_1
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
    // InternalBot.g:2741:1: rule__Intent1__Group__0 : rule__Intent1__Group__0__Impl rule__Intent1__Group__1 ;
    public final void rule__Intent1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2745:1: ( rule__Intent1__Group__0__Impl rule__Intent1__Group__1 )
            // InternalBot.g:2746:2: rule__Intent1__Group__0__Impl rule__Intent1__Group__1
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
    // InternalBot.g:2753:1: rule__Intent1__Group__0__Impl : ( ( rule__Intent1__NameAssignment_0 ) ) ;
    public final void rule__Intent1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2757:1: ( ( ( rule__Intent1__NameAssignment_0 ) ) )
            // InternalBot.g:2758:1: ( ( rule__Intent1__NameAssignment_0 ) )
            {
            // InternalBot.g:2758:1: ( ( rule__Intent1__NameAssignment_0 ) )
            // InternalBot.g:2759:2: ( rule__Intent1__NameAssignment_0 )
            {
             before(grammarAccess.getIntent1Access().getNameAssignment_0()); 
            // InternalBot.g:2760:2: ( rule__Intent1__NameAssignment_0 )
            // InternalBot.g:2760:3: rule__Intent1__NameAssignment_0
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
    // InternalBot.g:2768:1: rule__Intent1__Group__1 : rule__Intent1__Group__1__Impl ;
    public final void rule__Intent1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2772:1: ( rule__Intent1__Group__1__Impl )
            // InternalBot.g:2773:2: rule__Intent1__Group__1__Impl
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
    // InternalBot.g:2779:1: rule__Intent1__Group__1__Impl : ( ( rule__Intent1__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2783:1: ( ( ( rule__Intent1__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2784:1: ( ( rule__Intent1__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2784:1: ( ( rule__Intent1__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2785:2: ( rule__Intent1__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2786:2: ( rule__Intent1__FallbackIntentAssignment_1 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==90) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBot.g:2786:3: rule__Intent1__FallbackIntentAssignment_1
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
    // InternalBot.g:2795:1: rule__IntentLanguageInputs__Group__0 : rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 ;
    public final void rule__IntentLanguageInputs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2799:1: ( rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 )
            // InternalBot.g:2800:2: rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1
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
    // InternalBot.g:2807:1: rule__IntentLanguageInputs__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__IntentLanguageInputs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2811:1: ( ( 'inputs' ) )
            // InternalBot.g:2812:1: ( 'inputs' )
            {
            // InternalBot.g:2812:1: ( 'inputs' )
            // InternalBot.g:2813:2: 'inputs'
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
    // InternalBot.g:2822:1: rule__IntentLanguageInputs__Group__1 : rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 ;
    public final void rule__IntentLanguageInputs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2826:1: ( rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 )
            // InternalBot.g:2827:2: rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2
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
    // InternalBot.g:2834:1: rule__IntentLanguageInputs__Group__1__Impl : ( ( rule__IntentLanguageInputs__Group_1__0 )? ) ;
    public final void rule__IntentLanguageInputs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2838:1: ( ( ( rule__IntentLanguageInputs__Group_1__0 )? ) )
            // InternalBot.g:2839:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            {
            // InternalBot.g:2839:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            // InternalBot.g:2840:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 
            // InternalBot.g:2841:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==63) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:2841:3: rule__IntentLanguageInputs__Group_1__0
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
    // InternalBot.g:2849:1: rule__IntentLanguageInputs__Group__2 : rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 ;
    public final void rule__IntentLanguageInputs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2853:1: ( rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 )
            // InternalBot.g:2854:2: rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3
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
    // InternalBot.g:2861:1: rule__IntentLanguageInputs__Group__2__Impl : ( '{' ) ;
    public final void rule__IntentLanguageInputs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2865:1: ( ( '{' ) )
            // InternalBot.g:2866:1: ( '{' )
            {
            // InternalBot.g:2866:1: ( '{' )
            // InternalBot.g:2867:2: '{'
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
    // InternalBot.g:2876:1: rule__IntentLanguageInputs__Group__3 : rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 ;
    public final void rule__IntentLanguageInputs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2880:1: ( rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 )
            // InternalBot.g:2881:2: rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4
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
    // InternalBot.g:2888:1: rule__IntentLanguageInputs__Group__3__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) ;
    public final void rule__IntentLanguageInputs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2892:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) )
            // InternalBot.g:2893:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            {
            // InternalBot.g:2893:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            // InternalBot.g:2894:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 
            // InternalBot.g:2895:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            // InternalBot.g:2895:3: rule__IntentLanguageInputs__InputsAssignment_3
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
    // InternalBot.g:2903:1: rule__IntentLanguageInputs__Group__4 : rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 ;
    public final void rule__IntentLanguageInputs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2907:1: ( rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 )
            // InternalBot.g:2908:2: rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5
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
    // InternalBot.g:2915:1: rule__IntentLanguageInputs__Group__4__Impl : ( ( rule__IntentLanguageInputs__Group_4__0 )* ) ;
    public final void rule__IntentLanguageInputs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2919:1: ( ( ( rule__IntentLanguageInputs__Group_4__0 )* ) )
            // InternalBot.g:2920:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            {
            // InternalBot.g:2920:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            // InternalBot.g:2921:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 
            // InternalBot.g:2922:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==54) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:2922:3: rule__IntentLanguageInputs__Group_4__0
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
    // InternalBot.g:2930:1: rule__IntentLanguageInputs__Group__5 : rule__IntentLanguageInputs__Group__5__Impl ;
    public final void rule__IntentLanguageInputs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2934:1: ( rule__IntentLanguageInputs__Group__5__Impl )
            // InternalBot.g:2935:2: rule__IntentLanguageInputs__Group__5__Impl
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
    // InternalBot.g:2941:1: rule__IntentLanguageInputs__Group__5__Impl : ( '}' ) ;
    public final void rule__IntentLanguageInputs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2945:1: ( ( '}' ) )
            // InternalBot.g:2946:1: ( '}' )
            {
            // InternalBot.g:2946:1: ( '}' )
            // InternalBot.g:2947:2: '}'
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
    // InternalBot.g:2957:1: rule__IntentLanguageInputs__Group_1__0 : rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 ;
    public final void rule__IntentLanguageInputs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2961:1: ( rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 )
            // InternalBot.g:2962:2: rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1
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
    // InternalBot.g:2969:1: rule__IntentLanguageInputs__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__IntentLanguageInputs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2973:1: ( ( 'in' ) )
            // InternalBot.g:2974:1: ( 'in' )
            {
            // InternalBot.g:2974:1: ( 'in' )
            // InternalBot.g:2975:2: 'in'
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
    // InternalBot.g:2984:1: rule__IntentLanguageInputs__Group_1__1 : rule__IntentLanguageInputs__Group_1__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2988:1: ( rule__IntentLanguageInputs__Group_1__1__Impl )
            // InternalBot.g:2989:2: rule__IntentLanguageInputs__Group_1__1__Impl
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
    // InternalBot.g:2995:1: rule__IntentLanguageInputs__Group_1__1__Impl : ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2999:1: ( ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:3000:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:3000:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            // InternalBot.g:3001:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:3002:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            // InternalBot.g:3002:3: rule__IntentLanguageInputs__LanguageAssignment_1_1
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
    // InternalBot.g:3011:1: rule__IntentLanguageInputs__Group_4__0 : rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 ;
    public final void rule__IntentLanguageInputs__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3015:1: ( rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 )
            // InternalBot.g:3016:2: rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1
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
    // InternalBot.g:3023:1: rule__IntentLanguageInputs__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IntentLanguageInputs__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3027:1: ( ( ',' ) )
            // InternalBot.g:3028:1: ( ',' )
            {
            // InternalBot.g:3028:1: ( ',' )
            // InternalBot.g:3029:2: ','
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
    // InternalBot.g:3038:1: rule__IntentLanguageInputs__Group_4__1 : rule__IntentLanguageInputs__Group_4__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3042:1: ( rule__IntentLanguageInputs__Group_4__1__Impl )
            // InternalBot.g:3043:2: rule__IntentLanguageInputs__Group_4__1__Impl
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
    // InternalBot.g:3049:1: rule__IntentLanguageInputs__Group_4__1__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3053:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) )
            // InternalBot.g:3054:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:3054:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            // InternalBot.g:3055:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:3056:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            // InternalBot.g:3056:3: rule__IntentLanguageInputs__InputsAssignment_4_1
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
    // InternalBot.g:3065:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3069:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:3070:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
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
    // InternalBot.g:3077:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3081:1: ( ( 'user' ) )
            // InternalBot.g:3082:1: ( 'user' )
            {
            // InternalBot.g:3082:1: ( 'user' )
            // InternalBot.g:3083:2: 'user'
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
    // InternalBot.g:3092:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3096:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:3097:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
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
    // InternalBot.g:3104:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3108:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:3109:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:3109:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:3110:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:3111:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:3111:3: rule__Transition__IntentAssignment_1
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
    // InternalBot.g:3119:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3123:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:3124:2: rule__Transition__Group__2__Impl
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
    // InternalBot.g:3130:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3134:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:3135:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:3135:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:3136:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:3137:2: ( rule__Transition__Group_2__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==65) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:3137:3: rule__Transition__Group_2__0
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
    // InternalBot.g:3146:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3150:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:3151:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
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
    // InternalBot.g:3158:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3162:1: ( ( '=>' ) )
            // InternalBot.g:3163:1: ( '=>' )
            {
            // InternalBot.g:3163:1: ( '=>' )
            // InternalBot.g:3164:2: '=>'
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
    // InternalBot.g:3173:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3177:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:3178:2: rule__Transition__Group_2__1__Impl
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
    // InternalBot.g:3184:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3188:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:3189:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:3189:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:3190:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:3191:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:3191:3: rule__Transition__TargetAssignment_2_1
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
    // InternalBot.g:3200:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3204:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:3205:2: rule__State__Group__0__Impl rule__State__Group__1
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
    // InternalBot.g:3212:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3216:1: ( ( 'chatbot' ) )
            // InternalBot.g:3217:1: ( 'chatbot' )
            {
            // InternalBot.g:3217:1: ( 'chatbot' )
            // InternalBot.g:3218:2: 'chatbot'
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
    // InternalBot.g:3227:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3231:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:3232:2: rule__State__Group__1__Impl rule__State__Group__2
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
    // InternalBot.g:3239:1: rule__State__Group__1__Impl : ( ( rule__State__ActionsAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3243:1: ( ( ( rule__State__ActionsAssignment_1 ) ) )
            // InternalBot.g:3244:1: ( ( rule__State__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3244:1: ( ( rule__State__ActionsAssignment_1 ) )
            // InternalBot.g:3245:2: ( rule__State__ActionsAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_1()); 
            // InternalBot.g:3246:2: ( rule__State__ActionsAssignment_1 )
            // InternalBot.g:3246:3: rule__State__ActionsAssignment_1
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
    // InternalBot.g:3254:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3258:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:3259:2: rule__State__Group__2__Impl rule__State__Group__3
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
    // InternalBot.g:3266:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )* ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3270:1: ( ( ( rule__State__Group_2__0 )* ) )
            // InternalBot.g:3271:1: ( ( rule__State__Group_2__0 )* )
            {
            // InternalBot.g:3271:1: ( ( rule__State__Group_2__0 )* )
            // InternalBot.g:3272:2: ( rule__State__Group_2__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // InternalBot.g:3273:2: ( rule__State__Group_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==54) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:3273:3: rule__State__Group_2__0
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
    // InternalBot.g:3281:1: rule__State__Group__3 : rule__State__Group__3__Impl ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3285:1: ( rule__State__Group__3__Impl )
            // InternalBot.g:3286:2: rule__State__Group__3__Impl
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
    // InternalBot.g:3292:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3296:1: ( ( ( rule__State__Group_3__0 )? ) )
            // InternalBot.g:3297:1: ( ( rule__State__Group_3__0 )? )
            {
            // InternalBot.g:3297:1: ( ( rule__State__Group_3__0 )? )
            // InternalBot.g:3298:2: ( rule__State__Group_3__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:3299:2: ( rule__State__Group_3__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==65) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:3299:3: rule__State__Group_3__0
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
    // InternalBot.g:3308:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3312:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // InternalBot.g:3313:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
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
    // InternalBot.g:3320:1: rule__State__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3324:1: ( ( ',' ) )
            // InternalBot.g:3325:1: ( ',' )
            {
            // InternalBot.g:3325:1: ( ',' )
            // InternalBot.g:3326:2: ','
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
    // InternalBot.g:3335:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3339:1: ( rule__State__Group_2__1__Impl )
            // InternalBot.g:3340:2: rule__State__Group_2__1__Impl
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
    // InternalBot.g:3346:1: rule__State__Group_2__1__Impl : ( ( rule__State__ActionsAssignment_2_1 ) ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3350:1: ( ( ( rule__State__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3351:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3351:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            // InternalBot.g:3352:2: ( rule__State__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_1()); 
            // InternalBot.g:3353:2: ( rule__State__ActionsAssignment_2_1 )
            // InternalBot.g:3353:3: rule__State__ActionsAssignment_2_1
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
    // InternalBot.g:3362:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3366:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:3367:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
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
    // InternalBot.g:3374:1: rule__State__Group_3__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3378:1: ( ( '=>' ) )
            // InternalBot.g:3379:1: ( '=>' )
            {
            // InternalBot.g:3379:1: ( '=>' )
            // InternalBot.g:3380:2: '=>'
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
    // InternalBot.g:3389:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3393:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:3394:2: rule__State__Group_3__1__Impl
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
    // InternalBot.g:3400:1: rule__State__Group_3__1__Impl : ( ( rule__State__OutcomingAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3404:1: ( ( ( rule__State__OutcomingAssignment_3_1 ) ) )
            // InternalBot.g:3405:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            {
            // InternalBot.g:3405:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            // InternalBot.g:3406:2: ( rule__State__OutcomingAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_3_1()); 
            // InternalBot.g:3407:2: ( rule__State__OutcomingAssignment_3_1 )
            // InternalBot.g:3407:3: rule__State__OutcomingAssignment_3_1
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
    // InternalBot.g:3416:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3420:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:3421:2: rule__State2__Group__0__Impl rule__State2__Group__1
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
    // InternalBot.g:3428:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3432:1: ( ( 'chatbot' ) )
            // InternalBot.g:3433:1: ( 'chatbot' )
            {
            // InternalBot.g:3433:1: ( 'chatbot' )
            // InternalBot.g:3434:2: 'chatbot'
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
    // InternalBot.g:3443:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3447:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:3448:2: rule__State2__Group__1__Impl rule__State2__Group__2
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
    // InternalBot.g:3455:1: rule__State2__Group__1__Impl : ( ( rule__State2__ActionsAssignment_1 ) ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3459:1: ( ( ( rule__State2__ActionsAssignment_1 ) ) )
            // InternalBot.g:3460:1: ( ( rule__State2__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3460:1: ( ( rule__State2__ActionsAssignment_1 ) )
            // InternalBot.g:3461:2: ( rule__State2__ActionsAssignment_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_1()); 
            // InternalBot.g:3462:2: ( rule__State2__ActionsAssignment_1 )
            // InternalBot.g:3462:3: rule__State2__ActionsAssignment_1
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
    // InternalBot.g:3470:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3474:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:3475:2: rule__State2__Group__2__Impl rule__State2__Group__3
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
    // InternalBot.g:3482:1: rule__State2__Group__2__Impl : ( ( rule__State2__Group_2__0 )* ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3486:1: ( ( ( rule__State2__Group_2__0 )* ) )
            // InternalBot.g:3487:1: ( ( rule__State2__Group_2__0 )* )
            {
            // InternalBot.g:3487:1: ( ( rule__State2__Group_2__0 )* )
            // InternalBot.g:3488:2: ( rule__State2__Group_2__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_2()); 
            // InternalBot.g:3489:2: ( rule__State2__Group_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==54) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBot.g:3489:3: rule__State2__Group_2__0
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
    // InternalBot.g:3497:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3501:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:3502:2: rule__State2__Group__3__Impl rule__State2__Group__4
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
    // InternalBot.g:3509:1: rule__State2__Group__3__Impl : ( '{' ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3513:1: ( ( '{' ) )
            // InternalBot.g:3514:1: ( '{' )
            {
            // InternalBot.g:3514:1: ( '{' )
            // InternalBot.g:3515:2: '{'
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
    // InternalBot.g:3524:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3528:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:3529:2: rule__State2__Group__4__Impl rule__State2__Group__5
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
    // InternalBot.g:3536:1: rule__State2__Group__4__Impl : ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3540:1: ( ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) )
            // InternalBot.g:3541:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            {
            // InternalBot.g:3541:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            // InternalBot.g:3542:2: ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* )
            {
            // InternalBot.g:3542:2: ( ( rule__State2__Group_4__0 ) )
            // InternalBot.g:3543:3: ( rule__State2__Group_4__0 )
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3544:3: ( rule__State2__Group_4__0 )
            // InternalBot.g:3544:4: rule__State2__Group_4__0
            {
            pushFollow(FOLLOW_33);
            rule__State2__Group_4__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_4()); 

            }

            // InternalBot.g:3547:2: ( ( rule__State2__Group_4__0 )* )
            // InternalBot.g:3548:3: ( rule__State2__Group_4__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3549:3: ( rule__State2__Group_4__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==65) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBot.g:3549:4: rule__State2__Group_4__0
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
    // InternalBot.g:3558:1: rule__State2__Group__5 : rule__State2__Group__5__Impl ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3562:1: ( rule__State2__Group__5__Impl )
            // InternalBot.g:3563:2: rule__State2__Group__5__Impl
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
    // InternalBot.g:3569:1: rule__State2__Group__5__Impl : ( '}' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3573:1: ( ( '}' ) )
            // InternalBot.g:3574:1: ( '}' )
            {
            // InternalBot.g:3574:1: ( '}' )
            // InternalBot.g:3575:2: '}'
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
    // InternalBot.g:3585:1: rule__State2__Group_2__0 : rule__State2__Group_2__0__Impl rule__State2__Group_2__1 ;
    public final void rule__State2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3589:1: ( rule__State2__Group_2__0__Impl rule__State2__Group_2__1 )
            // InternalBot.g:3590:2: rule__State2__Group_2__0__Impl rule__State2__Group_2__1
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
    // InternalBot.g:3597:1: rule__State2__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3601:1: ( ( ',' ) )
            // InternalBot.g:3602:1: ( ',' )
            {
            // InternalBot.g:3602:1: ( ',' )
            // InternalBot.g:3603:2: ','
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
    // InternalBot.g:3612:1: rule__State2__Group_2__1 : rule__State2__Group_2__1__Impl ;
    public final void rule__State2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3616:1: ( rule__State2__Group_2__1__Impl )
            // InternalBot.g:3617:2: rule__State2__Group_2__1__Impl
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
    // InternalBot.g:3623:1: rule__State2__Group_2__1__Impl : ( ( rule__State2__ActionsAssignment_2_1 ) ) ;
    public final void rule__State2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3627:1: ( ( ( rule__State2__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3628:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3628:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            // InternalBot.g:3629:2: ( rule__State2__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2_1()); 
            // InternalBot.g:3630:2: ( rule__State2__ActionsAssignment_2_1 )
            // InternalBot.g:3630:3: rule__State2__ActionsAssignment_2_1
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
    // InternalBot.g:3639:1: rule__State2__Group_4__0 : rule__State2__Group_4__0__Impl rule__State2__Group_4__1 ;
    public final void rule__State2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3643:1: ( rule__State2__Group_4__0__Impl rule__State2__Group_4__1 )
            // InternalBot.g:3644:2: rule__State2__Group_4__0__Impl rule__State2__Group_4__1
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
    // InternalBot.g:3651:1: rule__State2__Group_4__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3655:1: ( ( '=>' ) )
            // InternalBot.g:3656:1: ( '=>' )
            {
            // InternalBot.g:3656:1: ( '=>' )
            // InternalBot.g:3657:2: '=>'
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
    // InternalBot.g:3666:1: rule__State2__Group_4__1 : rule__State2__Group_4__1__Impl rule__State2__Group_4__2 ;
    public final void rule__State2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3670:1: ( rule__State2__Group_4__1__Impl rule__State2__Group_4__2 )
            // InternalBot.g:3671:2: rule__State2__Group_4__1__Impl rule__State2__Group_4__2
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
    // InternalBot.g:3678:1: rule__State2__Group_4__1__Impl : ( ( rule__State2__OutcomingAssignment_4_1 ) ) ;
    public final void rule__State2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3682:1: ( ( ( rule__State2__OutcomingAssignment_4_1 ) ) )
            // InternalBot.g:3683:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            {
            // InternalBot.g:3683:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            // InternalBot.g:3684:2: ( rule__State2__OutcomingAssignment_4_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_4_1()); 
            // InternalBot.g:3685:2: ( rule__State2__OutcomingAssignment_4_1 )
            // InternalBot.g:3685:3: rule__State2__OutcomingAssignment_4_1
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
    // InternalBot.g:3693:1: rule__State2__Group_4__2 : rule__State2__Group_4__2__Impl ;
    public final void rule__State2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3697:1: ( rule__State2__Group_4__2__Impl )
            // InternalBot.g:3698:2: rule__State2__Group_4__2__Impl
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
    // InternalBot.g:3704:1: rule__State2__Group_4__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3708:1: ( ( ';' ) )
            // InternalBot.g:3709:1: ( ';' )
            {
            // InternalBot.g:3709:1: ( ';' )
            // InternalBot.g:3710:2: ';'
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
    // InternalBot.g:3720:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3724:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3725:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
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
    // InternalBot.g:3732:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3736:1: ( ( () ) )
            // InternalBot.g:3737:1: ( () )
            {
            // InternalBot.g:3737:1: ( () )
            // InternalBot.g:3738:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3739:2: ()
            // InternalBot.g:3739:3: 
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
    // InternalBot.g:3747:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3751:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3752:2: rule__TrainingPhrase__Group__1__Impl
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
    // InternalBot.g:3758:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3762:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3763:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3763:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3764:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3764:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3765:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3766:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3766:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_35);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3769:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3770:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3771:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==72) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:3771:4: rule__TrainingPhrase__TokensAssignment_1
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
    // InternalBot.g:3781:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3785:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3786:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
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
    // InternalBot.g:3793:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3797:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3798:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3798:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3799:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3800:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3800:3: rule__Parameter__NameAssignment_0
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
    // InternalBot.g:3808:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3812:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3813:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
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
    // InternalBot.g:3820:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3824:1: ( ( ':' ) )
            // InternalBot.g:3825:1: ( ':' )
            {
            // InternalBot.g:3825:1: ( ':' )
            // InternalBot.g:3826:2: ':'
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
    // InternalBot.g:3835:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3839:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3840:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
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
    // InternalBot.g:3847:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3851:1: ( ( 'entity' ) )
            // InternalBot.g:3852:1: ( 'entity' )
            {
            // InternalBot.g:3852:1: ( 'entity' )
            // InternalBot.g:3853:2: 'entity'
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
    // InternalBot.g:3862:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3866:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:3867:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
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
    // InternalBot.g:3874:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3878:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:3879:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:3879:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:3880:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:3881:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:3881:3: rule__Parameter__Alternatives_3
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
    // InternalBot.g:3889:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3893:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:3894:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
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
    // InternalBot.g:3901:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3905:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:3906:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:3906:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:3907:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:3908:2: ( rule__Parameter__Group_4__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==54) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==91) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:3908:3: rule__Parameter__Group_4__0
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
    // InternalBot.g:3916:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3920:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:3921:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
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
    // InternalBot.g:3928:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3932:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:3933:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:3933:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:3934:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:3935:2: ( rule__Parameter__Group_5__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==54) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==92) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:3935:3: rule__Parameter__Group_5__0
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
    // InternalBot.g:3943:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl rule__Parameter__Group__7 ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3947:1: ( rule__Parameter__Group__6__Impl rule__Parameter__Group__7 )
            // InternalBot.g:3948:2: rule__Parameter__Group__6__Impl rule__Parameter__Group__7
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
    // InternalBot.g:3955:1: rule__Parameter__Group__6__Impl : ( ( rule__Parameter__Group_6__0 )? ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3959:1: ( ( ( rule__Parameter__Group_6__0 )? ) )
            // InternalBot.g:3960:1: ( ( rule__Parameter__Group_6__0 )? )
            {
            // InternalBot.g:3960:1: ( ( rule__Parameter__Group_6__0 )? )
            // InternalBot.g:3961:2: ( rule__Parameter__Group_6__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_6()); 
            // InternalBot.g:3962:2: ( rule__Parameter__Group_6__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==54) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:3962:3: rule__Parameter__Group_6__0
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
    // InternalBot.g:3970:1: rule__Parameter__Group__7 : rule__Parameter__Group__7__Impl ;
    public final void rule__Parameter__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3974:1: ( rule__Parameter__Group__7__Impl )
            // InternalBot.g:3975:2: rule__Parameter__Group__7__Impl
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
    // InternalBot.g:3981:1: rule__Parameter__Group__7__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3985:1: ( ( ';' ) )
            // InternalBot.g:3986:1: ( ';' )
            {
            // InternalBot.g:3986:1: ( ';' )
            // InternalBot.g:3987:2: ';'
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
    // InternalBot.g:3997:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4001:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:4002:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
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
    // InternalBot.g:4009:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4013:1: ( ( ',' ) )
            // InternalBot.g:4014:1: ( ',' )
            {
            // InternalBot.g:4014:1: ( ',' )
            // InternalBot.g:4015:2: ','
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
    // InternalBot.g:4024:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4028:1: ( rule__Parameter__Group_4__1__Impl )
            // InternalBot.g:4029:2: rule__Parameter__Group_4__1__Impl
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
    // InternalBot.g:4035:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__IsListAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4039:1: ( ( ( rule__Parameter__IsListAssignment_4_1 ) ) )
            // InternalBot.g:4040:1: ( ( rule__Parameter__IsListAssignment_4_1 ) )
            {
            // InternalBot.g:4040:1: ( ( rule__Parameter__IsListAssignment_4_1 ) )
            // InternalBot.g:4041:2: ( rule__Parameter__IsListAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_4_1()); 
            // InternalBot.g:4042:2: ( rule__Parameter__IsListAssignment_4_1 )
            // InternalBot.g:4042:3: rule__Parameter__IsListAssignment_4_1
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
    // InternalBot.g:4051:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4055:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:4056:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
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
    // InternalBot.g:4063:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4067:1: ( ( ',' ) )
            // InternalBot.g:4068:1: ( ',' )
            {
            // InternalBot.g:4068:1: ( ',' )
            // InternalBot.g:4069:2: ','
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
    // InternalBot.g:4078:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4082:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:4083:2: rule__Parameter__Group_5__1__Impl
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
    // InternalBot.g:4089:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__RequiredAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4093:1: ( ( ( rule__Parameter__RequiredAssignment_5_1 ) ) )
            // InternalBot.g:4094:1: ( ( rule__Parameter__RequiredAssignment_5_1 ) )
            {
            // InternalBot.g:4094:1: ( ( rule__Parameter__RequiredAssignment_5_1 ) )
            // InternalBot.g:4095:2: ( rule__Parameter__RequiredAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_5_1()); 
            // InternalBot.g:4096:2: ( rule__Parameter__RequiredAssignment_5_1 )
            // InternalBot.g:4096:3: rule__Parameter__RequiredAssignment_5_1
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
    // InternalBot.g:4105:1: rule__Parameter__Group_6__0 : rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 ;
    public final void rule__Parameter__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4109:1: ( rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 )
            // InternalBot.g:4110:2: rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1
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
    // InternalBot.g:4117:1: rule__Parameter__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4121:1: ( ( ',' ) )
            // InternalBot.g:4122:1: ( ',' )
            {
            // InternalBot.g:4122:1: ( ',' )
            // InternalBot.g:4123:2: ','
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
    // InternalBot.g:4132:1: rule__Parameter__Group_6__1 : rule__Parameter__Group_6__1__Impl ;
    public final void rule__Parameter__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4136:1: ( rule__Parameter__Group_6__1__Impl )
            // InternalBot.g:4137:2: rule__Parameter__Group_6__1__Impl
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
    // InternalBot.g:4143:1: rule__Parameter__Group_6__1__Impl : ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) ) ;
    public final void rule__Parameter__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4147:1: ( ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) ) )
            // InternalBot.g:4148:1: ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) )
            {
            // InternalBot.g:4148:1: ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) )
            // InternalBot.g:4149:2: ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* )
            {
            // InternalBot.g:4149:2: ( ( rule__Parameter__PromptsAssignment_6_1 ) )
            // InternalBot.g:4150:3: ( rule__Parameter__PromptsAssignment_6_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 
            // InternalBot.g:4151:3: ( rule__Parameter__PromptsAssignment_6_1 )
            // InternalBot.g:4151:4: rule__Parameter__PromptsAssignment_6_1
            {
            pushFollow(FOLLOW_42);
            rule__Parameter__PromptsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 

            }

            // InternalBot.g:4154:2: ( ( rule__Parameter__PromptsAssignment_6_1 )* )
            // InternalBot.g:4155:3: ( rule__Parameter__PromptsAssignment_6_1 )*
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 
            // InternalBot.g:4156:3: ( rule__Parameter__PromptsAssignment_6_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==68) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalBot.g:4156:4: rule__Parameter__PromptsAssignment_6_1
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
    // InternalBot.g:4166:1: rule__Parameter2__Group__0 : rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 ;
    public final void rule__Parameter2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4170:1: ( rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 )
            // InternalBot.g:4171:2: rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1
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
    // InternalBot.g:4178:1: rule__Parameter2__Group__0__Impl : ( ( rule__Parameter2__NameAssignment_0 ) ) ;
    public final void rule__Parameter2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4182:1: ( ( ( rule__Parameter2__NameAssignment_0 ) ) )
            // InternalBot.g:4183:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            {
            // InternalBot.g:4183:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            // InternalBot.g:4184:2: ( rule__Parameter2__NameAssignment_0 )
            {
             before(grammarAccess.getParameter2Access().getNameAssignment_0()); 
            // InternalBot.g:4185:2: ( rule__Parameter2__NameAssignment_0 )
            // InternalBot.g:4185:3: rule__Parameter2__NameAssignment_0
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
    // InternalBot.g:4193:1: rule__Parameter2__Group__1 : rule__Parameter2__Group__1__Impl ;
    public final void rule__Parameter2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4197:1: ( rule__Parameter2__Group__1__Impl )
            // InternalBot.g:4198:2: rule__Parameter2__Group__1__Impl
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
    // InternalBot.g:4204:1: rule__Parameter2__Group__1__Impl : ( ',' ) ;
    public final void rule__Parameter2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4208:1: ( ( ',' ) )
            // InternalBot.g:4209:1: ( ',' )
            {
            // InternalBot.g:4209:1: ( ',' )
            // InternalBot.g:4210:2: ','
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
    // InternalBot.g:4220:1: rule__PromptLanguage__Group__0 : rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 ;
    public final void rule__PromptLanguage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4224:1: ( rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 )
            // InternalBot.g:4225:2: rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1
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
    // InternalBot.g:4232:1: rule__PromptLanguage__Group__0__Impl : ( 'prompts' ) ;
    public final void rule__PromptLanguage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4236:1: ( ( 'prompts' ) )
            // InternalBot.g:4237:1: ( 'prompts' )
            {
            // InternalBot.g:4237:1: ( 'prompts' )
            // InternalBot.g:4238:2: 'prompts'
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
    // InternalBot.g:4247:1: rule__PromptLanguage__Group__1 : rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 ;
    public final void rule__PromptLanguage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4251:1: ( rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 )
            // InternalBot.g:4252:2: rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2
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
    // InternalBot.g:4259:1: rule__PromptLanguage__Group__1__Impl : ( ( rule__PromptLanguage__Group_1__0 )? ) ;
    public final void rule__PromptLanguage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4263:1: ( ( ( rule__PromptLanguage__Group_1__0 )? ) )
            // InternalBot.g:4264:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            {
            // InternalBot.g:4264:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            // InternalBot.g:4265:2: ( rule__PromptLanguage__Group_1__0 )?
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_1()); 
            // InternalBot.g:4266:2: ( rule__PromptLanguage__Group_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==63) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBot.g:4266:3: rule__PromptLanguage__Group_1__0
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
    // InternalBot.g:4274:1: rule__PromptLanguage__Group__2 : rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 ;
    public final void rule__PromptLanguage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4278:1: ( rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 )
            // InternalBot.g:4279:2: rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3
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
    // InternalBot.g:4286:1: rule__PromptLanguage__Group__2__Impl : ( '[' ) ;
    public final void rule__PromptLanguage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4290:1: ( ( '[' ) )
            // InternalBot.g:4291:1: ( '[' )
            {
            // InternalBot.g:4291:1: ( '[' )
            // InternalBot.g:4292:2: '['
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
    // InternalBot.g:4301:1: rule__PromptLanguage__Group__3 : rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 ;
    public final void rule__PromptLanguage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4305:1: ( rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 )
            // InternalBot.g:4306:2: rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4
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
    // InternalBot.g:4313:1: rule__PromptLanguage__Group__3__Impl : ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) ;
    public final void rule__PromptLanguage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4317:1: ( ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) )
            // InternalBot.g:4318:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            {
            // InternalBot.g:4318:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            // InternalBot.g:4319:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 
            // InternalBot.g:4320:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            // InternalBot.g:4320:3: rule__PromptLanguage__PromptsAssignment_3
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
    // InternalBot.g:4328:1: rule__PromptLanguage__Group__4 : rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 ;
    public final void rule__PromptLanguage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4332:1: ( rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 )
            // InternalBot.g:4333:2: rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5
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
    // InternalBot.g:4340:1: rule__PromptLanguage__Group__4__Impl : ( ( rule__PromptLanguage__Group_4__0 )* ) ;
    public final void rule__PromptLanguage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4344:1: ( ( ( rule__PromptLanguage__Group_4__0 )* ) )
            // InternalBot.g:4345:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            {
            // InternalBot.g:4345:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            // InternalBot.g:4346:2: ( rule__PromptLanguage__Group_4__0 )*
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_4()); 
            // InternalBot.g:4347:2: ( rule__PromptLanguage__Group_4__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==54) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:4347:3: rule__PromptLanguage__Group_4__0
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
    // InternalBot.g:4355:1: rule__PromptLanguage__Group__5 : rule__PromptLanguage__Group__5__Impl ;
    public final void rule__PromptLanguage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4359:1: ( rule__PromptLanguage__Group__5__Impl )
            // InternalBot.g:4360:2: rule__PromptLanguage__Group__5__Impl
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
    // InternalBot.g:4366:1: rule__PromptLanguage__Group__5__Impl : ( ']' ) ;
    public final void rule__PromptLanguage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4370:1: ( ( ']' ) )
            // InternalBot.g:4371:1: ( ']' )
            {
            // InternalBot.g:4371:1: ( ']' )
            // InternalBot.g:4372:2: ']'
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
    // InternalBot.g:4382:1: rule__PromptLanguage__Group_1__0 : rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 ;
    public final void rule__PromptLanguage__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4386:1: ( rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 )
            // InternalBot.g:4387:2: rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1
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
    // InternalBot.g:4394:1: rule__PromptLanguage__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__PromptLanguage__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4398:1: ( ( 'in' ) )
            // InternalBot.g:4399:1: ( 'in' )
            {
            // InternalBot.g:4399:1: ( 'in' )
            // InternalBot.g:4400:2: 'in'
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
    // InternalBot.g:4409:1: rule__PromptLanguage__Group_1__1 : rule__PromptLanguage__Group_1__1__Impl ;
    public final void rule__PromptLanguage__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4413:1: ( rule__PromptLanguage__Group_1__1__Impl )
            // InternalBot.g:4414:2: rule__PromptLanguage__Group_1__1__Impl
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
    // InternalBot.g:4420:1: rule__PromptLanguage__Group_1__1__Impl : ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) ;
    public final void rule__PromptLanguage__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4424:1: ( ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:4425:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:4425:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            // InternalBot.g:4426:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:4427:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            // InternalBot.g:4427:3: rule__PromptLanguage__LanguageAssignment_1_1
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
    // InternalBot.g:4436:1: rule__PromptLanguage__Group_4__0 : rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 ;
    public final void rule__PromptLanguage__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4440:1: ( rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 )
            // InternalBot.g:4441:2: rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1
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
    // InternalBot.g:4448:1: rule__PromptLanguage__Group_4__0__Impl : ( ',' ) ;
    public final void rule__PromptLanguage__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4452:1: ( ( ',' ) )
            // InternalBot.g:4453:1: ( ',' )
            {
            // InternalBot.g:4453:1: ( ',' )
            // InternalBot.g:4454:2: ','
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
    // InternalBot.g:4463:1: rule__PromptLanguage__Group_4__1 : rule__PromptLanguage__Group_4__1__Impl ;
    public final void rule__PromptLanguage__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4467:1: ( rule__PromptLanguage__Group_4__1__Impl )
            // InternalBot.g:4468:2: rule__PromptLanguage__Group_4__1__Impl
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
    // InternalBot.g:4474:1: rule__PromptLanguage__Group_4__1__Impl : ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) ;
    public final void rule__PromptLanguage__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4478:1: ( ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) )
            // InternalBot.g:4479:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            {
            // InternalBot.g:4479:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            // InternalBot.g:4480:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 
            // InternalBot.g:4481:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            // InternalBot.g:4481:3: rule__PromptLanguage__PromptsAssignment_4_1
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
    // InternalBot.g:4490:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4494:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:4495:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
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
    // InternalBot.g:4502:1: rule__EntityToken__Group__0__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4506:1: ( ( '@' ) )
            // InternalBot.g:4507:1: ( '@' )
            {
            // InternalBot.g:4507:1: ( '@' )
            // InternalBot.g:4508:2: '@'
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
    // InternalBot.g:4517:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4521:1: ( rule__EntityToken__Group__1__Impl )
            // InternalBot.g:4522:2: rule__EntityToken__Group__1__Impl
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
    // InternalBot.g:4528:1: rule__EntityToken__Group__1__Impl : ( ( rule__EntityToken__EntityAssignment_1 ) ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4532:1: ( ( ( rule__EntityToken__EntityAssignment_1 ) ) )
            // InternalBot.g:4533:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            {
            // InternalBot.g:4533:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            // InternalBot.g:4534:2: ( rule__EntityToken__EntityAssignment_1 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 
            // InternalBot.g:4535:2: ( rule__EntityToken__EntityAssignment_1 )
            // InternalBot.g:4535:3: rule__EntityToken__EntityAssignment_1
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
    // InternalBot.g:4544:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4548:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:4549:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
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
    // InternalBot.g:4556:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4560:1: ( ( '[' ) )
            // InternalBot.g:4561:1: ( '[' )
            {
            // InternalBot.g:4561:1: ( '[' )
            // InternalBot.g:4562:2: '['
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
    // InternalBot.g:4571:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4575:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:4576:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
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
    // InternalBot.g:4583:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4587:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:4588:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:4588:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:4589:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:4590:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:4590:3: rule__ParameterToken__ParameterAssignment_1
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
    // InternalBot.g:4598:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4602:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:4603:2: rule__ParameterToken__Group__2__Impl
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
    // InternalBot.g:4609:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4613:1: ( ( ']' ) )
            // InternalBot.g:4614:1: ( ']' )
            {
            // InternalBot.g:4614:1: ( ']' )
            // InternalBot.g:4615:2: ']'
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
    // InternalBot.g:4625:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4629:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:4630:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
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
    // InternalBot.g:4637:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4641:1: ( ( '(' ) )
            // InternalBot.g:4642:1: ( '(' )
            {
            // InternalBot.g:4642:1: ( '(' )
            // InternalBot.g:4643:2: '('
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
    // InternalBot.g:4652:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4656:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:4657:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
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
    // InternalBot.g:4664:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4668:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:4669:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:4669:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:4670:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:4671:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:4671:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
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
    // InternalBot.g:4679:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4683:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:4684:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
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
    // InternalBot.g:4691:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4695:1: ( ( ')' ) )
            // InternalBot.g:4696:1: ( ')' )
            {
            // InternalBot.g:4696:1: ( ')' )
            // InternalBot.g:4697:2: ')'
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
    // InternalBot.g:4706:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4710:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:4711:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
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
    // InternalBot.g:4718:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4722:1: ( ( '[' ) )
            // InternalBot.g:4723:1: ( '[' )
            {
            // InternalBot.g:4723:1: ( '[' )
            // InternalBot.g:4724:2: '['
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
    // InternalBot.g:4733:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4737:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:4738:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
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
    // InternalBot.g:4745:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4749:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:4750:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:4750:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:4751:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:4752:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:4752:3: rule__ParameterRefenceToken__ParameterAssignment_4
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
    // InternalBot.g:4760:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4764:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:4765:2: rule__ParameterRefenceToken__Group__5__Impl
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
    // InternalBot.g:4771:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4775:1: ( ( ']' ) )
            // InternalBot.g:4776:1: ( ']' )
            {
            // InternalBot.g:4776:1: ( ']' )
            // InternalBot.g:4777:2: ']'
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
    // InternalBot.g:4787:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4791:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:4792:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
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
    // InternalBot.g:4799:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4803:1: ( ( 'request.' ) )
            // InternalBot.g:4804:1: ( 'request.' )
            {
            // InternalBot.g:4804:1: ( 'request.' )
            // InternalBot.g:4805:2: 'request.'
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
    // InternalBot.g:4814:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4818:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:4819:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
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
    // InternalBot.g:4826:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4830:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4831:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4831:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4832:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4833:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4833:3: rule__HTTPRequestToken__TypeAssignment_1
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
    // InternalBot.g:4841:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4845:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:4846:2: rule__HTTPRequestToken__Group__2__Impl
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
    // InternalBot.g:4852:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4856:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:4857:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:4857:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:4858:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:4859:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==75) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:4859:3: rule__HTTPRequestToken__Group_2__0
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
    // InternalBot.g:4868:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4872:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:4873:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
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
    // InternalBot.g:4880:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4884:1: ( ( '.' ) )
            // InternalBot.g:4885:1: ( '.' )
            {
            // InternalBot.g:4885:1: ( '.' )
            // InternalBot.g:4886:2: '.'
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
    // InternalBot.g:4895:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4899:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:4900:2: rule__HTTPRequestToken__Group_2__1__Impl
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
    // InternalBot.g:4906:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4910:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:4911:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:4911:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:4912:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:4913:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:4913:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
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
    // InternalBot.g:4922:1: rule__SimpleEntity__Group__0 : rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1 ;
    public final void rule__SimpleEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4926:1: ( rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1 )
            // InternalBot.g:4927:2: rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1
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
    // InternalBot.g:4934:1: rule__SimpleEntity__Group__0__Impl : ( 'Simple' ) ;
    public final void rule__SimpleEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4938:1: ( ( 'Simple' ) )
            // InternalBot.g:4939:1: ( 'Simple' )
            {
            // InternalBot.g:4939:1: ( 'Simple' )
            // InternalBot.g:4940:2: 'Simple'
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
    // InternalBot.g:4949:1: rule__SimpleEntity__Group__1 : rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2 ;
    public final void rule__SimpleEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4953:1: ( rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2 )
            // InternalBot.g:4954:2: rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2
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
    // InternalBot.g:4961:1: rule__SimpleEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__SimpleEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4965:1: ( ( 'entity' ) )
            // InternalBot.g:4966:1: ( 'entity' )
            {
            // InternalBot.g:4966:1: ( 'entity' )
            // InternalBot.g:4967:2: 'entity'
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
    // InternalBot.g:4976:1: rule__SimpleEntity__Group__2 : rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3 ;
    public final void rule__SimpleEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4980:1: ( rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3 )
            // InternalBot.g:4981:2: rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3
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
    // InternalBot.g:4988:1: rule__SimpleEntity__Group__2__Impl : ( ( rule__SimpleEntity__NameAssignment_2 ) ) ;
    public final void rule__SimpleEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4992:1: ( ( ( rule__SimpleEntity__NameAssignment_2 ) ) )
            // InternalBot.g:4993:1: ( ( rule__SimpleEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:4993:1: ( ( rule__SimpleEntity__NameAssignment_2 ) )
            // InternalBot.g:4994:2: ( rule__SimpleEntity__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:4995:2: ( rule__SimpleEntity__NameAssignment_2 )
            // InternalBot.g:4995:3: rule__SimpleEntity__NameAssignment_2
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
    // InternalBot.g:5003:1: rule__SimpleEntity__Group__3 : rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4 ;
    public final void rule__SimpleEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5007:1: ( rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4 )
            // InternalBot.g:5008:2: rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4
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
    // InternalBot.g:5015:1: rule__SimpleEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5019:1: ( ( ':' ) )
            // InternalBot.g:5020:1: ( ':' )
            {
            // InternalBot.g:5020:1: ( ':' )
            // InternalBot.g:5021:2: ':'
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
    // InternalBot.g:5030:1: rule__SimpleEntity__Group__4 : rule__SimpleEntity__Group__4__Impl ;
    public final void rule__SimpleEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5034:1: ( rule__SimpleEntity__Group__4__Impl )
            // InternalBot.g:5035:2: rule__SimpleEntity__Group__4__Impl
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
    // InternalBot.g:5041:1: rule__SimpleEntity__Group__4__Impl : ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__SimpleEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5045:1: ( ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5046:1: ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5046:1: ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5047:2: ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5047:2: ( ( rule__SimpleEntity__InputsAssignment_4 ) )
            // InternalBot.g:5048:3: ( rule__SimpleEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5049:3: ( rule__SimpleEntity__InputsAssignment_4 )
            // InternalBot.g:5049:4: rule__SimpleEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__SimpleEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5052:2: ( ( rule__SimpleEntity__InputsAssignment_4 )* )
            // InternalBot.g:5053:3: ( rule__SimpleEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5054:3: ( rule__SimpleEntity__InputsAssignment_4 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( ((LA48_0>=60 && LA48_0<=61)) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBot.g:5054:4: rule__SimpleEntity__InputsAssignment_4
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
    // InternalBot.g:5064:1: rule__ComplexEntity__Group__0 : rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1 ;
    public final void rule__ComplexEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5068:1: ( rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1 )
            // InternalBot.g:5069:2: rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1
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
    // InternalBot.g:5076:1: rule__ComplexEntity__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__ComplexEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5080:1: ( ( 'Composite' ) )
            // InternalBot.g:5081:1: ( 'Composite' )
            {
            // InternalBot.g:5081:1: ( 'Composite' )
            // InternalBot.g:5082:2: 'Composite'
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
    // InternalBot.g:5091:1: rule__ComplexEntity__Group__1 : rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2 ;
    public final void rule__ComplexEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5095:1: ( rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2 )
            // InternalBot.g:5096:2: rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2
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
    // InternalBot.g:5103:1: rule__ComplexEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__ComplexEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5107:1: ( ( 'entity' ) )
            // InternalBot.g:5108:1: ( 'entity' )
            {
            // InternalBot.g:5108:1: ( 'entity' )
            // InternalBot.g:5109:2: 'entity'
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
    // InternalBot.g:5118:1: rule__ComplexEntity__Group__2 : rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3 ;
    public final void rule__ComplexEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5122:1: ( rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3 )
            // InternalBot.g:5123:2: rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3
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
    // InternalBot.g:5130:1: rule__ComplexEntity__Group__2__Impl : ( ( rule__ComplexEntity__NameAssignment_2 ) ) ;
    public final void rule__ComplexEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5134:1: ( ( ( rule__ComplexEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5135:1: ( ( rule__ComplexEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5135:1: ( ( rule__ComplexEntity__NameAssignment_2 ) )
            // InternalBot.g:5136:2: ( rule__ComplexEntity__NameAssignment_2 )
            {
             before(grammarAccess.getComplexEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5137:2: ( rule__ComplexEntity__NameAssignment_2 )
            // InternalBot.g:5137:3: rule__ComplexEntity__NameAssignment_2
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
    // InternalBot.g:5145:1: rule__ComplexEntity__Group__3 : rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4 ;
    public final void rule__ComplexEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5149:1: ( rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4 )
            // InternalBot.g:5150:2: rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4
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
    // InternalBot.g:5157:1: rule__ComplexEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__ComplexEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5161:1: ( ( ':' ) )
            // InternalBot.g:5162:1: ( ':' )
            {
            // InternalBot.g:5162:1: ( ':' )
            // InternalBot.g:5163:2: ':'
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
    // InternalBot.g:5172:1: rule__ComplexEntity__Group__4 : rule__ComplexEntity__Group__4__Impl ;
    public final void rule__ComplexEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5176:1: ( rule__ComplexEntity__Group__4__Impl )
            // InternalBot.g:5177:2: rule__ComplexEntity__Group__4__Impl
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
    // InternalBot.g:5183:1: rule__ComplexEntity__Group__4__Impl : ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__ComplexEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5187:1: ( ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5188:1: ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5188:1: ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5189:2: ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5189:2: ( ( rule__ComplexEntity__InputsAssignment_4 ) )
            // InternalBot.g:5190:3: ( rule__ComplexEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5191:3: ( rule__ComplexEntity__InputsAssignment_4 )
            // InternalBot.g:5191:4: rule__ComplexEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__ComplexEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5194:2: ( ( rule__ComplexEntity__InputsAssignment_4 )* )
            // InternalBot.g:5195:3: ( rule__ComplexEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5196:3: ( rule__ComplexEntity__InputsAssignment_4 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=60 && LA49_0<=61)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalBot.g:5196:4: rule__ComplexEntity__InputsAssignment_4
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
    // InternalBot.g:5206:1: rule__RegexEntity__Group__0 : rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1 ;
    public final void rule__RegexEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5210:1: ( rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1 )
            // InternalBot.g:5211:2: rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1
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
    // InternalBot.g:5218:1: rule__RegexEntity__Group__0__Impl : ( 'Regex' ) ;
    public final void rule__RegexEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5222:1: ( ( 'Regex' ) )
            // InternalBot.g:5223:1: ( 'Regex' )
            {
            // InternalBot.g:5223:1: ( 'Regex' )
            // InternalBot.g:5224:2: 'Regex'
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
    // InternalBot.g:5233:1: rule__RegexEntity__Group__1 : rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2 ;
    public final void rule__RegexEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5237:1: ( rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2 )
            // InternalBot.g:5238:2: rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2
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
    // InternalBot.g:5245:1: rule__RegexEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__RegexEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5249:1: ( ( 'entity' ) )
            // InternalBot.g:5250:1: ( 'entity' )
            {
            // InternalBot.g:5250:1: ( 'entity' )
            // InternalBot.g:5251:2: 'entity'
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
    // InternalBot.g:5260:1: rule__RegexEntity__Group__2 : rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3 ;
    public final void rule__RegexEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5264:1: ( rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3 )
            // InternalBot.g:5265:2: rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3
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
    // InternalBot.g:5272:1: rule__RegexEntity__Group__2__Impl : ( ( rule__RegexEntity__NameAssignment_2 ) ) ;
    public final void rule__RegexEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5276:1: ( ( ( rule__RegexEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5277:1: ( ( rule__RegexEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5277:1: ( ( rule__RegexEntity__NameAssignment_2 ) )
            // InternalBot.g:5278:2: ( rule__RegexEntity__NameAssignment_2 )
            {
             before(grammarAccess.getRegexEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5279:2: ( rule__RegexEntity__NameAssignment_2 )
            // InternalBot.g:5279:3: rule__RegexEntity__NameAssignment_2
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
    // InternalBot.g:5287:1: rule__RegexEntity__Group__3 : rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4 ;
    public final void rule__RegexEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5291:1: ( rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4 )
            // InternalBot.g:5292:2: rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4
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
    // InternalBot.g:5299:1: rule__RegexEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__RegexEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5303:1: ( ( ':' ) )
            // InternalBot.g:5304:1: ( ':' )
            {
            // InternalBot.g:5304:1: ( ':' )
            // InternalBot.g:5305:2: ':'
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
    // InternalBot.g:5314:1: rule__RegexEntity__Group__4 : rule__RegexEntity__Group__4__Impl ;
    public final void rule__RegexEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5318:1: ( rule__RegexEntity__Group__4__Impl )
            // InternalBot.g:5319:2: rule__RegexEntity__Group__4__Impl
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
    // InternalBot.g:5325:1: rule__RegexEntity__Group__4__Impl : ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__RegexEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5329:1: ( ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5330:1: ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5330:1: ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5331:2: ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5331:2: ( ( rule__RegexEntity__InputsAssignment_4 ) )
            // InternalBot.g:5332:3: ( rule__RegexEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5333:3: ( rule__RegexEntity__InputsAssignment_4 )
            // InternalBot.g:5333:4: rule__RegexEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__RegexEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5336:2: ( ( rule__RegexEntity__InputsAssignment_4 )* )
            // InternalBot.g:5337:3: ( rule__RegexEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5338:3: ( rule__RegexEntity__InputsAssignment_4 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=60 && LA50_0<=61)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:5338:4: rule__RegexEntity__InputsAssignment_4
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
    // InternalBot.g:5348:1: rule__SLanguageInput__Group__0 : rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1 ;
    public final void rule__SLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5352:1: ( rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1 )
            // InternalBot.g:5353:2: rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1
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
    // InternalBot.g:5360:1: rule__SLanguageInput__Group__0__Impl : ( ( rule__SLanguageInput__Group_0__0 )? ) ;
    public final void rule__SLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5364:1: ( ( ( rule__SLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5365:1: ( ( rule__SLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5365:1: ( ( rule__SLanguageInput__Group_0__0 )? )
            // InternalBot.g:5366:2: ( rule__SLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5367:2: ( rule__SLanguageInput__Group_0__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==60) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:5367:3: rule__SLanguageInput__Group_0__0
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
    // InternalBot.g:5375:1: rule__SLanguageInput__Group__1 : rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2 ;
    public final void rule__SLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5379:1: ( rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2 )
            // InternalBot.g:5380:2: rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2
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
    // InternalBot.g:5387:1: rule__SLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__SLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5391:1: ( ( '{' ) )
            // InternalBot.g:5392:1: ( '{' )
            {
            // InternalBot.g:5392:1: ( '{' )
            // InternalBot.g:5393:2: '{'
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
    // InternalBot.g:5402:1: rule__SLanguageInput__Group__2 : rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3 ;
    public final void rule__SLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5406:1: ( rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3 )
            // InternalBot.g:5407:2: rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3
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
    // InternalBot.g:5414:1: rule__SLanguageInput__Group__2__Impl : ( ( rule__SLanguageInput__Group_2__0 ) ) ;
    public final void rule__SLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5418:1: ( ( ( rule__SLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5419:1: ( ( rule__SLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5419:1: ( ( rule__SLanguageInput__Group_2__0 ) )
            // InternalBot.g:5420:2: ( rule__SLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5421:2: ( rule__SLanguageInput__Group_2__0 )
            // InternalBot.g:5421:3: rule__SLanguageInput__Group_2__0
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
    // InternalBot.g:5429:1: rule__SLanguageInput__Group__3 : rule__SLanguageInput__Group__3__Impl ;
    public final void rule__SLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5433:1: ( rule__SLanguageInput__Group__3__Impl )
            // InternalBot.g:5434:2: rule__SLanguageInput__Group__3__Impl
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
    // InternalBot.g:5440:1: rule__SLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__SLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5444:1: ( ( '}' ) )
            // InternalBot.g:5445:1: ( '}' )
            {
            // InternalBot.g:5445:1: ( '}' )
            // InternalBot.g:5446:2: '}'
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
    // InternalBot.g:5456:1: rule__SLanguageInput__Group_0__0 : rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1 ;
    public final void rule__SLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5460:1: ( rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1 )
            // InternalBot.g:5461:2: rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1
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
    // InternalBot.g:5468:1: rule__SLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__SLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5472:1: ( ( 'inputs' ) )
            // InternalBot.g:5473:1: ( 'inputs' )
            {
            // InternalBot.g:5473:1: ( 'inputs' )
            // InternalBot.g:5474:2: 'inputs'
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
    // InternalBot.g:5483:1: rule__SLanguageInput__Group_0__1 : rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2 ;
    public final void rule__SLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5487:1: ( rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2 )
            // InternalBot.g:5488:2: rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2
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
    // InternalBot.g:5495:1: rule__SLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__SLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5499:1: ( ( 'in' ) )
            // InternalBot.g:5500:1: ( 'in' )
            {
            // InternalBot.g:5500:1: ( 'in' )
            // InternalBot.g:5501:2: 'in'
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
    // InternalBot.g:5510:1: rule__SLanguageInput__Group_0__2 : rule__SLanguageInput__Group_0__2__Impl ;
    public final void rule__SLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5514:1: ( rule__SLanguageInput__Group_0__2__Impl )
            // InternalBot.g:5515:2: rule__SLanguageInput__Group_0__2__Impl
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
    // InternalBot.g:5521:1: rule__SLanguageInput__Group_0__2__Impl : ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__SLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5525:1: ( ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:5526:1: ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:5526:1: ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:5527:2: ( rule__SLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getSLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:5528:2: ( rule__SLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:5528:3: rule__SLanguageInput__LanguageAssignment_0_2
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
    // InternalBot.g:5537:1: rule__SLanguageInput__Group_2__0 : rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1 ;
    public final void rule__SLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5541:1: ( rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1 )
            // InternalBot.g:5542:2: rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1
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
    // InternalBot.g:5549:1: rule__SLanguageInput__Group_2__0__Impl : ( ( rule__SLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__SLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5553:1: ( ( ( rule__SLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:5554:1: ( ( rule__SLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:5554:1: ( ( rule__SLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:5555:2: ( rule__SLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:5556:2: ( rule__SLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:5556:3: rule__SLanguageInput__InputsAssignment_2_0
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
    // InternalBot.g:5564:1: rule__SLanguageInput__Group_2__1 : rule__SLanguageInput__Group_2__1__Impl ;
    public final void rule__SLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5568:1: ( rule__SLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5569:2: rule__SLanguageInput__Group_2__1__Impl
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
    // InternalBot.g:5575:1: rule__SLanguageInput__Group_2__1__Impl : ( ( rule__SLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__SLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5579:1: ( ( ( rule__SLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5580:1: ( ( rule__SLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5580:1: ( ( rule__SLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5581:2: ( rule__SLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5582:2: ( rule__SLanguageInput__InputsAssignment_2_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=RULE_STRING && LA52_0<=RULE_ID)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:5582:3: rule__SLanguageInput__InputsAssignment_2_1
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
    // InternalBot.g:5591:1: rule__CLanguageInput__Group__0 : rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1 ;
    public final void rule__CLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5595:1: ( rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1 )
            // InternalBot.g:5596:2: rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1
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
    // InternalBot.g:5603:1: rule__CLanguageInput__Group__0__Impl : ( ( rule__CLanguageInput__Group_0__0 )? ) ;
    public final void rule__CLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5607:1: ( ( ( rule__CLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5608:1: ( ( rule__CLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5608:1: ( ( rule__CLanguageInput__Group_0__0 )? )
            // InternalBot.g:5609:2: ( rule__CLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5610:2: ( rule__CLanguageInput__Group_0__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==60) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:5610:3: rule__CLanguageInput__Group_0__0
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
    // InternalBot.g:5618:1: rule__CLanguageInput__Group__1 : rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2 ;
    public final void rule__CLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5622:1: ( rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2 )
            // InternalBot.g:5623:2: rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2
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
    // InternalBot.g:5630:1: rule__CLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__CLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5634:1: ( ( '{' ) )
            // InternalBot.g:5635:1: ( '{' )
            {
            // InternalBot.g:5635:1: ( '{' )
            // InternalBot.g:5636:2: '{'
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
    // InternalBot.g:5645:1: rule__CLanguageInput__Group__2 : rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3 ;
    public final void rule__CLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5649:1: ( rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3 )
            // InternalBot.g:5650:2: rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3
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
    // InternalBot.g:5657:1: rule__CLanguageInput__Group__2__Impl : ( ( rule__CLanguageInput__Group_2__0 ) ) ;
    public final void rule__CLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5661:1: ( ( ( rule__CLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5662:1: ( ( rule__CLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5662:1: ( ( rule__CLanguageInput__Group_2__0 ) )
            // InternalBot.g:5663:2: ( rule__CLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5664:2: ( rule__CLanguageInput__Group_2__0 )
            // InternalBot.g:5664:3: rule__CLanguageInput__Group_2__0
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
    // InternalBot.g:5672:1: rule__CLanguageInput__Group__3 : rule__CLanguageInput__Group__3__Impl ;
    public final void rule__CLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5676:1: ( rule__CLanguageInput__Group__3__Impl )
            // InternalBot.g:5677:2: rule__CLanguageInput__Group__3__Impl
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
    // InternalBot.g:5683:1: rule__CLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__CLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5687:1: ( ( '}' ) )
            // InternalBot.g:5688:1: ( '}' )
            {
            // InternalBot.g:5688:1: ( '}' )
            // InternalBot.g:5689:2: '}'
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
    // InternalBot.g:5699:1: rule__CLanguageInput__Group_0__0 : rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1 ;
    public final void rule__CLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5703:1: ( rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1 )
            // InternalBot.g:5704:2: rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1
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
    // InternalBot.g:5711:1: rule__CLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__CLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5715:1: ( ( 'inputs' ) )
            // InternalBot.g:5716:1: ( 'inputs' )
            {
            // InternalBot.g:5716:1: ( 'inputs' )
            // InternalBot.g:5717:2: 'inputs'
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
    // InternalBot.g:5726:1: rule__CLanguageInput__Group_0__1 : rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2 ;
    public final void rule__CLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5730:1: ( rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2 )
            // InternalBot.g:5731:2: rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2
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
    // InternalBot.g:5738:1: rule__CLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__CLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5742:1: ( ( 'in' ) )
            // InternalBot.g:5743:1: ( 'in' )
            {
            // InternalBot.g:5743:1: ( 'in' )
            // InternalBot.g:5744:2: 'in'
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
    // InternalBot.g:5753:1: rule__CLanguageInput__Group_0__2 : rule__CLanguageInput__Group_0__2__Impl ;
    public final void rule__CLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5757:1: ( rule__CLanguageInput__Group_0__2__Impl )
            // InternalBot.g:5758:2: rule__CLanguageInput__Group_0__2__Impl
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
    // InternalBot.g:5764:1: rule__CLanguageInput__Group_0__2__Impl : ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__CLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5768:1: ( ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:5769:1: ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:5769:1: ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:5770:2: ( rule__CLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getCLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:5771:2: ( rule__CLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:5771:3: rule__CLanguageInput__LanguageAssignment_0_2
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
    // InternalBot.g:5780:1: rule__CLanguageInput__Group_2__0 : rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1 ;
    public final void rule__CLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5784:1: ( rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1 )
            // InternalBot.g:5785:2: rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1
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
    // InternalBot.g:5792:1: rule__CLanguageInput__Group_2__0__Impl : ( ( rule__CLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__CLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5796:1: ( ( ( rule__CLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:5797:1: ( ( rule__CLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:5797:1: ( ( rule__CLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:5798:2: ( rule__CLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:5799:2: ( rule__CLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:5799:3: rule__CLanguageInput__InputsAssignment_2_0
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
    // InternalBot.g:5807:1: rule__CLanguageInput__Group_2__1 : rule__CLanguageInput__Group_2__1__Impl ;
    public final void rule__CLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5811:1: ( rule__CLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5812:2: rule__CLanguageInput__Group_2__1__Impl
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
    // InternalBot.g:5818:1: rule__CLanguageInput__Group_2__1__Impl : ( ( rule__CLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__CLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5822:1: ( ( ( rule__CLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5823:1: ( ( rule__CLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5823:1: ( ( rule__CLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5824:2: ( rule__CLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5825:2: ( rule__CLanguageInput__InputsAssignment_2_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==80) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:5825:3: rule__CLanguageInput__InputsAssignment_2_1
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
    // InternalBot.g:5834:1: rule__RLanguageInput__Group__0 : rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1 ;
    public final void rule__RLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5838:1: ( rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1 )
            // InternalBot.g:5839:2: rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1
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
    // InternalBot.g:5846:1: rule__RLanguageInput__Group__0__Impl : ( ( rule__RLanguageInput__Group_0__0 )? ) ;
    public final void rule__RLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5850:1: ( ( ( rule__RLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5851:1: ( ( rule__RLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5851:1: ( ( rule__RLanguageInput__Group_0__0 )? )
            // InternalBot.g:5852:2: ( rule__RLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5853:2: ( rule__RLanguageInput__Group_0__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==60) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:5853:3: rule__RLanguageInput__Group_0__0
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
    // InternalBot.g:5861:1: rule__RLanguageInput__Group__1 : rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2 ;
    public final void rule__RLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5865:1: ( rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2 )
            // InternalBot.g:5866:2: rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2
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
    // InternalBot.g:5873:1: rule__RLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__RLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5877:1: ( ( '{' ) )
            // InternalBot.g:5878:1: ( '{' )
            {
            // InternalBot.g:5878:1: ( '{' )
            // InternalBot.g:5879:2: '{'
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
    // InternalBot.g:5888:1: rule__RLanguageInput__Group__2 : rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3 ;
    public final void rule__RLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5892:1: ( rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3 )
            // InternalBot.g:5893:2: rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3
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
    // InternalBot.g:5900:1: rule__RLanguageInput__Group__2__Impl : ( ( rule__RLanguageInput__Group_2__0 ) ) ;
    public final void rule__RLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5904:1: ( ( ( rule__RLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5905:1: ( ( rule__RLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5905:1: ( ( rule__RLanguageInput__Group_2__0 ) )
            // InternalBot.g:5906:2: ( rule__RLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5907:2: ( rule__RLanguageInput__Group_2__0 )
            // InternalBot.g:5907:3: rule__RLanguageInput__Group_2__0
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
    // InternalBot.g:5915:1: rule__RLanguageInput__Group__3 : rule__RLanguageInput__Group__3__Impl ;
    public final void rule__RLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5919:1: ( rule__RLanguageInput__Group__3__Impl )
            // InternalBot.g:5920:2: rule__RLanguageInput__Group__3__Impl
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
    // InternalBot.g:5926:1: rule__RLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__RLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5930:1: ( ( '}' ) )
            // InternalBot.g:5931:1: ( '}' )
            {
            // InternalBot.g:5931:1: ( '}' )
            // InternalBot.g:5932:2: '}'
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
    // InternalBot.g:5942:1: rule__RLanguageInput__Group_0__0 : rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1 ;
    public final void rule__RLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5946:1: ( rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1 )
            // InternalBot.g:5947:2: rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1
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
    // InternalBot.g:5954:1: rule__RLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__RLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5958:1: ( ( 'inputs' ) )
            // InternalBot.g:5959:1: ( 'inputs' )
            {
            // InternalBot.g:5959:1: ( 'inputs' )
            // InternalBot.g:5960:2: 'inputs'
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
    // InternalBot.g:5969:1: rule__RLanguageInput__Group_0__1 : rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2 ;
    public final void rule__RLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5973:1: ( rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2 )
            // InternalBot.g:5974:2: rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2
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
    // InternalBot.g:5981:1: rule__RLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__RLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5985:1: ( ( 'in' ) )
            // InternalBot.g:5986:1: ( 'in' )
            {
            // InternalBot.g:5986:1: ( 'in' )
            // InternalBot.g:5987:2: 'in'
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
    // InternalBot.g:5996:1: rule__RLanguageInput__Group_0__2 : rule__RLanguageInput__Group_0__2__Impl ;
    public final void rule__RLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6000:1: ( rule__RLanguageInput__Group_0__2__Impl )
            // InternalBot.g:6001:2: rule__RLanguageInput__Group_0__2__Impl
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
    // InternalBot.g:6007:1: rule__RLanguageInput__Group_0__2__Impl : ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__RLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6011:1: ( ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:6012:1: ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:6012:1: ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:6013:2: ( rule__RLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getRLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:6014:2: ( rule__RLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:6014:3: rule__RLanguageInput__LanguageAssignment_0_2
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
    // InternalBot.g:6023:1: rule__RLanguageInput__Group_2__0 : rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1 ;
    public final void rule__RLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6027:1: ( rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1 )
            // InternalBot.g:6028:2: rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1
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
    // InternalBot.g:6035:1: rule__RLanguageInput__Group_2__0__Impl : ( ( rule__RLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__RLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6039:1: ( ( ( rule__RLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:6040:1: ( ( rule__RLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:6040:1: ( ( rule__RLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:6041:2: ( rule__RLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:6042:2: ( rule__RLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:6042:3: rule__RLanguageInput__InputsAssignment_2_0
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
    // InternalBot.g:6050:1: rule__RLanguageInput__Group_2__1 : rule__RLanguageInput__Group_2__1__Impl ;
    public final void rule__RLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6054:1: ( rule__RLanguageInput__Group_2__1__Impl )
            // InternalBot.g:6055:2: rule__RLanguageInput__Group_2__1__Impl
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
    // InternalBot.g:6061:1: rule__RLanguageInput__Group_2__1__Impl : ( ( rule__RLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__RLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6065:1: ( ( ( rule__RLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:6066:1: ( ( rule__RLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:6066:1: ( ( rule__RLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:6067:2: ( rule__RLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:6068:2: ( rule__RLanguageInput__InputsAssignment_2_1 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==79) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBot.g:6068:3: rule__RLanguageInput__InputsAssignment_2_1
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
    // InternalBot.g:6077:1: rule__RegexInput__Group__0 : rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 ;
    public final void rule__RegexInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6081:1: ( rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 )
            // InternalBot.g:6082:2: rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1
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
    // InternalBot.g:6089:1: rule__RegexInput__Group__0__Impl : ( () ) ;
    public final void rule__RegexInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6093:1: ( ( () ) )
            // InternalBot.g:6094:1: ( () )
            {
            // InternalBot.g:6094:1: ( () )
            // InternalBot.g:6095:2: ()
            {
             before(grammarAccess.getRegexInputAccess().getRegexInputAction_0()); 
            // InternalBot.g:6096:2: ()
            // InternalBot.g:6096:3: 
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
    // InternalBot.g:6104:1: rule__RegexInput__Group__1 : rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 ;
    public final void rule__RegexInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6108:1: ( rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 )
            // InternalBot.g:6109:2: rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2
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
    // InternalBot.g:6116:1: rule__RegexInput__Group__1__Impl : ( 'pattern' ) ;
    public final void rule__RegexInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6120:1: ( ( 'pattern' ) )
            // InternalBot.g:6121:1: ( 'pattern' )
            {
            // InternalBot.g:6121:1: ( 'pattern' )
            // InternalBot.g:6122:2: 'pattern'
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
    // InternalBot.g:6131:1: rule__RegexInput__Group__2 : rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 ;
    public final void rule__RegexInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6135:1: ( rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 )
            // InternalBot.g:6136:2: rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3
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
    // InternalBot.g:6143:1: rule__RegexInput__Group__2__Impl : ( ':' ) ;
    public final void rule__RegexInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6147:1: ( ( ':' ) )
            // InternalBot.g:6148:1: ( ':' )
            {
            // InternalBot.g:6148:1: ( ':' )
            // InternalBot.g:6149:2: ':'
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
    // InternalBot.g:6158:1: rule__RegexInput__Group__3 : rule__RegexInput__Group__3__Impl ;
    public final void rule__RegexInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6162:1: ( rule__RegexInput__Group__3__Impl )
            // InternalBot.g:6163:2: rule__RegexInput__Group__3__Impl
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
    // InternalBot.g:6169:1: rule__RegexInput__Group__3__Impl : ( ( rule__RegexInput__ExpresionAssignment_3 ) ) ;
    public final void rule__RegexInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6173:1: ( ( ( rule__RegexInput__ExpresionAssignment_3 ) ) )
            // InternalBot.g:6174:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            {
            // InternalBot.g:6174:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            // InternalBot.g:6175:2: ( rule__RegexInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getRegexInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6176:2: ( rule__RegexInput__ExpresionAssignment_3 )
            // InternalBot.g:6176:3: rule__RegexInput__ExpresionAssignment_3
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
    // InternalBot.g:6185:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6189:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:6190:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
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
    // InternalBot.g:6197:1: rule__CompositeInput__Group__0__Impl : ( () ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6201:1: ( ( () ) )
            // InternalBot.g:6202:1: ( () )
            {
            // InternalBot.g:6202:1: ( () )
            // InternalBot.g:6203:2: ()
            {
             before(grammarAccess.getCompositeInputAccess().getCompositeInputAction_0()); 
            // InternalBot.g:6204:2: ()
            // InternalBot.g:6204:3: 
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
    // InternalBot.g:6212:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6216:1: ( rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 )
            // InternalBot.g:6217:2: rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2
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
    // InternalBot.g:6224:1: rule__CompositeInput__Group__1__Impl : ( 'composite' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6228:1: ( ( 'composite' ) )
            // InternalBot.g:6229:1: ( 'composite' )
            {
            // InternalBot.g:6229:1: ( 'composite' )
            // InternalBot.g:6230:2: 'composite'
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
    // InternalBot.g:6239:1: rule__CompositeInput__Group__2 : rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 ;
    public final void rule__CompositeInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6243:1: ( rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 )
            // InternalBot.g:6244:2: rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3
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
    // InternalBot.g:6251:1: rule__CompositeInput__Group__2__Impl : ( ':' ) ;
    public final void rule__CompositeInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6255:1: ( ( ':' ) )
            // InternalBot.g:6256:1: ( ':' )
            {
            // InternalBot.g:6256:1: ( ':' )
            // InternalBot.g:6257:2: ':'
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
    // InternalBot.g:6266:1: rule__CompositeInput__Group__3 : rule__CompositeInput__Group__3__Impl ;
    public final void rule__CompositeInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6270:1: ( rule__CompositeInput__Group__3__Impl )
            // InternalBot.g:6271:2: rule__CompositeInput__Group__3__Impl
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
    // InternalBot.g:6277:1: rule__CompositeInput__Group__3__Impl : ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) ;
    public final void rule__CompositeInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6281:1: ( ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) )
            // InternalBot.g:6282:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            {
            // InternalBot.g:6282:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            // InternalBot.g:6283:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            {
            // InternalBot.g:6283:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) )
            // InternalBot.g:6284:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6285:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            // InternalBot.g:6285:4: rule__CompositeInput__ExpresionAssignment_3
            {
            pushFollow(FOLLOW_58);
            rule__CompositeInput__ExpresionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 

            }

            // InternalBot.g:6288:2: ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            // InternalBot.g:6289:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6290:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_STRING && LA57_0<=RULE_ID)||LA57_0==71) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBot.g:6290:4: rule__CompositeInput__ExpresionAssignment_3
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
    // InternalBot.g:6300:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6304:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:6305:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
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
    // InternalBot.g:6312:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6316:1: ( ( () ) )
            // InternalBot.g:6317:1: ( () )
            {
            // InternalBot.g:6317:1: ( () )
            // InternalBot.g:6318:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:6319:2: ()
            // InternalBot.g:6319:3: 
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
    // InternalBot.g:6327:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6331:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:6332:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
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
    // InternalBot.g:6339:1: rule__SimpleInput__Group__1__Impl : ( ( rule__SimpleInput__NameAssignment_1 ) ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6343:1: ( ( ( rule__SimpleInput__NameAssignment_1 ) ) )
            // InternalBot.g:6344:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            {
            // InternalBot.g:6344:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            // InternalBot.g:6345:2: ( rule__SimpleInput__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 
            // InternalBot.g:6346:2: ( rule__SimpleInput__NameAssignment_1 )
            // InternalBot.g:6346:3: rule__SimpleInput__NameAssignment_1
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
    // InternalBot.g:6354:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6358:1: ( rule__SimpleInput__Group__2__Impl )
            // InternalBot.g:6359:2: rule__SimpleInput__Group__2__Impl
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
    // InternalBot.g:6365:1: rule__SimpleInput__Group__2__Impl : ( ( rule__SimpleInput__Group_2__0 )? ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6369:1: ( ( ( rule__SimpleInput__Group_2__0 )? ) )
            // InternalBot.g:6370:1: ( ( rule__SimpleInput__Group_2__0 )? )
            {
            // InternalBot.g:6370:1: ( ( rule__SimpleInput__Group_2__0 )? )
            // InternalBot.g:6371:2: ( rule__SimpleInput__Group_2__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2()); 
            // InternalBot.g:6372:2: ( rule__SimpleInput__Group_2__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==81) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:6372:3: rule__SimpleInput__Group_2__0
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
    // InternalBot.g:6381:1: rule__SimpleInput__Group_2__0 : rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 ;
    public final void rule__SimpleInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6385:1: ( rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 )
            // InternalBot.g:6386:2: rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1
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
    // InternalBot.g:6393:1: rule__SimpleInput__Group_2__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6397:1: ( ( 'synonyms' ) )
            // InternalBot.g:6398:1: ( 'synonyms' )
            {
            // InternalBot.g:6398:1: ( 'synonyms' )
            // InternalBot.g:6399:2: 'synonyms'
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
    // InternalBot.g:6408:1: rule__SimpleInput__Group_2__1 : rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 ;
    public final void rule__SimpleInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6412:1: ( rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 )
            // InternalBot.g:6413:2: rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2
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
    // InternalBot.g:6420:1: rule__SimpleInput__Group_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6424:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) )
            // InternalBot.g:6425:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            {
            // InternalBot.g:6425:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            // InternalBot.g:6426:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 
            // InternalBot.g:6427:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            // InternalBot.g:6427:3: rule__SimpleInput__ValuesAssignment_2_1
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
    // InternalBot.g:6435:1: rule__SimpleInput__Group_2__2 : rule__SimpleInput__Group_2__2__Impl ;
    public final void rule__SimpleInput__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6439:1: ( rule__SimpleInput__Group_2__2__Impl )
            // InternalBot.g:6440:2: rule__SimpleInput__Group_2__2__Impl
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
    // InternalBot.g:6446:1: rule__SimpleInput__Group_2__2__Impl : ( ( rule__SimpleInput__Group_2_2__0 )* ) ;
    public final void rule__SimpleInput__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6450:1: ( ( ( rule__SimpleInput__Group_2_2__0 )* ) )
            // InternalBot.g:6451:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            {
            // InternalBot.g:6451:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            // InternalBot.g:6452:2: ( rule__SimpleInput__Group_2_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 
            // InternalBot.g:6453:2: ( rule__SimpleInput__Group_2_2__0 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==54) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBot.g:6453:3: rule__SimpleInput__Group_2_2__0
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
    // InternalBot.g:6462:1: rule__SimpleInput__Group_2_2__0 : rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 ;
    public final void rule__SimpleInput__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6466:1: ( rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 )
            // InternalBot.g:6467:2: rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1
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
    // InternalBot.g:6474:1: rule__SimpleInput__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6478:1: ( ( ',' ) )
            // InternalBot.g:6479:1: ( ',' )
            {
            // InternalBot.g:6479:1: ( ',' )
            // InternalBot.g:6480:2: ','
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
    // InternalBot.g:6489:1: rule__SimpleInput__Group_2_2__1 : rule__SimpleInput__Group_2_2__1__Impl ;
    public final void rule__SimpleInput__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6493:1: ( rule__SimpleInput__Group_2_2__1__Impl )
            // InternalBot.g:6494:2: rule__SimpleInput__Group_2_2__1__Impl
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
    // InternalBot.g:6500:1: rule__SimpleInput__Group_2_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6504:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) )
            // InternalBot.g:6505:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            {
            // InternalBot.g:6505:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            // InternalBot.g:6506:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 
            // InternalBot.g:6507:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            // InternalBot.g:6507:3: rule__SimpleInput__ValuesAssignment_2_2_1
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
    // InternalBot.g:6516:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6520:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:6521:2: rule__Text__Group__0__Impl rule__Text__Group__1
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
    // InternalBot.g:6528:1: rule__Text__Group__0__Impl : ( 'text' ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6532:1: ( ( 'text' ) )
            // InternalBot.g:6533:1: ( 'text' )
            {
            // InternalBot.g:6533:1: ( 'text' )
            // InternalBot.g:6534:2: 'text'
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
    // InternalBot.g:6543:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6547:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:6548:2: rule__Text__Group__1__Impl rule__Text__Group__2
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
    // InternalBot.g:6555:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6559:1: ( ( 'response' ) )
            // InternalBot.g:6560:1: ( 'response' )
            {
            // InternalBot.g:6560:1: ( 'response' )
            // InternalBot.g:6561:2: 'response'
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
    // InternalBot.g:6570:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6574:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:6575:2: rule__Text__Group__2__Impl rule__Text__Group__3
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
    // InternalBot.g:6582:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6586:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:6587:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:6587:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:6588:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:6589:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:6589:3: rule__Text__NameAssignment_2
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
    // InternalBot.g:6597:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6601:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:6602:2: rule__Text__Group__3__Impl rule__Text__Group__4
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
    // InternalBot.g:6609:1: rule__Text__Group__3__Impl : ( ':' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6613:1: ( ( ':' ) )
            // InternalBot.g:6614:1: ( ':' )
            {
            // InternalBot.g:6614:1: ( ':' )
            // InternalBot.g:6615:2: ':'
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
    // InternalBot.g:6624:1: rule__Text__Group__4 : rule__Text__Group__4__Impl ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6628:1: ( rule__Text__Group__4__Impl )
            // InternalBot.g:6629:2: rule__Text__Group__4__Impl
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
    // InternalBot.g:6635:1: rule__Text__Group__4__Impl : ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6639:1: ( ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) )
            // InternalBot.g:6640:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:6640:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            // InternalBot.g:6641:2: ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* )
            {
            // InternalBot.g:6641:2: ( ( rule__Text__InputsAssignment_4 ) )
            // InternalBot.g:6642:3: ( rule__Text__InputsAssignment_4 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:6643:3: ( rule__Text__InputsAssignment_4 )
            // InternalBot.g:6643:4: rule__Text__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__Text__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:6646:2: ( ( rule__Text__InputsAssignment_4 )* )
            // InternalBot.g:6647:3: ( rule__Text__InputsAssignment_4 )*
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:6648:3: ( rule__Text__InputsAssignment_4 )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( ((LA60_0>=60 && LA60_0<=61)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBot.g:6648:4: rule__Text__InputsAssignment_4
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
    // InternalBot.g:6658:1: rule__TextLanguageInput__Group__0 : rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 ;
    public final void rule__TextLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6662:1: ( rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 )
            // InternalBot.g:6663:2: rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1
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
    // InternalBot.g:6670:1: rule__TextLanguageInput__Group__0__Impl : ( ( rule__TextLanguageInput__Group_0__0 )? ) ;
    public final void rule__TextLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6674:1: ( ( ( rule__TextLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:6675:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:6675:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            // InternalBot.g:6676:2: ( rule__TextLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:6677:2: ( rule__TextLanguageInput__Group_0__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==60) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalBot.g:6677:3: rule__TextLanguageInput__Group_0__0
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
    // InternalBot.g:6685:1: rule__TextLanguageInput__Group__1 : rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 ;
    public final void rule__TextLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6689:1: ( rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 )
            // InternalBot.g:6690:2: rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2
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
    // InternalBot.g:6697:1: rule__TextLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__TextLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6701:1: ( ( '{' ) )
            // InternalBot.g:6702:1: ( '{' )
            {
            // InternalBot.g:6702:1: ( '{' )
            // InternalBot.g:6703:2: '{'
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
    // InternalBot.g:6712:1: rule__TextLanguageInput__Group__2 : rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 ;
    public final void rule__TextLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6716:1: ( rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 )
            // InternalBot.g:6717:2: rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3
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
    // InternalBot.g:6724:1: rule__TextLanguageInput__Group__2__Impl : ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) ;
    public final void rule__TextLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6728:1: ( ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) )
            // InternalBot.g:6729:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            {
            // InternalBot.g:6729:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            // InternalBot.g:6730:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 
            // InternalBot.g:6731:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            // InternalBot.g:6731:3: rule__TextLanguageInput__InputsAssignment_2
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
    // InternalBot.g:6739:1: rule__TextLanguageInput__Group__3 : rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 ;
    public final void rule__TextLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6743:1: ( rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 )
            // InternalBot.g:6744:2: rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4
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
    // InternalBot.g:6751:1: rule__TextLanguageInput__Group__3__Impl : ( ( rule__TextLanguageInput__Group_3__0 )* ) ;
    public final void rule__TextLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6755:1: ( ( ( rule__TextLanguageInput__Group_3__0 )* ) )
            // InternalBot.g:6756:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            {
            // InternalBot.g:6756:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            // InternalBot.g:6757:2: ( rule__TextLanguageInput__Group_3__0 )*
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 
            // InternalBot.g:6758:2: ( rule__TextLanguageInput__Group_3__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==54) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBot.g:6758:3: rule__TextLanguageInput__Group_3__0
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
    // InternalBot.g:6766:1: rule__TextLanguageInput__Group__4 : rule__TextLanguageInput__Group__4__Impl ;
    public final void rule__TextLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6770:1: ( rule__TextLanguageInput__Group__4__Impl )
            // InternalBot.g:6771:2: rule__TextLanguageInput__Group__4__Impl
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
    // InternalBot.g:6777:1: rule__TextLanguageInput__Group__4__Impl : ( '}' ) ;
    public final void rule__TextLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6781:1: ( ( '}' ) )
            // InternalBot.g:6782:1: ( '}' )
            {
            // InternalBot.g:6782:1: ( '}' )
            // InternalBot.g:6783:2: '}'
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
    // InternalBot.g:6793:1: rule__TextLanguageInput__Group_0__0 : rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 ;
    public final void rule__TextLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6797:1: ( rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 )
            // InternalBot.g:6798:2: rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1
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
    // InternalBot.g:6805:1: rule__TextLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6809:1: ( ( 'inputs' ) )
            // InternalBot.g:6810:1: ( 'inputs' )
            {
            // InternalBot.g:6810:1: ( 'inputs' )
            // InternalBot.g:6811:2: 'inputs'
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
    // InternalBot.g:6820:1: rule__TextLanguageInput__Group_0__1 : rule__TextLanguageInput__Group_0__1__Impl ;
    public final void rule__TextLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6824:1: ( rule__TextLanguageInput__Group_0__1__Impl )
            // InternalBot.g:6825:2: rule__TextLanguageInput__Group_0__1__Impl
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
    // InternalBot.g:6831:1: rule__TextLanguageInput__Group_0__1__Impl : ( ( rule__TextLanguageInput__Group_0_1__0 )? ) ;
    public final void rule__TextLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6835:1: ( ( ( rule__TextLanguageInput__Group_0_1__0 )? ) )
            // InternalBot.g:6836:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            {
            // InternalBot.g:6836:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            // InternalBot.g:6837:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 
            // InternalBot.g:6838:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==63) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalBot.g:6838:3: rule__TextLanguageInput__Group_0_1__0
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
    // InternalBot.g:6847:1: rule__TextLanguageInput__Group_0_1__0 : rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 ;
    public final void rule__TextLanguageInput__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6851:1: ( rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 )
            // InternalBot.g:6852:2: rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1
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
    // InternalBot.g:6859:1: rule__TextLanguageInput__Group_0_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInput__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6863:1: ( ( 'in' ) )
            // InternalBot.g:6864:1: ( 'in' )
            {
            // InternalBot.g:6864:1: ( 'in' )
            // InternalBot.g:6865:2: 'in'
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
    // InternalBot.g:6874:1: rule__TextLanguageInput__Group_0_1__1 : rule__TextLanguageInput__Group_0_1__1__Impl ;
    public final void rule__TextLanguageInput__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6878:1: ( rule__TextLanguageInput__Group_0_1__1__Impl )
            // InternalBot.g:6879:2: rule__TextLanguageInput__Group_0_1__1__Impl
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
    // InternalBot.g:6885:1: rule__TextLanguageInput__Group_0_1__1__Impl : ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) ;
    public final void rule__TextLanguageInput__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6889:1: ( ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) )
            // InternalBot.g:6890:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            {
            // InternalBot.g:6890:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            // InternalBot.g:6891:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 
            // InternalBot.g:6892:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            // InternalBot.g:6892:3: rule__TextLanguageInput__LanguageAssignment_0_1_1
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
    // InternalBot.g:6901:1: rule__TextLanguageInput__Group_3__0 : rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 ;
    public final void rule__TextLanguageInput__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6905:1: ( rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 )
            // InternalBot.g:6906:2: rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1
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
    // InternalBot.g:6913:1: rule__TextLanguageInput__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInput__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6917:1: ( ( ',' ) )
            // InternalBot.g:6918:1: ( ',' )
            {
            // InternalBot.g:6918:1: ( ',' )
            // InternalBot.g:6919:2: ','
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
    // InternalBot.g:6928:1: rule__TextLanguageInput__Group_3__1 : rule__TextLanguageInput__Group_3__1__Impl ;
    public final void rule__TextLanguageInput__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6932:1: ( rule__TextLanguageInput__Group_3__1__Impl )
            // InternalBot.g:6933:2: rule__TextLanguageInput__Group_3__1__Impl
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
    // InternalBot.g:6939:1: rule__TextLanguageInput__Group_3__1__Impl : ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) ;
    public final void rule__TextLanguageInput__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6943:1: ( ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) )
            // InternalBot.g:6944:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            {
            // InternalBot.g:6944:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            // InternalBot.g:6945:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 
            // InternalBot.g:6946:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            // InternalBot.g:6946:3: rule__TextLanguageInput__InputsAssignment_3_1
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
    // InternalBot.g:6955:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6959:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:6960:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
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
    // InternalBot.g:6967:1: rule__HTTPResponse__Group__0__Impl : ( 'Response' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6971:1: ( ( 'Response' ) )
            // InternalBot.g:6972:1: ( 'Response' )
            {
            // InternalBot.g:6972:1: ( 'Response' )
            // InternalBot.g:6973:2: 'Response'
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
    // InternalBot.g:6982:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6986:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:6987:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
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
    // InternalBot.g:6994:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6998:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:6999:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:6999:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:7000:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:7001:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:7001:3: rule__HTTPResponse__NameAssignment_1
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
    // InternalBot.g:7009:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7013:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:7014:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
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
    // InternalBot.g:7021:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7025:1: ( ( ':' ) )
            // InternalBot.g:7026:1: ( ':' )
            {
            // InternalBot.g:7026:1: ( ':' )
            // InternalBot.g:7027:2: ':'
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
    // InternalBot.g:7036:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7040:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:7041:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
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
    // InternalBot.g:7048:1: rule__HTTPResponse__Group__3__Impl : ( 'Request' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7052:1: ( ( 'Request' ) )
            // InternalBot.g:7053:1: ( 'Request' )
            {
            // InternalBot.g:7053:1: ( 'Request' )
            // InternalBot.g:7054:2: 'Request'
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
    // InternalBot.g:7063:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7067:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:7068:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
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
    // InternalBot.g:7075:1: rule__HTTPResponse__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7079:1: ( ( ':' ) )
            // InternalBot.g:7080:1: ( ':' )
            {
            // InternalBot.g:7080:1: ( ':' )
            // InternalBot.g:7081:2: ':'
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
    // InternalBot.g:7090:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7094:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:7095:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
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
    // InternalBot.g:7102:1: rule__HTTPResponse__Group__5__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7106:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) ) )
            // InternalBot.g:7107:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) )
            {
            // InternalBot.g:7107:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) )
            // InternalBot.g:7108:2: ( rule__HTTPResponse__HTTPRequestAssignment_5 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_5()); 
            // InternalBot.g:7109:2: ( rule__HTTPResponse__HTTPRequestAssignment_5 )
            // InternalBot.g:7109:3: rule__HTTPResponse__HTTPRequestAssignment_5
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
    // InternalBot.g:7117:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7121:1: ( rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 )
            // InternalBot.g:7122:2: rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7
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
    // InternalBot.g:7129:1: rule__HTTPResponse__Group__6__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7133:1: ( ( ';' ) )
            // InternalBot.g:7134:1: ( ';' )
            {
            // InternalBot.g:7134:1: ( ';' )
            // InternalBot.g:7135:2: ';'
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
    // InternalBot.g:7144:1: rule__HTTPResponse__Group__7 : rule__HTTPResponse__Group__7__Impl ;
    public final void rule__HTTPResponse__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7148:1: ( rule__HTTPResponse__Group__7__Impl )
            // InternalBot.g:7149:2: rule__HTTPResponse__Group__7__Impl
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
    // InternalBot.g:7155:1: rule__HTTPResponse__Group__7__Impl : ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) ) ;
    public final void rule__HTTPResponse__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7159:1: ( ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) ) )
            // InternalBot.g:7160:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) )
            {
            // InternalBot.g:7160:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) )
            // InternalBot.g:7161:2: ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* )
            {
            // InternalBot.g:7161:2: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            // InternalBot.g:7162:3: ( rule__HTTPResponse__InputsAssignment_7 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:7163:3: ( rule__HTTPResponse__InputsAssignment_7 )
            // InternalBot.g:7163:4: rule__HTTPResponse__InputsAssignment_7
            {
            pushFollow(FOLLOW_23);
            rule__HTTPResponse__InputsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 

            }

            // InternalBot.g:7166:2: ( ( rule__HTTPResponse__InputsAssignment_7 )* )
            // InternalBot.g:7167:3: ( rule__HTTPResponse__InputsAssignment_7 )*
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:7168:3: ( rule__HTTPResponse__InputsAssignment_7 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==60) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBot.g:7168:4: rule__HTTPResponse__InputsAssignment_7
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
    // InternalBot.g:7178:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7182:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:7183:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
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
    // InternalBot.g:7190:1: rule__HTTPRequest__Group__0__Impl : ( 'Request' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7194:1: ( ( 'Request' ) )
            // InternalBot.g:7195:1: ( 'Request' )
            {
            // InternalBot.g:7195:1: ( 'Request' )
            // InternalBot.g:7196:2: 'Request'
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
    // InternalBot.g:7205:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7209:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:7210:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
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
    // InternalBot.g:7217:1: rule__HTTPRequest__Group__1__Impl : ( ( rule__HTTPRequest__MethodAssignment_1 ) ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7221:1: ( ( ( rule__HTTPRequest__MethodAssignment_1 ) ) )
            // InternalBot.g:7222:1: ( ( rule__HTTPRequest__MethodAssignment_1 ) )
            {
            // InternalBot.g:7222:1: ( ( rule__HTTPRequest__MethodAssignment_1 ) )
            // InternalBot.g:7223:2: ( rule__HTTPRequest__MethodAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_1()); 
            // InternalBot.g:7224:2: ( rule__HTTPRequest__MethodAssignment_1 )
            // InternalBot.g:7224:3: rule__HTTPRequest__MethodAssignment_1
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
    // InternalBot.g:7232:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7236:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:7237:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
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
    // InternalBot.g:7244:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__NameAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7248:1: ( ( ( rule__HTTPRequest__NameAssignment_2 ) ) )
            // InternalBot.g:7249:1: ( ( rule__HTTPRequest__NameAssignment_2 ) )
            {
            // InternalBot.g:7249:1: ( ( rule__HTTPRequest__NameAssignment_2 ) )
            // InternalBot.g:7250:2: ( rule__HTTPRequest__NameAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_2()); 
            // InternalBot.g:7251:2: ( rule__HTTPRequest__NameAssignment_2 )
            // InternalBot.g:7251:3: rule__HTTPRequest__NameAssignment_2
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
    // InternalBot.g:7259:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7263:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:7264:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
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
    // InternalBot.g:7271:1: rule__HTTPRequest__Group__3__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7275:1: ( ( ':' ) )
            // InternalBot.g:7276:1: ( ':' )
            {
            // InternalBot.g:7276:1: ( ':' )
            // InternalBot.g:7277:2: ':'
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
    // InternalBot.g:7286:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7290:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:7291:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
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
    // InternalBot.g:7298:1: rule__HTTPRequest__Group__4__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7302:1: ( ( 'URL' ) )
            // InternalBot.g:7303:1: ( 'URL' )
            {
            // InternalBot.g:7303:1: ( 'URL' )
            // InternalBot.g:7304:2: 'URL'
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
    // InternalBot.g:7313:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7317:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:7318:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
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
    // InternalBot.g:7325:1: rule__HTTPRequest__Group__5__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7329:1: ( ( ':' ) )
            // InternalBot.g:7330:1: ( ':' )
            {
            // InternalBot.g:7330:1: ( ':' )
            // InternalBot.g:7331:2: ':'
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
    // InternalBot.g:7340:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7344:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:7345:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
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
    // InternalBot.g:7352:1: rule__HTTPRequest__Group__6__Impl : ( ( rule__HTTPRequest__URLAssignment_6 ) ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7356:1: ( ( ( rule__HTTPRequest__URLAssignment_6 ) ) )
            // InternalBot.g:7357:1: ( ( rule__HTTPRequest__URLAssignment_6 ) )
            {
            // InternalBot.g:7357:1: ( ( rule__HTTPRequest__URLAssignment_6 ) )
            // InternalBot.g:7358:2: ( rule__HTTPRequest__URLAssignment_6 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_6()); 
            // InternalBot.g:7359:2: ( rule__HTTPRequest__URLAssignment_6 )
            // InternalBot.g:7359:3: rule__HTTPRequest__URLAssignment_6
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
    // InternalBot.g:7367:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7371:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:7372:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
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
    // InternalBot.g:7379:1: rule__HTTPRequest__Group__7__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7383:1: ( ( ';' ) )
            // InternalBot.g:7384:1: ( ';' )
            {
            // InternalBot.g:7384:1: ( ';' )
            // InternalBot.g:7385:2: ';'
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
    // InternalBot.g:7394:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7398:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:7399:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
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
    // InternalBot.g:7406:1: rule__HTTPRequest__Group__8__Impl : ( ( rule__HTTPRequest__Group_8__0 )? ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7410:1: ( ( ( rule__HTTPRequest__Group_8__0 )? ) )
            // InternalBot.g:7411:1: ( ( rule__HTTPRequest__Group_8__0 )? )
            {
            // InternalBot.g:7411:1: ( ( rule__HTTPRequest__Group_8__0 )? )
            // InternalBot.g:7412:2: ( rule__HTTPRequest__Group_8__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_8()); 
            // InternalBot.g:7413:2: ( rule__HTTPRequest__Group_8__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==86) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBot.g:7413:3: rule__HTTPRequest__Group_8__0
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
    // InternalBot.g:7421:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7425:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:7426:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
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
    // InternalBot.g:7433:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7437:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:7438:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:7438:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:7439:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:7440:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==87) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalBot.g:7440:3: rule__HTTPRequest__Group_9__0
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
    // InternalBot.g:7448:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7452:1: ( rule__HTTPRequest__Group__10__Impl )
            // InternalBot.g:7453:2: rule__HTTPRequest__Group__10__Impl
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
    // InternalBot.g:7459:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7463:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:7464:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:7464:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:7465:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:7466:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==18) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalBot.g:7466:3: rule__HTTPRequest__Group_10__0
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
    // InternalBot.g:7475:1: rule__HTTPRequest__Group_8__0 : rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1 ;
    public final void rule__HTTPRequest__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7479:1: ( rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1 )
            // InternalBot.g:7480:2: rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1
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
    // InternalBot.g:7487:1: rule__HTTPRequest__Group_8__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7491:1: ( ( 'basicAuth' ) )
            // InternalBot.g:7492:1: ( 'basicAuth' )
            {
            // InternalBot.g:7492:1: ( 'basicAuth' )
            // InternalBot.g:7493:2: 'basicAuth'
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
    // InternalBot.g:7502:1: rule__HTTPRequest__Group_8__1 : rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2 ;
    public final void rule__HTTPRequest__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7506:1: ( rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2 )
            // InternalBot.g:7507:2: rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2
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
    // InternalBot.g:7514:1: rule__HTTPRequest__Group_8__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7518:1: ( ( ':' ) )
            // InternalBot.g:7519:1: ( ':' )
            {
            // InternalBot.g:7519:1: ( ':' )
            // InternalBot.g:7520:2: ':'
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
    // InternalBot.g:7529:1: rule__HTTPRequest__Group_8__2 : rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3 ;
    public final void rule__HTTPRequest__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7533:1: ( rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3 )
            // InternalBot.g:7534:2: rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3
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
    // InternalBot.g:7541:1: rule__HTTPRequest__Group_8__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) ) ;
    public final void rule__HTTPRequest__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7545:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) ) )
            // InternalBot.g:7546:1: ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) )
            {
            // InternalBot.g:7546:1: ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) )
            // InternalBot.g:7547:2: ( rule__HTTPRequest__BasicAuthAssignment_8_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_8_2()); 
            // InternalBot.g:7548:2: ( rule__HTTPRequest__BasicAuthAssignment_8_2 )
            // InternalBot.g:7548:3: rule__HTTPRequest__BasicAuthAssignment_8_2
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
    // InternalBot.g:7556:1: rule__HTTPRequest__Group_8__3 : rule__HTTPRequest__Group_8__3__Impl ;
    public final void rule__HTTPRequest__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7560:1: ( rule__HTTPRequest__Group_8__3__Impl )
            // InternalBot.g:7561:2: rule__HTTPRequest__Group_8__3__Impl
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
    // InternalBot.g:7567:1: rule__HTTPRequest__Group_8__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7571:1: ( ( ';' ) )
            // InternalBot.g:7572:1: ( ';' )
            {
            // InternalBot.g:7572:1: ( ';' )
            // InternalBot.g:7573:2: ';'
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
    // InternalBot.g:7583:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7587:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:7588:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
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
    // InternalBot.g:7595:1: rule__HTTPRequest__Group_9__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7599:1: ( ( 'headers' ) )
            // InternalBot.g:7600:1: ( 'headers' )
            {
            // InternalBot.g:7600:1: ( 'headers' )
            // InternalBot.g:7601:2: 'headers'
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
    // InternalBot.g:7610:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7614:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:7615:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
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
    // InternalBot.g:7622:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7626:1: ( ( ':' ) )
            // InternalBot.g:7627:1: ( ':' )
            {
            // InternalBot.g:7627:1: ( ':' )
            // InternalBot.g:7628:2: ':'
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
    // InternalBot.g:7637:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7641:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:7642:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
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
    // InternalBot.g:7649:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7653:1: ( ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) ) )
            // InternalBot.g:7654:1: ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) )
            {
            // InternalBot.g:7654:1: ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) )
            // InternalBot.g:7655:2: ( rule__HTTPRequest__HeadersAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_2()); 
            // InternalBot.g:7656:2: ( rule__HTTPRequest__HeadersAssignment_9_2 )
            // InternalBot.g:7656:3: rule__HTTPRequest__HeadersAssignment_9_2
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
    // InternalBot.g:7664:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4 ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7668:1: ( rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4 )
            // InternalBot.g:7669:2: rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4
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
    // InternalBot.g:7676:1: rule__HTTPRequest__Group_9__3__Impl : ( ( rule__HTTPRequest__Group_9_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7680:1: ( ( ( rule__HTTPRequest__Group_9_3__0 )* ) )
            // InternalBot.g:7681:1: ( ( rule__HTTPRequest__Group_9_3__0 )* )
            {
            // InternalBot.g:7681:1: ( ( rule__HTTPRequest__Group_9_3__0 )* )
            // InternalBot.g:7682:2: ( rule__HTTPRequest__Group_9_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9_3()); 
            // InternalBot.g:7683:2: ( rule__HTTPRequest__Group_9_3__0 )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==54) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalBot.g:7683:3: rule__HTTPRequest__Group_9_3__0
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
    // InternalBot.g:7691:1: rule__HTTPRequest__Group_9__4 : rule__HTTPRequest__Group_9__4__Impl ;
    public final void rule__HTTPRequest__Group_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7695:1: ( rule__HTTPRequest__Group_9__4__Impl )
            // InternalBot.g:7696:2: rule__HTTPRequest__Group_9__4__Impl
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
    // InternalBot.g:7702:1: rule__HTTPRequest__Group_9__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7706:1: ( ( ';' ) )
            // InternalBot.g:7707:1: ( ';' )
            {
            // InternalBot.g:7707:1: ( ';' )
            // InternalBot.g:7708:2: ';'
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
    // InternalBot.g:7718:1: rule__HTTPRequest__Group_9_3__0 : rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1 ;
    public final void rule__HTTPRequest__Group_9_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7722:1: ( rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1 )
            // InternalBot.g:7723:2: rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1
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
    // InternalBot.g:7730:1: rule__HTTPRequest__Group_9_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_9_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7734:1: ( ( ',' ) )
            // InternalBot.g:7735:1: ( ',' )
            {
            // InternalBot.g:7735:1: ( ',' )
            // InternalBot.g:7736:2: ','
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
    // InternalBot.g:7745:1: rule__HTTPRequest__Group_9_3__1 : rule__HTTPRequest__Group_9_3__1__Impl ;
    public final void rule__HTTPRequest__Group_9_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7749:1: ( rule__HTTPRequest__Group_9_3__1__Impl )
            // InternalBot.g:7750:2: rule__HTTPRequest__Group_9_3__1__Impl
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
    // InternalBot.g:7756:1: rule__HTTPRequest__Group_9_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_9_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7760:1: ( ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) ) )
            // InternalBot.g:7761:1: ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) )
            {
            // InternalBot.g:7761:1: ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) )
            // InternalBot.g:7762:2: ( rule__HTTPRequest__HeadersAssignment_9_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_3_1()); 
            // InternalBot.g:7763:2: ( rule__HTTPRequest__HeadersAssignment_9_3_1 )
            // InternalBot.g:7763:3: rule__HTTPRequest__HeadersAssignment_9_3_1
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
    // InternalBot.g:7772:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7776:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:7777:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
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
    // InternalBot.g:7784:1: rule__HTTPRequest__Group_10__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7788:1: ( ( 'data' ) )
            // InternalBot.g:7789:1: ( 'data' )
            {
            // InternalBot.g:7789:1: ( 'data' )
            // InternalBot.g:7790:2: 'data'
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
    // InternalBot.g:7799:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7803:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:7804:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
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
    // InternalBot.g:7811:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7815:1: ( ( ':' ) )
            // InternalBot.g:7816:1: ( ':' )
            {
            // InternalBot.g:7816:1: ( ':' )
            // InternalBot.g:7817:2: ':'
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
    // InternalBot.g:7826:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7830:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:7831:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
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
    // InternalBot.g:7838:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__DataAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7842:1: ( ( ( rule__HTTPRequest__DataAssignment_10_2 ) ) )
            // InternalBot.g:7843:1: ( ( rule__HTTPRequest__DataAssignment_10_2 ) )
            {
            // InternalBot.g:7843:1: ( ( rule__HTTPRequest__DataAssignment_10_2 ) )
            // InternalBot.g:7844:2: ( rule__HTTPRequest__DataAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_2()); 
            // InternalBot.g:7845:2: ( rule__HTTPRequest__DataAssignment_10_2 )
            // InternalBot.g:7845:3: rule__HTTPRequest__DataAssignment_10_2
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
    // InternalBot.g:7853:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7857:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:7858:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
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
    // InternalBot.g:7865:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7869:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:7870:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:7870:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:7871:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:7872:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==54) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalBot.g:7872:3: rule__HTTPRequest__Group_10_3__0
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
    // InternalBot.g:7880:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5 ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7884:1: ( rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5 )
            // InternalBot.g:7885:2: rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5
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
    // InternalBot.g:7892:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7896:1: ( ( ';' ) )
            // InternalBot.g:7897:1: ( ';' )
            {
            // InternalBot.g:7897:1: ( ';' )
            // InternalBot.g:7898:2: ';'
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
    // InternalBot.g:7907:1: rule__HTTPRequest__Group_10__5 : rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6 ;
    public final void rule__HTTPRequest__Group_10__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7911:1: ( rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6 )
            // InternalBot.g:7912:2: rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6
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
    // InternalBot.g:7919:1: rule__HTTPRequest__Group_10__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_10__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7923:1: ( ( 'dataType' ) )
            // InternalBot.g:7924:1: ( 'dataType' )
            {
            // InternalBot.g:7924:1: ( 'dataType' )
            // InternalBot.g:7925:2: 'dataType'
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
    // InternalBot.g:7934:1: rule__HTTPRequest__Group_10__6 : rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7 ;
    public final void rule__HTTPRequest__Group_10__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7938:1: ( rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7 )
            // InternalBot.g:7939:2: rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7
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
    // InternalBot.g:7946:1: rule__HTTPRequest__Group_10__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7950:1: ( ( ':' ) )
            // InternalBot.g:7951:1: ( ':' )
            {
            // InternalBot.g:7951:1: ( ':' )
            // InternalBot.g:7952:2: ':'
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
    // InternalBot.g:7961:1: rule__HTTPRequest__Group_10__7 : rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8 ;
    public final void rule__HTTPRequest__Group_10__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7965:1: ( rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8 )
            // InternalBot.g:7966:2: rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8
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
    // InternalBot.g:7973:1: rule__HTTPRequest__Group_10__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) ) ;
    public final void rule__HTTPRequest__Group_10__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7977:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) ) )
            // InternalBot.g:7978:1: ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) )
            {
            // InternalBot.g:7978:1: ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) )
            // InternalBot.g:7979:2: ( rule__HTTPRequest__DataTypeAssignment_10_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_10_7()); 
            // InternalBot.g:7980:2: ( rule__HTTPRequest__DataTypeAssignment_10_7 )
            // InternalBot.g:7980:3: rule__HTTPRequest__DataTypeAssignment_10_7
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
    // InternalBot.g:7988:1: rule__HTTPRequest__Group_10__8 : rule__HTTPRequest__Group_10__8__Impl ;
    public final void rule__HTTPRequest__Group_10__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7992:1: ( rule__HTTPRequest__Group_10__8__Impl )
            // InternalBot.g:7993:2: rule__HTTPRequest__Group_10__8__Impl
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
    // InternalBot.g:7999:1: rule__HTTPRequest__Group_10__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8003:1: ( ( ';' ) )
            // InternalBot.g:8004:1: ( ';' )
            {
            // InternalBot.g:8004:1: ( ';' )
            // InternalBot.g:8005:2: ';'
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
    // InternalBot.g:8015:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8019:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:8020:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
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
    // InternalBot.g:8027:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8031:1: ( ( ',' ) )
            // InternalBot.g:8032:1: ( ',' )
            {
            // InternalBot.g:8032:1: ( ',' )
            // InternalBot.g:8033:2: ','
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
    // InternalBot.g:8042:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8046:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:8047:2: rule__HTTPRequest__Group_10_3__1__Impl
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
    // InternalBot.g:8053:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8057:1: ( ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) ) )
            // InternalBot.g:8058:1: ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) )
            {
            // InternalBot.g:8058:1: ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) )
            // InternalBot.g:8059:2: ( rule__HTTPRequest__DataAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_3_1()); 
            // InternalBot.g:8060:2: ( rule__HTTPRequest__DataAssignment_10_3_1 )
            // InternalBot.g:8060:3: rule__HTTPRequest__DataAssignment_10_3_1
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
    // InternalBot.g:8069:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8073:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:8074:2: rule__Image__Group__0__Impl rule__Image__Group__1
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
    // InternalBot.g:8081:1: rule__Image__Group__0__Impl : ( 'image' ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8085:1: ( ( 'image' ) )
            // InternalBot.g:8086:1: ( 'image' )
            {
            // InternalBot.g:8086:1: ( 'image' )
            // InternalBot.g:8087:2: 'image'
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
    // InternalBot.g:8096:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8100:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:8101:2: rule__Image__Group__1__Impl rule__Image__Group__2
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
    // InternalBot.g:8108:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8112:1: ( ( 'response' ) )
            // InternalBot.g:8113:1: ( 'response' )
            {
            // InternalBot.g:8113:1: ( 'response' )
            // InternalBot.g:8114:2: 'response'
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
    // InternalBot.g:8123:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8127:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:8128:2: rule__Image__Group__2__Impl rule__Image__Group__3
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
    // InternalBot.g:8135:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8139:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:8140:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:8140:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:8141:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:8142:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:8142:3: rule__Image__NameAssignment_2
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
    // InternalBot.g:8150:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8154:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:8155:2: rule__Image__Group__3__Impl rule__Image__Group__4
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
    // InternalBot.g:8162:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8166:1: ( ( ':' ) )
            // InternalBot.g:8167:1: ( ':' )
            {
            // InternalBot.g:8167:1: ( ':' )
            // InternalBot.g:8168:2: ':'
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
    // InternalBot.g:8177:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8181:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:8182:2: rule__Image__Group__4__Impl rule__Image__Group__5
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
    // InternalBot.g:8189:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8193:1: ( ( 'URL' ) )
            // InternalBot.g:8194:1: ( 'URL' )
            {
            // InternalBot.g:8194:1: ( 'URL' )
            // InternalBot.g:8195:2: 'URL'
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
    // InternalBot.g:8204:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8208:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:8209:2: rule__Image__Group__5__Impl rule__Image__Group__6
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
    // InternalBot.g:8216:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8220:1: ( ( ':' ) )
            // InternalBot.g:8221:1: ( ':' )
            {
            // InternalBot.g:8221:1: ( ':' )
            // InternalBot.g:8222:2: ':'
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
    // InternalBot.g:8231:1: rule__Image__Group__6 : rule__Image__Group__6__Impl rule__Image__Group__7 ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8235:1: ( rule__Image__Group__6__Impl rule__Image__Group__7 )
            // InternalBot.g:8236:2: rule__Image__Group__6__Impl rule__Image__Group__7
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
    // InternalBot.g:8243:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8247:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:8248:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:8248:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:8249:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:8250:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:8250:3: rule__Image__URLAssignment_6
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
    // InternalBot.g:8258:1: rule__Image__Group__7 : rule__Image__Group__7__Impl ;
    public final void rule__Image__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8262:1: ( rule__Image__Group__7__Impl )
            // InternalBot.g:8263:2: rule__Image__Group__7__Impl
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
    // InternalBot.g:8269:1: rule__Image__Group__7__Impl : ( ( rule__Image__Group_7__0 )? ) ;
    public final void rule__Image__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8273:1: ( ( ( rule__Image__Group_7__0 )? ) )
            // InternalBot.g:8274:1: ( ( rule__Image__Group_7__0 )? )
            {
            // InternalBot.g:8274:1: ( ( rule__Image__Group_7__0 )? )
            // InternalBot.g:8275:2: ( rule__Image__Group_7__0 )?
            {
             before(grammarAccess.getImageAccess().getGroup_7()); 
            // InternalBot.g:8276:2: ( rule__Image__Group_7__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==89) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalBot.g:8276:3: rule__Image__Group_7__0
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
    // InternalBot.g:8285:1: rule__Image__Group_7__0 : rule__Image__Group_7__0__Impl rule__Image__Group_7__1 ;
    public final void rule__Image__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8289:1: ( rule__Image__Group_7__0__Impl rule__Image__Group_7__1 )
            // InternalBot.g:8290:2: rule__Image__Group_7__0__Impl rule__Image__Group_7__1
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
    // InternalBot.g:8297:1: rule__Image__Group_7__0__Impl : ( 'caption' ) ;
    public final void rule__Image__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8301:1: ( ( 'caption' ) )
            // InternalBot.g:8302:1: ( 'caption' )
            {
            // InternalBot.g:8302:1: ( 'caption' )
            // InternalBot.g:8303:2: 'caption'
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
    // InternalBot.g:8312:1: rule__Image__Group_7__1 : rule__Image__Group_7__1__Impl rule__Image__Group_7__2 ;
    public final void rule__Image__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8316:1: ( rule__Image__Group_7__1__Impl rule__Image__Group_7__2 )
            // InternalBot.g:8317:2: rule__Image__Group_7__1__Impl rule__Image__Group_7__2
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
    // InternalBot.g:8324:1: rule__Image__Group_7__1__Impl : ( ':' ) ;
    public final void rule__Image__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8328:1: ( ( ':' ) )
            // InternalBot.g:8329:1: ( ':' )
            {
            // InternalBot.g:8329:1: ( ':' )
            // InternalBot.g:8330:2: ':'
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
    // InternalBot.g:8339:1: rule__Image__Group_7__2 : rule__Image__Group_7__2__Impl ;
    public final void rule__Image__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8343:1: ( rule__Image__Group_7__2__Impl )
            // InternalBot.g:8344:2: rule__Image__Group_7__2__Impl
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
    // InternalBot.g:8350:1: rule__Image__Group_7__2__Impl : ( ( rule__Image__CaptionAssignment_7_2 ) ) ;
    public final void rule__Image__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8354:1: ( ( ( rule__Image__CaptionAssignment_7_2 ) ) )
            // InternalBot.g:8355:1: ( ( rule__Image__CaptionAssignment_7_2 ) )
            {
            // InternalBot.g:8355:1: ( ( rule__Image__CaptionAssignment_7_2 ) )
            // InternalBot.g:8356:2: ( rule__Image__CaptionAssignment_7_2 )
            {
             before(grammarAccess.getImageAccess().getCaptionAssignment_7_2()); 
            // InternalBot.g:8357:2: ( rule__Image__CaptionAssignment_7_2 )
            // InternalBot.g:8357:3: rule__Image__CaptionAssignment_7_2
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


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0"
    // InternalBot.g:8366:1: rule__TextLanguageInputHttpResponse__Group__0 : rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8370:1: ( rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 )
            // InternalBot.g:8371:2: rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1
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
    // InternalBot.g:8378:1: rule__TextLanguageInputHttpResponse__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8382:1: ( ( 'inputs' ) )
            // InternalBot.g:8383:1: ( 'inputs' )
            {
            // InternalBot.g:8383:1: ( 'inputs' )
            // InternalBot.g:8384:2: 'inputs'
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
    // InternalBot.g:8393:1: rule__TextLanguageInputHttpResponse__Group__1 : rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 ;
    public final void rule__TextLanguageInputHttpResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8397:1: ( rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 )
            // InternalBot.g:8398:2: rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2
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
    // InternalBot.g:8405:1: rule__TextLanguageInputHttpResponse__Group__1__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8409:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) )
            // InternalBot.g:8410:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            {
            // InternalBot.g:8410:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            // InternalBot.g:8411:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 
            // InternalBot.g:8412:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==63) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalBot.g:8412:3: rule__TextLanguageInputHttpResponse__Group_1__0
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
    // InternalBot.g:8420:1: rule__TextLanguageInputHttpResponse__Group__2 : rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 ;
    public final void rule__TextLanguageInputHttpResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8424:1: ( rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 )
            // InternalBot.g:8425:2: rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3
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
    // InternalBot.g:8432:1: rule__TextLanguageInputHttpResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8436:1: ( ( '{' ) )
            // InternalBot.g:8437:1: ( '{' )
            {
            // InternalBot.g:8437:1: ( '{' )
            // InternalBot.g:8438:2: '{'
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
    // InternalBot.g:8447:1: rule__TextLanguageInputHttpResponse__Group__3 : rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 ;
    public final void rule__TextLanguageInputHttpResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8451:1: ( rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 )
            // InternalBot.g:8452:2: rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4
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
    // InternalBot.g:8459:1: rule__TextLanguageInputHttpResponse__Group__3__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8463:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) )
            // InternalBot.g:8464:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            {
            // InternalBot.g:8464:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            // InternalBot.g:8465:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 
            // InternalBot.g:8466:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            // InternalBot.g:8466:3: rule__TextLanguageInputHttpResponse__InputsAssignment_3
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
    // InternalBot.g:8474:1: rule__TextLanguageInputHttpResponse__Group__4 : rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 ;
    public final void rule__TextLanguageInputHttpResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8478:1: ( rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 )
            // InternalBot.g:8479:2: rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5
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
    // InternalBot.g:8486:1: rule__TextLanguageInputHttpResponse__Group__4__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8490:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) )
            // InternalBot.g:8491:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            {
            // InternalBot.g:8491:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            // InternalBot.g:8492:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 
            // InternalBot.g:8493:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==54) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalBot.g:8493:3: rule__TextLanguageInputHttpResponse__Group_4__0
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
    // InternalBot.g:8501:1: rule__TextLanguageInputHttpResponse__Group__5 : rule__TextLanguageInputHttpResponse__Group__5__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8505:1: ( rule__TextLanguageInputHttpResponse__Group__5__Impl )
            // InternalBot.g:8506:2: rule__TextLanguageInputHttpResponse__Group__5__Impl
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
    // InternalBot.g:8512:1: rule__TextLanguageInputHttpResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8516:1: ( ( '}' ) )
            // InternalBot.g:8517:1: ( '}' )
            {
            // InternalBot.g:8517:1: ( '}' )
            // InternalBot.g:8518:2: '}'
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
    // InternalBot.g:8528:1: rule__TextLanguageInputHttpResponse__Group_1__0 : rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8532:1: ( rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 )
            // InternalBot.g:8533:2: rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1
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
    // InternalBot.g:8540:1: rule__TextLanguageInputHttpResponse__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8544:1: ( ( 'in' ) )
            // InternalBot.g:8545:1: ( 'in' )
            {
            // InternalBot.g:8545:1: ( 'in' )
            // InternalBot.g:8546:2: 'in'
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
    // InternalBot.g:8555:1: rule__TextLanguageInputHttpResponse__Group_1__1 : rule__TextLanguageInputHttpResponse__Group_1__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8559:1: ( rule__TextLanguageInputHttpResponse__Group_1__1__Impl )
            // InternalBot.g:8560:2: rule__TextLanguageInputHttpResponse__Group_1__1__Impl
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
    // InternalBot.g:8566:1: rule__TextLanguageInputHttpResponse__Group_1__1__Impl : ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8570:1: ( ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:8571:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:8571:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            // InternalBot.g:8572:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:8573:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            // InternalBot.g:8573:3: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1
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
    // InternalBot.g:8582:1: rule__TextLanguageInputHttpResponse__Group_4__0 : rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8586:1: ( rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 )
            // InternalBot.g:8587:2: rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1
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
    // InternalBot.g:8594:1: rule__TextLanguageInputHttpResponse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8598:1: ( ( ',' ) )
            // InternalBot.g:8599:1: ( ',' )
            {
            // InternalBot.g:8599:1: ( ',' )
            // InternalBot.g:8600:2: ','
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
    // InternalBot.g:8609:1: rule__TextLanguageInputHttpResponse__Group_4__1 : rule__TextLanguageInputHttpResponse__Group_4__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8613:1: ( rule__TextLanguageInputHttpResponse__Group_4__1__Impl )
            // InternalBot.g:8614:2: rule__TextLanguageInputHttpResponse__Group_4__1__Impl
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
    // InternalBot.g:8620:1: rule__TextLanguageInputHttpResponse__Group_4__1__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8624:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) )
            // InternalBot.g:8625:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:8625:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            // InternalBot.g:8626:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:8627:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            // InternalBot.g:8627:3: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1
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
    // InternalBot.g:8636:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8640:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:8641:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
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
    // InternalBot.g:8648:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8652:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:8653:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:8653:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:8654:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:8655:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:8655:3: rule__KeyValue__KeyAssignment_0
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
    // InternalBot.g:8663:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8667:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:8668:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalBot.g:8675:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8679:1: ( ( ':' ) )
            // InternalBot.g:8680:1: ( ':' )
            {
            // InternalBot.g:8680:1: ( ':' )
            // InternalBot.g:8681:2: ':'
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
    // InternalBot.g:8690:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8694:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:8695:2: rule__KeyValue__Group__2__Impl
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
    // InternalBot.g:8701:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8705:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:8706:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:8706:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:8707:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:8708:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:8708:3: rule__KeyValue__ValueAssignment_2
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
    // InternalBot.g:8717:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8721:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:8722:2: rule__Data__Group__0__Impl rule__Data__Group__1
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
    // InternalBot.g:8729:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8733:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:8734:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:8734:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:8735:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:8736:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:8736:3: rule__Data__KeyAssignment_0
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
    // InternalBot.g:8744:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8748:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:8749:2: rule__Data__Group__1__Impl rule__Data__Group__2
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
    // InternalBot.g:8756:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8760:1: ( ( ':' ) )
            // InternalBot.g:8761:1: ( ':' )
            {
            // InternalBot.g:8761:1: ( ':' )
            // InternalBot.g:8762:2: ':'
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
    // InternalBot.g:8771:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8775:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:8776:2: rule__Data__Group__2__Impl
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
    // InternalBot.g:8782:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8786:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:8787:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:8787:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:8788:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:8789:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:8789:3: rule__Data__ValueAssignment_2
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
    // InternalBot.g:8798:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8802:1: ( ( ruleEString ) )
            // InternalBot.g:8803:2: ( ruleEString )
            {
            // InternalBot.g:8803:2: ( ruleEString )
            // InternalBot.g:8804:3: ruleEString
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
    // InternalBot.g:8813:1: rule__Bot__LanguagesAssignment_4 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8817:1: ( ( ruleLanguage ) )
            // InternalBot.g:8818:2: ( ruleLanguage )
            {
            // InternalBot.g:8818:2: ( ruleLanguage )
            // InternalBot.g:8819:3: ruleLanguage
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
    // InternalBot.g:8828:1: rule__Bot__LanguagesAssignment_5_1 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8832:1: ( ( ruleLanguage ) )
            // InternalBot.g:8833:2: ( ruleLanguage )
            {
            // InternalBot.g:8833:2: ( ruleLanguage )
            // InternalBot.g:8834:3: ruleLanguage
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
    // InternalBot.g:8843:1: rule__Bot__IntentsAssignment_8 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8847:1: ( ( ruleIntent ) )
            // InternalBot.g:8848:2: ( ruleIntent )
            {
            // InternalBot.g:8848:2: ( ruleIntent )
            // InternalBot.g:8849:3: ruleIntent
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
    // InternalBot.g:8858:1: rule__Bot__IntentsAssignment_9 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8862:1: ( ( ruleIntent ) )
            // InternalBot.g:8863:2: ( ruleIntent )
            {
            // InternalBot.g:8863:2: ( ruleIntent )
            // InternalBot.g:8864:3: ruleIntent
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
    // InternalBot.g:8873:1: rule__Bot__EntitiesAssignment_10_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8877:1: ( ( ruleEntity ) )
            // InternalBot.g:8878:2: ( ruleEntity )
            {
            // InternalBot.g:8878:2: ( ruleEntity )
            // InternalBot.g:8879:3: ruleEntity
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
    // InternalBot.g:8888:1: rule__Bot__EntitiesAssignment_10_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8892:1: ( ( ruleEntity ) )
            // InternalBot.g:8893:2: ( ruleEntity )
            {
            // InternalBot.g:8893:2: ( ruleEntity )
            // InternalBot.g:8894:3: ruleEntity
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
    // InternalBot.g:8903:1: rule__Bot__ActionsAssignment_11_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8907:1: ( ( ruleAction ) )
            // InternalBot.g:8908:2: ( ruleAction )
            {
            // InternalBot.g:8908:2: ( ruleAction )
            // InternalBot.g:8909:3: ruleAction
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
    // InternalBot.g:8918:1: rule__Bot__ActionsAssignment_11_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_11_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8922:1: ( ( ruleAction ) )
            // InternalBot.g:8923:2: ( ruleAction )
            {
            // InternalBot.g:8923:2: ( ruleAction )
            // InternalBot.g:8924:3: ruleAction
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
    // InternalBot.g:8933:1: rule__Bot__FlowsAssignment_14_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_14_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8937:1: ( ( ruleTransition ) )
            // InternalBot.g:8938:2: ( ruleTransition )
            {
            // InternalBot.g:8938:2: ( ruleTransition )
            // InternalBot.g:8939:3: ruleTransition
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
    // InternalBot.g:8948:1: rule__Intent2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8952:1: ( ( ruleEString ) )
            // InternalBot.g:8953:2: ( ruleEString )
            {
            // InternalBot.g:8953:2: ( ruleEString )
            // InternalBot.g:8954:3: ruleEString
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
    // InternalBot.g:8963:1: rule__Intent2__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent2__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8967:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:8968:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:8968:2: ( ( 'Fallback' ) )
            // InternalBot.g:8969:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:8970:3: ( 'Fallback' )
            // InternalBot.g:8971:4: 'Fallback'
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,90,FOLLOW_2); 
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
    // InternalBot.g:8982:1: rule__Intent2__InputsAssignment_3 : ( ruleIntentLanguageInputs ) ;
    public final void rule__Intent2__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8986:1: ( ( ruleIntentLanguageInputs ) )
            // InternalBot.g:8987:2: ( ruleIntentLanguageInputs )
            {
            // InternalBot.g:8987:2: ( ruleIntentLanguageInputs )
            // InternalBot.g:8988:3: ruleIntentLanguageInputs
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
    // InternalBot.g:8997:1: rule__Intent2__ParametersAssignment_4_2_0 : ( ruleParameter2 ) ;
    public final void rule__Intent2__ParametersAssignment_4_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9001:1: ( ( ruleParameter2 ) )
            // InternalBot.g:9002:2: ( ruleParameter2 )
            {
            // InternalBot.g:9002:2: ( ruleParameter2 )
            // InternalBot.g:9003:3: ruleParameter2
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
    // InternalBot.g:9012:1: rule__Intent2__ParametersAssignment_4_2_1 : ( ruleParameter ) ;
    public final void rule__Intent2__ParametersAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9016:1: ( ( ruleParameter ) )
            // InternalBot.g:9017:2: ( ruleParameter )
            {
            // InternalBot.g:9017:2: ( ruleParameter )
            // InternalBot.g:9018:3: ruleParameter
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
    // InternalBot.g:9027:1: rule__Intent1__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9031:1: ( ( ruleEString ) )
            // InternalBot.g:9032:2: ( ruleEString )
            {
            // InternalBot.g:9032:2: ( ruleEString )
            // InternalBot.g:9033:3: ruleEString
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
    // InternalBot.g:9042:1: rule__Intent1__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent1__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9046:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:9047:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:9047:2: ( ( 'Fallback' ) )
            // InternalBot.g:9048:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:9049:3: ( 'Fallback' )
            // InternalBot.g:9050:4: 'Fallback'
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,90,FOLLOW_2); 
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
    // InternalBot.g:9061:1: rule__IntentLanguageInputs__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__IntentLanguageInputs__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9065:1: ( ( ruleLanguage ) )
            // InternalBot.g:9066:2: ( ruleLanguage )
            {
            // InternalBot.g:9066:2: ( ruleLanguage )
            // InternalBot.g:9067:3: ruleLanguage
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
    // InternalBot.g:9076:1: rule__IntentLanguageInputs__InputsAssignment_3 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9080:1: ( ( ruleIntentInput ) )
            // InternalBot.g:9081:2: ( ruleIntentInput )
            {
            // InternalBot.g:9081:2: ( ruleIntentInput )
            // InternalBot.g:9082:3: ruleIntentInput
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
    // InternalBot.g:9091:1: rule__IntentLanguageInputs__InputsAssignment_4_1 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9095:1: ( ( ruleIntentInput ) )
            // InternalBot.g:9096:2: ( ruleIntentInput )
            {
            // InternalBot.g:9096:2: ( ruleIntentInput )
            // InternalBot.g:9097:3: ruleIntentInput
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
    // InternalBot.g:9106:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9110:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9111:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9111:2: ( ( ruleEString ) )
            // InternalBot.g:9112:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:9113:3: ( ruleEString )
            // InternalBot.g:9114:4: ruleEString
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
    // InternalBot.g:9125:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9129:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:9130:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:9130:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:9131:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:9132:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:9132:4: rule__Transition__TargetAlternatives_2_1_0
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
    // InternalBot.g:9140:1: rule__State__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9144:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9145:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9145:2: ( ( ruleEString ) )
            // InternalBot.g:9146:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:9147:3: ( ruleEString )
            // InternalBot.g:9148:4: ruleEString
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
    // InternalBot.g:9159:1: rule__State__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9163:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9164:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9164:2: ( ( ruleEString ) )
            // InternalBot.g:9165:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:9166:3: ( ruleEString )
            // InternalBot.g:9167:4: ruleEString
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
    // InternalBot.g:9178:1: rule__State__OutcomingAssignment_3_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9182:1: ( ( ruleTransition ) )
            // InternalBot.g:9183:2: ( ruleTransition )
            {
            // InternalBot.g:9183:2: ( ruleTransition )
            // InternalBot.g:9184:3: ruleTransition
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
    // InternalBot.g:9193:1: rule__State2__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9197:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9198:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9198:2: ( ( ruleEString ) )
            // InternalBot.g:9199:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:9200:3: ( ruleEString )
            // InternalBot.g:9201:4: ruleEString
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
    // InternalBot.g:9212:1: rule__State2__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9216:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9217:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9217:2: ( ( ruleEString ) )
            // InternalBot.g:9218:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:9219:3: ( ruleEString )
            // InternalBot.g:9220:4: ruleEString
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
    // InternalBot.g:9231:1: rule__State2__OutcomingAssignment_4_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9235:1: ( ( ruleTransition ) )
            // InternalBot.g:9236:2: ( ruleTransition )
            {
            // InternalBot.g:9236:2: ( ruleTransition )
            // InternalBot.g:9237:3: ruleTransition
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
    // InternalBot.g:9246:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9250:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:9251:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:9251:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:9252:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:9253:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:9253:4: rule__TrainingPhrase__TokensAlternatives_1_0
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
    // InternalBot.g:9261:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9265:1: ( ( ruleEString ) )
            // InternalBot.g:9266:2: ( ruleEString )
            {
            // InternalBot.g:9266:2: ( ruleEString )
            // InternalBot.g:9267:3: ruleEString
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
    // InternalBot.g:9276:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9280:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9281:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9281:2: ( ( ruleEString ) )
            // InternalBot.g:9282:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:9283:3: ( ruleEString )
            // InternalBot.g:9284:4: ruleEString
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
    // InternalBot.g:9295:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9299:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:9300:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:9300:2: ( ruleDefaultEntity )
            // InternalBot.g:9301:3: ruleDefaultEntity
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
    // InternalBot.g:9310:1: rule__Parameter__IsListAssignment_4_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9314:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:9315:2: ( ( 'isList' ) )
            {
            // InternalBot.g:9315:2: ( ( 'isList' ) )
            // InternalBot.g:9316:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 
            // InternalBot.g:9317:3: ( 'isList' )
            // InternalBot.g:9318:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 
            match(input,91,FOLLOW_2); 
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
    // InternalBot.g:9329:1: rule__Parameter__RequiredAssignment_5_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9333:1: ( ( ( 'required' ) ) )
            // InternalBot.g:9334:2: ( ( 'required' ) )
            {
            // InternalBot.g:9334:2: ( ( 'required' ) )
            // InternalBot.g:9335:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 
            // InternalBot.g:9336:3: ( 'required' )
            // InternalBot.g:9337:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 
            match(input,92,FOLLOW_2); 
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
    // InternalBot.g:9348:1: rule__Parameter__PromptsAssignment_6_1 : ( rulePromptLanguage ) ;
    public final void rule__Parameter__PromptsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9352:1: ( ( rulePromptLanguage ) )
            // InternalBot.g:9353:2: ( rulePromptLanguage )
            {
            // InternalBot.g:9353:2: ( rulePromptLanguage )
            // InternalBot.g:9354:3: rulePromptLanguage
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
    // InternalBot.g:9363:1: rule__Parameter2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9367:1: ( ( ruleEString ) )
            // InternalBot.g:9368:2: ( ruleEString )
            {
            // InternalBot.g:9368:2: ( ruleEString )
            // InternalBot.g:9369:3: ruleEString
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
    // InternalBot.g:9378:1: rule__PromptLanguage__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__PromptLanguage__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9382:1: ( ( ruleLanguage ) )
            // InternalBot.g:9383:2: ( ruleLanguage )
            {
            // InternalBot.g:9383:2: ( ruleLanguage )
            // InternalBot.g:9384:3: ruleLanguage
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
    // InternalBot.g:9393:1: rule__PromptLanguage__PromptsAssignment_3 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9397:1: ( ( ruleEString ) )
            // InternalBot.g:9398:2: ( ruleEString )
            {
            // InternalBot.g:9398:2: ( ruleEString )
            // InternalBot.g:9399:3: ruleEString
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
    // InternalBot.g:9408:1: rule__PromptLanguage__PromptsAssignment_4_1 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9412:1: ( ( ruleEString ) )
            // InternalBot.g:9413:2: ( ruleEString )
            {
            // InternalBot.g:9413:2: ( ruleEString )
            // InternalBot.g:9414:3: ruleEString
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
    // InternalBot.g:9423:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9427:1: ( ( ruleEString ) )
            // InternalBot.g:9428:2: ( ruleEString )
            {
            // InternalBot.g:9428:2: ( ruleEString )
            // InternalBot.g:9429:3: ruleEString
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
    // InternalBot.g:9438:1: rule__EntityToken__EntityAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9442:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9443:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9443:2: ( ( ruleEString ) )
            // InternalBot.g:9444:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 
            // InternalBot.g:9445:3: ( ruleEString )
            // InternalBot.g:9446:4: ruleEString
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
    // InternalBot.g:9457:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9461:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9462:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9462:2: ( ( ruleEString ) )
            // InternalBot.g:9463:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:9464:3: ( ruleEString )
            // InternalBot.g:9465:4: ruleEString
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
    // InternalBot.g:9476:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9480:1: ( ( ruleEString ) )
            // InternalBot.g:9481:2: ( ruleEString )
            {
            // InternalBot.g:9481:2: ( ruleEString )
            // InternalBot.g:9482:3: ruleEString
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
    // InternalBot.g:9491:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9495:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9496:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9496:2: ( ( ruleEString ) )
            // InternalBot.g:9497:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:9498:3: ( ruleEString )
            // InternalBot.g:9499:4: ruleEString
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
    // InternalBot.g:9510:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9514:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:9515:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:9515:2: ( ruleHTTPReturnType )
            // InternalBot.g:9516:3: ruleHTTPReturnType
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
    // InternalBot.g:9525:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9529:1: ( ( ruleEString ) )
            // InternalBot.g:9530:2: ( ruleEString )
            {
            // InternalBot.g:9530:2: ( ruleEString )
            // InternalBot.g:9531:3: ruleEString
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
    // InternalBot.g:9540:1: rule__SimpleEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__SimpleEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9544:1: ( ( ruleEString ) )
            // InternalBot.g:9545:2: ( ruleEString )
            {
            // InternalBot.g:9545:2: ( ruleEString )
            // InternalBot.g:9546:3: ruleEString
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
    // InternalBot.g:9555:1: rule__SimpleEntity__InputsAssignment_4 : ( ruleSLanguageInput ) ;
    public final void rule__SimpleEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9559:1: ( ( ruleSLanguageInput ) )
            // InternalBot.g:9560:2: ( ruleSLanguageInput )
            {
            // InternalBot.g:9560:2: ( ruleSLanguageInput )
            // InternalBot.g:9561:3: ruleSLanguageInput
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
    // InternalBot.g:9570:1: rule__ComplexEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__ComplexEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9574:1: ( ( ruleEString ) )
            // InternalBot.g:9575:2: ( ruleEString )
            {
            // InternalBot.g:9575:2: ( ruleEString )
            // InternalBot.g:9576:3: ruleEString
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
    // InternalBot.g:9585:1: rule__ComplexEntity__InputsAssignment_4 : ( ruleCLanguageInput ) ;
    public final void rule__ComplexEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9589:1: ( ( ruleCLanguageInput ) )
            // InternalBot.g:9590:2: ( ruleCLanguageInput )
            {
            // InternalBot.g:9590:2: ( ruleCLanguageInput )
            // InternalBot.g:9591:3: ruleCLanguageInput
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
    // InternalBot.g:9600:1: rule__RegexEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__RegexEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9604:1: ( ( ruleEString ) )
            // InternalBot.g:9605:2: ( ruleEString )
            {
            // InternalBot.g:9605:2: ( ruleEString )
            // InternalBot.g:9606:3: ruleEString
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
    // InternalBot.g:9615:1: rule__RegexEntity__InputsAssignment_4 : ( ruleRLanguageInput ) ;
    public final void rule__RegexEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9619:1: ( ( ruleRLanguageInput ) )
            // InternalBot.g:9620:2: ( ruleRLanguageInput )
            {
            // InternalBot.g:9620:2: ( ruleRLanguageInput )
            // InternalBot.g:9621:3: ruleRLanguageInput
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
    // InternalBot.g:9630:1: rule__SLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__SLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9634:1: ( ( ruleLanguage ) )
            // InternalBot.g:9635:2: ( ruleLanguage )
            {
            // InternalBot.g:9635:2: ( ruleLanguage )
            // InternalBot.g:9636:3: ruleLanguage
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
    // InternalBot.g:9645:1: rule__SLanguageInput__InputsAssignment_2_0 : ( ruleSimpleInput ) ;
    public final void rule__SLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9649:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:9650:2: ( ruleSimpleInput )
            {
            // InternalBot.g:9650:2: ( ruleSimpleInput )
            // InternalBot.g:9651:3: ruleSimpleInput
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
    // InternalBot.g:9660:1: rule__SLanguageInput__InputsAssignment_2_1 : ( ruleSimpleInput ) ;
    public final void rule__SLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9664:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:9665:2: ( ruleSimpleInput )
            {
            // InternalBot.g:9665:2: ( ruleSimpleInput )
            // InternalBot.g:9666:3: ruleSimpleInput
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
    // InternalBot.g:9675:1: rule__CLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__CLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9679:1: ( ( ruleLanguage ) )
            // InternalBot.g:9680:2: ( ruleLanguage )
            {
            // InternalBot.g:9680:2: ( ruleLanguage )
            // InternalBot.g:9681:3: ruleLanguage
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
    // InternalBot.g:9690:1: rule__CLanguageInput__InputsAssignment_2_0 : ( ruleCompositeInput ) ;
    public final void rule__CLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9694:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:9695:2: ( ruleCompositeInput )
            {
            // InternalBot.g:9695:2: ( ruleCompositeInput )
            // InternalBot.g:9696:3: ruleCompositeInput
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
    // InternalBot.g:9705:1: rule__CLanguageInput__InputsAssignment_2_1 : ( ruleCompositeInput ) ;
    public final void rule__CLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9709:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:9710:2: ( ruleCompositeInput )
            {
            // InternalBot.g:9710:2: ( ruleCompositeInput )
            // InternalBot.g:9711:3: ruleCompositeInput
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
    // InternalBot.g:9720:1: rule__RLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__RLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9724:1: ( ( ruleLanguage ) )
            // InternalBot.g:9725:2: ( ruleLanguage )
            {
            // InternalBot.g:9725:2: ( ruleLanguage )
            // InternalBot.g:9726:3: ruleLanguage
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
    // InternalBot.g:9735:1: rule__RLanguageInput__InputsAssignment_2_0 : ( ruleRegexInput ) ;
    public final void rule__RLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9739:1: ( ( ruleRegexInput ) )
            // InternalBot.g:9740:2: ( ruleRegexInput )
            {
            // InternalBot.g:9740:2: ( ruleRegexInput )
            // InternalBot.g:9741:3: ruleRegexInput
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
    // InternalBot.g:9750:1: rule__RLanguageInput__InputsAssignment_2_1 : ( ruleRegexInput ) ;
    public final void rule__RLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9754:1: ( ( ruleRegexInput ) )
            // InternalBot.g:9755:2: ( ruleRegexInput )
            {
            // InternalBot.g:9755:2: ( ruleRegexInput )
            // InternalBot.g:9756:3: ruleRegexInput
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
    // InternalBot.g:9765:1: rule__RegexInput__ExpresionAssignment_3 : ( ruleEString ) ;
    public final void rule__RegexInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9769:1: ( ( ruleEString ) )
            // InternalBot.g:9770:2: ( ruleEString )
            {
            // InternalBot.g:9770:2: ( ruleEString )
            // InternalBot.g:9771:3: ruleEString
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
    // InternalBot.g:9780:1: rule__CompositeInput__ExpresionAssignment_3 : ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) ;
    public final void rule__CompositeInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9784:1: ( ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) )
            // InternalBot.g:9785:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            {
            // InternalBot.g:9785:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            // InternalBot.g:9786:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAlternatives_3_0()); 
            // InternalBot.g:9787:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            // InternalBot.g:9787:4: rule__CompositeInput__ExpresionAlternatives_3_0
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
    // InternalBot.g:9795:1: rule__SimpleInput__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9799:1: ( ( ruleEString ) )
            // InternalBot.g:9800:2: ( ruleEString )
            {
            // InternalBot.g:9800:2: ( ruleEString )
            // InternalBot.g:9801:3: ruleEString
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
    // InternalBot.g:9810:1: rule__SimpleInput__ValuesAssignment_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9814:1: ( ( ruleEString ) )
            // InternalBot.g:9815:2: ( ruleEString )
            {
            // InternalBot.g:9815:2: ( ruleEString )
            // InternalBot.g:9816:3: ruleEString
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
    // InternalBot.g:9825:1: rule__SimpleInput__ValuesAssignment_2_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9829:1: ( ( ruleEString ) )
            // InternalBot.g:9830:2: ( ruleEString )
            {
            // InternalBot.g:9830:2: ( ruleEString )
            // InternalBot.g:9831:3: ruleEString
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
    // InternalBot.g:9840:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9844:1: ( ( ruleEString ) )
            // InternalBot.g:9845:2: ( ruleEString )
            {
            // InternalBot.g:9845:2: ( ruleEString )
            // InternalBot.g:9846:3: ruleEString
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
    // InternalBot.g:9855:1: rule__Text__InputsAssignment_4 : ( ruleTextLanguageInput ) ;
    public final void rule__Text__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9859:1: ( ( ruleTextLanguageInput ) )
            // InternalBot.g:9860:2: ( ruleTextLanguageInput )
            {
            // InternalBot.g:9860:2: ( ruleTextLanguageInput )
            // InternalBot.g:9861:3: ruleTextLanguageInput
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
    // InternalBot.g:9870:1: rule__TextLanguageInput__LanguageAssignment_0_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInput__LanguageAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9874:1: ( ( ruleLanguage ) )
            // InternalBot.g:9875:2: ( ruleLanguage )
            {
            // InternalBot.g:9875:2: ( ruleLanguage )
            // InternalBot.g:9876:3: ruleLanguage
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
    // InternalBot.g:9885:1: rule__TextLanguageInput__InputsAssignment_2 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9889:1: ( ( ruleTextInputText ) )
            // InternalBot.g:9890:2: ( ruleTextInputText )
            {
            // InternalBot.g:9890:2: ( ruleTextInputText )
            // InternalBot.g:9891:3: ruleTextInputText
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
    // InternalBot.g:9900:1: rule__TextLanguageInput__InputsAssignment_3_1 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9904:1: ( ( ruleTextInputText ) )
            // InternalBot.g:9905:2: ( ruleTextInputText )
            {
            // InternalBot.g:9905:2: ( ruleTextInputText )
            // InternalBot.g:9906:3: ruleTextInputText
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
    // InternalBot.g:9915:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9919:1: ( ( ruleEString ) )
            // InternalBot.g:9920:2: ( ruleEString )
            {
            // InternalBot.g:9920:2: ( ruleEString )
            // InternalBot.g:9921:3: ruleEString
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
    // InternalBot.g:9930:1: rule__HTTPResponse__HTTPRequestAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9934:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9935:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9935:2: ( ( ruleEString ) )
            // InternalBot.g:9936:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_5_0()); 
            // InternalBot.g:9937:3: ( ruleEString )
            // InternalBot.g:9938:4: ruleEString
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
    // InternalBot.g:9949:1: rule__HTTPResponse__InputsAssignment_7 : ( ruleTextLanguageInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9953:1: ( ( ruleTextLanguageInputHttpResponse ) )
            // InternalBot.g:9954:2: ( ruleTextLanguageInputHttpResponse )
            {
            // InternalBot.g:9954:2: ( ruleTextLanguageInputHttpResponse )
            // InternalBot.g:9955:3: ruleTextLanguageInputHttpResponse
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
    // InternalBot.g:9964:1: rule__HTTPRequest__MethodAssignment_1 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9968:1: ( ( ruleMethod ) )
            // InternalBot.g:9969:2: ( ruleMethod )
            {
            // InternalBot.g:9969:2: ( ruleMethod )
            // InternalBot.g:9970:3: ruleMethod
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
    // InternalBot.g:9979:1: rule__HTTPRequest__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9983:1: ( ( ruleEString ) )
            // InternalBot.g:9984:2: ( ruleEString )
            {
            // InternalBot.g:9984:2: ( ruleEString )
            // InternalBot.g:9985:3: ruleEString
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
    // InternalBot.g:9994:1: rule__HTTPRequest__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9998:1: ( ( ruleEString ) )
            // InternalBot.g:9999:2: ( ruleEString )
            {
            // InternalBot.g:9999:2: ( ruleEString )
            // InternalBot.g:10000:3: ruleEString
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
    // InternalBot.g:10009:1: rule__HTTPRequest__BasicAuthAssignment_8_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10013:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10014:2: ( ruleKeyValue )
            {
            // InternalBot.g:10014:2: ( ruleKeyValue )
            // InternalBot.g:10015:3: ruleKeyValue
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
    // InternalBot.g:10024:1: rule__HTTPRequest__HeadersAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10028:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10029:2: ( ruleKeyValue )
            {
            // InternalBot.g:10029:2: ( ruleKeyValue )
            // InternalBot.g:10030:3: ruleKeyValue
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
    // InternalBot.g:10039:1: rule__HTTPRequest__HeadersAssignment_9_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_9_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10043:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10044:2: ( ruleKeyValue )
            {
            // InternalBot.g:10044:2: ( ruleKeyValue )
            // InternalBot.g:10045:3: ruleKeyValue
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
    // InternalBot.g:10054:1: rule__HTTPRequest__DataAssignment_10_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10058:1: ( ( ruleData ) )
            // InternalBot.g:10059:2: ( ruleData )
            {
            // InternalBot.g:10059:2: ( ruleData )
            // InternalBot.g:10060:3: ruleData
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
    // InternalBot.g:10069:1: rule__HTTPRequest__DataAssignment_10_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10073:1: ( ( ruleData ) )
            // InternalBot.g:10074:2: ( ruleData )
            {
            // InternalBot.g:10074:2: ( ruleData )
            // InternalBot.g:10075:3: ruleData
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
    // InternalBot.g:10084:1: rule__HTTPRequest__DataTypeAssignment_10_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_10_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10088:1: ( ( ruleDataType ) )
            // InternalBot.g:10089:2: ( ruleDataType )
            {
            // InternalBot.g:10089:2: ( ruleDataType )
            // InternalBot.g:10090:3: ruleDataType
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
    // InternalBot.g:10099:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10103:1: ( ( ruleEString ) )
            // InternalBot.g:10104:2: ( ruleEString )
            {
            // InternalBot.g:10104:2: ( ruleEString )
            // InternalBot.g:10105:3: ruleEString
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
    // InternalBot.g:10114:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10118:1: ( ( ruleEString ) )
            // InternalBot.g:10119:2: ( ruleEString )
            {
            // InternalBot.g:10119:2: ( ruleEString )
            // InternalBot.g:10120:3: ruleEString
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
    // InternalBot.g:10129:1: rule__Image__CaptionAssignment_7_2 : ( ruleEString ) ;
    public final void rule__Image__CaptionAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10133:1: ( ( ruleEString ) )
            // InternalBot.g:10134:2: ( ruleEString )
            {
            // InternalBot.g:10134:2: ( ruleEString )
            // InternalBot.g:10135:3: ruleEString
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


    // $ANTLR start "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"
    // InternalBot.g:10144:1: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10148:1: ( ( ruleLanguage ) )
            // InternalBot.g:10149:2: ( ruleLanguage )
            {
            // InternalBot.g:10149:2: ( ruleLanguage )
            // InternalBot.g:10150:3: ruleLanguage
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
    // InternalBot.g:10159:1: rule__TextLanguageInputHttpResponse__InputsAssignment_3 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10163:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:10164:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:10164:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:10165:3: ruleTextInputHttpResponse
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
    // InternalBot.g:10174:1: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10178:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:10179:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:10179:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:10180:3: ruleTextInputHttpResponse
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
    // InternalBot.g:10189:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10193:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:10194:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:10194:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:10195:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:10196:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:10196:4: rule__TextInputHttpResponse__TokensAlternatives_0
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
    // InternalBot.g:10204:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10208:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:10209:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:10209:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:10210:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:10211:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:10211:4: rule__TextInputText__TokensAlternatives_0
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
    // InternalBot.g:10219:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10223:1: ( ( ruleEString ) )
            // InternalBot.g:10224:2: ( ruleEString )
            {
            // InternalBot.g:10224:2: ( ruleEString )
            // InternalBot.g:10225:3: ruleEString
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
    // InternalBot.g:10234:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10238:1: ( ( ruleLiteral ) )
            // InternalBot.g:10239:2: ( ruleLiteral )
            {
            // InternalBot.g:10239:2: ( ruleLiteral )
            // InternalBot.g:10240:3: ruleLiteral
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
    // InternalBot.g:10249:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10253:1: ( ( ruleEString ) )
            // InternalBot.g:10254:2: ( ruleEString )
            {
            // InternalBot.g:10254:2: ( ruleEString )
            // InternalBot.g:10255:3: ruleEString
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
    // InternalBot.g:10264:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10268:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:10269:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:10269:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:10270:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:10271:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:10271:4: rule__Data__ValueAlternatives_2_0
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
            return "1221:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
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
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000020800L,0x0000000000180000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000020802L,0x0000000000180000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0008000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
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
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
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