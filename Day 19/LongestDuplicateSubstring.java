package june2020;

import java.util.*;

public class LongestDuplicateSubstring {

	public static int search(int L, String S) {

		int a = 26;
		int n = S.length();
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i)
			nums[i] = (int) S.charAt(i) - (int) 'a';

		long modulus = (long) Math.pow(2, 32);

		long hash = 0;
		for (int i = 0; i < L; ++i)
			hash = (hash * a + nums[i]) % modulus;

		HashSet<Long> seen = new HashSet<>();
		seen.add(hash);

		long aL = 1;
		for (int i = 1; i <= L; ++i)
			aL = (aL * a) % modulus;

		for (int start = 1; start < n - L + 1; ++start) {
			hash = (hash * a - nums[start - 1] * aL % modulus + modulus) % modulus;
			hash = (hash + nums[start + L - 1]) % modulus;
			if (seen.contains(hash))
				return start;
			seen.add(hash);
		}
		return -1;
	}

	public static String longestDupSubstring(String S) {
		int n = S.length();

		int lo = 1, hi = n;
		int mid;
		while (lo != hi) {
			mid = lo + (hi - lo) / 2;
			if (search(mid, S) != -1)
				lo = mid + 1;
			else
				hi = mid;
		}

		int start = search(lo - 1, S);
		return start != -1 ? S.substring(start, start + lo - 1) : "";
	}

	public static void main(String[] args) {
		System.out
				.println(longestDupSubstring("bananaajasvdghxwvsgvavghaksbjhxbjhsghsggaaaasjjjsjaananananananananana"));
	}

}
