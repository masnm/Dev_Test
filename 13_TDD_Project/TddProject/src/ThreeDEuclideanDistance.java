
public class ThreeDEuclideanDistance {
	ThreeDEuclideanDistance(){}
	
	//This function computes the euclidean distance of two coordinates
	//What happens if the inputs are not the same lenght??
	public double computeDistance(double[] pos, double[] pos_)
	{
		if ( pos.length != pos_.length )
			throw new IllegalArgumentException (
					"Hey, both coordinate position must be the same dimension"
				);
		
		double ans = 0.0;
		for ( int i = 0; i < pos.length; i++ ) {
			double got = pos_[i] - pos[i];
			ans += ( got * got );
		}
		return Math.sqrt ( ans );
	}
}
