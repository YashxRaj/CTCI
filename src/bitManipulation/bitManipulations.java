package bitManipulation;

public class bitManipulations {

	public static void insertion() {
		
	}

	private static int getBit(int num, int i) {
		return ((num & (1 << i)) != 0) == false ? 0 : 1;
	}

	private static int setBit(int num, int i) {
		return num | (1 << i);
	}

	private static int clearBit(int num, int i) {
		return num & ~(1 << i);
	}

	private static int clearBitsMSBThroughI(int num, int i) {
		return num & ((1 << i) - 1);
	}

	private static int clearBitsIThrough0(int num, int i) {
		return num & (-1 << (i + 1));
	}

	private static int updateBit(int num, int i, boolean bitIs1) {
		return num & (~(1 << i)) | ((bitIs1 ? 1 : 0) << i);
	}
}
