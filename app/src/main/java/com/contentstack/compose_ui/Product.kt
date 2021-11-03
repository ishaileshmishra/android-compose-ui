package com.contentstack.compose_ui

data class Product(val title: String, val subTitle: String, val image: String, val likedCount: Int, val isFavorite: Boolean)


const val subtitle: String =
    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"

fun getAllProducts(): List<Product> {
    return listOf(
        Product(
            "What is Lorem Ipsum?",
            subTitle = subtitle,
            "https://images.pexels.com/photos/10013078/pexels-photo-10013078.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            13,
            true
        ),
        Product(
            "Why do we use it?",
            subTitle = subtitle,
            "https://images.pexels.com/photos/9713309/pexels-photo-9713309.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            12,
            false
        ),
        Product(
            "Where does it come from?",
            subTitle = subtitle,
            "https://images.pexels.com/photos/9988436/pexels-photo-9988436.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            7,
            true
        ),
        Product(
            "Where can I get some?",
            subTitle = subtitle,
            "https://images.pexels.com/photos/9725706/pexels-photo-9725706.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            90,
            false
        ),
        Product(
            title = "This is for the demo",
            subTitle = subtitle,
            image = "https://images.pexels.com/photos/9828236/pexels-photo-9828236.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            23,
            isFavorite = true,
        ),
        Product(
            title = "Light road scape sunset",
            subTitle = subtitle,
            image = "https://images.pexels.com/photos/9713309/pexels-photo-9713309.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            17,
            isFavorite = false,
        ),
        Product(
            title = "The view where sun rises",
            subTitle = subtitle,
            image = "https://images.pexels.com/photos/9703493/pexels-photo-9703493.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
            2,
            isFavorite = false,
        )
    );
}
