package com.example.landlords

class CardDeck {

    val deckOfCardsMap = mapOf(
        1 to CardDataModel(1,"A", "C"),
        2 to CardDataModel(2,"2", "C"),
        3 to CardDataModel(3,"3", "C"),
        4 to CardDataModel(4,"4", "C"),
        5 to CardDataModel(4,"5", "C"),
        6 to CardDataModel(4,"6", "C"),
        7 to CardDataModel(4,"7", "C"),
        8 to CardDataModel(4,"8", "C"),
        9 to CardDataModel(4,"9", "C"),
        10 to CardDataModel(4,"10", "C"),
        11 to CardDataModel(4,"J", "C"),
        12 to CardDataModel(4,"Q", "C"),
        13 to CardDataModel(4,"K", "C"),
        14 to CardDataModel(4,"A", "D"),
        15 to CardDataModel(4,"2", "D"),
        16 to CardDataModel(4,"3", "D"),
        17 to CardDataModel(4,"4", "D"),
        18 to CardDataModel(4,"5", "D"),
        19 to CardDataModel(4,"6", "D"),
        20 to CardDataModel(4,"7", "D"),
        21 to CardDataModel(4,"8", "D"),
        22 to CardDataModel(4,"9", "D"),
        23 to CardDataModel(4,"10", "D"),
        24 to CardDataModel(4,"J", "D"),
        25 to CardDataModel(4,"Q", "D"),
        26 to CardDataModel(4,"K", "D"),
        27 to CardDataModel(4,"A", "H"),
        28 to CardDataModel(4,"2", "H"),
        29 to CardDataModel(4,"3", "H"),
        30 to CardDataModel(4,"4", "H"),
        31 to CardDataModel(4,"5", "H"),
        32 to CardDataModel(4,"6", "H"),
        33 to CardDataModel(4,"7", "H"),
        34 to CardDataModel(4,"8", "H"),
        35 to CardDataModel(4,"9", "H"),
        36 to CardDataModel(4,"10", "H"),
        37 to CardDataModel(4,"J", "H"),
        38 to CardDataModel(4,"Q", "H"),
        39 to CardDataModel(4,"K", "H"),
        40 to CardDataModel(4,"A", "S"),
        41 to CardDataModel(4,"2", "S"),
        42 to CardDataModel(4,"3", "S"),
        43 to CardDataModel(4,"4", "S"),
        44 to CardDataModel(4,"5", "S"),
        45 to CardDataModel(4,"6", "S"),
        46 to CardDataModel(4,"7", "S"),
        47 to CardDataModel(4,"8", "S"),
        48 to CardDataModel(4,"9", "S"),
        49 to CardDataModel(4,"10", "S"),
        50 to CardDataModel(4,"J", "S"),
        51 to CardDataModel(4,"Q", "S"),
        52 to CardDataModel(4,"K", "S"),
        53 to CardDataModel(4,"Small", "Blck"),
        54 to CardDataModel(4,"Big", "Red"),

    )

    // returns 3 lists of hands
    fun generateHand(): List<MutableList<CardDataModel>> {
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

    fun mapIntsToCards(list: List<Int>): MutableList<CardDataModel> {
        val myHand = mutableListOf<CardDataModel>()
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

//    fun generateFakeHand(): List<CardDataModel> {
//        return listOf(
//            CardDataModel("K", "H"),
//            CardDataModel("Q", "S"),
//            CardDataModel("J", "D"),
//            CardDataModel("10", "D"),
//            CardDataModel("9", "D"),
//            CardDataModel("8", "D"),
//            CardDataModel("7", "D"),
//            CardDataModel("6", "D"),
//            CardDataModel("5", "D"),
//            CardDataModel("4", "D"),
//            CardDataModel("3", "D"),
//            CardDataModel("2", "D"),
//            CardDataModel("A", "D"),
//        )
//    }
}