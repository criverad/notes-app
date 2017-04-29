package com.damelines.notes.handler

import io.vertx.core.Handler
import io.vertx.ext.web.RoutingContext

class ListNotesHandler implements Handler<RoutingContext> {

  @Override
  void handle(RoutingContext routingContext) {
    def response = routingContext.response()
    response.putHeader('Content-Type', 'text/plain')
    response.end('Vertx Web transmitting!')
  }

}
