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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language:'", "','", "'intents'", "':'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'parameters:'", "'inputs'", "'in'", "'{'", "'}'", "'user'", "'=>'", "'chatbot'", "'entity'", "'required'", "'isList'", "'prompts'", "'['", "']'", "'Token'", "'@'", "'('", "')'", "'request.'", "'.'", "'Entity'", "'r'", "'c'", "'s'", "'synonyms'", "'text'", "'response'", "'HttpResponse'", "'HttpRequest:'", "'HTTP'", "'request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'image'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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

                        if ( (LA5_0==47||LA5_0==49||LA5_0==51||LA5_0==58) ) {
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
            case 47:
                {
                alt8=1;
                }
                break;
            case 51:
                {
                alt8=2;
                }
                break;
            case 58:
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
            else if ( (LA23_0==43) ) {
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
            else if ( (LA26_0==47||(LA26_0>=59 && LA26_0<=62)) ) {
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
    // InternalBot.g:1346:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= 'Token' otherlv_1= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalBot.g:1352:2: ( (otherlv_0= 'Token' otherlv_1= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1353:2: (otherlv_0= 'Token' otherlv_1= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1353:2: (otherlv_0= 'Token' otherlv_1= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1354:3: otherlv_0= 'Token' otherlv_1= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_42); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getTokenKeyword_0());
            		
            otherlv_1=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_1());
            		
            // InternalBot.g:1362:3: ( ( ruleEString ) )
            // InternalBot.g:1363:4: ( ruleEString )
            {
            // InternalBot.g:1363:4: ( ruleEString )
            // InternalBot.g:1364:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEntityTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEntityTokenAccess().getEntityEntityCrossReference_2_0());
            				
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
    // InternalBot.g:1382:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1382:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1383:2: iv_ruleParameterToken= ruleParameterToken EOF
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
    // InternalBot.g:1389:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1395:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1396:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1396:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1397:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1401:3: ( ( ruleEString ) )
            // InternalBot.g:1402:4: ( ruleEString )
            {
            // InternalBot.g:1402:4: ( ruleEString )
            // InternalBot.g:1403:5: ruleEString
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
    // InternalBot.g:1425:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1425:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1426:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
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
    // InternalBot.g:1432:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1438:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1439:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1439:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1440:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1444:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1445:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1445:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1446:5: lv_textReference_1_0= ruleEString
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

            otherlv_2=(Token)match(input,39,FOLLOW_40); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1471:3: ( ( ruleEString ) )
            // InternalBot.g:1472:4: ( ruleEString )
            {
            // InternalBot.g:1472:4: ( ruleEString )
            // InternalBot.g:1473:5: ruleEString
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
    // InternalBot.g:1495:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1495:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1496:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
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
    // InternalBot.g:1502:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1508:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1509:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1509:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1510:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1514:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1515:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1515:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1516:5: lv_type_1_0= ruleHTTPReturnType
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

            // InternalBot.g:1533:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==41) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:1534:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,41,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1538:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1539:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1539:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1540:6: lv_dataKey_3_0= ruleEString
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
    // InternalBot.g:1562:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:1562:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:1563:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalBot.g:1569:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageInput ) )+ ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_inputs_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1575:2: ( (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageInput ) )+ ) )
            // InternalBot.g:1576:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageInput ) )+ )
            {
            // InternalBot.g:1576:2: (otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageInput ) )+ )
            // InternalBot.g:1577:3: otherlv_0= 'Entity' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
            		
            // InternalBot.g:1581:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:1582:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:1582:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:1583:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getEntityAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEntityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_47); 

            			newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getColonKeyword_2());
            		
            // InternalBot.g:1604:3: ( (lv_inputs_3_0= ruleLanguageInput ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==23||LA34_0==25) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalBot.g:1605:4: (lv_inputs_3_0= ruleLanguageInput )
            	    {
            	    // InternalBot.g:1605:4: (lv_inputs_3_0= ruleLanguageInput )
            	    // InternalBot.g:1606:5: lv_inputs_3_0= ruleLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getEntityAccess().getInputsLanguageInputParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_inputs_3_0=ruleLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_3_0,
            	    						"org.xtext.botGenerator.Bot.LanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleLanguageInput"
    // InternalBot.g:1627:1: entryRuleLanguageInput returns [EObject current=null] : iv_ruleLanguageInput= ruleLanguageInput EOF ;
    public final EObject entryRuleLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageInput = null;


        try {
            // InternalBot.g:1627:54: (iv_ruleLanguageInput= ruleLanguageInput EOF )
            // InternalBot.g:1628:2: iv_ruleLanguageInput= ruleLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguageInput=ruleLanguageInput();

            state._fsp--;

             current =iv_ruleLanguageInput; 
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
    // $ANTLR end "entryRuleLanguageInput"


    // $ANTLR start "ruleLanguageInput"
    // InternalBot.g:1634:1: ruleLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleLanguageInput() throws RecognitionException {
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
            // InternalBot.g:1640:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:1641:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:1641:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:1642:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:1642:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==23) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalBot.g:1643:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_49); 

                    				newLeafNode(otherlv_0, grammarAccess.getLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:1651:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1652:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1652:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1653:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLanguageInputRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_50); 

            			newLeafNode(otherlv_3, grammarAccess.getLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:1675:3: ( ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )* )
            // InternalBot.g:1676:4: ( (lv_inputs_4_0= ruleEntityInput ) ) ( (lv_inputs_5_0= ruleEntityInput ) )*
            {
            // InternalBot.g:1676:4: ( (lv_inputs_4_0= ruleEntityInput ) )
            // InternalBot.g:1677:5: (lv_inputs_4_0= ruleEntityInput )
            {
            // InternalBot.g:1677:5: (lv_inputs_4_0= ruleEntityInput )
            // InternalBot.g:1678:6: lv_inputs_4_0= ruleEntityInput
            {

            						newCompositeNode(grammarAccess.getLanguageInputAccess().getInputsEntityInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_51);
            lv_inputs_4_0=ruleEntityInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getLanguageInputRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.EntityInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:1695:4: ( (lv_inputs_5_0= ruleEntityInput ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=43 && LA36_0<=45)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:1696:5: (lv_inputs_5_0= ruleEntityInput )
            	    {
            	    // InternalBot.g:1696:5: (lv_inputs_5_0= ruleEntityInput )
            	    // InternalBot.g:1697:6: lv_inputs_5_0= ruleEntityInput
            	    {

            	    						newCompositeNode(grammarAccess.getLanguageInputAccess().getInputsEntityInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_51);
            	    lv_inputs_5_0=ruleEntityInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLanguageInputRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_5_0,
            	    							"org.xtext.botGenerator.Bot.EntityInput");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            otherlv_6=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getLanguageInputAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleLanguageInput"


    // $ANTLR start "entryRuleEntityInput"
    // InternalBot.g:1723:1: entryRuleEntityInput returns [EObject current=null] : iv_ruleEntityInput= ruleEntityInput EOF ;
    public final EObject entryRuleEntityInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityInput = null;


        try {
            // InternalBot.g:1723:52: (iv_ruleEntityInput= ruleEntityInput EOF )
            // InternalBot.g:1724:2: iv_ruleEntityInput= ruleEntityInput EOF
            {
             newCompositeNode(grammarAccess.getEntityInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntityInput=ruleEntityInput();

            state._fsp--;

             current =iv_ruleEntityInput; 
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
    // $ANTLR end "entryRuleEntityInput"


    // $ANTLR start "ruleEntityInput"
    // InternalBot.g:1730:1: ruleEntityInput returns [EObject current=null] : (this_RegexInput_0= ruleRegexInput | this_CompositeInput_1= ruleCompositeInput | this_SimpleInput_2= ruleSimpleInput ) ;
    public final EObject ruleEntityInput() throws RecognitionException {
        EObject current = null;

        EObject this_RegexInput_0 = null;

        EObject this_CompositeInput_1 = null;

        EObject this_SimpleInput_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1736:2: ( (this_RegexInput_0= ruleRegexInput | this_CompositeInput_1= ruleCompositeInput | this_SimpleInput_2= ruleSimpleInput ) )
            // InternalBot.g:1737:2: (this_RegexInput_0= ruleRegexInput | this_CompositeInput_1= ruleCompositeInput | this_SimpleInput_2= ruleSimpleInput )
            {
            // InternalBot.g:1737:2: (this_RegexInput_0= ruleRegexInput | this_CompositeInput_1= ruleCompositeInput | this_SimpleInput_2= ruleSimpleInput )
            int alt37=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt37=1;
                }
                break;
            case 44:
                {
                alt37=2;
                }
                break;
            case 45:
                {
                alt37=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalBot.g:1738:3: this_RegexInput_0= ruleRegexInput
                    {

                    			newCompositeNode(grammarAccess.getEntityInputAccess().getRegexInputParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegexInput_0=ruleRegexInput();

                    state._fsp--;


                    			current = this_RegexInput_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:1747:3: this_CompositeInput_1= ruleCompositeInput
                    {

                    			newCompositeNode(grammarAccess.getEntityInputAccess().getCompositeInputParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompositeInput_1=ruleCompositeInput();

                    state._fsp--;


                    			current = this_CompositeInput_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalBot.g:1756:3: this_SimpleInput_2= ruleSimpleInput
                    {

                    			newCompositeNode(grammarAccess.getEntityInputAccess().getSimpleInputParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_SimpleInput_2=ruleSimpleInput();

                    state._fsp--;


                    			current = this_SimpleInput_2;
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
    // $ANTLR end "ruleEntityInput"


    // $ANTLR start "entryRuleRegexInput"
    // InternalBot.g:1768:1: entryRuleRegexInput returns [EObject current=null] : iv_ruleRegexInput= ruleRegexInput EOF ;
    public final EObject entryRuleRegexInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexInput = null;


        try {
            // InternalBot.g:1768:51: (iv_ruleRegexInput= ruleRegexInput EOF )
            // InternalBot.g:1769:2: iv_ruleRegexInput= ruleRegexInput EOF
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
    // InternalBot.g:1775:1: ruleRegexInput returns [EObject current=null] : ( () otherlv_1= 'r' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) ;
    public final EObject ruleRegexInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1781:2: ( ( () otherlv_1= 'r' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) )
            // InternalBot.g:1782:2: ( () otherlv_1= 'r' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            {
            // InternalBot.g:1782:2: ( () otherlv_1= 'r' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            // InternalBot.g:1783:3: () otherlv_1= 'r' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) )
            {
            // InternalBot.g:1783:3: ()
            // InternalBot.g:1784:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRegexInputAccess().getRegexInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,43,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexInputAccess().getRKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:1798:3: ( (lv_expresion_3_0= ruleEString ) )
            // InternalBot.g:1799:4: (lv_expresion_3_0= ruleEString )
            {
            // InternalBot.g:1799:4: (lv_expresion_3_0= ruleEString )
            // InternalBot.g:1800:5: lv_expresion_3_0= ruleEString
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
    // InternalBot.g:1821:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:1821:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:1822:2: iv_ruleCompositeInput= ruleCompositeInput EOF
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
    // InternalBot.g:1828:1: ruleCompositeInput returns [EObject current=null] : ( () otherlv_1= 'c' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expresion_3_1 = null;

        EObject lv_expresion_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1834:2: ( ( () otherlv_1= 'c' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) )
            // InternalBot.g:1835:2: ( () otherlv_1= 'c' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            {
            // InternalBot.g:1835:2: ( () otherlv_1= 'c' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            // InternalBot.g:1836:3: () otherlv_1= 'c' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            {
            // InternalBot.g:1836:3: ()
            // InternalBot.g:1837:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeInputAccess().getCompositeInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeInputAccess().getCKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_52); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:1851:3: ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_ID)||LA39_0==36) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalBot.g:1852:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:1852:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    // InternalBot.g:1853:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:1853:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    int alt38=2;
            	    int LA38_0 = input.LA(1);

            	    if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_ID)) ) {
            	        alt38=1;
            	    }
            	    else if ( (LA38_0==36) ) {
            	        alt38=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt38) {
            	        case 1 :
            	            // InternalBot.g:1854:6: lv_expresion_3_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_3_0_0());
            	            					
            	            pushFollow(FOLLOW_53);
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
            	            // InternalBot.g:1870:6: lv_expresion_3_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_3_0_1());
            	            					
            	            pushFollow(FOLLOW_53);
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
    // $ANTLR end "ruleCompositeInput"


    // $ANTLR start "entryRuleSimpleInput"
    // InternalBot.g:1892:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:1892:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:1893:2: iv_ruleSimpleInput= ruleSimpleInput EOF
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
    // InternalBot.g:1899:1: ruleSimpleInput returns [EObject current=null] : ( () otherlv_1= 's' otherlv_2= ':' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )* )? ) ;
    public final EObject ruleSimpleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;

        AntlrDatatypeRuleToken lv_values_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1905:2: ( ( () otherlv_1= 's' otherlv_2= ':' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )* )? ) )
            // InternalBot.g:1906:2: ( () otherlv_1= 's' otherlv_2= ':' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )* )? )
            {
            // InternalBot.g:1906:2: ( () otherlv_1= 's' otherlv_2= ':' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )* )? )
            // InternalBot.g:1907:3: () otherlv_1= 's' otherlv_2= ':' ( (lv_name_3_0= ruleEString ) ) (otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )* )?
            {
            // InternalBot.g:1907:3: ()
            // InternalBot.g:1908:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,45,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleInputAccess().getSKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:1922:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:1923:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:1923:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:1924:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_54);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleInputRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1941:3: (otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==46) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:1942:4: otherlv_4= 'synonyms' ( (lv_values_5_0= ruleEString ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )*
                    {
                    otherlv_4=(Token)match(input,46,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_4_0());
                    			
                    // InternalBot.g:1946:4: ( (lv_values_5_0= ruleEString ) )
                    // InternalBot.g:1947:5: (lv_values_5_0= ruleEString )
                    {
                    // InternalBot.g:1947:5: (lv_values_5_0= ruleEString )
                    // InternalBot.g:1948:6: lv_values_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_55);
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

                    // InternalBot.g:1965:4: (otherlv_6= ',' ( (lv_values_7_0= ruleEString ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==13) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalBot.g:1966:5: otherlv_6= ',' ( (lv_values_7_0= ruleEString ) )
                    	    {
                    	    otherlv_6=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getSimpleInputAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalBot.g:1970:5: ( (lv_values_7_0= ruleEString ) )
                    	    // InternalBot.g:1971:6: (lv_values_7_0= ruleEString )
                    	    {
                    	    // InternalBot.g:1971:6: (lv_values_7_0= ruleEString )
                    	    // InternalBot.g:1972:7: lv_values_7_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_55);
                    	    lv_values_7_0=ruleEString();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSimpleInputRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"values",
                    	    								lv_values_7_0,
                    	    								"org.xtext.botGenerator.Bot.EString");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
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
    // InternalBot.g:1995:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:1995:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:1996:2: iv_ruleText= ruleText EOF
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
    // InternalBot.g:2002:1: ruleText returns [EObject current=null] : (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2008:2: ( (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ ) )
            // InternalBot.g:2009:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            {
            // InternalBot.g:2009:2: (otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+ )
            // InternalBot.g:2010:3: otherlv_0= 'text' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,47,FOLLOW_56); 

            			newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0());
            		
            otherlv_1=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2018:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2019:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2019:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2020:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,15,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:2041:3: ( (lv_inputs_4_0= ruleTextLanguageInput ) )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==23||LA42_0==25) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBot.g:2042:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    {
            	    // InternalBot.g:2042:4: (lv_inputs_4_0= ruleTextLanguageInput )
            	    // InternalBot.g:2043:5: lv_inputs_4_0= ruleTextLanguageInput
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
            	    if ( cnt42 >= 1 ) break loop42;
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
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
    // InternalBot.g:2064:1: entryRuleTextLanguageInput returns [EObject current=null] : iv_ruleTextLanguageInput= ruleTextLanguageInput EOF ;
    public final EObject entryRuleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInput = null;


        try {
            // InternalBot.g:2064:58: (iv_ruleTextLanguageInput= ruleTextLanguageInput EOF )
            // InternalBot.g:2065:2: iv_ruleTextLanguageInput= ruleTextLanguageInput EOF
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
    // InternalBot.g:2071:1: ruleTextLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:2077:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2078:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2078:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            // InternalBot.g:2079:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:2079:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==23) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBot.g:2080:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_20); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:2084:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==24) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalBot.g:2085:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_5); 

                            					newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:2089:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:2090:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:2090:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:2091:7: lv_language_2_0= ruleLanguage
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

            otherlv_3=(Token)match(input,25,FOLLOW_57); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2114:3: ( (lv_inputs_4_0= ruleTextInputText ) )
            // InternalBot.g:2115:4: (lv_inputs_4_0= ruleTextInputText )
            {
            // InternalBot.g:2115:4: (lv_inputs_4_0= ruleTextInputText )
            // InternalBot.g:2116:5: lv_inputs_4_0= ruleTextInputText
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

            // InternalBot.g:2133:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==13) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalBot.g:2134:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_57); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:2138:4: ( (lv_inputs_6_0= ruleTextInputText ) )
            	    // InternalBot.g:2139:5: (lv_inputs_6_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:2139:5: (lv_inputs_6_0= ruleTextInputText )
            	    // InternalBot.g:2140:6: lv_inputs_6_0= ruleTextInputText
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
            	    break loop45;
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
    // InternalBot.g:2166:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:2166:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:2167:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
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
    // InternalBot.g:2173:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ ) ;
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
            // InternalBot.g:2179:2: ( (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ ) )
            // InternalBot.g:2180:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ )
            {
            // InternalBot.g:2180:2: (otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+ )
            // InternalBot.g:2181:3: otherlv_0= 'HttpResponse' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'HttpRequest:' ( ( ruleEString ) ) otherlv_5= ';' ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getHttpResponseKeyword_0());
            		
            // InternalBot.g:2185:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2186:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2186:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2187:5: lv_name_1_0= ruleEString
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

            otherlv_2=(Token)match(input,15,FOLLOW_58); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getHttpRequestKeyword_3());
            		
            // InternalBot.g:2212:3: ( ( ruleEString ) )
            // InternalBot.g:2213:4: ( ruleEString )
            {
            // InternalBot.g:2213:4: ( ruleEString )
            // InternalBot.g:2214:5: ruleEString
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

            otherlv_5=(Token)match(input,20,FOLLOW_59); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_5());
            		
            // InternalBot.g:2232:3: ( (lv_inputs_6_0= ruleTextLanguageInputHttpResponse ) )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==23) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:2233:4: (lv_inputs_6_0= ruleTextLanguageInputHttpResponse )
            	    {
            	    // InternalBot.g:2233:4: (lv_inputs_6_0= ruleTextLanguageInputHttpResponse )
            	    // InternalBot.g:2234:5: lv_inputs_6_0= ruleTextLanguageInputHttpResponse
            	    {

            	    					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_60);
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
            	    if ( cnt46 >= 1 ) break loop46;
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
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
    // InternalBot.g:2255:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2255:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2256:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
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
    // InternalBot.g:2262:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) ;
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
            // InternalBot.g:2268:2: ( (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? ) )
            // InternalBot.g:2269:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            {
            // InternalBot.g:2269:2: (otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )? )
            // InternalBot.g:2270:3: otherlv_0= 'HTTP' otherlv_1= 'request' ( (lv_method_2_0= ruleMethod ) ) ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) otherlv_8= ';' (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )? (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )? (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            {
            otherlv_0=(Token)match(input,51,FOLLOW_61); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getHTTPKeyword_0());
            		
            otherlv_1=(Token)match(input,52,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getHTTPRequestAccess().getRequestKeyword_1());
            		
            // InternalBot.g:2278:3: ( (lv_method_2_0= ruleMethod ) )
            // InternalBot.g:2279:4: (lv_method_2_0= ruleMethod )
            {
            // InternalBot.g:2279:4: (lv_method_2_0= ruleMethod )
            // InternalBot.g:2280:5: lv_method_2_0= ruleMethod
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

            // InternalBot.g:2297:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:2298:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:2298:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:2299:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,15,FOLLOW_63); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getColonKeyword_4());
            		
            otherlv_5=(Token)match(input,53,FOLLOW_7); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getURLKeyword_5());
            		
            otherlv_6=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPRequestAccess().getColonKeyword_6());
            		
            // InternalBot.g:2328:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:2329:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:2329:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:2330:5: lv_URL_7_0= ruleEString
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

            otherlv_8=(Token)match(input,20,FOLLOW_64); 

            			newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8());
            		
            // InternalBot.g:2351:3: (otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==54) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalBot.g:2352:4: otherlv_9= 'basicAuth' otherlv_10= ':' ( (lv_basicAuth_11_0= ruleKeyValue ) ) otherlv_12= ';'
                    {
                    otherlv_9=(Token)match(input,54,FOLLOW_7); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_9_0());
                    			
                    otherlv_10=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:2360:4: ( (lv_basicAuth_11_0= ruleKeyValue ) )
                    // InternalBot.g:2361:5: (lv_basicAuth_11_0= ruleKeyValue )
                    {
                    // InternalBot.g:2361:5: (lv_basicAuth_11_0= ruleKeyValue )
                    // InternalBot.g:2362:6: lv_basicAuth_11_0= ruleKeyValue
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

                    otherlv_12=(Token)match(input,20,FOLLOW_65); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:2384:3: (otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==55) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:2385:4: otherlv_13= 'headers' otherlv_14= ':' ( (lv_headers_15_0= ruleKeyValue ) ) (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )* otherlv_18= ';'
                    {
                    otherlv_13=(Token)match(input,55,FOLLOW_7); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_10_0());
                    			
                    otherlv_14=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:2393:4: ( (lv_headers_15_0= ruleKeyValue ) )
                    // InternalBot.g:2394:5: (lv_headers_15_0= ruleKeyValue )
                    {
                    // InternalBot.g:2394:5: (lv_headers_15_0= ruleKeyValue )
                    // InternalBot.g:2395:6: lv_headers_15_0= ruleKeyValue
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

                    // InternalBot.g:2412:4: (otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==13) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalBot.g:2413:5: otherlv_16= ',' ( (lv_headers_17_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_16=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:2417:5: ( (lv_headers_17_0= ruleKeyValue ) )
                    	    // InternalBot.g:2418:6: (lv_headers_17_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:2418:6: (lv_headers_17_0= ruleKeyValue )
                    	    // InternalBot.g:2419:7: lv_headers_17_0= ruleKeyValue
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
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_18=(Token)match(input,20,FOLLOW_66); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:2442:3: (otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==56) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:2443:4: otherlv_19= 'data' otherlv_20= ':' ( (lv_data_21_0= ruleData ) ) (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )* otherlv_24= ';' otherlv_25= 'dataType' otherlv_26= ':' ( (lv_dataType_27_0= ruleDataType ) ) otherlv_28= ';'
                    {
                    otherlv_19=(Token)match(input,56,FOLLOW_7); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getDataKeyword_11_0());
                    			
                    otherlv_20=(Token)match(input,15,FOLLOW_3); 

                    				newLeafNode(otherlv_20, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_1());
                    			
                    // InternalBot.g:2451:4: ( (lv_data_21_0= ruleData ) )
                    // InternalBot.g:2452:5: (lv_data_21_0= ruleData )
                    {
                    // InternalBot.g:2452:5: (lv_data_21_0= ruleData )
                    // InternalBot.g:2453:6: lv_data_21_0= ruleData
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

                    // InternalBot.g:2470:4: (otherlv_22= ',' ( (lv_data_23_0= ruleData ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==13) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // InternalBot.g:2471:5: otherlv_22= ',' ( (lv_data_23_0= ruleData ) )
                    	    {
                    	    otherlv_22=(Token)match(input,13,FOLLOW_3); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getHTTPRequestAccess().getCommaKeyword_11_3_0());
                    	    				
                    	    // InternalBot.g:2475:5: ( (lv_data_23_0= ruleData ) )
                    	    // InternalBot.g:2476:6: (lv_data_23_0= ruleData )
                    	    {
                    	    // InternalBot.g:2476:6: (lv_data_23_0= ruleData )
                    	    // InternalBot.g:2477:7: lv_data_23_0= ruleData
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
                    	    break loop50;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,20,FOLLOW_67); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_11_4());
                    			
                    otherlv_25=(Token)match(input,57,FOLLOW_7); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_11_5());
                    			
                    otherlv_26=(Token)match(input,15,FOLLOW_68); 

                    				newLeafNode(otherlv_26, grammarAccess.getHTTPRequestAccess().getColonKeyword_11_6());
                    			
                    // InternalBot.g:2507:4: ( (lv_dataType_27_0= ruleDataType ) )
                    // InternalBot.g:2508:5: (lv_dataType_27_0= ruleDataType )
                    {
                    // InternalBot.g:2508:5: (lv_dataType_27_0= ruleDataType )
                    // InternalBot.g:2509:6: lv_dataType_27_0= ruleDataType
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
    // InternalBot.g:2535:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:2535:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:2536:2: iv_ruleImage= ruleImage EOF
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
    // InternalBot.g:2542:1: ruleImage returns [EObject current=null] : (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) ;
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
            // InternalBot.g:2548:2: ( (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) ) )
            // InternalBot.g:2549:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            {
            // InternalBot.g:2549:2: (otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) )
            // InternalBot.g:2550:3: otherlv_0= 'image' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_56); 

            			newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0());
            		
            otherlv_1=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2558:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2559:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2559:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2560:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,15,FOLLOW_63); 

            			newLeafNode(otherlv_3, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,53,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,15,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:2589:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2590:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2590:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2591:5: lv_URL_6_0= ruleEString
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
    // InternalBot.g:2612:1: entryRuleTextLanguageInputHttpResponse returns [EObject current=null] : iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF ;
    public final EObject entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInputHttpResponse = null;


        try {
            // InternalBot.g:2612:70: (iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:2613:2: iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF
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
    // InternalBot.g:2619:1: ruleTextLanguageInputHttpResponse returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:2625:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2626:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2626:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            // InternalBot.g:2627:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_20); 

            			newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0());
            		
            // InternalBot.g:2631:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==24) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalBot.g:2632:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_5); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:2636:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2637:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2637:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2638:6: lv_language_2_0= ruleLanguage
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

            otherlv_3=(Token)match(input,25,FOLLOW_69); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:2660:3: ( (lv_inputs_4_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:2661:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:2661:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            // InternalBot.g:2662:5: lv_inputs_4_0= ruleTextInputHttpResponse
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

            // InternalBot.g:2679:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==13) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalBot.g:2680:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_69); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:2684:4: ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    // InternalBot.g:2685:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    {
            	    // InternalBot.g:2685:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    // InternalBot.g:2686:6: lv_inputs_6_0= ruleTextInputHttpResponse
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
            	    break loop53;
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
    // InternalBot.g:2712:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:2712:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:2713:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
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
    // InternalBot.g:2719:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:2725:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:2726:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:2726:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=RULE_STRING && LA55_0<=RULE_ID)||LA55_0==34||LA55_0==40) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // InternalBot.g:2727:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:2727:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:2728:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:2728:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt54=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt54=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt54=2;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt54=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 54, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt54) {
            	        case 1 :
            	            // InternalBot.g:2729:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_70);
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
            	            // InternalBot.g:2745:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_70);
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
            	            // InternalBot.g:2761:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_70);
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
            	    if ( cnt55 >= 1 ) break loop55;
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
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
    // InternalBot.g:2782:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:2782:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:2783:2: iv_ruleTextInputText= ruleTextInputText EOF
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
    // InternalBot.g:2789:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2795:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:2796:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:2796:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( ((LA57_0>=RULE_STRING && LA57_0<=RULE_ID)||LA57_0==34) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalBot.g:2797:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:2797:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:2798:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:2798:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt56=2;
            	    int LA56_0 = input.LA(1);

            	    if ( ((LA56_0>=RULE_STRING && LA56_0<=RULE_ID)) ) {
            	        alt56=1;
            	    }
            	    else if ( (LA56_0==34) ) {
            	        alt56=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 56, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt56) {
            	        case 1 :
            	            // InternalBot.g:2799:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_71);
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
            	            // InternalBot.g:2815:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_71);
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
            	    if ( cnt57 >= 1 ) break loop57;
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
    // InternalBot.g:2836:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:2836:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:2837:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalBot.g:2843:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2849:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:2850:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:2850:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:2851:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:2851:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2852:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2852:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2853:5: lv_key_0_0= ruleEString
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
            		
            // InternalBot.g:2874:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:2875:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:2875:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:2876:5: lv_value_2_0= ruleLiteral
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
    // InternalBot.g:2897:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:2897:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:2898:2: iv_ruleData= ruleData EOF
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
    // InternalBot.g:2904:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2910:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:2911:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:2911:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:2912:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:2912:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:2913:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:2913:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:2914:5: lv_key_0_0= ruleEString
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

            otherlv_1=(Token)match(input,15,FOLLOW_57); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:2935:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:2936:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:2936:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:2937:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:2937:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_STRING && LA58_0<=RULE_ID)) ) {
                alt58=1;
            }
            else if ( (LA58_0==34) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:2938:6: lv_value_2_1= ruleLiteral
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
                    // InternalBot.g:2954:6: lv_value_2_2= ruleParameterToken
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
    // InternalBot.g:2976:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:2982:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:2983:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:2983:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt59=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt59=1;
                }
                break;
            case 59:
                {
                alt59=2;
                }
                break;
            case 60:
                {
                alt59=3;
                }
                break;
            case 61:
                {
                alt59=4;
                }
                break;
            case 62:
                {
                alt59=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalBot.g:2984:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:2984:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:2985:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:2992:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:2992:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:2993:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3000:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:3000:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:3001:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3008:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:3008:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:3009:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3016:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:3016:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:3017:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,62,FOLLOW_2); 

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
    // InternalBot.g:3027:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:3033:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:3034:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:3034:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt60=4;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt60=1;
                }
                break;
            case 63:
                {
                alt60=2;
                }
                break;
            case 58:
                {
                alt60=3;
                }
                break;
            case 56:
                {
                alt60=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalBot.g:3035:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3035:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3036:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3043:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:3043:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:3044:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3051:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:3051:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:3052:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3059:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:3059:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:3060:4: enumLiteral_3= 'data'
                    {
                    enumLiteral_3=(Token)match(input,56,FOLLOW_2); 

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
    // InternalBot.g:3070:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
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
            // InternalBot.g:3076:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:3077:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:3077:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt61=26;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt61=1;
                }
                break;
            case 65:
                {
                alt61=2;
                }
                break;
            case 66:
                {
                alt61=3;
                }
                break;
            case 67:
                {
                alt61=4;
                }
                break;
            case 68:
                {
                alt61=5;
                }
                break;
            case 69:
                {
                alt61=6;
                }
                break;
            case 70:
                {
                alt61=7;
                }
                break;
            case 71:
                {
                alt61=8;
                }
                break;
            case 72:
                {
                alt61=9;
                }
                break;
            case 73:
                {
                alt61=10;
                }
                break;
            case 74:
                {
                alt61=11;
                }
                break;
            case 75:
                {
                alt61=12;
                }
                break;
            case 76:
                {
                alt61=13;
                }
                break;
            case 77:
                {
                alt61=14;
                }
                break;
            case 78:
                {
                alt61=15;
                }
                break;
            case 79:
                {
                alt61=16;
                }
                break;
            case 80:
                {
                alt61=17;
                }
                break;
            case 81:
                {
                alt61=18;
                }
                break;
            case 82:
                {
                alt61=19;
                }
                break;
            case 83:
                {
                alt61=20;
                }
                break;
            case 84:
                {
                alt61=21;
                }
                break;
            case 85:
                {
                alt61=22;
                }
                break;
            case 86:
                {
                alt61=23;
                }
                break;
            case 87:
                {
                alt61=24;
                }
                break;
            case 88:
                {
                alt61=25;
                }
                break;
            case 89:
                {
                alt61=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalBot.g:3078:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:3078:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:3079:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3086:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:3086:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:3087:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3094:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:3094:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:3095:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:3102:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:3102:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:3103:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:3110:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:3110:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:3111:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:3118:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:3118:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:3119:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:3126:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:3126:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:3127:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:3134:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:3134:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:3135:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:3142:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:3142:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:3143:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:3150:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:3150:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:3151:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:3158:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:3158:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:3159:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:3166:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:3166:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:3167:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:3174:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:3174:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:3175:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:3182:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:3182:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:3183:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:3190:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:3190:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:3191:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:3198:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:3198:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:3199:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:3206:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:3206:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:3207:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:3214:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:3214:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:3215:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:3222:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:3222:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:3223:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:3230:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:3230:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:3231:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:3238:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:3238:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:3239:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:3246:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:3246:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:3247:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:3254:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:3254:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:3255:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:3262:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:3262:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:3263:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:3270:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:3270:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:3271:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:3278:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:3278:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:3279:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,89,FOLLOW_2); 

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
    // InternalBot.g:3289:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3295:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:3296:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:3296:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==90) ) {
                alt62=1;
            }
            else if ( (LA62_0==91) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalBot.g:3297:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:3297:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:3298:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3305:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:3305:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:3306:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); 

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
    // InternalBot.g:3316:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:3322:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:3323:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:3323:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==92) ) {
                alt63=1;
            }
            else if ( (LA63_0==93) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalBot.g:3324:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:3324:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:3325:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3332:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:3332:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:3333:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); 

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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000003FFFFFFL});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000040000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x040A800000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x040A800000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000084000000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010002002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000004000000032L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x7800800000000030L});
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
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x8500800000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000384000000030L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000384004000030L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000001000000032L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000400000030L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x01C0000000000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0180000000000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000010400000030L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000010400000032L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000400000032L});

}