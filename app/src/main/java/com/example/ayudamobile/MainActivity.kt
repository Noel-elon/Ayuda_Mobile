package com.example.ayudamobile

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.ui.tooling.preview.Preview
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.ayudamobile.composables.SignUpPage
import com.example.ayudamobile.composables.form
import com.example.ayudamobile.composables.mainScreen
import com.example.ayudamobile.ui.AyudaMobileTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = ViewModelProvider(this).get(AuthViewModel::class.java)
        vm.getCurrentUser("tok")

//        val request: OneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build()
//        WorkManager.getInstance(this).enqueue(request)
//        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this) {
//            Log.d("ManagerState: ", it.state.name)
//        }
        setContent {
            AyudaMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    mainScreen()
                    // form(vm = vm)
                }
            }
        }
    }
}

