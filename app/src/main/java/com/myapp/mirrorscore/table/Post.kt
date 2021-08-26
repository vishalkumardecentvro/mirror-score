package com.myapp.mirrorscore.table

data class Post (
  var userName: String = "",
  var text : String = "",
  var image : String = "",
  var createdOn : String = "",
  var updatedOn: String = "",
  var studentClass : String = "",
  var studentBoard : String = "",
  var subject :String = "",
  var answerCount: Int = 0,
  var upvoteCount : Int = 0
){}