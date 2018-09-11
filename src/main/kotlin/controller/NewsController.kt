package controller

import interfaces.getArticlesListener
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import NewsRequestClient
import interfaces.getSourcesListener
import model.ArticalsRequets
import model.SourceRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsController(private var API_KEY: String)
{

    private val retrofitNews = Retrofit.Builder().baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    private val newsClient = retrofitNews.create(NewsRequestClient::class.java)


    fun getNewsArticles(keyWord: String = " ", sources: String = " "
                       , domain: String = " ", language: String = " "
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

                            articlesListener.onReceived(articles)
                        }else
                        {
                            articlesListener.onError("OnResponse - ${response?.message()}")
                        }

                    }

                })

    }

    fun getNewsSources(category: String, language: String, country: String,
                       sourcesListener: getSourcesListener)
    {
        newsClient.getNewSourceRequest(API_KEY,country,category,language)
                .enqueue(object : Callback<SourceRequest>
                {
                    override fun onResponse(call: Call<SourceRequest>, response: Response<SourceRequest>)
                    {
                        val body = response.body();

                        if(body != null)
                        {
                            sourcesListener.onReceived(body.sources)
                        }else
                        {
                            sourcesListener.onError("${response.message()} ${response.errorBody()}")
                        }

                    }

                    override fun onFailure(call: Call<SourceRequest>, t: Throwable)
                    {
                        sourcesListener.onError(t.message)
                    }

                })

    }

}