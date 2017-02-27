package com.knoldus.producer.impl.events

import com.knoldus.producer.api.models.Tweet
import com.lightbend.lagom.scaladsl.persistence.{AggregateEvent, AggregateEventTag, AggregateEventTagger}
import play.api.libs.json.Json

/**
  * Created by Harmeet Singh(Taara) on 16/2/17.
  */

object TweetEventTag {
  val INSTANCE = AggregateEventTag[TweetEvent]
}

sealed trait TweetEvent extends AggregateEvent[TweetEvent] {
  override def aggregateTag: AggregateEventTagger[TweetEvent] = TweetEventTag.INSTANCE
}

case class TweetSaved(tweet: Tweet) extends TweetEvent
object TweetSaved {
  implicit val fomatter = Json.format[TweetSaved]
}
