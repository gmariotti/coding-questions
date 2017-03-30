package exercise02;


import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class JavaPermutation {
	public static boolean isPermutation(String s1, String s2) {
		Map<Character, Long> map1 = countingCharacters(s1);
		Map<Character, Long> map2 = countingCharacters(s2);

		return map1.equals(map2);
	}

	private static Map<Character, Long> countingCharacters(String word) {
		return word.chars()
		           .mapToObj(i -> (char) i)
		           .collect(groupingBy(identity(), counting()));
	}
}
