public class SymbolAlreadyDefinedException extends Exception{
    public SymbolAlreadyDefinedException(String message) {
		super(message + ", Symbol already exist in the current table!");
	}
}