
public class Calculator {
	
	public int calculate ( char op, int left, int right ) {
		int ans = 0;
		if ( op == '+' ) ans = left + right;
		if ( op == '-' ) ans = left - right;
		if ( op == '*' ) ans = left * right;
		if ( op == '/' ) ans = left / right;
		return ans;
	}
}
