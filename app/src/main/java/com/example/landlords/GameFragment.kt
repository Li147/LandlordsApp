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

    private lateinit var linearLayoutManagerMain: LinearLayoutManager
    private lateinit var linearLayoutManagerLeft: LinearLayoutManager
    private lateinit var linearLayoutManagerRight: LinearLayoutManager

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

        val model: GameFragmentViewModel by viewModels()

        val binding = GameFragmentBinding.bind(view)
        gameFragmentBinding = binding




        val recyclerViewMain = binding.rvPlayerHandMain
        val recyclerViewLeft= binding.rvPlayerHandLeft
        val recyclerViewRight = binding.rvPlayerHandRight

        linearLayoutManagerMain = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        linearLayoutManagerLeft = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        linearLayoutManagerRight = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        recyclerViewMain.layoutManager = linearLayoutManagerMain
        recyclerViewLeft.layoutManager = linearLayoutManagerLeft
        recyclerViewRight.layoutManager = linearLayoutManagerRight

        val deck = CardDeck()
        val hands = deck.generateHand()

        recyclerViewMain.adapter = RecyclerAdapter(hands[0])
        recyclerViewLeft.adapter = RecyclerAdapter(hands[1])
        recyclerViewRight.adapter = RecyclerAdapter(hands[2])
    }
}