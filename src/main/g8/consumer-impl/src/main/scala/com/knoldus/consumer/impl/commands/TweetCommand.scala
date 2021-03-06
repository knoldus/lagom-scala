package com.knoldus.consumer.impl.commands

import akka.Done
import com.knoldus.producer.api.models.Tweet
import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.Json

/**
  * Created by Harmeet Singh(Taara) on 19/2/17.
  */
sealed trait TweetCommand[T] extends ReplyType[T]

case class SaveNewTweet(tweet: Tweet) extends TweetCommand[Done]

object SaveNewTweet {
  implicit val formatter = Json.format[SaveNewTweet]
}
