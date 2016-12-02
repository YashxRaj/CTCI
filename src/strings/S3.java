package strings;

class S3 {
	//Faster than solution given in the book.
	public static String URLify(String str, int l) {
		StringBuilder sb = new StringBuilder();
		String p ="%20";
		for (int i = 0; i < l - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == ' ') {
					sb.append(str.substring(i, j));
					sb.append(p);
					i = j;
					break;
				}
			}
		}
		sb.delete(sb.lastIndexOf(p),sb.lastIndexOf(p)+p.length());
		return sb.toString();
	}
}