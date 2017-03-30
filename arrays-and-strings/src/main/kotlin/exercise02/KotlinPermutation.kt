package exercise02

fun String.isPermutation(s2: String): Boolean {
	val map1 = this.countSameChars()
	val map2 = s2.countSameChars()

	return map1 == map2
}

private fun String.countSameChars() = this.groupBy({ it -> it }, { 1 })
		.mapValues { it -> it.value.sum() }