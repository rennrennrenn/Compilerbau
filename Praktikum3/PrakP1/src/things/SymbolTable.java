package things;
import java.util.HashMap;

public class SymbolTable{
    public HashMap<String, String> symbols = new HashMap<String,String>();

    void addConstant(String id,String wert) throws SymbolAlreadyDefinedException{
        
        if(this.symbols.containsKey(id)){
            throw new SymbolAlreadyDefinedException(id + " " + wert);
        }
        this.symbols.put(id,wert);
    }

    String getSymbol(String id) throws UnknownSymbolException{
        if(!this.symbols.containsKey(id)){
            throw new UnknownSymbolException(id);
        }
        return this.symbols.get(id);
    }           
}

