package com.example.landlords

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.landlords.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    // View Binding
    private var _gameFragmentBinding: GameFragmentBinding? = null
    private val gameFragmentBinding get() = _gameFragmentBinding!!

    // ViewModel
    private val vm: GameFragmentViewModel by viewModels()

    var cardState: Int = 1

    private val animationListener = View.OnClickListener { view ->
        cardClickedEvent(view)

        view.animate().apply {
            view.id
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
        vm.getMainHand().observe(viewLifecycleOwner, { mainHandLiveData ->
            gameFragmentBinding.card1.setImageResource(vm.getCorrectImageResourceIdFromCardId(mainHandLiveData[0]))
            gameFragmentBinding.card2.setImageResource(vm.getCorrectImageResourceIdFromCardId(mainHandLiveData[1]))
            gameFragmentBinding.card3.setImageResource(vm.getCorrectImageResourceIdFromCardId(mainHandLiveData[2]))
            gameFragmentBinding.card4.setImageResource(vm.getCorrectImageResourceIdFromCardId(mainHandLiveData[3]))
            gameFragmentBinding.card5.setImageResource(vm.getCorrectImageResourceIdFromCardId(mainHandLiveData[4]))
        })
    }

    private fun setVisibilityObservers() {
        vm.getIsCardSelectedArr().observe(viewLifecycleOwner, { arr ->
            if (vm.isCardSelectedArr[0]) gameFragmentBinding.card1.visibility = View.VISIBLE
            if (vm.isCardSelectedArr[1]) gameFragmentBinding.card2.visibility = View.VISIBLE
            if (vm.isCardSelectedArr[2]) gameFragmentBinding.card3.visibility = View.VISIBLE
        })
    }

  fun cardClickedEvent(view: View) {
      val cardSelected = view as ImageView
      when (cardSelected.id){
          gameFragmentBinding.card1.id ->{
              val cardSelected = !vm.isCardSelectedArr[0]
              vm.isCardSelectedArr[0] = cardSelected
              // add or removed card from play
              if (cardSelected){
                  vm.cardsToBePlayed.add(77)
              }
              else {
                  vm.cardsToBePlayed.remove(77)
              }

          }
          gameFragmentBinding.card2.id ->{
              vm.isCardSelectedArr[1] = true
              vm.cardsToBePlayed.add(76)
          }
          gameFragmentBinding.card3.id ->{
              vm.isCardSelectedArr[2] = true
              vm.cardsToBePlayed.add(3)
          }
      }
      vm.setSelectedArr(vm.isCardSelectedArr)
      Log.d("current hand", vm.cardsToBePlayed.toString())
      Log.d("tag", "card clicked event")

  }

}