
import java.util.Random;

public class Advice 
{

	public boolean getAdvice( int i, char c) throws BooBoo
	{
		if( i == 1 )
		{
			throw new BooBoo();
		}
		else
		if( i != 1 && c != 'z')
		{
			char[] chars = {'1','2','3','4','5','6','7','8','9'}; 
			StringBuilder sb = new StringBuilder(); 
			Random random = new Random(); 
			char ch = chars[random.nextInt(chars.length)]; 
			sb.append(ch); 
			String output = sb.toString(); 
			
			switch( output )
			{
			case "1":
				System.out.println("Whatever You Do, Always Give 100%. Unless You're Donating Blood.");
				break;
				
			case "2":
				System.out.println("Study, Sleep, Socialize. Pick Two.");
				break;
				
			case "3":
				System.out.println("Don't Sweat the Petty Things and Don't Pet the Sweaty Things");
				break;
				
			case "4":
				System.out.println("Don't Make Snow Angels in a Dog Park");
				break;
				
			case "5":
				System.out.println("In a Barbershop with Two Barbers, Choose the Barber with the Worst Haircut");
				break;
				
			case "6":
				System.out.println("Don't Squat with Your Spurs On");
				break;
				
			case "7":
				System.out.println("Therapy is Expensive. Bubble Wrap is Cheap. You Choose.");
				break;
				
			case "8":
				System.out.println("Better to Look a Gift Horse in the Mouth than to Get Caught Looking in the Other End");
				break;
				
			case "9":
				System.out.println("If at first you don't succeed, skydiving is not for you");
				break;
			default:
				System.out.println("Generaly speaking, you aren't learning much if you mouth is moving.");
			}
		}
		else throw new BooBoo();
		
		float s = i % 2;
		if( s == 0)	return true;
		else
			return false;
	}
}
