package controller

import interfaces.getArticlesListener
import model.Article
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class NewsControllerTest
{
    val API_KEY = "4a8e4d3993f5444ba803bd997b5bf780"

    @Before
    fun setUp()
    {
    }

    @Test
    fun getNewsSources()
    {
        val myNewsController =  NewsController(API_KEY)

        myNewsController.getNewsArticles("android","","","",object :
                getArticlesListener {
            override fun onReceived(articles: Array<Article>?)
            {
                if(articles != null)
                {
                    println("got ${articles.size} files")
                    for (article in articles)
                    {
                        println(article)
                    }
                }
            }

            override fun onError(error: String?)
            {
                println(error)
            }

        })

    }

    @Test
    fun getAPI_KEY()
    {


    }

    @Test
    fun setAPI_KEY()
    {

    }


}