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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language'", "':'", "','", "'intents'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'parameters'", "'inputs'", "'in'", "'{'", "'}'", "'user'", "'=>'", "'chatbot'", "'back'", "'to'", "'entity'", "'isList'", "'required'", "'prompts'", "'['", "']'", "'@'", "'('", "')'", "'request.'", "'.'", "'Simple'", "'Composite'", "'Regex'", "'pattern'", "'composite'", "'synonyms'", "'Text'", "'text'", "'response'", "'Response'", "'Request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'Image'", "'mage'", "'caption'", "'Empty'", "'Button'", "'text:'", "'buttons:'", "'value:'", "'action:'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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
    public static final int T__102=102;
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
    public static final int T__103=103;
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

                        if ( ((LA3_0>=43 && LA3_0<=45)) ) {
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

                        if ( ((LA5_0>=49 && LA5_0<=50)||(LA5_0>=52 && LA5_0<=53)||(LA5_0>=59 && LA5_0<=60)||(LA5_0>=62 && LA5_0<=63)) ) {
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
    // InternalBot.g:345:1: ruleAction returns [EObject current=null] : (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse | this_Empty_4= ruleEmpty | this_ButtonAction_5= ruleButtonAction ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        EObject this_Text_0 = null;

        EObject this_HTTPRequest_1 = null;

        EObject this_Image_2 = null;

        EObject this_HTTPResponse_3 = null;

        EObject this_Empty_4 = null;

        EObject this_ButtonAction_5 = null;



        	enterRule();

        try {
            // InternalBot.g:351:2: ( (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse | this_Empty_4= ruleEmpty | this_ButtonAction_5= ruleButtonAction ) )
            // InternalBot.g:352:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse | this_Empty_4= ruleEmpty | this_ButtonAction_5= ruleButtonAction )
            {
            // InternalBot.g:352:2: (this_Text_0= ruleText | this_HTTPRequest_1= ruleHTTPRequest | this_Image_2= ruleImage | this_HTTPResponse_3= ruleHTTPResponse | this_Empty_4= ruleEmpty | this_ButtonAction_5= ruleButtonAction )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 49:
            case 50:
                {
                alt8=1;
                }
                break;
            case 53:
                {
                alt8=2;
                }
                break;
            case 59:
            case 60:
                {
                alt8=3;
                }
                break;
            case 52:
                {
                alt8=4;
                }
                break;
            case 62:
                {
                alt8=5;
                }
                break;
            case 63:
                {
                alt8=6;
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
                case 5 :
                    // InternalBot.g:389:3: this_Empty_4= ruleEmpty
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getEmptyParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Empty_4=ruleEmpty();

                    state._fsp--;


                    			current = this_Empty_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalBot.g:398:3: this_ButtonAction_5= ruleButtonAction
                    {

                    			newCompositeNode(grammarAccess.getActionAccess().getButtonActionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ButtonAction_5=ruleButtonAction();

                    state._fsp--;


                    			current = this_ButtonAction_5;
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
    // InternalBot.g:410:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalBot.g:410:47: (iv_ruleEString= ruleEString EOF )
            // InternalBot.g:411:2: iv_ruleEString= ruleEString EOF
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
    // InternalBot.g:417:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalBot.g:423:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalBot.g:424:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalBot.g:424:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // InternalBot.g:425:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalBot.g:433:3: this_ID_1= RULE_ID
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
    // InternalBot.g:444:1: entryRuleIntent returns [EObject current=null] : iv_ruleIntent= ruleIntent EOF ;
    public final EObject entryRuleIntent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent = null;


        try {
            // InternalBot.g:444:47: (iv_ruleIntent= ruleIntent EOF )
            // InternalBot.g:445:2: iv_ruleIntent= ruleIntent EOF
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
    // InternalBot.g:451:1: ruleIntent returns [EObject current=null] : (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 ) ;
    public final EObject ruleIntent() throws RecognitionException {
        EObject current = null;

        EObject this_Intent1_0 = null;

        EObject this_Intent2_1 = null;



        	enterRule();

        try {
            // InternalBot.g:457:2: ( (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 ) )
            // InternalBot.g:458:2: (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 )
            {
            // InternalBot.g:458:2: (this_Intent1_0= ruleIntent1 | this_Intent2_1= ruleIntent2 )
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
                    // InternalBot.g:459:3: this_Intent1_0= ruleIntent1
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
                    // InternalBot.g:468:3: this_Intent2_1= ruleIntent2
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
    // InternalBot.g:480:1: entryRuleIntent2 returns [EObject current=null] : iv_ruleIntent2= ruleIntent2 EOF ;
    public final EObject entryRuleIntent2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent2 = null;


        try {
            // InternalBot.g:480:48: (iv_ruleIntent2= ruleIntent2 EOF )
            // InternalBot.g:481:2: iv_ruleIntent2= ruleIntent2 EOF
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
    // InternalBot.g:487:1: ruleIntent2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? ) ;
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
            // InternalBot.g:493:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? ) )
            // InternalBot.g:494:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? )
            {
            // InternalBot.g:494:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? )
            // InternalBot.g:495:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )?
            {
            // InternalBot.g:495:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:496:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:496:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:497:5: lv_name_0_0= ruleEString
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

            // InternalBot.g:514:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalBot.g:515:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:515:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:516:5: lv_fallbackIntent_1_0= 'Fallback'
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
            		
            // InternalBot.g:532:3: ( (lv_inputs_3_0= ruleIntentLanguageInputs ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23||LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBot.g:533:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    {
            	    // InternalBot.g:533:4: (lv_inputs_3_0= ruleIntentLanguageInputs )
            	    // InternalBot.g:534:5: lv_inputs_3_0= ruleIntentLanguageInputs
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

            // InternalBot.g:551:3: (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalBot.g:552:4: otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_5); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntent2Access().getParametersKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getIntent2Access().getColonKeyword_4_1());
                    			
                    // InternalBot.g:560:4: ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_STRING) ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1==14) ) {
                                alt14=1;
                            }
                            else if ( (LA14_1==13) ) {
                                int LA14_5 = input.LA(3);

                                if ( (LA14_5==32) ) {
                                    alt14=1;
                                }


                            }


                        }
                        else if ( (LA14_0==RULE_ID) ) {
                            int LA14_2 = input.LA(2);

                            if ( (LA14_2==13) ) {
                                int LA14_5 = input.LA(3);

                                if ( (LA14_5==32) ) {
                                    alt14=1;
                                }


                            }
                            else if ( (LA14_2==14) ) {
                                alt14=1;
                            }


                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalBot.g:561:5: ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) )
                    	    {
                    	    // InternalBot.g:561:5: ( (lv_parameters_6_0= ruleParameter2 ) )*
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
                    	    	    // InternalBot.g:562:6: (lv_parameters_6_0= ruleParameter2 )
                    	    	    {
                    	    	    // InternalBot.g:562:6: (lv_parameters_6_0= ruleParameter2 )
                    	    	    // InternalBot.g:563:7: lv_parameters_6_0= ruleParameter2
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

                    	    // InternalBot.g:580:5: ( (lv_parameters_7_0= ruleParameter ) )
                    	    // InternalBot.g:581:6: (lv_parameters_7_0= ruleParameter )
                    	    {
                    	    // InternalBot.g:581:6: (lv_parameters_7_0= ruleParameter )
                    	    // InternalBot.g:582:7: lv_parameters_7_0= ruleParameter
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
    // InternalBot.g:605:1: entryRuleIntent1 returns [EObject current=null] : iv_ruleIntent1= ruleIntent1 EOF ;
    public final EObject entryRuleIntent1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntent1 = null;


        try {
            // InternalBot.g:605:48: (iv_ruleIntent1= ruleIntent1 EOF )
            // InternalBot.g:606:2: iv_ruleIntent1= ruleIntent1 EOF
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
    // InternalBot.g:612:1: ruleIntent1 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? ) ;
    public final EObject ruleIntent1() throws RecognitionException {
        EObject current = null;

        Token lv_fallbackIntent_1_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:618:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? ) )
            // InternalBot.g:619:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? )
            {
            // InternalBot.g:619:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? )
            // InternalBot.g:620:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            {
            // InternalBot.g:620:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:621:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:621:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:622:5: lv_name_0_0= ruleEString
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

            // InternalBot.g:639:3: ( (lv_fallbackIntent_1_0= 'Fallback' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==21) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalBot.g:640:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    {
                    // InternalBot.g:640:4: (lv_fallbackIntent_1_0= 'Fallback' )
                    // InternalBot.g:641:5: lv_fallbackIntent_1_0= 'Fallback'
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
    // InternalBot.g:657:1: entryRuleIntentLanguageInputs returns [EObject current=null] : iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF ;
    public final EObject entryRuleIntentLanguageInputs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentLanguageInputs = null;


        try {
            // InternalBot.g:657:61: (iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF )
            // InternalBot.g:658:2: iv_ruleIntentLanguageInputs= ruleIntentLanguageInputs EOF
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
    // InternalBot.g:664:1: ruleIntentLanguageInputs returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:670:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:671:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:671:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}' )
            // InternalBot.g:672:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleIntentInput ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:672:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==23) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalBot.g:673:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getIntentLanguageInputsAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:677:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==24) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalBot.g:678:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_6); 

                            					newLeafNode(otherlv_1, grammarAccess.getIntentLanguageInputsAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:682:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:683:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:683:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:684:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
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


                    }
                    break;

            }

            otherlv_3=(Token)match(input,25,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentLanguageInputsAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:707:3: ( (lv_inputs_4_0= ruleIntentInput ) )
            // InternalBot.g:708:4: (lv_inputs_4_0= ruleIntentInput )
            {
            // InternalBot.g:708:4: (lv_inputs_4_0= ruleIntentInput )
            // InternalBot.g:709:5: lv_inputs_4_0= ruleIntentInput
            {

            					newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_2_0());
            				
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

            // InternalBot.g:726:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==14) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:727:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleIntentInput ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_23); 

            	    				newLeafNode(otherlv_5, grammarAccess.getIntentLanguageInputsAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:731:4: ( (lv_inputs_6_0= ruleIntentInput ) )
            	    // InternalBot.g:732:5: (lv_inputs_6_0= ruleIntentInput )
            	    {
            	    // InternalBot.g:732:5: (lv_inputs_6_0= ruleIntentInput )
            	    // InternalBot.g:733:6: lv_inputs_6_0= ruleIntentInput
            	    {

            	    						newCompositeNode(grammarAccess.getIntentLanguageInputsAccess().getInputsIntentInputParserRuleCall_3_1_0());
            	    					
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
            	    break loop19;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getIntentLanguageInputsAccess().getRightCurlyBracketKeyword_4());
            		

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
    // InternalBot.g:759:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // InternalBot.g:759:51: (iv_ruleTransition= ruleTransition EOF )
            // InternalBot.g:760:2: iv_ruleTransition= ruleTransition EOF
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
    // InternalBot.g:766:1: ruleTransition returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'user' ( ( ruleEString ) ) (otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) ) )? ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_target_5_1 = null;

        EObject lv_target_5_2 = null;

        EObject lv_backTo_6_0 = null;



        	enterRule();

        try {
            // InternalBot.g:772:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'user' ( ( ruleEString ) ) (otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) ) )? ) )
            // InternalBot.g:773:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'user' ( ( ruleEString ) ) (otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) ) )? )
            {
            // InternalBot.g:773:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'user' ( ( ruleEString ) ) (otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) ) )? )
            // InternalBot.g:774:3: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'user' ( ( ruleEString ) ) (otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) ) )?
            {
            // InternalBot.g:774:3: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=RULE_STRING && LA20_0<=RULE_ID)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalBot.g:775:4: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':'
                    {
                    // InternalBot.g:775:4: ( (lv_name_0_0= ruleEString ) )
                    // InternalBot.g:776:5: (lv_name_0_0= ruleEString )
                    {
                    // InternalBot.g:776:5: (lv_name_0_0= ruleEString )
                    // InternalBot.g:777:6: lv_name_0_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getTransitionAccess().getNameEStringParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTransitionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,13,FOLLOW_25); 

                    				newLeafNode(otherlv_1, grammarAccess.getTransitionAccess().getColonKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getUserKeyword_1());
            		
            // InternalBot.g:803:3: ( ( ruleEString ) )
            // InternalBot.g:804:4: ( ruleEString )
            {
            // InternalBot.g:804:4: ( ruleEString )
            // InternalBot.g:805:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransitionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTransitionAccess().getIntentIntentCrossReference_2_0());
            				
            pushFollow(FOLLOW_26);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:819:3: (otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==28) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalBot.g:820:4: otherlv_4= '=>' ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_27); 

                    				newLeafNode(otherlv_4, grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_3_0());
                    			
                    // InternalBot.g:824:4: ( ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) ) | ( (lv_backTo_6_0= ruleBackToBot ) ) )
                    int alt22=2;
                    switch ( input.LA(1) ) {
                    case RULE_STRING:
                    case RULE_ID:
                        {
                        alt22=1;
                        }
                        break;
                    case 29:
                        {
                        int LA22_2 = input.LA(2);

                        if ( (LA22_2==RULE_STRING) ) {
                            int LA22_4 = input.LA(3);

                            if ( (LA22_4==EOF||LA22_4==14||LA22_4==20||LA22_4==25||LA22_4==28) ) {
                                alt22=1;
                            }
                            else if ( ((LA22_4>=RULE_STRING && LA22_4<=RULE_ID)||LA22_4==30) ) {
                                alt22=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 22, 4, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA22_2==RULE_ID) ) {
                            int LA22_5 = input.LA(3);

                            if ( ((LA22_5>=RULE_STRING && LA22_5<=RULE_ID)||LA22_5==30) ) {
                                alt22=2;
                            }
                            else if ( (LA22_5==EOF||LA22_5==14||LA22_5==20||LA22_5==25||LA22_5==28) ) {
                                alt22=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 22, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 22, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 30:
                        {
                        alt22=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }

                    switch (alt22) {
                        case 1 :
                            // InternalBot.g:825:5: ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) )
                            {
                            // InternalBot.g:825:5: ( ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) ) )
                            // InternalBot.g:826:6: ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) )
                            {
                            // InternalBot.g:826:6: ( (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState ) )
                            // InternalBot.g:827:7: (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState )
                            {
                            // InternalBot.g:827:7: (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState )
                            int alt21=2;
                            alt21 = dfa21.predict(input);
                            switch (alt21) {
                                case 1 :
                                    // InternalBot.g:828:8: lv_target_5_1= ruleState2
                                    {

                                    								newCompositeNode(grammarAccess.getTransitionAccess().getTargetState2ParserRuleCall_3_1_0_0_0());
                                    							
                                    pushFollow(FOLLOW_2);
                                    lv_target_5_1=ruleState2();

                                    state._fsp--;


                                    								if (current==null) {
                                    									current = createModelElementForParent(grammarAccess.getTransitionRule());
                                    								}
                                    								set(
                                    									current,
                                    									"target",
                                    									lv_target_5_1,
                                    									"org.xtext.botGenerator.Bot.State2");
                                    								afterParserOrEnumRuleCall();
                                    							

                                    }
                                    break;
                                case 2 :
                                    // InternalBot.g:844:8: lv_target_5_2= ruleState
                                    {

                                    								newCompositeNode(grammarAccess.getTransitionAccess().getTargetStateParserRuleCall_3_1_0_0_1());
                                    							
                                    pushFollow(FOLLOW_2);
                                    lv_target_5_2=ruleState();

                                    state._fsp--;


                                    								if (current==null) {
                                    									current = createModelElementForParent(grammarAccess.getTransitionRule());
                                    								}
                                    								set(
                                    									current,
                                    									"target",
                                    									lv_target_5_2,
                                    									"org.xtext.botGenerator.Bot.State");
                                    								afterParserOrEnumRuleCall();
                                    							

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalBot.g:863:5: ( (lv_backTo_6_0= ruleBackToBot ) )
                            {
                            // InternalBot.g:863:5: ( (lv_backTo_6_0= ruleBackToBot ) )
                            // InternalBot.g:864:6: (lv_backTo_6_0= ruleBackToBot )
                            {
                            // InternalBot.g:864:6: (lv_backTo_6_0= ruleBackToBot )
                            // InternalBot.g:865:7: lv_backTo_6_0= ruleBackToBot
                            {

                            							newCompositeNode(grammarAccess.getTransitionAccess().getBackToBackToBotParserRuleCall_3_1_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_backTo_6_0=ruleBackToBot();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getTransitionRule());
                            							}
                            							set(
                            								current,
                            								"backTo",
                            								lv_backTo_6_0,
                            								"org.xtext.botGenerator.Bot.BackToBot");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

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


    // $ANTLR start "entryRuleBackToBot"
    // InternalBot.g:888:1: entryRuleBackToBot returns [EObject current=null] : iv_ruleBackToBot= ruleBackToBot EOF ;
    public final EObject entryRuleBackToBot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackToBot = null;


        try {
            // InternalBot.g:888:50: (iv_ruleBackToBot= ruleBackToBot EOF )
            // InternalBot.g:889:2: iv_ruleBackToBot= ruleBackToBot EOF
            {
             newCompositeNode(grammarAccess.getBackToBotRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackToBot=ruleBackToBot();

            state._fsp--;

             current =iv_ruleBackToBot; 
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
    // $ANTLR end "entryRuleBackToBot"


    // $ANTLR start "ruleBackToBot"
    // InternalBot.g:895:1: ruleBackToBot returns [EObject current=null] : ( (otherlv_0= 'chatbot' ( ( ruleEString ) )+ )? otherlv_2= 'back' otherlv_3= 'to' ( ( ruleEString ) ) ) ;
    public final EObject ruleBackToBot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalBot.g:901:2: ( ( (otherlv_0= 'chatbot' ( ( ruleEString ) )+ )? otherlv_2= 'back' otherlv_3= 'to' ( ( ruleEString ) ) ) )
            // InternalBot.g:902:2: ( (otherlv_0= 'chatbot' ( ( ruleEString ) )+ )? otherlv_2= 'back' otherlv_3= 'to' ( ( ruleEString ) ) )
            {
            // InternalBot.g:902:2: ( (otherlv_0= 'chatbot' ( ( ruleEString ) )+ )? otherlv_2= 'back' otherlv_3= 'to' ( ( ruleEString ) ) )
            // InternalBot.g:903:3: (otherlv_0= 'chatbot' ( ( ruleEString ) )+ )? otherlv_2= 'back' otherlv_3= 'to' ( ( ruleEString ) )
            {
            // InternalBot.g:903:3: (otherlv_0= 'chatbot' ( ( ruleEString ) )+ )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==29) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalBot.g:904:4: otherlv_0= 'chatbot' ( ( ruleEString ) )+
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getBackToBotAccess().getChatbotKeyword_0_0());
                    			
                    // InternalBot.g:908:4: ( ( ruleEString ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_ID)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalBot.g:909:5: ( ruleEString )
                    	    {
                    	    // InternalBot.g:909:5: ( ruleEString )
                    	    // InternalBot.g:910:6: ruleEString
                    	    {

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getBackToBotRule());
                    	    						}
                    	    					

                    	    						newCompositeNode(grammarAccess.getBackToBotAccess().getPreviousActionCrossReference_0_1_0());
                    	    					
                    	    pushFollow(FOLLOW_28);
                    	    ruleEString();

                    	    state._fsp--;


                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


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


                    }
                    break;

            }

            otherlv_2=(Token)match(input,30,FOLLOW_29); 

            			newLeafNode(otherlv_2, grammarAccess.getBackToBotAccess().getBackKeyword_1());
            		
            otherlv_3=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getBackToBotAccess().getToKeyword_2());
            		
            // InternalBot.g:933:3: ( ( ruleEString ) )
            // InternalBot.g:934:4: ( ruleEString )
            {
            // InternalBot.g:934:4: ( ruleEString )
            // InternalBot.g:935:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBackToBotRule());
            					}
            				

            					newCompositeNode(grammarAccess.getBackToBotAccess().getBackToBotInteractionCrossReference_3_0());
            				
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
    // $ANTLR end "ruleBackToBot"


    // $ANTLR start "entryRuleState2"
    // InternalBot.g:953:1: entryRuleState2 returns [EObject current=null] : iv_ruleState2= ruleState2 EOF ;
    public final EObject entryRuleState2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState2 = null;


        try {
            // InternalBot.g:953:47: (iv_ruleState2= ruleState2 EOF )
            // InternalBot.g:954:2: iv_ruleState2= ruleState2 EOF
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
    // InternalBot.g:960:1: ruleState2 returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}' )? ) ;
    public final EObject ruleState2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_outcoming_8_0 = null;



        	enterRule();

        try {
            // InternalBot.g:966:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}' )? ) )
            // InternalBot.g:967:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}' )? )
            {
            // InternalBot.g:967:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}' )? )
            // InternalBot.g:968:3: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}' )?
            {
            // InternalBot.g:968:3: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_ID)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalBot.g:969:4: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':'
                    {
                    // InternalBot.g:969:4: ( (lv_name_0_0= ruleEString ) )
                    // InternalBot.g:970:5: (lv_name_0_0= ruleEString )
                    {
                    // InternalBot.g:970:5: (lv_name_0_0= ruleEString )
                    // InternalBot.g:971:6: lv_name_0_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getState2Access().getNameEStringParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getState2Rule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,13,FOLLOW_30); 

                    				newLeafNode(otherlv_1, grammarAccess.getState2Access().getColonKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getState2Access().getChatbotKeyword_1());
            		
            // InternalBot.g:997:3: ( ( ruleEString ) )
            // InternalBot.g:998:4: ( ruleEString )
            {
            // InternalBot.g:998:4: ( ruleEString )
            // InternalBot.g:999:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getState2Rule());
            					}
            				

            					newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1013:3: (otherlv_4= ',' ( ( ruleEString ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==14) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalBot.g:1014:4: otherlv_4= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getState2Access().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:1018:4: ( ( ruleEString ) )
            	    // InternalBot.g:1019:5: ( ruleEString )
            	    {
            	    // InternalBot.g:1019:5: ( ruleEString )
            	    // InternalBot.g:1020:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getState2Rule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getState2Access().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // InternalBot.g:1035:3: (otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==25) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalBot.g:1036:4: otherlv_6= '{' (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+ otherlv_13= '}'
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_32); 

                    				newLeafNode(otherlv_6, grammarAccess.getState2Access().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalBot.g:1040:4: (otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';' )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==28) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalBot.g:1041:5: otherlv_7= '=>' ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) ) otherlv_12= ';'
                    	    {
                    	    otherlv_7=(Token)match(input,28,FOLLOW_33); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getState2Access().getEqualsSignGreaterThanSignKeyword_4_1_0());
                    	    				
                    	    // InternalBot.g:1045:5: ( ( (lv_outcoming_8_0= ruleTransition ) ) | (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) ) )
                    	    int alt28=2;
                    	    int LA28_0 = input.LA(1);

                    	    if ( ((LA28_0>=RULE_STRING && LA28_0<=RULE_ID)||LA28_0==27) ) {
                    	        alt28=1;
                    	    }
                    	    else if ( (LA28_0==30) ) {
                    	        alt28=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 28, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt28) {
                    	        case 1 :
                    	            // InternalBot.g:1046:6: ( (lv_outcoming_8_0= ruleTransition ) )
                    	            {
                    	            // InternalBot.g:1046:6: ( (lv_outcoming_8_0= ruleTransition ) )
                    	            // InternalBot.g:1047:7: (lv_outcoming_8_0= ruleTransition )
                    	            {
                    	            // InternalBot.g:1047:7: (lv_outcoming_8_0= ruleTransition )
                    	            // InternalBot.g:1048:8: lv_outcoming_8_0= ruleTransition
                    	            {

                    	            								newCompositeNode(grammarAccess.getState2Access().getOutcomingTransitionParserRuleCall_4_1_1_0_0());
                    	            							
                    	            pushFollow(FOLLOW_15);
                    	            lv_outcoming_8_0=ruleTransition();

                    	            state._fsp--;


                    	            								if (current==null) {
                    	            									current = createModelElementForParent(grammarAccess.getState2Rule());
                    	            								}
                    	            								add(
                    	            									current,
                    	            									"outcoming",
                    	            									lv_outcoming_8_0,
                    	            									"org.xtext.botGenerator.Bot.Transition");
                    	            								afterParserOrEnumRuleCall();
                    	            							

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalBot.g:1066:6: (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) )
                    	            {
                    	            // InternalBot.g:1066:6: (otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) ) )
                    	            // InternalBot.g:1067:7: otherlv_9= 'back' otherlv_10= 'to' ( ( ruleEString ) )
                    	            {
                    	            otherlv_9=(Token)match(input,30,FOLLOW_29); 

                    	            							newLeafNode(otherlv_9, grammarAccess.getState2Access().getBackKeyword_4_1_1_1_0());
                    	            						
                    	            otherlv_10=(Token)match(input,31,FOLLOW_3); 

                    	            							newLeafNode(otherlv_10, grammarAccess.getState2Access().getToKeyword_4_1_1_1_1());
                    	            						
                    	            // InternalBot.g:1075:7: ( ( ruleEString ) )
                    	            // InternalBot.g:1076:8: ( ruleEString )
                    	            {
                    	            // InternalBot.g:1076:8: ( ruleEString )
                    	            // InternalBot.g:1077:9: ruleEString
                    	            {

                    	            									if (current==null) {
                    	            										current = createModelElement(grammarAccess.getState2Rule());
                    	            									}
                    	            								

                    	            									newCompositeNode(grammarAccess.getState2Access().getBackToUserInteractionCrossReference_4_1_1_1_2_0());
                    	            								
                    	            pushFollow(FOLLOW_15);
                    	            ruleEString();

                    	            state._fsp--;


                    	            									afterParserOrEnumRuleCall();
                    	            								

                    	            }


                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    otherlv_12=(Token)match(input,20,FOLLOW_34); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getState2Access().getSemicolonKeyword_4_1_2());
                    	    				

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);

                    otherlv_13=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_13, grammarAccess.getState2Access().getRightCurlyBracketKeyword_4_2());
                    			

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
    // $ANTLR end "ruleState2"


    // $ANTLR start "entryRuleState"
    // InternalBot.g:1107:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalBot.g:1107:46: (iv_ruleState= ruleState EOF )
            // InternalBot.g:1108:2: iv_ruleState= ruleState EOF
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
    // InternalBot.g:1114:1: ruleState returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) ) ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_outcoming_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1120:2: ( ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) ) ) ) )
            // InternalBot.g:1121:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) ) ) )
            {
            // InternalBot.g:1121:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) ) ) )
            // InternalBot.g:1122:3: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )? otherlv_2= 'chatbot' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* (otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) ) )
            {
            // InternalBot.g:1122:3: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_STRING && LA31_0<=RULE_ID)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalBot.g:1123:4: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':'
                    {
                    // InternalBot.g:1123:4: ( (lv_name_0_0= ruleEString ) )
                    // InternalBot.g:1124:5: (lv_name_0_0= ruleEString )
                    {
                    // InternalBot.g:1124:5: (lv_name_0_0= ruleEString )
                    // InternalBot.g:1125:6: lv_name_0_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getStateAccess().getNameEStringParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_5);
                    lv_name_0_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStateRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,13,FOLLOW_30); 

                    				newLeafNode(otherlv_1, grammarAccess.getStateAccess().getColonKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getChatbotKeyword_1());
            		
            // InternalBot.g:1151:3: ( ( ruleEString ) )
            // InternalBot.g:1152:4: ( ruleEString )
            {
            // InternalBot.g:1152:4: ( ruleEString )
            // InternalBot.g:1153:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStateRule());
            					}
            				

            					newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_2_0());
            				
            pushFollow(FOLLOW_35);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1167:3: (otherlv_4= ',' ( ( ruleEString ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==14) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalBot.g:1168:4: otherlv_4= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getStateAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:1172:4: ( ( ruleEString ) )
            	    // InternalBot.g:1173:5: ( ruleEString )
            	    {
            	    // InternalBot.g:1173:5: ( ruleEString )
            	    // InternalBot.g:1174:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStateRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getStateAccess().getActionsActionCrossReference_3_1_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            // InternalBot.g:1189:3: (otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) ) )
            // InternalBot.g:1190:4: otherlv_6= '=>' ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) )
            {
            otherlv_6=(Token)match(input,28,FOLLOW_33); 

            				newLeafNode(otherlv_6, grammarAccess.getStateAccess().getEqualsSignGreaterThanSignKeyword_4_0());
            			
            // InternalBot.g:1194:4: ( ( (lv_outcoming_7_0= ruleTransition ) ) | (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_STRING && LA33_0<=RULE_ID)||LA33_0==27) ) {
                alt33=1;
            }
            else if ( (LA33_0==30) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalBot.g:1195:5: ( (lv_outcoming_7_0= ruleTransition ) )
                    {
                    // InternalBot.g:1195:5: ( (lv_outcoming_7_0= ruleTransition ) )
                    // InternalBot.g:1196:6: (lv_outcoming_7_0= ruleTransition )
                    {
                    // InternalBot.g:1196:6: (lv_outcoming_7_0= ruleTransition )
                    // InternalBot.g:1197:7: lv_outcoming_7_0= ruleTransition
                    {

                    							newCompositeNode(grammarAccess.getStateAccess().getOutcomingTransitionParserRuleCall_4_1_0_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_outcoming_7_0=ruleTransition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStateRule());
                    							}
                    							add(
                    								current,
                    								"outcoming",
                    								lv_outcoming_7_0,
                    								"org.xtext.botGenerator.Bot.Transition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1215:5: (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) )
                    {
                    // InternalBot.g:1215:5: (otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) ) )
                    // InternalBot.g:1216:6: otherlv_8= 'back' otherlv_9= 'to' ( ( ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_29); 

                    						newLeafNode(otherlv_8, grammarAccess.getStateAccess().getBackKeyword_4_1_1_0());
                    					
                    otherlv_9=(Token)match(input,31,FOLLOW_3); 

                    						newLeafNode(otherlv_9, grammarAccess.getStateAccess().getToKeyword_4_1_1_1());
                    					
                    // InternalBot.g:1224:6: ( ( ruleEString ) )
                    // InternalBot.g:1225:7: ( ruleEString )
                    {
                    // InternalBot.g:1225:7: ( ruleEString )
                    // InternalBot.g:1226:8: ruleEString
                    {

                    								if (current==null) {
                    									current = createModelElement(grammarAccess.getStateRule());
                    								}
                    							

                    								newCompositeNode(grammarAccess.getStateAccess().getBackToUserInteractionCrossReference_4_1_1_2_0());
                    							
                    pushFollow(FOLLOW_2);
                    ruleEString();

                    state._fsp--;


                    								afterParserOrEnumRuleCall();
                    							

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleIntentInput"
    // InternalBot.g:1247:1: entryRuleIntentInput returns [EObject current=null] : iv_ruleIntentInput= ruleIntentInput EOF ;
    public final EObject entryRuleIntentInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentInput = null;


        try {
            // InternalBot.g:1247:52: (iv_ruleIntentInput= ruleIntentInput EOF )
            // InternalBot.g:1248:2: iv_ruleIntentInput= ruleIntentInput EOF
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
    // InternalBot.g:1254:1: ruleIntentInput returns [EObject current=null] : (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput ) ;
    public final EObject ruleIntentInput() throws RecognitionException {
        EObject current = null;

        EObject this_TrainingPhrase_0 = null;

        EObject this_RegexInput_1 = null;



        	enterRule();

        try {
            // InternalBot.g:1260:2: ( (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput ) )
            // InternalBot.g:1261:2: (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput )
            {
            // InternalBot.g:1261:2: (this_TrainingPhrase_0= ruleTrainingPhrase | this_RegexInput_1= ruleRegexInput )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_ID)||LA34_0==39) ) {
                alt34=1;
            }
            else if ( (LA34_0==46) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalBot.g:1262:3: this_TrainingPhrase_0= ruleTrainingPhrase
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
                    // InternalBot.g:1271:3: this_RegexInput_1= ruleRegexInput
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
    // InternalBot.g:1283:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:1283:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:1284:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
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
    // InternalBot.g:1290:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1296:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:1297:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:1297:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:1298:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:1298:3: ()
            // InternalBot.g:1299:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:1305:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)||LA36_0==39) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalBot.g:1306:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:1306:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:1307:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:1307:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_ID)) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==39) ) {
            	        alt35=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // InternalBot.g:1308:6: lv_tokens_1_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensLiteralParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_36);
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
            	            // InternalBot.g:1324:6: lv_tokens_1_2= ruleParameterRefenceToken
            	            {

            	            						newCompositeNode(grammarAccess.getTrainingPhraseAccess().getTokensParameterRefenceTokenParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_36);
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
    // $ANTLR end "ruleTrainingPhrase"


    // $ANTLR start "entryRuleParameter"
    // InternalBot.g:1346:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:1346:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:1347:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalBot.g:1353:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' ) ;
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
            // InternalBot.g:1359:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' ) )
            // InternalBot.g:1360:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' )
            {
            // InternalBot.g:1360:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';' )
            // InternalBot.g:1361:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )? otherlv_11= ';'
            {
            // InternalBot.g:1361:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1362:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1362:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1363:5: lv_name_0_0= ruleEString
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

            otherlv_1=(Token)match(input,13,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,32,FOLLOW_38); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getEntityKeyword_2());
            		
            // InternalBot.g:1388:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_STRING && LA37_0<=RULE_ID)) ) {
                alt37=1;
            }
            else if ( (LA37_0==50||(LA37_0>=68 && LA37_0<=71)) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:1389:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:1389:4: ( ( ruleEString ) )
                    // InternalBot.g:1390:5: ( ruleEString )
                    {
                    // InternalBot.g:1390:5: ( ruleEString )
                    // InternalBot.g:1391:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getParameterRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getParameterAccess().getEntityEntityCrossReference_3_0_0());
                    					
                    pushFollow(FOLLOW_39);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:1406:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:1406:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:1407:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:1407:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:1408:6: lv_defaultEntity_4_0= ruleDefaultEntity
                    {

                    						newCompositeNode(grammarAccess.getParameterAccess().getDefaultEntityDefaultEntityEnumRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_39);
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

            // InternalBot.g:1426:3: (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==14) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==33) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:1427:4: otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_40); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1431:4: ( (lv_isList_6_0= 'isList' ) )
                    // InternalBot.g:1432:5: (lv_isList_6_0= 'isList' )
                    {
                    // InternalBot.g:1432:5: (lv_isList_6_0= 'isList' )
                    // InternalBot.g:1433:6: lv_isList_6_0= 'isList'
                    {
                    lv_isList_6_0=(Token)match(input,33,FOLLOW_39); 

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

            // InternalBot.g:1446:3: (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==14) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==34) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalBot.g:1447:4: otherlv_7= ',' ( (lv_required_8_0= 'required' ) )
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_41); 

                    				newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1451:4: ( (lv_required_8_0= 'required' ) )
                    // InternalBot.g:1452:5: (lv_required_8_0= 'required' )
                    {
                    // InternalBot.g:1452:5: (lv_required_8_0= 'required' )
                    // InternalBot.g:1453:6: lv_required_8_0= 'required'
                    {
                    lv_required_8_0=(Token)match(input,34,FOLLOW_39); 

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

            // InternalBot.g:1466:3: (otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+ )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==14) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:1467:4: otherlv_9= ',' ( (lv_prompts_10_0= rulePromptLanguage ) )+
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_42); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getCommaKeyword_6_0());
                    			
                    // InternalBot.g:1471:4: ( (lv_prompts_10_0= rulePromptLanguage ) )+
                    int cnt40=0;
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==35) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // InternalBot.g:1472:5: (lv_prompts_10_0= rulePromptLanguage )
                    	    {
                    	    // InternalBot.g:1472:5: (lv_prompts_10_0= rulePromptLanguage )
                    	    // InternalBot.g:1473:6: lv_prompts_10_0= rulePromptLanguage
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterAccess().getPromptsPromptLanguageParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_43);
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
                    	    if ( cnt40 >= 1 ) break loop40;
                                EarlyExitException eee =
                                    new EarlyExitException(40, input);
                                throw eee;
                        }
                        cnt40++;
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
    // InternalBot.g:1499:1: entryRuleParameter2 returns [EObject current=null] : iv_ruleParameter2= ruleParameter2 EOF ;
    public final EObject entryRuleParameter2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter2 = null;


        try {
            // InternalBot.g:1499:51: (iv_ruleParameter2= ruleParameter2 EOF )
            // InternalBot.g:1500:2: iv_ruleParameter2= ruleParameter2 EOF
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
    // InternalBot.g:1506:1: ruleParameter2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) ;
    public final EObject ruleParameter2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1512:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) )
            // InternalBot.g:1513:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            {
            // InternalBot.g:1513:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            // InternalBot.g:1514:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ','
            {
            // InternalBot.g:1514:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1515:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1515:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1516:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameter2Access().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_44);
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
    // InternalBot.g:1541:1: entryRulePromptLanguage returns [EObject current=null] : iv_rulePromptLanguage= rulePromptLanguage EOF ;
    public final EObject entryRulePromptLanguage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePromptLanguage = null;


        try {
            // InternalBot.g:1541:55: (iv_rulePromptLanguage= rulePromptLanguage EOF )
            // InternalBot.g:1542:2: iv_rulePromptLanguage= rulePromptLanguage EOF
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
    // InternalBot.g:1548:1: rulePromptLanguage returns [EObject current=null] : (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) ;
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
            // InternalBot.g:1554:2: ( (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) )
            // InternalBot.g:1555:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            {
            // InternalBot.g:1555:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            // InternalBot.g:1556:3: otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getPromptLanguageAccess().getPromptsKeyword_0());
            		
            // InternalBot.g:1560:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==24) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalBot.g:1561:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getPromptLanguageAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:1565:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1566:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1566:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1567:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_46);
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

            otherlv_3=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getPromptLanguageAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalBot.g:1589:3: ( (lv_prompts_4_0= ruleEString ) )
            // InternalBot.g:1590:4: (lv_prompts_4_0= ruleEString )
            {
            // InternalBot.g:1590:4: (lv_prompts_4_0= ruleEString )
            // InternalBot.g:1591:5: lv_prompts_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_47);
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

            // InternalBot.g:1608:3: (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==14) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalBot.g:1609:4: otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getPromptLanguageAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:1613:4: ( (lv_prompts_6_0= ruleEString ) )
            	    // InternalBot.g:1614:5: (lv_prompts_6_0= ruleEString )
            	    {
            	    // InternalBot.g:1614:5: (lv_prompts_6_0= ruleEString )
            	    // InternalBot.g:1615:6: lv_prompts_6_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getPromptLanguageAccess().getPromptsEStringParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
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
            	    break loop43;
                }
            } while (true);

            otherlv_7=(Token)match(input,37,FOLLOW_2); 

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
    // InternalBot.g:1641:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1641:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1642:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalBot.g:1648:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1654:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1655:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1655:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1656:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1656:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1657:4: lv_text_0_0= ruleEString
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
    // InternalBot.g:1677:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1677:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1678:2: iv_ruleEntityToken= ruleEntityToken EOF
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
    // InternalBot.g:1684:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBot.g:1690:2: ( (otherlv_0= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1691:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1691:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1692:3: otherlv_0= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0());
            		
            // InternalBot.g:1696:3: ( ( ruleEString ) )
            // InternalBot.g:1697:4: ( ruleEString )
            {
            // InternalBot.g:1697:4: ( ruleEString )
            // InternalBot.g:1698:5: ruleEString
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
    // InternalBot.g:1716:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1716:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1717:2: iv_ruleParameterToken= ruleParameterToken EOF
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
    // InternalBot.g:1723:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalBot.g:1729:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' ) )
            // InternalBot.g:1730:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            {
            // InternalBot.g:1730:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' )
            // InternalBot.g:1731:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1735:3: ( ( ruleEString ) )
            // InternalBot.g:1736:4: ( ruleEString )
            {
            // InternalBot.g:1736:4: ( ruleEString )
            // InternalBot.g:1737:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterTokenAccess().getParameterParameterCrossReference_1_0());
            				
            pushFollow(FOLLOW_48);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_2); 

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
    // InternalBot.g:1759:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1759:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1760:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
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
    // InternalBot.g:1766:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1772:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1773:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1773:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1774:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1778:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1779:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1779:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1780:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_49);
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

            otherlv_2=(Token)match(input,40,FOLLOW_46); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterRefenceTokenAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getParameterRefenceTokenAccess().getLeftSquareBracketKeyword_3());
            		
            // InternalBot.g:1805:3: ( ( ruleEString ) )
            // InternalBot.g:1806:4: ( ruleEString )
            {
            // InternalBot.g:1806:4: ( ruleEString )
            // InternalBot.g:1807:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRefenceTokenRule());
            					}
            				

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getParameterParameterCrossReference_4_0());
            				
            pushFollow(FOLLOW_48);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

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
    // InternalBot.g:1829:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1829:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1830:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
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
    // InternalBot.g:1836:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1842:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1843:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1843:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1844:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_50); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1848:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1849:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1849:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1850:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_51);
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

            // InternalBot.g:1867:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBot.g:1868:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1872:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1873:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1873:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1874:6: lv_dataKey_3_0= ruleEString
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
    // InternalBot.g:1896:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:1896:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:1897:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalBot.g:1903:1: ruleEntity returns [EObject current=null] : (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleEntity_0 = null;

        EObject this_ComplexEntity_1 = null;

        EObject this_RegexEntity_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1909:2: ( (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) )
            // InternalBot.g:1910:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            {
            // InternalBot.g:1910:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt45=1;
                }
                break;
            case 44:
                {
                alt45=2;
                }
                break;
            case 45:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalBot.g:1911:3: this_SimpleEntity_0= ruleSimpleEntity
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
                    // InternalBot.g:1920:3: this_ComplexEntity_1= ruleComplexEntity
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
                    // InternalBot.g:1929:3: this_RegexEntity_2= ruleRegexEntity
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
    // InternalBot.g:1941:1: entryRuleSimpleEntity returns [EObject current=null] : iv_ruleSimpleEntity= ruleSimpleEntity EOF ;
    public final EObject entryRuleSimpleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEntity = null;


        try {
            // InternalBot.g:1941:53: (iv_ruleSimpleEntity= ruleSimpleEntity EOF )
            // InternalBot.g:1942:2: iv_ruleSimpleEntity= ruleSimpleEntity EOF
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
    // InternalBot.g:1948:1: ruleSimpleEntity returns [EObject current=null] : (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ ) ;
    public final EObject ruleSimpleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1954:2: ( (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ ) )
            // InternalBot.g:1955:2: (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ )
            {
            // InternalBot.g:1955:2: (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+ )
            // InternalBot.g:1956:3: otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,43,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleEntityAccess().getSimpleKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:1964:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1965:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1965:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1966:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getSimpleEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1987:3: ( (lv_inputs_4_0= ruleSLanguageInput ) )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==23||LA46_0==25) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalBot.g:1988:4: (lv_inputs_4_0= ruleSLanguageInput )
            	    {
            	    // InternalBot.g:1988:4: (lv_inputs_4_0= ruleSLanguageInput )
            	    // InternalBot.g:1989:5: lv_inputs_4_0= ruleSLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleEntityAccess().getInputsSLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
    // $ANTLR end "ruleSimpleEntity"


    // $ANTLR start "entryRuleComplexEntity"
    // InternalBot.g:2010:1: entryRuleComplexEntity returns [EObject current=null] : iv_ruleComplexEntity= ruleComplexEntity EOF ;
    public final EObject entryRuleComplexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexEntity = null;


        try {
            // InternalBot.g:2010:54: (iv_ruleComplexEntity= ruleComplexEntity EOF )
            // InternalBot.g:2011:2: iv_ruleComplexEntity= ruleComplexEntity EOF
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
    // InternalBot.g:2017:1: ruleComplexEntity returns [EObject current=null] : (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ ) ;
    public final EObject ruleComplexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2023:2: ( (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ ) )
            // InternalBot.g:2024:2: (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ )
            {
            // InternalBot.g:2024:2: (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+ )
            // InternalBot.g:2025:3: otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,44,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexEntityAccess().getCompositeKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:2033:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2034:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2034:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2035:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getComplexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:2056:3: ( (lv_inputs_4_0= ruleCLanguageInput ) )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==23||LA47_0==25) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalBot.g:2057:4: (lv_inputs_4_0= ruleCLanguageInput )
            	    {
            	    // InternalBot.g:2057:4: (lv_inputs_4_0= ruleCLanguageInput )
            	    // InternalBot.g:2058:5: lv_inputs_4_0= ruleCLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getComplexEntityAccess().getInputsCLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
    // $ANTLR end "ruleComplexEntity"


    // $ANTLR start "entryRuleRegexEntity"
    // InternalBot.g:2079:1: entryRuleRegexEntity returns [EObject current=null] : iv_ruleRegexEntity= ruleRegexEntity EOF ;
    public final EObject entryRuleRegexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexEntity = null;


        try {
            // InternalBot.g:2079:52: (iv_ruleRegexEntity= ruleRegexEntity EOF )
            // InternalBot.g:2080:2: iv_ruleRegexEntity= ruleRegexEntity EOF
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
    // InternalBot.g:2086:1: ruleRegexEntity returns [EObject current=null] : (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ ) ;
    public final EObject ruleRegexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2092:2: ( (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ ) )
            // InternalBot.g:2093:2: (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ )
            {
            // InternalBot.g:2093:2: (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+ )
            // InternalBot.g:2094:3: otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageInput ) )+
            {
            otherlv_0=(Token)match(input,45,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getRegexEntityAccess().getRegexKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:2102:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2103:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2103:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2104:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getRegexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:2125:3: ( (lv_inputs_4_0= ruleRLanguageInput ) )+
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
            	    // InternalBot.g:2126:4: (lv_inputs_4_0= ruleRLanguageInput )
            	    {
            	    // InternalBot.g:2126:4: (lv_inputs_4_0= ruleRLanguageInput )
            	    // InternalBot.g:2127:5: lv_inputs_4_0= ruleRLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getRegexEntityAccess().getInputsRLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_53);
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
    // $ANTLR end "ruleRegexEntity"


    // $ANTLR start "entryRuleSLanguageInput"
    // InternalBot.g:2148:1: entryRuleSLanguageInput returns [EObject current=null] : iv_ruleSLanguageInput= ruleSLanguageInput EOF ;
    public final EObject entryRuleSLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSLanguageInput = null;


        try {
            // InternalBot.g:2148:55: (iv_ruleSLanguageInput= ruleSLanguageInput EOF )
            // InternalBot.g:2149:2: iv_ruleSLanguageInput= ruleSLanguageInput EOF
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
    // InternalBot.g:2155:1: ruleSLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) ;
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
            // InternalBot.g:2161:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2162:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2162:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2163:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2163:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==23) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:2164:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_54); 

                    				newLeafNode(otherlv_0, grammarAccess.getSLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getSLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2172:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2173:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2173:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2174:6: lv_language_2_0= ruleLanguage
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
            		
            // InternalBot.g:2196:3: ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* )
            // InternalBot.g:2197:4: ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )*
            {
            // InternalBot.g:2197:4: ( (lv_inputs_4_0= ruleSimpleInput ) )
            // InternalBot.g:2198:5: (lv_inputs_4_0= ruleSimpleInput )
            {
            // InternalBot.g:2198:5: (lv_inputs_4_0= ruleSimpleInput )
            // InternalBot.g:2199:6: lv_inputs_4_0= ruleSimpleInput
            {

            						newCompositeNode(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_55);
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

            // InternalBot.g:2216:4: ( (lv_inputs_5_0= ruleSimpleInput ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:2217:5: (lv_inputs_5_0= ruleSimpleInput )
            	    {
            	    // InternalBot.g:2217:5: (lv_inputs_5_0= ruleSimpleInput )
            	    // InternalBot.g:2218:6: lv_inputs_5_0= ruleSimpleInput
            	    {

            	    						newCompositeNode(grammarAccess.getSLanguageInputAccess().getInputsSimpleInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_55);
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
            	    break loop50;
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
    // InternalBot.g:2244:1: entryRuleCLanguageInput returns [EObject current=null] : iv_ruleCLanguageInput= ruleCLanguageInput EOF ;
    public final EObject entryRuleCLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCLanguageInput = null;


        try {
            // InternalBot.g:2244:55: (iv_ruleCLanguageInput= ruleCLanguageInput EOF )
            // InternalBot.g:2245:2: iv_ruleCLanguageInput= ruleCLanguageInput EOF
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
    // InternalBot.g:2251:1: ruleCLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) ;
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
            // InternalBot.g:2257:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2258:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2258:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2259:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2259:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==23) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:2260:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_54); 

                    				newLeafNode(otherlv_0, grammarAccess.getCLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getCLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2268:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2269:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2269:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2270:6: lv_language_2_0= ruleLanguage
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

            otherlv_3=(Token)match(input,25,FOLLOW_56); 

            			newLeafNode(otherlv_3, grammarAccess.getCLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2292:3: ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* )
            // InternalBot.g:2293:4: ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )*
            {
            // InternalBot.g:2293:4: ( (lv_inputs_4_0= ruleCompositeInput ) )
            // InternalBot.g:2294:5: (lv_inputs_4_0= ruleCompositeInput )
            {
            // InternalBot.g:2294:5: (lv_inputs_4_0= ruleCompositeInput )
            // InternalBot.g:2295:6: lv_inputs_4_0= ruleCompositeInput
            {

            						newCompositeNode(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_57);
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

            // InternalBot.g:2312:4: ( (lv_inputs_5_0= ruleCompositeInput ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==47) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:2313:5: (lv_inputs_5_0= ruleCompositeInput )
            	    {
            	    // InternalBot.g:2313:5: (lv_inputs_5_0= ruleCompositeInput )
            	    // InternalBot.g:2314:6: lv_inputs_5_0= ruleCompositeInput
            	    {

            	    						newCompositeNode(grammarAccess.getCLanguageInputAccess().getInputsCompositeInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_57);
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
            	    break loop52;
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
    // InternalBot.g:2340:1: entryRuleRLanguageInput returns [EObject current=null] : iv_ruleRLanguageInput= ruleRLanguageInput EOF ;
    public final EObject entryRuleRLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRLanguageInput = null;


        try {
            // InternalBot.g:2340:55: (iv_ruleRLanguageInput= ruleRLanguageInput EOF )
            // InternalBot.g:2341:2: iv_ruleRLanguageInput= ruleRLanguageInput EOF
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
    // InternalBot.g:2347:1: ruleRLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) ;
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
            // InternalBot.g:2353:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2354:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2354:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2355:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2355:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==23) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:2356:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_54); 

                    				newLeafNode(otherlv_0, grammarAccess.getRLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getRLanguageInputAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2364:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2365:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2365:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2366:6: lv_language_2_0= ruleLanguage
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
            		
            // InternalBot.g:2388:3: ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* )
            // InternalBot.g:2389:4: ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )*
            {
            // InternalBot.g:2389:4: ( (lv_inputs_4_0= ruleRegexInput ) )
            // InternalBot.g:2390:5: (lv_inputs_4_0= ruleRegexInput )
            {
            // InternalBot.g:2390:5: (lv_inputs_4_0= ruleRegexInput )
            // InternalBot.g:2391:6: lv_inputs_4_0= ruleRegexInput
            {

            						newCompositeNode(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_58);
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

            // InternalBot.g:2408:4: ( (lv_inputs_5_0= ruleRegexInput ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==46) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:2409:5: (lv_inputs_5_0= ruleRegexInput )
            	    {
            	    // InternalBot.g:2409:5: (lv_inputs_5_0= ruleRegexInput )
            	    // InternalBot.g:2410:6: lv_inputs_5_0= ruleRegexInput
            	    {

            	    						newCompositeNode(grammarAccess.getRLanguageInputAccess().getInputsRegexInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_58);
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
            	    break loop54;
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
    // InternalBot.g:2436:1: entryRuleRegexInput returns [EObject current=null] : iv_ruleRegexInput= ruleRegexInput EOF ;
    public final EObject entryRuleRegexInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexInput = null;


        try {
            // InternalBot.g:2436:51: (iv_ruleRegexInput= ruleRegexInput EOF )
            // InternalBot.g:2437:2: iv_ruleRegexInput= ruleRegexInput EOF
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
    // InternalBot.g:2443:1: ruleRegexInput returns [EObject current=null] : ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) ;
    public final EObject ruleRegexInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2449:2: ( ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) )
            // InternalBot.g:2450:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            {
            // InternalBot.g:2450:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            // InternalBot.g:2451:3: () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) )
            {
            // InternalBot.g:2451:3: ()
            // InternalBot.g:2452:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRegexInputAccess().getRegexInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,46,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexInputAccess().getPatternKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2466:3: ( (lv_expresion_3_0= ruleEString ) )
            // InternalBot.g:2467:4: (lv_expresion_3_0= ruleEString )
            {
            // InternalBot.g:2467:4: (lv_expresion_3_0= ruleEString )
            // InternalBot.g:2468:5: lv_expresion_3_0= ruleEString
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
    // InternalBot.g:2489:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:2489:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:2490:2: iv_ruleCompositeInput= ruleCompositeInput EOF
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
    // InternalBot.g:2496:1: ruleCompositeInput returns [EObject current=null] : ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expresion_3_1 = null;

        EObject lv_expresion_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2502:2: ( ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) )
            // InternalBot.g:2503:2: ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            {
            // InternalBot.g:2503:2: ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            // InternalBot.g:2504:3: () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            {
            // InternalBot.g:2504:3: ()
            // InternalBot.g:2505:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeInputAccess().getCompositeInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,47,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeInputAccess().getCompositeKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2519:3: ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=RULE_STRING && LA56_0<=RULE_ID)||LA56_0==38) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalBot.g:2520:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:2520:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    // InternalBot.g:2521:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:2521:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( ((LA55_0>=RULE_STRING && LA55_0<=RULE_ID)) ) {
            	        alt55=1;
            	    }
            	    else if ( (LA55_0==38) ) {
            	        alt55=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 55, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // InternalBot.g:2522:6: lv_expresion_3_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_3_0_0());
            	            					
            	            pushFollow(FOLLOW_60);
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
            	            // InternalBot.g:2538:6: lv_expresion_3_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_3_0_1());
            	            					
            	            pushFollow(FOLLOW_60);
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
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
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
    // InternalBot.g:2560:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:2560:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:2561:2: iv_ruleSimpleInput= ruleSimpleInput EOF
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
    // InternalBot.g:2567:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) ;
    public final EObject ruleSimpleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2573:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) )
            // InternalBot.g:2574:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            {
            // InternalBot.g:2574:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            // InternalBot.g:2575:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            {
            // InternalBot.g:2575:3: ()
            // InternalBot.g:2576:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:2582:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2583:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2583:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2584:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_61);
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

            // InternalBot.g:2601:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==48) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:2602:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:2606:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:2607:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:2607:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:2608:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_62);
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

                    // InternalBot.g:2625:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==14) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalBot.g:2626:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:2630:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:2631:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:2631:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:2632:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_62);
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
                    	    break loop57;
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
    // InternalBot.g:2655:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:2655:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:2656:2: iv_ruleText= ruleText EOF
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
    // InternalBot.g:2662:1: ruleText returns [EObject current=null] : ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleTextLanguageInput ) )+ ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_inputs_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2668:2: ( ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleTextLanguageInput ) )+ ) )
            // InternalBot.g:2669:2: ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleTextLanguageInput ) )+ )
            {
            // InternalBot.g:2669:2: ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleTextLanguageInput ) )+ )
            // InternalBot.g:2670:3: (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleTextLanguageInput ) )+
            {
            // InternalBot.g:2670:3: (otherlv_0= 'Text' | otherlv_1= 'text' )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==49) ) {
                alt59=1;
            }
            else if ( (LA59_0==50) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalBot.g:2671:4: otherlv_0= 'Text'
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_63); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalBot.g:2676:4: otherlv_1= 'text'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextAccess().getTextKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2685:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:2686:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:2686:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:2687:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTextAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTextRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_4, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:2708:3: ( (lv_inputs_5_0= ruleTextLanguageInput ) )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==23||LA60_0==25) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // InternalBot.g:2709:4: (lv_inputs_5_0= ruleTextLanguageInput )
            	    {
            	    // InternalBot.g:2709:4: (lv_inputs_5_0= ruleTextLanguageInput )
            	    // InternalBot.g:2710:5: lv_inputs_5_0= ruleTextLanguageInput
            	    {

            	    					newCompositeNode(grammarAccess.getTextAccess().getInputsTextLanguageInputParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_53);
            	    lv_inputs_5_0=ruleTextLanguageInput();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_5_0,
            	    						"org.xtext.botGenerator.Bot.TextLanguageInput");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // InternalBot.g:2731:1: entryRuleTextLanguageInput returns [EObject current=null] : iv_ruleTextLanguageInput= ruleTextLanguageInput EOF ;
    public final EObject entryRuleTextLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInput = null;


        try {
            // InternalBot.g:2731:58: (iv_ruleTextLanguageInput= ruleTextLanguageInput EOF )
            // InternalBot.g:2732:2: iv_ruleTextLanguageInput= ruleTextLanguageInput EOF
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
    // InternalBot.g:2738:1: ruleTextLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:2744:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2745:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2745:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            // InternalBot.g:2746:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:2746:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==23) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalBot.g:2747:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:2751:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==24) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalBot.g:2752:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_6); 

                            					newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:2756:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:2757:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:2757:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:2758:7: lv_language_2_0= ruleLanguage
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

            otherlv_3=(Token)match(input,25,FOLLOW_64); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2781:3: ( (lv_inputs_4_0= ruleTextInputText ) )
            // InternalBot.g:2782:4: (lv_inputs_4_0= ruleTextInputText )
            {
            // InternalBot.g:2782:4: (lv_inputs_4_0= ruleTextInputText )
            // InternalBot.g:2783:5: lv_inputs_4_0= ruleTextInputText
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

            // InternalBot.g:2800:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==14) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBot.g:2801:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_64); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:2805:4: ( (lv_inputs_6_0= ruleTextInputText ) )
            	    // InternalBot.g:2806:5: (lv_inputs_6_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:2806:5: (lv_inputs_6_0= ruleTextInputText )
            	    // InternalBot.g:2807:6: lv_inputs_6_0= ruleTextInputText
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
            	    break loop63;
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
    // InternalBot.g:2833:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:2833:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:2834:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
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
    // InternalBot.g:2840:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ ) ;
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
            // InternalBot.g:2846:2: ( (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ ) )
            // InternalBot.g:2847:2: (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ )
            {
            // InternalBot.g:2847:2: (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+ )
            // InternalBot.g:2848:3: otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getResponseKeyword_0());
            		
            // InternalBot.g:2852:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2853:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2853:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2854:5: lv_name_1_0= ruleEString
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

            otherlv_2=(Token)match(input,13,FOLLOW_65); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,53,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getRequestKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPResponseAccess().getColonKeyword_4());
            		
            // InternalBot.g:2883:3: ( ( ruleEString ) )
            // InternalBot.g:2884:4: ( ruleEString )
            {
            // InternalBot.g:2884:4: ( ruleEString )
            // InternalBot.g:2885:5: ruleEString
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

            otherlv_6=(Token)match(input,20,FOLLOW_66); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_6());
            		
            // InternalBot.g:2903:3: ( (lv_inputs_7_0= ruleTextLanguageInputHttpResponse ) )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==23) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // InternalBot.g:2904:4: (lv_inputs_7_0= ruleTextLanguageInputHttpResponse )
            	    {
            	    // InternalBot.g:2904:4: (lv_inputs_7_0= ruleTextLanguageInputHttpResponse )
            	    // InternalBot.g:2905:5: lv_inputs_7_0= ruleTextLanguageInputHttpResponse
            	    {

            	    					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsTextLanguageInputHttpResponseParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_67);
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
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
    // InternalBot.g:2926:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2926:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2927:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
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
    // InternalBot.g:2933:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? ) ;
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
            // InternalBot.g:2939:2: ( (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? ) )
            // InternalBot.g:2940:2: (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? )
            {
            // InternalBot.g:2940:2: (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? )
            // InternalBot.g:2941:3: otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_68); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getRequestKeyword_0());
            		
            // InternalBot.g:2945:3: ( (lv_method_1_0= ruleMethod ) )
            // InternalBot.g:2946:4: (lv_method_1_0= ruleMethod )
            {
            // InternalBot.g:2946:4: (lv_method_1_0= ruleMethod )
            // InternalBot.g:2947:5: lv_method_1_0= ruleMethod
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

            // InternalBot.g:2964:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2965:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2965:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2966:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_69); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPRequestAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,54,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getColonKeyword_5());
            		
            // InternalBot.g:2995:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2996:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2996:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2997:5: lv_URL_6_0= ruleEString
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

            otherlv_7=(Token)match(input,20,FOLLOW_70); 

            			newLeafNode(otherlv_7, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_7());
            		
            // InternalBot.g:3018:3: (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==55) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBot.g:3019:4: otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';'
                    {
                    otherlv_8=(Token)match(input,55,FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_8_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getColonKeyword_8_1());
                    			
                    // InternalBot.g:3027:4: ( (lv_basicAuth_10_0= ruleKeyValue ) )
                    // InternalBot.g:3028:5: (lv_basicAuth_10_0= ruleKeyValue )
                    {
                    // InternalBot.g:3028:5: (lv_basicAuth_10_0= ruleKeyValue )
                    // InternalBot.g:3029:6: lv_basicAuth_10_0= ruleKeyValue
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

                    otherlv_11=(Token)match(input,20,FOLLOW_71); 

                    				newLeafNode(otherlv_11, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:3051:3: (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==56) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalBot.g:3052:4: otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,56,FOLLOW_5); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_9_0());
                    			
                    otherlv_13=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:3060:4: ( (lv_headers_14_0= ruleKeyValue ) )
                    // InternalBot.g:3061:5: (lv_headers_14_0= ruleKeyValue )
                    {
                    // InternalBot.g:3061:5: (lv_headers_14_0= ruleKeyValue )
                    // InternalBot.g:3062:6: lv_headers_14_0= ruleKeyValue
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_2_0());
                    					
                    pushFollow(FOLLOW_39);
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

                    // InternalBot.g:3079:4: (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==14) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalBot.g:3080:5: otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getHTTPRequestAccess().getCommaKeyword_9_3_0());
                    	    				
                    	    // InternalBot.g:3084:5: ( (lv_headers_16_0= ruleKeyValue ) )
                    	    // InternalBot.g:3085:6: (lv_headers_16_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:3085:6: (lv_headers_16_0= ruleKeyValue )
                    	    // InternalBot.g:3086:7: lv_headers_16_0= ruleKeyValue
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getHeadersKeyValueParserRuleCall_9_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_39);
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
                    	    break loop66;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,20,FOLLOW_72); 

                    				newLeafNode(otherlv_17, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:3109:3: (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==57) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalBot.g:3110:4: otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';'
                    {
                    otherlv_18=(Token)match(input,57,FOLLOW_5); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getDataKeyword_10_0());
                    			
                    otherlv_19=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:3118:4: ( (lv_data_20_0= ruleData ) )
                    // InternalBot.g:3119:5: (lv_data_20_0= ruleData )
                    {
                    // InternalBot.g:3119:5: (lv_data_20_0= ruleData )
                    // InternalBot.g:3120:6: lv_data_20_0= ruleData
                    {

                    						newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_39);
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

                    // InternalBot.g:3137:4: (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==14) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalBot.g:3138:5: otherlv_21= ',' ( (lv_data_22_0= ruleData ) )
                    	    {
                    	    otherlv_21=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_21, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:3142:5: ( (lv_data_22_0= ruleData ) )
                    	    // InternalBot.g:3143:6: (lv_data_22_0= ruleData )
                    	    {
                    	    // InternalBot.g:3143:6: (lv_data_22_0= ruleData )
                    	    // InternalBot.g:3144:7: lv_data_22_0= ruleData
                    	    {

                    	    							newCompositeNode(grammarAccess.getHTTPRequestAccess().getDataDataParserRuleCall_10_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_39);
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
                    	    break loop68;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,20,FOLLOW_73); 

                    				newLeafNode(otherlv_23, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			
                    otherlv_24=(Token)match(input,58,FOLLOW_5); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_10_5());
                    			
                    otherlv_25=(Token)match(input,13,FOLLOW_74); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_6());
                    			
                    // InternalBot.g:3174:4: ( (lv_dataType_26_0= ruleDataType ) )
                    // InternalBot.g:3175:5: (lv_dataType_26_0= ruleDataType )
                    {
                    // InternalBot.g:3175:5: (lv_dataType_26_0= ruleDataType )
                    // InternalBot.g:3176:6: lv_dataType_26_0= ruleDataType
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
    // InternalBot.g:3202:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:3202:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:3203:2: iv_ruleImage= ruleImage EOF
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
    // InternalBot.g:3209:1: ruleImage returns [EObject current=null] : ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? ) ;
    public final EObject ruleImage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_URL_7_0 = null;

        AntlrDatatypeRuleToken lv_caption_10_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3215:2: ( ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? ) )
            // InternalBot.g:3216:2: ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? )
            {
            // InternalBot.g:3216:2: ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? )
            // InternalBot.g:3217:3: (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )?
            {
            // InternalBot.g:3217:3: (otherlv_0= 'Image' | otherlv_1= 'mage' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==59) ) {
                alt70=1;
            }
            else if ( (LA70_0==60) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalBot.g:3218:4: otherlv_0= 'Image'
                    {
                    otherlv_0=(Token)match(input,59,FOLLOW_63); 

                    				newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalBot.g:3223:4: otherlv_1= 'mage'
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_63); 

                    				newLeafNode(otherlv_1, grammarAccess.getImageAccess().getMageKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:3232:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:3233:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:3233:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:3234:5: lv_name_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImageRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_69); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_5=(Token)match(input,54,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_6=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:3263:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:3264:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:3264:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:3265:5: lv_URL_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_75);
            lv_URL_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImageRule());
            					}
            					set(
            						current,
            						"URL",
            						lv_URL_7_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:3282:3: (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==61) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalBot.g:3283:4: otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,61,FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getImageAccess().getCaptionKeyword_7_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getImageAccess().getColonKeyword_7_1());
                    			
                    // InternalBot.g:3291:4: ( (lv_caption_10_0= ruleEString ) )
                    // InternalBot.g:3292:5: (lv_caption_10_0= ruleEString )
                    {
                    // InternalBot.g:3292:5: (lv_caption_10_0= ruleEString )
                    // InternalBot.g:3293:6: lv_caption_10_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getImageAccess().getCaptionEStringParserRuleCall_7_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_caption_10_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImageRule());
                    						}
                    						set(
                    							current,
                    							"caption",
                    							lv_caption_10_0,
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


    // $ANTLR start "entryRuleEmpty"
    // InternalBot.g:3315:1: entryRuleEmpty returns [EObject current=null] : iv_ruleEmpty= ruleEmpty EOF ;
    public final EObject entryRuleEmpty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmpty = null;


        try {
            // InternalBot.g:3315:46: (iv_ruleEmpty= ruleEmpty EOF )
            // InternalBot.g:3316:2: iv_ruleEmpty= ruleEmpty EOF
            {
             newCompositeNode(grammarAccess.getEmptyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEmpty=ruleEmpty();

            state._fsp--;

             current =iv_ruleEmpty; 
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
    // $ANTLR end "entryRuleEmpty"


    // $ANTLR start "ruleEmpty"
    // InternalBot.g:3322:1: ruleEmpty returns [EObject current=null] : (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleEmpty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3328:2: ( (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) ) )
            // InternalBot.g:3329:2: (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) )
            {
            // InternalBot.g:3329:2: (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) )
            // InternalBot.g:3330:3: otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,62,FOLLOW_63); 

            			newLeafNode(otherlv_0, grammarAccess.getEmptyAccess().getEmptyKeyword_0());
            		
            otherlv_1=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getEmptyAccess().getResponseKeyword_1());
            		
            // InternalBot.g:3338:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:3339:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:3339:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:3340:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getEmptyAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEmptyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
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
    // $ANTLR end "ruleEmpty"


    // $ANTLR start "entryRuleButtonAction"
    // InternalBot.g:3361:1: entryRuleButtonAction returns [EObject current=null] : iv_ruleButtonAction= ruleButtonAction EOF ;
    public final EObject entryRuleButtonAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleButtonAction = null;


        try {
            // InternalBot.g:3361:53: (iv_ruleButtonAction= ruleButtonAction EOF )
            // InternalBot.g:3362:2: iv_ruleButtonAction= ruleButtonAction EOF
            {
             newCompositeNode(grammarAccess.getButtonActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleButtonAction=ruleButtonAction();

            state._fsp--;

             current =iv_ruleButtonAction; 
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
    // $ANTLR end "entryRuleButtonAction"


    // $ANTLR start "ruleButtonAction"
    // InternalBot.g:3368:1: ruleButtonAction returns [EObject current=null] : (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleButtonLanguageInput ) ) ) ;
    public final EObject ruleButtonAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3374:2: ( (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleButtonLanguageInput ) ) ) )
            // InternalBot.g:3375:2: (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleButtonLanguageInput ) ) )
            {
            // InternalBot.g:3375:2: (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleButtonLanguageInput ) ) )
            // InternalBot.g:3376:3: otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleButtonLanguageInput ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63); 

            			newLeafNode(otherlv_0, grammarAccess.getButtonActionAccess().getButtonKeyword_0());
            		
            otherlv_1=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getButtonActionAccess().getResponseKeyword_1());
            		
            // InternalBot.g:3384:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:3385:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:3385:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:3386:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getButtonActionAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getButtonActionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_52); 

            			newLeafNode(otherlv_3, grammarAccess.getButtonActionAccess().getColonKeyword_3());
            		
            // InternalBot.g:3407:3: ( (lv_inputs_4_0= ruleButtonLanguageInput ) )
            // InternalBot.g:3408:4: (lv_inputs_4_0= ruleButtonLanguageInput )
            {
            // InternalBot.g:3408:4: (lv_inputs_4_0= ruleButtonLanguageInput )
            // InternalBot.g:3409:5: lv_inputs_4_0= ruleButtonLanguageInput
            {

            					newCompositeNode(grammarAccess.getButtonActionAccess().getInputsButtonLanguageInputParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_inputs_4_0=ruleButtonLanguageInput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getButtonActionRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.ButtonLanguageInput");
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
    // $ANTLR end "ruleButtonAction"


    // $ANTLR start "entryRuleButtonLanguageInput"
    // InternalBot.g:3430:1: entryRuleButtonLanguageInput returns [EObject current=null] : iv_ruleButtonLanguageInput= ruleButtonLanguageInput EOF ;
    public final EObject entryRuleButtonLanguageInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleButtonLanguageInput = null;


        try {
            // InternalBot.g:3430:60: (iv_ruleButtonLanguageInput= ruleButtonLanguageInput EOF )
            // InternalBot.g:3431:2: iv_ruleButtonLanguageInput= ruleButtonLanguageInput EOF
            {
             newCompositeNode(grammarAccess.getButtonLanguageInputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleButtonLanguageInput=ruleButtonLanguageInput();

            state._fsp--;

             current =iv_ruleButtonLanguageInput; 
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
    // $ANTLR end "entryRuleButtonLanguageInput"


    // $ANTLR start "ruleButtonLanguageInput"
    // InternalBot.g:3437:1: ruleButtonLanguageInput returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' otherlv_4= 'text:' ( (lv_text_5_0= ruleTextInputText ) ) otherlv_6= 'buttons:' ( (lv_buttons_7_0= ruleButton ) )+ otherlv_8= '}' ) ;
    public final EObject ruleButtonLanguageInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_text_5_0 = null;

        EObject lv_buttons_7_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3443:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' otherlv_4= 'text:' ( (lv_text_5_0= ruleTextInputText ) ) otherlv_6= 'buttons:' ( (lv_buttons_7_0= ruleButton ) )+ otherlv_8= '}' ) )
            // InternalBot.g:3444:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' otherlv_4= 'text:' ( (lv_text_5_0= ruleTextInputText ) ) otherlv_6= 'buttons:' ( (lv_buttons_7_0= ruleButton ) )+ otherlv_8= '}' )
            {
            // InternalBot.g:3444:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' otherlv_4= 'text:' ( (lv_text_5_0= ruleTextInputText ) ) otherlv_6= 'buttons:' ( (lv_buttons_7_0= ruleButton ) )+ otherlv_8= '}' )
            // InternalBot.g:3445:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' otherlv_4= 'text:' ( (lv_text_5_0= ruleTextInputText ) ) otherlv_6= 'buttons:' ( (lv_buttons_7_0= ruleButton ) )+ otherlv_8= '}'
            {
            // InternalBot.g:3445:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==23) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalBot.g:3446:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getButtonLanguageInputAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:3450:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==24) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // InternalBot.g:3451:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_6); 

                            					newLeafNode(otherlv_1, grammarAccess.getButtonLanguageInputAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:3455:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:3456:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:3456:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:3457:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getButtonLanguageInputAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_language_2_0=ruleLanguage();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getButtonLanguageInputRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_76); 

            			newLeafNode(otherlv_3, grammarAccess.getButtonLanguageInputAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_4=(Token)match(input,64,FOLLOW_64); 

            			newLeafNode(otherlv_4, grammarAccess.getButtonLanguageInputAccess().getTextKeyword_2());
            		
            // InternalBot.g:3484:3: ( (lv_text_5_0= ruleTextInputText ) )
            // InternalBot.g:3485:4: (lv_text_5_0= ruleTextInputText )
            {
            // InternalBot.g:3485:4: (lv_text_5_0= ruleTextInputText )
            // InternalBot.g:3486:5: lv_text_5_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getButtonLanguageInputAccess().getTextTextInputTextParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_77);
            lv_text_5_0=ruleTextInputText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getButtonLanguageInputRule());
            					}
            					set(
            						current,
            						"text",
            						lv_text_5_0,
            						"org.xtext.botGenerator.Bot.TextInputText");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,65,FOLLOW_13); 

            			newLeafNode(otherlv_6, grammarAccess.getButtonLanguageInputAccess().getButtonsKeyword_4());
            		
            // InternalBot.g:3507:3: ( (lv_buttons_7_0= ruleButton ) )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==19) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalBot.g:3508:4: (lv_buttons_7_0= ruleButton )
            	    {
            	    // InternalBot.g:3508:4: (lv_buttons_7_0= ruleButton )
            	    // InternalBot.g:3509:5: lv_buttons_7_0= ruleButton
            	    {

            	    					newCompositeNode(grammarAccess.getButtonLanguageInputAccess().getButtonsButtonParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_78);
            	    lv_buttons_7_0=ruleButton();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getButtonLanguageInputRule());
            	    					}
            	    					add(
            	    						current,
            	    						"buttons",
            	    						lv_buttons_7_0,
            	    						"org.xtext.botGenerator.Bot.Button");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt74 >= 1 ) break loop74;
                        EarlyExitException eee =
                            new EarlyExitException(74, input);
                        throw eee;
                }
                cnt74++;
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getButtonLanguageInputAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleButtonLanguageInput"


    // $ANTLR start "entryRuleButton"
    // InternalBot.g:3534:1: entryRuleButton returns [EObject current=null] : iv_ruleButton= ruleButton EOF ;
    public final EObject entryRuleButton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleButton = null;


        try {
            // InternalBot.g:3534:47: (iv_ruleButton= ruleButton EOF )
            // InternalBot.g:3535:2: iv_ruleButton= ruleButton EOF
            {
             newCompositeNode(grammarAccess.getButtonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleButton=ruleButton();

            state._fsp--;

             current =iv_ruleButton; 
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
    // $ANTLR end "entryRuleButton"


    // $ANTLR start "ruleButton"
    // InternalBot.g:3541:1: ruleButton returns [EObject current=null] : (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? ) ;
    public final EObject ruleButton() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_action_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3547:2: ( (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? ) )
            // InternalBot.g:3548:2: (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? )
            {
            // InternalBot.g:3548:2: (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? )
            // InternalBot.g:3549:3: otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_79); 

            			newLeafNode(otherlv_0, grammarAccess.getButtonAccess().getHyphenMinusKeyword_0());
            		
            otherlv_1=(Token)match(input,66,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getButtonAccess().getValueKeyword_1());
            		
            // InternalBot.g:3557:3: ( (lv_value_2_0= ruleEString ) )
            // InternalBot.g:3558:4: (lv_value_2_0= ruleEString )
            {
            // InternalBot.g:3558:4: (lv_value_2_0= ruleEString )
            // InternalBot.g:3559:5: lv_value_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getButtonAccess().getValueEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_80);
            lv_value_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getButtonRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:3576:3: (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==67) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalBot.g:3577:4: otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,67,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getButtonAccess().getActionKeyword_3_0());
                    			
                    // InternalBot.g:3581:4: ( (lv_action_4_0= ruleEString ) )
                    // InternalBot.g:3582:5: (lv_action_4_0= ruleEString )
                    {
                    // InternalBot.g:3582:5: (lv_action_4_0= ruleEString )
                    // InternalBot.g:3583:6: lv_action_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getButtonAccess().getActionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_action_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getButtonRule());
                    						}
                    						set(
                    							current,
                    							"action",
                    							lv_action_4_0,
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
    // $ANTLR end "ruleButton"


    // $ANTLR start "entryRuleTextLanguageInputHttpResponse"
    // InternalBot.g:3605:1: entryRuleTextLanguageInputHttpResponse returns [EObject current=null] : iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF ;
    public final EObject entryRuleTextLanguageInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextLanguageInputHttpResponse = null;


        try {
            // InternalBot.g:3605:70: (iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF )
            // InternalBot.g:3606:2: iv_ruleTextLanguageInputHttpResponse= ruleTextLanguageInputHttpResponse EOF
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
    // InternalBot.g:3612:1: ruleTextLanguageInputHttpResponse returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) ;
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
            // InternalBot.g:3618:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:3619:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:3619:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            // InternalBot.g:3620:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getTextLanguageInputHttpResponseAccess().getInputsKeyword_0());
            		
            // InternalBot.g:3624:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==24) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalBot.g:3625:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextLanguageInputHttpResponseAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:3629:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:3630:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:3630:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:3631:6: lv_language_2_0= ruleLanguage
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

            otherlv_3=(Token)match(input,25,FOLLOW_81); 

            			newLeafNode(otherlv_3, grammarAccess.getTextLanguageInputHttpResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:3653:3: ( (lv_inputs_4_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:3654:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:3654:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            // InternalBot.g:3655:5: lv_inputs_4_0= ruleTextInputHttpResponse
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

            // InternalBot.g:3672:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==14) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalBot.g:3673:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_81); 

            	    				newLeafNode(otherlv_5, grammarAccess.getTextLanguageInputHttpResponseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:3677:4: ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    // InternalBot.g:3678:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    {
            	    // InternalBot.g:3678:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    // InternalBot.g:3679:6: lv_inputs_6_0= ruleTextInputHttpResponse
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
            	    break loop77;
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
    // InternalBot.g:3705:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:3705:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:3706:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
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
    // InternalBot.g:3712:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:3718:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:3719:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:3719:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt79=0;
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( ((LA79_0>=RULE_STRING && LA79_0<=RULE_ID)||LA79_0==36||LA79_0==41) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // InternalBot.g:3720:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:3720:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:3721:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:3721:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt78=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt78=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt78=2;
            	        }
            	        break;
            	    case 41:
            	        {
            	        alt78=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 78, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt78) {
            	        case 1 :
            	            // InternalBot.g:3722:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_82);
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
            	            // InternalBot.g:3738:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_82);
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
            	            // InternalBot.g:3754:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_82);
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
            	    if ( cnt79 >= 1 ) break loop79;
                        EarlyExitException eee =
                            new EarlyExitException(79, input);
                        throw eee;
                }
                cnt79++;
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
    // InternalBot.g:3775:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:3775:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:3776:2: iv_ruleTextInputText= ruleTextInputText EOF
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
    // InternalBot.g:3782:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3788:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:3789:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:3789:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt81=0;
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( ((LA81_0>=RULE_STRING && LA81_0<=RULE_ID)||LA81_0==36) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // InternalBot.g:3790:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:3790:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:3791:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:3791:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt80=2;
            	    int LA80_0 = input.LA(1);

            	    if ( ((LA80_0>=RULE_STRING && LA80_0<=RULE_ID)) ) {
            	        alt80=1;
            	    }
            	    else if ( (LA80_0==36) ) {
            	        alt80=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 80, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt80) {
            	        case 1 :
            	            // InternalBot.g:3792:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_83);
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
            	            // InternalBot.g:3808:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_83);
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
            	    if ( cnt81 >= 1 ) break loop81;
                        EarlyExitException eee =
                            new EarlyExitException(81, input);
                        throw eee;
                }
                cnt81++;
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
    // InternalBot.g:3829:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:3829:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:3830:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalBot.g:3836:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3842:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:3843:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:3843:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:3844:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:3844:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3845:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3845:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3846:5: lv_key_0_0= ruleEString
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
            		
            // InternalBot.g:3867:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:3868:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:3868:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:3869:5: lv_value_2_0= ruleLiteral
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
    // InternalBot.g:3890:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:3890:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:3891:2: iv_ruleData= ruleData EOF
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
    // InternalBot.g:3897:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3903:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:3904:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:3904:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:3905:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:3905:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3906:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3906:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3907:5: lv_key_0_0= ruleEString
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

            otherlv_1=(Token)match(input,13,FOLLOW_64); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:3928:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:3929:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:3929:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:3930:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:3930:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_ID)) ) {
                alt82=1;
            }
            else if ( (LA82_0==36) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // InternalBot.g:3931:6: lv_value_2_1= ruleLiteral
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
                    // InternalBot.g:3947:6: lv_value_2_2= ruleParameterToken
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
    // InternalBot.g:3969:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:3975:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:3976:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:3976:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt83=5;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt83=1;
                }
                break;
            case 68:
                {
                alt83=2;
                }
                break;
            case 69:
                {
                alt83=3;
                }
                break;
            case 70:
                {
                alt83=4;
                }
                break;
            case 71:
                {
                alt83=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalBot.g:3977:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:3977:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:3978:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:3985:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:3985:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:3986:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:3993:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:3993:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:3994:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:4001:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:4001:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:4002:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:4009:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:4009:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:4010:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,71,FOLLOW_2); 

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
    // InternalBot.g:4020:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:4026:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:4027:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:4027:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt84=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt84=1;
                }
                break;
            case 72:
                {
                alt84=2;
                }
                break;
            case 73:
                {
                alt84=3;
                }
                break;
            case 57:
                {
                alt84=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalBot.g:4028:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:4028:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:4029:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4036:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:4036:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:4037:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:4044:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:4044:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:4045:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:4052:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:4052:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:4053:4: enumLiteral_3= 'data'
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
    // InternalBot.g:4063:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
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
            // InternalBot.g:4069:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:4070:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:4070:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt85=26;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt85=1;
                }
                break;
            case 75:
                {
                alt85=2;
                }
                break;
            case 76:
                {
                alt85=3;
                }
                break;
            case 77:
                {
                alt85=4;
                }
                break;
            case 78:
                {
                alt85=5;
                }
                break;
            case 79:
                {
                alt85=6;
                }
                break;
            case 80:
                {
                alt85=7;
                }
                break;
            case 81:
                {
                alt85=8;
                }
                break;
            case 82:
                {
                alt85=9;
                }
                break;
            case 83:
                {
                alt85=10;
                }
                break;
            case 84:
                {
                alt85=11;
                }
                break;
            case 85:
                {
                alt85=12;
                }
                break;
            case 86:
                {
                alt85=13;
                }
                break;
            case 87:
                {
                alt85=14;
                }
                break;
            case 88:
                {
                alt85=15;
                }
                break;
            case 89:
                {
                alt85=16;
                }
                break;
            case 90:
                {
                alt85=17;
                }
                break;
            case 91:
                {
                alt85=18;
                }
                break;
            case 92:
                {
                alt85=19;
                }
                break;
            case 93:
                {
                alt85=20;
                }
                break;
            case 94:
                {
                alt85=21;
                }
                break;
            case 95:
                {
                alt85=22;
                }
                break;
            case 96:
                {
                alt85=23;
                }
                break;
            case 97:
                {
                alt85=24;
                }
                break;
            case 98:
                {
                alt85=25;
                }
                break;
            case 99:
                {
                alt85=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalBot.g:4071:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:4071:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:4072:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4079:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:4079:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:4080:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:4087:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:4087:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:4088:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:4095:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:4095:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:4096:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:4103:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:4103:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:4104:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:4111:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:4111:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:4112:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:4119:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:4119:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:4120:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:4127:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:4127:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:4128:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:4135:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:4135:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:4136:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:4143:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:4143:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:4144:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:4151:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:4151:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:4152:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:4159:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:4159:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:4160:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:4167:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:4167:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:4168:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:4175:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:4175:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:4176:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:4183:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:4183:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:4184:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:4191:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:4191:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:4192:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:4199:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:4199:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:4200:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:4207:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:4207:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:4208:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:4215:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:4215:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:4216:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:4223:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:4223:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:4224:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:4231:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:4231:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:4232:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:4239:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:4239:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:4240:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:4247:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:4247:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:4248:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:4255:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:4255:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:4256:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:4263:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:4263:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:4264:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:4271:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:4271:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:4272:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,99,FOLLOW_2); 

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
    // InternalBot.g:4282:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:4288:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:4289:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:4289:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==100) ) {
                alt86=1;
            }
            else if ( (LA86_0==101) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalBot.g:4290:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:4290:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:4291:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4298:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:4298:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:4299:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); 

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
    // InternalBot.g:4309:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:4315:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:4316:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:4316:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==102) ) {
                alt87=1;
            }
            else if ( (LA87_0==103) ) {
                alt87=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // InternalBot.g:4317:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:4317:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:4318:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4325:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:4325:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:4326:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); 

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


    protected DFA21 dfa21 = new DFA21(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\5\uffff\2\11\3\uffff\2\11";
    static final String dfa_3s = "\1\4\2\15\1\4\1\35\2\16\1\4\2\uffff\2\16";
    static final String dfa_4s = "\1\35\2\15\1\5\1\35\2\34\1\5\2\uffff\2\34";
    static final String dfa_5s = "\10\uffff\1\2\1\1\2\uffff";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2\27\uffff\1\3",
            "\1\4",
            "\1\4",
            "\1\5\1\6",
            "\1\3",
            "\1\7\5\uffff\1\11\4\uffff\1\11\2\uffff\1\10",
            "\1\7\5\uffff\1\11\4\uffff\1\11\2\uffff\1\10",
            "\1\12\1\13",
            "",
            "",
            "\1\7\5\uffff\1\11\4\uffff\1\11\2\uffff\1\10",
            "\1\7\5\uffff\1\11\4\uffff\1\11\2\uffff\1\10"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "827:7: (lv_target_5_1= ruleState2 | lv_target_5_2= ruleState )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000FFFFFFC00L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000380000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0xD836000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xD836000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002C00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000408000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000060000030L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000002004002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000048000030L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000010004000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000000032L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000030L,0x00000000000000F0L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000800100000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000002000004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0204000000000000L,0x0000000000000300L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000800004000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000408004000030L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000004000000030L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000004000000032L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x000000C000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0380000000000002L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000003000000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000021000000030L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000021000000032L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000001000000032L});

}