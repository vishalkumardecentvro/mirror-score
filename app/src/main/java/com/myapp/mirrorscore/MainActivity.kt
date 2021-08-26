package com.myapp.mirrorscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val handler = Handler()
    handler.postDelayed({
      startActivity(Intent(this,HomeActivity::class.java))
    },3000)
  }
}