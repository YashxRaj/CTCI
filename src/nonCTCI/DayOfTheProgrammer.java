package nonCTCI;

import java.util.HashMap;
import java.util.Scanner;

public class DayOfTheProgrammer {
	private static String solve(int year) {
		return dotP(year, fillMonths(year, year < 1918 ? 1 : year == 1918 ? 2 : 3));
	}

	private static String dotP(int year, HashMap<Integer, Integer> months) {
		int i, dotp = 256;
		for (i = 1; i <= 12; i++) {
			if (dotp >= months.get(i)) dotp -= months.get(i);
			else break;
		}
		i=dotp==0?i-1:i;
		dotp=dotp==0?months.get(i):dotp;
		return (dotp<10?"0"+dotp:Integer.toString(dotp))+"."+(i<10?"0"+i:Integer.toString(i))+"."+year;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(solve(Integer.parseInt(in.nextLine())));
		in.close();
	}

	private static HashMap<Integer, Integer> fillMonths(int year, int j) {
		HashMap<Integer, Integer> months = new HashMap<>();
		months.put(1, 31);
		months.put(2, j==1?(year%4==0?29:28):(j==2?15:((year%4==0&&year%100!=0)||(year%400==0))?29:28));
		months.put(3, 31);
		months.put(4, 30);
		months.put(5, 31);
		months.put(6, 30);
		months.put(7, 31);
		months.put(8, 31);
		months.put(9, 30);
		months.put(10, 31);
		months.put(11, 30);
		months.put(12, 31);
		return months;
	}
}
