package com.local.moviedb.ui.theme.atomicCompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieItemDetails(
    movie: Movie,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxWidth()) {
        val titleTextStyle = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            letterSpacing = 0.15.sp,
        )
        val subtitleTextStyle = MaterialTheme.typography.caption
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = movie.title ?: "",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = titleTextStyle
        )

        Spacer(modifier = Modifier.width(16.dp))

        if (movie.overview != null) {
            Text(
                text = movie.overview,
                style = subtitleTextStyle,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
            )
        }
    }
}