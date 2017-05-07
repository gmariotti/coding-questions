package exercise06

import org.junit.Test
import org.junit.Assert.assertEquals

class TestStringCompression {

	@Test
	fun checkCompression() {
		val s1 = "bbaaacca"
		val s2 = "aabcccccaaa"
		val s3 = ""

		assertEquals(s1, s1.compress())
		assertEquals("a2b1c5a3", s2.compress())
		assertEquals(s3, s3.compress())
	}
}