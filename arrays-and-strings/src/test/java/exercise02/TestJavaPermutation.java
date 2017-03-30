package exercise02;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestJavaPermutation {

	@Test
	public void isNotPermutation() {
		String s1 = "arca";
		String s2 = "barca";

		assertTrue(!JavaPermutation.isPermutation(s1, s2));
	}

	@Test
	public void isPermutation() {
		String s1 = "arca";
		String s2 = "cara";

		assertTrue(JavaPermutation.isPermutation(s1, s2));
	}
}
