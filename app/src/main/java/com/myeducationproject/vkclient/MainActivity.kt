package com.myeducationproject.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.myeducationproject.vkclient.ui.theme.NewsMainScreen
import com.myeducationproject.vkclient.ui.theme.VkClientTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            VkClientTheme {

                NewsMainScreen(viewModel)

            }
        }
    }
}