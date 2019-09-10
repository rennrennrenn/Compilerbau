import java.util.HashMap;

public class SymbolTable{
    public HashMap<String, Pair> symbols = new HashMap<String,Pair>();
    public HashMap<String, String> memory = new HashMap<String, String>();
    
    void addVariable(String id, String addr, String value) throws SymbolAlreadyDefinedException{
        if(this.symbols.containsKey(id)){
            throw new SymbolAlreadyDefinedException(id + " " + value);
        }
        Pair<String, String> a = new Pair<String, String>();
        a.first = "VAR";
        a.second = addr;
        this.symbols.put(id,a);
        this.memory.put(addr,value);
    }
    
    void addConstant(String id,String value) throws SymbolAlreadyDefinedException{
        
        if(this.symbols.containsKey(id)){
            throw new SymbolAlreadyDefinedException(id + " " + value);
        }
        Pair<String, String> a = new Pair<String, String>();
        a.first = "CONST";
        a.second = value;
        this.symbols.put(id,a);
    }

    Pair getSymbol(String id) throws UnknownSymbolException{

        if(!this.symbols.containsKey(id)){
            throw new UnknownSymbolException(id);
        }
        Pair<String, String> a = this.symbols.get(id);        
        return a;
    }       
    
    String formatToHex(String zeros, String content) {
        int a = Integer.parseInt(content);
        String b = Integer.toHexString(a);
        return (zeros + b).substring(b.length());
    }
}