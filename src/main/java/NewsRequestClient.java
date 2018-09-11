import model.ArticalsRequets;
import model.SourceRequest;
import retrofit2.Call;
import retrofit2.http.*;

public interface NewsRequestClient
{

        @GET("v2/sources/")
        Call<SourceRequest> getNewSourceRequest(@Query("apiKey") String apiKey, @Query ("country") String country,
                                         @Query ("category") String category, @Query ("language") String language);

        @GET("/v2/everything")
        Call<ArticalsRequets> getArticlesRequest(@Query ("apiKey") String apiKey, @Query ("q") String keyWord, @Query ("sources") String sources,
                                                 @Query ("domains") String domains,
                                                 @Query ("language") String language);


}
