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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Text'", "'text'", "'Image'", "'mage'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'data'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'", "'Chatbot'", "'language'", "':'", "'intents'", "'flows'", "','", "'entities'", "'actions'", "'-'", "';'", "'parameters'", "'inputs'", "'{'", "'}'", "'in'", "'user'", "'=>'", "'chatbot'", "'entity'", "'prompts'", "'['", "']'", "'@'", "'('", "')'", "'request.'", "'.'", "'Simple'", "'Composite'", "'Regex'", "'pattern'", "'composite'", "'synonyms'", "'response'", "'Response'", "'Request'", "'URL'", "'basicAuth'", "'headers'", "'dataType'", "'caption'", "'Empty'", "'Button'", "'text:'", "'buttons:'", "'value:'", "'action:'", "'Fallback'", "'isList'", "'required'"
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
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
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


    // $ANTLR start "entryRuleButtonAction"
    // InternalBot.g:953:1: entryRuleButtonAction : ruleButtonAction EOF ;
    public final void entryRuleButtonAction() throws RecognitionException {
        try {
            // InternalBot.g:954:1: ( ruleButtonAction EOF )
            // InternalBot.g:955:1: ruleButtonAction EOF
            {
             before(grammarAccess.getButtonActionRule()); 
            pushFollow(FOLLOW_1);
            ruleButtonAction();

            state._fsp--;

             after(grammarAccess.getButtonActionRule()); 
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
    // $ANTLR end "entryRuleButtonAction"


    // $ANTLR start "ruleButtonAction"
    // InternalBot.g:962:1: ruleButtonAction : ( ( rule__ButtonAction__Group__0 ) ) ;
    public final void ruleButtonAction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:966:2: ( ( ( rule__ButtonAction__Group__0 ) ) )
            // InternalBot.g:967:2: ( ( rule__ButtonAction__Group__0 ) )
            {
            // InternalBot.g:967:2: ( ( rule__ButtonAction__Group__0 ) )
            // InternalBot.g:968:3: ( rule__ButtonAction__Group__0 )
            {
             before(grammarAccess.getButtonActionAccess().getGroup()); 
            // InternalBot.g:969:3: ( rule__ButtonAction__Group__0 )
            // InternalBot.g:969:4: rule__ButtonAction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ButtonAction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getButtonActionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleButtonAction"


    // $ANTLR start "entryRuleButtonLanguageInput"
    // InternalBot.g:978:1: entryRuleButtonLanguageInput : ruleButtonLanguageInput EOF ;
    public final void entryRuleButtonLanguageInput() throws RecognitionException {
        try {
            // InternalBot.g:979:1: ( ruleButtonLanguageInput EOF )
            // InternalBot.g:980:1: ruleButtonLanguageInput EOF
            {
             before(grammarAccess.getButtonLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            ruleButtonLanguageInput();

            state._fsp--;

             after(grammarAccess.getButtonLanguageInputRule()); 
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
    // $ANTLR end "entryRuleButtonLanguageInput"


    // $ANTLR start "ruleButtonLanguageInput"
    // InternalBot.g:987:1: ruleButtonLanguageInput : ( ( rule__ButtonLanguageInput__Group__0 ) ) ;
    public final void ruleButtonLanguageInput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:991:2: ( ( ( rule__ButtonLanguageInput__Group__0 ) ) )
            // InternalBot.g:992:2: ( ( rule__ButtonLanguageInput__Group__0 ) )
            {
            // InternalBot.g:992:2: ( ( rule__ButtonLanguageInput__Group__0 ) )
            // InternalBot.g:993:3: ( rule__ButtonLanguageInput__Group__0 )
            {
             before(grammarAccess.getButtonLanguageInputAccess().getGroup()); 
            // InternalBot.g:994:3: ( rule__ButtonLanguageInput__Group__0 )
            // InternalBot.g:994:4: rule__ButtonLanguageInput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getButtonLanguageInputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleButtonLanguageInput"


    // $ANTLR start "entryRuleButton"
    // InternalBot.g:1003:1: entryRuleButton : ruleButton EOF ;
    public final void entryRuleButton() throws RecognitionException {
        try {
            // InternalBot.g:1004:1: ( ruleButton EOF )
            // InternalBot.g:1005:1: ruleButton EOF
            {
             before(grammarAccess.getButtonRule()); 
            pushFollow(FOLLOW_1);
            ruleButton();

            state._fsp--;

             after(grammarAccess.getButtonRule()); 
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
    // $ANTLR end "entryRuleButton"


    // $ANTLR start "ruleButton"
    // InternalBot.g:1012:1: ruleButton : ( ( rule__Button__Group__0 ) ) ;
    public final void ruleButton() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1016:2: ( ( ( rule__Button__Group__0 ) ) )
            // InternalBot.g:1017:2: ( ( rule__Button__Group__0 ) )
            {
            // InternalBot.g:1017:2: ( ( rule__Button__Group__0 ) )
            // InternalBot.g:1018:3: ( rule__Button__Group__0 )
            {
             before(grammarAccess.getButtonAccess().getGroup()); 
            // InternalBot.g:1019:3: ( rule__Button__Group__0 )
            // InternalBot.g:1019:4: rule__Button__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Button__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getButtonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleButton"


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:1028:1: entryRuleTextLanguageInputHttpResponse : ruleTextLanguageInputHttpResponse EOF ;
    public final void entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:1029:1: ( ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:1030:1: ruleTextLanguageInputHttpResponse EOF
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
    // InternalBot.g:1037:1: ruleTextLanguageInputHttpResponse : ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) ;
    public final void ruleTextLanguageInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1041:2: ( ( ( rule__TextLanguageInputHttpResponse__Group__0 ) ) )
            // InternalBot.g:1042:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            {
            // InternalBot.g:1042:2: ( ( rule__TextLanguageInputHttpResponse__Group__0 ) )
            // InternalBot.g:1043:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup()); 
            // InternalBot.g:1044:3: ( rule__TextLanguageInputHttpResponse__Group__0 )
            // InternalBot.g:1044:4: rule__TextLanguageInputHttpResponse__Group__0
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
    // InternalBot.g:1053:1: entryRuleTextInputHttpResponse : ruleTextInputHttpResponse EOF ;
    public final void entryRuleTextInputHttpResponse() throws RecognitionException {
        try {
            // InternalBot.g:1054:1: ( ruleTextInputHttpResponse EOF )
            // InternalBot.g:1055:1: ruleTextInputHttpResponse EOF
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
    // InternalBot.g:1062:1: ruleTextInputHttpResponse : ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) ;
    public final void ruleTextInputHttpResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1066:2: ( ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) ) )
            // InternalBot.g:1067:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            {
            // InternalBot.g:1067:2: ( ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* ) )
            // InternalBot.g:1068:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) ) ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            {
            // InternalBot.g:1068:3: ( ( rule__TextInputHttpResponse__TokensAssignment ) )
            // InternalBot.g:1069:4: ( rule__TextInputHttpResponse__TokensAssignment )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:1070:4: ( rule__TextInputHttpResponse__TokensAssignment )
            // InternalBot.g:1070:5: rule__TextInputHttpResponse__TokensAssignment
            {
            pushFollow(FOLLOW_3);
            rule__TextInputHttpResponse__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 

            }

            // InternalBot.g:1073:3: ( ( rule__TextInputHttpResponse__TokensAssignment )* )
            // InternalBot.g:1074:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAssignment()); 
            // InternalBot.g:1075:4: ( rule__TextInputHttpResponse__TokensAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==72||LA1_0==77) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:1075:5: rule__TextInputHttpResponse__TokensAssignment
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
    // InternalBot.g:1085:1: entryRuleTextInputText : ruleTextInputText EOF ;
    public final void entryRuleTextInputText() throws RecognitionException {
        try {
            // InternalBot.g:1086:1: ( ruleTextInputText EOF )
            // InternalBot.g:1087:1: ruleTextInputText EOF
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
    // InternalBot.g:1094:1: ruleTextInputText : ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) ;
    public final void ruleTextInputText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1098:2: ( ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) ) )
            // InternalBot.g:1099:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            {
            // InternalBot.g:1099:2: ( ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* ) )
            // InternalBot.g:1100:3: ( ( rule__TextInputText__TokensAssignment ) ) ( ( rule__TextInputText__TokensAssignment )* )
            {
            // InternalBot.g:1100:3: ( ( rule__TextInputText__TokensAssignment ) )
            // InternalBot.g:1101:4: ( rule__TextInputText__TokensAssignment )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:1102:4: ( rule__TextInputText__TokensAssignment )
            // InternalBot.g:1102:5: rule__TextInputText__TokensAssignment
            {
            pushFollow(FOLLOW_4);
            rule__TextInputText__TokensAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 

            }

            // InternalBot.g:1105:3: ( ( rule__TextInputText__TokensAssignment )* )
            // InternalBot.g:1106:4: ( rule__TextInputText__TokensAssignment )*
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAssignment()); 
            // InternalBot.g:1107:4: ( rule__TextInputText__TokensAssignment )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)||LA2_0==72) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:1107:5: rule__TextInputText__TokensAssignment
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
    // InternalBot.g:1117:1: entryRuleKeyValue : ruleKeyValue EOF ;
    public final void entryRuleKeyValue() throws RecognitionException {
        try {
            // InternalBot.g:1118:1: ( ruleKeyValue EOF )
            // InternalBot.g:1119:1: ruleKeyValue EOF
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
    // InternalBot.g:1126:1: ruleKeyValue : ( ( rule__KeyValue__Group__0 ) ) ;
    public final void ruleKeyValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1130:2: ( ( ( rule__KeyValue__Group__0 ) ) )
            // InternalBot.g:1131:2: ( ( rule__KeyValue__Group__0 ) )
            {
            // InternalBot.g:1131:2: ( ( rule__KeyValue__Group__0 ) )
            // InternalBot.g:1132:3: ( rule__KeyValue__Group__0 )
            {
             before(grammarAccess.getKeyValueAccess().getGroup()); 
            // InternalBot.g:1133:3: ( rule__KeyValue__Group__0 )
            // InternalBot.g:1133:4: rule__KeyValue__Group__0
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
    // InternalBot.g:1142:1: entryRuleData : ruleData EOF ;
    public final void entryRuleData() throws RecognitionException {
        try {
            // InternalBot.g:1143:1: ( ruleData EOF )
            // InternalBot.g:1144:1: ruleData EOF
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
    // InternalBot.g:1151:1: ruleData : ( ( rule__Data__Group__0 ) ) ;
    public final void ruleData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1155:2: ( ( ( rule__Data__Group__0 ) ) )
            // InternalBot.g:1156:2: ( ( rule__Data__Group__0 ) )
            {
            // InternalBot.g:1156:2: ( ( rule__Data__Group__0 ) )
            // InternalBot.g:1157:3: ( rule__Data__Group__0 )
            {
             before(grammarAccess.getDataAccess().getGroup()); 
            // InternalBot.g:1158:3: ( rule__Data__Group__0 )
            // InternalBot.g:1158:4: rule__Data__Group__0
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
    // InternalBot.g:1167:1: ruleDefaultEntity : ( ( rule__DefaultEntity__Alternatives ) ) ;
    public final void ruleDefaultEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1171:1: ( ( ( rule__DefaultEntity__Alternatives ) ) )
            // InternalBot.g:1172:2: ( ( rule__DefaultEntity__Alternatives ) )
            {
            // InternalBot.g:1172:2: ( ( rule__DefaultEntity__Alternatives ) )
            // InternalBot.g:1173:3: ( rule__DefaultEntity__Alternatives )
            {
             before(grammarAccess.getDefaultEntityAccess().getAlternatives()); 
            // InternalBot.g:1174:3: ( rule__DefaultEntity__Alternatives )
            // InternalBot.g:1174:4: rule__DefaultEntity__Alternatives
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
    // InternalBot.g:1183:1: ruleHTTPReturnType : ( ( rule__HTTPReturnType__Alternatives ) ) ;
    public final void ruleHTTPReturnType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1187:1: ( ( ( rule__HTTPReturnType__Alternatives ) ) )
            // InternalBot.g:1188:2: ( ( rule__HTTPReturnType__Alternatives ) )
            {
            // InternalBot.g:1188:2: ( ( rule__HTTPReturnType__Alternatives ) )
            // InternalBot.g:1189:3: ( rule__HTTPReturnType__Alternatives )
            {
             before(grammarAccess.getHTTPReturnTypeAccess().getAlternatives()); 
            // InternalBot.g:1190:3: ( rule__HTTPReturnType__Alternatives )
            // InternalBot.g:1190:4: rule__HTTPReturnType__Alternatives
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
    // InternalBot.g:1199:1: ruleLanguage : ( ( rule__Language__Alternatives ) ) ;
    public final void ruleLanguage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1203:1: ( ( ( rule__Language__Alternatives ) ) )
            // InternalBot.g:1204:2: ( ( rule__Language__Alternatives ) )
            {
            // InternalBot.g:1204:2: ( ( rule__Language__Alternatives ) )
            // InternalBot.g:1205:3: ( rule__Language__Alternatives )
            {
             before(grammarAccess.getLanguageAccess().getAlternatives()); 
            // InternalBot.g:1206:3: ( rule__Language__Alternatives )
            // InternalBot.g:1206:4: rule__Language__Alternatives
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
    // InternalBot.g:1215:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1219:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalBot.g:1220:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalBot.g:1220:2: ( ( rule__DataType__Alternatives ) )
            // InternalBot.g:1221:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalBot.g:1222:3: ( rule__DataType__Alternatives )
            // InternalBot.g:1222:4: rule__DataType__Alternatives
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
    // InternalBot.g:1231:1: ruleMethod : ( ( rule__Method__Alternatives ) ) ;
    public final void ruleMethod() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1235:1: ( ( ( rule__Method__Alternatives ) ) )
            // InternalBot.g:1236:2: ( ( rule__Method__Alternatives ) )
            {
            // InternalBot.g:1236:2: ( ( rule__Method__Alternatives ) )
            // InternalBot.g:1237:3: ( rule__Method__Alternatives )
            {
             before(grammarAccess.getMethodAccess().getAlternatives()); 
            // InternalBot.g:1238:3: ( rule__Method__Alternatives )
            // InternalBot.g:1238:4: rule__Method__Alternatives
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
    // InternalBot.g:1246:1: rule__Action__Alternatives : ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) | ( ruleEmpty ) | ( ruleButtonAction ) );
    public final void rule__Action__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1250:1: ( ( ruleText ) | ( ruleHTTPRequest ) | ( ruleImage ) | ( ruleHTTPResponse ) | ( ruleEmpty ) | ( ruleButtonAction ) )
            int alt3=6;
            switch ( input.LA(1) ) {
            case 11:
            case 12:
                {
                alt3=1;
                }
                break;
            case 87:
                {
                alt3=2;
                }
                break;
            case 13:
            case 14:
                {
                alt3=3;
                }
                break;
            case 86:
                {
                alt3=4;
                }
                break;
            case 93:
                {
                alt3=5;
                }
                break;
            case 94:
                {
                alt3=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalBot.g:1251:2: ( ruleText )
                    {
                    // InternalBot.g:1251:2: ( ruleText )
                    // InternalBot.g:1252:3: ruleText
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
                    // InternalBot.g:1257:2: ( ruleHTTPRequest )
                    {
                    // InternalBot.g:1257:2: ( ruleHTTPRequest )
                    // InternalBot.g:1258:3: ruleHTTPRequest
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
                    // InternalBot.g:1263:2: ( ruleImage )
                    {
                    // InternalBot.g:1263:2: ( ruleImage )
                    // InternalBot.g:1264:3: ruleImage
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
                    // InternalBot.g:1269:2: ( ruleHTTPResponse )
                    {
                    // InternalBot.g:1269:2: ( ruleHTTPResponse )
                    // InternalBot.g:1270:3: ruleHTTPResponse
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
                    // InternalBot.g:1275:2: ( ruleEmpty )
                    {
                    // InternalBot.g:1275:2: ( ruleEmpty )
                    // InternalBot.g:1276:3: ruleEmpty
                    {
                     before(grammarAccess.getActionAccess().getEmptyParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleEmpty();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getEmptyParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1281:2: ( ruleButtonAction )
                    {
                    // InternalBot.g:1281:2: ( ruleButtonAction )
                    // InternalBot.g:1282:3: ruleButtonAction
                    {
                     before(grammarAccess.getActionAccess().getButtonActionParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleButtonAction();

                    state._fsp--;

                     after(grammarAccess.getActionAccess().getButtonActionParserRuleCall_5()); 

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
    // InternalBot.g:1291:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1295:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalBot.g:1296:2: ( RULE_STRING )
                    {
                    // InternalBot.g:1296:2: ( RULE_STRING )
                    // InternalBot.g:1297:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1302:2: ( RULE_ID )
                    {
                    // InternalBot.g:1302:2: ( RULE_ID )
                    // InternalBot.g:1303:3: RULE_ID
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
    // InternalBot.g:1312:1: rule__Intent__Alternatives : ( ( ruleIntent1 ) | ( ruleIntent2 ) );
    public final void rule__Intent__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1316:1: ( ( ruleIntent1 ) | ( ruleIntent2 ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 99:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==EOF||(LA5_3>=RULE_STRING && LA5_3<=RULE_ID)||LA5_3==56||(LA5_3>=58 && LA5_3<=59)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_3==54) ) {
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
                case 56:
                case 58:
                case 59:
                    {
                    alt5=1;
                    }
                    break;
                case 54:
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
                case 99:
                    {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==EOF||(LA5_3>=RULE_STRING && LA5_3<=RULE_ID)||LA5_3==56||(LA5_3>=58 && LA5_3<=59)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_3==54) ) {
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
                case 56:
                case 58:
                case 59:
                    {
                    alt5=1;
                    }
                    break;
                case 54:
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
                    // InternalBot.g:1317:2: ( ruleIntent1 )
                    {
                    // InternalBot.g:1317:2: ( ruleIntent1 )
                    // InternalBot.g:1318:3: ruleIntent1
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
                    // InternalBot.g:1323:2: ( ruleIntent2 )
                    {
                    // InternalBot.g:1323:2: ( ruleIntent2 )
                    // InternalBot.g:1324:3: ruleIntent2
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
    // InternalBot.g:1333:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );
    public final void rule__Transition__TargetAlternatives_2_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1337:1: ( ( ruleState ) | ( ruleState2 ) )
            int alt6=2;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // InternalBot.g:1338:2: ( ruleState )
                    {
                    // InternalBot.g:1338:2: ( ruleState )
                    // InternalBot.g:1339:3: ruleState
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
                    // InternalBot.g:1344:2: ( ruleState2 )
                    {
                    // InternalBot.g:1344:2: ( ruleState2 )
                    // InternalBot.g:1345:3: ruleState2
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
    // InternalBot.g:1354:1: rule__IntentInput__Alternatives : ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) );
    public final void rule__IntentInput__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1358:1: ( ( ruleTrainingPhrase ) | ( ruleRegexInput ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||LA7_0==75) ) {
                alt7=1;
            }
            else if ( (LA7_0==82) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalBot.g:1359:2: ( ruleTrainingPhrase )
                    {
                    // InternalBot.g:1359:2: ( ruleTrainingPhrase )
                    // InternalBot.g:1360:3: ruleTrainingPhrase
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
                    // InternalBot.g:1365:2: ( ruleRegexInput )
                    {
                    // InternalBot.g:1365:2: ( ruleRegexInput )
                    // InternalBot.g:1366:3: ruleRegexInput
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
    // InternalBot.g:1375:1: rule__TrainingPhrase__TokensAlternatives_1_0 : ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) );
    public final void rule__TrainingPhrase__TokensAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1379:1: ( ( ruleLiteral ) | ( ruleParameterRefenceToken ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            else if ( (LA8_0==75) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalBot.g:1380:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1380:2: ( ruleLiteral )
                    // InternalBot.g:1381:3: ruleLiteral
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
                    // InternalBot.g:1386:2: ( ruleParameterRefenceToken )
                    {
                    // InternalBot.g:1386:2: ( ruleParameterRefenceToken )
                    // InternalBot.g:1387:3: ruleParameterRefenceToken
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
    // InternalBot.g:1396:1: rule__Parameter__Alternatives_3 : ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) );
    public final void rule__Parameter__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1400:1: ( ( ( rule__Parameter__EntityAssignment_3_0 ) ) | ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                alt9=1;
            }
            else if ( (LA9_0==12||(LA9_0>=15 && LA9_0<=18)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBot.g:1401:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    {
                    // InternalBot.g:1401:2: ( ( rule__Parameter__EntityAssignment_3_0 ) )
                    // InternalBot.g:1402:3: ( rule__Parameter__EntityAssignment_3_0 )
                    {
                     before(grammarAccess.getParameterAccess().getEntityAssignment_3_0()); 
                    // InternalBot.g:1403:3: ( rule__Parameter__EntityAssignment_3_0 )
                    // InternalBot.g:1403:4: rule__Parameter__EntityAssignment_3_0
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
                    // InternalBot.g:1407:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    {
                    // InternalBot.g:1407:2: ( ( rule__Parameter__DefaultEntityAssignment_3_1 ) )
                    // InternalBot.g:1408:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    {
                     before(grammarAccess.getParameterAccess().getDefaultEntityAssignment_3_1()); 
                    // InternalBot.g:1409:3: ( rule__Parameter__DefaultEntityAssignment_3_1 )
                    // InternalBot.g:1409:4: rule__Parameter__DefaultEntityAssignment_3_1
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
    // InternalBot.g:1417:1: rule__Entity__Alternatives : ( ( ruleSimpleEntity ) | ( ruleComplexEntity ) | ( ruleRegexEntity ) );
    public final void rule__Entity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1421:1: ( ( ruleSimpleEntity ) | ( ruleComplexEntity ) | ( ruleRegexEntity ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt10=1;
                }
                break;
            case 80:
                {
                alt10=2;
                }
                break;
            case 81:
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
                    // InternalBot.g:1422:2: ( ruleSimpleEntity )
                    {
                    // InternalBot.g:1422:2: ( ruleSimpleEntity )
                    // InternalBot.g:1423:3: ruleSimpleEntity
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
                    // InternalBot.g:1428:2: ( ruleComplexEntity )
                    {
                    // InternalBot.g:1428:2: ( ruleComplexEntity )
                    // InternalBot.g:1429:3: ruleComplexEntity
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
                    // InternalBot.g:1434:2: ( ruleRegexEntity )
                    {
                    // InternalBot.g:1434:2: ( ruleRegexEntity )
                    // InternalBot.g:1435:3: ruleRegexEntity
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
    // InternalBot.g:1444:1: rule__CompositeInput__ExpresionAlternatives_3_0 : ( ( ruleLiteral ) | ( ruleEntityToken ) );
    public final void rule__CompositeInput__ExpresionAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1448:1: ( ( ruleLiteral ) | ( ruleEntityToken ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=RULE_STRING && LA11_0<=RULE_ID)) ) {
                alt11=1;
            }
            else if ( (LA11_0==74) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:1449:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1449:2: ( ruleLiteral )
                    // InternalBot.g:1450:3: ruleLiteral
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
                    // InternalBot.g:1455:2: ( ruleEntityToken )
                    {
                    // InternalBot.g:1455:2: ( ruleEntityToken )
                    // InternalBot.g:1456:3: ruleEntityToken
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


    // $ANTLR start "rule__Text__Alternatives_0"
    // InternalBot.g:1465:1: rule__Text__Alternatives_0 : ( ( 'Text' ) | ( 'text' ) );
    public final void rule__Text__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1469:1: ( ( 'Text' ) | ( 'text' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==11) ) {
                alt12=1;
            }
            else if ( (LA12_0==12) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalBot.g:1470:2: ( 'Text' )
                    {
                    // InternalBot.g:1470:2: ( 'Text' )
                    // InternalBot.g:1471:3: 'Text'
                    {
                     before(grammarAccess.getTextAccess().getTextKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTextAccess().getTextKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1476:2: ( 'text' )
                    {
                    // InternalBot.g:1476:2: ( 'text' )
                    // InternalBot.g:1477:3: 'text'
                    {
                     before(grammarAccess.getTextAccess().getTextKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTextAccess().getTextKeyword_0_1()); 

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
    // $ANTLR end "rule__Text__Alternatives_0"


    // $ANTLR start "rule__Image__Alternatives_0"
    // InternalBot.g:1486:1: rule__Image__Alternatives_0 : ( ( 'Image' ) | ( 'mage' ) );
    public final void rule__Image__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1490:1: ( ( 'Image' ) | ( 'mage' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==13) ) {
                alt13=1;
            }
            else if ( (LA13_0==14) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalBot.g:1491:2: ( 'Image' )
                    {
                    // InternalBot.g:1491:2: ( 'Image' )
                    // InternalBot.g:1492:3: 'Image'
                    {
                     before(grammarAccess.getImageAccess().getImageKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getImageAccess().getImageKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1497:2: ( 'mage' )
                    {
                    // InternalBot.g:1497:2: ( 'mage' )
                    // InternalBot.g:1498:3: 'mage'
                    {
                     before(grammarAccess.getImageAccess().getMageKeyword_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getImageAccess().getMageKeyword_0_1()); 

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
    // $ANTLR end "rule__Image__Alternatives_0"


    // $ANTLR start "rule__TextInputHttpResponse__TokensAlternatives_0"
    // InternalBot.g:1507:1: rule__TextInputHttpResponse__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) );
    public final void rule__TextInputHttpResponse__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1511:1: ( ( ruleLiteral ) | ( ruleParameterToken ) | ( ruleHTTPRequestToken ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
                {
                alt14=1;
                }
                break;
            case 72:
                {
                alt14=2;
                }
                break;
            case 77:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalBot.g:1512:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1512:2: ( ruleLiteral )
                    // InternalBot.g:1513:3: ruleLiteral
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
                    // InternalBot.g:1518:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1518:2: ( ruleParameterToken )
                    // InternalBot.g:1519:3: ruleParameterToken
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
                    // InternalBot.g:1524:2: ( ruleHTTPRequestToken )
                    {
                    // InternalBot.g:1524:2: ( ruleHTTPRequestToken )
                    // InternalBot.g:1525:3: ruleHTTPRequestToken
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
    // InternalBot.g:1534:1: rule__TextInputText__TokensAlternatives_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__TextInputText__TokensAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1538:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_STRING && LA15_0<=RULE_ID)) ) {
                alt15=1;
            }
            else if ( (LA15_0==72) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:1539:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1539:2: ( ruleLiteral )
                    // InternalBot.g:1540:3: ruleLiteral
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
                    // InternalBot.g:1545:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1545:2: ( ruleParameterToken )
                    // InternalBot.g:1546:3: ruleParameterToken
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
    // InternalBot.g:1555:1: rule__Data__ValueAlternatives_2_0 : ( ( ruleLiteral ) | ( ruleParameterToken ) );
    public final void rule__Data__ValueAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1559:1: ( ( ruleLiteral ) | ( ruleParameterToken ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_ID)) ) {
                alt16=1;
            }
            else if ( (LA16_0==72) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalBot.g:1560:2: ( ruleLiteral )
                    {
                    // InternalBot.g:1560:2: ( ruleLiteral )
                    // InternalBot.g:1561:3: ruleLiteral
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
                    // InternalBot.g:1566:2: ( ruleParameterToken )
                    {
                    // InternalBot.g:1566:2: ( ruleParameterToken )
                    // InternalBot.g:1567:3: ruleParameterToken
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
    // InternalBot.g:1576:1: rule__DefaultEntity__Alternatives : ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) );
    public final void rule__DefaultEntity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1580:1: ( ( ( 'text' ) ) | ( ( 'number' ) ) | ( ( 'date' ) ) | ( ( 'float' ) ) | ( ( 'time' ) ) )
            int alt17=5;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt17=1;
                }
                break;
            case 15:
                {
                alt17=2;
                }
                break;
            case 16:
                {
                alt17=3;
                }
                break;
            case 17:
                {
                alt17=4;
                }
                break;
            case 18:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalBot.g:1581:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1581:2: ( ( 'text' ) )
                    // InternalBot.g:1582:3: ( 'text' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1583:3: ( 'text' )
                    // InternalBot.g:1583:4: 'text'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1587:2: ( ( 'number' ) )
                    {
                    // InternalBot.g:1587:2: ( ( 'number' ) )
                    // InternalBot.g:1588:3: ( 'number' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalBot.g:1589:3: ( 'number' )
                    // InternalBot.g:1589:4: 'number'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1593:2: ( ( 'date' ) )
                    {
                    // InternalBot.g:1593:2: ( ( 'date' ) )
                    // InternalBot.g:1594:3: ( 'date' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1595:3: ( 'date' )
                    // InternalBot.g:1595:4: 'date'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1599:2: ( ( 'float' ) )
                    {
                    // InternalBot.g:1599:2: ( ( 'float' ) )
                    // InternalBot.g:1600:3: ( 'float' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1601:3: ( 'float' )
                    // InternalBot.g:1601:4: 'float'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1605:2: ( ( 'time' ) )
                    {
                    // InternalBot.g:1605:2: ( ( 'time' ) )
                    // InternalBot.g:1606:3: ( 'time' )
                    {
                     before(grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1607:3: ( 'time' )
                    // InternalBot.g:1607:4: 'time'
                    {
                    match(input,18,FOLLOW_2); 

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
    // InternalBot.g:1615:1: rule__HTTPReturnType__Alternatives : ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) );
    public final void rule__HTTPReturnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1619:1: ( ( ( 'text' ) ) | ( ( 'status_code' ) ) | ( ( 'image' ) ) | ( ( 'data' ) ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt18=1;
                }
                break;
            case 19:
                {
                alt18=2;
                }
                break;
            case 20:
                {
                alt18=3;
                }
                break;
            case 21:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalBot.g:1620:2: ( ( 'text' ) )
                    {
                    // InternalBot.g:1620:2: ( ( 'text' ) )
                    // InternalBot.g:1621:3: ( 'text' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1622:3: ( 'text' )
                    // InternalBot.g:1622:4: 'text'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1626:2: ( ( 'status_code' ) )
                    {
                    // InternalBot.g:1626:2: ( ( 'status_code' ) )
                    // InternalBot.g:1627:3: ( 'status_code' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1628:3: ( 'status_code' )
                    // InternalBot.g:1628:4: 'status_code'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1632:2: ( ( 'image' ) )
                    {
                    // InternalBot.g:1632:2: ( ( 'image' ) )
                    // InternalBot.g:1633:3: ( 'image' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1634:3: ( 'image' )
                    // InternalBot.g:1634:4: 'image'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1638:2: ( ( 'data' ) )
                    {
                    // InternalBot.g:1638:2: ( ( 'data' ) )
                    // InternalBot.g:1639:3: ( 'data' )
                    {
                     before(grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1640:3: ( 'data' )
                    // InternalBot.g:1640:4: 'data'
                    {
                    match(input,21,FOLLOW_2); 

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
    // InternalBot.g:1648:1: rule__Language__Alternatives : ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) );
    public final void rule__Language__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1652:1: ( ( ( 'en' ) ) | ( ( 'es' ) ) | ( ( 'da' ) ) | ( ( 'de' ) ) | ( ( 'fr' ) ) | ( ( 'hi' ) ) | ( ( 'id' ) ) | ( ( 'it' ) ) | ( ( 'ja' ) ) | ( ( 'ko' ) ) | ( ( 'nl' ) ) | ( ( 'no' ) ) | ( ( 'pl' ) ) | ( ( 'pt' ) ) | ( ( 'ru' ) ) | ( ( 'sv' ) ) | ( ( 'th' ) ) | ( ( 'tr' ) ) | ( ( 'uk' ) ) | ( ( 'zh' ) ) | ( ( 'ar' ) ) | ( ( 'cz' ) ) | ( ( 'bu' ) ) | ( ( 'fi' ) ) | ( ( 'gr' ) ) | ( ( 'ba' ) ) )
            int alt19=26;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt19=1;
                }
                break;
            case 23:
                {
                alt19=2;
                }
                break;
            case 24:
                {
                alt19=3;
                }
                break;
            case 25:
                {
                alt19=4;
                }
                break;
            case 26:
                {
                alt19=5;
                }
                break;
            case 27:
                {
                alt19=6;
                }
                break;
            case 28:
                {
                alt19=7;
                }
                break;
            case 29:
                {
                alt19=8;
                }
                break;
            case 30:
                {
                alt19=9;
                }
                break;
            case 31:
                {
                alt19=10;
                }
                break;
            case 32:
                {
                alt19=11;
                }
                break;
            case 33:
                {
                alt19=12;
                }
                break;
            case 34:
                {
                alt19=13;
                }
                break;
            case 35:
                {
                alt19=14;
                }
                break;
            case 36:
                {
                alt19=15;
                }
                break;
            case 37:
                {
                alt19=16;
                }
                break;
            case 38:
                {
                alt19=17;
                }
                break;
            case 39:
                {
                alt19=18;
                }
                break;
            case 40:
                {
                alt19=19;
                }
                break;
            case 41:
                {
                alt19=20;
                }
                break;
            case 42:
                {
                alt19=21;
                }
                break;
            case 43:
                {
                alt19=22;
                }
                break;
            case 44:
                {
                alt19=23;
                }
                break;
            case 45:
                {
                alt19=24;
                }
                break;
            case 46:
                {
                alt19=25;
                }
                break;
            case 47:
                {
                alt19=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalBot.g:1653:2: ( ( 'en' ) )
                    {
                    // InternalBot.g:1653:2: ( ( 'en' ) )
                    // InternalBot.g:1654:3: ( 'en' )
                    {
                     before(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1655:3: ( 'en' )
                    // InternalBot.g:1655:4: 'en'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1659:2: ( ( 'es' ) )
                    {
                    // InternalBot.g:1659:2: ( ( 'es' ) )
                    // InternalBot.g:1660:3: ( 'es' )
                    {
                     before(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1661:3: ( 'es' )
                    // InternalBot.g:1661:4: 'es'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:1665:2: ( ( 'da' ) )
                    {
                    // InternalBot.g:1665:2: ( ( 'da' ) )
                    // InternalBot.g:1666:3: ( 'da' )
                    {
                     before(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 
                    // InternalBot.g:1667:3: ( 'da' )
                    // InternalBot.g:1667:4: 'da'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:1671:2: ( ( 'de' ) )
                    {
                    // InternalBot.g:1671:2: ( ( 'de' ) )
                    // InternalBot.g:1672:3: ( 'de' )
                    {
                     before(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 
                    // InternalBot.g:1673:3: ( 'de' )
                    // InternalBot.g:1673:4: 'de'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:1677:2: ( ( 'fr' ) )
                    {
                    // InternalBot.g:1677:2: ( ( 'fr' ) )
                    // InternalBot.g:1678:3: ( 'fr' )
                    {
                     before(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 
                    // InternalBot.g:1679:3: ( 'fr' )
                    // InternalBot.g:1679:4: 'fr'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:1683:2: ( ( 'hi' ) )
                    {
                    // InternalBot.g:1683:2: ( ( 'hi' ) )
                    // InternalBot.g:1684:3: ( 'hi' )
                    {
                     before(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 
                    // InternalBot.g:1685:3: ( 'hi' )
                    // InternalBot.g:1685:4: 'hi'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:1689:2: ( ( 'id' ) )
                    {
                    // InternalBot.g:1689:2: ( ( 'id' ) )
                    // InternalBot.g:1690:3: ( 'id' )
                    {
                     before(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 
                    // InternalBot.g:1691:3: ( 'id' )
                    // InternalBot.g:1691:4: 'id'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:1695:2: ( ( 'it' ) )
                    {
                    // InternalBot.g:1695:2: ( ( 'it' ) )
                    // InternalBot.g:1696:3: ( 'it' )
                    {
                     before(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 
                    // InternalBot.g:1697:3: ( 'it' )
                    // InternalBot.g:1697:4: 'it'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:1701:2: ( ( 'ja' ) )
                    {
                    // InternalBot.g:1701:2: ( ( 'ja' ) )
                    // InternalBot.g:1702:3: ( 'ja' )
                    {
                     before(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 
                    // InternalBot.g:1703:3: ( 'ja' )
                    // InternalBot.g:1703:4: 'ja'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:1707:2: ( ( 'ko' ) )
                    {
                    // InternalBot.g:1707:2: ( ( 'ko' ) )
                    // InternalBot.g:1708:3: ( 'ko' )
                    {
                     before(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 
                    // InternalBot.g:1709:3: ( 'ko' )
                    // InternalBot.g:1709:4: 'ko'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:1713:2: ( ( 'nl' ) )
                    {
                    // InternalBot.g:1713:2: ( ( 'nl' ) )
                    // InternalBot.g:1714:3: ( 'nl' )
                    {
                     before(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 
                    // InternalBot.g:1715:3: ( 'nl' )
                    // InternalBot.g:1715:4: 'nl'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:1719:2: ( ( 'no' ) )
                    {
                    // InternalBot.g:1719:2: ( ( 'no' ) )
                    // InternalBot.g:1720:3: ( 'no' )
                    {
                     before(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 
                    // InternalBot.g:1721:3: ( 'no' )
                    // InternalBot.g:1721:4: 'no'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:1725:2: ( ( 'pl' ) )
                    {
                    // InternalBot.g:1725:2: ( ( 'pl' ) )
                    // InternalBot.g:1726:3: ( 'pl' )
                    {
                     before(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 
                    // InternalBot.g:1727:3: ( 'pl' )
                    // InternalBot.g:1727:4: 'pl'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:1731:2: ( ( 'pt' ) )
                    {
                    // InternalBot.g:1731:2: ( ( 'pt' ) )
                    // InternalBot.g:1732:3: ( 'pt' )
                    {
                     before(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 
                    // InternalBot.g:1733:3: ( 'pt' )
                    // InternalBot.g:1733:4: 'pt'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:1737:2: ( ( 'ru' ) )
                    {
                    // InternalBot.g:1737:2: ( ( 'ru' ) )
                    // InternalBot.g:1738:3: ( 'ru' )
                    {
                     before(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 
                    // InternalBot.g:1739:3: ( 'ru' )
                    // InternalBot.g:1739:4: 'ru'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:1743:2: ( ( 'sv' ) )
                    {
                    // InternalBot.g:1743:2: ( ( 'sv' ) )
                    // InternalBot.g:1744:3: ( 'sv' )
                    {
                     before(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 
                    // InternalBot.g:1745:3: ( 'sv' )
                    // InternalBot.g:1745:4: 'sv'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:1749:2: ( ( 'th' ) )
                    {
                    // InternalBot.g:1749:2: ( ( 'th' ) )
                    // InternalBot.g:1750:3: ( 'th' )
                    {
                     before(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 
                    // InternalBot.g:1751:3: ( 'th' )
                    // InternalBot.g:1751:4: 'th'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:1755:2: ( ( 'tr' ) )
                    {
                    // InternalBot.g:1755:2: ( ( 'tr' ) )
                    // InternalBot.g:1756:3: ( 'tr' )
                    {
                     before(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 
                    // InternalBot.g:1757:3: ( 'tr' )
                    // InternalBot.g:1757:4: 'tr'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:1761:2: ( ( 'uk' ) )
                    {
                    // InternalBot.g:1761:2: ( ( 'uk' ) )
                    // InternalBot.g:1762:3: ( 'uk' )
                    {
                     before(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 
                    // InternalBot.g:1763:3: ( 'uk' )
                    // InternalBot.g:1763:4: 'uk'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:1767:2: ( ( 'zh' ) )
                    {
                    // InternalBot.g:1767:2: ( ( 'zh' ) )
                    // InternalBot.g:1768:3: ( 'zh' )
                    {
                     before(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 
                    // InternalBot.g:1769:3: ( 'zh' )
                    // InternalBot.g:1769:4: 'zh'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:1773:2: ( ( 'ar' ) )
                    {
                    // InternalBot.g:1773:2: ( ( 'ar' ) )
                    // InternalBot.g:1774:3: ( 'ar' )
                    {
                     before(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 
                    // InternalBot.g:1775:3: ( 'ar' )
                    // InternalBot.g:1775:4: 'ar'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:1779:2: ( ( 'cz' ) )
                    {
                    // InternalBot.g:1779:2: ( ( 'cz' ) )
                    // InternalBot.g:1780:3: ( 'cz' )
                    {
                     before(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 
                    // InternalBot.g:1781:3: ( 'cz' )
                    // InternalBot.g:1781:4: 'cz'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:1785:2: ( ( 'bu' ) )
                    {
                    // InternalBot.g:1785:2: ( ( 'bu' ) )
                    // InternalBot.g:1786:3: ( 'bu' )
                    {
                     before(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 
                    // InternalBot.g:1787:3: ( 'bu' )
                    // InternalBot.g:1787:4: 'bu'
                    {
                    match(input,44,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:1791:2: ( ( 'fi' ) )
                    {
                    // InternalBot.g:1791:2: ( ( 'fi' ) )
                    // InternalBot.g:1792:3: ( 'fi' )
                    {
                     before(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 
                    // InternalBot.g:1793:3: ( 'fi' )
                    // InternalBot.g:1793:4: 'fi'
                    {
                    match(input,45,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23()); 

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:1797:2: ( ( 'gr' ) )
                    {
                    // InternalBot.g:1797:2: ( ( 'gr' ) )
                    // InternalBot.g:1798:3: ( 'gr' )
                    {
                     before(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 
                    // InternalBot.g:1799:3: ( 'gr' )
                    // InternalBot.g:1799:4: 'gr'
                    {
                    match(input,46,FOLLOW_2); 

                    }

                     after(grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24()); 

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:1803:2: ( ( 'ba' ) )
                    {
                    // InternalBot.g:1803:2: ( ( 'ba' ) )
                    // InternalBot.g:1804:3: ( 'ba' )
                    {
                     before(grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25()); 
                    // InternalBot.g:1805:3: ( 'ba' )
                    // InternalBot.g:1805:4: 'ba'
                    {
                    match(input,47,FOLLOW_2); 

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
    // InternalBot.g:1813:1: rule__DataType__Alternatives : ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1817:1: ( ( ( 'JSON' ) ) | ( ( 'FORM' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==48) ) {
                alt20=1;
            }
            else if ( (LA20_0==49) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:1818:2: ( ( 'JSON' ) )
                    {
                    // InternalBot.g:1818:2: ( ( 'JSON' ) )
                    // InternalBot.g:1819:3: ( 'JSON' )
                    {
                     before(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1820:3: ( 'JSON' )
                    // InternalBot.g:1820:4: 'JSON'
                    {
                    match(input,48,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1824:2: ( ( 'FORM' ) )
                    {
                    // InternalBot.g:1824:2: ( ( 'FORM' ) )
                    // InternalBot.g:1825:3: ( 'FORM' )
                    {
                     before(grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1826:3: ( 'FORM' )
                    // InternalBot.g:1826:4: 'FORM'
                    {
                    match(input,49,FOLLOW_2); 

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
    // InternalBot.g:1834:1: rule__Method__Alternatives : ( ( ( 'post' ) ) | ( ( 'get' ) ) );
    public final void rule__Method__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1838:1: ( ( ( 'post' ) ) | ( ( 'get' ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==50) ) {
                alt21=1;
            }
            else if ( (LA21_0==51) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalBot.g:1839:2: ( ( 'post' ) )
                    {
                    // InternalBot.g:1839:2: ( ( 'post' ) )
                    // InternalBot.g:1840:3: ( 'post' )
                    {
                     before(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 
                    // InternalBot.g:1841:3: ( 'post' )
                    // InternalBot.g:1841:4: 'post'
                    {
                    match(input,50,FOLLOW_2); 

                    }

                     after(grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1845:2: ( ( 'get' ) )
                    {
                    // InternalBot.g:1845:2: ( ( 'get' ) )
                    // InternalBot.g:1846:3: ( 'get' )
                    {
                     before(grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1()); 
                    // InternalBot.g:1847:3: ( 'get' )
                    // InternalBot.g:1847:4: 'get'
                    {
                    match(input,51,FOLLOW_2); 

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
    // InternalBot.g:1855:1: rule__Bot__Group__0 : rule__Bot__Group__0__Impl rule__Bot__Group__1 ;
    public final void rule__Bot__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1859:1: ( rule__Bot__Group__0__Impl rule__Bot__Group__1 )
            // InternalBot.g:1860:2: rule__Bot__Group__0__Impl rule__Bot__Group__1
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
    // InternalBot.g:1867:1: rule__Bot__Group__0__Impl : ( 'Chatbot' ) ;
    public final void rule__Bot__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1871:1: ( ( 'Chatbot' ) )
            // InternalBot.g:1872:1: ( 'Chatbot' )
            {
            // InternalBot.g:1872:1: ( 'Chatbot' )
            // InternalBot.g:1873:2: 'Chatbot'
            {
             before(grammarAccess.getBotAccess().getChatbotKeyword_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalBot.g:1882:1: rule__Bot__Group__1 : rule__Bot__Group__1__Impl rule__Bot__Group__2 ;
    public final void rule__Bot__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1886:1: ( rule__Bot__Group__1__Impl rule__Bot__Group__2 )
            // InternalBot.g:1887:2: rule__Bot__Group__1__Impl rule__Bot__Group__2
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
    // InternalBot.g:1894:1: rule__Bot__Group__1__Impl : ( ( rule__Bot__NameAssignment_1 ) ) ;
    public final void rule__Bot__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1898:1: ( ( ( rule__Bot__NameAssignment_1 ) ) )
            // InternalBot.g:1899:1: ( ( rule__Bot__NameAssignment_1 ) )
            {
            // InternalBot.g:1899:1: ( ( rule__Bot__NameAssignment_1 ) )
            // InternalBot.g:1900:2: ( rule__Bot__NameAssignment_1 )
            {
             before(grammarAccess.getBotAccess().getNameAssignment_1()); 
            // InternalBot.g:1901:2: ( rule__Bot__NameAssignment_1 )
            // InternalBot.g:1901:3: rule__Bot__NameAssignment_1
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
    // InternalBot.g:1909:1: rule__Bot__Group__2 : rule__Bot__Group__2__Impl rule__Bot__Group__3 ;
    public final void rule__Bot__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1913:1: ( rule__Bot__Group__2__Impl rule__Bot__Group__3 )
            // InternalBot.g:1914:2: rule__Bot__Group__2__Impl rule__Bot__Group__3
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
    // InternalBot.g:1921:1: rule__Bot__Group__2__Impl : ( 'language' ) ;
    public final void rule__Bot__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1925:1: ( ( 'language' ) )
            // InternalBot.g:1926:1: ( 'language' )
            {
            // InternalBot.g:1926:1: ( 'language' )
            // InternalBot.g:1927:2: 'language'
            {
             before(grammarAccess.getBotAccess().getLanguageKeyword_2()); 
            match(input,53,FOLLOW_2); 
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
    // InternalBot.g:1936:1: rule__Bot__Group__3 : rule__Bot__Group__3__Impl rule__Bot__Group__4 ;
    public final void rule__Bot__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1940:1: ( rule__Bot__Group__3__Impl rule__Bot__Group__4 )
            // InternalBot.g:1941:2: rule__Bot__Group__3__Impl rule__Bot__Group__4
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
    // InternalBot.g:1948:1: rule__Bot__Group__3__Impl : ( ':' ) ;
    public final void rule__Bot__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1952:1: ( ( ':' ) )
            // InternalBot.g:1953:1: ( ':' )
            {
            // InternalBot.g:1953:1: ( ':' )
            // InternalBot.g:1954:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:1963:1: rule__Bot__Group__4 : rule__Bot__Group__4__Impl rule__Bot__Group__5 ;
    public final void rule__Bot__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1967:1: ( rule__Bot__Group__4__Impl rule__Bot__Group__5 )
            // InternalBot.g:1968:2: rule__Bot__Group__4__Impl rule__Bot__Group__5
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
    // InternalBot.g:1975:1: rule__Bot__Group__4__Impl : ( ( rule__Bot__LanguagesAssignment_4 ) ) ;
    public final void rule__Bot__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1979:1: ( ( ( rule__Bot__LanguagesAssignment_4 ) ) )
            // InternalBot.g:1980:1: ( ( rule__Bot__LanguagesAssignment_4 ) )
            {
            // InternalBot.g:1980:1: ( ( rule__Bot__LanguagesAssignment_4 ) )
            // InternalBot.g:1981:2: ( rule__Bot__LanguagesAssignment_4 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_4()); 
            // InternalBot.g:1982:2: ( rule__Bot__LanguagesAssignment_4 )
            // InternalBot.g:1982:3: rule__Bot__LanguagesAssignment_4
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
    // InternalBot.g:1990:1: rule__Bot__Group__5 : rule__Bot__Group__5__Impl rule__Bot__Group__6 ;
    public final void rule__Bot__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:1994:1: ( rule__Bot__Group__5__Impl rule__Bot__Group__6 )
            // InternalBot.g:1995:2: rule__Bot__Group__5__Impl rule__Bot__Group__6
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
    // InternalBot.g:2002:1: rule__Bot__Group__5__Impl : ( ( rule__Bot__Group_5__0 )* ) ;
    public final void rule__Bot__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2006:1: ( ( ( rule__Bot__Group_5__0 )* ) )
            // InternalBot.g:2007:1: ( ( rule__Bot__Group_5__0 )* )
            {
            // InternalBot.g:2007:1: ( ( rule__Bot__Group_5__0 )* )
            // InternalBot.g:2008:2: ( rule__Bot__Group_5__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_5()); 
            // InternalBot.g:2009:2: ( rule__Bot__Group_5__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==57) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBot.g:2009:3: rule__Bot__Group_5__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Bot__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalBot.g:2017:1: rule__Bot__Group__6 : rule__Bot__Group__6__Impl rule__Bot__Group__7 ;
    public final void rule__Bot__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2021:1: ( rule__Bot__Group__6__Impl rule__Bot__Group__7 )
            // InternalBot.g:2022:2: rule__Bot__Group__6__Impl rule__Bot__Group__7
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
    // InternalBot.g:2029:1: rule__Bot__Group__6__Impl : ( 'intents' ) ;
    public final void rule__Bot__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2033:1: ( ( 'intents' ) )
            // InternalBot.g:2034:1: ( 'intents' )
            {
            // InternalBot.g:2034:1: ( 'intents' )
            // InternalBot.g:2035:2: 'intents'
            {
             before(grammarAccess.getBotAccess().getIntentsKeyword_6()); 
            match(input,55,FOLLOW_2); 
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
    // InternalBot.g:2044:1: rule__Bot__Group__7 : rule__Bot__Group__7__Impl rule__Bot__Group__8 ;
    public final void rule__Bot__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2048:1: ( rule__Bot__Group__7__Impl rule__Bot__Group__8 )
            // InternalBot.g:2049:2: rule__Bot__Group__7__Impl rule__Bot__Group__8
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
    // InternalBot.g:2056:1: rule__Bot__Group__7__Impl : ( ':' ) ;
    public final void rule__Bot__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2060:1: ( ( ':' ) )
            // InternalBot.g:2061:1: ( ':' )
            {
            // InternalBot.g:2061:1: ( ':' )
            // InternalBot.g:2062:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_7()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:2071:1: rule__Bot__Group__8 : rule__Bot__Group__8__Impl rule__Bot__Group__9 ;
    public final void rule__Bot__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2075:1: ( rule__Bot__Group__8__Impl rule__Bot__Group__9 )
            // InternalBot.g:2076:2: rule__Bot__Group__8__Impl rule__Bot__Group__9
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
    // InternalBot.g:2083:1: rule__Bot__Group__8__Impl : ( ( rule__Bot__IntentsAssignment_8 ) ) ;
    public final void rule__Bot__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2087:1: ( ( ( rule__Bot__IntentsAssignment_8 ) ) )
            // InternalBot.g:2088:1: ( ( rule__Bot__IntentsAssignment_8 ) )
            {
            // InternalBot.g:2088:1: ( ( rule__Bot__IntentsAssignment_8 ) )
            // InternalBot.g:2089:2: ( rule__Bot__IntentsAssignment_8 )
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_8()); 
            // InternalBot.g:2090:2: ( rule__Bot__IntentsAssignment_8 )
            // InternalBot.g:2090:3: rule__Bot__IntentsAssignment_8
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
    // InternalBot.g:2098:1: rule__Bot__Group__9 : rule__Bot__Group__9__Impl rule__Bot__Group__10 ;
    public final void rule__Bot__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2102:1: ( rule__Bot__Group__9__Impl rule__Bot__Group__10 )
            // InternalBot.g:2103:2: rule__Bot__Group__9__Impl rule__Bot__Group__10
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
    // InternalBot.g:2110:1: rule__Bot__Group__9__Impl : ( ( rule__Bot__IntentsAssignment_9 )* ) ;
    public final void rule__Bot__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2114:1: ( ( ( rule__Bot__IntentsAssignment_9 )* ) )
            // InternalBot.g:2115:1: ( ( rule__Bot__IntentsAssignment_9 )* )
            {
            // InternalBot.g:2115:1: ( ( rule__Bot__IntentsAssignment_9 )* )
            // InternalBot.g:2116:2: ( rule__Bot__IntentsAssignment_9 )*
            {
             before(grammarAccess.getBotAccess().getIntentsAssignment_9()); 
            // InternalBot.g:2117:2: ( rule__Bot__IntentsAssignment_9 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:2117:3: rule__Bot__IntentsAssignment_9
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Bot__IntentsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalBot.g:2125:1: rule__Bot__Group__10 : rule__Bot__Group__10__Impl rule__Bot__Group__11 ;
    public final void rule__Bot__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2129:1: ( rule__Bot__Group__10__Impl rule__Bot__Group__11 )
            // InternalBot.g:2130:2: rule__Bot__Group__10__Impl rule__Bot__Group__11
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
    // InternalBot.g:2137:1: rule__Bot__Group__10__Impl : ( ( rule__Bot__Group_10__0 )? ) ;
    public final void rule__Bot__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2141:1: ( ( ( rule__Bot__Group_10__0 )? ) )
            // InternalBot.g:2142:1: ( ( rule__Bot__Group_10__0 )? )
            {
            // InternalBot.g:2142:1: ( ( rule__Bot__Group_10__0 )? )
            // InternalBot.g:2143:2: ( rule__Bot__Group_10__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_10()); 
            // InternalBot.g:2144:2: ( rule__Bot__Group_10__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==58) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalBot.g:2144:3: rule__Bot__Group_10__0
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
    // InternalBot.g:2152:1: rule__Bot__Group__11 : rule__Bot__Group__11__Impl rule__Bot__Group__12 ;
    public final void rule__Bot__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2156:1: ( rule__Bot__Group__11__Impl rule__Bot__Group__12 )
            // InternalBot.g:2157:2: rule__Bot__Group__11__Impl rule__Bot__Group__12
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
    // InternalBot.g:2164:1: rule__Bot__Group__11__Impl : ( ( rule__Bot__Group_11__0 )? ) ;
    public final void rule__Bot__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2168:1: ( ( ( rule__Bot__Group_11__0 )? ) )
            // InternalBot.g:2169:1: ( ( rule__Bot__Group_11__0 )? )
            {
            // InternalBot.g:2169:1: ( ( rule__Bot__Group_11__0 )? )
            // InternalBot.g:2170:2: ( rule__Bot__Group_11__0 )?
            {
             before(grammarAccess.getBotAccess().getGroup_11()); 
            // InternalBot.g:2171:2: ( rule__Bot__Group_11__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==59) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:2171:3: rule__Bot__Group_11__0
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
    // InternalBot.g:2179:1: rule__Bot__Group__12 : rule__Bot__Group__12__Impl rule__Bot__Group__13 ;
    public final void rule__Bot__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2183:1: ( rule__Bot__Group__12__Impl rule__Bot__Group__13 )
            // InternalBot.g:2184:2: rule__Bot__Group__12__Impl rule__Bot__Group__13
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
    // InternalBot.g:2191:1: rule__Bot__Group__12__Impl : ( 'flows' ) ;
    public final void rule__Bot__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2195:1: ( ( 'flows' ) )
            // InternalBot.g:2196:1: ( 'flows' )
            {
            // InternalBot.g:2196:1: ( 'flows' )
            // InternalBot.g:2197:2: 'flows'
            {
             before(grammarAccess.getBotAccess().getFlowsKeyword_12()); 
            match(input,56,FOLLOW_2); 
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
    // InternalBot.g:2206:1: rule__Bot__Group__13 : rule__Bot__Group__13__Impl rule__Bot__Group__14 ;
    public final void rule__Bot__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2210:1: ( rule__Bot__Group__13__Impl rule__Bot__Group__14 )
            // InternalBot.g:2211:2: rule__Bot__Group__13__Impl rule__Bot__Group__14
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
    // InternalBot.g:2218:1: rule__Bot__Group__13__Impl : ( ':' ) ;
    public final void rule__Bot__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2222:1: ( ( ':' ) )
            // InternalBot.g:2223:1: ( ':' )
            {
            // InternalBot.g:2223:1: ( ':' )
            // InternalBot.g:2224:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_13()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:2233:1: rule__Bot__Group__14 : rule__Bot__Group__14__Impl ;
    public final void rule__Bot__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2237:1: ( rule__Bot__Group__14__Impl )
            // InternalBot.g:2238:2: rule__Bot__Group__14__Impl
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
    // InternalBot.g:2244:1: rule__Bot__Group__14__Impl : ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) ) ;
    public final void rule__Bot__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2248:1: ( ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) ) )
            // InternalBot.g:2249:1: ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) )
            {
            // InternalBot.g:2249:1: ( ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* ) )
            // InternalBot.g:2250:2: ( ( rule__Bot__Group_14__0 ) ) ( ( rule__Bot__Group_14__0 )* )
            {
            // InternalBot.g:2250:2: ( ( rule__Bot__Group_14__0 ) )
            // InternalBot.g:2251:3: ( rule__Bot__Group_14__0 )
            {
             before(grammarAccess.getBotAccess().getGroup_14()); 
            // InternalBot.g:2252:3: ( rule__Bot__Group_14__0 )
            // InternalBot.g:2252:4: rule__Bot__Group_14__0
            {
            pushFollow(FOLLOW_14);
            rule__Bot__Group_14__0();

            state._fsp--;


            }

             after(grammarAccess.getBotAccess().getGroup_14()); 

            }

            // InternalBot.g:2255:2: ( ( rule__Bot__Group_14__0 )* )
            // InternalBot.g:2256:3: ( rule__Bot__Group_14__0 )*
            {
             before(grammarAccess.getBotAccess().getGroup_14()); 
            // InternalBot.g:2257:3: ( rule__Bot__Group_14__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==60) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalBot.g:2257:4: rule__Bot__Group_14__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Bot__Group_14__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalBot.g:2267:1: rule__Bot__Group_5__0 : rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1 ;
    public final void rule__Bot__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2271:1: ( rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1 )
            // InternalBot.g:2272:2: rule__Bot__Group_5__0__Impl rule__Bot__Group_5__1
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
    // InternalBot.g:2279:1: rule__Bot__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Bot__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2283:1: ( ( ',' ) )
            // InternalBot.g:2284:1: ( ',' )
            {
            // InternalBot.g:2284:1: ( ',' )
            // InternalBot.g:2285:2: ','
            {
             before(grammarAccess.getBotAccess().getCommaKeyword_5_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:2294:1: rule__Bot__Group_5__1 : rule__Bot__Group_5__1__Impl ;
    public final void rule__Bot__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2298:1: ( rule__Bot__Group_5__1__Impl )
            // InternalBot.g:2299:2: rule__Bot__Group_5__1__Impl
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
    // InternalBot.g:2305:1: rule__Bot__Group_5__1__Impl : ( ( rule__Bot__LanguagesAssignment_5_1 ) ) ;
    public final void rule__Bot__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2309:1: ( ( ( rule__Bot__LanguagesAssignment_5_1 ) ) )
            // InternalBot.g:2310:1: ( ( rule__Bot__LanguagesAssignment_5_1 ) )
            {
            // InternalBot.g:2310:1: ( ( rule__Bot__LanguagesAssignment_5_1 ) )
            // InternalBot.g:2311:2: ( rule__Bot__LanguagesAssignment_5_1 )
            {
             before(grammarAccess.getBotAccess().getLanguagesAssignment_5_1()); 
            // InternalBot.g:2312:2: ( rule__Bot__LanguagesAssignment_5_1 )
            // InternalBot.g:2312:3: rule__Bot__LanguagesAssignment_5_1
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
    // InternalBot.g:2321:1: rule__Bot__Group_10__0 : rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 ;
    public final void rule__Bot__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2325:1: ( rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1 )
            // InternalBot.g:2326:2: rule__Bot__Group_10__0__Impl rule__Bot__Group_10__1
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
    // InternalBot.g:2333:1: rule__Bot__Group_10__0__Impl : ( 'entities' ) ;
    public final void rule__Bot__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2337:1: ( ( 'entities' ) )
            // InternalBot.g:2338:1: ( 'entities' )
            {
            // InternalBot.g:2338:1: ( 'entities' )
            // InternalBot.g:2339:2: 'entities'
            {
             before(grammarAccess.getBotAccess().getEntitiesKeyword_10_0()); 
            match(input,58,FOLLOW_2); 
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
    // InternalBot.g:2348:1: rule__Bot__Group_10__1 : rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 ;
    public final void rule__Bot__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2352:1: ( rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2 )
            // InternalBot.g:2353:2: rule__Bot__Group_10__1__Impl rule__Bot__Group_10__2
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
    // InternalBot.g:2360:1: rule__Bot__Group_10__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2364:1: ( ( ':' ) )
            // InternalBot.g:2365:1: ( ':' )
            {
            // InternalBot.g:2365:1: ( ':' )
            // InternalBot.g:2366:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_10_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:2375:1: rule__Bot__Group_10__2 : rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 ;
    public final void rule__Bot__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2379:1: ( rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3 )
            // InternalBot.g:2380:2: rule__Bot__Group_10__2__Impl rule__Bot__Group_10__3
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
    // InternalBot.g:2387:1: rule__Bot__Group_10__2__Impl : ( ( rule__Bot__EntitiesAssignment_10_2 ) ) ;
    public final void rule__Bot__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2391:1: ( ( ( rule__Bot__EntitiesAssignment_10_2 ) ) )
            // InternalBot.g:2392:1: ( ( rule__Bot__EntitiesAssignment_10_2 ) )
            {
            // InternalBot.g:2392:1: ( ( rule__Bot__EntitiesAssignment_10_2 ) )
            // InternalBot.g:2393:2: ( rule__Bot__EntitiesAssignment_10_2 )
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_10_2()); 
            // InternalBot.g:2394:2: ( rule__Bot__EntitiesAssignment_10_2 )
            // InternalBot.g:2394:3: rule__Bot__EntitiesAssignment_10_2
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
    // InternalBot.g:2402:1: rule__Bot__Group_10__3 : rule__Bot__Group_10__3__Impl ;
    public final void rule__Bot__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2406:1: ( rule__Bot__Group_10__3__Impl )
            // InternalBot.g:2407:2: rule__Bot__Group_10__3__Impl
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
    // InternalBot.g:2413:1: rule__Bot__Group_10__3__Impl : ( ( rule__Bot__EntitiesAssignment_10_3 )* ) ;
    public final void rule__Bot__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2417:1: ( ( ( rule__Bot__EntitiesAssignment_10_3 )* ) )
            // InternalBot.g:2418:1: ( ( rule__Bot__EntitiesAssignment_10_3 )* )
            {
            // InternalBot.g:2418:1: ( ( rule__Bot__EntitiesAssignment_10_3 )* )
            // InternalBot.g:2419:2: ( rule__Bot__EntitiesAssignment_10_3 )*
            {
             before(grammarAccess.getBotAccess().getEntitiesAssignment_10_3()); 
            // InternalBot.g:2420:2: ( rule__Bot__EntitiesAssignment_10_3 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=79 && LA27_0<=81)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBot.g:2420:3: rule__Bot__EntitiesAssignment_10_3
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Bot__EntitiesAssignment_10_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalBot.g:2429:1: rule__Bot__Group_11__0 : rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1 ;
    public final void rule__Bot__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2433:1: ( rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1 )
            // InternalBot.g:2434:2: rule__Bot__Group_11__0__Impl rule__Bot__Group_11__1
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
    // InternalBot.g:2441:1: rule__Bot__Group_11__0__Impl : ( 'actions' ) ;
    public final void rule__Bot__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2445:1: ( ( 'actions' ) )
            // InternalBot.g:2446:1: ( 'actions' )
            {
            // InternalBot.g:2446:1: ( 'actions' )
            // InternalBot.g:2447:2: 'actions'
            {
             before(grammarAccess.getBotAccess().getActionsKeyword_11_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalBot.g:2456:1: rule__Bot__Group_11__1 : rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2 ;
    public final void rule__Bot__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2460:1: ( rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2 )
            // InternalBot.g:2461:2: rule__Bot__Group_11__1__Impl rule__Bot__Group_11__2
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
    // InternalBot.g:2468:1: rule__Bot__Group_11__1__Impl : ( ':' ) ;
    public final void rule__Bot__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2472:1: ( ( ':' ) )
            // InternalBot.g:2473:1: ( ':' )
            {
            // InternalBot.g:2473:1: ( ':' )
            // InternalBot.g:2474:2: ':'
            {
             before(grammarAccess.getBotAccess().getColonKeyword_11_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:2483:1: rule__Bot__Group_11__2 : rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3 ;
    public final void rule__Bot__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2487:1: ( rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3 )
            // InternalBot.g:2488:2: rule__Bot__Group_11__2__Impl rule__Bot__Group_11__3
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
    // InternalBot.g:2495:1: rule__Bot__Group_11__2__Impl : ( ( rule__Bot__ActionsAssignment_11_2 ) ) ;
    public final void rule__Bot__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2499:1: ( ( ( rule__Bot__ActionsAssignment_11_2 ) ) )
            // InternalBot.g:2500:1: ( ( rule__Bot__ActionsAssignment_11_2 ) )
            {
            // InternalBot.g:2500:1: ( ( rule__Bot__ActionsAssignment_11_2 ) )
            // InternalBot.g:2501:2: ( rule__Bot__ActionsAssignment_11_2 )
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_11_2()); 
            // InternalBot.g:2502:2: ( rule__Bot__ActionsAssignment_11_2 )
            // InternalBot.g:2502:3: rule__Bot__ActionsAssignment_11_2
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
    // InternalBot.g:2510:1: rule__Bot__Group_11__3 : rule__Bot__Group_11__3__Impl ;
    public final void rule__Bot__Group_11__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2514:1: ( rule__Bot__Group_11__3__Impl )
            // InternalBot.g:2515:2: rule__Bot__Group_11__3__Impl
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
    // InternalBot.g:2521:1: rule__Bot__Group_11__3__Impl : ( ( rule__Bot__ActionsAssignment_11_3 )* ) ;
    public final void rule__Bot__Group_11__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2525:1: ( ( ( rule__Bot__ActionsAssignment_11_3 )* ) )
            // InternalBot.g:2526:1: ( ( rule__Bot__ActionsAssignment_11_3 )* )
            {
            // InternalBot.g:2526:1: ( ( rule__Bot__ActionsAssignment_11_3 )* )
            // InternalBot.g:2527:2: ( rule__Bot__ActionsAssignment_11_3 )*
            {
             before(grammarAccess.getBotAccess().getActionsAssignment_11_3()); 
            // InternalBot.g:2528:2: ( rule__Bot__ActionsAssignment_11_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=11 && LA28_0<=14)||(LA28_0>=86 && LA28_0<=87)||(LA28_0>=93 && LA28_0<=94)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalBot.g:2528:3: rule__Bot__ActionsAssignment_11_3
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__Bot__ActionsAssignment_11_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalBot.g:2537:1: rule__Bot__Group_14__0 : rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1 ;
    public final void rule__Bot__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2541:1: ( rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1 )
            // InternalBot.g:2542:2: rule__Bot__Group_14__0__Impl rule__Bot__Group_14__1
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
    // InternalBot.g:2549:1: rule__Bot__Group_14__0__Impl : ( '-' ) ;
    public final void rule__Bot__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2553:1: ( ( '-' ) )
            // InternalBot.g:2554:1: ( '-' )
            {
            // InternalBot.g:2554:1: ( '-' )
            // InternalBot.g:2555:2: '-'
            {
             before(grammarAccess.getBotAccess().getHyphenMinusKeyword_14_0()); 
            match(input,60,FOLLOW_2); 
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
    // InternalBot.g:2564:1: rule__Bot__Group_14__1 : rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2 ;
    public final void rule__Bot__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2568:1: ( rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2 )
            // InternalBot.g:2569:2: rule__Bot__Group_14__1__Impl rule__Bot__Group_14__2
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
    // InternalBot.g:2576:1: rule__Bot__Group_14__1__Impl : ( ( rule__Bot__FlowsAssignment_14_1 ) ) ;
    public final void rule__Bot__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2580:1: ( ( ( rule__Bot__FlowsAssignment_14_1 ) ) )
            // InternalBot.g:2581:1: ( ( rule__Bot__FlowsAssignment_14_1 ) )
            {
            // InternalBot.g:2581:1: ( ( rule__Bot__FlowsAssignment_14_1 ) )
            // InternalBot.g:2582:2: ( rule__Bot__FlowsAssignment_14_1 )
            {
             before(grammarAccess.getBotAccess().getFlowsAssignment_14_1()); 
            // InternalBot.g:2583:2: ( rule__Bot__FlowsAssignment_14_1 )
            // InternalBot.g:2583:3: rule__Bot__FlowsAssignment_14_1
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
    // InternalBot.g:2591:1: rule__Bot__Group_14__2 : rule__Bot__Group_14__2__Impl ;
    public final void rule__Bot__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2595:1: ( rule__Bot__Group_14__2__Impl )
            // InternalBot.g:2596:2: rule__Bot__Group_14__2__Impl
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
    // InternalBot.g:2602:1: rule__Bot__Group_14__2__Impl : ( ';' ) ;
    public final void rule__Bot__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2606:1: ( ( ';' ) )
            // InternalBot.g:2607:1: ( ';' )
            {
            // InternalBot.g:2607:1: ( ';' )
            // InternalBot.g:2608:2: ';'
            {
             before(grammarAccess.getBotAccess().getSemicolonKeyword_14_2()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:2618:1: rule__Intent2__Group__0 : rule__Intent2__Group__0__Impl rule__Intent2__Group__1 ;
    public final void rule__Intent2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2622:1: ( rule__Intent2__Group__0__Impl rule__Intent2__Group__1 )
            // InternalBot.g:2623:2: rule__Intent2__Group__0__Impl rule__Intent2__Group__1
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
    // InternalBot.g:2630:1: rule__Intent2__Group__0__Impl : ( ( rule__Intent2__NameAssignment_0 ) ) ;
    public final void rule__Intent2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2634:1: ( ( ( rule__Intent2__NameAssignment_0 ) ) )
            // InternalBot.g:2635:1: ( ( rule__Intent2__NameAssignment_0 ) )
            {
            // InternalBot.g:2635:1: ( ( rule__Intent2__NameAssignment_0 ) )
            // InternalBot.g:2636:2: ( rule__Intent2__NameAssignment_0 )
            {
             before(grammarAccess.getIntent2Access().getNameAssignment_0()); 
            // InternalBot.g:2637:2: ( rule__Intent2__NameAssignment_0 )
            // InternalBot.g:2637:3: rule__Intent2__NameAssignment_0
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
    // InternalBot.g:2645:1: rule__Intent2__Group__1 : rule__Intent2__Group__1__Impl rule__Intent2__Group__2 ;
    public final void rule__Intent2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2649:1: ( rule__Intent2__Group__1__Impl rule__Intent2__Group__2 )
            // InternalBot.g:2650:2: rule__Intent2__Group__1__Impl rule__Intent2__Group__2
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
    // InternalBot.g:2657:1: rule__Intent2__Group__1__Impl : ( ( rule__Intent2__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2661:1: ( ( ( rule__Intent2__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2662:1: ( ( rule__Intent2__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2662:1: ( ( rule__Intent2__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2663:2: ( rule__Intent2__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2664:2: ( rule__Intent2__FallbackIntentAssignment_1 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==99) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:2664:3: rule__Intent2__FallbackIntentAssignment_1
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
    // InternalBot.g:2672:1: rule__Intent2__Group__2 : rule__Intent2__Group__2__Impl rule__Intent2__Group__3 ;
    public final void rule__Intent2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2676:1: ( rule__Intent2__Group__2__Impl rule__Intent2__Group__3 )
            // InternalBot.g:2677:2: rule__Intent2__Group__2__Impl rule__Intent2__Group__3
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
    // InternalBot.g:2684:1: rule__Intent2__Group__2__Impl : ( ':' ) ;
    public final void rule__Intent2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2688:1: ( ( ':' ) )
            // InternalBot.g:2689:1: ( ':' )
            {
            // InternalBot.g:2689:1: ( ':' )
            // InternalBot.g:2690:2: ':'
            {
             before(grammarAccess.getIntent2Access().getColonKeyword_2()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:2699:1: rule__Intent2__Group__3 : rule__Intent2__Group__3__Impl rule__Intent2__Group__4 ;
    public final void rule__Intent2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2703:1: ( rule__Intent2__Group__3__Impl rule__Intent2__Group__4 )
            // InternalBot.g:2704:2: rule__Intent2__Group__3__Impl rule__Intent2__Group__4
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
    // InternalBot.g:2711:1: rule__Intent2__Group__3__Impl : ( ( rule__Intent2__InputsAssignment_3 )* ) ;
    public final void rule__Intent2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2715:1: ( ( ( rule__Intent2__InputsAssignment_3 )* ) )
            // InternalBot.g:2716:1: ( ( rule__Intent2__InputsAssignment_3 )* )
            {
            // InternalBot.g:2716:1: ( ( rule__Intent2__InputsAssignment_3 )* )
            // InternalBot.g:2717:2: ( rule__Intent2__InputsAssignment_3 )*
            {
             before(grammarAccess.getIntent2Access().getInputsAssignment_3()); 
            // InternalBot.g:2718:2: ( rule__Intent2__InputsAssignment_3 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==63) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalBot.g:2718:3: rule__Intent2__InputsAssignment_3
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__Intent2__InputsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalBot.g:2726:1: rule__Intent2__Group__4 : rule__Intent2__Group__4__Impl ;
    public final void rule__Intent2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2730:1: ( rule__Intent2__Group__4__Impl )
            // InternalBot.g:2731:2: rule__Intent2__Group__4__Impl
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
    // InternalBot.g:2737:1: rule__Intent2__Group__4__Impl : ( ( rule__Intent2__Group_4__0 )? ) ;
    public final void rule__Intent2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2741:1: ( ( ( rule__Intent2__Group_4__0 )? ) )
            // InternalBot.g:2742:1: ( ( rule__Intent2__Group_4__0 )? )
            {
            // InternalBot.g:2742:1: ( ( rule__Intent2__Group_4__0 )? )
            // InternalBot.g:2743:2: ( rule__Intent2__Group_4__0 )?
            {
             before(grammarAccess.getIntent2Access().getGroup_4()); 
            // InternalBot.g:2744:2: ( rule__Intent2__Group_4__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==62) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:2744:3: rule__Intent2__Group_4__0
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
    // InternalBot.g:2753:1: rule__Intent2__Group_4__0 : rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1 ;
    public final void rule__Intent2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2757:1: ( rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1 )
            // InternalBot.g:2758:2: rule__Intent2__Group_4__0__Impl rule__Intent2__Group_4__1
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
    // InternalBot.g:2765:1: rule__Intent2__Group_4__0__Impl : ( 'parameters' ) ;
    public final void rule__Intent2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2769:1: ( ( 'parameters' ) )
            // InternalBot.g:2770:1: ( 'parameters' )
            {
            // InternalBot.g:2770:1: ( 'parameters' )
            // InternalBot.g:2771:2: 'parameters'
            {
             before(grammarAccess.getIntent2Access().getParametersKeyword_4_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalBot.g:2780:1: rule__Intent2__Group_4__1 : rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2 ;
    public final void rule__Intent2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2784:1: ( rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2 )
            // InternalBot.g:2785:2: rule__Intent2__Group_4__1__Impl rule__Intent2__Group_4__2
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
    // InternalBot.g:2792:1: rule__Intent2__Group_4__1__Impl : ( ':' ) ;
    public final void rule__Intent2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2796:1: ( ( ':' ) )
            // InternalBot.g:2797:1: ( ':' )
            {
            // InternalBot.g:2797:1: ( ':' )
            // InternalBot.g:2798:2: ':'
            {
             before(grammarAccess.getIntent2Access().getColonKeyword_4_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:2807:1: rule__Intent2__Group_4__2 : rule__Intent2__Group_4__2__Impl ;
    public final void rule__Intent2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2811:1: ( rule__Intent2__Group_4__2__Impl )
            // InternalBot.g:2812:2: rule__Intent2__Group_4__2__Impl
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
    // InternalBot.g:2818:1: rule__Intent2__Group_4__2__Impl : ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) ) ;
    public final void rule__Intent2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2822:1: ( ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) ) )
            // InternalBot.g:2823:1: ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) )
            {
            // InternalBot.g:2823:1: ( ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* ) )
            // InternalBot.g:2824:2: ( ( rule__Intent2__Group_4_2__0 ) ) ( ( rule__Intent2__Group_4_2__0 )* )
            {
            // InternalBot.g:2824:2: ( ( rule__Intent2__Group_4_2__0 ) )
            // InternalBot.g:2825:3: ( rule__Intent2__Group_4_2__0 )
            {
             before(grammarAccess.getIntent2Access().getGroup_4_2()); 
            // InternalBot.g:2826:3: ( rule__Intent2__Group_4_2__0 )
            // InternalBot.g:2826:4: rule__Intent2__Group_4_2__0
            {
            pushFollow(FOLLOW_12);
            rule__Intent2__Group_4_2__0();

            state._fsp--;


            }

             after(grammarAccess.getIntent2Access().getGroup_4_2()); 

            }

            // InternalBot.g:2829:2: ( ( rule__Intent2__Group_4_2__0 )* )
            // InternalBot.g:2830:3: ( rule__Intent2__Group_4_2__0 )*
            {
             before(grammarAccess.getIntent2Access().getGroup_4_2()); 
            // InternalBot.g:2831:3: ( rule__Intent2__Group_4_2__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_STRING) ) {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==54) ) {
                        int LA32_4 = input.LA(3);

                        if ( (LA32_4==70) ) {
                            alt32=1;
                        }


                    }
                    else if ( (LA32_2==57) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==RULE_ID) ) {
                    int LA32_3 = input.LA(2);

                    if ( (LA32_3==54) ) {
                        int LA32_4 = input.LA(3);

                        if ( (LA32_4==70) ) {
                            alt32=1;
                        }


                    }
                    else if ( (LA32_3==57) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // InternalBot.g:2831:4: rule__Intent2__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent2__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalBot.g:2841:1: rule__Intent2__Group_4_2__0 : rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1 ;
    public final void rule__Intent2__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2845:1: ( rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1 )
            // InternalBot.g:2846:2: rule__Intent2__Group_4_2__0__Impl rule__Intent2__Group_4_2__1
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
    // InternalBot.g:2853:1: rule__Intent2__Group_4_2__0__Impl : ( ( rule__Intent2__ParametersAssignment_4_2_0 )* ) ;
    public final void rule__Intent2__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2857:1: ( ( ( rule__Intent2__ParametersAssignment_4_2_0 )* ) )
            // InternalBot.g:2858:1: ( ( rule__Intent2__ParametersAssignment_4_2_0 )* )
            {
            // InternalBot.g:2858:1: ( ( rule__Intent2__ParametersAssignment_4_2_0 )* )
            // InternalBot.g:2859:2: ( rule__Intent2__ParametersAssignment_4_2_0 )*
            {
             before(grammarAccess.getIntent2Access().getParametersAssignment_4_2_0()); 
            // InternalBot.g:2860:2: ( rule__Intent2__ParametersAssignment_4_2_0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_STRING) ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1==57) ) {
                        alt33=1;
                    }


                }
                else if ( (LA33_0==RULE_ID) ) {
                    int LA33_2 = input.LA(2);

                    if ( (LA33_2==57) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // InternalBot.g:2860:3: rule__Intent2__ParametersAssignment_4_2_0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Intent2__ParametersAssignment_4_2_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalBot.g:2868:1: rule__Intent2__Group_4_2__1 : rule__Intent2__Group_4_2__1__Impl ;
    public final void rule__Intent2__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2872:1: ( rule__Intent2__Group_4_2__1__Impl )
            // InternalBot.g:2873:2: rule__Intent2__Group_4_2__1__Impl
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
    // InternalBot.g:2879:1: rule__Intent2__Group_4_2__1__Impl : ( ( rule__Intent2__ParametersAssignment_4_2_1 ) ) ;
    public final void rule__Intent2__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2883:1: ( ( ( rule__Intent2__ParametersAssignment_4_2_1 ) ) )
            // InternalBot.g:2884:1: ( ( rule__Intent2__ParametersAssignment_4_2_1 ) )
            {
            // InternalBot.g:2884:1: ( ( rule__Intent2__ParametersAssignment_4_2_1 ) )
            // InternalBot.g:2885:2: ( rule__Intent2__ParametersAssignment_4_2_1 )
            {
             before(grammarAccess.getIntent2Access().getParametersAssignment_4_2_1()); 
            // InternalBot.g:2886:2: ( rule__Intent2__ParametersAssignment_4_2_1 )
            // InternalBot.g:2886:3: rule__Intent2__ParametersAssignment_4_2_1
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
    // InternalBot.g:2895:1: rule__Intent1__Group__0 : rule__Intent1__Group__0__Impl rule__Intent1__Group__1 ;
    public final void rule__Intent1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2899:1: ( rule__Intent1__Group__0__Impl rule__Intent1__Group__1 )
            // InternalBot.g:2900:2: rule__Intent1__Group__0__Impl rule__Intent1__Group__1
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
    // InternalBot.g:2907:1: rule__Intent1__Group__0__Impl : ( ( rule__Intent1__NameAssignment_0 ) ) ;
    public final void rule__Intent1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2911:1: ( ( ( rule__Intent1__NameAssignment_0 ) ) )
            // InternalBot.g:2912:1: ( ( rule__Intent1__NameAssignment_0 ) )
            {
            // InternalBot.g:2912:1: ( ( rule__Intent1__NameAssignment_0 ) )
            // InternalBot.g:2913:2: ( rule__Intent1__NameAssignment_0 )
            {
             before(grammarAccess.getIntent1Access().getNameAssignment_0()); 
            // InternalBot.g:2914:2: ( rule__Intent1__NameAssignment_0 )
            // InternalBot.g:2914:3: rule__Intent1__NameAssignment_0
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
    // InternalBot.g:2922:1: rule__Intent1__Group__1 : rule__Intent1__Group__1__Impl ;
    public final void rule__Intent1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2926:1: ( rule__Intent1__Group__1__Impl )
            // InternalBot.g:2927:2: rule__Intent1__Group__1__Impl
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
    // InternalBot.g:2933:1: rule__Intent1__Group__1__Impl : ( ( rule__Intent1__FallbackIntentAssignment_1 )? ) ;
    public final void rule__Intent1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2937:1: ( ( ( rule__Intent1__FallbackIntentAssignment_1 )? ) )
            // InternalBot.g:2938:1: ( ( rule__Intent1__FallbackIntentAssignment_1 )? )
            {
            // InternalBot.g:2938:1: ( ( rule__Intent1__FallbackIntentAssignment_1 )? )
            // InternalBot.g:2939:2: ( rule__Intent1__FallbackIntentAssignment_1 )?
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentAssignment_1()); 
            // InternalBot.g:2940:2: ( rule__Intent1__FallbackIntentAssignment_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==99) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalBot.g:2940:3: rule__Intent1__FallbackIntentAssignment_1
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
    // InternalBot.g:2949:1: rule__IntentLanguageInputs__Group__0 : rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 ;
    public final void rule__IntentLanguageInputs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2953:1: ( rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1 )
            // InternalBot.g:2954:2: rule__IntentLanguageInputs__Group__0__Impl rule__IntentLanguageInputs__Group__1
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
    // InternalBot.g:2961:1: rule__IntentLanguageInputs__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__IntentLanguageInputs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2965:1: ( ( 'inputs' ) )
            // InternalBot.g:2966:1: ( 'inputs' )
            {
            // InternalBot.g:2966:1: ( 'inputs' )
            // InternalBot.g:2967:2: 'inputs'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBot.g:2976:1: rule__IntentLanguageInputs__Group__1 : rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 ;
    public final void rule__IntentLanguageInputs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2980:1: ( rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2 )
            // InternalBot.g:2981:2: rule__IntentLanguageInputs__Group__1__Impl rule__IntentLanguageInputs__Group__2
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
    // InternalBot.g:2988:1: rule__IntentLanguageInputs__Group__1__Impl : ( ( rule__IntentLanguageInputs__Group_1__0 )? ) ;
    public final void rule__IntentLanguageInputs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:2992:1: ( ( ( rule__IntentLanguageInputs__Group_1__0 )? ) )
            // InternalBot.g:2993:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            {
            // InternalBot.g:2993:1: ( ( rule__IntentLanguageInputs__Group_1__0 )? )
            // InternalBot.g:2994:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_1()); 
            // InternalBot.g:2995:2: ( rule__IntentLanguageInputs__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==66) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:2995:3: rule__IntentLanguageInputs__Group_1__0
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
    // InternalBot.g:3003:1: rule__IntentLanguageInputs__Group__2 : rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 ;
    public final void rule__IntentLanguageInputs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3007:1: ( rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3 )
            // InternalBot.g:3008:2: rule__IntentLanguageInputs__Group__2__Impl rule__IntentLanguageInputs__Group__3
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
    // InternalBot.g:3015:1: rule__IntentLanguageInputs__Group__2__Impl : ( '{' ) ;
    public final void rule__IntentLanguageInputs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3019:1: ( ( '{' ) )
            // InternalBot.g:3020:1: ( '{' )
            {
            // InternalBot.g:3020:1: ( '{' )
            // InternalBot.g:3021:2: '{'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:3030:1: rule__IntentLanguageInputs__Group__3 : rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 ;
    public final void rule__IntentLanguageInputs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3034:1: ( rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4 )
            // InternalBot.g:3035:2: rule__IntentLanguageInputs__Group__3__Impl rule__IntentLanguageInputs__Group__4
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
    // InternalBot.g:3042:1: rule__IntentLanguageInputs__Group__3__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) ;
    public final void rule__IntentLanguageInputs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3046:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) ) )
            // InternalBot.g:3047:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            {
            // InternalBot.g:3047:1: ( ( rule__IntentLanguageInputs__InputsAssignment_3 ) )
            // InternalBot.g:3048:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_3()); 
            // InternalBot.g:3049:2: ( rule__IntentLanguageInputs__InputsAssignment_3 )
            // InternalBot.g:3049:3: rule__IntentLanguageInputs__InputsAssignment_3
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
    // InternalBot.g:3057:1: rule__IntentLanguageInputs__Group__4 : rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 ;
    public final void rule__IntentLanguageInputs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3061:1: ( rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5 )
            // InternalBot.g:3062:2: rule__IntentLanguageInputs__Group__4__Impl rule__IntentLanguageInputs__Group__5
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
    // InternalBot.g:3069:1: rule__IntentLanguageInputs__Group__4__Impl : ( ( rule__IntentLanguageInputs__Group_4__0 )* ) ;
    public final void rule__IntentLanguageInputs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3073:1: ( ( ( rule__IntentLanguageInputs__Group_4__0 )* ) )
            // InternalBot.g:3074:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            {
            // InternalBot.g:3074:1: ( ( rule__IntentLanguageInputs__Group_4__0 )* )
            // InternalBot.g:3075:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getGroup_4()); 
            // InternalBot.g:3076:2: ( rule__IntentLanguageInputs__Group_4__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==57) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:3076:3: rule__IntentLanguageInputs__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__IntentLanguageInputs__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalBot.g:3084:1: rule__IntentLanguageInputs__Group__5 : rule__IntentLanguageInputs__Group__5__Impl ;
    public final void rule__IntentLanguageInputs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3088:1: ( rule__IntentLanguageInputs__Group__5__Impl )
            // InternalBot.g:3089:2: rule__IntentLanguageInputs__Group__5__Impl
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
    // InternalBot.g:3095:1: rule__IntentLanguageInputs__Group__5__Impl : ( '}' ) ;
    public final void rule__IntentLanguageInputs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3099:1: ( ( '}' ) )
            // InternalBot.g:3100:1: ( '}' )
            {
            // InternalBot.g:3100:1: ( '}' )
            // InternalBot.g:3101:2: '}'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:3111:1: rule__IntentLanguageInputs__Group_1__0 : rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 ;
    public final void rule__IntentLanguageInputs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3115:1: ( rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1 )
            // InternalBot.g:3116:2: rule__IntentLanguageInputs__Group_1__0__Impl rule__IntentLanguageInputs__Group_1__1
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
    // InternalBot.g:3123:1: rule__IntentLanguageInputs__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__IntentLanguageInputs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3127:1: ( ( 'in' ) )
            // InternalBot.g:3128:1: ( 'in' )
            {
            // InternalBot.g:3128:1: ( 'in' )
            // InternalBot.g:3129:2: 'in'
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:3138:1: rule__IntentLanguageInputs__Group_1__1 : rule__IntentLanguageInputs__Group_1__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3142:1: ( rule__IntentLanguageInputs__Group_1__1__Impl )
            // InternalBot.g:3143:2: rule__IntentLanguageInputs__Group_1__1__Impl
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
    // InternalBot.g:3149:1: rule__IntentLanguageInputs__Group_1__1__Impl : ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3153:1: ( ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:3154:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:3154:1: ( ( rule__IntentLanguageInputs__LanguageAssignment_1_1 ) )
            // InternalBot.g:3155:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:3156:2: ( rule__IntentLanguageInputs__LanguageAssignment_1_1 )
            // InternalBot.g:3156:3: rule__IntentLanguageInputs__LanguageAssignment_1_1
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
    // InternalBot.g:3165:1: rule__IntentLanguageInputs__Group_4__0 : rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 ;
    public final void rule__IntentLanguageInputs__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3169:1: ( rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1 )
            // InternalBot.g:3170:2: rule__IntentLanguageInputs__Group_4__0__Impl rule__IntentLanguageInputs__Group_4__1
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
    // InternalBot.g:3177:1: rule__IntentLanguageInputs__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IntentLanguageInputs__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3181:1: ( ( ',' ) )
            // InternalBot.g:3182:1: ( ',' )
            {
            // InternalBot.g:3182:1: ( ',' )
            // InternalBot.g:3183:2: ','
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:3192:1: rule__IntentLanguageInputs__Group_4__1 : rule__IntentLanguageInputs__Group_4__1__Impl ;
    public final void rule__IntentLanguageInputs__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3196:1: ( rule__IntentLanguageInputs__Group_4__1__Impl )
            // InternalBot.g:3197:2: rule__IntentLanguageInputs__Group_4__1__Impl
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
    // InternalBot.g:3203:1: rule__IntentLanguageInputs__Group_4__1__Impl : ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) ;
    public final void rule__IntentLanguageInputs__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3207:1: ( ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) ) )
            // InternalBot.g:3208:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:3208:1: ( ( rule__IntentLanguageInputs__InputsAssignment_4_1 ) )
            // InternalBot.g:3209:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            {
             before(grammarAccess.getIntentLanguageInputsAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:3210:2: ( rule__IntentLanguageInputs__InputsAssignment_4_1 )
            // InternalBot.g:3210:3: rule__IntentLanguageInputs__InputsAssignment_4_1
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
    // InternalBot.g:3219:1: rule__Transition__Group__0 : rule__Transition__Group__0__Impl rule__Transition__Group__1 ;
    public final void rule__Transition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3223:1: ( rule__Transition__Group__0__Impl rule__Transition__Group__1 )
            // InternalBot.g:3224:2: rule__Transition__Group__0__Impl rule__Transition__Group__1
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
    // InternalBot.g:3231:1: rule__Transition__Group__0__Impl : ( 'user' ) ;
    public final void rule__Transition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3235:1: ( ( 'user' ) )
            // InternalBot.g:3236:1: ( 'user' )
            {
            // InternalBot.g:3236:1: ( 'user' )
            // InternalBot.g:3237:2: 'user'
            {
             before(grammarAccess.getTransitionAccess().getUserKeyword_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalBot.g:3246:1: rule__Transition__Group__1 : rule__Transition__Group__1__Impl rule__Transition__Group__2 ;
    public final void rule__Transition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3250:1: ( rule__Transition__Group__1__Impl rule__Transition__Group__2 )
            // InternalBot.g:3251:2: rule__Transition__Group__1__Impl rule__Transition__Group__2
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
    // InternalBot.g:3258:1: rule__Transition__Group__1__Impl : ( ( rule__Transition__IntentAssignment_1 ) ) ;
    public final void rule__Transition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3262:1: ( ( ( rule__Transition__IntentAssignment_1 ) ) )
            // InternalBot.g:3263:1: ( ( rule__Transition__IntentAssignment_1 ) )
            {
            // InternalBot.g:3263:1: ( ( rule__Transition__IntentAssignment_1 ) )
            // InternalBot.g:3264:2: ( rule__Transition__IntentAssignment_1 )
            {
             before(grammarAccess.getTransitionAccess().getIntentAssignment_1()); 
            // InternalBot.g:3265:2: ( rule__Transition__IntentAssignment_1 )
            // InternalBot.g:3265:3: rule__Transition__IntentAssignment_1
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
    // InternalBot.g:3273:1: rule__Transition__Group__2 : rule__Transition__Group__2__Impl ;
    public final void rule__Transition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3277:1: ( rule__Transition__Group__2__Impl )
            // InternalBot.g:3278:2: rule__Transition__Group__2__Impl
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
    // InternalBot.g:3284:1: rule__Transition__Group__2__Impl : ( ( rule__Transition__Group_2__0 )? ) ;
    public final void rule__Transition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3288:1: ( ( ( rule__Transition__Group_2__0 )? ) )
            // InternalBot.g:3289:1: ( ( rule__Transition__Group_2__0 )? )
            {
            // InternalBot.g:3289:1: ( ( rule__Transition__Group_2__0 )? )
            // InternalBot.g:3290:2: ( rule__Transition__Group_2__0 )?
            {
             before(grammarAccess.getTransitionAccess().getGroup_2()); 
            // InternalBot.g:3291:2: ( rule__Transition__Group_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==68) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:3291:3: rule__Transition__Group_2__0
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
    // InternalBot.g:3300:1: rule__Transition__Group_2__0 : rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 ;
    public final void rule__Transition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3304:1: ( rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1 )
            // InternalBot.g:3305:2: rule__Transition__Group_2__0__Impl rule__Transition__Group_2__1
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
    // InternalBot.g:3312:1: rule__Transition__Group_2__0__Impl : ( '=>' ) ;
    public final void rule__Transition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3316:1: ( ( '=>' ) )
            // InternalBot.g:3317:1: ( '=>' )
            {
            // InternalBot.g:3317:1: ( '=>' )
            // InternalBot.g:3318:2: '=>'
            {
             before(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBot.g:3327:1: rule__Transition__Group_2__1 : rule__Transition__Group_2__1__Impl ;
    public final void rule__Transition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3331:1: ( rule__Transition__Group_2__1__Impl )
            // InternalBot.g:3332:2: rule__Transition__Group_2__1__Impl
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
    // InternalBot.g:3338:1: rule__Transition__Group_2__1__Impl : ( ( rule__Transition__TargetAssignment_2_1 ) ) ;
    public final void rule__Transition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3342:1: ( ( ( rule__Transition__TargetAssignment_2_1 ) ) )
            // InternalBot.g:3343:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            {
            // InternalBot.g:3343:1: ( ( rule__Transition__TargetAssignment_2_1 ) )
            // InternalBot.g:3344:2: ( rule__Transition__TargetAssignment_2_1 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAssignment_2_1()); 
            // InternalBot.g:3345:2: ( rule__Transition__TargetAssignment_2_1 )
            // InternalBot.g:3345:3: rule__Transition__TargetAssignment_2_1
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
    // InternalBot.g:3354:1: rule__State__Group__0 : rule__State__Group__0__Impl rule__State__Group__1 ;
    public final void rule__State__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3358:1: ( rule__State__Group__0__Impl rule__State__Group__1 )
            // InternalBot.g:3359:2: rule__State__Group__0__Impl rule__State__Group__1
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
    // InternalBot.g:3366:1: rule__State__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3370:1: ( ( 'chatbot' ) )
            // InternalBot.g:3371:1: ( 'chatbot' )
            {
            // InternalBot.g:3371:1: ( 'chatbot' )
            // InternalBot.g:3372:2: 'chatbot'
            {
             before(grammarAccess.getStateAccess().getChatbotKeyword_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalBot.g:3381:1: rule__State__Group__1 : rule__State__Group__1__Impl rule__State__Group__2 ;
    public final void rule__State__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3385:1: ( rule__State__Group__1__Impl rule__State__Group__2 )
            // InternalBot.g:3386:2: rule__State__Group__1__Impl rule__State__Group__2
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
    // InternalBot.g:3393:1: rule__State__Group__1__Impl : ( ( rule__State__ActionsAssignment_1 ) ) ;
    public final void rule__State__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3397:1: ( ( ( rule__State__ActionsAssignment_1 ) ) )
            // InternalBot.g:3398:1: ( ( rule__State__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3398:1: ( ( rule__State__ActionsAssignment_1 ) )
            // InternalBot.g:3399:2: ( rule__State__ActionsAssignment_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_1()); 
            // InternalBot.g:3400:2: ( rule__State__ActionsAssignment_1 )
            // InternalBot.g:3400:3: rule__State__ActionsAssignment_1
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
    // InternalBot.g:3408:1: rule__State__Group__2 : rule__State__Group__2__Impl rule__State__Group__3 ;
    public final void rule__State__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3412:1: ( rule__State__Group__2__Impl rule__State__Group__3 )
            // InternalBot.g:3413:2: rule__State__Group__2__Impl rule__State__Group__3
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
    // InternalBot.g:3420:1: rule__State__Group__2__Impl : ( ( rule__State__Group_2__0 )* ) ;
    public final void rule__State__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3424:1: ( ( ( rule__State__Group_2__0 )* ) )
            // InternalBot.g:3425:1: ( ( rule__State__Group_2__0 )* )
            {
            // InternalBot.g:3425:1: ( ( rule__State__Group_2__0 )* )
            // InternalBot.g:3426:2: ( rule__State__Group_2__0 )*
            {
             before(grammarAccess.getStateAccess().getGroup_2()); 
            // InternalBot.g:3427:2: ( rule__State__Group_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==57) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBot.g:3427:3: rule__State__Group_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__State__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalBot.g:3435:1: rule__State__Group__3 : rule__State__Group__3__Impl ;
    public final void rule__State__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3439:1: ( rule__State__Group__3__Impl )
            // InternalBot.g:3440:2: rule__State__Group__3__Impl
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
    // InternalBot.g:3446:1: rule__State__Group__3__Impl : ( ( rule__State__Group_3__0 )? ) ;
    public final void rule__State__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3450:1: ( ( ( rule__State__Group_3__0 )? ) )
            // InternalBot.g:3451:1: ( ( rule__State__Group_3__0 )? )
            {
            // InternalBot.g:3451:1: ( ( rule__State__Group_3__0 )? )
            // InternalBot.g:3452:2: ( rule__State__Group_3__0 )?
            {
             before(grammarAccess.getStateAccess().getGroup_3()); 
            // InternalBot.g:3453:2: ( rule__State__Group_3__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==68) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:3453:3: rule__State__Group_3__0
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
    // InternalBot.g:3462:1: rule__State__Group_2__0 : rule__State__Group_2__0__Impl rule__State__Group_2__1 ;
    public final void rule__State__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3466:1: ( rule__State__Group_2__0__Impl rule__State__Group_2__1 )
            // InternalBot.g:3467:2: rule__State__Group_2__0__Impl rule__State__Group_2__1
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
    // InternalBot.g:3474:1: rule__State__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3478:1: ( ( ',' ) )
            // InternalBot.g:3479:1: ( ',' )
            {
            // InternalBot.g:3479:1: ( ',' )
            // InternalBot.g:3480:2: ','
            {
             before(grammarAccess.getStateAccess().getCommaKeyword_2_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:3489:1: rule__State__Group_2__1 : rule__State__Group_2__1__Impl ;
    public final void rule__State__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3493:1: ( rule__State__Group_2__1__Impl )
            // InternalBot.g:3494:2: rule__State__Group_2__1__Impl
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
    // InternalBot.g:3500:1: rule__State__Group_2__1__Impl : ( ( rule__State__ActionsAssignment_2_1 ) ) ;
    public final void rule__State__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3504:1: ( ( ( rule__State__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3505:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3505:1: ( ( rule__State__ActionsAssignment_2_1 ) )
            // InternalBot.g:3506:2: ( rule__State__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getStateAccess().getActionsAssignment_2_1()); 
            // InternalBot.g:3507:2: ( rule__State__ActionsAssignment_2_1 )
            // InternalBot.g:3507:3: rule__State__ActionsAssignment_2_1
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
    // InternalBot.g:3516:1: rule__State__Group_3__0 : rule__State__Group_3__0__Impl rule__State__Group_3__1 ;
    public final void rule__State__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3520:1: ( rule__State__Group_3__0__Impl rule__State__Group_3__1 )
            // InternalBot.g:3521:2: rule__State__Group_3__0__Impl rule__State__Group_3__1
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
    // InternalBot.g:3528:1: rule__State__Group_3__0__Impl : ( '=>' ) ;
    public final void rule__State__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3532:1: ( ( '=>' ) )
            // InternalBot.g:3533:1: ( '=>' )
            {
            // InternalBot.g:3533:1: ( '=>' )
            // InternalBot.g:3534:2: '=>'
            {
             before(grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_3_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBot.g:3543:1: rule__State__Group_3__1 : rule__State__Group_3__1__Impl ;
    public final void rule__State__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3547:1: ( rule__State__Group_3__1__Impl )
            // InternalBot.g:3548:2: rule__State__Group_3__1__Impl
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
    // InternalBot.g:3554:1: rule__State__Group_3__1__Impl : ( ( rule__State__OutcomingAssignment_3_1 ) ) ;
    public final void rule__State__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3558:1: ( ( ( rule__State__OutcomingAssignment_3_1 ) ) )
            // InternalBot.g:3559:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            {
            // InternalBot.g:3559:1: ( ( rule__State__OutcomingAssignment_3_1 ) )
            // InternalBot.g:3560:2: ( rule__State__OutcomingAssignment_3_1 )
            {
             before(grammarAccess.getStateAccess().getOutcomingAssignment_3_1()); 
            // InternalBot.g:3561:2: ( rule__State__OutcomingAssignment_3_1 )
            // InternalBot.g:3561:3: rule__State__OutcomingAssignment_3_1
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
    // InternalBot.g:3570:1: rule__State2__Group__0 : rule__State2__Group__0__Impl rule__State2__Group__1 ;
    public final void rule__State2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3574:1: ( rule__State2__Group__0__Impl rule__State2__Group__1 )
            // InternalBot.g:3575:2: rule__State2__Group__0__Impl rule__State2__Group__1
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
    // InternalBot.g:3582:1: rule__State2__Group__0__Impl : ( 'chatbot' ) ;
    public final void rule__State2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3586:1: ( ( 'chatbot' ) )
            // InternalBot.g:3587:1: ( 'chatbot' )
            {
            // InternalBot.g:3587:1: ( 'chatbot' )
            // InternalBot.g:3588:2: 'chatbot'
            {
             before(grammarAccess.getState2Access().getChatbotKeyword_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalBot.g:3597:1: rule__State2__Group__1 : rule__State2__Group__1__Impl rule__State2__Group__2 ;
    public final void rule__State2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3601:1: ( rule__State2__Group__1__Impl rule__State2__Group__2 )
            // InternalBot.g:3602:2: rule__State2__Group__1__Impl rule__State2__Group__2
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
    // InternalBot.g:3609:1: rule__State2__Group__1__Impl : ( ( rule__State2__ActionsAssignment_1 ) ) ;
    public final void rule__State2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3613:1: ( ( ( rule__State2__ActionsAssignment_1 ) ) )
            // InternalBot.g:3614:1: ( ( rule__State2__ActionsAssignment_1 ) )
            {
            // InternalBot.g:3614:1: ( ( rule__State2__ActionsAssignment_1 ) )
            // InternalBot.g:3615:2: ( rule__State2__ActionsAssignment_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_1()); 
            // InternalBot.g:3616:2: ( rule__State2__ActionsAssignment_1 )
            // InternalBot.g:3616:3: rule__State2__ActionsAssignment_1
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
    // InternalBot.g:3624:1: rule__State2__Group__2 : rule__State2__Group__2__Impl rule__State2__Group__3 ;
    public final void rule__State2__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3628:1: ( rule__State2__Group__2__Impl rule__State2__Group__3 )
            // InternalBot.g:3629:2: rule__State2__Group__2__Impl rule__State2__Group__3
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
    // InternalBot.g:3636:1: rule__State2__Group__2__Impl : ( ( rule__State2__Group_2__0 )* ) ;
    public final void rule__State2__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3640:1: ( ( ( rule__State2__Group_2__0 )* ) )
            // InternalBot.g:3641:1: ( ( rule__State2__Group_2__0 )* )
            {
            // InternalBot.g:3641:1: ( ( rule__State2__Group_2__0 )* )
            // InternalBot.g:3642:2: ( rule__State2__Group_2__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_2()); 
            // InternalBot.g:3643:2: ( rule__State2__Group_2__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==57) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalBot.g:3643:3: rule__State2__Group_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__State2__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // InternalBot.g:3651:1: rule__State2__Group__3 : rule__State2__Group__3__Impl rule__State2__Group__4 ;
    public final void rule__State2__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3655:1: ( rule__State2__Group__3__Impl rule__State2__Group__4 )
            // InternalBot.g:3656:2: rule__State2__Group__3__Impl rule__State2__Group__4
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
    // InternalBot.g:3663:1: rule__State2__Group__3__Impl : ( '{' ) ;
    public final void rule__State2__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3667:1: ( ( '{' ) )
            // InternalBot.g:3668:1: ( '{' )
            {
            // InternalBot.g:3668:1: ( '{' )
            // InternalBot.g:3669:2: '{'
            {
             before(grammarAccess.getState2Access().getLeftCurlyBracketKeyword_3()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:3678:1: rule__State2__Group__4 : rule__State2__Group__4__Impl rule__State2__Group__5 ;
    public final void rule__State2__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3682:1: ( rule__State2__Group__4__Impl rule__State2__Group__5 )
            // InternalBot.g:3683:2: rule__State2__Group__4__Impl rule__State2__Group__5
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
    // InternalBot.g:3690:1: rule__State2__Group__4__Impl : ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) ;
    public final void rule__State2__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3694:1: ( ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) ) )
            // InternalBot.g:3695:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            {
            // InternalBot.g:3695:1: ( ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* ) )
            // InternalBot.g:3696:2: ( ( rule__State2__Group_4__0 ) ) ( ( rule__State2__Group_4__0 )* )
            {
            // InternalBot.g:3696:2: ( ( rule__State2__Group_4__0 ) )
            // InternalBot.g:3697:3: ( rule__State2__Group_4__0 )
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3698:3: ( rule__State2__Group_4__0 )
            // InternalBot.g:3698:4: rule__State2__Group_4__0
            {
            pushFollow(FOLLOW_33);
            rule__State2__Group_4__0();

            state._fsp--;


            }

             after(grammarAccess.getState2Access().getGroup_4()); 

            }

            // InternalBot.g:3701:2: ( ( rule__State2__Group_4__0 )* )
            // InternalBot.g:3702:3: ( rule__State2__Group_4__0 )*
            {
             before(grammarAccess.getState2Access().getGroup_4()); 
            // InternalBot.g:3703:3: ( rule__State2__Group_4__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==68) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBot.g:3703:4: rule__State2__Group_4__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__State2__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
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
    // InternalBot.g:3712:1: rule__State2__Group__5 : rule__State2__Group__5__Impl ;
    public final void rule__State2__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3716:1: ( rule__State2__Group__5__Impl )
            // InternalBot.g:3717:2: rule__State2__Group__5__Impl
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
    // InternalBot.g:3723:1: rule__State2__Group__5__Impl : ( '}' ) ;
    public final void rule__State2__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3727:1: ( ( '}' ) )
            // InternalBot.g:3728:1: ( '}' )
            {
            // InternalBot.g:3728:1: ( '}' )
            // InternalBot.g:3729:2: '}'
            {
             before(grammarAccess.getState2Access().getRightCurlyBracketKeyword_5()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:3739:1: rule__State2__Group_2__0 : rule__State2__Group_2__0__Impl rule__State2__Group_2__1 ;
    public final void rule__State2__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3743:1: ( rule__State2__Group_2__0__Impl rule__State2__Group_2__1 )
            // InternalBot.g:3744:2: rule__State2__Group_2__0__Impl rule__State2__Group_2__1
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
    // InternalBot.g:3751:1: rule__State2__Group_2__0__Impl : ( ',' ) ;
    public final void rule__State2__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3755:1: ( ( ',' ) )
            // InternalBot.g:3756:1: ( ',' )
            {
            // InternalBot.g:3756:1: ( ',' )
            // InternalBot.g:3757:2: ','
            {
             before(grammarAccess.getState2Access().getCommaKeyword_2_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:3766:1: rule__State2__Group_2__1 : rule__State2__Group_2__1__Impl ;
    public final void rule__State2__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3770:1: ( rule__State2__Group_2__1__Impl )
            // InternalBot.g:3771:2: rule__State2__Group_2__1__Impl
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
    // InternalBot.g:3777:1: rule__State2__Group_2__1__Impl : ( ( rule__State2__ActionsAssignment_2_1 ) ) ;
    public final void rule__State2__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3781:1: ( ( ( rule__State2__ActionsAssignment_2_1 ) ) )
            // InternalBot.g:3782:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            {
            // InternalBot.g:3782:1: ( ( rule__State2__ActionsAssignment_2_1 ) )
            // InternalBot.g:3783:2: ( rule__State2__ActionsAssignment_2_1 )
            {
             before(grammarAccess.getState2Access().getActionsAssignment_2_1()); 
            // InternalBot.g:3784:2: ( rule__State2__ActionsAssignment_2_1 )
            // InternalBot.g:3784:3: rule__State2__ActionsAssignment_2_1
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
    // InternalBot.g:3793:1: rule__State2__Group_4__0 : rule__State2__Group_4__0__Impl rule__State2__Group_4__1 ;
    public final void rule__State2__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3797:1: ( rule__State2__Group_4__0__Impl rule__State2__Group_4__1 )
            // InternalBot.g:3798:2: rule__State2__Group_4__0__Impl rule__State2__Group_4__1
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
    // InternalBot.g:3805:1: rule__State2__Group_4__0__Impl : ( '=>' ) ;
    public final void rule__State2__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3809:1: ( ( '=>' ) )
            // InternalBot.g:3810:1: ( '=>' )
            {
            // InternalBot.g:3810:1: ( '=>' )
            // InternalBot.g:3811:2: '=>'
            {
             before(grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_4_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalBot.g:3820:1: rule__State2__Group_4__1 : rule__State2__Group_4__1__Impl rule__State2__Group_4__2 ;
    public final void rule__State2__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3824:1: ( rule__State2__Group_4__1__Impl rule__State2__Group_4__2 )
            // InternalBot.g:3825:2: rule__State2__Group_4__1__Impl rule__State2__Group_4__2
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
    // InternalBot.g:3832:1: rule__State2__Group_4__1__Impl : ( ( rule__State2__OutcomingAssignment_4_1 ) ) ;
    public final void rule__State2__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3836:1: ( ( ( rule__State2__OutcomingAssignment_4_1 ) ) )
            // InternalBot.g:3837:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            {
            // InternalBot.g:3837:1: ( ( rule__State2__OutcomingAssignment_4_1 ) )
            // InternalBot.g:3838:2: ( rule__State2__OutcomingAssignment_4_1 )
            {
             before(grammarAccess.getState2Access().getOutcomingAssignment_4_1()); 
            // InternalBot.g:3839:2: ( rule__State2__OutcomingAssignment_4_1 )
            // InternalBot.g:3839:3: rule__State2__OutcomingAssignment_4_1
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
    // InternalBot.g:3847:1: rule__State2__Group_4__2 : rule__State2__Group_4__2__Impl ;
    public final void rule__State2__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3851:1: ( rule__State2__Group_4__2__Impl )
            // InternalBot.g:3852:2: rule__State2__Group_4__2__Impl
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
    // InternalBot.g:3858:1: rule__State2__Group_4__2__Impl : ( ';' ) ;
    public final void rule__State2__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3862:1: ( ( ';' ) )
            // InternalBot.g:3863:1: ( ';' )
            {
            // InternalBot.g:3863:1: ( ';' )
            // InternalBot.g:3864:2: ';'
            {
             before(grammarAccess.getState2Access().getSemicolonKeyword_4_2()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:3874:1: rule__TrainingPhrase__Group__0 : rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 ;
    public final void rule__TrainingPhrase__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3878:1: ( rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1 )
            // InternalBot.g:3879:2: rule__TrainingPhrase__Group__0__Impl rule__TrainingPhrase__Group__1
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
    // InternalBot.g:3886:1: rule__TrainingPhrase__Group__0__Impl : ( () ) ;
    public final void rule__TrainingPhrase__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3890:1: ( ( () ) )
            // InternalBot.g:3891:1: ( () )
            {
            // InternalBot.g:3891:1: ( () )
            // InternalBot.g:3892:2: ()
            {
             before(grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0()); 
            // InternalBot.g:3893:2: ()
            // InternalBot.g:3893:3: 
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
    // InternalBot.g:3901:1: rule__TrainingPhrase__Group__1 : rule__TrainingPhrase__Group__1__Impl ;
    public final void rule__TrainingPhrase__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3905:1: ( rule__TrainingPhrase__Group__1__Impl )
            // InternalBot.g:3906:2: rule__TrainingPhrase__Group__1__Impl
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
    // InternalBot.g:3912:1: rule__TrainingPhrase__Group__1__Impl : ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) ;
    public final void rule__TrainingPhrase__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3916:1: ( ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) ) )
            // InternalBot.g:3917:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            {
            // InternalBot.g:3917:1: ( ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* ) )
            // InternalBot.g:3918:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) ) ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            {
            // InternalBot.g:3918:2: ( ( rule__TrainingPhrase__TokensAssignment_1 ) )
            // InternalBot.g:3919:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3920:3: ( rule__TrainingPhrase__TokensAssignment_1 )
            // InternalBot.g:3920:4: rule__TrainingPhrase__TokensAssignment_1
            {
            pushFollow(FOLLOW_35);
            rule__TrainingPhrase__TokensAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 

            }

            // InternalBot.g:3923:2: ( ( rule__TrainingPhrase__TokensAssignment_1 )* )
            // InternalBot.g:3924:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAssignment_1()); 
            // InternalBot.g:3925:3: ( rule__TrainingPhrase__TokensAssignment_1 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( ((LA42_0>=RULE_STRING && LA42_0<=RULE_ID)||LA42_0==75) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBot.g:3925:4: rule__TrainingPhrase__TokensAssignment_1
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__TrainingPhrase__TokensAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // InternalBot.g:3935:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3939:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // InternalBot.g:3940:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
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
    // InternalBot.g:3947:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3951:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // InternalBot.g:3952:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // InternalBot.g:3952:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // InternalBot.g:3953:2: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // InternalBot.g:3954:2: ( rule__Parameter__NameAssignment_0 )
            // InternalBot.g:3954:3: rule__Parameter__NameAssignment_0
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
    // InternalBot.g:3962:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3966:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // InternalBot.g:3967:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
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
    // InternalBot.g:3974:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3978:1: ( ( ':' ) )
            // InternalBot.g:3979:1: ( ':' )
            {
            // InternalBot.g:3979:1: ( ':' )
            // InternalBot.g:3980:2: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:3989:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl rule__Parameter__Group__3 ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:3993:1: ( rule__Parameter__Group__2__Impl rule__Parameter__Group__3 )
            // InternalBot.g:3994:2: rule__Parameter__Group__2__Impl rule__Parameter__Group__3
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
    // InternalBot.g:4001:1: rule__Parameter__Group__2__Impl : ( 'entity' ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4005:1: ( ( 'entity' ) )
            // InternalBot.g:4006:1: ( 'entity' )
            {
            // InternalBot.g:4006:1: ( 'entity' )
            // InternalBot.g:4007:2: 'entity'
            {
             before(grammarAccess.getParameterAccess().getEntityKeyword_2()); 
            match(input,70,FOLLOW_2); 
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
    // InternalBot.g:4016:1: rule__Parameter__Group__3 : rule__Parameter__Group__3__Impl rule__Parameter__Group__4 ;
    public final void rule__Parameter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4020:1: ( rule__Parameter__Group__3__Impl rule__Parameter__Group__4 )
            // InternalBot.g:4021:2: rule__Parameter__Group__3__Impl rule__Parameter__Group__4
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
    // InternalBot.g:4028:1: rule__Parameter__Group__3__Impl : ( ( rule__Parameter__Alternatives_3 ) ) ;
    public final void rule__Parameter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4032:1: ( ( ( rule__Parameter__Alternatives_3 ) ) )
            // InternalBot.g:4033:1: ( ( rule__Parameter__Alternatives_3 ) )
            {
            // InternalBot.g:4033:1: ( ( rule__Parameter__Alternatives_3 ) )
            // InternalBot.g:4034:2: ( rule__Parameter__Alternatives_3 )
            {
             before(grammarAccess.getParameterAccess().getAlternatives_3()); 
            // InternalBot.g:4035:2: ( rule__Parameter__Alternatives_3 )
            // InternalBot.g:4035:3: rule__Parameter__Alternatives_3
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
    // InternalBot.g:4043:1: rule__Parameter__Group__4 : rule__Parameter__Group__4__Impl rule__Parameter__Group__5 ;
    public final void rule__Parameter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4047:1: ( rule__Parameter__Group__4__Impl rule__Parameter__Group__5 )
            // InternalBot.g:4048:2: rule__Parameter__Group__4__Impl rule__Parameter__Group__5
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
    // InternalBot.g:4055:1: rule__Parameter__Group__4__Impl : ( ( rule__Parameter__Group_4__0 )? ) ;
    public final void rule__Parameter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4059:1: ( ( ( rule__Parameter__Group_4__0 )? ) )
            // InternalBot.g:4060:1: ( ( rule__Parameter__Group_4__0 )? )
            {
            // InternalBot.g:4060:1: ( ( rule__Parameter__Group_4__0 )? )
            // InternalBot.g:4061:2: ( rule__Parameter__Group_4__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_4()); 
            // InternalBot.g:4062:2: ( rule__Parameter__Group_4__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==57) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==100) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:4062:3: rule__Parameter__Group_4__0
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
    // InternalBot.g:4070:1: rule__Parameter__Group__5 : rule__Parameter__Group__5__Impl rule__Parameter__Group__6 ;
    public final void rule__Parameter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4074:1: ( rule__Parameter__Group__5__Impl rule__Parameter__Group__6 )
            // InternalBot.g:4075:2: rule__Parameter__Group__5__Impl rule__Parameter__Group__6
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
    // InternalBot.g:4082:1: rule__Parameter__Group__5__Impl : ( ( rule__Parameter__Group_5__0 )? ) ;
    public final void rule__Parameter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4086:1: ( ( ( rule__Parameter__Group_5__0 )? ) )
            // InternalBot.g:4087:1: ( ( rule__Parameter__Group_5__0 )? )
            {
            // InternalBot.g:4087:1: ( ( rule__Parameter__Group_5__0 )? )
            // InternalBot.g:4088:2: ( rule__Parameter__Group_5__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_5()); 
            // InternalBot.g:4089:2: ( rule__Parameter__Group_5__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==57) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==101) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalBot.g:4089:3: rule__Parameter__Group_5__0
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
    // InternalBot.g:4097:1: rule__Parameter__Group__6 : rule__Parameter__Group__6__Impl rule__Parameter__Group__7 ;
    public final void rule__Parameter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4101:1: ( rule__Parameter__Group__6__Impl rule__Parameter__Group__7 )
            // InternalBot.g:4102:2: rule__Parameter__Group__6__Impl rule__Parameter__Group__7
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
    // InternalBot.g:4109:1: rule__Parameter__Group__6__Impl : ( ( rule__Parameter__Group_6__0 )? ) ;
    public final void rule__Parameter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4113:1: ( ( ( rule__Parameter__Group_6__0 )? ) )
            // InternalBot.g:4114:1: ( ( rule__Parameter__Group_6__0 )? )
            {
            // InternalBot.g:4114:1: ( ( rule__Parameter__Group_6__0 )? )
            // InternalBot.g:4115:2: ( rule__Parameter__Group_6__0 )?
            {
             before(grammarAccess.getParameterAccess().getGroup_6()); 
            // InternalBot.g:4116:2: ( rule__Parameter__Group_6__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==57) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalBot.g:4116:3: rule__Parameter__Group_6__0
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
    // InternalBot.g:4124:1: rule__Parameter__Group__7 : rule__Parameter__Group__7__Impl ;
    public final void rule__Parameter__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4128:1: ( rule__Parameter__Group__7__Impl )
            // InternalBot.g:4129:2: rule__Parameter__Group__7__Impl
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
    // InternalBot.g:4135:1: rule__Parameter__Group__7__Impl : ( ';' ) ;
    public final void rule__Parameter__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4139:1: ( ( ';' ) )
            // InternalBot.g:4140:1: ( ';' )
            {
            // InternalBot.g:4140:1: ( ';' )
            // InternalBot.g:4141:2: ';'
            {
             before(grammarAccess.getParameterAccess().getSemicolonKeyword_7()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:4151:1: rule__Parameter__Group_4__0 : rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 ;
    public final void rule__Parameter__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4155:1: ( rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1 )
            // InternalBot.g:4156:2: rule__Parameter__Group_4__0__Impl rule__Parameter__Group_4__1
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
    // InternalBot.g:4163:1: rule__Parameter__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4167:1: ( ( ',' ) )
            // InternalBot.g:4168:1: ( ',' )
            {
            // InternalBot.g:4168:1: ( ',' )
            // InternalBot.g:4169:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_4_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:4178:1: rule__Parameter__Group_4__1 : rule__Parameter__Group_4__1__Impl ;
    public final void rule__Parameter__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4182:1: ( rule__Parameter__Group_4__1__Impl )
            // InternalBot.g:4183:2: rule__Parameter__Group_4__1__Impl
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
    // InternalBot.g:4189:1: rule__Parameter__Group_4__1__Impl : ( ( rule__Parameter__IsListAssignment_4_1 ) ) ;
    public final void rule__Parameter__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4193:1: ( ( ( rule__Parameter__IsListAssignment_4_1 ) ) )
            // InternalBot.g:4194:1: ( ( rule__Parameter__IsListAssignment_4_1 ) )
            {
            // InternalBot.g:4194:1: ( ( rule__Parameter__IsListAssignment_4_1 ) )
            // InternalBot.g:4195:2: ( rule__Parameter__IsListAssignment_4_1 )
            {
             before(grammarAccess.getParameterAccess().getIsListAssignment_4_1()); 
            // InternalBot.g:4196:2: ( rule__Parameter__IsListAssignment_4_1 )
            // InternalBot.g:4196:3: rule__Parameter__IsListAssignment_4_1
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
    // InternalBot.g:4205:1: rule__Parameter__Group_5__0 : rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 ;
    public final void rule__Parameter__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4209:1: ( rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1 )
            // InternalBot.g:4210:2: rule__Parameter__Group_5__0__Impl rule__Parameter__Group_5__1
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
    // InternalBot.g:4217:1: rule__Parameter__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4221:1: ( ( ',' ) )
            // InternalBot.g:4222:1: ( ',' )
            {
            // InternalBot.g:4222:1: ( ',' )
            // InternalBot.g:4223:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_5_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:4232:1: rule__Parameter__Group_5__1 : rule__Parameter__Group_5__1__Impl ;
    public final void rule__Parameter__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4236:1: ( rule__Parameter__Group_5__1__Impl )
            // InternalBot.g:4237:2: rule__Parameter__Group_5__1__Impl
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
    // InternalBot.g:4243:1: rule__Parameter__Group_5__1__Impl : ( ( rule__Parameter__RequiredAssignment_5_1 ) ) ;
    public final void rule__Parameter__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4247:1: ( ( ( rule__Parameter__RequiredAssignment_5_1 ) ) )
            // InternalBot.g:4248:1: ( ( rule__Parameter__RequiredAssignment_5_1 ) )
            {
            // InternalBot.g:4248:1: ( ( rule__Parameter__RequiredAssignment_5_1 ) )
            // InternalBot.g:4249:2: ( rule__Parameter__RequiredAssignment_5_1 )
            {
             before(grammarAccess.getParameterAccess().getRequiredAssignment_5_1()); 
            // InternalBot.g:4250:2: ( rule__Parameter__RequiredAssignment_5_1 )
            // InternalBot.g:4250:3: rule__Parameter__RequiredAssignment_5_1
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
    // InternalBot.g:4259:1: rule__Parameter__Group_6__0 : rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 ;
    public final void rule__Parameter__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4263:1: ( rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1 )
            // InternalBot.g:4264:2: rule__Parameter__Group_6__0__Impl rule__Parameter__Group_6__1
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
    // InternalBot.g:4271:1: rule__Parameter__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Parameter__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4275:1: ( ( ',' ) )
            // InternalBot.g:4276:1: ( ',' )
            {
            // InternalBot.g:4276:1: ( ',' )
            // InternalBot.g:4277:2: ','
            {
             before(grammarAccess.getParameterAccess().getCommaKeyword_6_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:4286:1: rule__Parameter__Group_6__1 : rule__Parameter__Group_6__1__Impl ;
    public final void rule__Parameter__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4290:1: ( rule__Parameter__Group_6__1__Impl )
            // InternalBot.g:4291:2: rule__Parameter__Group_6__1__Impl
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
    // InternalBot.g:4297:1: rule__Parameter__Group_6__1__Impl : ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) ) ;
    public final void rule__Parameter__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4301:1: ( ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) ) )
            // InternalBot.g:4302:1: ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) )
            {
            // InternalBot.g:4302:1: ( ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* ) )
            // InternalBot.g:4303:2: ( ( rule__Parameter__PromptsAssignment_6_1 ) ) ( ( rule__Parameter__PromptsAssignment_6_1 )* )
            {
            // InternalBot.g:4303:2: ( ( rule__Parameter__PromptsAssignment_6_1 ) )
            // InternalBot.g:4304:3: ( rule__Parameter__PromptsAssignment_6_1 )
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 
            // InternalBot.g:4305:3: ( rule__Parameter__PromptsAssignment_6_1 )
            // InternalBot.g:4305:4: rule__Parameter__PromptsAssignment_6_1
            {
            pushFollow(FOLLOW_42);
            rule__Parameter__PromptsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 

            }

            // InternalBot.g:4308:2: ( ( rule__Parameter__PromptsAssignment_6_1 )* )
            // InternalBot.g:4309:3: ( rule__Parameter__PromptsAssignment_6_1 )*
            {
             before(grammarAccess.getParameterAccess().getPromptsAssignment_6_1()); 
            // InternalBot.g:4310:3: ( rule__Parameter__PromptsAssignment_6_1 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==71) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:4310:4: rule__Parameter__PromptsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_42);
            	    rule__Parameter__PromptsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // InternalBot.g:4320:1: rule__Parameter2__Group__0 : rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 ;
    public final void rule__Parameter2__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4324:1: ( rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1 )
            // InternalBot.g:4325:2: rule__Parameter2__Group__0__Impl rule__Parameter2__Group__1
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
    // InternalBot.g:4332:1: rule__Parameter2__Group__0__Impl : ( ( rule__Parameter2__NameAssignment_0 ) ) ;
    public final void rule__Parameter2__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4336:1: ( ( ( rule__Parameter2__NameAssignment_0 ) ) )
            // InternalBot.g:4337:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            {
            // InternalBot.g:4337:1: ( ( rule__Parameter2__NameAssignment_0 ) )
            // InternalBot.g:4338:2: ( rule__Parameter2__NameAssignment_0 )
            {
             before(grammarAccess.getParameter2Access().getNameAssignment_0()); 
            // InternalBot.g:4339:2: ( rule__Parameter2__NameAssignment_0 )
            // InternalBot.g:4339:3: rule__Parameter2__NameAssignment_0
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
    // InternalBot.g:4347:1: rule__Parameter2__Group__1 : rule__Parameter2__Group__1__Impl ;
    public final void rule__Parameter2__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4351:1: ( rule__Parameter2__Group__1__Impl )
            // InternalBot.g:4352:2: rule__Parameter2__Group__1__Impl
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
    // InternalBot.g:4358:1: rule__Parameter2__Group__1__Impl : ( ',' ) ;
    public final void rule__Parameter2__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4362:1: ( ( ',' ) )
            // InternalBot.g:4363:1: ( ',' )
            {
            // InternalBot.g:4363:1: ( ',' )
            // InternalBot.g:4364:2: ','
            {
             before(grammarAccess.getParameter2Access().getCommaKeyword_1()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:4374:1: rule__PromptLanguage__Group__0 : rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 ;
    public final void rule__PromptLanguage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4378:1: ( rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1 )
            // InternalBot.g:4379:2: rule__PromptLanguage__Group__0__Impl rule__PromptLanguage__Group__1
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
    // InternalBot.g:4386:1: rule__PromptLanguage__Group__0__Impl : ( 'prompts' ) ;
    public final void rule__PromptLanguage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4390:1: ( ( 'prompts' ) )
            // InternalBot.g:4391:1: ( 'prompts' )
            {
            // InternalBot.g:4391:1: ( 'prompts' )
            // InternalBot.g:4392:2: 'prompts'
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0()); 
            match(input,71,FOLLOW_2); 
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
    // InternalBot.g:4401:1: rule__PromptLanguage__Group__1 : rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 ;
    public final void rule__PromptLanguage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4405:1: ( rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2 )
            // InternalBot.g:4406:2: rule__PromptLanguage__Group__1__Impl rule__PromptLanguage__Group__2
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
    // InternalBot.g:4413:1: rule__PromptLanguage__Group__1__Impl : ( ( rule__PromptLanguage__Group_1__0 )? ) ;
    public final void rule__PromptLanguage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4417:1: ( ( ( rule__PromptLanguage__Group_1__0 )? ) )
            // InternalBot.g:4418:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            {
            // InternalBot.g:4418:1: ( ( rule__PromptLanguage__Group_1__0 )? )
            // InternalBot.g:4419:2: ( rule__PromptLanguage__Group_1__0 )?
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_1()); 
            // InternalBot.g:4420:2: ( rule__PromptLanguage__Group_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==66) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:4420:3: rule__PromptLanguage__Group_1__0
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
    // InternalBot.g:4428:1: rule__PromptLanguage__Group__2 : rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 ;
    public final void rule__PromptLanguage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4432:1: ( rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3 )
            // InternalBot.g:4433:2: rule__PromptLanguage__Group__2__Impl rule__PromptLanguage__Group__3
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
    // InternalBot.g:4440:1: rule__PromptLanguage__Group__2__Impl : ( '[' ) ;
    public final void rule__PromptLanguage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4444:1: ( ( '[' ) )
            // InternalBot.g:4445:1: ( '[' )
            {
            // InternalBot.g:4445:1: ( '[' )
            // InternalBot.g:4446:2: '['
            {
             before(grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2()); 
            match(input,72,FOLLOW_2); 
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
    // InternalBot.g:4455:1: rule__PromptLanguage__Group__3 : rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 ;
    public final void rule__PromptLanguage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4459:1: ( rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4 )
            // InternalBot.g:4460:2: rule__PromptLanguage__Group__3__Impl rule__PromptLanguage__Group__4
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
    // InternalBot.g:4467:1: rule__PromptLanguage__Group__3__Impl : ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) ;
    public final void rule__PromptLanguage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4471:1: ( ( ( rule__PromptLanguage__PromptsAssignment_3 ) ) )
            // InternalBot.g:4472:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            {
            // InternalBot.g:4472:1: ( ( rule__PromptLanguage__PromptsAssignment_3 ) )
            // InternalBot.g:4473:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_3()); 
            // InternalBot.g:4474:2: ( rule__PromptLanguage__PromptsAssignment_3 )
            // InternalBot.g:4474:3: rule__PromptLanguage__PromptsAssignment_3
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
    // InternalBot.g:4482:1: rule__PromptLanguage__Group__4 : rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 ;
    public final void rule__PromptLanguage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4486:1: ( rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5 )
            // InternalBot.g:4487:2: rule__PromptLanguage__Group__4__Impl rule__PromptLanguage__Group__5
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
    // InternalBot.g:4494:1: rule__PromptLanguage__Group__4__Impl : ( ( rule__PromptLanguage__Group_4__0 )* ) ;
    public final void rule__PromptLanguage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4498:1: ( ( ( rule__PromptLanguage__Group_4__0 )* ) )
            // InternalBot.g:4499:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            {
            // InternalBot.g:4499:1: ( ( rule__PromptLanguage__Group_4__0 )* )
            // InternalBot.g:4500:2: ( rule__PromptLanguage__Group_4__0 )*
            {
             before(grammarAccess.getPromptLanguageAccess().getGroup_4()); 
            // InternalBot.g:4501:2: ( rule__PromptLanguage__Group_4__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==57) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBot.g:4501:3: rule__PromptLanguage__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__PromptLanguage__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // InternalBot.g:4509:1: rule__PromptLanguage__Group__5 : rule__PromptLanguage__Group__5__Impl ;
    public final void rule__PromptLanguage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4513:1: ( rule__PromptLanguage__Group__5__Impl )
            // InternalBot.g:4514:2: rule__PromptLanguage__Group__5__Impl
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
    // InternalBot.g:4520:1: rule__PromptLanguage__Group__5__Impl : ( ']' ) ;
    public final void rule__PromptLanguage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4524:1: ( ( ']' ) )
            // InternalBot.g:4525:1: ( ']' )
            {
            // InternalBot.g:4525:1: ( ']' )
            // InternalBot.g:4526:2: ']'
            {
             before(grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5()); 
            match(input,73,FOLLOW_2); 
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
    // InternalBot.g:4536:1: rule__PromptLanguage__Group_1__0 : rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 ;
    public final void rule__PromptLanguage__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4540:1: ( rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1 )
            // InternalBot.g:4541:2: rule__PromptLanguage__Group_1__0__Impl rule__PromptLanguage__Group_1__1
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
    // InternalBot.g:4548:1: rule__PromptLanguage__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__PromptLanguage__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4552:1: ( ( 'in' ) )
            // InternalBot.g:4553:1: ( 'in' )
            {
            // InternalBot.g:4553:1: ( 'in' )
            // InternalBot.g:4554:2: 'in'
            {
             before(grammarAccess.getPromptLanguageAccess().getInKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:4563:1: rule__PromptLanguage__Group_1__1 : rule__PromptLanguage__Group_1__1__Impl ;
    public final void rule__PromptLanguage__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4567:1: ( rule__PromptLanguage__Group_1__1__Impl )
            // InternalBot.g:4568:2: rule__PromptLanguage__Group_1__1__Impl
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
    // InternalBot.g:4574:1: rule__PromptLanguage__Group_1__1__Impl : ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) ;
    public final void rule__PromptLanguage__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4578:1: ( ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:4579:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:4579:1: ( ( rule__PromptLanguage__LanguageAssignment_1_1 ) )
            // InternalBot.g:4580:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:4581:2: ( rule__PromptLanguage__LanguageAssignment_1_1 )
            // InternalBot.g:4581:3: rule__PromptLanguage__LanguageAssignment_1_1
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
    // InternalBot.g:4590:1: rule__PromptLanguage__Group_4__0 : rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 ;
    public final void rule__PromptLanguage__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4594:1: ( rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1 )
            // InternalBot.g:4595:2: rule__PromptLanguage__Group_4__0__Impl rule__PromptLanguage__Group_4__1
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
    // InternalBot.g:4602:1: rule__PromptLanguage__Group_4__0__Impl : ( ',' ) ;
    public final void rule__PromptLanguage__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4606:1: ( ( ',' ) )
            // InternalBot.g:4607:1: ( ',' )
            {
            // InternalBot.g:4607:1: ( ',' )
            // InternalBot.g:4608:2: ','
            {
             before(grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:4617:1: rule__PromptLanguage__Group_4__1 : rule__PromptLanguage__Group_4__1__Impl ;
    public final void rule__PromptLanguage__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4621:1: ( rule__PromptLanguage__Group_4__1__Impl )
            // InternalBot.g:4622:2: rule__PromptLanguage__Group_4__1__Impl
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
    // InternalBot.g:4628:1: rule__PromptLanguage__Group_4__1__Impl : ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) ;
    public final void rule__PromptLanguage__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4632:1: ( ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) ) )
            // InternalBot.g:4633:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            {
            // InternalBot.g:4633:1: ( ( rule__PromptLanguage__PromptsAssignment_4_1 ) )
            // InternalBot.g:4634:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            {
             before(grammarAccess.getPromptLanguageAccess().getPromptsAssignment_4_1()); 
            // InternalBot.g:4635:2: ( rule__PromptLanguage__PromptsAssignment_4_1 )
            // InternalBot.g:4635:3: rule__PromptLanguage__PromptsAssignment_4_1
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
    // InternalBot.g:4644:1: rule__EntityToken__Group__0 : rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 ;
    public final void rule__EntityToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4648:1: ( rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1 )
            // InternalBot.g:4649:2: rule__EntityToken__Group__0__Impl rule__EntityToken__Group__1
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
    // InternalBot.g:4656:1: rule__EntityToken__Group__0__Impl : ( '@' ) ;
    public final void rule__EntityToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4660:1: ( ( '@' ) )
            // InternalBot.g:4661:1: ( '@' )
            {
            // InternalBot.g:4661:1: ( '@' )
            // InternalBot.g:4662:2: '@'
            {
             before(grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0()); 
            match(input,74,FOLLOW_2); 
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
    // InternalBot.g:4671:1: rule__EntityToken__Group__1 : rule__EntityToken__Group__1__Impl ;
    public final void rule__EntityToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4675:1: ( rule__EntityToken__Group__1__Impl )
            // InternalBot.g:4676:2: rule__EntityToken__Group__1__Impl
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
    // InternalBot.g:4682:1: rule__EntityToken__Group__1__Impl : ( ( rule__EntityToken__EntityAssignment_1 ) ) ;
    public final void rule__EntityToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4686:1: ( ( ( rule__EntityToken__EntityAssignment_1 ) ) )
            // InternalBot.g:4687:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            {
            // InternalBot.g:4687:1: ( ( rule__EntityToken__EntityAssignment_1 ) )
            // InternalBot.g:4688:2: ( rule__EntityToken__EntityAssignment_1 )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityAssignment_1()); 
            // InternalBot.g:4689:2: ( rule__EntityToken__EntityAssignment_1 )
            // InternalBot.g:4689:3: rule__EntityToken__EntityAssignment_1
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
    // InternalBot.g:4698:1: rule__ParameterToken__Group__0 : rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 ;
    public final void rule__ParameterToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4702:1: ( rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1 )
            // InternalBot.g:4703:2: rule__ParameterToken__Group__0__Impl rule__ParameterToken__Group__1
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
    // InternalBot.g:4710:1: rule__ParameterToken__Group__0__Impl : ( '[' ) ;
    public final void rule__ParameterToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4714:1: ( ( '[' ) )
            // InternalBot.g:4715:1: ( '[' )
            {
            // InternalBot.g:4715:1: ( '[' )
            // InternalBot.g:4716:2: '['
            {
             before(grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0()); 
            match(input,72,FOLLOW_2); 
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
    // InternalBot.g:4725:1: rule__ParameterToken__Group__1 : rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 ;
    public final void rule__ParameterToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4729:1: ( rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2 )
            // InternalBot.g:4730:2: rule__ParameterToken__Group__1__Impl rule__ParameterToken__Group__2
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
    // InternalBot.g:4737:1: rule__ParameterToken__Group__1__Impl : ( ( rule__ParameterToken__ParameterAssignment_1 ) ) ;
    public final void rule__ParameterToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4741:1: ( ( ( rule__ParameterToken__ParameterAssignment_1 ) ) )
            // InternalBot.g:4742:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            {
            // InternalBot.g:4742:1: ( ( rule__ParameterToken__ParameterAssignment_1 ) )
            // InternalBot.g:4743:2: ( rule__ParameterToken__ParameterAssignment_1 )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterAssignment_1()); 
            // InternalBot.g:4744:2: ( rule__ParameterToken__ParameterAssignment_1 )
            // InternalBot.g:4744:3: rule__ParameterToken__ParameterAssignment_1
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
    // InternalBot.g:4752:1: rule__ParameterToken__Group__2 : rule__ParameterToken__Group__2__Impl ;
    public final void rule__ParameterToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4756:1: ( rule__ParameterToken__Group__2__Impl )
            // InternalBot.g:4757:2: rule__ParameterToken__Group__2__Impl
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
    // InternalBot.g:4763:1: rule__ParameterToken__Group__2__Impl : ( ']' ) ;
    public final void rule__ParameterToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4767:1: ( ( ']' ) )
            // InternalBot.g:4768:1: ( ']' )
            {
            // InternalBot.g:4768:1: ( ']' )
            // InternalBot.g:4769:2: ']'
            {
             before(grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2()); 
            match(input,73,FOLLOW_2); 
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
    // InternalBot.g:4779:1: rule__ParameterRefenceToken__Group__0 : rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 ;
    public final void rule__ParameterRefenceToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4783:1: ( rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1 )
            // InternalBot.g:4784:2: rule__ParameterRefenceToken__Group__0__Impl rule__ParameterRefenceToken__Group__1
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
    // InternalBot.g:4791:1: rule__ParameterRefenceToken__Group__0__Impl : ( '(' ) ;
    public final void rule__ParameterRefenceToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4795:1: ( ( '(' ) )
            // InternalBot.g:4796:1: ( '(' )
            {
            // InternalBot.g:4796:1: ( '(' )
            // InternalBot.g:4797:2: '('
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0()); 
            match(input,75,FOLLOW_2); 
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
    // InternalBot.g:4806:1: rule__ParameterRefenceToken__Group__1 : rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 ;
    public final void rule__ParameterRefenceToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4810:1: ( rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2 )
            // InternalBot.g:4811:2: rule__ParameterRefenceToken__Group__1__Impl rule__ParameterRefenceToken__Group__2
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
    // InternalBot.g:4818:1: rule__ParameterRefenceToken__Group__1__Impl : ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) ;
    public final void rule__ParameterRefenceToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4822:1: ( ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) ) )
            // InternalBot.g:4823:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            {
            // InternalBot.g:4823:1: ( ( rule__ParameterRefenceToken__TextReferenceAssignment_1 ) )
            // InternalBot.g:4824:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceAssignment_1()); 
            // InternalBot.g:4825:2: ( rule__ParameterRefenceToken__TextReferenceAssignment_1 )
            // InternalBot.g:4825:3: rule__ParameterRefenceToken__TextReferenceAssignment_1
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
    // InternalBot.g:4833:1: rule__ParameterRefenceToken__Group__2 : rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 ;
    public final void rule__ParameterRefenceToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4837:1: ( rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3 )
            // InternalBot.g:4838:2: rule__ParameterRefenceToken__Group__2__Impl rule__ParameterRefenceToken__Group__3
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
    // InternalBot.g:4845:1: rule__ParameterRefenceToken__Group__2__Impl : ( ')' ) ;
    public final void rule__ParameterRefenceToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4849:1: ( ( ')' ) )
            // InternalBot.g:4850:1: ( ')' )
            {
            // InternalBot.g:4850:1: ( ')' )
            // InternalBot.g:4851:2: ')'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2()); 
            match(input,76,FOLLOW_2); 
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
    // InternalBot.g:4860:1: rule__ParameterRefenceToken__Group__3 : rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 ;
    public final void rule__ParameterRefenceToken__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4864:1: ( rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4 )
            // InternalBot.g:4865:2: rule__ParameterRefenceToken__Group__3__Impl rule__ParameterRefenceToken__Group__4
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
    // InternalBot.g:4872:1: rule__ParameterRefenceToken__Group__3__Impl : ( '[' ) ;
    public final void rule__ParameterRefenceToken__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4876:1: ( ( '[' ) )
            // InternalBot.g:4877:1: ( '[' )
            {
            // InternalBot.g:4877:1: ( '[' )
            // InternalBot.g:4878:2: '['
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3()); 
            match(input,72,FOLLOW_2); 
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
    // InternalBot.g:4887:1: rule__ParameterRefenceToken__Group__4 : rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 ;
    public final void rule__ParameterRefenceToken__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4891:1: ( rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5 )
            // InternalBot.g:4892:2: rule__ParameterRefenceToken__Group__4__Impl rule__ParameterRefenceToken__Group__5
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
    // InternalBot.g:4899:1: rule__ParameterRefenceToken__Group__4__Impl : ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) ;
    public final void rule__ParameterRefenceToken__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4903:1: ( ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) ) )
            // InternalBot.g:4904:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            {
            // InternalBot.g:4904:1: ( ( rule__ParameterRefenceToken__ParameterAssignment_4 ) )
            // InternalBot.g:4905:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterAssignment_4()); 
            // InternalBot.g:4906:2: ( rule__ParameterRefenceToken__ParameterAssignment_4 )
            // InternalBot.g:4906:3: rule__ParameterRefenceToken__ParameterAssignment_4
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
    // InternalBot.g:4914:1: rule__ParameterRefenceToken__Group__5 : rule__ParameterRefenceToken__Group__5__Impl ;
    public final void rule__ParameterRefenceToken__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4918:1: ( rule__ParameterRefenceToken__Group__5__Impl )
            // InternalBot.g:4919:2: rule__ParameterRefenceToken__Group__5__Impl
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
    // InternalBot.g:4925:1: rule__ParameterRefenceToken__Group__5__Impl : ( ']' ) ;
    public final void rule__ParameterRefenceToken__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4929:1: ( ( ']' ) )
            // InternalBot.g:4930:1: ( ']' )
            {
            // InternalBot.g:4930:1: ( ']' )
            // InternalBot.g:4931:2: ']'
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5()); 
            match(input,73,FOLLOW_2); 
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
    // InternalBot.g:4941:1: rule__HTTPRequestToken__Group__0 : rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 ;
    public final void rule__HTTPRequestToken__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4945:1: ( rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1 )
            // InternalBot.g:4946:2: rule__HTTPRequestToken__Group__0__Impl rule__HTTPRequestToken__Group__1
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
    // InternalBot.g:4953:1: rule__HTTPRequestToken__Group__0__Impl : ( 'request.' ) ;
    public final void rule__HTTPRequestToken__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4957:1: ( ( 'request.' ) )
            // InternalBot.g:4958:1: ( 'request.' )
            {
            // InternalBot.g:4958:1: ( 'request.' )
            // InternalBot.g:4959:2: 'request.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0()); 
            match(input,77,FOLLOW_2); 
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
    // InternalBot.g:4968:1: rule__HTTPRequestToken__Group__1 : rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 ;
    public final void rule__HTTPRequestToken__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4972:1: ( rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2 )
            // InternalBot.g:4973:2: rule__HTTPRequestToken__Group__1__Impl rule__HTTPRequestToken__Group__2
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
    // InternalBot.g:4980:1: rule__HTTPRequestToken__Group__1__Impl : ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) ;
    public final void rule__HTTPRequestToken__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4984:1: ( ( ( rule__HTTPRequestToken__TypeAssignment_1 ) ) )
            // InternalBot.g:4985:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            {
            // InternalBot.g:4985:1: ( ( rule__HTTPRequestToken__TypeAssignment_1 ) )
            // InternalBot.g:4986:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getTypeAssignment_1()); 
            // InternalBot.g:4987:2: ( rule__HTTPRequestToken__TypeAssignment_1 )
            // InternalBot.g:4987:3: rule__HTTPRequestToken__TypeAssignment_1
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
    // InternalBot.g:4995:1: rule__HTTPRequestToken__Group__2 : rule__HTTPRequestToken__Group__2__Impl ;
    public final void rule__HTTPRequestToken__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:4999:1: ( rule__HTTPRequestToken__Group__2__Impl )
            // InternalBot.g:5000:2: rule__HTTPRequestToken__Group__2__Impl
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
    // InternalBot.g:5006:1: rule__HTTPRequestToken__Group__2__Impl : ( ( rule__HTTPRequestToken__Group_2__0 )? ) ;
    public final void rule__HTTPRequestToken__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5010:1: ( ( ( rule__HTTPRequestToken__Group_2__0 )? ) )
            // InternalBot.g:5011:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            {
            // InternalBot.g:5011:1: ( ( rule__HTTPRequestToken__Group_2__0 )? )
            // InternalBot.g:5012:2: ( rule__HTTPRequestToken__Group_2__0 )?
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getGroup_2()); 
            // InternalBot.g:5013:2: ( rule__HTTPRequestToken__Group_2__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==78) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:5013:3: rule__HTTPRequestToken__Group_2__0
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
    // InternalBot.g:5022:1: rule__HTTPRequestToken__Group_2__0 : rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 ;
    public final void rule__HTTPRequestToken__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5026:1: ( rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1 )
            // InternalBot.g:5027:2: rule__HTTPRequestToken__Group_2__0__Impl rule__HTTPRequestToken__Group_2__1
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
    // InternalBot.g:5034:1: rule__HTTPRequestToken__Group_2__0__Impl : ( '.' ) ;
    public final void rule__HTTPRequestToken__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5038:1: ( ( '.' ) )
            // InternalBot.g:5039:1: ( '.' )
            {
            // InternalBot.g:5039:1: ( '.' )
            // InternalBot.g:5040:2: '.'
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0()); 
            match(input,78,FOLLOW_2); 
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
    // InternalBot.g:5049:1: rule__HTTPRequestToken__Group_2__1 : rule__HTTPRequestToken__Group_2__1__Impl ;
    public final void rule__HTTPRequestToken__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5053:1: ( rule__HTTPRequestToken__Group_2__1__Impl )
            // InternalBot.g:5054:2: rule__HTTPRequestToken__Group_2__1__Impl
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
    // InternalBot.g:5060:1: rule__HTTPRequestToken__Group_2__1__Impl : ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) ;
    public final void rule__HTTPRequestToken__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5064:1: ( ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) ) )
            // InternalBot.g:5065:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            {
            // InternalBot.g:5065:1: ( ( rule__HTTPRequestToken__DataKeyAssignment_2_1 ) )
            // InternalBot.g:5066:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            {
             before(grammarAccess.getHTTPRequestTokenAccess().getDataKeyAssignment_2_1()); 
            // InternalBot.g:5067:2: ( rule__HTTPRequestToken__DataKeyAssignment_2_1 )
            // InternalBot.g:5067:3: rule__HTTPRequestToken__DataKeyAssignment_2_1
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
    // InternalBot.g:5076:1: rule__SimpleEntity__Group__0 : rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1 ;
    public final void rule__SimpleEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5080:1: ( rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1 )
            // InternalBot.g:5081:2: rule__SimpleEntity__Group__0__Impl rule__SimpleEntity__Group__1
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
    // InternalBot.g:5088:1: rule__SimpleEntity__Group__0__Impl : ( 'Simple' ) ;
    public final void rule__SimpleEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5092:1: ( ( 'Simple' ) )
            // InternalBot.g:5093:1: ( 'Simple' )
            {
            // InternalBot.g:5093:1: ( 'Simple' )
            // InternalBot.g:5094:2: 'Simple'
            {
             before(grammarAccess.getSimpleEntityAccess().getSimpleKeyword_0()); 
            match(input,79,FOLLOW_2); 
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
    // InternalBot.g:5103:1: rule__SimpleEntity__Group__1 : rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2 ;
    public final void rule__SimpleEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5107:1: ( rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2 )
            // InternalBot.g:5108:2: rule__SimpleEntity__Group__1__Impl rule__SimpleEntity__Group__2
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
    // InternalBot.g:5115:1: rule__SimpleEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__SimpleEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5119:1: ( ( 'entity' ) )
            // InternalBot.g:5120:1: ( 'entity' )
            {
            // InternalBot.g:5120:1: ( 'entity' )
            // InternalBot.g:5121:2: 'entity'
            {
             before(grammarAccess.getSimpleEntityAccess().getEntityKeyword_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalBot.g:5130:1: rule__SimpleEntity__Group__2 : rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3 ;
    public final void rule__SimpleEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5134:1: ( rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3 )
            // InternalBot.g:5135:2: rule__SimpleEntity__Group__2__Impl rule__SimpleEntity__Group__3
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
    // InternalBot.g:5142:1: rule__SimpleEntity__Group__2__Impl : ( ( rule__SimpleEntity__NameAssignment_2 ) ) ;
    public final void rule__SimpleEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5146:1: ( ( ( rule__SimpleEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5147:1: ( ( rule__SimpleEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5147:1: ( ( rule__SimpleEntity__NameAssignment_2 ) )
            // InternalBot.g:5148:2: ( rule__SimpleEntity__NameAssignment_2 )
            {
             before(grammarAccess.getSimpleEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5149:2: ( rule__SimpleEntity__NameAssignment_2 )
            // InternalBot.g:5149:3: rule__SimpleEntity__NameAssignment_2
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
    // InternalBot.g:5157:1: rule__SimpleEntity__Group__3 : rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4 ;
    public final void rule__SimpleEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5161:1: ( rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4 )
            // InternalBot.g:5162:2: rule__SimpleEntity__Group__3__Impl rule__SimpleEntity__Group__4
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
    // InternalBot.g:5169:1: rule__SimpleEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__SimpleEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5173:1: ( ( ':' ) )
            // InternalBot.g:5174:1: ( ':' )
            {
            // InternalBot.g:5174:1: ( ':' )
            // InternalBot.g:5175:2: ':'
            {
             before(grammarAccess.getSimpleEntityAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:5184:1: rule__SimpleEntity__Group__4 : rule__SimpleEntity__Group__4__Impl ;
    public final void rule__SimpleEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5188:1: ( rule__SimpleEntity__Group__4__Impl )
            // InternalBot.g:5189:2: rule__SimpleEntity__Group__4__Impl
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
    // InternalBot.g:5195:1: rule__SimpleEntity__Group__4__Impl : ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__SimpleEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5199:1: ( ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5200:1: ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5200:1: ( ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5201:2: ( ( rule__SimpleEntity__InputsAssignment_4 ) ) ( ( rule__SimpleEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5201:2: ( ( rule__SimpleEntity__InputsAssignment_4 ) )
            // InternalBot.g:5202:3: ( rule__SimpleEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5203:3: ( rule__SimpleEntity__InputsAssignment_4 )
            // InternalBot.g:5203:4: rule__SimpleEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__SimpleEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5206:2: ( ( rule__SimpleEntity__InputsAssignment_4 )* )
            // InternalBot.g:5207:3: ( rule__SimpleEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getSimpleEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5208:3: ( rule__SimpleEntity__InputsAssignment_4 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=63 && LA50_0<=64)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:5208:4: rule__SimpleEntity__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__SimpleEntity__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalBot.g:5218:1: rule__ComplexEntity__Group__0 : rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1 ;
    public final void rule__ComplexEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5222:1: ( rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1 )
            // InternalBot.g:5223:2: rule__ComplexEntity__Group__0__Impl rule__ComplexEntity__Group__1
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
    // InternalBot.g:5230:1: rule__ComplexEntity__Group__0__Impl : ( 'Composite' ) ;
    public final void rule__ComplexEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5234:1: ( ( 'Composite' ) )
            // InternalBot.g:5235:1: ( 'Composite' )
            {
            // InternalBot.g:5235:1: ( 'Composite' )
            // InternalBot.g:5236:2: 'Composite'
            {
             before(grammarAccess.getComplexEntityAccess().getCompositeKeyword_0()); 
            match(input,80,FOLLOW_2); 
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
    // InternalBot.g:5245:1: rule__ComplexEntity__Group__1 : rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2 ;
    public final void rule__ComplexEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5249:1: ( rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2 )
            // InternalBot.g:5250:2: rule__ComplexEntity__Group__1__Impl rule__ComplexEntity__Group__2
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
    // InternalBot.g:5257:1: rule__ComplexEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__ComplexEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5261:1: ( ( 'entity' ) )
            // InternalBot.g:5262:1: ( 'entity' )
            {
            // InternalBot.g:5262:1: ( 'entity' )
            // InternalBot.g:5263:2: 'entity'
            {
             before(grammarAccess.getComplexEntityAccess().getEntityKeyword_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalBot.g:5272:1: rule__ComplexEntity__Group__2 : rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3 ;
    public final void rule__ComplexEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5276:1: ( rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3 )
            // InternalBot.g:5277:2: rule__ComplexEntity__Group__2__Impl rule__ComplexEntity__Group__3
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
    // InternalBot.g:5284:1: rule__ComplexEntity__Group__2__Impl : ( ( rule__ComplexEntity__NameAssignment_2 ) ) ;
    public final void rule__ComplexEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5288:1: ( ( ( rule__ComplexEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5289:1: ( ( rule__ComplexEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5289:1: ( ( rule__ComplexEntity__NameAssignment_2 ) )
            // InternalBot.g:5290:2: ( rule__ComplexEntity__NameAssignment_2 )
            {
             before(grammarAccess.getComplexEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5291:2: ( rule__ComplexEntity__NameAssignment_2 )
            // InternalBot.g:5291:3: rule__ComplexEntity__NameAssignment_2
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
    // InternalBot.g:5299:1: rule__ComplexEntity__Group__3 : rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4 ;
    public final void rule__ComplexEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5303:1: ( rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4 )
            // InternalBot.g:5304:2: rule__ComplexEntity__Group__3__Impl rule__ComplexEntity__Group__4
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
    // InternalBot.g:5311:1: rule__ComplexEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__ComplexEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5315:1: ( ( ':' ) )
            // InternalBot.g:5316:1: ( ':' )
            {
            // InternalBot.g:5316:1: ( ':' )
            // InternalBot.g:5317:2: ':'
            {
             before(grammarAccess.getComplexEntityAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:5326:1: rule__ComplexEntity__Group__4 : rule__ComplexEntity__Group__4__Impl ;
    public final void rule__ComplexEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5330:1: ( rule__ComplexEntity__Group__4__Impl )
            // InternalBot.g:5331:2: rule__ComplexEntity__Group__4__Impl
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
    // InternalBot.g:5337:1: rule__ComplexEntity__Group__4__Impl : ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__ComplexEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5341:1: ( ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5342:1: ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5342:1: ( ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5343:2: ( ( rule__ComplexEntity__InputsAssignment_4 ) ) ( ( rule__ComplexEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5343:2: ( ( rule__ComplexEntity__InputsAssignment_4 ) )
            // InternalBot.g:5344:3: ( rule__ComplexEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5345:3: ( rule__ComplexEntity__InputsAssignment_4 )
            // InternalBot.g:5345:4: rule__ComplexEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__ComplexEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5348:2: ( ( rule__ComplexEntity__InputsAssignment_4 )* )
            // InternalBot.g:5349:3: ( rule__ComplexEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getComplexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5350:3: ( rule__ComplexEntity__InputsAssignment_4 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=63 && LA51_0<=64)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBot.g:5350:4: rule__ComplexEntity__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__ComplexEntity__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
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
    // InternalBot.g:5360:1: rule__RegexEntity__Group__0 : rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1 ;
    public final void rule__RegexEntity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5364:1: ( rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1 )
            // InternalBot.g:5365:2: rule__RegexEntity__Group__0__Impl rule__RegexEntity__Group__1
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
    // InternalBot.g:5372:1: rule__RegexEntity__Group__0__Impl : ( 'Regex' ) ;
    public final void rule__RegexEntity__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5376:1: ( ( 'Regex' ) )
            // InternalBot.g:5377:1: ( 'Regex' )
            {
            // InternalBot.g:5377:1: ( 'Regex' )
            // InternalBot.g:5378:2: 'Regex'
            {
             before(grammarAccess.getRegexEntityAccess().getRegexKeyword_0()); 
            match(input,81,FOLLOW_2); 
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
    // InternalBot.g:5387:1: rule__RegexEntity__Group__1 : rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2 ;
    public final void rule__RegexEntity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5391:1: ( rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2 )
            // InternalBot.g:5392:2: rule__RegexEntity__Group__1__Impl rule__RegexEntity__Group__2
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
    // InternalBot.g:5399:1: rule__RegexEntity__Group__1__Impl : ( 'entity' ) ;
    public final void rule__RegexEntity__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5403:1: ( ( 'entity' ) )
            // InternalBot.g:5404:1: ( 'entity' )
            {
            // InternalBot.g:5404:1: ( 'entity' )
            // InternalBot.g:5405:2: 'entity'
            {
             before(grammarAccess.getRegexEntityAccess().getEntityKeyword_1()); 
            match(input,70,FOLLOW_2); 
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
    // InternalBot.g:5414:1: rule__RegexEntity__Group__2 : rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3 ;
    public final void rule__RegexEntity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5418:1: ( rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3 )
            // InternalBot.g:5419:2: rule__RegexEntity__Group__2__Impl rule__RegexEntity__Group__3
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
    // InternalBot.g:5426:1: rule__RegexEntity__Group__2__Impl : ( ( rule__RegexEntity__NameAssignment_2 ) ) ;
    public final void rule__RegexEntity__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5430:1: ( ( ( rule__RegexEntity__NameAssignment_2 ) ) )
            // InternalBot.g:5431:1: ( ( rule__RegexEntity__NameAssignment_2 ) )
            {
            // InternalBot.g:5431:1: ( ( rule__RegexEntity__NameAssignment_2 ) )
            // InternalBot.g:5432:2: ( rule__RegexEntity__NameAssignment_2 )
            {
             before(grammarAccess.getRegexEntityAccess().getNameAssignment_2()); 
            // InternalBot.g:5433:2: ( rule__RegexEntity__NameAssignment_2 )
            // InternalBot.g:5433:3: rule__RegexEntity__NameAssignment_2
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
    // InternalBot.g:5441:1: rule__RegexEntity__Group__3 : rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4 ;
    public final void rule__RegexEntity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5445:1: ( rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4 )
            // InternalBot.g:5446:2: rule__RegexEntity__Group__3__Impl rule__RegexEntity__Group__4
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
    // InternalBot.g:5453:1: rule__RegexEntity__Group__3__Impl : ( ':' ) ;
    public final void rule__RegexEntity__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5457:1: ( ( ':' ) )
            // InternalBot.g:5458:1: ( ':' )
            {
            // InternalBot.g:5458:1: ( ':' )
            // InternalBot.g:5459:2: ':'
            {
             before(grammarAccess.getRegexEntityAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:5468:1: rule__RegexEntity__Group__4 : rule__RegexEntity__Group__4__Impl ;
    public final void rule__RegexEntity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5472:1: ( rule__RegexEntity__Group__4__Impl )
            // InternalBot.g:5473:2: rule__RegexEntity__Group__4__Impl
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
    // InternalBot.g:5479:1: rule__RegexEntity__Group__4__Impl : ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) ) ;
    public final void rule__RegexEntity__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5483:1: ( ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) ) )
            // InternalBot.g:5484:1: ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:5484:1: ( ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* ) )
            // InternalBot.g:5485:2: ( ( rule__RegexEntity__InputsAssignment_4 ) ) ( ( rule__RegexEntity__InputsAssignment_4 )* )
            {
            // InternalBot.g:5485:2: ( ( rule__RegexEntity__InputsAssignment_4 ) )
            // InternalBot.g:5486:3: ( rule__RegexEntity__InputsAssignment_4 )
            {
             before(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5487:3: ( rule__RegexEntity__InputsAssignment_4 )
            // InternalBot.g:5487:4: rule__RegexEntity__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__RegexEntity__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:5490:2: ( ( rule__RegexEntity__InputsAssignment_4 )* )
            // InternalBot.g:5491:3: ( rule__RegexEntity__InputsAssignment_4 )*
            {
             before(grammarAccess.getRegexEntityAccess().getInputsAssignment_4()); 
            // InternalBot.g:5492:3: ( rule__RegexEntity__InputsAssignment_4 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=63 && LA52_0<=64)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:5492:4: rule__RegexEntity__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__RegexEntity__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // InternalBot.g:5502:1: rule__SLanguageInput__Group__0 : rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1 ;
    public final void rule__SLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5506:1: ( rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1 )
            // InternalBot.g:5507:2: rule__SLanguageInput__Group__0__Impl rule__SLanguageInput__Group__1
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
    // InternalBot.g:5514:1: rule__SLanguageInput__Group__0__Impl : ( ( rule__SLanguageInput__Group_0__0 )? ) ;
    public final void rule__SLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5518:1: ( ( ( rule__SLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5519:1: ( ( rule__SLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5519:1: ( ( rule__SLanguageInput__Group_0__0 )? )
            // InternalBot.g:5520:2: ( rule__SLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5521:2: ( rule__SLanguageInput__Group_0__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==63) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:5521:3: rule__SLanguageInput__Group_0__0
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
    // InternalBot.g:5529:1: rule__SLanguageInput__Group__1 : rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2 ;
    public final void rule__SLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5533:1: ( rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2 )
            // InternalBot.g:5534:2: rule__SLanguageInput__Group__1__Impl rule__SLanguageInput__Group__2
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
    // InternalBot.g:5541:1: rule__SLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__SLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5545:1: ( ( '{' ) )
            // InternalBot.g:5546:1: ( '{' )
            {
            // InternalBot.g:5546:1: ( '{' )
            // InternalBot.g:5547:2: '{'
            {
             before(grammarAccess.getSLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:5556:1: rule__SLanguageInput__Group__2 : rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3 ;
    public final void rule__SLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5560:1: ( rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3 )
            // InternalBot.g:5561:2: rule__SLanguageInput__Group__2__Impl rule__SLanguageInput__Group__3
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
    // InternalBot.g:5568:1: rule__SLanguageInput__Group__2__Impl : ( ( rule__SLanguageInput__Group_2__0 ) ) ;
    public final void rule__SLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5572:1: ( ( ( rule__SLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5573:1: ( ( rule__SLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5573:1: ( ( rule__SLanguageInput__Group_2__0 ) )
            // InternalBot.g:5574:2: ( rule__SLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5575:2: ( rule__SLanguageInput__Group_2__0 )
            // InternalBot.g:5575:3: rule__SLanguageInput__Group_2__0
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
    // InternalBot.g:5583:1: rule__SLanguageInput__Group__3 : rule__SLanguageInput__Group__3__Impl ;
    public final void rule__SLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5587:1: ( rule__SLanguageInput__Group__3__Impl )
            // InternalBot.g:5588:2: rule__SLanguageInput__Group__3__Impl
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
    // InternalBot.g:5594:1: rule__SLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__SLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5598:1: ( ( '}' ) )
            // InternalBot.g:5599:1: ( '}' )
            {
            // InternalBot.g:5599:1: ( '}' )
            // InternalBot.g:5600:2: '}'
            {
             before(grammarAccess.getSLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:5610:1: rule__SLanguageInput__Group_0__0 : rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1 ;
    public final void rule__SLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5614:1: ( rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1 )
            // InternalBot.g:5615:2: rule__SLanguageInput__Group_0__0__Impl rule__SLanguageInput__Group_0__1
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
    // InternalBot.g:5622:1: rule__SLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__SLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5626:1: ( ( 'inputs' ) )
            // InternalBot.g:5627:1: ( 'inputs' )
            {
            // InternalBot.g:5627:1: ( 'inputs' )
            // InternalBot.g:5628:2: 'inputs'
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBot.g:5637:1: rule__SLanguageInput__Group_0__1 : rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2 ;
    public final void rule__SLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5641:1: ( rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2 )
            // InternalBot.g:5642:2: rule__SLanguageInput__Group_0__1__Impl rule__SLanguageInput__Group_0__2
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
    // InternalBot.g:5649:1: rule__SLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__SLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5653:1: ( ( 'in' ) )
            // InternalBot.g:5654:1: ( 'in' )
            {
            // InternalBot.g:5654:1: ( 'in' )
            // InternalBot.g:5655:2: 'in'
            {
             before(grammarAccess.getSLanguageInputAccess().getInKeyword_0_1()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:5664:1: rule__SLanguageInput__Group_0__2 : rule__SLanguageInput__Group_0__2__Impl ;
    public final void rule__SLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5668:1: ( rule__SLanguageInput__Group_0__2__Impl )
            // InternalBot.g:5669:2: rule__SLanguageInput__Group_0__2__Impl
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
    // InternalBot.g:5675:1: rule__SLanguageInput__Group_0__2__Impl : ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__SLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5679:1: ( ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:5680:1: ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:5680:1: ( ( rule__SLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:5681:2: ( rule__SLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getSLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:5682:2: ( rule__SLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:5682:3: rule__SLanguageInput__LanguageAssignment_0_2
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
    // InternalBot.g:5691:1: rule__SLanguageInput__Group_2__0 : rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1 ;
    public final void rule__SLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5695:1: ( rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1 )
            // InternalBot.g:5696:2: rule__SLanguageInput__Group_2__0__Impl rule__SLanguageInput__Group_2__1
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
    // InternalBot.g:5703:1: rule__SLanguageInput__Group_2__0__Impl : ( ( rule__SLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__SLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5707:1: ( ( ( rule__SLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:5708:1: ( ( rule__SLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:5708:1: ( ( rule__SLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:5709:2: ( rule__SLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:5710:2: ( rule__SLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:5710:3: rule__SLanguageInput__InputsAssignment_2_0
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
    // InternalBot.g:5718:1: rule__SLanguageInput__Group_2__1 : rule__SLanguageInput__Group_2__1__Impl ;
    public final void rule__SLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5722:1: ( rule__SLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5723:2: rule__SLanguageInput__Group_2__1__Impl
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
    // InternalBot.g:5729:1: rule__SLanguageInput__Group_2__1__Impl : ( ( rule__SLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__SLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5733:1: ( ( ( rule__SLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5734:1: ( ( rule__SLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5734:1: ( ( rule__SLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5735:2: ( rule__SLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getSLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5736:2: ( rule__SLanguageInput__InputsAssignment_2_1 )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=RULE_STRING && LA54_0<=RULE_ID)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:5736:3: rule__SLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__SLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // InternalBot.g:5745:1: rule__CLanguageInput__Group__0 : rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1 ;
    public final void rule__CLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5749:1: ( rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1 )
            // InternalBot.g:5750:2: rule__CLanguageInput__Group__0__Impl rule__CLanguageInput__Group__1
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
    // InternalBot.g:5757:1: rule__CLanguageInput__Group__0__Impl : ( ( rule__CLanguageInput__Group_0__0 )? ) ;
    public final void rule__CLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5761:1: ( ( ( rule__CLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:5762:1: ( ( rule__CLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:5762:1: ( ( rule__CLanguageInput__Group_0__0 )? )
            // InternalBot.g:5763:2: ( rule__CLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:5764:2: ( rule__CLanguageInput__Group_0__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==63) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:5764:3: rule__CLanguageInput__Group_0__0
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
    // InternalBot.g:5772:1: rule__CLanguageInput__Group__1 : rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2 ;
    public final void rule__CLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5776:1: ( rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2 )
            // InternalBot.g:5777:2: rule__CLanguageInput__Group__1__Impl rule__CLanguageInput__Group__2
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
    // InternalBot.g:5784:1: rule__CLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__CLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5788:1: ( ( '{' ) )
            // InternalBot.g:5789:1: ( '{' )
            {
            // InternalBot.g:5789:1: ( '{' )
            // InternalBot.g:5790:2: '{'
            {
             before(grammarAccess.getCLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:5799:1: rule__CLanguageInput__Group__2 : rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3 ;
    public final void rule__CLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5803:1: ( rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3 )
            // InternalBot.g:5804:2: rule__CLanguageInput__Group__2__Impl rule__CLanguageInput__Group__3
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
    // InternalBot.g:5811:1: rule__CLanguageInput__Group__2__Impl : ( ( rule__CLanguageInput__Group_2__0 ) ) ;
    public final void rule__CLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5815:1: ( ( ( rule__CLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:5816:1: ( ( rule__CLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:5816:1: ( ( rule__CLanguageInput__Group_2__0 ) )
            // InternalBot.g:5817:2: ( rule__CLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:5818:2: ( rule__CLanguageInput__Group_2__0 )
            // InternalBot.g:5818:3: rule__CLanguageInput__Group_2__0
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
    // InternalBot.g:5826:1: rule__CLanguageInput__Group__3 : rule__CLanguageInput__Group__3__Impl ;
    public final void rule__CLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5830:1: ( rule__CLanguageInput__Group__3__Impl )
            // InternalBot.g:5831:2: rule__CLanguageInput__Group__3__Impl
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
    // InternalBot.g:5837:1: rule__CLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__CLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5841:1: ( ( '}' ) )
            // InternalBot.g:5842:1: ( '}' )
            {
            // InternalBot.g:5842:1: ( '}' )
            // InternalBot.g:5843:2: '}'
            {
             before(grammarAccess.getCLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:5853:1: rule__CLanguageInput__Group_0__0 : rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1 ;
    public final void rule__CLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5857:1: ( rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1 )
            // InternalBot.g:5858:2: rule__CLanguageInput__Group_0__0__Impl rule__CLanguageInput__Group_0__1
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
    // InternalBot.g:5865:1: rule__CLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__CLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5869:1: ( ( 'inputs' ) )
            // InternalBot.g:5870:1: ( 'inputs' )
            {
            // InternalBot.g:5870:1: ( 'inputs' )
            // InternalBot.g:5871:2: 'inputs'
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBot.g:5880:1: rule__CLanguageInput__Group_0__1 : rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2 ;
    public final void rule__CLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5884:1: ( rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2 )
            // InternalBot.g:5885:2: rule__CLanguageInput__Group_0__1__Impl rule__CLanguageInput__Group_0__2
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
    // InternalBot.g:5892:1: rule__CLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__CLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5896:1: ( ( 'in' ) )
            // InternalBot.g:5897:1: ( 'in' )
            {
            // InternalBot.g:5897:1: ( 'in' )
            // InternalBot.g:5898:2: 'in'
            {
             before(grammarAccess.getCLanguageInputAccess().getInKeyword_0_1()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:5907:1: rule__CLanguageInput__Group_0__2 : rule__CLanguageInput__Group_0__2__Impl ;
    public final void rule__CLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5911:1: ( rule__CLanguageInput__Group_0__2__Impl )
            // InternalBot.g:5912:2: rule__CLanguageInput__Group_0__2__Impl
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
    // InternalBot.g:5918:1: rule__CLanguageInput__Group_0__2__Impl : ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__CLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5922:1: ( ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:5923:1: ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:5923:1: ( ( rule__CLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:5924:2: ( rule__CLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getCLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:5925:2: ( rule__CLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:5925:3: rule__CLanguageInput__LanguageAssignment_0_2
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
    // InternalBot.g:5934:1: rule__CLanguageInput__Group_2__0 : rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1 ;
    public final void rule__CLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5938:1: ( rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1 )
            // InternalBot.g:5939:2: rule__CLanguageInput__Group_2__0__Impl rule__CLanguageInput__Group_2__1
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
    // InternalBot.g:5946:1: rule__CLanguageInput__Group_2__0__Impl : ( ( rule__CLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__CLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5950:1: ( ( ( rule__CLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:5951:1: ( ( rule__CLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:5951:1: ( ( rule__CLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:5952:2: ( rule__CLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:5953:2: ( rule__CLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:5953:3: rule__CLanguageInput__InputsAssignment_2_0
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
    // InternalBot.g:5961:1: rule__CLanguageInput__Group_2__1 : rule__CLanguageInput__Group_2__1__Impl ;
    public final void rule__CLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5965:1: ( rule__CLanguageInput__Group_2__1__Impl )
            // InternalBot.g:5966:2: rule__CLanguageInput__Group_2__1__Impl
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
    // InternalBot.g:5972:1: rule__CLanguageInput__Group_2__1__Impl : ( ( rule__CLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__CLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5976:1: ( ( ( rule__CLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:5977:1: ( ( rule__CLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:5977:1: ( ( rule__CLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:5978:2: ( rule__CLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getCLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:5979:2: ( rule__CLanguageInput__InputsAssignment_2_1 )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==83) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBot.g:5979:3: rule__CLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__CLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // InternalBot.g:5988:1: rule__RLanguageInput__Group__0 : rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1 ;
    public final void rule__RLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:5992:1: ( rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1 )
            // InternalBot.g:5993:2: rule__RLanguageInput__Group__0__Impl rule__RLanguageInput__Group__1
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
    // InternalBot.g:6000:1: rule__RLanguageInput__Group__0__Impl : ( ( rule__RLanguageInput__Group_0__0 )? ) ;
    public final void rule__RLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6004:1: ( ( ( rule__RLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:6005:1: ( ( rule__RLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:6005:1: ( ( rule__RLanguageInput__Group_0__0 )? )
            // InternalBot.g:6006:2: ( rule__RLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:6007:2: ( rule__RLanguageInput__Group_0__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==63) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalBot.g:6007:3: rule__RLanguageInput__Group_0__0
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
    // InternalBot.g:6015:1: rule__RLanguageInput__Group__1 : rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2 ;
    public final void rule__RLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6019:1: ( rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2 )
            // InternalBot.g:6020:2: rule__RLanguageInput__Group__1__Impl rule__RLanguageInput__Group__2
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
    // InternalBot.g:6027:1: rule__RLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__RLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6031:1: ( ( '{' ) )
            // InternalBot.g:6032:1: ( '{' )
            {
            // InternalBot.g:6032:1: ( '{' )
            // InternalBot.g:6033:2: '{'
            {
             before(grammarAccess.getRLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:6042:1: rule__RLanguageInput__Group__2 : rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3 ;
    public final void rule__RLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6046:1: ( rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3 )
            // InternalBot.g:6047:2: rule__RLanguageInput__Group__2__Impl rule__RLanguageInput__Group__3
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
    // InternalBot.g:6054:1: rule__RLanguageInput__Group__2__Impl : ( ( rule__RLanguageInput__Group_2__0 ) ) ;
    public final void rule__RLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6058:1: ( ( ( rule__RLanguageInput__Group_2__0 ) ) )
            // InternalBot.g:6059:1: ( ( rule__RLanguageInput__Group_2__0 ) )
            {
            // InternalBot.g:6059:1: ( ( rule__RLanguageInput__Group_2__0 ) )
            // InternalBot.g:6060:2: ( rule__RLanguageInput__Group_2__0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getGroup_2()); 
            // InternalBot.g:6061:2: ( rule__RLanguageInput__Group_2__0 )
            // InternalBot.g:6061:3: rule__RLanguageInput__Group_2__0
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
    // InternalBot.g:6069:1: rule__RLanguageInput__Group__3 : rule__RLanguageInput__Group__3__Impl ;
    public final void rule__RLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6073:1: ( rule__RLanguageInput__Group__3__Impl )
            // InternalBot.g:6074:2: rule__RLanguageInput__Group__3__Impl
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
    // InternalBot.g:6080:1: rule__RLanguageInput__Group__3__Impl : ( '}' ) ;
    public final void rule__RLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6084:1: ( ( '}' ) )
            // InternalBot.g:6085:1: ( '}' )
            {
            // InternalBot.g:6085:1: ( '}' )
            // InternalBot.g:6086:2: '}'
            {
             before(grammarAccess.getRLanguageInputAccess().getRightCurlyBracketKeyword_3()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:6096:1: rule__RLanguageInput__Group_0__0 : rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1 ;
    public final void rule__RLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6100:1: ( rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1 )
            // InternalBot.g:6101:2: rule__RLanguageInput__Group_0__0__Impl rule__RLanguageInput__Group_0__1
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
    // InternalBot.g:6108:1: rule__RLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__RLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6112:1: ( ( 'inputs' ) )
            // InternalBot.g:6113:1: ( 'inputs' )
            {
            // InternalBot.g:6113:1: ( 'inputs' )
            // InternalBot.g:6114:2: 'inputs'
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBot.g:6123:1: rule__RLanguageInput__Group_0__1 : rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2 ;
    public final void rule__RLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6127:1: ( rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2 )
            // InternalBot.g:6128:2: rule__RLanguageInput__Group_0__1__Impl rule__RLanguageInput__Group_0__2
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
    // InternalBot.g:6135:1: rule__RLanguageInput__Group_0__1__Impl : ( 'in' ) ;
    public final void rule__RLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6139:1: ( ( 'in' ) )
            // InternalBot.g:6140:1: ( 'in' )
            {
            // InternalBot.g:6140:1: ( 'in' )
            // InternalBot.g:6141:2: 'in'
            {
             before(grammarAccess.getRLanguageInputAccess().getInKeyword_0_1()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:6150:1: rule__RLanguageInput__Group_0__2 : rule__RLanguageInput__Group_0__2__Impl ;
    public final void rule__RLanguageInput__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6154:1: ( rule__RLanguageInput__Group_0__2__Impl )
            // InternalBot.g:6155:2: rule__RLanguageInput__Group_0__2__Impl
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
    // InternalBot.g:6161:1: rule__RLanguageInput__Group_0__2__Impl : ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) ) ;
    public final void rule__RLanguageInput__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6165:1: ( ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) ) )
            // InternalBot.g:6166:1: ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) )
            {
            // InternalBot.g:6166:1: ( ( rule__RLanguageInput__LanguageAssignment_0_2 ) )
            // InternalBot.g:6167:2: ( rule__RLanguageInput__LanguageAssignment_0_2 )
            {
             before(grammarAccess.getRLanguageInputAccess().getLanguageAssignment_0_2()); 
            // InternalBot.g:6168:2: ( rule__RLanguageInput__LanguageAssignment_0_2 )
            // InternalBot.g:6168:3: rule__RLanguageInput__LanguageAssignment_0_2
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
    // InternalBot.g:6177:1: rule__RLanguageInput__Group_2__0 : rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1 ;
    public final void rule__RLanguageInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6181:1: ( rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1 )
            // InternalBot.g:6182:2: rule__RLanguageInput__Group_2__0__Impl rule__RLanguageInput__Group_2__1
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
    // InternalBot.g:6189:1: rule__RLanguageInput__Group_2__0__Impl : ( ( rule__RLanguageInput__InputsAssignment_2_0 ) ) ;
    public final void rule__RLanguageInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6193:1: ( ( ( rule__RLanguageInput__InputsAssignment_2_0 ) ) )
            // InternalBot.g:6194:1: ( ( rule__RLanguageInput__InputsAssignment_2_0 ) )
            {
            // InternalBot.g:6194:1: ( ( rule__RLanguageInput__InputsAssignment_2_0 ) )
            // InternalBot.g:6195:2: ( rule__RLanguageInput__InputsAssignment_2_0 )
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_0()); 
            // InternalBot.g:6196:2: ( rule__RLanguageInput__InputsAssignment_2_0 )
            // InternalBot.g:6196:3: rule__RLanguageInput__InputsAssignment_2_0
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
    // InternalBot.g:6204:1: rule__RLanguageInput__Group_2__1 : rule__RLanguageInput__Group_2__1__Impl ;
    public final void rule__RLanguageInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6208:1: ( rule__RLanguageInput__Group_2__1__Impl )
            // InternalBot.g:6209:2: rule__RLanguageInput__Group_2__1__Impl
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
    // InternalBot.g:6215:1: rule__RLanguageInput__Group_2__1__Impl : ( ( rule__RLanguageInput__InputsAssignment_2_1 )* ) ;
    public final void rule__RLanguageInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6219:1: ( ( ( rule__RLanguageInput__InputsAssignment_2_1 )* ) )
            // InternalBot.g:6220:1: ( ( rule__RLanguageInput__InputsAssignment_2_1 )* )
            {
            // InternalBot.g:6220:1: ( ( rule__RLanguageInput__InputsAssignment_2_1 )* )
            // InternalBot.g:6221:2: ( rule__RLanguageInput__InputsAssignment_2_1 )*
            {
             before(grammarAccess.getRLanguageInputAccess().getInputsAssignment_2_1()); 
            // InternalBot.g:6222:2: ( rule__RLanguageInput__InputsAssignment_2_1 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==82) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalBot.g:6222:3: rule__RLanguageInput__InputsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_56);
            	    rule__RLanguageInput__InputsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // InternalBot.g:6231:1: rule__RegexInput__Group__0 : rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 ;
    public final void rule__RegexInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6235:1: ( rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1 )
            // InternalBot.g:6236:2: rule__RegexInput__Group__0__Impl rule__RegexInput__Group__1
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
    // InternalBot.g:6243:1: rule__RegexInput__Group__0__Impl : ( () ) ;
    public final void rule__RegexInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6247:1: ( ( () ) )
            // InternalBot.g:6248:1: ( () )
            {
            // InternalBot.g:6248:1: ( () )
            // InternalBot.g:6249:2: ()
            {
             before(grammarAccess.getRegexInputAccess().getRegexInputAction_0()); 
            // InternalBot.g:6250:2: ()
            // InternalBot.g:6250:3: 
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
    // InternalBot.g:6258:1: rule__RegexInput__Group__1 : rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 ;
    public final void rule__RegexInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6262:1: ( rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2 )
            // InternalBot.g:6263:2: rule__RegexInput__Group__1__Impl rule__RegexInput__Group__2
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
    // InternalBot.g:6270:1: rule__RegexInput__Group__1__Impl : ( 'pattern' ) ;
    public final void rule__RegexInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6274:1: ( ( 'pattern' ) )
            // InternalBot.g:6275:1: ( 'pattern' )
            {
            // InternalBot.g:6275:1: ( 'pattern' )
            // InternalBot.g:6276:2: 'pattern'
            {
             before(grammarAccess.getRegexInputAccess().getPatternKeyword_1()); 
            match(input,82,FOLLOW_2); 
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
    // InternalBot.g:6285:1: rule__RegexInput__Group__2 : rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 ;
    public final void rule__RegexInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6289:1: ( rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3 )
            // InternalBot.g:6290:2: rule__RegexInput__Group__2__Impl rule__RegexInput__Group__3
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
    // InternalBot.g:6297:1: rule__RegexInput__Group__2__Impl : ( ':' ) ;
    public final void rule__RegexInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6301:1: ( ( ':' ) )
            // InternalBot.g:6302:1: ( ':' )
            {
            // InternalBot.g:6302:1: ( ':' )
            // InternalBot.g:6303:2: ':'
            {
             before(grammarAccess.getRegexInputAccess().getColonKeyword_2()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:6312:1: rule__RegexInput__Group__3 : rule__RegexInput__Group__3__Impl ;
    public final void rule__RegexInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6316:1: ( rule__RegexInput__Group__3__Impl )
            // InternalBot.g:6317:2: rule__RegexInput__Group__3__Impl
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
    // InternalBot.g:6323:1: rule__RegexInput__Group__3__Impl : ( ( rule__RegexInput__ExpresionAssignment_3 ) ) ;
    public final void rule__RegexInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6327:1: ( ( ( rule__RegexInput__ExpresionAssignment_3 ) ) )
            // InternalBot.g:6328:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            {
            // InternalBot.g:6328:1: ( ( rule__RegexInput__ExpresionAssignment_3 ) )
            // InternalBot.g:6329:2: ( rule__RegexInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getRegexInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6330:2: ( rule__RegexInput__ExpresionAssignment_3 )
            // InternalBot.g:6330:3: rule__RegexInput__ExpresionAssignment_3
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
    // InternalBot.g:6339:1: rule__CompositeInput__Group__0 : rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 ;
    public final void rule__CompositeInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6343:1: ( rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1 )
            // InternalBot.g:6344:2: rule__CompositeInput__Group__0__Impl rule__CompositeInput__Group__1
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
    // InternalBot.g:6351:1: rule__CompositeInput__Group__0__Impl : ( () ) ;
    public final void rule__CompositeInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6355:1: ( ( () ) )
            // InternalBot.g:6356:1: ( () )
            {
            // InternalBot.g:6356:1: ( () )
            // InternalBot.g:6357:2: ()
            {
             before(grammarAccess.getCompositeInputAccess().getCompositeInputAction_0()); 
            // InternalBot.g:6358:2: ()
            // InternalBot.g:6358:3: 
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
    // InternalBot.g:6366:1: rule__CompositeInput__Group__1 : rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 ;
    public final void rule__CompositeInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6370:1: ( rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2 )
            // InternalBot.g:6371:2: rule__CompositeInput__Group__1__Impl rule__CompositeInput__Group__2
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
    // InternalBot.g:6378:1: rule__CompositeInput__Group__1__Impl : ( 'composite' ) ;
    public final void rule__CompositeInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6382:1: ( ( 'composite' ) )
            // InternalBot.g:6383:1: ( 'composite' )
            {
            // InternalBot.g:6383:1: ( 'composite' )
            // InternalBot.g:6384:2: 'composite'
            {
             before(grammarAccess.getCompositeInputAccess().getCompositeKeyword_1()); 
            match(input,83,FOLLOW_2); 
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
    // InternalBot.g:6393:1: rule__CompositeInput__Group__2 : rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 ;
    public final void rule__CompositeInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6397:1: ( rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3 )
            // InternalBot.g:6398:2: rule__CompositeInput__Group__2__Impl rule__CompositeInput__Group__3
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
    // InternalBot.g:6405:1: rule__CompositeInput__Group__2__Impl : ( ':' ) ;
    public final void rule__CompositeInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6409:1: ( ( ':' ) )
            // InternalBot.g:6410:1: ( ':' )
            {
            // InternalBot.g:6410:1: ( ':' )
            // InternalBot.g:6411:2: ':'
            {
             before(grammarAccess.getCompositeInputAccess().getColonKeyword_2()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:6420:1: rule__CompositeInput__Group__3 : rule__CompositeInput__Group__3__Impl ;
    public final void rule__CompositeInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6424:1: ( rule__CompositeInput__Group__3__Impl )
            // InternalBot.g:6425:2: rule__CompositeInput__Group__3__Impl
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
    // InternalBot.g:6431:1: rule__CompositeInput__Group__3__Impl : ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) ;
    public final void rule__CompositeInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6435:1: ( ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) ) )
            // InternalBot.g:6436:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            {
            // InternalBot.g:6436:1: ( ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* ) )
            // InternalBot.g:6437:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) ) ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            {
            // InternalBot.g:6437:2: ( ( rule__CompositeInput__ExpresionAssignment_3 ) )
            // InternalBot.g:6438:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6439:3: ( rule__CompositeInput__ExpresionAssignment_3 )
            // InternalBot.g:6439:4: rule__CompositeInput__ExpresionAssignment_3
            {
            pushFollow(FOLLOW_58);
            rule__CompositeInput__ExpresionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 

            }

            // InternalBot.g:6442:2: ( ( rule__CompositeInput__ExpresionAssignment_3 )* )
            // InternalBot.g:6443:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAssignment_3()); 
            // InternalBot.g:6444:3: ( rule__CompositeInput__ExpresionAssignment_3 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( ((LA59_0>=RULE_STRING && LA59_0<=RULE_ID)||LA59_0==74) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBot.g:6444:4: rule__CompositeInput__ExpresionAssignment_3
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__CompositeInput__ExpresionAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
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
    // InternalBot.g:6454:1: rule__SimpleInput__Group__0 : rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 ;
    public final void rule__SimpleInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6458:1: ( rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1 )
            // InternalBot.g:6459:2: rule__SimpleInput__Group__0__Impl rule__SimpleInput__Group__1
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
    // InternalBot.g:6466:1: rule__SimpleInput__Group__0__Impl : ( () ) ;
    public final void rule__SimpleInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6470:1: ( ( () ) )
            // InternalBot.g:6471:1: ( () )
            {
            // InternalBot.g:6471:1: ( () )
            // InternalBot.g:6472:2: ()
            {
             before(grammarAccess.getSimpleInputAccess().getSimpleInputAction_0()); 
            // InternalBot.g:6473:2: ()
            // InternalBot.g:6473:3: 
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
    // InternalBot.g:6481:1: rule__SimpleInput__Group__1 : rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 ;
    public final void rule__SimpleInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6485:1: ( rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2 )
            // InternalBot.g:6486:2: rule__SimpleInput__Group__1__Impl rule__SimpleInput__Group__2
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
    // InternalBot.g:6493:1: rule__SimpleInput__Group__1__Impl : ( ( rule__SimpleInput__NameAssignment_1 ) ) ;
    public final void rule__SimpleInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6497:1: ( ( ( rule__SimpleInput__NameAssignment_1 ) ) )
            // InternalBot.g:6498:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            {
            // InternalBot.g:6498:1: ( ( rule__SimpleInput__NameAssignment_1 ) )
            // InternalBot.g:6499:2: ( rule__SimpleInput__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getNameAssignment_1()); 
            // InternalBot.g:6500:2: ( rule__SimpleInput__NameAssignment_1 )
            // InternalBot.g:6500:3: rule__SimpleInput__NameAssignment_1
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
    // InternalBot.g:6508:1: rule__SimpleInput__Group__2 : rule__SimpleInput__Group__2__Impl ;
    public final void rule__SimpleInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6512:1: ( rule__SimpleInput__Group__2__Impl )
            // InternalBot.g:6513:2: rule__SimpleInput__Group__2__Impl
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
    // InternalBot.g:6519:1: rule__SimpleInput__Group__2__Impl : ( ( rule__SimpleInput__Group_2__0 )? ) ;
    public final void rule__SimpleInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6523:1: ( ( ( rule__SimpleInput__Group_2__0 )? ) )
            // InternalBot.g:6524:1: ( ( rule__SimpleInput__Group_2__0 )? )
            {
            // InternalBot.g:6524:1: ( ( rule__SimpleInput__Group_2__0 )? )
            // InternalBot.g:6525:2: ( rule__SimpleInput__Group_2__0 )?
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2()); 
            // InternalBot.g:6526:2: ( rule__SimpleInput__Group_2__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==84) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalBot.g:6526:3: rule__SimpleInput__Group_2__0
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
    // InternalBot.g:6535:1: rule__SimpleInput__Group_2__0 : rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 ;
    public final void rule__SimpleInput__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6539:1: ( rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1 )
            // InternalBot.g:6540:2: rule__SimpleInput__Group_2__0__Impl rule__SimpleInput__Group_2__1
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
    // InternalBot.g:6547:1: rule__SimpleInput__Group_2__0__Impl : ( 'synonyms' ) ;
    public final void rule__SimpleInput__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6551:1: ( ( 'synonyms' ) )
            // InternalBot.g:6552:1: ( 'synonyms' )
            {
            // InternalBot.g:6552:1: ( 'synonyms' )
            // InternalBot.g:6553:2: 'synonyms'
            {
             before(grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0()); 
            match(input,84,FOLLOW_2); 
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
    // InternalBot.g:6562:1: rule__SimpleInput__Group_2__1 : rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 ;
    public final void rule__SimpleInput__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6566:1: ( rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2 )
            // InternalBot.g:6567:2: rule__SimpleInput__Group_2__1__Impl rule__SimpleInput__Group_2__2
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
    // InternalBot.g:6574:1: rule__SimpleInput__Group_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6578:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_1 ) ) )
            // InternalBot.g:6579:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            {
            // InternalBot.g:6579:1: ( ( rule__SimpleInput__ValuesAssignment_2_1 ) )
            // InternalBot.g:6580:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_1()); 
            // InternalBot.g:6581:2: ( rule__SimpleInput__ValuesAssignment_2_1 )
            // InternalBot.g:6581:3: rule__SimpleInput__ValuesAssignment_2_1
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
    // InternalBot.g:6589:1: rule__SimpleInput__Group_2__2 : rule__SimpleInput__Group_2__2__Impl ;
    public final void rule__SimpleInput__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6593:1: ( rule__SimpleInput__Group_2__2__Impl )
            // InternalBot.g:6594:2: rule__SimpleInput__Group_2__2__Impl
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
    // InternalBot.g:6600:1: rule__SimpleInput__Group_2__2__Impl : ( ( rule__SimpleInput__Group_2_2__0 )* ) ;
    public final void rule__SimpleInput__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6604:1: ( ( ( rule__SimpleInput__Group_2_2__0 )* ) )
            // InternalBot.g:6605:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            {
            // InternalBot.g:6605:1: ( ( rule__SimpleInput__Group_2_2__0 )* )
            // InternalBot.g:6606:2: ( rule__SimpleInput__Group_2_2__0 )*
            {
             before(grammarAccess.getSimpleInputAccess().getGroup_2_2()); 
            // InternalBot.g:6607:2: ( rule__SimpleInput__Group_2_2__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==57) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBot.g:6607:3: rule__SimpleInput__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__SimpleInput__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
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
    // InternalBot.g:6616:1: rule__SimpleInput__Group_2_2__0 : rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 ;
    public final void rule__SimpleInput__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6620:1: ( rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1 )
            // InternalBot.g:6621:2: rule__SimpleInput__Group_2_2__0__Impl rule__SimpleInput__Group_2_2__1
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
    // InternalBot.g:6628:1: rule__SimpleInput__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__SimpleInput__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6632:1: ( ( ',' ) )
            // InternalBot.g:6633:1: ( ',' )
            {
            // InternalBot.g:6633:1: ( ',' )
            // InternalBot.g:6634:2: ','
            {
             before(grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:6643:1: rule__SimpleInput__Group_2_2__1 : rule__SimpleInput__Group_2_2__1__Impl ;
    public final void rule__SimpleInput__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6647:1: ( rule__SimpleInput__Group_2_2__1__Impl )
            // InternalBot.g:6648:2: rule__SimpleInput__Group_2_2__1__Impl
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
    // InternalBot.g:6654:1: rule__SimpleInput__Group_2_2__1__Impl : ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) ;
    public final void rule__SimpleInput__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6658:1: ( ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) ) )
            // InternalBot.g:6659:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            {
            // InternalBot.g:6659:1: ( ( rule__SimpleInput__ValuesAssignment_2_2_1 ) )
            // InternalBot.g:6660:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            {
             before(grammarAccess.getSimpleInputAccess().getValuesAssignment_2_2_1()); 
            // InternalBot.g:6661:2: ( rule__SimpleInput__ValuesAssignment_2_2_1 )
            // InternalBot.g:6661:3: rule__SimpleInput__ValuesAssignment_2_2_1
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
    // InternalBot.g:6670:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6674:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalBot.g:6675:2: rule__Text__Group__0__Impl rule__Text__Group__1
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
    // InternalBot.g:6682:1: rule__Text__Group__0__Impl : ( ( rule__Text__Alternatives_0 ) ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6686:1: ( ( ( rule__Text__Alternatives_0 ) ) )
            // InternalBot.g:6687:1: ( ( rule__Text__Alternatives_0 ) )
            {
            // InternalBot.g:6687:1: ( ( rule__Text__Alternatives_0 ) )
            // InternalBot.g:6688:2: ( rule__Text__Alternatives_0 )
            {
             before(grammarAccess.getTextAccess().getAlternatives_0()); 
            // InternalBot.g:6689:2: ( rule__Text__Alternatives_0 )
            // InternalBot.g:6689:3: rule__Text__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Text__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalBot.g:6697:1: rule__Text__Group__1 : rule__Text__Group__1__Impl rule__Text__Group__2 ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6701:1: ( rule__Text__Group__1__Impl rule__Text__Group__2 )
            // InternalBot.g:6702:2: rule__Text__Group__1__Impl rule__Text__Group__2
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
    // InternalBot.g:6709:1: rule__Text__Group__1__Impl : ( 'response' ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6713:1: ( ( 'response' ) )
            // InternalBot.g:6714:1: ( 'response' )
            {
            // InternalBot.g:6714:1: ( 'response' )
            // InternalBot.g:6715:2: 'response'
            {
             before(grammarAccess.getTextAccess().getResponseKeyword_1()); 
            match(input,85,FOLLOW_2); 
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
    // InternalBot.g:6724:1: rule__Text__Group__2 : rule__Text__Group__2__Impl rule__Text__Group__3 ;
    public final void rule__Text__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6728:1: ( rule__Text__Group__2__Impl rule__Text__Group__3 )
            // InternalBot.g:6729:2: rule__Text__Group__2__Impl rule__Text__Group__3
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
    // InternalBot.g:6736:1: rule__Text__Group__2__Impl : ( ( rule__Text__NameAssignment_2 ) ) ;
    public final void rule__Text__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6740:1: ( ( ( rule__Text__NameAssignment_2 ) ) )
            // InternalBot.g:6741:1: ( ( rule__Text__NameAssignment_2 ) )
            {
            // InternalBot.g:6741:1: ( ( rule__Text__NameAssignment_2 ) )
            // InternalBot.g:6742:2: ( rule__Text__NameAssignment_2 )
            {
             before(grammarAccess.getTextAccess().getNameAssignment_2()); 
            // InternalBot.g:6743:2: ( rule__Text__NameAssignment_2 )
            // InternalBot.g:6743:3: rule__Text__NameAssignment_2
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
    // InternalBot.g:6751:1: rule__Text__Group__3 : rule__Text__Group__3__Impl rule__Text__Group__4 ;
    public final void rule__Text__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6755:1: ( rule__Text__Group__3__Impl rule__Text__Group__4 )
            // InternalBot.g:6756:2: rule__Text__Group__3__Impl rule__Text__Group__4
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
    // InternalBot.g:6763:1: rule__Text__Group__3__Impl : ( ':' ) ;
    public final void rule__Text__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6767:1: ( ( ':' ) )
            // InternalBot.g:6768:1: ( ':' )
            {
            // InternalBot.g:6768:1: ( ':' )
            // InternalBot.g:6769:2: ':'
            {
             before(grammarAccess.getTextAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:6778:1: rule__Text__Group__4 : rule__Text__Group__4__Impl ;
    public final void rule__Text__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6782:1: ( rule__Text__Group__4__Impl )
            // InternalBot.g:6783:2: rule__Text__Group__4__Impl
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
    // InternalBot.g:6789:1: rule__Text__Group__4__Impl : ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) ;
    public final void rule__Text__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6793:1: ( ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) ) )
            // InternalBot.g:6794:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            {
            // InternalBot.g:6794:1: ( ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* ) )
            // InternalBot.g:6795:2: ( ( rule__Text__InputsAssignment_4 ) ) ( ( rule__Text__InputsAssignment_4 )* )
            {
            // InternalBot.g:6795:2: ( ( rule__Text__InputsAssignment_4 ) )
            // InternalBot.g:6796:3: ( rule__Text__InputsAssignment_4 )
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:6797:3: ( rule__Text__InputsAssignment_4 )
            // InternalBot.g:6797:4: rule__Text__InputsAssignment_4
            {
            pushFollow(FOLLOW_52);
            rule__Text__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getInputsAssignment_4()); 

            }

            // InternalBot.g:6800:2: ( ( rule__Text__InputsAssignment_4 )* )
            // InternalBot.g:6801:3: ( rule__Text__InputsAssignment_4 )*
            {
             before(grammarAccess.getTextAccess().getInputsAssignment_4()); 
            // InternalBot.g:6802:3: ( rule__Text__InputsAssignment_4 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=63 && LA62_0<=64)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBot.g:6802:4: rule__Text__InputsAssignment_4
            	    {
            	    pushFollow(FOLLOW_52);
            	    rule__Text__InputsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
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
    // InternalBot.g:6812:1: rule__TextLanguageInput__Group__0 : rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 ;
    public final void rule__TextLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6816:1: ( rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1 )
            // InternalBot.g:6817:2: rule__TextLanguageInput__Group__0__Impl rule__TextLanguageInput__Group__1
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
    // InternalBot.g:6824:1: rule__TextLanguageInput__Group__0__Impl : ( ( rule__TextLanguageInput__Group_0__0 )? ) ;
    public final void rule__TextLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6828:1: ( ( ( rule__TextLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:6829:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:6829:1: ( ( rule__TextLanguageInput__Group_0__0 )? )
            // InternalBot.g:6830:2: ( rule__TextLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:6831:2: ( rule__TextLanguageInput__Group_0__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==63) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalBot.g:6831:3: rule__TextLanguageInput__Group_0__0
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
    // InternalBot.g:6839:1: rule__TextLanguageInput__Group__1 : rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 ;
    public final void rule__TextLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6843:1: ( rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2 )
            // InternalBot.g:6844:2: rule__TextLanguageInput__Group__1__Impl rule__TextLanguageInput__Group__2
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
    // InternalBot.g:6851:1: rule__TextLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__TextLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6855:1: ( ( '{' ) )
            // InternalBot.g:6856:1: ( '{' )
            {
            // InternalBot.g:6856:1: ( '{' )
            // InternalBot.g:6857:2: '{'
            {
             before(grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:6866:1: rule__TextLanguageInput__Group__2 : rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 ;
    public final void rule__TextLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6870:1: ( rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3 )
            // InternalBot.g:6871:2: rule__TextLanguageInput__Group__2__Impl rule__TextLanguageInput__Group__3
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
    // InternalBot.g:6878:1: rule__TextLanguageInput__Group__2__Impl : ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) ;
    public final void rule__TextLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6882:1: ( ( ( rule__TextLanguageInput__InputsAssignment_2 ) ) )
            // InternalBot.g:6883:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            {
            // InternalBot.g:6883:1: ( ( rule__TextLanguageInput__InputsAssignment_2 ) )
            // InternalBot.g:6884:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_2()); 
            // InternalBot.g:6885:2: ( rule__TextLanguageInput__InputsAssignment_2 )
            // InternalBot.g:6885:3: rule__TextLanguageInput__InputsAssignment_2
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
    // InternalBot.g:6893:1: rule__TextLanguageInput__Group__3 : rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 ;
    public final void rule__TextLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6897:1: ( rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4 )
            // InternalBot.g:6898:2: rule__TextLanguageInput__Group__3__Impl rule__TextLanguageInput__Group__4
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
    // InternalBot.g:6905:1: rule__TextLanguageInput__Group__3__Impl : ( ( rule__TextLanguageInput__Group_3__0 )* ) ;
    public final void rule__TextLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6909:1: ( ( ( rule__TextLanguageInput__Group_3__0 )* ) )
            // InternalBot.g:6910:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            {
            // InternalBot.g:6910:1: ( ( rule__TextLanguageInput__Group_3__0 )* )
            // InternalBot.g:6911:2: ( rule__TextLanguageInput__Group_3__0 )*
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_3()); 
            // InternalBot.g:6912:2: ( rule__TextLanguageInput__Group_3__0 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==57) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBot.g:6912:3: rule__TextLanguageInput__Group_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__TextLanguageInput__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // InternalBot.g:6920:1: rule__TextLanguageInput__Group__4 : rule__TextLanguageInput__Group__4__Impl ;
    public final void rule__TextLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6924:1: ( rule__TextLanguageInput__Group__4__Impl )
            // InternalBot.g:6925:2: rule__TextLanguageInput__Group__4__Impl
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
    // InternalBot.g:6931:1: rule__TextLanguageInput__Group__4__Impl : ( '}' ) ;
    public final void rule__TextLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6935:1: ( ( '}' ) )
            // InternalBot.g:6936:1: ( '}' )
            {
            // InternalBot.g:6936:1: ( '}' )
            // InternalBot.g:6937:2: '}'
            {
             before(grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:6947:1: rule__TextLanguageInput__Group_0__0 : rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 ;
    public final void rule__TextLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6951:1: ( rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1 )
            // InternalBot.g:6952:2: rule__TextLanguageInput__Group_0__0__Impl rule__TextLanguageInput__Group_0__1
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
    // InternalBot.g:6959:1: rule__TextLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6963:1: ( ( 'inputs' ) )
            // InternalBot.g:6964:1: ( 'inputs' )
            {
            // InternalBot.g:6964:1: ( 'inputs' )
            // InternalBot.g:6965:2: 'inputs'
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBot.g:6974:1: rule__TextLanguageInput__Group_0__1 : rule__TextLanguageInput__Group_0__1__Impl ;
    public final void rule__TextLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6978:1: ( rule__TextLanguageInput__Group_0__1__Impl )
            // InternalBot.g:6979:2: rule__TextLanguageInput__Group_0__1__Impl
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
    // InternalBot.g:6985:1: rule__TextLanguageInput__Group_0__1__Impl : ( ( rule__TextLanguageInput__Group_0_1__0 )? ) ;
    public final void rule__TextLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:6989:1: ( ( ( rule__TextLanguageInput__Group_0_1__0 )? ) )
            // InternalBot.g:6990:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            {
            // InternalBot.g:6990:1: ( ( rule__TextLanguageInput__Group_0_1__0 )? )
            // InternalBot.g:6991:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputAccess().getGroup_0_1()); 
            // InternalBot.g:6992:2: ( rule__TextLanguageInput__Group_0_1__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==66) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBot.g:6992:3: rule__TextLanguageInput__Group_0_1__0
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
    // InternalBot.g:7001:1: rule__TextLanguageInput__Group_0_1__0 : rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 ;
    public final void rule__TextLanguageInput__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7005:1: ( rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1 )
            // InternalBot.g:7006:2: rule__TextLanguageInput__Group_0_1__0__Impl rule__TextLanguageInput__Group_0_1__1
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
    // InternalBot.g:7013:1: rule__TextLanguageInput__Group_0_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInput__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7017:1: ( ( 'in' ) )
            // InternalBot.g:7018:1: ( 'in' )
            {
            // InternalBot.g:7018:1: ( 'in' )
            // InternalBot.g:7019:2: 'in'
            {
             before(grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:7028:1: rule__TextLanguageInput__Group_0_1__1 : rule__TextLanguageInput__Group_0_1__1__Impl ;
    public final void rule__TextLanguageInput__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7032:1: ( rule__TextLanguageInput__Group_0_1__1__Impl )
            // InternalBot.g:7033:2: rule__TextLanguageInput__Group_0_1__1__Impl
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
    // InternalBot.g:7039:1: rule__TextLanguageInput__Group_0_1__1__Impl : ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) ;
    public final void rule__TextLanguageInput__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7043:1: ( ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) ) )
            // InternalBot.g:7044:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            {
            // InternalBot.g:7044:1: ( ( rule__TextLanguageInput__LanguageAssignment_0_1_1 ) )
            // InternalBot.g:7045:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getLanguageAssignment_0_1_1()); 
            // InternalBot.g:7046:2: ( rule__TextLanguageInput__LanguageAssignment_0_1_1 )
            // InternalBot.g:7046:3: rule__TextLanguageInput__LanguageAssignment_0_1_1
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
    // InternalBot.g:7055:1: rule__TextLanguageInput__Group_3__0 : rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 ;
    public final void rule__TextLanguageInput__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7059:1: ( rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1 )
            // InternalBot.g:7060:2: rule__TextLanguageInput__Group_3__0__Impl rule__TextLanguageInput__Group_3__1
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
    // InternalBot.g:7067:1: rule__TextLanguageInput__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInput__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7071:1: ( ( ',' ) )
            // InternalBot.g:7072:1: ( ',' )
            {
            // InternalBot.g:7072:1: ( ',' )
            // InternalBot.g:7073:2: ','
            {
             before(grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:7082:1: rule__TextLanguageInput__Group_3__1 : rule__TextLanguageInput__Group_3__1__Impl ;
    public final void rule__TextLanguageInput__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7086:1: ( rule__TextLanguageInput__Group_3__1__Impl )
            // InternalBot.g:7087:2: rule__TextLanguageInput__Group_3__1__Impl
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
    // InternalBot.g:7093:1: rule__TextLanguageInput__Group_3__1__Impl : ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) ;
    public final void rule__TextLanguageInput__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7097:1: ( ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) ) )
            // InternalBot.g:7098:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            {
            // InternalBot.g:7098:1: ( ( rule__TextLanguageInput__InputsAssignment_3_1 ) )
            // InternalBot.g:7099:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            {
             before(grammarAccess.getTextLanguageInputAccess().getInputsAssignment_3_1()); 
            // InternalBot.g:7100:2: ( rule__TextLanguageInput__InputsAssignment_3_1 )
            // InternalBot.g:7100:3: rule__TextLanguageInput__InputsAssignment_3_1
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
    // InternalBot.g:7109:1: rule__HTTPResponse__Group__0 : rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 ;
    public final void rule__HTTPResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7113:1: ( rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1 )
            // InternalBot.g:7114:2: rule__HTTPResponse__Group__0__Impl rule__HTTPResponse__Group__1
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
    // InternalBot.g:7121:1: rule__HTTPResponse__Group__0__Impl : ( 'Response' ) ;
    public final void rule__HTTPResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7125:1: ( ( 'Response' ) )
            // InternalBot.g:7126:1: ( 'Response' )
            {
            // InternalBot.g:7126:1: ( 'Response' )
            // InternalBot.g:7127:2: 'Response'
            {
             before(grammarAccess.getHTTPResponseAccess().getResponseKeyword_0()); 
            match(input,86,FOLLOW_2); 
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
    // InternalBot.g:7136:1: rule__HTTPResponse__Group__1 : rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 ;
    public final void rule__HTTPResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7140:1: ( rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2 )
            // InternalBot.g:7141:2: rule__HTTPResponse__Group__1__Impl rule__HTTPResponse__Group__2
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
    // InternalBot.g:7148:1: rule__HTTPResponse__Group__1__Impl : ( ( rule__HTTPResponse__NameAssignment_1 ) ) ;
    public final void rule__HTTPResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7152:1: ( ( ( rule__HTTPResponse__NameAssignment_1 ) ) )
            // InternalBot.g:7153:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            {
            // InternalBot.g:7153:1: ( ( rule__HTTPResponse__NameAssignment_1 ) )
            // InternalBot.g:7154:2: ( rule__HTTPResponse__NameAssignment_1 )
            {
             before(grammarAccess.getHTTPResponseAccess().getNameAssignment_1()); 
            // InternalBot.g:7155:2: ( rule__HTTPResponse__NameAssignment_1 )
            // InternalBot.g:7155:3: rule__HTTPResponse__NameAssignment_1
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
    // InternalBot.g:7163:1: rule__HTTPResponse__Group__2 : rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 ;
    public final void rule__HTTPResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7167:1: ( rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3 )
            // InternalBot.g:7168:2: rule__HTTPResponse__Group__2__Impl rule__HTTPResponse__Group__3
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
    // InternalBot.g:7175:1: rule__HTTPResponse__Group__2__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7179:1: ( ( ':' ) )
            // InternalBot.g:7180:1: ( ':' )
            {
            // InternalBot.g:7180:1: ( ':' )
            // InternalBot.g:7181:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_2()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7190:1: rule__HTTPResponse__Group__3 : rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 ;
    public final void rule__HTTPResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7194:1: ( rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4 )
            // InternalBot.g:7195:2: rule__HTTPResponse__Group__3__Impl rule__HTTPResponse__Group__4
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
    // InternalBot.g:7202:1: rule__HTTPResponse__Group__3__Impl : ( 'Request' ) ;
    public final void rule__HTTPResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7206:1: ( ( 'Request' ) )
            // InternalBot.g:7207:1: ( 'Request' )
            {
            // InternalBot.g:7207:1: ( 'Request' )
            // InternalBot.g:7208:2: 'Request'
            {
             before(grammarAccess.getHTTPResponseAccess().getRequestKeyword_3()); 
            match(input,87,FOLLOW_2); 
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
    // InternalBot.g:7217:1: rule__HTTPResponse__Group__4 : rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 ;
    public final void rule__HTTPResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7221:1: ( rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5 )
            // InternalBot.g:7222:2: rule__HTTPResponse__Group__4__Impl rule__HTTPResponse__Group__5
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
    // InternalBot.g:7229:1: rule__HTTPResponse__Group__4__Impl : ( ':' ) ;
    public final void rule__HTTPResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7233:1: ( ( ':' ) )
            // InternalBot.g:7234:1: ( ':' )
            {
            // InternalBot.g:7234:1: ( ':' )
            // InternalBot.g:7235:2: ':'
            {
             before(grammarAccess.getHTTPResponseAccess().getColonKeyword_4()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7244:1: rule__HTTPResponse__Group__5 : rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 ;
    public final void rule__HTTPResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7248:1: ( rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6 )
            // InternalBot.g:7249:2: rule__HTTPResponse__Group__5__Impl rule__HTTPResponse__Group__6
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
    // InternalBot.g:7256:1: rule__HTTPResponse__Group__5__Impl : ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) ) ;
    public final void rule__HTTPResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7260:1: ( ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) ) )
            // InternalBot.g:7261:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) )
            {
            // InternalBot.g:7261:1: ( ( rule__HTTPResponse__HTTPRequestAssignment_5 ) )
            // InternalBot.g:7262:2: ( rule__HTTPResponse__HTTPRequestAssignment_5 )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestAssignment_5()); 
            // InternalBot.g:7263:2: ( rule__HTTPResponse__HTTPRequestAssignment_5 )
            // InternalBot.g:7263:3: rule__HTTPResponse__HTTPRequestAssignment_5
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
    // InternalBot.g:7271:1: rule__HTTPResponse__Group__6 : rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 ;
    public final void rule__HTTPResponse__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7275:1: ( rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7 )
            // InternalBot.g:7276:2: rule__HTTPResponse__Group__6__Impl rule__HTTPResponse__Group__7
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
    // InternalBot.g:7283:1: rule__HTTPResponse__Group__6__Impl : ( ';' ) ;
    public final void rule__HTTPResponse__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7287:1: ( ( ';' ) )
            // InternalBot.g:7288:1: ( ';' )
            {
            // InternalBot.g:7288:1: ( ';' )
            // InternalBot.g:7289:2: ';'
            {
             before(grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_6()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:7298:1: rule__HTTPResponse__Group__7 : rule__HTTPResponse__Group__7__Impl ;
    public final void rule__HTTPResponse__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7302:1: ( rule__HTTPResponse__Group__7__Impl )
            // InternalBot.g:7303:2: rule__HTTPResponse__Group__7__Impl
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
    // InternalBot.g:7309:1: rule__HTTPResponse__Group__7__Impl : ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) ) ;
    public final void rule__HTTPResponse__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7313:1: ( ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) ) )
            // InternalBot.g:7314:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) )
            {
            // InternalBot.g:7314:1: ( ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* ) )
            // InternalBot.g:7315:2: ( ( rule__HTTPResponse__InputsAssignment_7 ) ) ( ( rule__HTTPResponse__InputsAssignment_7 )* )
            {
            // InternalBot.g:7315:2: ( ( rule__HTTPResponse__InputsAssignment_7 ) )
            // InternalBot.g:7316:3: ( rule__HTTPResponse__InputsAssignment_7 )
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:7317:3: ( rule__HTTPResponse__InputsAssignment_7 )
            // InternalBot.g:7317:4: rule__HTTPResponse__InputsAssignment_7
            {
            pushFollow(FOLLOW_23);
            rule__HTTPResponse__InputsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 

            }

            // InternalBot.g:7320:2: ( ( rule__HTTPResponse__InputsAssignment_7 )* )
            // InternalBot.g:7321:3: ( rule__HTTPResponse__InputsAssignment_7 )*
            {
             before(grammarAccess.getHTTPResponseAccess().getInputsAssignment_7()); 
            // InternalBot.g:7322:3: ( rule__HTTPResponse__InputsAssignment_7 )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==63) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalBot.g:7322:4: rule__HTTPResponse__InputsAssignment_7
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__HTTPResponse__InputsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop66;
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
    // InternalBot.g:7332:1: rule__HTTPRequest__Group__0 : rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 ;
    public final void rule__HTTPRequest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7336:1: ( rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1 )
            // InternalBot.g:7337:2: rule__HTTPRequest__Group__0__Impl rule__HTTPRequest__Group__1
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
    // InternalBot.g:7344:1: rule__HTTPRequest__Group__0__Impl : ( 'Request' ) ;
    public final void rule__HTTPRequest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7348:1: ( ( 'Request' ) )
            // InternalBot.g:7349:1: ( 'Request' )
            {
            // InternalBot.g:7349:1: ( 'Request' )
            // InternalBot.g:7350:2: 'Request'
            {
             before(grammarAccess.getHTTPRequestAccess().getRequestKeyword_0()); 
            match(input,87,FOLLOW_2); 
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
    // InternalBot.g:7359:1: rule__HTTPRequest__Group__1 : rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 ;
    public final void rule__HTTPRequest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7363:1: ( rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2 )
            // InternalBot.g:7364:2: rule__HTTPRequest__Group__1__Impl rule__HTTPRequest__Group__2
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
    // InternalBot.g:7371:1: rule__HTTPRequest__Group__1__Impl : ( ( rule__HTTPRequest__MethodAssignment_1 ) ) ;
    public final void rule__HTTPRequest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7375:1: ( ( ( rule__HTTPRequest__MethodAssignment_1 ) ) )
            // InternalBot.g:7376:1: ( ( rule__HTTPRequest__MethodAssignment_1 ) )
            {
            // InternalBot.g:7376:1: ( ( rule__HTTPRequest__MethodAssignment_1 ) )
            // InternalBot.g:7377:2: ( rule__HTTPRequest__MethodAssignment_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getMethodAssignment_1()); 
            // InternalBot.g:7378:2: ( rule__HTTPRequest__MethodAssignment_1 )
            // InternalBot.g:7378:3: rule__HTTPRequest__MethodAssignment_1
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
    // InternalBot.g:7386:1: rule__HTTPRequest__Group__2 : rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 ;
    public final void rule__HTTPRequest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7390:1: ( rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3 )
            // InternalBot.g:7391:2: rule__HTTPRequest__Group__2__Impl rule__HTTPRequest__Group__3
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
    // InternalBot.g:7398:1: rule__HTTPRequest__Group__2__Impl : ( ( rule__HTTPRequest__NameAssignment_2 ) ) ;
    public final void rule__HTTPRequest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7402:1: ( ( ( rule__HTTPRequest__NameAssignment_2 ) ) )
            // InternalBot.g:7403:1: ( ( rule__HTTPRequest__NameAssignment_2 ) )
            {
            // InternalBot.g:7403:1: ( ( rule__HTTPRequest__NameAssignment_2 ) )
            // InternalBot.g:7404:2: ( rule__HTTPRequest__NameAssignment_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getNameAssignment_2()); 
            // InternalBot.g:7405:2: ( rule__HTTPRequest__NameAssignment_2 )
            // InternalBot.g:7405:3: rule__HTTPRequest__NameAssignment_2
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
    // InternalBot.g:7413:1: rule__HTTPRequest__Group__3 : rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 ;
    public final void rule__HTTPRequest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7417:1: ( rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4 )
            // InternalBot.g:7418:2: rule__HTTPRequest__Group__3__Impl rule__HTTPRequest__Group__4
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
    // InternalBot.g:7425:1: rule__HTTPRequest__Group__3__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7429:1: ( ( ':' ) )
            // InternalBot.g:7430:1: ( ':' )
            {
            // InternalBot.g:7430:1: ( ':' )
            // InternalBot.g:7431:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7440:1: rule__HTTPRequest__Group__4 : rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 ;
    public final void rule__HTTPRequest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7444:1: ( rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5 )
            // InternalBot.g:7445:2: rule__HTTPRequest__Group__4__Impl rule__HTTPRequest__Group__5
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
    // InternalBot.g:7452:1: rule__HTTPRequest__Group__4__Impl : ( 'URL' ) ;
    public final void rule__HTTPRequest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7456:1: ( ( 'URL' ) )
            // InternalBot.g:7457:1: ( 'URL' )
            {
            // InternalBot.g:7457:1: ( 'URL' )
            // InternalBot.g:7458:2: 'URL'
            {
             before(grammarAccess.getHTTPRequestAccess().getURLKeyword_4()); 
            match(input,88,FOLLOW_2); 
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
    // InternalBot.g:7467:1: rule__HTTPRequest__Group__5 : rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 ;
    public final void rule__HTTPRequest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7471:1: ( rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6 )
            // InternalBot.g:7472:2: rule__HTTPRequest__Group__5__Impl rule__HTTPRequest__Group__6
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
    // InternalBot.g:7479:1: rule__HTTPRequest__Group__5__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7483:1: ( ( ':' ) )
            // InternalBot.g:7484:1: ( ':' )
            {
            // InternalBot.g:7484:1: ( ':' )
            // InternalBot.g:7485:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_5()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7494:1: rule__HTTPRequest__Group__6 : rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 ;
    public final void rule__HTTPRequest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7498:1: ( rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7 )
            // InternalBot.g:7499:2: rule__HTTPRequest__Group__6__Impl rule__HTTPRequest__Group__7
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
    // InternalBot.g:7506:1: rule__HTTPRequest__Group__6__Impl : ( ( rule__HTTPRequest__URLAssignment_6 ) ) ;
    public final void rule__HTTPRequest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7510:1: ( ( ( rule__HTTPRequest__URLAssignment_6 ) ) )
            // InternalBot.g:7511:1: ( ( rule__HTTPRequest__URLAssignment_6 ) )
            {
            // InternalBot.g:7511:1: ( ( rule__HTTPRequest__URLAssignment_6 ) )
            // InternalBot.g:7512:2: ( rule__HTTPRequest__URLAssignment_6 )
            {
             before(grammarAccess.getHTTPRequestAccess().getURLAssignment_6()); 
            // InternalBot.g:7513:2: ( rule__HTTPRequest__URLAssignment_6 )
            // InternalBot.g:7513:3: rule__HTTPRequest__URLAssignment_6
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
    // InternalBot.g:7521:1: rule__HTTPRequest__Group__7 : rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 ;
    public final void rule__HTTPRequest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7525:1: ( rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8 )
            // InternalBot.g:7526:2: rule__HTTPRequest__Group__7__Impl rule__HTTPRequest__Group__8
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
    // InternalBot.g:7533:1: rule__HTTPRequest__Group__7__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7537:1: ( ( ';' ) )
            // InternalBot.g:7538:1: ( ';' )
            {
            // InternalBot.g:7538:1: ( ';' )
            // InternalBot.g:7539:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_7()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:7548:1: rule__HTTPRequest__Group__8 : rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 ;
    public final void rule__HTTPRequest__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7552:1: ( rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9 )
            // InternalBot.g:7553:2: rule__HTTPRequest__Group__8__Impl rule__HTTPRequest__Group__9
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
    // InternalBot.g:7560:1: rule__HTTPRequest__Group__8__Impl : ( ( rule__HTTPRequest__Group_8__0 )? ) ;
    public final void rule__HTTPRequest__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7564:1: ( ( ( rule__HTTPRequest__Group_8__0 )? ) )
            // InternalBot.g:7565:1: ( ( rule__HTTPRequest__Group_8__0 )? )
            {
            // InternalBot.g:7565:1: ( ( rule__HTTPRequest__Group_8__0 )? )
            // InternalBot.g:7566:2: ( rule__HTTPRequest__Group_8__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_8()); 
            // InternalBot.g:7567:2: ( rule__HTTPRequest__Group_8__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==89) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalBot.g:7567:3: rule__HTTPRequest__Group_8__0
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
    // InternalBot.g:7575:1: rule__HTTPRequest__Group__9 : rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 ;
    public final void rule__HTTPRequest__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7579:1: ( rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10 )
            // InternalBot.g:7580:2: rule__HTTPRequest__Group__9__Impl rule__HTTPRequest__Group__10
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
    // InternalBot.g:7587:1: rule__HTTPRequest__Group__9__Impl : ( ( rule__HTTPRequest__Group_9__0 )? ) ;
    public final void rule__HTTPRequest__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7591:1: ( ( ( rule__HTTPRequest__Group_9__0 )? ) )
            // InternalBot.g:7592:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            {
            // InternalBot.g:7592:1: ( ( rule__HTTPRequest__Group_9__0 )? )
            // InternalBot.g:7593:2: ( rule__HTTPRequest__Group_9__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9()); 
            // InternalBot.g:7594:2: ( rule__HTTPRequest__Group_9__0 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==90) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalBot.g:7594:3: rule__HTTPRequest__Group_9__0
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
    // InternalBot.g:7602:1: rule__HTTPRequest__Group__10 : rule__HTTPRequest__Group__10__Impl ;
    public final void rule__HTTPRequest__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7606:1: ( rule__HTTPRequest__Group__10__Impl )
            // InternalBot.g:7607:2: rule__HTTPRequest__Group__10__Impl
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
    // InternalBot.g:7613:1: rule__HTTPRequest__Group__10__Impl : ( ( rule__HTTPRequest__Group_10__0 )? ) ;
    public final void rule__HTTPRequest__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7617:1: ( ( ( rule__HTTPRequest__Group_10__0 )? ) )
            // InternalBot.g:7618:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            {
            // InternalBot.g:7618:1: ( ( rule__HTTPRequest__Group_10__0 )? )
            // InternalBot.g:7619:2: ( rule__HTTPRequest__Group_10__0 )?
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10()); 
            // InternalBot.g:7620:2: ( rule__HTTPRequest__Group_10__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==21) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalBot.g:7620:3: rule__HTTPRequest__Group_10__0
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
    // InternalBot.g:7629:1: rule__HTTPRequest__Group_8__0 : rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1 ;
    public final void rule__HTTPRequest__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7633:1: ( rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1 )
            // InternalBot.g:7634:2: rule__HTTPRequest__Group_8__0__Impl rule__HTTPRequest__Group_8__1
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
    // InternalBot.g:7641:1: rule__HTTPRequest__Group_8__0__Impl : ( 'basicAuth' ) ;
    public final void rule__HTTPRequest__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7645:1: ( ( 'basicAuth' ) )
            // InternalBot.g:7646:1: ( 'basicAuth' )
            {
            // InternalBot.g:7646:1: ( 'basicAuth' )
            // InternalBot.g:7647:2: 'basicAuth'
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_8_0()); 
            match(input,89,FOLLOW_2); 
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
    // InternalBot.g:7656:1: rule__HTTPRequest__Group_8__1 : rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2 ;
    public final void rule__HTTPRequest__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7660:1: ( rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2 )
            // InternalBot.g:7661:2: rule__HTTPRequest__Group_8__1__Impl rule__HTTPRequest__Group_8__2
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
    // InternalBot.g:7668:1: rule__HTTPRequest__Group_8__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7672:1: ( ( ':' ) )
            // InternalBot.g:7673:1: ( ':' )
            {
            // InternalBot.g:7673:1: ( ':' )
            // InternalBot.g:7674:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_8_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7683:1: rule__HTTPRequest__Group_8__2 : rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3 ;
    public final void rule__HTTPRequest__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7687:1: ( rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3 )
            // InternalBot.g:7688:2: rule__HTTPRequest__Group_8__2__Impl rule__HTTPRequest__Group_8__3
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
    // InternalBot.g:7695:1: rule__HTTPRequest__Group_8__2__Impl : ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) ) ;
    public final void rule__HTTPRequest__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7699:1: ( ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) ) )
            // InternalBot.g:7700:1: ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) )
            {
            // InternalBot.g:7700:1: ( ( rule__HTTPRequest__BasicAuthAssignment_8_2 ) )
            // InternalBot.g:7701:2: ( rule__HTTPRequest__BasicAuthAssignment_8_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getBasicAuthAssignment_8_2()); 
            // InternalBot.g:7702:2: ( rule__HTTPRequest__BasicAuthAssignment_8_2 )
            // InternalBot.g:7702:3: rule__HTTPRequest__BasicAuthAssignment_8_2
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
    // InternalBot.g:7710:1: rule__HTTPRequest__Group_8__3 : rule__HTTPRequest__Group_8__3__Impl ;
    public final void rule__HTTPRequest__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7714:1: ( rule__HTTPRequest__Group_8__3__Impl )
            // InternalBot.g:7715:2: rule__HTTPRequest__Group_8__3__Impl
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
    // InternalBot.g:7721:1: rule__HTTPRequest__Group_8__3__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7725:1: ( ( ';' ) )
            // InternalBot.g:7726:1: ( ';' )
            {
            // InternalBot.g:7726:1: ( ';' )
            // InternalBot.g:7727:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8_3()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:7737:1: rule__HTTPRequest__Group_9__0 : rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 ;
    public final void rule__HTTPRequest__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7741:1: ( rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1 )
            // InternalBot.g:7742:2: rule__HTTPRequest__Group_9__0__Impl rule__HTTPRequest__Group_9__1
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
    // InternalBot.g:7749:1: rule__HTTPRequest__Group_9__0__Impl : ( 'headers' ) ;
    public final void rule__HTTPRequest__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7753:1: ( ( 'headers' ) )
            // InternalBot.g:7754:1: ( 'headers' )
            {
            // InternalBot.g:7754:1: ( 'headers' )
            // InternalBot.g:7755:2: 'headers'
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersKeyword_9_0()); 
            match(input,90,FOLLOW_2); 
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
    // InternalBot.g:7764:1: rule__HTTPRequest__Group_9__1 : rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 ;
    public final void rule__HTTPRequest__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7768:1: ( rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2 )
            // InternalBot.g:7769:2: rule__HTTPRequest__Group_9__1__Impl rule__HTTPRequest__Group_9__2
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
    // InternalBot.g:7776:1: rule__HTTPRequest__Group_9__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7780:1: ( ( ':' ) )
            // InternalBot.g:7781:1: ( ':' )
            {
            // InternalBot.g:7781:1: ( ':' )
            // InternalBot.g:7782:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7791:1: rule__HTTPRequest__Group_9__2 : rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 ;
    public final void rule__HTTPRequest__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7795:1: ( rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3 )
            // InternalBot.g:7796:2: rule__HTTPRequest__Group_9__2__Impl rule__HTTPRequest__Group_9__3
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
    // InternalBot.g:7803:1: rule__HTTPRequest__Group_9__2__Impl : ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) ) ;
    public final void rule__HTTPRequest__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7807:1: ( ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) ) )
            // InternalBot.g:7808:1: ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) )
            {
            // InternalBot.g:7808:1: ( ( rule__HTTPRequest__HeadersAssignment_9_2 ) )
            // InternalBot.g:7809:2: ( rule__HTTPRequest__HeadersAssignment_9_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_2()); 
            // InternalBot.g:7810:2: ( rule__HTTPRequest__HeadersAssignment_9_2 )
            // InternalBot.g:7810:3: rule__HTTPRequest__HeadersAssignment_9_2
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
    // InternalBot.g:7818:1: rule__HTTPRequest__Group_9__3 : rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4 ;
    public final void rule__HTTPRequest__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7822:1: ( rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4 )
            // InternalBot.g:7823:2: rule__HTTPRequest__Group_9__3__Impl rule__HTTPRequest__Group_9__4
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
    // InternalBot.g:7830:1: rule__HTTPRequest__Group_9__3__Impl : ( ( rule__HTTPRequest__Group_9_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7834:1: ( ( ( rule__HTTPRequest__Group_9_3__0 )* ) )
            // InternalBot.g:7835:1: ( ( rule__HTTPRequest__Group_9_3__0 )* )
            {
            // InternalBot.g:7835:1: ( ( rule__HTTPRequest__Group_9_3__0 )* )
            // InternalBot.g:7836:2: ( rule__HTTPRequest__Group_9_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_9_3()); 
            // InternalBot.g:7837:2: ( rule__HTTPRequest__Group_9_3__0 )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==57) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalBot.g:7837:3: rule__HTTPRequest__Group_9_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HTTPRequest__Group_9_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop70;
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
    // InternalBot.g:7845:1: rule__HTTPRequest__Group_9__4 : rule__HTTPRequest__Group_9__4__Impl ;
    public final void rule__HTTPRequest__Group_9__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7849:1: ( rule__HTTPRequest__Group_9__4__Impl )
            // InternalBot.g:7850:2: rule__HTTPRequest__Group_9__4__Impl
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
    // InternalBot.g:7856:1: rule__HTTPRequest__Group_9__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_9__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7860:1: ( ( ';' ) )
            // InternalBot.g:7861:1: ( ';' )
            {
            // InternalBot.g:7861:1: ( ';' )
            // InternalBot.g:7862:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_4()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:7872:1: rule__HTTPRequest__Group_9_3__0 : rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1 ;
    public final void rule__HTTPRequest__Group_9_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7876:1: ( rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1 )
            // InternalBot.g:7877:2: rule__HTTPRequest__Group_9_3__0__Impl rule__HTTPRequest__Group_9_3__1
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
    // InternalBot.g:7884:1: rule__HTTPRequest__Group_9_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_9_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7888:1: ( ( ',' ) )
            // InternalBot.g:7889:1: ( ',' )
            {
            // InternalBot.g:7889:1: ( ',' )
            // InternalBot.g:7890:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_9_3_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:7899:1: rule__HTTPRequest__Group_9_3__1 : rule__HTTPRequest__Group_9_3__1__Impl ;
    public final void rule__HTTPRequest__Group_9_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7903:1: ( rule__HTTPRequest__Group_9_3__1__Impl )
            // InternalBot.g:7904:2: rule__HTTPRequest__Group_9_3__1__Impl
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
    // InternalBot.g:7910:1: rule__HTTPRequest__Group_9_3__1__Impl : ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_9_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7914:1: ( ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) ) )
            // InternalBot.g:7915:1: ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) )
            {
            // InternalBot.g:7915:1: ( ( rule__HTTPRequest__HeadersAssignment_9_3_1 ) )
            // InternalBot.g:7916:2: ( rule__HTTPRequest__HeadersAssignment_9_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getHeadersAssignment_9_3_1()); 
            // InternalBot.g:7917:2: ( rule__HTTPRequest__HeadersAssignment_9_3_1 )
            // InternalBot.g:7917:3: rule__HTTPRequest__HeadersAssignment_9_3_1
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
    // InternalBot.g:7926:1: rule__HTTPRequest__Group_10__0 : rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 ;
    public final void rule__HTTPRequest__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7930:1: ( rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1 )
            // InternalBot.g:7931:2: rule__HTTPRequest__Group_10__0__Impl rule__HTTPRequest__Group_10__1
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
    // InternalBot.g:7938:1: rule__HTTPRequest__Group_10__0__Impl : ( 'data' ) ;
    public final void rule__HTTPRequest__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7942:1: ( ( 'data' ) )
            // InternalBot.g:7943:1: ( 'data' )
            {
            // InternalBot.g:7943:1: ( 'data' )
            // InternalBot.g:7944:2: 'data'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataKeyword_10_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalBot.g:7953:1: rule__HTTPRequest__Group_10__1 : rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 ;
    public final void rule__HTTPRequest__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7957:1: ( rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2 )
            // InternalBot.g:7958:2: rule__HTTPRequest__Group_10__1__Impl rule__HTTPRequest__Group_10__2
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
    // InternalBot.g:7965:1: rule__HTTPRequest__Group_10__1__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7969:1: ( ( ':' ) )
            // InternalBot.g:7970:1: ( ':' )
            {
            // InternalBot.g:7970:1: ( ':' )
            // InternalBot.g:7971:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:7980:1: rule__HTTPRequest__Group_10__2 : rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 ;
    public final void rule__HTTPRequest__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7984:1: ( rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3 )
            // InternalBot.g:7985:2: rule__HTTPRequest__Group_10__2__Impl rule__HTTPRequest__Group_10__3
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
    // InternalBot.g:7992:1: rule__HTTPRequest__Group_10__2__Impl : ( ( rule__HTTPRequest__DataAssignment_10_2 ) ) ;
    public final void rule__HTTPRequest__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:7996:1: ( ( ( rule__HTTPRequest__DataAssignment_10_2 ) ) )
            // InternalBot.g:7997:1: ( ( rule__HTTPRequest__DataAssignment_10_2 ) )
            {
            // InternalBot.g:7997:1: ( ( rule__HTTPRequest__DataAssignment_10_2 ) )
            // InternalBot.g:7998:2: ( rule__HTTPRequest__DataAssignment_10_2 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_2()); 
            // InternalBot.g:7999:2: ( rule__HTTPRequest__DataAssignment_10_2 )
            // InternalBot.g:7999:3: rule__HTTPRequest__DataAssignment_10_2
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
    // InternalBot.g:8007:1: rule__HTTPRequest__Group_10__3 : rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 ;
    public final void rule__HTTPRequest__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8011:1: ( rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4 )
            // InternalBot.g:8012:2: rule__HTTPRequest__Group_10__3__Impl rule__HTTPRequest__Group_10__4
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
    // InternalBot.g:8019:1: rule__HTTPRequest__Group_10__3__Impl : ( ( rule__HTTPRequest__Group_10_3__0 )* ) ;
    public final void rule__HTTPRequest__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8023:1: ( ( ( rule__HTTPRequest__Group_10_3__0 )* ) )
            // InternalBot.g:8024:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            {
            // InternalBot.g:8024:1: ( ( rule__HTTPRequest__Group_10_3__0 )* )
            // InternalBot.g:8025:2: ( rule__HTTPRequest__Group_10_3__0 )*
            {
             before(grammarAccess.getHTTPRequestAccess().getGroup_10_3()); 
            // InternalBot.g:8026:2: ( rule__HTTPRequest__Group_10_3__0 )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==57) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalBot.g:8026:3: rule__HTTPRequest__Group_10_3__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__HTTPRequest__Group_10_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop71;
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
    // InternalBot.g:8034:1: rule__HTTPRequest__Group_10__4 : rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5 ;
    public final void rule__HTTPRequest__Group_10__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8038:1: ( rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5 )
            // InternalBot.g:8039:2: rule__HTTPRequest__Group_10__4__Impl rule__HTTPRequest__Group_10__5
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
    // InternalBot.g:8046:1: rule__HTTPRequest__Group_10__4__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8050:1: ( ( ';' ) )
            // InternalBot.g:8051:1: ( ';' )
            {
            // InternalBot.g:8051:1: ( ';' )
            // InternalBot.g:8052:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:8061:1: rule__HTTPRequest__Group_10__5 : rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6 ;
    public final void rule__HTTPRequest__Group_10__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8065:1: ( rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6 )
            // InternalBot.g:8066:2: rule__HTTPRequest__Group_10__5__Impl rule__HTTPRequest__Group_10__6
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
    // InternalBot.g:8073:1: rule__HTTPRequest__Group_10__5__Impl : ( 'dataType' ) ;
    public final void rule__HTTPRequest__Group_10__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8077:1: ( ( 'dataType' ) )
            // InternalBot.g:8078:1: ( 'dataType' )
            {
            // InternalBot.g:8078:1: ( 'dataType' )
            // InternalBot.g:8079:2: 'dataType'
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_10_5()); 
            match(input,91,FOLLOW_2); 
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
    // InternalBot.g:8088:1: rule__HTTPRequest__Group_10__6 : rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7 ;
    public final void rule__HTTPRequest__Group_10__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8092:1: ( rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7 )
            // InternalBot.g:8093:2: rule__HTTPRequest__Group_10__6__Impl rule__HTTPRequest__Group_10__7
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
    // InternalBot.g:8100:1: rule__HTTPRequest__Group_10__6__Impl : ( ':' ) ;
    public final void rule__HTTPRequest__Group_10__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8104:1: ( ( ':' ) )
            // InternalBot.g:8105:1: ( ':' )
            {
            // InternalBot.g:8105:1: ( ':' )
            // InternalBot.g:8106:2: ':'
            {
             before(grammarAccess.getHTTPRequestAccess().getColonKeyword_10_6()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:8115:1: rule__HTTPRequest__Group_10__7 : rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8 ;
    public final void rule__HTTPRequest__Group_10__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8119:1: ( rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8 )
            // InternalBot.g:8120:2: rule__HTTPRequest__Group_10__7__Impl rule__HTTPRequest__Group_10__8
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
    // InternalBot.g:8127:1: rule__HTTPRequest__Group_10__7__Impl : ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) ) ;
    public final void rule__HTTPRequest__Group_10__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8131:1: ( ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) ) )
            // InternalBot.g:8132:1: ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) )
            {
            // InternalBot.g:8132:1: ( ( rule__HTTPRequest__DataTypeAssignment_10_7 ) )
            // InternalBot.g:8133:2: ( rule__HTTPRequest__DataTypeAssignment_10_7 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataTypeAssignment_10_7()); 
            // InternalBot.g:8134:2: ( rule__HTTPRequest__DataTypeAssignment_10_7 )
            // InternalBot.g:8134:3: rule__HTTPRequest__DataTypeAssignment_10_7
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
    // InternalBot.g:8142:1: rule__HTTPRequest__Group_10__8 : rule__HTTPRequest__Group_10__8__Impl ;
    public final void rule__HTTPRequest__Group_10__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8146:1: ( rule__HTTPRequest__Group_10__8__Impl )
            // InternalBot.g:8147:2: rule__HTTPRequest__Group_10__8__Impl
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
    // InternalBot.g:8153:1: rule__HTTPRequest__Group_10__8__Impl : ( ';' ) ;
    public final void rule__HTTPRequest__Group_10__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8157:1: ( ( ';' ) )
            // InternalBot.g:8158:1: ( ';' )
            {
            // InternalBot.g:8158:1: ( ';' )
            // InternalBot.g:8159:2: ';'
            {
             before(grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_8()); 
            match(input,61,FOLLOW_2); 
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
    // InternalBot.g:8169:1: rule__HTTPRequest__Group_10_3__0 : rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 ;
    public final void rule__HTTPRequest__Group_10_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8173:1: ( rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1 )
            // InternalBot.g:8174:2: rule__HTTPRequest__Group_10_3__0__Impl rule__HTTPRequest__Group_10_3__1
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
    // InternalBot.g:8181:1: rule__HTTPRequest__Group_10_3__0__Impl : ( ',' ) ;
    public final void rule__HTTPRequest__Group_10_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8185:1: ( ( ',' ) )
            // InternalBot.g:8186:1: ( ',' )
            {
            // InternalBot.g:8186:1: ( ',' )
            // InternalBot.g:8187:2: ','
            {
             before(grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:8196:1: rule__HTTPRequest__Group_10_3__1 : rule__HTTPRequest__Group_10_3__1__Impl ;
    public final void rule__HTTPRequest__Group_10_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8200:1: ( rule__HTTPRequest__Group_10_3__1__Impl )
            // InternalBot.g:8201:2: rule__HTTPRequest__Group_10_3__1__Impl
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
    // InternalBot.g:8207:1: rule__HTTPRequest__Group_10_3__1__Impl : ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) ) ;
    public final void rule__HTTPRequest__Group_10_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8211:1: ( ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) ) )
            // InternalBot.g:8212:1: ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) )
            {
            // InternalBot.g:8212:1: ( ( rule__HTTPRequest__DataAssignment_10_3_1 ) )
            // InternalBot.g:8213:2: ( rule__HTTPRequest__DataAssignment_10_3_1 )
            {
             before(grammarAccess.getHTTPRequestAccess().getDataAssignment_10_3_1()); 
            // InternalBot.g:8214:2: ( rule__HTTPRequest__DataAssignment_10_3_1 )
            // InternalBot.g:8214:3: rule__HTTPRequest__DataAssignment_10_3_1
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
    // InternalBot.g:8223:1: rule__Image__Group__0 : rule__Image__Group__0__Impl rule__Image__Group__1 ;
    public final void rule__Image__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8227:1: ( rule__Image__Group__0__Impl rule__Image__Group__1 )
            // InternalBot.g:8228:2: rule__Image__Group__0__Impl rule__Image__Group__1
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
    // InternalBot.g:8235:1: rule__Image__Group__0__Impl : ( ( rule__Image__Alternatives_0 ) ) ;
    public final void rule__Image__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8239:1: ( ( ( rule__Image__Alternatives_0 ) ) )
            // InternalBot.g:8240:1: ( ( rule__Image__Alternatives_0 ) )
            {
            // InternalBot.g:8240:1: ( ( rule__Image__Alternatives_0 ) )
            // InternalBot.g:8241:2: ( rule__Image__Alternatives_0 )
            {
             before(grammarAccess.getImageAccess().getAlternatives_0()); 
            // InternalBot.g:8242:2: ( rule__Image__Alternatives_0 )
            // InternalBot.g:8242:3: rule__Image__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Image__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getImageAccess().getAlternatives_0()); 

            }


            }

        }
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
    // InternalBot.g:8250:1: rule__Image__Group__1 : rule__Image__Group__1__Impl rule__Image__Group__2 ;
    public final void rule__Image__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8254:1: ( rule__Image__Group__1__Impl rule__Image__Group__2 )
            // InternalBot.g:8255:2: rule__Image__Group__1__Impl rule__Image__Group__2
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
    // InternalBot.g:8262:1: rule__Image__Group__1__Impl : ( 'response' ) ;
    public final void rule__Image__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8266:1: ( ( 'response' ) )
            // InternalBot.g:8267:1: ( 'response' )
            {
            // InternalBot.g:8267:1: ( 'response' )
            // InternalBot.g:8268:2: 'response'
            {
             before(grammarAccess.getImageAccess().getResponseKeyword_1()); 
            match(input,85,FOLLOW_2); 
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
    // InternalBot.g:8277:1: rule__Image__Group__2 : rule__Image__Group__2__Impl rule__Image__Group__3 ;
    public final void rule__Image__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8281:1: ( rule__Image__Group__2__Impl rule__Image__Group__3 )
            // InternalBot.g:8282:2: rule__Image__Group__2__Impl rule__Image__Group__3
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
    // InternalBot.g:8289:1: rule__Image__Group__2__Impl : ( ( rule__Image__NameAssignment_2 ) ) ;
    public final void rule__Image__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8293:1: ( ( ( rule__Image__NameAssignment_2 ) ) )
            // InternalBot.g:8294:1: ( ( rule__Image__NameAssignment_2 ) )
            {
            // InternalBot.g:8294:1: ( ( rule__Image__NameAssignment_2 ) )
            // InternalBot.g:8295:2: ( rule__Image__NameAssignment_2 )
            {
             before(grammarAccess.getImageAccess().getNameAssignment_2()); 
            // InternalBot.g:8296:2: ( rule__Image__NameAssignment_2 )
            // InternalBot.g:8296:3: rule__Image__NameAssignment_2
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
    // InternalBot.g:8304:1: rule__Image__Group__3 : rule__Image__Group__3__Impl rule__Image__Group__4 ;
    public final void rule__Image__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8308:1: ( rule__Image__Group__3__Impl rule__Image__Group__4 )
            // InternalBot.g:8309:2: rule__Image__Group__3__Impl rule__Image__Group__4
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
    // InternalBot.g:8316:1: rule__Image__Group__3__Impl : ( ':' ) ;
    public final void rule__Image__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8320:1: ( ( ':' ) )
            // InternalBot.g:8321:1: ( ':' )
            {
            // InternalBot.g:8321:1: ( ':' )
            // InternalBot.g:8322:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:8331:1: rule__Image__Group__4 : rule__Image__Group__4__Impl rule__Image__Group__5 ;
    public final void rule__Image__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8335:1: ( rule__Image__Group__4__Impl rule__Image__Group__5 )
            // InternalBot.g:8336:2: rule__Image__Group__4__Impl rule__Image__Group__5
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
    // InternalBot.g:8343:1: rule__Image__Group__4__Impl : ( 'URL' ) ;
    public final void rule__Image__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8347:1: ( ( 'URL' ) )
            // InternalBot.g:8348:1: ( 'URL' )
            {
            // InternalBot.g:8348:1: ( 'URL' )
            // InternalBot.g:8349:2: 'URL'
            {
             before(grammarAccess.getImageAccess().getURLKeyword_4()); 
            match(input,88,FOLLOW_2); 
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
    // InternalBot.g:8358:1: rule__Image__Group__5 : rule__Image__Group__5__Impl rule__Image__Group__6 ;
    public final void rule__Image__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8362:1: ( rule__Image__Group__5__Impl rule__Image__Group__6 )
            // InternalBot.g:8363:2: rule__Image__Group__5__Impl rule__Image__Group__6
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
    // InternalBot.g:8370:1: rule__Image__Group__5__Impl : ( ':' ) ;
    public final void rule__Image__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8374:1: ( ( ':' ) )
            // InternalBot.g:8375:1: ( ':' )
            {
            // InternalBot.g:8375:1: ( ':' )
            // InternalBot.g:8376:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_5()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:8385:1: rule__Image__Group__6 : rule__Image__Group__6__Impl rule__Image__Group__7 ;
    public final void rule__Image__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8389:1: ( rule__Image__Group__6__Impl rule__Image__Group__7 )
            // InternalBot.g:8390:2: rule__Image__Group__6__Impl rule__Image__Group__7
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
    // InternalBot.g:8397:1: rule__Image__Group__6__Impl : ( ( rule__Image__URLAssignment_6 ) ) ;
    public final void rule__Image__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8401:1: ( ( ( rule__Image__URLAssignment_6 ) ) )
            // InternalBot.g:8402:1: ( ( rule__Image__URLAssignment_6 ) )
            {
            // InternalBot.g:8402:1: ( ( rule__Image__URLAssignment_6 ) )
            // InternalBot.g:8403:2: ( rule__Image__URLAssignment_6 )
            {
             before(grammarAccess.getImageAccess().getURLAssignment_6()); 
            // InternalBot.g:8404:2: ( rule__Image__URLAssignment_6 )
            // InternalBot.g:8404:3: rule__Image__URLAssignment_6
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
    // InternalBot.g:8412:1: rule__Image__Group__7 : rule__Image__Group__7__Impl ;
    public final void rule__Image__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8416:1: ( rule__Image__Group__7__Impl )
            // InternalBot.g:8417:2: rule__Image__Group__7__Impl
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
    // InternalBot.g:8423:1: rule__Image__Group__7__Impl : ( ( rule__Image__Group_7__0 )? ) ;
    public final void rule__Image__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8427:1: ( ( ( rule__Image__Group_7__0 )? ) )
            // InternalBot.g:8428:1: ( ( rule__Image__Group_7__0 )? )
            {
            // InternalBot.g:8428:1: ( ( rule__Image__Group_7__0 )? )
            // InternalBot.g:8429:2: ( rule__Image__Group_7__0 )?
            {
             before(grammarAccess.getImageAccess().getGroup_7()); 
            // InternalBot.g:8430:2: ( rule__Image__Group_7__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==92) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalBot.g:8430:3: rule__Image__Group_7__0
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
    // InternalBot.g:8439:1: rule__Image__Group_7__0 : rule__Image__Group_7__0__Impl rule__Image__Group_7__1 ;
    public final void rule__Image__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8443:1: ( rule__Image__Group_7__0__Impl rule__Image__Group_7__1 )
            // InternalBot.g:8444:2: rule__Image__Group_7__0__Impl rule__Image__Group_7__1
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
    // InternalBot.g:8451:1: rule__Image__Group_7__0__Impl : ( 'caption' ) ;
    public final void rule__Image__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8455:1: ( ( 'caption' ) )
            // InternalBot.g:8456:1: ( 'caption' )
            {
            // InternalBot.g:8456:1: ( 'caption' )
            // InternalBot.g:8457:2: 'caption'
            {
             before(grammarAccess.getImageAccess().getCaptionKeyword_7_0()); 
            match(input,92,FOLLOW_2); 
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
    // InternalBot.g:8466:1: rule__Image__Group_7__1 : rule__Image__Group_7__1__Impl rule__Image__Group_7__2 ;
    public final void rule__Image__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8470:1: ( rule__Image__Group_7__1__Impl rule__Image__Group_7__2 )
            // InternalBot.g:8471:2: rule__Image__Group_7__1__Impl rule__Image__Group_7__2
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
    // InternalBot.g:8478:1: rule__Image__Group_7__1__Impl : ( ':' ) ;
    public final void rule__Image__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8482:1: ( ( ':' ) )
            // InternalBot.g:8483:1: ( ':' )
            {
            // InternalBot.g:8483:1: ( ':' )
            // InternalBot.g:8484:2: ':'
            {
             before(grammarAccess.getImageAccess().getColonKeyword_7_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:8493:1: rule__Image__Group_7__2 : rule__Image__Group_7__2__Impl ;
    public final void rule__Image__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8497:1: ( rule__Image__Group_7__2__Impl )
            // InternalBot.g:8498:2: rule__Image__Group_7__2__Impl
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
    // InternalBot.g:8504:1: rule__Image__Group_7__2__Impl : ( ( rule__Image__CaptionAssignment_7_2 ) ) ;
    public final void rule__Image__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8508:1: ( ( ( rule__Image__CaptionAssignment_7_2 ) ) )
            // InternalBot.g:8509:1: ( ( rule__Image__CaptionAssignment_7_2 ) )
            {
            // InternalBot.g:8509:1: ( ( rule__Image__CaptionAssignment_7_2 ) )
            // InternalBot.g:8510:2: ( rule__Image__CaptionAssignment_7_2 )
            {
             before(grammarAccess.getImageAccess().getCaptionAssignment_7_2()); 
            // InternalBot.g:8511:2: ( rule__Image__CaptionAssignment_7_2 )
            // InternalBot.g:8511:3: rule__Image__CaptionAssignment_7_2
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
    // InternalBot.g:8520:1: rule__Empty__Group__0 : rule__Empty__Group__0__Impl rule__Empty__Group__1 ;
    public final void rule__Empty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8524:1: ( rule__Empty__Group__0__Impl rule__Empty__Group__1 )
            // InternalBot.g:8525:2: rule__Empty__Group__0__Impl rule__Empty__Group__1
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
    // InternalBot.g:8532:1: rule__Empty__Group__0__Impl : ( 'Empty' ) ;
    public final void rule__Empty__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8536:1: ( ( 'Empty' ) )
            // InternalBot.g:8537:1: ( 'Empty' )
            {
            // InternalBot.g:8537:1: ( 'Empty' )
            // InternalBot.g:8538:2: 'Empty'
            {
             before(grammarAccess.getEmptyAccess().getEmptyKeyword_0()); 
            match(input,93,FOLLOW_2); 
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
    // InternalBot.g:8547:1: rule__Empty__Group__1 : rule__Empty__Group__1__Impl rule__Empty__Group__2 ;
    public final void rule__Empty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8551:1: ( rule__Empty__Group__1__Impl rule__Empty__Group__2 )
            // InternalBot.g:8552:2: rule__Empty__Group__1__Impl rule__Empty__Group__2
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
    // InternalBot.g:8559:1: rule__Empty__Group__1__Impl : ( 'response' ) ;
    public final void rule__Empty__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8563:1: ( ( 'response' ) )
            // InternalBot.g:8564:1: ( 'response' )
            {
            // InternalBot.g:8564:1: ( 'response' )
            // InternalBot.g:8565:2: 'response'
            {
             before(grammarAccess.getEmptyAccess().getResponseKeyword_1()); 
            match(input,85,FOLLOW_2); 
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
    // InternalBot.g:8574:1: rule__Empty__Group__2 : rule__Empty__Group__2__Impl ;
    public final void rule__Empty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8578:1: ( rule__Empty__Group__2__Impl )
            // InternalBot.g:8579:2: rule__Empty__Group__2__Impl
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
    // InternalBot.g:8585:1: rule__Empty__Group__2__Impl : ( ( rule__Empty__NameAssignment_2 ) ) ;
    public final void rule__Empty__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8589:1: ( ( ( rule__Empty__NameAssignment_2 ) ) )
            // InternalBot.g:8590:1: ( ( rule__Empty__NameAssignment_2 ) )
            {
            // InternalBot.g:8590:1: ( ( rule__Empty__NameAssignment_2 ) )
            // InternalBot.g:8591:2: ( rule__Empty__NameAssignment_2 )
            {
             before(grammarAccess.getEmptyAccess().getNameAssignment_2()); 
            // InternalBot.g:8592:2: ( rule__Empty__NameAssignment_2 )
            // InternalBot.g:8592:3: rule__Empty__NameAssignment_2
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


    // $ANTLR start "rule__ButtonAction__Group__0"
    // InternalBot.g:8601:1: rule__ButtonAction__Group__0 : rule__ButtonAction__Group__0__Impl rule__ButtonAction__Group__1 ;
    public final void rule__ButtonAction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8605:1: ( rule__ButtonAction__Group__0__Impl rule__ButtonAction__Group__1 )
            // InternalBot.g:8606:2: rule__ButtonAction__Group__0__Impl rule__ButtonAction__Group__1
            {
            pushFollow(FOLLOW_60);
            rule__ButtonAction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonAction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__0"


    // $ANTLR start "rule__ButtonAction__Group__0__Impl"
    // InternalBot.g:8613:1: rule__ButtonAction__Group__0__Impl : ( 'Button' ) ;
    public final void rule__ButtonAction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8617:1: ( ( 'Button' ) )
            // InternalBot.g:8618:1: ( 'Button' )
            {
            // InternalBot.g:8618:1: ( 'Button' )
            // InternalBot.g:8619:2: 'Button'
            {
             before(grammarAccess.getButtonActionAccess().getButtonKeyword_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getButtonActionAccess().getButtonKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__0__Impl"


    // $ANTLR start "rule__ButtonAction__Group__1"
    // InternalBot.g:8628:1: rule__ButtonAction__Group__1 : rule__ButtonAction__Group__1__Impl rule__ButtonAction__Group__2 ;
    public final void rule__ButtonAction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8632:1: ( rule__ButtonAction__Group__1__Impl rule__ButtonAction__Group__2 )
            // InternalBot.g:8633:2: rule__ButtonAction__Group__1__Impl rule__ButtonAction__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__ButtonAction__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonAction__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__1"


    // $ANTLR start "rule__ButtonAction__Group__1__Impl"
    // InternalBot.g:8640:1: rule__ButtonAction__Group__1__Impl : ( 'response' ) ;
    public final void rule__ButtonAction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8644:1: ( ( 'response' ) )
            // InternalBot.g:8645:1: ( 'response' )
            {
            // InternalBot.g:8645:1: ( 'response' )
            // InternalBot.g:8646:2: 'response'
            {
             before(grammarAccess.getButtonActionAccess().getResponseKeyword_1()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getButtonActionAccess().getResponseKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__1__Impl"


    // $ANTLR start "rule__ButtonAction__Group__2"
    // InternalBot.g:8655:1: rule__ButtonAction__Group__2 : rule__ButtonAction__Group__2__Impl rule__ButtonAction__Group__3 ;
    public final void rule__ButtonAction__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8659:1: ( rule__ButtonAction__Group__2__Impl rule__ButtonAction__Group__3 )
            // InternalBot.g:8660:2: rule__ButtonAction__Group__2__Impl rule__ButtonAction__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ButtonAction__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonAction__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__2"


    // $ANTLR start "rule__ButtonAction__Group__2__Impl"
    // InternalBot.g:8667:1: rule__ButtonAction__Group__2__Impl : ( ( rule__ButtonAction__NameAssignment_2 ) ) ;
    public final void rule__ButtonAction__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8671:1: ( ( ( rule__ButtonAction__NameAssignment_2 ) ) )
            // InternalBot.g:8672:1: ( ( rule__ButtonAction__NameAssignment_2 ) )
            {
            // InternalBot.g:8672:1: ( ( rule__ButtonAction__NameAssignment_2 ) )
            // InternalBot.g:8673:2: ( rule__ButtonAction__NameAssignment_2 )
            {
             before(grammarAccess.getButtonActionAccess().getNameAssignment_2()); 
            // InternalBot.g:8674:2: ( rule__ButtonAction__NameAssignment_2 )
            // InternalBot.g:8674:3: rule__ButtonAction__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ButtonAction__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getButtonActionAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__2__Impl"


    // $ANTLR start "rule__ButtonAction__Group__3"
    // InternalBot.g:8682:1: rule__ButtonAction__Group__3 : rule__ButtonAction__Group__3__Impl rule__ButtonAction__Group__4 ;
    public final void rule__ButtonAction__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8686:1: ( rule__ButtonAction__Group__3__Impl rule__ButtonAction__Group__4 )
            // InternalBot.g:8687:2: rule__ButtonAction__Group__3__Impl rule__ButtonAction__Group__4
            {
            pushFollow(FOLLOW_51);
            rule__ButtonAction__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonAction__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__3"


    // $ANTLR start "rule__ButtonAction__Group__3__Impl"
    // InternalBot.g:8694:1: rule__ButtonAction__Group__3__Impl : ( ':' ) ;
    public final void rule__ButtonAction__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8698:1: ( ( ':' ) )
            // InternalBot.g:8699:1: ( ':' )
            {
            // InternalBot.g:8699:1: ( ':' )
            // InternalBot.g:8700:2: ':'
            {
             before(grammarAccess.getButtonActionAccess().getColonKeyword_3()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getButtonActionAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__3__Impl"


    // $ANTLR start "rule__ButtonAction__Group__4"
    // InternalBot.g:8709:1: rule__ButtonAction__Group__4 : rule__ButtonAction__Group__4__Impl ;
    public final void rule__ButtonAction__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8713:1: ( rule__ButtonAction__Group__4__Impl )
            // InternalBot.g:8714:2: rule__ButtonAction__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ButtonAction__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__4"


    // $ANTLR start "rule__ButtonAction__Group__4__Impl"
    // InternalBot.g:8720:1: rule__ButtonAction__Group__4__Impl : ( ( rule__ButtonAction__InputsAssignment_4 ) ) ;
    public final void rule__ButtonAction__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8724:1: ( ( ( rule__ButtonAction__InputsAssignment_4 ) ) )
            // InternalBot.g:8725:1: ( ( rule__ButtonAction__InputsAssignment_4 ) )
            {
            // InternalBot.g:8725:1: ( ( rule__ButtonAction__InputsAssignment_4 ) )
            // InternalBot.g:8726:2: ( rule__ButtonAction__InputsAssignment_4 )
            {
             before(grammarAccess.getButtonActionAccess().getInputsAssignment_4()); 
            // InternalBot.g:8727:2: ( rule__ButtonAction__InputsAssignment_4 )
            // InternalBot.g:8727:3: rule__ButtonAction__InputsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ButtonAction__InputsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getButtonActionAccess().getInputsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__Group__4__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__0"
    // InternalBot.g:8736:1: rule__ButtonLanguageInput__Group__0 : rule__ButtonLanguageInput__Group__0__Impl rule__ButtonLanguageInput__Group__1 ;
    public final void rule__ButtonLanguageInput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8740:1: ( rule__ButtonLanguageInput__Group__0__Impl rule__ButtonLanguageInput__Group__1 )
            // InternalBot.g:8741:2: rule__ButtonLanguageInput__Group__0__Impl rule__ButtonLanguageInput__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__ButtonLanguageInput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__0"


    // $ANTLR start "rule__ButtonLanguageInput__Group__0__Impl"
    // InternalBot.g:8748:1: rule__ButtonLanguageInput__Group__0__Impl : ( ( rule__ButtonLanguageInput__Group_0__0 )? ) ;
    public final void rule__ButtonLanguageInput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8752:1: ( ( ( rule__ButtonLanguageInput__Group_0__0 )? ) )
            // InternalBot.g:8753:1: ( ( rule__ButtonLanguageInput__Group_0__0 )? )
            {
            // InternalBot.g:8753:1: ( ( rule__ButtonLanguageInput__Group_0__0 )? )
            // InternalBot.g:8754:2: ( rule__ButtonLanguageInput__Group_0__0 )?
            {
             before(grammarAccess.getButtonLanguageInputAccess().getGroup_0()); 
            // InternalBot.g:8755:2: ( rule__ButtonLanguageInput__Group_0__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==63) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalBot.g:8755:3: rule__ButtonLanguageInput__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ButtonLanguageInput__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getButtonLanguageInputAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__0__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__1"
    // InternalBot.g:8763:1: rule__ButtonLanguageInput__Group__1 : rule__ButtonLanguageInput__Group__1__Impl rule__ButtonLanguageInput__Group__2 ;
    public final void rule__ButtonLanguageInput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8767:1: ( rule__ButtonLanguageInput__Group__1__Impl rule__ButtonLanguageInput__Group__2 )
            // InternalBot.g:8768:2: rule__ButtonLanguageInput__Group__1__Impl rule__ButtonLanguageInput__Group__2
            {
            pushFollow(FOLLOW_70);
            rule__ButtonLanguageInput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__1"


    // $ANTLR start "rule__ButtonLanguageInput__Group__1__Impl"
    // InternalBot.g:8775:1: rule__ButtonLanguageInput__Group__1__Impl : ( '{' ) ;
    public final void rule__ButtonLanguageInput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8779:1: ( ( '{' ) )
            // InternalBot.g:8780:1: ( '{' )
            {
            // InternalBot.g:8780:1: ( '{' )
            // InternalBot.g:8781:2: '{'
            {
             before(grammarAccess.getButtonLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getButtonLanguageInputAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__1__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__2"
    // InternalBot.g:8790:1: rule__ButtonLanguageInput__Group__2 : rule__ButtonLanguageInput__Group__2__Impl rule__ButtonLanguageInput__Group__3 ;
    public final void rule__ButtonLanguageInput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8794:1: ( rule__ButtonLanguageInput__Group__2__Impl rule__ButtonLanguageInput__Group__3 )
            // InternalBot.g:8795:2: rule__ButtonLanguageInput__Group__2__Impl rule__ButtonLanguageInput__Group__3
            {
            pushFollow(FOLLOW_61);
            rule__ButtonLanguageInput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__2"


    // $ANTLR start "rule__ButtonLanguageInput__Group__2__Impl"
    // InternalBot.g:8802:1: rule__ButtonLanguageInput__Group__2__Impl : ( 'text:' ) ;
    public final void rule__ButtonLanguageInput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8806:1: ( ( 'text:' ) )
            // InternalBot.g:8807:1: ( 'text:' )
            {
            // InternalBot.g:8807:1: ( 'text:' )
            // InternalBot.g:8808:2: 'text:'
            {
             before(grammarAccess.getButtonLanguageInputAccess().getTextKeyword_2()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getButtonLanguageInputAccess().getTextKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__2__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__3"
    // InternalBot.g:8817:1: rule__ButtonLanguageInput__Group__3 : rule__ButtonLanguageInput__Group__3__Impl rule__ButtonLanguageInput__Group__4 ;
    public final void rule__ButtonLanguageInput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8821:1: ( rule__ButtonLanguageInput__Group__3__Impl rule__ButtonLanguageInput__Group__4 )
            // InternalBot.g:8822:2: rule__ButtonLanguageInput__Group__3__Impl rule__ButtonLanguageInput__Group__4
            {
            pushFollow(FOLLOW_71);
            rule__ButtonLanguageInput__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__3"


    // $ANTLR start "rule__ButtonLanguageInput__Group__3__Impl"
    // InternalBot.g:8829:1: rule__ButtonLanguageInput__Group__3__Impl : ( ( rule__ButtonLanguageInput__TextAssignment_3 ) ) ;
    public final void rule__ButtonLanguageInput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8833:1: ( ( ( rule__ButtonLanguageInput__TextAssignment_3 ) ) )
            // InternalBot.g:8834:1: ( ( rule__ButtonLanguageInput__TextAssignment_3 ) )
            {
            // InternalBot.g:8834:1: ( ( rule__ButtonLanguageInput__TextAssignment_3 ) )
            // InternalBot.g:8835:2: ( rule__ButtonLanguageInput__TextAssignment_3 )
            {
             before(grammarAccess.getButtonLanguageInputAccess().getTextAssignment_3()); 
            // InternalBot.g:8836:2: ( rule__ButtonLanguageInput__TextAssignment_3 )
            // InternalBot.g:8836:3: rule__ButtonLanguageInput__TextAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__TextAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getButtonLanguageInputAccess().getTextAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__3__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__4"
    // InternalBot.g:8844:1: rule__ButtonLanguageInput__Group__4 : rule__ButtonLanguageInput__Group__4__Impl rule__ButtonLanguageInput__Group__5 ;
    public final void rule__ButtonLanguageInput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8848:1: ( rule__ButtonLanguageInput__Group__4__Impl rule__ButtonLanguageInput__Group__5 )
            // InternalBot.g:8849:2: rule__ButtonLanguageInput__Group__4__Impl rule__ButtonLanguageInput__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__ButtonLanguageInput__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__4"


    // $ANTLR start "rule__ButtonLanguageInput__Group__4__Impl"
    // InternalBot.g:8856:1: rule__ButtonLanguageInput__Group__4__Impl : ( 'buttons:' ) ;
    public final void rule__ButtonLanguageInput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8860:1: ( ( 'buttons:' ) )
            // InternalBot.g:8861:1: ( 'buttons:' )
            {
            // InternalBot.g:8861:1: ( 'buttons:' )
            // InternalBot.g:8862:2: 'buttons:'
            {
             before(grammarAccess.getButtonLanguageInputAccess().getButtonsKeyword_4()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getButtonLanguageInputAccess().getButtonsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__4__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__5"
    // InternalBot.g:8871:1: rule__ButtonLanguageInput__Group__5 : rule__ButtonLanguageInput__Group__5__Impl rule__ButtonLanguageInput__Group__6 ;
    public final void rule__ButtonLanguageInput__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8875:1: ( rule__ButtonLanguageInput__Group__5__Impl rule__ButtonLanguageInput__Group__6 )
            // InternalBot.g:8876:2: rule__ButtonLanguageInput__Group__5__Impl rule__ButtonLanguageInput__Group__6
            {
            pushFollow(FOLLOW_32);
            rule__ButtonLanguageInput__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__5"


    // $ANTLR start "rule__ButtonLanguageInput__Group__5__Impl"
    // InternalBot.g:8883:1: rule__ButtonLanguageInput__Group__5__Impl : ( ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 ) ) ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 )* ) ) ;
    public final void rule__ButtonLanguageInput__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8887:1: ( ( ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 ) ) ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 )* ) ) )
            // InternalBot.g:8888:1: ( ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 ) ) ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 )* ) )
            {
            // InternalBot.g:8888:1: ( ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 ) ) ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 )* ) )
            // InternalBot.g:8889:2: ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 ) ) ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 )* )
            {
            // InternalBot.g:8889:2: ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 ) )
            // InternalBot.g:8890:3: ( rule__ButtonLanguageInput__ButtonsAssignment_5 )
            {
             before(grammarAccess.getButtonLanguageInputAccess().getButtonsAssignment_5()); 
            // InternalBot.g:8891:3: ( rule__ButtonLanguageInput__ButtonsAssignment_5 )
            // InternalBot.g:8891:4: rule__ButtonLanguageInput__ButtonsAssignment_5
            {
            pushFollow(FOLLOW_14);
            rule__ButtonLanguageInput__ButtonsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getButtonLanguageInputAccess().getButtonsAssignment_5()); 

            }

            // InternalBot.g:8894:2: ( ( rule__ButtonLanguageInput__ButtonsAssignment_5 )* )
            // InternalBot.g:8895:3: ( rule__ButtonLanguageInput__ButtonsAssignment_5 )*
            {
             before(grammarAccess.getButtonLanguageInputAccess().getButtonsAssignment_5()); 
            // InternalBot.g:8896:3: ( rule__ButtonLanguageInput__ButtonsAssignment_5 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==60) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalBot.g:8896:4: rule__ButtonLanguageInput__ButtonsAssignment_5
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__ButtonLanguageInput__ButtonsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

             after(grammarAccess.getButtonLanguageInputAccess().getButtonsAssignment_5()); 

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
    // $ANTLR end "rule__ButtonLanguageInput__Group__5__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group__6"
    // InternalBot.g:8905:1: rule__ButtonLanguageInput__Group__6 : rule__ButtonLanguageInput__Group__6__Impl ;
    public final void rule__ButtonLanguageInput__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8909:1: ( rule__ButtonLanguageInput__Group__6__Impl )
            // InternalBot.g:8910:2: rule__ButtonLanguageInput__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__6"


    // $ANTLR start "rule__ButtonLanguageInput__Group__6__Impl"
    // InternalBot.g:8916:1: rule__ButtonLanguageInput__Group__6__Impl : ( '}' ) ;
    public final void rule__ButtonLanguageInput__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8920:1: ( ( '}' ) )
            // InternalBot.g:8921:1: ( '}' )
            {
            // InternalBot.g:8921:1: ( '}' )
            // InternalBot.g:8922:2: '}'
            {
             before(grammarAccess.getButtonLanguageInputAccess().getRightCurlyBracketKeyword_6()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getButtonLanguageInputAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group__6__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0__0"
    // InternalBot.g:8932:1: rule__ButtonLanguageInput__Group_0__0 : rule__ButtonLanguageInput__Group_0__0__Impl rule__ButtonLanguageInput__Group_0__1 ;
    public final void rule__ButtonLanguageInput__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8936:1: ( rule__ButtonLanguageInput__Group_0__0__Impl rule__ButtonLanguageInput__Group_0__1 )
            // InternalBot.g:8937:2: rule__ButtonLanguageInput__Group_0__0__Impl rule__ButtonLanguageInput__Group_0__1
            {
            pushFollow(FOLLOW_53);
            rule__ButtonLanguageInput__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0__0"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0__0__Impl"
    // InternalBot.g:8944:1: rule__ButtonLanguageInput__Group_0__0__Impl : ( 'inputs' ) ;
    public final void rule__ButtonLanguageInput__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8948:1: ( ( 'inputs' ) )
            // InternalBot.g:8949:1: ( 'inputs' )
            {
            // InternalBot.g:8949:1: ( 'inputs' )
            // InternalBot.g:8950:2: 'inputs'
            {
             before(grammarAccess.getButtonLanguageInputAccess().getInputsKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getButtonLanguageInputAccess().getInputsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0__0__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0__1"
    // InternalBot.g:8959:1: rule__ButtonLanguageInput__Group_0__1 : rule__ButtonLanguageInput__Group_0__1__Impl ;
    public final void rule__ButtonLanguageInput__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8963:1: ( rule__ButtonLanguageInput__Group_0__1__Impl )
            // InternalBot.g:8964:2: rule__ButtonLanguageInput__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0__1"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0__1__Impl"
    // InternalBot.g:8970:1: rule__ButtonLanguageInput__Group_0__1__Impl : ( ( rule__ButtonLanguageInput__Group_0_1__0 )? ) ;
    public final void rule__ButtonLanguageInput__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8974:1: ( ( ( rule__ButtonLanguageInput__Group_0_1__0 )? ) )
            // InternalBot.g:8975:1: ( ( rule__ButtonLanguageInput__Group_0_1__0 )? )
            {
            // InternalBot.g:8975:1: ( ( rule__ButtonLanguageInput__Group_0_1__0 )? )
            // InternalBot.g:8976:2: ( rule__ButtonLanguageInput__Group_0_1__0 )?
            {
             before(grammarAccess.getButtonLanguageInputAccess().getGroup_0_1()); 
            // InternalBot.g:8977:2: ( rule__ButtonLanguageInput__Group_0_1__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==66) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalBot.g:8977:3: rule__ButtonLanguageInput__Group_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ButtonLanguageInput__Group_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getButtonLanguageInputAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0__1__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0_1__0"
    // InternalBot.g:8986:1: rule__ButtonLanguageInput__Group_0_1__0 : rule__ButtonLanguageInput__Group_0_1__0__Impl rule__ButtonLanguageInput__Group_0_1__1 ;
    public final void rule__ButtonLanguageInput__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:8990:1: ( rule__ButtonLanguageInput__Group_0_1__0__Impl rule__ButtonLanguageInput__Group_0_1__1 )
            // InternalBot.g:8991:2: rule__ButtonLanguageInput__Group_0_1__0__Impl rule__ButtonLanguageInput__Group_0_1__1
            {
            pushFollow(FOLLOW_8);
            rule__ButtonLanguageInput__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0_1__0"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0_1__0__Impl"
    // InternalBot.g:8998:1: rule__ButtonLanguageInput__Group_0_1__0__Impl : ( 'in' ) ;
    public final void rule__ButtonLanguageInput__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9002:1: ( ( 'in' ) )
            // InternalBot.g:9003:1: ( 'in' )
            {
            // InternalBot.g:9003:1: ( 'in' )
            // InternalBot.g:9004:2: 'in'
            {
             before(grammarAccess.getButtonLanguageInputAccess().getInKeyword_0_1_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getButtonLanguageInputAccess().getInKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0_1__0__Impl"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0_1__1"
    // InternalBot.g:9013:1: rule__ButtonLanguageInput__Group_0_1__1 : rule__ButtonLanguageInput__Group_0_1__1__Impl ;
    public final void rule__ButtonLanguageInput__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9017:1: ( rule__ButtonLanguageInput__Group_0_1__1__Impl )
            // InternalBot.g:9018:2: rule__ButtonLanguageInput__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__Group_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0_1__1"


    // $ANTLR start "rule__ButtonLanguageInput__Group_0_1__1__Impl"
    // InternalBot.g:9024:1: rule__ButtonLanguageInput__Group_0_1__1__Impl : ( ( rule__ButtonLanguageInput__LanguageAssignment_0_1_1 ) ) ;
    public final void rule__ButtonLanguageInput__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9028:1: ( ( ( rule__ButtonLanguageInput__LanguageAssignment_0_1_1 ) ) )
            // InternalBot.g:9029:1: ( ( rule__ButtonLanguageInput__LanguageAssignment_0_1_1 ) )
            {
            // InternalBot.g:9029:1: ( ( rule__ButtonLanguageInput__LanguageAssignment_0_1_1 ) )
            // InternalBot.g:9030:2: ( rule__ButtonLanguageInput__LanguageAssignment_0_1_1 )
            {
             before(grammarAccess.getButtonLanguageInputAccess().getLanguageAssignment_0_1_1()); 
            // InternalBot.g:9031:2: ( rule__ButtonLanguageInput__LanguageAssignment_0_1_1 )
            // InternalBot.g:9031:3: rule__ButtonLanguageInput__LanguageAssignment_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ButtonLanguageInput__LanguageAssignment_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getButtonLanguageInputAccess().getLanguageAssignment_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__Group_0_1__1__Impl"


    // $ANTLR start "rule__Button__Group__0"
    // InternalBot.g:9040:1: rule__Button__Group__0 : rule__Button__Group__0__Impl rule__Button__Group__1 ;
    public final void rule__Button__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9044:1: ( rule__Button__Group__0__Impl rule__Button__Group__1 )
            // InternalBot.g:9045:2: rule__Button__Group__0__Impl rule__Button__Group__1
            {
            pushFollow(FOLLOW_72);
            rule__Button__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Button__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__0"


    // $ANTLR start "rule__Button__Group__0__Impl"
    // InternalBot.g:9052:1: rule__Button__Group__0__Impl : ( '-' ) ;
    public final void rule__Button__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9056:1: ( ( '-' ) )
            // InternalBot.g:9057:1: ( '-' )
            {
            // InternalBot.g:9057:1: ( '-' )
            // InternalBot.g:9058:2: '-'
            {
             before(grammarAccess.getButtonAccess().getHyphenMinusKeyword_0()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getButtonAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__0__Impl"


    // $ANTLR start "rule__Button__Group__1"
    // InternalBot.g:9067:1: rule__Button__Group__1 : rule__Button__Group__1__Impl rule__Button__Group__2 ;
    public final void rule__Button__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9071:1: ( rule__Button__Group__1__Impl rule__Button__Group__2 )
            // InternalBot.g:9072:2: rule__Button__Group__1__Impl rule__Button__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Button__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Button__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__1"


    // $ANTLR start "rule__Button__Group__1__Impl"
    // InternalBot.g:9079:1: rule__Button__Group__1__Impl : ( 'value:' ) ;
    public final void rule__Button__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9083:1: ( ( 'value:' ) )
            // InternalBot.g:9084:1: ( 'value:' )
            {
            // InternalBot.g:9084:1: ( 'value:' )
            // InternalBot.g:9085:2: 'value:'
            {
             before(grammarAccess.getButtonAccess().getValueKeyword_1()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getButtonAccess().getValueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__1__Impl"


    // $ANTLR start "rule__Button__Group__2"
    // InternalBot.g:9094:1: rule__Button__Group__2 : rule__Button__Group__2__Impl rule__Button__Group__3 ;
    public final void rule__Button__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9098:1: ( rule__Button__Group__2__Impl rule__Button__Group__3 )
            // InternalBot.g:9099:2: rule__Button__Group__2__Impl rule__Button__Group__3
            {
            pushFollow(FOLLOW_73);
            rule__Button__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Button__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__2"


    // $ANTLR start "rule__Button__Group__2__Impl"
    // InternalBot.g:9106:1: rule__Button__Group__2__Impl : ( ( rule__Button__ValueAssignment_2 ) ) ;
    public final void rule__Button__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9110:1: ( ( ( rule__Button__ValueAssignment_2 ) ) )
            // InternalBot.g:9111:1: ( ( rule__Button__ValueAssignment_2 ) )
            {
            // InternalBot.g:9111:1: ( ( rule__Button__ValueAssignment_2 ) )
            // InternalBot.g:9112:2: ( rule__Button__ValueAssignment_2 )
            {
             before(grammarAccess.getButtonAccess().getValueAssignment_2()); 
            // InternalBot.g:9113:2: ( rule__Button__ValueAssignment_2 )
            // InternalBot.g:9113:3: rule__Button__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Button__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getButtonAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__2__Impl"


    // $ANTLR start "rule__Button__Group__3"
    // InternalBot.g:9121:1: rule__Button__Group__3 : rule__Button__Group__3__Impl ;
    public final void rule__Button__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9125:1: ( rule__Button__Group__3__Impl )
            // InternalBot.g:9126:2: rule__Button__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Button__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__3"


    // $ANTLR start "rule__Button__Group__3__Impl"
    // InternalBot.g:9132:1: rule__Button__Group__3__Impl : ( ( rule__Button__Group_3__0 )? ) ;
    public final void rule__Button__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9136:1: ( ( ( rule__Button__Group_3__0 )? ) )
            // InternalBot.g:9137:1: ( ( rule__Button__Group_3__0 )? )
            {
            // InternalBot.g:9137:1: ( ( rule__Button__Group_3__0 )? )
            // InternalBot.g:9138:2: ( rule__Button__Group_3__0 )?
            {
             before(grammarAccess.getButtonAccess().getGroup_3()); 
            // InternalBot.g:9139:2: ( rule__Button__Group_3__0 )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==98) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalBot.g:9139:3: rule__Button__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Button__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getButtonAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group__3__Impl"


    // $ANTLR start "rule__Button__Group_3__0"
    // InternalBot.g:9148:1: rule__Button__Group_3__0 : rule__Button__Group_3__0__Impl rule__Button__Group_3__1 ;
    public final void rule__Button__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9152:1: ( rule__Button__Group_3__0__Impl rule__Button__Group_3__1 )
            // InternalBot.g:9153:2: rule__Button__Group_3__0__Impl rule__Button__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Button__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Button__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group_3__0"


    // $ANTLR start "rule__Button__Group_3__0__Impl"
    // InternalBot.g:9160:1: rule__Button__Group_3__0__Impl : ( 'action:' ) ;
    public final void rule__Button__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9164:1: ( ( 'action:' ) )
            // InternalBot.g:9165:1: ( 'action:' )
            {
            // InternalBot.g:9165:1: ( 'action:' )
            // InternalBot.g:9166:2: 'action:'
            {
             before(grammarAccess.getButtonAccess().getActionKeyword_3_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getButtonAccess().getActionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group_3__0__Impl"


    // $ANTLR start "rule__Button__Group_3__1"
    // InternalBot.g:9175:1: rule__Button__Group_3__1 : rule__Button__Group_3__1__Impl ;
    public final void rule__Button__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9179:1: ( rule__Button__Group_3__1__Impl )
            // InternalBot.g:9180:2: rule__Button__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Button__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group_3__1"


    // $ANTLR start "rule__Button__Group_3__1__Impl"
    // InternalBot.g:9186:1: rule__Button__Group_3__1__Impl : ( ( rule__Button__ActionAssignment_3_1 ) ) ;
    public final void rule__Button__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9190:1: ( ( ( rule__Button__ActionAssignment_3_1 ) ) )
            // InternalBot.g:9191:1: ( ( rule__Button__ActionAssignment_3_1 ) )
            {
            // InternalBot.g:9191:1: ( ( rule__Button__ActionAssignment_3_1 ) )
            // InternalBot.g:9192:2: ( rule__Button__ActionAssignment_3_1 )
            {
             before(grammarAccess.getButtonAccess().getActionAssignment_3_1()); 
            // InternalBot.g:9193:2: ( rule__Button__ActionAssignment_3_1 )
            // InternalBot.g:9193:3: rule__Button__ActionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Button__ActionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getButtonAccess().getActionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__Group_3__1__Impl"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__Group__0"
    // InternalBot.g:9202:1: rule__TextLanguageInputHttpResponse__Group__0 : rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9206:1: ( rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1 )
            // InternalBot.g:9207:2: rule__TextLanguageInputHttpResponse__Group__0__Impl rule__TextLanguageInputHttpResponse__Group__1
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
    // InternalBot.g:9214:1: rule__TextLanguageInputHttpResponse__Group__0__Impl : ( 'inputs' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9218:1: ( ( 'inputs' ) )
            // InternalBot.g:9219:1: ( 'inputs' )
            {
            // InternalBot.g:9219:1: ( 'inputs' )
            // InternalBot.g:9220:2: 'inputs'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalBot.g:9229:1: rule__TextLanguageInputHttpResponse__Group__1 : rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 ;
    public final void rule__TextLanguageInputHttpResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9233:1: ( rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2 )
            // InternalBot.g:9234:2: rule__TextLanguageInputHttpResponse__Group__1__Impl rule__TextLanguageInputHttpResponse__Group__2
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
    // InternalBot.g:9241:1: rule__TextLanguageInputHttpResponse__Group__1__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9245:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? ) )
            // InternalBot.g:9246:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            {
            // InternalBot.g:9246:1: ( ( rule__TextLanguageInputHttpResponse__Group_1__0 )? )
            // InternalBot.g:9247:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_1()); 
            // InternalBot.g:9248:2: ( rule__TextLanguageInputHttpResponse__Group_1__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==66) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalBot.g:9248:3: rule__TextLanguageInputHttpResponse__Group_1__0
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
    // InternalBot.g:9256:1: rule__TextLanguageInputHttpResponse__Group__2 : rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 ;
    public final void rule__TextLanguageInputHttpResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9260:1: ( rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3 )
            // InternalBot.g:9261:2: rule__TextLanguageInputHttpResponse__Group__2__Impl rule__TextLanguageInputHttpResponse__Group__3
            {
            pushFollow(FOLLOW_74);
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
    // InternalBot.g:9268:1: rule__TextLanguageInputHttpResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9272:1: ( ( '{' ) )
            // InternalBot.g:9273:1: ( '{' )
            {
            // InternalBot.g:9273:1: ( '{' )
            // InternalBot.g:9274:2: '{'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,64,FOLLOW_2); 
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
    // InternalBot.g:9283:1: rule__TextLanguageInputHttpResponse__Group__3 : rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 ;
    public final void rule__TextLanguageInputHttpResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9287:1: ( rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4 )
            // InternalBot.g:9288:2: rule__TextLanguageInputHttpResponse__Group__3__Impl rule__TextLanguageInputHttpResponse__Group__4
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
    // InternalBot.g:9295:1: rule__TextLanguageInputHttpResponse__Group__3__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9299:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) ) )
            // InternalBot.g:9300:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            {
            // InternalBot.g:9300:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 ) )
            // InternalBot.g:9301:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_3()); 
            // InternalBot.g:9302:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_3 )
            // InternalBot.g:9302:3: rule__TextLanguageInputHttpResponse__InputsAssignment_3
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
    // InternalBot.g:9310:1: rule__TextLanguageInputHttpResponse__Group__4 : rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 ;
    public final void rule__TextLanguageInputHttpResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9314:1: ( rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5 )
            // InternalBot.g:9315:2: rule__TextLanguageInputHttpResponse__Group__4__Impl rule__TextLanguageInputHttpResponse__Group__5
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
    // InternalBot.g:9322:1: rule__TextLanguageInputHttpResponse__Group__4__Impl : ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9326:1: ( ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* ) )
            // InternalBot.g:9327:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            {
            // InternalBot.g:9327:1: ( ( rule__TextLanguageInputHttpResponse__Group_4__0 )* )
            // InternalBot.g:9328:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getGroup_4()); 
            // InternalBot.g:9329:2: ( rule__TextLanguageInputHttpResponse__Group_4__0 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==57) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalBot.g:9329:3: rule__TextLanguageInputHttpResponse__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__TextLanguageInputHttpResponse__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
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
    // InternalBot.g:9337:1: rule__TextLanguageInputHttpResponse__Group__5 : rule__TextLanguageInputHttpResponse__Group__5__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9341:1: ( rule__TextLanguageInputHttpResponse__Group__5__Impl )
            // InternalBot.g:9342:2: rule__TextLanguageInputHttpResponse__Group__5__Impl
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
    // InternalBot.g:9348:1: rule__TextLanguageInputHttpResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9352:1: ( ( '}' ) )
            // InternalBot.g:9353:1: ( '}' )
            {
            // InternalBot.g:9353:1: ( '}' )
            // InternalBot.g:9354:2: '}'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5()); 
            match(input,65,FOLLOW_2); 
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
    // InternalBot.g:9364:1: rule__TextLanguageInputHttpResponse__Group_1__0 : rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9368:1: ( rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1 )
            // InternalBot.g:9369:2: rule__TextLanguageInputHttpResponse__Group_1__0__Impl rule__TextLanguageInputHttpResponse__Group_1__1
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
    // InternalBot.g:9376:1: rule__TextLanguageInputHttpResponse__Group_1__0__Impl : ( 'in' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9380:1: ( ( 'in' ) )
            // InternalBot.g:9381:1: ( 'in' )
            {
            // InternalBot.g:9381:1: ( 'in' )
            // InternalBot.g:9382:2: 'in'
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalBot.g:9391:1: rule__TextLanguageInputHttpResponse__Group_1__1 : rule__TextLanguageInputHttpResponse__Group_1__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9395:1: ( rule__TextLanguageInputHttpResponse__Group_1__1__Impl )
            // InternalBot.g:9396:2: rule__TextLanguageInputHttpResponse__Group_1__1__Impl
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
    // InternalBot.g:9402:1: rule__TextLanguageInputHttpResponse__Group_1__1__Impl : ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9406:1: ( ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) ) )
            // InternalBot.g:9407:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            {
            // InternalBot.g:9407:1: ( ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 ) )
            // InternalBot.g:9408:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageAssignment_1_1()); 
            // InternalBot.g:9409:2: ( rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 )
            // InternalBot.g:9409:3: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1
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
    // InternalBot.g:9418:1: rule__TextLanguageInputHttpResponse__Group_4__0 : rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9422:1: ( rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1 )
            // InternalBot.g:9423:2: rule__TextLanguageInputHttpResponse__Group_4__0__Impl rule__TextLanguageInputHttpResponse__Group_4__1
            {
            pushFollow(FOLLOW_74);
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
    // InternalBot.g:9430:1: rule__TextLanguageInputHttpResponse__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9434:1: ( ( ',' ) )
            // InternalBot.g:9435:1: ( ',' )
            {
            // InternalBot.g:9435:1: ( ',' )
            // InternalBot.g:9436:2: ','
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalBot.g:9445:1: rule__TextLanguageInputHttpResponse__Group_4__1 : rule__TextLanguageInputHttpResponse__Group_4__1__Impl ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9449:1: ( rule__TextLanguageInputHttpResponse__Group_4__1__Impl )
            // InternalBot.g:9450:2: rule__TextLanguageInputHttpResponse__Group_4__1__Impl
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
    // InternalBot.g:9456:1: rule__TextLanguageInputHttpResponse__Group_4__1__Impl : ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) ;
    public final void rule__TextLanguageInputHttpResponse__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9460:1: ( ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) ) )
            // InternalBot.g:9461:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            {
            // InternalBot.g:9461:1: ( ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 ) )
            // InternalBot.g:9462:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            {
             before(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsAssignment_4_1()); 
            // InternalBot.g:9463:2: ( rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 )
            // InternalBot.g:9463:3: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1
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
    // InternalBot.g:9472:1: rule__KeyValue__Group__0 : rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 ;
    public final void rule__KeyValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9476:1: ( rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1 )
            // InternalBot.g:9477:2: rule__KeyValue__Group__0__Impl rule__KeyValue__Group__1
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
    // InternalBot.g:9484:1: rule__KeyValue__Group__0__Impl : ( ( rule__KeyValue__KeyAssignment_0 ) ) ;
    public final void rule__KeyValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9488:1: ( ( ( rule__KeyValue__KeyAssignment_0 ) ) )
            // InternalBot.g:9489:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            {
            // InternalBot.g:9489:1: ( ( rule__KeyValue__KeyAssignment_0 ) )
            // InternalBot.g:9490:2: ( rule__KeyValue__KeyAssignment_0 )
            {
             before(grammarAccess.getKeyValueAccess().getKeyAssignment_0()); 
            // InternalBot.g:9491:2: ( rule__KeyValue__KeyAssignment_0 )
            // InternalBot.g:9491:3: rule__KeyValue__KeyAssignment_0
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
    // InternalBot.g:9499:1: rule__KeyValue__Group__1 : rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 ;
    public final void rule__KeyValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9503:1: ( rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2 )
            // InternalBot.g:9504:2: rule__KeyValue__Group__1__Impl rule__KeyValue__Group__2
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
    // InternalBot.g:9511:1: rule__KeyValue__Group__1__Impl : ( ':' ) ;
    public final void rule__KeyValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9515:1: ( ( ':' ) )
            // InternalBot.g:9516:1: ( ':' )
            {
            // InternalBot.g:9516:1: ( ':' )
            // InternalBot.g:9517:2: ':'
            {
             before(grammarAccess.getKeyValueAccess().getColonKeyword_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:9526:1: rule__KeyValue__Group__2 : rule__KeyValue__Group__2__Impl ;
    public final void rule__KeyValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9530:1: ( rule__KeyValue__Group__2__Impl )
            // InternalBot.g:9531:2: rule__KeyValue__Group__2__Impl
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
    // InternalBot.g:9537:1: rule__KeyValue__Group__2__Impl : ( ( rule__KeyValue__ValueAssignment_2 ) ) ;
    public final void rule__KeyValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9541:1: ( ( ( rule__KeyValue__ValueAssignment_2 ) ) )
            // InternalBot.g:9542:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            {
            // InternalBot.g:9542:1: ( ( rule__KeyValue__ValueAssignment_2 ) )
            // InternalBot.g:9543:2: ( rule__KeyValue__ValueAssignment_2 )
            {
             before(grammarAccess.getKeyValueAccess().getValueAssignment_2()); 
            // InternalBot.g:9544:2: ( rule__KeyValue__ValueAssignment_2 )
            // InternalBot.g:9544:3: rule__KeyValue__ValueAssignment_2
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
    // InternalBot.g:9553:1: rule__Data__Group__0 : rule__Data__Group__0__Impl rule__Data__Group__1 ;
    public final void rule__Data__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9557:1: ( rule__Data__Group__0__Impl rule__Data__Group__1 )
            // InternalBot.g:9558:2: rule__Data__Group__0__Impl rule__Data__Group__1
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
    // InternalBot.g:9565:1: rule__Data__Group__0__Impl : ( ( rule__Data__KeyAssignment_0 ) ) ;
    public final void rule__Data__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9569:1: ( ( ( rule__Data__KeyAssignment_0 ) ) )
            // InternalBot.g:9570:1: ( ( rule__Data__KeyAssignment_0 ) )
            {
            // InternalBot.g:9570:1: ( ( rule__Data__KeyAssignment_0 ) )
            // InternalBot.g:9571:2: ( rule__Data__KeyAssignment_0 )
            {
             before(grammarAccess.getDataAccess().getKeyAssignment_0()); 
            // InternalBot.g:9572:2: ( rule__Data__KeyAssignment_0 )
            // InternalBot.g:9572:3: rule__Data__KeyAssignment_0
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
    // InternalBot.g:9580:1: rule__Data__Group__1 : rule__Data__Group__1__Impl rule__Data__Group__2 ;
    public final void rule__Data__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9584:1: ( rule__Data__Group__1__Impl rule__Data__Group__2 )
            // InternalBot.g:9585:2: rule__Data__Group__1__Impl rule__Data__Group__2
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
    // InternalBot.g:9592:1: rule__Data__Group__1__Impl : ( ':' ) ;
    public final void rule__Data__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9596:1: ( ( ':' ) )
            // InternalBot.g:9597:1: ( ':' )
            {
            // InternalBot.g:9597:1: ( ':' )
            // InternalBot.g:9598:2: ':'
            {
             before(grammarAccess.getDataAccess().getColonKeyword_1()); 
            match(input,54,FOLLOW_2); 
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
    // InternalBot.g:9607:1: rule__Data__Group__2 : rule__Data__Group__2__Impl ;
    public final void rule__Data__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9611:1: ( rule__Data__Group__2__Impl )
            // InternalBot.g:9612:2: rule__Data__Group__2__Impl
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
    // InternalBot.g:9618:1: rule__Data__Group__2__Impl : ( ( rule__Data__ValueAssignment_2 ) ) ;
    public final void rule__Data__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9622:1: ( ( ( rule__Data__ValueAssignment_2 ) ) )
            // InternalBot.g:9623:1: ( ( rule__Data__ValueAssignment_2 ) )
            {
            // InternalBot.g:9623:1: ( ( rule__Data__ValueAssignment_2 ) )
            // InternalBot.g:9624:2: ( rule__Data__ValueAssignment_2 )
            {
             before(grammarAccess.getDataAccess().getValueAssignment_2()); 
            // InternalBot.g:9625:2: ( rule__Data__ValueAssignment_2 )
            // InternalBot.g:9625:3: rule__Data__ValueAssignment_2
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
    // InternalBot.g:9634:1: rule__Bot__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Bot__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9638:1: ( ( ruleEString ) )
            // InternalBot.g:9639:2: ( ruleEString )
            {
            // InternalBot.g:9639:2: ( ruleEString )
            // InternalBot.g:9640:3: ruleEString
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
    // InternalBot.g:9649:1: rule__Bot__LanguagesAssignment_4 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9653:1: ( ( ruleLanguage ) )
            // InternalBot.g:9654:2: ( ruleLanguage )
            {
            // InternalBot.g:9654:2: ( ruleLanguage )
            // InternalBot.g:9655:3: ruleLanguage
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
    // InternalBot.g:9664:1: rule__Bot__LanguagesAssignment_5_1 : ( ruleLanguage ) ;
    public final void rule__Bot__LanguagesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9668:1: ( ( ruleLanguage ) )
            // InternalBot.g:9669:2: ( ruleLanguage )
            {
            // InternalBot.g:9669:2: ( ruleLanguage )
            // InternalBot.g:9670:3: ruleLanguage
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
    // InternalBot.g:9679:1: rule__Bot__IntentsAssignment_8 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9683:1: ( ( ruleIntent ) )
            // InternalBot.g:9684:2: ( ruleIntent )
            {
            // InternalBot.g:9684:2: ( ruleIntent )
            // InternalBot.g:9685:3: ruleIntent
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
    // InternalBot.g:9694:1: rule__Bot__IntentsAssignment_9 : ( ruleIntent ) ;
    public final void rule__Bot__IntentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9698:1: ( ( ruleIntent ) )
            // InternalBot.g:9699:2: ( ruleIntent )
            {
            // InternalBot.g:9699:2: ( ruleIntent )
            // InternalBot.g:9700:3: ruleIntent
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
    // InternalBot.g:9709:1: rule__Bot__EntitiesAssignment_10_2 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9713:1: ( ( ruleEntity ) )
            // InternalBot.g:9714:2: ( ruleEntity )
            {
            // InternalBot.g:9714:2: ( ruleEntity )
            // InternalBot.g:9715:3: ruleEntity
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
    // InternalBot.g:9724:1: rule__Bot__EntitiesAssignment_10_3 : ( ruleEntity ) ;
    public final void rule__Bot__EntitiesAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9728:1: ( ( ruleEntity ) )
            // InternalBot.g:9729:2: ( ruleEntity )
            {
            // InternalBot.g:9729:2: ( ruleEntity )
            // InternalBot.g:9730:3: ruleEntity
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
    // InternalBot.g:9739:1: rule__Bot__ActionsAssignment_11_2 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9743:1: ( ( ruleAction ) )
            // InternalBot.g:9744:2: ( ruleAction )
            {
            // InternalBot.g:9744:2: ( ruleAction )
            // InternalBot.g:9745:3: ruleAction
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
    // InternalBot.g:9754:1: rule__Bot__ActionsAssignment_11_3 : ( ruleAction ) ;
    public final void rule__Bot__ActionsAssignment_11_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9758:1: ( ( ruleAction ) )
            // InternalBot.g:9759:2: ( ruleAction )
            {
            // InternalBot.g:9759:2: ( ruleAction )
            // InternalBot.g:9760:3: ruleAction
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
    // InternalBot.g:9769:1: rule__Bot__FlowsAssignment_14_1 : ( ruleTransition ) ;
    public final void rule__Bot__FlowsAssignment_14_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9773:1: ( ( ruleTransition ) )
            // InternalBot.g:9774:2: ( ruleTransition )
            {
            // InternalBot.g:9774:2: ( ruleTransition )
            // InternalBot.g:9775:3: ruleTransition
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
    // InternalBot.g:9784:1: rule__Intent2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9788:1: ( ( ruleEString ) )
            // InternalBot.g:9789:2: ( ruleEString )
            {
            // InternalBot.g:9789:2: ( ruleEString )
            // InternalBot.g:9790:3: ruleEString
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
    // InternalBot.g:9799:1: rule__Intent2__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent2__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9803:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:9804:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:9804:2: ( ( 'Fallback' ) )
            // InternalBot.g:9805:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:9806:3: ( 'Fallback' )
            // InternalBot.g:9807:4: 'Fallback'
            {
             before(grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,99,FOLLOW_2); 
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
    // InternalBot.g:9818:1: rule__Intent2__InputsAssignment_3 : ( ruleIntentLanguageInputs ) ;
    public final void rule__Intent2__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9822:1: ( ( ruleIntentLanguageInputs ) )
            // InternalBot.g:9823:2: ( ruleIntentLanguageInputs )
            {
            // InternalBot.g:9823:2: ( ruleIntentLanguageInputs )
            // InternalBot.g:9824:3: ruleIntentLanguageInputs
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
    // InternalBot.g:9833:1: rule__Intent2__ParametersAssignment_4_2_0 : ( ruleParameter2 ) ;
    public final void rule__Intent2__ParametersAssignment_4_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9837:1: ( ( ruleParameter2 ) )
            // InternalBot.g:9838:2: ( ruleParameter2 )
            {
            // InternalBot.g:9838:2: ( ruleParameter2 )
            // InternalBot.g:9839:3: ruleParameter2
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
    // InternalBot.g:9848:1: rule__Intent2__ParametersAssignment_4_2_1 : ( ruleParameter ) ;
    public final void rule__Intent2__ParametersAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9852:1: ( ( ruleParameter ) )
            // InternalBot.g:9853:2: ( ruleParameter )
            {
            // InternalBot.g:9853:2: ( ruleParameter )
            // InternalBot.g:9854:3: ruleParameter
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
    // InternalBot.g:9863:1: rule__Intent1__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Intent1__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9867:1: ( ( ruleEString ) )
            // InternalBot.g:9868:2: ( ruleEString )
            {
            // InternalBot.g:9868:2: ( ruleEString )
            // InternalBot.g:9869:3: ruleEString
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
    // InternalBot.g:9878:1: rule__Intent1__FallbackIntentAssignment_1 : ( ( 'Fallback' ) ) ;
    public final void rule__Intent1__FallbackIntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9882:1: ( ( ( 'Fallback' ) ) )
            // InternalBot.g:9883:2: ( ( 'Fallback' ) )
            {
            // InternalBot.g:9883:2: ( ( 'Fallback' ) )
            // InternalBot.g:9884:3: ( 'Fallback' )
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 
            // InternalBot.g:9885:3: ( 'Fallback' )
            // InternalBot.g:9886:4: 'Fallback'
            {
             before(grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0()); 
            match(input,99,FOLLOW_2); 
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
    // InternalBot.g:9897:1: rule__IntentLanguageInputs__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__IntentLanguageInputs__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9901:1: ( ( ruleLanguage ) )
            // InternalBot.g:9902:2: ( ruleLanguage )
            {
            // InternalBot.g:9902:2: ( ruleLanguage )
            // InternalBot.g:9903:3: ruleLanguage
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
    // InternalBot.g:9912:1: rule__IntentLanguageInputs__InputsAssignment_3 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9916:1: ( ( ruleIntentInput ) )
            // InternalBot.g:9917:2: ( ruleIntentInput )
            {
            // InternalBot.g:9917:2: ( ruleIntentInput )
            // InternalBot.g:9918:3: ruleIntentInput
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
    // InternalBot.g:9927:1: rule__IntentLanguageInputs__InputsAssignment_4_1 : ( ruleIntentInput ) ;
    public final void rule__IntentLanguageInputs__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9931:1: ( ( ruleIntentInput ) )
            // InternalBot.g:9932:2: ( ruleIntentInput )
            {
            // InternalBot.g:9932:2: ( ruleIntentInput )
            // InternalBot.g:9933:3: ruleIntentInput
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
    // InternalBot.g:9942:1: rule__Transition__IntentAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__Transition__IntentAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9946:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9947:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9947:2: ( ( ruleEString ) )
            // InternalBot.g:9948:3: ( ruleEString )
            {
             before(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0()); 
            // InternalBot.g:9949:3: ( ruleEString )
            // InternalBot.g:9950:4: ruleEString
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
    // InternalBot.g:9961:1: rule__Transition__TargetAssignment_2_1 : ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) ;
    public final void rule__Transition__TargetAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9965:1: ( ( ( rule__Transition__TargetAlternatives_2_1_0 ) ) )
            // InternalBot.g:9966:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            {
            // InternalBot.g:9966:2: ( ( rule__Transition__TargetAlternatives_2_1_0 ) )
            // InternalBot.g:9967:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            {
             before(grammarAccess.getTransitionAccess().getTargetAlternatives_2_1_0()); 
            // InternalBot.g:9968:3: ( rule__Transition__TargetAlternatives_2_1_0 )
            // InternalBot.g:9968:4: rule__Transition__TargetAlternatives_2_1_0
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
    // InternalBot.g:9976:1: rule__State__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9980:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:9981:2: ( ( ruleEString ) )
            {
            // InternalBot.g:9981:2: ( ( ruleEString ) )
            // InternalBot.g:9982:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:9983:3: ( ruleEString )
            // InternalBot.g:9984:4: ruleEString
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
    // InternalBot.g:9995:1: rule__State__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:9999:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10000:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10000:2: ( ( ruleEString ) )
            // InternalBot.g:10001:3: ( ruleEString )
            {
             before(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:10002:3: ( ruleEString )
            // InternalBot.g:10003:4: ruleEString
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
    // InternalBot.g:10014:1: rule__State__OutcomingAssignment_3_1 : ( ruleTransition ) ;
    public final void rule__State__OutcomingAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10018:1: ( ( ruleTransition ) )
            // InternalBot.g:10019:2: ( ruleTransition )
            {
            // InternalBot.g:10019:2: ( ruleTransition )
            // InternalBot.g:10020:3: ruleTransition
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
    // InternalBot.g:10029:1: rule__State2__ActionsAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10033:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10034:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10034:2: ( ( ruleEString ) )
            // InternalBot.g:10035:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_1_0()); 
            // InternalBot.g:10036:3: ( ruleEString )
            // InternalBot.g:10037:4: ruleEString
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
    // InternalBot.g:10048:1: rule__State2__ActionsAssignment_2_1 : ( ( ruleEString ) ) ;
    public final void rule__State2__ActionsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10052:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10053:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10053:2: ( ( ruleEString ) )
            // InternalBot.g:10054:3: ( ruleEString )
            {
             before(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0()); 
            // InternalBot.g:10055:3: ( ruleEString )
            // InternalBot.g:10056:4: ruleEString
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
    // InternalBot.g:10067:1: rule__State2__OutcomingAssignment_4_1 : ( ruleTransition ) ;
    public final void rule__State2__OutcomingAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10071:1: ( ( ruleTransition ) )
            // InternalBot.g:10072:2: ( ruleTransition )
            {
            // InternalBot.g:10072:2: ( ruleTransition )
            // InternalBot.g:10073:3: ruleTransition
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
    // InternalBot.g:10082:1: rule__TrainingPhrase__TokensAssignment_1 : ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) ;
    public final void rule__TrainingPhrase__TokensAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10086:1: ( ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) ) )
            // InternalBot.g:10087:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            {
            // InternalBot.g:10087:2: ( ( rule__TrainingPhrase__TokensAlternatives_1_0 ) )
            // InternalBot.g:10088:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            {
             before(grammarAccess.getTrainingPhraseAccess().getTokensAlternatives_1_0()); 
            // InternalBot.g:10089:3: ( rule__TrainingPhrase__TokensAlternatives_1_0 )
            // InternalBot.g:10089:4: rule__TrainingPhrase__TokensAlternatives_1_0
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
    // InternalBot.g:10097:1: rule__Parameter__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10101:1: ( ( ruleEString ) )
            // InternalBot.g:10102:2: ( ruleEString )
            {
            // InternalBot.g:10102:2: ( ruleEString )
            // InternalBot.g:10103:3: ruleEString
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
    // InternalBot.g:10112:1: rule__Parameter__EntityAssignment_3_0 : ( ( ruleEString ) ) ;
    public final void rule__Parameter__EntityAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10116:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10117:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10117:2: ( ( ruleEString ) )
            // InternalBot.g:10118:3: ( ruleEString )
            {
             before(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0()); 
            // InternalBot.g:10119:3: ( ruleEString )
            // InternalBot.g:10120:4: ruleEString
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
    // InternalBot.g:10131:1: rule__Parameter__DefaultEntityAssignment_3_1 : ( ruleDefaultEntity ) ;
    public final void rule__Parameter__DefaultEntityAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10135:1: ( ( ruleDefaultEntity ) )
            // InternalBot.g:10136:2: ( ruleDefaultEntity )
            {
            // InternalBot.g:10136:2: ( ruleDefaultEntity )
            // InternalBot.g:10137:3: ruleDefaultEntity
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
    // InternalBot.g:10146:1: rule__Parameter__IsListAssignment_4_1 : ( ( 'isList' ) ) ;
    public final void rule__Parameter__IsListAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10150:1: ( ( ( 'isList' ) ) )
            // InternalBot.g:10151:2: ( ( 'isList' ) )
            {
            // InternalBot.g:10151:2: ( ( 'isList' ) )
            // InternalBot.g:10152:3: ( 'isList' )
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 
            // InternalBot.g:10153:3: ( 'isList' )
            // InternalBot.g:10154:4: 'isList'
            {
             before(grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0()); 
            match(input,100,FOLLOW_2); 
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
    // InternalBot.g:10165:1: rule__Parameter__RequiredAssignment_5_1 : ( ( 'required' ) ) ;
    public final void rule__Parameter__RequiredAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10169:1: ( ( ( 'required' ) ) )
            // InternalBot.g:10170:2: ( ( 'required' ) )
            {
            // InternalBot.g:10170:2: ( ( 'required' ) )
            // InternalBot.g:10171:3: ( 'required' )
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 
            // InternalBot.g:10172:3: ( 'required' )
            // InternalBot.g:10173:4: 'required'
            {
             before(grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0()); 
            match(input,101,FOLLOW_2); 
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
    // InternalBot.g:10184:1: rule__Parameter__PromptsAssignment_6_1 : ( rulePromptLanguage ) ;
    public final void rule__Parameter__PromptsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10188:1: ( ( rulePromptLanguage ) )
            // InternalBot.g:10189:2: ( rulePromptLanguage )
            {
            // InternalBot.g:10189:2: ( rulePromptLanguage )
            // InternalBot.g:10190:3: rulePromptLanguage
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
    // InternalBot.g:10199:1: rule__Parameter2__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Parameter2__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10203:1: ( ( ruleEString ) )
            // InternalBot.g:10204:2: ( ruleEString )
            {
            // InternalBot.g:10204:2: ( ruleEString )
            // InternalBot.g:10205:3: ruleEString
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
    // InternalBot.g:10214:1: rule__PromptLanguage__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__PromptLanguage__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10218:1: ( ( ruleLanguage ) )
            // InternalBot.g:10219:2: ( ruleLanguage )
            {
            // InternalBot.g:10219:2: ( ruleLanguage )
            // InternalBot.g:10220:3: ruleLanguage
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
    // InternalBot.g:10229:1: rule__PromptLanguage__PromptsAssignment_3 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10233:1: ( ( ruleEString ) )
            // InternalBot.g:10234:2: ( ruleEString )
            {
            // InternalBot.g:10234:2: ( ruleEString )
            // InternalBot.g:10235:3: ruleEString
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
    // InternalBot.g:10244:1: rule__PromptLanguage__PromptsAssignment_4_1 : ( ruleEString ) ;
    public final void rule__PromptLanguage__PromptsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10248:1: ( ( ruleEString ) )
            // InternalBot.g:10249:2: ( ruleEString )
            {
            // InternalBot.g:10249:2: ( ruleEString )
            // InternalBot.g:10250:3: ruleEString
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
    // InternalBot.g:10259:1: rule__Literal__TextAssignment : ( ruleEString ) ;
    public final void rule__Literal__TextAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10263:1: ( ( ruleEString ) )
            // InternalBot.g:10264:2: ( ruleEString )
            {
            // InternalBot.g:10264:2: ( ruleEString )
            // InternalBot.g:10265:3: ruleEString
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
    // InternalBot.g:10274:1: rule__EntityToken__EntityAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__EntityToken__EntityAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10278:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10279:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10279:2: ( ( ruleEString ) )
            // InternalBot.g:10280:3: ( ruleEString )
            {
             before(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0()); 
            // InternalBot.g:10281:3: ( ruleEString )
            // InternalBot.g:10282:4: ruleEString
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
    // InternalBot.g:10293:1: rule__ParameterToken__ParameterAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ParameterToken__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10297:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10298:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10298:2: ( ( ruleEString ) )
            // InternalBot.g:10299:3: ( ruleEString )
            {
             before(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0()); 
            // InternalBot.g:10300:3: ( ruleEString )
            // InternalBot.g:10301:4: ruleEString
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
    // InternalBot.g:10312:1: rule__ParameterRefenceToken__TextReferenceAssignment_1 : ( ruleEString ) ;
    public final void rule__ParameterRefenceToken__TextReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10316:1: ( ( ruleEString ) )
            // InternalBot.g:10317:2: ( ruleEString )
            {
            // InternalBot.g:10317:2: ( ruleEString )
            // InternalBot.g:10318:3: ruleEString
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
    // InternalBot.g:10327:1: rule__ParameterRefenceToken__ParameterAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__ParameterRefenceToken__ParameterAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10331:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10332:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10332:2: ( ( ruleEString ) )
            // InternalBot.g:10333:3: ( ruleEString )
            {
             before(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0()); 
            // InternalBot.g:10334:3: ( ruleEString )
            // InternalBot.g:10335:4: ruleEString
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
    // InternalBot.g:10346:1: rule__HTTPRequestToken__TypeAssignment_1 : ( ruleHTTPReturnType ) ;
    public final void rule__HTTPRequestToken__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10350:1: ( ( ruleHTTPReturnType ) )
            // InternalBot.g:10351:2: ( ruleHTTPReturnType )
            {
            // InternalBot.g:10351:2: ( ruleHTTPReturnType )
            // InternalBot.g:10352:3: ruleHTTPReturnType
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
    // InternalBot.g:10361:1: rule__HTTPRequestToken__DataKeyAssignment_2_1 : ( ruleEString ) ;
    public final void rule__HTTPRequestToken__DataKeyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10365:1: ( ( ruleEString ) )
            // InternalBot.g:10366:2: ( ruleEString )
            {
            // InternalBot.g:10366:2: ( ruleEString )
            // InternalBot.g:10367:3: ruleEString
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
    // InternalBot.g:10376:1: rule__SimpleEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__SimpleEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10380:1: ( ( ruleEString ) )
            // InternalBot.g:10381:2: ( ruleEString )
            {
            // InternalBot.g:10381:2: ( ruleEString )
            // InternalBot.g:10382:3: ruleEString
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
    // InternalBot.g:10391:1: rule__SimpleEntity__InputsAssignment_4 : ( ruleSLanguageInput ) ;
    public final void rule__SimpleEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10395:1: ( ( ruleSLanguageInput ) )
            // InternalBot.g:10396:2: ( ruleSLanguageInput )
            {
            // InternalBot.g:10396:2: ( ruleSLanguageInput )
            // InternalBot.g:10397:3: ruleSLanguageInput
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
    // InternalBot.g:10406:1: rule__ComplexEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__ComplexEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10410:1: ( ( ruleEString ) )
            // InternalBot.g:10411:2: ( ruleEString )
            {
            // InternalBot.g:10411:2: ( ruleEString )
            // InternalBot.g:10412:3: ruleEString
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
    // InternalBot.g:10421:1: rule__ComplexEntity__InputsAssignment_4 : ( ruleCLanguageInput ) ;
    public final void rule__ComplexEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10425:1: ( ( ruleCLanguageInput ) )
            // InternalBot.g:10426:2: ( ruleCLanguageInput )
            {
            // InternalBot.g:10426:2: ( ruleCLanguageInput )
            // InternalBot.g:10427:3: ruleCLanguageInput
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
    // InternalBot.g:10436:1: rule__RegexEntity__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__RegexEntity__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10440:1: ( ( ruleEString ) )
            // InternalBot.g:10441:2: ( ruleEString )
            {
            // InternalBot.g:10441:2: ( ruleEString )
            // InternalBot.g:10442:3: ruleEString
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
    // InternalBot.g:10451:1: rule__RegexEntity__InputsAssignment_4 : ( ruleRLanguageInput ) ;
    public final void rule__RegexEntity__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10455:1: ( ( ruleRLanguageInput ) )
            // InternalBot.g:10456:2: ( ruleRLanguageInput )
            {
            // InternalBot.g:10456:2: ( ruleRLanguageInput )
            // InternalBot.g:10457:3: ruleRLanguageInput
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
    // InternalBot.g:10466:1: rule__SLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__SLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10470:1: ( ( ruleLanguage ) )
            // InternalBot.g:10471:2: ( ruleLanguage )
            {
            // InternalBot.g:10471:2: ( ruleLanguage )
            // InternalBot.g:10472:3: ruleLanguage
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
    // InternalBot.g:10481:1: rule__SLanguageInput__InputsAssignment_2_0 : ( ruleSimpleInput ) ;
    public final void rule__SLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10485:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:10486:2: ( ruleSimpleInput )
            {
            // InternalBot.g:10486:2: ( ruleSimpleInput )
            // InternalBot.g:10487:3: ruleSimpleInput
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
    // InternalBot.g:10496:1: rule__SLanguageInput__InputsAssignment_2_1 : ( ruleSimpleInput ) ;
    public final void rule__SLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10500:1: ( ( ruleSimpleInput ) )
            // InternalBot.g:10501:2: ( ruleSimpleInput )
            {
            // InternalBot.g:10501:2: ( ruleSimpleInput )
            // InternalBot.g:10502:3: ruleSimpleInput
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
    // InternalBot.g:10511:1: rule__CLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__CLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10515:1: ( ( ruleLanguage ) )
            // InternalBot.g:10516:2: ( ruleLanguage )
            {
            // InternalBot.g:10516:2: ( ruleLanguage )
            // InternalBot.g:10517:3: ruleLanguage
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
    // InternalBot.g:10526:1: rule__CLanguageInput__InputsAssignment_2_0 : ( ruleCompositeInput ) ;
    public final void rule__CLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10530:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:10531:2: ( ruleCompositeInput )
            {
            // InternalBot.g:10531:2: ( ruleCompositeInput )
            // InternalBot.g:10532:3: ruleCompositeInput
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
    // InternalBot.g:10541:1: rule__CLanguageInput__InputsAssignment_2_1 : ( ruleCompositeInput ) ;
    public final void rule__CLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10545:1: ( ( ruleCompositeInput ) )
            // InternalBot.g:10546:2: ( ruleCompositeInput )
            {
            // InternalBot.g:10546:2: ( ruleCompositeInput )
            // InternalBot.g:10547:3: ruleCompositeInput
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
    // InternalBot.g:10556:1: rule__RLanguageInput__LanguageAssignment_0_2 : ( ruleLanguage ) ;
    public final void rule__RLanguageInput__LanguageAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10560:1: ( ( ruleLanguage ) )
            // InternalBot.g:10561:2: ( ruleLanguage )
            {
            // InternalBot.g:10561:2: ( ruleLanguage )
            // InternalBot.g:10562:3: ruleLanguage
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
    // InternalBot.g:10571:1: rule__RLanguageInput__InputsAssignment_2_0 : ( ruleRegexInput ) ;
    public final void rule__RLanguageInput__InputsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10575:1: ( ( ruleRegexInput ) )
            // InternalBot.g:10576:2: ( ruleRegexInput )
            {
            // InternalBot.g:10576:2: ( ruleRegexInput )
            // InternalBot.g:10577:3: ruleRegexInput
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
    // InternalBot.g:10586:1: rule__RLanguageInput__InputsAssignment_2_1 : ( ruleRegexInput ) ;
    public final void rule__RLanguageInput__InputsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10590:1: ( ( ruleRegexInput ) )
            // InternalBot.g:10591:2: ( ruleRegexInput )
            {
            // InternalBot.g:10591:2: ( ruleRegexInput )
            // InternalBot.g:10592:3: ruleRegexInput
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
    // InternalBot.g:10601:1: rule__RegexInput__ExpresionAssignment_3 : ( ruleEString ) ;
    public final void rule__RegexInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10605:1: ( ( ruleEString ) )
            // InternalBot.g:10606:2: ( ruleEString )
            {
            // InternalBot.g:10606:2: ( ruleEString )
            // InternalBot.g:10607:3: ruleEString
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
    // InternalBot.g:10616:1: rule__CompositeInput__ExpresionAssignment_3 : ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) ;
    public final void rule__CompositeInput__ExpresionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10620:1: ( ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) ) )
            // InternalBot.g:10621:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            {
            // InternalBot.g:10621:2: ( ( rule__CompositeInput__ExpresionAlternatives_3_0 ) )
            // InternalBot.g:10622:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            {
             before(grammarAccess.getCompositeInputAccess().getExpresionAlternatives_3_0()); 
            // InternalBot.g:10623:3: ( rule__CompositeInput__ExpresionAlternatives_3_0 )
            // InternalBot.g:10623:4: rule__CompositeInput__ExpresionAlternatives_3_0
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
    // InternalBot.g:10631:1: rule__SimpleInput__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10635:1: ( ( ruleEString ) )
            // InternalBot.g:10636:2: ( ruleEString )
            {
            // InternalBot.g:10636:2: ( ruleEString )
            // InternalBot.g:10637:3: ruleEString
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
    // InternalBot.g:10646:1: rule__SimpleInput__ValuesAssignment_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10650:1: ( ( ruleEString ) )
            // InternalBot.g:10651:2: ( ruleEString )
            {
            // InternalBot.g:10651:2: ( ruleEString )
            // InternalBot.g:10652:3: ruleEString
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
    // InternalBot.g:10661:1: rule__SimpleInput__ValuesAssignment_2_2_1 : ( ruleEString ) ;
    public final void rule__SimpleInput__ValuesAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10665:1: ( ( ruleEString ) )
            // InternalBot.g:10666:2: ( ruleEString )
            {
            // InternalBot.g:10666:2: ( ruleEString )
            // InternalBot.g:10667:3: ruleEString
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
    // InternalBot.g:10676:1: rule__Text__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Text__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10680:1: ( ( ruleEString ) )
            // InternalBot.g:10681:2: ( ruleEString )
            {
            // InternalBot.g:10681:2: ( ruleEString )
            // InternalBot.g:10682:3: ruleEString
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
    // InternalBot.g:10691:1: rule__Text__InputsAssignment_4 : ( ruleTextLanguageInput ) ;
    public final void rule__Text__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10695:1: ( ( ruleTextLanguageInput ) )
            // InternalBot.g:10696:2: ( ruleTextLanguageInput )
            {
            // InternalBot.g:10696:2: ( ruleTextLanguageInput )
            // InternalBot.g:10697:3: ruleTextLanguageInput
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
    // InternalBot.g:10706:1: rule__TextLanguageInput__LanguageAssignment_0_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInput__LanguageAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10710:1: ( ( ruleLanguage ) )
            // InternalBot.g:10711:2: ( ruleLanguage )
            {
            // InternalBot.g:10711:2: ( ruleLanguage )
            // InternalBot.g:10712:3: ruleLanguage
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
    // InternalBot.g:10721:1: rule__TextLanguageInput__InputsAssignment_2 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10725:1: ( ( ruleTextInputText ) )
            // InternalBot.g:10726:2: ( ruleTextInputText )
            {
            // InternalBot.g:10726:2: ( ruleTextInputText )
            // InternalBot.g:10727:3: ruleTextInputText
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
    // InternalBot.g:10736:1: rule__TextLanguageInput__InputsAssignment_3_1 : ( ruleTextInputText ) ;
    public final void rule__TextLanguageInput__InputsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10740:1: ( ( ruleTextInputText ) )
            // InternalBot.g:10741:2: ( ruleTextInputText )
            {
            // InternalBot.g:10741:2: ( ruleTextInputText )
            // InternalBot.g:10742:3: ruleTextInputText
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
    // InternalBot.g:10751:1: rule__HTTPResponse__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__HTTPResponse__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10755:1: ( ( ruleEString ) )
            // InternalBot.g:10756:2: ( ruleEString )
            {
            // InternalBot.g:10756:2: ( ruleEString )
            // InternalBot.g:10757:3: ruleEString
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
    // InternalBot.g:10766:1: rule__HTTPResponse__HTTPRequestAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__HTTPResponse__HTTPRequestAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10770:1: ( ( ( ruleEString ) ) )
            // InternalBot.g:10771:2: ( ( ruleEString ) )
            {
            // InternalBot.g:10771:2: ( ( ruleEString ) )
            // InternalBot.g:10772:3: ( ruleEString )
            {
             before(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_5_0()); 
            // InternalBot.g:10773:3: ( ruleEString )
            // InternalBot.g:10774:4: ruleEString
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
    // InternalBot.g:10785:1: rule__HTTPResponse__InputsAssignment_7 : ( ruleTextLanguageInputHttpResponse ) ;
    public final void rule__HTTPResponse__InputsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10789:1: ( ( ruleTextLanguageInputHttpResponse ) )
            // InternalBot.g:10790:2: ( ruleTextLanguageInputHttpResponse )
            {
            // InternalBot.g:10790:2: ( ruleTextLanguageInputHttpResponse )
            // InternalBot.g:10791:3: ruleTextLanguageInputHttpResponse
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
    // InternalBot.g:10800:1: rule__HTTPRequest__MethodAssignment_1 : ( ruleMethod ) ;
    public final void rule__HTTPRequest__MethodAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10804:1: ( ( ruleMethod ) )
            // InternalBot.g:10805:2: ( ruleMethod )
            {
            // InternalBot.g:10805:2: ( ruleMethod )
            // InternalBot.g:10806:3: ruleMethod
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
    // InternalBot.g:10815:1: rule__HTTPRequest__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__HTTPRequest__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10819:1: ( ( ruleEString ) )
            // InternalBot.g:10820:2: ( ruleEString )
            {
            // InternalBot.g:10820:2: ( ruleEString )
            // InternalBot.g:10821:3: ruleEString
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
    // InternalBot.g:10830:1: rule__HTTPRequest__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__HTTPRequest__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10834:1: ( ( ruleEString ) )
            // InternalBot.g:10835:2: ( ruleEString )
            {
            // InternalBot.g:10835:2: ( ruleEString )
            // InternalBot.g:10836:3: ruleEString
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
    // InternalBot.g:10845:1: rule__HTTPRequest__BasicAuthAssignment_8_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__BasicAuthAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10849:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10850:2: ( ruleKeyValue )
            {
            // InternalBot.g:10850:2: ( ruleKeyValue )
            // InternalBot.g:10851:3: ruleKeyValue
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
    // InternalBot.g:10860:1: rule__HTTPRequest__HeadersAssignment_9_2 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10864:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10865:2: ( ruleKeyValue )
            {
            // InternalBot.g:10865:2: ( ruleKeyValue )
            // InternalBot.g:10866:3: ruleKeyValue
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
    // InternalBot.g:10875:1: rule__HTTPRequest__HeadersAssignment_9_3_1 : ( ruleKeyValue ) ;
    public final void rule__HTTPRequest__HeadersAssignment_9_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10879:1: ( ( ruleKeyValue ) )
            // InternalBot.g:10880:2: ( ruleKeyValue )
            {
            // InternalBot.g:10880:2: ( ruleKeyValue )
            // InternalBot.g:10881:3: ruleKeyValue
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
    // InternalBot.g:10890:1: rule__HTTPRequest__DataAssignment_10_2 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10894:1: ( ( ruleData ) )
            // InternalBot.g:10895:2: ( ruleData )
            {
            // InternalBot.g:10895:2: ( ruleData )
            // InternalBot.g:10896:3: ruleData
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
    // InternalBot.g:10905:1: rule__HTTPRequest__DataAssignment_10_3_1 : ( ruleData ) ;
    public final void rule__HTTPRequest__DataAssignment_10_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10909:1: ( ( ruleData ) )
            // InternalBot.g:10910:2: ( ruleData )
            {
            // InternalBot.g:10910:2: ( ruleData )
            // InternalBot.g:10911:3: ruleData
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
    // InternalBot.g:10920:1: rule__HTTPRequest__DataTypeAssignment_10_7 : ( ruleDataType ) ;
    public final void rule__HTTPRequest__DataTypeAssignment_10_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10924:1: ( ( ruleDataType ) )
            // InternalBot.g:10925:2: ( ruleDataType )
            {
            // InternalBot.g:10925:2: ( ruleDataType )
            // InternalBot.g:10926:3: ruleDataType
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
    // InternalBot.g:10935:1: rule__Image__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Image__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10939:1: ( ( ruleEString ) )
            // InternalBot.g:10940:2: ( ruleEString )
            {
            // InternalBot.g:10940:2: ( ruleEString )
            // InternalBot.g:10941:3: ruleEString
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
    // InternalBot.g:10950:1: rule__Image__URLAssignment_6 : ( ruleEString ) ;
    public final void rule__Image__URLAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10954:1: ( ( ruleEString ) )
            // InternalBot.g:10955:2: ( ruleEString )
            {
            // InternalBot.g:10955:2: ( ruleEString )
            // InternalBot.g:10956:3: ruleEString
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
    // InternalBot.g:10965:1: rule__Image__CaptionAssignment_7_2 : ( ruleEString ) ;
    public final void rule__Image__CaptionAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10969:1: ( ( ruleEString ) )
            // InternalBot.g:10970:2: ( ruleEString )
            {
            // InternalBot.g:10970:2: ( ruleEString )
            // InternalBot.g:10971:3: ruleEString
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
    // InternalBot.g:10980:1: rule__Empty__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Empty__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10984:1: ( ( ruleEString ) )
            // InternalBot.g:10985:2: ( ruleEString )
            {
            // InternalBot.g:10985:2: ( ruleEString )
            // InternalBot.g:10986:3: ruleEString
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


    // $ANTLR start "rule__ButtonAction__NameAssignment_2"
    // InternalBot.g:10995:1: rule__ButtonAction__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__ButtonAction__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:10999:1: ( ( ruleEString ) )
            // InternalBot.g:11000:2: ( ruleEString )
            {
            // InternalBot.g:11000:2: ( ruleEString )
            // InternalBot.g:11001:3: ruleEString
            {
             before(grammarAccess.getButtonActionAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getButtonActionAccess().getNameEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__NameAssignment_2"


    // $ANTLR start "rule__ButtonAction__InputsAssignment_4"
    // InternalBot.g:11010:1: rule__ButtonAction__InputsAssignment_4 : ( ruleButtonLanguageInput ) ;
    public final void rule__ButtonAction__InputsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11014:1: ( ( ruleButtonLanguageInput ) )
            // InternalBot.g:11015:2: ( ruleButtonLanguageInput )
            {
            // InternalBot.g:11015:2: ( ruleButtonLanguageInput )
            // InternalBot.g:11016:3: ruleButtonLanguageInput
            {
             before(grammarAccess.getButtonActionAccess().getInputsButtonLanguageInputParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleButtonLanguageInput();

            state._fsp--;

             after(grammarAccess.getButtonActionAccess().getInputsButtonLanguageInputParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonAction__InputsAssignment_4"


    // $ANTLR start "rule__ButtonLanguageInput__LanguageAssignment_0_1_1"
    // InternalBot.g:11025:1: rule__ButtonLanguageInput__LanguageAssignment_0_1_1 : ( ruleLanguage ) ;
    public final void rule__ButtonLanguageInput__LanguageAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11029:1: ( ( ruleLanguage ) )
            // InternalBot.g:11030:2: ( ruleLanguage )
            {
            // InternalBot.g:11030:2: ( ruleLanguage )
            // InternalBot.g:11031:3: ruleLanguage
            {
             before(grammarAccess.getButtonLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLanguage();

            state._fsp--;

             after(grammarAccess.getButtonLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__LanguageAssignment_0_1_1"


    // $ANTLR start "rule__ButtonLanguageInput__TextAssignment_3"
    // InternalBot.g:11040:1: rule__ButtonLanguageInput__TextAssignment_3 : ( ruleTextInputText ) ;
    public final void rule__ButtonLanguageInput__TextAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11044:1: ( ( ruleTextInputText ) )
            // InternalBot.g:11045:2: ( ruleTextInputText )
            {
            // InternalBot.g:11045:2: ( ruleTextInputText )
            // InternalBot.g:11046:3: ruleTextInputText
            {
             before(grammarAccess.getButtonLanguageInputAccess().getTextTextInputTextParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTextInputText();

            state._fsp--;

             after(grammarAccess.getButtonLanguageInputAccess().getTextTextInputTextParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__TextAssignment_3"


    // $ANTLR start "rule__ButtonLanguageInput__ButtonsAssignment_5"
    // InternalBot.g:11055:1: rule__ButtonLanguageInput__ButtonsAssignment_5 : ( ruleButton ) ;
    public final void rule__ButtonLanguageInput__ButtonsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11059:1: ( ( ruleButton ) )
            // InternalBot.g:11060:2: ( ruleButton )
            {
            // InternalBot.g:11060:2: ( ruleButton )
            // InternalBot.g:11061:3: ruleButton
            {
             before(grammarAccess.getButtonLanguageInputAccess().getButtonsButtonParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleButton();

            state._fsp--;

             after(grammarAccess.getButtonLanguageInputAccess().getButtonsButtonParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ButtonLanguageInput__ButtonsAssignment_5"


    // $ANTLR start "rule__Button__ValueAssignment_2"
    // InternalBot.g:11070:1: rule__Button__ValueAssignment_2 : ( ruleEString ) ;
    public final void rule__Button__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11074:1: ( ( ruleEString ) )
            // InternalBot.g:11075:2: ( ruleEString )
            {
            // InternalBot.g:11075:2: ( ruleEString )
            // InternalBot.g:11076:3: ruleEString
            {
             before(grammarAccess.getButtonAccess().getValueEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getButtonAccess().getValueEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__ValueAssignment_2"


    // $ANTLR start "rule__Button__ActionAssignment_3_1"
    // InternalBot.g:11085:1: rule__Button__ActionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Button__ActionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11089:1: ( ( ruleEString ) )
            // InternalBot.g:11090:2: ( ruleEString )
            {
            // InternalBot.g:11090:2: ( ruleEString )
            // InternalBot.g:11091:3: ruleEString
            {
             before(grammarAccess.getButtonAccess().getActionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getButtonAccess().getActionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Button__ActionAssignment_3_1"


    // $ANTLR start "rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1"
    // InternalBot.g:11100:1: rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1 : ( ruleLanguage ) ;
    public final void rule__TextLanguageInputHttpResponse__LanguageAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11104:1: ( ( ruleLanguage ) )
            // InternalBot.g:11105:2: ( ruleLanguage )
            {
            // InternalBot.g:11105:2: ( ruleLanguage )
            // InternalBot.g:11106:3: ruleLanguage
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
    // InternalBot.g:11115:1: rule__TextLanguageInputHttpResponse__InputsAssignment_3 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11119:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:11120:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:11120:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:11121:3: ruleTextInputHttpResponse
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
    // InternalBot.g:11130:1: rule__TextLanguageInputHttpResponse__InputsAssignment_4_1 : ( ruleTextInputHttpResponse ) ;
    public final void rule__TextLanguageInputHttpResponse__InputsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11134:1: ( ( ruleTextInputHttpResponse ) )
            // InternalBot.g:11135:2: ( ruleTextInputHttpResponse )
            {
            // InternalBot.g:11135:2: ( ruleTextInputHttpResponse )
            // InternalBot.g:11136:3: ruleTextInputHttpResponse
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
    // InternalBot.g:11145:1: rule__TextInputHttpResponse__TokensAssignment : ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputHttpResponse__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11149:1: ( ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) ) )
            // InternalBot.g:11150:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            {
            // InternalBot.g:11150:2: ( ( rule__TextInputHttpResponse__TokensAlternatives_0 ) )
            // InternalBot.g:11151:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputHttpResponseAccess().getTokensAlternatives_0()); 
            // InternalBot.g:11152:3: ( rule__TextInputHttpResponse__TokensAlternatives_0 )
            // InternalBot.g:11152:4: rule__TextInputHttpResponse__TokensAlternatives_0
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
    // InternalBot.g:11160:1: rule__TextInputText__TokensAssignment : ( ( rule__TextInputText__TokensAlternatives_0 ) ) ;
    public final void rule__TextInputText__TokensAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11164:1: ( ( ( rule__TextInputText__TokensAlternatives_0 ) ) )
            // InternalBot.g:11165:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            {
            // InternalBot.g:11165:2: ( ( rule__TextInputText__TokensAlternatives_0 ) )
            // InternalBot.g:11166:3: ( rule__TextInputText__TokensAlternatives_0 )
            {
             before(grammarAccess.getTextInputTextAccess().getTokensAlternatives_0()); 
            // InternalBot.g:11167:3: ( rule__TextInputText__TokensAlternatives_0 )
            // InternalBot.g:11167:4: rule__TextInputText__TokensAlternatives_0
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
    // InternalBot.g:11175:1: rule__KeyValue__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__KeyValue__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11179:1: ( ( ruleEString ) )
            // InternalBot.g:11180:2: ( ruleEString )
            {
            // InternalBot.g:11180:2: ( ruleEString )
            // InternalBot.g:11181:3: ruleEString
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
    // InternalBot.g:11190:1: rule__KeyValue__ValueAssignment_2 : ( ruleLiteral ) ;
    public final void rule__KeyValue__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11194:1: ( ( ruleLiteral ) )
            // InternalBot.g:11195:2: ( ruleLiteral )
            {
            // InternalBot.g:11195:2: ( ruleLiteral )
            // InternalBot.g:11196:3: ruleLiteral
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
    // InternalBot.g:11205:1: rule__Data__KeyAssignment_0 : ( ruleEString ) ;
    public final void rule__Data__KeyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11209:1: ( ( ruleEString ) )
            // InternalBot.g:11210:2: ( ruleEString )
            {
            // InternalBot.g:11210:2: ( ruleEString )
            // InternalBot.g:11211:3: ruleEString
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
    // InternalBot.g:11220:1: rule__Data__ValueAssignment_2 : ( ( rule__Data__ValueAlternatives_2_0 ) ) ;
    public final void rule__Data__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalBot.g:11224:1: ( ( ( rule__Data__ValueAlternatives_2_0 ) ) )
            // InternalBot.g:11225:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            {
            // InternalBot.g:11225:2: ( ( rule__Data__ValueAlternatives_2_0 ) )
            // InternalBot.g:11226:3: ( rule__Data__ValueAlternatives_2_0 )
            {
             before(grammarAccess.getDataAccess().getValueAlternatives_2_0()); 
            // InternalBot.g:11227:3: ( rule__Data__ValueAlternatives_2_0 )
            // InternalBot.g:11227:4: rule__Data__ValueAlternatives_2_0
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
    static final String dfa_3s = "\1\105\1\4\2\71\1\4\2\uffff\2\71";
    static final String dfa_4s = "\1\105\1\5\2\104\1\5\2\uffff\2\104";
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
            return "1333:1: rule__Transition__TargetAlternatives_2_1_0 : ( ( ruleState ) | ( ruleState2 ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000032L,0x0000000000002100L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000100L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000FFFFFFC00000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0280000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0D00000000000030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000038000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000002L,0x0000000000038000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000007800L,0x0000000060C00000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000007802L,0x0000000060C00000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0040000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000005L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000030L,0x0000000000040800L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000800L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000079030L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x2200000000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000104L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000381000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000032L,0x0000000000040800L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000400L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000032L,0x0000000000000400L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000030L,0x0000000000000100L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000200000L,0x0000000006000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000030L,0x0000000000002100L});

}