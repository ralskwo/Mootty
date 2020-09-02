package com.humo.mootty.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.humo.mootty.R

class MainFragment : Fragment() {

//    private val viewModel: MainViewModel by viewModels(
//        factoryProducer = {SavedStateViewModelFactory(this)}
//    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.text.observe(viewLifecycleOwner){
//            //Update UI
//        }
//    }

}