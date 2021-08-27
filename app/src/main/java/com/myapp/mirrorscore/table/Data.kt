package com.myapp.mirrorscore.table

data class Data(
  val answerCount: Int,
  val createdOn: String,
  val image: String,
  val postId: Int,
  val report: Report,
  val reportCount: Int,
  val reported: Boolean,
  val studentBoard: String,
  val studentClass: String,
  val subject: String,
  val text: String,
  val updatedOn: String,
  val upvoteCount: Int,
  val upvoted: Boolean,
  val userId: Int,
  val userName: String
)