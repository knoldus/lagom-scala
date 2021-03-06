package com.knoldus.producer.api

import akka.{Done, NotUsed}
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

/**
  * Created by Harmeet Singh(Taara) on 16/2/17.
  */
trait TwitterSchedulerService extends Service {

  def scheduler: ServiceCall[NotUsed, Done]

  override def descriptor: Descriptor = {
    import Service._
    named("scheduler").
      withCalls(call(scheduler _))
      .withAutoAcl(true)
  }
}
