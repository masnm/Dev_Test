import java.text.DecimalFormat;

public class Sigmoid {
	Sigmoid()
	{
		
	}
	
	//This function returns the sigmoid function value with two precision!!
	//two precision!!
	//Let x be the data, y be the horizontal shift, and z the steepness
	public double compute(double x, double y, double z)
	{
		double ans = 1.0 /(1.0 + Math.exp(-(y + x*z)));
		ans *= 100;
		ans = Math.round ( ans );
		ans /= 100;
		return ans;
	}
}
