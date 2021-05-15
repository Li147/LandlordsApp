package com.example.landlords

class CardDeck {

    val deckOfCardsMap = mapOf(
        1 to CardDataModel(1,"A", "C", R.drawable.card_ac),
        2 to CardDataModel(2,"2", "C", R.drawable.card_2c),
        3 to CardDataModel(3,"3", "C", R.drawable.card_3c),
        4 to CardDataModel(4,"4", "C", R.drawable.card_4c),
        5 to CardDataModel(4,"5", "C", R.drawable.card_5c),
        6 to CardDataModel(4,"6", "C", R.drawable.card_6c),
        7 to CardDataModel(4,"7", "C", R.drawable.card_7c),
        8 to CardDataModel(4,"8", "C", R.drawable.card_8c),
        9 to CardDataModel(4,"9", "C", R.drawable.card_9c),
        10 to CardDataModel(4,"10", "C", R.drawable.card_10c),
        11 to CardDataModel(4,"J", "C", R.drawable.card_jc),
        12 to CardDataModel(4,"Q", "C", R.drawable.card_qc),
        13 to CardDataModel(4,"K", "C", R.drawable.card_kc),
        14 to CardDataModel(4,"A", "D", R.drawable.card_ad),
        15 to CardDataModel(4,"2", "D", R.drawable.card_2d),
        16 to CardDataModel(4,"3", "D", R.drawable.card_3d),
        17 to CardDataModel(4,"4", "D", R.drawable.card_4d),
        18 to CardDataModel(4,"5", "D", R.drawable.card_5d),
        19 to CardDataModel(4,"6", "D", R.drawable.card_6d),
        20 to CardDataModel(4,"7", "D", R.drawable.card_7d),
        21 to CardDataModel(4,"8", "D", R.drawable.card_8d),
        22 to CardDataModel(4,"9", "D", R.drawable.card_ac),
        23 to CardDataModel(4,"10", "D", R.drawable.card_10d),
        24 to CardDataModel(4,"J", "D", R.drawable.card_jd),
        25 to CardDataModel(4,"Q", "D", R.drawable.card_qd),
        26 to CardDataModel(4,"K", "D", R.drawable.card_kd),
        27 to CardDataModel(4,"A", "H", R.drawable.card_ah),
        28 to CardDataModel(4,"2", "H", R.drawable.card_2h),
        29 to CardDataModel(4,"3", "H", R.drawable.card_3h),
        30 to CardDataModel(4,"4", "H", R.drawable.card_4h),
        31 to CardDataModel(4,"5", "H", R.drawable.card_5h),
        32 to CardDataModel(4,"6", "H", R.drawable.card_6h),
        33 to CardDataModel(4,"7", "H", R.drawable.card_7h),
        34 to CardDataModel(4,"8", "H", R.drawable.card_8h),
        35 to CardDataModel(4,"9", "H", R.drawable.card_9h),
        36 to CardDataModel(4,"10", "H", R.drawable.card_10h),
        37 to CardDataModel(4,"J", "H", R.drawable.card_jh),
        38 to CardDataModel(4,"Q", "H", R.drawable.card_qh),
        39 to CardDataModel(4,"K", "H", R.drawable.card_kh),
        40 to CardDataModel(4,"A", "S", R.drawable.card_as),
        41 to CardDataModel(4,"2", "S", R.drawable.card_2s),
        42 to CardDataModel(4,"3", "S", R.drawable.card_3s),
        43 to CardDataModel(4,"4", "S", R.drawable.card_4s),
        44 to CardDataModel(4,"5", "S", R.drawable.card_5s),
        45 to CardDataModel(4,"6", "S", R.drawable.card_6s),
        46 to CardDataModel(4,"7", "S", R.drawable.card_7s),
        47 to CardDataModel(4,"8", "S", R.drawable.card_8s),
        48 to CardDataModel(4,"9", "S", R.drawable.card_9s),
        49 to CardDataModel(4,"10", "S", R.drawable.card_10s),
        50 to CardDataModel(4,"J", "S", R.drawable.card_js),
        51 to CardDataModel(4,"Q", "S", R.drawable.card_qs),
        52 to CardDataModel(4,"K", "S", R.drawable.card_ks),
        53 to CardDataModel(4,"Small", "Blck", R.drawable.back_yellow),
        54 to CardDataModel(4,"Big", "Red", R.drawable.back_red),

    )

    // returns 3 lists of hands
    fun generateHand(): List<List<Int>> {
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

//        var hand1 = mapIntsToCards(intList1)
//        var hand2 = mapIntsToCards(intList2)
//        var hand3 = mapIntsToCards(intList3)

        return listOf(intList1, intList1, intList1)
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