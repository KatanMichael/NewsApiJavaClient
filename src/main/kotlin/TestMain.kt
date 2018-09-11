import controller.NewsController
import interfaces.getArticlesListener
import interfaces.getSourcesListener
import model.Article
import model.Source

class TestMain

val API_KEY = "4a8e4d3993f5444ba803bd997b5bf780"


fun main(args: Array<String>)
{
    val myNewsController = NewsController(API_KEY)

    myNewsController.getNewsArticles("pokemon","ign","","",object :
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
            if(error != null)
            {
                println(error)
            }else
            {
                println("error is null")
            }
        }

    })


    myNewsController.getNewsSources("","","",
            object : getSourcesListener {
                override fun onReceived(sources: Array<Source>?)
                {
                    if(sources != null)
                    {
                        for(s in sources)
                        {
                            println(s)
                        }
                    }
                }

                override fun onError(error: String?)
                {
                    println(error)
                }

            })
}
