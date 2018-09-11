package interfaces

import model.Article

interface getArticlesListener
{
    fun onRecived(articles : Array<Article>?)
    fun onError(Error: String?)

}