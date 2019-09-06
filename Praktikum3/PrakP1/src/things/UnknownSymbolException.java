
public class UnknownSymbolException extends Exception{
    public UnknownSymbolException(String message) {
		super(message + ", Symbol doesnt exist in the current table!");
	}
}