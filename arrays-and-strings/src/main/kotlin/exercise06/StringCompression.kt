package exercise06

fun String.compress(): String {
	if (this.isEmpty()) {
		return ""
	}

	val builder = StringBuilder()
	val chars = this.toCharArray()


	var current = chars[0]
	builder.append(current)
	var counter = 1

	(1 until chars.size)
			.asSequence()
			.map { chars[it] }
			.forEach {
				if (it == current) {
					counter++
				} else {
					builder.append(counter).append(it)
					current = it
					counter = 1
				}
			}

	if (counter == 1)
		builder.append(current).append(counter)
	else
		builder.append(counter)

	val result = builder.toString()
	if (result.length >= this.length) {
		return this
	} else {
		return result
	}
}