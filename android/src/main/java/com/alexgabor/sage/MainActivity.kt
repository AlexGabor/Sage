package com.alexgabor.sage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alexgabor.common.usecase.GetRecipes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getRecipes = GetRecipes()
        getRecipes.recipes.value.let {
            Toast.makeText(this, "$it", Toast.LENGTH_LONG).show()
        }
    }
}