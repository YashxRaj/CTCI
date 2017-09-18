package nonCTCI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ForHonor {

	public static void main(String[] args) {
		File file = new File("C:/Users/ab69170/Documents/Notepad++/NewRCs.txt");
		try {
			Scanner s = new Scanner(file);
			String basic = "delete from VOIPTNM.RATE_CENTER where LATA = 100";
			String start = "'", end = "', ";
			String result = "";
			while (s.hasNextLine()) {
				String[] newLine = s.nextLine().split(",");
				String RC_STATE = newLine[2], RC_SHORT = newLine[3], RC_LONG = newLine[3], LATA = newLine[0];
				result += basic + start + RC_STATE + end + start + RC_SHORT + end + start + RC_LONG + end + LATA
						+ ");\n";
				
			}
			System.out.println(result);
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
