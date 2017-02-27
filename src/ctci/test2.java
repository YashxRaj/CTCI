package ctci;

public class test2 {

	public static void main(String[] args) {
		int num = 21;
		for (int i = 0; i < String.valueOf(Integer.toBinaryString(num)).length(); i++)
			System.out.println(getBit(num, i));
	}

	private static int getBit(int num, int i) {
		return ((num & (1 << i)) != 0) == false ? 0 : 1;
	}
}
