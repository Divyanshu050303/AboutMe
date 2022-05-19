package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContentInfo
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.DoneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {
        binding.apply {
            NickNameText.text=binding.NickNameText.text
            invalidateAll()
            EditText.visibility=View.GONE
            DoneButton.visibility=View.GONE
            NickNameText.visibility=View.VISIBLE
        }
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}