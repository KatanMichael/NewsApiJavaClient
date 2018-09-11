package controller

import interfaces.getArticlesListener
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import NewsRequestClient
import model.ArticalsRequets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsController(private var API_KEY: String)
{

    private val retrofitNews = Retrofit.Builder().baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    private val newsClient = retrofitNews.create(NewsRequestClient::class.java)


    fun getNewsArticles(keyWord: String = "", sources: String = ""
                       , domain: String = "", language: String = ""
                       ,articlesListener: getArticlesListener )
    {
        newsClient.getArticlesRequest(API_KEY,keyWord,sources,domain,language)
                .enqueue(object :
                        Callback<ArticalsRequets>
                {
                    override fun onFailure(call: Call<ArticalsRequets>?, t: Throwable?)
                    {
                        if(t != null)
                        {
                            articlesListener.onError("onFailure - ${t.message}")
                        }

                    }

                    override fun onResponse(call: Call<ArticalsRequets>?, response: Response<ArticalsRequets>?)
                    {
                        val body = response?.body()

                        if(body != null)
                        {
                            val articles = body?.articles

                            articlesListener.onRecived(articles)
                        }else
                        {
                            articlesListener.onError("OnResponse - ${response?.message()}}")
                        }

                    }

                })

    }


}