package nonCTCI;

public class GeneratePrimeList {
	/*
	 * 1 optimization: only use odd numbers in the array, reduces space
	 * usage by half.
	 */
	public static void main(String args[]) {
		// Driver code
		sieveOfEratosthenes(100);
	}

	public static boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		flags = initialize(flags);
		int prime = 2;
		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
		}
		print(flags, max);
		return flags;
	}

	private static int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next])
			next++;
		return next;
	}

	private static void crossOff(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime)
			flags[i] = false;
	}

	private static boolean[] initialize(boolean[] flags) {
		for (int i = 0; i < flags.length; i++)
			flags[i] = (i == 0 || i == 1) ? false : true;
		return flags;
	}

	private static void print(boolean[] flags, int max) {
		System.out.println("Primes until " + max + ":");
		for (int i = 0; i < flags.length; i++)
			System.out.print(flags[i] ? i + " " : "");
		System.out.println();
	}
}
