package startup;

public class Main {
	public static void main(String[] args) {
		SwedishTime st = new SwedishTime();
		st.set(2004, 3, 11, 6, 11);
		st.println();
		System.out.println(st.toString());
	}
}
