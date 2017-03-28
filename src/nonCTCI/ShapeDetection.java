package nonCTCI;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ShapeDetection {
	static double[][] lengths;
	static double[][] points;
	static HashMap<double[], Character> reverseNamedPoints;
	static HashMap<Character, double[]> namedPoints;
	static HashMap<String, Double> edges;
	static HashMap<Double, String> reverseEdges;

	public static void main(String[] args) {
		setNumberAndGetPoints();
		setAndPrintNamesOfPoints();
		calculateAndPrintEdges();
		detectSquares();
	}

	private static void detectSquares() {
		
	}

	public static double sizeOfEdge(char x, char y) {
		String str = x + "" + y, revStr = y + "" + x;
		return edges.containsKey(str) ? edges.get(str) : edges.get(revStr);
	}

	private static void setAndPrintNamesOfPoints() {
		// Setting Names.
		reverseNamedPoints = new HashMap<double[], Character>();
		int x = 65;
		for (int i = 0; i < points.length; i++)
			reverseNamedPoints.put(points[i], (char) x++);
		// Printing Names.
		StringBuffer s = new StringBuffer();
		DecimalFormat df = new DecimalFormat("#.##");
		s.append("Point - Name");
		s.append(System.lineSeparator());
		for (int i = 0; i < points.length; i++) {
			s.append("[" + df.format(points[i][0]) + "," + df.format(points[i][1]) + "]" + " - ");
			s.append(reverseNamedPoints.get(points[i]));
			s.append(System.lineSeparator());
		}
		System.out.println(s.toString());
	}

	private static void calculateAndPrintEdges() {
		// Calculating edges and reverseEdges.
		edges = new HashMap<String, Double>();
		reverseEdges = new HashMap<Double, String>();
		for (int i = 0; i < points.length; i++)
			for (int j = 0; j < points.length; j++) {
				char x = reverseNamedPoints.get(points[i]), y = reverseNamedPoints.get(points[j]);
				String str = x + "" + y, revStr = y + "" + x;
				if (x == y || edges.containsKey(revStr))
					continue;
				if (x != y && !edges.containsKey(str)) {
					double temp = Math.sqrt(Math.pow(Math.abs(points[i][0] - points[j][0]), 2)
							+ Math.pow(Math.abs(points[i][1] - points[j][1]), 2));
					edges.put(str, temp);
					reverseEdges.put(temp, reverseEdges.containsKey(temp) ? reverseEdges.get(temp) + "," + str : str);
				}
			}
		// Printing edges.
		StringBuffer s = new StringBuffer();
		DecimalFormat df = new DecimalFormat("0.00");
		s.append("Length - Edges");
		s.append(System.lineSeparator());
		for (Double d : reverseEdges.keySet()) {
			s.append(df.format(d));
			s.append(" - ");
			s.append(reverseEdges.get(d));
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
