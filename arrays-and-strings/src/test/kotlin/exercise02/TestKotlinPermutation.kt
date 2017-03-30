package exercise02

import org.junit.Assert.assertTrue
import org.junit.Test

class TestKotlinPermutation {

	@Test
	fun isPermutation() {
		val s1 = "comedy"
		val s2 = "mycedo"
		assertTrue(s1.isPermutation(s2))
	}
}