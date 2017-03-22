package ctci;

import linkedLists.LL;

public class test2 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (LL.chance())
				System.out.println(i + " - 1");
			else if (LL.chance())
				System.out.println(i + " - 2");
			else
				System.out.println(i + " - 3");
		}
	}

}
