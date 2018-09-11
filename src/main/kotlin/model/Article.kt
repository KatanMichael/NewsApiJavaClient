package model

data class Article(val source: Source, val author: String,
                   val title: String, val url: String, val urlToImage: String)
