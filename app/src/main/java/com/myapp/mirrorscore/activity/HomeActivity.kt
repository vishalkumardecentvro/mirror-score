package com.myapp.mirrorscore.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.myapp.mirrorscore.Connection
import com.myapp.mirrorscore.R
import com.myapp.mirrorscore.table.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

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
    GlobalScope.launch(Dispatchers.Main) {
      val authToken : String = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjMwNTg4MDA1LCJqdGkiOiIyYWE4YzQzZmZkZWE0YjZhYjU1NWJiNDJlNGNiZjlmNiIsInVzZXJfaWQiOjF9.4bo5uMDzIfC4v4q_t8w9gdPD7lP8-sn77Y0_oPbGrh4"
      val response: Response<List<Post>> = withContext(Dispatchers.IO) { Connection().api.getAllPost(authToken) }
      if(response.isSuccessful){
        response.body()?.let {
          Log.i("--userName--",it.get(0).userName)
        }
      }
      else{
        Log.e("--statusCode--",response.code().toString())
        Log.e("error",response.errorBody().toString())
      }
    }

  }

}