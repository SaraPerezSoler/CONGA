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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Chatbot'", "'language'", "':'", "','", "'intents'", "'entities'", "'actions'", "'flows'", "'-'", "';'", "'Fallback'", "'parameters'", "'inputs'", "'in'", "'{'", "'}'", "'user'", "'=>'", "'chatbot'", "'back'", "'to'", "'entity'", "'isList'", "'required'", "'prompts'", "'['", "']'", "'@'", "'('", "')'", "'request.'", "'.'", "'Simple'", "'Composite'", "'Regex'", "'pattern'", "'composite'", "'synonyms'", "'Text'", "'text'", "'response'", "'Response'", "'Request'", "'URL'", "'basicAuth'", "'headers'", "'data'", "'dataType'", "'Image'", "'mage'", "'caption'", "'Empty'", "'description:'", "'Button'", "'text:'", "'buttons:'", "'value:'", "'action:'", "'number'", "'date'", "'float'", "'time'", "'status_code'", "'image'", "'en'", "'es'", "'da'", "'de'", "'fr'", "'hi'", "'id'", "'it'", "'ja'", "'ko'", "'nl'", "'no'", "'pl'", "'pt'", "'ru'", "'sv'", "'th'", "'tr'", "'uk'", "'zh'", "'ar'", "'cz'", "'bu'", "'fi'", "'gr'", "'ba'", "'JSON'", "'FORM'", "'post'", "'get'"
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
    public static final int T__104=104;
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

                        if ( ((LA5_0>=49 && LA5_0<=50)||(LA5_0>=52 && LA5_0<=53)||(LA5_0>=59 && LA5_0<=60)||LA5_0==62||LA5_0==64) ) {
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
            case 64:
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

                    if ( (LA10_3==EOF||(LA10_3>=RULE_STRING && LA10_3<=RULE_ID)||(LA10_3>=16 && LA10_3<=18)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_3==13) ) {
                        alt10=2;
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

                    if ( (LA10_3==EOF||(LA10_3>=RULE_STRING && LA10_3<=RULE_ID)||(LA10_3>=16 && LA10_3<=18)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_3==13) ) {
                        alt10=2;
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
    // InternalBot.g:487:1: ruleIntent2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageIntent ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? ) ;
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
            // InternalBot.g:493:2: ( ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageIntent ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? ) )
            // InternalBot.g:494:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageIntent ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? )
            {
            // InternalBot.g:494:2: ( ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageIntent ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )? )
            // InternalBot.g:495:3: ( (lv_name_0_0= ruleEString ) ) ( (lv_fallbackIntent_1_0= 'Fallback' ) )? otherlv_2= ':' ( (lv_inputs_3_0= ruleLanguageIntent ) )* (otherlv_4= 'parameters' otherlv_5= ':' ( ( (lv_parameters_6_0= ruleParameter2 ) )* ( (lv_parameters_7_0= ruleParameter ) ) )+ )?
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
            		
            // InternalBot.g:532:3: ( (lv_inputs_3_0= ruleLanguageIntent ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23||LA12_0==25) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalBot.g:533:4: (lv_inputs_3_0= ruleLanguageIntent )
            	    {
            	    // InternalBot.g:533:4: (lv_inputs_3_0= ruleLanguageIntent )
            	    // InternalBot.g:534:5: lv_inputs_3_0= ruleLanguageIntent
            	    {

            	    					newCompositeNode(grammarAccess.getIntent2Access().getInputsLanguageIntentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_18);
            	    lv_inputs_3_0=ruleLanguageIntent();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntent2Rule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_3_0,
            	    						"org.xtext.botGenerator.Bot.LanguageIntent");
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

                            if ( (LA14_1==13) ) {
                                int LA14_4 = input.LA(3);

                                if ( (LA14_4==32) ) {
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

                                if ( (LA14_4==32) ) {
                                    alt14=1;
                                }


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


    // $ANTLR start "entryRuleLanguageIntent"
    // InternalBot.g:657:1: entryRuleLanguageIntent returns [EObject current=null] : iv_ruleLanguageIntent= ruleLanguageIntent EOF ;
    public final EObject entryRuleLanguageIntent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageIntent = null;


        try {
            // InternalBot.g:657:55: (iv_ruleLanguageIntent= ruleLanguageIntent EOF )
            // InternalBot.g:658:2: iv_ruleLanguageIntent= ruleLanguageIntent EOF
            {
             newCompositeNode(grammarAccess.getLanguageIntentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguageIntent=ruleLanguageIntent();

            state._fsp--;

             current =iv_ruleLanguageIntent; 
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
    // $ANTLR end "entryRuleLanguageIntent"


    // $ANTLR start "ruleLanguageIntent"
    // InternalBot.g:664:1: ruleLanguageIntent returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleLanguageIntent() throws RecognitionException {
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
            // InternalBot.g:670:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:671:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:671:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}' )
            // InternalBot.g:672:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTrainingPhrase ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )* otherlv_7= '}'
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

                    				newLeafNode(otherlv_0, grammarAccess.getLanguageIntentAccess().getInputsKeyword_0_0());
                    			
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

                            					newLeafNode(otherlv_1, grammarAccess.getLanguageIntentAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:682:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:683:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:683:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:684:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getLanguageIntentAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_language_2_0=ruleLanguage();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getLanguageIntentRule());
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

            			newLeafNode(otherlv_3, grammarAccess.getLanguageIntentAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:707:3: ( (lv_inputs_4_0= ruleTrainingPhrase ) )
            // InternalBot.g:708:4: (lv_inputs_4_0= ruleTrainingPhrase )
            {
            // InternalBot.g:708:4: (lv_inputs_4_0= ruleTrainingPhrase )
            // InternalBot.g:709:5: lv_inputs_4_0= ruleTrainingPhrase
            {

            					newCompositeNode(grammarAccess.getLanguageIntentAccess().getInputsTrainingPhraseParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTrainingPhrase();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLanguageIntentRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TrainingPhrase");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:726:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==14) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalBot.g:727:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTrainingPhrase ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_23); 

            	    				newLeafNode(otherlv_5, grammarAccess.getLanguageIntentAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:731:4: ( (lv_inputs_6_0= ruleTrainingPhrase ) )
            	    // InternalBot.g:732:5: (lv_inputs_6_0= ruleTrainingPhrase )
            	    {
            	    // InternalBot.g:732:5: (lv_inputs_6_0= ruleTrainingPhrase )
            	    // InternalBot.g:733:6: lv_inputs_6_0= ruleTrainingPhrase
            	    {

            	    						newCompositeNode(grammarAccess.getLanguageIntentAccess().getInputsTrainingPhraseParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTrainingPhrase();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLanguageIntentRule());
            	    						}
            	    						add(
            	    							current,
            	    							"inputs",
            	    							lv_inputs_6_0,
            	    							"org.xtext.botGenerator.Bot.TrainingPhrase");
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

            			newLeafNode(otherlv_7, grammarAccess.getLanguageIntentAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleLanguageIntent"


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


    // $ANTLR start "entryRuleTrainingPhrase"
    // InternalBot.g:1247:1: entryRuleTrainingPhrase returns [EObject current=null] : iv_ruleTrainingPhrase= ruleTrainingPhrase EOF ;
    public final EObject entryRuleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrainingPhrase = null;


        try {
            // InternalBot.g:1247:55: (iv_ruleTrainingPhrase= ruleTrainingPhrase EOF )
            // InternalBot.g:1248:2: iv_ruleTrainingPhrase= ruleTrainingPhrase EOF
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
    // InternalBot.g:1254:1: ruleTrainingPhrase returns [EObject current=null] : ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) ;
    public final EObject ruleTrainingPhrase() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_1_1 = null;

        EObject lv_tokens_1_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1260:2: ( ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ ) )
            // InternalBot.g:1261:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            {
            // InternalBot.g:1261:2: ( () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+ )
            // InternalBot.g:1262:3: () ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            {
            // InternalBot.g:1262:3: ()
            // InternalBot.g:1263:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTrainingPhraseAccess().getTrainingPhraseAction_0(),
            					current);
            			

            }

            // InternalBot.g:1269:3: ( ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_ID)||LA35_0==39) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalBot.g:1270:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    {
            	    // InternalBot.g:1270:4: ( (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken ) )
            	    // InternalBot.g:1271:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    {
            	    // InternalBot.g:1271:5: (lv_tokens_1_1= ruleLiteral | lv_tokens_1_2= ruleParameterRefenceToken )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_ID)) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==39) ) {
            	        alt34=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // InternalBot.g:1272:6: lv_tokens_1_1= ruleLiteral
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
            	            // InternalBot.g:1288:6: lv_tokens_1_2= ruleParameterRefenceToken
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
    // $ANTLR end "ruleTrainingPhrase"


    // $ANTLR start "entryRuleParameter"
    // InternalBot.g:1310:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalBot.g:1310:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalBot.g:1311:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalBot.g:1317:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+ )? otherlv_11= ';' ) ;
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
            // InternalBot.g:1323:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+ )? otherlv_11= ';' ) )
            // InternalBot.g:1324:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+ )? otherlv_11= ';' )
            {
            // InternalBot.g:1324:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+ )? otherlv_11= ';' )
            // InternalBot.g:1325:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' otherlv_2= 'entity' ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) ) (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )? (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )? (otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+ )? otherlv_11= ';'
            {
            // InternalBot.g:1325:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1326:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1326:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1327:5: lv_name_0_0= ruleEString
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
            		
            // InternalBot.g:1352:3: ( ( ( ruleEString ) ) | ( (lv_defaultEntity_4_0= ruleDefaultEntity ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_ID)) ) {
                alt36=1;
            }
            else if ( (LA36_0==50||(LA36_0>=69 && LA36_0<=72)) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalBot.g:1353:4: ( ( ruleEString ) )
                    {
                    // InternalBot.g:1353:4: ( ( ruleEString ) )
                    // InternalBot.g:1354:5: ( ruleEString )
                    {
                    // InternalBot.g:1354:5: ( ruleEString )
                    // InternalBot.g:1355:6: ruleEString
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
                    // InternalBot.g:1370:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    {
                    // InternalBot.g:1370:4: ( (lv_defaultEntity_4_0= ruleDefaultEntity ) )
                    // InternalBot.g:1371:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    {
                    // InternalBot.g:1371:5: (lv_defaultEntity_4_0= ruleDefaultEntity )
                    // InternalBot.g:1372:6: lv_defaultEntity_4_0= ruleDefaultEntity
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

            // InternalBot.g:1390:3: (otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==14) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==33) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // InternalBot.g:1391:4: otherlv_5= ',' ( (lv_isList_6_0= 'isList' ) )
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_40); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterAccess().getCommaKeyword_4_0());
                    			
                    // InternalBot.g:1395:4: ( (lv_isList_6_0= 'isList' ) )
                    // InternalBot.g:1396:5: (lv_isList_6_0= 'isList' )
                    {
                    // InternalBot.g:1396:5: (lv_isList_6_0= 'isList' )
                    // InternalBot.g:1397:6: lv_isList_6_0= 'isList'
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

            // InternalBot.g:1410:3: (otherlv_7= ',' ( (lv_required_8_0= 'required' ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==14) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==34) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalBot.g:1411:4: otherlv_7= ',' ( (lv_required_8_0= 'required' ) )
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_41); 

                    				newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getCommaKeyword_5_0());
                    			
                    // InternalBot.g:1415:4: ( (lv_required_8_0= 'required' ) )
                    // InternalBot.g:1416:5: (lv_required_8_0= 'required' )
                    {
                    // InternalBot.g:1416:5: (lv_required_8_0= 'required' )
                    // InternalBot.g:1417:6: lv_required_8_0= 'required'
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

            // InternalBot.g:1430:3: (otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+ )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==14) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalBot.g:1431:4: otherlv_9= ',' ( (lv_prompts_10_0= ruleLanguagePrompt ) )+
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_42); 

                    				newLeafNode(otherlv_9, grammarAccess.getParameterAccess().getCommaKeyword_6_0());
                    			
                    // InternalBot.g:1435:4: ( (lv_prompts_10_0= ruleLanguagePrompt ) )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==35) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalBot.g:1436:5: (lv_prompts_10_0= ruleLanguagePrompt )
                    	    {
                    	    // InternalBot.g:1436:5: (lv_prompts_10_0= ruleLanguagePrompt )
                    	    // InternalBot.g:1437:6: lv_prompts_10_0= ruleLanguagePrompt
                    	    {

                    	    						newCompositeNode(grammarAccess.getParameterAccess().getPromptsLanguagePromptParserRuleCall_6_1_0());
                    	    					
                    	    pushFollow(FOLLOW_43);
                    	    lv_prompts_10_0=ruleLanguagePrompt();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getParameterRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"prompts",
                    	    							lv_prompts_10_0,
                    	    							"org.xtext.botGenerator.Bot.LanguagePrompt");
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
    // InternalBot.g:1463:1: entryRuleParameter2 returns [EObject current=null] : iv_ruleParameter2= ruleParameter2 EOF ;
    public final EObject entryRuleParameter2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter2 = null;


        try {
            // InternalBot.g:1463:51: (iv_ruleParameter2= ruleParameter2 EOF )
            // InternalBot.g:1464:2: iv_ruleParameter2= ruleParameter2 EOF
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
    // InternalBot.g:1470:1: ruleParameter2 returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) ;
    public final EObject ruleParameter2() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1476:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' ) )
            // InternalBot.g:1477:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            {
            // InternalBot.g:1477:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ',' )
            // InternalBot.g:1478:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ','
            {
            // InternalBot.g:1478:3: ( (lv_name_0_0= ruleEString ) )
            // InternalBot.g:1479:4: (lv_name_0_0= ruleEString )
            {
            // InternalBot.g:1479:4: (lv_name_0_0= ruleEString )
            // InternalBot.g:1480:5: lv_name_0_0= ruleEString
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


    // $ANTLR start "entryRuleLanguagePrompt"
    // InternalBot.g:1505:1: entryRuleLanguagePrompt returns [EObject current=null] : iv_ruleLanguagePrompt= ruleLanguagePrompt EOF ;
    public final EObject entryRuleLanguagePrompt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguagePrompt = null;


        try {
            // InternalBot.g:1505:55: (iv_ruleLanguagePrompt= ruleLanguagePrompt EOF )
            // InternalBot.g:1506:2: iv_ruleLanguagePrompt= ruleLanguagePrompt EOF
            {
             newCompositeNode(grammarAccess.getLanguagePromptRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguagePrompt=ruleLanguagePrompt();

            state._fsp--;

             current =iv_ruleLanguagePrompt; 
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
    // $ANTLR end "entryRuleLanguagePrompt"


    // $ANTLR start "ruleLanguagePrompt"
    // InternalBot.g:1512:1: ruleLanguagePrompt returns [EObject current=null] : (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) ;
    public final EObject ruleLanguagePrompt() throws RecognitionException {
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
            // InternalBot.g:1518:2: ( (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' ) )
            // InternalBot.g:1519:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            {
            // InternalBot.g:1519:2: (otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']' )
            // InternalBot.g:1520:3: otherlv_0= 'prompts' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '[' ( (lv_prompts_4_0= ruleEString ) ) (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )* otherlv_7= ']'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_45); 

            			newLeafNode(otherlv_0, grammarAccess.getLanguagePromptAccess().getPromptsKeyword_0());
            		
            // InternalBot.g:1524:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==24) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalBot.g:1525:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getLanguagePromptAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:1529:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:1530:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:1530:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:1531:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getLanguagePromptAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_46);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLanguagePromptRule());
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

            			newLeafNode(otherlv_3, grammarAccess.getLanguagePromptAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalBot.g:1553:3: ( (lv_prompts_4_0= ruleEString ) )
            // InternalBot.g:1554:4: (lv_prompts_4_0= ruleEString )
            {
            // InternalBot.g:1554:4: (lv_prompts_4_0= ruleEString )
            // InternalBot.g:1555:5: lv_prompts_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLanguagePromptAccess().getPromptsEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_47);
            lv_prompts_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLanguagePromptRule());
            					}
            					add(
            						current,
            						"prompts",
            						lv_prompts_4_0,
            						"org.xtext.botGenerator.Bot.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:1572:3: (otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==14) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalBot.g:1573:4: otherlv_5= ',' ( (lv_prompts_6_0= ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getLanguagePromptAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:1577:4: ( (lv_prompts_6_0= ruleEString ) )
            	    // InternalBot.g:1578:5: (lv_prompts_6_0= ruleEString )
            	    {
            	    // InternalBot.g:1578:5: (lv_prompts_6_0= ruleEString )
            	    // InternalBot.g:1579:6: lv_prompts_6_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getLanguagePromptAccess().getPromptsEStringParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_47);
            	    lv_prompts_6_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLanguagePromptRule());
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
            	    break loop42;
                }
            } while (true);

            otherlv_7=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLanguagePromptAccess().getRightSquareBracketKeyword_5());
            		

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
    // $ANTLR end "ruleLanguagePrompt"


    // $ANTLR start "entryRuleLiteral"
    // InternalBot.g:1605:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalBot.g:1605:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalBot.g:1606:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalBot.g:1612:1: ruleLiteral returns [EObject current=null] : ( (lv_text_0_0= ruleEString ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_text_0_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1618:2: ( ( (lv_text_0_0= ruleEString ) ) )
            // InternalBot.g:1619:2: ( (lv_text_0_0= ruleEString ) )
            {
            // InternalBot.g:1619:2: ( (lv_text_0_0= ruleEString ) )
            // InternalBot.g:1620:3: (lv_text_0_0= ruleEString )
            {
            // InternalBot.g:1620:3: (lv_text_0_0= ruleEString )
            // InternalBot.g:1621:4: lv_text_0_0= ruleEString
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
    // InternalBot.g:1641:1: entryRuleEntityToken returns [EObject current=null] : iv_ruleEntityToken= ruleEntityToken EOF ;
    public final EObject entryRuleEntityToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntityToken = null;


        try {
            // InternalBot.g:1641:52: (iv_ruleEntityToken= ruleEntityToken EOF )
            // InternalBot.g:1642:2: iv_ruleEntityToken= ruleEntityToken EOF
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
    // InternalBot.g:1648:1: ruleEntityToken returns [EObject current=null] : (otherlv_0= '@' ( ( ruleEString ) ) ) ;
    public final EObject ruleEntityToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalBot.g:1654:2: ( (otherlv_0= '@' ( ( ruleEString ) ) ) )
            // InternalBot.g:1655:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            {
            // InternalBot.g:1655:2: (otherlv_0= '@' ( ( ruleEString ) ) )
            // InternalBot.g:1656:3: otherlv_0= '@' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEntityTokenAccess().getCommercialAtKeyword_0());
            		
            // InternalBot.g:1660:3: ( ( ruleEString ) )
            // InternalBot.g:1661:4: ( ruleEString )
            {
            // InternalBot.g:1661:4: ( ruleEString )
            // InternalBot.g:1662:5: ruleEString
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
    // InternalBot.g:1680:1: entryRuleParameterToken returns [EObject current=null] : iv_ruleParameterToken= ruleParameterToken EOF ;
    public final EObject entryRuleParameterToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterToken = null;


        try {
            // InternalBot.g:1680:55: (iv_ruleParameterToken= ruleParameterToken EOF )
            // InternalBot.g:1681:2: iv_ruleParameterToken= ruleParameterToken EOF
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
    // InternalBot.g:1687:1: ruleParameterToken returns [EObject current=null] : (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' (otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleParameterToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_info_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1693:2: ( (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' (otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')' )? ) )
            // InternalBot.g:1694:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' (otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')' )? )
            {
            // InternalBot.g:1694:2: (otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' (otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')' )? )
            // InternalBot.g:1695:3: otherlv_0= '[' ( ( ruleEString ) ) otherlv_2= ']' (otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')' )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterTokenAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalBot.g:1699:3: ( ( ruleEString ) )
            // InternalBot.g:1700:4: ( ruleEString )
            {
            // InternalBot.g:1700:4: ( ruleEString )
            // InternalBot.g:1701:5: ruleEString
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

            otherlv_2=(Token)match(input,37,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getParameterTokenAccess().getRightSquareBracketKeyword_2());
            		
            // InternalBot.g:1719:3: (otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==39) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalBot.g:1720:4: otherlv_3= '(' ( (lv_info_4_0= ruleEString ) ) otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,39,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getParameterTokenAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalBot.g:1724:4: ( (lv_info_4_0= ruleEString ) )
                    // InternalBot.g:1725:5: (lv_info_4_0= ruleEString )
                    {
                    // InternalBot.g:1725:5: (lv_info_4_0= ruleEString )
                    // InternalBot.g:1726:6: lv_info_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getParameterTokenAccess().getInfoEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_info_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getParameterTokenRule());
                    						}
                    						set(
                    							current,
                    							"info",
                    							lv_info_4_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,40,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getParameterTokenAccess().getRightParenthesisKeyword_3_2());
                    			

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
    // $ANTLR end "ruleParameterToken"


    // $ANTLR start "entryRuleParameterRefenceToken"
    // InternalBot.g:1752:1: entryRuleParameterRefenceToken returns [EObject current=null] : iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF ;
    public final EObject entryRuleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRefenceToken = null;


        try {
            // InternalBot.g:1752:62: (iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF )
            // InternalBot.g:1753:2: iv_ruleParameterRefenceToken= ruleParameterRefenceToken EOF
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
    // InternalBot.g:1759:1: ruleParameterRefenceToken returns [EObject current=null] : (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) ;
    public final EObject ruleParameterRefenceToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_textReference_1_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1765:2: ( (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' ) )
            // InternalBot.g:1766:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            {
            // InternalBot.g:1766:2: (otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']' )
            // InternalBot.g:1767:3: otherlv_0= '(' ( (lv_textReference_1_0= ruleEString ) ) otherlv_2= ')' otherlv_3= '[' ( ( ruleEString ) ) otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getParameterRefenceTokenAccess().getLeftParenthesisKeyword_0());
            		
            // InternalBot.g:1771:3: ( (lv_textReference_1_0= ruleEString ) )
            // InternalBot.g:1772:4: (lv_textReference_1_0= ruleEString )
            {
            // InternalBot.g:1772:4: (lv_textReference_1_0= ruleEString )
            // InternalBot.g:1773:5: lv_textReference_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getParameterRefenceTokenAccess().getTextReferenceEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_50);
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
            		
            // InternalBot.g:1798:3: ( ( ruleEString ) )
            // InternalBot.g:1799:4: ( ruleEString )
            {
            // InternalBot.g:1799:4: ( ruleEString )
            // InternalBot.g:1800:5: ruleEString
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
    // InternalBot.g:1822:1: entryRuleHTTPRequestToken returns [EObject current=null] : iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF ;
    public final EObject entryRuleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequestToken = null;


        try {
            // InternalBot.g:1822:57: (iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF )
            // InternalBot.g:1823:2: iv_ruleHTTPRequestToken= ruleHTTPRequestToken EOF
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
    // InternalBot.g:1829:1: ruleHTTPRequestToken returns [EObject current=null] : (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) ;
    public final EObject ruleHTTPRequestToken() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_dataKey_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1835:2: ( (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? ) )
            // InternalBot.g:1836:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            {
            // InternalBot.g:1836:2: (otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )? )
            // InternalBot.g:1837:3: otherlv_0= 'request.' ( (lv_type_1_0= ruleHTTPReturnType ) ) (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestTokenAccess().getRequestKeyword_0());
            		
            // InternalBot.g:1841:3: ( (lv_type_1_0= ruleHTTPReturnType ) )
            // InternalBot.g:1842:4: (lv_type_1_0= ruleHTTPReturnType )
            {
            // InternalBot.g:1842:4: (lv_type_1_0= ruleHTTPReturnType )
            // InternalBot.g:1843:5: lv_type_1_0= ruleHTTPReturnType
            {

            					newCompositeNode(grammarAccess.getHTTPRequestTokenAccess().getTypeHTTPReturnTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_52);
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

            // InternalBot.g:1860:3: (otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalBot.g:1861:4: otherlv_2= '.' ( (lv_dataKey_3_0= ruleEString ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getHTTPRequestTokenAccess().getFullStopKeyword_2_0());
                    			
                    // InternalBot.g:1865:4: ( (lv_dataKey_3_0= ruleEString ) )
                    // InternalBot.g:1866:5: (lv_dataKey_3_0= ruleEString )
                    {
                    // InternalBot.g:1866:5: (lv_dataKey_3_0= ruleEString )
                    // InternalBot.g:1867:6: lv_dataKey_3_0= ruleEString
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
    // InternalBot.g:1889:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // InternalBot.g:1889:47: (iv_ruleEntity= ruleEntity EOF )
            // InternalBot.g:1890:2: iv_ruleEntity= ruleEntity EOF
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
    // InternalBot.g:1896:1: ruleEntity returns [EObject current=null] : (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleEntity_0 = null;

        EObject this_ComplexEntity_1 = null;

        EObject this_RegexEntity_2 = null;



        	enterRule();

        try {
            // InternalBot.g:1902:2: ( (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity ) )
            // InternalBot.g:1903:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
            {
            // InternalBot.g:1903:2: (this_SimpleEntity_0= ruleSimpleEntity | this_ComplexEntity_1= ruleComplexEntity | this_RegexEntity_2= ruleRegexEntity )
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
                    // InternalBot.g:1904:3: this_SimpleEntity_0= ruleSimpleEntity
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
                    // InternalBot.g:1913:3: this_ComplexEntity_1= ruleComplexEntity
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
                    // InternalBot.g:1922:3: this_RegexEntity_2= ruleRegexEntity
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
    // InternalBot.g:1934:1: entryRuleSimpleEntity returns [EObject current=null] : iv_ruleSimpleEntity= ruleSimpleEntity EOF ;
    public final EObject entryRuleSimpleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleEntity = null;


        try {
            // InternalBot.g:1934:53: (iv_ruleSimpleEntity= ruleSimpleEntity EOF )
            // InternalBot.g:1935:2: iv_ruleSimpleEntity= ruleSimpleEntity EOF
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
    // InternalBot.g:1941:1: ruleSimpleEntity returns [EObject current=null] : (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageEntity ) )+ ) ;
    public final EObject ruleSimpleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:1947:2: ( (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageEntity ) )+ ) )
            // InternalBot.g:1948:2: (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageEntity ) )+ )
            {
            // InternalBot.g:1948:2: (otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageEntity ) )+ )
            // InternalBot.g:1949:3: otherlv_0= 'Simple' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleSLanguageEntity ) )+
            {
            otherlv_0=(Token)match(input,43,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getSimpleEntityAccess().getSimpleKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSimpleEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:1957:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:1958:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:1958:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:1959:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_53); 

            			newLeafNode(otherlv_3, grammarAccess.getSimpleEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:1980:3: ( (lv_inputs_4_0= ruleSLanguageEntity ) )+
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
            	    // InternalBot.g:1981:4: (lv_inputs_4_0= ruleSLanguageEntity )
            	    {
            	    // InternalBot.g:1981:4: (lv_inputs_4_0= ruleSLanguageEntity )
            	    // InternalBot.g:1982:5: lv_inputs_4_0= ruleSLanguageEntity
            	    {

            	    					newCompositeNode(grammarAccess.getSimpleEntityAccess().getInputsSLanguageEntityParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_inputs_4_0=ruleSLanguageEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSimpleEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.SLanguageEntity");
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
    // InternalBot.g:2003:1: entryRuleComplexEntity returns [EObject current=null] : iv_ruleComplexEntity= ruleComplexEntity EOF ;
    public final EObject entryRuleComplexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexEntity = null;


        try {
            // InternalBot.g:2003:54: (iv_ruleComplexEntity= ruleComplexEntity EOF )
            // InternalBot.g:2004:2: iv_ruleComplexEntity= ruleComplexEntity EOF
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
    // InternalBot.g:2010:1: ruleComplexEntity returns [EObject current=null] : (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageEntity ) )+ ) ;
    public final EObject ruleComplexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2016:2: ( (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageEntity ) )+ ) )
            // InternalBot.g:2017:2: (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageEntity ) )+ )
            {
            // InternalBot.g:2017:2: (otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageEntity ) )+ )
            // InternalBot.g:2018:3: otherlv_0= 'Composite' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleCLanguageEntity ) )+
            {
            otherlv_0=(Token)match(input,44,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getComplexEntityAccess().getCompositeKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComplexEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:2026:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2027:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2027:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2028:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_53); 

            			newLeafNode(otherlv_3, grammarAccess.getComplexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:2049:3: ( (lv_inputs_4_0= ruleCLanguageEntity ) )+
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
            	    // InternalBot.g:2050:4: (lv_inputs_4_0= ruleCLanguageEntity )
            	    {
            	    // InternalBot.g:2050:4: (lv_inputs_4_0= ruleCLanguageEntity )
            	    // InternalBot.g:2051:5: lv_inputs_4_0= ruleCLanguageEntity
            	    {

            	    					newCompositeNode(grammarAccess.getComplexEntityAccess().getInputsCLanguageEntityParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_inputs_4_0=ruleCLanguageEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getComplexEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.CLanguageEntity");
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
    // InternalBot.g:2072:1: entryRuleRegexEntity returns [EObject current=null] : iv_ruleRegexEntity= ruleRegexEntity EOF ;
    public final EObject entryRuleRegexEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexEntity = null;


        try {
            // InternalBot.g:2072:52: (iv_ruleRegexEntity= ruleRegexEntity EOF )
            // InternalBot.g:2073:2: iv_ruleRegexEntity= ruleRegexEntity EOF
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
    // InternalBot.g:2079:1: ruleRegexEntity returns [EObject current=null] : (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageEntity ) )+ ) ;
    public final EObject ruleRegexEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2085:2: ( (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageEntity ) )+ ) )
            // InternalBot.g:2086:2: (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageEntity ) )+ )
            {
            // InternalBot.g:2086:2: (otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageEntity ) )+ )
            // InternalBot.g:2087:3: otherlv_0= 'Regex' otherlv_1= 'entity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleRLanguageEntity ) )+
            {
            otherlv_0=(Token)match(input,45,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getRegexEntityAccess().getRegexKeyword_0());
            		
            otherlv_1=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexEntityAccess().getEntityKeyword_1());
            		
            // InternalBot.g:2095:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2096:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2096:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2097:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_53); 

            			newLeafNode(otherlv_3, grammarAccess.getRegexEntityAccess().getColonKeyword_3());
            		
            // InternalBot.g:2118:3: ( (lv_inputs_4_0= ruleRLanguageEntity ) )+
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
            	    // InternalBot.g:2119:4: (lv_inputs_4_0= ruleRLanguageEntity )
            	    {
            	    // InternalBot.g:2119:4: (lv_inputs_4_0= ruleRLanguageEntity )
            	    // InternalBot.g:2120:5: lv_inputs_4_0= ruleRLanguageEntity
            	    {

            	    					newCompositeNode(grammarAccess.getRegexEntityAccess().getInputsRLanguageEntityParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_inputs_4_0=ruleRLanguageEntity();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRegexEntityRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_4_0,
            	    						"org.xtext.botGenerator.Bot.RLanguageEntity");
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


    // $ANTLR start "entryRuleSLanguageEntity"
    // InternalBot.g:2141:1: entryRuleSLanguageEntity returns [EObject current=null] : iv_ruleSLanguageEntity= ruleSLanguageEntity EOF ;
    public final EObject entryRuleSLanguageEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSLanguageEntity = null;


        try {
            // InternalBot.g:2141:56: (iv_ruleSLanguageEntity= ruleSLanguageEntity EOF )
            // InternalBot.g:2142:2: iv_ruleSLanguageEntity= ruleSLanguageEntity EOF
            {
             newCompositeNode(grammarAccess.getSLanguageEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSLanguageEntity=ruleSLanguageEntity();

            state._fsp--;

             current =iv_ruleSLanguageEntity; 
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
    // $ANTLR end "entryRuleSLanguageEntity"


    // $ANTLR start "ruleSLanguageEntity"
    // InternalBot.g:2148:1: ruleSLanguageEntity returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleSLanguageEntity() throws RecognitionException {
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
            // InternalBot.g:2154:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2155:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2155:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2156:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2156:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==23) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalBot.g:2157:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_55); 

                    				newLeafNode(otherlv_0, grammarAccess.getSLanguageEntityAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getSLanguageEntityAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2165:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2166:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2166:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2167:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getSLanguageEntityAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSLanguageEntityRule());
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

            			newLeafNode(otherlv_3, grammarAccess.getSLanguageEntityAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2189:3: ( ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )* )
            // InternalBot.g:2190:4: ( (lv_inputs_4_0= ruleSimpleInput ) ) ( (lv_inputs_5_0= ruleSimpleInput ) )*
            {
            // InternalBot.g:2190:4: ( (lv_inputs_4_0= ruleSimpleInput ) )
            // InternalBot.g:2191:5: (lv_inputs_4_0= ruleSimpleInput )
            {
            // InternalBot.g:2191:5: (lv_inputs_4_0= ruleSimpleInput )
            // InternalBot.g:2192:6: lv_inputs_4_0= ruleSimpleInput
            {

            						newCompositeNode(grammarAccess.getSLanguageEntityAccess().getInputsSimpleInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_56);
            lv_inputs_4_0=ruleSimpleInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getSLanguageEntityRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.SimpleInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:2209:4: ( (lv_inputs_5_0= ruleSimpleInput ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=RULE_STRING && LA50_0<=RULE_ID)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalBot.g:2210:5: (lv_inputs_5_0= ruleSimpleInput )
            	    {
            	    // InternalBot.g:2210:5: (lv_inputs_5_0= ruleSimpleInput )
            	    // InternalBot.g:2211:6: lv_inputs_5_0= ruleSimpleInput
            	    {

            	    						newCompositeNode(grammarAccess.getSLanguageEntityAccess().getInputsSimpleInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_56);
            	    lv_inputs_5_0=ruleSimpleInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSLanguageEntityRule());
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

            			newLeafNode(otherlv_6, grammarAccess.getSLanguageEntityAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleSLanguageEntity"


    // $ANTLR start "entryRuleCLanguageEntity"
    // InternalBot.g:2237:1: entryRuleCLanguageEntity returns [EObject current=null] : iv_ruleCLanguageEntity= ruleCLanguageEntity EOF ;
    public final EObject entryRuleCLanguageEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCLanguageEntity = null;


        try {
            // InternalBot.g:2237:56: (iv_ruleCLanguageEntity= ruleCLanguageEntity EOF )
            // InternalBot.g:2238:2: iv_ruleCLanguageEntity= ruleCLanguageEntity EOF
            {
             newCompositeNode(grammarAccess.getCLanguageEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCLanguageEntity=ruleCLanguageEntity();

            state._fsp--;

             current =iv_ruleCLanguageEntity; 
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
    // $ANTLR end "entryRuleCLanguageEntity"


    // $ANTLR start "ruleCLanguageEntity"
    // InternalBot.g:2244:1: ruleCLanguageEntity returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleCLanguageEntity() throws RecognitionException {
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
            // InternalBot.g:2250:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2251:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2251:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2252:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2252:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==23) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalBot.g:2253:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_55); 

                    				newLeafNode(otherlv_0, grammarAccess.getCLanguageEntityAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getCLanguageEntityAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2261:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2262:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2262:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2263:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getCLanguageEntityAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCLanguageEntityRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_57); 

            			newLeafNode(otherlv_3, grammarAccess.getCLanguageEntityAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2285:3: ( ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )* )
            // InternalBot.g:2286:4: ( (lv_inputs_4_0= ruleCompositeInput ) ) ( (lv_inputs_5_0= ruleCompositeInput ) )*
            {
            // InternalBot.g:2286:4: ( (lv_inputs_4_0= ruleCompositeInput ) )
            // InternalBot.g:2287:5: (lv_inputs_4_0= ruleCompositeInput )
            {
            // InternalBot.g:2287:5: (lv_inputs_4_0= ruleCompositeInput )
            // InternalBot.g:2288:6: lv_inputs_4_0= ruleCompositeInput
            {

            						newCompositeNode(grammarAccess.getCLanguageEntityAccess().getInputsCompositeInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_58);
            lv_inputs_4_0=ruleCompositeInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getCLanguageEntityRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.CompositeInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:2305:4: ( (lv_inputs_5_0= ruleCompositeInput ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==47) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalBot.g:2306:5: (lv_inputs_5_0= ruleCompositeInput )
            	    {
            	    // InternalBot.g:2306:5: (lv_inputs_5_0= ruleCompositeInput )
            	    // InternalBot.g:2307:6: lv_inputs_5_0= ruleCompositeInput
            	    {

            	    						newCompositeNode(grammarAccess.getCLanguageEntityAccess().getInputsCompositeInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_58);
            	    lv_inputs_5_0=ruleCompositeInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getCLanguageEntityRule());
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

            			newLeafNode(otherlv_6, grammarAccess.getCLanguageEntityAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleCLanguageEntity"


    // $ANTLR start "entryRuleRLanguageEntity"
    // InternalBot.g:2333:1: entryRuleRLanguageEntity returns [EObject current=null] : iv_ruleRLanguageEntity= ruleRLanguageEntity EOF ;
    public final EObject entryRuleRLanguageEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRLanguageEntity = null;


        try {
            // InternalBot.g:2333:56: (iv_ruleRLanguageEntity= ruleRLanguageEntity EOF )
            // InternalBot.g:2334:2: iv_ruleRLanguageEntity= ruleRLanguageEntity EOF
            {
             newCompositeNode(grammarAccess.getRLanguageEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRLanguageEntity=ruleRLanguageEntity();

            state._fsp--;

             current =iv_ruleRLanguageEntity; 
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
    // $ANTLR end "entryRuleRLanguageEntity"


    // $ANTLR start "ruleRLanguageEntity"
    // InternalBot.g:2340:1: ruleRLanguageEntity returns [EObject current=null] : ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) ;
    public final EObject ruleRLanguageEntity() throws RecognitionException {
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
            // InternalBot.g:2346:2: ( ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' ) )
            // InternalBot.g:2347:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            {
            // InternalBot.g:2347:2: ( (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}' )
            // InternalBot.g:2348:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* ) otherlv_6= '}'
            {
            // InternalBot.g:2348:3: (otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==23) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalBot.g:2349:4: otherlv_0= 'inputs' otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_55); 

                    				newLeafNode(otherlv_0, grammarAccess.getRLanguageEntityAccess().getInputsKeyword_0_0());
                    			
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getRLanguageEntityAccess().getInKeyword_0_1());
                    			
                    // InternalBot.g:2357:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:2358:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:2358:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:2359:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getRLanguageEntityAccess().getLanguageLanguageEnumRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRLanguageEntityRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_59); 

            			newLeafNode(otherlv_3, grammarAccess.getRLanguageEntityAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2381:3: ( ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )* )
            // InternalBot.g:2382:4: ( (lv_inputs_4_0= ruleRegexInput ) ) ( (lv_inputs_5_0= ruleRegexInput ) )*
            {
            // InternalBot.g:2382:4: ( (lv_inputs_4_0= ruleRegexInput ) )
            // InternalBot.g:2383:5: (lv_inputs_4_0= ruleRegexInput )
            {
            // InternalBot.g:2383:5: (lv_inputs_4_0= ruleRegexInput )
            // InternalBot.g:2384:6: lv_inputs_4_0= ruleRegexInput
            {

            						newCompositeNode(grammarAccess.getRLanguageEntityAccess().getInputsRegexInputParserRuleCall_2_0_0());
            					
            pushFollow(FOLLOW_60);
            lv_inputs_4_0=ruleRegexInput();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getRLanguageEntityRule());
            						}
            						add(
            							current,
            							"inputs",
            							lv_inputs_4_0,
            							"org.xtext.botGenerator.Bot.RegexInput");
            						afterParserOrEnumRuleCall();
            					

            }


            }

            // InternalBot.g:2401:4: ( (lv_inputs_5_0= ruleRegexInput ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==46) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalBot.g:2402:5: (lv_inputs_5_0= ruleRegexInput )
            	    {
            	    // InternalBot.g:2402:5: (lv_inputs_5_0= ruleRegexInput )
            	    // InternalBot.g:2403:6: lv_inputs_5_0= ruleRegexInput
            	    {

            	    						newCompositeNode(grammarAccess.getRLanguageEntityAccess().getInputsRegexInputParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_60);
            	    lv_inputs_5_0=ruleRegexInput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRLanguageEntityRule());
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

            			newLeafNode(otherlv_6, grammarAccess.getRLanguageEntityAccess().getRightCurlyBracketKeyword_3());
            		

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
    // $ANTLR end "ruleRLanguageEntity"


    // $ANTLR start "entryRuleRegexInput"
    // InternalBot.g:2429:1: entryRuleRegexInput returns [EObject current=null] : iv_ruleRegexInput= ruleRegexInput EOF ;
    public final EObject entryRuleRegexInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegexInput = null;


        try {
            // InternalBot.g:2429:51: (iv_ruleRegexInput= ruleRegexInput EOF )
            // InternalBot.g:2430:2: iv_ruleRegexInput= ruleRegexInput EOF
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
    // InternalBot.g:2436:1: ruleRegexInput returns [EObject current=null] : ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) ;
    public final EObject ruleRegexInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2442:2: ( ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) ) )
            // InternalBot.g:2443:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            {
            // InternalBot.g:2443:2: ( () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) ) )
            // InternalBot.g:2444:3: () otherlv_1= 'pattern' otherlv_2= ':' ( (lv_expresion_3_0= ruleEString ) )
            {
            // InternalBot.g:2444:3: ()
            // InternalBot.g:2445:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRegexInputAccess().getRegexInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,46,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getRegexInputAccess().getPatternKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getRegexInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2459:3: ( (lv_expresion_3_0= ruleEString ) )
            // InternalBot.g:2460:4: (lv_expresion_3_0= ruleEString )
            {
            // InternalBot.g:2460:4: (lv_expresion_3_0= ruleEString )
            // InternalBot.g:2461:5: lv_expresion_3_0= ruleEString
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
    // InternalBot.g:2482:1: entryRuleCompositeInput returns [EObject current=null] : iv_ruleCompositeInput= ruleCompositeInput EOF ;
    public final EObject entryRuleCompositeInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeInput = null;


        try {
            // InternalBot.g:2482:55: (iv_ruleCompositeInput= ruleCompositeInput EOF )
            // InternalBot.g:2483:2: iv_ruleCompositeInput= ruleCompositeInput EOF
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
    // InternalBot.g:2489:1: ruleCompositeInput returns [EObject current=null] : ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) ;
    public final EObject ruleCompositeInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expresion_3_1 = null;

        EObject lv_expresion_3_2 = null;



        	enterRule();

        try {
            // InternalBot.g:2495:2: ( ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ ) )
            // InternalBot.g:2496:2: ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            {
            // InternalBot.g:2496:2: ( () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+ )
            // InternalBot.g:2497:3: () otherlv_1= 'composite' otherlv_2= ':' ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
            {
            // InternalBot.g:2497:3: ()
            // InternalBot.g:2498:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCompositeInputAccess().getCompositeInputAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,47,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getCompositeInputAccess().getCompositeKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_61); 

            			newLeafNode(otherlv_2, grammarAccess.getCompositeInputAccess().getColonKeyword_2());
            		
            // InternalBot.g:2512:3: ( ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) ) )+
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
            	    // InternalBot.g:2513:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    {
            	    // InternalBot.g:2513:4: ( (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken ) )
            	    // InternalBot.g:2514:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
            	    {
            	    // InternalBot.g:2514:5: (lv_expresion_3_1= ruleLiteral | lv_expresion_3_2= ruleEntityToken )
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
            	            // InternalBot.g:2515:6: lv_expresion_3_1= ruleLiteral
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionLiteralParserRuleCall_3_0_0());
            	            					
            	            pushFollow(FOLLOW_62);
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
            	            // InternalBot.g:2531:6: lv_expresion_3_2= ruleEntityToken
            	            {

            	            						newCompositeNode(grammarAccess.getCompositeInputAccess().getExpresionEntityTokenParserRuleCall_3_0_1());
            	            					
            	            pushFollow(FOLLOW_62);
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
    // InternalBot.g:2553:1: entryRuleSimpleInput returns [EObject current=null] : iv_ruleSimpleInput= ruleSimpleInput EOF ;
    public final EObject entryRuleSimpleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleInput = null;


        try {
            // InternalBot.g:2553:52: (iv_ruleSimpleInput= ruleSimpleInput EOF )
            // InternalBot.g:2554:2: iv_ruleSimpleInput= ruleSimpleInput EOF
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
    // InternalBot.g:2560:1: ruleSimpleInput returns [EObject current=null] : ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) ;
    public final EObject ruleSimpleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_values_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:2566:2: ( ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? ) )
            // InternalBot.g:2567:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            {
            // InternalBot.g:2567:2: ( () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )? )
            // InternalBot.g:2568:3: () ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            {
            // InternalBot.g:2568:3: ()
            // InternalBot.g:2569:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSimpleInputAccess().getSimpleInputAction_0(),
            					current);
            			

            }

            // InternalBot.g:2575:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2576:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2576:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2577:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSimpleInputAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_63);
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

            // InternalBot.g:2594:3: (otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==48) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalBot.g:2595:4: otherlv_2= 'synonyms' ( (lv_values_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    {
                    otherlv_2=(Token)match(input,48,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getSimpleInputAccess().getSynonymsKeyword_2_0());
                    			
                    // InternalBot.g:2599:4: ( (lv_values_3_0= ruleEString ) )
                    // InternalBot.g:2600:5: (lv_values_3_0= ruleEString )
                    {
                    // InternalBot.g:2600:5: (lv_values_3_0= ruleEString )
                    // InternalBot.g:2601:6: lv_values_3_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_64);
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

                    // InternalBot.g:2618:4: (otherlv_4= ',' ( (lv_values_5_0= ruleEString ) ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==14) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // InternalBot.g:2619:5: otherlv_4= ',' ( (lv_values_5_0= ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getSimpleInputAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalBot.g:2623:5: ( (lv_values_5_0= ruleEString ) )
                    	    // InternalBot.g:2624:6: (lv_values_5_0= ruleEString )
                    	    {
                    	    // InternalBot.g:2624:6: (lv_values_5_0= ruleEString )
                    	    // InternalBot.g:2625:7: lv_values_5_0= ruleEString
                    	    {

                    	    							newCompositeNode(grammarAccess.getSimpleInputAccess().getValuesEStringParserRuleCall_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_64);
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
    // InternalBot.g:2648:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalBot.g:2648:45: (iv_ruleText= ruleText EOF )
            // InternalBot.g:2649:2: iv_ruleText= ruleText EOF
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
    // InternalBot.g:2655:1: ruleText returns [EObject current=null] : ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleLanguageText ) )+ ) ;
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
            // InternalBot.g:2661:2: ( ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleLanguageText ) )+ ) )
            // InternalBot.g:2662:2: ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleLanguageText ) )+ )
            {
            // InternalBot.g:2662:2: ( (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleLanguageText ) )+ )
            // InternalBot.g:2663:3: (otherlv_0= 'Text' | otherlv_1= 'text' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' ( (lv_inputs_5_0= ruleLanguageText ) )+
            {
            // InternalBot.g:2663:3: (otherlv_0= 'Text' | otherlv_1= 'text' )
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
                    // InternalBot.g:2664:4: otherlv_0= 'Text'
                    {
                    otherlv_0=(Token)match(input,49,FOLLOW_65); 

                    				newLeafNode(otherlv_0, grammarAccess.getTextAccess().getTextKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalBot.g:2669:4: otherlv_1= 'text'
                    {
                    otherlv_1=(Token)match(input,50,FOLLOW_65); 

                    				newLeafNode(otherlv_1, grammarAccess.getTextAccess().getTextKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getTextAccess().getResponseKeyword_1());
            		
            // InternalBot.g:2678:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:2679:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:2679:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:2680:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,13,FOLLOW_53); 

            			newLeafNode(otherlv_4, grammarAccess.getTextAccess().getColonKeyword_3());
            		
            // InternalBot.g:2701:3: ( (lv_inputs_5_0= ruleLanguageText ) )+
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
            	    // InternalBot.g:2702:4: (lv_inputs_5_0= ruleLanguageText )
            	    {
            	    // InternalBot.g:2702:4: (lv_inputs_5_0= ruleLanguageText )
            	    // InternalBot.g:2703:5: lv_inputs_5_0= ruleLanguageText
            	    {

            	    					newCompositeNode(grammarAccess.getTextAccess().getInputsLanguageTextParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_54);
            	    lv_inputs_5_0=ruleLanguageText();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_5_0,
            	    						"org.xtext.botGenerator.Bot.LanguageText");
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


    // $ANTLR start "entryRuleLanguageText"
    // InternalBot.g:2724:1: entryRuleLanguageText returns [EObject current=null] : iv_ruleLanguageText= ruleLanguageText EOF ;
    public final EObject entryRuleLanguageText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageText = null;


        try {
            // InternalBot.g:2724:53: (iv_ruleLanguageText= ruleLanguageText EOF )
            // InternalBot.g:2725:2: iv_ruleLanguageText= ruleLanguageText EOF
            {
             newCompositeNode(grammarAccess.getLanguageTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguageText=ruleLanguageText();

            state._fsp--;

             current =iv_ruleLanguageText; 
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
    // $ANTLR end "entryRuleLanguageText"


    // $ANTLR start "ruleLanguageText"
    // InternalBot.g:2731:1: ruleLanguageText returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleLanguageText() throws RecognitionException {
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
            // InternalBot.g:2737:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:2738:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:2738:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}' )
            // InternalBot.g:2739:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputText ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )* otherlv_7= '}'
            {
            // InternalBot.g:2739:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==23) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalBot.g:2740:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getLanguageTextAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:2744:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==24) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalBot.g:2745:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_6); 

                            					newLeafNode(otherlv_1, grammarAccess.getLanguageTextAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:2749:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:2750:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:2750:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:2751:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getLanguageTextAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_language_2_0=ruleLanguage();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getLanguageTextRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_66); 

            			newLeafNode(otherlv_3, grammarAccess.getLanguageTextAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:2774:3: ( (lv_inputs_4_0= ruleTextInputText ) )
            // InternalBot.g:2775:4: (lv_inputs_4_0= ruleTextInputText )
            {
            // InternalBot.g:2775:4: (lv_inputs_4_0= ruleTextInputText )
            // InternalBot.g:2776:5: lv_inputs_4_0= ruleTextInputText
            {

            					newCompositeNode(grammarAccess.getLanguageTextAccess().getInputsTextInputTextParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTextInputText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLanguageTextRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TextInputText");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:2793:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==14) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalBot.g:2794:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputText ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_66); 

            	    				newLeafNode(otherlv_5, grammarAccess.getLanguageTextAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalBot.g:2798:4: ( (lv_inputs_6_0= ruleTextInputText ) )
            	    // InternalBot.g:2799:5: (lv_inputs_6_0= ruleTextInputText )
            	    {
            	    // InternalBot.g:2799:5: (lv_inputs_6_0= ruleTextInputText )
            	    // InternalBot.g:2800:6: lv_inputs_6_0= ruleTextInputText
            	    {

            	    						newCompositeNode(grammarAccess.getLanguageTextAccess().getInputsTextInputTextParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTextInputText();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLanguageTextRule());
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

            			newLeafNode(otherlv_7, grammarAccess.getLanguageTextAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleLanguageText"


    // $ANTLR start "entryRuleHTTPResponse"
    // InternalBot.g:2826:1: entryRuleHTTPResponse returns [EObject current=null] : iv_ruleHTTPResponse= ruleHTTPResponse EOF ;
    public final EObject entryRuleHTTPResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPResponse = null;


        try {
            // InternalBot.g:2826:53: (iv_ruleHTTPResponse= ruleHTTPResponse EOF )
            // InternalBot.g:2827:2: iv_ruleHTTPResponse= ruleHTTPResponse EOF
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
    // InternalBot.g:2833:1: ruleHTTPResponse returns [EObject current=null] : (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleLanguageTextHttpResponse ) )+ ) ;
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
            // InternalBot.g:2839:2: ( (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleLanguageTextHttpResponse ) )+ ) )
            // InternalBot.g:2840:2: (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleLanguageTextHttpResponse ) )+ )
            {
            // InternalBot.g:2840:2: (otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleLanguageTextHttpResponse ) )+ )
            // InternalBot.g:2841:3: otherlv_0= 'Response' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' otherlv_3= 'Request' otherlv_4= ':' ( ( ruleEString ) ) otherlv_6= ';' ( (lv_inputs_7_0= ruleLanguageTextHttpResponse ) )+
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPResponseAccess().getResponseKeyword_0());
            		
            // InternalBot.g:2845:3: ( (lv_name_1_0= ruleEString ) )
            // InternalBot.g:2846:4: (lv_name_1_0= ruleEString )
            {
            // InternalBot.g:2846:4: (lv_name_1_0= ruleEString )
            // InternalBot.g:2847:5: lv_name_1_0= ruleEString
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

            otherlv_2=(Token)match(input,13,FOLLOW_67); 

            			newLeafNode(otherlv_2, grammarAccess.getHTTPResponseAccess().getColonKeyword_2());
            		
            otherlv_3=(Token)match(input,53,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPResponseAccess().getRequestKeyword_3());
            		
            otherlv_4=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPResponseAccess().getColonKeyword_4());
            		
            // InternalBot.g:2876:3: ( ( ruleEString ) )
            // InternalBot.g:2877:4: ( ruleEString )
            {
            // InternalBot.g:2877:4: ( ruleEString )
            // InternalBot.g:2878:5: ruleEString
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

            otherlv_6=(Token)match(input,20,FOLLOW_68); 

            			newLeafNode(otherlv_6, grammarAccess.getHTTPResponseAccess().getSemicolonKeyword_6());
            		
            // InternalBot.g:2896:3: ( (lv_inputs_7_0= ruleLanguageTextHttpResponse ) )+
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
            	    // InternalBot.g:2897:4: (lv_inputs_7_0= ruleLanguageTextHttpResponse )
            	    {
            	    // InternalBot.g:2897:4: (lv_inputs_7_0= ruleLanguageTextHttpResponse )
            	    // InternalBot.g:2898:5: lv_inputs_7_0= ruleLanguageTextHttpResponse
            	    {

            	    					newCompositeNode(grammarAccess.getHTTPResponseAccess().getInputsLanguageTextHttpResponseParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_69);
            	    lv_inputs_7_0=ruleLanguageTextHttpResponse();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getHTTPResponseRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inputs",
            	    						lv_inputs_7_0,
            	    						"org.xtext.botGenerator.Bot.LanguageTextHttpResponse");
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
    // InternalBot.g:2919:1: entryRuleHTTPRequest returns [EObject current=null] : iv_ruleHTTPRequest= ruleHTTPRequest EOF ;
    public final EObject entryRuleHTTPRequest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTPRequest = null;


        try {
            // InternalBot.g:2919:52: (iv_ruleHTTPRequest= ruleHTTPRequest EOF )
            // InternalBot.g:2920:2: iv_ruleHTTPRequest= ruleHTTPRequest EOF
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
    // InternalBot.g:2926:1: ruleHTTPRequest returns [EObject current=null] : (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? ) ;
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
            // InternalBot.g:2932:2: ( (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? ) )
            // InternalBot.g:2933:2: (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? )
            {
            // InternalBot.g:2933:2: (otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )? )
            // InternalBot.g:2934:3: otherlv_0= 'Request' ( (lv_method_1_0= ruleMethod ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' otherlv_4= 'URL' otherlv_5= ':' ( (lv_URL_6_0= ruleEString ) ) otherlv_7= ';' (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )? (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )? (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getHTTPRequestAccess().getRequestKeyword_0());
            		
            // InternalBot.g:2938:3: ( (lv_method_1_0= ruleMethod ) )
            // InternalBot.g:2939:4: (lv_method_1_0= ruleMethod )
            {
            // InternalBot.g:2939:4: (lv_method_1_0= ruleMethod )
            // InternalBot.g:2940:5: lv_method_1_0= ruleMethod
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

            // InternalBot.g:2957:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:2958:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:2958:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:2959:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_71); 

            			newLeafNode(otherlv_3, grammarAccess.getHTTPRequestAccess().getColonKeyword_3());
            		
            otherlv_4=(Token)match(input,54,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getHTTPRequestAccess().getURLKeyword_4());
            		
            otherlv_5=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getHTTPRequestAccess().getColonKeyword_5());
            		
            // InternalBot.g:2988:3: ( (lv_URL_6_0= ruleEString ) )
            // InternalBot.g:2989:4: (lv_URL_6_0= ruleEString )
            {
            // InternalBot.g:2989:4: (lv_URL_6_0= ruleEString )
            // InternalBot.g:2990:5: lv_URL_6_0= ruleEString
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

            otherlv_7=(Token)match(input,20,FOLLOW_72); 

            			newLeafNode(otherlv_7, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_7());
            		
            // InternalBot.g:3011:3: (otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==55) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalBot.g:3012:4: otherlv_8= 'basicAuth' otherlv_9= ':' ( (lv_basicAuth_10_0= ruleKeyValue ) ) otherlv_11= ';'
                    {
                    otherlv_8=(Token)match(input,55,FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getHTTPRequestAccess().getBasicAuthKeyword_8_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getHTTPRequestAccess().getColonKeyword_8_1());
                    			
                    // InternalBot.g:3020:4: ( (lv_basicAuth_10_0= ruleKeyValue ) )
                    // InternalBot.g:3021:5: (lv_basicAuth_10_0= ruleKeyValue )
                    {
                    // InternalBot.g:3021:5: (lv_basicAuth_10_0= ruleKeyValue )
                    // InternalBot.g:3022:6: lv_basicAuth_10_0= ruleKeyValue
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

                    otherlv_11=(Token)match(input,20,FOLLOW_73); 

                    				newLeafNode(otherlv_11, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_8_3());
                    			

                    }
                    break;

            }

            // InternalBot.g:3044:3: (otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==56) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalBot.g:3045:4: otherlv_12= 'headers' otherlv_13= ':' ( (lv_headers_14_0= ruleKeyValue ) ) (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )* otherlv_17= ';'
                    {
                    otherlv_12=(Token)match(input,56,FOLLOW_5); 

                    				newLeafNode(otherlv_12, grammarAccess.getHTTPRequestAccess().getHeadersKeyword_9_0());
                    			
                    otherlv_13=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_13, grammarAccess.getHTTPRequestAccess().getColonKeyword_9_1());
                    			
                    // InternalBot.g:3053:4: ( (lv_headers_14_0= ruleKeyValue ) )
                    // InternalBot.g:3054:5: (lv_headers_14_0= ruleKeyValue )
                    {
                    // InternalBot.g:3054:5: (lv_headers_14_0= ruleKeyValue )
                    // InternalBot.g:3055:6: lv_headers_14_0= ruleKeyValue
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

                    // InternalBot.g:3072:4: (otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) ) )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==14) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalBot.g:3073:5: otherlv_15= ',' ( (lv_headers_16_0= ruleKeyValue ) )
                    	    {
                    	    otherlv_15=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_15, grammarAccess.getHTTPRequestAccess().getCommaKeyword_9_3_0());
                    	    				
                    	    // InternalBot.g:3077:5: ( (lv_headers_16_0= ruleKeyValue ) )
                    	    // InternalBot.g:3078:6: (lv_headers_16_0= ruleKeyValue )
                    	    {
                    	    // InternalBot.g:3078:6: (lv_headers_16_0= ruleKeyValue )
                    	    // InternalBot.g:3079:7: lv_headers_16_0= ruleKeyValue
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

                    otherlv_17=(Token)match(input,20,FOLLOW_74); 

                    				newLeafNode(otherlv_17, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_9_4());
                    			

                    }
                    break;

            }

            // InternalBot.g:3102:3: (otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==57) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalBot.g:3103:4: otherlv_18= 'data' otherlv_19= ':' ( (lv_data_20_0= ruleData ) ) (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )* otherlv_23= ';' otherlv_24= 'dataType' otherlv_25= ':' ( (lv_dataType_26_0= ruleDataType ) ) otherlv_27= ';'
                    {
                    otherlv_18=(Token)match(input,57,FOLLOW_5); 

                    				newLeafNode(otherlv_18, grammarAccess.getHTTPRequestAccess().getDataKeyword_10_0());
                    			
                    otherlv_19=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_19, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_1());
                    			
                    // InternalBot.g:3111:4: ( (lv_data_20_0= ruleData ) )
                    // InternalBot.g:3112:5: (lv_data_20_0= ruleData )
                    {
                    // InternalBot.g:3112:5: (lv_data_20_0= ruleData )
                    // InternalBot.g:3113:6: lv_data_20_0= ruleData
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

                    // InternalBot.g:3130:4: (otherlv_21= ',' ( (lv_data_22_0= ruleData ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==14) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalBot.g:3131:5: otherlv_21= ',' ( (lv_data_22_0= ruleData ) )
                    	    {
                    	    otherlv_21=(Token)match(input,14,FOLLOW_3); 

                    	    					newLeafNode(otherlv_21, grammarAccess.getHTTPRequestAccess().getCommaKeyword_10_3_0());
                    	    				
                    	    // InternalBot.g:3135:5: ( (lv_data_22_0= ruleData ) )
                    	    // InternalBot.g:3136:6: (lv_data_22_0= ruleData )
                    	    {
                    	    // InternalBot.g:3136:6: (lv_data_22_0= ruleData )
                    	    // InternalBot.g:3137:7: lv_data_22_0= ruleData
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

                    otherlv_23=(Token)match(input,20,FOLLOW_75); 

                    				newLeafNode(otherlv_23, grammarAccess.getHTTPRequestAccess().getSemicolonKeyword_10_4());
                    			
                    otherlv_24=(Token)match(input,58,FOLLOW_5); 

                    				newLeafNode(otherlv_24, grammarAccess.getHTTPRequestAccess().getDataTypeKeyword_10_5());
                    			
                    otherlv_25=(Token)match(input,13,FOLLOW_76); 

                    				newLeafNode(otherlv_25, grammarAccess.getHTTPRequestAccess().getColonKeyword_10_6());
                    			
                    // InternalBot.g:3167:4: ( (lv_dataType_26_0= ruleDataType ) )
                    // InternalBot.g:3168:5: (lv_dataType_26_0= ruleDataType )
                    {
                    // InternalBot.g:3168:5: (lv_dataType_26_0= ruleDataType )
                    // InternalBot.g:3169:6: lv_dataType_26_0= ruleDataType
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
    // InternalBot.g:3195:1: entryRuleImage returns [EObject current=null] : iv_ruleImage= ruleImage EOF ;
    public final EObject entryRuleImage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImage = null;


        try {
            // InternalBot.g:3195:46: (iv_ruleImage= ruleImage EOF )
            // InternalBot.g:3196:2: iv_ruleImage= ruleImage EOF
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
    // InternalBot.g:3202:1: ruleImage returns [EObject current=null] : ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? ) ;
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
            // InternalBot.g:3208:2: ( ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? ) )
            // InternalBot.g:3209:2: ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? )
            {
            // InternalBot.g:3209:2: ( (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )? )
            // InternalBot.g:3210:3: (otherlv_0= 'Image' | otherlv_1= 'mage' ) otherlv_2= 'response' ( (lv_name_3_0= ruleEString ) ) otherlv_4= ':' otherlv_5= 'URL' otherlv_6= ':' ( (lv_URL_7_0= ruleEString ) ) (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )?
            {
            // InternalBot.g:3210:3: (otherlv_0= 'Image' | otherlv_1= 'mage' )
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
                    // InternalBot.g:3211:4: otherlv_0= 'Image'
                    {
                    otherlv_0=(Token)match(input,59,FOLLOW_65); 

                    				newLeafNode(otherlv_0, grammarAccess.getImageAccess().getImageKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalBot.g:3216:4: otherlv_1= 'mage'
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_65); 

                    				newLeafNode(otherlv_1, grammarAccess.getImageAccess().getMageKeyword_0_1());
                    			

                    }
                    break;

            }

            otherlv_2=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getImageAccess().getResponseKeyword_1());
            		
            // InternalBot.g:3225:3: ( (lv_name_3_0= ruleEString ) )
            // InternalBot.g:3226:4: (lv_name_3_0= ruleEString )
            {
            // InternalBot.g:3226:4: (lv_name_3_0= ruleEString )
            // InternalBot.g:3227:5: lv_name_3_0= ruleEString
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

            otherlv_4=(Token)match(input,13,FOLLOW_71); 

            			newLeafNode(otherlv_4, grammarAccess.getImageAccess().getColonKeyword_3());
            		
            otherlv_5=(Token)match(input,54,FOLLOW_5); 

            			newLeafNode(otherlv_5, grammarAccess.getImageAccess().getURLKeyword_4());
            		
            otherlv_6=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getImageAccess().getColonKeyword_5());
            		
            // InternalBot.g:3256:3: ( (lv_URL_7_0= ruleEString ) )
            // InternalBot.g:3257:4: (lv_URL_7_0= ruleEString )
            {
            // InternalBot.g:3257:4: (lv_URL_7_0= ruleEString )
            // InternalBot.g:3258:5: lv_URL_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImageAccess().getURLEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_77);
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

            // InternalBot.g:3275:3: (otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==61) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalBot.g:3276:4: otherlv_8= 'caption' otherlv_9= ':' ( (lv_caption_10_0= ruleEString ) )
                    {
                    otherlv_8=(Token)match(input,61,FOLLOW_5); 

                    				newLeafNode(otherlv_8, grammarAccess.getImageAccess().getCaptionKeyword_7_0());
                    			
                    otherlv_9=(Token)match(input,13,FOLLOW_3); 

                    				newLeafNode(otherlv_9, grammarAccess.getImageAccess().getColonKeyword_7_1());
                    			
                    // InternalBot.g:3284:4: ( (lv_caption_10_0= ruleEString ) )
                    // InternalBot.g:3285:5: (lv_caption_10_0= ruleEString )
                    {
                    // InternalBot.g:3285:5: (lv_caption_10_0= ruleEString )
                    // InternalBot.g:3286:6: lv_caption_10_0= ruleEString
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
    // InternalBot.g:3308:1: entryRuleEmpty returns [EObject current=null] : iv_ruleEmpty= ruleEmpty EOF ;
    public final EObject entryRuleEmpty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmpty = null;


        try {
            // InternalBot.g:3308:46: (iv_ruleEmpty= ruleEmpty EOF )
            // InternalBot.g:3309:2: iv_ruleEmpty= ruleEmpty EOF
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
    // InternalBot.g:3315:1: ruleEmpty returns [EObject current=null] : (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleEmpty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_5_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3321:2: ( (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}' )? ) )
            // InternalBot.g:3322:2: (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}' )? )
            {
            // InternalBot.g:3322:2: (otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}' )? )
            // InternalBot.g:3323:3: otherlv_0= 'Empty' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) (otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}' )?
            {
            otherlv_0=(Token)match(input,62,FOLLOW_65); 

            			newLeafNode(otherlv_0, grammarAccess.getEmptyAccess().getEmptyKeyword_0());
            		
            otherlv_1=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getEmptyAccess().getResponseKeyword_1());
            		
            // InternalBot.g:3331:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:3332:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:3332:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:3333:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getEmptyAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_78);
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

            // InternalBot.g:3350:3: (otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==25) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalBot.g:3351:4: otherlv_3= '{' otherlv_4= 'description:' ( (lv_description_5_0= ruleEString ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_79); 

                    				newLeafNode(otherlv_3, grammarAccess.getEmptyAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,63,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getEmptyAccess().getDescriptionKeyword_3_1());
                    			
                    // InternalBot.g:3359:4: ( (lv_description_5_0= ruleEString ) )
                    // InternalBot.g:3360:5: (lv_description_5_0= ruleEString )
                    {
                    // InternalBot.g:3360:5: (lv_description_5_0= ruleEString )
                    // InternalBot.g:3361:6: lv_description_5_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getEmptyAccess().getDescriptionEStringParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_80);
                    lv_description_5_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEmptyRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.xtext.botGenerator.Bot.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,26,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getEmptyAccess().getRightCurlyBracketKeyword_3_3());
                    			

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
    // $ANTLR end "ruleEmpty"


    // $ANTLR start "entryRuleButtonAction"
    // InternalBot.g:3387:1: entryRuleButtonAction returns [EObject current=null] : iv_ruleButtonAction= ruleButtonAction EOF ;
    public final EObject entryRuleButtonAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleButtonAction = null;


        try {
            // InternalBot.g:3387:53: (iv_ruleButtonAction= ruleButtonAction EOF )
            // InternalBot.g:3388:2: iv_ruleButtonAction= ruleButtonAction EOF
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
    // InternalBot.g:3394:1: ruleButtonAction returns [EObject current=null] : (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleLanguageButton ) ) ) ;
    public final EObject ruleButtonAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_inputs_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3400:2: ( (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleLanguageButton ) ) ) )
            // InternalBot.g:3401:2: (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleLanguageButton ) ) )
            {
            // InternalBot.g:3401:2: (otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleLanguageButton ) ) )
            // InternalBot.g:3402:3: otherlv_0= 'Button' otherlv_1= 'response' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_inputs_4_0= ruleLanguageButton ) )
            {
            otherlv_0=(Token)match(input,64,FOLLOW_65); 

            			newLeafNode(otherlv_0, grammarAccess.getButtonActionAccess().getButtonKeyword_0());
            		
            otherlv_1=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getButtonActionAccess().getResponseKeyword_1());
            		
            // InternalBot.g:3410:3: ( (lv_name_2_0= ruleEString ) )
            // InternalBot.g:3411:4: (lv_name_2_0= ruleEString )
            {
            // InternalBot.g:3411:4: (lv_name_2_0= ruleEString )
            // InternalBot.g:3412:5: lv_name_2_0= ruleEString
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

            otherlv_3=(Token)match(input,13,FOLLOW_53); 

            			newLeafNode(otherlv_3, grammarAccess.getButtonActionAccess().getColonKeyword_3());
            		
            // InternalBot.g:3433:3: ( (lv_inputs_4_0= ruleLanguageButton ) )
            // InternalBot.g:3434:4: (lv_inputs_4_0= ruleLanguageButton )
            {
            // InternalBot.g:3434:4: (lv_inputs_4_0= ruleLanguageButton )
            // InternalBot.g:3435:5: lv_inputs_4_0= ruleLanguageButton
            {

            					newCompositeNode(grammarAccess.getButtonActionAccess().getInputsLanguageButtonParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_inputs_4_0=ruleLanguageButton();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getButtonActionRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.LanguageButton");
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


    // $ANTLR start "entryRuleLanguageButton"
    // InternalBot.g:3456:1: entryRuleLanguageButton returns [EObject current=null] : iv_ruleLanguageButton= ruleLanguageButton EOF ;
    public final EObject entryRuleLanguageButton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageButton = null;


        try {
            // InternalBot.g:3456:55: (iv_ruleLanguageButton= ruleLanguageButton EOF )
            // InternalBot.g:3457:2: iv_ruleLanguageButton= ruleLanguageButton EOF
            {
             newCompositeNode(grammarAccess.getLanguageButtonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguageButton=ruleLanguageButton();

            state._fsp--;

             current =iv_ruleLanguageButton; 
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
    // $ANTLR end "entryRuleLanguageButton"


    // $ANTLR start "ruleLanguageButton"
    // InternalBot.g:3463:1: ruleLanguageButton returns [EObject current=null] : ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' (otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )? otherlv_10= 'buttons:' ( (lv_buttons_11_0= ruleButton ) )+ otherlv_12= '}' ) ;
    public final EObject ruleLanguageButton() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Enumerator lv_language_2_0 = null;

        EObject lv_inputs_6_0 = null;

        EObject lv_inputs_9_0 = null;

        EObject lv_buttons_11_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3469:2: ( ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' (otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )? otherlv_10= 'buttons:' ( (lv_buttons_11_0= ruleButton ) )+ otherlv_12= '}' ) )
            // InternalBot.g:3470:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' (otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )? otherlv_10= 'buttons:' ( (lv_buttons_11_0= ruleButton ) )+ otherlv_12= '}' )
            {
            // InternalBot.g:3470:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' (otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )? otherlv_10= 'buttons:' ( (lv_buttons_11_0= ruleButton ) )+ otherlv_12= '}' )
            // InternalBot.g:3471:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )? otherlv_3= '{' (otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )? otherlv_10= 'buttons:' ( (lv_buttons_11_0= ruleButton ) )+ otherlv_12= '}'
            {
            // InternalBot.g:3471:3: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==23) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalBot.g:3472:4: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    {
                    otherlv_0=(Token)match(input,23,FOLLOW_21); 

                    				newLeafNode(otherlv_0, grammarAccess.getLanguageButtonAccess().getInputsKeyword_0_0());
                    			
                    // InternalBot.g:3476:4: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==24) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // InternalBot.g:3477:5: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_6); 

                            					newLeafNode(otherlv_1, grammarAccess.getLanguageButtonAccess().getInKeyword_0_1_0());
                            				
                            // InternalBot.g:3481:5: ( (lv_language_2_0= ruleLanguage ) )
                            // InternalBot.g:3482:6: (lv_language_2_0= ruleLanguage )
                            {
                            // InternalBot.g:3482:6: (lv_language_2_0= ruleLanguage )
                            // InternalBot.g:3483:7: lv_language_2_0= ruleLanguage
                            {

                            							newCompositeNode(grammarAccess.getLanguageButtonAccess().getLanguageLanguageEnumRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_22);
                            lv_language_2_0=ruleLanguage();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getLanguageButtonRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_81); 

            			newLeafNode(otherlv_3, grammarAccess.getLanguageButtonAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalBot.g:3506:3: (otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==65) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalBot.g:3507:4: otherlv_4= 'text:' otherlv_5= '-' ( (lv_inputs_6_0= ruleTextInputText ) ) (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )*
                    {
                    otherlv_4=(Token)match(input,65,FOLLOW_13); 

                    				newLeafNode(otherlv_4, grammarAccess.getLanguageButtonAccess().getTextKeyword_2_0());
                    			
                    otherlv_5=(Token)match(input,19,FOLLOW_66); 

                    				newLeafNode(otherlv_5, grammarAccess.getLanguageButtonAccess().getHyphenMinusKeyword_2_1());
                    			
                    // InternalBot.g:3515:4: ( (lv_inputs_6_0= ruleTextInputText ) )
                    // InternalBot.g:3516:5: (lv_inputs_6_0= ruleTextInputText )
                    {
                    // InternalBot.g:3516:5: (lv_inputs_6_0= ruleTextInputText )
                    // InternalBot.g:3517:6: lv_inputs_6_0= ruleTextInputText
                    {

                    						newCompositeNode(grammarAccess.getLanguageButtonAccess().getInputsTextInputTextParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_82);
                    lv_inputs_6_0=ruleTextInputText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLanguageButtonRule());
                    						}
                    						add(
                    							current,
                    							"inputs",
                    							lv_inputs_6_0,
                    							"org.xtext.botGenerator.Bot.TextInputText");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalBot.g:3534:4: (otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==14) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // InternalBot.g:3535:5: otherlv_7= ',' otherlv_8= '-' ( (lv_inputs_9_0= ruleTextInputText ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_13); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getLanguageButtonAccess().getCommaKeyword_2_3_0());
                    	    				
                    	    otherlv_8=(Token)match(input,19,FOLLOW_66); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getLanguageButtonAccess().getHyphenMinusKeyword_2_3_1());
                    	    				
                    	    // InternalBot.g:3543:5: ( (lv_inputs_9_0= ruleTextInputText ) )
                    	    // InternalBot.g:3544:6: (lv_inputs_9_0= ruleTextInputText )
                    	    {
                    	    // InternalBot.g:3544:6: (lv_inputs_9_0= ruleTextInputText )
                    	    // InternalBot.g:3545:7: lv_inputs_9_0= ruleTextInputText
                    	    {

                    	    							newCompositeNode(grammarAccess.getLanguageButtonAccess().getInputsTextInputTextParserRuleCall_2_3_2_0());
                    	    						
                    	    pushFollow(FOLLOW_82);
                    	    lv_inputs_9_0=ruleTextInputText();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getLanguageButtonRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"inputs",
                    	    								lv_inputs_9_0,
                    	    								"org.xtext.botGenerator.Bot.TextInputText");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,66,FOLLOW_13); 

            			newLeafNode(otherlv_10, grammarAccess.getLanguageButtonAccess().getButtonsKeyword_3());
            		
            // InternalBot.g:3568:3: ( (lv_buttons_11_0= ruleButton ) )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==19) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // InternalBot.g:3569:4: (lv_buttons_11_0= ruleButton )
            	    {
            	    // InternalBot.g:3569:4: (lv_buttons_11_0= ruleButton )
            	    // InternalBot.g:3570:5: lv_buttons_11_0= ruleButton
            	    {

            	    					newCompositeNode(grammarAccess.getLanguageButtonAccess().getButtonsButtonParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_83);
            	    lv_buttons_11_0=ruleButton();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getLanguageButtonRule());
            	    					}
            	    					add(
            	    						current,
            	    						"buttons",
            	    						lv_buttons_11_0,
            	    						"org.xtext.botGenerator.Bot.Button");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
            } while (true);

            otherlv_12=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLanguageButtonAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleLanguageButton"


    // $ANTLR start "entryRuleButton"
    // InternalBot.g:3595:1: entryRuleButton returns [EObject current=null] : iv_ruleButton= ruleButton EOF ;
    public final EObject entryRuleButton() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleButton = null;


        try {
            // InternalBot.g:3595:47: (iv_ruleButton= ruleButton EOF )
            // InternalBot.g:3596:2: iv_ruleButton= ruleButton EOF
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
    // InternalBot.g:3602:1: ruleButton returns [EObject current=null] : (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? ) ;
    public final EObject ruleButton() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_action_4_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3608:2: ( (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? ) )
            // InternalBot.g:3609:2: (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? )
            {
            // InternalBot.g:3609:2: (otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )? )
            // InternalBot.g:3610:3: otherlv_0= '-' otherlv_1= 'value:' ( (lv_value_2_0= ruleEString ) ) (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getButtonAccess().getHyphenMinusKeyword_0());
            		
            otherlv_1=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getButtonAccess().getValueKeyword_1());
            		
            // InternalBot.g:3618:3: ( (lv_value_2_0= ruleEString ) )
            // InternalBot.g:3619:4: (lv_value_2_0= ruleEString )
            {
            // InternalBot.g:3619:4: (lv_value_2_0= ruleEString )
            // InternalBot.g:3620:5: lv_value_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getButtonAccess().getValueEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_85);
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

            // InternalBot.g:3637:3: (otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==68) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalBot.g:3638:4: otherlv_3= 'action:' ( (lv_action_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,68,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getButtonAccess().getActionKeyword_3_0());
                    			
                    // InternalBot.g:3642:4: ( (lv_action_4_0= ruleEString ) )
                    // InternalBot.g:3643:5: (lv_action_4_0= ruleEString )
                    {
                    // InternalBot.g:3643:5: (lv_action_4_0= ruleEString )
                    // InternalBot.g:3644:6: lv_action_4_0= ruleEString
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


    // $ANTLR start "entryRuleLanguageTextHttpResponse"
    // InternalBot.g:3666:1: entryRuleLanguageTextHttpResponse returns [EObject current=null] : iv_ruleLanguageTextHttpResponse= ruleLanguageTextHttpResponse EOF ;
    public final EObject entryRuleLanguageTextHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLanguageTextHttpResponse = null;


        try {
            // InternalBot.g:3666:65: (iv_ruleLanguageTextHttpResponse= ruleLanguageTextHttpResponse EOF )
            // InternalBot.g:3667:2: iv_ruleLanguageTextHttpResponse= ruleLanguageTextHttpResponse EOF
            {
             newCompositeNode(grammarAccess.getLanguageTextHttpResponseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLanguageTextHttpResponse=ruleLanguageTextHttpResponse();

            state._fsp--;

             current =iv_ruleLanguageTextHttpResponse; 
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
    // $ANTLR end "entryRuleLanguageTextHttpResponse"


    // $ANTLR start "ruleLanguageTextHttpResponse"
    // InternalBot.g:3673:1: ruleLanguageTextHttpResponse returns [EObject current=null] : (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleLanguageTextHttpResponse() throws RecognitionException {
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
            // InternalBot.g:3679:2: ( (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' ) )
            // InternalBot.g:3680:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            {
            // InternalBot.g:3680:2: (otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}' )
            // InternalBot.g:3681:3: otherlv_0= 'inputs' (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )? otherlv_3= '{' ( (lv_inputs_4_0= ruleTextInputHttpResponse ) ) (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getLanguageTextHttpResponseAccess().getInputsKeyword_0());
            		
            // InternalBot.g:3685:3: (otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==24) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalBot.g:3686:4: otherlv_1= 'in' ( (lv_language_2_0= ruleLanguage ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getLanguageTextHttpResponseAccess().getInKeyword_1_0());
                    			
                    // InternalBot.g:3690:4: ( (lv_language_2_0= ruleLanguage ) )
                    // InternalBot.g:3691:5: (lv_language_2_0= ruleLanguage )
                    {
                    // InternalBot.g:3691:5: (lv_language_2_0= ruleLanguage )
                    // InternalBot.g:3692:6: lv_language_2_0= ruleLanguage
                    {

                    						newCompositeNode(grammarAccess.getLanguageTextHttpResponseAccess().getLanguageLanguageEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_language_2_0=ruleLanguage();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLanguageTextHttpResponseRule());
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

            otherlv_3=(Token)match(input,25,FOLLOW_86); 

            			newLeafNode(otherlv_3, grammarAccess.getLanguageTextHttpResponseAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalBot.g:3714:3: ( (lv_inputs_4_0= ruleTextInputHttpResponse ) )
            // InternalBot.g:3715:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            {
            // InternalBot.g:3715:4: (lv_inputs_4_0= ruleTextInputHttpResponse )
            // InternalBot.g:3716:5: lv_inputs_4_0= ruleTextInputHttpResponse
            {

            					newCompositeNode(grammarAccess.getLanguageTextHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_24);
            lv_inputs_4_0=ruleTextInputHttpResponse();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLanguageTextHttpResponseRule());
            					}
            					add(
            						current,
            						"inputs",
            						lv_inputs_4_0,
            						"org.xtext.botGenerator.Bot.TextInputHttpResponse");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalBot.g:3733:3: (otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==14) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalBot.g:3734:4: otherlv_5= ',' ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_86); 

            	    				newLeafNode(otherlv_5, grammarAccess.getLanguageTextHttpResponseAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalBot.g:3738:4: ( (lv_inputs_6_0= ruleTextInputHttpResponse ) )
            	    // InternalBot.g:3739:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    {
            	    // InternalBot.g:3739:5: (lv_inputs_6_0= ruleTextInputHttpResponse )
            	    // InternalBot.g:3740:6: lv_inputs_6_0= ruleTextInputHttpResponse
            	    {

            	    						newCompositeNode(grammarAccess.getLanguageTextHttpResponseAccess().getInputsTextInputHttpResponseParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_inputs_6_0=ruleTextInputHttpResponse();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLanguageTextHttpResponseRule());
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
            	    break loop80;
                }
            } while (true);

            otherlv_7=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getLanguageTextHttpResponseAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleLanguageTextHttpResponse"


    // $ANTLR start "entryRuleTextInputHttpResponse"
    // InternalBot.g:3766:1: entryRuleTextInputHttpResponse returns [EObject current=null] : iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF ;
    public final EObject entryRuleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputHttpResponse = null;


        try {
            // InternalBot.g:3766:62: (iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF )
            // InternalBot.g:3767:2: iv_ruleTextInputHttpResponse= ruleTextInputHttpResponse EOF
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
    // InternalBot.g:3773:1: ruleTextInputHttpResponse returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ ;
    public final EObject ruleTextInputHttpResponse() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;

        EObject lv_tokens_0_3 = null;



        	enterRule();

        try {
            // InternalBot.g:3779:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+ )
            // InternalBot.g:3780:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            {
            // InternalBot.g:3780:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) ) )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_ID)||LA82_0==36||LA82_0==41) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // InternalBot.g:3781:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    {
            	    // InternalBot.g:3781:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken ) )
            	    // InternalBot.g:3782:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    {
            	    // InternalBot.g:3782:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken | lv_tokens_0_3= ruleHTTPRequestToken )
            	    int alt81=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_STRING:
            	    case RULE_ID:
            	        {
            	        alt81=1;
            	        }
            	        break;
            	    case 36:
            	        {
            	        alt81=2;
            	        }
            	        break;
            	    case 41:
            	        {
            	        alt81=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 81, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt81) {
            	        case 1 :
            	            // InternalBot.g:3783:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_87);
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
            	            // InternalBot.g:3799:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_87);
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
            	            // InternalBot.g:3815:5: lv_tokens_0_3= ruleHTTPRequestToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputHttpResponseAccess().getTokensHTTPRequestTokenParserRuleCall_0_2());
            	            				
            	            pushFollow(FOLLOW_87);
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
            	    if ( cnt82 >= 1 ) break loop82;
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
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
    // InternalBot.g:3836:1: entryRuleTextInputText returns [EObject current=null] : iv_ruleTextInputText= ruleTextInputText EOF ;
    public final EObject entryRuleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextInputText = null;


        try {
            // InternalBot.g:3836:54: (iv_ruleTextInputText= ruleTextInputText EOF )
            // InternalBot.g:3837:2: iv_ruleTextInputText= ruleTextInputText EOF
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
    // InternalBot.g:3843:1: ruleTextInputText returns [EObject current=null] : ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ ;
    public final EObject ruleTextInputText() throws RecognitionException {
        EObject current = null;

        EObject lv_tokens_0_1 = null;

        EObject lv_tokens_0_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3849:2: ( ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+ )
            // InternalBot.g:3850:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            {
            // InternalBot.g:3850:2: ( ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) ) )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( ((LA84_0>=RULE_STRING && LA84_0<=RULE_ID)||LA84_0==36) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // InternalBot.g:3851:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    {
            	    // InternalBot.g:3851:3: ( (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken ) )
            	    // InternalBot.g:3852:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    {
            	    // InternalBot.g:3852:4: (lv_tokens_0_1= ruleLiteral | lv_tokens_0_2= ruleParameterToken )
            	    int alt83=2;
            	    int LA83_0 = input.LA(1);

            	    if ( ((LA83_0>=RULE_STRING && LA83_0<=RULE_ID)) ) {
            	        alt83=1;
            	    }
            	    else if ( (LA83_0==36) ) {
            	        alt83=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 83, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt83) {
            	        case 1 :
            	            // InternalBot.g:3853:5: lv_tokens_0_1= ruleLiteral
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensLiteralParserRuleCall_0_0());
            	            				
            	            pushFollow(FOLLOW_88);
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
            	            // InternalBot.g:3869:5: lv_tokens_0_2= ruleParameterToken
            	            {

            	            					newCompositeNode(grammarAccess.getTextInputTextAccess().getTokensParameterTokenParserRuleCall_0_1());
            	            				
            	            pushFollow(FOLLOW_88);
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
            	    if ( cnt84 >= 1 ) break loop84;
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
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
    // InternalBot.g:3890:1: entryRuleKeyValue returns [EObject current=null] : iv_ruleKeyValue= ruleKeyValue EOF ;
    public final EObject entryRuleKeyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValue = null;


        try {
            // InternalBot.g:3890:49: (iv_ruleKeyValue= ruleKeyValue EOF )
            // InternalBot.g:3891:2: iv_ruleKeyValue= ruleKeyValue EOF
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
    // InternalBot.g:3897:1: ruleKeyValue returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) ;
    public final EObject ruleKeyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalBot.g:3903:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) ) )
            // InternalBot.g:3904:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            {
            // InternalBot.g:3904:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) ) )
            // InternalBot.g:3905:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_value_2_0= ruleLiteral ) )
            {
            // InternalBot.g:3905:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3906:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3906:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3907:5: lv_key_0_0= ruleEString
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
            		
            // InternalBot.g:3928:3: ( (lv_value_2_0= ruleLiteral ) )
            // InternalBot.g:3929:4: (lv_value_2_0= ruleLiteral )
            {
            // InternalBot.g:3929:4: (lv_value_2_0= ruleLiteral )
            // InternalBot.g:3930:5: lv_value_2_0= ruleLiteral
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
    // InternalBot.g:3951:1: entryRuleData returns [EObject current=null] : iv_ruleData= ruleData EOF ;
    public final EObject entryRuleData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleData = null;


        try {
            // InternalBot.g:3951:45: (iv_ruleData= ruleData EOF )
            // InternalBot.g:3952:2: iv_ruleData= ruleData EOF
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
    // InternalBot.g:3958:1: ruleData returns [EObject current=null] : ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) ;
    public final EObject ruleData() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        EObject lv_value_2_1 = null;

        EObject lv_value_2_2 = null;



        	enterRule();

        try {
            // InternalBot.g:3964:2: ( ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) ) )
            // InternalBot.g:3965:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            {
            // InternalBot.g:3965:2: ( ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) ) )
            // InternalBot.g:3966:3: ( (lv_key_0_0= ruleEString ) ) otherlv_1= ':' ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            {
            // InternalBot.g:3966:3: ( (lv_key_0_0= ruleEString ) )
            // InternalBot.g:3967:4: (lv_key_0_0= ruleEString )
            {
            // InternalBot.g:3967:4: (lv_key_0_0= ruleEString )
            // InternalBot.g:3968:5: lv_key_0_0= ruleEString
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

            otherlv_1=(Token)match(input,13,FOLLOW_66); 

            			newLeafNode(otherlv_1, grammarAccess.getDataAccess().getColonKeyword_1());
            		
            // InternalBot.g:3989:3: ( ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) ) )
            // InternalBot.g:3990:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            {
            // InternalBot.g:3990:4: ( (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken ) )
            // InternalBot.g:3991:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            {
            // InternalBot.g:3991:5: (lv_value_2_1= ruleLiteral | lv_value_2_2= ruleParameterToken )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=RULE_STRING && LA85_0<=RULE_ID)) ) {
                alt85=1;
            }
            else if ( (LA85_0==36) ) {
                alt85=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalBot.g:3992:6: lv_value_2_1= ruleLiteral
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
                    // InternalBot.g:4008:6: lv_value_2_2= ruleParameterToken
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
    // InternalBot.g:4030:1: ruleDefaultEntity returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) ;
    public final Enumerator ruleDefaultEntity() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalBot.g:4036:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) ) )
            // InternalBot.g:4037:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            {
            // InternalBot.g:4037:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'number' ) | (enumLiteral_2= 'date' ) | (enumLiteral_3= 'float' ) | (enumLiteral_4= 'time' ) )
            int alt86=5;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt86=1;
                }
                break;
            case 69:
                {
                alt86=2;
                }
                break;
            case 70:
                {
                alt86=3;
                }
                break;
            case 71:
                {
                alt86=4;
                }
                break;
            case 72:
                {
                alt86=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // InternalBot.g:4038:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:4038:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:4039:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDefaultEntityAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4046:3: (enumLiteral_1= 'number' )
                    {
                    // InternalBot.g:4046:3: (enumLiteral_1= 'number' )
                    // InternalBot.g:4047:4: enumLiteral_1= 'number'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDefaultEntityAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:4054:3: (enumLiteral_2= 'date' )
                    {
                    // InternalBot.g:4054:3: (enumLiteral_2= 'date' )
                    // InternalBot.g:4055:4: enumLiteral_2= 'date'
                    {
                    enumLiteral_2=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDefaultEntityAccess().getDATEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:4062:3: (enumLiteral_3= 'float' )
                    {
                    // InternalBot.g:4062:3: (enumLiteral_3= 'float' )
                    // InternalBot.g:4063:4: enumLiteral_3= 'float'
                    {
                    enumLiteral_3=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDefaultEntityAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:4070:3: (enumLiteral_4= 'time' )
                    {
                    // InternalBot.g:4070:3: (enumLiteral_4= 'time' )
                    // InternalBot.g:4071:4: enumLiteral_4= 'time'
                    {
                    enumLiteral_4=(Token)match(input,72,FOLLOW_2); 

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
    // InternalBot.g:4081:1: ruleHTTPReturnType returns [Enumerator current=null] : ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) ;
    public final Enumerator ruleHTTPReturnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalBot.g:4087:2: ( ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) ) )
            // InternalBot.g:4088:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            {
            // InternalBot.g:4088:2: ( (enumLiteral_0= 'text' ) | (enumLiteral_1= 'status_code' ) | (enumLiteral_2= 'image' ) | (enumLiteral_3= 'data' ) )
            int alt87=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt87=1;
                }
                break;
            case 73:
                {
                alt87=2;
                }
                break;
            case 74:
                {
                alt87=3;
                }
                break;
            case 57:
                {
                alt87=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalBot.g:4089:3: (enumLiteral_0= 'text' )
                    {
                    // InternalBot.g:4089:3: (enumLiteral_0= 'text' )
                    // InternalBot.g:4090:4: enumLiteral_0= 'text'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getHTTPReturnTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4097:3: (enumLiteral_1= 'status_code' )
                    {
                    // InternalBot.g:4097:3: (enumLiteral_1= 'status_code' )
                    // InternalBot.g:4098:4: enumLiteral_1= 'status_code'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getHTTPReturnTypeAccess().getSTATUS_CODEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:4105:3: (enumLiteral_2= 'image' )
                    {
                    // InternalBot.g:4105:3: (enumLiteral_2= 'image' )
                    // InternalBot.g:4106:4: enumLiteral_2= 'image'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getHTTPReturnTypeAccess().getIMAGEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:4113:3: (enumLiteral_3= 'data' )
                    {
                    // InternalBot.g:4113:3: (enumLiteral_3= 'data' )
                    // InternalBot.g:4114:4: enumLiteral_3= 'data'
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
    // InternalBot.g:4124:1: ruleLanguage returns [Enumerator current=null] : ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) ;
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
            // InternalBot.g:4130:2: ( ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) ) )
            // InternalBot.g:4131:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            {
            // InternalBot.g:4131:2: ( (enumLiteral_0= 'en' ) | (enumLiteral_1= 'es' ) | (enumLiteral_2= 'da' ) | (enumLiteral_3= 'de' ) | (enumLiteral_4= 'fr' ) | (enumLiteral_5= 'hi' ) | (enumLiteral_6= 'id' ) | (enumLiteral_7= 'it' ) | (enumLiteral_8= 'ja' ) | (enumLiteral_9= 'ko' ) | (enumLiteral_10= 'nl' ) | (enumLiteral_11= 'no' ) | (enumLiteral_12= 'pl' ) | (enumLiteral_13= 'pt' ) | (enumLiteral_14= 'ru' ) | (enumLiteral_15= 'sv' ) | (enumLiteral_16= 'th' ) | (enumLiteral_17= 'tr' ) | (enumLiteral_18= 'uk' ) | (enumLiteral_19= 'zh' ) | (enumLiteral_20= 'ar' ) | (enumLiteral_21= 'cz' ) | (enumLiteral_22= 'bu' ) | (enumLiteral_23= 'fi' ) | (enumLiteral_24= 'gr' ) | (enumLiteral_25= 'ba' ) )
            int alt88=26;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt88=1;
                }
                break;
            case 76:
                {
                alt88=2;
                }
                break;
            case 77:
                {
                alt88=3;
                }
                break;
            case 78:
                {
                alt88=4;
                }
                break;
            case 79:
                {
                alt88=5;
                }
                break;
            case 80:
                {
                alt88=6;
                }
                break;
            case 81:
                {
                alt88=7;
                }
                break;
            case 82:
                {
                alt88=8;
                }
                break;
            case 83:
                {
                alt88=9;
                }
                break;
            case 84:
                {
                alt88=10;
                }
                break;
            case 85:
                {
                alt88=11;
                }
                break;
            case 86:
                {
                alt88=12;
                }
                break;
            case 87:
                {
                alt88=13;
                }
                break;
            case 88:
                {
                alt88=14;
                }
                break;
            case 89:
                {
                alt88=15;
                }
                break;
            case 90:
                {
                alt88=16;
                }
                break;
            case 91:
                {
                alt88=17;
                }
                break;
            case 92:
                {
                alt88=18;
                }
                break;
            case 93:
                {
                alt88=19;
                }
                break;
            case 94:
                {
                alt88=20;
                }
                break;
            case 95:
                {
                alt88=21;
                }
                break;
            case 96:
                {
                alt88=22;
                }
                break;
            case 97:
                {
                alt88=23;
                }
                break;
            case 98:
                {
                alt88=24;
                }
                break;
            case 99:
                {
                alt88=25;
                }
                break;
            case 100:
                {
                alt88=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // InternalBot.g:4132:3: (enumLiteral_0= 'en' )
                    {
                    // InternalBot.g:4132:3: (enumLiteral_0= 'en' )
                    // InternalBot.g:4133:4: enumLiteral_0= 'en'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLanguageAccess().getENGLISHEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4140:3: (enumLiteral_1= 'es' )
                    {
                    // InternalBot.g:4140:3: (enumLiteral_1= 'es' )
                    // InternalBot.g:4141:4: enumLiteral_1= 'es'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLanguageAccess().getSPANISHEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalBot.g:4148:3: (enumLiteral_2= 'da' )
                    {
                    // InternalBot.g:4148:3: (enumLiteral_2= 'da' )
                    // InternalBot.g:4149:4: enumLiteral_2= 'da'
                    {
                    enumLiteral_2=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLanguageAccess().getDANISHEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalBot.g:4156:3: (enumLiteral_3= 'de' )
                    {
                    // InternalBot.g:4156:3: (enumLiteral_3= 'de' )
                    // InternalBot.g:4157:4: enumLiteral_3= 'de'
                    {
                    enumLiteral_3=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLanguageAccess().getGERMANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalBot.g:4164:3: (enumLiteral_4= 'fr' )
                    {
                    // InternalBot.g:4164:3: (enumLiteral_4= 'fr' )
                    // InternalBot.g:4165:4: enumLiteral_4= 'fr'
                    {
                    enumLiteral_4=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLanguageAccess().getFRENCHEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalBot.g:4172:3: (enumLiteral_5= 'hi' )
                    {
                    // InternalBot.g:4172:3: (enumLiteral_5= 'hi' )
                    // InternalBot.g:4173:4: enumLiteral_5= 'hi'
                    {
                    enumLiteral_5=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getLanguageAccess().getHINDIEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalBot.g:4180:3: (enumLiteral_6= 'id' )
                    {
                    // InternalBot.g:4180:3: (enumLiteral_6= 'id' )
                    // InternalBot.g:4181:4: enumLiteral_6= 'id'
                    {
                    enumLiteral_6=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getLanguageAccess().getINDONESIANEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalBot.g:4188:3: (enumLiteral_7= 'it' )
                    {
                    // InternalBot.g:4188:3: (enumLiteral_7= 'it' )
                    // InternalBot.g:4189:4: enumLiteral_7= 'it'
                    {
                    enumLiteral_7=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getLanguageAccess().getITALIANEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalBot.g:4196:3: (enumLiteral_8= 'ja' )
                    {
                    // InternalBot.g:4196:3: (enumLiteral_8= 'ja' )
                    // InternalBot.g:4197:4: enumLiteral_8= 'ja'
                    {
                    enumLiteral_8=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getLanguageAccess().getJAPANESEEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalBot.g:4204:3: (enumLiteral_9= 'ko' )
                    {
                    // InternalBot.g:4204:3: (enumLiteral_9= 'ko' )
                    // InternalBot.g:4205:4: enumLiteral_9= 'ko'
                    {
                    enumLiteral_9=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getLanguageAccess().getKOREANEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalBot.g:4212:3: (enumLiteral_10= 'nl' )
                    {
                    // InternalBot.g:4212:3: (enumLiteral_10= 'nl' )
                    // InternalBot.g:4213:4: enumLiteral_10= 'nl'
                    {
                    enumLiteral_10=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getLanguageAccess().getDUTCHEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalBot.g:4220:3: (enumLiteral_11= 'no' )
                    {
                    // InternalBot.g:4220:3: (enumLiteral_11= 'no' )
                    // InternalBot.g:4221:4: enumLiteral_11= 'no'
                    {
                    enumLiteral_11=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getLanguageAccess().getNORWEGIANEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalBot.g:4228:3: (enumLiteral_12= 'pl' )
                    {
                    // InternalBot.g:4228:3: (enumLiteral_12= 'pl' )
                    // InternalBot.g:4229:4: enumLiteral_12= 'pl'
                    {
                    enumLiteral_12=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getLanguageAccess().getPOLISHEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;
                case 14 :
                    // InternalBot.g:4236:3: (enumLiteral_13= 'pt' )
                    {
                    // InternalBot.g:4236:3: (enumLiteral_13= 'pt' )
                    // InternalBot.g:4237:4: enumLiteral_13= 'pt'
                    {
                    enumLiteral_13=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_13, grammarAccess.getLanguageAccess().getPORTUGUESEEnumLiteralDeclaration_13());
                    			

                    }


                    }
                    break;
                case 15 :
                    // InternalBot.g:4244:3: (enumLiteral_14= 'ru' )
                    {
                    // InternalBot.g:4244:3: (enumLiteral_14= 'ru' )
                    // InternalBot.g:4245:4: enumLiteral_14= 'ru'
                    {
                    enumLiteral_14=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_14, grammarAccess.getLanguageAccess().getRUSIANEnumLiteralDeclaration_14());
                    			

                    }


                    }
                    break;
                case 16 :
                    // InternalBot.g:4252:3: (enumLiteral_15= 'sv' )
                    {
                    // InternalBot.g:4252:3: (enumLiteral_15= 'sv' )
                    // InternalBot.g:4253:4: enumLiteral_15= 'sv'
                    {
                    enumLiteral_15=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_15, grammarAccess.getLanguageAccess().getSWEDISHEnumLiteralDeclaration_15());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalBot.g:4260:3: (enumLiteral_16= 'th' )
                    {
                    // InternalBot.g:4260:3: (enumLiteral_16= 'th' )
                    // InternalBot.g:4261:4: enumLiteral_16= 'th'
                    {
                    enumLiteral_16=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_16, grammarAccess.getLanguageAccess().getTHAIEnumLiteralDeclaration_16());
                    			

                    }


                    }
                    break;
                case 18 :
                    // InternalBot.g:4268:3: (enumLiteral_17= 'tr' )
                    {
                    // InternalBot.g:4268:3: (enumLiteral_17= 'tr' )
                    // InternalBot.g:4269:4: enumLiteral_17= 'tr'
                    {
                    enumLiteral_17=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_17, grammarAccess.getLanguageAccess().getTURKISHEnumLiteralDeclaration_17());
                    			

                    }


                    }
                    break;
                case 19 :
                    // InternalBot.g:4276:3: (enumLiteral_18= 'uk' )
                    {
                    // InternalBot.g:4276:3: (enumLiteral_18= 'uk' )
                    // InternalBot.g:4277:4: enumLiteral_18= 'uk'
                    {
                    enumLiteral_18=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_18, grammarAccess.getLanguageAccess().getUKRANIANEnumLiteralDeclaration_18());
                    			

                    }


                    }
                    break;
                case 20 :
                    // InternalBot.g:4284:3: (enumLiteral_19= 'zh' )
                    {
                    // InternalBot.g:4284:3: (enumLiteral_19= 'zh' )
                    // InternalBot.g:4285:4: enumLiteral_19= 'zh'
                    {
                    enumLiteral_19=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_19, grammarAccess.getLanguageAccess().getCHINESEEnumLiteralDeclaration_19());
                    			

                    }


                    }
                    break;
                case 21 :
                    // InternalBot.g:4292:3: (enumLiteral_20= 'ar' )
                    {
                    // InternalBot.g:4292:3: (enumLiteral_20= 'ar' )
                    // InternalBot.g:4293:4: enumLiteral_20= 'ar'
                    {
                    enumLiteral_20=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_20, grammarAccess.getLanguageAccess().getARABICEnumLiteralDeclaration_20());
                    			

                    }


                    }
                    break;
                case 22 :
                    // InternalBot.g:4300:3: (enumLiteral_21= 'cz' )
                    {
                    // InternalBot.g:4300:3: (enumLiteral_21= 'cz' )
                    // InternalBot.g:4301:4: enumLiteral_21= 'cz'
                    {
                    enumLiteral_21=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_21, grammarAccess.getLanguageAccess().getCZECHEnumLiteralDeclaration_21());
                    			

                    }


                    }
                    break;
                case 23 :
                    // InternalBot.g:4308:3: (enumLiteral_22= 'bu' )
                    {
                    // InternalBot.g:4308:3: (enumLiteral_22= 'bu' )
                    // InternalBot.g:4309:4: enumLiteral_22= 'bu'
                    {
                    enumLiteral_22=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_22, grammarAccess.getLanguageAccess().getBULGARIANEnumLiteralDeclaration_22());
                    			

                    }


                    }
                    break;
                case 24 :
                    // InternalBot.g:4316:3: (enumLiteral_23= 'fi' )
                    {
                    // InternalBot.g:4316:3: (enumLiteral_23= 'fi' )
                    // InternalBot.g:4317:4: enumLiteral_23= 'fi'
                    {
                    enumLiteral_23=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_23, grammarAccess.getLanguageAccess().getFINISHEnumLiteralDeclaration_23());
                    			

                    }


                    }
                    break;
                case 25 :
                    // InternalBot.g:4324:3: (enumLiteral_24= 'gr' )
                    {
                    // InternalBot.g:4324:3: (enumLiteral_24= 'gr' )
                    // InternalBot.g:4325:4: enumLiteral_24= 'gr'
                    {
                    enumLiteral_24=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_24, grammarAccess.getLanguageAccess().getGREEKEnumLiteralDeclaration_24());
                    			

                    }


                    }
                    break;
                case 26 :
                    // InternalBot.g:4332:3: (enumLiteral_25= 'ba' )
                    {
                    // InternalBot.g:4332:3: (enumLiteral_25= 'ba' )
                    // InternalBot.g:4333:4: enumLiteral_25= 'ba'
                    {
                    enumLiteral_25=(Token)match(input,100,FOLLOW_2); 

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
    // InternalBot.g:4343:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:4349:2: ( ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) ) )
            // InternalBot.g:4350:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            {
            // InternalBot.g:4350:2: ( (enumLiteral_0= 'JSON' ) | (enumLiteral_1= 'FORM' ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==101) ) {
                alt89=1;
            }
            else if ( (LA89_0==102) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalBot.g:4351:3: (enumLiteral_0= 'JSON' )
                    {
                    // InternalBot.g:4351:3: (enumLiteral_0= 'JSON' )
                    // InternalBot.g:4352:4: enumLiteral_0= 'JSON'
                    {
                    enumLiteral_0=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getJSONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4359:3: (enumLiteral_1= 'FORM' )
                    {
                    // InternalBot.g:4359:3: (enumLiteral_1= 'FORM' )
                    // InternalBot.g:4360:4: enumLiteral_1= 'FORM'
                    {
                    enumLiteral_1=(Token)match(input,102,FOLLOW_2); 

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
    // InternalBot.g:4370:1: ruleMethod returns [Enumerator current=null] : ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) ;
    public final Enumerator ruleMethod() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalBot.g:4376:2: ( ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) ) )
            // InternalBot.g:4377:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            {
            // InternalBot.g:4377:2: ( (enumLiteral_0= 'post' ) | (enumLiteral_1= 'get' ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==103) ) {
                alt90=1;
            }
            else if ( (LA90_0==104) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalBot.g:4378:3: (enumLiteral_0= 'post' )
                    {
                    // InternalBot.g:4378:3: (enumLiteral_0= 'post' )
                    // InternalBot.g:4379:4: enumLiteral_0= 'post'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMethodAccess().getPOSTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalBot.g:4386:3: (enumLiteral_1= 'get' )
                    {
                    // InternalBot.g:4386:3: (enumLiteral_1= 'get' )
                    // InternalBot.g:4387:4: enumLiteral_1= 'get'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

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
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000001FFFFFF800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000380000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000380000060000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x5836000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x5836000000040000L,0x0000000000000001L});
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
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000008000000030L});
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
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000030L,0x00000000000001E0L});
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
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0204000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000800004000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000400004000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000004000000030L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000004000000032L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000001000000030L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000018000000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0380000000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0300000000000002L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000006000000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000004L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000021000000030L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000021000000032L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000001000000032L});

}