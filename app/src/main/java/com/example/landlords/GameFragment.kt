package com.example.landlords

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.landlords.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    // View Binding
    private var _gameFragmentBinding: GameFragmentBinding? = null
    private val gameFragmentBinding get() = _gameFragmentBinding!!

    // ViewModel
    private val vm: GameFragmentViewModel by viewModels()

    var cardState: Int = 1

    private val animationListener = View.OnClickListener { view ->
        view.animate().apply {
            if (cardState == 1) {
                duration = 100
                translationY(-100F)
                cardState = 0
            } else {
                duration = 100
                translationY(0F)
                cardState = 1
            }
        }
    }

    private val gameListener = View.OnClickListener { view ->
        view.tag
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    // populate the views now that the layout has been inflated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _gameFragmentBinding = GameFragmentBinding.bind(view)

//        binding.card1.setOnClickListener(animationListener)
//        binding.card2.setOnClickListener(animationListener)


//        val tv_dynamic = TextView(activity)
//        tv_dynamic.textSize = 20f
//        tv_dynamic.text = "This is a dynamic TextView generated programmatically in Kotlin"
//        binding.mainHand.addView(tv_dynamic)

        setupClickListeners()
        addImageUpdateObserverToCards()
        vm.setHand(vm.generateHand())

        //
        vm.setSelectedArr(vm.isCardSelectedArr)
        setVisibilityObservers()


        val deck = CardDeck()
        val hands = deck.generateHand()
    }

    private fun setupClickListeners() {
        gameFragmentBinding.card1.setOnClickListener(animationListener)
        gameFragmentBinding.card2.setOnClickListener(animationListener)
        gameFragmentBinding.card3.setOnClickListener(animationListener)
    }

    // Observer is waiting for viewModel to update our UI
    private fun fragmentImageUpdateObserver() {
        vm.cardTextLiveData.observe(viewLifecycleOwner, Observer { updatedText ->
            gameFragmentBinding.card1.setImageResource(vm.getCorrectImageResourceIdFromCardId(1))
        })
    }

    private fun addImageUpdateObserverToCards() {
        vm.getHand().observe(viewLifecycleOwner, { myArray ->
            gameFragmentBinding.card1.setImageResource(vm.getCorrectImageResourceIdFromCardId(myArray[1]))
            gameFragmentBinding.card5.setImageResource(vm.getCorrectImageResourceIdFromCardId(myArray[4]))
        })
    }

    private fun setVisibilityObservers() {
        vm.getIsCardSelectedArr().observe(viewLifecycleOwner, { arr ->
            gameFragmentBinding.card1.visibility = View.INVISIBLE
        })
    }



}