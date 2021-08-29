package com.myapp.mirrorscore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myapp.mirrorscore.databinding.RvPostBinding
import com.myapp.mirrorscore.table.Data

class PostsAdapter(post: List<Data>, private val listener: OnClickUpvote) :
  RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
  lateinit var postList: List<Data>

  init {
    if (post != null) {
      this.postList = post
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = RvPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.populate(position, postList)
  }

  override fun getItemCount(): Int {
    return postList.size
  }

  inner class ViewHolder(val binding: RvPostBinding) : RecyclerView.ViewHolder(binding.root) {
    fun populate(position: Int, postList: List<Data>) {
      binding.tvName.setText(postList.get(position).userName)
      binding.tvClass.setText(postList.get(position).studentClass + " class")
      binding.tvQuestions.setText(postList.get(position).text)
      binding.tvUpvotes.setText("Upvotes (${postList.get(position).upvoteCount})")
      binding.tvReply.setText("Reply (${postList.get(position).answerCount})")
      binding.tvReport.setText("Report (${postList.get(position).reportCount})")

      binding.tvUpvotes.setOnClickListener() {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION)
          listener.upvote(adapterPosition)
      }
    }

  }

  interface OnClickUpvote {
    fun upvote(position: Int)
  }
}