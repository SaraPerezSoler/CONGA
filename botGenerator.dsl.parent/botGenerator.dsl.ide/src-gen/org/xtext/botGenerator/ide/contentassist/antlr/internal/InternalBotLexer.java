package org.xtext.botGenerator.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBotLexer extends Lexer {
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

    public InternalBotLexer() {;} 
    public InternalBotLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalBotLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalBot.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:11:7: ( 'Text' )
            // InternalBot.g:11:9: 'Text'
            {
            match("Text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12:7: ( 'text' )
            // InternalBot.g:12:9: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:13:7: ( 'Image' )
            // InternalBot.g:13:9: 'Image'
            {
            match("Image"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:14:7: ( 'mage' )
            // InternalBot.g:14:9: 'mage'
            {
            match("mage"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:15:7: ( 'number' )
            // InternalBot.g:15:9: 'number'
            {
            match("number"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:16:7: ( 'date' )
            // InternalBot.g:16:9: 'date'
            {
            match("date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:17:7: ( 'float' )
            // InternalBot.g:17:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:18:7: ( 'time' )
            // InternalBot.g:18:9: 'time'
            {
            match("time"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:19:7: ( 'status_code' )
            // InternalBot.g:19:9: 'status_code'
            {
            match("status_code"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:20:7: ( 'image' )
            // InternalBot.g:20:9: 'image'
            {
            match("image"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:21:7: ( 'data' )
            // InternalBot.g:21:9: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:22:7: ( 'en' )
            // InternalBot.g:22:9: 'en'
            {
            match("en"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:23:7: ( 'es' )
            // InternalBot.g:23:9: 'es'
            {
            match("es"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:24:7: ( 'da' )
            // InternalBot.g:24:9: 'da'
            {
            match("da"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:25:7: ( 'de' )
            // InternalBot.g:25:9: 'de'
            {
            match("de"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:26:7: ( 'fr' )
            // InternalBot.g:26:9: 'fr'
            {
            match("fr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:27:7: ( 'hi' )
            // InternalBot.g:27:9: 'hi'
            {
            match("hi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:28:7: ( 'id' )
            // InternalBot.g:28:9: 'id'
            {
            match("id"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:29:7: ( 'it' )
            // InternalBot.g:29:9: 'it'
            {
            match("it"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:30:7: ( 'ja' )
            // InternalBot.g:30:9: 'ja'
            {
            match("ja"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:31:7: ( 'ko' )
            // InternalBot.g:31:9: 'ko'
            {
            match("ko"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:32:7: ( 'nl' )
            // InternalBot.g:32:9: 'nl'
            {
            match("nl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:33:7: ( 'no' )
            // InternalBot.g:33:9: 'no'
            {
            match("no"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:34:7: ( 'pl' )
            // InternalBot.g:34:9: 'pl'
            {
            match("pl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:35:7: ( 'pt' )
            // InternalBot.g:35:9: 'pt'
            {
            match("pt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:36:7: ( 'ru' )
            // InternalBot.g:36:9: 'ru'
            {
            match("ru"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:37:7: ( 'sv' )
            // InternalBot.g:37:9: 'sv'
            {
            match("sv"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:38:7: ( 'th' )
            // InternalBot.g:38:9: 'th'
            {
            match("th"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:39:7: ( 'tr' )
            // InternalBot.g:39:9: 'tr'
            {
            match("tr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:40:7: ( 'uk' )
            // InternalBot.g:40:9: 'uk'
            {
            match("uk"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:41:7: ( 'zh' )
            // InternalBot.g:41:9: 'zh'
            {
            match("zh"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:42:7: ( 'ar' )
            // InternalBot.g:42:9: 'ar'
            {
            match("ar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:43:7: ( 'cz' )
            // InternalBot.g:43:9: 'cz'
            {
            match("cz"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:44:7: ( 'bu' )
            // InternalBot.g:44:9: 'bu'
            {
            match("bu"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:45:7: ( 'fi' )
            // InternalBot.g:45:9: 'fi'
            {
            match("fi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:46:7: ( 'gr' )
            // InternalBot.g:46:9: 'gr'
            {
            match("gr"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:47:7: ( 'ba' )
            // InternalBot.g:47:9: 'ba'
            {
            match("ba"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:48:7: ( 'JSON' )
            // InternalBot.g:48:9: 'JSON'
            {
            match("JSON"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:49:7: ( 'FORM' )
            // InternalBot.g:49:9: 'FORM'
            {
            match("FORM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:50:7: ( 'post' )
            // InternalBot.g:50:9: 'post'
            {
            match("post"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:51:7: ( 'get' )
            // InternalBot.g:51:9: 'get'
            {
            match("get"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:52:7: ( 'Chatbot' )
            // InternalBot.g:52:9: 'Chatbot'
            {
            match("Chatbot"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:53:7: ( 'language' )
            // InternalBot.g:53:9: 'language'
            {
            match("language"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:54:7: ( ':' )
            // InternalBot.g:54:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:55:7: ( 'intents' )
            // InternalBot.g:55:9: 'intents'
            {
            match("intents"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:56:7: ( 'flows' )
            // InternalBot.g:56:9: 'flows'
            {
            match("flows"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:57:7: ( ',' )
            // InternalBot.g:57:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:58:7: ( 'entities' )
            // InternalBot.g:58:9: 'entities'
            {
            match("entities"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:59:7: ( 'actions' )
            // InternalBot.g:59:9: 'actions'
            {
            match("actions"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:60:7: ( '-' )
            // InternalBot.g:60:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:61:7: ( ';' )
            // InternalBot.g:61:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:62:7: ( 'parameters' )
            // InternalBot.g:62:9: 'parameters'
            {
            match("parameters"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:63:7: ( 'inputs' )
            // InternalBot.g:63:9: 'inputs'
            {
            match("inputs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:64:7: ( '{' )
            // InternalBot.g:64:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:65:7: ( '}' )
            // InternalBot.g:65:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:66:7: ( 'in' )
            // InternalBot.g:66:9: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:67:7: ( 'user' )
            // InternalBot.g:67:9: 'user'
            {
            match("user"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:68:7: ( '=>' )
            // InternalBot.g:68:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:69:7: ( 'back' )
            // InternalBot.g:69:9: 'back'
            {
            match("back"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:70:7: ( 'to' )
            // InternalBot.g:70:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:71:7: ( 'chatbot' )
            // InternalBot.g:71:9: 'chatbot'
            {
            match("chatbot"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:72:7: ( 'entity' )
            // InternalBot.g:72:9: 'entity'
            {
            match("entity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:73:7: ( 'prompts' )
            // InternalBot.g:73:9: 'prompts'
            {
            match("prompts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:74:7: ( '[' )
            // InternalBot.g:74:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:75:7: ( ']' )
            // InternalBot.g:75:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:76:7: ( '@' )
            // InternalBot.g:76:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:77:7: ( '(' )
            // InternalBot.g:77:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:78:7: ( ')' )
            // InternalBot.g:78:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:79:7: ( 'request.' )
            // InternalBot.g:79:9: 'request.'
            {
            match("request."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:80:7: ( '.' )
            // InternalBot.g:80:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:81:7: ( 'Simple' )
            // InternalBot.g:81:9: 'Simple'
            {
            match("Simple"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:82:7: ( 'Composite' )
            // InternalBot.g:82:9: 'Composite'
            {
            match("Composite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:83:7: ( 'Regex' )
            // InternalBot.g:83:9: 'Regex'
            {
            match("Regex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:84:7: ( 'pattern' )
            // InternalBot.g:84:9: 'pattern'
            {
            match("pattern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:85:7: ( 'composite' )
            // InternalBot.g:85:9: 'composite'
            {
            match("composite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:86:7: ( 'synonyms' )
            // InternalBot.g:86:9: 'synonyms'
            {
            match("synonyms"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:87:7: ( 'response' )
            // InternalBot.g:87:9: 'response'
            {
            match("response"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:88:7: ( 'Response' )
            // InternalBot.g:88:9: 'Response'
            {
            match("Response"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:89:7: ( 'Request' )
            // InternalBot.g:89:9: 'Request'
            {
            match("Request"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:90:7: ( 'URL' )
            // InternalBot.g:90:9: 'URL'
            {
            match("URL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:91:7: ( 'basicAuth' )
            // InternalBot.g:91:9: 'basicAuth'
            {
            match("basicAuth"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:92:7: ( 'headers' )
            // InternalBot.g:92:9: 'headers'
            {
            match("headers"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:93:7: ( 'dataType' )
            // InternalBot.g:93:9: 'dataType'
            {
            match("dataType"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:94:7: ( 'caption' )
            // InternalBot.g:94:9: 'caption'
            {
            match("caption"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:95:7: ( 'Empty' )
            // InternalBot.g:95:9: 'Empty'
            {
            match("Empty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:96:7: ( 'Button' )
            // InternalBot.g:96:9: 'Button'
            {
            match("Button"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:97:7: ( 'text:' )
            // InternalBot.g:97:9: 'text:'
            {
            match("text:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:98:7: ( 'buttons:' )
            // InternalBot.g:98:9: 'buttons:'
            {
            match("buttons:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:99:7: ( 'value:' )
            // InternalBot.g:99:9: 'value:'
            {
            match("value:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:100:8: ( 'action:' )
            // InternalBot.g:100:10: 'action:'
            {
            match("action:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:101:8: ( 'Fallback' )
            // InternalBot.g:101:10: 'Fallback'
            {
            match("Fallback"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:102:8: ( 'isList' )
            // InternalBot.g:102:10: 'isList'
            {
            match("isList"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:103:8: ( 'required' )
            // InternalBot.g:103:10: 'required'
            {
            match("required"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12060:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalBot.g:12060:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalBot.g:12060:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalBot.g:12060:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalBot.g:12060:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBot.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12062:10: ( ( '0' .. '9' )+ )
            // InternalBot.g:12062:12: ( '0' .. '9' )+
            {
            // InternalBot.g:12062:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalBot.g:12062:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12064:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalBot.g:12064:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalBot.g:12064:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalBot.g:12064:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalBot.g:12064:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalBot.g:12064:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBot.g:12064:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalBot.g:12064:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalBot.g:12064:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBot.g:12064:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalBot.g:12064:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12066:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalBot.g:12066:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalBot.g:12066:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBot.g:12066:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12068:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalBot.g:12068:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalBot.g:12068:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalBot.g:12068:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalBot.g:12068:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalBot.g:12068:41: ( '\\r' )? '\\n'
                    {
                    // InternalBot.g:12068:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalBot.g:12068:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12070:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalBot.g:12070:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalBot.g:12070:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBot.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalBot.g:12072:16: ( . )
            // InternalBot.g:12072:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalBot.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=100;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalBot.g:1:10: T__11
                {
                mT__11(); 

                }
                break;
            case 2 :
                // InternalBot.g:1:16: T__12
                {
                mT__12(); 

                }
                break;
            case 3 :
                // InternalBot.g:1:22: T__13
                {
                mT__13(); 

                }
                break;
            case 4 :
                // InternalBot.g:1:28: T__14
                {
                mT__14(); 

                }
                break;
            case 5 :
                // InternalBot.g:1:34: T__15
                {
                mT__15(); 

                }
                break;
            case 6 :
                // InternalBot.g:1:40: T__16
                {
                mT__16(); 

                }
                break;
            case 7 :
                // InternalBot.g:1:46: T__17
                {
                mT__17(); 

                }
                break;
            case 8 :
                // InternalBot.g:1:52: T__18
                {
                mT__18(); 

                }
                break;
            case 9 :
                // InternalBot.g:1:58: T__19
                {
                mT__19(); 

                }
                break;
            case 10 :
                // InternalBot.g:1:64: T__20
                {
                mT__20(); 

                }
                break;
            case 11 :
                // InternalBot.g:1:70: T__21
                {
                mT__21(); 

                }
                break;
            case 12 :
                // InternalBot.g:1:76: T__22
                {
                mT__22(); 

                }
                break;
            case 13 :
                // InternalBot.g:1:82: T__23
                {
                mT__23(); 

                }
                break;
            case 14 :
                // InternalBot.g:1:88: T__24
                {
                mT__24(); 

                }
                break;
            case 15 :
                // InternalBot.g:1:94: T__25
                {
                mT__25(); 

                }
                break;
            case 16 :
                // InternalBot.g:1:100: T__26
                {
                mT__26(); 

                }
                break;
            case 17 :
                // InternalBot.g:1:106: T__27
                {
                mT__27(); 

                }
                break;
            case 18 :
                // InternalBot.g:1:112: T__28
                {
                mT__28(); 

                }
                break;
            case 19 :
                // InternalBot.g:1:118: T__29
                {
                mT__29(); 

                }
                break;
            case 20 :
                // InternalBot.g:1:124: T__30
                {
                mT__30(); 

                }
                break;
            case 21 :
                // InternalBot.g:1:130: T__31
                {
                mT__31(); 

                }
                break;
            case 22 :
                // InternalBot.g:1:136: T__32
                {
                mT__32(); 

                }
                break;
            case 23 :
                // InternalBot.g:1:142: T__33
                {
                mT__33(); 

                }
                break;
            case 24 :
                // InternalBot.g:1:148: T__34
                {
                mT__34(); 

                }
                break;
            case 25 :
                // InternalBot.g:1:154: T__35
                {
                mT__35(); 

                }
                break;
            case 26 :
                // InternalBot.g:1:160: T__36
                {
                mT__36(); 

                }
                break;
            case 27 :
                // InternalBot.g:1:166: T__37
                {
                mT__37(); 

                }
                break;
            case 28 :
                // InternalBot.g:1:172: T__38
                {
                mT__38(); 

                }
                break;
            case 29 :
                // InternalBot.g:1:178: T__39
                {
                mT__39(); 

                }
                break;
            case 30 :
                // InternalBot.g:1:184: T__40
                {
                mT__40(); 

                }
                break;
            case 31 :
                // InternalBot.g:1:190: T__41
                {
                mT__41(); 

                }
                break;
            case 32 :
                // InternalBot.g:1:196: T__42
                {
                mT__42(); 

                }
                break;
            case 33 :
                // InternalBot.g:1:202: T__43
                {
                mT__43(); 

                }
                break;
            case 34 :
                // InternalBot.g:1:208: T__44
                {
                mT__44(); 

                }
                break;
            case 35 :
                // InternalBot.g:1:214: T__45
                {
                mT__45(); 

                }
                break;
            case 36 :
                // InternalBot.g:1:220: T__46
                {
                mT__46(); 

                }
                break;
            case 37 :
                // InternalBot.g:1:226: T__47
                {
                mT__47(); 

                }
                break;
            case 38 :
                // InternalBot.g:1:232: T__48
                {
                mT__48(); 

                }
                break;
            case 39 :
                // InternalBot.g:1:238: T__49
                {
                mT__49(); 

                }
                break;
            case 40 :
                // InternalBot.g:1:244: T__50
                {
                mT__50(); 

                }
                break;
            case 41 :
                // InternalBot.g:1:250: T__51
                {
                mT__51(); 

                }
                break;
            case 42 :
                // InternalBot.g:1:256: T__52
                {
                mT__52(); 

                }
                break;
            case 43 :
                // InternalBot.g:1:262: T__53
                {
                mT__53(); 

                }
                break;
            case 44 :
                // InternalBot.g:1:268: T__54
                {
                mT__54(); 

                }
                break;
            case 45 :
                // InternalBot.g:1:274: T__55
                {
                mT__55(); 

                }
                break;
            case 46 :
                // InternalBot.g:1:280: T__56
                {
                mT__56(); 

                }
                break;
            case 47 :
                // InternalBot.g:1:286: T__57
                {
                mT__57(); 

                }
                break;
            case 48 :
                // InternalBot.g:1:292: T__58
                {
                mT__58(); 

                }
                break;
            case 49 :
                // InternalBot.g:1:298: T__59
                {
                mT__59(); 

                }
                break;
            case 50 :
                // InternalBot.g:1:304: T__60
                {
                mT__60(); 

                }
                break;
            case 51 :
                // InternalBot.g:1:310: T__61
                {
                mT__61(); 

                }
                break;
            case 52 :
                // InternalBot.g:1:316: T__62
                {
                mT__62(); 

                }
                break;
            case 53 :
                // InternalBot.g:1:322: T__63
                {
                mT__63(); 

                }
                break;
            case 54 :
                // InternalBot.g:1:328: T__64
                {
                mT__64(); 

                }
                break;
            case 55 :
                // InternalBot.g:1:334: T__65
                {
                mT__65(); 

                }
                break;
            case 56 :
                // InternalBot.g:1:340: T__66
                {
                mT__66(); 

                }
                break;
            case 57 :
                // InternalBot.g:1:346: T__67
                {
                mT__67(); 

                }
                break;
            case 58 :
                // InternalBot.g:1:352: T__68
                {
                mT__68(); 

                }
                break;
            case 59 :
                // InternalBot.g:1:358: T__69
                {
                mT__69(); 

                }
                break;
            case 60 :
                // InternalBot.g:1:364: T__70
                {
                mT__70(); 

                }
                break;
            case 61 :
                // InternalBot.g:1:370: T__71
                {
                mT__71(); 

                }
                break;
            case 62 :
                // InternalBot.g:1:376: T__72
                {
                mT__72(); 

                }
                break;
            case 63 :
                // InternalBot.g:1:382: T__73
                {
                mT__73(); 

                }
                break;
            case 64 :
                // InternalBot.g:1:388: T__74
                {
                mT__74(); 

                }
                break;
            case 65 :
                // InternalBot.g:1:394: T__75
                {
                mT__75(); 

                }
                break;
            case 66 :
                // InternalBot.g:1:400: T__76
                {
                mT__76(); 

                }
                break;
            case 67 :
                // InternalBot.g:1:406: T__77
                {
                mT__77(); 

                }
                break;
            case 68 :
                // InternalBot.g:1:412: T__78
                {
                mT__78(); 

                }
                break;
            case 69 :
                // InternalBot.g:1:418: T__79
                {
                mT__79(); 

                }
                break;
            case 70 :
                // InternalBot.g:1:424: T__80
                {
                mT__80(); 

                }
                break;
            case 71 :
                // InternalBot.g:1:430: T__81
                {
                mT__81(); 

                }
                break;
            case 72 :
                // InternalBot.g:1:436: T__82
                {
                mT__82(); 

                }
                break;
            case 73 :
                // InternalBot.g:1:442: T__83
                {
                mT__83(); 

                }
                break;
            case 74 :
                // InternalBot.g:1:448: T__84
                {
                mT__84(); 

                }
                break;
            case 75 :
                // InternalBot.g:1:454: T__85
                {
                mT__85(); 

                }
                break;
            case 76 :
                // InternalBot.g:1:460: T__86
                {
                mT__86(); 

                }
                break;
            case 77 :
                // InternalBot.g:1:466: T__87
                {
                mT__87(); 

                }
                break;
            case 78 :
                // InternalBot.g:1:472: T__88
                {
                mT__88(); 

                }
                break;
            case 79 :
                // InternalBot.g:1:478: T__89
                {
                mT__89(); 

                }
                break;
            case 80 :
                // InternalBot.g:1:484: T__90
                {
                mT__90(); 

                }
                break;
            case 81 :
                // InternalBot.g:1:490: T__91
                {
                mT__91(); 

                }
                break;
            case 82 :
                // InternalBot.g:1:496: T__92
                {
                mT__92(); 

                }
                break;
            case 83 :
                // InternalBot.g:1:502: T__93
                {
                mT__93(); 

                }
                break;
            case 84 :
                // InternalBot.g:1:508: T__94
                {
                mT__94(); 

                }
                break;
            case 85 :
                // InternalBot.g:1:514: T__95
                {
                mT__95(); 

                }
                break;
            case 86 :
                // InternalBot.g:1:520: T__96
                {
                mT__96(); 

                }
                break;
            case 87 :
                // InternalBot.g:1:526: T__97
                {
                mT__97(); 

                }
                break;
            case 88 :
                // InternalBot.g:1:532: T__98
                {
                mT__98(); 

                }
                break;
            case 89 :
                // InternalBot.g:1:538: T__99
                {
                mT__99(); 

                }
                break;
            case 90 :
                // InternalBot.g:1:544: T__100
                {
                mT__100(); 

                }
                break;
            case 91 :
                // InternalBot.g:1:551: T__101
                {
                mT__101(); 

                }
                break;
            case 92 :
                // InternalBot.g:1:558: T__102
                {
                mT__102(); 

                }
                break;
            case 93 :
                // InternalBot.g:1:565: T__103
                {
                mT__103(); 

                }
                break;
            case 94 :
                // InternalBot.g:1:572: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 95 :
                // InternalBot.g:1:580: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 96 :
                // InternalBot.g:1:589: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 97 :
                // InternalBot.g:1:601: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 98 :
                // InternalBot.g:1:617: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 99 :
                // InternalBot.g:1:633: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 100 :
                // InternalBot.g:1:641: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\31\66\6\uffff\1\64\6\uffff\6\66\1\64\2\uffff\3\64\2\uffff\1\66\1\uffff\2\66\1\u0089\1\u008a\1\u008b\3\66\1\u008f\1\u0090\1\u0092\1\u0093\1\66\1\u0095\1\u0096\1\66\1\u0098\2\66\1\u009b\1\u009c\1\u009f\1\66\1\u00a2\1\u00a3\1\u00a4\1\66\1\u00a6\1\u00a7\1\u00a8\1\u00a9\3\66\1\u00ae\1\66\1\u00b1\1\66\1\u00b3\1\u00b4\1\66\1\u00b6\3\66\1\u00bb\1\u00be\1\u00bf\7\66\15\uffff\6\66\5\uffff\3\66\3\uffff\3\66\2\uffff\1\66\2\uffff\1\66\2\uffff\1\66\1\uffff\2\66\2\uffff\2\66\1\uffff\2\66\3\uffff\1\66\4\uffff\4\66\1\uffff\2\66\1\uffff\1\66\2\uffff\1\66\1\uffff\4\66\1\uffff\2\66\2\uffff\1\u00ef\12\66\1\u00fa\3\66\1\u00fe\1\u0100\1\u0101\1\66\1\u0103\1\66\1\u0105\1\u0107\12\66\1\u0112\5\66\1\u0119\5\66\1\u011f\1\66\1\uffff\1\u0121\1\u0122\10\66\1\uffff\3\66\4\uffff\1\u012e\1\uffff\1\66\1\uffff\1\66\1\uffff\1\u0131\1\u0132\2\66\1\u0135\5\66\1\uffff\6\66\1\uffff\5\66\1\uffff\1\66\2\uffff\5\66\1\u014d\2\66\1\u0150\2\66\1\uffff\1\u0153\1\66\2\uffff\2\66\1\uffff\1\66\1\u0158\1\u0159\1\66\1\u015b\21\66\1\u016e\1\uffff\2\66\1\uffff\1\u0171\2\uffff\3\66\1\u0175\2\uffff\1\66\1\uffff\1\u0177\1\66\1\u0179\1\u017a\3\66\1\u017e\1\uffff\1\u017f\1\66\1\u0181\3\66\1\u0185\2\66\1\uffff\1\66\1\u0189\1\uffff\1\u018a\1\66\1\u018c\1\uffff\1\u018d\1\uffff\1\66\3\uffff\1\u018f\1\u0190\2\uffff\1\66\2\uffff\1\66\1\u0193\1\uffff\1\66\1\u0195\1\u0196\2\uffff\1\66\2\uffff\1\66\2\uffff\1\u0199\1\u019a\1\uffff\1\u019b\2\uffff\1\66\1\u019d\3\uffff\1\u019e\2\uffff";
    static final String DFA12_eofS =
        "\u019f\uffff";
    static final String DFA12_minS =
        "\1\0\2\145\1\155\1\141\1\154\1\141\1\151\1\164\1\144\1\156\1\145\1\141\1\157\1\141\1\145\1\153\1\150\1\143\2\141\1\145\1\123\1\117\1\150\1\141\6\uffff\1\76\6\uffff\1\151\1\145\1\122\1\155\1\165\1\141\1\101\2\uffff\2\0\1\52\2\uffff\1\170\1\uffff\1\170\1\155\3\60\1\141\1\147\1\155\4\60\1\157\2\60\1\141\1\60\1\156\1\141\3\60\1\114\3\60\1\141\4\60\1\163\1\162\1\157\1\60\1\161\1\60\1\145\2\60\1\164\1\60\1\141\1\155\1\160\3\60\1\164\1\117\1\122\1\154\1\141\1\155\1\156\15\uffff\1\155\1\147\1\114\1\160\1\164\1\154\5\uffff\2\164\1\145\3\uffff\1\147\1\145\1\142\2\uffff\1\141\2\uffff\1\141\2\uffff\1\164\1\uffff\1\157\1\147\2\uffff\1\145\1\165\1\uffff\2\151\3\uffff\1\144\4\uffff\1\164\1\141\1\164\1\155\1\uffff\1\165\1\160\1\uffff\1\162\2\uffff\1\151\1\uffff\1\164\1\160\2\164\1\uffff\1\153\1\151\2\uffff\1\60\1\116\1\115\1\154\1\164\1\160\1\147\1\160\1\145\1\160\1\165\1\60\2\164\1\165\3\60\1\145\1\60\1\145\2\60\1\164\1\163\1\165\1\156\1\145\1\156\1\164\1\163\1\164\1\145\1\60\1\155\1\145\1\160\1\145\1\157\1\60\1\157\1\142\1\157\1\151\1\157\1\60\1\143\1\uffff\2\60\2\142\1\157\1\165\1\154\1\170\1\157\1\145\1\uffff\1\171\1\157\1\145\4\uffff\1\60\1\uffff\1\162\1\uffff\1\171\1\uffff\2\60\1\163\1\171\1\60\1\164\1\163\1\164\1\151\1\162\1\uffff\1\145\1\162\1\164\1\163\1\162\1\156\1\uffff\1\156\1\157\1\163\1\157\1\156\1\uffff\1\101\2\uffff\1\141\1\157\1\163\1\141\1\145\1\60\1\156\1\163\1\60\1\156\1\72\1\uffff\1\60\1\160\2\uffff\1\137\1\155\1\uffff\1\163\2\60\1\145\1\60\1\163\1\164\1\156\1\163\1\164\1\145\1\163\1\72\1\164\1\151\1\156\1\163\1\165\1\143\1\164\1\151\1\147\1\60\1\uffff\1\163\1\164\1\uffff\1\60\2\uffff\1\145\1\143\1\163\1\60\2\uffff\1\163\1\uffff\1\60\1\145\2\60\1\56\1\144\1\145\1\60\1\uffff\1\60\1\164\1\60\1\72\1\164\1\153\1\60\1\164\1\145\1\uffff\1\145\1\60\1\uffff\1\60\1\157\1\60\1\uffff\1\60\1\uffff\1\162\3\uffff\2\60\2\uffff\1\145\2\uffff\1\150\1\60\1\uffff\1\145\2\60\2\uffff\1\144\2\uffff\1\163\2\uffff\2\60\1\uffff\1\60\2\uffff\1\145\1\60\3\uffff\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\145\1\162\1\155\1\141\1\165\1\145\1\162\1\171\1\164\1\163\1\151\1\141\1\157\1\164\1\165\1\163\1\150\1\162\1\172\1\165\1\162\1\123\1\141\1\157\1\141\6\uffff\1\76\6\uffff\1\151\1\145\1\122\1\155\1\165\1\141\1\172\2\uffff\2\uffff\1\57\2\uffff\1\170\1\uffff\1\170\1\155\3\172\1\141\1\147\1\155\4\172\1\157\2\172\1\141\1\172\1\156\1\141\3\172\1\114\3\172\1\141\4\172\1\163\1\164\1\157\1\172\1\163\1\172\1\145\2\172\1\164\1\172\1\141\1\155\1\160\3\172\1\164\1\117\1\122\1\154\1\141\1\155\1\156\15\uffff\1\155\1\163\1\114\1\160\1\164\1\154\5\uffff\2\164\1\145\3\uffff\1\147\1\145\1\142\2\uffff\1\145\2\uffff\1\167\2\uffff\1\164\1\uffff\1\157\1\147\2\uffff\1\145\1\165\1\uffff\2\151\3\uffff\1\144\4\uffff\1\164\1\141\1\164\1\155\1\uffff\1\165\1\160\1\uffff\1\162\2\uffff\1\151\1\uffff\1\164\1\160\2\164\1\uffff\1\153\1\151\2\uffff\1\172\1\116\1\115\1\154\1\164\1\160\1\147\1\160\1\145\1\160\1\165\1\172\2\164\1\165\3\172\1\145\1\172\1\145\2\172\1\164\1\163\1\165\1\156\1\145\1\156\1\164\1\163\1\164\1\145\1\172\1\155\1\145\1\160\1\151\1\157\1\172\1\157\1\142\1\157\1\151\1\157\1\172\1\143\1\uffff\2\172\2\142\1\157\1\165\1\154\1\170\1\157\1\145\1\uffff\1\171\1\157\1\145\4\uffff\1\172\1\uffff\1\162\1\uffff\1\171\1\uffff\2\172\1\163\1\171\1\172\1\164\1\163\1\164\1\171\1\162\1\uffff\1\145\1\162\1\164\1\163\1\162\1\156\1\uffff\1\156\1\157\1\163\1\157\1\156\1\uffff\1\101\2\uffff\1\141\1\157\1\163\1\141\1\145\1\172\1\156\1\163\1\172\1\156\1\72\1\uffff\1\172\1\160\2\uffff\1\137\1\155\1\uffff\1\163\2\172\1\145\1\172\1\163\1\164\1\156\1\163\1\164\1\145\2\163\1\164\1\151\1\156\1\163\1\165\1\143\1\164\1\151\1\147\1\172\1\uffff\1\163\1\164\1\uffff\1\172\2\uffff\1\145\1\143\1\163\1\172\2\uffff\1\163\1\uffff\1\172\1\145\2\172\1\56\1\144\1\145\1\172\1\uffff\1\172\1\164\1\172\1\72\1\164\1\153\1\172\1\164\1\145\1\uffff\1\145\1\172\1\uffff\1\172\1\157\1\172\1\uffff\1\172\1\uffff\1\162\3\uffff\2\172\2\uffff\1\145\2\uffff\1\150\1\172\1\uffff\1\145\2\172\2\uffff\1\144\2\uffff\1\163\2\uffff\2\172\1\uffff\1\172\2\uffff\1\145\1\172\3\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\32\uffff\1\54\1\57\1\62\1\63\1\66\1\67\1\uffff\1\100\1\101\1\102\1\103\1\104\1\106\7\uffff\1\136\1\137\3\uffff\1\143\1\144\1\uffff\1\136\67\uffff\1\54\1\57\1\62\1\63\1\66\1\67\1\72\1\100\1\101\1\102\1\103\1\104\1\106\6\uffff\1\137\1\140\1\141\1\142\1\143\3\uffff\1\34\1\35\1\74\3\uffff\1\26\1\27\1\uffff\1\16\1\17\1\uffff\1\20\1\43\1\uffff\1\33\2\uffff\1\22\1\23\2\uffff\1\70\2\uffff\1\14\1\15\1\21\1\uffff\1\24\1\25\1\30\1\31\4\uffff\1\32\2\uffff\1\36\1\uffff\1\37\1\40\1\uffff\1\41\4\uffff\1\42\2\uffff\1\45\1\44\57\uffff\1\51\12\uffff\1\120\3\uffff\1\1\1\127\1\2\1\10\1\uffff\1\4\1\uffff\1\6\1\uffff\1\13\12\uffff\1\50\6\uffff\1\71\5\uffff\1\73\1\uffff\1\46\1\47\13\uffff\1\3\2\uffff\1\7\1\56\2\uffff\1\12\27\uffff\1\111\2\uffff\1\125\1\uffff\1\131\1\5\4\uffff\1\65\1\134\1\uffff\1\76\10\uffff\1\132\11\uffff\1\107\2\uffff\1\126\3\uffff\1\55\1\uffff\1\122\1\uffff\1\112\1\77\1\105\2\uffff\1\61\1\75\1\uffff\1\124\1\130\2\uffff\1\52\3\uffff\1\117\1\123\1\uffff\1\114\1\60\1\uffff\1\135\1\115\2\uffff\1\133\1\uffff\1\53\1\116\2\uffff\1\113\1\121\1\110\1\uffff\1\64\1\11";
    static final String DFA12_specialS =
        "\1\1\57\uffff\1\2\1\0\u016d\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\64\2\63\2\64\1\63\22\64\1\63\1\64\1\60\4\64\1\61\1\44\1\45\2\64\1\33\1\34\1\46\1\62\12\57\1\32\1\35\1\64\1\40\2\64\1\43\1\56\1\53\1\30\1\56\1\52\1\27\2\56\1\3\1\26\7\56\1\50\1\47\1\1\1\51\5\56\1\41\1\64\1\42\1\55\1\56\1\64\1\22\1\24\1\23\1\6\1\12\1\7\1\25\1\13\1\11\1\14\1\15\1\31\1\4\1\5\1\56\1\16\1\56\1\17\1\10\1\2\1\20\1\54\3\56\1\21\1\36\1\64\1\37\uff82\64",
            "\1\65",
            "\1\67\2\uffff\1\71\1\70\5\uffff\1\73\2\uffff\1\72",
            "\1\74",
            "\1\75",
            "\1\77\2\uffff\1\100\5\uffff\1\76",
            "\1\101\3\uffff\1\102",
            "\1\105\2\uffff\1\103\5\uffff\1\104",
            "\1\106\1\uffff\1\107\2\uffff\1\110",
            "\1\112\10\uffff\1\111\1\114\4\uffff\1\115\1\113",
            "\1\116\4\uffff\1\117",
            "\1\121\3\uffff\1\120",
            "\1\122",
            "\1\123",
            "\1\127\12\uffff\1\124\2\uffff\1\126\2\uffff\1\130\1\uffff\1\125",
            "\1\132\17\uffff\1\131",
            "\1\133\7\uffff\1\134",
            "\1\135",
            "\1\137\16\uffff\1\136",
            "\1\143\6\uffff\1\141\6\uffff\1\142\12\uffff\1\140",
            "\1\145\23\uffff\1\144",
            "\1\147\14\uffff\1\146",
            "\1\150",
            "\1\151\21\uffff\1\152",
            "\1\153\6\uffff\1\154",
            "\1\155",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\164",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\0\u0082",
            "\0\u0082",
            "\1\u0083\4\uffff\1\u0084",
            "",
            "",
            "\1\u0086",
            "",
            "\1\u0087",
            "\1\u0088",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0091\6\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0094",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0097",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0099",
            "\1\u009a",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\17\66\1\u009e\3\66\1\u009d\6\66",
            "\1\u00a0",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00a1\6\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00a5",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00aa",
            "\1\u00ab\1\uffff\1\u00ac",
            "\1\u00ad",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00af\1\uffff\1\u00b0",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00b2",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00b5",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00ba\6\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u00bc\17\66\1\u00bd\7\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c7",
            "\1\u00c8\11\uffff\1\u00ca\1\uffff\1\u00c9",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "",
            "",
            "",
            "",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "",
            "",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "",
            "",
            "\1\u00d6\3\uffff\1\u00d5",
            "",
            "",
            "\1\u00d7\25\uffff\1\u00d8",
            "",
            "",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "",
            "\1\u00de",
            "\1\u00df",
            "",
            "",
            "",
            "\1\u00e0",
            "",
            "",
            "",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "\1\u00e6",
            "",
            "\1\u00e7",
            "",
            "",
            "\1\u00e8",
            "",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\u00ff\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0102",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0104",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\23\66\1\u0106\6\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116\3\uffff\1\u0117",
            "\1\u0118",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0120",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\u012c",
            "\1\u012d",
            "",
            "",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u012f",
            "",
            "\1\u0130",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0133",
            "\1\u0134",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139\17\uffff\1\u013a",
            "\1\u013b",
            "",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "",
            "\1\u0147",
            "",
            "",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u014e",
            "\1\u014f",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0151",
            "\1\u0152",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0154",
            "",
            "",
            "\1\u0155",
            "\1\u0156",
            "",
            "\1\u0157",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u015a",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0164\70\uffff\1\u0163",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u016f",
            "\1\u0170",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0176",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0178",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0180",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0186",
            "\1\u0187",
            "",
            "\1\u0188",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u018b",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u018e",
            "",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0191",
            "",
            "",
            "\1\u0192",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u0194",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u0197",
            "",
            "",
            "\1\u0198",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\1\u019c",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_49 = input.LA(1);

                        s = -1;
                        if ( ((LA12_49>='\u0000' && LA12_49<='\uFFFF')) ) {s = 130;}

                        else s = 52;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='T') ) {s = 1;}

                        else if ( (LA12_0=='t') ) {s = 2;}

                        else if ( (LA12_0=='I') ) {s = 3;}

                        else if ( (LA12_0=='m') ) {s = 4;}

                        else if ( (LA12_0=='n') ) {s = 5;}

                        else if ( (LA12_0=='d') ) {s = 6;}

                        else if ( (LA12_0=='f') ) {s = 7;}

                        else if ( (LA12_0=='s') ) {s = 8;}

                        else if ( (LA12_0=='i') ) {s = 9;}

                        else if ( (LA12_0=='e') ) {s = 10;}

                        else if ( (LA12_0=='h') ) {s = 11;}

                        else if ( (LA12_0=='j') ) {s = 12;}

                        else if ( (LA12_0=='k') ) {s = 13;}

                        else if ( (LA12_0=='p') ) {s = 14;}

                        else if ( (LA12_0=='r') ) {s = 15;}

                        else if ( (LA12_0=='u') ) {s = 16;}

                        else if ( (LA12_0=='z') ) {s = 17;}

                        else if ( (LA12_0=='a') ) {s = 18;}

                        else if ( (LA12_0=='c') ) {s = 19;}

                        else if ( (LA12_0=='b') ) {s = 20;}

                        else if ( (LA12_0=='g') ) {s = 21;}

                        else if ( (LA12_0=='J') ) {s = 22;}

                        else if ( (LA12_0=='F') ) {s = 23;}

                        else if ( (LA12_0=='C') ) {s = 24;}

                        else if ( (LA12_0=='l') ) {s = 25;}

                        else if ( (LA12_0==':') ) {s = 26;}

                        else if ( (LA12_0==',') ) {s = 27;}

                        else if ( (LA12_0=='-') ) {s = 28;}

                        else if ( (LA12_0==';') ) {s = 29;}

                        else if ( (LA12_0=='{') ) {s = 30;}

                        else if ( (LA12_0=='}') ) {s = 31;}

                        else if ( (LA12_0=='=') ) {s = 32;}

                        else if ( (LA12_0=='[') ) {s = 33;}

                        else if ( (LA12_0==']') ) {s = 34;}

                        else if ( (LA12_0=='@') ) {s = 35;}

                        else if ( (LA12_0=='(') ) {s = 36;}

                        else if ( (LA12_0==')') ) {s = 37;}

                        else if ( (LA12_0=='.') ) {s = 38;}

                        else if ( (LA12_0=='S') ) {s = 39;}

                        else if ( (LA12_0=='R') ) {s = 40;}

                        else if ( (LA12_0=='U') ) {s = 41;}

                        else if ( (LA12_0=='E') ) {s = 42;}

                        else if ( (LA12_0=='B') ) {s = 43;}

                        else if ( (LA12_0=='v') ) {s = 44;}

                        else if ( (LA12_0=='^') ) {s = 45;}

                        else if ( (LA12_0=='A'||LA12_0=='D'||(LA12_0>='G' && LA12_0<='H')||(LA12_0>='K' && LA12_0<='Q')||(LA12_0>='V' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='o'||LA12_0=='q'||(LA12_0>='w' && LA12_0<='y')) ) {s = 46;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 47;}

                        else if ( (LA12_0=='\"') ) {s = 48;}

                        else if ( (LA12_0=='\'') ) {s = 49;}

                        else if ( (LA12_0=='/') ) {s = 50;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 51;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||LA12_0=='!'||(LA12_0>='#' && LA12_0<='&')||(LA12_0>='*' && LA12_0<='+')||LA12_0=='<'||(LA12_0>='>' && LA12_0<='?')||LA12_0=='\\'||LA12_0=='`'||LA12_0=='|'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_48 = input.LA(1);

                        s = -1;
                        if ( ((LA12_48>='\u0000' && LA12_48<='\uFFFF')) ) {s = 130;}

                        else s = 52;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}