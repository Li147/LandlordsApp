package com.example.landlords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameFragmentViewModel : ViewModel() {

    private val cardDeck : CardDeck = CardDeck()

    private val mainHandLiveData = MutableLiveData<Array<Int>>()
    private val mainHand = Array<Int>(10) { i -> i}

    fun getMainHand() : LiveData<Array<Int>> {
        return mainHandLiveData
    }

    fun setHand(hand: Array<Int>) {
        mainHandLiveData.value = hand
    }

    fun generateHand() : Array<Int> {
        val mainHand = cardDeck.generateHand()[0]
        return mainHand.toTypedArray()
    }


    private val isCardSelectedArrLiveData = MutableLiveData<Array<Boolean>>()
    var isCardSelectedArr = Array<Boolean>(17) { i -> false }

    fun getIsCardSelectedArr() : LiveData<Array<Boolean>> {
        return isCardSelectedArrLiveData
    }

    fun setSelectedArr(arr: Array<Boolean>) {
        isCardSelectedArrLiveData.value = arr
    }

    var cardsToBePlayed = mutableListOf<Int>()


    // Create MutableLiveData which Fragment can subscribe to
    // When this data changes, it triggers the UI to do an update
    val cardTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
//        val updatedText = cardModel1.rank
//        cardTextLiveData.postValue(updatedText)
    }


    fun getCorrectImageResourceIdFromCardId(cardId: Int) : Int {
        return cardDeck.deckOfCardsMap[cardId]?.imgResId ?: R.drawable.back_gray
    }

}