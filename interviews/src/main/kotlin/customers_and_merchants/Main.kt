package customers_and_merchants

data class Transaction(val cardId: Long,
                       val merchantId: Long,
                       val category: String,
                       val amount: Double,
                       val timestamp: Long)

fun main(args: Array<String>) {
	val transactions = listOf(Transaction(1, 1, "AAP", 10.0, 100000),
	                          Transaction(1, 1, "AAP", 10.0, 100000),
	                          Transaction(2, 1, "AAP", 10.0, 100000),
	                          Transaction(1, 2, "AAP", 10.0, 100000),
	                          Transaction(3, 2, "AAP", 10.0, 100000),
	                          Transaction(3, 4, "TUN", 10.0, 100000),
	                          Transaction(1, 5, "TUN", 10.0, 100000))

	// filter transactions from same customer to same merchant
	val filteredTransactions = transactions.distinctBy { Triple(it.cardId, it.merchantId, it.category) }
	assert(filteredTransactions.size == 6)

	// group transactions per customer and then per category
	val userCategoryGroups = filteredTransactions
			.groupBy { it.cardId }
			.mapValues { it.value.groupBy { it.category } }

	// map each transaction to a triple of <mID, 1, 1> if a customer has multiple transactions for the
	// same category and <mID, 1, 0> if it doesn't
	val userCategoryMerchantPlusMinus = userCategoryGroups.mapValues {
		it.value.mapValues {
			if (it.value.size > 1) it.value.map { Triple(it.merchantId, 1, 1) }
			else it.value.map { Triple(it.merchantId, 1, 0) }
		}
	}

	// triple are moved into a list of triples
	val listOfMerchantsUserTransaction = userCategoryMerchantPlusMinus
			.flatMap { it.value.values }
			.flatMap { it }

	// count, for each merchant, how many users buys from him and how many buys from others too
	val foldedMerchants = listOfMerchantsUserTransaction.foldRight(mutableMapOf<Long, Pair<Int, Int>>()) {
		(mID, totCustomers, alsoOthers), map ->
		val value = map.getOrDefault(mID, 0 to 0)
		map[mID] = (value.first + totCustomers) to (value.second + alsoOthers)
		map
	}

	foldedMerchants.forEach {
		println("Merchant ${it.key} has ${it.value.second.toFloat() / it.value.first * 100}% of customers that buy from others too")
	}
}