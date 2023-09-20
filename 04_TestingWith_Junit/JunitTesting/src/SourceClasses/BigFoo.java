package SourceClasses;

import java.util.Calendar;

public class BigFoo 
{
	private int age;
	private String name;
	private BigFoo instance;
    private static final int SCALE = 10000;  
    private static final int ARRINIT = 2000;  
  
	public void BigFoo ( String iname )
	{
		name = iname;
	}

	public BigFoo getInstance()
	{
		return instance;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int calcAge( int year, int month, int day )
	{
		if(year == 0) {
			throw new IllegalArgumentException("Invalid Year");
		}
		if(month == 0) {
			throw new IllegalArgumentException("Invalid Month");
		}
		if(day == 0) {
		}
		
		Calendar dob = Calendar.getInstance();
		dob.set(year, month, day);
		Calendar today = Calendar.getInstance();
		
		this.age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		
		if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
			this.age--;
		
		return this.age;		
	}
	
    public static String pi_digits(int digits)
    {  
        StringBuffer pi = new StringBuffer();  
        int[] arr = new int[digits + 1];  
        int carry = 0;  
  
        for (int i = 0; i <= digits; ++i)  
            arr[i] = ARRINIT;  
  
        for (int i = digits; i > 0; i-= 14) 
        {  
            int sum = 0;  
            for (int j = i; j > 0; --j) 
            {  
                sum = sum * j + SCALE * arr[j];  
                arr[j] = sum % (j * 2 - 1);  
                sum /= j * 2 - 1;
            }  
            pi.append(String.format("%04d", carry + sum / SCALE));  
            carry = sum % SCALE;  
        }  
        return pi.toString();  
    }  

    
    public static void main(String[] args) {
		BigFoo bf = new BigFoo();
		int a = bf.calcAge(0, 1, 1);
	}
}
