package SourceClasses;

/*
 * foo bar buzz
 */

public class Mathematic {
	
	private int x, y, ans;
	
	public int getX ()      { return this.x; }
	public void setX(int x) { this.x = x;    }

	public int getY ()      { return this.y; }
	public void setY(int y) { this.y = y;    }
	
	public void add () { this.ans = x + y; }
	public void sub () { this.ans = x - y; }
	public void mul () { this.ans = x * y; }
	public void div () { this.ans = x / y; }
	
	public int getAns () { return this.ans; }
	public void showAns () { System.out.println ( "Ans is " + ans + " " ); }
	
	public static int add ( int x, int y ) { return x + y; }

	public static void main(String[] args) {
		
		Mathematic obj = new Mathematic ();
		
		obj.setX ( 13 );
		obj.setY ( 12 );
		
		obj.add ();
		
		obj.showAns ();

	}

}
