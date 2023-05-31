package startup;

public class IllegalNegativeParameterException extends RuntimeException{

		public IllegalNegativeParameterException () {}
		
		public void errorMessage() {
			System.out.println("Negative parameters are not allowed");
		}
}
