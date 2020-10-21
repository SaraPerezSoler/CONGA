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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language:'", "','", "'intents'", "':'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'parameters:'", "'inputs'", "'in'", "'{'", "'}'", "'user'", "'=>'", "'chatbot'", "'entity'", "'required'", "'isList'", "'prompts'", "'['", "']'", "'Token'", "'@'", "'('", "')'", "'request.'", "'.'", "'Entity'", "'simple'", "'composite'", "'regex'", "'pattern'", "'synonyms'", "'text'", "'response'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'image'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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
    public static final int T__94=94;
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
    // InternalBot.g:72:1: ruleBot returns [EObject current=null] : (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ ) ;
    public final EObject ruleBot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_languages_3_0 = null;

        Enumerator lv_languages_5_0 = null;

        EObject lv_intents_8_0 = null;

        EObject lv_intents_9_0 = null;

        EObject lv_entities_12_0 = null;

        EObject lv_entities_13_0 = null;

        EObject lv_actions_16_0 = null;

        EObject lv_actions_17_0 = null;

        EObject lv_flows_21_0 = null;



        	enterRule();

        try {
            // InternalBot.g:78:2: ( (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ ) )
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ )
            {
            // InternalBot.g:79:2: (otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+ )
            // InternalBot.g:80:3: otherlv_0= 'Chatbot' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'language:' ( (lv_languages_3_0= ruleLanguage ) ) (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )* otherlv_6= 'intents' otherlv_7= ':' ( (lv_intents_8_0= ruleIntent ) ) ( (lv_intents_9_0= ruleIntent ) )* (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )? (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )? otherlv_18= 'flows' otherlv_19= ':' (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+
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
            		
            // InternalBot.g:107:3: ( (lv_languages_3_0= ruleLanguage ) )
            // InternalBot.g:108:4: (lv_languages_3_0= ruleLanguage )
            {
            // InternalBot.g:108:4: (lv_languages_3_0= ruleLanguage )
            // InternalBot.g:109:5: lv_languages_3_0= ruleLanguage
            {

            					newCompositeNode(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_languages_3_0=ruleLanguage();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"languages",
            						lv_languages_3_0,
            						"org.xtext.botGenerator.Bot.Language");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:126:3: (otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBot.g:127:4: otherlv_4= ',' ( (lv_languages_5_0= ruleLanguage ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_5); 

            	    				newLeafNode(otherlv_4, grammarAccess.getBotAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:131:4: ( (lv_languages_5_0= ruleLanguage ) )
            	    // InternalBot.g:132:5: (lv_languages_5_0= ruleLanguage )
            	    {
            	    // InternalBot.g:132:5: (lv_languages_5_0= ruleLanguage )
            	    // InternalBot.g:133:6: lv_languages_5_0= ruleLanguage
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getLanguagesLanguageEnumRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_languages_5_0=ruleLanguage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"languages",
            	    							lv_languages_5_0,
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

            otherlv_6=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_6, grammarAccess.getBotAccess().getIntentsKeyword_5());
            		
            otherlv_7=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getBotAccess().getColonKeyword_6());
            		
            // InternalBot.g:159:3: ( (lv_intents_8_0= ruleIntent ) )
            // InternalBot.g:160:4: (lv_intents_8_0= ruleIntent )
            {
            // InternalBot.g:160:4: (lv_intents_8_0= ruleIntent )
            // InternalBot.g:161:5: lv_intents_8_0= ruleIntent
            {

            					newCompositeNode(grammarAccess.getBotAccess().getIntentsIntentParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_8);
            lv_intents_8_0=ruleIntent();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBotRule());
            					}
            					add(
            						current,
            						"intents",
            						lv_intents_8_0,
            						"org.xtext.botGenerator.Bot.Intent");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:178:3: ( (lv_intents_9_0= ruleIntent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:179:4: (lv_intents_9_0= ruleIntent )
            	    {
            	    // InternalBot.g:179:4: (lv_intents_9_0= ruleIntent )
            	    // InternalBot.g:180:5: lv_intents_9_0= ruleIntent
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
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalBot.g:197:3: (otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBot.g:198:4: otherlv_10= 'entities' otherlv_11= ':' ( (lv_entities_12_0= ruleEntity ) ) ( (lv_entities_13_0= ruleEntity ) )*
                    {
                    otherlv_10=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_10, grammarAccess.getBotAccess().getEntitiesKeyword_9_0());
                    			
                    otherlv_11=(Token)match(input,15,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getBotAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:206:4: ( (lv_entities_12_0= ruleEntity ) )
                    // InternalBot.g:207:5: (lv_entities_12_0= ruleEntity )
                    {
                    // InternalBot.g:207:5: (lv_entities_12_0= ruleEntity )
                    // InternalBot.g:208:6: lv_entities_12_0= ruleEntity
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_entities_12_0=ruleEntity();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"entities",
                    							lv_entities_12_0,
                    							"org.xtext.botGenerator.Bot.Entity");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:225:4: ( (lv_entities_13_0= ruleEntity ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==42) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBot.g:226:5: (lv_entities_13_0= ruleEntity )
                    	    {
                    	    // InternalBot.g:226:5: (lv_entities_13_0= ruleEntity )
                    	    // InternalBot.g:227:6: lv_entities_13_0= ruleEntity
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getEntitiesEntityParserRuleCall_9_3_0());
                    	    					
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
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalBot.g:245:3: (otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBot.g:246:4: otherlv_14= 'actions' otherlv_15= ':' ( (lv_actions_16_0= ruleAction ) ) ( (lv_actions_17_0= ruleAction ) )*
                    {
                    otherlv_14=(Token)match(input,17,FOLLOW_7); 

                    				newLeafNode(otherlv_14, grammarAccess.getBotAccess().getActionsKeyword_10_0());
                    			
                    otherlv_15=(Token)match(input,15,FOLLOW_11); 

                    				newLeafNode(otherlv_15, grammarAccess.getBotAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:254:4: ( (lv_actions_16_0= ruleAction ) )
                    // InternalBot.g:255:5: (lv_actions_16_0= ruleAction )
                    {
                    // InternalBot.g:255:5: (lv_actions_16_0= ruleAction )
                    // InternalBot.g:256:6: lv_actions_16_0= ruleAction
                    {

                    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_actions_16_0=ruleAction();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBotRule());
                    						}
                    						add(
                    							current,
                    							"actions",
                    							lv_actions_16_0,
                    							"org.xtext.botGenerator.Bot.Action");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:273:4: ( (lv_actions_17_0= ruleAction ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==48||LA5_0==50||LA5_0==52||LA5_0==59) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBot.g:274:5: (lv_actions_17_0= ruleAction )
                    	    {
                    	    // InternalBot.g:274:5: (lv_actions_17_0= ruleAction )
                    	    // InternalBot.g:275:6: lv_actions_17_0= ruleAction
                    	    {

                    	    						newCompositeNode(grammarAccess.getBotAccess().getActionsActionParserRuleCall_10_3_0());
                    	    					
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
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_18=(Token)match(input,18,FOLLOW_7); 

            			newLeafNode(otherlv_18, grammarAccess.getBotAccess().getFlowsKeyword_11());
            		
            otherlv_19=(Token)match(input,15,FOLLOW_13); 

            			newLeafNode(otherlv_19, grammarAccess.getBotAccess().getColonKeyword_12());
            		
            // InternalBot.g:301:3: (otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';' )+
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
            	    // InternalBot.g:302:4: otherlv_20= '-' ( (lv_flows_21_0= ruleTransition ) ) otherlv_22= ';'
            	    {
            	    otherlv_20=(Token)match(input,19,FOLLOW_14); 

            	    				newLeafNode(otherlv_20, grammarAccess.getBotAccess().getHyphenMinusKeyword_13_0());
            	    			
            	    // InternalBot.g:306:4: ( (lv_flows_21_0= ruleTransition ) )
            	    // InternalBot.g:307:5: (lv_flows_21_0= ruleTransition )
            	    {
            	    // InternalBot.g:307:5: (lv_flows_21_0= ruleTransition )
            	    // InternalBot.g:308:6: lv_flows_21_0= ruleTransition
            	    {

            	    						newCompositeNode(grammarAccess.getBotAccess().getFlowsTransitionParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_flows_21_0=ruleTransition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBotRule());
            	    						}
            	    						add(
            	    							current,
            	    							"flows",
            	    							lv_flows_21_0,
            	    							"org.xtext.botGenerator.Bot.Transition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_22=(Token)match(input,20,FOLLOW_16); 

            	    				newLeafNode(otherlv_22, grammarAccess.getBotAccess().getSemicolonKeyword_13_2());
            	    			

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
    // InternalBot.g:334:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalBot.g:334:47: (iv_ruleAction= ruleAction EOF )
            // InternalBot.g:335:2: iv_ruleAction= ruleAction EOF
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
    // InternalBot.g:341:1: ruleAction returns [EObject current=null] : (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_Text_0 = null;

        EObject this_HTTPRequest_1 = null;

        EObject this_Image_2 = null;

        EObject this_HTTPResponse_3 = null;



        	enterRule();

        try {
            // InternalBot.g:347:2: ( (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse ) )
            // InternalBot.g:348:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            {
            // InternalBot.g:348:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt8=1;
                }
                break;
            case 52:
                {
                alt8=2;
                }
                break;
            case 59:
                {
                alt8=3;
                }
                break;
            case 50:
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
                    // InternalBot.g:349:3: this_Text_0= ruleText
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
                    // InternalBot.g:358:3: this_HTTPRequest_1= ruleHTTPRequest
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
                    // InternalBot.g:367:3: this_Image_2= ruleImage
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
                    // InternalBot.g:376:3: this_HTTPResponse_3= ruleHTTPResponse
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
    // InternalBot.g:388:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalBot.g:388:47: (iv_ruleEString= ruleEString EOF )
            // InternalBot.g:389:2: iv_ruleEString= ruleEString EOF
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
    // InternalBot.g:395:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalBot.g:401:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalBot.g:402:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalBot.g:402:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // InternalBot.g:403:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:411:3: this_ID_1= RULE_ID
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
    // InternalBot.g:422:1: entryRuleIntent returns [EObject current=null] : iv_ruleIntent= ruleIntent EOF ;
    public final EObject entryRuleIntent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent = null;


        try {
            // InternalBot.g:422:47: (iv_ruleIntent= ruleIntent EOF )
            // InternalBot.g:423:2: iv_ruleIntent= ruleIntent EOF
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
    // InternalBot.g:429:1: ruleIntent returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+ )? ) ;
    public final EObject ruleIntent() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_inputs_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:435:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+ )? ) )
            // InternalBot.g:436:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+ )? )
            {
            // InternalBot.g:436:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+ )? )
            // InternalBot.g:437:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+ )?
            {
            // InternalBot.g:437:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:438:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:438:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:439:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getIntentAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:456:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBot.g:457:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:457:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:458:5: lv_fallbackIntent_1_0= 'Fallback'
                    {
                    lv_fallbackIntent_1_0=(Token)match(input,21,FOLLOW_7); 

                    					newLeafNode(lv_fallbackIntent_1_0, grammarAccess.getIntentAccess().getFallbackIntentFallbackKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIntentRule());
                    					}
                    					setWithLastConsumed(current, "fallbackIntent", lv_fallbackIntent_1_0 != null, "Fallback");
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,15,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getIntentAccess().getColonKeyword_2());
            		
            // InternalBot.g:474:3: ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBot.g:475:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    {
            	    // InternalBot.g:475:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    // InternalBot.g:476:5: lv_inputs_3_0= ruleIntentLanguageInputs
            	    {

            	    					newCompositeNode(grammarAccess.getIntentAccess().getInputsIntentLanguageInputsParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_inputs_3_0=ruleIntentLanguageInputs();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntentRule());
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
            	    break loop11;
                }
            } while (true);

            // InternalBot.g:493:3: (otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+ )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalBot.g:494:4: otherlv_4= 'parameters:' ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntentAccess().getParametersKeyword_4_0());
                    			
                    // InternalBot.g:498:4: ( ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) ) )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_STRING) ) {
                            int LA13_1 = input.LA(2);

                            if ( (LA13_1==15) ) {
                                int LA13_4 = input.LA(3);

                                if ( (LA13_4==30) ) {
                                    alt13=1;
                                }


                            }
                            else if ( (LA13_1==13) ) {
                                alt13=1;
                            }


                        }
                        else if ( (LA13_0==RULE_ID) ) {
                            int LA13_2 = input.LA(2);

                            if ( (LA13_2==15) ) {
                                int LA13_4 = input.LA(3);

                                if ( (LA13_4==30) ) {
                                    alt13=1;
                                }


                            }
                            else if ( (LA13_2==13) ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalBot.g:499:5: ( (lv_parameters_5_0= ruleParameter2 ) )* ( (lv_parameters_6_0= ruleParameter ) )
                    	    {
                    	    // InternalBot.g:499:5: ( (lv_parameters_5_0= ruleParameter2 ) )*
                    	    loop12:
                    	    do {
                    	        int alt12=2;
                    	        int LA12_0 = input.LA(1);

                    	        if ( (LA12_0==RULE_STRING) ) {
                    	            int LA12_1 = input.LA(2);

                    	            if ( (LA12_1==13) ) {
                    	                alt12=1;
                    	            }


                    	        }
                    	        else if ( (LA12_0==RULE_ID) ) {
                    	            int LA12_2 = input.LA(2);

                    	            if ( (LA12_2==13) ) {
                    	                alt12=1;
                    	            }


                    	        }


                    	        switch (alt12) {
                    	    	case 1 :
                    	    	    // InternalBot.g:500:6: (lv_parameters_5_0= ruleParameter2 )
                    	    	    {
                    	    	    // InternalBot.g:500:6: (lv_parameters_5_0= ruleParameter2 )
                    	    	    // InternalBot.g:501:7: lv_parameters_5_0= ruleParameter2
                    	    	    {

                    	    	    							newCompositeNode(grammarAccess.getIntentAccess().getParametersParameter2ParserRuleCall_4_1_0_0());
                    	    	    						
                    	    	    pushFollow(FOLLOW_3);
                    	    	    lv_parameters_5_0=ruleParameter2();

                    	    	    state._fsp--;


                    	    	    							if (current==null) {
                    	    	    								current = createModelElementForParent(grammarAccess.getIntentRule());
                    	    	    							}
                    	    	    							add(
                    	    	    								current,
                    	    	    								"parameters",
                    	    	    								lv_parameters_5_0,
                    	    	    								"org.xtext.botGenerator.Bot.Parameter2");
                    	    	    							afterParserOrEnumRuleCall();
                    	    	    						

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop12;
                    	        }
                    	    } while (true);

                    	    // InternalBot.g:518:5: ( (lv_parameters_6_0= ruleParameter ) )
                    	    // InternalBot.g:519:6: (lv_parameters_6_0= ruleParameter )
                    	    {
                    	    // InternalBot.g:519:6: (lv_parameters_6_0= ruleParameter )
                    	    // InternalBot.g:520:7: lv_parameters_6_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getIntentAccess().getParametersParameterParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_parameters_6_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getIntentRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_6_0,
                    	    								"org.xtext.botGenerator.Bot.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
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
    // $ANTLR end "ruleIntent"


    // $ANTLR start "entryRuleIntentLanguageInputs"
    // InternalBot.g:543:1: entryRuleIntentLanguageInputs returns [EObject current=null] : iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF ;
    public final EObject entryRuleIntentLanguageInputs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentLanguageInputs = null;


        try {
            // InternalBot.g:543:61: (iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF )
            // InternalBot.g:544:2: iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF
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
    // InternalBot.g:550:1: ruleIntentLanguageInputs returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:556:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:557:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:557:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' )
            // InternalBot.g:558:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0());
            		
            // InternalBot.g:562:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:563:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getIntentLanguageInputsAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:567:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:568:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:568:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:569:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,25,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:591:3: ( (lv_inputs_4_0= ruleIntentInput ) )
            // InternalBot.g:592:4: (lv_inputs_4_0= ruleIntentInput )
            {
            // InternalBot.g:592:4: (lv_inputs_4_0= ruleIntentInput )
            // InternalBot.g:593:5: lv_inputs_4_0= ruleIntentInput
            {

            					newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_23);
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

            // InternalBot.g:610:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==13) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalBot.g:611:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_22); 

            	    				newLeafNode(otherlv_5, grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:615:4: ( (lv_inputs_6_0= ruleIntentInput ) )
            	    // InternalBot.g:616:5: (lv_inputs_6_0= ruleIntentInput )
            	    {
            	    // InternalBot.g:616:5: (lv_inputs_6_0= ruleIntentInput )
            	    // InternalBot.g:617:6: lv_inputs_6_0= ruleIntentInput
            	    {

            	    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
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
            	    break loop16;
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
    // InternalBot.g:643:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalBot.g:643:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalBot.g:644:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalBot.g:650:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_target_3_1 = null;

        EObject lv_target_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:656:2: ( (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? ) )
            // InternalBot.g:657:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            {
            // InternalBot.g:657:2: (otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )? )
            // InternalBot.g:658:3: otherlv_0= 'user' ( ( ruleEString ) ) (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getUserKeyword_0());
            		
            // InternalBot.g:662:3: ( ( ruleEString ) )
            // InternalBot.g:663:4: ( ruleEString )
            {
            // InternalBot.g:663:4: ( ruleEString )
            // InternalBot.g:664:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_1_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:678:3: (otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBot.g:679:4: otherlv_2= '=>' ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_2_0());
                    			
                    // InternalBot.g:683:4: ( ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) ) )
                    // InternalBot.g:684:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    {
                    // InternalBot.g:684:5: ( (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 ) )
                    // InternalBot.g:685:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    {
                    // InternalBot.g:685:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )
                    int alt17=2;
                    alt17 = dfa17.predict(input);
                    switch (alt17) {
                        case 1 :
                            // InternalBot.g:686:7: lv_target_3_1= ruleState
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
                            // InternalBot.g:702:7: lv_target_3_2= ruleState2
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
    // InternalBot.g:725:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBot.g:725:46: (iv_ruleState= ruleState EOF )
            // InternalBot.g:726:2: iv_ruleState= ruleState EOF
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
    // InternalBot.g:732:1: ruleState returns [EObject current=null] : (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_outcoming_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:738:2: ( (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? ) )
            // InternalBot.g:739:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? )
            {
            // InternalBot.g:739:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )? )
            // InternalBot.g:740:3: otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getChatbotKeyword_0());
            		
            // InternalBot.g:744:3: ( ( ruleEString ) )
            // InternalBot.g:745:4: ( ruleEString )
            {
            // InternalBot.g:745:4: ( ruleEString )
            // InternalBot.g:746:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_1_0());
            				
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:760:3: (otherlv_2= ',' ( ( ruleEString ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==13) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:761:4: otherlv_2= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalBot.g:765:4: ( ( ruleEString ) )
            	    // InternalBot.g:766:5: ( ruleEString )
            	    {
            	    // InternalBot.g:766:5: ( ruleEString )
            	    // InternalBot.g:767:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_2_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalBot.g:782:3: (otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:783:4: otherlv_4= '=>' ( (lv_outcoming_5_0= ruleTransition ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_3_0());
                    			
                    // InternalBot.g:787:4: ( (lv_outcoming_5_0= ruleTransition ) )
                    // InternalBot.g:788:5: (lv_outcoming_5_0= ruleTransition )
                    {
                    // InternalBot.g:788:5: (lv_outcoming_5_0= ruleTransition )
                    // InternalBot.g:789:6: lv_outcoming_5_0= ruleTransition
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
    // InternalBot.g:811:1: entryRuleState2 returns [EObject current=null] : iv_ruleState2= ruleState2 EOF ;
    public final EObject entryRuleState2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState2 = null;


        try {
            // InternalBot.g:811:47: (iv_ruleState2= ruleState2 EOF )
            // InternalBot.g:812:2: iv_ruleState2= ruleState2 EOF
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
    // InternalBot.g:818:1: ruleState2 returns [EObject current=null] : (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' ) ;
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
            // InternalBot.g:824:2: ( (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' ) )
            // InternalBot.g:825:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' )
            {
            // InternalBot.g:825:2: (otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}' )
            // InternalBot.g:826:3: otherlv_0= 'chatbot' ( ( ruleEString ) ) (otherlv_2= ',' ( ( ruleEString ) ) )* otherlv_4= '{' (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getState2Access().getChatbotKeyword_0());
            		
            // InternalBot.g:830:3: ( ( ruleEString ) )
            // InternalBot.g:831:4: ( ruleEString )
            {
            // InternalBot.g:831:4: ( ruleEString )
            // InternalBot.g:832:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getState2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_1_0());
            				
            pushFollow(FOLLOW_27);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:846:3: (otherlv_2= ',' ( ( ruleEString ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==13) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalBot.g:847:4: otherlv_2= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_2=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_2, grammarAccess.getState2Access().getCommaKeyword_2_0());
            	    			
            	    // InternalBot.g:851:4: ( ( ruleEString ) )
            	    // InternalBot.g:852:5: ( ruleEString )
            	    {
            	    // InternalBot.g:852:5: ( ruleEString )
            	    // InternalBot.g:853:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getState2Rule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_2_1_0());
            	    					
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

            otherlv_4=(Token)match(input,25,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getState2Access().getLeftCurlyBracketKeyword_3());
            		
            // InternalBot.g:872:3: (otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';' )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalBot.g:873:4: otherlv_5= '=>' ( (lv_outcoming_6_0= ruleTransition ) ) otherlv_7= ';'
            	    {
            	    otherlv_5=(Token)match(input,28,FOLLOW_14); 

            	    				newLeafNode(otherlv_5, grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_4_0());
            	    			
            	    // InternalBot.g:877:4: ( (lv_outcoming_6_0= ruleTransition ) )
            	    // InternalBot.g:878:5: (lv_outcoming_6_0= ruleTransition )
            	    {
            	    // InternalBot.g:878:5: (lv_outcoming_6_0= ruleTransition )
            	    // InternalBot.g:879:6: lv_outcoming_6_0= ruleTransition
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

            	    otherlv_7=(Token)match(input,20,FOLLOW_29); 

            	    				newLeafNode(otherlv_7, grammarAccess.getState2Access().getSemicolonKeyword_4_2());
            	    			

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // InternalBot.g:909:1: entryRuleIntentInput returns [EObject current=null] : iv_ruleIntentInput= ruleIntentInput EOF ;
    public final EObject entryRuleIntentInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentInput = null;


        try {
            // InternalBot.g:909:52: (iv_ruleIntentInput= ruleIntentInput EOF )
            // InternalBot.g:910:2: iv_ruleIntentInput= ruleIntentInput EOF
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
    // InternalBot.g:916:1: ruleIntentInput returns [EObject current=null] : (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput ) ;
    public final EObject ruleIntentInput() throws RecognitionException {
        EObject current = null;

        EObject this_TrainingPhrase_0 = null;

        EObject this_RegexInput_1 = null;



        	enterRule();

        try {
            // InternalBot.g:922:2: ( (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput ) )
            // InternalBot.g:923:2: (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput )
            {
            // InternalBot.g:923:2: (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_STRING && LA23_0<=RULE_ID)||LA23_0==38) ) {
                alt23=1;
            }
            else if ( (LA23_0==46) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalBot.g:924:3: this_TrainingPhrase_0= ruleTrainingPhrase
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
                    // InternalBot.g:933:3: this_RegexInput_1= ruleRegexInput
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
    // InternalBot.g:945:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:945:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:946:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
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
    // InternalBot.g:952:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:958:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:959:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:959:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:960:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:960:3: ()
            // InternalBot.g:961:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:967:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_STRING && LA25_0<=RULE_ID)||LA25_0==38) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalBot.g:968:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:968:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:969:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:969:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_ID)) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==38) ) {
            	        alt24=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // InternalBot.g:970:6: lv_tokens_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_30);
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
            	            // InternalBot.g:986:6: lv_tokens_1_2= ruleParameterRefenceToken
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_30);
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
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
    // InternalBot.g:1008:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:1008:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:1009:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalBot.g:1015:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) )? (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token lv_required_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_isList_10_0=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_defaultEntity_4_0 = null;

        EObject lv_prompts_8_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1021:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) )? (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' ) )
            // InternalBot.g:1022:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) )? (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' )
            {
            // InternalBot.g:1022:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) )? (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';' )
            // InternalBot.g:1023:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) )? (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )? (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )? otherlv_11= ';'
            {
            // InternalBot.g:1023:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1024:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1024:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1025:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_1=(Token)match(input,15,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,30,FOLLOW_32); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1050:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_ID)) ) {
                alt26=1;
            }
            else if ( (LA26_0==48||(LA26_0>=60 && LA26_0<=63)) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalBot.g:1051:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:1051:4: ( ( ruleEString ) )
                    // InternalBot.g:1052:5: ( ruleEString )
                    {
                    // InternalBot.g:1052:5: ( ruleEString )
                    // InternalBot.g:1053:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_33);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1068:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:1068:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:1069:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:1069:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:1070:6: lv_defaultEntity_4_0= ruleDefaultEntity
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_33);
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

            // InternalBot.g:1088:3: (otherlv_5= ',' ( (lv_required_6_0= 'required' ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==31) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalBot.g:1089:4: otherlv_5= ',' ( (lv_required_6_0= 'required' ) )
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_34); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1093:4: ( (lv_required_6_0= 'required' ) )
                    // InternalBot.g:1094:5: (lv_required_6_0= 'required' )
                    {
                    // InternalBot.g:1094:5: (lv_required_6_0= 'required' )
                    // InternalBot.g:1095:6: lv_required_6_0= 'required'
                    {
                    lv_required_6_0=(Token)match(input,31,FOLLOW_33); 

                    						newLeafNode(lv_required_6_0, grammarAccess.getParameterAccess().getRequiredRequiredKeyword_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "required", lv_required_6_0 != null, "required");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalBot.g:1108:3: (otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+ )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==13) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==33) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalBot.g:1109:4: otherlv_7= ',' ( (lv_prompts_8_0= rulePromptLanguage ) )+
                    {
                    otherlv_7=(Token)match(input,13,FOLLOW_35); 

                    				newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1113:4: ( (lv_prompts_8_0= rulePromptLanguage ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==33) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalBot.g:1114:5: (lv_prompts_8_0= rulePromptLanguage )
                    	    {
                    	    // InternalBot.g:1114:5: (lv_prompts_8_0= rulePromptLanguage )
                    	    // InternalBot.g:1115:6: lv_prompts_8_0= rulePromptLanguage
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_5_1_0());
                    	    					
                    	    pushFollow(FOLLOW_36);
                    	    lv_prompts_8_0=rulePromptLanguage();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"prompts",
                    	    							lv_prompts_8_0,
                    	    							"org.xtext.botGenerator.Bot.PromptLanguage");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    }
                    break;

            }

            // InternalBot.g:1133:3: (otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==13) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:1134:4: otherlv_9= ',' ( (lv_isList_10_0= 'isList' ) )
                    {
                    otherlv_9=(Token)match(input,13,FOLLOW_37); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getCommaKeyword_6_0());
                    			
                    // InternalBot.g:1138:4: ( (lv_isList_10_0= 'isList' ) )
                    // InternalBot.g:1139:5: (lv_isList_10_0= 'isList' )
                    {
                    // InternalBot.g:1139:5: (lv_isList_10_0= 'isList' )
                    // InternalBot.g:1140:6: lv_isList_10_0= 'isList'
                    {
                    lv_isList_10_0=(Token)match(input,32,FOLLOW_15); 

                    						newLeafNode(lv_isList_10_0, grammarAccess.getParameterAccess().getIsListIsListKeyword_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    						setWithLastConsumed(current, "isList", lv_isList_10_0 != null, "isList");
                    					

                    }


                    }


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
    // InternalBot.g:1161:1: entryRuleParameter2 returns [EObject current=null] : iv_ruleParameter2= ruleParameter2 EOF ;
    public final EObject entryRuleParameter2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter2 = null;


        try {
            // InternalBot.g:1161:51: (iv_ruleParameter2= ruleParameter2 EOF )
            // InternalBot.g:1162:2: iv_ruleParameter2= ruleParameter2 EOF
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
    // InternalBot.g:1168:1: ruleParameter2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) ;
    public final EObject ruleParameter2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1174:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) )
            // InternalBot.g:1175:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            {
            // InternalBot.g:1175:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            // InternalBot.g:1176:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ','
            {
            // InternalBot.g:1176:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1177:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1177:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1178:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameter2Access().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
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

            otherlv_1=(Token)match(input,13,FOLLOW_2); 

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
    // InternalBot.g:1203:1: entryRulePromptLanguage returns [EObject current=null] : iv_rulePromptLanguage= rulePromptLanguage EOF ;
    public final EObject entryRulePromptLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePromptLanguage = null;


        try {
            // InternalBot.g:1203:55: (iv_rulePromptLanguage= rulePromptLanguage EOF )
            // InternalBot.g:1204:2: iv_rulePromptLanguage= rulePromptLanguage EOF
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
    // InternalBot.g:1210:1: rulePromptLanguage returns [EObject current=null] : (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) ;
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
            // InternalBot.g:1216:2: ( (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) )
            // InternalBot.g:1217:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            {
            // InternalBot.g:1217:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            // InternalBot.g:1218:3: otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_39); 

            			newLeafNode(otherlv_0, grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0());
            		
            // InternalBot.g:1222:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==24) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:1223:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getPromptLanguageAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:1227:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1228:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1228:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1229:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_40);
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
            		
            // InternalBot.g:1251:3: ( (lv_prompts_4_0= ruleEString ) )
            // InternalBot.g:1252:4: (lv_prompts_4_0= ruleEString )
            {
            // InternalBot.g:1252:4: (lv_prompts_4_0= ruleEString )
            // InternalBot.g:1253:5: lv_prompts_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_41);
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

            // InternalBot.g:1270:3: (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==13) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBot.g:1271:4: otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:1275:4: ( (lv_prompts_6_0= ruleEString ) )
            	    // InternalBot.g:1276:5: (lv_prompts_6_0= ruleEString )
            	    {
            	    // InternalBot.g:1276:5: (lv_prompts_6_0= ruleEString )
            	    // InternalBot.g:1277:6: lv_prompts_6_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_41);
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
            	    break loop32;
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
    // InternalBot.g:1303:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1303:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1304:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalBot.g:1310:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1316:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1317:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1317:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1318:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1318:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1319:4: lv_text_0_0= ruleEString
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
    // InternalBot.g:1339:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1339:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1340:2: iv_ruleEntityToken= ruleEntityToken EOF
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
    // InternalBot.g:1346:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= 'Token' otherlv_1= '@' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1352:2: ( (otherlv_0= 'Token' otherlv_1= '@' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalBot.g:1353:2: (otherlv_0= 'Token' otherlv_1= '@' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalBot.g:1353:2: (otherlv_0= 'Token' otherlv_1= '@' ( (otherlv_2= RULE_ID ) ) )
            // InternalBot.g:1354:3: otherlv_0= 'Token' otherlv_1= '@' ( (otherlv_2= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_42); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getTokenKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_43); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_1());
            		
            // InternalBot.g:1362:3: ( (otherlv_2= RULE_ID ) )
            // InternalBot.g:1363:4: (otherlv_2= RULE_ID )
            {
            // InternalBot.g:1363:4: (otherlv_2= RULE_ID )
            // InternalBot.g:1364:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityTokenRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_2_0());
            				

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
    // InternalBot.g:1379:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1379:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1380:2: iv_ruleParameterToken= ruleParameterToken EOF
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
    // InternalBot.g:1386:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1392:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1393:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1393:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1394:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1398:3: ( ( ruleEString ) )
            // InternalBot.g:1399:4: ( ruleEString )
            {
            // InternalBot.g:1399:4: ( ruleEString )
            // InternalBot.g:1400:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0());
            				
            pushFollow(FOLLOW_44);
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
    // InternalBot.g:1422:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1422:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1423:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
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
    // InternalBot.g:1429:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1435:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1436:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1436:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1437:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1441:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1442:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1442:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1443:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_45);
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

            otherlv_2=(Token)match(input,39,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1468:3: ( ( ruleEString ) )
            // InternalBot.g:1469:4: ( ruleEString )
            {
            // InternalBot.g:1469:4: ( ruleEString )
            // InternalBot.g:1470:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRefenceTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0());
            				
            pushFollow(FOLLOW_44);
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
    // InternalBot.g:1492:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1492:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1493:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
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
    // InternalBot.g:1499:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1505:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1506:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1506:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1507:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_46); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1511:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1512:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1512:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1513:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_47);
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

            // InternalBot.g:1530:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==41) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:1531:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1535:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1536:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1536:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1537:6: lv_dataKey_3_0= ruleEString
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
    // InternalBot.g:1559:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:1559:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:1560:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalBot.g:1566:1: ruleEntity returns [EObject current=null] : (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleEntity_0 = null;

        EObject this_ComplexEntity_1 = null;

        EObject this_RegexEntity_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1572:2: ( (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) )
            // InternalBot.g:1573:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            {
            // InternalBot.g:1573:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==42) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==RULE_STRING) ) {
                    switch ( input.LA(3) ) {
                    case 43:
                        {
                        alt34=1;
                        }
                        break;
                    case 44:
                        {
                        alt34=2;
                        }
                        break;
                    case 45:
                        {
                        alt34=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 2, input);

                        throw nvae;
                    }

                }
                else if ( (LA34_1==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                    case 43:
                        {
                        alt34=1;
                        }
                        break;
                    case 44:
                        {
                        alt34=2;
                        }
                        break;
                    case 45:
                        {
                        alt34=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 3, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalBot.g:1574:3: this_SimpleEntity_0= ruleSimpleEntity
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
                    // InternalBot.g:1583:3: this_ComplexEntity_1= ruleComplexEntity
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
                    // InternalBot.g:1592:3: this_RegexEntity_2= ruleRegexEntity
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
    // InternalBot.g:1604:1: entryRuleSimpleEntity returns [EObject current=null] : iv_ruleSimpleEntity= ruleSimpleEntity EOF ;
    public final EObject entryRuleSimpleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEntity = null;


        try {
            // InternalBot.g:1604:53: (iv_ruleSimpleEntity= ruleSimpleEntity EOF )
            // InternalBot.g:1605:2: iv_ruleSimpleEntity= ruleSimpleEntity EOF
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
    // InternalBot.g:1611:1: ruleSimpleEntity returns [EObject current=null] : (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'simple' otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ ) ;
    public final EObject ruleSimpleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1617:2: ( (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'simple' otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ ) )
            // InternalBot.g:1618:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'simple' otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ )
            {
            // InternalBot.g:1618:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'simple' otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ )
            // InternalBot.g:1619:3: otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'simple' otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleEntityAccess().getEntityKeyword_0());
            		
            // InternalBot.g:1623:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1624:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1624:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1625:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleEntityAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_48);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleEntityAccess().getSimpleKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getSimpleEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1650:3: ( (lv_inputs_4_0= ruleSLanguageInput ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==23||LA35_0==25) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBot.g:1651:4: (lv_inputs_4_0= ruleSLanguageInput )
            	    {
            	    // InternalBot.g:1651:4: (lv_inputs_4_0= ruleSLanguageInput )
            	    // InternalBot.g:1652:5: lv_inputs_4_0= ruleSLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleEntityAccess().getInputsSLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_50);
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
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
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
    // InternalBot.g:1673:1: entryRuleComplexEntity returns [EObject current=null] : iv_ruleComplexEntity= ruleComplexEntity EOF ;
    public final EObject entryRuleComplexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexEntity = null;


        try {
            // InternalBot.g:1673:54: (iv_ruleComplexEntity= ruleComplexEntity EOF )
            // InternalBot.g:1674:2: iv_ruleComplexEntity= ruleComplexEntity EOF
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
    // InternalBot.g:1680:1: ruleComplexEntity returns [EObject current=null] : (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'composite' otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ ) ;
    public final EObject ruleComplexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1686:2: ( (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'composite' otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ ) )
            // InternalBot.g:1687:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'composite' otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ )
            {
            // InternalBot.g:1687:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'composite' otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ )
            // InternalBot.g:1688:3: otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'composite' otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexEntityAccess().getEntityKeyword_0());
            		
            // InternalBot.g:1692:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1693:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1693:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1694:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getComplexEntityAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_51);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComplexEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,44,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getComplexEntityAccess().getCompositeKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getComplexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1719:3: ( (lv_inputs_4_0= ruleCLanguageInput ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==23||LA36_0==25) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:1720:4: (lv_inputs_4_0= ruleCLanguageInput )
            	    {
            	    // InternalBot.g:1720:4: (lv_inputs_4_0= ruleCLanguageInput )
            	    // InternalBot.g:1721:5: lv_inputs_4_0= ruleCLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getComplexEntityAccess().getInputsCLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_50);
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
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
    // InternalBot.g:1742:1: entryRuleRegexEntity returns [EObject current=null] : iv_ruleRegexEntity= ruleRegexEntity EOF ;
    public final EObject entryRuleRegexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexEntity = null;


        try {
            // InternalBot.g:1742:52: (iv_ruleRegexEntity= ruleRegexEntity EOF )
            // InternalBot.g:1743:2: iv_ruleRegexEntity= ruleRegexEntity EOF
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
    // InternalBot.g:1749:1: ruleRegexEntity returns [EObject current=null] : (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'regex' otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ ) ;
    public final EObject ruleRegexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1755:2: ( (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'regex' otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ ) )
            // InternalBot.g:1756:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'regex' otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ )
            {
            // InternalBot.g:1756:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'regex' otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ )
            // InternalBot.g:1757:3: otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= 'regex' otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRegexEntityAccess().getEntityKeyword_0());
            		
            // InternalBot.g:1761:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1762:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1762:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1763:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRegexEntityAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_52);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegexEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexEntityAccess().getRegexKeyword_2());
            		
            otherlv_3=(Token)match(input,15,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getRegexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1788:3: ( (lv_inputs_4_0= ruleRLanguageInput ) )+
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
            	    // InternalBot.g:1789:4: (lv_inputs_4_0= ruleRLanguageInput )
            	    {
            	    // InternalBot.g:1789:4: (lv_inputs_4_0= ruleRLanguageInput )
            	    // InternalBot.g:1790:5: lv_inputs_4_0= ruleRLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getRegexEntityAccess().getInputsRLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_50);
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
    // $ANTLR end "ruleRegexEntity"


    // $ANTLR start "entryRuleSLanguageInput"
    // InternalBot.g:1811:1: entryRuleSLanguageInput returns [EObject current=null] : iv_ruleSLanguageInput= ruleSLanguageInput EOF ;
    public final EObject entryRuleSLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSLanguageInput = null;


        try {
            // InternalBot.g:1811:55: (iv_ruleSLanguageInput= ruleSLanguageInput EOF )
            // InternalBot.g:1812:2: iv_ruleSLanguageInput= ruleSLanguageInput EOF
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
    // InternalBot.g:1818:1: ruleSLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) ;
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
            // InternalBot.g:1824:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:1825:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:1825:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:1826:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:1826:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==23) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:1827:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_53); 

                    				newLeafNode(otherlv_0, grammarAccess.getSLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getSLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:1835:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1836:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1836:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1837:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getSLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_21);
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
            		
            // InternalBot.g:1859:3: ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* )
            // InternalBot.g:1860:4: ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )*
            {
            // InternalBot.g:1860:4: ( (lv_inputs_4_0= ruleSimpleInput ) )
            // InternalBot.g:1861:5: (lv_inputs_4_0= ruleSimpleInput )
            {
            // InternalBot.g:1861:5: (lv_inputs_4_0= ruleSimpleInput )
            // InternalBot.g:1862:6: lv_inputs_4_0= ruleSimpleInput
            {

            						newCompositeNode(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_54);
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

            // InternalBot.g:1879:4: ( (lv_inputs_5_0= ruleSimpleInput ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBot.g:1880:5: (lv_inputs_5_0= ruleSimpleInput )
            	    {
            	    // InternalBot.g:1880:5: (lv_inputs_5_0= ruleSimpleInput )
            	    // InternalBot.g:1881:6: lv_inputs_5_0= ruleSimpleInput
            	    {

            	    						newCompositeNode(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_54);
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
            	    break loop39;
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
    // InternalBot.g:1907:1: entryRuleCLanguageInput returns [EObject current=null] : iv_ruleCLanguageInput= ruleCLanguageInput EOF ;
    public final EObject entryRuleCLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCLanguageInput = null;


        try {
            // InternalBot.g:1907:55: (iv_ruleCLanguageInput= ruleCLanguageInput EOF )
            // InternalBot.g:1908:2: iv_ruleCLanguageInput= ruleCLanguageInput EOF
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
    // InternalBot.g:1914:1: ruleCLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) ;
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
            // InternalBot.g:1920:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:1921:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:1921:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:1922:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:1922:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==23) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBot.g:1923:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_53); 

                    				newLeafNode(otherlv_0, grammarAccess.getCLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getCLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:1931:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1932:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1932:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1933:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getCLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,25,FOLLOW_55); 

            			newLeafNode(otherlv_3, grammarAccess.getCLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:1955:3: ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* )
            // InternalBot.g:1956:4: ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )*
            {
            // InternalBot.g:1956:4: ( (lv_inputs_4_0= ruleCompositeInput ) )
            // InternalBot.g:1957:5: (lv_inputs_4_0= ruleCompositeInput )
            {
            // InternalBot.g:1957:5: (lv_inputs_4_0= ruleCompositeInput )
            // InternalBot.g:1958:6: lv_inputs_4_0= ruleCompositeInput
            {

            						newCompositeNode(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_56);
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

            // InternalBot.g:1975:4: ( (lv_inputs_5_0= ruleCompositeInput ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_STRING && LA41_0<=RULE_ID)||LA41_0==36) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalBot.g:1976:5: (lv_inputs_5_0= ruleCompositeInput )
            	    {
            	    // InternalBot.g:1976:5: (lv_inputs_5_0= ruleCompositeInput )
            	    // InternalBot.g:1977:6: lv_inputs_5_0= ruleCompositeInput
            	    {

            	    						newCompositeNode(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_56);
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
            	    break loop41;
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
    // InternalBot.g:2003:1: entryRuleRLanguageInput returns [EObject current=null] : iv_ruleRLanguageInput= ruleRLanguageInput EOF ;
    public final EObject entryRuleRLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRLanguageInput = null;


        try {
            // InternalBot.g:2003:55: (iv_ruleRLanguageInput= ruleRLanguageInput EOF )
            // InternalBot.g:2004:2: iv_ruleRLanguageInput= ruleRLanguageInput EOF
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
    // InternalBot.g:2010:1: ruleRLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) ;
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
            // InternalBot.g:2016:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2017:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2017:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2018:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2018:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==23) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:2019:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_53); 

                    				newLeafNode(otherlv_0, grammarAccess.getRLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getRLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2027:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2028:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2028:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2029:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getRLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,25,FOLLOW_22); 

            			newLeafNode(otherlv_3, grammarAccess.getRLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2051:3: ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* )
            // InternalBot.g:2052:4: ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )*
            {
            // InternalBot.g:2052:4: ( (lv_inputs_4_0= ruleRegexInput ) )
            // InternalBot.g:2053:5: (lv_inputs_4_0= ruleRegexInput )
            {
            // InternalBot.g:2053:5: (lv_inputs_4_0= ruleRegexInput )
            // InternalBot.g:2054:6: lv_inputs_4_0= ruleRegexInput
            {

            						newCompositeNode(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_57);
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

            // InternalBot.g:2071:4: ( (lv_inputs_5_0= ruleRegexInput ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==46) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalBot.g:2072:5: (lv_inputs_5_0= ruleRegexInput )
            	    {
            	    // InternalBot.g:2072:5: (lv_inputs_5_0= ruleRegexInput )
            	    // InternalBot.g:2073:6: lv_inputs_5_0= ruleRegexInput
            	    {

            	    						newCompositeNode(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_57);
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
            	    break loop43;
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
    // InternalBot.g:2099:1: entryRuleRegexInput returns [EObject current=null] : iv_ruleRegexInput= ruleRegexInput EOF ;
    public final EObject entryRuleRegexInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexInput = null;


        try {
            // InternalBot.g:2099:51: (iv_ruleRegexInput= ruleRegexInput EOF )
            // InternalBot.g:2100:2: iv_ruleRegexInput= ruleRegexInput EOF
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
    // InternalBot.g:2106:1: ruleRegexInput returns [EObject current=null] : ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) ;
    public final EObject ruleRegexInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2112:2: ( ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) )
            // InternalBot.g:2113:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            {
            // InternalBot.g:2113:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            // InternalBot.g:2114:3: () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) )
            {
            // InternalBot.g:2114:3: ()
            // InternalBot.g:2115:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRegexInputAccess().getRegexInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,46,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexInputAccess().getPatternKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2129:3: ( (lv_expresion_3_0= ruleEString ) )
            // InternalBot.g:2130:4: (lv_expresion_3_0= ruleEString )
            {
            // InternalBot.g:2130:4: (lv_expresion_3_0= ruleEString )
            // InternalBot.g:2131:5: lv_expresion_3_0= ruleEString
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
    // InternalBot.g:2152:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:2152:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:2153:2: iv_ruleCompositeInput= ruleCompositeInput EOF
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
    // InternalBot.g:2159:1: ruleCompositeInput returns [EObject current=null] : ( () ( ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) ) )+ ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject lv_expresion_1_1 = null;

        EObject lv_expresion_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2165:2: ( ( () ( ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) ) )+ ) )
            // InternalBot.g:2166:2: ( () ( ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) ) )+ )
            {
            // InternalBot.g:2166:2: ( () ( ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) ) )+ )
            // InternalBot.g:2167:3: () ( ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) ) )+
            {
            // InternalBot.g:2167:3: ()
            // InternalBot.g:2168:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeInputAccess().getCompositeInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:2174:3: ( ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) ) )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                switch ( input.LA(1) ) {
                case RULE_STRING:
                    {
                    alt45=1;
                    }
                    break;
                case RULE_ID:
                    {
                    alt45=1;
                    }
                    break;
                case 36:
                    {
                    alt45=1;
                    }
                    break;

                }

                switch (alt45) {
            	case 1 :
            	    // InternalBot.g:2175:4: ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:2175:4: ( (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken ) )
            	    // InternalBot.g:2176:5: (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:2176:5: (lv_expresion_1_1= ruleLiteral | lv_expresion_1_2= ruleEntityToken )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( ((LA44_0>=RULE_STRING && LA44_0<=RULE_ID)) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==36) ) {
            	        alt44=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // InternalBot.g:2177:6: lv_expresion_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_58);
            	            lv_expresion_1_1=ruleLiteral();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getCompositeInputRule());
            	            						}
            	            						add(
            	            							current,
            	            							"expresion",
            	            							lv_expresion_1_1,
            	            							"org.xtext.botGenerator.Bot.Literal");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalBot.g:2193:6: lv_expresion_1_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_58);
            	            lv_expresion_1_2=ruleEntityToken();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getCompositeInputRule());
            	            						}
            	            						add(
            	            							current,
            	            							"expresion",
            	            							lv_expresion_1_2,
            	            							"org.xtext.botGenerator.Bot.EntityToken");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
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
    // InternalBot.g:2215:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:2215:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:2216:2: iv_ruleSimpleInput= ruleSimpleInput EOF
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
    // InternalBot.g:2222:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) ;
    public final EObject ruleSimpleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2228:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) )
            // InternalBot.g:2229:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            {
            // InternalBot.g:2229:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            // InternalBot.g:2230:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            {
            // InternalBot.g:2230:3: ()
            // InternalBot.g:2231:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:2237:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2238:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2238:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2239:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_59);
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

            // InternalBot.g:2256:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==47) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:2257:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:2261:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:2262:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:2262:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:2263:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_60);
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

                    // InternalBot.g:2280:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==13) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalBot.g:2281:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:2285:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:2286:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:2286:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:2287:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_60);
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
                    	    break loop46;
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
    // InternalBot.g:2310:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:2310:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:2311:2: iv_ruleText= ruleText EOF
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
    // InternalBot.g:2317:1: ruleText returns [EObject current=null] : (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2323:2: ( (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) )
            // InternalBot.g:2324:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            {
            // InternalBot.g:2324:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            // InternalBot.g:2325:3: otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,48,FOLLOW_61); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0());
            		
            otherlv_1=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2333:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2334:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2334:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2335:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_3=(Token)match(input,15,FOLLOW_49); 

            			newLeafNode(otherlv_3, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:2356:3: ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==23||LA48_0==25) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalBot.g:2357:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    {
            	    // InternalBot.g:2357:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    // InternalBot.g:2358:5: lv_inputs_4_0= ruleTextLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_50);
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
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
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
    // InternalBot.g:2379:1: entryRuleTextLanguageInput returns [EObject current=null] : iv_ruleTextLanguageInput= ruleTextLanguageInput EOF ;
    public final EObject entryRuleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInput = null;


        try {
            // InternalBot.g:2379:58: (iv_ruleTextLanguageInput= ruleTextLanguageInput EOF )
            // InternalBot.g:2380:2: iv_ruleTextLanguageInput= ruleTextLanguageInput EOF
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
    // InternalBot.g:2386:1: ruleTextLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:2392:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2393:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2393:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            // InternalBot.g:2394:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:2394:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==23) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalBot.g:2395:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_20); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:2399:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==24) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // InternalBot.g:2400:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_5); 

                            					newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:2404:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:2405:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:2405:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:2406:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getTextLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,25,FOLLOW_62); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2429:3: ( (lv_inputs_4_0= ruleTextInputText ) )
            // InternalBot.g:2430:4: (lv_inputs_4_0= ruleTextInputText )
            {
            // InternalBot.g:2430:4: (lv_inputs_4_0= ruleTextInputText )
            // InternalBot.g:2431:5: lv_inputs_4_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
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

            // InternalBot.g:2448:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==13) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalBot.g:2449:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_62); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:2453:4: ( (lv_inputs_6_0= ruleTextInputText ) )
            	    // InternalBot.g:2454:5: (lv_inputs_6_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:2454:5: (lv_inputs_6_0= ruleTextInputText )
            	    // InternalBot.g:2455:6: lv_inputs_6_0= ruleTextInputText
            	    {

            	    						newCompositeNode(grammarAccess.getTextLanguageInputAccess().getInputsTextInputTextParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
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
            	    break loop51;
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
    // InternalBot.g:2481:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:2481:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:2482:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
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
    // InternalBot.g:2488:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ ) ;
    public final EObject ruleHTTPResponse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2494:2: ( (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ ) )
            // InternalBot.g:2495:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ )
            {
            // InternalBot.g:2495:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ )
            // InternalBot.g:2496:3: otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0());
            		
            // InternalBot.g:2500:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2501:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2501:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2502:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_2=(Token)match(input,15,FOLLOW_63); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3());
            		
            // InternalBot.g:2527:3: ( ( ruleEString ) )
            // InternalBot.g:2528:4: ( ruleEString )
            {
            // InternalBot.g:2528:4: ( ruleEString )
            // InternalBot.g:2529:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getHTTPResponseRule());
            					}
            				

            					newCompositeNode(grammarAccess.getHTTPResponseAccess().getHTTPRequestHTTPRequestCrossReference_4_0());
            				
            pushFollow(FOLLOW_15);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_64); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5());
            		
            // InternalBot.g:2547:3: ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==23) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:2548:4: (lv_inputs_6_0= ruleTextLanguageInputHttpResponse )
            	    {
            	    // InternalBot.g:2548:4: (lv_inputs_6_0= ruleTextLanguageInputHttpResponse )
            	    // InternalBot.g:2549:5: lv_inputs_6_0= ruleTextLanguageInputHttpResponse
            	    {

            	    					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_65);
            	    lv_inputs_6_0=ruleTextLanguageInputHttpResponse();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_6_0,
            	    						"org.xtext.botGenerator.Bot.TextLanguageInputHttpResponse");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
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
    // InternalBot.g:2570:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2570:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2571:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
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
    // InternalBot.g:2577:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) ;
    public final EObject ruleHTTPRequest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Enumerator lv_method_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_URL_7_0 = null;

        EObject lv_basicAuth_11_0 = null;

        EObject lv_headers_15_0 = null;

        EObject lv_headers_17_0 = null;

        EObject lv_data_21_0 = null;

        EObject lv_data_23_0 = null;

        Enumerator lv_dataType_27_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2583:2: ( (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) )
            // InternalBot.g:2584:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            {
            // InternalBot.g:2584:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            // InternalBot.g:2585:3: otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_66); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0());
            		
            otherlv_1=(Token)match(input,53,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getHTTPRequestAccess().getRequestKeyword_1());
            		
            // InternalBot.g:2593:3: ( (lv_method_2_0= ruleMethod ) )
            // InternalBot.g:2594:4: (lv_method_2_0= ruleMethod )
            {
            // InternalBot.g:2594:4: (lv_method_2_0= ruleMethod )
            // InternalBot.g:2595:5: lv_method_2_0= ruleMethod
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getMethodMethodEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_method_2_0=ruleMethod();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"method",
            						lv_method_2_0,
            						"org.xtext.botGenerator.Bot.Method");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2612:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:2613:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:2613:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:2614:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_68); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getURLKeyword_5());
            		
            otherlv_6=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPRequestAccess().getColonKeyword_6());
            		
            // InternalBot.g:2643:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:2644:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:2644:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:2645:5: lv_URL_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getHTTPRequestAccess().getURLEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_15);
            lv_URL_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_7_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,20,FOLLOW_69); 

            			newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8());
            		
            // InternalBot.g:2666:3: (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==55) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:2667:4: otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,55,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0());
                    			
                    otherlv_10=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:2675:4: ( (lv_basicAuth_11_0= ruleKeyValue ) )
                    // InternalBot.g:2676:5: (lv_basicAuth_11_0= ruleKeyValue )
                    {
                    // InternalBot.g:2676:5: (lv_basicAuth_11_0= ruleKeyValue )
                    // InternalBot.g:2677:6: lv_basicAuth_11_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getBasicAuthKeyValueParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_basicAuth_11_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						set(
                    							current,
                    							"basicAuth",
                    							lv_basicAuth_11_0,
                    							"org.xtext.botGenerator.Bot.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_12=(Token)match(input,20,FOLLOW_70); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:2699:3: (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalBot.g:2700:4: otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';'
                    {
                    otherlv_13=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0());
                    			
                    otherlv_14=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:2708:4: ( (lv_headers_15_0= ruleKeyValue ) )
                    // InternalBot.g:2709:5: (lv_headers_15_0= ruleKeyValue )
                    {
                    // InternalBot.g:2709:5: (lv_headers_15_0= ruleKeyValue )
                    // InternalBot.g:2710:6: lv_headers_15_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_headers_15_0=ruleKeyValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						add(
                    							current,
                    							"headers",
                    							lv_headers_15_0,
                    							"org.xtext.botGenerator.Bot.KeyValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2727:4: (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==13) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalBot.g:2728:5: otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_16=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:2732:5: ( (lv_headers_17_0= ruleKeyValue ) )
                    	    // InternalBot.g:2733:6: (lv_headers_17_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:2733:6: (lv_headers_17_0= ruleKeyValue )
                    	    // InternalBot.g:2734:7: lv_headers_17_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_33);
                    	    lv_headers_17_0=ruleKeyValue();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"headers",
                    	    								lv_headers_17_0,
                    	    								"org.xtext.botGenerator.Bot.KeyValue");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,20,FOLLOW_71); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:2757:3: (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==57) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalBot.g:2758:4: otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';'
                    {
                    otherlv_19=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1());
                    			
                    // InternalBot.g:2766:4: ( (lv_data_21_0= ruleData ) )
                    // InternalBot.g:2767:5: (lv_data_21_0= ruleData )
                    {
                    // InternalBot.g:2767:5: (lv_data_21_0= ruleData )
                    // InternalBot.g:2768:6: lv_data_21_0= ruleData
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_2_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_data_21_0=ruleData();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						add(
                    							current,
                    							"data",
                    							lv_data_21_0,
                    							"org.xtext.botGenerator.Bot.Data");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:2785:4: (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==13) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalBot.g:2786:5: otherlv_22= ',' ( (lv_data_23_0= ruleData ) )
                    	    {
                    	    otherlv_22=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalBot.g:2790:5: ( (lv_data_23_0= ruleData ) )
                    	    // InternalBot.g:2791:6: (lv_data_23_0= ruleData )
                    	    {
                    	    // InternalBot.g:2791:6: (lv_data_23_0= ruleData )
                    	    // InternalBot.g:2792:7: lv_data_23_0= ruleData
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_11_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_33);
                    	    lv_data_23_0=ruleData();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"data",
                    	    								lv_data_23_0,
                    	    								"org.xtext.botGenerator.Bot.Data");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,20,FOLLOW_72); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4());
                    			
                    otherlv_25=(Token)match(input,58,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5());
                    			
                    otherlv_26=(Token)match(input,15,FOLLOW_73); 

                    				newLeafNode(otherlv_26, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6());
                    			
                    // InternalBot.g:2822:4: ( (lv_dataType_27_0= ruleDataType ) )
                    // InternalBot.g:2823:5: (lv_dataType_27_0= ruleDataType )
                    {
                    // InternalBot.g:2823:5: (lv_dataType_27_0= ruleDataType )
                    // InternalBot.g:2824:6: lv_dataType_27_0= ruleDataType
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataTypeDataTypeEnumRuleCall_11_7_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_dataType_27_0=ruleDataType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getHTTPRequestRule());
                    						}
                    						set(
                    							current,
                    							"dataType",
                    							lv_dataType_27_0,
                    							"org.xtext.botGenerator.Bot.DataType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_28=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_28, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_8());
                    			

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
    // InternalBot.g:2850:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:2850:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:2851:2: iv_ruleImage= ruleImage EOF
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
    // InternalBot.g:2857:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) ;
    public final EObject ruleImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_URL_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2863:2: ( (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) )
            // InternalBot.g:2864:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            {
            // InternalBot.g:2864:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            // InternalBot.g:2865:3: otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_61); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            otherlv_1=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2873:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2874:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2874:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2875:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_3=(Token)match(input,15,FOLLOW_68); 

            			newLeafNode(otherlv_3, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,54,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:2904:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2905:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2905:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2906:5: lv_URL_6_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
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
    // InternalBot.g:2927:1: entryRuleTextLanguageInputHttpResponse returns [EObject current=null] : iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF ;
    public final EObject entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInputHttpResponse = null;


        try {
            // InternalBot.g:2927:70: (iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:2928:2: iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF
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
    // InternalBot.g:2934:1: ruleTextLanguageInputHttpResponse returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:2940:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2941:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2941:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            // InternalBot.g:2942:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0());
            		
            // InternalBot.g:2946:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==24) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:2947:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:2951:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2952:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2952:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2953:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_3=(Token)match(input,25,FOLLOW_74); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:2975:3: ( (lv_inputs_4_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:2976:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:2976:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            // InternalBot.g:2977:5: lv_inputs_4_0= ruleTextInputHttpResponse
            {

            					newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_23);
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

            // InternalBot.g:2994:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==13) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalBot.g:2995:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_74); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:2999:4: ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    // InternalBot.g:3000:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    {
            	    // InternalBot.g:3000:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    // InternalBot.g:3001:6: lv_inputs_6_0= ruleTextInputHttpResponse
            	    {

            	    						newCompositeNode(grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_23);
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
            	    break loop59;
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
    // InternalBot.g:3027:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:3027:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:3028:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
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
    // InternalBot.g:3034:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:3040:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:3041:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:3041:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( ((LA61_0>=RULE_STRING && LA61_0<=RULE_ID)||LA61_0==34||LA61_0==40) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalBot.g:3042:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:3042:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:3043:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:3043:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt60=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt60=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt60=2;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt60=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 60, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt60) {
            	        case 1 :
            	            // InternalBot.g:3044:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_75);
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
            	            // InternalBot.g:3060:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_75);
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
            	            // InternalBot.g:3076:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_75);
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
            	    if ( cnt61 >= 1 ) break loop61;
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
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
    // InternalBot.g:3097:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:3097:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:3098:2: iv_ruleTextInputText= ruleTextInputText EOF
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
    // InternalBot.g:3104:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3110:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:3111:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:3111:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( ((LA63_0>=RULE_STRING && LA63_0<=RULE_ID)||LA63_0==34) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBot.g:3112:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:3112:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:3113:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:3113:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt62=2;
            	    int LA62_0 = input.LA(1);

            	    if ( ((LA62_0>=RULE_STRING && LA62_0<=RULE_ID)) ) {
            	        alt62=1;
            	    }
            	    else if ( (LA62_0==34) ) {
            	        alt62=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 62, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt62) {
            	        case 1 :
            	            // InternalBot.g:3114:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_76);
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
            	            // InternalBot.g:3130:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_76);
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
            	    if ( cnt63 >= 1 ) break loop63;
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
    // InternalBot.g:3151:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:3151:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:3152:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalBot.g:3158:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3164:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:3165:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:3165:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:3166:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:3166:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3167:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3167:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3168:5: lv_key_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getKeyValueAccess().getKeyEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_1=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getKeyValueAccess().getColonKeyword_1());
            		
            // InternalBot.g:3189:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:3190:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:3190:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:3191:5: lv_value_2_0= ruleLiteral
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
    // InternalBot.g:3212:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:3212:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:3213:2: iv_ruleData= ruleData EOF
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
    // InternalBot.g:3219:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3225:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:3226:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:3226:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:3227:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:3227:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3228:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3228:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3229:5: lv_key_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataAccess().getKeyEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_1=(Token)match(input,15,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:3250:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:3251:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:3251:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:3252:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:3252:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=RULE_STRING && LA64_0<=RULE_ID)) ) {
                alt64=1;
            }
            else if ( (LA64_0==34) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // InternalBot.g:3253:6: lv_value_2_1= ruleLiteral
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
                    // InternalBot.g:3269:6: lv_value_2_2= ruleParameterToken
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
    // InternalBot.g:3291:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:3297:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:3298:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:3298:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt65=5;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt65=1;
                }
                break;
            case 60:
                {
                alt65=2;
                }
                break;
            case 61:
                {
                alt65=3;
                }
                break;
            case 62:
                {
                alt65=4;
                }
                break;
            case 63:
                {
                alt65=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // InternalBot.g:3299:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3299:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3300:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3307:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:3307:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:3308:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3315:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:3315:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:3316:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3323:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:3323:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:3324:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3331:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:3331:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:3332:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,63,FOLLOW_2); 

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
    // InternalBot.g:3342:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:3348:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:3349:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:3349:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt66=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt66=1;
                }
                break;
            case 64:
                {
                alt66=2;
                }
                break;
            case 59:
                {
                alt66=3;
                }
                break;
            case 57:
                {
                alt66=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalBot.g:3350:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3350:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3351:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3358:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:3358:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:3359:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3366:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:3366:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:3367:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3374:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:3374:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:3375:4: enumLiteral_3= 'data'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_2); 

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
    // InternalBot.g:3385:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
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
            // InternalBot.g:3391:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:3392:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:3392:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt67=26;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt67=1;
                }
                break;
            case 66:
                {
                alt67=2;
                }
                break;
            case 67:
                {
                alt67=3;
                }
                break;
            case 68:
                {
                alt67=4;
                }
                break;
            case 69:
                {
                alt67=5;
                }
                break;
            case 70:
                {
                alt67=6;
                }
                break;
            case 71:
                {
                alt67=7;
                }
                break;
            case 72:
                {
                alt67=8;
                }
                break;
            case 73:
                {
                alt67=9;
                }
                break;
            case 74:
                {
                alt67=10;
                }
                break;
            case 75:
                {
                alt67=11;
                }
                break;
            case 76:
                {
                alt67=12;
                }
                break;
            case 77:
                {
                alt67=13;
                }
                break;
            case 78:
                {
                alt67=14;
                }
                break;
            case 79:
                {
                alt67=15;
                }
                break;
            case 80:
                {
                alt67=16;
                }
                break;
            case 81:
                {
                alt67=17;
                }
                break;
            case 82:
                {
                alt67=18;
                }
                break;
            case 83:
                {
                alt67=19;
                }
                break;
            case 84:
                {
                alt67=20;
                }
                break;
            case 85:
                {
                alt67=21;
                }
                break;
            case 86:
                {
                alt67=22;
                }
                break;
            case 87:
                {
                alt67=23;
                }
                break;
            case 88:
                {
                alt67=24;
                }
                break;
            case 89:
                {
                alt67=25;
                }
                break;
            case 90:
                {
                alt67=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }

            switch (alt67) {
                case 1 :
                    // InternalBot.g:3393:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:3393:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:3394:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3401:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:3401:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:3402:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3409:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:3409:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:3410:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3417:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:3417:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:3418:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3425:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:3425:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:3426:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:3433:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:3433:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:3434:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:3441:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:3441:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:3442:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:3449:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:3449:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:3450:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:3457:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:3457:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:3458:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:3465:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:3465:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:3466:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:3473:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:3473:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:3474:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:3481:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:3481:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:3482:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:3489:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:3489:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:3490:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:3497:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:3497:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:3498:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:3505:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:3505:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:3506:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:3513:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:3513:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:3514:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:3521:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:3521:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:3522:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:3529:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:3529:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:3530:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:3537:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:3537:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:3538:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:3545:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:3545:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:3546:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:3553:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:3553:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:3554:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:3561:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:3561:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:3562:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:3569:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:3569:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:3570:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:3577:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:3577:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:3578:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:3585:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:3585:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:3586:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:3593:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:3593:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:3594:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,90,FOLLOW_2); 

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
    // InternalBot.g:3604:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3610:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:3611:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:3611:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==91) ) {
                alt68=1;
            }
            else if ( (LA68_0==92) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalBot.g:3612:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:3612:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:3613:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3620:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:3620:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:3621:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,92,FOLLOW_2); 

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
    // InternalBot.g:3631:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3637:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:3638:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:3638:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==93) ) {
                alt69=1;
            }
            else if ( (LA69_0==94) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // InternalBot.g:3639:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:3639:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:3640:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3647:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:3647:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:3648:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,94,FOLLOW_2); 

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


    protected DFA17 dfa17 = new DFA17(this);
    static final String dfa_1s = "\11\uffff";
    static final String dfa_2s = "\2\uffff\2\5\3\uffff\2\5";
    static final String dfa_3s = "\1\35\1\4\2\15\1\4\2\uffff\2\15";
    static final String dfa_4s = "\1\35\1\5\2\34\1\5\2\uffff\2\34";
    static final String dfa_5s = "\5\uffff\1\1\1\2\2\uffff";
    static final String dfa_6s = "\11\uffff}>";
    static final String[] dfa_7s = {
            "\1\1",
            "\1\2\1\3",
            "\1\4\6\uffff\1\5\4\uffff\1\6\2\uffff\1\5",
            "\1\4\6\uffff\1\5\4\uffff\1\6\2\uffff\1\5",
            "\1\7\1\10",
            "",
            "",
            "\1\4\6\uffff\1\5\4\uffff\1\6\2\uffff\1\5",
            "\1\4\6\uffff\1\5\4\uffff\1\6\2\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "685:6: (lv_target_3_1= ruleState | lv_target_3_2= ruleState2 )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000007FFFFFEL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000040000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0815000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0815000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000404000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010002002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000032L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xF001000000000030L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000200102000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000401000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000800002000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0A01000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000001004000030L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000404004000030L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000001000000032L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000400000030L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000060000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0380000000000002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000018000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000010400000030L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000010400000032L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000400000032L});

}