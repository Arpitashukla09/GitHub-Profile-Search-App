package com.example.searchassessment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.searchassessment.ui.RepoListScreen
import com.example.searchassessment.ui.theme.SearchAssessmentTheme
import com.example.searchassessment.ui.viewModel.MainViewModel
import data.GHRepo
import data.Results

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SearchAssessmentTheme {
                var repos = remember { mutableStateOf<List<GHRepo>>(emptyList()) }
                mainViewModel.fetchRepos("Arpita")
                mainViewModel.repos.observe(this ){
                    Log.d("Arpita", "onCreate: $it ")
                    if(it is Results.Success)
                    {
                        repos.value=it.data
                    }
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) { RepoListScreen(repos = repos.value) }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SearchAssessmentTheme {
        Greeting("Android")
    }
}