package com.myapp.mirrorscore

import com.myapp.mirrorscore.table.Post
import com.myapp.mirrorscore.table.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

private val baseUrl: String = "https://mirrorscore-android.herokuapp.com/discussionWall/"

object Connection {
  val postInstance: PostInterface

  init {
    val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    postInstance = retrofit.create(PostInterface::class.java)
  }
}

interface PostInterface {
  @GET("post?userId=1")
  fun getAllPost(
    @Header("Authorization") authToken: String
  ): Call<Post>

  @POST("answerupvote?userId=1")
  fun updateUpvoteCount(@Body answerId:Int,@Header("Authorization") authToken: String):Call<Void>
}