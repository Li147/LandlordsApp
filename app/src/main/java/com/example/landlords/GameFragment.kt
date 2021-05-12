package com.example.landlords

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.landlords.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    private var gameFragmentBinding: GameFragmentBinding? = null
    private val vm: GameFragmentViewModel by viewModels()

    private lateinit var linearLayoutManagerMain: LinearLayoutManager
    private lateinit var linearLayoutManagerLeft: LinearLayoutManager
    private lateinit var linearLayoutManagerRight: LinearLayoutManager

    var cardState: Int = 1

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

        val binding = GameFragmentBinding.bind(view)
        gameFragmentBinding = binding

        binding.testCard.setOnClickListener { view ->
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


        val deck = CardDeck()
        val hands = deck.generateHand()

    }
}