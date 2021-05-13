package com.example.landlords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameFragmentViewModel : ViewModel() {

    private val mainHandLiveData = MutableLiveData<Array<Int>>()
    private val mainHand = Array<Int>(10) { i -> i}

    fun getHand() : LiveData<Array<Int>> {
        return mainHandLiveData
    }

    fun setHand(hand: Array<Int>) {
        mainHandLiveData.value = hand
    }

    fun generateHand() : Array<Int> {
        return arrayOf(1,2,3,4,5)
    }


    private val isCardSelectedArrLiveData = MutableLiveData<Array<Boolean>>()
    var isCardSelectedArr = Array<Boolean>(17) { i -> false }

    fun getIsCardSelectedArr() : LiveData<Array<Boolean>> {
        return isCardSelectedArrLiveData
    }

    fun setSelectedArr(arr: Array<Boolean>) {
        isCardSelectedArrLiveData.value = arr
    }



    // Create the model which contains data for our UI
    private val cardModel1 = CardDataModel(5, "69", "diamonds")

    // Create MutableLiveData which Fragment can subscribe to
    // When this data changes, it triggers the UI to do an update
    val cardTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainFragment
    fun getUpdatedText() {
        val updatedText = cardModel1.rank
        cardTextLiveData.postValue(updatedText)
    }


    fun getCorrectImageResourceIdFromCardId(cardId: Int) : Int {
        return when (cardId) {
            1 -> R.drawable.card_2c
            2 -> R.drawable.card_13d
            else -> R.drawable.card_3c
        }
    }

}