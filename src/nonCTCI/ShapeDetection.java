package nonCTCI;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class ShapeDetection {
	static double[][] lengths;
	static double[][] points;
	static HashMap<double[], Character> reverseNamedPoints;
	static HashMap<Character, double[]> namedPoints;
	static HashMap<String, Double> mappedLengths;

	// Will require add points, remove points, update points functions.
	// Remove main.
	// Add constructor.
	ShapeDetection() {
	}

	public static void main(String[] args) {
		setNumberAndGetPoints();
		setAndPrintNamesOfPoints();
		calculateAndPrintEdges();
		detectSquares();
	}

	private static double distanceBetween(char x, char y) {
		return mappedLengths.get(x + y + "");
	}

	private static void detectSquares() {

		StringBuffer s = new StringBuffer();
		for (String x : mappedLengths.keySet())
			for (String y : mappedLengths.keySet())
				if (!x.equals(y) && mappedLengths.get(x) == mappedLengths.get(y))
					s.append(x + y + "");
		char[] ch = s.toString().toCharArray();
		HashMap<Character, Integer> check = new HashMap<Character, Integer>();
		for (int i = 0; i < ch.length - 1; i++)
			check.put(ch[i], check.get(ch[i]) + 1);
		boolean p = false;
		System.out.println(ch.length);
		for (int i = 1; i < ch.length; i += 2)
			if (check.containsValue(i))
				p = true;
		System.out.println(p == false ? " is a square." : "No squares found.");
	}

	private static void setAndPrintNamesOfPoints() {
		// Setting Names.
		reverseNamedPoints = new HashMap<double[], Character>();
		int x = 65;
		for (int i = 0; i < points.length; i++)
			reverseNamedPoints.put(points[i], (char) x++);
		// Printing Names.
		StringBuffer s = new StringBuffer();
		s.append("Point - Name");
		s.append(System.lineSeparator());
		for (int i = 0; i < points.length; i++) {
			s.append(points[i][0] + "," + points[i][1] + " - ");
			s.append(reverseNamedPoints.get(points[i]));
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	private static void calculateAndPrintEdges() {
		// Calculating lengths of edges.
		mappedLengths = new HashMap<String, Double>();
		for (int i = 0; i < points.length; i++)
			for (int j = 0; j < points.length; j++) {
				char x = reverseNamedPoints.get(points[i]), y = reverseNamedPoints.get(points[j]);
				if (!mappedLengths.containsKey(x + y + "") && !mappedLengths.containsKey(y + x + "")) {
					double temp = Math.sqrt(Math.pow(Math.abs(points[i][0] - points[j][0]), 2)
							+ Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
					mappedLengths.put(x + y + "", temp);
					mappedLengths.put(y + x + "", temp);
				}
			}
		// Printing lengths.
		StringBuffer s = new StringBuffer();
		DecimalFormat df = new DecimalFormat("0.00");
		s.append("Points and their lengths:");
		s.append(System.lineSeparator());
		s.append(System.lineSeparator());
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				char x = reverseNamedPoints.get(points[i]), y = reverseNamedPoints.get(points[j]);
				s.append(x + " : " + y + " - ");
				s.append(df.format(mappedLengths.get(x + y + "")));
				s.append(System.lineSeparator());
			}
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	private static void setNumberAndGetPoints() {
		// Setting Number
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int n = s.nextInt();
		points = new double[n][2];
		// Getting points.
		System.out.println("Enter the points:");
		s.nextLine();
		for (int i = 0; i < n; i++) {
			Scanner scan = new Scanner(s.nextLine());
			scan.useDelimiter(",");
			points[i][0] = scan.nextInt();
			points[i][1] = scan.nextInt();
			scan.close();
		}
		s.close();
	}

}
