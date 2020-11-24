package org.xtext.botGenerator.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.botGenerator.services.BotGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBotParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language'", "':'", "','", "'intents'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'parameters'", "'inputs'", "'in'", "'{'", "'}'", "'user'", "'=>'", "'chatbot'", "'entity'", "'isList'", "'required'", "'prompts'", "'['", "']'", "'@'", "'('", "')'", "'request.'", "'.'", "'Simple'", "'Composite'", "'Regex'", "'pattern'", "'composite'", "'synonyms'", "'text'", "'response'", "'Response'", "'Request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'image'", "'caption'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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

        public InternalBotParser(TokenStream input, BotGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Bot";
       	}

       	@Override
       	protected BotGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleBot"
    // InternalBot.g:65:1: entryRuleBot returns [EObject current=null] : iv_ruleBot= ruleBot EOF ;
    public final EObject entryRuleBot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBot = null;


        try {
            // InternalBot.g:65:44: (iv_ruleBot= ruleBot EOF )
            // InternalBot.g:66:2: iv_ruleBot= ruleBot EOF
            {
             newCompositeNode(grammarAccess.getBotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBot=ruleBot();

            state._fsp--;

             current =iv_ruleBot; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBot"


    // $ANTLR start "ruleBot"
    // InternalBot.g:72:1: ruleBot returns [EObject current=null] : (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language' otherlv_3= ':' ( (lv_languages_4_0= ruleLanguage ) ) (otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) ) )* otherlv_7= 'intents' otherlv_8= ':' ( (lv_intents_9_0= ruleIntent ) ) ( (lv_intents_10_0= ruleIntent ) )* (otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )* )? (otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )* )? otherlv_19= 'flows' otherlv_20= ':' (otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';' )+ ) ;
    public final EObject ruleBot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_languages_4_0 = null;

        Enumerator lv_languages_6_0 = null;

        EObject lv_intents_9_0 = null;

        EObject lv_intents_10_0 = null;

        EObject lv_entities_13_0 = null;

        EObject lv_entities_14_0 = null;

        EObject lv_actions_17_0 = null;

        EObject lv_actions_18_0 = null;

        EObject lv_flows_22_0 = null;



        	enterRule();

        try {
            // InternalBot.g:78:2: ( (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language' otherlv_3= ':' ( (lv_languages_4_0= ruleLanguage ) ) (otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) ) )* otherlv_7= 'intents' otherlv_8= ':' ( (lv_intents_9_0= ruleIntent ) ) ( (lv_intents_10_0= ruleIntent ) )* (otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )* )? (otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )* )? otherlv_19= 'flows' otherlv_20= ':' (otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';' )+ ) )
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language' otherlv_3= ':' ( (lv_languages_4_0= ruleLanguage ) ) (otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) ) )* otherlv_7= 'intents' otherlv_8= ':' ( (lv_intents_9_0= ruleIntent ) ) ( (lv_intents_10_0= ruleIntent ) )* (otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )* )? (otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )* )? otherlv_19= 'flows' otherlv_20= ':' (otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';' )+ )
            {
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language' otherlv_3= ':' ( (lv_languages_4_0= ruleLanguage ) ) (otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) ) )* otherlv_7= 'intents' otherlv_8= ':' ( (lv_intents_9_0= ruleIntent ) ) ( (lv_intents_10_0= ruleIntent ) )* (otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )* )? (otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )* )? otherlv_19= 'flows' otherlv_20= ':' (otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';' )+ )
            // InternalBot.g:80:3: otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language' otherlv_3= ':' ( (lv_languages_4_0= ruleLanguage ) ) (otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) ) )* otherlv_7= 'intents' otherlv_8= ':' ( (lv_intents_9_0= ruleIntent ) ) ( (lv_intents_10_0= ruleIntent ) )* (otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )* )? (otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )* )? otherlv_19= 'flows' otherlv_20= ':' (otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';' )+
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBotAccess().getChatbotKeyword_0());
            		
            // InternalBot.g:84:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:85:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:85:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:86:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getBotAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getBotAccess().getLanguageKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getBotAccess().getColonKeyword_3());
            		
            // InternalBot.g:111:3: ( (lv_languages_4_0= ruleLanguage ) )
            // InternalBot.g:112:4: (lv_languages_4_0= ruleLanguage )
            {
            // InternalBot.g:112:4: (lv_languages_4_0= ruleLanguage )
            // InternalBot.g:113:5: lv_languages_4_0= ruleLanguage
            {

            					newCompositeNode(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_languages_4_0=ruleLanguage();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"languages",
            						lv_languages_4_0,
            						"org.xtext.botGenerator.Bot.Language");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:130:3: (otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:131:4: otherlv_5= ',' ( (lv_languages_6_0= ruleLanguage ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_6); 

            	    				newLeafNode(otherlv_5, grammarAccess.getBotAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalBot.g:135:4: ( (lv_languages_6_0= ruleLanguage ) )
            	    // InternalBot.g:136:5: (lv_languages_6_0= ruleLanguage )
            	    {
            	    // InternalBot.g:136:5: (lv_languages_6_0= ruleLanguage )
            	    // InternalBot.g:137:6: lv_languages_6_0= ruleLanguage
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_languages_6_0=ruleLanguage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"languages",
            	    							lv_languages_6_0,
            	    							"org.xtext.botGenerator.Bot.Language");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_7, grammarAccess.getBotAccess().getIntentsKeyword_6());
            		
            otherlv_8=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getBotAccess().getColonKeyword_7());
            		
            // InternalBot.g:163:3: ( (lv_intents_9_0= ruleIntent ) )
            // InternalBot.g:164:4: (lv_intents_9_0= ruleIntent )
            {
            // InternalBot.g:164:4: (lv_intents_9_0= ruleIntent )
            // InternalBot.g:165:5: lv_intents_9_0= ruleIntent
            {

            					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_8);
            lv_intents_9_0=ruleIntent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"intents",
            						lv_intents_9_0,
            						"org.xtext.botGenerator.Bot.Intent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:182:3: ( (lv_intents_10_0= ruleIntent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:183:4: (lv_intents_10_0= ruleIntent )
            	    {
            	    // InternalBot.g:183:4: (lv_intents_10_0= ruleIntent )
            	    // InternalBot.g:184:5: lv_intents_10_0= ruleIntent
            	    {

            	    					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    lv_intents_10_0=ruleIntent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getBotRule());
            	    					}
            	    					add(
            	    						current,
            	    						"intents",
            	    						lv_intents_10_0,
            	    						"org.xtext.botGenerator.Bot.Intent");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalBot.g:201:3: (otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBot.g:202:4: otherlv_11= 'entities' otherlv_12= ':' ( (lv_entities_13_0= ruleEntity ) ) ( (lv_entities_14_0= ruleEntity ) )*
                    {
                    otherlv_11=(Token)match(input,16,FOLLOW_5); 

                    				newLeafNode(otherlv_11, grammarAccess.getBotAccess().getEntitiesKeyword_10_0());
                    			
                    otherlv_12=(Token)match(input,13,FOLLOW_9); 

                    				newLeafNode(otherlv_12, grammarAccess.getBotAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:210:4: ( (lv_entities_13_0= ruleEntity ) )
                    // InternalBot.g:211:5: (lv_entities_13_0= ruleEntity )
                    {
                    // InternalBot.g:211:5: (lv_entities_13_0= ruleEntity )
                    // InternalBot.g:212:6: lv_entities_13_0= ruleEntity
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_entities_13_0=ruleEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"entities",
                    							lv_entities_13_0,
                    							"org.xtext.botGenerator.Bot.Entity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:229:4: ( (lv_entities_14_0= ruleEntity ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=41 && LA3_0<=43)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBot.g:230:5: (lv_entities_14_0= ruleEntity )
                    	    {
                    	    // InternalBot.g:230:5: (lv_entities_14_0= ruleEntity )
                    	    // InternalBot.g:231:6: lv_entities_14_0= ruleEntity
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_10_3_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_entities_14_0=ruleEntity();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBotRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"entities",
                    	    							lv_entities_14_0,
                    	    							"org.xtext.botGenerator.Bot.Entity");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBot.g:249:3: (otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBot.g:250:4: otherlv_15= 'actions' otherlv_16= ':' ( (lv_actions_17_0= ruleAction ) ) ( (lv_actions_18_0= ruleAction ) )*
                    {
                    otherlv_15=(Token)match(input,17,FOLLOW_5); 

                    				newLeafNode(otherlv_15, grammarAccess.getBotAccess().getActionsKeyword_11_0());
                    			
                    otherlv_16=(Token)match(input,13,FOLLOW_11); 

                    				newLeafNode(otherlv_16, grammarAccess.getBotAccess().getColonKeyword_11_1());
                    			
                    // InternalBot.g:258:4: ( (lv_actions_17_0= ruleAction ) )
                    // InternalBot.g:259:5: (lv_actions_17_0= ruleAction )
                    {
                    // InternalBot.g:259:5: (lv_actions_17_0= ruleAction )
                    // InternalBot.g:260:6: lv_actions_17_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_actions_17_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_17_0,
                    							"org.xtext.botGenerator.Bot.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:277:4: ( (lv_actions_18_0= ruleAction ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==47||(LA5_0>=49 && LA5_0<=50)||LA5_0==56) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBot.g:278:5: (lv_actions_18_0= ruleAction )
                    	    {
                    	    // InternalBot.g:278:5: (lv_actions_18_0= ruleAction )
                    	    // InternalBot.g:279:6: lv_actions_18_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_11_3_0());
                    	    					
                    	    pushFollow(FOLLOW_12);
                    	    lv_actions_18_0=ruleAction();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getBotRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"actions",
                    	    							lv_actions_18_0,
                    	    							"org.xtext.botGenerator.Bot.Action");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_19=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_19, grammarAccess.getBotAccess().getFlowsKeyword_12());
            		
            otherlv_20=(Token)match(input,13,FOLLOW_13); 

            			newLeafNode(otherlv_20, grammarAccess.getBotAccess().getColonKeyword_13());
            		
            // InternalBot.g:305:3: (otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==19) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBot.g:306:4: otherlv_21= '-' ( (lv_flows_22_0= ruleTransition ) ) otherlv_23= ';'
            	    {
            	    otherlv_21=(Token)match(input,19,FOLLOW_14); 

            	    				newLeafNode(otherlv_21, grammarAccess.getBotAccess().getHyphenMinusKeyword_14_0());
            	    			
            	    // InternalBot.g:310:4: ( (lv_flows_22_0= ruleTransition ) )
            	    // InternalBot.g:311:5: (lv_flows_22_0= ruleTransition )
            	    {
            	    // InternalBot.g:311:5: (lv_flows_22_0= ruleTransition )
            	    // InternalBot.g:312:6: lv_flows_22_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_14_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_flows_22_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"flows",
            	    							lv_flows_22_0,
            	    							"org.xtext.botGenerator.Bot.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_23=(Token)match(input,20,FOLLOW_16); 

            	    				newLeafNode(otherlv_23, grammarAccess.getBotAccess().getSemicolonKeyword_14_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBot"


    // $ANTLR start "entryRuleAction"
    // InternalBot.g:338:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalBot.g:338:47: (iv_ruleAction= ruleAction EOF )
            // InternalBot.g:339:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalBot.g:345:1: ruleAction returns [EObject current=null] : (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_Text_0 = null;

        EObject this_HTTPRequest_1 = null;

        EObject this_Image_2 = null;

        EObject this_HTTPResponse_3 = null;



        	enterRule();

        try {
            // InternalBot.g:351:2: ( (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) )
            // InternalBot.g:352:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            {
            // InternalBot.g:352:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt8=1;
                }
                break;
            case 50:
                {
                alt8=2;
                }
                break;
            case 56:
                {
                alt8=3;
                }
                break;
            case 49:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalBot.g:353:3: this_Text_0= ruleText
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getTextParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Text_0=ruleText();

                    state._fsp--;


                    			current = this_Text_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:362:3: this_HTTPRequest_1= ruleHTTPRequest
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getHTTPRequestParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_HTTPRequest_1=ruleHTTPRequest();

                    state._fsp--;


                    			current = this_HTTPRequest_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBot.g:371:3: this_Image_2= ruleImage
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getImageParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Image_2=ruleImage();

                    state._fsp--;


                    			current = this_Image_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalBot.g:380:3: this_HTTPResponse_3= ruleHTTPResponse
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getHTTPResponseParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_HTTPResponse_3=ruleHTTPResponse();

                    state._fsp--;


                    			current = this_HTTPResponse_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleEString"
    // InternalBot.g:392:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalBot.g:392:47: (iv_ruleEString= ruleEString EOF )
            // InternalBot.g:393:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalBot.g:399:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalBot.g:405:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalBot.g:406:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalBot.g:406:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalBot.g:407:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:415:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleIntent"
    // InternalBot.g:426:1: entryRuleIntent returns [EObject current=null] : iv_ruleIntent= ruleIntent EOF ;
    public final EObject entryRuleIntent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent = null;


        try {
            // InternalBot.g:426:47: (iv_ruleIntent= ruleIntent EOF )
            // InternalBot.g:427:2: iv_ruleIntent= ruleIntent EOF
            {
             newCompositeNode(grammarAccess.getIntentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntent=ruleIntent();

            state._fsp--;

             current =iv_ruleIntent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntent"


    // $ANTLR start "ruleIntent"
    // InternalBot.g:433:1: ruleIntent returns [EObject current=null] : (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 ) ;
    public final EObject ruleIntent() throws RecognitionException {
        EObject current = null;

        EObject this_Intent1_0 = null;

        EObject this_Intent2_1 = null;



        	enterRule();

        try {
            // InternalBot.g:439:2: ( (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 ) )
            // InternalBot.g:440:2: (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 )
            {
            // InternalBot.g:440:2: (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_STRING) ) {
                switch ( input.LA(2) ) {
                case 21:
                    {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==13) ) {
                        alt10=2;
                    }
                    else if ( (LA10_3==EOF||(LA10_3>=RULE_STRING && LA10_3<=RULE_ID)||(LA10_3>=16 && LA10_3<=18)) ) {
                        alt10=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 13:
                    {
                    alt10=2;
                    }
                    break;
                case EOF:
                case RULE_STRING:
                case RULE_ID:
                case 16:
                case 17:
                case 18:
                    {
                    alt10=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA10_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 21:
                    {
                    int LA10_3 = input.LA(3);

                    if ( (LA10_3==13) ) {
                        alt10=2;
                    }
                    else if ( (LA10_3==EOF||(LA10_3>=RULE_STRING && LA10_3<=RULE_ID)||(LA10_3>=16 && LA10_3<=18)) ) {
                        alt10=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case RULE_STRING:
                case RULE_ID:
                case 16:
                case 17:
                case 18:
                    {
                    alt10=1;
                    }
                    break;
                case 13:
                    {
                    alt10=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalBot.g:441:3: this_Intent1_0= ruleIntent1
                    {

                    			newCompositeNode(grammarAccess.getIntentAccess().getIntent1ParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Intent1_0=ruleIntent1();

                    state._fsp--;


                    			current = this_Intent1_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:450:3: this_Intent2_1= ruleIntent2
                    {

                    			newCompositeNode(grammarAccess.getIntentAccess().getIntent2ParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Intent2_1=ruleIntent2();

                    state._fsp--;


                    			current = this_Intent2_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntent"


    // $ANTLR start "entryRuleIntent2"
    // InternalBot.g:462:1: entryRuleIntent2 returns [EObject current=null] : iv_ruleIntent2= ruleIntent2 EOF ;
    public final EObject entryRuleIntent2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent2 = null;


        try {
            // InternalBot.g:462:48: (iv_ruleIntent2= ruleIntent2 EOF )
            // InternalBot.g:463:2: iv_ruleIntent2= ruleIntent2 EOF
            {
             newCompositeNode(grammarAccess.getIntent2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntent2=ruleIntent2();

            state._fsp--;

             current =iv_ruleIntent2; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntent2"


    // $ANTLR start "ruleIntent2"
    // InternalBot.g:469:1: ruleIntent2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? ) ;
    public final EObject ruleIntent2() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_inputs_3_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_parameters_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:475:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? ) )
            // InternalBot.g:476:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? )
            {
            // InternalBot.g:476:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? )
            // InternalBot.g:477:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )?
            {
            // InternalBot.g:477:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:478:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:478:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:479:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIntent2Access().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntent2Rule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:496:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:497:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:497:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:498:5: lv_fallbackIntent_1_0= 'Fallback'
                    {
                    lv_fallbackIntent_1_0=(Token)match(input,21,FOLLOW_5); 

                    					newLeafNode(lv_fallbackIntent_1_0, grammarAccess.getIntent2Access().getFallbackIntentFallbackKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntent2Rule());
                    					}
                    					setWithLastConsumed(current, "fallbackIntent", lv_fallbackIntent_1_0 != null, "Fallback");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getIntent2Access().getColonKeyword_2());
            		
            // InternalBot.g:514:3: ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBot.g:515:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    {
            	    // InternalBot.g:515:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    // InternalBot.g:516:5: lv_inputs_3_0= ruleIntentLanguageInputs
            	    {

            	    					newCompositeNode(grammarAccess.getIntent2Access().getInputsIntentLanguageInputsParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_inputs_3_0=ruleIntentLanguageInputs();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntent2Rule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_3_0,
            	    						"org.xtext.botGenerator.Bot.IntentLanguageInputs");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // InternalBot.g:533:3: (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:534:4: otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntent2Access().getParametersKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntent2Access().getColonKeyword_4_1());
                    			
                    // InternalBot.g:542:4: ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_STRING) ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1==13) ) {
                                int LA14_4 = input.LA(3);

                                if ( (LA14_4==30) ) {
                                    alt14=1;
                                }


                            }
                            else if ( (LA14_1==14) ) {
                                alt14=1;
                            }


                        }
                        else if ( (LA14_0==RULE_ID) ) {
                            int LA14_2 = input.LA(2);

                            if ( (LA14_2==14) ) {
                                alt14=1;
                            }
                            else if ( (LA14_2==13) ) {
                                int LA14_4 = input.LA(3);

                                if ( (LA14_4==30) ) {
                                    alt14=1;
                                }


                            }


                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBot.g:543:5: ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) )
                    	    {
                    	    // InternalBot.g:543:5: ( (lv_parameters_6_0= ruleParameter2 ) )*
                    	    loop13:
                    	    do {
                    	        int alt13=2;
                    	        int LA13_0 = input.LA(1);

                    	        if ( (LA13_0==RULE_STRING) ) {
                    	            int LA13_1 = input.LA(2);

                    	            if ( (LA13_1==14) ) {
                    	                alt13=1;
                    	            }


                    	        }
                    	        else if ( (LA13_0==RULE_ID) ) {
                    	            int LA13_2 = input.LA(2);

                    	            if ( (LA13_2==14) ) {
                    	                alt13=1;
                    	            }


                    	        }


                    	        switch (alt13) {
                    	    	case 1 :
                    	    	    // InternalBot.g:544:6: (lv_parameters_6_0= ruleParameter2 )
                    	    	    {
                    	    	    // InternalBot.g:544:6: (lv_parameters_6_0= ruleParameter2 )
                    	    	    // InternalBot.g:545:7: lv_parameters_6_0= ruleParameter2
                    	    	    {

                    	    	    							newCompositeNode(grammarAccess.getIntent2Access().getParametersParameter2ParserRuleCall_4_2_0_0());
                    	    	    						
                    	    	    pushFollow(FOLLOW_3);
                    	    	    lv_parameters_6_0=ruleParameter2();

                    	    	    state._fsp--;


                    	    	    							if (current==null) {
                    	    	    								current = createModelElementForParent(grammarAccess.getIntent2Rule());
                    	    	    							}
                    	    	    							add(
                    	    	    								current,
                    	    	    								"parameters",
                    	    	    								lv_parameters_6_0,
                    	    	    								"org.xtext.botGenerator.Bot.Parameter2");
                    	    	    							afterParserOrEnumRuleCall();
                    	    	    						

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop13;
                    	        }
                    	    } while (true);

                    	    // InternalBot.g:562:5: ( (lv_parameters_7_0= ruleParameter ) )
                    	    // InternalBot.g:563:6: (lv_parameters_7_0= ruleParameter )
                    	    {
                    	    // InternalBot.g:563:6: (lv_parameters_7_0= ruleParameter )
                    	    // InternalBot.g:564:7: lv_parameters_7_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getIntent2Access().getParametersParameterParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_parameters_7_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getIntent2Rule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_7_0,
                    	    								"org.xtext.botGenerator.Bot.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntent2"


    // $ANTLR start "entryRuleIntent1"
    // InternalBot.g:587:1: entryRuleIntent1 returns [EObject current=null] : iv_ruleIntent1= ruleIntent1 EOF ;
    public final EObject entryRuleIntent1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent1 = null;


        try {
            // InternalBot.g:587:48: (iv_ruleIntent1= ruleIntent1 EOF )
            // InternalBot.g:588:2: iv_ruleIntent1= ruleIntent1 EOF
            {
             newCompositeNode(grammarAccess.getIntent1Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntent1=ruleIntent1();

            state._fsp--;

             current =iv_ruleIntent1; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntent1"


    // $ANTLR start "ruleIntent1"
    // InternalBot.g:594:1: ruleIntent1 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? ) ;
    public final EObject ruleIntent1() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:600:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? ) )
            // InternalBot.g:601:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? )
            {
            // InternalBot.g:601:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? )
            // InternalBot.g:602:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            {
            // InternalBot.g:602:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:603:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:603:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:604:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIntent1Access().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntent1Rule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:621:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBot.g:622:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:622:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:623:5: lv_fallbackIntent_1_0= 'Fallback'
                    {
                    lv_fallbackIntent_1_0=(Token)match(input,21,FOLLOW_2); 

                    					newLeafNode(lv_fallbackIntent_1_0, grammarAccess.getIntent1Access().getFallbackIntentFallbackKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntent1Rule());
                    					}
                    					setWithLastConsumed(current, "fallbackIntent", lv_fallbackIntent_1_0 != null, "Fallback");
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntent1"


    // $ANTLR start "entryRuleIntentLanguageInputs"
    // InternalBot.g:639:1: entryRuleIntentLanguageInputs returns [EObject current=null] : iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF ;
    public final EObject entryRuleIntentLanguageInputs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentLanguageInputs = null;


        try {
            // InternalBot.g:639:61: (iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF )
            // InternalBot.g:640:2: iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF
            {
             newCompositeNode(grammarAccess.getIntentLanguageInputsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntentLanguageInputs=ruleIntentLanguageInputs();

            state._fsp--;

             current =iv_ruleIntentLanguageInputs; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntentLanguageInputs"


    // $ANTLR start "ruleIntentLanguageInputs"
    // InternalBot.g:646:1: ruleIntentLanguageInputs returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleIntentLanguageInputs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:652:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:653:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:653:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' )
            // InternalBot.g:654:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0());
            		
            // InternalBot.g:658:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalBot.g:659:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:663:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:664:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:664:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:665:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIntentLanguageInputsRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:687:3: ( (lv_inputs_4_0= ruleIntentInput ) )
            // InternalBot.g:688:4: (lv_inputs_4_0= ruleIntentInput )
            {
            // InternalBot.g:688:4: (lv_inputs_4_0= ruleIntentInput )
            // InternalBot.g:689:5: lv_inputs_4_0= ruleIntentInput
            {

            					newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleIntentInput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentLanguageInputsRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.IntentInput");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:706:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==14) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalBot.g:707:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_23); 

            	    				newLeafNode(otherlv_5, grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:711:4: ( (lv_inputs_6_0= ruleIntentInput ) )
            	    // InternalBot.g:712:5: (lv_inputs_6_0= ruleIntentInput )
            	    {
            	    // InternalBot.g:712:5: (lv_inputs_6_0= ruleIntentInput )
            	    // InternalBot.g:713:6: lv_inputs_6_0= ruleIntentInput
            	    {

            	    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleIntentInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIntentLanguageInputsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.IntentInput");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentLanguageInputs"


    // $ANTLR start "entryRuleTransition"
    // InternalBot.g:739:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalBot.g:739:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalBot.g:740:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // InternalBot.g:746:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_target_3_1 = null;

        EObject lv_target_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:752:2: ( (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) )
            // InternalBot.g:753:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            {
            // InternalBot.g:753:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            // InternalBot.g:754:3: otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getUserKeyword_0());
            		
            // InternalBot.g:758:3: ( ( ruleEString ) )
            // InternalBot.g:759:4: ( ruleEString )
            {
            // InternalBot.g:759:4: ( ruleEString )
            // InternalBot.g:760:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:774:3: (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:775:4: otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_26); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                    			
                    // InternalBot.g:779:4: ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    // InternalBot.g:780:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    {
                    // InternalBot.g:780:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    // InternalBot.g:781:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    {
                    // InternalBot.g:781:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    int alt19=2;
                    alt19 = dfa19.predict(input);
                    switch (alt19) {
                        case 1 :
                            // InternalBot.g:782:7: lv_target_3_1= ruleState
                            {

                            							newCompositeNode(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_2_1_0_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_target_3_1=ruleState();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTransitionRule());
                            							}
                            							set(
                            								current,
                            								"target",
                            								lv_target_3_1,
                            								"org.xtext.botGenerator.Bot.State");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;
                        case 2 :
                            // InternalBot.g:798:7: lv_target_3_2= ruleState2
                            {

                            							newCompositeNode(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_2_1_0_1());
                            						
                            pushFollow(FOLLOW_2);
                            lv_target_3_2=ruleState2();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTransitionRule());
                            							}
                            							set(
                            								current,
                            								"target",
                            								lv_target_3_2,
                            								"org.xtext.botGenerator.Bot.State2");
                            							afterParserOrEnumRuleCall();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleState"
    // InternalBot.g:821:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBot.g:821:46: (iv_ruleState= ruleState EOF )
            // InternalBot.g:822:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalBot.g:828:1: ruleState returns [EObject current=null] : (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_outcoming_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:834:2: ( (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? ) )
            // InternalBot.g:835:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? )
            {
            // InternalBot.g:835:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? )
            // InternalBot.g:836:3: otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getChatbotKeyword_0());
            		
            // InternalBot.g:840:3: ( ( ruleEString ) )
            // InternalBot.g:841:4: ( ruleEString )
            {
            // InternalBot.g:841:4: ( ruleEString )
            // InternalBot.g:842:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0());
            				
            pushFollow(FOLLOW_27);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:856:3: (otherlv_2= ',' ( ( ruleEString ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==14) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:857:4: otherlv_2= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalBot.g:861:4: ( ( ruleEString ) )
            	    // InternalBot.g:862:5: ( ruleEString )
            	    {
            	    // InternalBot.g:862:5: ( ruleEString )
            	    // InternalBot.g:863:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalBot.g:878:3: (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalBot.g:879:4: otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_3_0());
                    			
                    // InternalBot.g:883:4: ( (lv_outcoming_5_0= ruleTransition ) )
                    // InternalBot.g:884:5: (lv_outcoming_5_0= ruleTransition )
                    {
                    // InternalBot.g:884:5: (lv_outcoming_5_0= ruleTransition )
                    // InternalBot.g:885:6: lv_outcoming_5_0= ruleTransition
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_outcoming_5_0=ruleTransition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStateRule());
                    						}
                    						add(
                    							current,
                    							"outcoming",
                    							lv_outcoming_5_0,
                    							"org.xtext.botGenerator.Bot.Transition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleState2"
    // InternalBot.g:907:1: entryRuleState2 returns [EObject current=null] : iv_ruleState2= ruleState2 EOF ;
    public final EObject entryRuleState2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState2 = null;


        try {
            // InternalBot.g:907:47: (iv_ruleState2= ruleState2 EOF )
            // InternalBot.g:908:2: iv_ruleState2= ruleState2 EOF
            {
             newCompositeNode(grammarAccess.getState2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState2=ruleState2();

            state._fsp--;

             current =iv_ruleState2; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState2"


    // $ANTLR start "ruleState2"
    // InternalBot.g:914:1: ruleState2 returns [EObject current=null] : (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' ) ;
    public final EObject ruleState2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_outcoming_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:920:2: ( (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' ) )
            // InternalBot.g:921:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' )
            {
            // InternalBot.g:921:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' )
            // InternalBot.g:922:3: otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getState2Access().getChatbotKeyword_0());
            		
            // InternalBot.g:926:3: ( ( ruleEString ) )
            // InternalBot.g:927:4: ( ruleEString )
            {
            // InternalBot.g:927:4: ( ruleEString )
            // InternalBot.g:928:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getState2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_1_0());
            				
            pushFollow(FOLLOW_28);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:942:3: (otherlv_2= ',' ( ( ruleEString ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==14) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalBot.g:943:4: otherlv_2= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getState2Access().getCommaKeyword_2_0());
            	    			
            	    // InternalBot.g:947:4: ( ( ruleEString ) )
            	    // InternalBot.g:948:5: ( ruleEString )
            	    {
            	    // InternalBot.g:948:5: ( ruleEString )
            	    // InternalBot.g:949:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getState2Rule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0());
            	    					
            	    pushFollow(FOLLOW_28);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FOLLOW_29); 

            			newLeafNode(otherlv_4, grammarAccess.getState2Access().getLeftCurlyBracketKeyword_3());
            		
            // InternalBot.g:968:3: (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==28) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalBot.g:969:4: otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';'
            	    {
            	    otherlv_5=(Token)match(input,28,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_4_0());
            	    			
            	    // InternalBot.g:973:4: ( (lv_outcoming_6_0= ruleTransition ) )
            	    // InternalBot.g:974:5: (lv_outcoming_6_0= ruleTransition )
            	    {
            	    // InternalBot.g:974:5: (lv_outcoming_6_0= ruleTransition )
            	    // InternalBot.g:975:6: lv_outcoming_6_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_outcoming_6_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getState2Rule());
            	    						}
            	    						add(
            	    							current,
            	    							"outcoming",
            	    							lv_outcoming_6_0,
            	    							"org.xtext.botGenerator.Bot.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_7=(Token)match(input,20,FOLLOW_30); 

            	    				newLeafNode(otherlv_7, grammarAccess.getState2Access().getSemicolonKeyword_4_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getState2Access().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState2"


    // $ANTLR start "entryRuleIntentInput"
    // InternalBot.g:1005:1: entryRuleIntentInput returns [EObject current=null] : iv_ruleIntentInput= ruleIntentInput EOF ;
    public final EObject entryRuleIntentInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentInput = null;


        try {
            // InternalBot.g:1005:52: (iv_ruleIntentInput= ruleIntentInput EOF )
            // InternalBot.g:1006:2: iv_ruleIntentInput= ruleIntentInput EOF
            {
             newCompositeNode(grammarAccess.getIntentInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntentInput=ruleIntentInput();

            state._fsp--;

             current =iv_ruleIntentInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntentInput"


    // $ANTLR start "ruleIntentInput"
    // InternalBot.g:1012:1: ruleIntentInput returns [EObject current=null] : (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput ) ;
    public final EObject ruleIntentInput() throws RecognitionException {
        EObject current = null;

        EObject this_TrainingPhrase_0 = null;

        EObject this_RegexInput_1 = null;



        	enterRule();

        try {
            // InternalBot.g:1018:2: ( (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput ) )
            // InternalBot.g:1019:2: (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput )
            {
            // InternalBot.g:1019:2: (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_ID)||LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==44) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:1020:3: this_TrainingPhrase_0= ruleTrainingPhrase
                    {

                    			newCompositeNode(grammarAccess.getIntentInputAccess().getTrainingPhraseParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TrainingPhrase_0=ruleTrainingPhrase();

                    state._fsp--;


                    			current = this_TrainingPhrase_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:1029:3: this_RegexInput_1= ruleRegexInput
                    {

                    			newCompositeNode(grammarAccess.getIntentInputAccess().getRegexInputParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegexInput_1=ruleRegexInput();

                    state._fsp--;


                    			current = this_RegexInput_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentInput"


    // $ANTLR start "entryRuleTrainingPhrase"
    // InternalBot.g:1041:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:1041:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:1042:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
            {
             newCompositeNode(grammarAccess.getTrainingPhraseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrainingPhrase=ruleTrainingPhrase();

            state._fsp--;

             current =iv_ruleTrainingPhrase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrainingPhrase"


    // $ANTLR start "ruleTrainingPhrase"
    // InternalBot.g:1048:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1054:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:1055:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:1055:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:1056:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:1056:3: ()
            // InternalBot.g:1057:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:1063:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=RULE_STRING && LA27_0<=RULE_ID)||LA27_0==37) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBot.g:1064:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:1064:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:1065:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:1065:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_ID)) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==37) ) {
            	        alt26=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // InternalBot.g:1066:6: lv_tokens_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_31);
            	            lv_tokens_1_1=ruleLiteral();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getTrainingPhraseRule());
            	            						}
            	            						add(
            	            							current,
            	            							"tokens",
            	            							lv_tokens_1_1,
            	            							"org.xtext.botGenerator.Bot.Literal");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:1082:6: lv_tokens_1_2= ruleParameterRefenceToken
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_31);
            	            lv_tokens_1_2=ruleParameterRefenceToken();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getTrainingPhraseRule());
            	            						}
            	            						add(
            	            							current,
            	            							"tokens",
            	            							lv_tokens_1_2,
            	            							"org.xtext.botGenerator.Bot.ParameterRefenceToken");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrainingPhrase"


    // $ANTLR start "entryRuleParameter"
    // InternalBot.g:1104:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:1104:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:1105:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalBot.g:1111:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_isList_6_0=null;
        Token otherlv_7=null;
        Token lv_required_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_defaultEntity_4_0 = null;

        EObject lv_prompts_10_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1117:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' ) )
            // InternalBot.g:1118:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' )
            {
            // InternalBot.g:1118:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' )
            // InternalBot.g:1119:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';'
            {
            // InternalBot.g:1119:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1120:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1120:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1121:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,30,FOLLOW_33); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1146:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_ID)) ) {
                alt28=1;
            }
            else if ( (LA28_0==47||(LA28_0>=58 && LA28_0<=61)) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalBot.g:1147:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:1147:4: ( ( ruleEString ) )
                    // InternalBot.g:1148:5: ( ruleEString )
                    {
                    // InternalBot.g:1148:5: ( ruleEString )
                    // InternalBot.g:1149:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_34);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1164:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:1164:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:1165:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:1165:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:1166:6: lv_defaultEntity_4_0= ruleDefaultEntity
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_defaultEntity_4_0=ruleDefaultEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    						}
                    						set(
                    							current,
                    							"defaultEntity",
                    							lv_defaultEntity_4_0,
                    							"org.xtext.botGenerator.Bot.DefaultEntity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalBot.g:1184:3: (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==14) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==31) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:1185:4: otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_35); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1189:4: ( (lv_isList_6_0= 'isList' ) )
                    // InternalBot.g:1190:5: (lv_isList_6_0= 'isList' )
                    {
                    // InternalBot.g:1190:5: (lv_isList_6_0= 'isList' )
                    // InternalBot.g:1191:6: lv_isList_6_0= 'isList'
                    {
                    lv_isList_6_0=(Token)match(input,31,FOLLOW_34); 

                    						newLeafNode(lv_isList_6_0, grammarAccess.getParameterAccess().getIsListIsListKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "isList", lv_isList_6_0 != null, "isList");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalBot.g:1204:3: (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==32) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:1205:4: otherlv_7= ',' ( (lv_required_8_0= 'required' ) )
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_36); 

                    				newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1209:4: ( (lv_required_8_0= 'required' ) )
                    // InternalBot.g:1210:5: (lv_required_8_0= 'required' )
                    {
                    // InternalBot.g:1210:5: (lv_required_8_0= 'required' )
                    // InternalBot.g:1211:6: lv_required_8_0= 'required'
                    {
                    lv_required_8_0=(Token)match(input,32,FOLLOW_34); 

                    						newLeafNode(lv_required_8_0, grammarAccess.getParameterAccess().getRequiredRequiredKeyword_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "required", lv_required_8_0 != null, "required");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalBot.g:1224:3: (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalBot.g:1225:4: otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_37); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getCommaKeyword_6_0());
                    			
                    // InternalBot.g:1229:4: ( (lv_prompts_10_0= rulePromptLanguage ) )+
                    int cnt31=0;
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==33) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalBot.g:1230:5: (lv_prompts_10_0= rulePromptLanguage )
                    	    {
                    	    // InternalBot.g:1230:5: (lv_prompts_10_0= rulePromptLanguage )
                    	    // InternalBot.g:1231:6: lv_prompts_10_0= rulePromptLanguage
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_38);
                    	    lv_prompts_10_0=rulePromptLanguage();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"prompts",
                    	    							lv_prompts_10_0,
                    	    							"org.xtext.botGenerator.Bot.PromptLanguage");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt31 >= 1 ) break loop31;
                                EarlyExitException eee =
                                    new EarlyExitException(31, input);
                                throw eee;
                        }
                        cnt31++;
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getParameterAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameter2"
    // InternalBot.g:1257:1: entryRuleParameter2 returns [EObject current=null] : iv_ruleParameter2= ruleParameter2 EOF ;
    public final EObject entryRuleParameter2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter2 = null;


        try {
            // InternalBot.g:1257:51: (iv_ruleParameter2= ruleParameter2 EOF )
            // InternalBot.g:1258:2: iv_ruleParameter2= ruleParameter2 EOF
            {
             newCompositeNode(grammarAccess.getParameter2Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter2=ruleParameter2();

            state._fsp--;

             current =iv_ruleParameter2; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter2"


    // $ANTLR start "ruleParameter2"
    // InternalBot.g:1264:1: ruleParameter2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) ;
    public final EObject ruleParameter2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1270:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) )
            // InternalBot.g:1271:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            {
            // InternalBot.g:1271:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            // InternalBot.g:1272:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ','
            {
            // InternalBot.g:1272:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1273:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1273:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1274:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameter2Access().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameter2Rule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getParameter2Access().getCommaKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter2"


    // $ANTLR start "entryRulePromptLanguage"
    // InternalBot.g:1299:1: entryRulePromptLanguage returns [EObject current=null] : iv_rulePromptLanguage= rulePromptLanguage EOF ;
    public final EObject entryRulePromptLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePromptLanguage = null;


        try {
            // InternalBot.g:1299:55: (iv_rulePromptLanguage= rulePromptLanguage EOF )
            // InternalBot.g:1300:2: iv_rulePromptLanguage= rulePromptLanguage EOF
            {
             newCompositeNode(grammarAccess.getPromptLanguageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePromptLanguage=rulePromptLanguage();

            state._fsp--;

             current =iv_rulePromptLanguage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePromptLanguage"


    // $ANTLR start "rulePromptLanguage"
    // InternalBot.g:1306:1: rulePromptLanguage returns [EObject current=null] : (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) ;
    public final EObject rulePromptLanguage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        AntlrDatatypeRuleToken lv_prompts_4_0 = null;

        AntlrDatatypeRuleToken lv_prompts_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1312:2: ( (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) )
            // InternalBot.g:1313:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            {
            // InternalBot.g:1313:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            // InternalBot.g:1314:3: otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_40); 

            			newLeafNode(otherlv_0, grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0());
            		
            // InternalBot.g:1318:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==24) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:1319:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getPromptLanguageAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:1323:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1324:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1324:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1325:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPromptLanguageRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalBot.g:1347:3: ( (lv_prompts_4_0= ruleEString ) )
            // InternalBot.g:1348:4: (lv_prompts_4_0= ruleEString )
            {
            // InternalBot.g:1348:4: (lv_prompts_4_0= ruleEString )
            // InternalBot.g:1349:5: lv_prompts_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_42);
            lv_prompts_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPromptLanguageRule());
            					}
            					add(
            						current,
            						"prompts",
            						lv_prompts_4_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1366:3: (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==14) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:1367:4: otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:1371:4: ( (lv_prompts_6_0= ruleEString ) )
            	    // InternalBot.g:1372:5: (lv_prompts_6_0= ruleEString )
            	    {
            	    // InternalBot.g:1372:5: (lv_prompts_6_0= ruleEString )
            	    // InternalBot.g:1373:6: lv_prompts_6_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_prompts_6_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPromptLanguageRule());
            	    						}
            	    						add(
            	    							current,
            	    							"prompts",
            	    							lv_prompts_6_0,
            	    							"org.xtext.botGenerator.Bot.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_7=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPromptLanguageAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePromptLanguage"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:1399:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1399:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1400:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalBot.g:1406:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1412:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1413:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1413:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1414:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1414:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1415:4: lv_text_0_0= ruleEString
            {

            				newCompositeNode(grammarAccess.getLiteralAccess().getTextEStringParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_text_0_0=ruleEString();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getLiteralRule());
            				}
            				set(
            					current,
            					"text",
            					lv_text_0_0,
            					"org.xtext.botGenerator.Bot.EString");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleEntityToken"
    // InternalBot.g:1435:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1435:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1436:2: iv_ruleEntityToken= ruleEntityToken EOF
            {
             newCompositeNode(grammarAccess.getEntityTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityToken=ruleEntityToken();

            state._fsp--;

             current =iv_ruleEntityToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntityToken"


    // $ANTLR start "ruleEntityToken"
    // InternalBot.g:1442:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBot.g:1448:2: ( (otherlv_0= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1449:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1449:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1450:3: otherlv_0= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0());
            		
            // InternalBot.g:1454:3: ( ( ruleEString ) )
            // InternalBot.g:1455:4: ( ruleEString )
            {
            // InternalBot.g:1455:4: ( ruleEString )
            // InternalBot.g:1456:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntityToken"


    // $ANTLR start "entryRuleParameterToken"
    // InternalBot.g:1474:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1474:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1475:2: iv_ruleParameterToken= ruleParameterToken EOF
            {
             newCompositeNode(grammarAccess.getParameterTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterToken=ruleParameterToken();

            state._fsp--;

             current =iv_ruleParameterToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterToken"


    // $ANTLR start "ruleParameterToken"
    // InternalBot.g:1481:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1487:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1488:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1488:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1489:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1493:3: ( ( ruleEString ) )
            // InternalBot.g:1494:4: ( ruleEString )
            {
            // InternalBot.g:1494:4: ( ruleEString )
            // InternalBot.g:1495:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0());
            				
            pushFollow(FOLLOW_43);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterToken"


    // $ANTLR start "entryRuleParameterRefenceToken"
    // InternalBot.g:1517:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1517:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1518:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
            {
             newCompositeNode(grammarAccess.getParameterRefenceTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterRefenceToken=ruleParameterRefenceToken();

            state._fsp--;

             current =iv_ruleParameterRefenceToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterRefenceToken"


    // $ANTLR start "ruleParameterRefenceToken"
    // InternalBot.g:1524:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1530:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1531:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1531:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1532:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1536:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1537:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1537:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1538:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_44);
            lv_textReference_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRefenceTokenRule());
            					}
            					set(
            						current,
            						"textReference",
            						lv_textReference_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1563:3: ( ( ruleEString ) )
            // InternalBot.g:1564:4: ( ruleEString )
            {
            // InternalBot.g:1564:4: ( ruleEString )
            // InternalBot.g:1565:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRefenceTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0());
            				
            pushFollow(FOLLOW_43);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getParameterRefenceTokenAccess().getRightSquareBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterRefenceToken"


    // $ANTLR start "entryRuleHTTPRequestToken"
    // InternalBot.g:1587:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1587:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1588:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
            {
             newCompositeNode(grammarAccess.getHTTPRequestTokenRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHTTPRequestToken=ruleHTTPRequestToken();

            state._fsp--;

             current =iv_ruleHTTPRequestToken; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTPRequestToken"


    // $ANTLR start "ruleHTTPRequestToken"
    // InternalBot.g:1594:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1600:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1601:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1601:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1602:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1606:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1607:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1607:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1608:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_46);
            lv_type_1_0=ruleHTTPReturnType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestTokenRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.botGenerator.Bot.HTTPReturnType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1625:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==40) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:1626:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1630:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1631:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1631:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1632:6: lv_dataKey_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getDataKeyEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_dataKey_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestTokenRule());
                    						}
                    						set(
                    							current,
                    							"dataKey",
                    							lv_dataKey_3_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPRequestToken"


    // $ANTLR start "entryRuleEntity"
    // InternalBot.g:1654:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:1654:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:1655:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // InternalBot.g:1661:1: ruleEntity returns [EObject current=null] : (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleEntity_0 = null;

        EObject this_ComplexEntity_1 = null;

        EObject this_RegexEntity_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1667:2: ( (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) )
            // InternalBot.g:1668:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            {
            // InternalBot.g:1668:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt36=1;
                }
                break;
            case 42:
                {
                alt36=2;
                }
                break;
            case 43:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalBot.g:1669:3: this_SimpleEntity_0= ruleSimpleEntity
                    {

                    			newCompositeNode(grammarAccess.getEntityAccess().getSimpleEntityParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleEntity_0=ruleSimpleEntity();

                    state._fsp--;


                    			current = this_SimpleEntity_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:1678:3: this_ComplexEntity_1= ruleComplexEntity
                    {

                    			newCompositeNode(grammarAccess.getEntityAccess().getComplexEntityParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComplexEntity_1=ruleComplexEntity();

                    state._fsp--;


                    			current = this_ComplexEntity_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBot.g:1687:3: this_RegexEntity_2= ruleRegexEntity
                    {

                    			newCompositeNode(grammarAccess.getEntityAccess().getRegexEntityParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegexEntity_2=ruleRegexEntity();

                    state._fsp--;


                    			current = this_RegexEntity_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleSimpleEntity"
    // InternalBot.g:1699:1: entryRuleSimpleEntity returns [EObject current=null] : iv_ruleSimpleEntity= ruleSimpleEntity EOF ;
    public final EObject entryRuleSimpleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEntity = null;


        try {
            // InternalBot.g:1699:53: (iv_ruleSimpleEntity= ruleSimpleEntity EOF )
            // InternalBot.g:1700:2: iv_ruleSimpleEntity= ruleSimpleEntity EOF
            {
             newCompositeNode(grammarAccess.getSimpleEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleEntity=ruleSimpleEntity();

            state._fsp--;

             current =iv_ruleSimpleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleEntity"


    // $ANTLR start "ruleSimpleEntity"
    // InternalBot.g:1706:1: ruleSimpleEntity returns [EObject current=null] : (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ ) ;
    public final EObject ruleSimpleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1712:2: ( (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ ) )
            // InternalBot.g:1713:2: (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ )
            {
            // InternalBot.g:1713:2: (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ )
            // InternalBot.g:1714:3: otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,41,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleEntityAccess().getSimpleKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:1722:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1723:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1723:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1724:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleEntityAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getSimpleEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1745:3: ( (lv_inputs_4_0= ruleSLanguageInput ) )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==23||LA37_0==25) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalBot.g:1746:4: (lv_inputs_4_0= ruleSLanguageInput )
            	    {
            	    // InternalBot.g:1746:4: (lv_inputs_4_0= ruleSLanguageInput )
            	    // InternalBot.g:1747:5: lv_inputs_4_0= ruleSLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleEntityAccess().getInputsSLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_inputs_4_0=ruleSLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSimpleEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.SLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleEntity"


    // $ANTLR start "entryRuleComplexEntity"
    // InternalBot.g:1768:1: entryRuleComplexEntity returns [EObject current=null] : iv_ruleComplexEntity= ruleComplexEntity EOF ;
    public final EObject entryRuleComplexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexEntity = null;


        try {
            // InternalBot.g:1768:54: (iv_ruleComplexEntity= ruleComplexEntity EOF )
            // InternalBot.g:1769:2: iv_ruleComplexEntity= ruleComplexEntity EOF
            {
             newCompositeNode(grammarAccess.getComplexEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComplexEntity=ruleComplexEntity();

            state._fsp--;

             current =iv_ruleComplexEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComplexEntity"


    // $ANTLR start "ruleComplexEntity"
    // InternalBot.g:1775:1: ruleComplexEntity returns [EObject current=null] : (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ ) ;
    public final EObject ruleComplexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1781:2: ( (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ ) )
            // InternalBot.g:1782:2: (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ )
            {
            // InternalBot.g:1782:2: (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ )
            // InternalBot.g:1783:3: otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,42,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexEntityAccess().getCompositeKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:1791:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1792:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1792:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1793:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getComplexEntityAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComplexEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getComplexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1814:3: ( (lv_inputs_4_0= ruleCLanguageInput ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==23||LA38_0==25) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalBot.g:1815:4: (lv_inputs_4_0= ruleCLanguageInput )
            	    {
            	    // InternalBot.g:1815:4: (lv_inputs_4_0= ruleCLanguageInput )
            	    // InternalBot.g:1816:5: lv_inputs_4_0= ruleCLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getComplexEntityAccess().getInputsCLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_inputs_4_0=ruleCLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComplexEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.CLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComplexEntity"


    // $ANTLR start "entryRuleRegexEntity"
    // InternalBot.g:1837:1: entryRuleRegexEntity returns [EObject current=null] : iv_ruleRegexEntity= ruleRegexEntity EOF ;
    public final EObject entryRuleRegexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexEntity = null;


        try {
            // InternalBot.g:1837:52: (iv_ruleRegexEntity= ruleRegexEntity EOF )
            // InternalBot.g:1838:2: iv_ruleRegexEntity= ruleRegexEntity EOF
            {
             newCompositeNode(grammarAccess.getRegexEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegexEntity=ruleRegexEntity();

            state._fsp--;

             current =iv_ruleRegexEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegexEntity"


    // $ANTLR start "ruleRegexEntity"
    // InternalBot.g:1844:1: ruleRegexEntity returns [EObject current=null] : (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ ) ;
    public final EObject ruleRegexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1850:2: ( (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ ) )
            // InternalBot.g:1851:2: (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ )
            {
            // InternalBot.g:1851:2: (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ )
            // InternalBot.g:1852:3: otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,43,FOLLOW_32); 

            			newLeafNode(otherlv_0, grammarAccess.getRegexEntityAccess().getRegexKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:1860:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1861:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1861:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1862:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRegexEntityAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegexEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getRegexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1883:3: ( (lv_inputs_4_0= ruleRLanguageInput ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==23||LA39_0==25) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBot.g:1884:4: (lv_inputs_4_0= ruleRLanguageInput )
            	    {
            	    // InternalBot.g:1884:4: (lv_inputs_4_0= ruleRLanguageInput )
            	    // InternalBot.g:1885:5: lv_inputs_4_0= ruleRLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getRegexEntityAccess().getInputsRLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_inputs_4_0=ruleRLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRegexEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.RLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegexEntity"


    // $ANTLR start "entryRuleSLanguageInput"
    // InternalBot.g:1906:1: entryRuleSLanguageInput returns [EObject current=null] : iv_ruleSLanguageInput= ruleSLanguageInput EOF ;
    public final EObject entryRuleSLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSLanguageInput = null;


        try {
            // InternalBot.g:1906:55: (iv_ruleSLanguageInput= ruleSLanguageInput EOF )
            // InternalBot.g:1907:2: iv_ruleSLanguageInput= ruleSLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getSLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSLanguageInput=ruleSLanguageInput();

            state._fsp--;

             current =iv_ruleSLanguageInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSLanguageInput"


    // $ANTLR start "ruleSLanguageInput"
    // InternalBot.g:1913:1: ruleSLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleSLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1919:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:1920:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:1920:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:1921:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:1921:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==23) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBot.g:1922:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_49); 

                    				newLeafNode(otherlv_0, grammarAccess.getSLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getSLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:1930:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1931:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1931:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1932:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getSLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSLanguageInputRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getSLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:1954:3: ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* )
            // InternalBot.g:1955:4: ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )*
            {
            // InternalBot.g:1955:4: ( (lv_inputs_4_0= ruleSimpleInput ) )
            // InternalBot.g:1956:5: (lv_inputs_4_0= ruleSimpleInput )
            {
            // InternalBot.g:1956:5: (lv_inputs_4_0= ruleSimpleInput )
            // InternalBot.g:1957:6: lv_inputs_4_0= ruleSimpleInput
            {

            						newCompositeNode(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_50);
            lv_inputs_4_0=ruleSimpleInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getSLanguageInputRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.SimpleInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:1974:4: ( (lv_inputs_5_0= ruleSimpleInput ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_ID)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBot.g:1975:5: (lv_inputs_5_0= ruleSimpleInput )
            	    {
            	    // InternalBot.g:1975:5: (lv_inputs_5_0= ruleSimpleInput )
            	    // InternalBot.g:1976:6: lv_inputs_5_0= ruleSimpleInput
            	    {

            	    						newCompositeNode(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_50);
            	    lv_inputs_5_0=ruleSimpleInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_5_0,
            	    							"org.xtext.botGenerator.Bot.SimpleInput");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSLanguageInputAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSLanguageInput"


    // $ANTLR start "entryRuleCLanguageInput"
    // InternalBot.g:2002:1: entryRuleCLanguageInput returns [EObject current=null] : iv_ruleCLanguageInput= ruleCLanguageInput EOF ;
    public final EObject entryRuleCLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCLanguageInput = null;


        try {
            // InternalBot.g:2002:55: (iv_ruleCLanguageInput= ruleCLanguageInput EOF )
            // InternalBot.g:2003:2: iv_ruleCLanguageInput= ruleCLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getCLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCLanguageInput=ruleCLanguageInput();

            state._fsp--;

             current =iv_ruleCLanguageInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCLanguageInput"


    // $ANTLR start "ruleCLanguageInput"
    // InternalBot.g:2009:1: ruleCLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleCLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2015:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2016:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2016:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2017:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2017:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==23) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:2018:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_49); 

                    				newLeafNode(otherlv_0, grammarAccess.getCLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getCLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2026:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2027:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2027:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2028:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getCLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCLanguageInputRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_51); 

            			newLeafNode(otherlv_3, grammarAccess.getCLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2050:3: ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* )
            // InternalBot.g:2051:4: ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )*
            {
            // InternalBot.g:2051:4: ( (lv_inputs_4_0= ruleCompositeInput ) )
            // InternalBot.g:2052:5: (lv_inputs_4_0= ruleCompositeInput )
            {
            // InternalBot.g:2052:5: (lv_inputs_4_0= ruleCompositeInput )
            // InternalBot.g:2053:6: lv_inputs_4_0= ruleCompositeInput
            {

            						newCompositeNode(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_52);
            lv_inputs_4_0=ruleCompositeInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getCLanguageInputRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.CompositeInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:2070:4: ( (lv_inputs_5_0= ruleCompositeInput ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==45) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalBot.g:2071:5: (lv_inputs_5_0= ruleCompositeInput )
            	    {
            	    // InternalBot.g:2071:5: (lv_inputs_5_0= ruleCompositeInput )
            	    // InternalBot.g:2072:6: lv_inputs_5_0= ruleCompositeInput
            	    {

            	    						newCompositeNode(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_52);
            	    lv_inputs_5_0=ruleCompositeInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_5_0,
            	    							"org.xtext.botGenerator.Bot.CompositeInput");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCLanguageInputAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCLanguageInput"


    // $ANTLR start "entryRuleRLanguageInput"
    // InternalBot.g:2098:1: entryRuleRLanguageInput returns [EObject current=null] : iv_ruleRLanguageInput= ruleRLanguageInput EOF ;
    public final EObject entryRuleRLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRLanguageInput = null;


        try {
            // InternalBot.g:2098:55: (iv_ruleRLanguageInput= ruleRLanguageInput EOF )
            // InternalBot.g:2099:2: iv_ruleRLanguageInput= ruleRLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getRLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRLanguageInput=ruleRLanguageInput();

            state._fsp--;

             current =iv_ruleRLanguageInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRLanguageInput"


    // $ANTLR start "ruleRLanguageInput"
    // InternalBot.g:2105:1: ruleRLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleRLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2111:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2112:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2112:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2113:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2113:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==23) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBot.g:2114:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_49); 

                    				newLeafNode(otherlv_0, grammarAccess.getRLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getRLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2122:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2123:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2123:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2124:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getRLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRLanguageInputRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getRLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2146:3: ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* )
            // InternalBot.g:2147:4: ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )*
            {
            // InternalBot.g:2147:4: ( (lv_inputs_4_0= ruleRegexInput ) )
            // InternalBot.g:2148:5: (lv_inputs_4_0= ruleRegexInput )
            {
            // InternalBot.g:2148:5: (lv_inputs_4_0= ruleRegexInput )
            // InternalBot.g:2149:6: lv_inputs_4_0= ruleRegexInput
            {

            						newCompositeNode(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_53);
            lv_inputs_4_0=ruleRegexInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getRLanguageInputRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.RegexInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:2166:4: ( (lv_inputs_5_0= ruleRegexInput ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==44) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalBot.g:2167:5: (lv_inputs_5_0= ruleRegexInput )
            	    {
            	    // InternalBot.g:2167:5: (lv_inputs_5_0= ruleRegexInput )
            	    // InternalBot.g:2168:6: lv_inputs_5_0= ruleRegexInput
            	    {

            	    						newCompositeNode(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_53);
            	    lv_inputs_5_0=ruleRegexInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_5_0,
            	    							"org.xtext.botGenerator.Bot.RegexInput");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRLanguageInputAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRLanguageInput"


    // $ANTLR start "entryRuleRegexInput"
    // InternalBot.g:2194:1: entryRuleRegexInput returns [EObject current=null] : iv_ruleRegexInput= ruleRegexInput EOF ;
    public final EObject entryRuleRegexInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexInput = null;


        try {
            // InternalBot.g:2194:51: (iv_ruleRegexInput= ruleRegexInput EOF )
            // InternalBot.g:2195:2: iv_ruleRegexInput= ruleRegexInput EOF
            {
             newCompositeNode(grammarAccess.getRegexInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegexInput=ruleRegexInput();

            state._fsp--;

             current =iv_ruleRegexInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegexInput"


    // $ANTLR start "ruleRegexInput"
    // InternalBot.g:2201:1: ruleRegexInput returns [EObject current=null] : ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) ;
    public final EObject ruleRegexInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2207:2: ( ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) )
            // InternalBot.g:2208:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            {
            // InternalBot.g:2208:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            // InternalBot.g:2209:3: () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) )
            {
            // InternalBot.g:2209:3: ()
            // InternalBot.g:2210:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRegexInputAccess().getRegexInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexInputAccess().getPatternKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2224:3: ( (lv_expresion_3_0= ruleEString ) )
            // InternalBot.g:2225:4: (lv_expresion_3_0= ruleEString )
            {
            // InternalBot.g:2225:4: (lv_expresion_3_0= ruleEString )
            // InternalBot.g:2226:5: lv_expresion_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRegexInputAccess().getExpresionEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_expresion_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegexInputRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegexInput"


    // $ANTLR start "entryRuleCompositeInput"
    // InternalBot.g:2247:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:2247:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:2248:2: iv_ruleCompositeInput= ruleCompositeInput EOF
            {
             newCompositeNode(grammarAccess.getCompositeInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompositeInput=ruleCompositeInput();

            state._fsp--;

             current =iv_ruleCompositeInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeInput"


    // $ANTLR start "ruleCompositeInput"
    // InternalBot.g:2254:1: ruleCompositeInput returns [EObject current=null] : ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expresion_3_1 = null;

        EObject lv_expresion_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2260:2: ( ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) )
            // InternalBot.g:2261:2: ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            {
            // InternalBot.g:2261:2: ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            // InternalBot.g:2262:3: () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            {
            // InternalBot.g:2262:3: ()
            // InternalBot.g:2263:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeInputAccess().getCompositeInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,45,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeInputAccess().getCompositeKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_54); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2277:3: ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=RULE_STRING && LA47_0<=RULE_ID)||LA47_0==36) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBot.g:2278:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:2278:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    // InternalBot.g:2279:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:2279:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    int alt46=2;
            	    int LA46_0 = input.LA(1);

            	    if ( ((LA46_0>=RULE_STRING && LA46_0<=RULE_ID)) ) {
            	        alt46=1;
            	    }
            	    else if ( (LA46_0==36) ) {
            	        alt46=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt46) {
            	        case 1 :
            	            // InternalBot.g:2280:6: lv_expresion_3_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_3_0_0());
            	            					
            	            pushFollow(FOLLOW_55);
            	            lv_expresion_3_1=ruleLiteral();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getCompositeInputRule());
            	            						}
            	            						add(
            	            							current,
            	            							"expresion",
            	            							lv_expresion_3_1,
            	            							"org.xtext.botGenerator.Bot.Literal");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:2296:6: lv_expresion_3_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_3_0_1());
            	            					
            	            pushFollow(FOLLOW_55);
            	            lv_expresion_3_2=ruleEntityToken();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getCompositeInputRule());
            	            						}
            	            						add(
            	            							current,
            	            							"expresion",
            	            							lv_expresion_3_2,
            	            							"org.xtext.botGenerator.Bot.EntityToken");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompositeInput"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:2318:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:2318:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:2319:2: iv_ruleSimpleInput= ruleSimpleInput EOF
            {
             newCompositeNode(grammarAccess.getSimpleInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleInput=ruleSimpleInput();

            state._fsp--;

             current =iv_ruleSimpleInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleInput"


    // $ANTLR start "ruleSimpleInput"
    // InternalBot.g:2325:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) ;
    public final EObject ruleSimpleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2331:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) )
            // InternalBot.g:2332:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            {
            // InternalBot.g:2332:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            // InternalBot.g:2333:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            {
            // InternalBot.g:2333:3: ()
            // InternalBot.g:2334:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:2340:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2341:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2341:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2342:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_56);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleInputRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2359:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==46) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:2360:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:2364:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:2365:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:2365:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:2366:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_57);
                    lv_values_3_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleInputRule());
                    						}
                    						add(
                    							current,
                    							"values",
                    							lv_values_3_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2383:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==14) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalBot.g:2384:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:2388:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:2389:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:2389:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:2390:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_57);
                    	    lv_values_5_0=ruleEString();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSimpleInputRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_5_0,
                    	    								"org.xtext.botGenerator.Bot.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleInput"


    // $ANTLR start "entryRuleText"
    // InternalBot.g:2413:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:2413:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:2414:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalBot.g:2420:1: ruleText returns [EObject current=null] : (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2426:2: ( (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) )
            // InternalBot.g:2427:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            {
            // InternalBot.g:2427:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            // InternalBot.g:2428:3: otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,47,FOLLOW_58); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0());
            		
            otherlv_1=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2436:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2437:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2437:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2438:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:2459:3: ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==23||LA50_0==25) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:2460:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    {
            	    // InternalBot.g:2460:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    // InternalBot.g:2461:5: lv_inputs_4_0= ruleTextLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_inputs_4_0=ruleTextLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.TextLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleTextLanguageInput"
    // InternalBot.g:2482:1: entryRuleTextLanguageInput returns [EObject current=null] : iv_ruleTextLanguageInput= ruleTextLanguageInput EOF ;
    public final EObject entryRuleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInput = null;


        try {
            // InternalBot.g:2482:58: (iv_ruleTextLanguageInput= ruleTextLanguageInput EOF )
            // InternalBot.g:2483:2: iv_ruleTextLanguageInput= ruleTextLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getTextLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextLanguageInput=ruleTextLanguageInput();

            state._fsp--;

             current =iv_ruleTextLanguageInput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextLanguageInput"


    // $ANTLR start "ruleTextLanguageInput"
    // InternalBot.g:2489:1: ruleTextLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2495:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2496:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2496:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            // InternalBot.g:2497:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:2497:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==23) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBot.g:2498:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:2502:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==24) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalBot.g:2503:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_6); 

                            					newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:2507:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:2508:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:2508:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:2509:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_language_2_0=ruleLanguage();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTextLanguageInputRule());
                            							}
                            							set(
                            								current,
                            								"language",
                            								lv_language_2_0,
                            								"org.xtext.botGenerator.Bot.Language");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_59); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2532:3: ( (lv_inputs_4_0= ruleTextInputText ) )
            // InternalBot.g:2533:4: (lv_inputs_4_0= ruleTextInputText )
            {
            // InternalBot.g:2533:4: (lv_inputs_4_0= ruleTextInputText )
            // InternalBot.g:2534:5: lv_inputs_4_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTextInputText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextLanguageInputRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TextInputText");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2551:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==14) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBot.g:2552:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_59); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:2556:4: ( (lv_inputs_6_0= ruleTextInputText ) )
            	    // InternalBot.g:2557:5: (lv_inputs_6_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:2557:5: (lv_inputs_6_0= ruleTextInputText )
            	    // InternalBot.g:2558:6: lv_inputs_6_0= ruleTextInputText
            	    {

            	    						newCompositeNode(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTextInputText();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTextLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.TextInputText");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTextLanguageInputAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextLanguageInput"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:2584:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:2584:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:2585:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
            {
             newCompositeNode(grammarAccess.getHTTPResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHTTPResponse=ruleHTTPResponse();

            state._fsp--;

             current =iv_ruleHTTPResponse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTPResponse"


    // $ANTLR start "ruleHTTPResponse"
    // InternalBot.g:2591:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ ) ;
    public final EObject ruleHTTPResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2597:2: ( (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ ) )
            // InternalBot.g:2598:2: (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ )
            {
            // InternalBot.g:2598:2: (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ )
            // InternalBot.g:2599:3: otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getResponseKeyword_0());
            		
            // InternalBot.g:2603:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2604:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2604:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2605:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_60); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,50,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getRequestKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPResponseAccess().getColonKeyword_4());
            		
            // InternalBot.g:2634:3: ( ( ruleEString ) )
            // InternalBot.g:2635:4: ( ruleEString )
            {
            // InternalBot.g:2635:4: ( ruleEString )
            // InternalBot.g:2636:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHTTPResponseRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_5_0());
            				
            pushFollow(FOLLOW_15);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_61); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_6());
            		
            // InternalBot.g:2654:3: ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==23) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:2655:4: (lv_inputs_7_0= ruleTextLanguageInputHttpResponse )
            	    {
            	    // InternalBot.g:2655:4: (lv_inputs_7_0= ruleTextLanguageInputHttpResponse )
            	    // InternalBot.g:2656:5: lv_inputs_7_0= ruleTextLanguageInputHttpResponse
            	    {

            	    					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_62);
            	    lv_inputs_7_0=ruleTextLanguageInputHttpResponse();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_7_0,
            	    						"org.xtext.botGenerator.Bot.TextLanguageInputHttpResponse");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPResponse"


    // $ANTLR start "entryRuleHTTPRequest"
    // InternalBot.g:2677:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2677:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2678:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
            {
             newCompositeNode(grammarAccess.getHTTPRequestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleHTTPRequest=ruleHTTPRequest();

            state._fsp--;

             current =iv_ruleHTTPRequest; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHTTPRequest"


    // $ANTLR start "ruleHTTPRequest"
    // InternalBot.g:2684:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? ) ;
    public final EObject ruleHTTPRequest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Enumerator lv_method_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_URL_6_0 = null;

        EObject lv_basicAuth_10_0 = null;

        EObject lv_headers_14_0 = null;

        EObject lv_headers_16_0 = null;

        EObject lv_data_20_0 = null;

        EObject lv_data_22_0 = null;

        Enumerator lv_dataType_26_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2690:2: ( (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? ) )
            // InternalBot.g:2691:2: (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? )
            {
            // InternalBot.g:2691:2: (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? )
            // InternalBot.g:2692:3: otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )?
            {
            otherlv_0=(Token)match(input,50,FOLLOW_63); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getRequestKeyword_0());
            		
            // InternalBot.g:2696:3: ( (lv_method_1_0= ruleMethod ) )
            // InternalBot.g:2697:4: (lv_method_1_0= ruleMethod )
            {
            // InternalBot.g:2697:4: (lv_method_1_0= ruleMethod )
            // InternalBot.g:2698:5: lv_method_1_0= ruleMethod
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_method_1_0=ruleMethod();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"method",
            						lv_method_1_0,
            						"org.xtext.botGenerator.Bot.Method");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2715:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2716:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2716:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2717:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_64); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPRequestAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getColonKeyword_5());
            		
            // InternalBot.g:2746:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2747:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2747:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2748:5: lv_URL_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_15);
            lv_URL_6_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_6_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,20,FOLLOW_65); 

            			newLeafNode(otherlv_7, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_7());
            		
            // InternalBot.g:2769:3: (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==52) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:2770:4: otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';'
                    {
                    otherlv_8=(Token)match(input,52,FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_8_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getColonKeyword_8_1());
                    			
                    // InternalBot.g:2778:4: ( (lv_basicAuth_10_0= ruleKeyValue ) )
                    // InternalBot.g:2779:5: (lv_basicAuth_10_0= ruleKeyValue )
                    {
                    // InternalBot.g:2779:5: (lv_basicAuth_10_0= ruleKeyValue )
                    // InternalBot.g:2780:6: lv_basicAuth_10_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_8_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_basicAuth_10_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						set(
                    							current,
                    							"basicAuth",
                    							lv_basicAuth_10_0,
                    							"org.xtext.botGenerator.Bot.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_11=(Token)match(input,20,FOLLOW_66); 

                    				newLeafNode(otherlv_11, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:2802:3: (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==53) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalBot.g:2803:4: otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,53,FOLLOW_5); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_9_0());
                    			
                    otherlv_13=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:2811:4: ( (lv_headers_14_0= ruleKeyValue ) )
                    // InternalBot.g:2812:5: (lv_headers_14_0= ruleKeyValue )
                    {
                    // InternalBot.g:2812:5: (lv_headers_14_0= ruleKeyValue )
                    // InternalBot.g:2813:6: lv_headers_14_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_headers_14_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						add(
                    							current,
                    							"headers",
                    							lv_headers_14_0,
                    							"org.xtext.botGenerator.Bot.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2830:4: (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==14) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalBot.g:2831:5: otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getHTTPRequestAccess().getCommaKeyword_9_3_0());
                    	    				
                    	    // InternalBot.g:2835:5: ( (lv_headers_16_0= ruleKeyValue ) )
                    	    // InternalBot.g:2836:6: (lv_headers_16_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:2836:6: (lv_headers_16_0= ruleKeyValue )
                    	    // InternalBot.g:2837:7: lv_headers_16_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
                    	    lv_headers_16_0=ruleKeyValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"headers",
                    	    								lv_headers_16_0,
                    	    								"org.xtext.botGenerator.Bot.KeyValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,20,FOLLOW_67); 

                    				newLeafNode(otherlv_17, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:2860:3: (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==54) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalBot.g:2861:4: otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';'
                    {
                    otherlv_18=(Token)match(input,54,FOLLOW_5); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getDataKeyword_10_0());
                    			
                    otherlv_19=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:2869:4: ( (lv_data_20_0= ruleData ) )
                    // InternalBot.g:2870:5: (lv_data_20_0= ruleData )
                    {
                    // InternalBot.g:2870:5: (lv_data_20_0= ruleData )
                    // InternalBot.g:2871:6: lv_data_20_0= ruleData
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_data_20_0=ruleData();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						add(
                    							current,
                    							"data",
                    							lv_data_20_0,
                    							"org.xtext.botGenerator.Bot.Data");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2888:4: (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==14) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // InternalBot.g:2889:5: otherlv_21= ',' ( (lv_data_22_0= ruleData ) )
                    	    {
                    	    otherlv_21=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_21, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:2893:5: ( (lv_data_22_0= ruleData ) )
                    	    // InternalBot.g:2894:6: (lv_data_22_0= ruleData )
                    	    {
                    	    // InternalBot.g:2894:6: (lv_data_22_0= ruleData )
                    	    // InternalBot.g:2895:7: lv_data_22_0= ruleData
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_34);
                    	    lv_data_22_0=ruleData();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"data",
                    	    								lv_data_22_0,
                    	    								"org.xtext.botGenerator.Bot.Data");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,20,FOLLOW_68); 

                    				newLeafNode(otherlv_23, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			
                    otherlv_24=(Token)match(input,55,FOLLOW_5); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_10_5());
                    			
                    otherlv_25=(Token)match(input,13,FOLLOW_69); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_6());
                    			
                    // InternalBot.g:2925:4: ( (lv_dataType_26_0= ruleDataType ) )
                    // InternalBot.g:2926:5: (lv_dataType_26_0= ruleDataType )
                    {
                    // InternalBot.g:2926:5: (lv_dataType_26_0= ruleDataType )
                    // InternalBot.g:2927:6: lv_dataType_26_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_10_7_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_dataType_26_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_26_0,
                    							"org.xtext.botGenerator.Bot.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_27=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_27, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_8());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPRequest"


    // $ANTLR start "entryRuleImage"
    // InternalBot.g:2953:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:2953:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:2954:2: iv_ruleImage= ruleImage EOF
            {
             newCompositeNode(grammarAccess.getImageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImage=ruleImage();

            state._fsp--;

             current =iv_ruleImage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImage"


    // $ANTLR start "ruleImage"
    // InternalBot.g:2960:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) (otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) ) )? ) ;
    public final EObject ruleImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_URL_6_0 = null;

        AntlrDatatypeRuleToken lv_caption_9_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2966:2: ( (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) (otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) ) )? ) )
            // InternalBot.g:2967:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) (otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) ) )? )
            {
            // InternalBot.g:2967:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) (otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) ) )? )
            // InternalBot.g:2968:3: otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) (otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,56,FOLLOW_58); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            otherlv_1=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2976:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2977:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2977:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2978:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImageRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_64); 

            			newLeafNode(otherlv_3, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,51,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:3007:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:3008:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:3008:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:3009:5: lv_URL_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_70);
            lv_URL_6_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImageRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_6_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:3026:3: (otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==57) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalBot.g:3027:4: otherlv_7= 'caption' otherlv_8= ':' ( (lv_caption_9_0= ruleEString ) )
                    {
                    otherlv_7=(Token)match(input,57,FOLLOW_5); 

                    				newLeafNode(otherlv_7, grammarAccess.getImageAccess().getCaptionKeyword_7_0());
                    			
                    otherlv_8=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getImageAccess().getColonKeyword_7_1());
                    			
                    // InternalBot.g:3035:4: ( (lv_caption_9_0= ruleEString ) )
                    // InternalBot.g:3036:5: (lv_caption_9_0= ruleEString )
                    {
                    // InternalBot.g:3036:5: (lv_caption_9_0= ruleEString )
                    // InternalBot.g:3037:6: lv_caption_9_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getImageAccess().getCaptionEStringParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_caption_9_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImageRule());
                    						}
                    						set(
                    							current,
                    							"caption",
                    							lv_caption_9_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImage"


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:3059:1: entryRuleTextLanguageInputHttpResponse returns [EObject current=null] : iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF ;
    public final EObject entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInputHttpResponse = null;


        try {
            // InternalBot.g:3059:70: (iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:3060:2: iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF
            {
             newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextLanguageInputHttpResponse=ruleTextLanguageInputHttpResponse();

            state._fsp--;

             current =iv_ruleTextLanguageInputHttpResponse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextLanguageInputHttpResponse"


    // $ANTLR start "ruleTextLanguageInputHttpResponse"
    // InternalBot.g:3066:1: ruleTextLanguageInputHttpResponse returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_4_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3072:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:3073:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:3073:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            // InternalBot.g:3074:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0());
            		
            // InternalBot.g:3078:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==24) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalBot.g:3079:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:3083:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:3084:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:3084:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:3085:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTextLanguageInputHttpResponseRule());
                    						}
                    						set(
                    							current,
                    							"language",
                    							lv_language_2_0,
                    							"org.xtext.botGenerator.Bot.Language");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:3107:3: ( (lv_inputs_4_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:3108:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:3108:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            // InternalBot.g:3109:5: lv_inputs_4_0= ruleTextInputHttpResponse
            {

            					newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTextInputHttpResponse();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextLanguageInputHttpResponseRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TextInputHttpResponse");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:3126:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==14) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalBot.g:3127:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_71); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:3131:4: ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    // InternalBot.g:3132:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    {
            	    // InternalBot.g:3132:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    // InternalBot.g:3133:6: lv_inputs_6_0= ruleTextInputHttpResponse
            	    {

            	    						newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTextInputHttpResponse();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTextLanguageInputHttpResponseRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.TextInputHttpResponse");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getTextLanguageInputHttpResponseAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextLanguageInputHttpResponse"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:3159:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:3159:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:3160:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
            {
             newCompositeNode(grammarAccess.getTextInputHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextInputHttpResponse=ruleTextInputHttpResponse();

            state._fsp--;

             current =iv_ruleTextInputHttpResponse; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextInputHttpResponse"


    // $ANTLR start "ruleTextInputHttpResponse"
    // InternalBot.g:3166:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:3172:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:3173:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:3173:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_ID)||LA64_0==34||LA64_0==39) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBot.g:3174:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:3174:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:3175:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:3175:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt63=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt63=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt63=2;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt63=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 63, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt63) {
            	        case 1 :
            	            // InternalBot.g:3176:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_72);
            	            lv_tokens_0_1=ruleLiteral();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputHttpResponseRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_1,
            	            						"org.xtext.botGenerator.Bot.Literal");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:3192:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_72);
            	            lv_tokens_0_2=ruleParameterToken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputHttpResponseRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_2,
            	            						"org.xtext.botGenerator.Bot.ParameterToken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 3 :
            	            // InternalBot.g:3208:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_72);
            	            lv_tokens_0_3=ruleHTTPRequestToken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputHttpResponseRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_3,
            	            						"org.xtext.botGenerator.Bot.HTTPRequestToken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextInputHttpResponse"


    // $ANTLR start "entryRuleTextInputText"
    // InternalBot.g:3229:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:3229:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:3230:2: iv_ruleTextInputText= ruleTextInputText EOF
            {
             newCompositeNode(grammarAccess.getTextInputTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextInputText=ruleTextInputText();

            state._fsp--;

             current =iv_ruleTextInputText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextInputText"


    // $ANTLR start "ruleTextInputText"
    // InternalBot.g:3236:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3242:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:3243:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:3243:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_ID)||LA66_0==34) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // InternalBot.g:3244:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:3244:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:3245:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:3245:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt65=2;
            	    int LA65_0 = input.LA(1);

            	    if ( ((LA65_0>=RULE_STRING && LA65_0<=RULE_ID)) ) {
            	        alt65=1;
            	    }
            	    else if ( (LA65_0==34) ) {
            	        alt65=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 65, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt65) {
            	        case 1 :
            	            // InternalBot.g:3246:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_73);
            	            lv_tokens_0_1=ruleLiteral();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputTextRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_1,
            	            						"org.xtext.botGenerator.Bot.Literal");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:3262:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_73);
            	            lv_tokens_0_2=ruleParameterToken();

            	            state._fsp--;


            	            					if (current==null) {
            	            						current = createModelElementForParent(grammarAccess.getTextInputTextRule());
            	            					}
            	            					add(
            	            						current,
            	            						"tokens",
            	            						lv_tokens_0_2,
            	            						"org.xtext.botGenerator.Bot.ParameterToken");
            	            					afterParserOrEnumRuleCall();
            	            				

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextInputText"


    // $ANTLR start "entryRuleKeyValue"
    // InternalBot.g:3283:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:3283:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:3284:2: iv_ruleKeyValue= ruleKeyValue EOF
            {
             newCompositeNode(grammarAccess.getKeyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeyValue=ruleKeyValue();

            state._fsp--;

             current =iv_ruleKeyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyValue"


    // $ANTLR start "ruleKeyValue"
    // InternalBot.g:3290:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3296:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:3297:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:3297:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:3298:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:3298:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3299:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3299:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3300:5: lv_key_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_key_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getKeyValueRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getColonKeyword_1());
            		
            // InternalBot.g:3321:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:3322:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:3322:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:3323:5: lv_value_2_0= ruleLiteral
            {

            					newCompositeNode(grammarAccess.getKeyValueAccess().getValueLiteralParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getKeyValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.botGenerator.Bot.Literal");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyValue"


    // $ANTLR start "entryRuleData"
    // InternalBot.g:3344:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:3344:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:3345:2: iv_ruleData= ruleData EOF
            {
             newCompositeNode(grammarAccess.getDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleData=ruleData();

            state._fsp--;

             current =iv_ruleData; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleData"


    // $ANTLR start "ruleData"
    // InternalBot.g:3351:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3357:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:3358:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:3358:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:3359:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:3359:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3360:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3360:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3361:5: lv_key_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_key_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataRule());
            					}
            					set(
            						current,
            						"key",
            						lv_key_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_59); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:3382:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:3383:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:3383:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:3384:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:3384:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=RULE_STRING && LA67_0<=RULE_ID)) ) {
                alt67=1;
            }
            else if ( (LA67_0==34) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalBot.g:3385:6: lv_value_2_1= ruleLiteral
                    {

                    						newCompositeNode(grammarAccess.getDataAccess().getValueLiteralParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_1=ruleLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_1,
                    							"org.xtext.botGenerator.Bot.Literal");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalBot.g:3401:6: lv_value_2_2= ruleParameterToken
                    {

                    						newCompositeNode(grammarAccess.getDataAccess().getValueParameterTokenParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_2=ruleParameterToken();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_2,
                    							"org.xtext.botGenerator.Bot.ParameterToken");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleData"


    // $ANTLR start "ruleDefaultEntity"
    // InternalBot.g:3423:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:3429:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:3430:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:3430:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt68=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt68=1;
                }
                break;
            case 58:
                {
                alt68=2;
                }
                break;
            case 59:
                {
                alt68=3;
                }
                break;
            case 60:
                {
                alt68=4;
                }
                break;
            case 61:
                {
                alt68=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // InternalBot.g:3431:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3431:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3432:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3439:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:3439:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:3440:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3447:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:3447:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:3448:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3455:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:3455:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:3456:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3463:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:3463:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:3464:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDefaultEntityAccess().getTIMEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultEntity"


    // $ANTLR start "ruleHTTPReturnType"
    // InternalBot.g:3474:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:3480:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:3481:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:3481:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt69=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt69=1;
                }
                break;
            case 62:
                {
                alt69=2;
                }
                break;
            case 56:
                {
                alt69=3;
                }
                break;
            case 54:
                {
                alt69=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // InternalBot.g:3482:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3482:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3483:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3490:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:3490:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:3491:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3498:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:3498:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:3499:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3506:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:3506:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:3507:4: enumLiteral_3= 'data'
                    {
                    enumLiteral_3=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getHTTPReturnTypeAccess().getDATAEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHTTPReturnType"


    // $ANTLR start "ruleLanguage"
    // InternalBot.g:3517:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
    public final Enumerator ruleLanguage() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;
        Token enumLiteral_13=null;
        Token enumLiteral_14=null;
        Token enumLiteral_15=null;
        Token enumLiteral_16=null;
        Token enumLiteral_17=null;
        Token enumLiteral_18=null;
        Token enumLiteral_19=null;
        Token enumLiteral_20=null;
        Token enumLiteral_21=null;
        Token enumLiteral_22=null;
        Token enumLiteral_23=null;
        Token enumLiteral_24=null;
        Token enumLiteral_25=null;


        	enterRule();

        try {
            // InternalBot.g:3523:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:3524:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:3524:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt70=26;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt70=1;
                }
                break;
            case 64:
                {
                alt70=2;
                }
                break;
            case 65:
                {
                alt70=3;
                }
                break;
            case 66:
                {
                alt70=4;
                }
                break;
            case 67:
                {
                alt70=5;
                }
                break;
            case 68:
                {
                alt70=6;
                }
                break;
            case 69:
                {
                alt70=7;
                }
                break;
            case 70:
                {
                alt70=8;
                }
                break;
            case 71:
                {
                alt70=9;
                }
                break;
            case 72:
                {
                alt70=10;
                }
                break;
            case 73:
                {
                alt70=11;
                }
                break;
            case 74:
                {
                alt70=12;
                }
                break;
            case 75:
                {
                alt70=13;
                }
                break;
            case 76:
                {
                alt70=14;
                }
                break;
            case 77:
                {
                alt70=15;
                }
                break;
            case 78:
                {
                alt70=16;
                }
                break;
            case 79:
                {
                alt70=17;
                }
                break;
            case 80:
                {
                alt70=18;
                }
                break;
            case 81:
                {
                alt70=19;
                }
                break;
            case 82:
                {
                alt70=20;
                }
                break;
            case 83:
                {
                alt70=21;
                }
                break;
            case 84:
                {
                alt70=22;
                }
                break;
            case 85:
                {
                alt70=23;
                }
                break;
            case 86:
                {
                alt70=24;
                }
                break;
            case 87:
                {
                alt70=25;
                }
                break;
            case 88:
                {
                alt70=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalBot.g:3525:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:3525:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:3526:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3533:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:3533:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:3534:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3541:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:3541:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:3542:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3549:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:3549:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:3550:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3557:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:3557:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:3558:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:3565:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:3565:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:3566:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:3573:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:3573:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:3574:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:3581:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:3581:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:3582:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:3589:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:3589:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:3590:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:3597:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:3597:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:3598:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:3605:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:3605:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:3606:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:3613:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:3613:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:3614:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:3621:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:3621:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:3622:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:3629:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:3629:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:3630:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:3637:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:3637:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:3638:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:3645:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:3645:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:3646:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:3653:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:3653:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:3654:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:3661:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:3661:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:3662:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:3669:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:3669:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:3670:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:3677:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:3677:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:3678:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:3685:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:3685:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:3686:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:3693:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:3693:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:3694:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:3701:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:3701:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:3702:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:3709:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:3709:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:3710:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:3717:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:3717:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:3718:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:3725:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:3725:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:3726:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_25, grammarAccess.getLanguageAccess().getBANGLAEnumLiteralDeclaration_25());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLanguage"


    // $ANTLR start "ruleDataType"
    // InternalBot.g:3736:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3742:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:3743:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:3743:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==89) ) {
                alt71=1;
            }
            else if ( (LA71_0==90) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalBot.g:3744:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:3744:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:3745:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3752:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:3752:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:3753:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getFORMEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleMethod"
    // InternalBot.g:3763:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3769:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:3770:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:3770:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==91) ) {
                alt72=1;
            }
            else if ( (LA72_0==92) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalBot.g:3771:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:3771:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:3772:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3779:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:3779:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:3780:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMethodAccess().getGETEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"

    // Delegated rules


    protected DFA19 dfa19 = new DFA19(this);
    static final String dfa_1s = "\11\uffff";
    static final String dfa_2s = "\2\uffff\2\5\3\uffff\2\5";
    static final String dfa_3s = "\1\35\1\4\2\16\1\4\2\uffff\2\16";
    static final String dfa_4s = "\1\35\1\5\2\34\1\5\2\uffff\2\34";
    static final String dfa_5s = "\5\uffff\1\1\1\2\2\uffff";
    static final String dfa_6s = "\11\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\1\3",
            "\1\4\5\uffff\1\5\4\uffff\1\6\2\uffff\1\5",
            "\1\4\5\uffff\1\5\4\uffff\1\6\2\uffff\1\5",
            "\1\7\1\10",
            "",
            "",
            "\1\4\5\uffff\1\5\4\uffff\1\6\2\uffff\1\5",
            "\1\4\5\uffff\1\5\4\uffff\1\6\2\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "781:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x8000000000000000L,0x0000000001FFFFFFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000E0000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000E0000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0106800000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0106800000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000102000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010004002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002000000032L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x3C00800000000030L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000200100000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000800004000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x4140800000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000200004000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000102004000030L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000001000000032L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000400000030L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000006000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000008400000030L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000008400000032L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000400000032L});

}