package com.knoldus.consumer.api

import akka.NotUsed
import com.knoldus.producer.api.models.Tweet
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

/**
  * Created by Harmeet Singh(Taara) on 20/2/17.
  */
trait TwitterConsumerService extends Service {

  override def descriptor: Descriptor = {
    import Service._

    named("tweets").withCalls(
      restCall(Method.GET, "/api/latest-tweets?limit", findLatestTweets _)
    ).withAutoAcl(true)
  }

  def findLatestTweets(limit: Int): ServiceCall[NotUsed, Seq[Tweet]]
}
