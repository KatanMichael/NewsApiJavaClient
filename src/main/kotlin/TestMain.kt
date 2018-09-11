import controller.NewsController
import interfaces.getArticlesListener
import model.Article

class TestMain

val API_KEY = "4a8e4d3993f5444ba803bd997b5bf780"


fun main(args: Array<String>)
{
    val myNewsController = NewsController(API_KEY)

    myNewsController.getNewsArticles("","","","",object :
            getArticlesListener {
        override fun onRecived(articles: Array<Article>?)
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
            if(error != null)
            {
                println(error)
            }else
            {
                println("error is null")
            }
        }

    })

}
