package com.dicoding.submissionjetelectronics.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.submissionjetelectronics.R
import com.dicoding.submissionjetelectronics.ui.theme.SubmissionJetElectronicsTheme

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        HeaderProfile()
    }
}

@Composable
fun HeaderProfile(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .height(360.dp)
                .padding(16.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.fotoku),
            contentScale = ContentScale.FillWidth,
            contentDescription = "My Picture"
        )
        Spacer(modifier = modifier.height(8.dp))
        ProfileItem(title = "Name", field = "Zakiansyah")
        ProfileItem(title = "Email", field = "Zakiansyah0112@gmail.com")
        ProfileItem(title = "Learning Path", field = "Mobile Development - 16")
    }
}

@Composable
@Preview(showBackground = true)
fun AboutScreenPreview() {
    SubmissionJetElectronicsTheme {
        HeaderProfile()
    }
}