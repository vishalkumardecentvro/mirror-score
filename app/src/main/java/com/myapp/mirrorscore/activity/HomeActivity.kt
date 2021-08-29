package com.myapp.mirrorscore.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.myapp.mirrorscore.Connection
import com.myapp.mirrorscore.R
import com.myapp.mirrorscore.adapter.PostsAdapter
import com.myapp.mirrorscore.table.Post
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(),PostsAdapter.OnClickUpvote {

  val key =
    "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjMwNTg4MDA1LCJqdGkiOiIyYWE4YzQzZmZkZWE0YjZhYjU1NWJiNDJlNGNiZjlmNiIsInVzZXJfaWQiOjF9.4bo5uMDzIfC4v4q_t8w9gdPD7lP8-sn77Y0_oPbGrh4"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    instantiate()
    initialize()
    listen()
    load()
  }

  fun instantiate() {


  }

  fun initialize() {

  }

  fun listen() {

  }

  fun load() {
    val post = Connection.postInstance.getAllPost(key)
    post.enqueue(object : Callback<Post> {
      override fun onResponse(call: Call<Post>, response: Response<Post>) {
        val post = response.body()
        if (post != null) {
          Log.d("name", post.Result.data.get(0).userName)
          rvPost.adapter = PostsAdapter(post.Result.data,this@HomeActivity)
        }
      }

      override fun onFailure(call: Call<Post>, t: Throwable) {
        Log.e("error", t.toString())
      }

    })
  }

  override fun upvote(position: Int) {
    val upvote = Connection.postInstance.updateUpvoteCount(1,key)
    upvote.enqueue(object : Callback<Void> {
      override fun onResponse(call: Call<Void>, response: Response<Void>) {
        load()
        Toast.makeText(this@HomeActivity,"Api hit",Toast.LENGTH_SHORT).show()
      }

      override fun onFailure(call: Call<Void>, t: Throwable) {
        Log.i("-error--",t.toString())
      }

    })
  }

}