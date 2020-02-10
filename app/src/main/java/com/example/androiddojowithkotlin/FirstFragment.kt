package com.example.androiddojowithkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    fun add(view: View, price: Int){
        var count: Int = 0

        Log.i("UIText", view.amountValueTextView.text.toString())
        Log.i("ResourceText", getString(R.string.amountValueText))


        if(view.amountValueTextView.text.toString() == getString(R.string.amountValueText))
            count = price
        else
            count = Integer.parseInt(view.amountValueTextView.text.toString())
        count += price
        view.amountValueTextView.text = count.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.ooLongTeaButton.setOnClickListener{
            var amount : Int = 0
            if(view.amountValueTextView.text.toString() == getString(R.string.amountValueText)) {
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(0)
                findNavController().navigate(action)
            }
            else{
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(view.amountValueTextView.text.toString().toInt())
                findNavController().navigate(action)
            }
        }

        view.blackTeaButton.setOnClickListener{
            Toast.makeText(context, "你點擊了紅茶按鈕", Toast.LENGTH_SHORT).show()
        }

        view.greenTeaButton.setOnClickListener{
            this.add(view, 20)
        }

        view.milkTeaButton.setOnClickListener {
            this.add(view, 70)
        }
    }
}
