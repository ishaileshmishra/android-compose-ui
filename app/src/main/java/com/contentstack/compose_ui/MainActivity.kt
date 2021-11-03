package com.contentstack.compose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.contentstack.compose_ui.ui.theme.AndroidecommerceappcomposeTheme



class MainActivity : ComponentActivity() {
    private val products = getAllProducts()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidecommerceappcomposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoadProducts(products)
                }
            }
        }
    }
}


@Composable
fun LoadProducts(products: List<Product>) {
    LazyColumn {
        items(products) { message ->
            CardRow(message)
        }
    }
}


@Composable
fun CardRow(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
        elevation = 10.dp
    ) {

        Row(modifier = Modifier.padding(end = 8.dp)) {
            ComposeImage(image = product.image)
            Column(
                modifier = Modifier.padding(all = 15.dp),
                verticalArrangement = Arrangement.Center
            ) {
                buildAnnotatedString {
                    TextTitle(title = product.title)
                }
                Spacer(modifier = Modifier.height(10.dp))
                TextSubTitle(subTitle = product.subTitle)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (product.isFavorite) IconIsFav(Color.Red, product.likedCount) else IconIsFav(
                        Color.Black,
                        product.likedCount
                    )
                    ButtonAddToCart()
                }
            }
        }
    }
}

@Composable
fun ComposeImage(image: String) {
    Image(
        painter = rememberImagePainter(image),
        contentDescription = null,
        modifier = Modifier
            .height(185.dp)
            .width(100.dp)
            .background(color = Color.White)
    )
}

@Composable
fun IconIsFav(color: Color, likedCount: Int) {
    Row {
        if (color==Color.Black) Icon(Icons.Rounded.FavoriteBorder, tint = color, contentDescription = "Localized description") else
        Icon(Icons.Rounded.Favorite, tint = color, contentDescription = "Localized description")
        Text(text = " ${likedCount}K")
    }
}

@Composable
fun TextTitle(title: String) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                append(title)
            }
        }, maxLines = 2
    )
}


@Composable
fun TextSubTitle(subTitle: String) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                append(subTitle)
            }
        }, maxLines = 4
    )
}

@Composable
fun ButtonAddToCart() {
    OutlinedButton(onClick = {
        println("clicked on view")
    }) {
        Text("View")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val allProducts = getAllProducts()
    AndroidecommerceappcomposeTheme {
        LoadProducts(allProducts)
    }
}