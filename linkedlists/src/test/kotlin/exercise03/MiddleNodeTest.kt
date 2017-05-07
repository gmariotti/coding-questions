package exercise03

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MiddleNodeTest {

	@Test
	fun removeMiddleNode() {
		val initialNode = Node("a", Node("b", Node("c", Node("d", Node("e")))))
		val middleNode = initialNode.next?.next?.next
		assertTrue(removeMiddle(middleNode))

		val expected = Node("a", Node("b", Node("c", Node("e"))))
		assertEquals(expected, initialNode)
	}

	@Test
	fun failRemoveLastNode() {
		val initialNode = Node("a", Node("b", Node("c")))
		val finalNode = initialNode.next?.next
		assertTrue(!removeMiddle(finalNode))
	}
}