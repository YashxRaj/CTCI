package ctci;

public class test2 {

	public static void main(String[] args) {
		boolean flag = false;
		System.out.println(flag);
		int a = 5;
		int b = 6;
		invertBoolean(a, b, flag);
		System.out.println(flag);
	}

	private static void invertBoolean(int a, int b, boolean flag) {
		flag = true;
	}

}
