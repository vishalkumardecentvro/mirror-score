package com.myapp.mirrorscore

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.myapp.mirrorscore.table.Post
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

class Connection {
  private val baseUrl : String = "https://mirrorscore-android.herokuapp.com/discussionWall/"
  private val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
  private val retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build()
  val api = retrofit.create(getPostInterface::class.java)
}

interface getPostInterface {
  @GET("post?userId=1")
  suspend fun getAllPost(@Header("Authorization")authToken : String):Response<List<Post>>
}