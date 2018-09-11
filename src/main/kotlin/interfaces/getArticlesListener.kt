package interfaces

import model.Article

interface getArticlesListener
{
    fun onReceived(articles : Array<Article>?)
    fun onError(Error: String?)

}