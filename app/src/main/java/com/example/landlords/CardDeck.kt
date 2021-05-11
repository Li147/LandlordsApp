package com.example.landlords

class CardDeck {

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