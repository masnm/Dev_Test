import java.awt.Toolkit;

public class BooBoo extends Exception 
{
	public void ouch()
	{
		System.out.println("Something bad happened, no advice today");
		Toolkit.getDefaultToolkit().beep();	}
	
}
