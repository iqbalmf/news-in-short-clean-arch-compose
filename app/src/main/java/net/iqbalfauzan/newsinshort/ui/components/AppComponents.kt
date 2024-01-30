package net.iqbalfauzan.newsinshort.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import net.iqbalfauzan.newsinshort.R
import net.iqbalfauzan.newsinshort.data.entity.Articles
import net.iqbalfauzan.newsinshort.data.entity.NewsResponse
import net.iqbalfauzan.newsinshort.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NewsList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) {
            NormalTextComponent(textValue = it.title ?: "-")
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = Purple40
        )
    )
}

@Composable
fun NewsRowComponent(page: Int, article: Articles) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage, contentDescription = "",
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.icon_logo),
            error = painterResource(id = R.drawable.icon_logo)
        )

        Spacer(modifier = Modifier.size(20.dp))
        HeadingTextComponent(textValue = article.title ?: "-")
        Spacer(modifier = Modifier.size(10.dp))
        NormalTextComponent(textValue = article.description ?: "-")
        Spacer(modifier = Modifier.weight(1f))
        AuthorDetailsComponent(
            textValue = article.author ?: "",
            sourceName = article.source?.name ?: ""
        )
    }
}

@Composable
fun HeadingTextComponent(textValue: String, centerAligned: Boolean = false) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium),
        textAlign = if (centerAligned) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun AuthorDetailsComponent(textValue: String?, sourceName: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
    ) {
        textValue?.also {
            Text(text = it)
        }
        Spacer(modifier = Modifier.weight(1f))
        sourceName?.also {
            Text(text = it)
        }
    }
}

@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_no_data),
            contentDescription = "No News as of Now\nPlease check in some time!"
        )

        HeadingTextComponent(textValue = "No News as of Now\nPlease check in some time!",
            centerAligned = true)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsRowComponentPreview() {
    val article = Articles(
        author = "Mr x",
        title = "Dummy Title Article",
        description = null,
        url = null,
        urlToImage = null,
        publishedAt = null,
        content = null,
        source = null
    )
    NewsRowComponent(page = 0, article = article)
}

@Preview
@Composable
fun EmptyStateComponentPreview() {
    EmptyStateComponent()
}