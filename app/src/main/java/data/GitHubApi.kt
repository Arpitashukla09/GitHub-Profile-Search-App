package data
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {
    @GET("users/{username}/repos")
    suspend fun getRepos(@Path("username") username: String): Response<List<GHRepo>>

    @GET("/search/repositories")
    suspend fun getUserRepository(
        @Query("q") language: String = "language:swift",
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc"
    ): Response<List<GHRepo>>
}

object NetworkService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: GitHubApi = retrofit.create(GitHubApi::class.java)
}
