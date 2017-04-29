package com.damelines.notes

import com.damelines.notes.handler.ListNotesHandler
import com.damelines.notes.module.NotesModule
import com.google.inject.Guice
import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router

class NotesVerticle extends AbstractVerticle {

  @Override
  void start() throws Exception {
    println 'Starting com.damelines.notes.NotesVerticle'

    def injector = Guice.createInjector(new NotesModule(vertx: vertx, config: config()))

    def server = vertx.createHttpServer()
    def router = Router.router(vertx)

    router.route().handler(injector.getInstance(ListNotesHandler))

    server.requestHandler(router.&accept).listen(8080)
  }

  @Override
  void stop() throws Exception {
    println 'Stopping com.damelines.notes.NotesVerticle'
  }
}
