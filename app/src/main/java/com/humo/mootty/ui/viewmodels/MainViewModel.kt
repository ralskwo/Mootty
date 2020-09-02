package com.humo.mootty.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.humo.mootty.data.models.CardItem

class MainViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    // TODO: Implement the ViewModel
    var cardList: List<CardItem> =
        savedStateHandle["card_list"] ?: throw IllegalArgumentException("Missing user cards")
//    var text: LiveData<MainText> = TODO()

}
