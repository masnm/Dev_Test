
public class Generator implements TextToInterface {

	@Override
	public char stringToOperation(String str) {
		if ( str.equals("add") ) return '+';
		return '0';
	}

}
