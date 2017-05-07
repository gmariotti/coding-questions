package exercise03

data class Node(var value: String, var next: Node? = null)

fun removeMiddle(node: Node?): Boolean {
	val next = node?.next?: return false
	node.value = next.value
	node.next = next.next
	return true
}