package com.damelines.notes

import com.damelines.notes.handler.NotesHandlers
import com.damelines.notes.module.NotesModule
import com.google.inject.Guice
import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler

class NotesVerticle extends AbstractVerticle {

  static final String BASE_URI = '/api'

  @Override
  void start() throws Exception {
    println "Starting ${this.class.name}"

    def injector = setupGuiceInjector()

    def server = vertx.createHttpServer()
    def router = Router.router(vertx)

    def notesHandlers = injector.getInstance(NotesHandlers)

    // Weird thing that handles the request body and sets it in the routing context
    router.route(BASE_URI + '/note*').handler(BodyHandler.create())

    // Handle standard REST operations
    router.get(BASE_URI + '/notes').handler(notesHandlers.&getNoteList)
    router.get(BASE_URI + '/note/:noteId').handler(notesHandlers.&getNote)
    router.post(BASE_URI + '/note').handler(notesHandlers.&createNote)
    router.put(BASE_URI + '/note').handler(notesHandlers.&updateNote)
    router.delete(BASE_URI + '/note/:noteId').handler(notesHandlers.&deleteNote)

    server.requestHandler(router.&accept).listen(8080)
  }

  def setupGuiceInjector() {
    Guice.createInjector(new NotesModule(vertx: vertx, config: config()))
  }

}
