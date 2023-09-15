
public class StackTraceDemo {

	public static void main(String[] args) {
		System.out.println("Starting main method");
		m1(); // call m1
		System.out.println("End main method");
	}

	static void m1() {
		System.out.println("In method m1()");
		m2(); // call m2
	}

	static void m2() {
		int x = 10;
		try {
			System.out.println("In method m2()");
			double z = x / 1; // an exception is thrown here
			System.out.println(z);
		} catch (Exception ex) {
			System.out.println();
			ex.printStackTrace();
		}
	}

}

/*
-------------------------------
|A,23,{0bj}
-------------------------------
*/

