package com.dicoding.submissionjetelectronics.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.submissionjetelectronics.ui.theme.SubmissionJetElectronicsTheme

@Composable
fun ProfileItem(
    title: String,
    field: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(modifier.padding(
            start = 16.dp,
            top = 8.dp,
            end = 8.dp,
            bottom = 8.dp
        )) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = modifier.height(8.dp))

            Text(
                modifier = modifier.padding(bottom = 2.dp),
                text = field,
                style = MaterialTheme.typography.bodyLarge
            )
            Divider(color = MaterialTheme.colorScheme.onPrimary, thickness = 2.dp)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileItemReview() {
    SubmissionJetElectronicsTheme {
        ProfileItem(title = "Email", field = "Zakiansyah0112@gmail.com")
    }
}