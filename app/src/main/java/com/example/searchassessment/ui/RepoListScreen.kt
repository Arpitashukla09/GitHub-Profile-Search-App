package com.example.searchassessment.ui
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import data.GHRepo

@Composable
fun RepoListScreen(repos: List<GHRepo>) {
    // State for WebView URL
    var selectedRepoURL = remember { mutableStateOf<String?>(null) }.value
    if (selectedRepoURL == null) {
        // Show the list of repositories
        LazyColumn {
            items(repos) { repo ->
                RepoItem(repo) { clickedRepoURL ->
                    selectedRepoURL = clickedRepoURL
                }
            }
        }
    } else {
        // Show WebView for the selected repository
        WebViewScreen(repoURL = selectedRepoURL) {
            selectedRepoURL = null // Go back to the list when back is pressed
        }
    }
}

@Composable
fun WebViewScreen(repoURL: String?, onBackPressed: () -> Unit) {
    val context = LocalContext.current

    // Handle back button press
    BackHandler(enabled = true) {
        onBackPressed() // Go back to the list of repositories
    }

    AndroidView(factory = {
        WebView(context).apply {
            settings.javaScriptEnabled = true
            loadUrl(repoURL ?: "")
        }
    })
}
