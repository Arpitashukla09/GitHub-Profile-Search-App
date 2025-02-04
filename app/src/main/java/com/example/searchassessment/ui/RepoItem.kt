package com.example.searchassessment.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.GHRepo

@Composable
fun RepoItem(repo: GHRepo, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(repo.repoURL) }, // Handle click
        shape = RoundedCornerShape(8.dp),  // Rounded corners for better look

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = repo.name, style = MaterialTheme.typography.bodyMedium)
                Text(text = "ID: ${repo.id}", style = MaterialTheme.typography.bodySmall)
            }
            Text(text = repo.repoURL, style = MaterialTheme.typography.bodySmall)
        }
    }
}
