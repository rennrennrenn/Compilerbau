/* Generated By:JavaCC: Do not edit this line. ExprsParse.java */
    public class ExprsParse implements ExprsParseConstants {
        private static SymbolTable st = new SymbolTable();
        public static void main(String args []) {
            ExprsParse parser = new ExprsParse(System.in);
           try {
                parser.start();
                System.out.println("Ausdruck ok");
            } catch (Exception e) {
                System.out.println("Ausdruck nicht ok");
                System.out.println(e);
            }
        }

  static final public void start() throws ParseException, SymbolAlreadyDefinedException, UnknownSymbolException {
         st.addConstant("final", "");
         st.addConstant("int", "");
    programm();
    jj_consume_token(0);
  }

  static final public void programm() throws ParseException, SymbolAlreadyDefinedException, UnknownSymbolException {
    String a = null;
    constDecl();
    a = expression();
                                 System.out.println(a);
  }

  static final public void constDecl() throws ParseException, SymbolAlreadyDefinedException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 7:
      jj_consume_token(7);
      constZuw();
      constList();
      jj_consume_token(8);
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
  }

  static final public void constZuw() throws ParseException, SymbolAlreadyDefinedException {
    Token a;
    Token b;
    a = jj_consume_token(IDENT);
    jj_consume_token(9);
    b = jj_consume_token(NUMBER);
      st.addConstant(a.image.toString(), b.image.toString());
  }

  static final public void constList() throws ParseException, SymbolAlreadyDefinedException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 10:
      jj_consume_token(10);
      constZuw();
      constList();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  static final public String expression() throws ParseException, UnknownSymbolException {
    String a= null;
    String b= null;
    a = term();
    b = sum();
                      {if (true) return a+b;}
    throw new Error("Missing return statement in function");
  }

  static final public String sum() throws ParseException, UnknownSymbolException {
    String a= null;
    String b= null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 11:
    case 12:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 11:
        jj_consume_token(11);
        a = term();
        b = sum();
                            {if (true) return a+b +"+";}
        break;
      case 12:
        jj_consume_token(12);
        a = term();
        b = sum();
                           {if (true) return a+ b +"-";}
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
     {if (true) return "";}
    throw new Error("Missing return statement in function");
  }

  static final public String term() throws ParseException, UnknownSymbolException {
    String a= null;
    String b= null;
    a = faktor();
    b = product();
                             {if (true) return a+b;}
    throw new Error("Missing return statement in function");
  }

  static final public String product() throws ParseException, UnknownSymbolException {
    String a = null;
    String b = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 13:
    case 14:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 13:
        jj_consume_token(13);
        a = faktor();
        b = product();
                                 {if (true) return a + b + "*";}
        break;
      case 14:
        jj_consume_token(14);
        a = faktor();
        b = product();
                                  {if (true) return a + b + "/";}
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
     {if (true) return "";}
    throw new Error("Missing return statement in function");
  }

  static final public String faktor() throws ParseException, UnknownSymbolException {
    Token a;
    Token b;
    String s = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      a = jj_consume_token(NUMBER);
                {if (true) return a.image.toString();}
      break;
    case IDENT:
      b = jj_consume_token(IDENT);
                 {if (true) return st.getSymbol(b.image.toString());}
      break;
    case 15:
      jj_consume_token(15);
      s = expression();
      jj_consume_token(16);
                              {if (true) return s;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ExprsParseTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x400,0x1800,0x1800,0x6000,0x6000,0x8060,};
   }

  /** Constructor with InputStream. */
  public ExprsParse(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ExprsParse(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ExprsParseTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ExprsParse(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ExprsParseTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ExprsParse(ExprsParseTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ExprsParseTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

    }
