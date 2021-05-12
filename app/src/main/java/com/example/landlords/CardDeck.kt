package com.example.landlords

class CardDeck {

    val deckOfCardsMap = mapOf(
        1 to Card("A", "C"),
        2 to Card("2", "C"),
        3 to Card("3", "C"),
        4 to Card("4", "C"),
        5 to Card("5", "C"),
        6 to Card("6", "C"),
        7 to Card("7", "C"),
        8 to Card("8", "C"),
        9 to Card("9", "C"),
        10 to Card("10", "C"),
        11 to Card("J", "C"),
        12 to Card("Q", "C"),
        13 to Card("K", "C"),
        14 to Card("A", "D"),
        15 to Card("2", "D"),
        16 to Card("3", "D"),
        17 to Card("4", "D"),
        18 to Card("5", "D"),
        19 to Card("6", "D"),
        20 to Card("7", "D"),
        21 to Card("8", "D"),
        22 to Card("9", "D"),
        23 to Card("10", "D"),
        24 to Card("J", "D"),
        25 to Card("Q", "D"),
        26 to Card("K", "D"),
        27 to Card("A", "H"),
        28 to Card("2", "H"),
        29 to Card("3", "H"),
        30 to Card("4", "H"),
        31 to Card("5", "H"),
        32 to Card("6", "H"),
        33 to Card("7", "H"),
        34 to Card("8", "H"),
        35 to Card("9", "H"),
        36 to Card("10", "H"),
        37 to Card("J", "H"),
        38 to Card("Q", "H"),
        39 to Card("K", "H"),
        40 to Card("A", "S"),
        41 to Card("2", "S"),
        42 to Card("3", "S"),
        43 to Card("4", "S"),
        44 to Card("5", "S"),
        45 to Card("6", "S"),
        46 to Card("7", "S"),
        47 to Card("8", "S"),
        48 to Card("9", "S"),
        49 to Card("10", "S"),
        50 to Card("J", "S"),
        51 to Card("Q", "S"),
        52 to Card("K", "S"),
        53 to Card("Small", "Blck"),
        54 to Card("Big", "Red"),

    )

    // returns 3 lists of hands
    fun generateHand(): List<MutableList<Card>> {
        val shuffledList = mutableListOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
            27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
            40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52,
            53, 54
        ).shuffled()

        var intList1 = shuffledList.filterIndexed { index, s ->
            (index < 18)
        }
        var intList2 = shuffledList.filterIndexed { index, s ->
            (index in 18..34)
        }
        var intList3 = shuffledList.filterIndexed { index, s ->
            (index in 35..51)
        }

        var hand1 = mapIntsToCards(intList1)
        var hand2 = mapIntsToCards(intList2)
        var hand3 = mapIntsToCards(intList3)

        var hands = listOf(hand1, hand2, hand3)

        return hands
    }

    fun mapIntsToCards(list: List<Int>): MutableList<Card> {
        val myHand = mutableListOf<Card>()
        val intsIterator = list.listIterator()

        while (intsIterator.hasNext()) {
            val x = intsIterator.next()
            val card = deckOfCardsMap.get(x)
            if (card != null) {
                myHand.add(card)
            }
        }
        print(myHand.size)
        return myHand
    }

    fun generateFakeHand(): List<Card> {
        return listOf(
            Card("K", "H"),
            Card("Q", "S"),
            Card("J", "D"),
            Card("10", "D"),
            Card("9", "D"),
            Card("8", "D"),
            Card("7", "D"),
            Card("6", "D"),
            Card("5", "D"),
            Card("4", "D"),
            Card("3", "D"),
            Card("2", "D"),
            Card("A", "D"),
        )
    }
}