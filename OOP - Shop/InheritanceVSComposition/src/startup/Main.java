package startup;

public class Main {
	public static void main(String[] args) {
		NewRandom nr = new NewRandom();
		NewRandomComp nrc = new NewRandomComp();
		
		System.out.println(nr.betweenInt(2,10));
		System.out.println(nrc.betweenInt(2,10));
		System.out.println();
		System.out.println(nr.betweenFloat(2,10));
		System.out.println(nrc.betweenFloat(2,10));
		System.out.println();
		System.out.println(nr.betweenDouble(2,10));
		System.out.println(nrc.betweenDouble(2,10));
		System.out.println();
		System.out.println(nr.betweenLong(2,10));
		System.out.println(nrc.betweenLong(2,10));
		
	}
}
