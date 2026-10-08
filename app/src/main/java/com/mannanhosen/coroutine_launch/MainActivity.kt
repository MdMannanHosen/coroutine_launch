package com.mannanhosen.coroutine_launch

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.mannanhosen.coroutine_launch.ui.theme.Coroutine_launchTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Coroutine_launchTheme {
                CoroutineScope(Dispatchers.IO).launch{
                  printFollowers()
                }
            }
        }
    }

    // for Launch

//    private suspend fun printFollowers(){
//        var fbFollowers = 0;
//        val job = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getfbFollowers()
//        }
//        job.join()
//        Log.d("Mannan", fbFollowers.toString())
//    }


    // for Async

    private suspend fun printFollowers(){
        val fb = CoroutineScope(Dispatchers.IO).async {
            getfbFollowers()
        }
        val insta = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }

        Log.d("Mannan", "Fb Follower ${fb.await()}, Insta Follower ${insta.await()}")
    }

    private suspend fun getfbFollowers(): Int{
        delay(5000)
        return 100;
    }

    private suspend fun getInstaFollowers(): Int{
        delay(5000)
        return 100;
    }



}

