package com.example.ayudamobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.ui.tooling.preview.Preview
import com.example.ayudamobile.composables.SignUpPage
import com.example.ayudamobile.composables.form
import com.example.ayudamobile.ui.AyudaMobileTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = ViewModelProvider(this).get(AuthViewModel::class.java)
        setContent {
            AyudaMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    form(vm = vm)
                }
            }
        }
    }
}

