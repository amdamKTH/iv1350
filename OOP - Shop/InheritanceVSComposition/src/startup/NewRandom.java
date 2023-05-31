package startup;
import java.util.Random;

public class NewRandom extends Random {
	
	public int betweenInt(int lower, int upper) {
		if (lower < 0 || upper < 0) {
			throw new IllegalNegativeParameterException();
		}
		
		if (lower > upper) {
			throw new IllegalOrderParameterException();
		}
		double randInt = this.nextDouble();
		double diff = upper - lower;
		return (int)((diff * randInt) + lower);
	}
	
	public float betweenFloat(float lower, float upper) {
		if (lower < 0 || upper < 0) {
			throw new IllegalNegativeParameterException();
		}
		
		if (lower > upper) {
			throw new IllegalOrderParameterException();
		}
		double randInt = this.nextDouble();
		double diff = upper - lower;
		return (float)((diff * randInt) + lower);
	}
	
	public double betweenDouble(double lower, double upper) {
		if (lower < 0 || upper < 0) {
			throw new IllegalNegativeParameterException();
		}
		
		if (lower > upper) {
			throw new IllegalOrderParameterException();
		}
		double randInt = this.nextDouble();
		double diff = upper - lower;
		return ((diff * randInt) + lower);
	}
	
	public long betweenLong(long lower, long upper) {
		if (lower < 0 || upper < 0) {
			throw new IllegalNegativeParameterException();
		}
		
		if (lower > upper) {
			throw new IllegalOrderParameterException();
		}
		double randInt = this.nextDouble();
		double diff = upper - lower;
		return (long)((diff * randInt) + lower);
	}
}
